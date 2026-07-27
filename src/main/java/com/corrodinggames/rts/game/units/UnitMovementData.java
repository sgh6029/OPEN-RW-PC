/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units;

public final class UnitMovementData {
    public float targetX;
    public float targetY;
    public float velocityX;
    public float velocityY;
    public float rotation;
    public float speed;
    public boolean isActive;
    public float h;
    public float i;
    public BaseUnit targetUnit;
    public float k;
    public float l;
    public boolean m;

    public void a(float f2) {
        this.targetY = this.targetX = f2;
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.rotation = 0.0f;
        this.speed = 0.0f;
        this.isActive = false;
        this.h = 0.0f;
        this.i = 0.0f;
        this.targetUnit = null;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = false;
    }

    public final void a(int n2) {
        if (this.velocityY < (float)n2 && this.velocityY >= 0.0f) {
            this.velocityY = n2;
        }
    }

    public final void b(int n2) {
        if (this.velocityY > (float)(-n2)) {
            this.velocityY = -n2;
        }
    }

    public final boolean a() {
        return this.velocityY == 0.0f;
    }

    public final boolean b() {
        return this.velocityY < 0.0f;
    }
}

