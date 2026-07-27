/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.http.client.ClientProtocolException
 *  org.apache.http.message.BasicNameValuePair
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.MasterServerAuth;
import com.corrodinggames.rts.gameFramework.j.n;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

class p
implements Runnable {
    p() {
    }

    @Override
    public void run() {
        GameEngine.aq();
        GameEngine l2 = GameEngine.getInstance();
        GameEngine.b("GetOwnInfoRunnable", "Starting getOwnInfoFromMasterServer");
        try {
            String string2;
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<BasicNameValuePair>(2);
            arrayList.add(new BasicNameValuePair("action", "self_info"));
            n.a(arrayList, "port", Integer.toString(l2.networkEngine.m));
            n.a(arrayList, "id", l2.networkEngine.aS);
            MasterServerAuth.instance.addTokenHashParam(l2.networkEngine.aS, arrayList);
            MasterServerAuth.instance.addOptionalTokenHashParam(l2.networkEngine.aS, arrayList);
            BufferedReader bufferedReader = n.a(arrayList);
            String string3 = bufferedReader.readLine();
            if (string3 == null || !string3.contains("CORRODINGGAMES")) {
                GameEngine.b("GetOwnInfoRunnable", "Error bad header returned from the master server: " + string3);
                return;
            }
            while ((string2 = bufferedReader.readLine()) != null) {
                String[] stringArray = string2.split(",");
                if (stringArray.length <= 1) {
                    GameEngine.b("GetOwnInfoRunnable", "columns.length too short at:" + stringArray.length);
                    continue;
                }
                String string4 = stringArray[0];
                String string5 = stringArray[1];
                try {
                    GameEngine.b("GetOwnInfoRunnable", "got info");
                    l2.networkEngine.a(true, string4, (Boolean)Boolean.parseBoolean(string5));
                }
                catch (NumberFormatException numberFormatException) {
                    GameEngine.b("GetOwnInfoRunnable", "failed to load server");
                    numberFormatException.printStackTrace();
                }
            }
            com.corrodinggames.rts.appFramework.p.l();
            GameEngine.b("GetOwnInfoRunnable", "Completed load from master server without error");
        }
        catch (ClientProtocolException clientProtocolException) {
            l2.networkEngine.a(false, null, null);
            clientProtocolException.printStackTrace();
        }
        catch (IOException iOException) {
            l2.networkEngine.a(false, null, null);
            iOException.printStackTrace();
        }
        catch (Exception exception) {
            l2.networkEngine.a(false, null, null);
            GameEngine.a("GetOwnInfoRunnable Failed", exception);
        }
    }
}

