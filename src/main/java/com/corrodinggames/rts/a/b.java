/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.a;

import com.corrodinggames.rts.a.DebugSocketServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class b
implements Runnable {
    Socket a;
    final /* synthetic */ DebugSocketServer b;

    public b(DebugSocketServer a2, Socket socket) {
        this.b = a2;
        this.a = socket;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(this.a.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
            while (this.b.b) {
                String string2 = bufferedReader.readLine();
                if (string2 == null) {
                    break;
                }
                String string3 = com.corrodinggames.rts.a.DebugSocketServer.b(string2);
                printWriter.print(string3);
                printWriter.flush();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        finally {
            try {
                this.a.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

