/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.Sys
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GMissionEngine;
import java.awt.Toolkit;
import org.lwjgl.Sys;

public class JavaMissionEngine
extends GMissionEngine {
    Main a;

    public JavaMissionEngine(Main main) {
        this.a = main;
    }

    @Override
    public void a(String string2, int n2) {
        GameEngine.log("slick queuing-alert:" + string2);
        ScriptEngine.getInstance().addRunnableToQueue(new JavaMissionEngine$1(this, string2));
    }

    @Override
    public void a(String string2, String string3) {
        GameEngine.log("slick queuing-messageBox:" + string3);
        ScriptEngine.getInstance().addRunnableToQueue(new JavaMissionEngine$2(this, string3, string2));
    }

    @Override
    public void a(String string2, boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        if (l2 != null && l2.isGameMinimized) {
            return;
        }
        if (this.a.gameHandler != null) {
            this.a.gameHandler.a(string2, bl2);
        }
    }

    @Override
    public void d() {
        GameEngine.log("refreshModDisplay");
        ScriptEngine.getInstance().addScriptToQueue("mods.refreshModList()");
    }

    @Override
    public void a(Throwable throwable) {
        this.a(throwable, true);
    }

    public void a(Throwable throwable, boolean bl2) {
        try {
            GameEngine.log("----------- onGameCrash ----------");
            Toolkit.getDefaultToolkit();
            String string2 = GameEngine.b(throwable);
            String string3 = string2 + "\nCheck logs for more details";
            GameEngine.log("Error message: " + string3);
            if (com.corrodinggames.rts.a.DebugSocketServer.a()) {
                GameEngine.log("onGameCrash: Not showing popup message due to active debugSocket");
                System.exit(1);
                return;
            }
            if (throwable != null && throwable instanceof OutOfMemoryError && !com.corrodinggames.rts.game.GameLogic.is64Bit) {
                string3 = string3 + " (You are also using the 32 bit version, switching to the 64 bit version might help with out of memory)";
            }
            Sys.alert((String)"Crash", (String)string3);
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            GameEngine.log("onGameCrash: end");
        }
        catch (Throwable throwable2) {
            GameEngine.log("exception showing message");
            throwable2.printStackTrace();
        }
    }

    @Override
    public boolean b() {
        return !GameEngine.getInstance().I() && !this.a.slickLibRocketManager.b();
    }

    @Override
    public boolean c() {
        return com.corrodinggames.rts.a.DebugSocketServer.a();
    }
}

