/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.corrodinggames.rts.gameFramework.h;

import android.os.Build;
import com.corrodinggames.rts.gameFramework.SettingsEngine;
import com.corrodinggames.rts.gameFramework.h.b;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.newdawn.slick.Game;

public final class a {
    static ResourceBundle a;
    static boolean b;
    public static int c;
    public static String d;
    static Pattern e;
    static final Pattern f;

    public static void a() {
        com.corrodinggames.rts.gameFramework.h.a.e();
    }

    static ResourceBundle b() {
        if (a == null) {
            com.corrodinggames.rts.gameFramework.h.a.e();
        }
        java.util.Enumeration<String> keys = a.getKeys();
        while (keys.hasMoreElements()) {
            String iterable_element = keys.nextElement();
        }
        return a;
    }

    static PropertyResourceBundle a(String string2) {
        AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.k("translations/" + string2);
        if (j2 == null) {
            return null;
        }
        PropertyResourceBundle propertyResourceBundle = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader((InputStream)j2, "UTF-8");
            propertyResourceBundle = new PropertyResourceBundle(inputStreamReader);
            inputStreamReader.close();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return propertyResourceBundle;
    }

    public static String a(String string2, Locale locale, boolean bl2, boolean bl3) {
        if (locale == Locale.ROOT) {
            return string2;
        }
        String string3 = locale.getLanguage();
        String string4 = bl2 ? locale.getCountry() : "";
        String string5 = bl3 ? locale.getVariant() : "";
        if (string3.equals("") && string4.equals("") && string5.equals("")) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(string2);
        stringBuilder.append('_');
        if (!string5.equals("")) {
            stringBuilder.append(string3).append('_').append(string4.toLowerCase(Locale.ROOT)).append('_').append(string5.toLowerCase(Locale.ROOT));
        } else if (!string4.equals("")) {
            stringBuilder.append(string3).append('_').append(string4.toLowerCase(Locale.ROOT));
        } else {
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }

    static ResourceBundle a(String string2, Locale locale) {
        String string3 = com.corrodinggames.rts.gameFramework.h.a.a(string2, Locale.ROOT, false, false) + ".properties";
        PropertyResourceBundle propertyResourceBundle = com.corrodinggames.rts.gameFramework.h.a.a(string3);
        if (propertyResourceBundle == null) {
            throw new RuntimeException("Root locate file:" + string3 + " is missing, it is required");
        }
        boolean bl2 = Locale.ROOT.equals(locale);
        if (bl2) {
            GameEngine.log("Locale: Using " + string3 + " as locale");
            return propertyResourceBundle;
        }
        String string4 = com.corrodinggames.rts.gameFramework.h.a.a(string2, locale, true, true) + ".properties";
        PropertyResourceBundle propertyResourceBundle2 = com.corrodinggames.rts.gameFramework.h.a.a(string4);
        if (propertyResourceBundle2 == null) {
            GameEngine.log("Locale: No locale for " + string4 + " checking locale without variant ");
            string4 = com.corrodinggames.rts.gameFramework.h.a.a(string2, locale, true, false) + ".properties";
            propertyResourceBundle2 = com.corrodinggames.rts.gameFramework.h.a.a(string4);
            if (propertyResourceBundle2 == null) {
                GameEngine.log("Locale: No locale for " + string4 + " checking locale without variant or country");
                string4 = com.corrodinggames.rts.gameFramework.h.a.a(string2, locale, false, false) + ".properties";
                propertyResourceBundle2 = com.corrodinggames.rts.gameFramework.h.a.a(string4);
                if (propertyResourceBundle2 == null) {
                    GameEngine.log("Locale: No locale for " + string4 + " using base locale");
                    return propertyResourceBundle;
                }
            }
        }
        GameEngine.log("Locale: Using " + string4 + " as locale");
        return new b(propertyResourceBundle2, propertyResourceBundle);
    }

    public static String c() {
        if (d != null) {
            return d;
        }
        return com.corrodinggames.rts.gameFramework.h.a.d().getLanguage();
    }

    public static Locale d() {
        GameEngine l2 = GameEngine.getInstance();
        SettingsEngine settingsEngine = null;
        if (l2 != null) {
            settingsEngine = l2.bQ;
        }
        boolean bl2 = false;
        if (settingsEngine != null && settingsEngine.forceEnglish) {
            bl2 = true;
        }
        if (bl2) {
            return Locale.ROOT;
        }
        return Locale.getDefault();
    }

    public static synchronized void e() {
        ++c;
        GameEngine l2 = GameEngine.getInstance();
        SettingsEngine settingsEngine = null;
        if (l2 != null) {
            settingsEngine = l2.bQ;
        }
        boolean bl2 = false;
        if (settingsEngine != null && settingsEngine.forceEnglish) {
            bl2 = true;
        }
        if (a != null && b == bl2) {
            GameEngine.log("Locale.reload: skipping reload");
        }
        if (Build.VERSION.SDK_INT >= 9) {
            ResourceBundle.clearCache();
        }
        if (bl2) {
            GameEngine.log("Locale: forceEnglish");
            a = com.corrodinggames.rts.gameFramework.h.a.a("Strings", Locale.ROOT);
        } else if (d != null) {
            a = com.corrodinggames.rts.gameFramework.h.a.a("Strings", new Locale(d));
        } else if (settingsEngine != null && settingsEngine.overrideLanguageCode != null && !settingsEngine.overrideLanguageCode.equals("")) {
            a = com.corrodinggames.rts.gameFramework.h.a.a("Strings", new Locale(settingsEngine.overrideLanguageCode));
        } else {
            Locale locale = Locale.getDefault();
            GameEngine.log("Locale: default targetLocale:" + locale);
            if (locale != null) {
                GameEngine.log("Locale: default targetLocale ISO3:" + locale.getISO3Language());
            }
            a = com.corrodinggames.rts.gameFramework.h.a.a("Strings", locale);
        }
        b = bl2;
        boolean bl3 = false;
        if (bl3) {
            // empty if block
        }
    }

    private static final String d(String string2) {
        String string3 = null;
        try {
            ResourceBundle resourceBundle = com.corrodinggames.rts.gameFramework.h.a.b();
            if (resourceBundle.containsKey(string2)) {
                string3 = resourceBundle.getString(string2);
            } else {
                // 如果key不存在，返回key本身作为默认值，避免MissingResourceException
                GameEngine.log("Translation key not found: " + string2);
                return "Miss:"+string2;
            }
        }
        catch (MissingResourceException missingResourceException) {
            // 处理MissingResourceException，返回key本身作为默认值
            GameEngine.log("Translation key not found (MissingResourceException): " + string2);
            return string2;
        }
        catch (NullPointerException nullPointerException) {
            String string4 = "NullPointer with key:" + string2 + " locale:" + com.corrodinggames.rts.gameFramework.h.a.b().getLocale().toString();
            throw new RuntimeException(string4, nullPointerException);
        }
        if (string3.contains("[") || string3.contains("]")) {
            string3 = string3.replace("[[", "{{");
            string3 = string3.replace("]]", "}}");
            string3 = string3.replace("[", "{{");
            string3 = string3.replace("]", "}}");
        }
        if (string3.contains("{") || string3.contains("}")) {
            string3 = string3.replace("}}  {{", "}}{{");
            string3 = string3.replace("}} {{", "}}{{");
            string3 = string3.replace("}}{{", "\n-");
            string3 = string3.replace("{{", "-");
            string3 = string3.replace("}}", "");
        }
        return string3;
    }

    private static final boolean e(String string2) {
        try {
            com.corrodinggames.rts.gameFramework.h.a.b().getString(string2);
            return true;
        }
        catch (MissingResourceException missingResourceException) {
            return false;
        }
    }

    public static final String a(String string2, String string3, Object ... objectArray) {
        try {
            return com.corrodinggames.rts.gameFramework.h.a.a(string2, objectArray);
        }
        catch (MissingResourceException missingResourceException) {
            return string3;
        }
    }

    public static final String a(String string2, Object ... objectArray) {
        String string3 = com.corrodinggames.rts.gameFramework.h.a.d(string2);
        if (objectArray == null || objectArray.length == 0) {
            return string3;
        }
        String string4 = new MessageFormat(string3).format(objectArray, new StringBuffer(), (FieldPosition)null).toString();
        return string4;
    }

    public static final String b(String string2) {
        if (string2 == null) {
            return null;
        }
        String string3 = string2;
        String string4 = null;
        Matcher matcher = e.matcher(string2);
        if (matcher.matches()) {
            string3 = matcher.group(1);
            string4 = matcher.group(2);
        }
        string3 = string3.trim();
        string3 = string3.replace(" ", "_");
        string3 = string3.replace(".tmx", "");
        string3 = string3.toLowerCase(Locale.ENGLISH);
        String string5 = "maps.name." + string3;
        if (com.corrodinggames.rts.gameFramework.h.a.e(string5)) {
            String string6 = com.corrodinggames.rts.gameFramework.h.a.a(string5, new Object[0]);
            if (string4 != null) {
                string6 = string6 + string4;
            }
            GameEngine.log("translated:" + string6);
            if (string6 != null) {
                string6 = string6.replace("_", " ");
            }
            return string6;
        }
        return string2;
    }

    public static String c(String string2) {
        if (!string2.contains("[i:")) {
            return string2;
        }
        int n2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = f.matcher(string2);
        while (matcher.find()) {
            if (++n2 > 100) {
                GameEngine.b("convertInlineBlocks: Too many loops while parsing: " + string2);
                return string2;
            }
            String string3 = matcher.group(1);
            String string4 = com.corrodinggames.rts.gameFramework.h.a.a(string3, null, new Object[0]);
            if (string4 == null) {
                GameEngine.log("convertInlineBlocks: No key:" + string3);
                string4 = "[No key: " + string3 + "]";
            }
            matcher.appendReplacement(stringBuffer, string4);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    static {
        c = 0;
        e = Pattern.compile("(.*)(\\(.*\\)( *\\[by.*\\])?)");
        f = Pattern.compile("\\[i:([^\\]]*?)\\]");
    }
}
