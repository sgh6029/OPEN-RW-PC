/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.io.OutputStream;
import java.net.SocketException;

import test.rudp.ReliableSocket;

class q
extends OutputStream {
    protected ReliableSocket a;
    protected byte[] b;
    protected int c;

    public q(ReliableSocket h2) {
        if (h2 == null) {
            throw new NullPointerException("sock");
        }
        this.a = h2;
        try {
            this.b = new byte[this.a.getSendBufferSize()];
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.c = 0;
    }

    @Override
    public synchronized void write(int n2) {
        if (this.c >= this.b.length) {
            this.flush();
        }
        this.b[this.c++] = (byte)(n2 & 0xFF);
    }

    @Override
    public synchronized void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public synchronized void write(byte[] byArray, int n2, int n3) {
        int n4;
        if (byArray == null) {
            throw new NullPointerException();
        }
        if (n2 < 0 || n3 < 0 || n2 + n3 > byArray.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i2 = 0; i2 < n3; i2 += n4) {
            n4 = Math.min(this.b.length, n3 - i2);
            if (n4 > this.b.length - this.c) {
                this.flush();
            }
            System.arraycopy(byArray, n2 + i2, this.b, this.c, n4);
            this.c += n4;
        }
    }

    @Override
    public synchronized void flush() {
        if (this.c > 0) {
            this.a.a(this.b, 0, this.c);
            this.c = 0;
        }
    }

    @Override
    public synchronized void close() {
        this.flush();
        try {
            this.a.shutdownOutput();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}

