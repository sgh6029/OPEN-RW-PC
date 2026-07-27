/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import java.io.IOException;
import java.io.Reader;

public class l
extends Reader {
    private Reader a;
    private char[] b;
    private int c;
    private int d;
    private int e = -1;
    private int f = -1;

    public l(Reader reader) {
        this(reader, 8192);
    }

    public l(Reader reader, int n2) {
        super((Object)reader);
        if (n2 <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.a = reader;
        this.b = new char[n2];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            if (!this.c()) {
                this.a.close();
                this.b = null;
            }
        }
    }

    private int b() throws IOException {
        int n2;
        if (this.e == -1 || this.c - this.e >= this.f) {
            int n3 = this.a.read(this.b, 0, this.b.length);
            if (n3 > 0) {
                this.e = -1;
                this.c = 0;
                this.d = n3;
            }
            return n3;
        }
        if (this.e == 0 && this.f > this.b.length) {
            n2 = this.b.length * 2;
            if (n2 > this.f) {
                n2 = this.f;
            }
            char[] cArray = new char[n2];
            System.arraycopy(this.b, 0, cArray, 0, this.b.length);
            this.b = cArray;
        } else if (this.e > 0) {
            System.arraycopy(this.b, this.e, this.b, 0, this.b.length - this.e);
            this.c -= this.e;
            this.d -= this.e;
            this.e = 0;
        }
        n2 = this.a.read(this.b, this.c, this.b.length - this.c);
        if (n2 != -1) {
            this.d += n2;
        }
        return n2;
    }

    private boolean c() {
        return this.b == null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mark(int n2) throws IOException {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        Object object = this.lock;
        synchronized (object) {
            this.d();
            this.f = n2;
            this.e = this.c;
        }
    }

    private void d() throws IOException {
        if (this.c()) {
            throw new IOException("BufferedReader is closed");
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            this.d();
            if (this.c < this.d || this.b() != -1) {
                return this.b[this.c++];
            }
            return -1;
        }
    }

    public static void a(int n2, int n3, int n4) {
        if ((n3 | n4) < 0 || n3 > n2 || n2 - n3 < n4) {
            throw new IndexOutOfBoundsException();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read(char[] cArray, int n2, int n3) throws IOException {
        Object object = this.lock;
        synchronized (object) {
            int n4;
            this.d();
            l.a(cArray.length, n2, n3);
            int n5 = n3;
            while (n5 > 0) {
                int n6;
                n4 = this.d - this.c;
                if (n4 > 0) {
                    n6 = n4 >= n5 ? n5 : n4;
                    System.arraycopy(this.b, this.c, cArray, n2, n6);
                    this.c += n6;
                    n2 += n6;
                    n5 -= n6;
                }
                if (n5 == 0 || n5 < n3 && !this.a.ready()) break;
                if ((this.e == -1 || this.c - this.e >= this.f) && n5 >= this.b.length) {
                    n6 = this.a.read(cArray, n2, n5);
                    if (n6 <= 0) break;
                    n5 -= n6;
                    this.e = -1;
                    break;
                }
                if (this.b() != -1) continue;
                break;
            }
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl24 : MonitorExitStatement: MONITOREXIT : var4_4
            n4 = n3 - n5;
            return n4 > 0 || n4 == n3 ? n4 : -1;
        }
    }

    public String a() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            int n2;
            this.d();
            if (this.c == this.d && this.b() == -1) {
                return null;
            }
            for (n2 = this.c; n2 < this.d; ++n2) {
                char c2 = this.b[n2];
                if (c2 > '\r') continue;
                if (c2 == '\n') {
                    String string2 = new String(this.b, this.c, n2 - this.c);
                    this.c = n2 + 1;
                    return string2;
                }
                if (c2 != '\r') continue;
                String string3 = new String(this.b, this.c, n2 - this.c);
                this.c = n2 + 1;
                if ((this.c < this.d || this.b() != -1) && this.b[this.c] == '\n') {
                    ++this.c;
                }
                return string3;
            }
            n2 = 0;
            StringBuilder stringBuilder = new StringBuilder(80);
            stringBuilder.append(this.b, this.c, this.d - this.c);
            while (true) {
                this.c = this.d;
                if (n2 == 10) {
                    return stringBuilder.toString();
                }
                if (this.b() == -1) {
                    return stringBuilder.length() > 0 || n2 != 0 ? stringBuilder.toString() : null;
                }
                for (int i2 = this.c; i2 < this.d; ++i2) {
                    int n3 = this.b[i2];
                    if (n2 == 0) {
                        if (n3 != 10 && n3 != 13) continue;
                        n2 = n3;
                        continue;
                    }
                    if (n2 == 13 && n3 == 10) {
                        if (i2 > this.c) {
                            stringBuilder.append(this.b, this.c, i2 - this.c - 1);
                        }
                        this.c = i2 + 1;
                        return stringBuilder.toString();
                    }
                    if (i2 > this.c) {
                        stringBuilder.append(this.b, this.c, i2 - this.c - 1);
                    }
                    this.c = i2;
                    return stringBuilder.toString();
                }
                if (n2 == 0) {
                    stringBuilder.append(this.b, this.c, this.d - this.c);
                } else {
                    stringBuilder.append(this.b, this.c, this.d - this.c - 1);
                }
                try {
                    Thread.sleep(5L);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean ready() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            this.d();
            return this.d - this.c > 0 || this.a.ready();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            this.d();
            if (this.e == -1) {
                throw new IOException("Invalid mark");
            }
            this.c = this.e;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long skip(long l2) throws IOException {
        if (l2 < 0L) {
            throw new IllegalArgumentException("byteCount < 0: " + l2);
        }
        Object object = this.lock;
        synchronized (object) {
            this.d();
            if (l2 < 1L) {
                return 0L;
            }
            if ((long)(this.d - this.c) >= l2) {
                this.c = (int)((long)this.c + l2);
                return l2;
            }
            this.c = this.d;
            for (long i2 = (long)(this.d - this.c); i2 < l2; i2 += (long)(this.d - this.c)) {
                if (this.b() == -1) {
                    return i2;
                }
                if ((long)(this.d - this.c) >= l2 - i2) {
                    this.c = (int)((long)this.c + (l2 - i2));
                    return l2;
                }
                this.c = this.d;
            }
            return l2;
        }
    }
}

