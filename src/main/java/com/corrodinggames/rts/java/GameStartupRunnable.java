/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.Sys
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.DisplayMode
 *  org.lwjgl.opengl.GL11
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.java.Main;
import java.awt.Toolkit;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;

public class GameStartupRunnable
implements Runnable {
    final /* synthetic */ Main a;

    public GameStartupRunnable(Main main) {
        this.a = main;
    }

    @Override
    public void run() {
        GameEngine.aq();
        try {
            this.a.gameContainer.start();
        }
        catch (SlickException slickException) {
            if (!"Failed to initialise the LWJGL display".equals(slickException.getMessage())) {
                throw new RuntimeException(slickException);
            }
            GameEngine.a("Error starting display", (Throwable)slickException);
            String string2 = "\nFailed to get opengl version";
            try {
                System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
                Display.setDisplayMode((DisplayMode)new DisplayMode(100, 100));
                Display.create();
                String string3 = GL11.glGetString((int)7938);
                Display.destroy();
                GameEngine.log("OpenGL version: " + string3);
                string2 = "\n";
                string2 = string2 + "OpenGL version detected: " + string3;
                if (string3.startsWith("1.0") || string3.startsWith("1.1")) {
                    string2 = string2 + "\n---\nOpenGL 1.1 is over 20 years old you might be using a fallback microsoft driver. Try updating your graphics drivers from the manufacturer.";
                }
            }
            catch (Exception exception) {
                GameEngine.a("Failed to get opengl info", (Throwable)exception);
            }
            Toolkit.getDefaultToolkit();
            Sys.alert((String)"Error", (String)("Failed to create display." + string2));
            System.exit(1);
        }
        GameEngine.log("Game stopped running shutting down");
        GameEngine l2 = GameEngine.getInstance();
        l2.ca.b("lastgame", false);
        this.a.a(true);
    }
}

