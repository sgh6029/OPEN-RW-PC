/*
 * Decompiled with CFR 0.152.
 */
package com;

import com.Element;
import com.ElementDocument;
import com.LibRocket$CompiledGeometry;
import com.LibRocket$TextureHolder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class LibRocket {
    public boolean debug = false;
    String currentDocumentPath;
    ElementDocument currentDocument;
    ArrayList lastDocuments = new ArrayList();
    long longLastModified = -1L;
    long longLastModifiedNewestCss = -1L;
    String[] activeDocumentCss;
    int reloadSkip;
    public String documentPrefix = "assets/gui/";
    public boolean queueExtraUpdate = false;
    public int width = 1000;
    public int height = 1000;
    public int lastMouseX = 0;
    public int lastMouseY = 0;
    ArrayList compiledGeometryList = new ArrayList();
    ArrayList textureHolderList = new ArrayList();

    public native void setup();

    public void backToLastDocument() {
        if (this.lastDocuments.size() == 0) {
            this.closeActiveDocument();
            return;
        }
        ElementDocument elementDocument = (ElementDocument)this.lastDocuments.remove(this.lastDocuments.size() - 1);
        this.setDocument(elementDocument.documentPath, elementDocument.metadata, false);
    }

    public void clearHistory() {
        this.lastDocuments.clear();
    }

    public ElementDocument setDocument(String string2) {
        return this.setDocument(string2, null);
    }

    public ElementDocument setDocument(String string2, HashMap hashMap) {
        return this.setDocument(string2, hashMap, true);
    }

    public void reloadDocument() {
        if (this.currentDocument != null && this.currentDocumentPath != null) {
            boolean bl2 = false;
            this.setDocument(this.currentDocumentPath, this.getActiveDocumentMetadata(), bl2);
        }
    }

    public ElementDocument setDocument(String string2, HashMap hashMap, boolean bl2) {
        if (this.currentDocument != null) {
            if (bl2) {
                this.lastDocuments.add(this.currentDocument);
            }
            this.closeDocument(this.currentDocument);
            this.currentDocument = null;
        }
        this.currentDocumentPath = string2;
        ElementDocument elementDocument = new ElementDocument();
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        elementDocument.metadata = hashMap;
        elementDocument.documentPath = string2;
        this.currentDocument = elementDocument;
        this.longLastModified = this.getLastModified();
        this.loadDocumentWithContainer(this.getDocumentPath(this.currentDocumentPath), elementDocument);
        this.newDocumentLoaded(elementDocument);
        elementDocument.show();
        this.newDocumentShown(elementDocument);
        return elementDocument;
    }

    public void newDocumentLoaded(ElementDocument elementDocument) {
    }

    public void newDocumentShown(ElementDocument elementDocument) {
    }

    public ElementDocument createPopup(String string2, Object object) {
        ElementDocument elementDocument = this.loadDocument(this.getDocumentPath(string2));
        if (elementDocument != null) {
            elementDocument.setMetadata("mode", object);
        }
        return elementDocument;
    }

    public void closeDocument(ElementDocument elementDocument) {
        elementDocument.closeDocument();
        this.queueExtraUpdate = true;
    }

    public void closeActiveDocument() {
        if (this.currentDocument != null) {
            this.closeDocument(this.currentDocument);
            this.currentDocument = null;
        }
    }

    public ElementDocument getActiveDocument() {
        return this.currentDocument;
    }

    public HashMap getActiveDocumentMetadata() {
        if (this.currentDocument != null) {
            return this.currentDocument.metadata;
        }
        return null;
    }

    public String getActiveDocumentPath() {
        if (this.currentDocument == null) {
            return "<No Current Document>";
        }
        return this.currentDocument.documentPath;
    }

    public Element getActiveElementById(String string2) {
        if (this.currentDocument == null) {
            System.out.println("currentDocument==null on getActiveElementById:" + string2);
            return null;
        }
        if (string2 == null) {
            throw new RuntimeException("id==null");
        }
        return this.currentDocument.getElementById(string2);
    }

    public String[] getActiveDocumentCss() {
        if (this.activeDocumentCss == null) {
            ArrayList<String> arrayList = new ArrayList<String>();
            String string2 = "assets/gui";
            File file = new File(string2);
            File[] fileArray = file.listFiles();
            for (int i2 = 0; i2 < fileArray.length; ++i2) {
                File file2 = fileArray[i2];
                if (!file2.getName().toLowerCase(Locale.ENGLISH).endsWith(".rcss")) continue;
                String string3 = string2 + "/" + file2.getName();
                arrayList.add(string3);
                System.out.println("getActiveDocumentCss: " + string3);
            }
            this.activeDocumentCss = arrayList.toArray(new String[0]);
        }
        return this.activeDocumentCss;
    }

    public long getFileLastModified(String string2) {
        File file = new File(string2);
        return file.lastModified();
    }

    public long getLastModifiedNewestCss() {
        if (this.currentDocumentPath == null) {
            return -2L;
        }
        long l2 = -1L;
        for (String string2 : this.getActiveDocumentCss()) {
            long l3 = this.getFileLastModified(string2);
            if (l3 <= l2) continue;
            l2 = l3;
        }
        return l2;
    }

    public long getLastModified() {
        if (this.currentDocumentPath == null) {
            return -2L;
        }
        return this.getFileLastModified("assets/gui/" + this.currentDocumentPath);
    }

    public void detectChangesAndReload() {
        ++this.reloadSkip;
        if (this.reloadSkip < 20) {
            return;
        }
        this.reloadSkip = 0;
        if (this.getActiveDocument() != null) {
            boolean bl2 = false;
            long l2 = this.getLastModified();
            if (this.longLastModified == -1L) {
                this.longLastModified = l2;
            } else if (this.longLastModified != l2) {
                System.out.println("reloadDocument: '" + this.currentDocumentPath + "' current now:" + l2);
                bl2 = true;
                this.longLastModified = l2;
            }
            long l3 = this.getLastModifiedNewestCss();
            if (this.longLastModifiedNewestCss == -1L) {
                this.longLastModifiedNewestCss = l3;
            } else if (this.longLastModifiedNewestCss != l3) {
                System.out.println("reloadDocument from css: '" + this.currentDocumentPath + "' current now:" + l2);
                bl2 = true;
                this.longLastModifiedNewestCss = l3;
            }
            if (bl2) {
                this.reloadDocument();
            }
        }
    }

    public String getDocumentPath(String string2) {
        return this.documentPrefix + string2;
    }

    private native ElementDocument loadDocument(String var1);

    private native void loadDocumentWithContainer(String var1, ElementDocument var2);

    public void loadFont(String string2) {
        this.loadFont(string2, null);
    }

    public native void loadFont(String var1, String var2);

    public void postUpdate() {
        if (this.queueExtraUpdate) {
            this.queueExtraUpdate = false;
            this.update();
            this.render();
            this.processMouseMove(-1, -1, 0);
            this.processMouseMove(this.lastMouseX, this.lastMouseY, 0);
        }
    }

    public native void update();

    public native void render();

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setDimensionsWrap(int n2, int n3) {
        this.width = n2;
        this.height = n3;
        this.setDimensions(n2, n3);
    }

    private native void setDimensions(int var1, int var2);

    public void mouseMove(int n2, int n3, int n4) {
        this.lastMouseX = n2;
        this.lastMouseY = n3;
        this.processMouseMove(n2, n3, n4);
    }

    public native void processMouseMove(int var1, int var2, int var3);

    public native void processMouseButtonDown(int var1, int var2);

    public native void processMouseButtonUp(int var1, int var2);

    public native void processMouseWheel(int var1, int var2);

    public native void processTextInput(String var1);

    public native void processTextInputChar(int var1);

    public native void processKeyDown(int var1, int var2);

    public native void processKeyUp(int var1, int var2);

    public void RenderGeometry(float[] fArray, float[] fArray2, int[] nArray, int[] nArray2, int n2, float f2, float f3) {
        this.RenderGeometryPossiblyCompiled(fArray, fArray2, nArray, nArray2, n2, f2, f3, null);
    }

    public void RenderGeometryPossiblyCompiled(float[] fArray, float[] fArray2, int[] nArray, int[] nArray2, int n2, float f2, float f3, LibRocket$CompiledGeometry libRocket$CompiledGeometry) {
        System.out.println("RenderGeometryPossiblyCompiled(" + nArray2.length + ")");
    }

    public int CompileGeometry(float[] fArray, float[] fArray2, int[] nArray, int[] nArray2, int n2) {
        int n3;
        LibRocket$CompiledGeometry libRocket$CompiledGeometry = null;
        boolean bl2 = true;
        if (bl2) {
            for (n3 = 1; n3 < this.compiledGeometryList.size(); ++n3) {
                LibRocket$CompiledGeometry libRocket$CompiledGeometry2 = (LibRocket$CompiledGeometry)this.compiledGeometryList.get(n3);
                if (libRocket$CompiledGeometry2 == null) continue;
                boolean bl3 = true;
                if (libRocket$CompiledGeometry2.verticesXY != fArray) {
                    if (!Arrays.equals(libRocket$CompiledGeometry2.verticesXY, fArray)) {
                        bl3 = false;
                    } else {
                        fArray = libRocket$CompiledGeometry2.verticesXY;
                    }
                }
                if (libRocket$CompiledGeometry2.verticesUV != fArray2) {
                    if (!Arrays.equals(libRocket$CompiledGeometry2.verticesUV, fArray2)) {
                        bl3 = false;
                    } else {
                        fArray2 = libRocket$CompiledGeometry2.verticesUV;
                    }
                }
                if (libRocket$CompiledGeometry2.verticesColors != nArray) {
                    if (!Arrays.equals(libRocket$CompiledGeometry2.verticesColors, nArray)) {
                        bl3 = false;
                    } else {
                        nArray = libRocket$CompiledGeometry2.verticesColors;
                    }
                }
                if (libRocket$CompiledGeometry2.indices != nArray2) {
                    if (!Arrays.equals(libRocket$CompiledGeometry2.indices, nArray2)) {
                        bl3 = false;
                    } else {
                        nArray2 = libRocket$CompiledGeometry2.indices;
                    }
                }
                if (!bl3) continue;
            }
        }
        if (libRocket$CompiledGeometry == null) {
            libRocket$CompiledGeometry = new LibRocket$CompiledGeometry();
            libRocket$CompiledGeometry.verticesXY = fArray;
            libRocket$CompiledGeometry.verticesUV = fArray2;
            libRocket$CompiledGeometry.verticesColors = nArray;
            libRocket$CompiledGeometry.indices = nArray2;
            libRocket$CompiledGeometry.textureId = n2;
        }
        if (this.compiledGeometryList.size() == 0) {
            this.compiledGeometryList.add(null);
        }
        n3 = 0;
        for (int i2 = 1; i2 < this.compiledGeometryList.size(); ++i2) {
            if (this.compiledGeometryList.get(i2) != null) continue;
            libRocket$CompiledGeometry.id = i2;
            this.compiledGeometryList.set(i2, libRocket$CompiledGeometry);
            n3 = 1;
            break;
        }
        if (n3 == 0) {
            libRocket$CompiledGeometry.id = this.compiledGeometryList.size();
            this.compiledGeometryList.add(libRocket$CompiledGeometry);
        }
        return libRocket$CompiledGeometry.id;
    }

    public void RenderCompiledGeometry(int n2, float f2, float f3) {
        LibRocket$CompiledGeometry libRocket$CompiledGeometry = (LibRocket$CompiledGeometry)this.compiledGeometryList.get(n2);
        if (libRocket$CompiledGeometry == null) {
            LibRocket.warn("CompileGeometry null for " + n2);
            return;
        }
        this.RenderGeometryPossiblyCompiled(libRocket$CompiledGeometry.verticesXY, libRocket$CompiledGeometry.verticesUV, libRocket$CompiledGeometry.verticesColors, libRocket$CompiledGeometry.indices, libRocket$CompiledGeometry.textureId, f2, f3, libRocket$CompiledGeometry);
    }

    public void ReleaseCompiledGeometry(int n2) {
        this.compiledGeometryList.set(n2, null);
    }

    public void ReleaseCompiledGeometryForTexture(int n2) {
        for (int i2 = 1; i2 < this.compiledGeometryList.size(); ++i2) {
            LibRocket$CompiledGeometry libRocket$CompiledGeometry = (LibRocket$CompiledGeometry)this.compiledGeometryList.get(i2);
            if (libRocket$CompiledGeometry == null || libRocket$CompiledGeometry.textureId != n2) continue;
            LibRocket.log("ReleaseCompiledGeometryForTexture:" + libRocket$CompiledGeometry.textureId);
            this.compiledGeometryList.set(i2, null);
        }
    }

    public void EnableScissorRegion(boolean bl2) {
    }

    public void SetScissorRegion(int n2, int n3, int n4, int n5) {
    }

    public boolean LoadTexture(int n2, String string2) {
        LibRocket.log("JavaMethod:LoadTexture()");
        return true;
    }

    public boolean GenerateTexture(int n2, byte[] byArray) {
        LibRocket.log("JavaMethod:GenerateTexture()");
        return true;
    }

    public void ReleaseTexture(int n2) {
        LibRocket.log("JavaMethod:ReleaseTexture");
        this.ReleaseCompiledGeometryForTexture(n2);
    }

    public void HandleEvent(String string2) {
        LibRocket.log("JavaMethod:HandleEvent:" + string2);
    }

    public String TranslateString(String string2) {
        return string2;
    }

    private void callback(String string2) {
        System.out.println("In Java with: " + string2);
    }

    public static void test() {
        LibRocket libRocket = new LibRocket();
        libRocket.setup();
        libRocket.loadDocument(libRocket.getDocumentPath("test.rml"));
        libRocket.update();
        libRocket.render();
    }

    public static void main(String[] stringArray) {
        LibRocket.test();
    }

    public LibRocket$TextureHolder getNewTextureHolder() {
        if (this.textureHolderList.size() == 0) {
            this.textureHolderList.add(null);
        }
        LibRocket$TextureHolder libRocket$TextureHolder = this.getFromTextureHolderFactory();
        boolean bl2 = false;
        for (int i2 = 1; i2 < this.textureHolderList.size(); ++i2) {
            if (this.textureHolderList.get(i2) != null) continue;
            libRocket$TextureHolder.index = i2;
            this.textureHolderList.set(i2, libRocket$TextureHolder);
            System.out.println("getNewTextureHolder: set:" + libRocket$TextureHolder.index);
            bl2 = true;
            break;
        }
        if (!bl2) {
            libRocket$TextureHolder.index = this.textureHolderList.size();
            this.textureHolderList.add(libRocket$TextureHolder);
            System.out.println("getNewTextureHolder: append:" + libRocket$TextureHolder.index);
        }
        return libRocket$TextureHolder;
    }

    public LibRocket$TextureHolder findTextureHolder(int n2) {
        return (LibRocket$TextureHolder)this.textureHolderList.get(n2);
    }

    public boolean removeTextureHolder(int n2) {
        if (this.textureHolderList.size() <= n2) {
            LibRocket.warn("removeTextureHolder: cannot remove:" + n2 + " it is out of range");
            return false;
        }
        LibRocket$TextureHolder libRocket$TextureHolder = this.findTextureHolder(n2);
        if (libRocket$TextureHolder != null) {
            libRocket$TextureHolder.remove();
        }
        this.textureHolderList.set(n2, null);
        return true;
    }

    public LibRocket$TextureHolder getFromTextureHolderFactory() {
        return new LibRocket$TextureHolder(this);
    }

    public static void log(String string2) {
        System.out.println(string2);
    }

    public static void warn(String string2) {
        System.out.println(string2);
    }

    static {
        String string2;
        boolean bl2 = false;
        String string3 = System.getProperty("os.name");
        if (string3.startsWith("Windows")) {
            bl2 = true;
        }
        boolean bl3 = (string2 = System.getProperty("os.arch")).contains("64") || string2.startsWith("armv8");
        String string4 = "rocketConnector";
        if (bl2 && bl3) {
            string4 = "rocketConnector64";
        }
        System.loadLibrary(string4);
    }
}

