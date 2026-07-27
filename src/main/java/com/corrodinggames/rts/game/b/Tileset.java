/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.b.MapLayer;
import com.corrodinggames.rts.game.b.MapLoadException;
import com.corrodinggames.rts.game.b.TilesetImageDescriptor;
import com.corrodinggames.rts.gameFramework.GameEngine;

import android.graphics.Rect;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Tileset {
    public String a;
    public com.corrodinggames.rts.gameFramework.m.Texture_M b;
    public String c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    int i = 0;
    int j;
    float k;
    public int l;
    public int m = Integer.MAX_VALUE;
    public short n;
    public TileMap o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    private HashMap x = new HashMap();
    static String t = "[EMBED]";
    static ArrayList u = new ArrayList();
    Rect v = new Rect();
    int w = -1;

    public String a(TileMap b2, Element element) {
        Element element2 = (Element) element.getElementsByTagName("properties").item(0);
        if (element2 != null) {
            NodeList nodeList = element2.getElementsByTagName("property");
            for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
                Element element3 = (Element) nodeList.item(i2);
                String string2 = element3.getAttribute("name");
                if (!string2.equals("embedded_png"))
                    continue;
                String string3 = element3.getAttribute("value");
                if (string3 != null && !string3.equals("")) {
                    return string3;
                }
                Node node = element3.getFirstChild();
                if (node == null)
                    continue;
                String string4 = node.getNodeValue();
                return string4;
            }
        }
        return null;
    }

    public static Element a(TileMap b2, String string2) throws MapLoadException {
        try {
            InputStream inputStream = b2.d("tilesets/", string2);
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            Element element = document.getDocumentElement();
            return element;
        } catch (Exception exception) {
            com.corrodinggames.rts.gameFramework.GameEngine.getInstance()
                    .a("Unable to load or parse sourced tileset: tilesets/" + string2, 1);
            throw new MapLoadException("Unable to load or parse sourced tileset: tilesets/" + string2, exception);
        }
    }

    public Tileset(TileMap b2, String string2, int n2) throws MapLoadException {
        this.o = b2;
        this.l = n2;
        Element element = com.corrodinggames.rts.game.b.Tileset.a(b2, string2);
        this.a = string2;
        this.a(element);
    }

    public Tileset(TileMap b2, Element element) throws MapLoadException {
        this.o = b2;
        this.l = Integer.parseInt(element.getAttribute("firstgid"));
        String string2 = element.getAttribute("source");
        if (string2 != null && !string2.equals("")) {
            GameEngine.log("FuckerFiler: " + string2);// ../../decoration.tsx
            while (true) {
                if (string2.startsWith("../")) {
                    string2 = string2.substring(3);
                }else{
                    break;
                }
            }
            element = com.corrodinggames.rts.game.b.Tileset.a(b2, string2);
            this.a = string2;
        }
        this.a(element);
    }

    public void a(Element element) throws MapLoadException {
        Object object;
        NodeList nodeList = element.getElementsByTagName("image");
        if (nodeList.getLength() > 0) {
            object = (Element) nodeList.item(0);
            String string2 = ((Element) object).getAttribute("source");
            string2 = string2.trim();
            this.c = com.corrodinggames.rts.gameFramework.GameEngine.k(string2);
        }
        if ((object = this.a(this.o, element)) != null) {
            this.c = com.corrodinggames.rts.game.b.Tileset.a((String) object, this.c);
        }
        if (this.c == null) {
            throw new MapLoadException("Map tileset is missing an image tag or embedded image data");
        }
        this.d = this.o.n;
        this.e = this.o.o;
        if (element.hasAttribute("tilewidth")) {
            this.d = Integer.parseInt(element.getAttribute("tilewidth"));
            this.e = Integer.parseInt(element.getAttribute("tileheight"));
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.C()) {
            this.d = this.o.n;
            this.e = this.o.o;
        }
        int n2 = 0;
        if (element.hasAttribute("spacing")) {
            n2 = Integer.parseInt(element.getAttribute("spacing"));
        }
        this.f = this.d + n2;
        this.g = this.e + n2;
        NodeList nodeList2 = element.getElementsByTagName("tile");
        for (int i2 = 0; i2 < nodeList2.getLength(); ++i2) {
            Element element2 = (Element) nodeList2.item(i2);
            int n3 = Integer.parseInt(element2.getAttribute("id"));
            n3 += this.l;
            Properties properties = new Properties();
            Element element3 = (Element) element2.getElementsByTagName("properties").item(0);
            if (element3 != null) {
                NodeList nodeList3 = element3.getElementsByTagName("property");
                for (int i3 = 0; i3 < nodeList3.getLength(); ++i3) {
                    Element element4 = (Element) nodeList3.item(i3);
                    String string3 = element4.getAttribute("name");
                    String string4 = element4.getAttribute("value");
                    if ("unit".equalsIgnoreCase(string3) || "customUnit".equalsIgnoreCase(string3)) {
                        this.s = true;
                    }
                    properties.setProperty(string3, string4);
                }
            }
            this.x.put(new Integer(n3), properties);
        }
    }

    public static String a(String string2, String string3) {
        for (TilesetImageDescriptor k2 : ((ArrayList<TilesetImageDescriptor>) u)) {
            if (!string2.equalsIgnoreCase(k2.embeddedBase64))
                continue;
            return k2.imageKey;
        }
        TilesetImageDescriptor k3 = new TilesetImageDescriptor();
        k3.inUse = false;
        k3.texture = null;
        k3.embeddedBase64 = string2;
        k3.pathPrefix = t;
        k3.imageKey = t + com.corrodinggames.rts.game.b.TilesetImageDescriptor.nextEmbedId;
        k3.originalImageName = string3;
        ++com.corrodinggames.rts.game.b.TilesetImageDescriptor.nextEmbedId;
        u.add(k3);
        return k3.imageKey;
    }

    public static com.corrodinggames.rts.gameFramework.m.Texture_M a(String string2) throws MapLoadException {
        Object object;
        GameEngine l2 = GameEngine.getInstance();
        String string3 = "tilesets/bitmaps/";
        if (string2.startsWith(t)) {
            string3 = t;
        }
        TilesetImageDescriptor k2 = null;
        for (Object object2 : u) {
            if (!string2.equalsIgnoreCase(((TilesetImageDescriptor) object2).imageKey) || !string3.equalsIgnoreCase(((TilesetImageDescriptor) object2).pathPrefix))
                continue;
            k2 = (com.corrodinggames.rts.game.b.TilesetImageDescriptor) object2;
            break;
        }
        if (k2 != null) {
            if (k2.embeddedBase64 != null) {
                com.corrodinggames.rts.gameFramework.m.Texture_M e2;
                Object object2;
                object = com.corrodinggames.rts.game.b.MapLayer.a(k2.embeddedBase64, "base64", "");
                object2 = new BufferedInputStream((InputStream) object);
                boolean bl2 = false;
                try {
                    e2 = l2.bO.a((InputStream) object2, bl2);
                } catch (RuntimeException runtimeException) {
                    runtimeException.printStackTrace();
                    throw new MapLoadException("Error loading embedded base64 image:" + k2.originalImageName + " - " + runtimeException.getMessage());
                }
                if (e2 == null) {
                    throw new MapLoadException("Embedded tilesetBitmap is null for: " + string2);
                }
                k2.texture = e2;
                k2.embeddedBase64 = null;
            }
            k2.inUse = true;
            return k2.texture;
        }
        try {
            object = l2.bL.d(string3, string2);
        } catch (IOException iOException) {
            throw new MapLoadException("Image file could not be found or loaded: " + string3 + string2, iOException);
        }
        boolean bl3 = false;
        com.corrodinggames.rts.gameFramework.m.Texture_M e3 = l2.bO.a((InputStream) object, bl3);
        try {
            if (object != null) {
                ((InputStream) object).close();
            }
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (e3 == null) {
            throw new RuntimeException("tilesetBitmap is null for: " + string2);
        }
        e3.a("tilesets/" + string2);
        TilesetImageDescriptor k3 = new TilesetImageDescriptor();
        k3.inUse = true;
        k3.texture = e3;
        k3.pathPrefix = string3;
        k3.imageKey = string2;
        u.add(k3);
        return k3.texture;
    }

    public static void a() {
        for (TilesetImageDescriptor k2 : ((ArrayList<TilesetImageDescriptor>) u)) {
            k2.inUse = false;
        }
    }

    public static void b() {
        Iterator iterator = u.iterator();
        while (iterator.hasNext()) {
            TilesetImageDescriptor k2 = (TilesetImageDescriptor) iterator.next();
            if (k2.inUse)
                continue;
            if (k2.texture != null) {
                k2.texture.o();
                k2.texture = null;
            }
            k2.embeddedBase64 = null;
            iterator.remove();
        }
    }

    void c() throws MapLoadException {
        this.b = com.corrodinggames.rts.game.b.Tileset.a(this.c);
        this.j = this.b.m() / this.f;
        if (this.j == 0) {
            this.j = 1;
        }
        this.k = 1.0f / (float) this.j;
    }

    public Properties a(int n2) {
        return (Properties) this.x.get(new Integer(n2));
    }

    public final void a(int n2, Rect rect) {
        int n3 = n2 % this.j;
        int n4 = (int) ((float) n2 * this.k);
        int n5 = this.h + n3 * this.f;
        int n6 = this.i + n4 * this.g;
        rect.left = n5;
        rect.top = n6;
        rect.c = n5 + this.d;
        rect.d = n6 + this.e;
    }

    public final Rect b(int n2) {
        if (this.w == n2) {
            return this.v;
        }
        this.w = n2;
        this.a(n2, this.v);
        return this.v;
    }

    public void c(int n2) {
        this.m = n2;
    }

    public boolean d(int n2) {
        return n2 >= this.l && n2 <= this.m;
    }

    public void d() {
        this.b = null;
        this.o = null;
        this.x = null;
    }

    public Integer b(String string2, String string3) {
        for (Map.Entry entry : ((Set<Map.Entry>) this.x.entrySet())) {
            Integer n2 = (Integer) entry.getKey();
            Properties properties = (Properties) entry.getValue();
            String string4 = properties.getProperty(string2);
            if (string4 == null || !string4.equals(string3))
                continue;
            return n2;
        }
        return null;
    }

    public int a(int n2, int n3) {
        int n4;
        if (this.b == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("getIndexOffsetByPosition tilesetBitmap == null");
            n4 = 3;
        } else if (this.d == 0) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("getIndexOffsetByPosition tileWidth==0");
            n4 = 3;
        } else {
            n4 = this.b.m() / this.d;
        }
        return n2 + n3 * n4;
    }
}
