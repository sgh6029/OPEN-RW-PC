/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import java.io.IOException;
import java.util.List;

import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.bi;
import com.corrodinggames.rts.game.units.custom.bp;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.h;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.z;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.Color;
import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GGameObject;

public class bh
        extends com.corrodinggames.rts.game.g {
    public String bh;
    public int bi;
    public l bj;

    public static void a(bh bhVar, l lVar, IniFile abVar, String str) throws bo {
        boolean z;
        boolean z2 = true;
        float f = 0.0f;
        bh bhVar2 = bhVar;
        l lVar2 = lVar;
        IniFile abVar2 = abVar;
        String str2 = str;

        // 检查必须设置directDamage或areaDamage
        Integer b = abVar2.b(str2, "directDamage", (Integer) null);
        Integer b2 = abVar2.b(str2, "areaDamage", (Integer) null);
        if (b == null && b2 == null) {
            throw new RuntimeException("[" + str2 + "]: directDamage or areaDamage must be set");
        }

        // 目标地面相关设置
        bhVar2.s = abVar2.a(str2, "targetGround", Boolean.valueOf(bhVar2.s)).booleanValue();
        bhVar2.t = abVar2.a(str2, "targetGround_includeTargetHeight", Boolean.valueOf(bhVar2.t)).booleanValue();

        // 区域半径
        Integer b3 = abVar2.b(str2, "areaRadius", (Integer) null);
        if (b3 != null) {
            bhVar2.i = b3.intValue();
        }

        // 直接伤害和区域伤害
        bhVar2.b = abVar2.b(str2, "directDamage", Integer.valueOf(bhVar2.b)).intValue();
        bhVar2.c = abVar2.b(str2, "areaDamage", Integer.valueOf(bhVar2.c)).intValue();

        // 各种布尔属性设置
        bhVar2.d = abVar2.a(str2, "interceptProjectile_removeTargetLifeOnly", Boolean.valueOf(bhVar2.d)).booleanValue();
        bhVar2.g = abVar2.a(str2, "areaDamageNoFalloff", Boolean.valueOf(bhVar2.g)).booleanValue();
        bhVar2.j = abVar2.a(str2, "areaIgnoreUnitsCloserThan", Float.valueOf(bhVar2.j)).floatValue();
        bhVar2.h = abVar2.a(str2, "areaRadiusFromEdge", Boolean.valueOf(bhVar2.h)).booleanValue();

        // 友军火力设置
        String b4 = abVar2.b(str2, "friendlyFire", (String) null);
        if ("only-ignoreEnemy".equalsIgnoreCase(b4)) {
            bhVar2.l = true;
        } else {
            Boolean a = abVar2.a(str2, "friendlyFire", (Boolean) null);
            if (a != null) {
                bhVar2.l = false;
                bhVar2.k = a.booleanValue();
            }
        }

        // 继续各种属性设置
        bhVar2.m = abVar2.a(str2, "areaHitAirAndLandAtSameTime", Boolean.valueOf(bhVar2.m)).booleanValue();
        bhVar2.n = abVar2.a(str2, "areaHitUnderwaterAlways", Boolean.valueOf(bhVar2.n)).booleanValue();
        bhVar2.o = abVar2.a(str2, "deflectionPower", Float.valueOf(bhVar2.o)).floatValue();
        bhVar2.p = abVar2.a(str2, "nukeWeapon", Boolean.valueOf(bhVar2.p)).booleanValue();
        bhVar2.q = abVar2.a(str2, "shouldRevealFog", Boolean.valueOf(bhVar2.q)).booleanValue();
        bhVar2.r = abVar2.a(str2, "alwaysVisibleInFog", Boolean.valueOf(bhVar2.r)).booleanValue();

        // 生命值和计时器
        bhVar2.v = abVar2.h(str2, "life").floatValue();
        bhVar2.u = abVar2.b(str2, "delayedStartTimer", Float.valueOf(0.0f)).floatValue();

        // 速度和图像相关
        bhVar2.w = abVar2.a(str2, "speed", Float.valueOf(bhVar2.w)).floatValue();
        bhVar2.x = abVar2.a(str2, "frame", Short.valueOf(bhVar2.x)).shortValue();
        bhVar2.y = abVar2.a(str2, "drawType", Short.valueOf(bhVar2.y)).shortValue();
        bhVar2.z = abVar2.a(str2, "shadowFrame", Short.valueOf(bhVar2.z)).shortValue();

        // 图像设置
        Texture_M a2 = lVar2.a(abVar2, str2, "image");
        if (a2 != null) {
            bhVar2.B = a2;
        }
        Texture_M a3 = lVar2.a(abVar2, str2, "shadowImage");
        if (a3 != null) {
            bhVar2.C = a3;
        }

        // 光束图像设置
        bhVar2.ad = abVar2.a(str2, "beamImageOffsetRate", Float.valueOf(bhVar2.ad)).floatValue();
        Texture_M a4 = lVar2.a(abVar2, str2, "beamImage");
        if (a4 != null) {
            bhVar2.Y = a4;
            bhVar2.X = true;
            if (a4.q < 20 && !GameEngine.ax()) {
                throw new RuntimeException(
                        "beamImage height must currently be 20 pixels or greater (performance when tiling)");
            }
        }

        // 光束开始和结束图像
        Texture_M a5 = lVar2.a(abVar2, str2, "beamImageStart");
        if (a5 != null) {
            bhVar2.Z = a5;
            if (a4 == null) {
                throw new RuntimeException("beamImageStart requires beamImage to be set");
            }
        }
        bhVar2.aa = abVar2.a(str2, "beamImageStartRotated", Boolean.valueOf(false)).booleanValue();

        Texture_M a6 = lVar2.a(abVar2, str2, "beamImageEnd");
        if (a6 != null) {
            bhVar2.ab = a6;
            if (a4 == null) {
                throw new RuntimeException("beamImageEnd requires beamImage to be set");
            }
        }
        bhVar2.ac = abVar2.a(str2, "beamImageEndRotated", Boolean.valueOf(false)).booleanValue();

        // 不可见属性
        bhVar2.A = abVar2.a(str2, "invisible", Boolean.valueOf(bhVar2.A)).booleanValue();

        // 弹道和重力相关
        bhVar2.D = abVar2.a(str2, "initialUnguidedSpeedHeight", Float.valueOf(bhVar2.D)).floatValue();
        bhVar2.E = abVar2.a(str2, "initialUnguidedSpeedX", Float.valueOf(bhVar2.E)).floatValue();
        bhVar2.F = abVar2.a(str2, "initialUnguidedSpeedY", Float.valueOf(bhVar2.F)).floatValue();
        bhVar2.G = abVar2.a(str2, "gravity", Float.valueOf(bhVar2.G)).floatValue();
        bhVar2.H = abVar2.a(str2, "trueGravity", Float.valueOf(bhVar2.H)).floatValue();

        // 即时武器相关
        bhVar2.I = abVar2.a(str2, "instant", Boolean.valueOf(bhVar2.I)).booleanValue();
        bhVar2.L = abVar2.a(str2, "instantReuseLast", Boolean.valueOf(bhVar2.L)).booleanValue();
        bhVar2.M = abVar2.a(str2, "instantReuseLast_alsoChangeTurretAim", Boolean.valueOf(bhVar2.M)).booleanValue();
        if (bhVar2.M) {
            if (!bhVar2.L) {
                throw new RuntimeException(
                        "[" + str2 + "]instantReuseLast_alsoChangeTurretAim also requires instantReuseLast");
            }
            lVar2.eA = true;
        }
        bhVar2.N = abVar2.a(str2, "instantReuseLast_keepAreaDamageList", Boolean.valueOf(bhVar2.N)).booleanValue();

        // 移动和瞄准相关
        bhVar2.T = abVar2.a(str2, "moveWithParent", Boolean.valueOf(bhVar2.T)).booleanValue();
        bhVar2.J = abVar2.a(str2, "disableLeadTargeting", Boolean.valueOf(bhVar2.J)).booleanValue();
        bhVar2.K = abVar2.a(str2, "leadTargetingSpeedCalculation", Float.valueOf(bhVar2.K)).floatValue();
        bhVar2.ae = abVar2.a(str2, "ballistic", Boolean.valueOf(bhVar2.ae)).booleanValue();

        // 尾迹效果
        String b5 = abVar2.b(str2, "trailEffect", (String) null);
        if (b5 != null) {
            if ("true".equalsIgnoreCase(b5)) {
                bhVar2.af = true;
            } else if ("false".equalsIgnoreCase(b5)) {
                bhVar2.af = false;
            } else {
                bhVar2.af = false;
                bhVar2.ah = lVar2.a(b5, (com.corrodinggames.rts.game.units.custom.z) null);
            }
        }

        // 创建时的效果
        String b6 = abVar2.b(str2, "effectOnCreate", (String) null);
        if (b6 != null) {
            bhVar2.ai = lVar2.a(b6, (com.corrodinggames.rts.game.units.custom.z) null);
        }

        // 尾迹效果率
        bhVar2.ag = abVar2.a(str2, "trailEffectRate", Float.valueOf(bhVar2.ag)).floatValue();
        if (bhVar2.af) {
            bhVar2.ao = -1118720;
        }

        // 摆动效果
        bhVar2.am = abVar2.a(str2, "wobbleAmplitude", Float.valueOf(bhVar2.am)).floatValue();
        bhVar2.an = abVar2.b(str2, "wobbleFrequency", Float.valueOf(bhVar2.an)).floatValue();
        if (bhVar2.an <= 0.0f) {
            throw new RuntimeException("wobbleFrequency must be greater than 0");
        }

        // 生成投射物
        bhVar2.ak = com.corrodinggames.rts.game.units.custom.bi.a(lVar2, abVar2, str2, "spawnProjectilesOnEndOfLife",
                (com.corrodinggames.rts.game.units.custom.bi) null);
        bhVar2.aj = com.corrodinggames.rts.game.units.custom.bi.a(lVar2, abVar2, str2, "spawnProjectilesOnExplode",
                (com.corrodinggames.rts.game.units.custom.bi) null);
        bhVar2.al = com.corrodinggames.rts.game.units.custom.bi.a(lVar2, abVar2, str2, "spawnProjectilesOnCreate",
                (com.corrodinggames.rts.game.units.custom.bi) null);

        // 光照效果
        bhVar2.ao = abVar2.a(str2, "lightColor", Integer.valueOf(bhVar2.ao)).intValue();
        bhVar2.ap = abVar2.a(str2, "lightSize", Float.valueOf(bhVar2.ap)).floatValue();
        bhVar2.aq = abVar2.a(str2, "lightCastOnGround", Boolean.valueOf(bhVar2.aq)).booleanValue();

        // 命中效果
        bhVar2.ar = abVar2.a(str2, "largeHitEffect", Boolean.valueOf(bhVar2.ar)).booleanValue();

        // 转向和扫射
        bhVar2.O = abVar2.a(str2, "turnSpeed", Float.valueOf(bhVar2.O)).floatValue();
        bhVar2.P = abVar2.a(str2, "turnSpeedWhenNear", Float.valueOf(bhVar2.P)).floatValue();
        bhVar2.Q = abVar2.a(str2, "sweepSpeed", Float.valueOf(bhVar2.Q)).floatValue();
        bhVar2.R = abVar2.a(str2, "sweepOffset", Float.valueOf(bhVar2.R)).floatValue();
        bhVar2.S = abVar2.a(str2, "sweepOffsetFromTargetRadius", Float.valueOf(bhVar2.S)).floatValue();

        // 绘制和效果
        bhVar2.U = abVar2.a(str2, "drawUnderUnits", Boolean.valueOf(bhVar2.U)).booleanValue();
        bhVar2.V = abVar2.a(str2, "lightingEffect", Boolean.valueOf(bhVar2.V)).booleanValue();
        bhVar2.W = abVar2.a(str2, "laserEffect", Boolean.valueOf(bhVar2.W)).booleanValue();

        // 激光效果默认颜色
        if (bhVar2.W && bhVar2.Y == null) {
            bhVar2.aE = Color.a(80, 255, 0, 0);
        }

        // 效果限制检查
        if (bhVar2.V && bhVar2.s) {
            throw new RuntimeException("lightingEffect must be targeted, cannot be targetGround");
        }
        if (bhVar2.W && bhVar2.s) {
            throw new RuntimeException("laserEffect must be targeted, cannot be targetGround");
        }

        // 弹道参数
        bhVar2.as = abVar2.a(str2, "ballistic_delaymove_height", Float.valueOf(bhVar2.as)).floatValue();
        bhVar2.at = abVar2.a(str2, "ballistic_height", Float.valueOf(bhVar2.at)).floatValue();
        bhVar2.au = abVar2.a(str2, "targetSpeed", Float.valueOf(bhVar2.au)).floatValue();
        bhVar2.av = abVar2.a(str2, "targetSpeedAcceleration", Float.valueOf(bhVar2.av)).floatValue();

        // 自动目标锁定
        bhVar2.aw = abVar2.a(str2, "autoTargetingOnDeadTarget", Boolean.valueOf(bhVar2.aw)).booleanValue();
        bhVar2.ax = abVar2.a(str2, "autoTargetingOnDeadTargetRange", Float.valueOf(bhVar2.ax)).floatValue();
        bhVar2.ay = abVar2.a(str2, "autoTargetingOnDeadTargetLead", Float.valueOf(bhVar2.ay)).floatValue();

        // 飞行中重新锁定目标
        bhVar2.az = abVar2.a(str2, "retargetingInFlight", Boolean.valueOf(bhVar2.az)).booleanValue();
        bhVar2.aA = abVar2.a(str2, "retargetingInFlightSearchDelay", Float.valueOf(bhVar2.aA)).floatValue();
        bhVar2.aB = abVar2.a(str2, "retargetingInFlightSearchRange", Float.valueOf(bhVar2.aB)).floatValue();
        bhVar2.aC = abVar2.a(str2, "retargetingInFlightSearchLead", Float.valueOf(bhVar2.aC)).floatValue();
        bhVar2.aD = abVar2.a(lVar2, str2, "retargetingInFlightSearchOnlyTags",
                (com.corrodinggames.rts.game.units.custom.h) null);

        // 性能限制检查
        if (bhVar2.ax > 1500.0f) {
            throw new RuntimeException("for performance autoTargetingOnDeadTargetRange cannot be >1500");
        }
        if (bhVar2.aB > 1500.0f) {
            throw new RuntimeException("for performance retargetingInFlightSearchRange cannot be >1500");
        }

        // 颜色和团队颜色
        bhVar2.aE = abVar2.a(str2, "color", Integer.valueOf(bhVar2.aE)).intValue();
        bhVar2.aG = abVar2.a(str2, "teamColorRatio", Float.valueOf(bhVar2.aG)).floatValue();
        if (bhVar2.aG < 0.0f || bhVar2.aG > 1.0f) {
            throw new RuntimeException("teamColorRatio should be between 0-1 got:" + bhVar2.aG);
        }
        bhVar2.aH = abVar2.a(str2, "teamColorRatio_sourceRatio", Float.valueOf(1.0f - bhVar2.aG)).floatValue();
        if (bhVar2.aH < 0.0f || bhVar2.aH > 1.0f) {
            throw new RuntimeException("teamColorRatio_sourceRatio should be between 0-1 got:" + bhVar2.aH);
        }
        if (bhVar2.aG == 0.0f && bhVar2.aH != 1.0f) {
            throw new RuntimeException("teamColorRatio_sourceRatio requires teamColorRatio");
        }

        // 绘制大小
        bhVar2.aF = abVar2.a(str2, "drawSize", Float.valueOf(bhVar2.aF)).floatValue();

        // 火焰武器和声音
        bhVar2.aI = abVar2.a(str2, "flameWeapon", Boolean.valueOf(bhVar2.aI)).booleanValue();
        bhVar2.aJ = abVar2.a(str2, "hitSound", Boolean.valueOf(bhVar2.aJ)).booleanValue();

        // 地面目标参数
        bhVar2.aL = abVar2.a(str2, "targetGroundHeightOffset", Float.valueOf(bhVar2.aL)).floatValue();
        bhVar2.aK = abVar2.a(str2, "targetGroundSpread", Float.valueOf(bhVar2.aK)).floatValue();
        bhVar2.aM = abVar2.a(str2, "speedSpread", Float.valueOf(bhVar2.aM)).floatValue();

        // 爆炸和伤害乘数
        bhVar2.aO = abVar2.a(str2, "explodeOnEndOfLife", Boolean.valueOf(bhVar2.aO)).booleanValue();
        bhVar2.aN = abVar2.a(str2, "ignoreParentShootDamageMultiplier", Boolean.valueOf(bhVar2.aN)).booleanValue();
        bhVar2.aP = abVar2.a(str2, "pushForce", Float.valueOf(bhVar2.aP)).floatValue();
        bhVar2.aQ = abVar2.a(str2, "pushVelocity", Float.valueOf(bhVar2.aQ)).floatValue();
        bhVar2.aR = abVar2.a(str2, "buildingDamageMultiplier", Float.valueOf(bhVar2.aR)).floatValue();
        bhVar2.aS = abVar2.a(str2, "shieldDamageMultiplier", Float.valueOf(bhVar2.aS)).floatValue();
        bhVar2.aT = abVar2.a(str2, "shieldDefectionMultiplier", Float.valueOf(bhVar2.aT)).floatValue();
        bhVar2.aU = abVar2.a(str2, "hullDamageMultiplier", Float.valueOf(bhVar2.aU)).floatValue();
        bhVar2.aV = abVar2.a(str2, "armourIgnoreAmount", Float.valueOf(bhVar2.aV)).floatValue();
        bhVar2.aW = abVar2.a(str2, "areaExpandTime", Float.valueOf(bhVar2.aW)).floatValue();

        // 爆炸效果
        String b7 = abVar2.b(str2, "explodeEffect", (String) null);
        if (b7 != null) {
            bhVar2.aX = lVar2.a(b7, (com.corrodinggames.rts.game.units.custom.z) null);
        }
        String b8 = abVar2.b(str2, "explodeEffectOnShield", (String) null);
        if (b8 != null) {
            bhVar2.aY = lVar2.a(b8, (com.corrodinggames.rts.game.units.custom.z) null);
        }

        // 生成单位
        bp a7 = bp.a(lVar2, abVar2, str2, "spawnUnit");
        if (a7 != null && !a7.b()) {
            bhVar2.aZ = a7;
        }

        // 卸载单位和传送
        bhVar2.ba = abVar2.b(str2, "unloadUpToXUnitsFromSource", Integer.valueOf(bhVar2.ba)).intValue();
        bhVar2.bb = abVar2.a(str2, "teleportSource", Boolean.valueOf(bhVar2.bb)).booleanValue();
        bhVar2.bc = abVar2.a(str2, "convertHitToSourceTeam", Boolean.valueOf(bhVar2.bc)).booleanValue();

        // 标签
        String b9 = abVar2.b(str2, "tags", (String) null);
        bhVar2.bd = com.corrodinggames.rts.game.units.custom.g.a(b9);

        // 修饰器系统（mutator）
        m k = abVar2.k(str2, "mutator");
        m mVar = new m();
        for (String str3 : ((List<String>) k)) {
            String[] split = str3.split("_");
            if (split.length > 1) {
                String str4 = split[0];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str4);
                stringBuilder.append("_");
                String stringBuilder2 = stringBuilder.toString();
                if (!mVar.contains(stringBuilder2) && str4.length() > "mutator".length()) {
                    mVar.add(stringBuilder2);
                }
            }
        }

        // 处理每个修饰器
        for (String str5 : ((List<String>) mVar)) {
            h hVar = new h();

            // 单位标签条件
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str5);
            stringBuilder3.append("ifUnitWithTags");
            hVar.a = com.corrodinggames.rts.game.units.custom.g
                    .a(abVar2.b(str2, stringBuilder3.toString(), (String) null));
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str5);
            stringBuilder4.append("ifUnitWithoutTags");
            hVar.b = com.corrodinggames.rts.game.units.custom.g
                    .a(abVar2.b(str2, stringBuilder4.toString(), (String) null));

            // 验证至少有一个标签条件
            if (hVar.a == null && hVar.b == null) {
                throw new RuntimeException("[" + str2 + "]" + str5 + " requires: unitWithTags and/or unitWithoutTags");
            }

            // 伤害乘数
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(str5);
            stringBuilder5.append("directDamageMultiplier");
            hVar.c = abVar2.a(str2, stringBuilder5.toString(), Float.valueOf(1.0f)).floatValue();
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(str5);
            stringBuilder6.append("areaDamageMultiplier");
            hVar.d = abVar2.a(str2, stringBuilder6.toString(), Float.valueOf(1.0f)).floatValue();

            // 资源添加（直接命中）
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(str5);
            stringBuilder7.append("addResourcesDirectHit");
            b a8 = com.corrodinggames.rts.game.units.custom.d.b.a(lVar2, abVar2, str2, stringBuilder7.toString(), true);
            if (a8 != null && a8.d()) {
                hVar.e = a8;
                if (bhVar2.s) {
                    throw new RuntimeException("[" + str2 + "]" + str5
                            + "addResourcesDirectHit doesn't work with targetGround, as it will never get direct hits (use addResourcesAreaHit)");
                }
            }

            // 资源添加（区域命中）
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append(str5);
            stringBuilder8.append("addResourcesAreaHit");
            b a9 = com.corrodinggames.rts.game.units.custom.d.b.a(lVar2, abVar2, str2, stringBuilder8.toString(), true);
            if (a9 != null && a9.d()) {
                hVar.f = a9;
                if (b3 == null) {
                    throw new RuntimeException(
                            "[" + str2 + "]" + str5 + "addResourcesAreaHit requires areaRadius to be set");
                }
            }

            // 改变爆炸效果
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(str5);
            stringBuilder9.append("changedExplodeEffect");
            String b10 = abVar2.b(str2, stringBuilder9.toString(), (String) null);
            if (b10 != null) {
                hVar.g = lVar2.a(b10, (com.corrodinggames.rts.game.units.custom.z) null);
                if (hVar.g != null && !hVar.g.a()) {
                    hVar.g = (com.corrodinggames.rts.game.units.custom.z) null;
                }
            }

            // 检查是否需要添加修饰器
            boolean z3 = !GameUtils.k(hVar.c, 1.0f);
            boolean z4 = (!GameUtils.k(hVar.d, 1.0f) && bhVar2.c != 0 && bhVar2.i > 0) ? false : true;
            if (hVar.e != null) {
                z3 = true;
            }
            if (hVar.f != null) {
                z4 = true;
            }

            // 添加到相应的列表
            if (z3) {
                if (bhVar2.be == null) {
                    bhVar2.be = new m();
                }
                bhVar2.be.add(hVar);
            }
            if (z4) {
                if (bhVar2.bf == null) {
                    bhVar2.bf = new m();
                }
                bhVar2.e = true;
                bhVar2.bf.add(hVar);
            }
            if (hVar.g != null) {
                if (bhVar2.bg == null) {
                    bhVar2.bg = new m();
                }
                bhVar2.bg.add(hVar);
            }
        }

        // 设置区域伤害标志
        if (bhVar2.c != 0 && bhVar2.i > 0) {
            bhVar2.e = true;
        }

        // 设置推力标志
        if ((bhVar2.aP != 0.0f || bhVar2.aQ != 0.0f) && bhVar2.i > 0) {
            bhVar2.e = true;
        }

        // 设置直接伤害标志
        if (!bhVar2.e) {
            z = true;
        } else {
            z = false;
        }
        bhVar2.f = z;

        // 添加到单位的武器列表
        lVar2.fT.add(bhVar2);
    }

    public static void a(bh bh2, com.corrodinggames.rts.gameFramework.j.GameOutputStream as2) throws IOException {
        as2.a(bh2.bj);
        as2.writeUTF(bh2.bh);
    }

    public static com.corrodinggames.rts.game.g b(GameInputStream k2) throws IOException {
        UnitType as2 = k2.q();
        String string2 = k2.l();
        if (as2 == null) {
            return null;
        }
        if (!(as2 instanceof l)) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .b("ProjectileTemplate:readInLinkCustom: Got non CustomUnitMetadata object of:" + as2.i()
                            + " loading real_meta");
            return null;
        }
        l l2 = (l) as2;
        bh bh2 = l2.f(string2);
        if (bh2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine
                    .b("ProjectileTemplate:readInLinkCustom: Could not find projectile with name:" + string2);
            return null;
        }
        return bh2;
    }

    public void a(BaseUnit am2, f f2, BaseUnit am3, float f3, float f4, float f5) {
        bh bh2 = this;
        if (am3 == null) {
            f2.aC = true;
            f2.n = f3;
            f2.o = f4;
            if (bh2.aK != 0.0f) {
                f2.n += (float) com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject) am2, (int) (-bh2.aK * 100.0f),
                        (int) (bh2.aK * 100.0f), 2) / 100.0f;
                am2.bC = (int) ((float) am2.bC + f2.n);
                f2.o += (float) com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject) am2, (int) (-bh2.aK * 100.0f),
                        (int) (bh2.aK * 100.0f), 3) / 100.0f;
                am2.bC = (int) ((float) am2.bC + f2.o);
            }
            f2.p = 0.0f;
            f2.p += bh2.aL;
        } else if (f2.m) {
            f2.aC = true;
            if (!bh2.J) {
                float f6 = f2.t;
                if (bh2.au != -1.0f) {
                    f6 = bh2.au;
                }
                if (bh2.K >= 0.0f) {
                    f6 = bh2.K;
                }
                PointF pointF = am3.a(f2.posX, f2.posY, f6, f2.h, f5);
                f2.n = pointF.x;
                f2.o = pointF.b;
            } else {
                f2.n = am3.posX;
                f2.o = am3.posY;
            }
            f2.p = bh2.t ? am3.posZ : 0.0f;
            f2.p += bh2.aL;
            if (bh2.aK != 0.0f) {
                f2.n += (float) com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject) am2, (int) (-bh2.aK * 100.0f),
                        (int) (bh2.aK * 100.0f), 2) / 100.0f;
                f2.o += (float) com.corrodinggames.rts.gameFramework.GameUtils.a((GGameObject) am2, (int) (-bh2.aK * 100.0f),
                        (int) (bh2.aK * 100.0f), 7) / 100.0f;
            }
        } else {
            f2.l = am3;
        }
    }
}
