/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL20
 */
package com.corrodinggames.rts.java;

import android.graphics.PorterDuff;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;


import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.aa;
import com.corrodinggames.rts.gameFramework.m.ShaderProgram;
import com.corrodinggames.rts.gameFramework.m.ShaderUniform;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.v;
import com.corrodinggames.rts.gameFramework.m.w;
import com.corrodinggames.rts.gameFramework.m.y;
import com.corrodinggames.rts.gameFramework.AssetType;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.gameFramework.utility.m;
import com.corrodinggames.rts.java.Main;
import com.corrodinggames.rts.java.SlickTextureWrapper;
import com.corrodinggames.rts.java.FontKey;
import com.corrodinggames.rts.java.GraphicsTransform;
import com.corrodinggames.rts.java.SlickTexture;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.GlyphPage;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.ImageIOImageData;
import org.newdawn.slick.opengl.PNGImageData;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.FastTrig;
import org.newdawn.slick.util.ResourceLoader;

public final class SlickGraphicsEngine
implements y {
    public boolean a = true;
    public boolean b;
    public static final org.newdawn.slick.Color c = new org.newdawn.slick.Color(0, 0, 0, 255);
    public static final org.newdawn.slick.Color d = new org.newdawn.slick.Color(0, 0, 0, 255);
    public static final org.newdawn.slick.Color e = new org.newdawn.slick.Color(0, 0, 0, 255);
    public Graphics f;
    public com.corrodinggames.rts.gameFramework.m.Texture_M g;
    public int h;
    public int i;
    public com.corrodinggames.rts.gameFramework.m.f j;
    public static Graphics k = null;
    static SlickGraphicsEngine l = null;
    public static ShaderProgram m = null;
    private static SGL W = Renderer.get();
    final Rect n = new Rect();
    final Rect o = new Rect();
    final RectF p = new RectF();
    final PointF q = new PointF();
    public static SlickTextureWrapper r;
    public static SlickTextureWrapper s;
    public static SlickTextureWrapper t;
    ArrayList<FontKey> u = new ArrayList<FontKey>();
    int v = -1;
    Paint w = null;
    SlickTexture x = null;
    boolean y;
    final Paint z = new Paint();
    public static final org.newdawn.slick.Color A;
    static float B;
    FontKey C = new FontKey(this);
    byte[] D = new byte[4];
    static ArrayList<SlickTexture> E;
    int F = 0;
    RectF G = new RectF();
    static Paint H;
    static Paint I;
    static RectF J;
    static RectF K;
    public float L = 1.0f;
    static RectF M;
    FloatBuffer N = BufferUtils.createFloatBuffer((int)3);
    float[] O = new float[0];
    int P = -1;
    float Q;
    float R;
    float S;
    private static LineStripRenderer X;
    GraphicsTransform T = new GraphicsTransform();
    m U = new m();
    m V = new m();

    public static void c() {
        W = Renderer.get();
    }

    public org.newdawn.slick.Color t() {
        return c;
    }

    public SlickGraphicsEngine c(com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        SlickGraphicsEngine e3 = this.d(e2);
        e3.j = this.j;
        return e3;
    }

    public SlickGraphicsEngine d(com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        SlickGraphicsEngine e3 = new SlickGraphicsEngine();
        SlickTexture s2 = this.e(e2);
        try {
            e3.f = s2.C().getGraphics();
            e3.g = e2;
            if (e2 != null) {
                e3.h = e2.m();
                e3.i = e2.l();
            }
        }
        catch (SlickException slickException) {
            throw new RuntimeException(slickException);
        }
        return e3;
    }

    @Override
    public int m() {
        if (this.g != null) {
            return this.h;
        }
        GameEngine l2 = GameEngine.getInstance();
        return (int)l2.cl;
    }

    @Override
    public int n() {
        if (this.g != null) {
            return this.i;
        }
        GameEngine l2 = GameEngine.getInstance();
        return (int)l2.cm;
    }

    @Override
    public void a(int n2, int n3) {
        this.h = n2;
        this.i = n3;
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public void a(Context context) {
    }

    @Override
    public void b() {
        r = new SlickTextureWrapper((SlickTexture)this.a(com.corrodinggames.rts.R.drawable.error_outmem));
        r.a("Out of memory");
        s = new SlickTextureWrapper((SlickTexture)this.a(com.corrodinggames.rts.R.drawable.error_general));
        s.a("General Error");
        t = new SlickTextureWrapper((SlickTexture)this.a(com.corrodinggames.rts.R.drawable.error_toolargethumb));
        s.a("Too Large Thumbnail Error");
        if (!com.corrodinggames.rts.gameFramework.GameEngine.isDemoVersionStatic) {
            this.j = new com.corrodinggames.rts.gameFramework.m.f(1024, 1024);
        }
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.l d() {
        return null;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.l l2) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.AndroidGLRenderer a2) {
    }

    public static boolean a(String string2) {
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            int n2 = string2.codePointAt(i2);
            if (n2 <= 255) continue;
            return true;
        }
        return false;
    }

    Font a(FontKey f2, String string2, boolean bl2) {
        int n2;
        FontKey f3 = this.a(f2, bl2);
        if (f3.a(string2)) {
            return f3.d;
        }
        UnicodeFont unicodeFont = (UnicodeFont)f3.d;
        int n3 = 0;
        for (Object e2 : unicodeFont.getGlyphPages()) {
            GlyphPage glyphPage = (GlyphPage)e2;
            n3 += glyphPage.getGlyphs().size();
        }
        for (n2 = 0; n2 < string2.length(); ++n2) {
            char c2 = string2.charAt(n2);
            boolean bl3 = false;
            if (bl3) continue;
        }
        n2 = unicodeFont.getGlyphPages().size();
        unicodeFont.addGlyphs(string2);
        try {
            unicodeFont.loadGlyphs();
        }
        catch (SlickException slickException) {
            throw new RuntimeException(slickException);
        }
        int n4 = 0;
        for (Object e3 : unicodeFont.getGlyphPages()) {
            GlyphPage glyphPage = (GlyphPage)e3;
            n4 += glyphPage.getGlyphs().size();
        }
        int n5 = unicodeFont.getGlyphPages().size();
        if (n3 != n4) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("new glypth, " + n4 + " " + f3.toString() + " for text:" + string2);
        }
        f3.b(string2);
        return f3.d;
    }

    FontKey a(FontKey f2, boolean bl2) {
        java.awt.Font font;
        Object object;
        for (FontKey f3 : this.u) {
            if (f3.a != f2.a || f3.b != f2.b || f3.c != f2.c) continue;
            return f3;
        }
        f2 = f2.a();
        com.corrodinggames.rts.gameFramework.GameEngine.log("New font:" + f2.a + " bold:" + f2.b);
        if (bl2) {
            // empty if block
        }
        Object object2 = "font/Roboto-Regular.ttf";
        if (f2.b) {
            object2 = "font/Roboto-Bold.ttf";
        }
        if (f2.c) {
            object2 = "font/DroidSansFallback.ttf";
        }
        boolean bl3 = false;
        try {
            object = ResourceLoader.getResourceAsStream((String)object2);
            font = java.awt.Font.createFont(0, (InputStream)object);
            font = font.deriveFont((float)f2.a);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        catch (FontFormatException fontFormatException) {
            throw new RuntimeException(fontFormatException);
        }
        object = new UnicodeFont(font);
        ((UnicodeFont)object).addAsciiGlyphs();
        java.awt.Color color2 = new java.awt.Color(255, 255, 255);
        ((UnicodeFont)object).getEffects().add(new ColorEffect(color2));
        try {
            ((UnicodeFont)object).loadGlyphs();
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.GameEngine.a(com.corrodinggames.rts.gameFramework.AssetType.gameImage, (Throwable)outOfMemoryError);
        }
        catch (SlickException slickException) {
            throw new RuntimeException(slickException);
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("loadGlyphs");
        f2.d = (Font) object;
        this.u.add(f2);
        return f2;
    }

    public void a(Paint paint, String string2) throws IOException {
        this.a(paint, true, string2, null, null);
    }

    public void b(Paint paint) throws IOException {
        this.a(paint, false, null, null, null);
    }

    public void a(Paint paint, SlickTexture s2, com.corrodinggames.rts.gameFramework.m.Texture_M e2) throws IOException {
        this.a(paint, false, null, s2, e2);
    }

    public void u() {
        this.y();
        Graphics.setCurrent(this.f);
        this.b(true);
        this.b = true;
        B = -1.0f;
        org.newdawn.slick.Color.setRebindRequired();
        this.w = this.z;
        l = this;
    }



   public void a(Paint var1, boolean var2, String var3, SlickTexture var4, com.corrodinggames.rts.gameFramework.m.Texture_M var5) throws IOException {
      boolean var6 = false;
      if (k != this.f) {
         this.u();
         var6 = true;
         k = this.f;
      }

      boolean var8;
      if ((var1 == null || var1 instanceof ag) && this.w == var1 && this.x == var4 && !var2) {
         ShaderProgram var7 = null;
         if (this.a) {
            if (var1 != null && var1 instanceof ag) {
               var7 = ((ag)var1).q();
            }

            if (var5 != null && var7 == null) {
               var7 = var5.B();
            }
         }

         if (m == var7) {
            if (m != null) {
               var8 = m.a(var1, var5);
               if (var8) {
                  this.f.flushBuffer();
                  this.b(m);
               }
            }

            return;
         }
      }

      this.w = var1;
      this.x = var4;
      boolean var13 = var4 == null && !var2;
      if (this.v != Graphics.MODE_NORMAL) {
         this.v = Graphics.MODE_NORMAL;
         this.f.setDrawMode(this.v);
      }

      if (var6 && this.g != null) {
         W.glEnable(3042);
         W.glColorMask(true, true, true, true);
         GL14.glBlendFuncSeparate(770, 771, 770, 1);
      }

      if (var1 == null) {
         var8 = false;
         this.a(org.newdawn.slick.Color.white);
         if (var13) {
            this.a(1.0F);
         }

         if (var2) {
            this.f.resetFont();
         }
      } else {
         var8 = var1.c();
      }

      if (this.a) {
         ShaderProgram var9 = null;
         if (var1 != null && var1 instanceof ag) {
            var9 = ((ag)var1).q();
         }

         if (var5 != null && var9 == null) {
            var9 = var5.B();
         }

         boolean var10;
         if (m != var9) {
            this.f.flushBuffer();
            if (var9 == null) {
               this.v();
            } else {
               var9.f();
               var10 = this.c(var9);
               if (!var10) {
                  if (m != null) {
                     this.v();
                  }
               } else {
                  var9.a(var1, var5);
                  this.b(var9);
               }
            }

            m = var9;
         } else if (m != null) {
            var10 = m.a(var1, var5);
            if (var10) {
               this.f.flushBuffer();
               this.b(m);
            }
         }
      }

      boolean var14;
      if (var4 != null) {
         var14 = var4.E == 1;
         if (var14 != var8) {
            this.f.flushBuffer();
            int var15 = var8 ? 1 : 2;
            var4.C().setFilter(var15);
            var4.E = var15;
         }
      }

      if (var1 != null) {
         var14 = true;
         ColorFilter var16 = var1.h();
         if (var16 != null) {
            if (var16 instanceof LightingColorFilter) {
               LightingColorFilter var11 = (LightingColorFilter)var16;
               if (var11.a != 0 && var11.a != -1) {
                  int var12 = var11.a;
                  d.r = (float)android.graphics.Color.b(var12) * 0.003921569F;
                  d.g = (float)android.graphics.Color.c(var12) * 0.003921569F;
                  d.b = (float)android.graphics.Color.d(var12) * 0.003921569F;
                  d.a = (float)android.graphics.Color.a(var12) * 0.003921569F;
                  a(var1.e(), e);
                  org.newdawn.slick.Color var10000 = d;
                  var10000.r *= e.r;
                  var10000 = d;
                  var10000.g *= e.g;
                  var10000 = d;
                  var10000.b *= e.b;
                  var10000 = d;
                  var10000.a *= e.a;
                  this.a(d);
                  this.v = Graphics.MODE_ADD;
                  this.f.setDrawMode(this.v);
                  W.glEnable(3042);
                  W.glColorMask(true, true, true, true);
                  W.glBlendFunc(770, 1);
                  var14 = false;
               }
            } else if (var16 instanceof v) {
               v var17 = (v)var16;
               if (var17.a == com.corrodinggames.rts.gameFramework.m.w.b) {
                  this.f(var1.e());
                  this.v = 99;
                  W.glEnable(3042);
                  W.glColorMask(true, true, true, true);
                  W.glBlendFunc(1, 1);
                  var14 = false;
               } else if (var17.a == com.corrodinggames.rts.gameFramework.m.w.c) {
                  this.f(var1.e());
                  this.v = 99;
                  W.glEnable(3042);
                  W.glColorMask(true, true, true, true);
                  W.glBlendFunc(774, 771);
                  var14 = false;
               }
            }
         }

         if (var14) {
            this.f(var1.e());
         }

         if (var13) {
            if (var1.g() != 0.0F) {
               this.a(var1.g());
            } else {
               this.a(1.0F);
            }
         }

         if (var2) {
            Font var18 = this.a(var1, var3, true);
            this.f.setFont(var18);
         }
      }

   }

    public void v() {
        GL20.glUseProgram((int)0);
    }

    public void b(ShaderProgram ae2) {
        for (ShaderUniform af2 : ae2.p) {
            int n2;
            if (!af2.c) continue;
            af2.c = false;
            if (af2.b == -1) {
                af2.b = GL20.glGetUniformLocation((int)ae2.n, (CharSequence)af2.a);
                if (af2.b == -1 && !af2.d) {
                    af2.d = true;
                    ae2.b("Unknown parameter: " + af2.a);
                    int n3 = GL20.glGetProgrami((int)ae2.n, (int)35718);
                    int n4 = GL20.glGetProgrami((int)ae2.n, (int)35719);
                    for (n2 = 0; n2 < n3; ++n2) {
                        String string2 = GL20.glGetActiveUniform((int)ae2.n, (int)n2, (int)n4);
                        ae2.b("Possible parameter: " + string2);
                    }
                    return;
                }
            }
            if (af2.f != null) {
                SlickTexture s2 = this.e(af2.f);
                Texture texture = s2.C().getTexture();
                if (af2.g) {
                    GL20.glUniform2f((int)af2.b, (float)texture.getTextureWidth(), (float)texture.getTextureHeight());
                    continue;
                }
                n2 = texture.getTextureID();
                ae2.b("Updating texture to:" + n2);
                GL20.glUniform1i((int)af2.b, (int)1);
                GL13.glActiveTexture((int)33985);
                GL11.glBindTexture((int)3553, (int)n2);
                GL13.glActiveTexture((int)33984);
                continue;
            }
            if (af2.e.length == 1) {
                GL20.glUniform1f((int)af2.b, (float)af2.e[0]);
                continue;
            }
            if (af2.e.length == 2) {
                GL20.glUniform2f((int)af2.b, (float)af2.e[0], (float)af2.e[1]);
                continue;
            }
            if (af2.e.length == 4) {
                GL20.glUniform4f((int)af2.b, (float)af2.e[0], (float)af2.e[1], (float)af2.e[2], (float)af2.e[3]);
                continue;
            }
            ae2.b("Unhandled parameter size: " + af2.a + " - " + af2.e.length);
        }
    }

    public boolean c(ShaderProgram ae2) {
        if (ae2.o != 0) {
            return false;
        }
        if (ae2.n != 0 && !ae2.m) {
            GL20.glUseProgram((int)ae2.n);
            return true;
        }
        ae2.m = false;
        ae2.b("Compiling shader");
        ae2.g = this.a(ae2, 35633, ae2.e);
        ae2.h = this.a(ae2, 35632, ae2.f);
        if (ae2.o != 0) {
            return false;
        }
        ae2.n = GL20.glCreateProgram();
        if (ae2.n == 0) {
            ae2.c("could not create program; check ShaderProgram.isSupported()");
            return false;
        }
        GL20.glAttachShader((int)ae2.n, (int)ae2.g);
        GL20.glAttachShader((int)ae2.n, (int)ae2.h);
        GL20.glLinkProgram((int)ae2.n);
        int n2 = GL20.glGetProgrami((int)ae2.n, (int)35714);
        int n3 = GL20.glGetProgrami((int)ae2.n, (int)35716);
        String string2 = GL20.glGetProgramInfoLog((int)ae2.n, (int)n3);
        if (string2 != null && string2.length() != 0) {
            ae2.d = string2 + "\n" + ae2.d;
        }
        if (ae2.d != null) {
            ae2.d = ae2.d.trim();
        }
        if (n2 == 0) {
            ae2.c(ae2.d.length() != 0 ? ae2.d : "Could not link program");
            return false;
        }
        GL20.glUseProgram((int)ae2.n);
        return true;
    }

    protected int a(ShaderProgram ae2, int n2, String string2) {
        int n3 = GL20.glCreateShader((int)n2);
        if (n3 == 0) {
            ae2.c("could not create shader object; check ShaderProgram.isSupported()");
        }
        GL20.glShaderSource((int)n3, (CharSequence)string2);
        GL20.glCompileShader((int)n3);
        int n4 = GL20.glGetShaderi((int)n3, (int)35713);
        int n5 = GL20.glGetShaderi((int)n3, (int)35716);
        String string3 = this.e(n2);
        String string4 = GL20.glGetShaderInfoLog((int)n3, (int)n5);
        if (string4 != null && string4.length() != 0) {
            ae2.d = ae2.d + string3 + " compile log:\n" + string4 + "\n";
        }
        if (n4 == 0) {
            ae2.c(ae2.d.length() != 0 ? ae2.d : "Could not compile " + this.e(n2));
        }
        return n3;
    }

    private String e(int n2) {
        if (n2 == 35632) {
            return "FRAGMENT_SHADER";
        }
        if (n2 == 35633) {
            return "VERTEX_SHADER";
        }
        return "shader";
    }

    private void f(int n2) {
        com.corrodinggames.rts.java.SlickGraphicsEngine.a(n2, A);
        this.a(A);
    }

    private void a(org.newdawn.slick.Color color2) {
        org.newdawn.slick.Color color3 = c;
        if (this.b) {
            this.b = false;
        } else if (color3.r == color2.r && color3.g == color2.g && color3.b == color2.b && color3.a == color2.a) {
            return;
        }
        color3.a = color2.a;
        color3.r = color2.r;
        color3.g = color2.g;
        color3.b = color2.b;
        this.f.setColor(color3);
    }

    public void a(float f2) {
        if (B != f2) {
            B = f2;
            this.f.setLineWidth(f2);
        }
    }

    public Font a(Paint paint, String string2, boolean bl2) {
        FontKey f2 = this.C;
        f2.a = (int)paint.k();
        if (this.x()) {
            f2.a = (int)((float)f2.a * this.L);
        }
        Typeface typeface = paint.i();
        f2.b = false;
        if (typeface != null) {
            f2.b = typeface.a();
        }
        f2.c = false;
        boolean bl3 = com.corrodinggames.rts.java.SlickGraphicsEngine.a(string2);
        if (bl3) {
            f2.c = true;
        }
        Font font = this.a(f2, string2, bl2);
        return font;
    }

    public static void a(ImageData imageData, ByteBuffer byteBuffer, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9 = (n2 + n3 * imageData.getTexWidth()) * n8;
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            byteBuffer.put(n9, (byte)n6);
            byteBuffer.put(n9 + 1, (byte)n5);
            byteBuffer.put(n9 + 2, (byte)n4);
            byteBuffer.put(n9 + 3, (byte)n7);
        } else {
            byteBuffer.put(n9, (byte)n4);
            byteBuffer.put(n9 + 1, (byte)n5);
            byteBuffer.put(n9 + 2, (byte)n6);
            byteBuffer.put(n9 + 3, (byte)n7);
        }
    }

    public static int a(ImageData imageData, ByteBuffer byteBuffer, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8 = (n2 + n3 * imageData.getTexWidth()) * n4;
        if (n4 == 4) {
            // empty if block
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            n7 = byteBuffer.get(n8) & 0xFF;
            n6 = byteBuffer.get(n8 + 1) & 0xFF;
            n5 = byteBuffer.get(n8 + 2) & 0xFF;
        } else {
            n5 = byteBuffer.get(n8) & 0xFF;
            n6 = byteBuffer.get(n8 + 1) & 0xFF;
            n7 = byteBuffer.get(n8 + 2) & 0xFF;
        }
        int n9 = n4 < 4 ? 255 : byteBuffer.get(n8 + 3) & 0xFF;
        return com.corrodinggames.rts.java.SlickGraphicsEngine.a(n9, n5, n6, n7);
    }

    public static final int a(int n2, int n3, int n4, int n5) {
        return n2 << 24 | n3 << 16 | n4 << 8 | n5;
    }

    public static org.newdawn.slick.Color a(int n2, org.newdawn.slick.Color color2) {
        color2.r = (float)(n2 >> 16 & 0xFF) * 0.003921569f;
        color2.g = (float)(n2 >> 8 & 0xFF) * 0.003921569f;
        color2.b = (float)(n2 & 0xFF) * 0.003921569f;
        color2.a = (float)(n2 >>> 24) * 0.003921569f;
        return color2;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M a(int n2) {
        return this.a(n2, true);
    }

    @Override
    public void e() {
        com.corrodinggames.rts.java.SlickGraphicsEngine.w();
    }

    public static void w() {
        if (E.size() == 0) {
            return;
        }
        for (SlickTexture s2 : E) {
            s2.I();
        }
        E.clear();
    }

    public static void a(SlickTexture s2) {
        E.add(s2);
        if (E.size() > 15) {
            com.corrodinggames.rts.java.SlickGraphicsEngine.w();
        }
    }

    public static SlickTexture b(int n2, boolean bl2) {
        String string2 = com.corrodinggames.rts.gameFramework.GameUtils.f(n2);
        try {
            FileInputStream fileInputStream = new FileInputStream(string2);
            ImageData imageData = com.corrodinggames.rts.java.SlickGraphicsEngine.a(fileInputStream);
            ((InputStream)fileInputStream).close();
            return com.corrodinggames.rts.java.SlickGraphicsEngine.a(imageData, string2);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.GameEngine.a(com.corrodinggames.rts.gameFramework.AssetType.gameImage, (Throwable)outOfMemoryError);
            if (r == null) {
                throw new RuntimeException("outOfMemoryErrorImage==null", outOfMemoryError);
            }
            return r;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M a(int n2, boolean bl2) {
        return com.corrodinggames.rts.java.SlickGraphicsEngine.b(n2, bl2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ImageData a(InputStream inputStream) throws IOException {
        ImageData imageData;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);){
            try {
                bufferedInputStream.mark(Integer.MAX_VALUE);
                PNGImageData pNGImageData = new PNGImageData();
                pNGImageData.loadImage(bufferedInputStream);
                imageData = pNGImageData;
            }
            catch (IOException iOException) {
                bufferedInputStream.reset();
                com.corrodinggames.rts.gameFramework.GameEngine.log("PNG load failed: " + iOException.getMessage());
                com.corrodinggames.rts.gameFramework.GameEngine.log("Attempting load with ImageIO..");
                ImageIOImageData imageIOImageData = new ImageIOImageData();
                ByteBuffer byteBuffer = imageIOImageData.loadImage(bufferedInputStream, false, null);
                imageData = new com.corrodinggames.rts.java.a.SlickImageDataWrapper(imageIOImageData, byteBuffer);
            }
        }
        return imageData;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M a(InputStream inputStream, boolean bl2) {
        try {
            String string2 = null;
            if (inputStream instanceof AssetInputStream) {
                string2 = ((AssetInputStream)inputStream).d();
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.b("loadImage InputStream is not AssetInputStream");
                com.corrodinggames.rts.gameFramework.GameEngine.T();
            }
            ++this.F;
            ImageData imageData = com.corrodinggames.rts.java.SlickGraphicsEngine.a(inputStream);
            return com.corrodinggames.rts.java.SlickGraphicsEngine.a(imageData, string2);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.GameEngine.a(com.corrodinggames.rts.gameFramework.AssetType.gameImage, (Throwable)outOfMemoryError);
            if (r == null) {
                throw new RuntimeException("outOfMemoryErrorImage==null", outOfMemoryError);
            }
            return r;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public static SlickTexture a(ImageData imageData, String string2) {
        SlickTexture s2 = new SlickTexture();
        s2.a(imageData, string2, false);
        com.corrodinggames.rts.java.SlickGraphicsEngine.a(s2);
        return s2;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M a(int n2, int n3, boolean bl2) {
        SlickTexture s2 = new SlickTexture();
        try {
            s2.a(new Image(n2, n3), null);
            com.corrodinggames.rts.java.SlickGraphicsEngine.a(s2);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            com.corrodinggames.rts.gameFramework.GameEngine.a(com.corrodinggames.rts.gameFramework.AssetType.gameImageCreate, (Throwable)outOfMemoryError);
            if (r == null) {
                throw new RuntimeException("outOfMemoryErrorImage==null", outOfMemoryError);
            }
            return r;
        }
        catch (SlickException slickException) {
            throw new RuntimeException(slickException);
        }
        return s2;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M b(int n2, int n3, boolean bl2) {
        return com.corrodinggames.rts.java.SlickGraphicsEngine.a(new ImageBuffer(n2, n3), null);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, float f2, float f3, float f4, Paint paint) throws IOException {
        this.k();
        this.a(f4 + 90.0f, f2, f3);
        this.c(e2, f2 - (float)e2.r, f3 - (float)e2.s, paint);
        this.l();
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, Rect rect, float f2, float f3, float f4, Paint paint) throws IOException {
        this.k();
        this.a(f4, f2, f3);
        this.G.a(f2 - (float)e2.r, f3 - (float)e2.s, e2.p, e2.q);
        this.a(e2, rect, this.G, paint);
        this.l();
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, Rect rect, Rect rect2, Paint paint) throws IOException {
        this.G.a(rect2);
        this.a(e2, rect, this.G, paint);
    }

    @Override
    public void b(com.corrodinggames.rts.gameFramework.m.Texture_M e2, Rect rect, Rect rect2, Paint paint) throws IOException {
        this.G.a(rect2);
        this.a(e2, rect, this.G, paint);
    }

    @Override
    public void a(Rect rect, Paint paint) throws IOException {
        this.G.a(rect);
        this.a(this.G, paint);
    }

    @Override
    public void a(boolean bl2) {
    }

    @Override
    public void f() {
    }

    private final SlickTexture e(com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        SlickTexture s2 = (SlickTexture)e2.c();
        return s2;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, Rect rect, RectF rectF, Paint paint) throws IOException {
        this.a(e2, rectF.left, rectF.b, rectF.c, rectF.d, rect.left, rect.top, rect.c, rect.d, paint);
    }

    private void c(com.corrodinggames.rts.gameFramework.m.Texture_M e2, float f2, float f3, Paint paint) throws IOException {
        float f4 = e2.m();
        float f5 = e2.l();
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = f4;
        float f11 = f5;
        this.a(e2, f2, f3, f6, f7, f8, f9, f10, f11, paint);
    }

    private void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Paint paint) throws IOException {
        com.corrodinggames.rts.gameFramework.m.g g2;
        float f10;
        float f11;
        float f12;
        GraphicsTransform g3 = this.T;
        float f13 = f4 - f2;
        float f14 = f5 - f3;
        if (g3.c != -90.0f) {
            float f15 = f13 / 2.0f;
            float f16 = f14 / 2.0f;
            f12 = f2 + f15 - g3.g;
            f11 = f3 + f16 - g3.h;
            if (f12 != 0.0f || f11 != 0.0f) {
                f10 = 0.01f;
                if (f12 > 0.01f || f11 > 0.01f || f12 < -0.01f || f11 < -0.01f) {
                    PointF pointF = this.q;
                    pointF.x = f12;
                    pointF.b = f11;
                    com.corrodinggames.rts.java.SlickGraphicsEngine.a(g3.c + 180.0f, pointF);
                    float f17 = pointF.x + g3.g - f15;
                    float f18 = pointF.b + g3.h - f16;
                    f4 += f17 - f2;
                    f5 += f18 - f3;
                    f2 = f17;
                    f3 = f18;
                }
            }
        }
        SlickTexture s2 = this.e(e2);
        boolean bl2 = false;
        if (this.j != null && s2.m() < 450 && s2.l() < 100 && (g2 = this.j.a(s2)) != null) {
            bl2 = true;
            s2 = this.e(g2.a);
            if (f6 < 0.0f) {
                f2 += -f6;
                f6 = 0.0f;
            }
            if (f7 < 0.0f) {
                f3 += -f7;
                f7 = 0.0f;
            }
            if (f8 > g2.d) {
                f4 += -(g2.d - f8);
                f8 = g2.d;
            }
            if (f9 > g2.e) {
                f5 += -(g2.e - f9);
                f9 = g2.e;
            }
            f6 += (float)g2.b;
            f8 += (float)g2.b;
            f7 += (float)g2.c;
            f9 += (float)g2.c;
        }
        f12 = f4 - f2;
        f11 = f5 - f3;
        f2 *= g3.d;
        f3 *= g3.e;
        f2 += g3.a;
        f3 += g3.b;
        f10 = (f12 *= g3.d) / 2.0f;
        float f19 = (f11 *= g3.e) / 2.0f;
        this.a(paint, s2, e2);
        Image image = s2.C();
        if (image == null) {
            s2.G();
            throw new RuntimeException("getSlickImage==null");
        }
        this.a(image, f2 + f10, f3 + f19, f12, f11, f6, f7, f8, f9, this.t(), g3.c);
    }

    private void a(Image image, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, org.newdawn.slick.Color color2, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Graphics.setCurrent(this.f);
        image.startUse();
        if (color2 != null) {
            color2.bind();
        }
        float f19 = f4;
        float f20 = f5;
        float f21 = f19 * 0.5f;
        float f22 = f20 * 0.5f;
        float f23 = f8 - f6;
        float f24 = f9 - f7;
        float f25 = image.getTextureWidth() / (float)image.getWidth();
        float f26 = image.getTextureHeight() / (float)image.getHeight();
        float f27 = f6 * f25;
        float f28 = f7 * f26;
        float f29 = f23 * f25;
        float f30 = f24 * f26;
        float f31 = f10 + 90.0f;
        if (f31 == 0.0f) {
            f18 = -f21 + f2;
            f17 = -f22 + f3;
            f16 = f21 + f2;
            f15 = -f22 + f3;
            f14 = -f21 + f2;
            f13 = f22 + f3;
            f12 = f21 + f2;
            f11 = f22 + f3;
        } else {
            float f32 = com.corrodinggames.rts.gameFramework.GameUtils.k(f31);
            float f33 = com.corrodinggames.rts.gameFramework.GameUtils.j(f31);
            float f34 = f21 * f32;
            float f35 = f22 * f32;
            float f36 = f21 * f33;
            float f37 = f22 * f33;
            f18 = -f34 + f37 + f2;
            f17 = -f36 - f35 + f3;
            f16 = f34 + f37 + f2;
            f15 = f36 - f35 + f3;
            f14 = -f34 - f37 + f2;
            f13 = -f36 + f35 + f3;
            f12 = f34 - f37 + f2;
            f11 = f36 + f35 + f3;
        }
        W.glTexCoord2f(f27, f28);
        W.glVertex3f(f18, f17, 0.0f);
        W.glTexCoord2f(f27, f28 + f30);
        W.glVertex3f(f14, f13, 0.0f);
        W.glTexCoord2f(f27 + f29, f28 + f30);
        W.glVertex3f(f12, f11, 0.0f);
        W.glTexCoord2f(f27 + f29, f28);
        W.glVertex3f(f16, f15, 0.0f);
        image.endUse();
        this.f.getColor().bind();
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, float f2, float f3, Paint paint) throws IOException {
        this.b(e2, f2 - e2.t, f3 - e2.u, paint);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, float f2, float f3, Paint paint, float f4, float f5) throws IOException {
        this.k();
        this.b(f2, f3);
        this.a(f5, f5);
        this.a(f4, f2, f3);
        this.c(e2, 0.0f, 0.0f, paint);
        this.l();
    }

    @Override
    public void b(com.corrodinggames.rts.gameFramework.m.Texture_M e2, float f2, float f3, Paint paint) throws IOException {
        this.c(e2, f2, f3, paint);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, Rect rect, Paint paint) {
        this.a(e2, rect, paint, 0, 0, 0, 0);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, Rect rect, Paint paint, int n2, int n3, int n4, int n5) {
        aa.a((y)this, e2, rect, paint, n2, n3, n4, n5);
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, RectF rectF, Paint paint, float f2, float f3, int n2, int n3) {
        aa.a((y)this, e2, rectF, paint, f2, f3, n2, n3);
    }

    @Override
    public void b(int n2) {
        if (l != this) {
            this.u();
        }
        this.b(false);
        this.w = null;
        this.f.setBackground(com.corrodinggames.rts.java.SlickGraphicsEngine.a(n2, e));
        this.f.clear();
    }

    @Override
    public void o() {
        if (l != this) {
            this.u();
        }
        this.w = null;
        this.f.clearAlphaMap();
    }

    @Override
    public void a(int n2, PorterDuff.Mode mode) {
        this.w = null;
        if (mode != PorterDuff.Mode.CLEAR) {
            this.b(n2);
            return;
        }
        this.b(n2);
        this.f.clearAlphaMap();
    }

    @Override
    public void a(String string2, float f2, float f3, Paint paint, Paint paint2, float f4) throws IOException {
        float f5 = this.b(string2, paint);
        J.a(f2, f3, f2 + f5, f3 + (float)this.a(string2, paint));
        com.corrodinggames.rts.gameFramework.GameUtils.a(J, f4);
        K.a(J);
        if (paint.j() == Paint$Align.b) {
            J.a(-(f5 / 2.0f), 0.0f);
        }
        this.a(J, paint2);
        this.a(string2, com.corrodinggames.rts.java.SlickGraphicsEngine.K.left + f4, com.corrodinggames.rts.java.SlickGraphicsEngine.K.d - f4, paint);
    }

    boolean x() {
        if (!com.corrodinggames.rts.gameFramework.GameEngine.getInstance().bQ.resizeFontWithUIScale) {
            return false;
        }
        if (this.L == 1.0f) {
            return false;
        }
        if (this.L < 1.0f) {
            return true;
        }
        return true;
    }

    @Override
    public void a(String string2, float f2, float f3, Paint paint) throws IOException {
        int n2;
        if (this.x()) {
            this.k();
            float f4 = 1.0f / this.L;
            this.a(f4, f4);
            f2 *= this.L;
            f3 *= this.L;
        }
        f2 *= this.T.d;
        f3 *= this.T.e;
        f2 += this.T.a;
        f3 += this.T.b;
        this.a(paint, string2);
        int n3 = 0;
        if (paint.j() == Paint$Align.b) {
            n2 = this.f.getFont().getWidth(string2);
            n3 -= n2 / 2;
        } else if (paint.j() == Paint$Align.c) {
            n2 = this.f.getFont().getWidth(string2);
            n3 -= n2;
        }
        n2 = 0;
        int n4 = this.f.getFont().getLineHeight();
        int n5 = (int)(f2 + (float)n3);
        int n6 = (int)(f3 + (float)(n2 -= n4));
        this.f.drawString(string2, n5, n6);
        if (this.x()) {
            this.l();
        }
    }

    @Override
    public void b(Rect rect, Paint paint) throws IOException {
        this.G.a(rect);
        this.a(this.G, paint);
    }

    @Override
    public void a(RectF rectF, Paint paint) throws IOException {
        this.b(paint);
        if (paint.d() == Paint$Style.a || paint.d() == Paint$Style.c) {
            TextureImpl.bindNone();
            W.glBegin(7);
            float f2 = rectF.left;
            float f3 = rectF.b;
            float f4 = rectF.c;
            float f5 = rectF.d;
            f2 *= this.T.d;
            f3 *= this.T.e;
            f4 *= this.T.d;
            f5 *= this.T.e;
            W.glVertex2f(f2 += this.T.a, f3 += this.T.b);
            W.glVertex2f(f4 += this.T.a, f3);
            W.glVertex2f(f4, f5 += this.T.b);
            W.glVertex2f(f2, f5);
            W.glEnd();
        } else {
            float f6 = rectF.left;
            float f7 = rectF.b;
            float f8 = rectF.b();
            float f9 = rectF.c();
            f6 *= this.T.d;
            f7 *= this.T.e;
            this.f.drawRect(f6 += this.T.a, f7 += this.T.b, f8 *= this.T.d, f9 *= this.T.e);
        }
    }

    @Override
    public void g() {
        this.e();
        M = null;
        if (this.j != null) {
            this.j.c();
        }
    }

    @Override
    public void h() {
        this.y();
        if (this.j != null) {
            this.j.d();
        }
        if (this.a && m != null) {
            this.v();
            m = null;
        }
        this.w = null;
        M = null;
        this.b = true;
        B = -1.0f;
        this.y = false;
    }

    @Override
    public void c(Rect rect, Paint paint) throws IOException {
        this.o.a(rect.left, rect.top, rect.left + rect.c, rect.top + rect.d);
        this.b(this.o, paint);
    }

    @Override
    public void a(Rect rect) {
        if (rect != null) {
            this.T.f = new RectF(rect);
            this.T.f.left *= this.T.d;
            this.T.f.c *= this.T.d;
            this.T.f.b *= this.T.e;
            this.T.f.d *= this.T.e;
            this.T.f.a(this.T.a, this.T.b);
        } else {
            this.T.f = null;
        }
        this.b(false);
    }

    @Override
    public void a(RectF rectF) {
        if (rectF != null) {
            this.T.f = new RectF(rectF);
            this.T.f.left *= this.T.d;
            this.T.f.c *= this.T.d;
            this.T.f.b *= this.T.e;
            this.T.f.d *= this.T.e;
            this.T.f.a(this.T.a, this.T.b);
        } else {
            this.T.f = null;
        }
        this.b(false);
    }

    public void b(boolean bl2) {
        RectF rectF = this.T.f;
        if (M == rectF && !bl2) {
            return;
        }
        this.y();
        if (rectF != null) {
            W.glEnable(3089);
            W.glScissor((int)rectF.left, (int)((float)this.n() * this.L - rectF.d), (int)rectF.b(), (int)rectF.c());
        } else {
            W.glDisable(3089);
        }
        M = rectF;
    }

    @Override
    public void b(float f2, float f3, float f4, Paint paint) throws IOException {
        f2 *= this.T.d;
        f3 *= this.T.e;
        f2 += this.T.a;
        f3 += this.T.b;
        f4 *= this.T.d;
        this.b(paint);
        if (paint.d() == Paint$Style.b) {
            int n2 = 40;
            if (f4 > 100.0f) {
                n2 = 60;
            }
            this.a(f2, f3, f4, n2);
        } else {
            this.f.fillOval(f2 - f4, f3 - f4, f4 * 2.0f, f4 * 2.0f);
        }
    }

    @Override
    public void a(float f2, float f3, float f4, Paint paint) throws IOException {
        float f5 = this.T.d;
        if (f4 * f5 < 25.0f && paint.d() == Paint$Style.b) {
            aa.a(this, f2, f3, f4, paint, f5);
            return;
        }
        this.b(f2, f3, f4, paint);
    }

    public FloatBuffer c(int n2) {
        if (this.N.capacity() < n2) {
            this.N = BufferUtils.createFloatBuffer((int)n2);
        }
        return this.N;
    }

    public FloatBuffer a(float[] fArray, int n2) {
        FloatBuffer floatBuffer = this.c(n2);
        floatBuffer.clear();
        floatBuffer.put(fArray, 0, n2);
        floatBuffer.flip();
        return floatBuffer;
    }

    public float[] d(int n2) {
        if (this.O.length < n2) {
            this.O = new float[n2];
        }
        return this.O;
    }

    @Override
    public void a(float[] fArray, int n2, int n3, Paint paint) throws IOException {
        if (n3 == 0) {
            return;
        }
        boolean bl2 = true;
        if (Main.b) {
            bl2 = false;
        }
        float f2 = paint.g();
        float f3 = 1.0f;
        float f4 = 0.0f;
        if (f2 > 1.0f) {
            f3 += (f2 - 1.0f) * 0.5f;
            f4 += (f2 - 1.0f) * 0.5f;
        }
        float f5 = this.T.d;
        float f6 = this.T.e;
        float f7 = this.T.a;
        float f8 = this.T.b;
        if (bl2) {
            float[] fArray2 = this.d(n3 * 4);
            int n4 = n3 * 4;
            int n5 = 0;
            for (int i2 = 0; i2 < n4; i2 += 8) {
                float f9 = fArray[n5];
                float f10 = fArray[n5 + 1];
                float f11 = f9 - f4;
                float f12 = f9 + f3;
                float f13 = f10 - f4;
                float f14 = f10 + f3;
                fArray2[i2 + 0] = f11;
                fArray2[i2 + 1] = f13;
                fArray2[i2 + 2] = f12;
                fArray2[i2 + 3] = f13;
                fArray2[i2 + 4] = f12;
                fArray2[i2 + 5] = f14;
                fArray2[i2 + 6] = f11;
                fArray2[i2 + 7] = f14;
                n5 += 2;
            }
            this.b(fArray2, 0, n3 * 4, paint);
        } else {
            this.b(paint);
            TextureImpl.bindNone();
            W.glBegin(7);
            int n6 = n2 + n3;
            for (int i3 = n2; i3 < n6; i3 += 2) {
                float f15 = fArray[i3];
                float f16 = fArray[i3 + 1];
                f15 *= f5;
                f16 *= f6;
                float f17 = (f15 += f7) - f4;
                float f18 = f15 + f3;
                float f19 = (f16 += f8) - f4;
                float f20 = f16 + f3;
                W.glVertex2f(f17, f19);
                W.glVertex2f(f18, f19);
                W.glVertex2f(f18, f20);
                W.glVertex2f(f17, f20);
            }
            W.glEnd();
        }
    }

    public void b(float[] fArray, int n2, int n3, Paint paint) throws IOException {
        boolean bl2 = Main.a;
        if (bl2) {
            GL11.glDisableClientState((int)32886);
        }
        this.b(paint);
        TextureImpl.bindNone();
        GL11.glEnableClientState((int)32884);
        FloatBuffer floatBuffer = this.a(fArray, n3);
        GL11.glVertexPointer((int)2, (int)0, (FloatBuffer)floatBuffer);
        GL11.glDrawArrays((int)7, (int)n2, (int)(n3 / 2));
        if (bl2) {
            GL11.glEnableClientState((int)32886);
        }
    }

    public void a(float f2, float f3, float f4, int n2) {
        Graphics.setCurrent(this.f);
        TextureImpl.bindNone();
        if (this.P != n2) {
            this.P = n2;
            this.Q = 6.283185f / (float)n2;
            this.R = (float)FastTrig.cos(this.Q);
            this.S = (float)FastTrig.sin(this.Q);
        }
        float f5 = this.R;
        float f6 = this.S;
        float f7 = f4;
        float f8 = 0.0f;
        boolean bl2 = true;
        X.start();
        ++n2;
        float f9 = f7 + f2;
        float f10 = f8 + f3;
        for (int i2 = 0; i2 < n2; ++i2) {
            X.vertex(f7 + f2, f8 + f3);
            float f11 = f7;
            f7 = f5 * f7 - f6 * f8;
            f8 = f6 * f11 + f5 * f8;
        }
        X.end();
    }

    @Override
    public void i() {
        this.z();
    }

    @Override
    public void j() {
        this.A();
    }

    @Override
    public void k() {
        this.z();
    }

    @Override
    public void l() {
        this.A();
    }

    @Override
    public void a(float f2, float f3, float f4) {
        this.T.c += f2;
        this.T.g = f3;
        this.T.h = f4;
    }

    public static void a(float f2, PointF pointF) {
        float f3 = com.corrodinggames.rts.gameFramework.GameUtils.j(f2);
        float f4 = com.corrodinggames.rts.gameFramework.GameUtils.k(f2);
        float f5 = pointF.x;
        float f6 = pointF.b;
        pointF.x = f4 * f6 - f3 * f5;
        pointF.b = f3 * f6 + f4 * f5;
    }

    @Override
    public void a(float f2, float f3) {
        this.T.d *= f2;
        this.T.e *= f3;
    }

    @Override
    public void a(float f2, float f3, float f4, float f5) {
        this.b(f4, f5);
        this.a(f2, f3);
        this.b(-f4, -f5);
    }

    @Override
    public void b(float f2, float f3) {
        this.T.a += f2 * this.T.d;
        this.T.b += f3 * this.T.e;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.m m2) {
        m2.a(this);
    }

    @Override
    public void a(float f2, float f3, float f4, float f5, Paint paint) throws IOException {
        this.b(paint);
        f2 *= this.T.d;
        f3 *= this.T.e;
        f4 *= this.T.d;
        f5 *= this.T.e;
        this.f.drawLine(f2 += this.T.a, f3 += this.T.b, f4 += this.T.a, f5 += this.T.b);
    }

    @Override
    public void a(Paint paint) {
        this.a(paint, "", false);
    }

    @Override
    public void a(ShaderProgram ae2) {
        if (this.a) {
            this.c(ae2);
            this.v();
            m = null;
        }
    }

    public void y() {
        this.f.flushBuffer();
    }

    @Override
    public void p() {
        this.f.flushBuffer();
        this.w = null;
        this.f.flush();
    }

    @Override
    public void q() {
        if (this.f != null) {
            this.f.destroy();
        }
        this.f = null;
    }

    @Override
    public int a(String string2, Paint paint) throws IOException {
        this.a(paint, string2);
        int n2 = this.f.getFont().getLineHeight();
        if (this.x()) {
            n2 = (int)((float)n2 / this.L);
        }
        return n2;
    }

    @Override
    public int b(String string2, Paint paint) throws IOException {
        this.a(paint, string2);
        int n2 = this.f.getFont().getWidth(string2);
        if (this.x()) {
            n2 = (int)((float)n2 / this.L);
        }
        return n2;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.m.Texture_M r() {
        return r;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.m.Texture_M e2, File file) {
        SlickTexture s2 = this.e(e2);
        boolean bl2 = true;
        String string2 = "png";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ImageOut.write(s2.C(), "png", bufferedOutputStream);
            bufferedOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        catch (SlickException slickException) {
            throw new RuntimeException(slickException);
        }
    }

    @Override
    public void a(Lock lock) {
    }

    @Override
    public void b(Lock lock) {
    }

    public void z() {
        this.U.add(this.T);
        GraphicsTransform g2 = this.V.a == 0 ? new GraphicsTransform() : (GraphicsTransform)this.V.c();
        this.T.a(g2);
        this.T = g2;
    }

    public void A() {
        if (this.U.size() == 0) {
            throw new RuntimeException("tranform stack is empty");
        }
        this.V.add(this.T);
        this.T = (GraphicsTransform)this.U.c();
        this.b(false);
    }

    @Override
    public float s() {
        return this.L;
    }

    @Override
    public /* synthetic */ y a(com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        return this.c(e2);
    }

    @Override
    public /* synthetic */ y b(com.corrodinggames.rts.gameFramework.m.Texture_M e2) {
        return this.d(e2);
    }

    static {
        A = new org.newdawn.slick.Color(0, 0, 0, 255);
        B = -1.0f;
        E = new ArrayList();
        I = new ag();
        H = new Paint();
        H.a(255, 255, 0, 0);
        H.a(Paint$Style.b);
        J = new RectF();
        K = new RectF();
        X = Renderer.getLineStripRenderer();
    }
}
