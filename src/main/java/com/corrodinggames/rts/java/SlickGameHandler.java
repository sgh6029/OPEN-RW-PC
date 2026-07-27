/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.OpenGLException
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.librocket.scripts.ScriptEngine;

import com.corrodinggames.rts.appFramework.m;
import com.corrodinggames.rts.game.GameLogic;
import com.corrodinggames.rts.game.j;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.n;
import com.corrodinggames.rts.gameFramework.m.y;
import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes;

import android.graphics.Color;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Iterator;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.OpenGLException;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

import java.io.FileOutputStream;

public class SlickGameHandler
        extends BasicGame {
    public GameContainer a;
    public Main b;
    public SlickGameContainer c;
    n d;
    GameEngine e;
    HeadlessGameView f;
    boolean g = false;
    Object h = new Object();
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    SlickTexture m;
    SlickTexture n;
    boolean o;
    boolean p = false;
    boolean q = false;
    public boolean r = false;// 初始化完成?
    boolean s = false;
    int t;
    boolean u = false;
    boolean v;
    float w;
    float x;
    boolean y = false;
    private boolean[] Z = new boolean[224];
    int z = 0;
    float A = 0.0f;
    float B = 0.0f;
    int C = 0;
    int D = 0;
    int E;
    int F;
    int G;
    int H;
    boolean I;
    boolean J;
    float K = 0.0f;
    int L = 0;
    String M = "";
    String N = "";
    long O = -9999L;
    float P = 1.0f;
    float Q = 1.0f;
    float R = 1.0f;
    int S = 100;
    int T = 100;
    long U;
    float V = 0.0f;
    float W = 0.0f;
    int X;
    j Y;

    public SlickGameHandler(String string2) {
        super(string2);
    }

    @Override
    public boolean closeRequested() {
        if (this.i) {
            return true;
        }
        if (com.corrodinggames.rts.a.DebugSocketServer.a()) {
            return true;
        }
        if (this.c != null && !this.c.isFullscreen()) {
            ScriptEngine.getInstance().addScriptToQueue("askQuitGame();");
            return false;
        }
        return true;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.a = gameContainer;
        gameContainer.setAlwaysRender(true);
        gameContainer.setForceExit(true);
        gameContainer.setShowFPS(false);
        gameContainer.setTargetFrameRate(300);
        if (com.corrodinggames.rts.gameFramework.GameEngine.noBackground) {
            gameContainer.setShowFPS(true);
            gameContainer.setTargetFrameRate(30);
        }
        gameContainer.setIcons(new String[] { "res/drawable/icon_window.png", "res/drawable/icon_window128.png",
                "res/drawable/icon_window24.png", "res/drawable/icon_window16.png" });
        gameContainer.setUpdateOnlyWhenVisible(false);
        gameContainer.getInput().enableKeyRepeat();
        this.m = com.corrodinggames.rts.java.SlickGraphicsEngine.b(com.corrodinggames.rts.R.drawable.logo, true);
        this.n = com.corrodinggames.rts.java.SlickGraphicsEngine.b(com.corrodinggames.rts.R.drawable.pointer, true);
        gameContainer.setMouseCursor(this.n.C(), 0, 0);
        this.U = System.currentTimeMillis();
    }

    public void a() {
        this.e = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        if (this.a.isVSyncRequested() != this.e.bQ.renderVsync) {
            try {
                this.a.setVSync(this.e.bQ.renderVsync);
            } catch (OpenGLException openGLException) {
                com.corrodinggames.rts.gameFramework.GameEngine.a("Error while changing vsync setting",
                        (Throwable) openGLException);
            }
        }
        if (this.e.bQ.highRefreshRate) {
            this.a.setTargetFrameRate(300);
        } else {
            this.a.setTargetFrameRate(120);
        }
        boolean bl2 = false;
        if (this.e.bQ.enableMouseCapture && (!this.e.bQ.slick2dFullScreen || this.e.cU) && !this.e.gameStarted
                && !this.e.canProcessGameLogic(false) && this.e.bq) {
            bl2 = true;
        }
        if (bl2 != this.v) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Grabbing mouse:" + bl2);
            this.v = bl2;
            if (!this.u) {
                this.a.setMouseGrabbed(this.v);
            }
            if (this.v) {
                // empty if block
            }
            if (!this.v) {
                Mouse.setCursorPosition((int) ((int) (this.w * this.P)),
                        (int) ((int) ((float) Display.getHeight() - this.x * this.P)));
            }
            com.corrodinggames.rts.gameFramework.GameEngine.isNetworkConnectedStatic2 = this.v;
        }
        this.a.setSmoothDeltas(this.e.bQ.renderSmoothDelta);
        if (this.o != Display.isActive()) {
            this.o = Display.isActive();
            if (this.o) {
                this.f();
            }
        }
    }

    public void b() {
        if (this.p) {
            com.corrodinggames.rts.gameFramework.GameEngine.g("loadingStartedThreaded");
            return;
        }
        this.p = true;
        this.c();
    }

    public void c() {
        if (this.q) {
            com.corrodinggames.rts.gameFramework.GameEngine.g("loadingStartedNonThreaded");
            return;
        }
        this.q = true;
        if (this.b == null) {
            this.b = new Main();
        }
        try {
            this.b.h();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.isNetworkConnectedStatic) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("switching to sandbox");
            ScriptEngine.getInstance().addScriptToQueue(
                    "open('sandboxOptions.rml', 'maps/skirmish/[z;p10]Crossing Large (10p).tmx'); loadConfigAndStartNewSandbox('maps/skirmish/[z;p10]Crossing Large (10p).tmx');");
        }
        this.r = true;
    }

    public void a(HeadlessGameView d2) {
        com.corrodinggames.rts.gameFramework.GameEngine.b("SlickContainer:setup");
        this.e = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.f = d2;
        this.f.d = new m();
        this.f.a = this.a.getWidth();
        this.f.b = this.a.getHeight();
        this.e.updateCameraPosition(this.f.a, this.f.b);
        this.d = new n();
    }

    @Override
    public void update(GameContainer gameContainer, int n2) {
        this.t = n2;
    }

    public int a(int n2) {
        if (n2 == 0) {
            return 1;
        }
        if (n2 == 1) {
            return 2;
        }
        if (n2 == 2) {
            return 3;
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("Unknown mouse button:" + n2);
        return 0;
    }

    public void a(int n2, int n3, boolean bl2) {
        if (this.y) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("mouseGrab:m:" + bl2 + ",newX:" + n2 + ",newY:" + n3);
        }
        if (!this.v) {
            this.w = (int) ((float) n2 / this.P);
            this.x = (int) ((float) n3 / this.P);
        } else {
            if (bl2) {
                int n4;
                int n5;
                if (this.u) {
                    n5 = n2 - this.S;
                    n4 = n3 - this.T;
                } else {
                    n5 = n2;
                    n4 = n3;
                }
                this.w += (float) n5 / this.P;
                this.x += (float) n4 / this.P;
            } else {
                this.w = (int) ((float) n2 / this.P);
                this.x = (int) ((float) n3 / this.P);
            }
            if (this.w < 0.0f) {
                this.w = 0.0f;
            }
            if (this.x < 0.0f) {
                this.x = 0.0f;
            }
            if (this.f != null) {
                if (this.w > (float) (this.f.o() - 1)) {
                    this.w = this.f.o() - 1;
                }
                if (this.x > (float) (this.f.p() - 1)) {
                    this.x = this.f.p() - 1;
                }
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.log("processMouseGrab gameView==null");
            }
        }
    }

    @Override
    public void mousePressed(int n2, int n3, int n4) {
        this.a(n3, n4, false);
        if (this.d()) {
            this.a(this.w, this.x);
            this.b.slickLibRocketManager.processMouseButtonDown(0, 0);
            return;
        }
        if (this.f != null) {
            int n5 = this.a(n2);
            if (n5 != 0) {
                this.f.d.a(this.w, this.x, true, n5);
            }
            return;
        }
    }

    public void a(float f2, float f3) {
        f2 *= this.P;
        f3 *= this.P;
        this.b.slickLibRocketManager.mouseMove((int) (f2 /= this.R), (int) (f3 /= this.R), 0);
    }

    @Override
    public void mouseDragged(int n2, int n3, int n4, int n5) {
        this.a(n4, n5, true);
        if (this.d()) {
            this.a(this.w, this.x);
            return;
        }
        if (this.f != null) {
            this.f.d.a(this.w, this.x);
            return;
        }
    }

    @Override
    public void mouseMoved(int n2, int n3, int n4, int n5) {
        this.a(n4, n5, true);
        if (this.d()) {
            this.a(this.w, this.x);
            return;
        }
        if (this.f != null) {
            this.f.d.a(this.w, this.x);
            return;
        }
    }

    @Override
    public void mouseReleased(int n2, int n3, int n4) {
        this.a(n3, n4, false);
        if (this.d()) {
            this.b.slickLibRocketManager.processMouseButtonUp(0, 0);
            return;
        }
        if (this.f != null) {
            int n5 = this.a(n2);
            if (n5 != 0) {
                this.f.d.a(this.w, this.x, false, n5);
            }
            return;
        }
    }

    @Override
    public void mouseWheelMoved(int n2) {
        if (this.d()) {
            this.b.slickLibRocketManager.processMouseWheel(-(n2 / 120) * 2, 0);
            return;
        }
        if (this.e != null) {
            this.e.k(n2);
            return;
        }
    }

    boolean d() {
        return this.b != null && this.b.slickLibRocketManager != null && !this.b.slickLibRocketManager.b();
    }

    public boolean b(int n2) {
        if (n2 >= this.Z.length || n2 < 0) {
            return false;
        }
        return this.Z[n2];
    }

    public int e() {
        int n2 = 0;
        if (this.b(42) || this.b(54)) {
            n2 += 2;
        }
        if (this.b(29) || this.b(157)) {
            ++n2;
        }
        if (this.b(56) || this.b(184)) {
            n2 += 4;
        }
        return n2;
    }

    public void a(int n2, boolean bl2) {
        if (n2 >= this.Z.length || n2 < 0) {
            return;
        }
        this.Z[n2] = bl2;
    }

    public void f() {
        for (int i2 = 0; i2 < this.Z.length; ++i2) {
            if (!this.Z[i2])
                continue;
            this.c(i2);
        }
    }

    @Override
    public void keyPressed(int n2, char c2) {
        this.a(n2, true);
        if (this.b.guiEngine == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("keyPressed: guiEngine==null");
            return;
        }
        this.b.guiEngine.a(n2, c2);
    }

    public void c(int n2) {
        this.keyReleased(n2, '\u0000');
    }

    @Override
    public void keyReleased(int n2, char c2) {
        this.a(n2, false);
        if (this.d()) {
            Integer n3 = SlickToAndroidKeycodes.c(n2);
            if (n3 != null) {
                this.b.slickLibRocketManager.processKeyUp(n3, this.e());
            } else if (!Character.isISOControl(c2)) {
                // empty if block
            }
        }
        if (this.e != null) {
            this.e.b(SlickToAndroidKeycodes.b(n2), false);
            return;
        }
    }

    public void a(int n2, int n3) {
        this.E = n2;
        this.F = n3;
        this.g();
    }

    public void g() {
        if (this.l) {
            return;
        }
        if (this.i) {
            return;
        }
        try {
            int n2;
            boolean bl2 = this.e.bQ.slick2dFullScreen;
            boolean bl3 = this.e.bQ.slick2dBorderless;
            if (bl3) {
                bl2 = true;
            }
            int n3 = this.E;
            int n4 = this.F;
            if (bl2) {
                n3 = this.c.getScreenWidth();
                n4 = this.c.getScreenHeight();
                String string2 = this.e.bQ.slick2dFullScreenResolution;
                if (string2 == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("fullScreenResolutionString is null");
                    string2 = "native";
                }
                if (!string2.equals("native")) {
                    String[] stringArray = string2.split("x");
                    if (stringArray.length != 2) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("Unknown resolution format:" + string2);
                    } else {
                        Integer n5 = com.corrodinggames.rts.gameFramework.GameUtils.l(stringArray[0]);
                        Integer n6 = com.corrodinggames.rts.gameFramework.GameUtils.l(stringArray[1]);
                        if (n5 == null || n6 == null) {
                            com.corrodinggames.rts.gameFramework.GameEngine.b("Bad resolution int:" + string2);
                        } else {
                            n3 = n5;
                            n4 = n6;
                        }
                    }
                }
            }
            float f2 = 1.0f;
            if ((float) n3 > 3360.0f || (float) n4 > 1890.0f) {
                f2 = 2.0f;
            } else if ((float) n3 > 2688.0f || (float) n4 > 1512.0f) {
                f2 = 1.5f;
            }
            float f3 = this.e.bQ.renderDensity;
            if (this.I == bl2 && this.J == bl3 && this.E == this.G && this.F == this.H
                    && com.corrodinggames.rts.gameFramework.GameUtils.h(f2 *= this.e.bQ.uiRenderScale, this.P)
                    && com.corrodinggames.rts.gameFramework.GameUtils.h(f3, this.Q)) {
                return;
            }
            int n7 = n3;
            int n8 = n4;
            boolean bl4 = this.J != bl3;
            this.P = f2;
            this.Q = f3;
            this.R = this.P;
            this.R *= (this.Q - 1.0f) * 0.5f + 1.0f;
            this.G = this.E;
            this.H = this.F;
            this.I = bl2;
            this.J = bl3;
            boolean bl5 = false;
            if (bl3 && bl2) {
                bl5 = true;
            }
            System.setProperty("org.lwjgl.opengl.Window.undecorated", bl5 ? "true" : "false");
            if (bl2) {
                com.corrodinggames.rts.gameFramework.GameEngine
                        .log("screen: " + this.c.getScreenWidth() + ", " + this.c.getScreenHeight());
                com.corrodinggames.rts.gameFramework.GameEngine
                        .log("container: " + this.a.getWidth() + ", " + this.a.getHeight());
                if (bl3) {
                    this.c.setDisplayMode(n7, n8, false);
                } else {
                    this.c.setDisplayMode(n7, n8, true);
                }
            } else {
                n2 = 0;
                if (this.c.isFullscreen()) {
                    n2 = 1;
                }
                if (bl4) {
                    n2 = 1;
                    if (n7 > 2 && n8 > 2) {
                        this.c.setDisplayMode(n7 - 1, n8 - 1, false);
                    }
                }
                if (n2 != 0) {
                    this.c.setDisplayMode(n7, n8, false);
                    Display.setResizable((boolean) false);
                    Display.setResizable((boolean) true);
                } else {
                    SGL sGL = Renderer.get();
                    sGL.initDisplay(n7, n8);
                    sGL.enterOrtho(n7, n8);
                    Field field = GameContainer.class.getDeclaredField("width");
                    field.setAccessible(true);
                    field.set(this.c, n7);
                    Field field2 = GameContainer.class.getDeclaredField("height");
                    field2.setAccessible(true);
                    field2.set(this.c, n8);
                }
            }
            this.S = Display.getWidth() / 2;
            this.T = Display.getHeight() / 2;
            n2 = (int) ((float) n7 / this.P);
            int n9 = (int) ((float) n8 / this.P);
            int n10 = (int) ((float) n7 / this.R);
            int n11 = (int) ((float) n8 / this.R);
            if (this.f != null) {
                this.f.a = n2;
                this.f.b = n9;
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.log("setResolution: gameView=null");
            }
            if (this.e != null) {
                this.e.updateCameraPosition(n2, n9);
                this.e.X();
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.log("setResolution: game=null");
            }
            if (this.b != null && this.b.slickLibRocketManager != null) {
                this.b.slickLibRocketManager.setDimensionsWrap(n10, n11);
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.log("setResolution: main.libRocket=null");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(String string2, boolean bl2) {
        boolean bl3 = true;
        if (!string2.startsWith("Loading units ")) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("--Now loading:" + string2);
            bl3 = false;
        }
        if (bl2) {
            this.N = this.M;
            this.M = string2;
        }
        long l2 = System.currentTimeMillis();
        if (bl3 && l2 < this.O + 10L) {
            return;
        }
        this.O = l2;
        Graphics graphics = this.c.a();
        this.a(this.c, graphics);
        this.c.a(graphics);
    }

    public void a(GameContainer gameContainer, Graphics graphics) {
        int n2;
        this.K += (float) this.t;
        ++this.L;
        graphics.setColor(org.newdawn.slick.Color.black);
        graphics.clear();
        if (this.m != null) {
            graphics.drawImage(this.m.C(), Display.getWidth() / 2 - this.m.p / 2,
                    Display.getHeight() / 2 - this.m.q / 2);
        }
        String string2 = "Loading";
        int n3 = this.L % 4;
        for (n2 = 0; n2 <= n3; ++n2) {
            string2 = string2 + ".";
        }
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.e("    " + string2, 17);
        n2 = graphics.getFont().getWidth(string2);
        int n4 = Display.getHeight() - 70;
        graphics.setColor(org.newdawn.slick.Color.white);
        graphics.drawString(string2, Display.getWidth() / 2 - n2 / 2, n4);
        graphics.setColor(new org.newdawn.slick.Color(1.0f, 1.0f, 1.0f, 0.6f));
        n2 = graphics.getFont().getWidth(this.M);
        graphics.drawString(this.M, Display.getWidth() / 2 - n2 / 2, n4 + 20);
    }

    public void a(SlickGraphicsEngine e2) {
        e2.k();
        if (this.P != 1.0f) {
            e2.a(this.P, this.P);
        }
    }

    public void b(SlickGraphicsEngine e2) {
        e2.l();
    }

    public void a(Graphics graphics, float f2) {
        graphics.pushTransform();
        graphics.scale(f2, f2);
    }

    public void a(Graphics graphics) {
        graphics.popTransform();
    }

    @Override
    public void render(GameContainer var1, Graphics var2) {
        long var3 = System.currentTimeMillis();
        float var5 = (float) (var3 - this.U) * 0.060000002F;
        int var6 = (int) (var3 - this.U);
        this.U = var3;
        if (this.v && this.u && var1.hasFocus()) {
            Mouse.setCursorPosition(this.S, this.T);
        }

        if (!this.r) {
            this.a(var1, var2);
            if (!this.s) {
                this.s = true;
            } else {
                if (!this.p) {
                    this.b();
                }

            }
        } else if (this.e == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("render: game==null");
        } else {
            this.a();
            float var7 = (float) this.t * 0.060000002F;
            int var8 = Display.getWidth();
            int var9 = Display.getHeight();
            if (var8 != this.G || var9 != this.H) {
                if (this.C != var8 || this.D != var9) {
                    this.C = var8;
                    this.D = var9;
                    this.B = 0.0F;
                }

                this.B += var7;
                this.A += var7;
                if (this.A > 300.0F || this.B > 20.0F || this.A > 0.0F) {
                    this.A = 0.0F;
                    this.B = 0.0F;
                    this.a(var8, var9);
                }
            }

            float var10 = this.R;
            this.b.a(var7);
            if (this.e.bQ.liveReloading) {
                ++this.z;
                if (this.z > 30) {
                    this.z = 0;
                    if (com.corrodinggames.rts.java.SlickTexture.y != null) {
                        Iterator var11 = com.corrodinggames.rts.java.SlickTexture.y.iterator();

                        while (var11.hasNext()) {
                            SlickTexture var12 = (SlickTexture) var11.next();
                            var12.t();
                        }
                    }

                    if (!this.e.h(48)) {
                        this.b.slickLibRocketManager.detectChangesAndReload();
                    }
                }
            }

            boolean var16 = false;
            SlickGraphicsEngine var17 = null;
            if (!this.e.loadNewGame) {
                var2.setColor(org.newdawn.slick.Color.gray);
                var2.resetTransform();
                var2.clearClip();
                var2.clear();
                if (!this.d() && !this.e.bI) {
                    ++this.X;
                    if (this.X > 100) {
                        this.X = 0;
                        com.corrodinggames.rts.gameFramework.GameEngine.log("Fail safe menu");
                        com.corrodinggames.librocket.a.a().b();
                    }
                }
            } else {
                this.X = 0;
            }

            boolean var13 = this.e.bT.ae.a();
            boolean var14 = this.e.bl && this.e.bT.af.a();
            if (var14) {
                var13 = true;
            }

            if (this.e.loadNewGame) {
                var2.resetTransform();
                if (!this.e.dv) {
                    var2.clearClip();
                    var2.clear();
                }

                var2.setColor(org.newdawn.slick.Color.black);
                if (!com.corrodinggames.rts.gameFramework.GameEngine.isNetworkServerStatic) {
                    var17 = (SlickGraphicsEngine) this.e.bO;
                    if (var17 != null) {
                        var17.f = var2;
                        var17.L = this.P;
                        var16 = true;
                        this.a(var17);
                    }
                }

                boolean var15 = this.e.cS;
                if (var13) {
                    this.e.cS = true;
                }

                try {
                    this.e.processGameFrame(var7, this.t);// GameEngine的绘制方法
                } catch (UnsupportedEncodingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                if (var13) {
                    this.e.cS = var15;
                }

                this.t = 0;
                if (!com.corrodinggames.rts.gameFramework.GameEngine.isNetworkServerStatic && var16) {
                    this.b(var17);
                }
            } else {
                this.e.networkEngine.b(var7);
                this.e.bN.a(var7);
            }

            this.a(var2, var10);
            com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a().a(0.0F);
            this.b.slickLibRocketManager.c.update(var7);
            if (!this.b.slickLibRocketManager.b()) {
                this.b.slickLibRocketManager.a(var2);
                this.b.slickLibRocketManager.update();
                this.b.slickLibRocketManager.render();
                this.b.slickLibRocketManager.c.checkForErrors();
                this.b.slickLibRocketManager.debug = false;
            }

            this.b.slickLibRocketManager.postUpdate();
            this.a(var2);
            if (this.i) {
                var2.clear();
            }

            if (this.v && !var13 && !this.e.cU) {
                var2.drawImage(this.n.C(), this.w * this.P, this.x * this.P);
            }

            if (var13) {
                this.a(var2, var14);
            }

            if (this.b.u) {
                ++this.b.v;
                if (this.b.v > 2) {
                    this.b.u = false;
                    this.b.v = 0;
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Saving settings (queued)");
                    this.e.bQ.save();
                }
            }

        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Graphics graphics, boolean bl2) {
        HeadlessGameView d2 = this.f;
        boolean bl3 = false;
        int n2 = 10;
        int n3 = 10;
        if (d2 != null) {
            n2 = d2.a;
            n3 = d2.b;
        }
        try {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Saving screenshot");
            String string2 = "screenshots";
            File file = new File("screenshots");
            if (!file.exists()) {
                file.mkdir();
            }
            String string3 = "screenshot_" + com.corrodinggames.rts.gameFramework.GameUtils.a("d MMM yyyy HH.mm.ss")
                    + ".png";
            String string4 = "screenshots" + File.separator + string3;
            if (bl2) {
                if (this.Y == null) {
                    this.Y = new j();
                }
                bl3 = true;
                float f2 = 2.0f;
                int n4 = (int) ((float) d2.a * f2);
                int n5 = (int) ((float) d2.b * f2);
                y y2 = this.e.bO;
                this.Y.a(y2, n4, n5, 0);
                GameLogic i2 = (GameLogic) this.e;
                boolean bl4 = this.e.cS;
                i2.enableShaderLayer(this.Y);
                this.e.cS = true;
                try {
                    this.e.bO.b(Color.a(0, 0, 0));
                    com.corrodinggames.rts.gameFramework.m.l l2 = d2.b(true);
                    i2.updateCameraPosition(n4, n5);
                    i2.updateCameraSystem();
                    i2.processGameFrame(0.0f, 0);
                    i2.updateCameraPosition(n2, n3);
                    i2.updateCameraSystem();
                } finally {
                    i2.disableShaderLayer(this.Y);
                    this.e.cS = bl4;
                }
                y2.a(this.Y.a, new File(string4));
                com.corrodinggames.rts.gameFramework.GameEngine.f(null, "Saving large screenshot: " + string3);
                return;
            }
            Image image = new Image(this.c.getWidth(), this.c.getHeight());
            graphics.copyArea(image, 0, 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageOut.write(image, "png", byteArrayOutputStream);
            com.corrodinggames.rts.gameFramework.GameEngine.f(null, "Saving screenshot: " + string3);
            u$1 u$1 = new u$1(this, string4, byteArrayOutputStream, string3);
            Thread thread = new Thread(u$1);
            thread.start();
        } catch (Exception exception) {
            exception.printStackTrace();
            com.corrodinggames.rts.gameFramework.GameEngine.n("Failed to take screenshot:" + exception.getMessage());
            return;
        } finally {
            if (d2 != null) {
                d2.a = n2;
                d2.b = n3;
            }
        }
    }
}

class u$1
        implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ByteArrayOutputStream b;
    final /* synthetic */ String c;
    final /* synthetic */ SlickGameHandler d;

    u$1(SlickGameHandler u2, String string2, ByteArrayOutputStream byteArrayOutputStream, String string3) {
        this.d = u2;
        this.a = string2;
        this.b = byteArrayOutputStream;
        this.c = string3;
    }

    @Override
    public void run() {
        try {
            try (FileOutputStream fileOutputStream = new FileOutputStream(this.a);) {
                fileOutputStream.write(this.b.toByteArray());
            }
            GameEngine.log("Screenshot saved: " + this.c);
        } catch (Exception exception) {
            exception.printStackTrace();
            GameEngine.n("Failed to write screenshot:" + exception.getMessage());
        }
    }
}