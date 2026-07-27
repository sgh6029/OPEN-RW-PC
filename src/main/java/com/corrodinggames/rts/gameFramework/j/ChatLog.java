/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Html
 *  android.text.Spanned
 */
package com.corrodinggames.rts.gameFramework.j;

import android.text.Html;
import android.text.Spanned;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.b;
import com.corrodinggames.rts.gameFramework.j.NetworkConnection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ChatLog {
    private ConcurrentLinkedQueue<b> a = new ConcurrentLinkedQueue<b>();

    public String a(String string2) {
        return GameUtils.i(string2);
    }

    public void a(int n2, String string2, String string3, NetworkConnection c2) {
        string3 = string3.trim();
        b b2 = new b(this, n2, string2, string3, c2);
        this.a.add(b2);
        if (this.a.size() > 45) {
            this.a.poll();
        }
    }

    public int a(NetworkConnection c2, int n2) {
        if (c2 == null) {
            return 0;
        }
        int n3 = c2.c;
        int n4 = 0;
        for (b b2 : this.a) {
            if (b2.d != n3 || GameUtils.a(b2.e, System.nanoTime()) >= (long)n2 || b2.c.startsWith("-i ") || b2.c.startsWith("-qc ")) continue;
            ++n4;
            if (b2.c == null) continue;
            if (GameUtils.a(b2.c, '\n') >= 3) {
                n4 += 2;
            }
            if (GameUtils.a(b2.c, '\n') >= 6) {
                n4 += 2;
            }
            if (GameUtils.a(b2.c, '\n') < 9) continue;
            n4 += 2;
        }
        return n4;
    }

    public String a() {
        String string2 = "";
        for (b b2 : this.a) {
            string2 = string2 + b2.a() + "\n";
        }
        return string2;
    }

    public ConcurrentLinkedQueue b() {
        return this.a;
    }

    public String a(boolean bl2) {
        String string2 = "";
        if (!bl2) {
            for (b b2 : this.a) {
                string2 = string2 + b2.b() + "<br/>\n";
            }
        } else {
            for (b b3 : this.a) {
                string2 = b3.b() + "<br/>\n" + string2;
            }
        }
        return "<pre>" + string2 + "</pre>";
    }

    public Spanned b(boolean bl2) {
        return Html.fromHtml((String)this.a(bl2));
    }

    public void c() {
        this.a.clear();
    }
}

