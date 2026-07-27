package com.corrodinggames.rts.java;

import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.MusicManager;
import com.corrodinggames.rts.gameFramework.av;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GMissionEngine;
import com.corrodinggames.rts.gameFramework.sound.f;
import com.corrodinggames.rts.gameFramework.j.NetworkCallbacks;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.PasswordHandler;
import com.corrodinggames.rts.gameFramework.j.NetworkConnection;
import com.corrodinggames.rts.gameFramework.m.x;
import com.corrodinggames.rts.gameFramework.utility.aj;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;
import com.corrodinggames.rts.java.b.CommonGuiEngine;
import com.corrodinggames.rts.java.debuger.SimpleCommandLine;

import android.content.ServerContext;
import android.graphics.Point;
import android.os.Looper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Input;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.opengl.renderer.VBORenderer;

public class Main extends NetworkCallbacks {
    // 类变量注释
    public static boolean a = false; // isDebugMode?
    public static boolean b = true; // isEnabled?
    public static String gameTitle = "Rusted Warfare Core[Fork]"; // gameTitle
    public static Main instance; // instance
    public HeadlessGameView d; // libRocketManager?
    public String buildNumber = "#28"; // buildNumber
    public NetworkEngine networkManager; // networkManager?
    public SlickGameHandler gameHandler; // gameHandler
    public boolean u; // isConnected?
    public int v; // connectionPort?
    private aj f = new aj(); // taskQueue
    private boolean g = true; // isRunning
    protected CommonGuiEngine guiEngine; // guiEngine
    protected SlickGameContainer gameContainer; // gameContainer
    private String[] commandLineArgs; // commandLineArgs
    private int n; // errorCount
    private long startTime = System.nanoTime(); // startTime
    protected com.corrodinggames.rts.java.d.SlickLibRocketManager slickLibRocketManager; // slickLibRocketManager
    private GMissionEngine globalMissionEngine = new JavaMissionEngine(this); // missionEngine
    private Thread mainThread; // mainThread
    private boolean s = true; // ???
    private Object t = new Object(); // lockObject

    public static void main(String[] args) {
        instance = new Main();
        instance.realMain(args);
        // Main$1 mainStarter = new Main$1();//无用...
        SimpleCommandLine.main(args);
    }

    public static void a(String message) {
        GameEngine.log(message);
    }

    public void f() {
        com.corrodinggames.rts.gameFramework.utility.l inputReader = new com.corrodinggames.rts.gameFramework.utility.l(
                new InputStreamReader(System.in));

        while (this.g) {
            try {
                String inputLine = inputReader.a();
                if (inputLine == null) {
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                } else {
                    this.a((NetworkConnection) null, "ADMIN", inputLine, true);
                }
            } catch (IOException ioException) {
                if (this.n < 3) {
                    GameEngine
                            .log("Error while reading stdin: " + ioException.toString());
                    ++this.n;
                    if (this.n == 3) {
                        GameEngine.log("Too many stdin errors, ignoring");
                    }
                }

                try {
                    Thread.sleep(700L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    public void g() {
        Semaphore semaphore = new Semaphore(0);
        Thread initThread = new Thread(new Main$2(this, semaphore));
        initThread.setDaemon(true);
        initThread.start();

        try {
            semaphore.acquire();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public synchronized void realMain(String[] args) {
        this.commandLineArgs = args;
        boolean noDisplay = false;
        boolean noSound = false;
        boolean noMusic = false;
        boolean noPreferIPv4 = false;
        boolean allowSoftwareRender = false;
        boolean fullscreen = false;
        boolean disableVBOs = false;
        boolean forceVBOs = false;
        Integer width = null;
        Integer height = null;
        GameEngine.log("Reading args");
        String twoPartArg = null;
        String errorMessage = null;

        int i;
        String arg;
        for (i = 0; i < args.length; ++i) {
            arg = args[i].trim().toLowerCase(Locale.ENGLISH);
            if (twoPartArg != null) {
                if (twoPartArg.equals("+connect_lobby")) {
                    a("connect lobby:" + arg);
                    GameEngine.buildVersion = arg;
                    twoPartArg = null;
                } else if (twoPartArg.equals("-width")) {
                    width = Integer.parseInt(arg);
                    twoPartArg = null;
                } else if (twoPartArg.equals("-height")) {
                    height = Integer.parseInt(arg);
                    twoPartArg = null;
                } else {
                    a("Unknown two_part_arg: " + twoPartArg);
                    twoPartArg = null;
                }
            } else {
                String param;
                if (arg.equals("-debug")) {
                    ++i;
                    if (i >= args.length) {
                        a("-debug requires parameters");
                        System.exit(1);
                    }

                    param = args[i];
                    int debugPort = Integer.parseInt(param.split(":")[0]);
                    String debugHost = param.split(":")[1];
                    com.corrodinggames.rts.a.DebugSocketServer.a(debugPort, debugHost);
                } else if (arg.equals("-debugscript")) {
                    ++i;
                    if (i >= args.length) {
                        a("-debugscript requires parameters");
                        System.exit(1);
                    }

                    param = args[i];
                    com.corrodinggames.rts.a.DebugSocketServer.a(param);
                } else if (arg.equals("-log")) {
                    ++i;
                    if (i >= args.length) {
                        a("-log requires parameters");
                        System.exit(1);
                    }

                    param = args[i];

                    try {
                        PrintStream logStream = new PrintStream(param);
                        System.setOut(logStream);
                        System.setErr(logStream);
                        GameEngine.log("File logging started");
                    } catch (FileNotFoundException fileNotFoundException) {
                        GameEngine.a("Cannot open log file:" + param);
                        fileNotFoundException.printStackTrace();
                    }
                } else if (!arg.equals("-nologfile")) {
                    if (arg.equals("-lang")) {
                        ++i;
                        if (i >= args.length) {
                            a("-lang requires parameters");
                            System.exit(1);
                        }

                        param = args[i];
                        com.corrodinggames.rts.gameFramework.h.a.d = param;
                    } else if (arg.equals("-logcolor")) {
                        GameEngine.ax = true;
                    } else if (arg.equals("-nodisplay")) {
                        noDisplay = true;
                    } else if (arg.equals("-canvasgl")) {
                        GameEngine.isGameStartedStatic = true;
                    } else if (arg.equals("-replay_debug")) {
                        GameEngine.aw = true;
                    } else if (arg.equals("-nopreferipv4")) {
                        noPreferIPv4 = true;
                    } else if (arg.equals("-noresources")) {
                        GameEngine.isNetworkServerStatic = true;
                    } else if (arg.equals("-nosound")) {
                        noSound = true;
                    } else if (arg.equals("-nomusic")) {
                        noMusic = true;
                    } else if (arg.equals("-safemode")) {
                        GameEngine.isGamePausedOrMinimizedStatic2 = true;
                    } else if (arg.equals("-extrasafemode")) {
                        GameEngine.isNetworkGameActiveStatic2 = true;
                    } else if (arg.equals("-disable_vbos")) {
                        disableVBOs = true;
                    } else if (arg.equals("-disable_atlas")) {
                        GameEngine.isDemoVersionStatic = true;
                    } else if (arg.equals("-force_vbos")) {
                        forceVBOs = true;
                    } else if (arg.equals("-allowsoftwarerender")) {
                        allowSoftwareRender = true;
                    } else if (arg.equals("-fullscreen")) {
                        fullscreen = true;
                    } else if (arg.equals("-nobackground")) {
                        GameEngine.noBackground = true;
                    } else if (arg.equals("-nomods")) {
                        GameEngine.isInGameOrLobbyStatic = true;
                    } else if (arg.equals("-printunits")) {
                        GameEngine.isGamePausedStatic = true;
                    } else if (arg.equals("-outputunitimages")) {
                        GameEngine.isGameMinimizedStatic = true;
                    } else if (arg.equals("-oldreplays")) {
                        GameEngine.isGamePausedOrMinimizedStatic = true;
                    } else if (arg.equals("-teamshaders")) {
                        GameEngine.isGameMinimizedStatic2 = true;
                    } else if (arg.equals("-noteamshaders")) {
                        GameEngine.isGameMinimizedStatic2 = false;
                    } else if (arg.equals("-devdebug")) {
                        ++i;
                        if (i >= args.length) {
                            a("-debugscript requires parameters");
                            System.exit(1);
                        }

                        param = args[i];
                        GameEngine.platformName = param;
                    } else if (arg.equals("-postprocessing")) {
                        GameEngine.isGamePausedStatic2 = true;
                    } else if (arg.equals("-nopostprocessing")) {
                        GameEngine.isGamePausedStatic2 = false;
                    } else if (arg.equals("-disabletextureread")) {
                        com.corrodinggames.rts.java.SlickTexture.F = false;
                    } else if (arg.equals("-sandbox")) {
                        GameEngine.isNetworkConnectedStatic = true;
                    } else if (arg.equals("-steam")) {
                        GameEngine.isNetworkGameActiveStatic = true;
                    } else if (!arg.equals("-width") && !arg.equals("-height")) {
                        if (arg.startsWith("+")) {
                            if (arg.equals("+connect_lobby")) {
                                twoPartArg = arg;
                            } else {
                                a("Unknown steam option: " + arg);
                            }
                        } else if (arg.trim().length() != 0) {
                            a("Unknown option: " + arg);
                            errorMessage = "Unknown option: " + arg;
                        }
                    } else {
                        twoPartArg = arg;
                    }
                }
            }
        }

        GameEngine.log("Game arguments:");

        for (i = 0; i < args.length; ++i) {
            arg = args[i].trim().toLowerCase(Locale.ENGLISH);
            a("arg: " + arg);
        }

        if (errorMessage != null) {
            if (GameEngine.isNetworkGameActiveStatic) {
                a("Unknown options but running anyway due to being in steam");
            } else {
                a("Exiting due to unknown option: " + errorMessage);
                System.exit(1);
            }
        }

        GameEngine.isPausedStatic2 = true;
        GameEngine.aq();
        String osName = System.getProperty("os.name");
        GameEngine.log("OS name: " + osName);
        GameEngine.log("OS version: " + System.getProperty("os.version"));
        GameEngine.log("LWJGL version: " + Sys.getVersion());
        GameEngine.log("Build Number: " + this.buildNumber);
        GameEngine.log("Game Version: 1.15");
        GameEngine.log("Game Code: 176");
        com.corrodinggames.rts.game.GameLogic.is64Bit = Sys.is64Bit();
        GameEngine.log("Is 64bit: " + com.corrodinggames.rts.game.GameLogic.is64Bit);
        GameEngine.log("JVM maxMemory:" + Runtime.getRuntime().maxMemory());
        GameEngine.log("JVM totalMemory:" + Runtime.getRuntime().totalMemory());
        GameEngine.log("JVM freeMemory:" + Runtime.getRuntime().freeMemory());
        if (osName != null && osName.toLowerCase().contains("mac os")) {
            com.corrodinggames.rts.game.GameLogic.isSandboxEnabled = true;
        }

        if (noPreferIPv4) {
            GameEngine.log("Skipping preferIPv4Stack=true");
        } else {
            System.setProperty("java.net.preferIPv4Stack", "true");
        }

        if (GameEngine.isNetworkGameActiveStatic) {
            com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a = new com.corrodinggames.rts.java.c.JavaSteamEngine();
            GameEngine.log("Early steam init");
            com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a().b();
            GameEngine.log("Early steam init done.");
        } else {
            GameEngine.log("steam not requested");
        }

        this.g();// looper init & wait...
        String title = gameTitle;
        if (noDisplay) {
            title = "";
        }

        Input.disableControllers();
        if (a) {
            Renderer.setRenderer(2);
        }

        if (!forceVBOs && com.corrodinggames.rts.game.GameLogic.isSandboxEnabled) {
            GameEngine.log("Disabling vbo on mac (without force option)");
            disableVBOs = true;
        }

        if (disableVBOs) {
            GameEngine.log("disable_vbos requested");
            SGL renderer = Renderer.get();
            if (renderer instanceof VBORenderer) {
                VBORenderer vboRenderer = (VBORenderer) renderer;
                vboRenderer.disableVBOs();
            } else {
                GameEngine.log("Failed to disable VBOs, wrong class");
            }
        }

        com.corrodinggames.rts.java.SlickGraphicsEngine.c();
        this.gameHandler = new SlickGameHandler(title);
        this.gameHandler.b = this;
        this.gameHandler.i = noDisplay;
        this.gameHandler.j = noSound;
        this.gameHandler.k = noMusic;
        float screenHeight;
        float screenWidth;
        if (noDisplay) {
            GameEngine.a("Skipping display mode call");
            screenHeight = 800.0F;
            screenWidth = 600.0F;
        } else {
            try {
                DisplayMode displayMode = Display.getDisplayMode();
                screenHeight = (float) displayMode.getHeight();
                screenWidth = (float) displayMode.getWidth();
            } catch (Exception exception) {
                GameEngine.a("Failed to get display mode, defaulting to min size");
                exception.printStackTrace();
                screenHeight = 800.0F;
                screenWidth = 600.0F;
            }
        }

        GameEngine.log("screenHeight:" + screenHeight);
        GameEngine.log("screenWidth:" + screenWidth);
        int displayWidth = 1000;
        int displayHeight = 733;
        if (screenHeight > 800.0F) {
            displayWidth = 1000;
            displayHeight = 800;
        }

        if (screenHeight > 900.0F) {
            displayWidth = 1600;
            displayHeight = 900;
        }

        if (noDisplay) {
            displayWidth = 10;
            displayHeight = 10;
        }

        if (width != null) {
            GameEngine.log("Overriding width to:" + width);
            displayWidth = width;
        }

        if (height != null) {
            GameEngine.log("Overriding height to:" + height);
            displayHeight = height;
        }

        if (allowSoftwareRender) {
            GameEngine.log("allowSoftwareOpenGL is now on");
            System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
        }

        this.gameHandler.l = false;
        boolean isFullscreen = fullscreen;

        try {
            if (this.gameHandler.l) {
                this.gameHandler.a(displayWidth * 2, displayHeight * 2);
                this.gameContainer = new SlickGameContainer(
                        new ScalableGame(this.gameHandler, displayWidth, displayHeight), displayWidth, displayHeight,
                        isFullscreen);
            } else {
                this.gameContainer = new SlickGameContainer(this.gameHandler, displayWidth, displayHeight,
                        isFullscreen);
            }
        } catch (SlickException slickException) {
            throw new RuntimeException(slickException);
        }

        this.gameHandler.c = this.gameContainer;
        Display.setResizable(true);
        GameStartupRunnable gameStartup = new GameStartupRunnable(this);
        this.mainThread = new Thread(gameStartup);
        this.mainThread.setDaemon(false);
        this.mainThread.start();
    }

    public void b(String message) {
        this.globalMissionEngine.a(message, true);
    }

    public synchronized void h() throws UnsupportedEncodingException, IOException {
        this.b("displayModes");
        this.b("starting controllers");
        this.startTime = System.nanoTime();
        GameEngine.isPausedStatic2 = true;
        GameEngine.isSandboxModeStatic2 = true;
        if (!GameEngine.isNetworkServerStatic) {
            if (GameEngine.isGameStartedStatic) {
                GameEngine.isIOSVersionStatic2 = true;
                GameEngine.isAndroidVersionStatic2 = true;
                GameEngine.bg = x.class;
            } else {
                GameEngine.isIOSVersionStatic2 = true;
                GameEngine.isAndroidVersionStatic2 = true;
                GameEngine.bg = SlickGraphicsEngine.class;
            }
        }

        if (this.gameHandler != null && !this.gameHandler.j) {
            byte audioChannels = 20;
            OpenALAudio openALAudio = new OpenALAudio(audioChannels, 9, 512);
            GameEngine.log("openALAudio hasDevice:" + openALAudio.hasDevice());
            com.corrodinggames.rts.gameFramework.sound.e.c = new OpenALSoundFactory(openALAudio);
            if (this.gameHandler.k) {
                GameEngine.log("Music disabled");
                MusicManager.a = new av();
            } else {
                MusicManager.a = new com.corrodinggames.rts.java.OpenALMusicFactory(openALAudio);
            }
        } else {
            GameEngine.b("Disabling sound with NullSoundFactory");
            com.corrodinggames.rts.gameFramework.sound.e.c = new f();
            MusicManager.a = new av();
        }

        com.corrodinggames.rts.gameFramework.j.n.d = new JavaHttpClientManager();
        com.corrodinggames.rts.gameFramework.ac.b = new v();
        long startTime = PerformanceProfiler.a();
        this.b("loading libRocket");
        GameEngine.log("start libRocket setup");
        this.d = new HeadlessGameView();
        this.guiEngine = com.corrodinggames.rts.java.b.CommonGuiEngine.p();
        this.guiEngine.f = this;
        this.slickLibRocketManager = new com.corrodinggames.rts.java.d.SlickLibRocketManager();
        this.guiEngine.a(this.slickLibRocketManager, this.d);
        this.slickLibRocketManager.debug = false;
        this.slickLibRocketManager.setup();
        this.b("libRocket - fonts");
        this.slickLibRocketManager.loadFont("font/Delicious-Roman.otf");
        this.slickLibRocketManager.loadFont("font/Delicious-Italic.otf");
        this.slickLibRocketManager.loadFont("font/Delicious-Bold.otf");
        this.slickLibRocketManager.loadFont("font/Delicious-BoldItalic.otf");
        this.slickLibRocketManager.loadFont("font/Roboto-Regular.ttf");
        this.slickLibRocketManager.loadFont("font/Roboto-Bold.ttf");
        GameEngine.log("NotoSansCJKsc start");
        this.slickLibRocketManager.loadFont("font/NotoSansCJKsc-Regular.otf", "notoSans");
        this.slickLibRocketManager.loadFont("font/DroidSansFallback.ttf", "fallback");
        GameEngine.log("NotoSansCJKsc end");
        this.guiEngine.c();
        GameEngine.log("end libRocket setup");
        this.b("GuiEngine");
        PerformanceProfiler.a("libRocket setup took:", startTime);
        GameEngine.dz = this.buildNumber;
        ServerContext serverContext = new ServerContext();
        this.b("GameEngine");
        int screenWidth = this.gameHandler.a.getWidth();
        int screenHeight = this.gameHandler.a.getHeight();
        GameEngine.ck = new Point(screenWidth, screenHeight);
        GameEngine gameEngine = GameEngine.a(serverContext,
                this.globalMissionEngine);
        this.b("GameEngine ready");
        GameEngine
                .log("version: " + gameEngine.getBaseVersion() + " " + gameEngine.getVersionCode(false) + ":"
                        + this.buildNumber);
        this.guiEngine.b();
        com.corrodinggames.rts.a.DebugSocketServer.runPendingScripts();
        this.networkManager = gameEngine.networkEngine;
        gameEngine.bQ.showZoomButton = false;
        gameEngine.bQ.showUnitGroups = false;
        this.gameHandler.a(this.d);
        this.gameHandler.a(1000, 800);
        long endTime = System.nanoTime();
        GameEngine.log("-----------------------------");
        GameEngine
                .log("----- Game init finished in:" + (double) (endTime - this.startTime) / 1000000.0 + " ms");
        gameEngine.networkEngine.d = this;
        gameEngine.networkEngine.y = "unset";// self网络玩家名?
        if (!GameEngine.noBackground) {
        }
    }

    public void b() {
        Main$3 startGameTask = new Main$3(this);
        this.f.a(startGameTask);
    }

    public void a(float deltaTime) {
        this.f.a();
    }

    public void a(boolean isForced) {
        this.g = false;
        GameEngine gameEngine = GameEngine.getInstance();
        if (!isForced) {
            gameEngine.networkEngine.u();
        } else {
            gameEngine.networkEngine.b("shutdownServer");
        }

        try {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            System.exit(0);
        } catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
    }

    public Main() {
    }

    public synchronized boolean a(NetworkConnection connection, String username, String message) {
        return true;
    }

    public synchronized void b(NetworkConnection connection, String username, String message) {
        this.a(connection, username, message, false);
    }

    public void c() {
        GameEngine gameEngine = GameEngine.getInstance();
        if (!gameEngine.networkEngine.aW) {
            ScriptEngine scriptEngine = ScriptEngine.getInstance();
            if (scriptEngine != null) {
                scriptEngine.addScriptToQueueIfNotAlreadyQueued("mp.refreshUI()");
            }
        }
    }

    public synchronized void a(int messageType, String username, String message, NetworkConnection connection) {
        if (this.slickLibRocketManager != null && this.slickLibRocketManager.c != null) {
            this.slickLibRocketManager.c
                    .addRunnableToQueue(new Main$4(this, messageType, username, message, connection));
        } else {
            GameEngine.T();
        }
    }

    public synchronized void a(NetworkConnection connection, String username, String message, boolean isAdmin) {
        if (!isAdmin) {
            a(username + ": " + message);
        }

        if (!this.s) {
            ;
        }
    }

    public String a(NetworkConnection connection, String username) {
        return null;
    }

    public synchronized void c(NetworkConnection connection, String username, String message) {
    }

    public synchronized void b(NetworkConnection connection, String username) {
    }

    public void i() {
        GameEngine gameEngine = GameEngine.getInstance();
        this.gameHandler.g();
    }

    public void d() {
        com.corrodinggames.librocket.a.a().o();
    }

    public void a(PasswordHandler event) {
        com.corrodinggames.librocket.a.a().a(event);
    }
}

final class Main$1 implements Runnable {
    Main$1() {
    }

    @Override
    public void run() {
        Main.instance.f();
    }
}

class Main$2 implements Runnable {
    final /* synthetic */ Semaphore a; // semaphore
    final /* synthetic */ Main b; // mainInstance

    Main$2(Main main, Semaphore semaphore) {
        this.b = main;
        this.a = semaphore;
    }

    @Override
    public void run() {
        try {
            GameEngine.aq();
            Looper.a();
            this.a.release(1);
            Looper.c();
        } catch (RuntimeException e) {
            GameEngine.log("Error: "+e.getMessage());
        }
    }
}

class Main$3 implements Runnable {
    final /* synthetic */ Main a; // mainInstance

    Main$3(Main main) {
        this.a = main;
    }

    @Override
    public void run() {
        GameEngine gameEngine = GameEngine.getInstance();
        GameEngine.log("got startGameEvent..");
        try {
            com.corrodinggames.rts.appFramework.n.r();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (gameEngine.bL == null || !gameEngine.bL.W) {
            GameEngine.log("Not starting multiplayer game because map failed to load");
            gameEngine.networkEngine.af();
            return;
        }
        gameEngine.networkEngine.bd = true;
        gameEngine.bH = false;
        gameEngine.gameStarted = false;
        this.a.guiEngine.c(false);
        com.corrodinggames.librocket.a.a().f();
        this.a.slickLibRocketManager.getActiveDocument();
        if (this.a.slickLibRocketManager.c != null) {
            this.a.slickLibRocketManager.c.getRoot().resumeNonMenu();
        } else {
            GameEngine.log("startGameEvent: scriptEngine==null");
            GameEngine.T();
        }
    }
}

class Main$4 implements Runnable {
    final /* synthetic */ int a; // messageType
    final /* synthetic */ String b; // username
    final /* synthetic */ String c; // message
    final /* synthetic */ NetworkConnection d; // connection
    final /* synthetic */ Main e; // mainInstance

    Main$4(Main main, int messageType, String username, String message, NetworkConnection connection) {
        this.e = main;
        this.a = messageType;
        this.b = username;
        this.c = message;
        this.d = connection;
    }

    @Override
    public void run() {
        this.e.slickLibRocketManager.c.getRoot().receiveChatMessage(this.a, this.b, this.c, this.d);
    }
}