/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.GameStateChecksum;

public class ChecksumField {
    public String a;
    public long b;
    boolean c;
    final /* synthetic */ GameStateChecksum d;

    public ChecksumField(GameStateChecksum ak2, String string2) {
        this(ak2, string2, true);
    }

    public ChecksumField(GameStateChecksum ak2, String string2, boolean bl2) {
        this.d = ak2;
        this.a = string2;
        this.c = bl2;
        ak2.b.add(this);
    }
}

