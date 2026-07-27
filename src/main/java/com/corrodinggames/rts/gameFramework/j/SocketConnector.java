/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;
import java.net.Socket;

public class SocketConnector
implements Runnable {
    String serverAddress;
    boolean useUdp;
    boolean isConnecting;
    Thread connectThread;
    public String errorMessage;
    Runnable onCompleteCallback;
    public Socket connectedSocket;
    boolean cancelRequested = false;

    public SocketConnector(String string2, boolean bl2, Runnable runnable) {
        this.serverAddress = string2;
        this.useUdp = bl2;
        this.onCompleteCallback = runnable;
    }

    public boolean a() {
        if (!this.isConnecting) {
            return false;
        }
        this.cancelRequested = true;
        return true;
    }

    public void b() {
        this.isConnecting = true;
        this.connectThread = new Thread(this);
        this.connectThread.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            this.connectedSocket = NetworkEngine.b(this.serverAddress, this.useUdp);
        }
        catch (IOException iOException) {
            // String string2;
            this.errorMessage = iOException.getMessage();
            iOException.printStackTrace();
            return;
        }
        catch (NetworkException ag2) {
            GameEngine.log("Cancelled connectSocketToServer");
            this.errorMessage = "CANCELLED";
        }
        finally {
            this.isConnecting = false;
            if (this.cancelRequested) {
                if (this.connectedSocket != null) {
                    try {
                        this.connectedSocket.close();
                        this.connectedSocket = null;
                        this.errorMessage = "cancelled";
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
            } else {
                this.onCompleteCallback.run();
            }
        }
    }
}

