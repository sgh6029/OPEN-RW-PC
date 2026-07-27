/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.bc;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.utility.m;
import com.corrodinggames.rts.gameFramework.utility.x;

import android.graphics.RectF;

import com.corrodinggames.rts.gameFramework.GGameObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;


import org.w3c.dom.Element;

public class MapObject {
    public int a;
    public String b;
    public String c;
    public String d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    private String p;
    public RectF j;
    public int k = -1;
    public Tileset l;
    public int m = -1;
    public Properties n;
    public m o = new m();

    static float a(Element element, String string2) throws MapLoadException {
        String string3 = element.getAttribute(string2);
        try {
            return Float.parseFloat(string3);
        }
        catch (NumberFormatException numberFormatException) {
            throw new MapLoadException("Invalid map: Error reading '" + string2 + "' invalid float: " + string3, numberFormatException);
        }
    }

    public MapObject(Element element, TileMap b2, MapObjectLayer i2) throws MapLoadException {
        String string2;
        String string3;
        org.w3c.dom.NodeList object = null;//old : object
        Element element2;
        Element element3;
        this.b = element.getAttribute("name");
        if (this.b != null) {
            this.c = this.b.trim().toLowerCase(Locale.ENGLISH);
        }
        this.d = element.getAttribute("type");
        this.e = Float.parseFloat(element.getAttribute("x"));
        this.f = Float.parseFloat(element.getAttribute("y"));
        if (element.hasAttribute("rotation")) {
            this.i = Float.parseFloat(element.getAttribute("rotation")) - 90.0f;
        }
        if (!element.getAttribute("width").equals("")) {
            this.g = com.corrodinggames.rts.game.b.MapObject.a(element, "width");
        }
        if (!element.getAttribute("height").equals("")) {
            this.h = com.corrodinggames.rts.game.b.MapObject.a(element, "height");
        }
        if ((element3 = (Element)element.getElementsByTagName("image").item(0)) != null) {
            this.p = element3.getAttribute("source");
        }
        if ((element2 = (Element)element.getElementsByTagName("properties").item(0)) != null && (object = element2.getElementsByTagName("property")) != null) {
            this.n = new Properties();
            for (int i3 = 0; i3 < object.getLength(); ++i3) {
                Element element4 = (Element)object.item(i3);
                string3 = element4.getAttribute("name");
                string2 = "";
                string2 = element4.hasAttribute("value") ? element4.getAttribute("value") : element4.getTextContent();
                this.n.setProperty(string3, string2);
            }
        }
        if (element.hasAttribute("gid")) {
            this.k = Integer.parseInt(element.getAttribute("gid"));
            this.l = b2.a(this.k);
            if (this.l != null) {
                this.l.p = true;
                this.l.r = true;
                this.m = this.k - this.l.l;
            } else {
                throw new RuntimeException("Unable to decode base 64 block, could not find tileId:" + this.k);
            }
        }
        Properties properties = this.n;
        this.j = new RectF(this.e, this.f, this.e + this.g, this.f + this.h);
        b2.a(this.j);
        this.e = this.j.left;
        this.f = this.j.b;
        this.g = this.j.b();
        this.h = this.j.c();
        float f2 = this.j.d();
        float f3 = this.j.e();
        string3 = element.getAttribute("type");
        if (!(string3 == null || string3.equals("") || string3.equals("unit") || string3.equals("comment") || i2.b.equalsIgnoreCase("triggers"))) {
            this.d("Triggers should be on triggers layer");
        }
        if (properties != null) {
            string2 = properties.getProperty("unit");
            String string4 = properties.getProperty("customUnit");
            if (string2 != null || string4 != null) {
                BaseUnit am2;
                String string5 = properties.getProperty("team");
                PlayerTeam n2 = null;
                if (string5 == null) {
                    throw new MapLoadException("Unit object team missing for:" + (string2 != null ? string2 : string4));
                }
                if ("none".equalsIgnoreCase(string5)) {
                    n2 = com.corrodinggames.rts.game.PlayerTeam.k(-1);
                } else {
                    int n3;
                    try {
                        n3 = Integer.valueOf(string5);
                    }
                    catch (NumberFormatException numberFormatException) {
                        throw new MapLoadException("Unit object team invalid: " + numberFormatException.getMessage(), numberFormatException);
                    }
                    n2 = com.corrodinggames.rts.game.PlayerTeam.k(n3);
                    if (n2 == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("map", "Unit object without team:" + string2 + " (skipping unit)");
                        return;
                    }
                    if (n2.b()) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("map", "Unit team is marked as spectator:" + string2 + " (skipping unit)");
                        return;
                    }
                }
                if (string4 != null) {
                    com.corrodinggames.rts.game.units.custom.l l2 = com.corrodinggames.rts.game.units.custom.l.n(string4);
                    if (l2 == null) {
                        throw new MapLoadException("Could not find custom unit of:" + string4 + " at x:" + this.e + ", y:" + this.f);
                    }
                    UnitType as2 = com.corrodinggames.rts.game.units.custom.l.c(l2);
                    if (as2 != null) {
                        if (as2 instanceof com.corrodinggames.rts.game.units.custom.l) {
                            l2 = (com.corrodinggames.rts.game.units.custom.l)as2;
                        } else {
                            com.corrodinggames.rts.gameFramework.GameEngine.b("replacement not a custom unit:" + as2.i());
                        }
                    }
                    if ((am2 = com.corrodinggames.rts.game.units.custom.l.a(false, l2)) == null) {
                        throw new RuntimeException("Metadata unit is null for:" + string4);
                    }
                } else {
                    am2 = null;
                    UnitType as3 = UnitTypeEnum.a(string2);
                    if (as3 != null) {
                        am2 = as3.createUnitInstance();
                    } else {
                        throw new MapLoadException("Could not find unit type of:" + string2 + " at x:" + this.e + ", y:" + this.f);
                    }
                }
                am2.posX = f2;
                am2.posY = f3;
                if (!am2.bI()) {
                    am2.h(this.i);
                }
                if (n2 == null) {
                    throw new MapLoadException("team is null:" + string2);
                }
                am2.b(n2);
                if (properties.getProperty("type") != null) {
                    am2.a_(properties.getProperty("type"));
                }
                if (properties.getProperty("randomRotate") != null && !am2.bI()) {
                    am2.h(com.corrodinggames.rts.gameFramework.GameUtils.a(am2, -180, 180));
                }
                am2.bO = "builder".equalsIgnoreCase(string2) || "builder".equalsIgnoreCase(string4);
                am2.bP = "commandCenter".equalsIgnoreCase(string2) || "commandCenter".equalsIgnoreCase(string4);
                am2.bM = true;
                am2.n();
                com.corrodinggames.rts.game.PlayerTeam.c(am2);
                GGameObject.dL();
            }
        }
    }

    public boolean a(BaseUnit am2) {
        return this.j.b((int)am2.posX, (int)am2.posY);
    }

    public void a(String string2) {
        if (!this.o.contains(string2)) {
            this.o.add(string2);
        }
    }

    public String[] a() {
        if (this.n == null) {
            return x.h;
        }
        m m2 = new m();
        Enumeration<?> enumeration = this.n.propertyNames();
        while (enumeration.hasMoreElements()) {
            String string2 = (String)enumeration.nextElement();
            if (this.o.contains(string2)) continue;
            m2.add(string2);
        }
        return (String[])m2.toArray(x.h);
    }

    public String b(String string2) {
        this.a(string2);
        if (this.n == null) {
            return null;
        }
        return this.n.getProperty(string2);
    }

    public String a(String string2, String string3) {
        this.a(string2);
        if (this.n == null) {
            return null;
        }
        return this.n.getProperty(string2, string3);
    }

    public Integer c(String string2) throws MapLoadException {
        String string3 = this.a(string2, (String)null);
        if (string3 == null) {
            return null;
        }
        try {
            return Integer.parseInt(string3);
        }
        catch (NumberFormatException numberFormatException) {
            throw new MapLoadException(string2 + ": Unexpected integer value:'" + string3 + "'");
        }
    }

   public bb a(String var1, bb var2) {
      String var3 = this.a((String)var1, (String)null);
      if (var3 == null) {
         return var2;
      } else {
         ArrayList var4 = new ArrayList();
         bc var5 = new bc((String)null, var3);
         var4.add(var5);
         String var6 = var1 + "_";
         m var7 = new m();
         Iterator var8 = this.n.keySet().iterator();

         String var10;
         while(var8.hasNext()) {
            Object var9 = var8.next();
            if (var9 instanceof String) {
               var10 = (String)var9;
               if (var10.startsWith(var6)) {
                  var7.add(var10);
               }
            } else {
               com.corrodinggames.rts.gameFramework.GameEngine.b("createLocaleStringFromProperty: Non string:" + var9);
            }
         }

         var8 = (Iterator) var7.iterator();

         while(var8.hasNext()) {
            String var14 = (String)var8.next();
            var10 = var14.substring(var6.length());
            var10 = var10.toLowerCase(Locale.ROOT);
            com.corrodinggames.rts.gameFramework.GameEngine.b("createLocaleStringFromProperty checking: " + var14);
            if (var10.length() <= 4) {
               String var11 = this.b(var14);
               com.corrodinggames.rts.gameFramework.GameEngine.b("createLocaleStringFromProperty got: " + var11);
               com.corrodinggames.rts.gameFramework.GameEngine.b("createLocaleStringFromProperty code: " + var10);
               bc var12 = new bc(var10, var11);
               var4.add(var12);
            }
         }

         bc[] var13 = (bc[])var4.toArray(new bc[0]);
         bb var15 = new bb(var13);
         var15.b();
         com.corrodinggames.rts.gameFramework.GameEngine.b("createLocaleStringFromProperty final: " + var15.b());
         com.corrodinggames.rts.gameFramework.GameEngine.b("createLocaleStringFromProperty locate: " + com.corrodinggames.rts.gameFramework.h.a.c());
         return var15;
      }
   }

    public void d(String string2) {
        NetworkEngine.g("(Map trigger: " + this.b + ", type:" + this.d + "): " + string2);
    }

    public String b() {
        return "(Map trigger: " + this.b + ", type:" + this.d + ")";
    }
}
