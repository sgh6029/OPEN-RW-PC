/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.rts.gameFramework.GameEngine;

class Root$8
implements Runnable {
    final /* synthetic */ GameEngine val$game;
    final /* synthetic */ String val$saveName;
    final /* synthetic */ Root this$0;

    Root$8(Root root,GameEngine l2, String string2) {
        this.this$0 = root;
        this.val$game = l2;
        this.val$saveName = string2;
    }

    @Override
    public void run() {
        this.val$game.ca.b(this.val$saveName);
        this.this$0.closePopup();
        this.this$0.showMaps();
    }
}

