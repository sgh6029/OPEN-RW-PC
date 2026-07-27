/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 */
package com.corrodinggames.rts.gameFramework.utility;

import android.content.res.AssetFileDescriptor;
import android.content.Context;
import android.content.res.AssetManager;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class AssetInputStream
extends InputStream {
    InputStream a;
    String b;
    String c;
    boolean d;
    String e;

    public boolean a() {
        if (this.a instanceof FileInputStream) {
            return true;
        }
        return !GameEngine.av() && this.c != null;
    }

    public FileDescriptor b() throws IOException {
        if (this.a instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream)this.a;
            return fileInputStream.getFD();
        }
        if (!GameEngine.av() && this.c != null) {
            Context context = com.corrodinggames.rts.appFramework.c.a();
            AssetManager assetManager = context.d();
            AssetFileDescriptor assetFileDescriptor = assetManager.b(this.c);
            return assetFileDescriptor.getFileDescriptor();
        }
        throw new RuntimeException("AssetInputStream: unexpected stream for: " + this.b);
    }

    private AssetInputStream() {
    }

    public AssetInputStream(InputStream inputStream, String string2, String string3) throws FileNotFoundException {
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        this.a = inputStream;
        this.b = string2;
        this.c = string3;
        this.e = GameEngine.U();
    }

    public AssetInputStream(FileInputStream fileInputStream, String string2) throws FileNotFoundException {
        if (fileInputStream == null) {
            throw new FileNotFoundException();
        }
        this.a = fileInputStream;
        this.b = string2;
        this.e = GameEngine.U();
    }

    public AssetInputStream(InputStream inputStream, String string2) throws FileNotFoundException {
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        this.a = inputStream;
        this.b = string2;
        this.e = GameEngine.U();
    }

    public long c() {
        if (!GameEngine.av()) {
            return -1L;
        }
        if (this.b == null) {
            return -2L;
        }
        File file = new File(this.b);
        return file.lastModified();
    }

    public String d() {
        return this.b;
    }

    @Override
    public int available()  throws IOException {
        return this.a.available();
    }

    @Override
    public void close() throws IOException {
        this.d = true;
        this.a.close();
    }

    protected void finalize() {
        if (!this.d) {
            GameEngine.b("AssetInputStream was finalized with being closed");
            GameEngine.b(this.e);
        }
    }

    public boolean equals(Object object) {
        return this.a.equals(object);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public void mark(int n2) {
        this.a.mark(n2);
    }

    @Override
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override
    public int read()  throws IOException {
        return this.a.read();
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) throws IOException {
        return this.a.read(byArray, n2, n3);
    }

    @Override
    public int read(byte[] byArray)  throws IOException {
        return this.a.read(byArray);
    }

    @Override
    public void reset()  throws IOException {
        this.a.reset();
    }

    @Override
    public long skip(long l2) throws IOException {
        return this.a.skip(l2);
    }

    public String toString() {
        return this.a.toString();
    }
}

