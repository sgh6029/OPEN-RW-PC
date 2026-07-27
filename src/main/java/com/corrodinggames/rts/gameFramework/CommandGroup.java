/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import java.util.HashMap;

//属实看不出这是个啥 他只被a引用
public class CommandGroup {
    public byte a;
    HashMap b = new HashMap();

    public void a(CommandGroup b2) {
        this.b.put(b2.a, b2);
    }
}

