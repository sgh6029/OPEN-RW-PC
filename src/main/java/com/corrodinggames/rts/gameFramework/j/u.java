/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.j.s;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.net.UnknownHostException;
import java.util.List;

class u
implements Runnable {
    int a;
    List b;
    s c;
    String d;
    boolean e;

    public u(List list, s s2, String string2, boolean bl2, int n2) {
        this.a = n2;
        this.b = list;
        this.c = s2;
        this.d = string2;
        this.e = bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object;
        block10: {
            GameEngine l2 = GameEngine.getInstance();
            try {
                if (n.a) {
                    GameEngine.b("LoadFromMasterServer", this.a + ": Started doSingleRequest");
                }
                object = n.a((List)this.b, (String)this.d, (boolean)this.e).a;
                if (n.a) {
                    GameEngine.b("LoadFromMasterServer", this.a + ": Ended doSingleRequest");
                }
                this.c.a((BufferedReader)object, this.a, this.d);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                String string2 = GameUtils.a(exception, true);
                if (exception instanceof UnknownHostException) {
                    string2 = "DNS lookup failed, check your internet connection";
                }
                if (string2 != null && string2.contains("Cleartext HTTP traffic")) {
                    string2 = string2 + " ( Broken apk file? - " + l2.getPackageNameWithContext() + ")";
                }
                this.c.d = "#" + this.a + ": " + string2;
                String string3 = "Error getting game list from server #" + this.a;
                GameEngine.log(string3);
                if (!l2.isDeveloperMode()) break block10;
                l2.a("Error getting game list from server #" + this.a, 1);
            }
        }
        object = this.c;
        synchronized (object) {
            --this.c.f;
            if (this.c.f == 0) {
                this.c.a();
            }
        }
    }
}

