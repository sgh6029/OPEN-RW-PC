/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.Locale;

public class al {
    public static ArrayList a(String string2, String string3, String string4, boolean bl2) {
        int n2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList = new ArrayList<String>();
        char c2 = string3.charAt(0);
        char c3 = string4.charAt(0);
        int n3 = string3.length();
        int n4 = string4.length();
        int n5 = string2.length();
        for (int i2 = 0; i2 < n5; ++i2) {
            char c4 = string2.charAt(i2);
            if (c4 == '(') {
                ++n2;
            } else if (c4 == ')') {
                --n2;
            }
            if (n2 == 0) {
                if (!(c2 != c4 || n3 != 1 && string2.indexOf(string3, i2) != i2 || bl2 && (al.b(string2, i2 - 1) || al.b(string2, i2 + string3.length())))) {
                    arrayList.add(stringBuffer.toString());
                    stringBuffer = new StringBuffer();
                    i2 += string3.length() - 1;
                    continue;
                }
                if (!(c3 != c4 || n4 != 1 && string2.indexOf(string4, i2) != i2 || bl2 && (al.b(string2, i2 - 1) || al.b(string2, i2 + string4.length())))) {
                    arrayList.add(stringBuffer.toString());
                    stringBuffer = new StringBuffer();
                    i2 += string4.length() - 1;
                    continue;
                }
            }
            stringBuffer.append(c4);
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }

    public static ArrayList a(String string2, String string3, boolean bl2, boolean bl3) {
        int n2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList = new ArrayList<String>();
        char c2 = string3.charAt(0);
        int n3 = string3.length();
        int n4 = string2.length();
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        if (string3.equals("-")) {
            bl7 = true;
        }
        int n5 = 0;
        int n6 = 0;
        String string4 = string2;
        if (bl3) {
            string4 = string2.toLowerCase(Locale.ROOT);
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            boolean bl8;
            char c3 = string4.charAt(i2);
            char c4 = string2.charAt(i2);
            if (n6 != 32) {
                n5 = n6;
            }
            n6 = c3;
            boolean bl9 = bl4;
            bl4 = false;
            if (!bl9) {
                if (c3 == '\\') {
                    bl4 = true;
                }
                if (!bl6 && c3 == '\'') {
                    boolean bl10 = bl5 = !bl5;
                }
                if (!bl5 && c3 == '\"') {
                    bl6 = !bl6;
                }
            }
            boolean bl11 = bl8 = bl5 || bl6;
            if (!bl8) {
                if (c3 == '(') {
                    ++n2;
                } else if (c3 == ')') {
                    --n2;
                }
                if (!(n2 != 0 || c2 != c3 || n3 != 1 && string4.indexOf(string3, i2) != i2 || bl2 && (al.b(string2, i2 - 1) || al.b(string2, i2 + string3.length())) || bl7 && (n5 == 42 || n5 == 47 || n5 == 43))) {
                    arrayList.add(stringBuffer.toString());
                    stringBuffer.setLength(0);
                    i2 += string3.length() - 1;
                    continue;
                }
            }
            stringBuffer.append(c4);
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }

   public static ArrayList a(String var0, String var1, boolean var2) {
      int var3 = 0;
      char[] var4 = new char[5];
      StringBuffer var5 = new StringBuffer();
      ArrayList var6 = new ArrayList();
      char var7 = var1.charAt(0);
      int var8 = var1.length();
      int var9 = var0.length();

      for(int var10 = 0; var10 < var9; ++var10) {
         char var11 = var0.charAt(var10);
         byte var12 = 0;
         char var13 = 0;
         if (var11 == '(') {
            var12 = 40;
         } else if (var11 == ')') {
            var13 = '(';
         } else if (var11 == '[') {
            var12 = 91;
         } else if (var11 == ']') {
            var13 = '[';
         }

         if (var12 != 0) {
            ++var3;
            if (var3 >= var4.length) {
               int var14 = var4.length;
               int var15 = var14 + 5;
               char[] var16 = new char[var15];
               System.arraycopy(var4, 0, var16, 0, var14);
               var4 = var16;
            }

            var4[var3] = (char)var12;
         } else if (var13 != 0) {
            if (var4[var3] == var13) {
               --var3;
            } else {
               GameEngine.log("Bad bracket order: '" + var0 + "' at index:" + var10 + " got " + var13 + " type expected: " + var4[var3]);
            }
         }

         if (var3 == 0) {
            boolean var17 = false;
            if (var7 == var11 && (var8 == 1 || var0.indexOf(var1, var10) == var10)) {
               var17 = true;
            }

            if (var17 && (!var2 || !b(var0, var10 - 1) && !b(var0, var10 + var1.length()))) {
               var6.add(var5.toString());
               var5 = new StringBuffer();
               var10 += var1.length() - 1;
               continue;
            }
         }

         var5.append(var11);
      }

      var6.add(var5.toString());
      return var6;
   }

    public static String[] b(String string2, String string3, boolean bl2) {
        if (!string2.contains(string3)) {
            return new String[]{string2};
        }
        return (String[]) al.a(string2, string3, bl2).toArray(new String[0]);
    }

    public static int a(String string2, int n2) {
        char c2 = string2.charAt(n2);
        if (c2 != '(') {
            GameEngine.b("getBracketEnd: Did not start on a bracket");
            return -1;
        }
        if (n2 + 1 >= string2.length()) {
            return -1;
        }
        int n3 = 1;
        for (int i2 = n2 + 1; i2 < string2.length(); ++i2) {
            char c3 = string2.charAt(i2);
            if (c3 == '(') {
                ++n3;
            } else if (c3 == ')') {
                --n3;
            }
            if (n3 != 0) continue;
            return i2;
        }
        return -1;
    }

    public static int a(String string2) {
        int n2 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        for (char c2 : string2.toCharArray()) {
            boolean bl5 = bl2;
            bl2 = false;
            if (!bl5) {
                if (c2 == '\\') {
                    bl2 = true;
                }
                if (!bl4 && c2 == '\'') {
                    boolean bl6 = bl3 = !bl3;
                }
                if (!bl3 && c2 == '\"') {
                    boolean bl7 = bl4 = !bl4;
                }
            }
            if (bl3 || bl4) continue;
            if (c2 == '(') {
                ++n2;
                continue;
            }
            if (c2 != ')') continue;
            --n2;
        }
        return n2;
    }

    public static int b(String string2) {
        int n2 = 0;
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            char c2 = string2.charAt(i2);
            if (c2 == '(') {
                ++n2;
                continue;
            }
            if (c2 != ')') continue;
            --n2;
        }
        return n2;
    }

    public static String[] a(String string2, char c2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c3 : string2.toCharArray()) {
            boolean bl5 = bl2;
            bl2 = false;
            if (!bl5) {
                if (c3 == '\\') {
                    bl2 = true;
                }
                if (!bl4 && c3 == '\'') {
                    boolean bl6 = bl3 = !bl3;
                }
                if (!bl3 && c3 == '\"') {
                    boolean bl7 = bl4 = !bl4;
                }
            }
            if (!(c3 != c2 || bl3 || bl4 || bl3)) {
                arrayList.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            stringBuilder.append(c3);
        }
        if (stringBuilder.length() != 0) {
            arrayList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return arrayList.toArray(new String[0]);
    }

    public static String[] b(String string2, char c2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        boolean bl2 = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c3 : string2.toCharArray()) {
            boolean bl3 = bl2;
            bl2 = false;
            if (!bl3) {
                if (c3 == '\\') {
                    bl2 = true;
                    continue;
                }
                if (c3 == c2) {
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    continue;
                }
            }
            stringBuilder.append(c3);
        }
        if (stringBuilder.length() != 0) {
            arrayList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        if (arrayList.size() == 0) {
            arrayList.add("");
        }
        return arrayList.toArray(new String[0]);
    }

    public static String a(String[] stringArray) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl2 = true;
        for (String string2 : stringArray) {
            if (bl2) {
                bl2 = false;
            } else {
                stringBuffer.append(",");
            }
            if (string2.contains("\\")) {
                string2 = string2.replace("\\", "\\\\");
            }
            if (string2.contains(",")) {
                string2 = string2.replace(",", "\\,");
            }
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    public static int a(String string2, String string3) {
        return al.a(string2, string3, 0);
    }

    public static int a(String string2, String string3, int n2) {
        int n3 = 0;
        char c2 = string3.charAt(0);
        int n4 = string3.length();
        for (int i2 = n2; i2 < string2.length(); ++i2) {
            char c3 = string2.charAt(i2);
            if (c3 == '(') {
                ++n3;
            } else if (c3 == ')') {
                --n3;
            }
            if (n3 != 0 || c2 != c3 || n4 != 1 && string2.indexOf(string3, i2) != i2) continue;
            return i2;
        }
        return -1;
    }

   public static int b(String var0, String var1, int var2) {
      int var3 = 0;
      char[] var4 = new char[5];
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      char var8 = var1.charAt(0);
      int var9 = var1.length();

      for(int var10 = var2; var10 < var0.length(); ++var10) {
         char var11 = var0.charAt(var10);
         boolean var12 = var5;
         var5 = false;
         if (!var12) {
            if (var11 == '\\') {
               var5 = true;
            }

            if (!var7 && var11 == '\'') {
               var6 = !var6;
            }

            if (!var6 && var11 == '"') {
               var7 = !var7;
            }
         }

         boolean var13 = var6 || var7;
         if (!var13) {
            byte var15 = 0;
            char var16 = 0;
            if (var11 == '(') {
               var15 = 40;
            } else if (var11 == ')') {
               var16 = '(';
            } else if (var11 == '[') {
               var15 = 91;
            } else if (var11 == ']') {
               var16 = '[';
            }

            if (var15 != 0) {
               ++var3;
               if (var3 >= var4.length) {
                  int var17 = var4.length;
                  int var18 = var17 + 5;
                  char[] var19 = new char[var18];
                  System.arraycopy(var4, 0, var19, 0, var17);
                  var4 = var19;
               }

               var4[var3] = (char)var15;
            } else if (var16 != 0) {
               if (var4[var3] == var16) {
                  --var3;
               } else {
                  GameEngine.log("Bad bracket order: '" + var0 + "' at index:" + var10 + " got " + var16 + " type expected: " + var4[var3]);
               }
            }

            if ((var3 == 0 || var3 == 0) && var8 == var11 && (var9 == 1 || var0.indexOf(var1, var10) == var10)) {
               return var10;
            }
         }
      }

      return -1;
   }
    public static boolean b(String string2, int n2) {
        if (n2 < 0 || n2 >= string2.length()) {
            return false;
        }
        char c2 = string2.charAt(n2);
        return Character.isLetter(c2) || Character.isDigit(c2);
    }

    public static int a(String string2, String string3, String string4) {
        int n2 = string2.indexOf(string3);
        int n3 = string2.indexOf(string4);
        if (n2 == -1) {
            return n3;
        }
        if (n3 == -1) {
            return n2;
        }
        if (n2 < n3) {
            return n2;
        }
        return n3;
    }

    public static int a(String string2, int n2, String[] stringArray) {
        int n3 = -1;
        for (String string3 : stringArray) {
            int n4 = al.a(string2, string3, n2);
            if (n4 == -1 || n3 <= n4 && n3 != -1) continue;
            n3 = n4;
        }
        return n3;
    }

    public static String c(String string2) {
        boolean bl2 = false;
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            char c2 = string2.charAt(i2);
            if (c2 == '-') {
                bl2 = !bl2;
                continue;
            }
            if (c2 == '+' || c2 == ' ') continue;
            if (bl2) {
                return "-" + string2.substring(i2);
            }
            if (i2 == 0) {
                return string2;
            }
            return string2.substring(i2);
        }
        return string2;
    }

    public static String[] b(String string2, String string3) {
        int n2 = string2.indexOf(string3);
        if (n2 == -1) {
            return null;
        }
        String string4 = string2.substring(0, n2);
        String string5 = string2.substring(n2 + string3.length());
        return new String[]{string4, string5};
    }

    public static String[] c(String string2, String string3) {
        int n2 = al.b(string2, string3, 0);
        if (n2 == -1) {
            return null;
        }
        String string4 = string2.substring(0, n2);
        String string5 = string2.substring(n2 + string3.length());
        return new String[]{string4, string5};
    }

    public static final String d(String string2) {
        if (string2 == null) {
            return null;
        }
        if (string2.length() < 1) {
            return string2.toUpperCase();
        }
        return string2.substring(0, 1).toUpperCase(Locale.ROOT) + string2.substring(1).toLowerCase(Locale.ROOT);
    }

    public static String[] e(String string2) {
        return al.b(string2, ',');
    }
}

