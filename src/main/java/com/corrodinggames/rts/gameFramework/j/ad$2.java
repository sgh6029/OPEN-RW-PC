/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

final class ad$2
extends w {
    final /* synthetic */ Object d;

    ad$2(Object object) {
        this.d = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(String string2) {
        super.a(string2);
        Object object = this.d;
        synchronized (object) {
            this.d.notify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(String string2, x x2, Exception exception) {
        super.a(string2, x2, exception);
        Object object = this.d;
        synchronized (object) {
            this.d.notify();
        }
    }
}

