/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game;

import java.io.IOException;


import com.corrodinggames.rts.game.m;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.y;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.GGameObject;

public class l
extends GGameObject {
    int a;
    int b;
    int c = 50;
    int d = 40;
    m e;
    int f;
    int g = -1;
    static final Rect h = new Rect();
    static final Rect i = new Rect();
    static final Paint j = y.b();
    static Texture_M k = null;
    static Texture_M l = null;
    static Texture_M m = null;
    static final RectF n = new RectF();

    public static void b() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        k = l2.bO.a(com.corrodinggames.rts.R.drawable.scorch_mark, true);
        com.corrodinggames.rts.game.l.k.m = true;
        l = l2.bO.a(com.corrodinggames.rts.R.drawable.scorch_mark_nuke, true);
        com.corrodinggames.rts.game.l.l.m = true;
        m = l2.bO.a(com.corrodinggames.rts.R.drawable.blood_mark, true);
        com.corrodinggames.rts.game.l.m.m = true;
    }

    public l() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        this.S(-1);
        this.f = l2.by;
    }

    public static void a(float f2, float f3) {
        com.corrodinggames.rts.game.l.a(f2, f3, com.corrodinggames.rts.game.m.a);
    }

    public static void a(float f2, float f3, m m2) {
        if (!com.corrodinggames.rts.game.l.b(f2, f3, m2)) {
            return;
        }
        l l2 = new l();
        l2.posX = f2;
        l2.posY = f3;
        if (m2 == com.corrodinggames.rts.game.m.a) {
            l2.a = 0;
            l2.b = com.corrodinggames.rts.gameFramework.GameUtils.a(l2, 0, 3, 0);
        } else {
            l2.a = 2;
        }
        if (l2.a == 2) {
            l2.c = l.m();
            l2.d = l.l();
        }
        l2.e = m2;
        l2.d();
    }

    public static void a(com.corrodinggames.rts.game.units.y y2, int n2) {
        if (!y2.cJ()) {
            m m2;
            m m3 = m2 = n2 == 2 ? com.corrodinggames.rts.game.m.b : com.corrodinggames.rts.game.m.a;
            if (!com.corrodinggames.rts.game.l.b(y2.posX, y2.posY, m2)) {
                return;
            }
            l l2 = new l();
            l2.a = n2;
            if (l2.a == 2) {
                l2.c = l.m();
                l2.d = l.l();
            }
            l2.posX = y2.posX;
            l2.posY = y2.posY;
            l2.e = m2;
            l2.b = com.corrodinggames.rts.gameFramework.GameUtils.a(l2, 0, 3, 0);
            l2.d();
        }
    }

   public static boolean b(float var0, float var1, m var2) {
      int var3 = 0;
      int var4 = 0;
      byte var5 = 5;
      byte var6 = 25;
      if (var2 == com.corrodinggames.rts.game.m.b) {
         var6 = 45;
      }

      GGameObject[] var7 = GGameObject.fastGameObjectList.a();
      int var8 = GGameObject.fastGameObjectList.size();

      for(int var9 = 0; var9 < var8; ++var9) {
         GGameObject var10 = var7[var9];
         if (var10 instanceof l) {
            l var11 = (l)var10;
            if (com.corrodinggames.rts.gameFramework.GameUtils.c(var11.posX - var0) < (float)var6 && com.corrodinggames.rts.gameFramework.GameUtils.c(var11.posY - var1) < (float)var6 && var11.e == var2) {
               ++var3;
               if (com.corrodinggames.rts.gameFramework.GameUtils.c(var11.posX - var0) < (float)var5 && com.corrodinggames.rts.gameFramework.GameUtils.c(var11.posY - var1) < (float)var5) {
                  ++var4;
               }
            }
         }
      }

      if (var3 >= 3) {
         return false;
      } else if (var4 >= 1) {
         return false;
      } else {
         return true;
      }
   }


    @Override
    public boolean a(com.corrodinggames.rts.gameFramework.GameEngine l2) {
        return false;
    }

    @Override
    public boolean f(float f2) {
        return false;
    }

    @Override
    public boolean c(float f2) {
        return true;
    }

    public RectF c() {
        com.corrodinggames.rts.game.l.n.left = this.posX - (float)this.c * 0.5f;
        com.corrodinggames.rts.game.l.n.c = this.posX + (float)this.c * 0.5f;
        com.corrodinggames.rts.game.l.n.b = this.posY - (float)this.d * 0.5f;
        com.corrodinggames.rts.game.l.n.d = this.posY + (float)this.d * 0.5f;
        return n;
    }

    public void a(com.corrodinggames.rts.gameFramework.m.y y2, int n2, int n3, float f2) throws IOException {
        int n4 = this.b * this.c;
        int n5 = 0;
        Texture_M e2 = null;
        int n6 = this.c;
        int n7 = this.d;
        if (this.a == 0) {
            e2 = k;
        } else if (this.a == 1) {
            e2 = m;
        } else if (this.a == 2) {
            e2 = l;
        }
        Rect rect = h;
        Rect rect2 = i;
        rect2.left = n4;
        rect2.top = n5;
        rect2.c = n4 + n6;
        rect2.d = n5 + n7;
        int n8 = (int)this.posX;
        int n9 = (int)this.posY;
        int n10 = n6 >> 1;
        int n11 = n7 >> 1;
        float f3 = (n8 -= n2) - n10;
        float f4 = (n9 -= n3) - n11;
        float f5 = n8 + n10;
        float f6 = n9 + n11;
        rect.left = (int)(f3 * f2);
        rect.top = (int)(f4 * f2);
        rect.c = (int)(f5 * f2);
        rect.d = (int)(f6 * f2);
        y2.b(e2, rect2, rect, j);
    }

    private void d() {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        l2.bL.a(this);
    }

    @Override
    public void e(float f2) {
    }

    @Override
    public void a(float f2, boolean bl2) {
    }

    @Override
    public void d(float f2) {
    }

    @Override
    public void a(float f2) {
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.posX);
        as2.a(this.posY);
        as2.a(this.a);
        as2.a(this.b);
        as2.a(this.c);
        as2.a(this.d);
        as2.a(this.e);
        as2.a(this.f);
        super.a(as2);
    }

    @Override
    public void a(GameInputStream k2) throws IOException {
        this.posX = k2.g();
        this.posY = k2.g();
        this.a = k2.readInt();
        this.b = k2.readInt();
        this.c = k2.readInt();
        this.d = k2.readInt();
        if (k2.b() >= 87) {
            this.e = (m)k2.b(m.class);
            this.f = k2.readInt();
        } else {
            m m2 = this.e = this.a == 2 ? com.corrodinggames.rts.game.m.b : com.corrodinggames.rts.game.m.a;
            if (this.a == 2) {
                this.c = l.m();
                this.d = l.l();
            }
        }
        try {
            super.a(k2);
        } catch (IOException e) {
        }
    }
}

