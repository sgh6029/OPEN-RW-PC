/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a.a;

import java.io.IOException;

import com.corrodinggames.rts.game.a.a.AIBehaviorType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

public abstract class AIBehavior {
    public abstract AIBehaviorType a();

    public void a(float f2, com.corrodinggames.rts.game.a.AIController a2) {
    }

    public void b(float f2, com.corrodinggames.rts.game.a.AIController a2) {
    }

    public void a(GameInputStream k2) throws IOException {
    }

    public void a(GameOutputStream as2) throws IOException {
    }

    public void a(com.corrodinggames.rts.game.a.AIController a2, y y2) {
    }

    public void b(com.corrodinggames.rts.game.a.AIController a2, y y2) {
    }
}

