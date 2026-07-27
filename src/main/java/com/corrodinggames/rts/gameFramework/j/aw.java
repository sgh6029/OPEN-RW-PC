/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.storage.a;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.PacketData;
import com.corrodinggames.rts.gameFramework.j.BlockOutputStream;
import com.corrodinggames.rts.gameFramework.j.NetworkConnection;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;

import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.ListIterator;

public class aw
extends GameOutputStream {
    ByteArrayOutputStream a;
    PrintStream e;
    private PrintStream f;
    private LinkedList g = new LinkedList();

    @Override
    public void a() throws IOException {
        ListIterator listIterator = this.g.listIterator(this.g.size());
        while (listIterator.hasPrevious()) {
            BlockOutputStream ax2 = (BlockOutputStream)listIterator.previous();
            ax2.a();
        }
        this.e.flush();
        if (this.a != null) {
            this.a.flush();
        }
    }

    @Override
    void b() {
        this.f = this.e;
    }

    public aw() {
        this.a = new ByteArrayOutputStream();
        this.e = new PrintStream(this.a);
        this.b();
    }

    public aw(PrintStream printStream) {
        this.e = printStream;
        this.b();
    }

    @Override
    public PacketData b(int n2) {
        return this.a(n2, -1);
    }

    @Override
    public PacketData a(int n2, int n3) {
        try {
            this.a();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        PacketData au2 = new PacketData(n2);
        au2.c = this.a.toByteArray();
        au2.d = n3;
        return au2;
    }

    @Override
    public String c() {
        try {
            this.a();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this.a.toString();
    }

    @Override
    public byte[] d() {
        try {
            this.a();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this.a.toByteArray();
    }

    @Override
    public void c(int n2) {
        this.f.println(n2);
    }

    @Override
    public void a(boolean bl2) {
        this.f.println(bl2);
    }

    @Override
    public void a(int n2) {
        this.f.println("#int:");
        this.f.println(n2);
    }

    @Override
    public void a(float f2) {
        this.f.println("#writeFloat");
        this.f.println(f2);
    }

    @Override
    public void a(long l2) {
        this.f.println("#writeLong");
        this.f.println(l2);
    }

    @Override
    public void b(String string2) {
        this.a(string2 != null);
        if (string2 != null) {
            this.writeUTF(string2);
        }
    }

    @Override
    public void writeUTF(String string2) {
        this.f.println(string2);
    }

    @Override
    public void a(GGameObject w2) {
        this.f.println("#writeGameObject:");
        if (w2 == null) {
            this.f.println(-1);
        } else {
            this.f.println(w2.objectId);
        }
    }

    @Override
    public void b(GGameObject w2) {
        this.f.println("#writeExistingGameObject:");
        if (w2 != null && !w2.ej) {
            this.f.println(w2.objectId);
            return;
        }
        this.f.println(-1);
    }

    @Override
    public void b(BaseUnit am2) {
        if (am2 != null && !am2.ej && !am2.bV) {
            this.a((GGameObject)am2);
            return;
        }
        this.a((GGameObject)null);
    }

    @Override
    public void a(BaseUnit am2) {
        if (am2 != null && !am2.ej) {
            this.a((GGameObject)am2);
            return;
        }
        this.a((GGameObject)null);
    }

    @Override
    public void a(y y2) {
        if (y2 != null && !y2.ej) {
            this.a((GGameObject)y2);
            return;
        }
        this.a((GGameObject)null);
    }

    @Override
    public void a(PointF pointF) {
        this.f.println("#PointF:");
        this.a(pointF != null);
        if (pointF != null) {
            this.a(pointF.x);
            this.a(pointF.b);
        }
    }

    @Override
    public void a(Enum enum_) {
        if (enum_ == null) {
            this.f.println("#Enum: null");
            this.f.println(-1);
        } else {
            this.f.println("#Enum:" + enum_.getClass().getSimpleName() + " : " + enum_.toString());
            this.f.println(enum_.ordinal());
        }
    }

    @Override
    public void a(com.corrodinggames.rts.game.units.UnitType as2) {
        this.f.println("#unitType:");
        if (as2 == null) {
            this.f.println(-1);
        } else if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
            this.f.println(-2);
            this.writeUTF(((com.corrodinggames.rts.game.units.custom.l)as2).M);
        } else {
            this.f.println(((UnitTypeEnum)as2).ordinal());
        }
    }

    @Override
    public void a(NetworkConnection c2) {
        if (c2 == null) {
            this.f.println(0);
        } else {
            this.f.println(c2.c);
        }
    }

    @Override
    public void a(PlayerTeam n2) {
        this.f.println("#team:");
        this.f.println(n2.k);
    }

    @Override
    public void a(File file) throws IOException {
        try (AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.a(file);){
            this.a(j2, (int)file.length());
        }
    }

    @Override
    public void a(InputStream inputStream, int n2) throws IOException {
        int n3;
        int n4 = 0;
        this.a(n2);
        byte[] byArray = new byte[16384];
        while ((n3 = inputStream.read(byArray, 0, byArray.length)) != -1) {
            if (n4 + n3 > n2) {
                int n5 = n2 - n4;
                if (n5 < 0) {
                    NetworkEngine.g("writeStream: bytesTillFull is " + n5);
                    return;
                }
                this.f.write(byArray, 0, n5);
                return;
            }
            this.f.write(byArray, 0, n3);
            n4 += n3;
        }
    }

    @Override
    public void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        this.a(byteArrayOutputStream.size());
        byteArrayOutputStream.writeTo(this.f);
    }

    @Override
    public void a(byte[] byArray) throws IOException {
        this.a(byArray.length);
        this.f.write(byArray);
    }

    @Override
    public void a(short s2) {
        this.f.println("#writeShort");
        this.f.println(s2);
    }

    @Override
    public void e() {
        this.f.println("#writeMark:");
        this.a((short)12345);
    }

    @Override
    public void d(String string2) {
        this.f.println("#writeIfDebugOnly: " + string2);
    }

    @Override
    public boolean f() {
        return true;
    }

    @Override
    public void e(String string2) {
        this.a(string2, false);
    }

    @Override
    public void a(String string2, boolean bl2) {
        BlockOutputStream ax2 = new BlockOutputStream(bl2);
        ax2.b = string2;
        this.g.add(ax2);
        this.f = ((BlockOutputStream)this.g.getLast()).d;
    }

    @Override
    public void a(String string2) throws IOException {
        BlockOutputStream ax2 = (BlockOutputStream)this.g.removeLast();
        if (!ax2.b.equals(string2)) {
            GameEngine.b("OutputNetStream:endBlock", "Name does not match: expected" + string2 + " , got:" + ax2.b);
        }
        ax2.a();
        this.f = this.g.isEmpty() ? this.e : ((BlockOutputStream)this.g.getLast()).d;
        String string3 = "";
        String string4 = "";
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            string3 = string3 + ">";
            string4 = string4 + "<";
        }
        this.f.println(string3 + ">>>> Start of block: " + ax2.b);
        this.a(ax2.c);
        this.f.println(string4 + "<<<< End of block: " + ax2.b);
        ax2.b();
    }
}

