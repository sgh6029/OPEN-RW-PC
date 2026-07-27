/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.http.message.BasicNameValuePair
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.j.ServerTimeoutTask;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;

class q
implements Runnable {
    Runnable a;

    q(Runnable runnable) {
        this.a = runnable;
    }

    @Override
    public void run() {
        GameEngine.aq();
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.b("LoadFromMasterServer", "Starting load");
        int n2 = n.e++;
        try {
            Timer timer = new Timer();
            timer.schedule((TimerTask)new ServerTimeoutTask(n2), 5000L);
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<BasicNameValuePair>(2);
            arrayList.add(new BasicNameValuePair("action", "list"));
            arrayList.add(new BasicNameValuePair("game_version", Integer.toString(l2.getVersionCode(true))));
            arrayList.add(new BasicNameValuePair("game_version_beta", GameUtils.a(l2.isBetaVersion())));
            boolean bl2 = false;
            n.a(arrayList, false, new q$1(this, n2, l2));
        }
        catch (Exception exception) {
            exception.printStackTrace();
            l2.a("Error getting game list from server", 1);
        }
    }
}

