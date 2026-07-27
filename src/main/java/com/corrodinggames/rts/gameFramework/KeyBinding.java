/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes$MissingKey;
import java.util.ArrayList;
import java.util.Locale;

public class KeyBinding {
    public String a;
    public boolean b = false;
    public ArrayList<af> c = new ArrayList<af>();
    public ArrayList d = new ArrayList();

    public boolean a() {
        for (af af2 : this.c) {
            if (af2.a != -1 || !af2.a()) continue;
            return true;
        }
        return false;
    }

    public boolean b() {
        for (af af2 : this.c) {
            if (af2 == null || af2.a != -1 || !af2.b()) continue;
            return true;
        }
        return false;
    }

    public String c() {
        for (af af2 : this.c) {
            if (af2 == null) continue;
            return af2.c().toUpperCase();
        }
        return "";
    }

    public af a(int n2) {
        if (this.c.size() > n2) {
            af af2 = (af)this.c.get(n2);
            return af2;
        }
        return null;
    }

    public String b(int n2) {
        if (this.c.size() > n2) {
            af af2 = (af)this.c.get(n2);
            if (af2 == null) {
                return "<null>";
            }
            return af2.c().toUpperCase();
        }
        return "";
    }

    public KeyBinding c(int n2) {
        int n3 = 0;
        return this.a(n2, 0, n3, false);
    }

    public KeyBinding a(int n2, int n3, int n4, boolean bl2) {
        ag ag2 = new ag();
        ag2.e = n2;
        ag2.a = -1;
        ag2.b = n4;
        if (bl2) {
            ag2.d = true;
        }
        if (this.c.size() <= n3) {
            this.c.add(new ak());
        }
        if (this.c.size() <= n3) {
            this.c.add(new ak());
        }
        this.c.set(n3, ag2);
        return this;
    }

    public KeyBinding a(String string2) {
        return this.a(string2, -1);
    }

    public KeyBinding a(String string2, int n2) {
        if (string2 == null) {
            throw new RuntimeException("key==null");
        }
        return this.a(-1, string2, n2);
    }

    public KeyBinding a(int n2, String string2, int n3) {
        block10: {
            if (string2 == null) {
                throw new RuntimeException("key==null");
            }
            ag ag2 = new ag();
            ag2.a = n2;
            ag2.b = 0;
            if ((string2 = string2.toLowerCase(Locale.ENGLISH)).contains("alt+")) {
                string2 = string2.replace("alt+", "");
                ag2.b += 4;
            }
            if (string2.contains("ctrl+")) {
                string2 = string2.replace("ctrl+", "");
                ++ag2.b;
            }
            if (string2.contains("shift+")) {
                string2 = string2.replace("shift+", "");
                ag2.b += 2;
            }
            try {
                ag2.e = ac.d(string2);
                if (n3 == -1) {
                    this.c.add(ag2);
                } else {
                    if (this.c.size() <= n3) {
                        this.c.add(new ak());
                    }
                    if (this.c.size() <= n3) {
                        this.c.add(new ak());
                    }
                    this.c.set(n3, ag2);
                }
            }
            catch (SlickToAndroidKeycodes$MissingKey slickToAndroidKeycodes$MissingKey) {
                slickToAndroidKeycodes$MissingKey.printStackTrace();
                GameEngine l2 = GameEngine.getInstance();
                if (l2 == null) break block10;
                l2.a(slickToAndroidKeycodes$MissingKey.getMessage(), 1);
            }
        }
        return this;
    }

    public KeyBinding b(int n2, int n3, int n4, boolean bl2) {
        ah ah2 = new ah();
        ah2.a = n2;
        ah2.e = n3;
        ah2.f = n4;
        ah2.g = bl2;
        try {
            ah2.i = ah2.a(true);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            GameEngine.b("Failed to bind Axis:" + n4 + " on joystick:" + n3);
            return this;
        }
        this.c.add(ah2);
        return this;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.a.replace("-", "").replace("  ", " ").replace("  ", " ").replace(" ", "_").toLowerCase(Locale.ENGLISH);
    }
}

