/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.JavaMissionEngine;

class JavaMissionEngine$2
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ JavaMissionEngine c;

    JavaMissionEngine$2(JavaMissionEngine i2, String string2, String string3) {
        this.c = i2;
        this.a = string2;
        this.b = string3;
    }

    @Override
    public void run() {
        GameEngine.log("slick messageBox:" + this.a);
        this.c.a.slickLibRocketManager.b(this.b, this.a);
    }
}

