package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.m;
import java.util.Iterator;

public class ab {
   m a;
   boolean b;
   float c;
   float d;
   int e;
   boolean f;
   public m g;
   // $FF: synthetic field
   final aa h;

   public ab(aa var1) {
      this.h = var1;
      this.a = new m();
   }

   public void a(y var1, UnitCommand var2) {
      var2.i = this;
      this.f = var2.j;
   }

   public void a(UnitCommand var1) {
      Iterator var2 = this.a.iterator();

      while(var2.hasNext()) {
         y var3 = (y)var2.next();
         if (!var3.bV) {
            UnitCommand var4 = var3.ar();
            if (var4 != null && var4.b(var1)) {
               var3.ay();
            }
         }
      }

   }

   public void a() {
      this.a.clear();
      BaseUnit[] var1 = BaseUnit.bE.a();
      int var2 = 0;

      for(int var3 = BaseUnit.bE.size(); var2 < var3; ++var2) {
         BaseUnit var4 = var1[var2];
         if (var4 instanceof y) {
            y var5 = (y)var4;
            if (var5.I()) {
               UnitCommand var6 = var5.ar();
               if (var6 != null && var6.i == this && var5.bg()) {
                  this.a.add(var5);
                  this.c = var6.g();
                  this.d = var6.h();
               }
            }
         }
      }

   }

   public void a(y var1) {
      var1.ac = this.e;
      UnitCommand var2 = var1.ar();
      if (var2 != null) {
         var2.i = this;
      }

   }

   public void b() {
      long var1 = PerformanceProfiler.a();
      this.c();
   }

   public y a(m var1, float var2, float var3, boolean var4) {
      float var5 = -1.0F;
      y var6 = null;
      Iterator var7 = var1.iterator();

      while(true) {
         y var8;
         float var9;
         do {
            do {
               if (!var7.hasNext()) {
                  return var6;
               }

               var8 = (y)var7.next();
            } while(!var4 && (var8.ad != null || var8.ae));

            var9 = com.corrodinggames.rts.gameFramework.GameUtils.b(var2, var3, var8.posX, var8.posY);
            if (var8.af) {
               var9 -= 160.0F;
            }
         } while(var5 != -1.0F && !(var9 < var5));

         var5 = var9;
         var6 = var8;
      }
   }

   public m a(float var1, float var2, boolean var3) {
      m var4 = new m(1);
      m var5 = new m();
      var5.clear();
      var5.addAll(this.a);

      while(true) {
         y var6 = this.a(var5, var1, var2, true);
         if (var6 == null) {
            return var4;
         }

         var4.add(var6);
         var5.remove(var6);
         m var7 = this.a(var5, var6, true, var3);
         var5.removeAll(var7);
      }
   }

   public m a(m var1, y var2, boolean var3, boolean var4) {
      m var5 = new m(1);
      var5.clear();
      int var6 = 0;
      boolean var7 = false;
      boolean var8 = true;
      Object[] var9 = var1.a();
      int var10 = 0;

      int var11;
      for(var11 = var1.size(); var10 < var11; ++var10) {
         y var12 = (y)var9[var10];
         var12.ap = false;
      }

      for(var10 = 0; var10 <= 2; ++var10) {
         var11 = 0;

         for(int var15 = var1.size(); var11 < var15; ++var11) {
            y var13 = (y)var9[var11];
            if (!var13.ap && var13 != var2 && (var3 || var13.ad == null && !var13.ae) && var13.h() == var2.h()) {
               float var14 = com.corrodinggames.rts.gameFramework.GameUtils.a(var13.posX, var13.posY, var2.posX, var2.posY);
               if ((var10 != 0 || !(var14 > 3600.0F)) && (var10 != 1 || !(var14 > 14400.0F)) && (var4 && var14 < 160000.0F || var14 < 40000.0F && var6 < 25) && (var4 || com.corrodinggames.rts.gameFramework.GameUtils.c(var13.z() - var2.z()) < 0.4F)) {
                  var13.ap = true;
                  var5.add(var13);
                  ++var6;
               }
            }
         }
      }

      return var5;
   }

   public void c() {
      GameEngine var1 = GameEngine.getInstance();
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = 0.0F;
      float var5 = 0.0F;
      long var6 = PerformanceProfiler.a();
      this.a();
      this.h.b.a(0.0F, 0.0F);
      Iterator var8 = this.a.iterator();

      while(var8.hasNext()) {
         y var9 = (y)var8.next();
         this.h.b.b(var9.posX, var9.posY);
      }

      this.h.b.a(this.h.b.x / (float)this.a.size(), this.h.b.b / (float)this.a.size());
      float var24 = com.corrodinggames.rts.gameFramework.GameUtils.d(this.h.b.x, this.h.b.b, this.c, this.d);

      y var10;
      for(Iterator var25 = this.a.iterator(); var25.hasNext(); var10.ac = this.e) {
         var10 = (y)var25.next();
         if (var10.ah > 1) {
            var10.af = var10.ae;
         } else {
            var10.af = false;
         }

         if (var10.af && var10.ah > 7) {
            float var11 = com.corrodinggames.rts.gameFramework.GameUtils.c(var10.am, var24, 360.0F);
            if (com.corrodinggames.rts.gameFramework.GameUtils.c(var11) > 80.0F) {
               var10.af = false;
            }
         }

         var10.aB();
         var10.ah = 0;
         var10.an = var1.by;
      }

      int var26 = 0;

      while(true) {
         var10 = null;
         long var27 = PerformanceProfiler.a();
         var10 = this.a(this.a, this.c, this.d, false);
         if (var10 == null) {
            return;
         }

         var10.ae = true;
         ab var13 = null;
         if (var26 > 0) {
            var13 = this.h.b();
         }

         if (var13 != null) {
            var13.g = this.g;
            var13.a(var10);
         }

         m var14 = this.a(this.a, var10, false, this.f);
         int var15 = 0;
         float var16 = 0.0F;

         for(Iterator var17 = var14.iterator(); var17.hasNext(); ++var15) {
            y var18 = (y)var17.next();
            if (var18.cj > var16) {
               var16 = var18.cj;
            }

            var18.a(var10);
            if (var13 != null) {
               var13.a(var18);
            }
         }

         if (var10 != null) {
            var10.ah = (short)(var15 + 1);
         }

         m var28 = new m();
         Object[] var29 = this.a.a();
         int var19 = 0;

         for(int var20 = this.a.size(); var19 < var20; ++var19) {
            y var21 = (y)var29[var19];
            if (var21.ad == var10) {
               var28.add(var21);
            }
         }

         m var30 = this.h.a(var15, var16, var24);
         long var31 = PerformanceProfiler.a();
         this.h.a(var28, var10, var30, var24, var15);
         long var22 = PerformanceProfiler.a();
         this.h.a(var28, var10);
         ++var26;
      }
   }
}
