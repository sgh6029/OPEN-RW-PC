/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.corrodinggames.rts.gameFramework.j;

import android.os.Build;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class v
implements Runnable {
    String a;
    String b;

    v() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        long l2 = GameEngine.V();
        GameEngine l3 = GameEngine.getInstance();
        GameEngine.b("SendErrorReport", "Starting");
        try {
            String string2;
            ArrayList arrayList = new ArrayList(2);
            n.a(arrayList, "action", "error_report");
            n.a(arrayList, "game_version", Integer.toString(l3.getVersionCode(false)));
            n.a(arrayList, "game_version_internal", Integer.toString(l3.getVersionCode(true)));
            n.a(arrayList, "game_version_string", l3.getFullVersionString());
            n.a(arrayList, "package_name", l3.getPackageNameWithContext());
            n.a(arrayList, "installation_source", l3.getInstallerPackageName());
            String string3 = "" + Build.VERSION.SDK_INT;
            if (GameEngine.av()) {
                string3 = "s:0;";
                if (com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a().e()) {
                    string3 = "s:1;";
                }
            }
            if (GameEngine.av() || GameEngine.isDebugVersionStatic2) {
                string2 = System.getProperty("os.name") + " - " + System.getProperty("os.version");
                n.a(arrayList, "system_version", string2);
            }
            n.a(arrayList, "sdk_version", string3);
            n.a(arrayList, "device_model", l3.G());
            n.a(arrayList, "build_version", l3.H());
            n.a(arrayList, "release_version", GameUtils.a(GameEngine.as));
            n.a(arrayList, "dedicated_server", GameUtils.a(GameEngine.isPausedStatic2));
            string2 = "NA";
            if (l3.networkEngine != null) {
                string2 = l3.networkEngine.aR;
            }
            n.a(arrayList, "private_token", string2);
            n.a(arrayList, "private_token_2", GameUtils.b(GameUtils.b(string2)));
            n.a(arrayList, "message", this.a);
            n.a(arrayList, "stacktrace", this.b);
            GameEngine.b("SendErrorReport", "making request");
            BufferedReader bufferedReader = n.a(arrayList);
            String string4 = bufferedReader.readLine();
            if (string4 == null || !string4.contains("CORRODINGGAMES")) {
                GameEngine.b("StartCreateOnMasterServer", "Error bad header returned from the master server: " + string4);
                return;
            }
            GameEngine.b("SendErrorReport", "Send trace successfully");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            float f2 = (float)(GameEngine.V() - l2) / 1000000.0f;
            GameEngine.b("SendErrorReport", "took: " + f2 + " seconds");
        }
    }
}

