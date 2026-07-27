/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.i;

import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.i.a;
import com.corrodinggames.rts.gameFramework.storage.g;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class b
implements Comparable {
    public int a;
    public static int b = 1;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public long k;
    boolean l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public String s;
    public String t;
    public String u;
    public String v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;
    public boolean A = false;
    public boolean B = true;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public long G;
    public long H;
    public int I;
    public int J;
    public static int K = 1;
    public int L = K++;
    public String M;
    public boolean N;
    public boolean O;
    public int P;
    ArrayList Q = new ArrayList();
    public String R;
    public String S;
    public String T;
    public ArrayList U = new ArrayList();
    public ArrayList V = new ArrayList();

    public b() {
        this.a = b++;
    }

    public String a() {
        if (this.s != null) {
            return this.s;
        }
        if (this.t != null) {
            return this.t;
        }
        return this.c;
    }

    public String b() {
        String string2 = this.a();
        return com.corrodinggames.rts.gameFramework.GameUtils.a(string2, 25);
    }

    public String c() {
        String string2 = this.a();
        return com.corrodinggames.rts.gameFramework.GameUtils.a(string2, 40);
    }

    public int d() {
        return this.L;
    }

    public String e() {
        return this.f();
    }

    public String f() {
        String string2 = "";
        if (this.u != null) {
            string2 = string2 + this.u;
        }
        String string3 = "RAM:" + this.s();
        if (this.n != null) {
            string3 = string3 + " Storage: slow external unpacked";
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.at() && this.q != null && com.corrodinggames.rts.gameFramework.storage.a.a(this.q) && !this.j) {
            string3 = string3 + " Warning: slow external storage";
        }
        string2 = string2 + "\n (" + string3 + ")";
        return string2;
    }

    public String g() {
        if (this.y) {
            return this.q;
        }
        return com.corrodinggames.rts.gameFramework.storage.a.e(this.q);
    }

    public String h() {
        if (this.y) {
            return this.p;
        }
        return com.corrodinggames.rts.gameFramework.storage.a.e(this.p);
    }

    public String i() {
        File file = new File(this.g());
        return file.getAbsolutePath();
    }

    public String j() {
        return this.q;
    }

    public String k() throws IOException {
        File file = new File(this.g());
        return file.getCanonicalPath();
    }

    public String l() {
        String string2 = this.S;
        if (this.T != null) {
            if (string2 == null) {
                string2 = "";
            }
            string2 = string2 + this.T;
        }
        if (string2 == null && this.U.size() > 0) {
            string2 = "";
            int n2 = 0;
            int n3 = 0;
            for (String string3 : ((ArrayList<String>)this.U) ){
                if (n3 <= 2) {
                    string2 = string2 == null ? string3 : string2 + "\n" + string3;
                } else {
                    ++n2;
                }
                ++n3;
            }
            if (n2 > 0) {
                string2 = string2 + "\n" + n2 + " more warnings...";
            }
        }
        if (!(this.C && string2 == null || this.D || string2 != null)) {
            if (string2 == null) {
                string2 = "";
            }
            string2 = string2 + "Not yet loaded, reload needed";
        }
        return string2;
    }

    public boolean m() {
        return !this.f && this.R == null;
    }

    public void a(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.b("Adding error for mod: " + this.b() + (this.m() ? "" : "(disabled)") + ": " + string2);
        if (this.R == null) {
            if (!this.f) {
                int n2;
                GameEngine l2 = GameEngine.getInstance();
                String string3 = string2;
                if (string3 != null && (!string3.contains(this.a()) || string3.contains(this.b()))) {
                    string3 = "Error loading mod '" + this.b() + "': " + string3;
                }
                if ((n2 = l2.bZ.d(this.b())) > 1) {
                    string3 = string3 + " (NOTE: You have " + n2 + " mods with the same title: '" + this.b() + "' this might make debugging tricky)";
                }
                l2.i(string3);
            }
            com.corrodinggames.rts.gameFramework.GameEngine.log("Disabling mod due to error: " + this.b() + " path:" + this.i());
            this.R = string2;
        }
        this.V.add(string2);
    }

    public void b(String string2) {
        if (this.U.contains(string2)) {
            return;
        }
        this.U.add(string2);
    }

    public String a(String string2, int n2) {
        if (n2 > 4) {
            return null;
        }
        String[] stringArray = com.corrodinggames.rts.gameFramework.storage.a.h(string2);
        if (stringArray == null) {
            return null;
        }
        for (String string3 : stringArray) {
            if (!string3.equalsIgnoreCase("mod-info.txt")) continue;
            return string2 + "/" + "mod-info.txt";
        }
        if (stringArray.length > 5) {
            return null;
        }
        for (String string3 : stringArray) {
            String string4;
            String string5 = string2 + "/" + string3;
            if (!com.corrodinggames.rts.gameFramework.storage.a.f(string5) || (string4 = this.a(string5, n2 + 1)) == null) continue;
            return string4;
        }
        return null;
    }

    public void n() {
        if (com.corrodinggames.rts.gameFramework.GameEngine.getInstance().isExtraSafeMode2Enabled()) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("SAFE MODE: skipping setSourceFolder");
            return;
        }
        String string2 = this.q + "/" + "mod-info.txt";
        if (!com.corrodinggames.rts.gameFramework.storage.g.f("mods-info", string2)) {
            String string3 = this.q;
            if (string3 == null) {
                com.corrodinggames.rts.gameFramework.GameEngine.log("setSourceFolder: sourceFolder==null");
                return;
            }
            String[] stringArray = com.corrodinggames.rts.gameFramework.storage.g.d("mods-dir-search", string3);
            if (stringArray != null && stringArray.length == 1) {
                String string4 = stringArray[0];
                String string5 = string3 + "/" + string4;
                String string6 = string5 + "/" + "mod-info.txt";
                if (com.corrodinggames.rts.gameFramework.storage.a.f(string5) && com.corrodinggames.rts.gameFramework.storage.a.i(string6)) {
                    com.corrodinggames.rts.gameFramework.GameEngine.log("Changing mod sourceFolder to:" + string5);
                    this.q = string5;
                }
            }
        }
    }

    public IniFile o() {
        Object object;
        InputStream inputStream;
        if (this.q == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("No source yet for mod: " + this.c);
            return null;
        }
        String string2 = this.q + "/" + "mod-info.txt";
        try {
            inputStream = this.j ? com.corrodinggames.rts.gameFramework.storage.g.e("mods-info", string2) : com.corrodinggames.rts.gameFramework.storage.a.k(string2);
        }
        catch (Exception exception) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Error loading mod info for: " + this.c + " at " + string2);
            exception.printStackTrace();
            this.b("Error loading mod-info.txt: " + exception.getMessage());
            return null;
        }
        if (inputStream == null && (object = this.a(this.q, 1)) != null) {
            AssetInputStream j2 = com.corrodinggames.rts.gameFramework.storage.a.k(string2);
            if (j2 != null) {
                com.corrodinggames.rts.gameFramework.GameEngine.a("mod-info.txt cache seems to be invalid for: " + string2);
                com.corrodinggames.rts.gameFramework.storage.g.c("mods-info", string2);
                inputStream = j2;
            } else {
                String string3 = "No mod info at " + com.corrodinggames.rts.gameFramework.storage.a.d(string2) + " but found one nested at: " + com.corrodinggames.rts.gameFramework.storage.a.d((String)object) + " (Hint: This mod might have been extracted with an extra folder)";
                this.a(string3);
            }
        }
        if (inputStream == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("No mod info for: " + this.c + " at " + string2);
            return null;
        }
        try {
            object = new IniFile(inputStream, string2);
        }
        catch (IOException iOException) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Error loading mod info for: " + this.c + " at " + string2);
            iOException.printStackTrace();
            this.b("Error loading mod-info.txt: " + iOException.getMessage());
            return null;
        }
        return (IniFile) object;
    }

    public String p() {
        String string2 = this.c("thumbnail");
        if (string2 != null) {
            string2 = this.i() + "/" + string2;
            return string2;
        }
        return null;
    }

    public ArrayList q() {
        return this.Q;
    }

    public String c(String string2) {
        String string3 = "mod";
        IniFile ab2 = this.o();
        if (ab2 == null) {
            return null;
        }
        return ab2.b(string3, string2, (String)null);
    }

   public void r() {
      if (com.corrodinggames.rts.gameFramework.GameEngine.getInstance().isExtraSafeMode2Enabled()) {
         com.corrodinggames.rts.gameFramework.GameEngine.log("SAFE MODE: refreshData: Skipping mod read");
         this.u = "<< SAFE MODE ACTIVE: MOD DATA SKIPPED. RESTART IN NORMAL MODE. >>";
      } else {
         IniFile var1 = this.o();
         String var5;
         if (var1 != null) {
            String var3 = "mod";
            String var4 = "music";
            this.s = var1.b(var3, "title", (String)null);
            this.u = var1.b(var3, "description", (String)null);
            if (this.u != null && this.u.contains("\\n")) {
               this.u = this.u.replace("\\n", "\n");
            }

            this.v = var1.b(var3, "minVersion", (String)null);
            if (this.v != null && !this.v.trim().equals("")) {
               try {
                  com.corrodinggames.rts.gameFramework.i.a.a(this.v);
               } catch (bo var14) {
                  String var6 = var14.getMessage();
                  this.a(var6);
               }
            }

            this.M = var1.b(var4, "sourceFolder", (String)null);
            this.N = var1.a(var4, "whenUsingUnitsFromThisMod_playExclusively", false);
            this.O = var1.a(var4, "addToNormalPlaylist", false);
            if (this.M != null && this.m()) {
               com.corrodinggames.rts.gameFramework.GameEngine.log("Loading music for: " + this.a());
               var5 = com.corrodinggames.rts.gameFramework.GameUtils.b(this.q, this.M);
               String[] var17 = com.corrodinggames.rts.gameFramework.storage.g.d("mods-dir-music", var5);
               if (var17 == null) {
                  this.b("Could not read target music folder: " + com.corrodinggames.rts.gameFramework.storage.a.e(var5));
               } else {
                  ArrayList var7 = new ArrayList();
                  String[] var8 = var17;
                  int var9 = var17.length;

                  for(int var10 = 0; var10 < var9; ++var10) {
                     String var11 = var8[var10];
                     if (var11.toLowerCase().endsWith(".ogg")) {
                        String var12 = com.corrodinggames.rts.gameFramework.GameUtils.b(var5, var11);
                        if (!this.Q.contains(var12)) {
                           com.corrodinggames.rts.gameFramework.GameEngine.log("Found music track: " + var11);
                        }

                        var7.add(var12);
                     }
                  }

                  this.Q = var7;
                  if (this.Q.size() == 0) {
                     this.b("Could not find any .ogg files in music folder: " + com.corrodinggames.rts.gameFramework.storage.a.e(var5));
                  }
               }
            }

            this.r = true;
         }

         String var2 = this.w();
         File var15 = new File(var2);
         if (var15.exists() && !var15.isDirectory()) {
            IniFile var16 = null;

            try {
               var16 = new IniFile(var2);
            } catch (IOException var13) {
               var13.printStackTrace();
               this.b("IO error reading: " + com.corrodinggames.rts.gameFramework.storage.a.e(var2));
            }

            if (var16 != null) {
               var5 = "steam";
               this.k = var16.a(var5, "id", 0L);
            }
         }

      }
   }

    private String w() {
        return this.g() + "/steam.dat";
    }

    public boolean a(long l2) {
        this.k = l2;
        String string2 = this.w();
        try {
            PrintWriter printWriter = new PrintWriter(string2);
            printWriter.println("[steam]");
            printWriter.println("id: " + l2);
            printWriter.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            com.corrodinggames.rts.gameFramework.GameEngine.getInstance().i("IO error: Failed to save workshop id for mod at: " + string2);
            return false;
        }
        return true;
    }

    public String s() {
        String string2 = "";
        string2 = string2 + String.format("%.2f", Float.valueOf((float)((double)(this.G + this.H) / 1000.0 / 1000.0))) + " mb" + (this.C ? " - disabled" : "");
        return string2;
    }

    public void t() {
        com.corrodinggames.rts.gameFramework.GameEngine.log("Mod: '" + this.a() + "' - Memory use:" + this.s() + " " + (this.m() ? "" : " (disabled)"));
    }

    public boolean u() {
        com.corrodinggames.rts.gameFramework.GameEngine.log("Trying to delete mod: '" + this.a() + "'");
        String string2 = this.h();
        com.corrodinggames.rts.gameFramework.GameEngine.log("sourceFolder: '" + string2 + "'");
        if (!this.v()) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Mod: '" + this.a() + "' - Cannot be deleted");
            return false;
        }
        File file = new File(string2);
        if (!com.corrodinggames.rts.gameFramework.storage.a.i(file.getAbsolutePath())) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("Mod: '" + this.a() + "' - cannot delete: Not a file");
            return false;
        }
        boolean bl2 = com.corrodinggames.rts.gameFramework.storage.a.b(file);
        com.corrodinggames.rts.gameFramework.GameEngine.log("Delete result: " + bl2);
        return bl2;
    }

    public boolean v() {
        if (this.z) {
            return false;
        }
        if (com.corrodinggames.rts.gameFramework.GameEngine.isDebugVersionStatic2 && this.j) {
            return true;
        }
        return com.corrodinggames.rts.gameFramework.GameEngine.at() && this.j;
    }

    public int a(b b2) {
        b b3 = this;
        if (b2 == null) {
            return 0;
        }
        int n2 = b3.x;
        int n3 = b2.x;
        if (n2 != n3) {
            return n2 - n3;
        }
        String string2 = b3.a();
        String string3 = b2.a();
        if (string2 == null) {
            string2 = "";
        }
        if (string3 == null) {
            string3 = "";
        }
        return string2.compareTo(string3);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((b)object);
    }
}
