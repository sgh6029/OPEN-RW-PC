/*
 * Decompiled with CFR 0.152.
 */
/*
com.corrodinggames.rts.game.units.a.s -> com.corrodinggames.rts.game.units.a.AbstractUnitAction:
    com.corrodinggames.rts.game.units.a.c a -> actionId
    com.corrodinggames.rts.game.units.custom.d.b b -> cost
    float g -> sortOrder
    com.corrodinggames.rts.game.units.a.a h -> unitAction
    com.corrodinggames.rts.game.units.a.c i -> NONE_ACTION_ID
    java.lang.String a() -> isLocked
    boolean a(com.corrodinggames.rts.game.units.a.s,com.corrodinggames.rts.game.units.a.s) -> onTargetSelected
    boolean a(com.corrodinggames.rts.game.units.am) -> isTargetingGround
    boolean a(com.corrodinggames.rts.game.units.am,com.corrodinggames.rts.game.n) -> appendTooltip
    void a(com.corrodinggames.rts.game.units.am,com.corrodinggames.rts.game.units.am) -> isPickAction
    void a(com.corrodinggames.rts.game.units.am,com.corrodinggames.rts.gameFramework.f.ae) -> onPurchase
    void a(com.corrodinggames.rts.game.units.am,com.corrodinggames.rts.gameFramework.f.ae,android.graphics.Paint,android.graphics.Paint) -> isWaiting
    boolean a(com.corrodinggames.rts.game.units.am,boolean) -> drawTooltip
    void a(java.lang.String) -> canAfford
    boolean A() -> getDescription
    java.lang.String b() -> getCostForUnit
    boolean b(com.corrodinggames.rts.game.units.a.c) -> getBuildQueueCount
    int b(com.corrodinggames.rts.game.units.am,boolean) -> isActive
    com.corrodinggames.rts.game.units.custom.d.b B() -> getDisplayText
    int c() -> isConfirmed
    boolean c(com.corrodinggames.rts.game.units.a.c) -> isMove
    boolean c(com.corrodinggames.rts.game.units.am,boolean) -> onClicked
    boolean C() -> getCost
    boolean d(com.corrodinggames.rts.game.units.a.c) -> isAvailableForUnit
    java.lang.String d(com.corrodinggames.rts.game.units.am) -> isVisible
    boolean d(com.corrodinggames.rts.game.units.am,boolean) -> getDisplayTextWithQueueCount
    boolean D() -> getDisplayTextForUnit
    void e(com.corrodinggames.rts.game.units.a.c) -> getDescriptionForUnit
    java.lang.String e(com.corrodinggames.rts.game.units.am) -> getProducedUnitType
    com.corrodinggames.rts.game.units.as E() -> getActionType
    com.corrodinggames.rts.game.units.a.t f() -> isAlsoSelected
    void f(com.corrodinggames.rts.game.units.am) -> onConfirmed
    boolean F() -> getDisplayType
    boolean g() -> isHighPriority
    boolean g(com.corrodinggames.rts.game.units.am) -> isNotAvailable
    boolean G() -> isBuildOption
    boolean h() -> getIconForUnit
    com.corrodinggames.rts.gameFramework.m.e h(com.corrodinggames.rts.game.units.am) -> isShowingNotEnoughEnergy
    boolean H() -> isAttack
    boolean h_() -> shouldShowDisplayText
    com.corrodinggames.rts.game.units.as i() -> mo5959i
    com.corrodinggames.rts.game.units.am i(com.corrodinggames.rts.game.units.am) -> isShowingNotEnoughResources
    boolean I() -> getTargetUnit
    com.corrodinggames.rts.gameFramework.m.e j() -> getIconColor
    java.lang.String j(com.corrodinggames.rts.game.units.am) -> getIcon
    int J() -> getNotAvailableReason
    boolean k(com.corrodinggames.rts.game.units.am) -> isSingleUse
    float l() -> getBuildSpeed
    boolean l(com.corrodinggames.rts.game.units.am) -> isTargetingAction
    int m() -> getKeyBinding
    boolean m(com.corrodinggames.rts.game.units.am) -> getEnergyCost
    com.corrodinggames.rts.gameFramework.ad M() -> isPrimary
    float m_() -> getSortOrder
    boolean n(com.corrodinggames.rts.game.units.am) -> isSecondary
    com.corrodinggames.rts.game.units.a.c N() -> getActionId
    boolean n_() -> isQueuable
    boolean o() -> isCancel
    boolean o(com.corrodinggames.rts.game.units.am) -> isAvailableAndVisible
    java.lang.String O() -> getActionIdString
    boolean o_() -> isLockedAndDisabled
    boolean p() -> isInstant
    float p(com.corrodinggames.rts.game.units.am) -> getProgress
    com.corrodinggames.rts.game.units.custom.h P() -> getAnimationSet
    java.util.ArrayList q(com.corrodinggames.rts.game.units.am) -> isPurchase
    boolean Q() -> getOptions
    boolean r(com.corrodinggames.rts.game.units.am) -> isAvailable
    com.corrodinggames.rts.game.units.custom.d.b r_() -> getAdditionalCost
    boolean s() -> isWaitingForTarget
    boolean s(com.corrodinggames.rts.game.units.am) -> shouldShowProgress
    int t() -> getQueueSize
    boolean t(com.corrodinggames.rts.game.units.am) -> shouldShowCount
    boolean u() -> isGuiBlinking
    boolean u(com.corrodinggames.rts.game.units.am) -> isActivated
    android.graphics.Rect v() -> getIconRect
    com.corrodinggames.rts.game.units.custom.a.e v(com.corrodinggames.rts.game.units.am) -> getActionTypeForUnit
    java.lang.String w(com.corrodinggames.rts.game.units.am) -> getDisplayTextForUnitWithQueueCount
    boolean x() -> isRightClickAction
    com.corrodinggames.rts.game.units.as y() -> getAttachedUnitType
    com.corrodinggames.rts.game.units.a.c z() -> getQueueId
*/

package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.a.e;
import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.KeyBinding;
import com.corrodinggames.rts.gameFramework.f.ae;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.corrodinggames.rts.gameFramework.GameEngine;

import java.io.IOException;
import java.util.ArrayList;

//s.java
@SuppressWarnings("rawtypes")
public abstract class AbstractUnitAction
        implements Comparable {
    public float sortOrder = -999.0f;
    public UnitAction unitAction = com.corrodinggames.rts.game.units.a.UnitAction.a;
    public static final ActionId NONE_ACTION_ID = ActionId.a;
    private ActionId actionId;
    private b cost;

    public float m_() {
        if (this instanceof SetRallyAction) {
            return -100.0f;
        }
        if (this.sortOrder != -999.0f) {
            return this.sortOrder;
        }
        UnitType as2 = this.i();
        if (as2 != null && this.g()) {
            return as2.g();
        }
        return 1.0f;
    }

    public int a(AbstractUnitAction s2) {
        if (s2 == null) {
            return 0;
        }
        float f2 = this.m_() - s2.m_();
        if (f2 < 0.0f) {
            return -1;
        }
        if (f2 > 0.0f) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        AbstractUnitAction s2 = (AbstractUnitAction) object;
        return this.actionId.equals(s2.actionId);
    }

    public static final boolean b(ActionId c2) {
        return c2 == null || c2 == NONE_ACTION_ID;
    }

    public static final boolean c(ActionId c2) {
        return !AbstractUnitAction.b(c2);
    }

    public static boolean a(AbstractUnitAction s2, AbstractUnitAction s3) {
        return s2 == s3;
    }

    public final boolean d(ActionId c2) {
        return this.actionId == c2;
    }

    public AbstractUnitAction(int n2) {
        this.a(String.valueOf(n2));
    }

    public AbstractUnitAction(String string2) {
        this.a(string2);
    }

    public AbstractUnitAction(ActionId c2) {
        this.e(c2);
    }

    public final void a(String string2) {
        this.actionId = ActionId.isSameInstance(string2);
    }

    public final void e(ActionId c2) {
        this.actionId = c2;
    }

    public final ActionId N() {
        return this.actionId;
    }

    public ActionId z() {
        return this.N();
    }

    public final String O() {
        if (this.actionId == null) {
            return "<null index>";
        }
        return this.actionId.getId();
    }

    public abstract String b();

    public abstract String a() throws IOException;

    public h P() {
        return null;
    }

    public String d(BaseUnit am2) {
        return this.b();
    }

    public String e(BaseUnit am2) throws IOException {
        return this.a();
    }

    public abstract int c();

    public b B() {
        b b2 = this.unitAction.a();
        if (b2 != null) {
            return b2;
        }
        int n2 = this.c();
        if (n2 == 0) {
            return com.corrodinggames.rts.game.units.custom.d.b.a;
        }
        if (this.cost == null || this.cost.a() != n2) {
            this.cost = com.corrodinggames.rts.game.units.custom.d.b.a(n2);
        }
        return this.cost;
    }

    public b r_() {
        if (this.unitAction.b() != null) {
            return this.unitAction.b();
        }
        return null;
    }

    public abstract int b(BaseUnit var1, boolean var2);

    public boolean n_() {
        return false;
    }

    public boolean g(BaseUnit am2) {
        return this.unitAction.b(am2);
    }

    public String j(BaseUnit am2) {
        return this.unitAction.c(am2);
    }

    public void a(BaseUnit am2, BaseUnit am3) {
        this.unitAction.a(am2, am3);
    }

    public boolean d(BaseUnit am2, boolean bl2) {
        return true;
    }

    public boolean k(BaseUnit am2) {
        return false;
    }

    public boolean l(BaseUnit am2) {
        return false;
    }

    public boolean a(BaseUnit am2, boolean bl2) {
        if (this.g(am2)) {
            return false;
        }
        if (com.corrodinggames.rts.game.units.g.e.a(am2, this.N()) > 0) {
            return false;
        }
        if (bl2) {
            return this.B().c(am2, this.Q());
        }
        return this.B().b(am2);
    }

    public boolean r(BaseUnit am2) {
        return this.b(am2);
    }

    public boolean u(BaseUnit am2) {
        return this.unitAction.a(am2);
    }

    public boolean b(BaseUnit am2) {
        return this.unitAction.a(am2, false);
    }

    public boolean a(BaseUnit am2, PlayerTeam n2) {
        return false;
    }

    public boolean u() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean C() {
        return false;
    }

    public boolean D() {
        return true;
    }

    public boolean A() {
        return false;
    }

    public abstract UnitType i();

    public UnitType y() {
        return null;
    }

    public UnitType E() {
        return null;
    }

    public boolean F() {
        return false;
    }

    public int t() {
        return 1;
    }

    public abstract boolean g();

    public abstract ActionType e();

    public boolean o() {
        return false;
    }

    public abstract ActionDisplayType f();

    public boolean m(BaseUnit am2) {
        return false;
    }

    public boolean n(BaseUnit am2) {
        return false;
    }

    public e v(BaseUnit am2) {
        return null;
    }

    public String d() {
        String string2 = null;
        GameEngine l2 = GameEngine.getInstance();
        int n2 = 0;
        BaseUnit[] amArray = l2.bS.bZ.a();
        int n3 = l2.bS.bZ.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4;
            BaseUnit am2 = amArray[i2];
            if (!(am2 instanceof y))
                continue;
            y y2 = (y) am2;
            if (string2 == null) {
                string2 = this.d(y2);
            }
            if ((n4 = this.b(y2, true)) == -1 || n4 == 0)
                continue;
            n2 += n4;
        }
        if (string2 == null) {
            string2 = this.b();
        }
        if (n2 != -1 && n2 != 0) {
            string2 = string2 + " (" + n2 + ")";
        }
        return string2;
    }

    public boolean h_() {
        return true;
    }

    public String w(BaseUnit am2) {
        return this.d(am2);
    }

    public void a(BaseUnit am2, ae ae2, Paint paint, Paint paint2) {
        b b2;
        int n2;
        Object object;
        Paint paint3 = ae2.g;
        if (paint != null) {
            ae2.a(paint);
        }
        if (this.h_() && (object = this.w(am2)) != null && !((String) object).equals("")) {
            ae2.b((String) object);
        }
        if (paint != null) {
            ae2.a(paint3);
        }
        object = this.f();
        b b3 = this.B();
        if (!b3.c() && object != ActionDisplayType.infoOnlyStockpile) {
            boolean bl2 = true;
            ae2.b(" (");
            BaseUnit am3 = null;
            n2 = 0;
            if (paint2 != null) {
                am3 = am2;
                n2 = paint2.e();
            }
            b3.a(ae2, false, true, 5, bl2, am3, n2);
            ae2.b(")");
        }
        if ((b2 = this.r_()) != null && !b2.c() && object != ActionDisplayType.infoOnlyStockpile) {
            boolean bl3 = true;
            ae2.b(" (");
            n2 = 0;
            b2.a(ae2, false, true, 5, bl3, null, n2);
            ae2.b(")");
        }
    }

    public void a(BaseUnit am2, ae ae2) throws IOException {
        String string2;
        String string3 = com.corrodinggames.rts.gameFramework.f.GameUIController.a(this, false);
        if (string3 != null && !"".equals(string3)) {
            string3 = string3.trim();
            ae2.b("\n" + string3);
        }
        if ((string2 = this.e(am2)) != null && !"".equals(string2)) {
            string2 = string2.trim();
            ae2.b("\n" + string2);
        }
    }

    public boolean c(BaseUnit am2, boolean bl2) {
        return false;
    }

    public void f(BaseUnit am2) {
    }

    public com.corrodinggames.rts.gameFramework.m.Texture_M j() {
        if (this.f() == ActionDisplayType.upgrade) {
            return GameEngine.getInstance().bS.bk;
        }
        return null;
    }

    public com.corrodinggames.rts.gameFramework.m.Texture_M h(BaseUnit am2) {
        return null;
    }

    public int J() {
        return Color.a(100, 255, 255, 255);
    }

    public Rect v() {
        return null;
    }

    public BaseUnit i(BaseUnit am2) {
        return null;
    }

    public boolean s(BaseUnit am2) {
        return true;
    }

    public boolean t(BaseUnit am2) {
        return true;
    }

    public boolean a(BaseUnit am2) {
        return this.unitAction.d(am2);
    }

    public boolean s() {
        return false;
    }

    public boolean o(BaseUnit am2) {
        return true;
    }

    public boolean G() {
        return false;
    }

    public void c(BaseUnit am2) {
    }

    public float l() {
        return 1.0f;
    }

    public int m() {
        return -1;
    }

    public boolean H() {
        return false;
    }

    public boolean I() {
        return false;
    }

    public boolean x() {
        return false;
    }

    public float p(BaseUnit am2) {
        return -1.0f;
    }

    public ArrayList q(BaseUnit am2) {
        return null;
    }

    public KeyBinding M() {
        return null;
    }

    public boolean o_() {
        return false;
    }

    public boolean Q() {
        return false;
    }

    public void a(y y2) {
    }

    public boolean a(float f2, float f3) {
        return false;
    }

    public boolean p() {
        return false;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((AbstractUnitAction) object);
    }
}
