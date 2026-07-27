/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.librocket.scripts;

import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class ScriptEngine$Action {
    public String script;
    public boolean tryToCatchCrash;
    public String caughtCrash;
    public boolean completed;
    public int framesDelay;

    public void run(ScriptEngine scriptEngine) {
        block6: {
            try {
                scriptEngine.processScript(this.script);
            }
            catch (Exception exception) {
                if (this.tryToCatchCrash) {
                    GameEngine.a("caught script crash", (Throwable)exception);
                    this.caughtCrash = GameUtils.a(exception);
                    break block6;
                }
                throw new RuntimeException(exception);
            }
            finally {
                this.completed = true;
            }
        }
    }

    public String waitForCompletionOrCrash(boolean bl2) {
        for (int i2 = 0; i2 < 3000; ++i2) {
            if (this.completed) {
                return this.caughtCrash;
            }
            try {
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            if (!bl2) continue;
            i2 = 0;
        }
        return "Time Out";
    }
}

