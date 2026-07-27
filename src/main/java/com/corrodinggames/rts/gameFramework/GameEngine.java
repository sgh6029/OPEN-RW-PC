/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Debug
 */
package com.corrodinggames.rts.gameFramework;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.gameFramework.sound.e;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.f.o;
import com.corrodinggames.rts.gameFramework.g.c;
import com.corrodinggames.rts.gameFramework.g.f;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameModeType;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.utility.d;
import com.corrodinggames.rts.gameFramework.utility.AssetIndex;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class GameEngine {
    public final Object gameLoopLock = new Object();
    public final Object gameLoopLock2 = new Object();
    protected static GameEngine instance = null;
    public Context am = null;
    public Context an;
    public com.corrodinggames.rts.appFramework.f ao;
    public com.corrodinggames.rts.appFramework.f ap;
    public boolean gameStarted;
    public boolean isGamePaused = false;
    public static boolean as = true;
    public static boolean forceCoreUnitCheck = false; //强制要求CoreUnit匹配 -- PS:当前有CoreUnit不匹配的问题 只能出此下策
    public static boolean at = false;
    public static boolean au = false;
    public static Throwable av;
    public static boolean aw;
    public static boolean ax;
    public static boolean noBackground;// 主界面菜单背后的战斗背景
    public static boolean isDesktopVersionStatic;
    public static boolean isPausedStatic;
    public static boolean isNetworkServerStatic;
    public static boolean isDemoVersionStatic;
    public static boolean isGameStartedStatic;
    public static boolean isGamePausedStatic;
    public static boolean isGameMinimizedStatic;
    public static boolean isGamePausedOrMinimizedStatic;
    public static boolean isNetworkGameActiveStatic;
    public static boolean isNetworkConnectedStatic;
    public static boolean isInGameOrLobbyStatic;
    public static String buildVersion;
    public static boolean isGameThreadRunningStatic;
    public static boolean isGamePausedStatic2;
    public static boolean isGameMinimizedStatic2;
    public static boolean isGamePausedOrMinimizedStatic2;
    public static boolean isNetworkGameActiveStatic2;
    public static String platformName;
    public static boolean isNetworkConnectedStatic2;
    public boolean aS;
    public static boolean aT;
    public static boolean isPausedStatic2;
    public static boolean aV;
    public static boolean isAndroidVersionStatic2;
    public static boolean isIOSVersionStatic2;
    public static boolean isPCVersionStatic2;
    public static boolean isDebugVersionStatic2;
    public static String androidVersion;
    public static boolean isSandboxModeStatic2;
    public static boolean bc;
    public static boolean bd;
    public static boolean be;
    public static boolean bf;
    public static Class bg;
    public static com.corrodinggames.rts.gameFramework.m.y bh;
    public boolean isGameModePaused = false;
    public boolean isGameMinimized;
    public boolean bk = false;
    public boolean bl = false;
    public boolean bm = false;
    public boolean bn = false;
    public boolean bo = false;
    public boolean bp;
    public boolean bq = false;
    public boolean br = false;
    public com.corrodinggames.rts.game.PlayerTeam bs;
    public float bt = 1.0f;
    public float bu = -1.0f;
    public boolean bv;
    public boolean bw;
    public int bx = 0;
    public int by;
    public int bz;
    public int bA;
    public int bB;
    public int bC;
    public boolean isGamePausedOrMinimized2;
    public boolean isBenchmarking = false;
    public volatile boolean exitGameThread = false;
    public volatile boolean loadNewGame = false;
    public volatile boolean bH = false;
    public volatile boolean bI = false;
    public int unitLimit;
    public AssetIndex bK;
    public TileMap bL;
    public e bM;
    public MusicManager bN;
    public com.corrodinggames.rts.gameFramework.m.y bO;
    public com.corrodinggames.rts.gameFramework.a bP; // sound
    public SettingsEngine bQ;
    public com.corrodinggames.rts.gameFramework.effect.c bR;
    public g bS;
    public ac bT;
    public com.corrodinggames.rts.gameFramework.k.l bU;
    public aa bV;
    public o bW;
    public NetworkEngine networkEngine;
    public GameStatistics bY;
    public com.corrodinggames.rts.gameFramework.i.a bZ;
    public GameSaver ca;
    public ReplayEngine cb;
    public com.corrodinggames.rts.game.units.f.c cc;
    public PerformanceProfiler cd;
    public com.corrodinggames.rts.gameFramework.n.MissionEngine ce;
    public com.corrodinggames.rts.gameFramework.CommandQueue cf; //
    public com.corrodinggames.rts.gameFramework.g.a cg = new com.corrodinggames.rts.gameFramework.g.a();
    public boolean ch = false;
    public float ci;
    public float cj;
    public static Point ck;
    public float cl;
    public float cm;
    public float cn = 1.0f;
    public float co;
    public float cp;
    public float cq;
    public float cr;
    public float cs;
    public boolean ct;
    public int cu;
    public int cv;
    public float cw;
    public float cx;
    public float cy;
    public float cz;
    public float screenHeight;
    public float uiScale;
    public float zoomLevel;
    public float maxZoomLevel;
    public float minZoomLevel;
    public float cameraShakeX;
    public float cameraShakeY;
    public float cameraShakeIntensity;
    public float cameraShakeDecay;
    public float cameraShakeTime;
    public final Rect cameraBoundsEnabled = new Rect();
    public final Rect cL = new Rect();
    public final RectF cM = new RectF();
    public final Rect cN = new Rect();
    public final RectF cO = new RectF();
    public final RectF cP = new RectF();
    public final Rect cQ = new Rect();
    public boolean cR;
    public boolean cS;
    public float cT;
    public boolean cU;
    public float cV = 1.0f;
    public boolean cW = false;
    public float cX = 1.0f;
    public float cY = 1.0f;
    public boolean cZ;
    public float mouseX;
    public float mouseY;
    public boolean mouseScreenX = true;
    public boolean mouseScreenY = true;
    public boolean mouseWorldX = true;
    public boolean mouseWorldY = true;
    public boolean mousePressed = true;
    public float dh = 0.0f;
    public float di = 0.0f;
    public boolean dj = false;
    protected GameThread dk = null;
    public String menuBackgroundMapFile;//主菜单背景战斗的地图文件路径
    public GameInputStream dm;
    public Paint dn;
    public Paint do_;
    public Paint dp;
    public boolean dq = false;
    public boolean dr = false;
    public float ds = 0.0f;
    public boolean dt = false;
    public boolean du = false;
    public boolean dv = false;
    public int dw;
    public float dx = 0.0f;
    public static com.corrodinggames.rts.gameFramework.GameEngineFactory dy = new GameLogicFactory();
    public static String dz;
    float keyState;
    boolean keyPressed = false;
    ArrayList<m_f> dC = new ArrayList<m_f>();
    final Handler dD = new Handler(Looper.b());
    public String gameMode;
    private Runnable a = new l$1(this);
    public String dF;
    public String dG;
    private Runnable b = new l$2(this);
    public GMissionEngine dH = null;
    transient String dI = null;
    Object dJ = new Object();
    String dK;
    String dL;
    public boolean[] dM = new boolean[10];
    protected ConcurrentLinkedQueue dN = new ConcurrentLinkedQueue();
    private boolean[] c = new boolean[KeyEvent.a() + 1];
    private boolean[] d = new boolean[KeyEvent.a() + 1];
    private int e;
    public static boolean dO;
    static byte[] dP;
    static byte[] dQ;
    static byte[] dR;
    static d dS;
    static boolean dT;
    static int dU;
    static boolean dV;
    static AssetType dW;
    static boolean gameModeMultiplayer;
    static boolean gameModeSinglePlayer;
    public byte dZ = (byte) 42;
    public byte ea = (byte) 42;
    public final TaskQueue eb = new TaskQueue();
    public final TaskQueue ec = new TaskQueue();
    public final TaskQueue ed = new TaskQueue();
    public boolean ee;
    public boolean ef;
    public String eg;
    public boolean eh;
    public boolean ei;
    static int ej;

    public static boolean b(Context context) {
        String string2 = null;
        string2 = isPausedStatic2 ? "dedicatedServer" : context.g().h();
        Log.d("RustedWarfare", "packageName:" + string2);
        return string2.contains("rtsdemo");
    }

    public boolean A() {
        return this.cS || this.cT > 0.0f || this.cU;
    }

    public static final GameEngine getInstance() {
        return instance;
    }

    public static final boolean C() {
        return be;
    }

    public static final boolean D() {
        return bf;
    }

    public void c(Context context) {
        com.corrodinggames.rts.appFramework.c.a(context);
        this.am = context;
    }

    public static synchronized GameEngine a(Context context, GMissionEngine n2) throws UnsupportedEncodingException, IOException {
        if (instance != null) {
            if (n2 != null) {
                GameEngine.instance.dH = n2;
            }
            instance.c(context);
            return instance;
        }
        instance = dy.a(context);
        GameEngine.log("Created new gameEngine of:" + instance.getClass().getName());
        if (n2 != null) {
            GameEngine.instance.dH = n2;
        }
        instance.initializeEngine(context);
        return instance;
    }

    public GameEngine(Context context) {
        Log.d("RustedWarfare", "GameEngine:GameEngine()");
        if (instance != null) {
            throw new RuntimeException("gameEngine already created");
        }
        this.c(context);
        instance = this;
    }

    protected void finalize() {
        Log.d("RustedWarfare", "GameEngine:finalize()");
        try {
            super.finalize();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean E() {
        return true;
    }

    public abstract void initializeEngine(Context var1) throws UnsupportedEncodingException, IOException;

    public void F() {
    }

    public abstract boolean isNetworkGameActive();

    public abstract boolean canProcessGameLogic(boolean var1);

    public abstract void setGameView(Activity var1, com.corrodinggames.rts.appFramework.f var2, boolean var3);

    public abstract void updateCameraPosition(int var1, int var2);

    public abstract int getVersionCode(boolean var1);

    public abstract boolean isBetaVersion();

    public abstract boolean isDeveloperMode();

    public abstract String getPackageNameWithContext();

    public abstract String getInstallerPackageName();

    public abstract String getFullVersionString();

    public abstract String getVersionDisplayString();

    public abstract String getBaseVersion();

    public abstract void clearVersionCache();

    public abstract String getVersionNumber();

    public String G() {
        if (GameEngine.av()) {
            return "PC";
        }
        if (isDebugVersionStatic2) {
            String string2 = com.corrodinggames.rts.gameFramework.l.a.a();
            if (string2 != null) {
                return "IOS - " + string2;
            }
            return "IOS";
        }
        if (isPausedStatic2) {
            return "SERVER";
        }
        return Build.MODEL;
    }

    public String H() {
        return dz;
    }

    public abstract void initializeAndStartGame(boolean var1, boolean var2, GameMode var3);

    public abstract void startGame(boolean var1, GameMode var2);

    public abstract void e();

    public abstract void cleanupGameObjects();

    public abstract void loadMenuBackground();

    //调用绘制 此方法为中间层
    //这个方法会被GameThread循环调用
    public abstract void processGameFrame(float var1, int var2) throws UnsupportedEncodingException, IOException;

    public boolean I() {
        return this.bH;
    }

    public synchronized void J() {
        GameEngine.log("--- setRunning ---");
        if (!GameEngine.av() && !isDebugVersionStatic2) {
            this.bN.h();
        }
        if (!isAndroidVersionStatic2 && !isSandboxModeStatic2 && this.dk == null) {
            this.dk = new GameThread();
            this.dk.a(true);
            this.dk.start();
        }
    }

    public synchronized void K() {
        GameEngine.log("--- setStoppedIfNotInGameThread ---");
        if (Thread.currentThread() != this.dk) {
            this.L();
        }
    }

    public synchronized void L() {
        GameEngine.log("--- setStopped ---");
        if (this.dk == null) {
            Log.d("RustedWarfare", "gameThread already null");
            return;
        }
        if (!GameEngine.av()) {
            this.bN.f();
        }
        this.dk.a(false);
        if (Thread.currentThread() != this.dk) {
            boolean bl2 = true;
            while (bl2) {
                try {
                    this.dk.join();
                    bl2 = false;
                } catch (InterruptedException interruptedException) {
                }
            }
            Log.d("RustedWarfare", "thread stop");
        } else {
            GameEngine.g("currentThread is game thread");
        }
        this.dk = null;
        if (this.ao != null) {
            this.ao.l();
        }
        if (this.isBenchmarking) {
            Debug.stopMethodTracing();
        }
    }

    public boolean M() {
        if (this.networkEngine == null) {
            return false;
        }
        if (!this.networkEngine.B) {
            return false;
        }
        return !this.networkEngine.F && !this.cb.j();
    }

    public boolean N() {
        if (this.networkEngine == null) {
            return false;
        }
        return this.networkEngine.B;
    }

    public boolean O() {
        if (this.networkEngine == null) {
            return false;
        }
        if (this.networkEngine.F) {
            return true;
        }
        return this.networkEngine.B || this.cb.j();
    }

    public boolean P() {
        if (this.networkEngine == null) {
            return true;
        }
        if (this.networkEngine.F) {
            return true;
        }
        return !this.networkEngine.B && !this.cb.j();
    }

    public void Q() {
        this.ct = false;
        if (this.cy < 0.0f) {
            this.cy = 0.0f;
            this.ct = true;
        }
        if (this.cz < 0.0f) {
            this.cz = 0.0f;
            this.ct = true;
        }
        if (this.bL != null) {
            if (this.cy > this.bL.i() - this.minZoomLevel) {
                this.cy = this.bL.i() - this.minZoomLevel;
                this.ct = true;
            }
            if (this.cz > this.bL.j() - this.uiScale) {
                this.cz = this.bL.j() - this.uiScale;
                this.ct = true;
            }
            if (this.minZoomLevel > this.bL.i()) {
                this.cy = this.bL.i() / 2.0f - this.minZoomLevel / 2.0f;
                this.ct = true;
            }
            if (this.uiScale > this.bL.j()) {
                this.cz = this.bL.j() / 2.0f - this.uiScale / 2.0f;
                this.ct = true;
            }
        }
        this.a(this.cy, this.cz);
    }

    public void a(float f2, float f3) {
        this.cy = f2;
        this.cz = f3;
        this.cu = (int) this.cy;
        this.cv = (int) this.cz;
        this.cw = (float) ((int) (this.cy * this.cX)) / this.cX;
        this.cx = (float) ((int) (this.cz * this.cX)) / this.cX;
        int n2 = 90;
        if (GameEngine.C()) {
            n2 = 210;
        }
        this.cN.a((int) (this.cy - (float) n2), (int) (this.cz - (float) n2), (int) (this.cy + this.screenHeight + (float) n2),
                (int) (this.cz + this.uiScale + (float) n2));
        this.cO.a(this.cN);
        this.cQ.a((int) this.cy, (int) this.cz, (int) (this.cy + this.screenHeight), (int) (this.cz + this.uiScale));
        int n3 = 300;
        this.cP.a((int) (this.cy - (float) n3), (int) (this.cz - (float) n3), (int) (this.cy + this.screenHeight + (float) n3),
                (int) (this.cz + this.uiScale + (float) n3));
    }

    public void b(float f2, float f3) {
        this.a(f2 - this.minZoomLevel / 2.0f, f3 - this.uiScale / 2.0f);
    }

    public static boolean d(Context context) {
        if (isPausedStatic2) {
            return false;
        }
        if (Build.MODEL.equals("GT-I9100") || Build.MODEL.equals("GT-I9300")) {
            try {
                WifiManager wifiManager = (WifiManager) context.c("wifi");
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                if (wifiInfo != null && "BlueStacks".equals(wifiInfo.getSSID())) {
                    return true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    public void R() {
        if (this.cX != 1.0f) {
            this.bO.a(this.cX, this.cX);
        }
    }

    public void S() {
        if (this.cX != 1.0f) {
            this.bO.a(1.0f / this.cX, 1.0f / this.cX);
        }
    }

    public static void a(String string2, Exception exception) {
        GameEngine.log(string2);
        exception.printStackTrace();
    }

    public static String a(String string2, String string3) {
        if (ax && !string2.contains("\u001b[0m")) {
            string2 = string3 + string2 + "\u001b[0m";
        }
        return string2;
    }

    public static void a(String string2) {
        GameEngine.log(GameEngine.a("--- ERROR: " + string2, "\u001b[31m"));
    }

    public static void b(String string2) {
        GameEngine.log(GameEngine.a(string2, "\u001b[33m"));
    }

    public static void a(String string2, Throwable throwable) {
        GameEngine.b(string2);
        GameEngine.log("" + throwable.toString());
        GameEngine.log("cause:" + throwable.getCause());
        throwable.printStackTrace();
    }

    public static void c(String string2) {
        if (isIOSVersionStatic2) {
            Log.b("RustedWarfare", string2);
            return;
        }
        Log.b("RustedWarfare", string2);
    }

    public static void d(String string2) {
        GameEngine.c(string2);
    }

    public static void log(String string2) {
        GameEngine.c(string2);
    }

    public static void b(String string2, String string3) {
        GameEngine.c(string2 + ":" + string3);
    }

    public static synchronized void f(String string2) {
        GameEngine.c(string2 + " (at " + System.nanoTime() + ")");
    }

    public static void T() {
        StackTraceElement[] stackTraceElementArray;
        for (StackTraceElement stackTraceElement : stackTraceElementArray = new Throwable().getStackTrace()) {
            GameEngine.log(stackTraceElement.toString());
        }
    }

    public static String U() {
        StackTraceElement[] stackTraceElementArray;
        String string2 = "";
        for (StackTraceElement stackTraceElement : stackTraceElementArray = new Throwable().getStackTrace()) {
            string2 = string2 + stackTraceElement.toString() + "\n";
        }
        return string2;
    }

    public static void g(String string2) {
        GameEngine.b(string2);
        GameEngine.T();
    }

    public static long V() {
        return System.currentTimeMillis();
    }

    public static final boolean a(long l2, long l3) {
        long l4 = GameEngine.V();
        if (l2 + l3 < l4) {
            return true;
        }
        return l4 < l2 - 1000L;
    }

    public float W() {
        float f2 = this.ci;
        if (this.bQ != null) {
            f2 *= this.bQ.renderDensity;
            f2 *= this.bQ.uiRenderScale;
            if (this.bQ.renderDoubleScale) {
                return f2 / 2.0f;
            }
        }
        return f2;
    }

    public int e(float f2) {
        int n2 = (int) (f2 * this.cj + 0.5f);
        return n2;
    }

    public int a(int n2) {
        return (int) ((float) n2 * this.cj + 0.5f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void X() {
        if (this.keyState != this.cj) {
            GameEngine.log("Density size changed now: " + this.cj + ", refreshing fonts");
            ArrayList arrayList = this.dC;
            synchronized (arrayList) {
                for (m_f m2 : this.dC) {
                    m2.a();
                }
            }
            this.keyState = this.cj;
            if (this.bO != null) {
                // empty if block
            }
        }
    }

    protected void Y() {
        for (m_f m2 : this.dC) {
            this.bO.a(m2.b);
        }
        this.keyPressed = true;
    }

    public void a(Paint paint) {
        this.a(paint, 16.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Paint paint, float f2) {
        m_f m2 = new m_f(this);
        m2.a = f2;
        m2.b = paint;
        m2.a();
        ArrayList arrayList = this.dC;
        synchronized (arrayList) {
            this.dC.add(m2);
        }
        if (this.keyPressed) {
            this.bO.a(m2.b);
        }
    }

    public void b(Paint paint, float f2) {
        float f3 = this.e(f2);
        if (paint.k() != f3) {
            paint.b(f3);
        }
    }

    public void h(String string2) {
        this.a(string2, true);
    }

    public void a(String string2, boolean bl2) {
        this.dI = string2;
        if (this.dH != null) {
            this.dH.a(string2, bl2);
        }
    }

    public void Z() {
        this.dI = null;
    }

    public void i(String string2) {
        this.a(string2, 1);
    }

    public void a(String string2, int n2) {
        if (isPausedStatic2) {
            GameEngine.log("alert:" + string2);
        } else if (string2 == null) {
            GameEngine.g("Cannot show alert, no message text");
        } else {
            this.gameMode = string2;
            this.dD.a(this.a);
        }
        if (this.dH != null) {
            this.dH.a(string2, n2);
        }
    }

    public boolean aa() {
        if (this.dH != null) {
            return this.dH.c();
        }
        return false;
    }

    public void a(String string2, bb bb2) {
        String string3 = null;
        if (bb2 != null) {
            string3 = bb2.b();
        }
        this.c(string2, string3);
    }

    public void c(String string2, String string3) {
        if (this.dH != null) {
            this.dH.a(string2, string3);
        }
        if (isPausedStatic2) {
            if (this.dH == null) {
                GameEngine.b("showMessageBox: not showing due to non-android:" + string3);
            }
            return;
        }
        this.bp = true;
        this.dF = string2;
        this.dG = string3;
        this.dD.a(this.b);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ab() {
        Object object = this.dJ;
        synchronized (object) {
            if (this.dK != null) {
                this.c(this.dL, this.dK);
                this.dK = null;
                this.dL = null;
            }
        }
    }

    public void d(String string2, String string3) {
        this.dL = string2;
        this.dK = string3;
        if (isAndroidVersionStatic2) {
            this.ab();
            return;
        }
        l$3 l$3 = new l$3(this);
        l$3.start();
    }

    public boolean ac() {
        if (this.gameStarted) {
            return false;
        }
        if (this.ao.k() == null) {
            return false;
        }
        return this.ao.k().b();
    }

    public void ad() {
        if (this.ao.k() == null) {
            return;
        }
        this.ao.k().c();
    }

    public int ae() {
        if (this.gameStarted) {
            return 0;
        }
        return this.ao.k().a();
    }

    public float af() {
        return this.b(0);
    }

    public float ag() {
        return this.c(0);
    }

    public float b(int n2) {
        if (this.ao == null) {
            return 0.0f;
        }
        if (this.bQ.renderDoubleScale) {
            return this.ao.k().d()[n2] / 2.0f;
        }
        return this.ao.k().d()[n2];
    }

    public float c(int n2) {
        if (this.ao == null) {
            return 0.0f;
        }
        if (this.bQ.renderDoubleScale) {
            return this.ao.k().f()[n2] / 2.0f;
        }
        return this.ao.k().f()[n2];
    }

    public int d(int n2) {
        return this.ao.k().e()[n2];
    }

    public boolean e(int n2) {
        if (n2 != 1 && n2 != 2 && n2 != 3) {
            throw new RuntimeException("Unknown mouseButton:" + n2);
        }
        int n3 = this.f(n2);
        return n3 != -1;
    }

    public int f(int n2) {
        if (n2 == 0) {
            throw new RuntimeException("finding state of 0 doesn't make sense");
        }
        int[] nArray = this.ao.k().e();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n2)
                continue;
            return i2;
        }
        return -1;
    }

    public boolean g(int n2) {
        if (n2 >= this.c.length || n2 < 0) {
            return false;
        }
        if (this.c[n2] && this.d[n2]) {
            this.d[n2] = false;
            return true;
        }
        return false;
    }

    public boolean h(int n2) {
        if (n2 >= this.c.length || n2 < 0) {
            return false;
        }
        return this.c[n2];
    }

    public boolean a(int n2, boolean bl2) {
        boolean bl3 = true;
        boolean bl4 = true;
        int n3 = this.ah();
        if ((n2 & 2) != 0) {
            if ((n3 & 2) == 0) {
                bl3 = false;
            }
        } else if ((n3 & 2) != 0) {
            bl4 = false;
        }
        if ((n2 & 1) != 0) {
            if ((n3 & 1) == 0) {
                bl3 = false;
            }
        } else if ((n3 & 1) != 0) {
            bl4 = false;
        }
        if ((n2 & 4) != 0) {
            if ((n3 & 4) == 0) {
                bl3 = false;
            }
        } else if ((n3 & 4) != 0) {
            bl4 = false;
        }
        if (bl2) {
            return bl3;
        }
        return bl3 && bl4;
    }

    public boolean i(int n2) {
        boolean bl2 = true;
        if (n2 == 59 || n2 == 60) {
            return true;
        }
        if (n2 == 113 || n2 == 114) {
            return true;
        }
        return n2 == 57 || n2 == 58;
    }

    public static String j(int n2) {
        String string2 = "";
        if ((n2 & 2) != 0) {
            string2 = string2 + "shift+";
        }
        if ((n2 & 1) != 0) {
            string2 = string2 + "ctrl+";
        }
        if ((n2 & 4) != 0) {
            string2 = string2 + "alt+";
        }
        return string2;
    }

    public int ah() {
        int n2 = 0;
        if (this.h(59) || this.h(60)) {
            n2 += 2;
        }
        if (this.h(113) || this.h(114)) {
            ++n2;
        }
        if (this.h(57) || this.h(58)) {
            n2 += 4;
        }
        return n2;
    }

    public boolean c(int n2, int n3) {
        boolean bl2 = false;
        boolean bl3 = false;
        if (n2 >= 0 && n2 < this.c.length) {
            bl2 = this.c[n2];
        }
        if (n3 >= 0 && n3 < this.c.length) {
            bl3 = this.c[n3];
        }
        return bl2 || bl3;
    }

    public void b(int n2, boolean bl2) {
        if (n2 >= 0 && n2 < this.c.length) {
            this.c[n2] = bl2;
            if (bl2) {
                this.d[n2] = bl2;
            }
        } else {
            GameEngine.log("setKeyState: Key out of range:" + n2);
        }
    }

    public void k(int n2) {
        this.dN.add(new IndexedTimestampTracker(this, n2));
    }

    public int ai() {
        return this.e;
    }

    protected void aj() {
        this.e = 0;

        while (true) {
            while (true) {
                while (true) {
                    TimestampTracker var1 = (TimestampTracker) this.dN.poll();
                    if (var1 == null) {
                        return;
                    }

                    if (var1 instanceof ExtendedTimestampTracker) {
                        ExtendedTimestampTracker var3 = (ExtendedTimestampTracker) var1;
                        if (var3.c < this.c.length && var3.c >= 0) {
                            this.c[var3.c] = !var3.d;
                            this.d[var3.c] = !var3.d;
                        } else {
                            b("updateKeyState", "keyCode (" + var3.c + ") is out of range");
                        }
                    } else if (var1 instanceof IndexedTimestampTracker) {
                        IndexedTimestampTracker var2 = (IndexedTimestampTracker) var1;
                        this.e += var2.c;
                    }
                }
            }
        }
    }

    public static String j(String string2) {
        int n2 = string2.lastIndexOf("/");
        if (n2 == -1) {
            n2 = string2.length();
        }
        return string2.substring(0, n2);
    }

    public static String k(String string2) {
        int n2 = string2.lastIndexOf("/");
        n2 = n2 == -1 ? 0 : ++n2;
        return string2.substring(n2);
    }

    public static Integer l(String string2) {
        String string3 = GameEngine.k(string2);
        GameEngine.log("getMapLevel for :" + string2 + " file:" + string3);
        Pattern pattern = Pattern.compile("^l(\\d*);.*");
        Matcher matcher = pattern.matcher(string3);
        if (matcher.matches()) {
            GameEngine.log("getMapLevel:" + string2 + ":" + Integer.parseInt(matcher.group(1)));
            return Integer.parseInt(matcher.group(1));
        }
        return null;
    }

    public static String m(String string2) {
        String string3;
        String[] stringArray;
        GameEngine l2 = GameEngine.getInstance();
        Integer n2 = GameEngine.l(string2);
        if (n2 == null) {
            return null;
        }
        int n3 = string2.lastIndexOf("/");
        if (n3 == -1) {
            n3 = string2.length();
        }
        if ((stringArray = com.corrodinggames.rts.gameFramework.storage.a.a(string3 = string2.substring(0, n3),
                true)) == null) {
            return null;
        }
        for (String string4 : stringArray) {
            Integer n4 = GameEngine.l(string4);
            if (n4 == null || n4 <= n2
                    || l2.isGamePaused && !com.corrodinggames.rts.appFramework.i.a(string4, string3 + "/" + string4))
                continue;
            return string3 + "/" + string4;
        }
        return null;
    }

    public String ak() {
        return this.menuBackgroundMapFile;
    }

    public String al() {
        String string2 = this.menuBackgroundMapFile;
        if ((this.menuBackgroundMapFile == null || "".equals(this.menuBackgroundMapFile)) && this.N()) {
            string2 = this.networkEngine.l();
        }
        return com.corrodinggames.rts.appFramework.i.e(com.corrodinggames.rts.appFramework.i.d(string2));
    }

    public String am() {
        return com.corrodinggames.rts.appFramework.i.d(this.menuBackgroundMapFile);
    }

    public GameModeType an() {
        if (com.corrodinggames.rts.appFramework.i.g(this.menuBackgroundMapFile)) {
            return GameModeType.customMap;
        }
        return GameModeType.skirmishMap;
    }

    public static String a(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        String string2 = ((Object) stringWriter).toString();
        printWriter.close();
        return string2;
    }

    public static String b(Throwable throwable) {
        Object object;
        String string2 = throwable.getMessage();
        if (string2 == null) {
            string2 = throwable.getClass().getName();
        } else {
            string2 = string2.replace("java.lang.RuntimeException: ", "");
            string2 = string2.replace("java.lang.RuntimeException: ", "");
        }
        Object object2 = throwable;
        while (object2 != null && (object = ((Throwable) object2).getCause()) != null && object != throwable
                && object != object2) {
            object2 = object;
        }
        object = null;
        if (object2 != null && object2 != throwable) {
            String string3;
            object = ((Throwable) object2).getMessage();
            if (object == null) {
                object = object2.getClass().getName();
            }
            if (!((String) object).equals(string3 = string2)) {
                string2 = string2 + " caused by (" + (String) object + ")";
            }
        }
        return string2;
    }

    public static File ao() {
        com.corrodinggames.rts.gameFramework.storage.a.d();
        String string2 = "/SD/rustedWarfare/crashes.txt";
        if (GameEngine.at()) {
            string2 = "/SD/rustedWarfare/crashes.txt";
        }
        String string3 = com.corrodinggames.rts.gameFramework.storage.a.e(string2);
        File file = new File(string3);
        return file;
    }

    public static void e(String string2, String string3) {
        File file = GameEngine.ao();
        try {
            OutputStream outputStream = com.corrodinggames.rts.gameFramework.storage.a.a(file, true);
            PrintWriter printWriter = new PrintWriter(outputStream);
            String string4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
            printWriter.write("\r\n" + string2 + " (at " + string4 + " - " + "1.15" + "" + ")\n");
            printWriter.write(string3 + "\r\n");
            printWriter.close();
        } catch (Throwable throwable) {
            GameEngine.log("Exception in writeCrashToFile");
            throwable.printStackTrace();
        }
    }

    public static void ap() {
        if (!at) {
            return;
        }
        if (isPausedStatic2) {
            return;
        }
        if (dS != null) {
            GameEngine.b("setupANRWatchDog: activeANRWatchDog!=null");
            return;
        }
        dS = new d(4000);
        dS.a(new l$4());
        dS.start();
        GameEngine.b("setupANRWatchDog: running");
    }

    public static void aq() {
        if (dP == null && GameEngine.av()) {
            dP = new byte[2500000];
            GameEngine.dP[0] = 2;
            GameEngine.dP[GameEngine.dP.length - 1] = 5;
        }
        if (isPausedStatic) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread()
                    .getUncaughtExceptionHandler();
            if (!(uncaughtExceptionHandler instanceof com.corrodinggames.rts.gameFramework.CustomExceptionHandler)) {
                Thread.currentThread().setUncaughtExceptionHandler(
                        new com.corrodinggames.rts.gameFramework.CustomExceptionHandler(uncaughtExceptionHandler));
            }
        } else {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(uncaughtExceptionHandler instanceof com.corrodinggames.rts.gameFramework.CustomExceptionHandler)) {
                Thread.setDefaultUncaughtExceptionHandler(
                        new com.corrodinggames.rts.gameFramework.CustomExceptionHandler(uncaughtExceptionHandler));
            }
        }
    }

    public abstract int getUnitChecksum();

    public boolean ar() {
        return true;
    }

    public boolean as() {
        return true;
    }

    public static void n(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2 != null) {
            if (++dU < 1000) {
                GameEngine.b("reportProblem: " + string2);
            }
            if (dU < 10) {
                l2.a(string2, 1);
            }
        }
    }

    public static boolean at() {
        return !isPausedStatic2;
    }

    public static boolean au() {
        return !isAndroidVersionStatic2 || isDebugVersionStatic2;
    }

    public static boolean av() {
        return isAndroidVersionStatic2 && !isDebugVersionStatic2;
    }

    public static boolean aw() {
        return isAndroidVersionStatic2 && !isDebugVersionStatic2;
    }

    public static boolean ax() {
        return isPausedStatic2 && !isAndroidVersionStatic2;
    }

    public boolean ay() {
        return this.networkEngine.B || this.cb.j();
    }

    public void a(com.corrodinggames.rts.game.units.BaseUnit am2, float f2) {
        this.bW.a((int) am2.posX, (int) am2.posY, f2, am2);
        this.bS.i.c(am2);
    }

    public static boolean az() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2 != null && l2.bQ.teamShaders && (l2.bQ.newRender || !GameEngine.at())) {
            return true;
        }
        return isGameMinimizedStatic2;
    }

    public static boolean aA() {
        GameEngine l2 = GameEngine.getInstance();
        // GameEngine.e("1" + (l2 != null) + "2" + l2.bQ.shaderEffects + "3" + (l2.bQ.newRender || !GameEngine.at()));
        if (l2 != null && l2.bQ.shaderEffects && (l2.bQ.newRender || !GameEngine.at())) {
            return true;
        }
        // try {
        //     throw new Exception("打印堆栈");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        return isGamePausedStatic2;
    }

    public static boolean aB() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2 != null && l2.bQ.shaderEffects && (l2.bQ.newRender || !GameEngine.at())) {
            return true;
        }
        return isGamePausedStatic2;
    }

    public abstract int getScreenHeight();

    public static void aC() {
        System.out.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());
        long l2 = Runtime.getRuntime().maxMemory();
        System.out.println("Maximum memory (bytes): " + (l2 == Long.MAX_VALUE ? "no limit" : Long.valueOf(l2)));
        System.out.println("Total memory (bytes): " + Runtime.getRuntime().totalMemory());
    }

    public Context aD() {
        return this.am;
    }

    public static void f(String string2, String string3) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2 == null) {
            return;
        }
        String string4 = string3;
        if (l2.bS != null && l2.bS.h != null) {
            l2.bS.h.a(string2, string4);
        } else {
            GameEngine.g("addMessage: interfaceEngine/messageInterface==null");
        }
    }

    public static void a(AssetType u2, Throwable throwable) {
        dQ = null;
        GameEngine.log("reportCaughtOutOfMemory:" + (Object) ((Object) dW));
        if (dW != null) {
            return;
        }
        dW = u2;
        if (throwable != null) {
            GameEngine.c(throwable);
        }
        GameEngine.aC();
    }

    public static void c(Throwable throwable) {
        try {
            throwable.printStackTrace();
        } catch (Throwable throwable2) {
            GameEngine.log("Failed to print stacktrace");
        }
    }

    public void aE() {
        String string2;
        if (gameModeMultiplayer && !gameModeSinglePlayer) {
            gameModeSinglePlayer = true;
            string2 = "Warning game has less than 5mb of free space remaining. A larger battle might cause a crash. ";
            int n2 = this.bZ.h();
            if (n2 > 1) {
                string2 = string2 + "This is often caused by large mods, you currently have: " + n2 + " mods loaded. ";
            }
            this.c("Warning: Low memory detected", string2);
        }
        if (!dV && dW != null) {
            GameEngine.log("Showing out of memory message");
            dV = true;
            string2 = "";
            String string3 = "trying to load data";
            if (dW == AssetType.gameImage) {
                string3 = "trying to load game textures";
            } else if (dW == AssetType.gameImageCreate) {
                string3 = "trying to create a texture";
            } else if (dW == AssetType.gameImageColor) {
                string3 = "trying to colour new texture";
            } else if (dW == AssetType.gameImageFogBuffer) {
                string3 = "trying to create texture buffer for on-screen fog fading";
            } else if (dW == AssetType.gameFont) {
                string3 = "trying to create game fonts";
            } else if (dW == AssetType.gameSound) {
                string3 = "trying to load game sounds";
            } else if (dW == AssetType.uiImage) {
                string3 = "trying to load UI textures";
            }
            string2 = "The game ran out of memory " + string3 + ". ";
            int n3 = this.bZ.h();
            if (n3 > 1) {
                string2 = string2 + "This is often caused by large mods, you currently have: " + n3 + " mods. ";
            }
            if (GameEngine.av() && !com.corrodinggames.rts.game.GameLogic.is64Bit) {
                string2 = string2
                        + "You are also using the 32 bit version, switching to the 64 bit version might help. ";
            }
            this.c("Warning: Out Of Memory", string2);
        }
    }

    public void aF() {
        try {
            byte[] byArray = new byte[5000000];
            byArray[0] = this.dZ;
            this.ea = byArray[1];
            byArray = null;
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            GameEngine.log("Low memory detected");
            outOfMemoryError.printStackTrace();
            gameModeMultiplayer = true;
        }
    }

    public void a(Runnable runnable) {
        this.ec.a(runnable);
    }

    public final boolean a(float f2, float f3, float f4) {
        return this.cM.left < f2 + f4 && f2 - f4 < this.cM.c && this.cM.b < f3 + f4 && f3 - f4 < this.cM.d;
    }

    public abstract boolean isExtraSafeModeEnabled();

    public abstract boolean isExtraSafeMode2Enabled();

    public static boolean o(String string2) {
        if (platformName == null) {
            return false;
        }
        return platformName.contains(string2);
    }

    public static void p(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        NetworkEngine ad2 = l2.networkEngine;
        String string3 = "" + string2;
        GameEngine.b(string3);
        GameEngine.T();
        if (++ej < 10) {
            String string4 = string3;
            if (ad2 != null) {
                ad2.m(string4);
            }
        }
    }

    public void a(f f2, c c2) {
        this.cg = new com.corrodinggames.rts.gameFramework.g.a(f2, c2);
        this.cg.a();
    }

    static {
        aw = false;
        ax = false;
        isNetworkGameActiveStatic = false;
        isNetworkConnectedStatic = false;
        buildVersion = null;
        isGameThreadRunningStatic = false;
        isGamePausedStatic2 = false;
        isGameMinimizedStatic2 = false;
        isGamePausedOrMinimizedStatic2 = false;
        isNetworkGameActiveStatic2 = false;
        platformName = null;
        aT = false;
        isPausedStatic2 = false;
        aV = false;
        isAndroidVersionStatic2 = false;
        isIOSVersionStatic2 = false;
        isPCVersionStatic2 = false;
        isDebugVersionStatic2 = false;
        androidVersion = null;
        isSandboxModeStatic2 = false;
        bc = true;
        bd = true;
        be = false;
        bf = false;
        dz = Build.VERSION.RELEASE;
        dO = false;
        dQ = new byte[1000];
        dR = new byte[1000];
        dT = false;
        dU = 0;
        dW = null;
    }
}
