/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class z
implements Runnable {
    z() {
    }

    @Override
    public void run() {
        GameEngine.aq();
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.b("startRemoveOnMasterServer", "Starting remove");
        try {
            ArrayList arrayList = new ArrayList(2);
            n.a(arrayList, "action", "remove");
            String string2 = l2.networkEngine.aS;
            if (string2 == null) {
                GameEngine.b("startRemoveOnMasterServer", "No game id");
                return;
            }
            n.a(arrayList, "id", string2);
            n.a(arrayList, "private_token", l2.networkEngine.aR);
            BufferedReader bufferedReader = n.a(arrayList);
            String string3 = bufferedReader.readLine();
            if (string3 == null || !string3.contains("CORRODINGGAMES")) {
                GameEngine.b("startRemoveOnMasterServer", "Error bad header returned from the master server: " + string3);
                return;
            }
            String string4 = bufferedReader.readLine();
            GameEngine.b("startRemoveOnMasterServer", "Remove server response was:" + string4);
            GameEngine.b("startRemoveOnMasterServer", "Completed load from master server without error");
        }
        catch (IOException iOException) {
            GameEngine.b("startRemoveOnMasterServer", "Remove failed");
            iOException.printStackTrace();
        }
    }
}

