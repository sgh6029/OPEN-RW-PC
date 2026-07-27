/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.b.i;
import com.corrodinggames.rts.game.units.custom.ba;
import com.corrodinggames.rts.game.units.custom.c_f5;
import com.corrodinggames.rts.game.units.custom.d_f;
import com.corrodinggames.rts.game.units.custom.f_f6;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.m;

public final class e_f1 {
    public f_f6 a;
    float b;
    float c;
    float d = 1.0f;
    boolean e = false;
    boolean f = false;
    boolean g;
    boolean h;
    boolean i;
    int j;
    float k = 0.0f;
    float l = 0.05f;
    j m;
    float[] n;

    public e_f1(j j2) {
        this.m = j2;
    }

    public void a(f_f6 f2, int n2) {
        this.a(f2, n2, false);
    }

    public void a(f_f6 f2, int n2, boolean bl2) {
        if (f2 == null || !f2.a()) {
            return;
        }
        if ((this.i || this.f && this.e) && n2 <= this.j && (!bl2 || f2 != this.a)) {
            return;
        }
        this.i = true;
        if (f2 != this.a || bl2 || this.g) {
            float f3 = 0.0f;
            if (this.a != null && this.e) {
                f3 = this.a.i;
            }
            this.a = f2;
            this.j = n2;
            this.c();
            this.f = bl2;
            this.h = !bl2;
            this.b = -1.0f;
            this.c = -1.0f;
            this.d = 1.0f;
            this.g = false;
            float f4 = f2.h;
            if (f3 > f4) {
                f4 = f3;
            }
            if (f4 > 0.0f) {
                this.k = 1.0f;
                this.l = f4;
            } else {
                this.k = 0.0f;
            }
        }
        this.e = true;
    }

    public void a() {
        if (this.a != null) {
            boolean bl2 = true;
            this.b(bl2);
        }
        this.e = false;
        this.a = null;
        this.j = -1;
    }

    public void b() {
        if (this.a != null) {
            float f2;
            if (!this.g && (f2 = this.a.i) > 0.0f) {
                this.g = true;
                this.c();
                this.h = false;
                this.j = -1;
                this.k = 1.0f;
                this.l = f2;
                return;
            }
            boolean bl2 = true;
            this.b(bl2);
        }
        this.e = false;
        this.a = null;
        this.j = -1;
    }

    public void a(float f2) {
        if (!this.e) {
            return;
        }
        this.c = this.b;
        if (this.b < 0.0f) {
            this.b = 0.0f;
        }
        float f3 = this.d;
        if (this.a != null && this.a.j != null) {
            f3 *= this.a.j.readNumber(this.m);
        }
        this.b += f3 * f2;
        if (this.h && !this.i) {
            this.b();
        }
        this.i = false;
        if (this.e) {
            if (this.k > 0.0f) {
                this.k -= this.l * f2;
            } else if (this.g) {
                this.b();
                return;
            }
            if (!this.g && this.a != null) {
                if (this.a.g) {
                    if (this.b > this.a.n) {
                        this.a(false);
                        this.b = this.a.n;
                        this.d = -1.0f;
                    } else if (this.b < 0.0f) {
                        this.b = 0.0f;
                        this.d = 1.0f;
                        if (this.f) {
                            this.b();
                            if (!this.g) {
                                return;
                            }
                        }
                    }
                } else {
                    if (this.b > this.a.n) {
                        if (this.f) {
                            this.a(false);
                            this.b();
                            if (!this.g) {
                                return;
                            }
                        } else {
                            this.a(false);
                            this.b = 0.0f;
                            this.d = 1.0f;
                        }
                    }
                    if (this.b < 0.0f && !this.f && f3 < 0.0f) {
                        this.b = this.a.n;
                    }
                }
            }
            boolean bl2 = false;
            if (this.g) {
                bl2 = true;
            }
            this.b(bl2);
        }
    }

    void c() {
        m m2 = this.a.l;
        if (m2 == null || m2.size() == 0) {
            this.n = null;
            return;
        }
        if (this.n == null || this.n.length < m2.size()) {
            this.n = new float[m2.size()];
        }
        for (int i2 = 0; i2 < m2.size(); ++i2) {
            i i3;
            c_f5 c2 = (c_f5)m2.get(i2);
            d_f d2 = c2.a;
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.scale) {
                this.n[i2] = this.m.c;
                continue;
            }
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.frame) {
                this.n[i2] = -99.0f;
                continue;
            }
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.legX) {
                if ( c2.b <= 0 ) {
                    //WTFING????
                    continue;
                }
                if (this.m.dT != null && c2.b < this.m.dT.length) {
                    i3 = this.m.dT[c2.b];
                    this.n[i2] = i3.p;
                    continue;
                }
                this.n[i2] = 0.0f;
                com.corrodinggames.rts.gameFramework.GameEngine.b("setBaseBlendValues: Target leg out of range for: " + this.m.dt().i());
                continue;
            }
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.legY) {
                if (this.m.dT == null || c2.b < 0 || c2.b >= this.m.dT.length) continue;
                i3 = this.m.dT[c2.b];
                this.n[i2] = i3.q;
                continue;
            }
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.legDir) {
                if (this.m.dT == null || c2.b < 0 || c2.b >= this.m.dT.length) continue;
                this.n[i2] = this.m.dT[c2.b].r = com.corrodinggames.rts.gameFramework.GameUtils.a(this.m.dT[c2.b].r, false);
                continue;
            }
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.legHeight) {
                if (this.m.dT == null || c2.b < 0 || c2.b >= this.m.dT.length) continue;
                this.n[i2] = this.m.dT[c2.b].d;
                continue;
            }
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.legAlpha) {
                if (this.m.dT == null || c2.b < 0 || c2.b >= this.m.dT.length) continue;
                this.n[i2] = this.m.dT[c2.b].s;
                continue;
            }
            if (d2 == com.corrodinggames.rts.game.units.custom.d_f.event) continue;
            this.n[i2] = 0.0f;
            com.corrodinggames.rts.gameFramework.GameEngine.b("Unsupported blend type:" + (Object)((Object)d2));
        }
    }

    void a(boolean bl2) {
        m m2 = this.a.l;
        for (int i2 = 0; i2 < m2.size(); ++i2) {
            c_f5 c2 = (c_f5)m2.get(i2);
            d_f d2 = c2.a;
            if (d2 != com.corrodinggames.rts.game.units.custom.d_f.event) continue;
            c2.a(this.m, this.c, this.b, bl2);
        }
    }


    void b(boolean var1) {
      m var2 = this.a.l;

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         c_f5 var4 = (c_f5)var2.get(var3);
         d_f var5 = var4.a;
         if (var5 != com.corrodinggames.rts.game.units.custom.d_f.frame || this.m.el || var1) {
            float var6;
            if (var1) {
               var6 = 0.0F;
               if (var5 == com.corrodinggames.rts.game.units.custom.d_f.scale) {
                  var6 = 1.0F;
               } else if (var5 == com.corrodinggames.rts.game.units.custom.d_f.frame) {
                  var6 = (float)this.m.x.Y;
               } else if (var5 == com.corrodinggames.rts.game.units.custom.d_f.legAlpha) {
                  var6 = 1.0F;
                  ba[] var7 = this.m.x.ax;
                  if (var7 != null && var4.b < var7.length) {
                     var6 = var7[var4.b].r;
                  }
               }
            } else {
               var6 = var4.b(this.b);
            }

            if (this.k > 0.0F && var5 != com.corrodinggames.rts.game.units.custom.d_f.frame) {
               if (this.n != null && var3 >= 0 && var3 < this.n.length) {
                  var6 = var6 * (1.0F - this.k) + this.n[var3] * this.k;
               } else {
                  com.corrodinggames.rts.gameFramework.GameEngine.b("Warning: Invalid index access in blend animation: var3=" + var3 + ", n.length=" + (this.n != null ? this.n.length : "null"));
               }
            }

            if (var5 == com.corrodinggames.rts.game.units.custom.d_f.frame) {
               this.m.a = (int)var6;
            } else if (var5 == com.corrodinggames.rts.game.units.custom.d_f.scale) {
               this.m.c = var6;
            } else {
               i var8;
               if (var5 == com.corrodinggames.rts.game.units.custom.d_f.legX) {
                  if (this.m.dT != null && var4.b >= 0 && var4.b < this.m.dT.length) {
                     var8 = this.m.dT[var4.b];
                     var8.p = var6;
                     var8.k = true;
                     var8.o = true;
                  }
               } else if (var5 == com.corrodinggames.rts.game.units.custom.d_f.legY) {
                  if (this.m.dT != null && var4.b >= 0 && var4.b < this.m.dT.length) {
                     var8 = this.m.dT[var4.b];
                     var8.q = var6;
                     var8.k = true;
                     var8.o = true;
                  }
               } else if (var5 == com.corrodinggames.rts.game.units.custom.d_f.legDir) {
                  if (this.m.dT != null && var4.b >= 0 && var4.b < this.m.dT.length) {
                     this.m.dT[var4.b].r = var6;
                  }
               } else if (var5 == com.corrodinggames.rts.game.units.custom.d_f.legHeight) {
                  if (this.m.dT != null && var4.b >= 0 && var4.b < this.m.dT.length) {
                     this.m.dT[var4.b].d = var6;
                  }
               } else if (var5 == com.corrodinggames.rts.game.units.custom.d_f.legAlpha) {
                  i[] var9 = this.m.dT;
                  if (var9 != null && var4.b >= 0 && var4.b < var9.length) {
                     var9[var4.b].s = var6;
                  }
               } else if (var5 != com.corrodinggames.rts.game.units.custom.d_f.turretX && var5 == com.corrodinggames.rts.game.units.custom.d_f.event) {
                  var4.a(this.m, this.c, this.b, var1);
               }
            }
         }
      }

   }
    public boolean a(f_f6 f2) {
        return this.e && this.a == f2;
    }
}
