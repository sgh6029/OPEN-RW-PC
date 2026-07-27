/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.a_f4;
import com.corrodinggames.rts.gameFramework.utility.e;
import com.corrodinggames.rts.gameFramework.GameSaver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

final class l$4
implements e {
    l$4() {
    }

    @Override
    public void a(a_f4 a2) {
        if (GameEngine.dT) {
            GameEngine.b("activeANRWatchDog: ANR already detected");
        }
        GameEngine.dT = true;
        GameEngine.b("activeANRWatchDog: ANR detected");
        String string2 = GameEngine.a(a2);
        n.a("detectedANR", string2);
        try {
            Thread.sleep(400L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        try {
            File file = GameSaver.a("lastFreeze", "", true);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.print(string2);
            printStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }
}

