/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.JavaMissionEngine;

class JavaMissionEngine$1
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ JavaMissionEngine b;

    JavaMissionEngine$1(JavaMissionEngine i2, String string2) {
        this.b = i2;
        this.a = string2;
    }

    @Override
    public void run() {
        GameEngine.log("slick post-alert:" + this.a);
        this.b.a.slickLibRocketManager.b("", this.a);
    }
}

