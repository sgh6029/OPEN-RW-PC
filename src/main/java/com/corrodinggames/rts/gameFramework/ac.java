/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;
import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes;
import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes$MissingKey;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

public class ac {
    public static aj a = new al();
    public static InputHandler b = new InputHandler();
    public KeyBinding c;
    public KeyBinding d;
    public KeyBinding e;
    public KeyBinding f;
    public KeyBinding g;
    public KeyBinding h;
    public KeyBinding i;
    public KeyBinding j;
    public KeyBinding k;
    public KeyBinding l = this.a("Debug Left");
    public KeyBinding m = this.a("Debug Right");
    public KeyBinding n = this.b("Camera Up");
    public KeyBinding o = this.b("Camera Down");
    public KeyBinding p = this.b("Camera Left");
    public KeyBinding q = this.b("Camera Right");
    public KeyBinding r = this.b("Zoom In");
    public KeyBinding s = this.b("Zoom Out");
    public KeyBinding t = this.b("Send Chat");
    public KeyBinding u = this.b("Send Team Chat");
    public KeyBinding v = this.b("Ping Map");
    public KeyBinding w = this.b("Show Menu");
    public KeyBinding x = this.b("Save Game");
    public KeyBinding y = this.b("Deselect units");
    public KeyBinding z = this.b("Go to notification");
    public KeyBinding A = this.b("Select Whole Army");
    public KeyBinding B = this.b("Select Command Center");
    public KeyBinding C = this.b("Cycle Builders");
    public KeyBinding D = this.b("Cycle Extractors");
    public KeyBinding E = this.b("Cycle Upgradable Fabricators");
    public KeyBinding F = this.b("Cycle Land Factories");
    public KeyBinding G = this.b("Cycle Air Factories");
    public KeyBinding H = this.b("Next Music Track");
    public ae I = this.c("Game Speed (Single player)");
    public KeyBinding J = this.b("Slower");
    public KeyBinding K = this.b("Faster");
    public KeyBinding L = this.b("Pause Game");
    public ae M = this.c("Unit Actions");
    public KeyBinding N = this.b("Attack Move");
    public KeyBinding O = this.b("Stop");
    public KeyBinding P = this.b("Guard Unit");
    public KeyBinding Q = this.b("Patrol");
    public KeyBinding R = this.b("Reclaim");
    public KeyBinding S = this.b("Action - Upgrade");
    public KeyBinding T = this.b("Action - Set Rally");
    public KeyBinding U = this.a("Debug Editor");
    public KeyBinding V = this.a("Debug Pause");
    public KeyBinding W = this.a("Debug Slow");
    public KeyBinding X = this.a("Debug HideInterface");
    public KeyBinding Y = this.a("Debug HideInterface Temp");
    public KeyBinding Z = this.a("Debug InvincibleUnits");
    public KeyBinding aa = this.a("debugPrintSelectedUnit");
    public KeyBinding ab = this.a("debugDevModeSwitch");
    public KeyBinding ac = this.a("debugAIViewSwitch");
    public KeyBinding ad = this.a("debugMapSwitch");
    public KeyBinding ae = this.a("Debug Take Screenshot");
    public KeyBinding af = this.a("Debug Take Screenshot High");
    public KeyBinding[] ag;
    public ae ah;
    public KeyBinding[] ai;
    public KeyBinding[] aj;
    public KeyBinding[] ak;
    public ArrayList<KeyBinding> al;
    Properties am;
    int an;
    int ao;

    public ac() {
        int n2;
        int n3;
        int n4;
        this.n.a("UP").a("NUMPAD8");
        this.o.a("DOWN").a("NUMPAD2");
        this.p.a("LEFT").a("NUMPAD4");
        this.q.a("RIGHT").a("NUMPAD6");
        this.l.a("F5");
        this.m.a("F6");
        this.x.a("CTRL+S");
        this.t.a("ENTER").a("T");
        this.u.a("SHIFT+ENTER").a("Y");
        this.v.a("CTRL+M").a("CTRL+P");
        this.w.a("ESCAPE").a("F10");
        this.y.a("SPACE");
        this.z.a("CTRL+SPACE");
        this.A.a("CTRL+A");
        this.C.a("CTRL+B");
        this.D.a("CTRL+E");
        this.E.a("CTRL+F");
        this.F.a("CTRL+L");
        this.G.a("CTRL+K");
        this.B.a("CTRL+C");
        this.H.a("CTRL+N");
        this.N.a("A");
        this.L.a("BREAK");
        this.O.a("S");
        this.P.a("G");
        this.Q.a("P");
        this.S.a("U");
        this.T.a("R");
        this.U.a("CTRL+SHIFT+E");
        this.V.a("CTRL+SHIFT+P");
        this.W.a("CTRL+SHIFT+S");
        this.X.a("CTRL+SHIFT+H");
        this.Y.a("CTRL+H");
        this.Z.a("CTRL+SHIFT+I");
        this.aa.a("CTRL+SHIFT+L");
        this.ab.a("CTRL+SHIFT+D");
        this.ac.a("SHIFT+F3");
        this.ad.a("SHIFT+F4");
        this.ae.a("CTRL+SHIFT+ALT+S");
        this.af.a("CTRL+SHIFT+ALT+D");
        this.J.a("minus").a("NUMPADSUBTRACT");
        this.K.a("equals").a("NUMPADADD");
        int[] nArray = new int[]{54, 52, 31, 50, 30, 42, 41, 38, 39, 40, 37, 43};
        this.ag = new KeyBinding[10];
        for (n4 = 0; n4 < this.ag.length; ++n4) {
            this.ag[n4] = this.b("unit action " + (n4 + 1));
            this.ag[n4].c(nArray[n4]);
        }
        this.ah = this.c("Unit Groups");
        this.ak = new KeyBinding[10];
        for (n4 = 0; n4 < this.ak.length; ++n4) {
            this.ak[n4] = this.b("create group " + (n4 + 1));
            n3 = this.a(n4 == 9 ? 0 : n4 + 1);
            n2 = 1;
            this.ak[n4].a(n3, 0, n2, false);
        }
        this.ai = new KeyBinding[10];
        for (n4 = 0; n4 < this.ai.length; ++n4) {
            this.ai[n4] = this.b("select group " + (n4 + 1));
            n3 = this.a(n4 == 9 ? 0 : n4 + 1);
            this.ai[n4].c(n3);
        }
        this.aj = new KeyBinding[10];
        for (n4 = 0; n4 < this.aj.length; ++n4) {
            this.aj[n4] = this.b("Add group to selection " + (n4 + 1));
            n3 = this.a(n4 == 9 ? 0 : n4 + 1);
            n2 = 2;
            this.aj[n4].a(n3, 0, n2, false);
        }
        this.am = new Properties();
        this.an = 0;
        this.ao = 0;
    }

    public int a(int n2) {
        if (n2 >= 10) {
            throw new RuntimeException("number:" + n2 + " too high");
        }
        if (n2 == 0) {
            return 7;
        }
        return 8 + (n2 - 1);
    }

    public KeyBinding a(String string2) {
        if (this.al == null) {
            this.al = new ArrayList<KeyBinding>();
        }
        KeyBinding ad2 = new KeyBinding();
        ad2.a = string2;
        ad2.b = false;
        this.al.add(ad2);
        return ad2;
    }

    public KeyBinding b(String string2) {
        if (this.al == null) {
            this.al = new ArrayList<KeyBinding>();
        }
        KeyBinding ad2 = new KeyBinding();
        ad2.a = string2;
        ad2.b = true;
        this.al.add(ad2);
        return ad2;
    }

    public ae c(String string2) {
        if (this.al == null) {
            this.al = new ArrayList<KeyBinding>();
        }
        ae ae2 = new ae();
        ae2.a = string2;
        ae2.b = true;
        this.al.add(ae2);
        return ae2;
    }

    public void a(String string2, String string3) {
        string2 = string2.toLowerCase(Locale.ENGLISH).trim();
        KeyBinding ad2 = null;
        for (KeyBinding ad3 : this.al) {
            if (ad3.a == null || !ad3.e().equals(string2)) continue;
            ad2 = ad3;
        }
        if (ad2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("loadKey: could not find:" + string2);
            return;
        }
        String[] stringArray = string3.split(",");
        for (int i2 = 0; i2 <= 1 && i2 < stringArray.length; ++i2) {
            String string4 = stringArray[i2];
            if (string4.equalsIgnoreCase("DEFAULT")) continue;
            ad2.a(string4, i2);
            if (ad2.c.size() > i2 && ad2.c.get(i2) != null) {
                ((af)ad2.c.get((int)i2)).d = true;
                continue;
            }
            com.corrodinggames.rts.gameFramework.GameEngine.g("out of range");
        }
    }

    public String a(KeyBinding ad2) {
        String string2 = "";
        boolean bl2 = true;
        for (af af2 : ad2.c) {
            if (bl2) {
                bl2 = false;
            } else {
                string2 = string2 + ",";
            }
            if (af2.d) {
                if (af2.d()) {
                    string2 = string2 + "CLEARED";
                    continue;
                }
                string2 = string2 + af2.c();
                continue;
            }
            string2 = string2 + "DEFAULT";
        }
        return string2;
    }

    public boolean a(KeyBinding ad2, int n2) {
        GameEngine l2 = GameEngine.getInstance();
        af af2 = ad2.a(n2);
        if (af2 == null) {
            return false;
        }
        ArrayList arrayList = l2.bT.al;
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            KeyBinding ad3 = (KeyBinding)arrayList.get(i2);
            if (ad3 == ad2) continue;
            for (af af3 : ad3.c) {
                if (!af2.a(af3)) continue;
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.c = this.a("shoot");
        this.d = this.a("move up");
        this.e = this.a("move down");
        this.f = this.a("move left");
        this.g = this.a("move right");
        this.h = this.a("aim up");
        this.i = this.a("aim down");
        this.j = this.a("aim left");
        this.k = this.a("aim right");
        int n2 = 0;
        this.c.a(n2, "enter", -1);
        this.c.a(n2, "space", -1);
        this.d.a(n2, "w", -1);
        this.e.a(n2, "s", -1);
        this.f.a(n2, "a", -1);
        this.g.a(n2, "d", -1);
        this.h.a(n2, "UP", -1);
        this.i.a(n2, "DOWN", -1);
        this.j.a(n2, "LEFT", -1);
        this.k.a(n2, "RIGHT", -1);
        com.corrodinggames.rts.gameFramework.GameEngine.log("getControllerCount:" + b.a());
        int n3 = 1;
        this.d.b(n2, n3, 0, true);
        this.e.b(n2, n3, 0, false);
        this.f.b(n2, n3, 1, true);
        this.g.b(n2, n3, 1, false);
        this.h.b(n2, n3, 2, true);
        this.i.b(n2, n3, 2, false);
        this.j.b(n2, n3, 3, true);
        this.k.b(n2, n3, 3, false);
        this.c.b(n2, n3, 4, true);
    }

    public void b() {
        if (b.a() != this.ao) {
            this.ao = b.a();
            com.corrodinggames.rts.gameFramework.GameEngine.log("Number of controllers changed, now:" + this.ao);
        }
    }

    public static int d(String string2) throws SlickToAndroidKeycodes$MissingKey {
        if (string2.equalsIgnoreCase("CLEARED")) {
            return 0;
        }
        return SlickToAndroidKeycodes.a(string2);
    }
}

