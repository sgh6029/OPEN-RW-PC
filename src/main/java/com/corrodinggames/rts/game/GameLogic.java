/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.os.Debug
 *  android.util.DisplayMetrics
 */
package com.corrodinggames.rts.game;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Debug;
import android.util.DisplayMetrics;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.SettingsEngine;
import com.corrodinggames.rts.gameFramework.aa;
import com.corrodinggames.rts.gameFramework.ac;
import com.corrodinggames.rts.gameFramework.MusicManager;
import com.corrodinggames.rts.gameFramework.ReplayEngine;
import com.corrodinggames.rts.gameFramework.GameStateManager;
import com.corrodinggames.rts.gameFramework.GameStateData;
import com.corrodinggames.rts.gameFramework.GameStatistics;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.ProfilerSection;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.x;
import com.corrodinggames.rts.gameFramework.m.z;
import com.corrodinggames.rts.gameFramework.utility.o;
import com.corrodinggames.rts.gameFramework.utility.s;
import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameLogic
        extends GameEngine {
    public static String gameVersionName; // a -> gameVersionName
    public static boolean is64Bit; // b -> is64Bit
    public static boolean isSandboxEnabled; // c -> isSandboxEnabled
    int someCounter; // d -> someCounter
    public float densityScaleMultiplier = 1.0f; // e -> densityScaleMultiplier
    public static String safeModeReason; // f -> safeModeReason
    k[] g = new k[6]; // g -> someKArray
    String h; // h -> someString
    public boolean i = false; // i -> someBoolean
    public int j = 0; // j -> someInteger
    public ConcurrentLinkedQueue k = new ConcurrentLinkedQueue(); // k -> concurrentLinkedQueue
    Paint l; // l -> paintL
    Paint m; // m -> paintM
    Paint n; // n -> paintN
    Paint o; // o -> paintO
    Paint p; // p -> paintP
    int q = 0; // q -> intQ
    int r = 0; // r -> intR
    int s = 0; // s -> intS
    float t = 16.0f; // t -> floatT
    public String u = "0fps"; // u -> stringU
    Rect v = new Rect(); // v -> rectV
    public ArrayList w = new ArrayList(); // w -> arrayListW
    Paint x; // x -> paintX
    Paint y; // y -> paintY
    Paint z; // z -> paintZ
    public Paint A = new Paint(); // A -> paintA
    public GameStateData gameStateData; // B -> gameStateData
    public GameStateManager gameStateManager; // C -> gameStateManager
    public com.corrodinggames.rts.gameFramework.effect.b D = new com.corrodinggames.rts.gameFramework.effect.b(); // D -> cloudRenderer
    com.corrodinggames.rts.game.GameObject E; // E -> gameObjectE
    boolean F; // F -> booleanF
    float G = 0.0f; // G -> floatG
    public float H = 1.0f; // H -> floatH
    public float I; // I -> floatI
    public float J; // J -> floatJ
    com.corrodinggames.rts.game.j K; // K -> jK
    com.corrodinggames.rts.game.j L; // L -> jL
    boolean M; // M -> booleanM
    com.corrodinggames.rts.gameFramework.m.y graphicsEngine; // N -> graphicsEngine
    com.corrodinggames.rts.gameFramework.m.Texture_M O; // O -> textureO
    com.corrodinggames.rts.gameFramework.m.Texture_M P; // P -> textureP
    com.corrodinggames.rts.gameFramework.m.Texture_M Q; // Q -> textureQ
    float R = 0.0f; // R -> floatR
    Rect S = new Rect(); // S -> rectS
    RectF T = new RectF(); // T -> rectFT
    public com.corrodinggames.rts.gameFramework.m.Texture_M U = null; // U -> textureU
    public com.corrodinggames.rts.gameFramework.m.Texture_M V = null; // V -> textureV
    s W = new s("allOnScreenObjects"); // W -> sW
    s X = new s("allOnScreenObjectsDirty"); // X -> sX
    Matrix Y = new Matrix(); // Y -> matrixY
    public ArrayList Z = new ArrayList(); // Z -> arrayListZ
    public ArrayList aa = new ArrayList(); // aa -> arrayListAA
    Timer ab; // ab -> timerAB
    boolean ac; // ac -> booleanAC
    Object ad = new Object(); // ad -> objectAD
    int ae = 0; // ae -> intAE
    com.corrodinggames.rts.game.units.BaseUnit af; // af -> baseUnitAF
    com.corrodinggames.rts.game.units.BaseUnit ag; // ag -> baseUnitAG
    float ah; // ah -> floatAH
    boolean ai; // ai -> booleanAI

    public GameLogic(Context context) {
        super(context);
    }

    @Override
    public boolean isNetworkGameActive() { // a -> isNetworkGameActive
        if (this.bS.u) {
            return true;
        }
        return (this.dH != null && this.dH.b());
    }

    @Override
    public boolean canProcessGameLogic(boolean bl2) { // a -> canProcessGameLogic
        if (!bl2 || this.cb.j()) {
            if (this.bS.u) {
                return true;
            }
            if (this.bp) {
                return true;
            }
            if (this.gameStarted && !this.bH) {
                return true;
            }
            if (this.exitGameThread && this.dH != null && this.dH.b()) {
                return true;
            }
        }
        if (bl2 && !this.networkEngine.aW) {
            return true;
        }
        return this.networkEngine.I();
    }

    @Override
    public int getScreenHeight() { // b -> getScreenHeight
        return this.s;
    }

    @Override
    public boolean isExtraSafeModeEnabled() { // c -> isExtraSafeModeEnabled
        return this.eh;
    }

    @Override
    public boolean isExtraSafeMode2Enabled() { // d -> isExtraSafeMode2Enabled
        return this.ei;
    }

    @Override
    public synchronized void initializeEngine(Context context) throws IOException { // a -> initializeEngine
        Log.d("RustedWarfare", "--- ----------------- ----");
        Log.d("RustedWarfare", "--- GameEngine:init() ----");
        Log.d("RustedWarfare", "--- ----------------- ----");
        if (this.isGameModePaused) {
            Log.d("RustedWarfare", "GameEngine init has already been called");
            return;
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("Version:" + this.getFullVersionString());
        if (com.corrodinggames.rts.game.GameLogic.C() && this.getClass().equals(GameLogic.class)) {
            throw new RuntimeException("inSpace but class is:" + this.getClass());
        }
        System.gc();
        this.h("Asset Index");
        this.bK = new com.corrodinggames.rts.gameFramework.utility.AssetIndex(context);
        long l2 = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();
        this.cd = new PerformanceProfiler(this);
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.C);
        if (isPausedStatic2) {
            this.ci = 1.0f;
        } else {
            DisplayMetrics displayMetrics = context.e().getDisplayMetrics();
            this.ci = context.e().getDisplayMetrics().density;
            com.corrodinggames.rts.gameFramework.GameEngine.log("densityScaleRaw: " + this.ci);
            this.setScreenSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        this.ci *= this.densityScaleMultiplier;
        com.corrodinggames.rts.gameFramework.GameEngine.log("densityScaleRaw*densityScaleMultiplier: " + this.ci);
        if (com.corrodinggames.rts.gameFramework.GameEngine.b(context)) {
            this.isGamePaused = true;
        }
        this.E = new com.corrodinggames.rts.game.b_f1();
        this.bo = false;
        this.h("InputController");
        this.bT = new ac();
        this.bT.a();
        this.h("SettingsEngine");
        this.bQ = SettingsEngine.getInstance(context);
        this.bQ.loadMainExternalFolder(true);
        com.corrodinggames.rts.gameFramework.storage.a.b();
        int n2 = 3;
        if (isDebugVersionStatic2) {
            n2 = 1;
        }
        if (this.bQ.numIncompleteLoadAttempts > 1 || this.bQ.numLoadsSinceRunningGameOrNormalExit > n2) {
            this.ee = true;
            if (this.bQ.numIncompleteLoadAttempts > 2 || this.bQ.numLoadsSinceRunningGameOrNormalExit > 4) {
                this.bQ.forceEnglish = true;
                this.ef = true;
            }
            if (this.bQ.numIncompleteLoadAttempts > 3) {
                this.bQ.newRender = false;
            }
            if (this.bQ.numIncompleteLoadAttempts > 4 || this.bQ.numLoadsSinceRunningGameOrNormalExit > 5) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Extra safe mode");
                this.eh = true;
            }
            if (this.bQ.numIncompleteLoadAttempts > 5) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Extra safe mode x2");
                this.ei = true;
            }
            if (this.bQ.numIncompleteLoadAttempts > 6) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Extra safe mode x3");
                this.bQ.newRender = false;
                this.bQ.shaderEffects = false;
                this.bQ.teamShaders = false;
            }
            if (this.bQ.newRender && this.bQ.numLoadsSinceRunningGameOrNormalExit > 15) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Disabling opengl mode");
                this.bQ.newRender = false;
            }
            com.corrodinggames.rts.gameFramework.GameEngine
                    .log("starting game in safe mode, numIncompleteLoadAttempts:" + this.bQ.numIncompleteLoadAttempts
                            + " numLoadsSinceRunningGameOrNormalExit:" + this.bQ.numLoadsSinceRunningGameOrNormalExit);
        }
        if (isGamePausedOrMinimizedStatic2) {
            this.ee = true;
            this.eg = "<forced by command line>";
        }
        if (isNetworkGameActiveStatic2) {
            this.ee = true;
            this.eh = true;
            this.ei = true;
            this.eg = "<forced by command line>";
        }
        ++this.bQ.numLoadsSinceRunningGameOrNormalExit;
        ++this.bQ.numIncompleteLoadAttempts;
        boolean bl2 = this.bQ.save();
        if (!bl2 && isDebugVersionStatic2) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("starting game in safe mode, failed to save settings");
            this.eg = "failing to write preferences data";
            this.ee = true;
        }
        com.corrodinggames.rts.gameFramework.c.a.a();
        this.cj = this.W();
        com.corrodinggames.rts.gameFramework.GameEngine.log("densityScale(): " + this.cj);
        long l3 = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();
        com.corrodinggames.rts.gameFramework.h.a.a();
        com.corrodinggames.rts.gameFramework.PerformanceProfiler.a("Locale.init took:", l3);
        com.corrodinggames.rts.game.PlayerTeam.L();
        this.l = new Paint();
        this.m = new Paint();
        this.m.a(255, 255, 255, 255);
        this.m.a(true);
        this.a(this.m, 16.0f);
        this.n = new Paint();
        this.n.a(255, 255, 255, 255);
        this.n.a(true);
        this.a(this.n, 16.0f);
        this.o = new Paint();
        this.o.a(100, 255, 0, 0);
        this.a(this.o, 16.0f);
        this.p = new Paint();
        this.p.a(100, 0, 255, 0);
        this.a(this.p, 16.0f);
        this.dn = new Paint();
        this.do_ = new Paint();
        this.do_.a(Paint$Align.b);
        this.do_.a(true);
        this.do_.a(Typeface.a(Typeface.c, 0));
        this.a(this.do_, 16.0f);
        this.dp = new Paint();
        this.dp.a(255, 230, 255, 230);
        this.dp.a(true);
        this.dp.a(Paint$Align.b);
        this.a(this.dp, 18.0f);
        this.x = new Paint();
        this.x.b(-1);
        this.x.c(100);
        this.y = new Paint();
        this.y.b(-7829368);
        this.y.c(240);
        this.y.a(Paint$Style.b);
        this.y.a(1.0f);
        long l4 = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();
        this.h("AudioEngine");
        com.corrodinggames.rts.gameFramework.sound.e.b();
        this.bM = new com.corrodinggames.rts.gameFramework.sound.e();
        this.bM.a(context);
        com.corrodinggames.rts.gameFramework.PerformanceProfiler.a("AudioEngine took:", l4);
        this.h("MusicController");
        this.bN = new MusicManager();
        this.bN.a(context);
        if (bh != null) {
            com.corrodinggames.rts.game.GameLogic.log("init(): using Graphics instance");
            this.bO = bh;
        } else if (bg != null) {
            com.corrodinggames.rts.game.GameLogic.log("init(): using GraphicsSlick2d");
            try {
                this.bO = (com.corrodinggames.rts.gameFramework.m.y) bg.newInstance();
            } catch (InstantiationException instantiationException) {
                throw new RuntimeException(instantiationException);
            } catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
        } else {
            this.bO = isPausedStatic2 ? new z() : new x();
        }
        this.h("graphics.init");
        this.bO.a(context);
        this.bO.b();
        com.corrodinggames.rts.gameFramework.FileChangeEngine.a();
        this.h("Fonts");
        this.Y();
        this.h("effects.init");
        this.bR = new com.corrodinggames.rts.gameFramework.effect.c();
        this.bR.a(context);
        this.h("minimapHandler");
        this.bW = new com.corrodinggames.rts.gameFramework.f.o();
        this.bW.a(context);
        if (ck != null) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .log("We have an initial screen size, can do early setup of image buffers");
            this.h("Map Buffers");
            this.updateCameraPosition(com.corrodinggames.rts.game.GameLogic.ck.x, com.corrodinggames.rts.game.GameLogic.ck.b);
            this.updateCameraSystem();
            com.corrodinggames.rts.game.b.TileMap.d();
            com.corrodinggames.rts.game.b.TileMap.f();
            this.bW.e();
            boolean bl3 = com.corrodinggames.rts.gameFramework.GameEngine.aA();
            if (bl3) {
                this.h("Setting up postprocessing");
                boolean bl4 = this.setupPostprocessing();
                if (!bl4) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Failed to setup postprocessing");
                }
            }
        }
        this.h("PathEngine");
        this.bU = new com.corrodinggames.rts.gameFramework.k.l();
        this.h("GroupController");
        this.bV = new aa();
        this.h("CollisionEngine");
        this.bP = new com.corrodinggames.rts.gameFramework.a();
        this.h("InterfaceEngine");
        this.bS = new g();
        this.bS.a(context);
        this.gameStateManager = com.corrodinggames.rts.gameFramework.GameStateManager.c(context);
        this.h("NetworkEngine");
        this.networkEngine = new NetworkEngine();
        this.networkEngine.F();
        this.h("StatsHandler");
        this.bY = new GameStatistics();
        this.h("ModEngine");
        this.bZ = new com.corrodinggames.rts.gameFramework.i.a();
        this.bZ.a();
        if (this.ee) {
            this.bZ.g();
        }
        this.h("CommandController");
        this.cf = new com.corrodinggames.rts.gameFramework.CommandQueue();
        this.h("GameSaver");
        this.ca = new com.corrodinggames.rts.gameFramework.GameSaver();
        this.h("ReplayEngine");
        this.cb = new ReplayEngine();
        this.cb.a(context);
        this.h("UnitGeoIndex");
        this.cc = new com.corrodinggames.rts.game.units.f.c();
        this.h("Precalculating map fog");
        com.corrodinggames.rts.game.b.TileMap.c();
        this.h("ScorchMark.load");
        com.corrodinggames.rts.game.l.b();
        this.h("Projectile.load");
        com.corrodinggames.rts.game.f.c();
        this.h("Emitter.load");
        com.corrodinggames.rts.gameFramework.effect.f.b();
        this.h("Unit.loadAllUnits");
        long l5 = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();
        com.corrodinggames.rts.game.units.BaseUnit.bH();
        com.corrodinggames.rts.gameFramework.PerformanceProfiler.a("loadAllUnits took:", l5);
        this.h("Loading custom unit data");
        long l6 = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();
        com.corrodinggames.rts.game.units.custom.ag.h();
        this.h("getAllUnitsChecksum");
        com.corrodinggames.rts.gameFramework.PerformanceProfiler.a("CustomUnits took:", l6);
        long l7 = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();
        this.someCounter = com.corrodinggames.rts.game.units.BaseUnit.bM();
        com.corrodinggames.rts.gameFramework.PerformanceProfiler.a("allUnitsChecksum took:", l7);
        this.z = new Paint();
        this.z.a(50, 255, 255, 255);
        this.F();
        System.gc();
        this.isGameModePaused = true;
        com.corrodinggames.rts.gameFramework.GameEngine.log("Init completed");
        com.corrodinggames.rts.gameFramework.PerformanceProfiler.a("Loading took:", l2);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.C);
        this.cd.a(true, true);
        long l8 = com.corrodinggames.rts.gameFramework.PerformanceProfiler.a();
        this.h("Loading map data");
        if (!com.corrodinggames.rts.gameFramework.GameEngine.noBackground) {
            this.loadMenuBackground();
        }
        com.corrodinggames.rts.gameFramework.PerformanceProfiler.a("loadAMenuMap took:", l8);
        this.h("Last setup");
        com.corrodinggames.rts.game.GameLogic.ap();
        this.networkEngine.m();
        this.h("init complete");
        if (isGamePausedStatic) {
            com.corrodinggames.rts.game.units.UnitTypeEnum.s();
            System.exit(0);
        }
        if (isGameMinimizedStatic) {
            com.corrodinggames.rts.game.units.UnitTypeEnum.r();
            System.exit(0);
        }
        this.isGameMinimized = true;
    }

    public void setScreenSize(int n2, int n3) { // a -> setScreenSize
        float f2 = 1.0f;
        float f3 = com.corrodinggames.rts.gameFramework.GameUtils.b(0.0f, 0.0f, (float) n2, (float) n3);
        float f4 = 1131.0f;
        f2 = f3 / f4;
        com.corrodinggames.rts.gameFramework.GameEngine.log("defaultViewpointZoomDensity: " + f2);
        if (f2 < 0.5f) {
            f2 = 0.5f;
        }
        if (f2 > 3.0f) {
            f2 = 3.0f;
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("defaultViewpointZoomDensity after limit: " + f2);
        this.cY = 1.0f;
        if ((double) com.corrodinggames.rts.gameFramework.GameUtils.c(f2 - 1.0f) > 0.1) {
            this.cY = f2;
            if (this.cY > 2.0f) {
                this.cY = 2.0f;
            }
            if (this.cY < 0.5f) {
                this.cY = 0.5f;
            }
            this.cX = this.cV * this.cY;
        }
    }

    @Override
    public void e() { // e -> resetGameState
        this.K();
        this.f();
    }

    public void f() { // f -> resetGameFlags
        this.cleanupGameState(false);
        this.loadNewGame = false;
        this.bH = false;
        this.exitGameThread = false;
        this.bp = false;
        this.bS.u = false;
    }

    @Override
    public synchronized void startGame(boolean bl2, com.corrodinggames.rts.gameFramework.GameMode s2) { // a -> startGame
        this.K();
        this.initializeAndStartGame(bl2, false, s2);
    }

    /**
     * 初始化并启动游戏
     * 
     * @param paramBoolean1 是否为单人游戏模式
     * @param paramBoolean2 是否为加载游戏状态（true表示从存档加载，false表示新游戏）
     * @param gameMode      游戏启动场景类型（如正常游戏、菜单、保存游戏等）
     */
    @Override
    public void initializeAndStartGame(boolean paramBoolean1, boolean paramBoolean2,
            com.corrodinggames.rts.gameFramework.GameMode gameMode) { // a -> initializeAndStartGame
        try {
            // === 基础设置初始化 ===
            // 设置单位容量限制
            this.bC = this.bQ.teamUnitCapSinglePlayer;
            if (this.bC < 1) {
                this.bC = 1; // 确保最小单位容量为1
            }
            this.bB = this.bC;

            // 调用初始化方法
            cleanupGameState(paramBoolean2);

            // 初始化玩家队伍系统
            com.corrodinggames.rts.game.PlayerTeam.X();

            // === 游戏状态标志重置 ===
            this.bo = false; // 重置游戏结束标志
            System.gc(); // 触发垃圾回收

            // 设置游戏状态标志
            this.bI = true; // 游戏初始化中
            this.loadNewGame = false; // 重置游戏运行标志
            this.bp = false; // 重置暂停标志
            this.exitGameThread = false; // 重置其他状态标志
            this.by = 0; // 重置计数器
            this.ch = false; // 重置完成标志

            // 初始化游戏引擎
            this.networkEngine.a(1L);

            // === 计数器和工具初始化 ===
            this.bx = 0; // 重置游戏时钟
            this.unitLimit = 0; // 重置随机种子
            com.corrodinggames.rts.gameFramework.GameUtils.a(); // 初始化游戏工具

            this.networkEngine.t(); // 执行引擎初始化

            // === 新游戏特定初始化 ===
            if (!paramBoolean2) { // 如果不是加载游戏（新游戏）
                this.dq = false; // 重置任务标志
                this.dr = false; // 重置完成标志
                this.ds = 0.0F; // 重置进度
                this.du = false; // 重置解锁标志
                this.dt = false; // 重置教程标志
            }

            this.j = 0; // 重置帧计数器

            if (!paramBoolean2) {
                this.cV = 1.0F; // 设置初始视角位置
            }

            this.dx = 0.0F; // 重置其他位置值

            // === 自定义内容加载 ===
            if (!this.cb.j()) {
                if (!this.networkEngine.B) {
                    com.corrodinggames.rts.game.units.custom.ag.b(true); // 加载单人游戏自定义内容
                } else {
                    com.corrodinggames.rts.game.units.custom.ag.d(); // 加载多人游戏自定义内容
                }
            }

            // === 玩家和AI控制器设置 ===
            if (!this.networkEngine.B) { // 如果不是网络游戏
                if (!this.cb.j() && paramBoolean1) { // 如果是单人游戏且不是重放
                    this.bs = new com.corrodinggames.rts.game.e(0); // 创建玩家队伍
                    this.bs.v = "Player"; // 设置玩家名称

                    // 为其他队伍创建AI控制器
                    for (int i = 1; i < 8; i++) {
                        new com.corrodinggames.rts.game.a.AIController(i);
                    }

                    this.networkEngine.aq(); // 初始化AI系统
                }
            } else { // 网络游戏
                this.bs = this.networkEngine.z; // 获取网络玩家队伍
                if (this.bs == null) {
                    throw new RuntimeException("cannot find player's team");
                }
                // 检查队伍状态一致性
                if (this.bs != com.corrodinggames.rts.game.PlayerTeam.k(this.bs.k)) {
                    com.corrodinggames.rts.gameFramework.GameEngine.g("Stale playerTeam");
                }
            }

            // === 地图加载 ===
            this.ce = null; // 重置当前实体
            this.bL = new com.corrodinggames.rts.game.b.TileMap(); // 创建新的地图对象

            java.io.InputStream inputStream = null;
            try {
                // 根据是否有自定义地图选择加载方式
                if (this.dm != null) {
                    inputStream = this.dm.w(); // 获取自定义地图流
                    try {
                        inputStream.reset();
                        this.bL.a(inputStream, paramBoolean2); // 加载自定义地图
                    } catch (java.io.IOException iOException) {
                        iOException.printStackTrace();
                    }
                } else {
                    this.bL.a(ak(), paramBoolean2); // 加载默认地图
                }
            } catch (com.corrodinggames.rts.game.b.MapLoadException f) {
                // 地图加载失败处理
                f.printStackTrace();
                String str = "Error loading map: " + f.getMessage();
                a(str, 1); // 显示错误信息

                // 自动化测试环境下直接崩溃
                if (aT) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .log("Crashing on allowed map error because automated testing is active");
                    throw new RuntimeException(f);
                }

                // 非网络游戏下返回菜单
                if (!this.networkEngine.B) {
                    if (this.ao != null) {
                        com.corrodinggames.rts.appFramework.g g1 = this.ao.i();
                        if (g1 != null) {
                            g1.m(); // 返回主菜单
                        }
                    }
                }

                String str2 = a(f);
                e("Map Load Warning", str2); // 显示警告

                this.bI = false; // 标记初始化失败
                return; // 退出初始化
            }

            // 检查地图是否成功加载
            if (!this.bL.W) {
                log("map did not load, returning");
                this.bI = false;
                return;
            }

            this.bL.G = false; // 禁用地图网格显示
            com.corrodinggames.rts.game.PlayerTeam.e(); // 初始化队伍系统

            // === 队伍初始化 ===
            for (int i = 0; i < com.corrodinggames.rts.game.PlayerTeam.c; i++) {
                com.corrodinggames.rts.game.PlayerTeam n = com.corrodinggames.rts.game.PlayerTeam.k(i);
                if (n != null) {
                    n.J(); // 初始化每个队伍
                }
            }

            // === 新游戏的额外初始化 ===
            if (!paramBoolean2) {
                com.corrodinggames.rts.game.units.custom.l.F(); // 重置自定义单位
            }

            // === 随机种子设置 ===
            if (!this.networkEngine.B && !this.cb.j()) {
                this.networkEngine.ay.h = 16256.0F;
                this.networkEngine.ay.q = com.corrodinggames.rts.gameFramework.GameUtils.a(1, 1000000000); // 生成随机种子
            }

            this.unitLimit = this.networkEngine.ay.q; // 保存全局种子
            log("global Seed: " + this.unitLimit); // 日志输出种子

            // === 网络游戏或重放的特定设置 ===
            if (this.networkEngine.B || this.cb.j()) {
                if (!this.networkEngine.F) {
                    this.bB = this.networkEngine.aw; // 设置单位容量
                    this.bC = this.networkEngine.ax;
                }

                com.corrodinggames.rts.gameFramework.GameEngine.log("Unit cap is now: " + this.bC);

                // 根据设置配置战争迷雾
                switch (this.networkEngine.ay.d) {
                    case 0: // 无迷雾
                        this.bL.E = false;
                        this.bL.F = false;
                        break;
                    case 1: // 部分迷雾
                        this.bL.E = true;
                        this.bL.F = false;
                        break;
                    case 2: // 完全迷雾
                        this.bL.E = true;
                        this.bL.F = true;
                        break;
                }

                this.bL.G = this.networkEngine.ay.e; // 设置网格显示

                // 初始化战争迷雾
                int i = 10;
                if (this.networkEngine.ay.e) {
                    i = 10;
                }

                for (int j = 0; j < com.corrodinggames.rts.game.PlayerTeam.c; j++) {
                    com.corrodinggames.rts.game.PlayerTeam n = com.corrodinggames.rts.game.PlayerTeam.k(j);
                    if (n != null) {
                        if (n.N == null) {
                            com.corrodinggames.rts.gameFramework.GameEngine.log("Fog null for team: " + n.k);
                        } else {
                            // 为每个地图格子设置迷雾值
                            for (int k = 0; k < this.bL.C; k++) {
                                for (int m = 0; m < this.bL.D; m++) {
                                    n.N[k][m] = (byte) i;
                                }
                            }
                        }
                    }
                }

                // === 队伍AI和行为设置 ===
                int k = this.networkEngine.k(); // 获取队伍颜色
                for (int m = 0; m < com.corrodinggames.rts.game.PlayerTeam.c; m++) {
                    com.corrodinggames.rts.game.PlayerTeam n2 = com.corrodinggames.rts.game.PlayerTeam.k(m);
                    if (n2 != null) {
                        n2.o = k; // 设置队伍颜色

                        // 设置AI难度
                        if (n2.w) {
                            if (!n2.y) {
                                if (n2.z != null) {
                                    n2.x = n2.z.intValue(); // 使用覆盖的难度设置
                                } else {
                                    n2.x = this.networkEngine.ay.f; // 使用默认难度
                                }
                            } else {
                                n2.c("aiDifficulty is locked"); // 难度已锁定
                            }
                        }

                        n2.I = this.networkEngine.ay.l; // 设置队伍收入

                        // 设置AI行为类型
                        int n3 = this.networkEngine.ay.g;
                        if (n2.teamAIBehaviourOverride != null) {
                            n3 = n2.teamAIBehaviourOverride.intValue(); // 使用覆盖的行为设置
                        }

                        // 根据AI行为类型配置起始单位
                        if (n3 != 1) {
                            boolean bool1 = true; // 是否生成建筑
                            boolean bool2 = true; // 是否生成单位
                            Float float_ = null; // 建筑位置X
                            Float float_1 = null; // 建筑位置Y
                            Float float_2 = null; // 单位位置X
                            Float float_3 = null; // 单位位置Y

                            // 根据行为类型调整生成策略
                            if (n3 == 5 || n3 == 4 || n3 > 10) {
                                bool2 = false; // 不生成标准单位
                            }

                            if (n3 == 5 || n3 == 4 || n3 == 3 || n3 > 10) {
                                bool1 = false; // 不生成标准建筑
                            }

                            if (n3 == 9) {
                                bool2 = false; // 不生成单位
                                bool1 = false; // 不生成建筑
                            }

                            // 查找队伍的起始位置
                            java.util.Iterator iterator = com.corrodinggames.rts.game.units.BaseUnit.bF().iterator();
                            while (iterator.hasNext()) {
                                com.corrodinggames.rts.game.units.BaseUnit am = (com.corrodinggames.rts.game.units.BaseUnit) iterator
                                        .next();
                                if (am instanceof com.corrodinggames.rts.game.units.BaseUnit && !am.bV && am.bX == n2) {
                                    if (am.bO && float_ == null) { // 找到建筑位置
                                        float_ = Float.valueOf(am.posX);
                                        float_1 = Float.valueOf(am.posY);

                                        if (!bool1) {
                                            am.ci(); // 如果不生成建筑，清除现有建筑
                                        }
                                    }

                                    if (am.bP && float_2 == null) { // 找到单位位置
                                        float_2 = Float.valueOf(am.posX);
                                        float_3 = Float.valueOf(am.posY);

                                        if (!bool2) {
                                            am.ci(); // 如果不生成单位，清除现有单位
                                        }
                                    }
                                }
                            }

                            // 生成特定类型的起始单位
                            if (float_2 == null) {
                                com.corrodinggames.rts.gameFramework.GameEngine
                                        .log("placementLocation==null for team:" + n2.k);
                            } else {
                                float f1 = float_2.floatValue();
                                float f2 = float_3.floatValue();

                                // 根据行为类型生成不同的单位组合
                                if (n3 == 2) {
                                    // 生成建造者和重型坦克
                                    for (int i1 = 0; i1 <= 2; i1++) {
                                        if (i1 != 1) {
                                            com.corrodinggames.rts.game.units.BaseUnit am2 = com.corrodinggames.rts.game.units.UnitTypeEnum.builder
                                                    .createUnitInstance();
                                            am2.b(n2);
                                            am2.posX = f1 - 16968.0F + i1 * 50;
                                            am2.posY = f2;
                                            com.corrodinggames.rts.game.PlayerTeam.c(am2);
                                        }
                                    }

                                    for (int i1 = 0; i1 <= 2; i1++) {
                                        com.corrodinggames.rts.game.units.BaseUnit am2 = com.corrodinggames.rts.game.units.UnitTypeEnum.heavyTank
                                                .createUnitInstance();
                                        am2.b(n2);
                                        am2.posX = f1 - 16968.0F + i1 * 50;
                                        am2.posY = f2 + 16968.0F;
                                        com.corrodinggames.rts.game.PlayerTeam.c(am2);
                                    }
                                } else if (n3 == 3 || n3 == 4) {
                                    // 生成战斗工程师
                                    for (int i1 = 0; i1 <= 2; i1++) {
                                        com.corrodinggames.rts.game.units.UnitType as = com.corrodinggames.rts.game.units.UnitTypeEnum
                                                .a("combatEngineer");
                                        if (as == null) {
                                            com.corrodinggames.rts.gameFramework.j.NetworkEngine.g(
                                                    "Could not find: combatEngineer on network.setup.startingUnits==3");
                                        } else {
                                            com.corrodinggames.rts.game.units.BaseUnit am2 = as.createUnitInstance();
                                            am2.b(n2);
                                            am2.posX = f1 - 16968.0F + i1 * 50;
                                            am2.posY = f2 + 16968.0F;
                                            com.corrodinggames.rts.game.PlayerTeam.c(am2);
                                        }
                                    }
                                } else if (n3 == 5) {
                                    // 生成实验蜘蛛单位
                                    com.corrodinggames.rts.game.units.UnitType as = com.corrodinggames.rts.game.units.UnitTypeEnum
                                            .a("experimentalSpider");
                                    if (as == null) {
                                        com.corrodinggames.rts.gameFramework.j.NetworkEngine.g(
                                                "Could not find: experimentalSpider on network.setup.startingUnits==5");
                                    } else {
                                        com.corrodinggames.rts.game.units.BaseUnit am2 = as.createUnitInstance();
                                        am2.b(n2);
                                        am2.posX = f1;
                                        am2.posY = f2;
                                        am2.cg = 17076.0F; // 设置高度
                                        am2.posZ = 16384.0F; // 设置其他属性
                                        am2.dc(); // 初始化单位
                                        com.corrodinggames.rts.game.PlayerTeam.c(am2);
                                    }
                                } else if (n3 != 9 && n3 > 10) {
                                    // 生成自定义单位
                                    com.corrodinggames.rts.game.units.custom.l l = com.corrodinggames.rts.game.units.custom.l
                                            .c(n3);
                                    if (l == null) {
                                        com.corrodinggames.rts.gameFramework.j.NetworkEngine
                                                .g("Could not find starting unit on startingUnits==" + n3);
                                    } else {
                                        com.corrodinggames.rts.game.units.BaseUnit am2 = l.createUnitInstance();
                                        am2.b(n2);
                                        am2.posX = f1;
                                        am2.posY = f2;

                                        if (!am2.bI()) {
                                            am2.cg = 17076.0F; // 设置非飞行单位高度
                                        }

                                        if (l.eI) {
                                            am2.dc(); // 初始化单位
                                            if (am2 instanceof com.corrodinggames.rts.game.units.custom.j) {
                                                ((com.corrodinggames.rts.game.units.custom.j) am2).dB(); // 自定义初始化
                                            }
                                        }

                                        com.corrodinggames.rts.game.PlayerTeam.c(am2);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // === 初始视角设置 ===
            if (!paramBoolean2) { // 新游戏
                if (this.ce == null || !this.ce.q) {
                    a(0.0F, 0.0F); // 重置视角到原点

                    int i = 0; // 单位计数
                    int j = 0; // 树木计数
                    boolean bool = false; // 是否找到玩家起始位置

                    // 统计地图上的单位和树木，并寻找玩家起始位置
                    java.util.Iterator iterator = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
                    while (iterator.hasNext()) {
                        com.corrodinggames.rts.game.units.BaseUnit am = (com.corrodinggames.rts.game.units.BaseUnit) iterator
                                .next();
                        if (am instanceof com.corrodinggames.rts.game.units.Tree) {
                            j++; // 计数树木
                        } else {
                            i++; // 计数单位
                        }

                        // 寻找玩家的起始单位位置
                        if (am.bX == this.bs && am.bP) {
                            b(am.posX, am.posY); // 设置视角到起始单位
                            bool = true;
                        }
                    }

                    // 如果没有找到起始单位，寻找任何玩家单位
                    if (!bool) {
                        java.util.Iterator iterator1 = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
                        while (iterator1.hasNext()) {
                            com.corrodinggames.rts.game.units.BaseUnit am = (com.corrodinggames.rts.game.units.BaseUnit) iterator1
                                    .next();
                            if (am.bX == this.bs && !am.t() && !am.u()) {
                                b(am.posX, am.posY); // 设置视角到第一个可用单位
                                break;
                            }
                        }
                    }

                    log("there are " + i + " units on this map and " + j + " trees"); // 日志输出统计
                }
            }

            // === 游戏状态管理初始化 ===
            this.gameStateData = com.corrodinggames.rts.gameFramework.GameStateManager.c(this.am).b(ak());
            this.bU.a(this.bL, paramBoolean2); // 初始化路径查找系统
            this.bW.a(this.bL, paramBoolean2); // 初始化碰撞系统

            // === 子系统初始化 ===
            this.cf.a(); // 初始化选择系统
            this.bV.a(); // 初始化单位管理系统

            if (!paramBoolean2) {
                com.corrodinggames.rts.gameFramework.effect.a.a(); // 初始化特效系统（新游戏）
            }

            this.ca.a(paramBoolean2); // 初始化输入系统
            this.bS.a(paramBoolean2); // 初始化渲染系统

            // === 渲染系统设置 ===
            if (!paramBoolean2) {
                this.bS.y(); // 准备渲染
                selectAnyOnScreenBuilder(); // 执行图形初始化

                if (this.bv) {
                    this.bS.y(); // 额外渲染准备
                }
            } else {
                this.bS.y(); // 加载游戏的渲染准备
            }

            this.cc.a(this.bL); // 初始化小地图系统

            if (!paramBoolean2) {
                this.bN.c(); // 初始化声音系统（新游戏）
            }

            this.bY.a(); // 初始化UI系统

            // === 单位状态初始化 ===
            java.util.Iterator iterator2 = com.corrodinggames.rts.game.units.BaseUnit.bE.iterator();
            while (iterator2.hasNext()) {
                com.corrodinggames.rts.game.units.BaseUnit am = (com.corrodinggames.rts.game.units.BaseUnit) iterator2
                        .next();
                if (am instanceof com.corrodinggames.rts.game.units.y) {
                    ((com.corrodinggames.rts.game.units.y) am).c(false); // 初始化特定单位类型
                }
            }

            // === 完成初始化 ===
            this.gameStateData.e = true; // 标记游戏状态数据就绪
            this.gameStateManager.a(this.am); // 注册游戏状态管理器

            this.loadNewGame = true; // 标记游戏开始运行
            this.bH = false; // 重置暂停标志
            this.bI = false; // 标记初始化完成

            // 记录玩家已玩过游戏（用于帮助系统）
            if (gameMode != com.corrodinggames.rts.gameFramework.GameMode.menu && !this.bQ.hasPlayedGameOrSeenHelp) {
                this.bQ.hasPlayedGameOrSeenHelp = true;
                this.bQ.save(); // 保存设置
            }

            // 多次触发垃圾回收以清理内存
            for (int i = 0; i < 5; i++) {
                System.gc();
            }

            // === 内存使用日志 ===
            if (!com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2) {
                android.util.Log.a("RustedWarfare", "getNativeHeapSize" + android.os.Debug.getNativeHeapSize());
                android.util.Log.a("RustedWarfare",
                        "getNativeHeapAllocatedSize" + android.os.Debug.getNativeHeapAllocatedSize());
                android.util.Log.a("RustedWarfare", "getNativeHeapFreeSize" + android.os.Debug.getNativeHeapFreeSize());
                android.util.Log.a("RustedWarfare",
                        "Runtime.getRuntime().maxMemory()" + java.lang.Runtime.getRuntime().maxMemory());
            }

            // === 后期初始化 ===
            if (this.dk != null) {
                this.dk.a(); // 初始化后期系统
            }

            this.G = 0.0F; // 重置游戏时间

            // 单机模式下禁用网络
            if (this.networkEngine.F && this.networkEngine.B) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Disabling network for singleplayer");
                this.networkEngine.B = false;
            }

            // === 重放记录初始化 ===
            if (!ax()) {
                if (gameMode == com.corrodinggames.rts.gameFramework.GameMode.normalSave) {
                    com.corrodinggames.rts.gameFramework.GameEngine
                            .log("Not starting replay recording as we are loading a save");
                } else {
                    this.cb.a(paramBoolean2); // 开始记录重放
                }
            }

            // 特殊模式检查
            if (com.corrodinggames.rts.gameFramework.k.l.m) {
                return;
            }
        } catch (Exception e) {
            throw e; // 重新抛出异常
        }
    }

    private void selectAnyOnScreenBuilder() { // aG -> selectAnyOnScreenBuilder
        this.bS.y();
        for (com.corrodinggames.rts.game.units.BaseUnit am2 : ((List<com.corrodinggames.rts.game.units.BaseUnit>) com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am2.bX != this.bs || !(am2 instanceof y) || !am2.ak() || !am2.s_() || !am2.bT() || am2.u() || am2.t())
                continue;
            com.corrodinggames.rts.gameFramework.GameEngine.log("selectAnyOnScreenBuilder: found builder");
            this.bS.j(am2);
            return;
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("selectAnyOnScreenBuilder: no builder found");
    }

    @Override
    public void cleanupGameObjects() { // g -> cleanupGameObjects
        o o2 = com.corrodinggames.rts.gameFramework.GGameObject.dK();
        for (Object object : o2) {
            ((GGameObject) object).a();
        }
        com.corrodinggames.rts.game.units.BaseUnit.bF();
        com.corrodinggames.rts.gameFramework.GGameObject.dK();
        int n2 = o2.size();
        if (n2 != 0) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .a("SHOULD_NOT_HAPPEN: we still had " + n2 + " objects in gameObjectListForLogic after removeAll");
            for (GGameObject w2 : ((Iterable<GGameObject>) o2)) {
                String string2 = "Object: " + w2.objectId;
                if (w2 instanceof com.corrodinggames.rts.game.units.BaseUnit) {
                    string2 = ((com.corrodinggames.rts.game.units.BaseUnit) w2).c();
                }
                com.corrodinggames.rts.gameFramework.GameEngine.a("Remaining object: " + string2);
            }
            if (com.corrodinggames.rts.gameFramework.GameEngine.getInstance().aa()) {
                throw new RuntimeException("We still had " + n2 + " objects in gameObjectListForLogic after removeAll");
            }
        }
        com.corrodinggames.rts.game.units.BaseUnit.bF().clear();
        com.corrodinggames.rts.gameFramework.GGameObject.dK().clear();
        com.corrodinggames.rts.game.units.custom.j.dD();
        this.W.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cleanupGameState(boolean bl2) { // b -> cleanupGameState
        Object object = this.gameLoopLock;
        synchronized (object) {
            if (this.ao != null) {
                this.ao.l();
            }
            this.bq = false;
            if (!bl2) {
                this.cb.g();
            }
            this.bU.c();
            this.cleanupGameObjects();
            if (!com.corrodinggames.rts.game.GameLogic.av()) {
                this.bN.f();
            }
            this.bR.a(bl2);
            if (this.bL != null) {
                this.bL.clearAllMapData();
                this.bL = null;
            }
            if (this.ce != null) {
                this.ce = null;
            }
            if (this.cc != null) {
                this.cc.b();
            }
            this.af = null;
            this.ag = null;
            this.j = 0;
            com.corrodinggames.rts.game.PlayerTeam.Y();
            this.a(com.corrodinggames.rts.gameFramework.g.f.none, com.corrodinggames.rts.gameFramework.g.c.player);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processGameFrame(float f2, int n2) throws IOException { // a -> processGameFrame
        Object object = this.gameLoopLock;
        synchronized (object) {
            this.processGameLogic(f2, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    // 这个方法会调用更加低级的绘制调用
    // 见注释: "//调用基础绘图"
    public void processGameLogic(float f2, int n2) throws IOException { // b -> processGameLogic
        float f3;
        float f4;
        float f5;
        if (this.bx == 2) {
            this.aF();
        } else if (this.bx % 10000 == 0 && this.bx != 0) {
            this.aF();
        }
        if (isGameThreadRunningStatic && !this.aS && com.corrodinggames.rts.game.GameLogic.at()
                && Debug.getNativeHeapAllocatedSize() > 0xC800000L) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("getNativeHeapAllocatedSize: "
                    + com.corrodinggames.rts.gameFramework.GameUtils.g((int) Debug.getNativeHeapAllocatedSize()));
            this.aS = true;
        }
        this.aE();
        this.eb.a();
        this.ec.b();
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.a);
        this.networkEngine.b(f2);
        this.ao = this.ap;
        if (!this.ao.b()) {
            return;
        }
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.b);
        while (this.k.peek() != null) {
            Runnable runnable = (Runnable) this.k.poll();
            runnable.run();
        }
        if (!this.loadNewGame) {
            if (this.gameStarted) {
                return;
            }
            Log.d("RustedWarfare", "game running without a loaded level!!!");
            this.stopAndCloseGame();
            try {
                Thread.sleep(10L);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            return;
        }
        this.bq = true;
        if (!this.F && this.bx > 5) {
            this.F = true;
            boolean bl2 = false;
            if (this.bQ.numIncompleteLoadAttempts > 1) {
                bl2 = true;
            }
            this.bQ.numIncompleteLoadAttempts = 0;
            if (this.ee) {
                this.bQ.numLoadsSinceRunningGameOrNormalExit = 0;
            }
            this.bQ.save();
            if (this.ee && (this.ef || this.bZ.c() > 0)) {
                if (this.eg != null) {
                    this.c("Safe mode", "Started game in safe mode due to " + this.eg + ". Mods have been disabled.");
                } else if (bl2) {
                    this.c("Safe mode",
                            "Started game in safe mode due to failed loading attempts. Mods have been disabled.");
                } else {
                    this.c("Safe mode",
                            "Started game in safe mode due to multiple loads without starting a game or exiting. Mods have been disabled.");
                }
            }
        }
        if (!this.bH && this.loadNewGame && this.bQ.numLoadsSinceRunningGameOrNormalExit != 0) {
            this.bQ.numLoadsSinceRunningGameOrNormalExit = 0;
            this.bQ.save();
        }
        this.ca.b();
        float f6 = this.cV * this.cY;
        if (f6 != this.cX) {
            f5 = this.mouseX / this.cX + this.cy;
            f4 = this.mouseY / this.cX + this.cz;
            this.cX = f6;
            this.updateCameraSystem();
            if (this.cZ) {
                f3 = this.mouseX / this.cX + this.cy;
                float f7 = this.mouseY / this.cX + this.cz;
                this.a(this.cy - (f3 - f5), this.cz - (f7 - f4));
                this.cZ = false;
            }
        }
        if (this.cr != 0.0f || this.cs != 0.0f) {
            f5 = 3.0f * f2;
            f4 = 0.0f;
            if (this.cr > 0.0f) {
                f4 = com.corrodinggames.rts.gameFramework.GameUtils.g(this.cr, f5);
            }
            if (this.cr < 0.0f) {
                f4 = com.corrodinggames.rts.gameFramework.GameUtils.f(this.cr, -f5);
            }
            f4 += 0.15f * this.cr;
            f3 = 0.0f;
            if (this.cs > 0.0f) {
                f3 = com.corrodinggames.rts.gameFramework.GameUtils.g(this.cs, f5);
            }
            if (this.cs < 0.0f) {
                f3 = com.corrodinggames.rts.gameFramework.GameUtils.f(this.cs, -f5);
            }
            f3 += 0.15f * this.cs;
            if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.cr) <= f5) {
                f4 = this.cr;
                this.cr = 0.0f;
            } else {
                this.cr -= f4;
            }
            if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.cs) <= f5) {
                f3 = this.cs;
                this.cs = 0.0f;
            } else {
                this.cs -= f3;
            }
            this.cy += f4;
            this.cz += f3;
            this.a(this.cy, this.cz);
            this.Q();
        }
        if (this.cR != this.cS) {
            this.updateCameraSystem();
        }
        if (f2 > 3.0f) {
            f2 = 3.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (this.bu >= 0.0f) {
            f2 = this.bu;
        }
        this.bA = (int) ((float) this.bA + f2 * 16.666666f);
        this.updateCameraFocus(f2);
        this.q += n2;
        ++this.r;
        if (this.r >= 40) {
            if (this.q == 0) {
                this.q = 1;
            }
            this.s = (int) ((float) (this.r * 1000 / this.q) + 0.5f);
            this.t = (float) this.q / (float) this.r;
            this.q = 0;
            this.r = 0;
            if (this.bQ.showFps) {
                this.u = this.s + "fps";
            }
        }
        this.aj();
        for (int i2 = 0; i2 < this.dM.length; ++i2) {
            this.dM[i2] = true;
        }
        this.dh = com.corrodinggames.rts.gameFramework.GameUtils.a(this.dh, 0.1f * f2);
        this.di = com.corrodinggames.rts.gameFramework.GameUtils.a(this.di, 0.1f * f2);
        this.dh = com.corrodinggames.rts.gameFramework.GameUtils.b(this.dh, 5.0f);
        this.di = com.corrodinggames.rts.gameFramework.GameUtils.b(this.di, 5.0f);
        this.bS.a(f2);
        this.Q();
        com.corrodinggames.rts.game.b.TileMap.f();
        if (this.networkEngine.B) {
            float f8 = f2;
            if (this.cb.v != 1) {
                f8 *= (float) this.cb.v;
            }
            this.networkEngine.a(f8);
            if (!this.canProcessGameLogic(true) && !this.networkEngine.Y) {
                this.G += f8;
                while (this.G > this.networkEngine.c()) {
                    if (this.networkEngine.I()) {
                        this.networkEngine.Y = true;
                        break;
                    }
                    this.G -= this.networkEngine.c();
                    this.networkEngine.a(this.networkEngine.c(), false);
                    if (this.networkEngine.Y)
                        break;
                    this.updateGameLogic(this.networkEngine.c());
                }
                if (!this.networkEngine.C) {
                    if (this.networkEngine.af || this.networkEngine.ad) {
                        if (this.networkEngine.af && this.networkEngine.ad && this.bx < this.networkEngine.X - this.networkEngine.Q - 5) {
                            this.networkEngine.d("nearly within frame range");
                            this.networkEngine.af = false;
                        }
                        if (this.bx > this.networkEngine.X - 6) {
                            this.networkEngine.d("we have back within frame range");
                            this.networkEngine.af = false;
                            this.networkEngine.ad = false;
                        }
                    }
                    if (!this.networkEngine.ad && this.bx < this.networkEngine.X - this.networkEngine.Q - 10) {
                        this.networkEngine.d("we are slightly out of frame range, speeding up");
                        this.networkEngine.ad = true;
                    }
                    if (!this.networkEngine.af && this.bx < this.networkEngine.X - this.networkEngine.Q - 30) {
                        this.networkEngine.d("we are out of frame range, fast forwarding (" + this.bx + "->" + this.networkEngine.X + ")");
                        this.networkEngine.af = true;
                    }
                    if (!this.networkEngine.af && this.networkEngine.ad) {
                        this.networkEngine.ae += f2;
                        if (this.networkEngine.ae > this.networkEngine.c() * 3.0f) {
                            this.networkEngine.ae = 0.0f;
                            this.networkEngine.a(this.networkEngine.c(), true);
                            if (!this.networkEngine.Y) {
                                this.updateGameLogic(this.networkEngine.c());
                            }
                        }
                    }
                    if (this.networkEngine.af) {
                        this.networkEngine.a(this.networkEngine.c(), true);
                        if (!this.networkEngine.Y) {
                            this.updateGameLogic(this.networkEngine.c());
                        }
                    }
                    if (this.bx < this.networkEngine.X - 90) {
                        this.networkEngine.a(this.networkEngine.c(), true);
                        if (!this.networkEngine.Y) {
                            this.updateGameLogic(this.networkEngine.c());
                        }
                    }
                    if (this.bx < this.networkEngine.X - 120) {
                        this.networkEngine.a(this.networkEngine.c(), true);
                        if (!this.networkEngine.Y) {
                            this.updateGameLogic(this.networkEngine.c());
                        }
                    }
                    if (this.bx < this.networkEngine.X - 600) {
                        this.networkEngine.a(this.networkEngine.c(), true);
                        if (!this.networkEngine.Y) {
                            this.updateGameLogic(this.networkEngine.c());
                        }
                    }
                }
            }
        } else if (this.cb.i()) {
            float f9 = f2;
            if (this.cb.v != 1) {
                f9 *= (float) this.cb.v;
            }
            if (this.bt != 1.0f) {
                f9 *= this.bt;
            }
            if (!this.canProcessGameLogic(false)) {
                this.G += f9;
                while (this.G > this.networkEngine.c()) {
                    this.G -= this.networkEngine.c();
                    if (this.networkEngine.I())
                        break;
                    this.updateGameLogic(this.networkEngine.c());
                }
            }
            if (this.G > 100.0f) {
                this.G = 100.0f;
            }
            if (this.G < 0.0f) {
                this.G = 0.0f;
            }
        } else if (!this.canProcessGameLogic(false)) {
            this.updateGameLogic(f2); // 产生大量单位
        }
        if (this.canProcessGameLogic(false)) {
            try {
                Thread.sleep(2L);
            } catch (Exception exception) {
                // empty catch block
            }
        }
        this.bU.a(f2);
        this.bM.b(f2);
        this.bN.a(f2);
        this.bT.b();
        com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a().a(f2);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.b);
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.c);
        if (!this.dv) {
            if (this.bO.a()) {
                this.drawGame((com.corrodinggames.rts.gameFramework.m.l) null, f2);// 调用基础绘图1
            } else if (this.ao.n()) {
                com.corrodinggames.rts.gameFramework.m.l l2 = this.ao.b(true);
                this.drawGame(l2, f2);// 调用基础绘图2
            } else {
                com.corrodinggames.rts.appFramework.f f10 = this.ao;
                this.ao.a(f2, n2);
                if (f10.c() && !f10.e()) {
                    Object object = f10.g();
                    synchronized (object) {
                        if (f10.c() && !f10.e()) {
                            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.w);
                            com.corrodinggames.rts.gameFramework.m.l l3 = f10.b(true);
                            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.w);
                            try {
                                if (!f10.e()) {
                                    if (l3 != null) {
                                        if (l3.c()) {
                                            com.corrodinggames.rts.gameFramework.GameEngine
                                                    .log("gameengine draw: bufferedCanvas drawn on");
                                        }
                                        l3.a(true);
                                    }
                                    if (l3 == null) {
                                        com.corrodinggames.rts.gameFramework.GameEngine
                                                .f("GameEngine gameViewCanvas is null after lockCanvas - "
                                                        + f10.hashCode());
                                    }
                                    this.drawGame(l3, f2);// 调用基础绘图3
                                    this.bO.a((com.corrodinggames.rts.gameFramework.m.l) null);
                                }
                            } finally {
                                if (l3 != null) {
                                    try {
                                        f10.a(l3, true);
                                    } catch (IllegalArgumentException illegalArgumentException) {
                                        illegalArgumentException.printStackTrace();
                                        com.corrodinggames.rts.gameFramework.GameEngine
                                                .f("GameEngine catch currentGameView - " + f10.hashCode());
                                        com.corrodinggames.rts.gameFramework.GameEngine
                                                .f("GameEngine catch currentGameView.gameThreadSync - "
                                                        + f10.g().hashCode());
                                        f10.h();
                                    } catch (IllegalStateException illegalStateException) {
                                        illegalStateException.printStackTrace();
                                        com.corrodinggames.rts.gameFramework.GameEngine
                                                .f("GameEngine catch currentGameView - " + f10.hashCode());
                                        com.corrodinggames.rts.gameFramework.GameEngine
                                                .f("GameEngine catch currentGameView.gameThreadSync - "
                                                        + f10.g().hashCode());
                                    }
                                }
                            }
                        }
                    }
                }
                this.ao.b(f2, n2);
            }
        }
        this.dv = false;
        this.Z();
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.c);
        if (this.du) {
            this.du = false;
            Integer n3 = com.corrodinggames.rts.game.GameLogic.l(this.menuBackgroundMapFile);
            String string2 = null;
            if (n3 != null) {
                string2 = com.corrodinggames.rts.game.GameLogic.m(this.menuBackgroundMapFile);
            }
            if (this.networkEngine.B) {
                string2 = null;
                new i$a(this).start();
            }
            if (string2 != null) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("gotoNextLevel: Loading next level: " + string2);
                this.menuBackgroundMapFile = string2;
                this.bS.h.b();
                this.initializeAndStartGame(true, false, com.corrodinggames.rts.gameFramework.GameMode.normal);
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.log("gotoNextLevel: No next level, finishing");
                this.loadNewGame = false;
                com.corrodinggames.rts.appFramework.g g2 = this.ao.i();
                if (g2 != null) {
                    g2.b();
                    g2.m();
                } else {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("gotoNextLevel: Error getInGameActivity==null");
                }
            }
        }
        if (!this.gameStarted && this.isBenchmarking && !this.i) {
            com.corrodinggames.rts.game.GameLogic.log("starting method trace");
            Debug.startMethodTracing((String) "lukeTrace", (int) 110000000);
            this.i = true;
        }
        this.exitGameThread = true;
        this.ed.a();
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.a);
        this.cd.b();
    }

    public void stopAndCloseGame() { // h -> stopAndCloseGame
        com.corrodinggames.rts.appFramework.g g2 = this.ao.i();
        if (g2 != null) {
            if (!g2.c()) {
                g2.b();
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.b("stopAndClose: inGameActivity is isFinishing");
            }
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.b("stopAndClose: Error getInGameActivity==null");
        }
    }

    public void a_old(float deltaTime) throws IOException { // a -> updateGameLogic (old version)
        // 检查调试模式和deltaTime阈值
        if (ay() && deltaTime < 1036831949f) {
            // 记录调试信息
            StringBuilder sb = new StringBuilder();
            sb.append("updateAllGame1: deltaSpeed:").append(deltaTime)
                    .append(" frame:").append(this.bx)
                    .append(" network.currentStepRate:").append(this.networkEngine.c());
            com.corrodinggames.rts.gameFramework.j.NetworkEngine.g(sb.toString());
        }

        // 应用游戏速度倍率
        if (this.bt != 16256f) {
            if (!this.networkEngine.B && !this.cb.i()) {
                deltaTime *= this.bt;
            }
        }

        // 计算实际时间增量
        float actualDelta = deltaTime * this.H;

        // 更新内部状态
        this.I = 16384f + actualDelta;
        this.J = actualDelta;

        // 更新网络模块
        this.networkEngine.c(actualDelta);

        // 更新游戏时间
        this.by += (int) (actualDelta * 1099257173f);

        // 更新各种子系统
        this.cf.c();
        this.cb.a(actualDelta);
        this.bx++;

        com.corrodinggames.rts.game.PlayerTeam.g(actualDelta);

        // 更新AI系统（如果存在）
        if (this.bL != null) {
            this.bL.e(actualDelta);
        }

        // 再次检查调试模式
        if (ay() && actualDelta < 1036831949f) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateAllGame2: deltaSpeed:").append(actualDelta)
                    .append(" frame:").append(this.bx);
            com.corrodinggames.rts.gameFramework.j.NetworkEngine.g(sb.toString());
        }

        // 处理所有游戏对象
        com.corrodinggames.rts.game.units.BaseUnit.bF(); // 静态初始化？

        com.corrodinggames.rts.gameFramework.utility.o allObjects = com.corrodinggames.rts.gameFramework.GGameObject
                .dK();
        Object[] objectArray = allObjects.b();
        int objectCount = allObjects.size();
        boolean debugMode = ay();

        // 第一轮更新：所有活动对象
        for (int i = 0; i < objectCount; i++) {
            com.corrodinggames.rts.gameFramework.GGameObject obj = (com.corrodinggames.rts.gameFramework.GGameObject) objectArray[i];

            // JIT bug检测和修复
            if (debugMode && actualDelta != this.J) {
                StringBuilder sb = new StringBuilder();
                sb.append("JIT bug detected, attempting to correct. before object:")
                        .append(obj.objectId).append(" frame:").append(this.bx)
                        .append(" deltaSpeed:").append(actualDelta);
                com.corrodinggames.rts.gameFramework.j.NetworkEngine.h(sb.toString());
                actualDelta = this.J;
            }

            obj.a(actualDelta);
        }

        // 调试日志
        if (ay() && actualDelta < 1036831949f) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateAllGame3: deltaSpeed:").append(actualDelta)
                    .append(" frame:").append(this.bx);
            com.corrodinggames.rts.gameFramework.j.NetworkEngine.g(sb.toString());
        }

        // 第二轮更新：新增的对象
        int pendingCount = allObjects.a.size();
        for (int i = 0; i < pendingCount; i++) {
            com.corrodinggames.rts.gameFramework.utility.r pending = (com.corrodinggames.rts.gameFramework.utility.r) allObjects.a
                    .get(i);
            if (pending.a == com.corrodinggames.rts.gameFramework.utility.q.a) {
                com.corrodinggames.rts.gameFramework.GGameObject newObj = (com.corrodinggames.rts.gameFramework.GGameObject) pending.b;
                if (!newObj.ej) {
                    newObj.a(actualDelta);
                }
            }
        }

        // 性能分析：开始单位更新
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.m);
        this.cc.a();
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.m);

        // 更新各种游戏系统
        com.corrodinggames.rts.game.units.y.g(actualDelta);
        com.corrodinggames.rts.game.units.custom.j.s(actualDelta);
        com.corrodinggames.rts.game.units.custom.j.a(actualDelta, 0);

        // 定期清理（每1000帧）
        this.j++;
        if (this.j >= 1000) {
            this.j = 0;

            // 统计活动单位数量
            int activeUnitCount = 0;
            com.corrodinggames.rts.gameFramework.utility.o allUnits = com.corrodinggames.rts.game.units.BaseUnit.bF();
            for (java.util.Iterator<com.corrodinggames.rts.game.units.BaseUnit> it = allUnits.iterator(); it
                    .hasNext();) {
                com.corrodinggames.rts.game.units.BaseUnit unit = it.next();
                if (unit.bV && !(unit instanceof com.corrodinggames.rts.game.units.Tree)) {
                    activeUnitCount++;
                }
            }

            // 如果单位数量超过阈值，清理老旧单位
            if (activeUnitCount > 70) {
                com.corrodinggames.rts.gameFramework.utility.o units = com.corrodinggames.rts.game.units.BaseUnit.bF();
                for (java.util.Iterator<com.corrodinggames.rts.game.units.BaseUnit> it = units.iterator(); it
                        .hasNext();) {
                    com.corrodinggames.rts.game.units.BaseUnit unit = it.next();
                    if (unit instanceof com.corrodinggames.rts.game.units.BaseUnit &&
                            unit.bV &&
                            !(unit instanceof com.corrodinggames.rts.game.units.Tree) &&
                            unit.bW < (this.by - 30000L) &&
                            activeUnitCount > 70) {
                        unit.a(); // 清理单位
                        activeUnitCount--;
                    }
                }
            }
        }

        // 更新渲染和图形系统
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.l);
        com.corrodinggames.rts.game.PlayerTeam.f(actualDelta);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.l);

        com.corrodinggames.rts.gameFramework.effect.a.a(actualDelta);
        this.bR.a(actualDelta);
        this.D.a(actualDelta);
        com.corrodinggames.rts.gameFramework.utility.y.a(actualDelta);

        // 更新网络模块
        if (this.ce != null) {
            this.ce.c(actualDelta);
        }

        // 更新UI系统
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.o);
        this.bV.a(actualDelta);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.o);

        // 更新输入系统
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.n);
        this.bW.a(actualDelta);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.n);

        // 更新其他系统
        this.bU.b(actualDelta);

        if (this.cg != null) {
            this.cg.b();
        }

        this.bY.b();
    }

    public void updateGameLogic(float j) throws IOException { // a -> updateGameLogic
        if (this.ay() && j < 0.1f) {
            com.corrodinggames.rts.gameFramework.j.NetworkEngine.g("updateAllGame1: deltaSpeed:" + j + " frame:" + this.bx
                    + " network.currentStepRate:" + this.networkEngine.c());
        }
        if (this.bt != 1.0f && !this.networkEngine.B && !this.cb.i()) {
            j *= this.bt;
        }
        j *= this.H;
        this.I = j + 2.0f;
        this.J = j;
        this.networkEngine.c(j);
        this.by += (int) (j * 16.666666f);
        this.cf.c();
        this.cb.a(j);
        ++this.bx;
        com.corrodinggames.rts.game.PlayerTeam.g(j);
        if (this.bL != null) {
            this.bL.e(j);
        }
        if (this.ay() && j < 0.1f) {
            com.corrodinggames.rts.gameFramework.j.NetworkEngine.g("updateAllGame2: deltaSpeed:" + j + " frame:" + this.bx);
        }
        BaseUnit.bF();
        final com.corrodinggames.rts.gameFramework.utility.o dk = com.corrodinggames.rts.gameFramework.GGameObject.dK();
        final Object[] b = dk.b();
        final int size = dk.size();
        final boolean ay = this.ay();
        for (int i = 0; i < size; ++i) {
            final GGameObject tw = (GGameObject) b[i];
            if (ay && j != this.J) {
                com.corrodinggames.rts.gameFramework.j.NetworkEngine.h("JIT bug detected, attempting to correct. before object:"
                        + tw.objectId + " frame:" + this.bx + " deltaSpeed:" + j);
                j = this.J;
            }
            tw.a(j);
        }
        // GameEngine.e("CCFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF  | "+size+"|"+j); //核心问题 ma
        if (this.ay() && j < 0.1f) {
            com.corrodinggames.rts.gameFramework.j.NetworkEngine.g("updateAllGame3: deltaSpeed:" + j + " frame:" + this.bx);
        }
        for (int size2 = dk.a.size(), k = 0; k < size2; ++k) {
            final com.corrodinggames.rts.gameFramework.utility.r tr = (com.corrodinggames.rts.gameFramework.utility.r) dk.a
                    .get(k);
            if (tr.a == com.corrodinggames.rts.gameFramework.utility.q.a) {
                final GGameObject w2 = (GGameObject) tr.b;
                if (!w2.ej) {
                    w2.a(j);
                }
            }
        }
        this.cd.a(ProfilerSection.m);
        this.cc.a();
        this.cd.b(ProfilerSection.m);
        com.corrodinggames.rts.game.units.y.g(j);
        com.corrodinggames.rts.game.units.custom.j.s(j);
        com.corrodinggames.rts.game.units.custom.j.a(j, 0);
        ++this.j;
        if (this.j >= 1000) {
            this.j = 0;
            int n = 0;
            for (final BaseUnit am : ((List<BaseUnit>) BaseUnit.bF())) {
                if (am.bV && !(am instanceof com.corrodinggames.rts.game.units.Tree)) {
                    ++n;
                }
            }
            if (n > 70) {
                for (final BaseUnit am2 : ((List<BaseUnit>) BaseUnit.bF())) {
                    if (am2 instanceof BaseUnit) {
                        final BaseUnit am3 = am2;
                        if (!am3.bV || am3 instanceof com.corrodinggames.rts.game.units.Tree || am3.bW >= this.by - 30000
                                || n <= 70) {
                            continue;
                        }
                        am3.a();
                        --n;
                    }
                }
            }
        }
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.l);
        com.corrodinggames.rts.game.PlayerTeam.f(j);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.l);
        com.corrodinggames.rts.gameFramework.effect.a.a(j);
        this.bR.a(j);
        this.D.a(j);
        com.corrodinggames.rts.gameFramework.utility.y.a(j);
        if (this.ce != null) {
            this.ce.c(j);
        }
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.o);
        this.bV.a(j);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.o);
        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.n);
        this.bW.a(j);
        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.n);
        this.bU.b(j);
        if (this.cg != null) {
            this.cg.b();
        }
        this.bY.b();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void drawGame(com.corrodinggames.rts.gameFramework.m.l l2, float f2) throws IOException { // a -> drawGame
        Object object = this.gameLoopLock2;
        synchronized (object) {
            this.drawAll(l2, f2);// 调用基础绘图(底层)
        }
    }

    public boolean setupPostprocessing() throws IOException { // i -> setupPostprocessing
        if (this.K == null) {
            this.K = new com.corrodinggames.rts.game.j("assets/shaders/post_base.frag");
        }
        if (this.L == null) {
            this.L = new com.corrodinggames.rts.game.j("assets/shaders/post_displacement.frag");
        }
        this.K.a(this.bO);
        this.L.a(this.bO);
        if (this.K.g || this.L.g) {
            if (!this.M) {
                this.M = true;
                com.corrodinggames.rts.gameFramework.GameEngine.log("setupPostprocessing: failed");
            }
            return false;
        }
        return true;
    }

    public void enableShaderLayer(com.corrodinggames.rts.game.j j2) throws IOException { // a -> enableShaderLayer
        if (this.graphicsEngine != null) {
            throw new RuntimeException("Layer already enabled");
        }
        this.graphicsEngine = this.bO;
        this.bO = j2.b;
        this.bO.i();
        this.bO.a(new Rect(0, 0, this.bO.m(), this.bO.n()));
        this.bO.b(j2.f, j2.e);
    }

    public void disableShaderLayer(com.corrodinggames.rts.game.j j2) throws IOException { // b -> disableShaderLayer
        if (this.graphicsEngine == null) {
            throw new RuntimeException("Layer not enabled");
        }
        this.bO.j();
        this.bO.p();
        this.bO = this.graphicsEngine;
        this.graphicsEngine = null;
        this.bO.b(j2.f, j2.e);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void b_old(com.corrodinggames.rts.gameFramework.m.l canvas, float deltaTime) throws IOException { // b -> drawAll (old version)
        // 检查canvas是否为空
        if (canvas == null) {
            com.corrodinggames.rts.game.GameLogic.b("drawAll", "canvas is null, not may not be available yet");
            return;
        }

        // 检查全局标志
        if (com.corrodinggames.rts.game.GameLogic.isNetworkServerStatic) {
            return;
        }

        // 设置渲染器
        this.bO.a(canvas);
        this.bO.a(this.ao.d());
        this.bO.g();

        // 更新绘制计数
        this.bz++;
        com.corrodinggames.rts.gameFramework.m.TeamColorTexture.G = 0f;

        // 检查是否在加载状态
        if (this.du) {
            // 绘制加载界面
            this.bO.b(android.graphics.Color.a(0, 0, 0));
            this.bO.a("Loading..", this.co, this.cp, this.dp);
            return;
        }

        float scale = this.cn;
        boolean applyScale = (scale != 16256f);

        // 应用缩放变换
        if (applyScale) {
            this.bO.i();
            this.bO.a(scale, scale);
        }

        // 检查调试模式
        boolean debugMode = com.corrodinggames.rts.gameFramework.GameEngine.aA();
        boolean drawDebug = false;

        if (debugMode) {
            // 检查特定按键组合
            if (h(113) && h(44)) {
                drawDebug = true;
            }
        }

        // 检查是否应该绘制调试视图
        if (!setupPostprocessing() && drawDebug) {
            drawDebug = false;
        }

        if (drawDebug) {
            // 调试模式绘制路径
            enableShaderLayer(this.K);

            try {
                // 清屏为黑色
                this.bO.b(android.graphics.Color.a(0, 0, 0));

                // 性能分析：开始基础绘制
                this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
                drawGameWorld(null, deltaTime); // 不传递canvas
                this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
            } finally {
                // 确保恢复渲染状态
                disableShaderLayer(this.K);
            }
        } else {
            // 正常绘制路径
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
            drawGameWorld(canvas, deltaTime);
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
        }

        // 完成基础渲染
        if (this.K == null) {// 原先没有这个检查
            setupPostprocessing();
        }
        this.K.b();

        // 检查是否需要绘制UI层
        boolean drawUI = !this.L.a();
        int uiDrawResult = 0;

        if (drawUI) {
            enableShaderLayer(this.L);

            try {
                // 设置UI背景色（蓝色）
                this.bO.b(android.graphics.Color.a(128, 128, 255));

                // 准备UI渲染
                R();

                // 绘制UI并获取结果
                uiDrawResult = this.bR.a(deltaTime, 3);
                this.bR.l = null; // 清除引用
            } finally {
                // 确保恢复渲染状态
                disableShaderLayer(this.L);
            }
        }

        // 处理UI绘制结果
        if (uiDrawResult > 0) {
            float uiScale = this.bO.s();

            // 设置着色器参数
            com.corrodinggames.rts.gameFramework.m.ShaderProgram shaderParams = this.L.d;
            shaderParams.a("screenBase", this.K.a);
            shaderParams.b("screenBaseSize", this.K.a);
            shaderParams.a("u_resolution", this.cl, this.cm);
            shaderParams.a("u_offsetBy", 1045220557f * this.cX);
            shaderParams.a("u_uiScaling", uiScale);

            // 完成UI渲染
            this.L.b();
        }

        // 绘制游戏内UI（如果游戏未暂停）
        if (!A()) {
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.f);
            drawUI(canvas, deltaTime);
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.f);
        }

        // 显示FPS计数器
        if (this.bQ.showFps &&
                this.cT == 0f &&
                !this.cU &&
                !this.cS) {
            this.bO.a(this.u, 17096f, 16908f, this.m);
        }

        // 显示调试文本
        if (com.corrodinggames.rts.game.GameLogic.safeModeReason != null) {
            this.bO.a(com.corrodinggames.rts.game.GameLogic.safeModeReason, 17096f, 17066f, this.m);
        }

        // 绘制触摸控制（如果启用）
        if (!this.gameStarted) {
            if (this.bO.d() == null || com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2) {
                this.bS.c(deltaTime);
            }
        }

        // 绘制游戏结束UI（如果游戏未暂停）
        if (!A()) {
            this.bR.a(deltaTime, 4);
        }

        // 清理自定义渲染
        com.corrodinggames.rts.game.units.custom.j.dE();

        // 完成渲染
        this.bO.h();

        // 恢复缩放变换
        if (applyScale) {
            canvas.a(); // 恢复canvas状态
        }
    }

    public void drawAll(com.corrodinggames.rts.gameFramework.m.l var1, float var2) throws IOException { // b -> drawAll
        if (var1 == null) {
            b("drawAll", "canvas is null, not may not be available yet");
        } else if (!com.corrodinggames.rts.game.GameLogic.isNetworkServerStatic) {
            this.bO.a(var1);
            this.bO.a(this.ao.d());
            this.bO.g();
            ++this.bz;
            com.corrodinggames.rts.gameFramework.m.TeamColorTexture.G = 0.0F;
            if (this.du) {
                this.bO.b(Color.a(0, 0, 0));
                this.bO.a("Loading..", this.co, this.cp, this.dp);
            } else {
                float var3 = this.cn;
                if (var3 != 1.0F) {
                    this.bO.i();
                    this.bO.a(var3, var3);
                }

                boolean var4 = com.corrodinggames.rts.gameFramework.GameEngine.aA();
                if (var4 && this.h(113) && this.h(44)) {
                    var4 = false;
                }

                if (var4) {
                    boolean var5 = this.setupPostprocessing();
                    if (!var5) {
                        var4 = false;
                    }
                }

                if (var4) {
                    this.enableShaderLayer(this.K);

                    try {
                        this.bO.b(Color.a(0, 0, 0));
                        this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
                        this.drawGameWorld((com.corrodinggames.rts.gameFramework.m.l) null, var2);
                        this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
                    } finally {
                        this.disableShaderLayer(this.K);
                    }

                    this.K.b();
                    if (!this.L.a()) {
                        this.enableShaderLayer(this.L);

                        int var14;
                        try {
                            this.bO.b(Color.a(128, 128, 255));
                            this.R();
                            var14 = this.bR.a(var2, 3);
                            this.bR.l = null;
                        } finally {
                            this.disableShaderLayer(this.L);
                        }

                        if (var14 > 0) {
                            float var6 = this.bO.s();
                            this.L.d.a("screenBase", this.K.a);
                            this.L.d.b("screenBaseSize", this.K.a);
                            this.L.d.a("u_resolution", this.cl, this.cm);
                            this.L.d.a("u_offsetBy", 0.2F * this.cX);
                            this.L.d.a("u_uiScaling", var6);
                            this.L.b();
                        }
                    }
                } else {
                    this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
                    this.drawGameWorld(var1, var2);
                    this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.d);
                }

                if (!this.A()) {
                    this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.f);
                    this.drawUI(var1, var2);
                    this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.f);
                }

                if (this.bQ.showFps && this.cT == 0.0F && !this.cU && !this.cS) {
                    this.bO.a(this.u, 100.0F, 35.0F, this.m);
                }

                if (safeModeReason != null) {
                    this.bO.a(safeModeReason, 100.0F, 85.0F, this.m);
                }

                if (!this.gameStarted && (this.bO.d() != null
                        || com.corrodinggames.rts.gameFramework.GameEngine.isAndroidVersionStatic2)) {
                    this.bS.c(var2);
                }

                if (!this.A()) {
                    this.bR.a(var2, 4);
                }

                com.corrodinggames.rts.game.units.custom.j.dE();
                this.bO.h();
                if (var3 != 1.0F) {
                    var1.a();
                }

            }
        }
    }

    public boolean shouldShowUnitIcons() { // j -> shouldShowUnitIcons
        if (!this.bQ.showUnitIcons) {
            return false;
        }
        if ((double) this.cX < 0.7 && this.minZoomLevel >= this.bL.i() - 5.0f && this.uiScale >= this.bL.j() - 5.0f) {
            return true;
        }
        if (com.corrodinggames.rts.game.GameLogic.C()) {
            return (double) this.cX < 0.1;
        }
        if (com.corrodinggames.rts.game.GameLogic.av()) {
            return (double) this.cX < 0.27;
        }
        return (double) this.cX < 0.4;
    }

    public void drawBackground(float f2) { // b -> drawBackground
        boolean bl2 = false;
        if (this.cQ.left < 0 || this.cQ.top < 0 || (float) this.cQ.c > this.bL.i() || (float) this.cQ.d > this.bL.j()) {
            bl2 = true;
        }
        if (bl2) {
            this.bO.b(Color.a(0, 0, 0));
        }
    }

    public void c(float f2) { // c -> drawOverlay
    }

    public void drawGameWorld(com.corrodinggames.rts.gameFramework.m.l var1, float var2) throws IOException { // c -> drawGameWorld
        if (this.loadNewGame) {
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.h);
            this.X.b();
            this.dw = 0;
            boolean var3 = false;
            GGameObject[] var4 = com.corrodinggames.rts.game.units.BaseUnit.fastGameObjectList.a();
            int var5 = com.corrodinggames.rts.gameFramework.GGameObject.fastGameObjectList.size();

            for (int var6 = 0; var6 < var5; ++var6) {
                GGameObject var7 = var4[var6];
                boolean var8 = var7.el;
                boolean var9 = var7.a(this);
                var7.el = var9;
                if (var8 != var9) {
                    var3 = true;
                }

                if (var9) {
                    this.X.a(var7);
                }
            }

            if (this.W.size() != this.X.size()) {
                var3 = true;
            }

            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.h);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.i);
            if (var3) {
                s var12 = this.W;
                this.W = this.X;
                this.X = var12;
            }

            if (!this.shouldShowUnitIcons()) {
                Collections.sort(this.W, com.corrodinggames.rts.gameFramework.GGameObject.ei);
            }

            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.i);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.q);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.s);
            this.bO.i();
            this.bO.a(this.cameraBoundsEnabled);
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.s);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.r);
            this.drawBackground(var2);
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.r);
            if (this.bQ.renderFancyWater) {
                if (this.O == null) {
                    this.O = this.bO.a(com.corrodinggames.rts.R.drawable.water_cloud);
                }

                if (this.P == null) {
                    this.P = this.bO.a(com.corrodinggames.rts.R.drawable.water_layer1);
                }

                if (this.Q == null) {
                    this.Q = this.bO.a(com.corrodinggames.rts.R.drawable.water_layer2);
                }

                this.S.a(this.cameraBoundsEnabled);
                this.R += 0.05F * var2;
                if (this.R > 100.0F) {
                    this.R -= 100.0F;
                }

                this.bO.a(this.O, this.S, (Paint) null, this.cu / 6, this.cv / 6, 1, 1);
                this.S.a(this.cL);
                this.T.a(this.cL);
                this.bO.i();
                this.R();
                this.bO.a(this.Q, this.T, (Paint) null, (float) this.cu + this.R, (float) this.cv + this.R, 0, 0);
                this.bO.a(this.P, this.T, (Paint) null, (float) this.cu, (float) this.cv, 0, 0);
                this.bO.j();
            }

            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.t);
            if (this.bL != null && this.ar()) {
                this.bL.d(var2);
            }

            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.t);
            this.R();
            this.bO.a(this.cL);
            boolean var13 = this.shouldShowUnitIcons();
            this.bU.c(var2);
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.q);
            GGameObject[] var14 = this.W.a();
            int var15 = this.W.size();
            this.mouseScreenX = true;
            this.mouseScreenY = true;
            this.mouseWorldX = true;
            this.mouseWorldY = true;
            this.mousePressed = true;
            if ((double) this.cX < 0.45) {
                this.mouseWorldX = false;
                this.mouseScreenX = false;
                this.mousePressed = false;
            }

            if ((double) this.cX < 0.3) {
                this.mouseWorldY = false;
                this.mouseScreenY = false;
            }

            GGameObject var10;
            int var16;
            if (!var13) {
                for (var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    if (var10.em == 0) {
                        var10.c(var2);
                    }
                }
            }

            com.corrodinggames.rts.gameFramework.effect.a.b(var2);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.g);
            this.bR.b(var2);
            this.bR.a(var2, 1);
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.g);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.p);
            if (var13) {
                if (this.bS.q() == 0) {
                    com.corrodinggames.rts.game.units.BaseUnit.bI.a(255, 195, 195, 195);
                    com.corrodinggames.rts.game.units.BaseUnit.bJ.a(255, 255, 255, 255);
                } else {
                    com.corrodinggames.rts.game.units.BaseUnit.bI.a(175, 175, 175, 175);
                    com.corrodinggames.rts.game.units.BaseUnit.bJ.a(255, 255, 255, 255);
                }

                for (var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    if (!var10.f(var2)) {
                        var10.c(var2);
                    }
                }

                for (var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    var10.a(var2, true);
                    var10.p(var2);
                }
            } else {
                for (var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    var10.d(var2);
                }

                for (var16 = 0; var16 < var5; ++var16) {
                    var10 = var4[var16];
                    if (!var10.el) {
                        if (!(var10 instanceof com.corrodinggames.rts.game.units.BaseUnit)) {
                            continue;
                        }

                        com.corrodinggames.rts.game.units.BaseUnit var11 = (com.corrodinggames.rts.game.units.BaseUnit) var10;
                        if (!var11.cG || var11.bX != this.bs && !var11.cf()) {
                            continue;
                        }
                    }

                    var10.e(var2);
                    if (!var10.el) {
                        var10.p(var2);
                    }
                }

                for (var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    if (var10.em != 0 && var10.em != 10) {
                        var10.c(var2);
                    }
                }

                for (var16 = 0; var16 < var15; ++var16) {
                    var10 = var14[var16];
                    var10.a(var2, false);
                    var10.p(var2);
                }

                com.corrodinggames.rts.game.PlayerTeam.h(var2);

                // OpenAI AI 控制器 tick（仅当有 OpenAI 难度的 AI 玩家时生效）
                try {
                    com.corrodinggames.rts.ai.openai.OpenAIPlayerController.getInstance().tick(var2);
                } catch (Exception openAIEx) {
                    System.out.println("[OpenAI] tick error: " + openAIEx.toString());
                    openAIEx.printStackTrace();
                    com.corrodinggames.rts.gameFramework.GameEngine.a("[OpenAI] tick error: " + openAIEx.toString());
                }
            }

            this.mouseWorldX = true;
            this.mouseWorldY = true;
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.p);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.g);
            this.bR.a(var2, 2);
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.g);

            for (var16 = 0; var16 < var15; ++var16) {
                var10 = var14[var16];
                if (var10.em == 10) {
                    var10.c(var2);
                }
            }

            this.D.b(var2);
            if (this.ce != null) {
                this.ce.a(var2);
            }

            this.c(var2);
            com.corrodinggames.rts.gameFramework.utility.y.b(var2);
            this.cc.c(var2);
            this.cd.a(com.corrodinggames.rts.gameFramework.ProfilerSection.e);
            this.bO.j();
            this.cd.b(com.corrodinggames.rts.gameFramework.ProfilerSection.e);
        }
    }

    public void drawUI(com.corrodinggames.rts.gameFramework.m.l l2, float f2) throws IOException { // d -> drawUI
        this.bS.b(f2);
        if (this.ce != null) {
            this.ce.b(f2);
        }
        this.bW.e(f2);
        if (this.bQ.showFps && this.cT == 0.0f) {
            this.cd.c();
        }
        if (this.ch) {
            this.bO.a("Look Mode", this.co, this.cp, this.dp);
        }
        if (this.bm) {
            int n2 = 20;
            for (int i2 = 0; i2 < com.corrodinggames.rts.game.PlayerTeam.c; ++i2) {
                PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(i2);
                if (n3 == null || !(n3 instanceof com.corrodinggames.rts.game.a.AIController))
                    continue;
                com.corrodinggames.rts.game.a.AIController a2 = (com.corrodinggames.rts.game.a.AIController) n3;
                this.bO.a(a2.k + "| c:" + a2.o, 20.0f, (float) n2, this.dn);
                n2 += 20;
            }
        }
    }

    public void updateCameraSystem() { // k -> updateCameraSystem
        float f2;
        this.cj = this.W();
        this.X();
        this.co = this.cl / 2.0f;
        this.cp = this.cm / 2.0f;
        this.cq = (int) (this.cm / 3.0f);
        if (com.corrodinggames.rts.game.GameLogic.av()) {
            this.cq = (int) (this.cm / 2.5f);
        }
        if (this.cq > (f2 = (float) ((int) (this.cl / 3.0f)))) {
            this.cq = f2;
        }
        int n2 = (int) (250.0f * this.cj);
        this.cq = com.corrodinggames.rts.gameFramework.GameUtils.b(this.cq, 60.0f, (float) n2);
        float f3 = this.cy + this.cameraShakeDecay;
        float f4 = this.cz + this.cameraShakeTime;
        if (this.cS) {
            this.cameraShakeX = this.cl;
            this.cameraShakeY = this.cl;
        } else {
            this.cameraShakeY = this.cl - this.cq + 1.0f;
            this.cameraShakeX = com.corrodinggames.rts.gameFramework.f.g.bO ? this.cl : this.cameraShakeY;
        }
        if (this.cameraShakeX < 1.0f) {
            this.cameraShakeX = 1.0f;
        }
        if (this.cameraShakeY < 1.0f) {
            this.cameraShakeY = 1.0f;
        }
        if (this.cR != this.cS) {
            f3 = !this.cS ? (f3 -= this.cq / 2.0f / this.cX) : (f3 += this.cq / 2.0f / this.cX);
        }
        this.cR = this.cS;
        this.cameraShakeIntensity = this.cm;
        this.screenHeight = this.cameraShakeX / this.cX;
        this.uiScale = this.cameraShakeIntensity / this.cX;
        this.minZoomLevel = this.cameraShakeY / this.cX;
        this.cameraShakeDecay = this.screenHeight / 2.0f;
        this.cameraShakeTime = this.uiScale / 2.0f;
        this.cameraBoundsEnabled.a(0, 0, (int) this.cameraShakeX, (int) this.cameraShakeIntensity);
        this.cL.a(0, 0, (int) this.screenHeight + 1, (int) this.uiScale + 1);
        this.cM.a(0.0f, 0.0f, this.screenHeight + 1.0f, this.uiScale + 1.0f);
        this.a(f3 - this.cameraShakeDecay, f4 - this.cameraShakeTime);
    }

    @Override
    public void updateCameraPosition(int n2, int n3) { // b -> updateCameraPosition
        this.updateCameraPosition(n2, n3, 1.0f);
    }

    public void updateCameraPosition(int n2, int n3, float f2) { // a -> updateCameraPosition
        this.cl = n2;
        this.cm = n3;
        this.cn = f2;
        this.updateCameraSystem();
    }

    @Override
    public String getPackageNameWithContext() { // l -> getPackageNameWithContext
        if (com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2) {
            return "com.corrodinggames.rts.java";
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPCVersionStatic2) {
            return "com.corrodinggames.rts.gdx";
        }
        if (isPausedStatic2) {
            return "com.corrodinggames.rts.server";
        }
        if (this.am == null) {
            return "<null context>";
        }
        return this.am.h();
    }

    @Override
    public String getInstallerPackageName() { // m -> getInstallerPackageName
        if (com.corrodinggames.rts.gameFramework.GameEngine.isIOSVersionStatic2) {
            return "java";
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPCVersionStatic2) {
            return "java-gdx";
        }
        if (isPausedStatic2) {
            return "dedicatedServer";
        }
        if (this.am == null) {
            return "<null context>";
        }
        try {
            PackageManager packageManager = this.am.f();
            String string2 = packageManager.getInstallerPackageName(this.getPackageNameWithContext());
            return string2;
        } catch (IllegalArgumentException illegalArgumentException) {
            return "IllegalArgumentException: " + illegalArgumentException.getMessage();
        }
    }

    @Override
    public boolean isBetaVersion() { // n -> isBetaVersion
        return this.getVersionNumber().contains("p");
    }

    @Override
    public int getVersionCode(boolean bl2) { // c -> getVersionCode
        if (isPausedStatic2 || bl2) {
            return 176;
        }
        try {
            PackageInfo packageInfo = this.am.f().getPackageInfo(this.am.h(), 0);
            int n2 = packageInfo.versionCode;
            return n2;
        } catch (PackageManager.NameNotFoundException nameNotFoundException) {
            throw new RuntimeException(nameNotFoundException);
        }
    }

    public String getSignatureHash() { // o -> getSignatureHash
        if (!com.corrodinggames.rts.game.GameLogic.at()) {
            return null;
        }
        try {
            PackageInfo packageInfo = this.am.f().getPackageInfo(this.am.h(), 64);
            Signature[] signatureArray = packageInfo.signatures;
            int n2 = signatureArray.length;
            int n3 = 0;
            if (n3 < n2) {
                Signature signature = signatureArray[n3];
                String string2 = com.corrodinggames.rts.gameFramework.GameUtils.b(signature.toByteArray());
                return string2;
            }
            return null;
        } catch (PackageManager.NameNotFoundException nameNotFoundException) {
            throw new RuntimeException(nameNotFoundException);
        }
    }

    @Override
    public boolean isDeveloperMode() { // p -> isDeveloperMode
        if (!com.corrodinggames.rts.gameFramework.GameEngine.isDebugVersionStatic2) {
            if (this.isRawBuild()) {
                return true;
            }
            if (aV) {
                return true;
            }
        }
        return false;
    }

    public boolean isRawBuild() { // q -> isRawBuild
        return y.class.getSimpleName().equals("OrderableUnit");
    }

    @Override
    public String getFullVersionString() { // r -> getFullVersionString
        String string2 = this.getVersionDisplayString();
        if ("" != null && !"".equals("")) {
            string2 = string2 + "-";
        }
        return string2;
    }

    @Override
    public void clearVersionCache() { // s -> clearVersionCache
        gameVersionName = null;
        this.getVersionDisplayString();
    }

    @Override
    public String getVersionDisplayString() { // t -> getVersionDisplayString
        if (gameVersionName != null) {
            return gameVersionName;
        }
        String string2 = "v" + this.getBaseVersion();
        if (!com.corrodinggames.rts.gameFramework.GameEngine.as || aV) {
            string2 = "DEBUG BUILD - " + string2;
        } else if (com.corrodinggames.rts.gameFramework.GameEngine.at) {
            string2 = "TESTING BUILD - " + string2;
        } else if (string2.contains("p")){
            string2 = "BETA VERSION - " + string2;
        }
        if (!com.corrodinggames.rts.gameFramework.GameEngine.isDebugVersionStatic2 && this.isRawBuild()) {
            string2 = "RAW - " + string2;
        }
        gameVersionName = string2;
        return gameVersionName;
    }

    @Override
    public String getBaseVersion() { // u -> getBaseVersion
        return "1.15";
    }

    @Override
    public String getVersionNumber() { // v -> getVersionNumber
        return "1.15";
    }

    public synchronized void synchronizedMethod() { // w -> synchronizedMethod
        this.ac = false;
        if (this.ab != null) {
            this.ab.cancel();
            this.ab = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void setGameView(Activity activity, com.corrodinggames.rts.appFramework.f f2, boolean bl2) { // a -> setGameView
        Object object = this.ad;
        synchronized (object) {
            if (!isPausedStatic2) {
                f2.a();
            }
            this.an = activity;
            this.cS = this.gameStarted = bl2;
            if (!(!bl2 || this.loadNewGame || this.bI || com.corrodinggames.rts.gameFramework.GameEngine.noBackground
                    || this.networkEngine.B)) {
                this.loadMenuBackground();
            }
            com.corrodinggames.rts.appFramework.f f3 = this.ap;
            if (this.ao == null) {
                this.ao = f2;
            }
            this.ap = f2;
            if (f3 != null && f3 != f2) {
                f3.j();
            }
            if (f2 != null) {
                f2.m();
            }
            if (this.bS != null) {
                this.bS.e();
            }
            this.synchronizedMethod();
            this.J();
        }
    }

    @Override
    public synchronized void loadMenuBackground() { // x -> loadMenuBackground
        if (this.ae > 20) {
            return;
        }
        int n2 = 3;
        int n3 = this.bQ.nextBackgroundMap++;
        if (this.bQ.nextBackgroundMap > 3) {
            this.bQ.nextBackgroundMap = 1;
        }
        this.bQ.save();
        n3 = com.corrodinggames.rts.gameFramework.GameUtils.b(n3, 1, 3);
        this.dm = null;
        this.menuBackgroundMapFile = "maps/menu_background/menu" + n3 + ".tmx";
        try {
            com.corrodinggames.rts.game.PlayerTeam.b(10, true);
        } catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        for (int i2 = 0; i2 < com.corrodinggames.rts.game.PlayerTeam.c; ++i2) {
            com.corrodinggames.rts.game.a.AIController a2 = new com.corrodinggames.rts.game.a.AIController(i2);
            if (i2 != 0)
                continue;
            this.bs = a2;
        }
        this.startGame(false, com.corrodinggames.rts.gameFramework.GameMode.menu);
        this.bH = true;
        this.bS.y();
        if (!this.loadNewGame) {
            com.corrodinggames.rts.gameFramework.GameEngine.g("Menu load failed");
            ++this.ae;
        }
    }

    void updateCameraFocus(float f2) { // d -> updateCameraFocus
        if (this.gameStarted && !this.bH) {
            if (this.ag == null) {
                this.ag = this.getBaseUnitY();
                if (this.af == this.ag) {
                    this.ag = null;
                }
            }
            if (this.af == null) {
                this.af = this.ag;
                this.ag = null;
            }
            if (this.ah != 0.0f && this.ag != null) {
                this.isAreaVisible(f2, this.ag.posX, this.ag.posY, this.ah * 0.5f);
            }
            if (this.af != null) {
                boolean bl2 = this.isAreaVisible(f2, this.af.posX, this.af.posY, (1.0f - this.ah) * 0.5f);
                float f3 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cy + this.cameraShakeDecay,
                        this.cz + this.cameraShakeTime,
                        this.af.posX, this.af.posY);
                if (f3 < 6400.0f) {
                    bl2 = true;
                }
                if (bl2) {
                    this.ai = true;
                }
            }
            if (this.ai) {
                this.ah += 0.01f * f2;
                if (this.ah >= 1.0f) {
                    this.ah = 0.0f;
                    this.af = null;
                    this.ai = false;
                }
            }
        }
    }

    com.corrodinggames.rts.game.units.BaseUnit findRandomUnit(PlayerTeam n2) { // a -> findRandomUnit
        int n3 = 0;
        for (com.corrodinggames.rts.game.units.BaseUnit am2 : ((List<com.corrodinggames.rts.game.units.BaseUnit>) com.corrodinggames.rts.game.units.BaseUnit.bE)) {
            if (am2.u() || am2.bX != n2 && n2 != null)
                continue;
            ++n3;
        }
        if (n3 > 0) {
            int n4 = com.corrodinggames.rts.gameFramework.GameUtils.a(0, n3 - 1);
            int n5 = 0;
            for (com.corrodinggames.rts.game.units.BaseUnit am3 : ((List<com.corrodinggames.rts.game.units.BaseUnit>) com.corrodinggames.rts.game.units.BaseUnit.bE)) {
                if (am3.u() || am3.bX != n2 && n2 != null)
                    continue;
                if (n5 == n4) {
                    return am3;
                }
                ++n5;
            }
        }
        return null;
    }

    com.corrodinggames.rts.game.units.BaseUnit getBaseUnitY() { // y -> getBaseUnitY
        com.corrodinggames.rts.game.units.BaseUnit am2 = this.findRandomUnit(this.bs);
        if (am2 != null) {
            return am2;
        }
        return this.findRandomUnit((PlayerTeam) null);
    }

    public boolean isAreaVisible(float f2, float f3, float f4, float f5) { // a -> isAreaVisible
        float f6 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.cy + this.cameraShakeDecay,
                this.cz + this.cameraShakeTime, f3, f4);
        float f7 = com.corrodinggames.rts.gameFramework.GameUtils.a(this.cy + this.cameraShakeDecay,
                this.cz + this.cameraShakeTime, f3, f4);
        float f8 = 15.0f;
        float f9 = f5 * f2;
        if (f8 < f9 + 1.0f) {
            f8 = f9 + 1.0f;
        }
        if (f7 < f8 * f8 || this.ct) {
            return true;
        }
        this.zoomLevel += com.corrodinggames.rts.gameFramework.GameUtils.k(f6) * f9;
        this.maxZoomLevel += com.corrodinggames.rts.gameFramework.GameUtils.j(f6) * f9;
        if (com.corrodinggames.rts.gameFramework.GameUtils.c(this.zoomLevel) >= 1.0f
                || com.corrodinggames.rts.gameFramework.GameUtils.c(this.maxZoomLevel) >= 1.0f) {
            this.cy += this.zoomLevel;
            this.cz += this.maxZoomLevel;
            this.zoomLevel = 0.0f;
            this.maxZoomLevel = 0.0f;
            this.a(this.cy, this.cz);
        }
        return false;
    }

    @Override
    public int getUnitChecksum() { // z -> getUnitChecksum
        if (GameEngine.forceCoreUnitCheck) {
            return this.someCounter;
        } else {
            return 678359601;
        }
    }

    static {
        safeModeReason = null;
    }
}