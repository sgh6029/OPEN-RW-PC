/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameEngine;

final class ad$1
extends PasswordHandler {
    final /* synthetic */ Object a;

    ad$1(Object object) {
        this.a = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.log("Entered password");
        if (l2.networkEngine.C) {
            GameEngine.a("Cannot enter a password when we are a server");
        } else {
            l2.networkEngine.n = string2;
        }
        Object object = this.a;
        synchronized (object) {
            this.a.notify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a() {
        Object object = this.a;
        synchronized (object) {
            this.a.notify();
        }
    }
}

