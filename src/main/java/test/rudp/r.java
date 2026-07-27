/*
 * Decompiled with CFR 0.152.
 */
package test.rudp;

import java.io.IOException;

public class r {
    public static final r a = new r();
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public r() {
        this.a(32, 32, 300, 70, 0, 3, 3, 3, 2000, 600, 300);
    }

    public r(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        this.a(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
    }

    private void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        try {
            this.a("maxSendQueueSize", n2, 1, 255);
            this.a("maxRecvQueueSize", n3, 1, 255);
            this.a("maxSegmentSize", n4, 22, 6535);
            this.a("maxOutstandingSegs", n5, 1, 255);
            this.a("maxRetrans", n6, 0, 255);
            this.a("maxCumulativeAcks", n7, 0, 255);
            this.a("maxOutOfSequence", n8, 0, 255);
            this.a("maxAutoReset", n9, 0, 255);
            this.a("nullSegmentTimeout", n10, 0, 65535);
            this.a("retransmissionTimeout", n11, 100, 65535);
            this.a("cumulativeAckTimeout", n12, 100, 65535);
        } catch (IOException e) {
        }
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
        this.f = n6;
        this.g = n7;
        this.h = n8;
        this.i = n9;
        this.j = n10;
        this.k = n11;
        this.l = n12;
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.b).append(", ");
        stringBuilder.append(this.c).append(", ");
        stringBuilder.append(this.d).append(", ");
        stringBuilder.append(this.e).append(", ");
        stringBuilder.append(this.f).append(", ");
        stringBuilder.append(this.g).append(", ");
        stringBuilder.append(this.h).append(", ");
        stringBuilder.append(this.i).append(", ");
        stringBuilder.append(this.j).append(", ");
        stringBuilder.append(this.k).append(", ");
        stringBuilder.append(this.l);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void a(String string2, int n2, int n3, int n4) throws IOException {
        if (n2 < n3 || n2 > n4) {
            throw new IOException(string2 + " out of range");
        }
    }
}
