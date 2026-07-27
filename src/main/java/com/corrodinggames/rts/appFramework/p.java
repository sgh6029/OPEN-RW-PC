/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.appFramework;

import com.corrodinggames.rts.appFramework.b;
import com.corrodinggames.rts.appFramework.p$1;
import com.corrodinggames.rts.gameFramework.j.g;
import com.corrodinggames.rts.gameFramework.j.n;

import android.os.Handler;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;

public class p
extends b {
    static p c;
    final Handler d = new Handler();//WARN: 原先没有被初始化 !!!!! 请注意
    private Runnable e;

    public static void l() {
        if (c != null) {
            p.c.d.a(p.c.e);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ArrayList m() {
        Object object = n.f;
        synchronized (object) {
            GameEngine l2 = GameEngine.getInstance();
            ArrayList<g> arrayList = new ArrayList<g>();
            ConcurrentLinkedQueue<g> tmp = l2.networkEngine.bi;
            for (g g2 : tmp) {
                arrayList.add(g2);
            }
            Collections.sort(arrayList, new p$1());
            return arrayList;
        }
    }
}

