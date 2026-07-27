/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class SteamSharedLibraryLoader {
    private final String libraryPath;
    static boolean alreadyLoaded = false;
    static File librarySystemPath;
    private static final String extractSubFolder = "steamworks4j/";

    private SteamSharedLibraryLoader(String string2) {
        this.libraryPath = string2;
    }

    private String getLibNameWindows(String string2, boolean bl2) {
        return string2 + (bl2 ? "64" : "") + ".dll";
    }

    private String getLibNameLinux(String string2, boolean bl2) {
        return "lib" + string2 + (bl2 ? "64" : "") + ".so";
    }

    private String getLibNameMac(String string2) {
        return "lib" + string2 + ".dylib";
    }

    private void loadLibraries(String ... stringArray) throws IOException {
        String string2 = System.getProperty("os.name");
        String string3 = System.getProperty("os.arch");
        boolean bl2 = string2.contains("Windows");
        boolean bl3 = string2.contains("Linux");
        boolean bl4 = string2.contains("Mac");
        boolean bl5 = string3.equals("amd64") || string3.equals("x86_64");
        String[] stringArray2 = new String[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (bl2) {
                stringArray2[i2] = this.getLibNameWindows(stringArray[i2], bl5);
                continue;
            }
            if (bl3) {
                stringArray2[i2] = this.getLibNameLinux(stringArray[i2], bl5);
                continue;
            }
            if (bl4) {
                stringArray2[i2] = this.getLibNameMac(stringArray[i2]);
                continue;
            }
            throw new IOException("Unrecognized system architecture: " + string2 + ", " + string3);
        }
        if (this.libraryPath == null) {
            String string4 = ".nohash";
            CRC32 cRC32 = new CRC32();
            for (String string5 : stringArray2) {
                string4 = this.crc(cRC32, this.getClass().getResourceAsStream("/" + string5));
            }
            librarySystemPath = SteamSharedLibraryLoader.discoverExtractLocation(extractSubFolder + string4, UUID.randomUUID().toString());
            System.out.println("steam librarySystemPath name:" + librarySystemPath);
            if (librarySystemPath == null) {
                throw new IOException("Failed to create temp folder to extract native libraries");
            }
            librarySystemPath = librarySystemPath.getParentFile();
        } else {
            librarySystemPath = new File(this.libraryPath);
        }
        for (String string6 : stringArray2) {
            String string5;
            String string7 = this.libraryPath == null ? this.extractLibrary(librarySystemPath, string6) : librarySystemPath + "/" + string6;
            string5 = new File(string7).getCanonicalPath();
            System.load(string5);
        }
    }

    private String extractLibrary(File file, String string2) throws IOException {
        InputStream inputStream;
        ZipFile zipFile;
        File file2;
        block7: {
            Object object;
            file2 = new File(file, string2);
            zipFile = null;
            if (this.libraryPath != null) {
                System.out.println("steam extractLibrary zip:" + string2);
                zipFile = new ZipFile(this.libraryPath);
                object = zipFile.getEntry(string2);
                inputStream = zipFile.getInputStream((ZipEntry)object);
            } else {
                System.out.println("steam extractLibrary name:" + string2);
                inputStream = SteamSharedLibraryLoader.class.getResourceAsStream("/" + string2);
            }
            if (inputStream == null) {
                throw new IOException("Error extracting " + string2 + " from " + (this.libraryPath != null ? this.libraryPath : "resources"));
            }
            try {
                int n2;
                object = new FileOutputStream(file2);
                byte[] byArray = new byte[4096];
                while ((n2 = inputStream.read(byArray)) != -1) {
                    ((FileOutputStream)object).write(byArray, 0, n2);
                }
                ((FileOutputStream)object).close();
            }
            catch (IOException iOException) {
                if (file2.exists()) break block7;
                throw iOException;
            }
        }
        inputStream.close();
        if (zipFile != null) {
            zipFile.close();
        }
        return file2.getAbsolutePath();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String crc(CRC32 cRC32, InputStream inputStream) {
        byte[] byArray = new byte[4096];
        try {
            int n2;
            while ((n2 = inputStream.read(byArray)) != -1) {
                cRC32.update(byArray, 0, n2);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException iOException) {}
        }
        return Long.toHexString(cRC32.getValue());
    }

    static boolean loadLibraries(String string2) throws SteamException {
        if (alreadyLoaded) {
            return true;
        }
        SteamSharedLibraryLoader steamSharedLibraryLoader = new SteamSharedLibraryLoader(string2);
        try {
            steamSharedLibraryLoader.loadLibraries("steam_api", "steamworks4j");
        }
        catch (Throwable throwable) {
            throw new SteamException(throwable);
        }
        alreadyLoaded = true;
        return true;
    }

    private static File discoverExtractLocation(String string2, String string3) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/" + string2, string3);
        if (SteamSharedLibraryLoader.canWrite(file)) {
            return file;
        }
        try {
            File file2 = File.createTempFile(string2, null);
            if (file2.delete() && SteamSharedLibraryLoader.canWrite(file = new File(file2, string3))) {
                return file;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        file = new File(System.getProperty("user.home") + "/." + string2, string3);
        if (SteamSharedLibraryLoader.canWrite(file)) {
            return file;
        }
        file = new File(".tmp/" + string2, string3);
        if (SteamSharedLibraryLoader.canWrite(file)) {
            return file;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean canWrite(File file) {
        File file2 = file.getParentFile();
        if (file.exists()) {
            if (!file.canWrite() || !SteamSharedLibraryLoader.canExecute(file)) {
                return false;
            }
        } else {
            if (!file2.exists() && !file2.mkdirs()) {
                return false;
            }
            if (!file2.isDirectory()) {
                return false;
            }
        }
        File file3 = new File(file2, UUID.randomUUID().toString());
        try {
            new FileOutputStream(file3).close();
            boolean bl2 = SteamSharedLibraryLoader.canExecute(file3);
            return bl2;
        }
        catch (IOException iOException) {
            boolean bl3 = false;
            return bl3;
        }
        finally {
            file3.delete();
        }
    }

    private static boolean canExecute(File file) {
        try {
            if (file.canExecute()) {
                return true;
            }
            if (file.setExecutable(true)) {
                return file.canExecute();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }
}

