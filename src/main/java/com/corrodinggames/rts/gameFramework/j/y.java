/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.MasterServerAuth;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class y
implements Runnable {
    y() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        GameEngine.aq();
        long l2 = GameEngine.V();
        GameEngine l3 = GameEngine.getInstance();
        GameEngine.b("StartCreateOnMasterServer", "Starting create");
        try {
            ArrayList arrayList = new ArrayList(2);
            n.a(arrayList, "action", "add");
            String string2 = "u_" + GameUtils.b();
            n.a(arrayList, "user_id", string2);
            MasterServerAuth.instance.addAuthParams(string2, arrayList);
            n.a(arrayList, "game_name", "Unnamed");
            n.a(arrayList, "game_version", Integer.toString(l3.getVersionCode(true)));
            if (!l3.networkEngine.v) {
                n.a(arrayList, "game_version_string", l3.getVersionNumber());
            } else {
                n.a(arrayList, "game_version_string", "ANY");
            }
            n.a(arrayList, "game_version_beta", GameUtils.a(l3.isBetaVersion()));
            String string3 = l3.networkEngine.au();
            if (string3 != null) {
                n.a(arrayList, "game_mods", string3);
            }
            n.a(arrayList, "private_token", l3.networkEngine.aR);
            n.a(arrayList, "private_token_2", GameUtils.b(GameUtils.b(l3.networkEngine.aR)));
            n.a(arrayList, "confirm", GameUtils.b("a" + GameUtils.b(l3.networkEngine.aR)));
            n.b(arrayList);
            BufferedReader bufferedReader = n.a(arrayList, 15);
            String string4 = bufferedReader.readLine();
            if (string4 == null || !string4.contains("CORRODINGGAMES")) {
                GameEngine.b("StartCreateOnMasterServer", "Error bad header returned from the master server: " + string4);
                return;
            }
            String string5 = bufferedReader.readLine();
            String[] stringArray = string5.split(",");
            if (stringArray.length < 1) {
                GameEngine.b("StartCreateOnMasterServer", "columns.length too short at:" + stringArray.length);
            }
            String string6 = stringArray[0];
            try {
                String string7 = string6;
                GameEngine.b("StartCreateOnMasterServer", "Created server is:" + string7);
                l3.networkEngine.aS = string7;
            }
            catch (NumberFormatException numberFormatException) {
                GameEngine.b("StartCreateOnMasterServer", "failed to load server");
                numberFormatException.printStackTrace();
            }
            if (stringArray.length >= 2) {
                try {
                    MasterServerAuth.authTokenLength = Integer.parseInt(stringArray[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    MasterServerAuth.authTokenLength = -1;
                }
            }
            GameEngine.b("StartCreateOnMasterServer", "Completed create from master server without error");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        finally {
            float f2 = (float)(GameEngine.V() - l2) / 1000000.0f;
            GameEngine.b("StartCreateOnMasterServer", "create took: " + f2 + " seconds");
        }
    }
}

