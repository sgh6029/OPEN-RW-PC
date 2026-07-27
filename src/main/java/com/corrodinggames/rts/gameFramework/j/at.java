/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class at {
    public GZIPOutputStream a;
    public BufferedOutputStream b;
    public String c;
    public ByteArrayOutputStream d = new ByteArrayOutputStream();
    public DataOutputStream e;
    public boolean f = false;

    public void a() throws IOException {
        this.e.flush();
        if (this.b != null) {
            this.b.flush();
        }
        if (this.a != null) {
            this.a.finish();
        }
    }

    public void b() throws IOException {
        if (!this.f) {
            this.e.close();
        } else {
            GameEngine.g("TODO: Cannot yet close wrapped stream");
        }
    }

    public at(boolean bl2) throws IOException {
        OutputStream outputStream;
        if (bl2) {
            this.a = new GZIPOutputStream(this.d);
            this.b = new BufferedOutputStream(this.a);
            outputStream = this.b;
        } else {
            outputStream = this.d;
        }
        this.e = new DataOutputStream(outputStream);
    }
}

