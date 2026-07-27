/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.units.a.WrapperUnitAction;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.b.a;
import com.corrodinggames.rts.game.units.custom.b.n;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.bp;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.an;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import java.util.ArrayList;
import java.util.List;

public final class m
        extends a {
    public static final m a = new m();

    public static void a(l l2, IniFile ab2) throws bo {
        String string2 = "attachment_";
        com.corrodinggames.rts.gameFramework.utility.m m2 = ab2.e(string2);
        if (m2.size() > 0) {
            l2.a(a);
            short s2 = 0;
            for (String string3 : ((List<String>) m2)) {
                String string4 = string3.substring(string2.length());
                n n2 = new n();
                m.a(n2, l2, ab2, string3, string4);
                n2.b = string4;
                n2.a = s2;
                s2 = (short) (s2 + 1);
                l2.aA.add(n2);
            }
        }
    }

    public static void a(n n2, l l2, IniFile ab2, String string2, String string3) throws bo {
        n2.c = ab2.i(string2, "x");
        n2.d = ab2.i(string2, "y");
        n2.e = ab2.a(string2, "height", Float.valueOf(n2.e)).floatValue();
        n2.i = ab2.a(string2, "lockDir", (Boolean) n2.i);
        n2.j = ab2.a(string2, "redirectDamageToParent", (Boolean) n2.j);
        n2.k = ab2.a(string2, "redirectDamageToParent_shieldOnly", (Boolean) n2.k);
        if (!n2.j && n2.k) {
            throw new bo("[" + string2 + "] redirectDamageToParent_shieldOnly requires redirectDamageToParent");
        }
        n2.l = ab2.a(string2, "canBeAttackedAndDamaged", (Boolean) n2.l);
        n2.m = ab2.a(string2, "isUnselectable", (Boolean) n2.m);
        n2.n = ab2.a(string2, "isUnselectableAsTarget", (Boolean) n2.m);
        n2.o = ab2.a(string2, "isVisible", (Boolean) n2.o);
        n2.p = ab2.a(string2, "showMiniHp", (Boolean) n2.p);
        n2.q = ab2.a(string2, "hideHp", (Boolean) n2.q);
        n2.N = ab2.a(l2, string2, "showAllActionsFrom", (LogicBoolean) null);
        if (LogicBoolean.isStaticFalse(n2.N)) {
            n2.N = null;
        }
        Float f2 = ab2.a(string2, "idleDir", (Float) null);
        Float f3 = ab2.a(string2, "idleDirReversing", (Float) null);
        if (f2 != null) {
            n2.f = f2.floatValue();
            n2.g = f2.floatValue();
        }
        n2.g = f3 != null ? f3.floatValue() : n2.f;
        n2.h = ab2.a(string2, "resetRotationWhenNotAttacking", (Boolean) false);
        n2.r = ab2.a(string2, "rotateWithParent", (Boolean) n2.r);
        n2.s = ab2.a(string2, "lockLegMovement", (Boolean) n2.s);
        n2.t = ab2.a(string2, "freezeLegMovement", (Boolean) n2.t);
        n2.u = ab2.a(string2, "lockRotation", (Boolean) n2.u);
        if (n2.u && n2.h) {
            throw new bo("[" + string2 + "] Cannot use lockRotation and resetRotationWhenIdle at same time");
        }
        n2.v = ab2.a(string2, "keepAliveWhenParentDies", (Boolean) n2.v);
        n2.w = bp.b(l2, ab2, string2, "onCreateSpawnUnitOf");
        if (n2.w.b()) {
            n2.w = null;
        }
        n2.x = ab2.a(string2, "createIncompleteIfParentIs", (Boolean) n2.x);
        n2.y = ab2.a(string2, "onConvertKeepExistingUnitInSameSlot", (Boolean) n2.y);
        n2.z = ab2.a(string2, "onParentTeamChangeKeepCurrentTeam", (Boolean) n2.z);
        n2.B = ab2.a(string2, "setDrawLayerOnBottom", (Boolean) n2.B);
        if (n2.B) {
            n2.A = false;
        }
        n2.A = ab2.a(string2, "setDrawLayerOnTop", (Boolean) n2.A);
        if (n2.A && n2.B) {
            throw new bo("[" + string2 + "] Cannot use setDrawLayerOnTop and setDrawLayerOnBottom at same time");
        }
        n2.D = ab2.a(string2, "addTransportedUnits", (Boolean) n2.D);
        n2.E = ab2.a(string2, "unloadInCurrentPosition", (Boolean) n2.E);
        n2.F = ab2.a(string2, "smoothlyBlendPositionWhenExistingUnitAdded", (Boolean) n2.F);
        n2.G = n2.F ? 500.0f : 0.0f;
        n2.H = ab2.a(string2, "deattachIfWantingToMove", (Boolean) n2.H);
        n2.I = ab2.a(string2, "hidden", (Boolean) n2.I);
        n2.J = ab2.a(string2, "prioritizeParentsMainTarget", (Boolean) n2.J);
        n2.K = ab2.a(string2, "onlyAttackParentsMainTarget", (Boolean) n2.K);
        n2.L = ab2.a(string2, "alwaysAllowedToAttackParentsMainTarget", (Boolean) n2.L);
        n2.M = ab2.a(string2, "canAttack", (Boolean) n2.M);
        n2.O = ab2.a(string2, "keepWaypointsNeedingMovement", (Boolean) n2.O);
        if (n2.D) {
            l2.aB = true;
        }
    }

    @Override
    public void a(j j2, float f2) {
        this.b(j2, f2);
    }

    @Override
    public void b(j var1, float var2) {
        com.corrodinggames.rts.gameFramework.GameEngine var3 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l var4 = var1.x;
        com.corrodinggames.rts.gameFramework.utility.m var5 = var4.aA;
        if (var5.a != 0) {
            if (var4.aB) {
                Object[] var6 = var5.a();

                for (int var7 = 0; var7 < var5.a; ++var7) {
                    n var8 = (n) var6[var7];
                    if (var8.D && var1.B.a > 0) {
                        y var9 = a(var1, var8);
                        if (var9 == null) {
                            java.util.Iterator var10 = var1.B.iterator();

                            while (var10.hasNext()) {
                                BaseUnit var11 = (BaseUnit) var10.next();
                                if (var11 instanceof y && var11.cO == null && var1.a((y) var11, var8)) {
                                    var11.cN = null;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            com.corrodinggames.rts.gameFramework.utility.m var19 = var1.C;
            if (var19 != null) {
                float var20 = var1.cg - var1.D;
                var1.D = var1.cg;
                Object[] var21 = var19.a();

                for (int var22 = var19.a - 1; var22 >= 0; --var22) {
                    y var23 = (y) var21[var22];
                    if (var23 != null) {
                        if (var23.bV) {
                            var23.bx();
                            var21[var22] = null;
                        } else {
                            if (var1.cN != null) {
                                if (var23.cN == null) {
                                    var23.cN = var1.cN;
                                    var3.bS.l(var23);
                                }
                            } else if (var23.cN != null && var23.cN != var1) {
                                var23.cN = null;
                            }

                            n var24 = (n) var5.get(var22);
                            float var12 = GameUtils.k(var1.cg);
                            float var13 = GameUtils.j(var1.cg);
                            float var14 = var12 * var24.d - var13 * var24.c;
                            float var15 = var13 * var24.d + var12 * var24.c;
                            var14 += var1.posX;
                            var15 += var1.posY;
                            float var16 = var1.posZ + var24.e;
                            float var17;
                            if (com.corrodinggames.rts.gameFramework.utility.y.b(var23.cQ, (int) var24.G)) {
                                var17 = 0.05F;
                                var23.posX += (var14 - var23.posX) * var17;
                                var23.posY += (var15 - var23.posY) * var17;
                                var23.posZ += (var16 - var23.posZ) * var17;
                            } else {
                                var23.posX = var14;
                                var23.posY = var15;
                                var23.posZ = var16;
                            }

                            if (var23.cm < 1.0F && var24.x) {
                                var23.r(var1.cm);
                                var23.cn = var1.cm;
                            }

                            if (var24.A) {
                                if (var23.em <= var1.em) {
                                    int var25 = 0;
                                    if (var23 instanceof j) {
                                        var25 = ((j) var23).x.cI;
                                    }

                                    var23.em = var1.em;
                                    var23.en = var1.en + 1 + var25;
                                }
                            } else if (var24.B && var23.em >= var1.em) {
                                var23.em = var1.em;
                                var23.en = var1.en - 1;
                            }

                            if (var1.ci) {
                                var17 = var1.cg + var24.g;
                            } else {
                                var17 = var1.cg + var24.f;
                            }

                            if (!var23.bI()) {
                                if (var24.u) {
                                    var23.h(var17);
                                } else {
                                    if (var20 != 0.0F && var24.r) {
                                        var23.i(var20);
                                    }

                                    if (var24.h && var23.R == null) {
                                        var23.c(var2, var17);
                                    }
                                }
                            }

                            if (var24.K) {
                                var23.R = var1.R;
                                var23.S = 5.0F;
                            }

                            if (var24.L && var23.R == null) {
                                var23.R = var1.R;
                            }

                            if (var24.J && var1.R != null && var23.R != var1.R) {
                                boolean var18 = false;
                                if (var24.L) {
                                    var18 = true;
                                }

                                if (var23.a(var1.R, var18)) {
                                    var23.R = var1.R;
                                    var23.S = 5.0F;
                                }
                            }

                            if (var23 instanceof j) {
                                j var26 = (j) var23;
                                if (var24.s) {
                                    var26.dP = var26.posX;
                                    var26.dP = var26.posY;
                                    var26.dR = var26.posZ;
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public void a(j j2, boolean bl2) {
        com.corrodinggames.rts.gameFramework.utility.m m2 = j2.C;
        if (m2 == null) {
            return;
        }
        com.corrodinggames.rts.gameFramework.utility.m m3 = j2.x.aA;
        Object[] objectArray = m2.a();
        for (int i2 = m2.a - 1; i2 >= 0; --i2) {
            y y2 = (y) objectArray[i2];
            if (y2 == null)
                continue;
            n n2 = (n) m3.get(i2);
            y2.bx();
            objectArray[i2] = null;
            if (!bl2 || n2.v)
                continue;
            y2.ci();
        }
    }

    @Override
    public void b(j j2) {
        this.a(j2, true);
    }

    @Override
    public void c(j j2) {
        this.a(j2, true);
    }

    @Override
    public void a(j j2) {
        boolean bl2 = false;
        com.corrodinggames.rts.gameFramework.utility.m m2 = j2.x.aA;
        Object[] objectArray = m2.a();
        for (int i2 = m2.a - 1; i2 >= 0; --i2) {
            n n2 = (n) objectArray[i2];
            if (n2.w == null)
                continue;
            y y2 = m.a(j2, n2);
            if (y2 != null) {
                if (n2.y)
                    continue;
                y2.ci();
            }
            com.corrodinggames.rts.gameFramework.utility.m m3 = new com.corrodinggames.rts.gameFramework.utility.m();
            n2.w.a(m3, j2.bX, j2, true);
            if (m3.size() > 1) {
                com.corrodinggames.rts.gameFramework.GameEngine
                        .b("onCreateSpawnUnitOf: created an extra " + (m3.size() - 1) + " units");
                for (int i3 = 1; i3 < m3.size(); ++i3) {
                    ((BaseUnit) m3.get(i3)).ci();
                }
            }
            if (m3.size() == 0) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("onCreateSpawnUnitOf: Warning no units created");
                continue;
            }
            BaseUnit am2 = (BaseUnit) m3.get(0);
            if (!(am2 instanceof y)) {
                com.corrodinggames.rts.gameFramework.GameEngine.b(
                        "onCreateSpawnUnitOf: Warning " + am2.r().i() + " not an orderable unit type, cannot attach");
                am2.ci();
                continue;
            }
            y y3 = (y) am2;
            if (!j2.a(y3, n2))
                continue;
            y3.cQ = -9999;
            if (j2.cm < 1.0f && n2.x) {
                y3.r(j2.cm);
                y3.cn = j2.cm;
            }
            bl2 = true;
        }
        if (bl2) {
            this.b(j2, 0.0f);
        }
    }

    @Override
    public void a(j j2, l l2) {
        y y2;
        int n2;
        com.corrodinggames.rts.gameFramework.utility.m m2 = j2.C;
        com.corrodinggames.rts.gameFramework.utility.m m3 = j2.x.aA;
        if (m3.size() == 0) {
            j2.C = null;
            return;
        }
        if (m2 == null) {
            return;
        }
        for (n2 = m2.size() - 1; n2 >= 0; --n2) {
            y2 = (y) m2.get(n2);
            if (y2 == null || n2 < m3.size())
                continue;
            y2.ci();
            m2.remove(n2);
        }
        for (n2 = m2.size() - 1; n2 >= 0; --n2) {
            y2 = (y) m2.get(n2);
            if (y2 == null)
                continue;
            y2.cP = (n) m3.get(n2);
        }
    }

    public static n a(j j2, short s2) {
        com.corrodinggames.rts.gameFramework.utility.m m2 = j2.x.aA;
        if (m2.a <= s2) {
            return null;
        }
        return (n) m2.get(s2);
    }

    public static y a(j j2, n n2) {
        com.corrodinggames.rts.gameFramework.utility.m m2 = j2.C;
        if (m2 == null) {
            return null;
        }
        short s2 = n2.a;
        if (m2.a <= s2) {
            return null;
        }
        return (y) m2.get(s2);
    }

    public static boolean a(j j2, n n2, y y2) {
        com.corrodinggames.rts.gameFramework.utility.m m2;
        l l2 = j2.x;
        short s2 = n2.a;
        if (l2.aA.a <= s2 && y2 != null) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .b("setAttachedUnitLookup: slot:" + s2 + " larger than max slot size:" + l2.aA.a);
            return false;
        }
        if (j2.C == null) {
            j2.C = new com.corrodinggames.rts.gameFramework.utility.m();
        }
        if ((m2 = j2.C).size() == 0) {
            j2.D = j2.cg;
        }
        if (y2 == null && s2 >= m2.size()) {
            return true;
        }
        while (m2.size() <= s2) {
            m2.add((Object) null);
        }
        m2.set((int) s2, y2);
        return true;
    }

    public static void a(j j2, com.corrodinggames.rts.gameFramework.utility.m m2, boolean bl2) {
        com.corrodinggames.rts.gameFramework.utility.m m3 = j2.C;
        if (m3 != null) {
            for (BaseUnit am2 : ((List<BaseUnit>) m3)) {
                n n2;
                if (am2 == null || !(am2 instanceof y) || (n2 = am2.dn()) == null || n2.N == null)
                    continue;
                ArrayList<AbstractUnitAction> arrayList = am2.N();
                for (AbstractUnitAction s2 : arrayList) {
                    boolean bl3 = bl2 ? an.a(n2.N, j2) : n2.N.read(j2);
                    if (!bl3)
                        continue;
                    WrapperUnitAction g2 = new WrapperUnitAction(s2, (y) am2, s2.N());
                    m2.add(g2);
                }
            }
        }
    }
}
