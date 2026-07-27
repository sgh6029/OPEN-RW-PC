/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.a;

import com.corrodinggames.rts.a.DebugSocketServer;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

final class a$1
implements Runnable {
    a$1() {
    }

    @Override
    public void run() {
        for (String string2 : DebugSocketServer.scriptsToRun) {
            GameEngine.log("Running debug script:" + string2);
            try {
                String string3;
                FileReader fileReader = new FileReader(string2);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((string3 = bufferedReader.readLine()) != null) {
                    if ((string3 = string3.trim()).equals("") || string3.startsWith("#")) continue;
                    GameEngine.log("Running: " + string3);
                    String string4 = DebugSocketServer.b("script " + string3);
                    GameEngine.log("got: " + string4.trim());
                }
                bufferedReader.close();
                fileReader.close();
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
            GameEngine.log("End of:" + string2);
        }
    }
}

