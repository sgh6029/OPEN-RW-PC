/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.text.Spanned
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.TextView
 */
package com.corrodinggames.rts.appFramework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.util.ArrayList;

import com.corrodinggames.rts.appFramework.b;
import com.corrodinggames.rts.appFramework.n$1;
import com.corrodinggames.rts.appFramework.n$2;
import com.corrodinggames.rts.appFramework.n$3;
import com.corrodinggames.rts.appFramework.n$4;
import com.corrodinggames.rts.appFramework.n$5;
import com.corrodinggames.rts.appFramework.o;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.gameFramework.h.a;
import com.corrodinggames.rts.gameFramework.j.PasswordHandler;
import com.corrodinggames.rts.gameFramework.j.GameModeType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameMode;

public class n
extends b {
    public static n c;
    boolean d;
    final Handler e = new Handler();//原先没有被初始化 请留意
    public static boolean f;
    public boolean g;
    TextView h;
    private Handler k;
    private Runnable l;
    private Runnable m;
    static PasswordHandler i;
    static AlertDialog j;

    public static boolean l() {
        if (c == null) {
            return false;
        }
        return n.c.g;
    }

    public static void m() {
        if (c != null) {
            n n2 = c;
            n$1 n$1 = new n$1(n2);
            n.c.e.a(n$1);
        }
    }

    public static void d(String string2) {
        n n2 = c;
        if (n2 == null) {
            return;
        }
        Message message = n2.k.a();
        message.d().putString("text", string2);
        n2.k.c(message);
    }

    void n() {
        if (!this.d) {
            com.corrodinggames.rts.gameFramework.GameEngine.b("addMessageToChatLogInternal: !onCreateFinished");
            return;
        }
        GameEngine l2 = GameEngine.getInstance();
        Spanned spanned = l2.networkEngine.aC.b(true);
        if (this.h == null) {
            throw new RuntimeException("chatLog==null");
        }
        if (spanned == null) {
            throw new RuntimeException("chatLogHTML==null");
        }
        try {
            this.h.clearFocus();
            this.h.setTextKeepState((CharSequence)spanned);
        }
        catch (NullPointerException nullPointerException) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("chatLog.setText error", (Throwable)nullPointerException);
            l2.a("chatLog.setText error", 1);
        }
    }

    public static void a(String string2, String string3) {
        if (c != null) {
            n n2 = c;
            n$2 n$2 = new n$2(n2, string3);
            n.c.e.a(n$2);
        }
    }

    public static void o() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.networkEngine != null) {
            l2.networkEngine.O();
            l2.networkEngine.d.c();
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2) {
            return;
        }
        if (l2.networkEngine != null && l2.networkEngine.aW) {
            return;
        }
        if (c != null) {
            n.c.e.a(n.c.l);
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.b("MultiplayerBattleroomActivity:updateUI() lastLoaded==null");
        }
    }

    public static void p() {
        if (c != null) {
            n.c.e.a(n.c.m);
            f = false;
        } else {
            com.corrodinggames.rts.gameFramework.GameEngine.b("MultiplayerBattleroomActivity:startGame() lastLoaded==null");
            com.corrodinggames.rts.gameFramework.GameEngine.T();
            f = true;
        }
    }

    public static void q() {
        o o2 = new o("Starting unit count");
        o o3 = new o("Total unit HP");
        o o4 = new o("Team Credits");
        ArrayList<com.corrodinggames.rts.game.PlayerTeam> tmp =com.corrodinggames.rts.game.PlayerTeam.c(); 
        for (com.corrodinggames.rts.game.PlayerTeam n2 : tmp) {
            int n3 = 0;
            int n4 = 0;
            BaseUnit[] amArray = BaseUnit.bE.a();
            int n5 = BaseUnit.bE.size();
            for (int i2 = 0; i2 < n5; ++i2) {
                BaseUnit am2 = amArray[i2];
                if (am2.bX != n2) continue;
                ++n3;
                n4 = (int)((float)n4 + am2.cu);
            }
            if (n3 == 0) continue;
            o2.a(n2, n3);
            o3.a(n2, n4);
            o4.a(n2, (int)n2.o);
        }
        if (!o2.a()) {
            o3.a();
        }
        o4.a();
    }

    public static void r()throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        l2.dm = null;
        if (l2.networkEngine.ay.a == GameModeType.savedGame) {
            if (!l2.networkEngine.C) {
                l2.ca.a(l2.networkEngine.aA, true, false, false);
                l2.bS.h.a(null, "Note: Game was started from a saved game.");
            } else {
                l2.ca.c(l2.networkEngine.ay.b, true);
            }
            n.q();
        } else if (l2.networkEngine.ay.a == GameModeType.customMap) {
            if (!l2.networkEngine.C) {
                l2.menuBackgroundMapFile = "";
                l2.dm = l2.networkEngine.aB;
                l2.startGame(true, GameMode.normal);
                l2.bS.h.a(null, "Note: Game was started from a custom map on server.");
            } else {
                l2.menuBackgroundMapFile = l2.networkEngine.az;
                l2.startGame(true, GameMode.normal);
            }
            n.q();
        } else {
            l2.menuBackgroundMapFile = l2.networkEngine.az;
            l2.startGame(true, GameMode.normal);
        }
    }

    public static void a(PasswordHandler ae2) {
        GameEngine l2 = GameEngine.getInstance();
        Context context = l2.aD();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String string2 = "Password Required";
        String string3 = "This server requires a password to join";
        if (ae2.b != null) {
            string2 = "Server Question";
            string3 = ae2.b;
            string3 = a.c(string3);
        }
        if (ae2.e != null) {
            string2 = ae2.e;
        }
        builder.setTitle((CharSequence)string2);
        builder.setMessage((CharSequence)string3);
        EditText editText = new EditText(builder.getContext());
        builder.setView((View)editText);
        if (ae2.b != null) {
            editText.setHint((CharSequence)"Enter text...");
        } else {
            editText.setHint((CharSequence)"Enter password...");
        }
        builder.setPositiveButton((CharSequence)(ae2.f != null ? ae2.f : "Submit"), (DialogInterface.OnClickListener)new n$3(editText, ae2));
        builder.setNegativeButton((CharSequence)(ae2.g != null ? ae2.g : "Disconnect"), (DialogInterface.OnClickListener)new n$4(ae2));
        builder.setOnCancelListener((DialogInterface.OnCancelListener)new n$5(ae2));
        AlertDialog alertDialog = j;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
        }
        AlertDialog alertDialog2 = builder.show();
        i = ae2;
        j = alertDialog2;
        editText.requestFocus();
    }

    static {
        f = false;
    }
}

