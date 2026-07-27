/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.GameLogic;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameEngineFactory;

import android.content.Context;

public class GameLogicFactory
extends GameEngineFactory {
    @Override
    public GameEngine a(Context context) {
        return new GameLogic(context);
    }
}

