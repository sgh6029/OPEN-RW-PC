/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.MusicManager$1;
import com.corrodinggames.rts.gameFramework.MusicManager$2;
import com.corrodinggames.rts.gameFramework.AndroidMusicFactory;
import com.corrodinggames.rts.gameFramework.MusicFactory;
import com.corrodinggames.rts.gameFramework.GameMusic;
import com.corrodinggames.rts.gameFramework.MusicTrack;
import com.corrodinggames.rts.gameFramework.MusicCategory;
import com.corrodinggames.rts.gameFramework.MusicUpdateThread;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;

import android.content.Context;
import android.util.Log;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MusicManager {
    public static MusicFactory a = new AndroidMusicFactory();
    Object b = new Object();
    Object c = new Object();
    volatile float d = 1.0f;
    MusicUpdateThread e;
    volatile boolean f = false;
    volatile boolean g = true;
    float h = 0.0f;
    int i = 0;
    boolean j = false;
    MusicTrack k;
    boolean l;
    String m;
    boolean n;
    boolean o;
    float p;
    float q;
    float r;
    public boolean s;
    public String t;
    public boolean u;
    String v;
    Context w;
    boolean x;
    boolean y;
    int z;
    MusicTrack A;
    boolean B;
    boolean C;
    float D;
    boolean E = false;
    public boolean F = false;
    boolean G = false;
    float H;
    ArrayList I = new ArrayList();
    static HashMap J = new HashMap();
    static int K = 0;
    boolean L;
    boolean M;
    long N = -1L;

    public float a() {
        GameEngine l2 = GameEngine.getInstance();
        return l2.bQ.musicVolume * l2.bQ.masterVolume;
    }

    public boolean b() {
        if (com.corrodinggames.rts.gameFramework.GameEngine.ax()) {
            return false;
        }
        if (this.u) {
            return false;
        }
        return this.a() > 0.01f;
    }

    public void a(Context context) {
        this.w = context;
        if (com.corrodinggames.rts.gameFramework.GameEngine.ax()) {
            return;
        }
        a.a(this);
        this.k = a.a();
        this.A = a.a();
        MusicCategory.c();
        if (a.d()) {
            this.e = new MusicUpdateThread(this);
            this.e.start();
        }
    }

    public void c() {
        if (!com.corrodinggames.rts.gameFramework.GameEngine.av()) {
            this.l = false;
            this.m = null;
            this.x = true;
            this.B = false;
        }
        this.y = true;
        this.u = false;
    }

    static GameMusic a(String string2, boolean bl2) {
        GameMusic ar2;
        GameMusic ar3 = (GameMusic)J.get(string2);
        if (ar3 != null) {
            return ar3;
        }
        try {
            ar2 = a.a(string2);
        }
        catch (ArithmeticException arithmeticException) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("Error loading:" + string2, (Throwable)arithmeticException);
            if (++K > 2 && K <= 4) {
                com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Failed to load music track:" + string2 + ". Music track skipped.");
            }
            if (!bl2) {
                throw new RuntimeException(arithmeticException);
            }
            return null;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("OutOfMemoryError loading:" + string2, (Throwable)outOfMemoryError);
            com.corrodinggames.rts.gameFramework.GameEngine.aC();
            System.gc();
            com.corrodinggames.rts.gameFramework.GameEngine.aC();
            if (++K < 3) {
                com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Ran out of memory loading music track:" + string2 + ". Music track skipped.");
            }
            if (!bl2) {
                throw new RuntimeException(outOfMemoryError);
            }
            return null;
        }
        catch (Exception exception) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("Exception loading:" + string2, (Throwable)exception);
            if (++K > 2 && K <= 4) {
                com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("Unknown error loading music track:" + string2 + ". Music track skipped.");
            }
            if (!bl2) {
                throw new RuntimeException(exception);
            }
            return null;
        }
        if (bl2) {
            J.put(string2, ar2);
        }
        return ar2;
    }

    public ArrayList d() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : MusicCategory.a.b()) {
            arrayList.add(string2);
        }
        for (String string2 : MusicCategory.b.b()) {
            arrayList.add(string2);
        }
        for (String string2 : MusicCategory.a.b()) {
            arrayList.add(string2);
        }
        return arrayList;
    }

    public String a(MusicCategory at2) {
        return this.a(at2, at2);
    }

    public String a(MusicCategory at2, MusicCategory at3) {
        GameEngine l2 = GameEngine.getInstance();
        MusicCategory at4 = com.corrodinggames.rts.gameFramework.GameUtils.c(at2.b().length + at3.b().length) < at2.b().length ? at2 : at3;
        String[] stringArray = at4.b();
        return at4.a(stringArray[com.corrodinggames.rts.gameFramework.GameUtils.c(stringArray.length)]);
    }

    public synchronized void e() {
        this.s = true;
        this.u = false;
        this.t = null;
    }

    public synchronized void a(String string2) {
        this.s = true;
        this.u = false;
        this.t = string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void a(float f2) {
        if (com.corrodinggames.rts.gameFramework.GameEngine.ax()) {
            return;
        }
        if (!a.d()) {
            if (!this.L) {
                this.b(f2);
            }
            this.g = true;
        }
        this.N = com.corrodinggames.rts.gameFramework.GameEngine.V();
        GameEngine l2 = GameEngine.getInstance();
        if (l2.bT.H.a()) {
            this.e();
        }
        if (this.v != null) {
            NetworkEngine.a((String)null, this.v);
            this.v = null;
        }
        if (this.p != this.a()) {
            this.p = this.a();
            this.o = true;
        }
        Object object = this.c;
        synchronized (object) {
            this.d = f2;
            if (this.L) {
                if (!this.M) {
                    this.M = true;
                    com.corrodinggames.rts.gameFramework.GameEngine.n("Music subsystem crashed, music has been disabled to keep your game running. Please send your logs.");
                }
                return;
            }
            if (!this.g) {
                this.h += f2;
                ++this.i;
                if (this.h > 320.0f && this.i > 80 && !this.j) {
                    this.j = true;
                    com.corrodinggames.rts.gameFramework.GameEngine.n("Lockup detected in music subsystem");
                }
            } else {
                this.h = 0.0f;
                this.i = 0;
            }
            this.g = false;
            this.f = true;
            this.c.notifyAll();
        }
    }

    public String b(String string2) {
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.k(string2);
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.g(string2);
        string2 = string2.replace("[noloop]", "");
        string2 = string2.replace("_", " ");
        return string2;
    }

    public boolean b(float f2) {
        try {
            this.c(f2);
            return true;
        }
        catch (Exception exception) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("Music system crashed", (Throwable)exception);
            this.L = true;
            com.corrodinggames.rts.gameFramework.GameEngine.log("Stopping music");
            try {
                this.g();
            }
            catch (Exception exception2) {
                com.corrodinggames.rts.gameFramework.GameEngine.a("crash stopping music", (Throwable)exception2);
            }
            return false;
        }
    }

    public void c(float f2) {
        if (com.corrodinggames.rts.gameFramework.GameEngine.ax()) {
            return;
        }
        a.a(f2);
        if (!this.b()) {
            if (this.l && this.k.c()) {
                this.g();
                this.l = false;
                this.B = false;
            }
            return;
        }
        boolean bl2 = false;
        if (!this.l) {
            bl2 = true;
        }
        if (this.n) {
            if (!this.C) {
                this.q += f2;
            }
            if (this.q > 600.0f) {
                this.r += f2;
                if (this.r > 100.0f) {
                    this.r = 0.0f;
                    if (!this.l || !this.k.c()) {
                        bl2 = true;
                        this.q = 0.0f;
                    }
                }
            }
        } else {
            this.q += f2;
            if (this.q > 3600.0f) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Next music track, timer:" + this.q);
                bl2 = true;
                this.q = 0.0f;
            }
        }
        if (this.y) {
            b b2 = com.corrodinggames.rts.gameFramework.f.g.z();
            if (b2 != null && b2.N) {
                bl2 = true;
            }
            this.y = false;
        }
        if (bl2 || this.s) {
            Object object;
            Object object2;
            Object object3;
            boolean bl3 = this.s;
            String string2 = this.t;
            if (this.s) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Next music track requested");
                this.s = false;
                this.q = 0.0f;
                this.t = null;
            }
            String string3 = null;
            boolean bl4 = false;
            Object object4 = null;
            if (string2 != null) {
                object3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bZ.i();
                ((ArrayList)object3).addAll(this.d());
                object2 = string2;
                if (string2.endsWith(".ogg") || string2.endsWith(".wav")) {
                    string2 = this.b(string2);
                }
                object = ((ArrayList)object3).iterator();
                while (((Iterator) object).hasNext()) {
                    String string4 = (String)((Iterator) object).next();
                    String string5 = this.b(string4);
                    if (!string5.equalsIgnoreCase((String)object2)) continue;
                    bl4 = true;
                    string3 = string4;
                    break;
                }
                if (string3 == null) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Failed to find requested music: " + (String)object2);
                }
            }
            object3 = com.corrodinggames.rts.gameFramework.f.g.z();
            if (string3 == null && object3 != null && ((b)object3).P < 10 && ((b)object3).N && ((ArrayList)(object2 = ((b)object3).q())).size() > 0) {
                bl4 = true;
                object4 = object3;
                string3 = (String)((ArrayList)object2).get(com.corrodinggames.rts.gameFramework.GameUtils.a(0, ((ArrayList)object2).size() - 1));
                if (bl3 || this.I.contains(string3)) {
                    for (int i2 = 0; i2 < 30 && (string3.equals(this.m) || this.I.contains(string3)); ++i2) {
                        string3 = (String)((ArrayList)object2).get(com.corrodinggames.rts.gameFramework.GameUtils.a(0, ((ArrayList)object2).size() - 1));
                        if (i2 <= 20) continue;
                        this.I.clear();
                    }
                }
                com.corrodinggames.rts.gameFramework.GameEngine.log("Playing music from mod:" + ((b)object3).a() + " - '" + string3 + "'");
            }
            if (string3 == null) {
                string3 = this.x ? this.a(MusicCategory.a) : this.a(MusicCategory.b, MusicCategory.a);
                if (bl3 || this.I.contains(string3)) {
                    for (int i3 = 0; i3 < 30 && (string3.equals(this.m) || this.I.contains(string3)); ++i3) {
                        string3 = this.a(MusicCategory.b, MusicCategory.a);
                        if (i3 <= 20) continue;
                        this.I.clear();
                    }
                }
            }
            if (!string3.equals(this.m)) {
                this.m = string3;
                this.x = false;
                this.q = 0.0f;
                this.n = bl4 || string3.contains("[noloop]");
                this.I.add(string3);
                if (this.I.size() > 4) {
                    this.I.remove(0);
                }
                if (bl3) {
                    this.v = "Now playing: " + this.b(string3);
                }
                MusicTrack as2 = this.k;
                this.k = this.A;
                this.A = as2;
                try {
                    object = MusicManager.a(string3, false);
                }
                catch (RuntimeException runtimeException) {
                    runtimeException.printStackTrace();
                    if (this.z < 3) {
                        this.v = "Failed to open music track: " + string3;
                        ++this.z;
                    }
                    if (object4 != null) {
                        ++((b)object4).P;
                    }
                    return;
                }
                try {
                    this.k.a((GameMusic)object);
                    this.k.a(!this.n);
                }
                catch (RuntimeException runtimeException) {
                    runtimeException.printStackTrace();
                    if (this.z < 3) {
                        this.v = "Failed to play music track: " + string3;
                        ++this.z;
                    }
                    if (object4 != null) {
                        ++((b)object4).P;
                    }
                    return;
                }
                this.E = false;
                if (!bl3 && this.B) {
                    this.E = true;
                }
                if (this.l) {
                    this.B = true;
                }
                this.C = true;
                this.G = false;
                this.D = 1.0f;
                this.l = true;
            } else if (bl3) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("Same music found");
            }
        }
        if (this.C || this.o) {
            float f3;
            float f4;
            boolean bl5 = a.c();
            this.D = !bl5 ? (this.F ? (this.D -= f2 * 0.1f) : (this.D -= f2 * 0.006f)) : (this.F ? (this.D -= f2 * 0.1f) : (this.E ? (this.D -= f2 * 0.003f) : (this.D -= f2 * 0.008f)));
            if (!bl5) {
                f4 = this.D * this.a();
                f3 = (1.0f - this.D) * this.a();
            } else {
                f4 = (this.D * 2.0f - 1.0f) * this.a();
                f3 = (1.0f - this.D * 2.0f) * this.a();
            }
            f4 = com.corrodinggames.rts.gameFramework.GameUtils.b(f4, 0.0f, 1.0f);
            f3 = com.corrodinggames.rts.gameFramework.GameUtils.b(f3, 0.0f, 1.0f);
            if (this.C) {
                if (this.D <= 0.0f) {
                    this.C = false;
                    this.E = false;
                    if (this.B && !this.G) {
                        this.G = true;
                        this.A.d();
                    }
                    if (this.l) {
                        this.k.a(this.a(), this.a());
                    }
                } else {
                    this.H += f2;
                    if (this.H > 10.0f) {
                        this.H = 0.0f;
                        if (this.B && !this.G) {
                            this.A.a(f4, f4);
                            if (f4 < 0.02f) {
                                this.G = true;
                                this.A.d();
                            }
                        }
                        if (this.l) {
                            this.k.a(f3, f3);
                        }
                    }
                }
            } else if (this.l) {
                this.k.a(f3, f3);
            }
        }
        this.o = false;
    }

    public void f() {
        Log.a("RustedWarfare", "Music:pause()");
        MusicManager$1 am$1 = new MusicManager$1(this);
        am$1.start();
    }

    public void g() {
        if (this.l) {
            this.k.a();
        }
        if (this.B) {
            this.A.a();
        }
    }

    public void h() {
        MusicManager$2 am$2 = new MusicManager$2(this);
        am$2.start();
    }

    public void i() {
        a.b();
        if (this.B) {
            this.A.d();
            this.A.e();
        }
        if (this.k != null) {
            this.k.d();
            this.k.e();
        }
        this.k = null;
        this.m = null;
        this.l = false;
    }

    public boolean j() {
        return this.C;
    }
}
