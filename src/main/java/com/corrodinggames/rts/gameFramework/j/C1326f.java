/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import java.io.IOException;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;

//TODO: wtf the name?
public class C1326f
        extends GameOutputStream {
    public String a = "";

    @Override
    public void a(int n2) throws IOException {
        this.a = this.a + "|" + n2;
        super.a(n2);
    }

    @Override
    public void a(float f2) throws IOException {
        this.a = this.a + "|" + f2;
        super.a(f2);
    }

    @Override
    public void a(short s2) throws IOException {
        this.a = this.a + "|" + s2;
        super.a(s2);
    }

    @Override
    public void a(boolean bl2) throws IOException {
        this.a = this.a + "|" + bl2;
        super.a(bl2);
    }

    @Override
    public void a(String string2, boolean bl2) throws IOException {
        this.a = this.a + "<" + string2 + ">";
        super.a(string2, bl2);
    }

    @Override
    public void a(String string2) throws IOException {
        this.a = this.a + "</" + string2 + ">";
        super.a(string2);
    }

    @Override
    public void a(BaseUnit am2) throws IOException {
        this.a = this.a + "|u:" + am2;
        super.a(am2);
    }
}
