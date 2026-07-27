package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.n;
import com.corrodinggames.rts.game.units.custom.d_f;
import com.corrodinggames.rts.game.units.custom.c_f5;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.ba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f_f6 {
    public String a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public boolean g;
    public float h;
    public float i;
    public LogicBoolean j;
    public com.corrodinggames.rts.game.units.custom.m k;
    public m l;
    public boolean m;
    public float n;
    public boolean o;
    public ArrayList<n> p;
    public float q;

    public f_f6(String str) {
        this.l = new m();
        this.m = true;
        this.p = new ArrayList();
        this.a = str;
    }

    public c_f5 a(String str, String str2) throws bo {
        int i = -1;
        d_f d_fVar;
        if (str2.startsWith("leg") || str2.startsWith("arm")) {
            if ("x".equalsIgnoreCase(str)) {
                d_fVar = d_f.legX;
            } else if ("y".equalsIgnoreCase(str)) {
                d_fVar = d_f.legY;
            } else if ("dir".equalsIgnoreCase(str)) {
                d_fVar = d_f.legDir;
            } else if ("height".equalsIgnoreCase(str)) {
                d_fVar = d_f.legHeight;
            } else if ("alpha".equalsIgnoreCase(str)) {
                d_fVar = d_f.legAlpha;
            } else {
                throw new bo("Unknown leg/arm animation type:" + str + " on animation:" + this.a);
            }
        } else if (str2.startsWith("turret")) {
            i = Integer.parseInt(str2.substring("turret".length())) - 1;
            if ("x".equalsIgnoreCase(str)) {
                d_fVar = d_f.turretX;
            } else if ("y".equalsIgnoreCase(str)) {
                d_fVar = d_f.turretY;
            } else {
                throw new bo("Unknown turret animation type:" + str + " on animation:" + this.a);
            }
        } else if (str2.startsWith("body")) {
            if ("scale".equalsIgnoreCase(str)) {
                d_fVar = d_f.scale;
            } else if ("frame".equalsIgnoreCase(str)) {
                d_fVar = d_f.frame;
            } else {
                throw new bo("Unknown body animation type:" + str + " on animation:" + this.a);
            }
        } else if (str2.startsWith("effect")) {
            d_fVar = d_f.event;
            str2 = "event";
        } else {
            throw new bo("Unknown animation target:" + str2 + " on animation:" + this.a);
        }
        Iterator<c_f5> it = this.l.iterator();
        while (it.hasNext()) {
            c_f5 next = it.next();
            if (next.a == d_fVar && next.c.equals(str2)) {
                return next;
            }
        }
        c_f5 c_f5Var = new c_f5();
        c_f5Var.a = d_fVar;
        c_f5Var.b = i;
        c_f5Var.c = str2;
        this.l.add(c_f5Var);
        return c_f5Var;
    }

    // public void a(l lVar) throws bo {
    //     Iterator<c_f5> it = this.l.iterator();
    //     while (it.hasNext()) {
    //         c_f5 next = it.next();
    //         if (next.a == d_f.legX || next.a == d_f.legY || next.a == d_f.legHeight || next.a == d_f.legDir || next.a == d_f.legAlpha) {
    //             ba[] baVarArr = lVar.ax;
    //             int length = baVarArr.length;
    //             boolean z = false;
    //             int i = 0;
    //             while (i < length) {
    //                 ba baVar = baVarArr[i];
    //                 GameEngine.e("=========|||"+baVar.a+"|||||"+baVar.b+"|||||"+next.c);
    //                 if (next.c.equals(baVar.b)) {
    //                     next.b = baVar.a;
    //                     z = true;
    //                     break;
    //                 }
    //                 i++;
    //             }
    //             if (!z) {
    //                 throw new bo("Cannot find leg:" + next.c + " for animation:" + this.a);
    //             }
    //         }
    //         if (next.b < 0) {
    //             throw new bo("Cannot find target for:" + next.c + " for animation:" + this.a);
    //         }
    //     }
    // }
    
    @SuppressWarnings("unchecked")
    public void a(final l l) throws bo {
        for (final c_f5 c : ((List<c_f5>)this.l) ){
            if (c.a == d_f.legX|| c.a == d_f.legY || c.a ==d_f.legDir || c.a == d_f.legHeight || c.a == d_f.legDir) {
                boolean b = false;
                for (final ba ba : l.ax) {
                    if (c.c.equals(ba.b)) {
                        c.b = ba.a;
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    throw new bo("Cannot find leg:" + c.c + " for animation:" + this.a);
                }
            }
            GameEngine.log("AAAAAAAAAAAAAA||"+c.b+"|||");
            if (c.b < 0) {
                throw new bo("Cannot find target for:" + c.c + " for animation:" + this.a);
            }
        }
    }

    public void a(l lVar, IniFile abVar, String str, String str2) throws bo {
        String b = abVar.b(str, str2 + "onActions", (String)null);
        if (b != null) {
            for (String trim : b.split(",")) {
                String trim2 = trim.trim();
                if (!"".equals(trim2)) {
                    n a = com.corrodinggames.rts.game.units.custom.n.a(trim2);
                    if (a == null) {
                        throw new bo("Unknown action type: " + trim2 + " on animation:" + this.a);
                    }
                    f_f6 a2 = lVar.a(a);
                    if (a2 != null) {
                        throw new bo("Cannot add action: " + trim2 + " to:" + this.a + " it already exists on:" + a2.a);
                    }
                    this.p.add(a);
                }
            }
        }
        this.q = abVar.a(str, str2 + "onActionsQueuedUnitPlayAt", Float.valueOf(0.0f)).floatValue();
        this.b = abVar.b(str, str2 + "start", Integer.valueOf(0)).intValue();
        this.c = abVar.b(str, str2 + "end", Integer.valueOf(-1)).intValue();
        if (this.c != -1 && this.c < this.b) {
            throw new RuntimeException("animationEnd cannot before animationStart on animation:" + this.a);
        }
        this.k = com.corrodinggames.rts.game.units.custom.m.a(lVar, abVar, str, "", true);
        this.h = abVar.d(str, str2 + "blendIn", Float.valueOf(-16512.0f)).floatValue();
        this.i = abVar.d(str, str2 + "blendOut", Float.valueOf(-16512.0f)).floatValue();
        this.j = abVar.a(lVar, str, str2 + "playbackRate", (LogicBoolean)null, LogicBoolean$ReturnType.number);
        this.d = abVar.a(str, str2 + "scale_start", Float.valueOf(1.0f)).floatValue();
        this.e = abVar.a(str, str2 + "scale_end", Float.valueOf(1.0f)).floatValue();
        Float a3 = abVar.a(str, str2 + "speed", (Float)null);
        String str3 = "speed";
        boolean z = false;
        if (a3 != null) {
            this.f = a3.floatValue();
            z = true;
        } else {
            this.f = 1.0f;
        }
        this.g = abVar.a(str, str2 + "pingPong", Boolean.valueOf(false)).booleanValue();
        float f2 = 1.0f * this.f;
        float a4 = abVar.a(str, str2 + "KeyframeTimeScale", Float.valueOf(1.0f)).floatValue();
        String str4 = str3;
        boolean z2 = z;
        if (this.c != -1) {
            z2 = true;
            str4 = "animationEnd";
            c_f5 c_f5Var = new c_f5();
            c_f5Var.a = d_f.frame;
            this.l.add(c_f5Var);
            int i = (this.c - this.b) + 1;
            float f3 = ((float) i) * f2;
            c_f5Var.a(0.0f, (float) this.b);
            c_f5Var.a(f3, ((float) this.c) + 0.001f);
            f2 = f3;
        }
        if (this.d != 1.0f || this.e != 1.0f) {
            z2 = true;
            str4 = "animationScaleX";
            c_f5 c_f5Var2 = new c_f5();
            c_f5Var2.a = d_f.scale;
            this.l.add(c_f5Var2);
            c_f5Var2.a(0.0f, this.d);
            c_f5Var2.a(f2, this.e);
        }
        if (z2) {
            this.n = f2;
        }
        m f4 = abVar.f(str, str2 + "leg", str2 + "arm");
        f4.addAll(abVar.k(str, str2 + "turret"));
        f4.addAll(abVar.k(str, str2 + "body"));
        f4.addAll(abVar.k(str, str2 + "effect"));
        Iterator it = f4.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            if (z2) {
                throw new bo("Cannot mix new (" + str5 + ") and old style (" + str4 + ") animations on:" + this.a);
            }
            a(lVar, abVar, str, str2, str5);
        }
        m mVar = new m();
        this.m = false;
        Iterator<c_f5> it2 = this.l.iterator();
        while (it2.hasNext()) {
            c_f5 next = it2.next();
            next.a(a4);
            next.c();
            if (this.n < next.d) {
                this.n = next.d;
            }
            if (next.e.length > 0) {
                this.o = true;
            }
            if (!(next.a == d_f.frame || next.a == d_f.scale)) {
                this.m = true;
            }
            mVar.add(next);
        }
        this.l = mVar;
    }

    public void a(l lVar, IniFile abVar, String str, String str2, String str3) throws bo {
        String substring = str3.substring(str2.length());
        String[] split = substring.split("_");
        String str4 = split[0];
        String substring2 = str3.substring((str2 + str4 + "_").length());
        float a = abVar.a(substring2, false, str, str3);
        String e = abVar.e(str, str3);
        if (!e.startsWith("{") || !e.endsWith("}")) {
            throw new bo("Unknown format:" + e, str, str3);
        }
        String substring3 = e.substring(1, e.length() - 1);
        String[] split2 = substring3.split(",");
        c_f5 c_f5Var = null;
        for (String trim : split2) {
            String trim2 = trim.trim();
            String[] split3 = trim2.split(":");
            if (split3.length != 2) {
                throw new bo("Unknown format on part:" + trim2 + " of: " + substring3, str, str3);
            }
            String trim3 = split3[0].trim();
            String trim4 = split3[1].trim();
            try {
                c_f5 a2 = a(trim3, str4);
                if (c_f5Var != a2) {
                    if (c_f5Var != null) {
                        c_f5Var.b();
                    }
                    c_f5Var = a2;
                }
                a2.a(lVar, a, trim3, trim4);
            } catch (bo e2) {
                throw new bo(e2.getMessage() + " (as part of key:" + str3 + " section:" + str + ")", e2);
            }
        }
        if (c_f5Var != null) {
            c_f5Var.b();
        }
    }

    public boolean a() {
        return this.o;
    }

    public boolean a(n nVar) {
        Iterator<n> it = this.p.iterator();
        while (it.hasNext()) {
            if (it.next() == nVar) {
                return true;
            }
        }
        return false;
    }
}