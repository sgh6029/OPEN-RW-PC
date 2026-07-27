/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.PacketData;
import com.corrodinggames.rts.gameFramework.j.m;

import android.graphics.PointF;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GGameObject;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

public class GameInputStream {
    ByteArrayInputStream a;
    private DataInputStream e;
    private DataInputStream f;
    private LinkedList g = new LinkedList();
    int b = 999999;
    int c = 999999;
    int d = 0;

    void a() {
        this.f = this.e;
    }

    public GameInputStream(PacketData au2) {
        this.a = new ByteArrayInputStream(au2.c);
        this.e = new DataInputStream(this.a);
        this.a();
    }

    public GameInputStream(DataInputStream dataInputStream) {
        this.e = dataInputStream;
        this.a();
    }

    public GameInputStream(String string2) {
        this.a = new ByteArrayInputStream(string2.getBytes());
        this.e = new DataInputStream(this.a);
        this.a();
    }

    public GameInputStream(byte[] byArray) {
        this.a = new ByteArrayInputStream(byArray);
        this.e = new DataInputStream(this.a);
        this.a();
    }

    public void a(int n2) {
        this.b = n2;
    }

    public int b() {
        return this.b;
    }

    public void b(int n2) {
        this.c = n2;
    }

    public int c() {
        return this.c;
    }

    public byte d() throws IOException {
        return this.f.readByte();
    }

    public boolean e() throws IOException {
        return this.f.readBoolean();
    }

    public int readInt() throws IOException {
        return this.f.readInt();
    }

    public float g() throws IOException {
        return this.f.readFloat();
    }

    public double h()  throws IOException {
        return this.f.readDouble();
    }

    public long i() throws IOException {
        return this.f.readLong();
    }

    public String j() throws IOException {
        if (!this.e()) {
            return null;
        }
        return this.l();
    }

    public Integer k()  throws IOException {
        if (!this.e()) {
            return null;
        }
        return this.readInt();
    }

    public String l() throws IOException {
        String string2 = this.f.readUTF();
        return string2;
    }

    public g m() throws IOException {
        String string2 = this.f.readUTF();
        if (string2.equals("")) {
            return null;
        }
        return com.corrodinggames.rts.game.units.custom.g.c(string2);
    }

    public long n() throws IOException {
        long l2 = this.f.readLong();
        return l2;
    }

    public GGameObject a(Class clazz) throws IOException {
        long l2 = this.f.readLong();
        return GGameObject.a(l2, clazz, false);
    }

    public void a(com.corrodinggames.rts.gameFramework.utility.m m2, Class clazz)  throws IOException {
        int n2 = this.readInt();
        for (int i2 = 0; i2 < n2; ++i2) {
            GGameObject w2 = this.a(clazz);
            if (w2 == null) continue;
            m2.add(w2);
        }
    }

    public BaseUnit o()  throws IOException {
        return this.a(m.b);
    }

    public BaseUnit a(m m2) throws IOException {
        long l2 = this.f.readLong();
        boolean bl2 = m2 == m.a;
        return GGameObject.a(l2, bl2);
    }

    public y p() throws IOException {
        long l2 = this.f.readLong();
        return GGameObject.b(l2, false);
    }


   public Enum b(Class var1) throws IOException {
      int var2 = this.f.readInt();
      if (var2 == -1) {
         return null;
      } else {
         Object[] var3 = var1.getEnumConstants();
         if (var2 >= 0 && var2 < var3.length) {
            return (Enum)var3[var2];
         } else {
            NetworkEngine.g("readEnum:" + var2 + " is out of range for " + var1.toString());
            return null;
         }
      }
   }

   public UnitType q() throws IOException {
      int var1 = this.f.readInt();
      if (var1 == -1) {
         return null;
      } else if (var1 == -2) {
         String var5 = this.l();
         com.corrodinggames.rts.game.units.custom.l var3 = com.corrodinggames.rts.game.units.custom.l.n(var5);
         if (var3 == null) {
            NetworkEngine.g("readUnitType: Could not find customUnitMetadata:" + var5);
         }

         UnitType var4 = com.corrodinggames.rts.game.units.custom.l.c(var3);
         if (var4 != null) {
            if (var4 instanceof GameEngine) {
               var3 = (com.corrodinggames.rts.game.units.custom.l)var4;
            } else {
               com.corrodinggames.rts.gameFramework.GameEngine.b("replacement not a custom unit:" + var4.i());
            }
         }

         return var3;
      } else {
         Object[] var2 = UnitTypeEnum.class.getEnumConstants();
         if (var1 >= 0 && var1 < var2.length) {
            return (UnitTypeEnum)var2[var1];
         } else {
            NetworkEngine.g("readUnitType:" + var1 + " is out of range for UnitType");
            return null;
         }
      }
   }

    public PlayerTeam r()  throws IOException {
        byte by = this.f.readByte();
        PlayerTeam n2 = PlayerTeam.k(by);
        if (n2 == null) {
            throw new IOException("Error loading save data, could not find referenced team:" + by + "");
        }
        return n2;
    }

    public PlayerTeam s()  throws IOException {
        byte by = this.f.readByte();
        return PlayerTeam.k(by);
    }

    public byte[] t() throws IOException {
        int n2;
        int n3 = this.readInt();
        byte[] byArray = new byte[n3];
        for (int i2 = 0; i2 < n3 && (n2 = this.f.read(byArray, i2, n3 - i2)) != -1; i2 += n2) {
        }
        return byArray;
    }

    public GameInputStream u() throws IOException {
        byte[] byArray = this.t();
        return new GameInputStream(byArray);
    }

    public short v() throws IOException {
        return this.f.readShort();
    }

    public void a(String string2) throws IOException {
        short s2 = this.v();
        if (s2 != 12345) {
            NetworkEngine.g("Mark wasn't read for:" + string2);
            if (GameEngine.getInstance().aa()) {
                throw new RuntimeException("Mark wasn't read for:" + string2);
            }
        }
    }

    public InputStream w() {
        return this.f;
    }

    public void b(String string2) throws IOException {
        this.a(string2, false);
    }

    public String x() throws IOException {
        return this.a(false, false);
    }

    public void a(String string2, boolean bl2) throws IOException {
        this.a(string2, bl2, false);
    }

    public void a(String string2, boolean bl2, boolean bl3) throws IOException {
        if (this.b < 11) {
            GameEngine.log("Skipping start block:" + string2);
            return;
        }
        String string3 = this.a(bl2, bl3);
        if (!string3.equals(string2)) {
            GameEngine.b("InputNetStream:endBlock", "Name does not match: expected:" + string2 + " , got:" + string3);
        }
    }

    public byte[] c(String string2) throws IOException {
        String string3 = this.f.readUTF();
        if (!string3.equals(string2)) {
            GameEngine.b("getBlockRaw", "Name does not match: expected:" + string2 + " , got:" + string3);
        }
        byte[] byArray = this.t();
        return byArray;
    }

    public String a(boolean bl2, boolean bl3) throws IOException {
        if (this.b < 11) {
            GameEngine.log("Skipping start block: startBlockAndGetName()");
            return "<skipped>";
        }
        String string2 = this.f.readUTF();
        byte[] byArray = this.t();
        com.corrodinggames.rts.gameFramework.j.l l2 = new com.corrodinggames.rts.gameFramework.j.l(byArray, bl2, bl3);
        l2.a = string2;
        this.g.add(l2);
        this.f = ((com.corrodinggames.rts.gameFramework.j.l)this.g.getLast()).c;
        return string2;
    }

    public void d(String string2) {
        if (this.b < 11) {
            GameEngine.log("Skipping end block:" + string2);
            return;
        }
        com.corrodinggames.rts.gameFramework.j.l l2 = (com.corrodinggames.rts.gameFramework.j.l)this.g.removeLast();
        if (!l2.a.equals(string2)) {
            GameEngine.b("InputNetStream:endBlock", "Name does not match: expected" + string2 + " ," + l2.a);
        }
        this.f = this.g.isEmpty() ? this.e : ((com.corrodinggames.rts.gameFramework.j.l)this.g.getLast()).c;
    }

    public PointF y() throws IOException {
        if (!this.e()) {
            return null;
        }
        PointF pointF = new PointF();
        pointF.x = this.g();
        pointF.b = this.g();
        return pointF;
    }
}

