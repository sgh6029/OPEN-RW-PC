/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.gameFramework.j.ConnectionAcceptor;
import java.net.InetAddress;

public class ConnectionAttemptTracker {
    public InetAddress a;
    public int b = 1;
    public boolean c;
    public boolean d;
    final /* synthetic */ ConnectionAcceptor e;

    public ConnectionAttemptTracker(ConnectionAcceptor ao2) {
        this.e = ao2;
    }
}

