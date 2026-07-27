/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.i;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.custom.ag;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.f.g;
import com.corrodinggames.rts.gameFramework.i.b;
import com.corrodinggames.rts.gameFramework.i.c;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.FileLoaderFactory;
import com.corrodinggames.rts.gameFramework.utility.al;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

public class a {
    public static String a;
    public static String b;
    public b c = new b();
    Object d = new Object();
    ArrayList<b> e = new ArrayList<b>();//old no b
    ArrayList f = new ArrayList();

    public a() {
        try {
            com.corrodinggames.rts.gameFramework.i.a.a(GameEngine.getInstance().getBaseVersion());
        }
        catch (bo bo2) {
            throw new RuntimeException(bo2);
        }
    }

    private static int a(String string2, int n2) throws bo {
        String[] stringArray = com.corrodinggames.rts.gameFramework.GameUtils.c(string2, '.');
        if (stringArray == null) {
            throw new bo("Unexpected version format (Missing " + n2 + ")");
        }
        if (stringArray.length > 3) {
            throw new bo("Unexpected version format (" + string2 + ")");
        }
        if (stringArray.length <= n2) {
            return 0;
        }
        try {
            return Integer.valueOf(stringArray[n2]);
        }
        catch (NumberFormatException numberFormatException) {
            throw new bo("Unexpected version format (Bad " + n2 + ")", numberFormatException);
        }
    }

    public static void a(String string2) throws bo {
        String string3 = GameEngine.getInstance().getBaseVersion();
        com.corrodinggames.rts.gameFramework.i.a.a(string2, string3);
    }

    public static String b(String string2) {
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "v", "");
        string2 = string2.trim();
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "a", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "b", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "c", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "d", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "e", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "f", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "g", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "h1", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "h2", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "h3", "");
        string2 = com.corrodinggames.rts.gameFramework.GameUtils.a(string2, "h4", "");
        return string2;
    }

    public static void a(String string2, String string3) throws bo {
        string3 = com.corrodinggames.rts.gameFramework.i.a.b(string3);
        String string4 = string2 = com.corrodinggames.rts.gameFramework.i.a.b(string2);
        String string5 = string3;
        try {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            String[] stringArray;
            int n8 = 1000;
            int n9 = 1000;
            if (string3.contains("p")) {
                stringArray = al.b(string3, "p");
                try {
                    n8 = Integer.valueOf(stringArray[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new bo("Unexpected min version:" + string4 + " (Bad build number)", numberFormatException);
                }
                string3 = stringArray[0];
            }
            if (string2.contains("p")) {
                stringArray = al.b(string2, "p");
                try {
                    n9 = Integer.valueOf(stringArray[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new bo("Unexpected min version:" + string4 + "(Bad build number)", numberFormatException);
                }
                string2 = stringArray[0];
            }
            try {
                n7 = com.corrodinggames.rts.gameFramework.i.a.a(string3, 0);
                n6 = com.corrodinggames.rts.gameFramework.i.a.a(string2, 0);
                n5 = com.corrodinggames.rts.gameFramework.i.a.a(string3, 1);
                n4 = com.corrodinggames.rts.gameFramework.i.a.a(string2, 1);
                n3 = com.corrodinggames.rts.gameFramework.i.a.a(string3, 2);
                n2 = com.corrodinggames.rts.gameFramework.i.a.a(string2, 2);
            }
            catch (bo bo2) {
                throw new bo("Requires version: " + string4 + " or higher. " + bo2.getMessage(), bo2);
            }
            if (n6 < 1) {
                throw new bo("Min version cannot be less than v1.10");
            }
            if (n6 > n7) {
                throw new bo("Requires version: " + string4 + " or higher. (You have: " + string5 + ")");
            }
            if (n7 > n6) {
                return;
            }
            if (n4 < 10 && n6 == 1) {
                throw new bo("Min version cannot be less than v1.10");
            }
            if (n4 > n5) {
                throw new bo("Requires version: " + string4 + " or higher. (You have: " + string5 + ")");
            }
            if (n5 > n4) {
                return;
            }
            if (n2 > n3) {
                throw new bo("Requires version: " + string4 + " or higher. (You have: " + string5 + ")");
            }
            if (n3 > n2) {
                return;
            }
            if (n9 > n8) {
                throw new bo("Requires newer build: " + string4 + " or higher. (You have: " + string5 + ")");
            }
        }
        catch (RuntimeException runtimeException) {
            throw new bo("Requires version: " + string4 + " or higher." + runtimeException.getMessage(), runtimeException);
        }
    }

    public void a() {
        this.k();
        this.f();
    }

    public int a(boolean bl2) {
        int n2 = 0;
        for (b b2 : this.e) {
            if (b2.f || b2.D || bl2 && b2.R != null) continue;
            ++n2;
        }
        return n2;
    }

    public int b() {
        int n2 = 0;
        for (b b2 : this.e) {
            if (b2.f || b2.R == null) continue;
            ++n2;
        }
        return n2;
    }

    public int c() {
        int n2 = 0;
        for (b b2 : this.e) {
            if (b2.z) continue;
            ++n2;
        }
        return n2;
    }

    public void d() {
        for (b b2 : this.e) {
            b2.g = b2.f;
            b2.h = false;
        }
    }

    public void e() {
        GameEngine l2 = GameEngine.getInstance();
        String string2 = "";
        for (b b2 : this.e) {
            String string3 = b2.c;
            string3 = string3.replace(",", " ");
            if ((string3 = string3.replace("|", " ")).length() > 15) {
                string3 = string3.substring(12) + "...";
            }
            if (string2.length() != 0) {
                string2 = string2 + ",";
            }
            String string4 = b2.f ? "disabled" : "enabled";
            string2 = string2 + string3 + "|" + b2.e + "|" + string4;
        }
        l2.bQ.modSettingsVersion = 1;
        l2.bQ.modSettings = string2;
    }

    public void f() {
        String[] stringArray;
        GameEngine.log("Loading mod selection");
        GameEngine l2 = GameEngine.getInstance();
        String string2 = l2.bQ.modSettings;
        for (String string3 : stringArray = string2.split(",")) {
            boolean bl2;
            String[] stringArray2 = string3.split("\\|");
            if (stringArray2.length != 3) {
                GameEngine.log("loadSelection: wrong count (" + stringArray2.length + "):" + string3);
                continue;
            }
            String string4 = stringArray2[0];
            String string5 = stringArray2[1];
            String string6 = stringArray2[2];
            if (string6.equals("enabled")) {
                bl2 = false;
            } else if (string6.equals("disabled")) {
                bl2 = true;
            } else {
                GameEngine.log("loadSelection: Unknown option:" + string3);
                continue;
            }
            b b2 = this.c(string5);
            if (b2 == null) {
                GameEngine.log("loadSelection: Did not find mod in settings:" + string4);
                continue;
            }
            b2.f = bl2;
            b2.i = true;
        }
    }

    public b c(String string2) {
        for (b b2 : this.e) {
            if (!b2.e.equals(string2)) continue;
            return b2;
        }
        return null;
    }

    public int d(String string2) {
        if (string2 == null) {
            return 0;
        }
        int n2 = 0;
        for (b b2 : this.e) {
            if (!string2.equals(b2.c())) continue;
            ++n2;
        }
        return n2;
    }

    public b a(int n2) {
        for (b b2 : this.e) {
            if (b2.L != n2) continue;
            return b2;
        }
        return null;
    }

    public void g() {
        for (b b2 : this.e) {
            b2.f = true;
        }
    }

    public int h() {
        int n2 = 0;
        for (b b2 : this.e) {
            if (b2.f && !b2.D) continue;
            ++n2;
        }
        return n2;
    }

    public b e(String string2) {
        for (b b2 : this.e) {
            if (!b2.d.equals(string2)) continue;
            return b2;
        }
        return null;
    }

    public b f(String string2) {
        for (b b2 : this.e) {
            if (!b2.a().equals(string2)) continue;
            return b2;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public b a(String string2, String string3, String string4, String string5, boolean bl2, boolean bl3, boolean bl4, int n2) {
        b b2 = this.c(string5);
        if (b2 == null) {
            b2 = new b();
            b2.c = string2;
            b2.d = string3;
            b2.e = string5;
            boolean bl5 = b2.f = !bl2;
        }
        if (b2.q == null && string4 != null) {
            b2.p = b2.q = string4;
            b2.n();
            if (b2.q != null && b2.q.toLowerCase(Locale.ROOT).contains("rwmod")) {
                b2.j = true;
            }
        }
        b2.x = n2;
        b2.l = true;
        b2.y = bl3;
        b2.z = bl4;
        if (!b2.z) {
            b2.o = "Storage: " + com.corrodinggames.rts.gameFramework.storage.a.d(b2.q);
        }
        b2.r();
        Object object = this.d;
        synchronized (object) {
            if (!this.e.contains(b2)) {
                ArrayList<b> arrayList = new ArrayList<b>();
                arrayList.addAll(this.e);
                arrayList.add(b2);
                Collections.sort(arrayList);
                this.e = arrayList;
            }
        }
        return b2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(b b2) {
        Object object = this.d;
        synchronized (object) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.e);
            arrayList.remove(b2);
            this.e = arrayList;
        }
    }

    public void a(String string2, boolean bl2, boolean bl3) {
        GameEngine.log("loading mod custom units at:" + string2);
        String[] stringArray = com.corrodinggames.rts.gameFramework.storage.a.h(string2);
        if (stringArray == null) {
            GameEngine.b("getAllModList: ERROR");
            GameEngine.b("getAllModList: Failed to load:" + string2);
            return;
        }
        for (String string3 : stringArray) {
            String string4 = string2 + "/" + string3;
            if (!com.corrodinggames.rts.gameFramework.storage.a.f(string4) && !string3.endsWith(".ini")) continue;
            String string5 = com.corrodinggames.rts.gameFramework.GameUtils.e(string3);
            String string6 = string3;
            if (string6.contains("/")) {
                string6 = string6.substring(string3.lastIndexOf("/") + 1);
            }
            boolean bl4 = false;
            this.a(string6, string3, string4, string5, bl2, bl4, bl3, 0);
        }
    }

    public ArrayList i() {
        ArrayList arrayList = new ArrayList();
        for (b b2 : this.e) {
            if (!b2.m()) continue;
            arrayList.addAll(b2.q());
        }
        return arrayList;
    }

    public ArrayList j() {
        ArrayList<b> arrayList = new ArrayList<b>();
        for (b b2 : this.e) {
            if (!b2.m()) continue;
            arrayList.add(b2);
        }
        return arrayList;
    }

   public ArrayList k() {
      Iterator var1 = this.e.iterator();

      while(var1.hasNext()) {
         b var2 = (b)var1.next();
         var2.l = false;
         if (var2.m) {
            var2.l = true;
         }
      }

      com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine var8 = com.corrodinggames.rts.gameFramework.o.DisabledSteamEngine.a();
      if (var8 != null) {
         var8.l();
      } else {
         GameEngine.log("getAllModList: SteamEngine==null");
      }

      String var9 = ag.m();
      if (!com.corrodinggames.rts.gameFramework.storage.a.f(var9)) {
         GameEngine.log("Modded Custom '" + var9 + "' directory not found");
      } else {
         boolean var3 = false;
         this.a(var9, true, var3);
      }

      String var10 = ag.k();
      if (!com.corrodinggames.rts.gameFramework.storage.a.f(var10)) {
         GameEngine.log("Modded Custom '" + var10 + "' directory not found");
      } else {
         boolean var4 = true;
         this.a(var10, false, var4);
      }

      String var11 = ag.l();
      if (!com.corrodinggames.rts.gameFramework.storage.a.f(var11)) {
         GameEngine.log("Modded Custom '" + var11 + "' directory not found");
      } else {
         boolean var5 = true;
         this.a(var11, true, var5);
      }

      Iterator var12 = this.e.iterator();

      b var6;
      while(var12.hasNext()) {
         var6 = (b)var12.next();
         if (!var6.l) {
            GameEngine.log("Removing mod no longer found on system: " + var6.a());
            this.a(var6);
         }
      }

      GameEngine.log("========= Mods ===========");
      GameEngine.log("Number of mods:" + this.e.size());
      var12 = this.e.iterator();

      while(var12.hasNext()) {
         var6 = (b)var12.next();
         GameEngine.log("Mod: '" + var6.a());
      }

      GameEngine.log("================================");
      GameEngine var13 = GameEngine.getInstance();
      b var7;
      Iterator var14;
      if (var13.bQ.lastModCount != -1 && var13.bQ.modSettingsVersion >= 1) {
         if (this.e.size() > var13.bQ.lastModCount + 4) {
            GameEngine.log("Too many new mods found, not enabling new mods");
            GameEngine.log("Number of mods:" + this.e.size() + " vs " + var13.bQ.lastModCount);
            var14 = this.e.iterator();

            while(var14.hasNext()) {
               var7 = (b)var14.next();
               if (!var7.i) {
                  var7.f = true;
               }
            }

            this.e();
            var13.bQ.save();
         }
      } else {
         GameEngine.log("Disabling all new mods for first/new load");

         for(var14 = this.e.iterator(); var14.hasNext(); var7.f = true) {
            var7 = (b)var14.next();
         }

         this.e();
         var13.bQ.save();
      }

      var13.bQ.lastModCount = this.e.size();
      return this.e;
   }

    public void l() throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        try {
            l2.br = true;
            l2.e();
            this.a(false, false);
        }
        finally {
            l2.br = false;
        }
        l2.loadMenuBackground();
    }

    public void a(boolean bl2, boolean bl3) throws IOException {
        GameEngine l2 = GameEngine.getInstance();
        FileLoaderFactory.b();
        if (!bl3) {
            for (b b2 : this.e) {
                if (b2.R != null) {
                    GameEngine.log("re-enabling mod: " + b2.a());
                }
                b2.R = null;
                b2.V.clear();
                b2.S = null;
                b2.U.clear();
                b2.C = false;
                b2.D = false;
                b2.E = 0;
                b2.F = 0;
                b2.G = 0L;
                b2.H = 0L;
                b2.I = 0;
                b2.J = 0;
                b2.w = 0;
            }
        }
        this.k();
        ArrayList arrayList = new ArrayList(com.corrodinggames.rts.game.units.custom.l.d);
        if (!bl3) {
            ag.h();
        } else {
            ag.b();
        }
        if (bl2) {
            int n2 = 0;
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                com.corrodinggames.rts.game.units.custom.l l3 = (com.corrodinggames.rts.game.units.custom.l)iterator.next();
                if (l3.J == null || l3.J.f || l3.J.R == null || com.corrodinggames.rts.game.units.custom.l.a(l3) != null) continue;
                GameEngine.log("Was missing: " + l3.M);
                com.corrodinggames.rts.game.units.custom.l.d.add(l3);
                ++n2;
            }
            if (n2 > 0) {
                ag.e();
            }
        }
        com.corrodinggames.rts.game.units.custom.l.A();
        PlayerTeam.P();
        g.K();
    }

    public void m() {
        GameEngine l2 = GameEngine.getInstance();
        if (l2.dH != null) {
            l2.dH.d();
        } else {
            GameEngine.log("No active callbacks");
        }
    }

   public String[] a(String[] var1, String var2) {
      GameEngine.log("addExtraMapsForPath: " + var2);
      ArrayList var3 = new ArrayList();
      String[] var4;
      int var6;
      if (var1 != null) {
         var4 = var1;
         int var5 = var1.length;

         for(var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            var3.add(var7);
         }
      }

      if (GameEngine.at() && "/SD/rusted_warfare_maps".equals(var2)) {
         var4 = com.corrodinggames.rts.gameFramework.storage.a.a("/SD/rustedWarfare/maps", true);
         if (var4 != null) {
            String[] var10 = var4;
            var6 = var4.length;

            for(int var12 = 0; var12 < var6; ++var12) {
               String var8 = var10[var12];
               var3.add("NEW_PATH|maps2/" + var8);
            }
         }
      }

      Iterator var9 = this.g(var2).iterator();

      while(var9.hasNext()) {
         c var11 = (c)var9.next();
         var3.add("MOD|" + var11.c.e + "/" + var11.b);
      }

      return var1 == null && var3.size() == 0 ? null : (String[])var3.toArray(new String[0]);
   }

    public ArrayList g(String string2) {
        ArrayList<c> arrayList = new ArrayList<c>();
        for (c c2 : ((ArrayList<c>)this.f) ){
            boolean bl2 = false;
            if (string2.startsWith("mod/") && string2.startsWith("mod/" + c2.c.e)) {
                bl2 = true;
            }
            if (!c2.c.f && string2.startsWith("/SD/rusted_warfare_maps")) {
                bl2 = true;
            }
            if (!bl2) continue;
            GameEngine.log("Adding extra map:" + c2.a);
            arrayList.add(c2);
        }
        return arrayList;
    }

    public void n() {
        this.f.clear();
    }

    public void a(String string2, b b2) {
        c c2 = new c(this);
        c2.a = string2;
        c2.c = b2;
        if (b2.q == null) {
            GameEngine.a("Skipping:" + string2 + " as mod sourceFolder is null");
            return;
        }
        String string3 = string2;
        String string4 = b2.q;
        if (string3.startsWith(string4)) {
            string3 = string3.substring(string4.length());
        } else {
            String string5 = com.corrodinggames.rts.gameFramework.storage.a.o(string3);
            if (string5.startsWith(string4)) {
                string3 = string5.substring(string4.length());
                GameEngine.log("Mod path:" + b2.q + " in map path without tag:" + string3);
            } else {
                GameEngine.a("Mod path:" + b2.q + " not in map path:" + string3);
            }
        }
        c2.b = string3;
        b2.A = true;
        ++b2.F;
        this.f.add(c2);
    }

    public b h(String string2) {
        String[] stringArray;
        if (string2.contains("MOD|") && (stringArray = string2.split("/")).length >= 2) {
            for (int i2 = stringArray.length - 2; i2 >= 0; --i2) {
                String string3 = stringArray[i2];
                if (!string3.startsWith("MOD|")) continue;
                String string4 = string3.substring("MOD|".length());
                b b2 = this.c(string4);
                if (b2 == null) {
                    GameEngine.log("getLinkedModForFile: Failed to find mod with hash:" + string4);
                    return null;
                }
                return b2;
            }
        }
        return null;
    }
}

