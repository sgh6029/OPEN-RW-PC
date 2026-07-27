/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.Display
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.MusicManager;
import com.corrodinggames.rts.gameFramework.GameEngine;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class SlickGameContainer
extends AppGameContainer {
    boolean a = false;
    Object b = new Object();
    DisplayMessageThread c;

    public SlickGameContainer(Game game, int n2, int n3, boolean bl2) throws SlickException {
        super(game, n2, n3, bl2);
    }

    public Graphics a() {
        Graphics graphics = this.getGraphics();
        this.input.poll(this.width, this.height);
        Music.poll(1);
        if (MusicManager.a != null) {
            MusicManager.a.a(1);
        }
        GL.glClear(16640);
        GL.glLoadIdentity();
        graphics.resetTransform();
        graphics.resetFont();
        graphics.resetLineWidth();
        graphics.setAntiAlias(false);
        return graphics;
    }

    public void a(Graphics graphics) {
        graphics.resetTransform();
        GL.flush();
        Display.update();
    }

    @Override
    protected void gameLoop() throws SlickException {
        int n2 = this.getDelta();
        if (!Display.isVisible() && this.updateOnlyOnVisible) {
            try {
                Thread.sleep(100L);
            }
            catch (Exception exception) {}
        } else {
            this.updateAndRender(n2);
        }
        this.updateFPS();
        Display.update((boolean)false);
        if (!this.a) {
            Display.processMessages();
        } else if (this.c == null) {
            this.c = new DisplayMessageThread(this);
            this.c.start();
        }
        if (Display.isCloseRequested() && this.game.closeRequested()) {
            this.running = false;
        }
    }

    @Override
    protected void updateAndRender(int n2) throws SlickException {
        if (this.smoothDeltas && this.getFPS() != 0) {
            n2 = 1000 / this.getFPS();
        }
        this.input.poll(this.width, this.height);
        Music.poll(n2);
        if (MusicManager.a != null) {
            MusicManager.a.a(n2);
        }
        if (!this.paused) {
            this.storedDelta += (long)n2;
            if (this.storedDelta >= this.minimumLogicInterval) {
                if (this.maximumLogicInterval != 0L) {
                    long l2 = this.storedDelta / this.maximumLogicInterval;
                    int n3 = 0;
                    while ((long)n3 < l2) {
                        this.game.update(this, (int)this.maximumLogicInterval);
                        ++n3;
                    }
                    n3 = (int)(this.storedDelta % this.maximumLogicInterval);
                    if ((long)n3 > this.minimumLogicInterval) {
                        this.game.update(this, (int)((long)n3 % this.maximumLogicInterval));
                        this.storedDelta = 0L;
                    } else {
                        this.storedDelta = n3;
                    }
                } else {
                    this.game.update(this, (int)this.storedDelta);
                    this.storedDelta = 0L;
                }
            }
        } else {
            this.game.update(this, 0);
        }
        if (this.hasFocus() || this.getAlwaysRender()) {
            if (this.clearEachFrame) {
                GL.glClear(16640);
            }
            GL.glLoadIdentity();
            Graphics graphics = this.getGraphics();
            graphics.resetTransform();
            graphics.resetFont();
            graphics.resetLineWidth();
            graphics.setAntiAlias(false);
            this.game.render(this, graphics);
            graphics.resetTransform();
            if (this.isShowingFPS()) {
                this.getDefaultFont().drawString(10.0f, 10.0f, "FPS: " + this.recordedFPS);
            }
            GL.flush();
        }
        if (this.targetFPS != -1) {
            Display.sync((int)this.targetFPS);
        }
    }

    @Override
    public void destroy() {
        try {
            Display.destroy();
        }
        catch (Exception exception) {
            GameEngine.a("Error on Display.destroy in destroy", (Throwable)exception);
        }
    }
}

