/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.a.a;

import java.util.List;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.a.AbstractUnitAction;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.a.a_f2;
import com.corrodinggames.rts.game.units.custom.a.d;
import com.corrodinggames.rts.game.units.custom.as;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter;
import com.corrodinggames.rts.game.units.custom.u;
import com.corrodinggames.rts.game.units.g.e;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.Vector3D;

import android.graphics.PointF;

public class j
extends a_f2 {
    boolean a;
    boolean b;
    boolean c;
    LogicBoolean d;
    LogicBoolean e;
    LogicBoolean f;
    LogicBoolean g;
    boolean h;
    float i;
    float j;
    u k;
    boolean l;
    boolean m;
    float n = -1.0f;
    Vector3D o;
    boolean p;
    VariableScope$CachedWriter q;

    public static void a(l l2, IniFile ab2, String string2, String string3, d d2, String string4, boolean bl2) throws bo {
        float f2;
        float f3;
        Object object;
        Object object2;
        Object object3;
        boolean bl3;
        boolean bl4 = ab2.a(string2, string3 + "resetUnitStats", (Boolean)false);
        String string5 = ab2.b(string2, string3 + "setUnitStats", (String)null);
        if (bl4 || string5 != null) {
            j j2 = new j();
            j2.p = bl4;
            if (string5 != null) {
                j2.q = as.a(string5, l2, string2, string3 + "setUnitStats");
            }
            d2.ac.add(j2);
        }
        if (bl3 = ab2.a(string2, string3 + "deleteSelf", (Boolean)false).booleanValue()) {
            j j3 = new j();
            j3.a = bl3;
            d2.ac.add(j3);
        }
        boolean bl5 = ab2.a(string2, string3 + "switchToNeutralTeam", (Boolean)false);
        boolean bl6 = ab2.a(string2, string3 + "switchToAggressiveTeam", (Boolean)false);
        LogicBoolean logicBoolean = ab2.a(l2, string2, string3 + "switchToTeam", null, LogicBoolean$ReturnType.number);
        if (bl5 || bl6 || logicBoolean != null) {
            object3 = new j();
            ((j)object3).b = bl5;
            ((j)object3).c = bl6;
            ((j)object3).d = logicBoolean;
            d2.ac.add(object3);
        }
        if ((object3 = ab2.c(l2, string2, string3 + "setBodyRotation", null)) != null) {
            object2 = new j();
            ((j)object2).e = (LogicBoolean) object3;
            d2.ac.add(object2);
        }
        if ((object2 = ab2.c(l2, string2, string3 + "setHeight", null)) != null) {
            object = new j();
            ((j)object).f = (LogicBoolean) object2;
            d2.ac.add(object);
        }
        if ((object = ab2.b(l2, string2, string3 + "teleportTo", null)) != null) {
            j j4 = new j();
            j4.g = (LogicBoolean) object;
            d2.ac.add(j4);
        }
        if ((f3 = ab2.a(string2, string3 + "setBuilt", Float.valueOf(-1.0f)).floatValue()) > 1.0f) {
            throw new bo("[" + string2 + "] setBuilt cannot be greater than 1");
        }
        boolean bl7 = ab2.a(string2, string3 + "clearAllActionCooldowns", (Boolean)false);
        float f4 = ab2.c(string2, string3 + "addAllActionCooldownsTime", Float.valueOf(0.0f)).floatValue();
        if (f4 == 0.0f) {
            f4 = ab2.c(string2, string3 + "addAllActionCooldownsFor", Float.valueOf(0.0f)).floatValue();
        }
        if ((f2 = ab2.c(string2, string3 + "addActionCooldownTime", Float.valueOf(0.0f)).floatValue()) == 0.0f) {
            f2 = ab2.c(string2, string3 + "addActionCooldownFor", Float.valueOf(0.0f)).floatValue();
        }
        u u2 = ab2.a(l2, string2, string3 + "addActionCooldownApplyToActions", (u)null);
        Vector3D ai2 = ab2.a(string2, string3 + "offsetSelfAbsolute", (Vector3D)null);
        if (u2 != null && f2 <= 0.0f) {
            throw new bo("[" + string2 + "]addActionCooldownApplyToActions requires addActionCooldownTime to be set");
        }
        boolean bl8 = ab2.a(string2, string3 + "removeAllQueuedItemsWithoutRefund", (Boolean)false);
        boolean bl9 = ab2.a(string2, string3 + "refundAllQueuedItems", (Boolean)false);
        if (bl8 && bl9) {
            throw new bo("[" + string2 + "]Cannot set removeAllQueuedActionsWithoutRefund and refundAllQueuedActions at the same time, pick one.");
        }
        if (f2 > 0.0f || f4 > 0.0f || bl7 || f3 >= 0.0f || ai2 != null || bl8 || bl9) {
            j j5 = new j();
            j5.h = bl7;
            j5.i = f4;
            j5.j = f2;
            j5.k = u2;
            j5.n = f3;
            j5.o = ai2;
            j5.l = bl8;
            j5.m = bl9;
            d2.ac.add(j5);
        }
    }

    @Override
public boolean a(com.corrodinggames.rts.game.units.custom.j jUnit, 
                 com.corrodinggames.rts.game.units.a.AbstractUnitAction upgradeOrAbility,
                 android.graphics.PointF point, 
                 com.corrodinggames.rts.game.units.BaseUnit target, 
                 int param) {
    
    // 处理单位属性升级
    if (this.p) {
        jUnit.y = jUnit.x.cL; // 设置单位类型
        jUnit.cv = (float) jUnit.y.c; // 设置最大生命值
        
        // 如果当前生命值超过最大值，则调整为最大值
        if (jUnit.cu > jUnit.cv) {
            jUnit.o(jUnit.cv); // 调整生命值
        }
        
        jUnit.cA = (float) jUnit.y.g; // 设置护甲值
        
        // 如果当前护甲超过最大值，则调整为最大值
        if (jUnit.cx > jUnit.cA) {
            jUnit.cx = jUnit.cA;
        }
    }
    
    // 应用变量作用域
    if (this.q != null) {
        this.q.writeToUnit(jUnit);
        com.corrodinggames.rts.game.units.custom.d.b.d(jUnit);
    }
    
    // 更新单位视觉表现
    if (this.a) {
        jUnit.ci(); // 更新外观
        if (jUnit.bI()) { // 检查是否需要更新选择状态
            com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bU.a(jUnit);
        }
    }
    
    // 设置单位阵营
    if (this.b) {
        jUnit.e(com.corrodinggames.rts.game.PlayerTeam.i);
    }
    if (this.c) {
        jUnit.e(com.corrodinggames.rts.game.PlayerTeam.h);
    }
    if (this.d != null) {
        int teamId = (int) this.d.readNumber(jUnit);
        com.corrodinggames.rts.game.PlayerTeam team = com.corrodinggames.rts.game.PlayerTeam.k(teamId);
        if (team != null) {
            jUnit.e(team);
        }
    }
    
    // 设置单位高度
    if (this.e != null) {
        float height = this.e.readNumber(jUnit);
        jUnit.h(height);
    }
    
    // 设置单位方向
    if (this.f != null) {
        jUnit.posZ = this.f.readNumber(jUnit);
    }
    
    // 设置单位位置
    if (this.g != null) {
        com.corrodinggames.rts.game.units.BaseUnit targetUnit = this.g.readUnit(jUnit);
        if (targetUnit != null) {
            jUnit.f(targetUnit.posX, targetUnit.posY);
        }
    }
    
    // 移除特定状态效果
    if (this.h) {
        com.corrodinggames.rts.game.units.g.e.c(jUnit, com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID);
    }
    
    // 设置单位隐藏状态
    if (this.l) {
        jUnit.i(false);
    }
    if (this.m) {
        jUnit.i(true);
    }
    
    // 应用资源奖励
    if (this.i > 0) {
        com.corrodinggames.rts.game.units.g.e.a(jUnit, com.corrodinggames.rts.game.units.a.AbstractUnitAction.NONE_ACTION_ID, (int) this.i);
    }
    
    // 应用经验值奖励
    if (this.j > 0) {
        if (this.k == null) {
            com.corrodinggames.rts.game.units.g.e.a(jUnit, upgradeOrAbility.N(), (int) this.j);
        } else {
            // 为多个升级类型应用经验值
            for (com.corrodinggames.rts.game.units.a.AbstractUnitAction ability : ((List<com.corrodinggames.rts.game.units.a.AbstractUnitAction>)this.k.a())) {
                com.corrodinggames.rts.game.units.g.e.a(jUnit, ability.N(), (int) this.j);
            }
        }
    }
    
    // 设置建造进度
    if (this.n >= 0) {
        jUnit.r(this.n);
        jUnit.cn = this.n;
    }
    
    // 应用位置和方向偏移
    if (this.o != null) {
        jUnit.b(jUnit.posX + this.o.a, jUnit.posY + this.o.b);
        jUnit.posZ += this.o.c;
        jUnit.cK = true; // 标记位置已更新
    }
    
    return true;
}}

