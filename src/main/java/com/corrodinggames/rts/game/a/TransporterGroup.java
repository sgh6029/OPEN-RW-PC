/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.a.ActionId;
import com.corrodinggames.rts.game.units.TransportUnitInterface;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitMovementType;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameCommand;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import android.graphics.PointF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//游戏中AI控制的运输系统
//负责自动调度运输单位执行运输任务
public class TransporterGroup
extends AIUnitGroupBase {
    boolean a;
    int b;
    int c;
    BaseZone d;
    float e = 100.0f;
    float f = 4000.0f;
    float g = 100.0f;
    float h;
    float i;
    float j;
    float k;
    int l;
    AIUnitGroupBase m;
    com.corrodinggames.rts.game.units.y n;
    float o = 0.0f;
    boolean p = false;
    boolean q;
    float r;
    float s;

    @Override
    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.a);
        as2.a(this.b);
        as2.a(this.c);
        int n2 = this.F.size();
        as2.a(n2);
        ArrayList<com.corrodinggames.rts.game.units.y> tmp = this.F;
        for (com.corrodinggames.rts.game.units.y y2 : tmp) {
            as2.a(y2);
        }
        as2.c(5);
        as2.a(this.R.a(this.m));
        as2.a(this.q);
        as2.a(this.n);
        as2.a(this.o);
        as2.a(this.p);
        as2.a(this.r);
        as2.a(this.s);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        int n2;
        this.a = k2.e();
        this.b = k2.readInt();
        this.c = k2.readInt();
        this.q();
        int n3 = k2.readInt();
        for (n2 = 0; n2 < n3; ++n2) {
            com.corrodinggames.rts.game.units.y y2 = k2.p();
            if (y2 == null) continue;
            if (!this.R.g(y2)) {
                com.corrodinggames.rts.gameFramework.GameEngine.b("TransporterGroup:readIn: Unit is not transporterUnit");
                continue;
            }
            this.a(y2);
        }
        n2 = k2.d();
        if (n2 >= 1) {
            this.m = (AIUnitGroupBase)this.R.m(k2.readInt());
        }
        if (n2 >= 2) {
            this.q = k2.e();
        }
        if (n2 >= 3) {
            this.n = k2.p();
        }
        if (n2 >= 4) {
            this.o = k2.g();
            this.p = k2.e();
        }
        if (n2 >= 5) {
            this.r = k2.g();
            this.s = k2.g();
        }
        super.a(k2);
    }

    public TransporterGroup(AIController a2) {
        super(a2);
    }

    public void c() {
        for (BaseUnit am2 : ((List<BaseUnit>)BaseUnit.bE)) {
            if (am2.bV || am2.bX != this.R || this.l <= this.F.size() || !(am2 instanceof com.corrodinggames.rts.game.units.y)) continue;
            com.corrodinggames.rts.game.units.y y2 = (com.corrodinggames.rts.game.units.y)am2;
            if (y2.bN || y2.aB != null || !this.R.g(y2) || !this.R.i(y2)) continue;
            this.a(y2);
        }
    }

    public boolean d() {
        return this.m != null;
    }

    @Override
   public void c(float var1) {
      GameEngine var2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
      this.h += var1;
      this.n();
      if (this.l <= this.F.size()) {
      }

      this.i = com.corrodinggames.rts.gameFramework.GameUtils.a(this.i, var1);
      this.j = com.corrodinggames.rts.gameFramework.GameUtils.a(this.j, var1);
      this.k = com.corrodinggames.rts.gameFramework.GameUtils.a(this.k, var1);
      if (!this.d() && !this.q && this.l > this.F.size() && this.i == 0.0F) {
         this.i = 300.0F;
         this.c();
      }

      Iterator var4;
      y var5;
      TransportUnitInterface var6;
      if (!this.d() && this.F.size() != 0) {
         if (!this.d()) {
            this.f = com.corrodinggames.rts.gameFramework.GameUtils.a(this.f, var1);
            if (this.f == 0.0F) {
               this.f = 4000.0F;
               if (this.d != null) {
                  PointF var3 = this.d.w();
                  this.S = var3.x;
                  this.T = var3.b;
               }
            }
         }

         if (this.j == 0.0F) {
            this.j = 400.0F;
            GameCommand var10 = var2.cf.a(this.R);
            var4 = this.F.iterator();

            while(true) {
               while(var4.hasNext()) {
                  var5 = (y)var4.next();
                  if (this.c(var5) > 28900.0F && !var5.aw()) {
                     var10.a(var5);
                  } else {
                     var6 = (TransportUnitInterface)var5;
                     if (var6.bB() != 0) {
                        ActionId var7 = var5.cp();
                        GameCommand var8 = var2.cf.a(this.R);
                        var8.a(var5);
                        var8.a(var7);
                     }
                  }
               }

               var10.a(this.S, this.T);
               break;
            }
         }

         if (this.m == null) {
            this.g = com.corrodinggames.rts.gameFramework.GameUtils.a(this.g, var1);
            if (this.g == 0.0F) {
               this.g = 100.0F;
               if (com.corrodinggames.rts.gameFramework.GameUtils.a(0, 100) < 80) {
                  this.a(var1, true);
               }

               if (this.m == null) {
                  this.a(var1, false);
               }
            }
         }
      }

      if (this.m != null && this.m.V) {
         this.m = null;
      }

      GameCommand var9;
      Iterator var17;
      y var21;
      if (!this.q) {
         if (this.m != null) {
            ArrayList var11 = this.m.G;
            if (this.n != null && (this.n.bV || this.n.cN != null || this.n.cO != null)) {
               var11.remove(this.n);
               this.n = null;
            }

            if (this.n == null) {
               var4 = var11.iterator();

               label204:
               while(true) {
                  while(true) {
                     do {
                        if (!var4.hasNext()) {
                           if (this.n == null) {
                              this.q = true;
                              this.j = 0.0F;
                              this.k = 0.0F;
                              this.r = this.m.S;
                              this.s = this.m.T;
                           }
                           break label204;
                        }

                        var5 = (y)var4.next();
                     } while(var5.cN != null);

                     var17 = this.F.iterator();

                     while(var17.hasNext()) {
                        var21 = (y)var17.next();
                        if (var21.d(var5, false)) {
                           this.n = var5;
                           break;
                        }
                     }
                  }
               }
            }

            if (this.n != null) {
               Iterator var15;
               y var18;
               if (this.j == 0.0F) {
                  this.j = 400.0F;
                  GameCommand var13 = var2.cf.a(this.R);
                  var15 = this.F.iterator();

                  while(var15.hasNext()) {
                     var18 = (y)var15.next();
                     var13.a(var18);
                  }

                  var13.a(this.n.posX, this.n.posY);
               }

               if (this.k == 0.0F) {
                  this.k = 80.0F;
                  var4 = var11.iterator();

                  while(true) {
                     while(var4.hasNext()) {
                        var5 = (y)var4.next();
                        var17 = this.F.iterator();

                        while(var17.hasNext()) {
                           var21 = (y)var17.next();
                           if (var21.d(var5, false)) {
                              float var26 = com.corrodinggames.rts.gameFramework.GameUtils.a(var21.posX, var21.posY, var5.posX, var5.posY);
                              if (var26 < 14400.0F) {
                                 var9 = var2.cf.a(this.R);
                                 var9.a(var5);
                                 var9.e(var21);
                                 break;
                              }
                           }
                        }
                     }

                     boolean var14 = false;
                     var15 = this.F.iterator();

                     while(var15.hasNext()) {
                        var18 = (y)var15.next();
                        if (var18.d(this.n, false)) {
                           var14 = true;
                        }
                     }

                     if (!var14) {
                        this.n = null;
                     }
                     break;
                  }
               }
            }
         }
      } else if (this.m == null) {
         this.e();
      } else {
         if (this.j == 0.0F) {
            this.j = 400.0F;
            float var12 = this.m.S + com.corrodinggames.rts.gameFramework.GameUtils.c(-40.0F, 40.0F);
            float var16 = this.m.T + com.corrodinggames.rts.gameFramework.GameUtils.c(-40.0F, 40.0F);
            if (this.o > 600.0F) {
               var12 += com.corrodinggames.rts.gameFramework.GameUtils.c(-300.0F, 300.0F);
               var16 += com.corrodinggames.rts.gameFramework.GameUtils.c(-300.0F, 300.0F);
            }

            if (this.o > 1200.0F) {
               var12 += com.corrodinggames.rts.gameFramework.GameUtils.c(-300.0F, 300.0F);
               var16 += com.corrodinggames.rts.gameFramework.GameUtils.c(-300.0F, 300.0F);
            }

            if (com.corrodinggames.rts.gameFramework.utility.y.a(var12, var16, UnitMovementType.LAND)) {
               var12 += com.corrodinggames.rts.gameFramework.GameUtils.c(-100.0F, 100.0F);
               var16 += com.corrodinggames.rts.gameFramework.GameUtils.c(-100.0F, 100.0F);
            }

            if (com.corrodinggames.rts.gameFramework.utility.y.a(var12, var16, UnitMovementType.LAND)) {
               var12 += com.corrodinggames.rts.gameFramework.GameUtils.c(-200.0F, 200.0F);
               var16 += com.corrodinggames.rts.gameFramework.GameUtils.c(-200.0F, 200.0F);
            }

            if (com.corrodinggames.rts.gameFramework.utility.y.a(var12, var16, UnitMovementType.LAND)) {
               var12 += com.corrodinggames.rts.gameFramework.GameUtils.c(-200.0F, 200.0F);
               var16 += com.corrodinggames.rts.gameFramework.GameUtils.c(-200.0F, 200.0F);
            }

            if (com.corrodinggames.rts.gameFramework.utility.y.a(var12, var16, UnitMovementType.LAND)) {
               this.j = 30.0F;
            } else {
               this.r = var12;
               this.s = var16;
               GameCommand var19 = var2.cf.a(this.R);
               var17 = this.F.iterator();

               while(var17.hasNext()) {
                  var21 = (y)var17.next();
                  TransportUnitInterface var27 = (TransportUnitInterface)var21;
                  if (var27.bB() != 0) {
                     float var28 = com.corrodinggames.rts.gameFramework.GameUtils.a(var21.posX, var21.posY, this.r, this.s);
                     if (var28 > 1600.0F) {
                        var19.a(var21);
                     }
                  } else {
                     var9 = var2.cf.a(this.R);
                     var9.a(var21);
                     var9.a(this.S, this.T);
                  }
               }

               var19.a(this.r, this.s);
            }
         }

         if (this.k == 0.0F) {
            this.k = 100.0F;
            Iterator var22 = this.F.iterator();

            while(var22.hasNext()) {
               y var29 = (y)var22.next();
               float var20 = com.corrodinggames.rts.gameFramework.GameUtils.a(var29.posX, var29.posY, this.r, this.s);
               if (var20 < 6400.0F) {
                  this.p = true;
                  ActionId var24 = var29.cp();
                  GameCommand var25 = var2.cf.a(this.R);
                  var25.a(var29);
                  var25.a(var24);
               }
            }
         }

         if (this.p) {
            this.m.o();
            this.o += var1;
         }

         boolean var23 = false;
         var4 = this.F.iterator();

         while(var4.hasNext()) {
            var5 = (y)var4.next();
            if (!var5.bV) {
               var6 = (TransportUnitInterface)var5;
               if (var6.bB() != 0) {
                  var23 = true;
               }
            }
         }

         if (!var23 || this.o > 1700.0F) {
            this.e();
         }
      }

      if (this.h > 1500.0F && this.F.size() == 0) {
         this.p();
      }

   }



    public void e() {
        this.q = false;
        this.m = null;
        this.o = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.p = false;
        this.f();
    }

    public void a(float f2, boolean bl2) {
        for (o o2 : ((ArrayList<o>)this.R.bn)) {
            if (!(o2 instanceof AIUnitGroupBase) || o2 instanceof TransporterGroup || bl2 && !(o2 instanceof RallyGroup)) continue;
            AIUnitGroupBase h2 = (AIUnitGroupBase)o2;
            if (h2.G.size() == 0 || h2.m()) continue;
            this.m = h2;
            this.n = null;
            return;
        }
    }

    public BaseZone a(boolean bl2) {
        BaseZone i2 = null;
        for (o o2 : ((ArrayList<o>)this.R.bn)) {
            if (!(o2 instanceof BaseZone)) continue;
            BaseZone i3 = (BaseZone)o2;
            if (i3.s && bl2 || i3.b != com.corrodinggames.rts.game.a.BaseZoneStage.Active) continue;
            i2 = i3;
            if (com.corrodinggames.rts.gameFramework.GameUtils.c(3) != 0) continue;
            return i2;
        }
        return i2;
    }

    public void f() {
        boolean bl2 = true;
        PointF pointF = null;
        if (bl2) {
            this.d = this.a(true);
            if (this.d == null) {
                this.d = this.a(false);
            }
            if (this.d != null) {
                pointF = this.d.w();
            }
        }
        if (pointF == null) {
            pointF = this.R.am();
            this.d = null;
        }
        this.S = pointF.x;
        this.T = pointF.b;
    }
}

