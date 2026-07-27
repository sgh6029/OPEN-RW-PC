/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import java.io.IOException;

class Multiplayer$1
implements Runnable {
    final /* synthetic */ String val$teamIdString;
    final /* synthetic */ Multiplayer this$0;

    Multiplayer$1(Multiplayer multiplayer, String string2) {
        this.this$0 = multiplayer;
        this.val$teamIdString = string2;
    }

    @Override
    public void run() {
        try {
            this.this$0.showPlayerConfigNow(this.val$teamIdString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

