/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class UpdateServerRunnable
implements Runnable {
    UpdateServerRunnable() {
    }

    @Override
    public void run() {
        GameEngine.aq();
        GameEngine l2 = GameEngine.getInstance();
        try {
            ArrayList arrayList = new ArrayList(2);
            n.a(arrayList, "action", "update");
            String string2 = l2.networkEngine.aS;
            if (string2 == null) {
                GameEngine.b("startUpdateOnMasterServer", "No game id");
                return;
            }
            n.a(arrayList, "id", string2);
            n.a(arrayList, "private_token", l2.networkEngine.aR);
            if (GameEngine.ax()) {
                n.a(arrayList, "check_port", "false");
            }
            n.b(arrayList);
            BufferedReader bufferedReader = n.a(arrayList);
            String string3 = bufferedReader.readLine();
            if (string3 == null || !string3.contains("CORRODINGGAMES")) {
                GameEngine.b("startUpdateOnMasterServer", "Error bad header returned from the master server: " + string3);
                return;
            }
            String string4 = bufferedReader.readLine();
            if (!"GAME UPDATED".equals(string4)) {
                GameEngine.b("startUpdateOnMasterServer", "Update server response was:" + string4);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

