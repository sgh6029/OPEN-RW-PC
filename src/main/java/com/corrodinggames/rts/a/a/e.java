/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.a.a.l;
import com.corrodinggames.rts.a.a.n;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.f.b;
import com.corrodinggames.rts.gameFramework.PerformanceProfiler;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.i.a;
import com.corrodinggames.rts.gameFramework.storage.d;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.ag;
import com.corrodinggames.rts.gameFramework.utility.al;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class e
extends l {
    int a = 1;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
   public void a() {
      com.corrodinggames.rts.gameFramework.GameEngine.log("separator regex test");
      "first".split(Pattern.quote(File.separator));
      n.a("first\\second".split(Pattern.quote("\\"))[0], "first");
      n.a("first/second".split(Pattern.quote("/"))[0], "first");
      com.corrodinggames.rts.gameFramework.GameEngine.log("Test for dis sq ranges");
      int var1 = 850000;
      int var2 = 8500000;
      n.a(50 < var1 * var1);
      n.a(50.0F < (float)(var1 * var1));
      n.a(50 < var2 * var2);
      n.a(50.0F < (float)(var2 * var2));
      Random var3 = new Random();
      float[] var4 = new float[10000];

      for(int var5 = 1; var5 < 5; ++var5) {
         int var6 = 0;

         for(int var7 = 0; var7 < var4.length; ++var7) {
            var4[var7] = var3.nextFloat() * 50.0F;
         }

         long var57 = PerformanceProfiler.a();

         int var9;
         int var10;
         for(var9 = 0; var9 < 1000; ++var9) {
            for(var10 = 0; var10 < var4.length; ++var10) {
               var6 += GameUtils.a((int)var4[var10]);
            }
         }

         com.corrodinggames.rts.gameFramework.GameEngine.log("sum:" + var6);
         com.corrodinggames.rts.gameFramework.GameEngine.log("fastSquareRootInt took:" + PerformanceProfiler.a((double)PerformanceProfiler.a(var57)));

         for(var9 = 0; var9 < var4.length; ++var9) {
            var4[var9] = var3.nextFloat() * 50.0F;
         }

         var57 = PerformanceProfiler.a();
         var6 = 0;

         for(var9 = 0; var9 < 1000; ++var9) {
            for(var10 = 0; var10 < var4.length; ++var10) {
               var6 = (int)((float)var6 + GameUtils.a((float)((int)var4[var10])));
            }
         }

         com.corrodinggames.rts.gameFramework.GameEngine.log("sum:" + var6);
         com.corrodinggames.rts.gameFramework.GameEngine.log("squareRoot took:" + PerformanceProfiler.a((double)PerformanceProfiler.a(var57)));
      }

      com.corrodinggames.rts.gameFramework.GameEngine.log("CommonUtils.fastSplit");
      String[] var54 = GameUtils.c("testA|testB", '|');
      n.a(var54.length, 2);
      n.a(var54[0], "testA");
      n.a(var54[1], "testB");
      var54 = GameUtils.c("test|", '|');
      n.a(var54.length, "test|".split("\\|").length);
      n.a(var54[0], "test");
      var54 = GameUtils.c("|test", '|');
      n.a(var54.length, 2);
      n.a(var54[0], "");
      n.a(var54[1], "test");
      var54 = GameUtils.c("|", '|');
      n.a(var54.length, 0);
      com.corrodinggames.rts.gameFramework.GameEngine.log("VariableReplacement");
      b var55 = new b();
      var55.b.a("a", "5");
      var55.b.a("b", "10");
      var55.b.a("abc_foo", "7");
      com.corrodinggames.rts.game.units.custom.l var56 = com.corrodinggames.rts.game.units.custom.l.b;

      IniFile var58;
      try {
         var58 = new IniFile("assets/" + var56.D);
      } catch (IOException var51) {
         throw new RuntimeException(var51);
      }

      String var8;
      try {
         var8 = var55.a(var56, var58, "core", "123");
         n.a(var8, "123");
         var8 = var55.a(var56, var58, "core", "1+1");
         n.a(var8, "2");
         var8 = var55.a(var56, var58, "core", "(1+1)*2");
         n.a(var8, "4");
         var8 = var55.a(var56, var58, "core", "a+b");
         n.a(var8, "15");
         var8 = var55.a(var56, var58, "core", "a+a+abc_foo");
         n.a(var8, "17");
         var8 = var55.a(var56, var58, "core", "(2+2)*(2+2)");
         n.a(var8, "16");
         var8 = var55.a(var56, var58, "core", "10/5");
         n.a(var8, "2");
         var8 = var55.a(var56, var58, "core", "10-5");
         n.a(var8, "5");
         var8 = var55.a(var56, var58, "core", "cos(60)");
         n.c(var8, "0.5");
         var8 = var55.a(var56, var58, "core", "sin(b+20+(2-2)+(5*0))");
         n.c(var8, "0.5");
      } catch (bo var50) {
         throw new RuntimeException(var50);
      }

      com.corrodinggames.rts.gameFramework.GameEngine.log("PassthroughZipReader");
      n.a(ag.l("/first/second/zip.rwmod/test1/test2"), "test1/test2");
      n.a(ag.l("\\first\\second\\zip.rwmod\\test1\\test2"), "test1/test2");
      this.a("A", "B");
      this.a("AA=11", "BB=22");
      this.a("AA='11'", "BB='22'");
      this.a("AA=(11)", "BB=22");
      this.a("(AA)=(11)", "BB=22");
      this.a("(AA)=('11')", "BB=22");
      this.a("(AA)=('11')", "BB=((22))");
      this.a("(A,A)=('1,1')", "BB=((2,2))");
      this.a("(A,A)=('1,,1')", "BB=((2,2))");
      com.corrodinggames.rts.gameFramework.GameEngine.log("splitWithEscaping");
      this.a(al.b("hello world", ' '), "hello", "world");
      this.a(al.b("hello world", 'X'), "hello world");
      this.a(al.b("hello,world", ','), "hello", "world");
      this.a(al.b("he\\,llo,world", ','), "he,llo", "world");
      this.a("".split(" "), "");
      this.a(al.b("", ' '), "");
      this.a(al.b("hello\\\\,World", ','), "hello\\", "World");
      this.a(al.b("Hello\\A,world", ','), "HelloA", "world");
      this.a(al.b("h\\ello\\,world", ','), "hello,world");
      this.a(al.b("h\\ello\\,w,orld", ','), "hello,w", "orld");
      this.a(al.b("h\\ello\\,w,orld", ','), "hello,w", "orld");
      n.a(al.a(new String[]{"Hello"}), "Hello");
      n.a(al.a(new String[]{"Hello", "World"}), "Hello,World");
      n.a(al.a(new String[]{"Hel,lo", "World"}), "Hel\\,lo,World");
      n.a(al.a(new String[]{"Hel,lo,", "Wor,ld"}), "Hel\\,lo\\,,Wor\\,ld");
      n.a(al.a(new String[]{"Hel\\,lo,", "Wor,ld"}), "Hel\\\\\\,lo\\,,Wor\\,ld");
      n.a(al.a(new String[]{"H\\el\\,lo,", "Wor,ld"}), "H\\\\el\\\\\\,lo\\,,Wor\\,ld");
      com.corrodinggames.rts.gameFramework.GameEngine.log("FileLoaderBackend");
      var8 = "/tmp/rustedWarfareTests/";
      d var59 = new d(var8, "test1");
      var59.a = "fileLoader1: ";
      var59.b = true;
      String var60 = "/tmp/rustedWarfareTestsSec2/";
      d var11 = new d(var60, "test2");
      var11.a = "fileLoader2: ";
      var11.b = true;
      String var12 = "primary-PATH/";
      String var13 = "[ALT-PATH]/";
      com.corrodinggames.rts.gameFramework.storage.e var14 = new com.corrodinggames.rts.gameFramework.storage.e(var59, var12, var11, var13);
      var14.a = "mergedFileLoader: ";
      var14.b = true;
      n.b(var59.f("/SD/rustedWarfare/"), var8);
      n.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "mods/maps/coolMap.tmx");
      n.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "mods/maps/coolMap.tmx");
      n.b(var59.f("units/test.ini"), "assets/units/test.ini");
      com.corrodinggames.rts.gameFramework.GameEngine.log("FileLoaderBackend - merged");
      n.b(var14.f("/SD/rustedWarfare/"), var8);
      n.b(var14.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "mods/maps/coolMap.tmx");
      boolean var15 = true;
      com.corrodinggames.rts.gameFramework.GameEngine.log("FileLoaderBackend - android fake");
      boolean var16 = com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2;
      com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 = false;

      try {
         n.b(var59.f("/SD/rustedWarfare/"), var8);
         n.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "maps/coolMap.tmx");
         n.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "maps/coolMap.tmx");
         n.b(var59.f("units/test.ini"), "units/test.ini");
      } finally {
         com.corrodinggames.rts.gameFramework.GameEngine.isPausedStatic2 = var16;
      }

      if (var15) {
         com.corrodinggames.rts.gameFramework.GameEngine.log("FileLoaderBackend - real file tests");
         String var17 = "/SD/rustedWarfare/testDir";
         File var18 = new File(var59.f(var17));
         var18.mkdirs();
         File var19 = new File(var11.f(var17));
         var19.mkdirs();
         boolean var41 = false;

         try {
            var41 = true;
            File var20 = new File(var59.f(var17 + "/map1.tmx"));
            var20.createNewFile();
            FileWriter var21 = new FileWriter(var20);
            var21.write("map1");
            var21.close();
            File var22 = new File(var59.f(var17 + "/map2.tmx"));
            var22.createNewFile();
            File var23 = new File(var11.f(var17 + "/map3.tmx"));
            var23.createNewFile();
            FileWriter var24 = new FileWriter(var23);
            var24.write("map3");
            var24.close();
            String[] var25 = var59.b(var17, false);
            n.a(var25.length, 2);
            n.b(var25[0], "map1.tmx");
            n.b(var25[1], "map2.tmx");
            var25 = var14.b(var17, false);
            n.a(var25.length, 3);
            n.b(var25[0], var12 + "map1.tmx");
            n.b(var25[1], var12 + "map2.tmx");
            n.b(var25[2], var13 + "map3.tmx");
            String var26 = var25[2];
            AssetInputStream var27 = var14.j(var17 + "/" + var26);
            if (var27 == null) {
               throw new RuntimeException("Null for: " + var17 + "/" + var26);
            }

            n.b(GameUtils.b(var27), "map3");
            var41 = false;
         } catch (IOException var52) {
            throw new RuntimeException(var52);
         } finally {
            if (var41) {
               com.corrodinggames.rts.gameFramework.GameEngine.log("FileLoaderBackend - clean up");
               String[] var29 = var18.list();
               String[] var30 = var29;
               int var31 = var29.length;

               for(int var32 = 0; var32 < var31; ++var32) {
                  String var33 = var30[var32];
                  File var34 = new File(var18.getPath(), var33);
                  var34.delete();
               }

               var18.delete();
            }
         }

         com.corrodinggames.rts.gameFramework.GameEngine.log("FileLoaderBackend - clean up");
         String[] var61 = var18.list();
         String[] var62 = var61;
         int var63 = var61.length;

         for(int var64 = 0; var64 < var63; ++var64) {
            String var65 = var62[var64];
            File var66 = new File(var18.getPath(), var65);
            var66.delete();
         }

         var18.delete();
         com.corrodinggames.rts.gameFramework.GameEngine.log("isSameOrHigherVersion..");
         this.a("v1.13", "v1.14", true);
         this.a("v1.13", "v2.14", true);
         this.a("v1.13", "v2.11", true);
         this.a("v1.13", "v1.13p5", false);
         this.a("v1.13", "v1.13.2", true);
         this.a("v1.13.2", "v1.13", false);
         this.a("v1.13", "v1.13b", true);
         this.a("v1.13", "v1.13.2p6", true);
         this.a("v1.13", "v1.14.2p6", true);
         this.a("v1.13p9", "v1.14.2p6", true);
         this.a("v1.13p9", "v1.14p6", true);
         this.a("v1.14p3", "v1.14p6", true);
         this.a("v1.14p3", "v1.14p6b", true);
         this.a("v1.14p8", "v1.14p3", false);
         this.a("v1", "v2", true);
         this.a("v1.5", "v2", true);
         this.a("v2", "v1.15", false);
         this.a("v2.0.5", "v1.15", false);
         this.a("v1.15", "v2.0.5", true);
         this.a("v1.15.6", "v2.0.5", true);
         this.a("v1.15.6", "v1.16.5", true);
         this.a("v1.13", "v1.13.2p5", true);
         this.a("v1.14", "v1.14p3", false);
         this.a("v1.14b", "v1.14p3", false);
         this.a("v1.14.2", "v1.14p3", false);
         this.a("v1.14.2b", "v1.14p3", false);

         try {
            com.corrodinggames.rts.gameFramework.i.a.a("v1.11p1");
         } catch (bo var48) {
            throw new RuntimeException(var48);
         }

         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("10000", com.corrodinggames.rts.game.units.custom.e.b.none), "10000");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("", com.corrodinggames.rts.game.units.custom.e.b.space), "");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("1", com.corrodinggames.rts.game.units.custom.e.b.comma), "1");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("10", com.corrodinggames.rts.game.units.custom.e.b.comma), "10");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("100", com.corrodinggames.rts.game.units.custom.e.b.comma), "100");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("1000", com.corrodinggames.rts.game.units.custom.e.b.comma), "1,000");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a(".", com.corrodinggames.rts.game.units.custom.e.b.comma), ".");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a(".2", com.corrodinggames.rts.game.units.custom.e.b.comma), ".2");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a(".22", com.corrodinggames.rts.game.units.custom.e.b.comma), ".22");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a(".223", com.corrodinggames.rts.game.units.custom.e.b.comma), ".223");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a(".2234", com.corrodinggames.rts.game.units.custom.e.b.comma), ".2234");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("100.2234", com.corrodinggames.rts.game.units.custom.e.b.comma), "100.2234");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("1000.2234", com.corrodinggames.rts.game.units.custom.e.b.comma), "1,000.2234");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("10000", com.corrodinggames.rts.game.units.custom.e.b.comma), "10,000");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("9800000", com.corrodinggames.rts.game.units.custom.e.b.comma), "9,800,000");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("9800000.67", com.corrodinggames.rts.game.units.custom.e.b.comma), "9,800,000.67");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("98000000.67", com.corrodinggames.rts.game.units.custom.e.b.comma), "98,000,000.67");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("980000000.67", com.corrodinggames.rts.game.units.custom.e.b.comma), "980,000,000.67");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("9800000001.67", com.corrodinggames.rts.game.units.custom.e.b.comma), "9,800,000,001.67");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("9800000001.6", com.corrodinggames.rts.game.units.custom.e.b.comma), "9,800,000,001.6");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("9800000001.", com.corrodinggames.rts.game.units.custom.e.b.comma), "9,800,000,001.");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a("9800000001", com.corrodinggames.rts.game.units.custom.e.b.comma), "9,800,000,001");
         n.a(com.corrodinggames.rts.game.units.custom.e.a_f3.a(9800000L, com.corrodinggames.rts.game.units.custom.e.b.comma), "9,800,000");
      }

   }
    public void a(String string2, String string3) {
        ArrayList arrayList = al.a(string2 + "," + string3, ",", false, false);
        n.a((String)arrayList.get(0), string2);
        n.a((String)arrayList.get(1), string3);
    }

    public void a(String[] stringArray, String string2) {
        n.a(stringArray.length, 1);
        n.a(stringArray[0], string2);
    }

    public void a(String[] stringArray, String string2, String string3) {
        n.a(stringArray.length, 2);
        n.a(stringArray[0], string2);
        n.a(stringArray[1], string3);
    }

    public void a(String string2, String string3, boolean bl2) {
        boolean bl3 = false;
        try {
            com.corrodinggames.rts.gameFramework.i.a.a(string2, string3);
            bl3 = true;
        }
        catch (bo bo2) {
            if (bl2) {
                com.corrodinggames.rts.gameFramework.GameEngine.b(bo2.getMessage());
            }
            bl3 = false;
        }
        if (bl3 != bl2) {
            throw new RuntimeException("isSameOrHigherVersion(" + string2 + "," + string3 + "): Asset failed got: " + bl3);
        }
    }
}

