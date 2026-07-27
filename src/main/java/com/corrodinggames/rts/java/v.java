/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.InputHandler;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes;

public class v
extends InputHandler {
    @Override
    public boolean a(int n2, int n3, boolean bl2) {
        return super.a(n2, n3, bl2);
    }

    @Override
    public boolean a(int n2, int n3) {
        return false;
    }

    @Override
    public int a() {
        return 0;
    }

    @Override
    public float b(int n2, int n3) {
        return 0.0f;
    }

    @Override
    public String c(int n2, int n3) {
        return GameEngine.j(n3) + SlickToAndroidKeycodes.a(n2);
    }
}

