/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import test.rudp.c;
import com.corrodinggames.rts.gameFramework.j.ConnectionAcceptor;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

class ao$1
extends c {
    final /* synthetic */ ConnectionAcceptor a;

    ao$1(ConnectionAcceptor ao2) {
        this.a = ao2;
    }

    @Override
    public boolean a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return this.a.a(((InetSocketAddress)socketAddress).getAddress(), false);
        }
        GameEngine.log("AcceptFilter: Unhandled SocketAddress type:" + socketAddress.getClass().getName());
        return true;
    }
}

