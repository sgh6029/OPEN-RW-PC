/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import test.rudp.ReliableSocket;

class o
extends InputStream {
    protected ReliableSocket a;
    protected byte[] b;
    protected int c;
    protected int d;

    public o(ReliableSocket h2) {
        if (h2 == null) {
            throw new NullPointerException("sock");
        }
        this.a = h2;
        try {
            this.b = new byte[this.a.getReceiveBufferSize()];
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.d = 0;
        this.c = 0;
    }

    @Override
    public synchronized int read() {
        if (this.a() < 0) {
            return -1;
        }
        return this.b[this.c++] & 0xFF;
    }

    @Override
    public synchronized int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public synchronized int read(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new NullPointerException();
        }
        if (n2 < 0 || n3 < 0 || n2 + n3 > byArray.length) {
            throw new IndexOutOfBoundsException();
        }
        if (this.a() < 0) {
            return -1;
        }
        int n4 = Math.min(this.available(), n3);
        System.arraycopy(this.b, this.c, byArray, n2, n4);
        this.c += n4;
        return n4;
    }

    @Override
    public synchronized int available() {
        return this.d - this.c;
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public void close() {
        try {
            this.a.shutdownInput();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private int a() {
        if (this.available() == 0) {
            try {
                this.d = this.a.b(this.b, 0, this.b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.c = 0;
        }
        return this.d;
    }
}

