/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.appFramework.n;
import com.corrodinggames.rts.gameFramework.j.PasswordHandler;

final class ad$7
implements Runnable {
    final /* synthetic */ PasswordHandler a;

    ad$7(PasswordHandler ae2) {
        this.a = ae2;
    }

    @Override
    public void run() {
        n.a(this.a);
    }
}

