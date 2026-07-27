/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

final class UnitStateTracker {
    public boolean stateFlag1;
    public boolean stateFlag2;
    public boolean stateFlag3;
    boolean isReset;
    public float stateValue1;
    public float stateValue2;

    UnitStateTracker() {
    }

    public void a() {
        this.stateFlag1 = false;
        this.stateFlag2 = false;
        this.stateFlag3 = false;
        this.stateValue1 = 0.0f;
        this.stateValue2 = 0.0f;
        this.isReset = true;
    }
}

