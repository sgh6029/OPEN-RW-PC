/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class BlockOutputStream {
    public BufferedOutputStream a;
    public String b;
    public ByteArrayOutputStream c = new ByteArrayOutputStream();
    public PrintStream d;
    public boolean e = false;

    public void a() throws IOException {
        this.d.flush();
        if (this.a != null) {
            this.a.flush();
        }
    }

    public void b() {
        if (!this.e) {
            this.d.close();
        } else {
            GameEngine.g("TODO: Cannot yet close wrapped stream");
        }
    }

    public BlockOutputStream(boolean bl2) {
        OutputStream outputStream;
        if (bl2) {
            this.a = new BufferedOutputStream(this.c);
            outputStream = this.a;
        } else {
            outputStream = this.c;
        }
        this.d = new PrintStream(outputStream);
    }
}

