/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class l {
    public String a;
    public ByteArrayInputStream b;
    public DataInputStream c;

    public l(byte[] byArray, boolean bl2, boolean bl3) throws IOException {
        this.b = new ByteArrayInputStream(byArray);
        InputStream inputStream = bl2 ? new BufferedInputStream(new GZIPInputStream(this.b)) : this.b;
        this.c = new DataInputStream(inputStream);
    }
}

