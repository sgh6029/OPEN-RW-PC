/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.PacketData;
import com.corrodinggames.rts.gameFramework.j.NetworkConnection;
import com.corrodinggames.rts.gameFramework.j.c$1;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

final class d
        implements Runnable {
    Boolean a = true;
    final /* synthetic */ NetworkConnection b;

    private d(NetworkConnection c2) {
        this.b = c2;
    }

    @Override
    public void run() {
        GameEngine.aq();
        Thread.currentThread().setName("ReceiveWorker-" + this.b.g());
        try {
            this.a();
        } catch (EOFException eOFException) {
            this.b.a("network:ReceiveWorker: EOF reading packet", eOFException);
        } catch (IOException iOException) {
            if (!this.b.a) {
                iOException.printStackTrace();
            }
            if (GameEngine.isDebugVersionStatic2 && iOException instanceof SocketException && !this.b.a) {
                String string2;
                GameEngine l2 = GameEngine.getInstance();
                if (!l2.networkEngine.C && l2.networkEngine.aW && (string2 = iOException.getMessage()) != null
                        && string2.contains("EBADF")) {
                    l2.i("Warning: This disconnect likely due to iOS removing sockets of background apps. Avoid minimising the game in multiplayer. Note: Games can be rejoined.");
                }
            }
            this.b.c("network:ReceiveWorker: " + iOException.getMessage());
        } catch (OutOfMemoryError outOfMemoryError) {
            GameEngine.c(outOfMemoryError);
            this.b.c("network:ReceiveWorker OutOfMemoryError: " + outOfMemoryError.getMessage());
        }
        NetworkConnection.a(this.b, true, false);
    }

    void a() throws IOException {
        InputStream inputStream = this.b.d.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        while (this.a.booleanValue() && !this.b.a && !this.b.d.isClosed()) {
            try {

                int n2 = dataInputStream.readInt();

                int n3 = dataInputStream.readInt();

                if (n2 > 20000000) {
                    this.b.b("readData(): new packet of type:" + n3 + " has size of:" + n2);
                }

                if (n2 > 10000) {
                    int n4 = 50000000;
                    if (NetworkConnection.a((NetworkConnection) this.b).C) {
                        n4 = 1000000;
                    }
                    if (!this.b.p) {
                        n4 = 10000;
                    }
                    if (n2 > n4) {
                        this.b.b("Requested packet too large rejecting (max:" + n4 + ")");
                        return;
                    }
                }

                if (n2 < 0) {
                    this.b.b("Requested packet negative size:" + n2 + " rejecting");
                    return;
                }
                
                PacketData au2 = new PacketData(n3);
                au2.c = new byte[n2];
                this.b.V = 0;
                this.b.U = n2;

                int n5 = 0;
                au2.a = this.b;

                while (n5 < n2 && !this.b.a) {
                    int n6 = dataInputStream.read(au2.c, n5, n2 - n5); //problem in there!!!!!!!!!!

                    if (n6 == -1) {
                        this.b.b("we got to the end of the stream?!?");
                        return;
                    }
                    ++this.b.P;
                    this.b.V = n5 += n6;
                }

                this.b.U = 0;
                this.b.V = 0;

                if (this.b.a) {
                    continue;
                }

                if (au2.b > 100) {
                    NetworkConnection.a(this.b).c(au2);
                    continue;
                }

                NetworkConnection.a((NetworkConnection) this.b).aN.add(au2);
            } catch (Exception e) {
                GameEngine.log("Exception in ReceiveWorker: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        }
    }

    /* synthetic */ d(NetworkConnection c2, c$1 c$1) {
        this(c2);
    }
}
