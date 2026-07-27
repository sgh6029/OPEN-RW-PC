/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.ProgressDialog
 *  android.content.ActivityNotFoundException
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.TextView
 *  android.widget.Toast
 */
package com.corrodinggames.rts.appFramework;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;



import com.corrodinggames.rts.gameFramework.h.a;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class g
extends b {
    f c;
    final Handler d = new Handler(Looper.b());
    ProgressDialog e;
    boolean f = true;

    @Override
    public void b() {
        GameEngine.log("IngameActivity: finish");
        super.b();
        com.corrodinggames.rts.appFramework.c.a((Activity)this, true);
    }

    @Override
    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        if (bl2) {
            com.corrodinggames.rts.appFramework.c.a((Activity)this, false, true);
        }
        this.c.a(bl2);
    }

    @Override
    public boolean a(Menu menu) {
        super.a(menu);
        menu.clear();
        GameEngine l2 = GameEngine.getInstance();
        menu.add(0, 12, 0, (CharSequence)a.a("menus.ingame.save", new Object[0])).setIcon(17301582);
        if (l2.bv && !GameEngine.isDebugVersionStatic2) {
            menu.add(0, 18, 0, (CharSequence)a.a("menus.ingame.exportMap", new Object[0])).setIcon(17301582);
        }
        menu.add(0, 2, 0, (CharSequence)a.a("menus.ingame.settings", new Object[0])).setIcon(17301577);
        if (!l2.N()) {
            // empty if block
        }
        if (l2.cb != null && l2.cb.j()) {
            menu.add(0, 22, 0, (CharSequence)a.a("menus.ingame.hideInterface", new Object[0])).setIcon(17301584);
        }
        if (l2.N()) {
            menu.add(0, 13, 0, (CharSequence)a.a("menus.ingame.chat", new Object[0])).setIcon(17301584);
            menu.add(0, 14, 0, (CharSequence)a.a("menus.ingame.players", new Object[0])).setIcon(17301661);
            if (l2.networkEngine.C && com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a().e()) {
                menu.add(0, 17, 0, (CharSequence)a.a("menus.ingame.steam_reinvite", new Object[0])).setIcon(17301584);
            }
            boolean bl2 = false;
            if (l2.bs != null && l2.bs.G) {
                bl2 = true;
            }
            if (!bl2 && !l2.dq) {
                menu.add(0, 19, 0, (CharSequence)a.a("menus.ingame.surrender", new Object[0])).setIcon(17301552);
            }
            if (!l2.networkEngine.C) {
                menu.add(0, 10, 0, (CharSequence)a.a("menus.ingame.disconnect", new Object[0])).setIcon(17301552);
            } else {
                menu.add(0, 10, 0, (CharSequence)a.a("menus.ingame.exitGame", new Object[0])).setIcon(17301552);
            }
        } else {
            if (l2.ce != null && l2.ce.h != null) {
                menu.add(0, 11, 0, (CharSequence)a.a("menus.ingame.briefing", new Object[0])).setIcon(17301659);
            }
            menu.add(0, 15, 0, (CharSequence)a.a("menus.ingame.exitGame", new Object[0])).setIcon(17301552);
        }
        if (l2 != null && l2.bQ.allowGameRecording) {
            if (!l2.bo) {
                menu.add(0, 9, 0, (CharSequence)"Start Recording");
            } else {
                menu.add(0, 9, 0, (CharSequence)"Stop Recording");
            }
        }
        return true;
    }

    public void c(int n2) {
        GameEngine.log("outer selectMenuOption: " + n2);
        g$1 g$1 = new g$1(this, n2);
        this.d.a(g$1);
    }

    public void d(int n2) {
        switch (n2) {
            case 4: {
                GameEngine.getInstance().ch = !GameEngine.getInstance().ch;
                break;
            }
            case 2: {
                Intent intent = new Intent(this.k(), s.class);
                this.a(intent, 0);
                break;
            }
            case 3: {
                new AlertDialog.Builder((Context)this).setIcon(17301543).setTitle((CharSequence)"Skip?").setMessage((CharSequence)"Are you sure you want to skip this level?").setPositiveButton((CharSequence)"Yes", (DialogInterface.OnClickListener)new g$9(this)).setNegativeButton((CharSequence)"No", null).show();
                break;
            }
            case 6: {
                GameEngine l2 = GameEngine.getInstance();
                l2.bl = !l2.bl;
                break;
            }
            case 5: {
                new AlertDialog.Builder((Context)this).setIcon(17301543).setTitle((CharSequence)"Restart?").setMessage((CharSequence)"Are you sure you want to restart this level?").setPositiveButton((CharSequence)"Yes", (DialogInterface.OnClickListener)new g$10(this)).setNegativeButton((CharSequence)"No", null).show();
                break;
            }
            case 12: {
                g g2 = this;
                g$11 g$11 = new g$11(this, g2);
                if (com.corrodinggames.rts.appFramework.c.a((Activity)this, g$11)) break;
                g$11.run();
                break;
            }
            case 18: {
                if (!com.corrodinggames.rts.appFramework.c.b(this)) break;
                this.e(null);
                break;
            }
            case 9: {
                GameEngine l3 = GameEngine.getInstance();
                if (!l3.bo) {
                    l3.bo = true;
                    break;
                }
                l3.bo = false;
                break;
            }
            case 19: {
                new AlertDialog.Builder((Context)this).setIcon(17301543).setTitle((CharSequence)"Disconnect?").setMessage((CharSequence)"Are you sure you want to surrender this game?").setPositiveButton((CharSequence)"Surrender", (DialogInterface.OnClickListener)new g$12(this)).setNegativeButton((CharSequence)"No", null).show();
                break;
            }
            case 10: {
                GameEngine l4 = GameEngine.getInstance();
                String string2 = a.a("menus.ingame.multiplayerClose.titleDisconnect", new Object[0]);
                String string3 = a.a("menus.ingame.multiplayerClose.messageDisconnect", new Object[0]);
                String string4 = a.a("menus.ingame.multiplayerClose.disconnectButton", new Object[0]);
                if (l4.networkEngine.C) {
                    string2 = a.a("menus.ingame.multiplayerClose.title", new Object[0]);
                    string3 = a.a("menus.ingame.multiplayerClose.messageEndGame", new Object[0]);
                    string4 = a.a("menus.ingame.exitGame", new Object[0]);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)this).setIcon(17301543).setTitle((CharSequence)string2).setMessage((CharSequence)string3).setPositiveButton((CharSequence)string4, (DialogInterface.OnClickListener)new g$13(this)).setNegativeButton((CharSequence)a.a("menus.common.back", new Object[0]), null);
                if (l4.networkEngine.C) {
                    builder.setNeutralButton((CharSequence)a.a("menus.ingame.multiplayerClose.returnToBattleroom", new Object[0]), (DialogInterface.OnClickListener)new g$14(this));
                }
                builder.show();
                break;
            }
            case 15: {
                new AlertDialog.Builder((Context)this).setIcon(17301543).setTitle((CharSequence)"Exit?").setMessage((CharSequence)"Are you sure you want to exit this game?").setPositiveButton((CharSequence)"Yes", (DialogInterface.OnClickListener)new g$15(this)).setNegativeButton((CharSequence)"No", null).show();
                break;
            }
            case 11: {
                GameEngine l5 = GameEngine.getInstance();
                if (l5.ce == null || l5.ce.h == null) break;
                l5.a("Briefing", l5.ce.h);
                break;
            }
            case 13: {
                this.a(false);
                break;
            }
            case 16: {
                this.a(true);
                break;
            }
            case 14: {
                GameEngine l6 = GameEngine.getInstance();
                if (l6.networkEngine == null) break;
                l6.networkEngine.H();
                break;
            }
            case 20: {
                this.b();
                break;
            }
            case 21: {
                this.b();
                n.o();
                n.m();
                break;
            }
            case 22: {
                GameEngine l7 = GameEngine.getInstance();
                l7.cU = true;
                l7.bS.u = false;
                break;
            }
            case 23: {
                GameEngine.log("TODO display leaderboard settings");
            }
        }
    }

    private void a(boolean bl2) {
        GameEngine l2 = GameEngine.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
        if (!bl2) {
            builder.setTitle((CharSequence)"Send Message");
        } else {
            builder.setTitle((CharSequence)"Send Team Message");
        }
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this);
        View view = layoutInflater.inflate(com.corrodinggames.rts.R.layout.alert_chat, null);
        builder.setView(view);
        TextView textView = (TextView)view.findViewById(com.corrodinggames.rts.R.id.chat_messages);
        EditText editText = (EditText)view.findViewById(com.corrodinggames.rts.R.id.chat_text);
        textView.setText((CharSequence)l2.networkEngine.aC.a());
        editText.setText((CharSequence)"");
        editText.requestFocus();
        builder.setPositiveButton((CharSequence)(bl2 ? "Send Team" : "Send"), (DialogInterface.OnClickListener)new g$16(this, editText, bl2));
        builder.setNeutralButton((CharSequence)"Send & Ping Map", (DialogInterface.OnClickListener)new g$2(this, editText, bl2));
        builder.setNegativeButton((CharSequence)"Cancel", (DialogInterface.OnClickListener)new g$3(this));
        builder.show();
    }

    private void e(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
        builder.setTitle((CharSequence)"Export Map");
        builder.setMessage((CharSequence)"Enter a name to export the map as");
        EditText editText = new EditText((Context)this);
        if (string2 == null) {
            String string3 = com.corrodinggames.rts.gameFramework.GameUtils.a("d MMM yyyy");
            string3 = string3.replace(".", "");
            String string4 = "New " + l2.al() + " (" + string3 + " " + com.corrodinggames.rts.gameFramework.GameUtils.a("HH.mm.ss") + ")";
            string4 = string4.replace("  ", " ");
            editText.setText((CharSequence)string4);
        } else {
            editText.setText((CharSequence)string2);
        }
        builder.setView((View)editText);
        builder.setPositiveButton((CharSequence)"Ok", (DialogInterface.OnClickListener)new g$4(this, editText, l2));
        builder.setNegativeButton((CharSequence)"Cancel", (DialogInterface.OnClickListener)new g$5(this));
        builder.show();
    }

    private void f(String string2) {
        GameEngine l2 = GameEngine.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
        builder.setTitle((CharSequence)"Save Game");
        builder.setMessage((CharSequence)"Enter a name to save the game under");
        EditText editText = new EditText((Context)this);
        if (string2 == null) {
            String string3 = com.corrodinggames.rts.gameFramework.GameUtils.a("d MMM yyyy");
            string3 = string3.replace(".", "");
            editText.setText((CharSequence)(l2.al() + " (" + string3 + " " + com.corrodinggames.rts.gameFramework.GameUtils.a("HH.mm.ss") + ")"));
        } else {
            editText.setText((CharSequence)string2);
        }
        builder.setView((View)editText);
        builder.setPositiveButton((CharSequence)"Ok", (DialogInterface.OnClickListener)new g$6(this, editText));
        builder.setNegativeButton((CharSequence)"Cancel", (DialogInterface.OnClickListener)new g$7(this));
        builder.show();
    }

    public void d(String string2) {
        this.a(0);
        h h2 = new h(this);
        h2.a = string2;
        new Thread(h2).start();
    }

    public void l() {
        g$8 g$8 = new g$8(this);
        this.d.a(g$8);
    }

    private void n() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)"market://details?id=com.corrodinggames.rts"));
            this.a(intent);
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            String string2 = "Failed to open Android Market";
            int n2 = 0;
            Toast toast = Toast.makeText((Context)this.g(), (CharSequence)string2, (int)n2);
            toast.show();
        }
    }

    public void m() {
    }

    static /* synthetic */ void a(g g2, String string2) {
        g2.f(string2);
    }

    static /* synthetic */ void b(g g2, String string2) {
        g2.e(string2);
    }

    static /* synthetic */ void a(g g2) {
        g2.n();
    }
}
