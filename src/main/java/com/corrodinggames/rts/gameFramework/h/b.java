/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.h;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;
class b extends ResourceBundle {
    ResourceBundle a;
    ResourceBundle b;

    public b(ResourceBundle resourceBundle, ResourceBundle resourceBundle2) {
        this.a = resourceBundle;
        this.b = resourceBundle2;
    }

    // 添加这个方法修复问题
    @Override
    public Locale getLocale() {
        // 返回主资源包的locale，或者如果主资源包没有locale则返回后备资源包的locale
        if (this.a != null) {
            Locale locale = this.a.getLocale();
            if (locale != null) {
                return locale;
            }
        }
        if (this.b != null) {
            return this.b.getLocale();
        }
        return Locale.getDefault(); // 默认回退
    }

    public Enumeration getKeys() {
        GameEngine.log("MultipleResourceBundle: Slow get keys");
        Vector<String> vector = new Vector<String>();
        vector.addAll(Collections.list(this.a.getKeys()));
        if (this.b != null) {
            for (String string2 : Collections.list(this.b.getKeys())) {
                if (vector.contains(string2)) continue;
                vector.add(string2);
            }
        }
        return vector.elements();
    }

    @Override
    protected Object handleGetObject(String string2) {
        Object object;
        try {
            object = this.a.getObject(string2);
        }
        catch (MissingResourceException missingResourceException) {
            object = null;
        }
        if (object == null && this.b != null) {
            try {
                object = this.b.getObject(string2);
            }
            catch (MissingResourceException missingResourceException) {
                object = null;
            }
        }
        // 如果两个资源包都没有找到key，返回null让上层处理
        return object;
    }
}
