/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.zip.DataFormatException;

public class GameOutputStream {
    ByteArrayOutputStream b;
    DataOutputStream c;
    private DataOutputStream a;
    private LinkedList e = new LinkedList();
    public int d = 999999;

    public void a() throws IOException  {
        ListIterator listIterator = this.e.listIterator(this.e.size());
        while (listIterator.hasPrevious()) {
            at at2 = (at)listIterator.previous();
            at2.a();
        }
        this.c.flush();
        if (this.b != null) {
            this.b.flush();
        }
    }

    void b() {
        this.a = this.c;
    }

    public GameOutputStream(int n2) {
        this();
        this.d = n2;
    }

    public GameOutputStream() {
        this.b = new ByteArrayOutputStream();
        this.c = new DataOutputStream(this.b);
        this.b();
    }

    public GameOutputStream(DataOutputStream dataOutputStream) {
        this.c = dataOutputStream;
        this.b();
    }

    public PacketData b(int n2) {
        return this.a(n2, -1);
    }

    public PacketData a(int n2, int n3) {
        try {
            this.a();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        PacketData au2 = new PacketData(n2);
        au2.c = this.b.toByteArray();
        au2.d = n3;
        return au2;
    }

    public String c() {
        try {
            this.a();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this.b.toString();
    }

    public byte[] d() {
        try {
            this.a();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this.b.toByteArray();
    }

    public void c(int n2) throws IOException {
        this.a.writeByte(n2);
    }

    public void a(boolean bl2) throws IOException  {
        this.a.writeBoolean(bl2);
    }

    public void a(int n2) throws IOException  {
        this.a.writeInt(n2);
    }

    public void a(float f2) throws IOException  {
        this.a.writeFloat(f2);
    }

    public void a(double d2) throws IOException  {
        this.a.writeDouble(d2);
    }

    public void a(long l2) throws IOException  {
        this.a.writeLong(l2);
    }

    public void b(String string2) throws IOException  {
        this.a(string2 != null);
        if (string2 != null) {
            this.writeUTF(string2);
        }
    }

    public void a(Integer n2) throws IOException  {
        this.a(n2 != null);
        if (n2 != null) {
            this.a((int)n2);
        }
    }

    public void writeUTF(String string2)  throws IOException {
        this.a.writeUTF(string2);
    }

    public void a(g g2)  throws IOException {
        if (g2 == null) {
            this.a.writeUTF("");
        }
        this.a.writeUTF(g2.toString());
    }

    public void a(GGameObject w2) throws IOException  {
        if (w2 == null) {
            this.a.writeLong(-1L);
        } else {
            this.a.writeLong(w2.objectId);
        }
    }

    public void b(GGameObject w2)  throws IOException {
        if (w2 != null && !w2.ej) {
            this.a.writeLong(w2.objectId);
            return;
        }
        this.a.writeLong(-1L);
    }

    public void a(m m2) throws IOException  {
        if (m2 == null) {
            this.a(0);
            return;
        }
        this.a(m2.size());
        for (Object e2 : m2) {
            GGameObject w2 = (GGameObject)e2;
            this.b(w2);
        }
    }

    public void b(BaseUnit am2) throws IOException  {
        if (am2 != null && !am2.ej && !am2.bV) {
            this.a((GGameObject)am2);
            return;
        }
        this.a((GGameObject)null);
    }

    public void a(BaseUnit am2)  throws IOException {
        if (am2 != null && !am2.ej) {
            this.a((GGameObject)am2);
            return;
        }
        this.a((GGameObject)null);
    }

    public void a(y y2)  throws IOException {
        if (y2 != null && !y2.ej) {
            this.a((GGameObject)y2);
            return;
        }
        this.a((GGameObject)null);
    }

    public void a(PointF pointF)  throws IOException {
        this.a(pointF != null);
        if (pointF != null) {
            this.a(pointF.x);
            this.a(pointF.b);
        }
    }

    public void a(Enum enum_) throws IOException  {
        if (enum_ == null) {
            this.a.writeInt(-1);
        } else {
            this.a.writeInt(enum_.ordinal());
        }
    }

    public void a(com.corrodinggames.rts.game.units.UnitType as2) throws IOException  {
        if (as2 == null) {
            this.a.writeInt(-1);
        } else if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
            this.a.writeInt(-2);
            this.writeUTF(((com.corrodinggames.rts.game.units.custom.l)as2).M);
        } else {
            this.a.writeInt(((UnitTypeEnum)as2).ordinal());
        }
    }

    public void a(NetworkConnection c2)  throws IOException {
        if (c2 == null) {
            this.a.writeInt(0);
        } else {
            this.a.writeInt(c2.c);
        }
    }

    public void a(PlayerTeam n2) throws IOException  {
        this.a.writeByte(n2.k);
    }

    public void a(File file)  throws IOException {
        AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.a(file);
        if (j2 == null) {
            throw new IOException("Failed to read save file data");
        }
        try {
            this.a(j2, (int)file.length());
        }
        finally {
            if (j2 != null) {
                ((InputStream)j2).close();
            }
        }
    }

    public void a(GameInputStream k2)  throws IOException {
        InputStream inputStream = k2.w();
        try {
            inputStream.reset();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.a(inputStream, inputStream.available());
    }

    public void a(InputStream inputStream, int n2)  throws IOException {
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
                this.a.write(byArray, 0, n5);
                return;
            }
            this.a.write(byArray, 0, n3);
            n4 += n3;
        }
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream)  throws IOException {
        this.a(byteArrayOutputStream.size());
        byteArrayOutputStream.writeTo(this.a);
    }

    public void a(byte[] byArray)  throws IOException {
        this.a(byArray.length);
        this.a.write(byArray);
    }

    public void b(byte[] byArray) throws IOException  {
        this.a.write(byArray);
    }

    public void a(short s2) throws IOException  {
        this.a.writeShort(s2);
    }

    public void e()  throws IOException {
        this.a((short)12345);
    }

    public void d(String string2) {
    }

    public boolean f() {
        return false;
    }

    public void e(String string2) throws IOException {
        this.a(string2, false);
    }

    public void a(String string2, boolean bl2) throws IOException {
        at at2 = new at(bl2);
        at2.c = string2;
        this.e.add(at2);
        this.a = ((at)this.e.getLast()).e;
    }

    public void a(String string2) throws IOException  {
        at at2 = (at)this.e.removeLast();
        if (!at2.c.equals(string2)) {
            GameEngine.b("OutputNetStream:endBlock", "Name does not match: expected" + string2 + " , got:" + at2.c);
        }
        at2.a();
        this.a = this.e.isEmpty() ? this.c : ((at)this.e.getLast()).e;
        this.a.writeUTF(at2.c);
        this.a(at2.d);
        try {
            at2.b();
        }
        catch (Exception exception) {
            if (exception instanceof DataFormatException) {
                if (!GameEngine.isDebugVersionStatic2) {
                    GameEngine.b("DataFormatException error calling streamBlock.close() (this is expected on android 4.4)");
                }
            }
            GameEngine.b("Error calling streamBlock.close() to clean up memory");
            exception.printStackTrace();
        }
    }

    public int g() {
        return this.d;
    }

    public void h() {
        this.c = null;
        this.a = null;
        try {
            if (this.b != null) {
                this.b.close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.b = null;
    }
}

