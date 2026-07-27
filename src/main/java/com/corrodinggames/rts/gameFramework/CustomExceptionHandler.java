/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.gameFramework.SettingsEngine;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class CustomExceptionHandler
implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    CustomExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void uncaughtException(Thread thread, Throwable throwable) {
        boolean bl2 = false;
        boolean bl3 = false;
        GameEngine l2 = null;
        try {
            GameEngine.dQ = null;
            GameEngine.dR = null;
            GameEngine.dP = null; 
            System.gc();
            try {
                GameEngine.log("uncaughtException start");
                l2 = GameEngine.getInstance();
                if (l2 != null && throwable instanceof OutOfMemoryError) {
                    GameEngine.log("Freeing memory");
                    try {
                        TileMap.al = null;
                        if (l2.bL != null) {
                            l2.bL = null;
                        }
                        if (l2.bN != null) {
                            l2.bN.i();
                            l2.bN = null;
                        }
                        System.gc();
                        GameEngine.log("uncaughtException: Memory freed");
                    }
                    catch (Throwable throwable2) {
                        GameEngine.log("exception freeing memory");
                        throwable2.printStackTrace();
                    }
                }
                GameEngine.a("gameEngine:uncaughtExceptionHandler", throwable);
                String string2 = GameEngine.a(throwable);
                boolean bl4 = false;
                boolean bl5 = false;
                if (l2 != null) {
                    SettingsEngine settingsEngine = l2.bQ;
                    if (settingsEngine != null) {
                        bl4 = settingsEngine.sendReports;
                    } else {
                        GameEngine.log("CustomExceptionHandler: no settings");
                    }
                } else {
                    GameEngine.log("CustomExceptionHandler: no game");
                }
                if (GameEngine.dO) {
                    GameEngine.log("CustomExceptionHandler: a crash was already sent");
                    bl4 = false;
                    bl5 = true;
                }
                GameEngine.dO = true;
                if (bl4) {
                    try {
                        GameEngine.log("Starting errorReport");
                        n.a("uncaughtException", string2);
                        GameEngine.log("waiting");
                        Thread.sleep(800L);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                if (!bl5 && l2 != null && l2.dH != null) {
                    l2.dH.a(throwable);
                }
                bl3 = true;
                GameEngine.e("fatal", string2);
            }
            catch (Exception exception) {
                GameEngine.log("exception sending crash");
                exception.printStackTrace();
            }
            if (l2 != null) {
                if (l2.dH != null && l2.dH.a()) {
                    GameEngine.log("gameCrashesDontExit=true");
                    bl2 = true;
                    return;
                }
                if (l2.networkEngine != null && l2.networkEngine.B) {
                    GameEngine.log("Sending disconnect");
                    l2.networkEngine.c("Game crash");
                }
            }
            if (!GameEngine.isDesktopVersionStatic) {
                if (this.a != null) {
                    GameEngine.log("CustomExceptionHandler: sending to: defaultUEH.uncaughtException");
                    this.a.uncaughtException(thread, throwable);
                    GameEngine.log("CustomExceptionHandler: back from: defaultUEH.uncaughtException");
                } else {
                    GameEngine.log("CustomExceptionHandler: defaultUEH==null");
                    System.exit(2);
                }
            }
            GameEngine.av = throwable;
            bl2 = true;
        }
        catch (Throwable throwable3) {
            GameEngine.log("Exception in uncaughtException");
            throwable3.printStackTrace();
        }
        finally {
            if (!bl2) {
                GameEngine.log("Crash was not handled, exiting");
                Runtime.getRuntime().halt(1);
            }
        }
    }
}
