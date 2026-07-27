/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java.audio.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AudioFile {
    protected InputStream a;
    protected File b;
    protected String c;

    public AudioFile(String string2) {
        this.b = new File(string2);
        this.c = this.b.getName();
    }

    public AudioFile(InputStream inputStream, String string2) {
        this.a = inputStream;
        this.c = string2;
        if (this.a == null) {
            throw new RuntimeException("inputStream==null");
        }
    }

    public InputStream a() {
        if (this.a != null) {
            return this.a;
        }
        try {
            return new FileInputStream(this.b);
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException(fileNotFoundException);
        }
    }

    public String b() {
        String string2 = this.c;
        int n2 = string2.lastIndexOf(46);
        if (n2 == -1) {
            return "";
        }
        return string2.substring(n2 + 1);
    }
}

