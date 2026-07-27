/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.scripts.Root;

class Root$6
implements Runnable {
    final /* synthetic */ String val$serverListDataId;
    final /* synthetic */ String val$serverRowTemplateId;
    final /* synthetic */ String val$refreshButton;
    final /* synthetic */ Root this$0;

    Root$6(Root root, String string2, String string3, String string4) {
        this.this$0 = root;
        this.val$serverListDataId = string2;
        this.val$serverRowTemplateId = string3;
        this.val$refreshButton = string4;
    }

    @Override
    public void run() {
        this.this$0.scriptEngine.addScriptToQueue("displayServerListRaw(" + this.this$0.restrictedString(this.val$serverListDataId) + "," + this.this$0.restrictedString(this.val$serverRowTemplateId) + "," + this.this$0.restrictedString(this.val$refreshButton) + ")");
    }
}

