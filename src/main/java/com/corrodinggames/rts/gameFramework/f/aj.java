package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.Paint;
import android.graphics.Rect;

import java.io.IOException;
import java.util.Iterator;

public class aj {
   m a;
   Rect b;
   Paint c;
   Paint d;

   public void a(float var1, float var2) {
      GameEngine var3 = GameEngine.getInstance();
      int var4 = 0;
      int var5 = 0;
      try {
         var5 = com.corrodinggames.rts.gameFramework.f.d.a(this.c);
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      for(Iterator var6 = this.a.iterator(); var6.hasNext(); ++var4) {
         ak var7 = (ak)var6.next();
         int var8 = 0;
         af var9 = null;
         Iterator var10 = var7.a.iterator();

         while(var10.hasNext()) {
            af var11 = (af)var10.next();
            if (var9 != null) {
               var8 += var9.a(this.c);
            }

            int var12 = (int)(var1 + (float)var8 + (float)this.b.d());
            var12 -= var7.b / 2;
            int var13 = (int)(var2 + (float)this.b.top + (float)(var5 / 2) + (float)(var4 * var5));
            if (!(var11 instanceof ai)) {
               if (var11 instanceof ah) {
                  ah var14 = (ah)var11;
                  Texture_M var15 = var14.a;
                  try {
                     var3.bO.a(var15, (float)var12, (float)var13 - (float)var15.q * var14.b, ae.c, 0.0F, var14.b);
                  } catch (IOException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
               }

               var9 = var11;
            } else {
               ai var16 = (ai)var11;
               Paint var17 = var16.b(this.c);
               try {
                  var3.bO.a(var16.d, (float)var12, (float)var13, var17);
               } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
               var9 = var11;
            }
         }
      }

   }
}
