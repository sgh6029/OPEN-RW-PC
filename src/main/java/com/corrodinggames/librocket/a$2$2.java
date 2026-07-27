/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket;

import com.corrodinggames.librocket.a$2;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.rts.gameFramework.GameEngine;

class a$2$2
implements Runnable {
    final /* synthetic */ Root a;
    final /* synthetic */ a$2 b;

    a$2$2(a$2 a$2, Root root) {
        this.b = a$2;
        this.a = root;
    }

    @Override
    public void run() {
        if (this.b.a.a) {
            GameEngine.b("AskPasswordCallBack already called");
            return;
        }
        this.b.a.a = true;
        this.a.closeAlertOnly();
        this.b.c.a();
    }
}

