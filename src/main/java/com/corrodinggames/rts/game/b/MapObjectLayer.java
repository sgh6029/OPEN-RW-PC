/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import com.corrodinggames.rts.game.b.MapObject;
import com.corrodinggames.rts.game.b.TileMap;
import java.util.ArrayList;
import java.util.Properties;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MapObjectLayer {
    public int a;
    public String b;
    public ArrayList c;
    public int d;
    public int e;
    public Properties f;

    public MapObject a(String string2) {
        if (this.c != null) {
            for (MapObject a2 : ((ArrayList<MapObject>)this.c)) {
                if (!string2.equalsIgnoreCase(a2.b)) continue;
                return a2;
            }
        }
        return null;
    }

    public MapObjectLayer(Element element, TileMap b2) throws MapLoadException {
        Object object;
        Element element2;
        int n2;
        NodeList nodeList;
        this.b = element.getAttribute("name");
        if (element.hasAttribute("width")) {
            this.d = Integer.parseInt(element.getAttribute("width"));
        }
        if (element.hasAttribute("height")) {
            this.e = Integer.parseInt(element.getAttribute("height"));
        }
        this.c = new ArrayList();
        Element element3 = (Element)element.getElementsByTagName("properties").item(0);
        if (element3 != null && (nodeList = element3.getElementsByTagName("property")) != null) {
            this.f = new Properties();
            for (n2 = 0; n2 < nodeList.getLength(); ++n2) {
                element2 = (Element)nodeList.item(n2);
                object = element2.getAttribute("name");
                String string2 = element2.getAttribute("value");
                this.f.setProperty((String)object, string2);
            }
        }
        nodeList = element.getElementsByTagName("object");
        n2 = 0;
        while (n2 < nodeList.getLength()) {
            element2 = (Element)nodeList.item(n2);
            object = new MapObject(element2, b2, this);
            ((MapObject)object).a = n2++;
            this.c.add(object);
        }
    }
}

