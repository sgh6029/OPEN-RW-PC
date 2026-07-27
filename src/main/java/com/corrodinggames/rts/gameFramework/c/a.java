/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.c;

import com.corrodinggames.rts.gameFramework.c.b;
import com.corrodinggames.rts.gameFramework.c.c;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public class a
implements Runnable {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static float e;
    boolean f = true;
    public static boolean g;
    public ServerSocket h;
    public boolean i = true;
    static ArrayList j;

    public static void a() {
        if (!a) {
            return;
        }
        GameEngine.log("-----");
        GameEngine.log("-----");
        GameEngine.log("----- Debug Active ----");
        GameEngine.log("-----");
        GameEngine.log("-----");
        GameEngine.aV = true;
        GameEngine.getInstance().clearVersionCache();
        a a2 = new a();
        a2.b();
    }

    public void b() {
        if (b) {
            this.a(5677, "");
        }
        GameEngine.getInstance().eb.a(new c(this));
    }

    public void a(int n2, String string2) {
        try {
            g = true;
            GameEngine.aT = true;
            GameEngine.log("");
            GameEngine.log("----- createDebugSocket ----");
            GameEngine.log("port: " + n2);
            GameEngine.log("password: " + string2);
            GameEngine.log("------------------");
            GameEngine.log("");
            if (n2 != -1) {
                this.h = new ServerSocket(n2);
                Thread thread = new Thread(this);
                thread.start();
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    private a() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void run() {
        try {
            while (this.i) {
                Socket socket = this.h.accept();
                try {
                    socket.setTcpNoDelay(true);
                    b b2 = new b(this, socket);
                    Thread thread = new Thread(b2);
                    thread.run();
                }
                catch (IOException iOException) {
                    GameEngine.log("Got IOException on debug connection");
                    iOException.printStackTrace();
                    throw new RuntimeException(iOException);
                }
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public static String a(String string2) {
        String string3 = null;
        String[] stringArray = null;
        int n2 = string2.indexOf(" ");
        if (n2 == -1) {
            n2 = string2.length();
        }
        String string4 = string2.substring(0, n2).toLowerCase(Locale.ENGLISH);
        if (n2 != -1 && string2.length() >= n2 + 1) {
            string3 = string2.substring(n2 + 1);
            stringArray = string3.split(" ");
        }
        if (string4.equalsIgnoreCase("ping")) {
            return "pong";
        }
        if (string4.equalsIgnoreCase("script")) {
            return "todo";
        }
        if (string4.equalsIgnoreCase("function") || string4.equalsIgnoreCase("functionNoTimeout")) {
            return "todo";
        }
        return "unknown command";
    }

    static {
        g = true;
        j = new ArrayList();
    }
}

