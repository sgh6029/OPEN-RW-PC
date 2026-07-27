/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.l.b;

class Root$11
extends b {
    final /* synthetic */ Root this$0;

    Root$11(Root root) {
        this.this$0 = root;
    }

    @Override
    public void onFileSelected() {
        GameEngine.log("importFilePopup: onFileSelected");
    }

    @Override
    public void onCancelled() {
        GameEngine.log("importFilePopup: onCancelled");
    }
}

