/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.widget.EditText
 */
package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import android.widget.EditText;
import com.corrodinggames.rts.appFramework.n;
import com.corrodinggames.rts.gameFramework.j.PasswordHandler;

final class n$3
implements DialogInterface.OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ PasswordHandler b;

    n$3(EditText editText, PasswordHandler ae2) {
        this.a = editText;
        this.b = ae2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        String string2 = this.a.getText().toString();
        this.b.a(string2);
        n.i = null;
        n.j = null;
    }
}

