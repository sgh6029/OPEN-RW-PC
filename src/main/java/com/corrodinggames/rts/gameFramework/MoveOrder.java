/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import java.io.IOException;

import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

//似乎表示移动指令/路径 被e.java(GameCommand - 猜测)使用
//原 d
public class MoveOrder {
    public com.corrodinggames.rts.gameFramework.k.k a;
    public long b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public UnitMovementType h;

    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.b);
        as2.a(this.c);
        as2.a(this.d);
        as2.a(this.e);
        as2.a(this.f);
        as2.a(this.g);
        as2.a(this.h);
        as2.a(this.a != null);
        if (this.a != null) {
            this.a.a(as2);
        }
    }

    public void a(GameInputStream k2) throws IOException {
        this.b = k2.i();
        this.c = k2.g();
        this.d = k2.g();
        this.e = k2.g();
        this.f = k2.g();
        this.g = k2.readInt();
        this.h = (UnitMovementType) k2.b(UnitMovementType.class);
        boolean bl2 = k2.e();
        if (bl2) {
            boolean bl3 = false;
            this.a = new com.corrodinggames.rts.gameFramework.k.k(null, bl3);
            this.a.a(k2);
        }
    }
}
