/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.scripts.Root;
import java.util.HashMap;

class Root$1
implements Runnable {
    final /* synthetic */ String val$level;
    final /* synthetic */ Root this$0;

    Root$1(Root root, String string2) {
        this.this$0 = root;
        this.val$level = string2;
    }

    @Override
    public void run() {
        HashMap hashMap = null;
        boolean bl2 = false;
        this.this$0.libRocket.setDocument(this.val$level, hashMap, bl2);
        this.this$0.onShowNewScreen();
    }
}

