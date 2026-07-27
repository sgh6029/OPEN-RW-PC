/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.widget.EditText
 */
package com.corrodinggames.rts.appFramework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.content.Context;

import com.corrodinggames.rts.appFramework.g;
import com.corrodinggames.rts.appFramework.g$6$1;

class g$6
implements DialogInterface.OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ g b;

    g$6(g g2, EditText editText) {
        this.b = g2;
        this.a = editText;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        String string2 = this.a.getText().toString();
        if (string2.contains("/") || string2.contains("\\") || string2.contains(":") || string2.contains("*") || string2.contains("?") || string2.contains("\"") || string2.contains("<") || string2.contains(">")) {
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.b);
            builder.setTitle((CharSequence)"Bad Save Name");
            builder.setMessage((CharSequence)"The characters /\\:*?\"<> are not allowed (fat32 formatting)");
            builder.setPositiveButton((CharSequence)"Ok", (DialogInterface.OnClickListener)new g$6$1(this, string2));
            builder.show();
        } else {
            this.b.d(string2);
        }
    }
}

