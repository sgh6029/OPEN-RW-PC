/*
 * Decompiled with CFR 0.152.
 */
package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Element {
    private long nativeHandle;
    boolean loadedChinese = false;
    HashSet charsetsLoaded;

    public native Element getElementById(String var1);

    public boolean equals(Object object) {
        if (object == null || !(object instanceof Element)) {
            return false;
        }
        Element element = (Element)object;
        return element.nativeHandle == this.nativeHandle;
    }

    public String getAttribute(String string2) {
        return this.getAttribute(string2, null);
    }

    public boolean getAttributeBoolean(String string2, boolean bl2) {
        String string3 = this.getAttribute(string2, null);
        if (string3 == null) {
            return bl2;
        }
        if (string3.equalsIgnoreCase("true")) {
            return true;
        }
        if (string3.equalsIgnoreCase("false")) {
            return false;
        }
        return bl2;
    }

    public String getId() {
        return this.getAttribute("id");
    }

    public native String getTagName();

    public native boolean focus();

    public native void blur();

    public native void click();

    public native void addReference();

    public native void removeReference();

    public native String getAttribute(String var1, String var2);

    public native void setAttribute(String var1, String var2);

    public void addStyle(String string2) {
        String string3 = this.getAttribute("style");
        if (string3 == null) {
            string3 = "";
        }
        string3 = string3 + string2;
        this.setAttribute("style", string3);
    }

    public void setStyle(String string2) {
        this.setAttribute("style", string2);
    }

    public void setValue(String string2) {
        this.setAttribute("value", string2);
    }

    public void setCheckbox(boolean bl2) {
        if (bl2) {
            this.setAttribute("checked", "");
        } else {
            this.setAttribute("checked", null);
        }
    }

    public boolean getCheckbox() {
        String string2 = this.getAttribute("checked");
        return string2 != null && !"false".equals(string2);
    }

    public String getValue() {
        return this.getAttribute("value");
    }

    public Integer getValueAsInt(Integer n2) {
        String string2 = this.getValue();
        if (string2 == null || string2.equals("") || string2.equals("null")) {
            return n2;
        }
        return Integer.parseInt(string2);
    }

    public Float getValueAsFloat(Float f2) {
        String string2 = this.getValue();
        if (string2 == null || string2.equals("")) {
            return f2;
        }
        string2 = string2.replace(",", ".");
        return Float.valueOf(Float.parseFloat(string2));
    }

    public Boolean getValueAsBoolean(Boolean bl2) {
        String string2 = this.getValue();
        if (string2 == null || string2.equals("")) {
            return bl2;
        }
        return Boolean.parseBoolean(string2);
    }

    public native String getAttributeKey(int var1);

    public native String getAttributeValue(int var1);

    public native int getNumAttributes();

    public native Element getChild(int var1);

    public native int getNumChildren();

    public native String getInnerRML();

    public native void setInnerRML(String var1);

    public static String excapeHTML(String string2) {
        string2 = string2.replace("&", "&amp;");
        string2 = string2.replace("<", "&lt;");
        string2 = string2.replace(">", "&gt;");
        string2 = string2.replace("${", "$ {");
        return string2;
    }

    public void setTextNoCharset(String string2, boolean bl2) {
        if (string2 == null) {
            string2 = "";
        }
        string2 = Element.excapeHTML(string2);
        if (bl2 && string2.contains("\n")) {
            string2 = string2.replaceAll("\n", "<br/>\n");
        }
        this.setInnerRML(string2);
    }

    public boolean loadCharsetIfNeededWithCurrentText() {
        return this.loadCharsetIfNeeded(this.getInnerRML());
    }

    public boolean loadCharsetIfNeeded(String string2) {
        int n2;
        String string3 = "";
        int n3 = string2.length();
        for (int i2 = 0; i2 < n3; i2 += Character.charCount(n2)) {
            n2 = string2.codePointAt(i2);
            if (n2 <= 128) continue;
            boolean bl2 = false;
            if (n2 >= 196 && n2 <= 252) {
                bl2 = true;
            }
            if (bl2) continue;
            if (this.charsetsLoaded == null) {
                this.charsetsLoaded = new HashSet();
            }
            if (this.charsetsLoaded.contains(n2)) continue;
            this.charsetsLoaded.add(n2);
            if (!string3.equals("")) {
                string3 = string3 + ",";
            }
            string3 = string3 + Element.keycodeToHex(n2);
        }
        if (!string3.equals("")) {
            this.compareAndAddClass("needsUnicodeFont");
            return true;
        }
        return false;
    }

    public static final String keycodeToHex(int n2) {
        String string2 = String.format("U+%04X", n2);
        return string2;
    }

    public void compareAndSetText(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        if (!string2.equals(this.getInnerRML())) {
            this.setText(string2);
        }
    }

    public void setText(String string2) {
        this.loadCharsetIfNeeded(string2);
        this.setTextNoCharset(string2, false);
    }

    public void setTextWithNewlines(String string2) {
        this.loadCharsetIfNeeded(string2);
        this.setTextNoCharset(string2, true);
    }

    public void addClass(String string2) {
        this.setClassNames(this.getClassNames() + " " + string2);
    }

    public void compareAndAddClass(String string2) {
        if (!this.hasClassName(string2)) {
            this.addClass(string2);
        }
    }

    public void removeClass(String string2) {
        String string3;
        String string4 = this.getClassNames();
        if (!string4.equals(string3 = string4.replaceAll("\\b" + string2 + "\\b", ""))) {
            this.setClassNames(string3);
        }
    }

    public void compareAndSetClassNames(String string2) {
        if (!string2.equals(this.getClassNames())) {
            this.setClassNames(string2);
        }
    }

    public native void setClassNames(String var1);

    public native String getClassNames();

    public Element cloneAndFix() {
        Element element = this.clone();
        element.setClassNames(this.getClassNames());
        return element;
    }

    public native Element clone();

    public native void appendChild(Element var1);

    public native void insertBefore(Element var1, Element var2);

    public native void removeChild(Element var1);

    public native String getProperty(String var1, String var2);

    public native void setProperty(String var1, String var2);

    public native boolean isPseudoClassSet(String var1);

    public native float getAbsoluteLeft();

    public native float getAbsoluteTop();

    public native float getOffsetLeft();

    public native float getOffsetTop();

    public native float getOffsetWidth();

    public native float getOffsetHeight();

    public native float getScrollTop();

    public native void setScrollTop(float var1);

    public native void scrollIntoView(boolean var1);

    public boolean isFocused() {
        return this.isPseudoClassSet("focus");
    }

    public boolean isHovering() {
        return this.isPseudoClassSet("hover");
    }

    public void prependChild(Element element) {
        if (this.getNumChildren() == 0) {
            this.appendChild(element);
        } else {
            this.insertBefore(element, this.getChild(0));
        }
    }

    public void clearAllChildren() {
        int n2;
        for (int i2 = n2 = this.getNumChildren(); i2 >= 0; --i2) {
            Element element = this.getChild(i2);
            if (element == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            String string2 = element.getTagName();
            if (string2.equals("scrollbarvertical")) continue;
            this.removeChild(element);
        }
    }

    public ArrayList getChildren() {
        ArrayList<Element> arrayList = new ArrayList<Element>();
        int n2 = this.getNumChildren();
        for (int i2 = 0; i2 < n2; ++i2) {
            Element element = this.getChild(i2);
            if (element == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            arrayList.add(element);
        }
        return arrayList;
    }

    public Element getTopLevelFocusedElement() {
        int n2 = this.getNumChildren();
        for (int i2 = 0; i2 < n2; ++i2) {
            Element element = this.getChild(i2);
            if (element == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            Element element2 = element.getTopLevelFocusedElement();
            if (element2 == null) continue;
            return element2;
        }
        if (this.isFocused()) {
            return this;
        }
        return null;
    }

    public ArrayList getChainFromChildElement(Element element) {
        if (element.equals(this)) {
            ArrayList<Element> arrayList = new ArrayList<Element>();
            arrayList.add(this);
            return arrayList;
        }
        int n2 = this.getNumChildren();
        for (int i2 = 0; i2 < n2; ++i2) {
            Element element2 = this.getChild(i2);
            if (element2 == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            ArrayList arrayList = element2.getChainFromChildElement(element);
            if (arrayList == null) continue;
            arrayList.add(this);
            return arrayList;
        }
        return null;
    }

    public ArrayList getAllNestedChildren() {
        ArrayList arrayList = new ArrayList();
        this.getAllNestedChildren(arrayList);
        return arrayList;
    }

    public void getAllNestedChildren(ArrayList arrayList) {
        int n2 = this.getNumChildren();
        for (int i2 = 0; i2 < n2; ++i2) {
            Element element = this.getChild(i2);
            if (element == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            arrayList.add(element);
            element.getAllNestedChildren(arrayList);
        }
    }

    public boolean hasClassName(String string2) {
        return (" " + this.getClassNames() + " ").contains(" " + string2 + " ");
    }

    public Element findByClassName(String string2) {
        int n2 = this.getNumChildren();
        for (int i2 = 0; i2 < n2; ++i2) {
            Element element = this.getChild(i2);
            if (element == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            if (element.hasClassName(string2)) {
                return element;
            }
            Element element2 = element.findByClassName(string2);
            if (element2 == null) continue;
            return element2;
        }
        return null;
    }

    public Element findByTagName(String string2) {
        int n2 = this.getNumChildren();
        for (int i2 = 0; i2 < n2; ++i2) {
            Element element = this.getChild(i2);
            if (element == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            if (element.getTagName().equalsIgnoreCase(string2)) {
                return element;
            }
            Element element2 = element.findByTagName(string2);
            if (element2 == null) continue;
            return element2;
        }
        return null;
    }

    public ArrayList findElementsByClassName(String string2) {
        ArrayList arrayList = new ArrayList();
        this.findElementsByClassName(string2, arrayList);
        return arrayList;
    }

    public void findElementsByClassName(String string2, List list) {
        int n2 = this.getNumChildren();
        for (int i2 = 0; i2 < n2; ++i2) {
            Element element = this.getChild(i2);
            if (element == null) {
                throw new RuntimeException("child==null, i:" + i2);
            }
            if ((" " + element.getClassNames() + " ").contains(" " + string2 + " ")) {
                list.add(element);
            }
            element.findElementsByClassName(string2, list);
        }
    }

    public void hide() {
        this.show(false);
    }

    public void show() {
        this.show(true);
    }

    public void show(boolean bl2) {
        if (!bl2) {
            this.compareAndAddClass("hide");
        } else {
            this.removeClass("hide");
        }
    }
}

