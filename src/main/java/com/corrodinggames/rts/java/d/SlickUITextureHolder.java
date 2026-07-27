/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.d;

import com.corrodinggames.librocket.c;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.AssetType;
import com.corrodinggames.rts.gameFramework.utility.FileLoaderFactory;
import com.corrodinggames.rts.gameFramework.utility.IFileLoader;
import com.corrodinggames.rts.java.d.SlickLibRocketManager;
import com.corrodinggames.rts.java.SlickGraphicsEngine;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.PNGImageData;

public class SlickUITextureHolder
extends c {
    Image h;
    boolean i;
    ImageBuffer j;
    final /* synthetic */ SlickLibRocketManager k;

    public SlickUITextureHolder(SlickLibRocketManager a2) {
        super(a2);
        this.k = a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean a() {
        InputStream inputStream;
        IFileLoader af2 = FileLoaderFactory.a(this.a);
        if (af2 != null) {
            inputStream = af2.b(this.a, true);
            if (inputStream == null) {
                GameEngine.g("Failed to open zipped file: " + this.a);
                return false;
            }
        } else {
            try {
                inputStream = new FileInputStream(this.a);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return false;
            }
        }
        try {
            PNGImageData pNGImageData;
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);){
                pNGImageData = new PNGImageData();
                pNGImageData.loadImage(bufferedInputStream);
            }
            this.h = new Image(pNGImageData);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            GameEngine.a(AssetType.uiImage, (Throwable)outOfMemoryError);
            this.h = com.corrodinggames.rts.java.SlickGraphicsEngine.r.C();
            this.i = true;
        }
        catch (IOException iOException) {
            GameEngine.a("Exception loading image: " + this.a, (Throwable)iOException);
            this.h = com.corrodinggames.rts.java.SlickGraphicsEngine.s.C();
            this.i = true;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            unsupportedOperationException.printStackTrace();
            GameEngine.a("Exception loading image: " + this.a, (Throwable)unsupportedOperationException);
            this.h = com.corrodinggames.rts.java.SlickGraphicsEngine.s.C();
            this.i = true;
        }
        this.width = this.h.getWidth();
        this.height = this.h.getHeight();
        if (this.c && (this.width > 500 || this.height > 500)) {
            GameEngine.log("Map thumbnail is too large. Size:(" + this.width + "," + this.height + ") (max:500 pixels)");
            this.h = com.corrodinggames.rts.java.SlickGraphicsEngine.t.C();
            this.i = true;
            this.width = this.h.getWidth();
            this.height = this.h.getHeight();
        }
        return true;
    }

    @Override
    public void remove() {
        if (this.h != null && !this.i) {
            try {
                this.h.destroy();
            }
            catch (SlickException slickException) {
                slickException.printStackTrace();
            }
        }
        this.a = null;
        this.j = null;
        this.h = null;
        this.i = false;
    }
}

