/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareEqualBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.CompareJoinerBoolean$CompareNotEqualBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$JoinerBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$NotBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ArrayContextReader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$DefaultContextReader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ParameterMapping;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ParameterMapping$FieldOrMethod;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$VoidContextReader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$StaticString;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.al;
import com.corrodinggames.rts.gameFramework.utility.m;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicBooleanLoader {
    public static final boolean TRACE = false;
    static Pattern patternSingleQuote = Pattern.compile("'(.*)'");
    static Pattern patternDoubleQuote = Pattern.compile("\"(.*)\"");
    static Pattern patternInteger = Pattern.compile("(-?\\d*)");
    static Pattern patternFloat = Pattern.compile("(-?\\d*\\.\\d*)");
    static final LogicBooleanLoader$LogicBooleanContext defaultContextReader = new LogicBooleanLoader$DefaultContextReader();
    static final LogicBooleanLoader$LogicBooleanContext voidContextReader = new LogicBooleanLoader$VoidContextReader(
            null);
    static final LogicBooleanLoader$LogicBooleanContext voidNumberContextReader = new LogicBooleanLoader$VoidContextReader(
            "Number");
    static final LogicBooleanLoader$LogicBooleanContext voidBoolContextReader = new LogicBooleanLoader$VoidContextReader(
            "Bool");
    static final LogicBooleanLoader$LogicBooleanContext voidArrayContextReader = new LogicBooleanLoader$VoidContextReader(
            "Array element");
    static final LogicBooleanLoader$LogicBooleanContext numberArrayContextReader = new LogicBooleanLoader$ArrayContextReader(
            LogicBoolean$ReturnType.numberArray);
    static final LogicBooleanLoader$LogicBooleanContext boolArrayContextReader = new LogicBooleanLoader$ArrayContextReader(
            LogicBoolean$ReturnType.boolArray);
    static final LogicBooleanLoader$LogicBooleanContext unitArrayContextReader = new LogicBooleanLoader$ArrayContextReader(
            LogicBoolean$ReturnType.unitArray);

    public static boolean isEmptyIgnoringPlusMinus(String string) {
        int n = 0;
        while (n < string.length()) {
            char c = string.charAt(n);
            if (c != '-' && c != '+') {
                if (c != ' ')
                    return false;
            }
            ++n;
        }
        return true;
    }

    public static LogicBoolean parseNumberBlock(l l2, String string) {
        LogicBoolean logicBoolean = LogicBooleanLoader.parseBooleanBlock(l2, string, false);
        if (logicBoolean == null)
            return logicBoolean;
        if (logicBoolean.getReturnType() == LogicBoolean$ReturnType.number)
            return logicBoolean;
        throw new RuntimeException("Expected number for: '" + string + "' got a "
                + (Object) ((Object) logicBoolean.getReturnType()) + " type");
    }

    public static LogicBoolean parseBooleanBlock(l var0, String var1, boolean var2) {
        int var3 = al.a(var1);
        if (var3 != 0) {
            if (var3 > 0) {
                throw new RuntimeException("Brackets unbalanced for: '" + var1 + "'. A '(' was not closed.");
            }

            if (var3 < 0) {
                throw new RuntimeException("Brackets unbalanced for: '" + var1 + "'. Too many ')'.");
            }
        }

        var1 = var1.trim();
        var1 = breakOuterLayerBrackets(var1);
        if (var1.length() > 1 && var1.charAt(0) == '-') {
            boolean var4 = false;

            for (int var5 = 1; var5 < var1.length(); ++var5) {
                char var6 = var1.charAt(var5);
                if (var6 != ' ') {
                    var4 = !Character.isDigit(var6);
                }
            }

            if (var4) {
                var1 = "0" + var1;
            }
        }

        String var25 = var1.toLowerCase(Locale.ROOT);
        String[] var26 = new String[] { "==", "!=", "<=", ">=", "<", ">" };
        String[] var27 = new String[] { "or", "and", "==", "!=", "<=", ">=", "<", ">", "%", "-", "+", "*", "/", "=" };
        String[] var7 = var27;
        int var8 = var27.length;

        int var15;
        String var16;
        boolean var17;
        int var18;
        boolean var19;
        String var50;
        for (int var9 = 0; var9 < var8; ++var9) {
            String var10 = var7[var9];
            if (GameUtils.c(var25, var10)) {
                boolean var11 = false;
                boolean var12 = false;
                if (var10.equals("and") || var10.equals("or")) {
                    var11 = true;
                    var12 = true;
                }

                ArrayList var13;
                if (var10.equals("<>")) {
                    int var14 = al.a(var1, 0, var26);
                    var13 = new ArrayList();
                    var13.add(var1.substring(0, var14));
                    var15 = var14 + 2;
                    if (var15 > var1.length() - 1) {
                        var15 = var1.length() - 1;
                    }

                    var16 = var1.substring(var14, var15);
                    if (!var16.endsWith("=")) {
                        var16 = var16.substring(0, 1);
                    }

                    var13.add(var1.substring(var14 + var16.length()));
                    var10 = var16;
                } else if (var12) {
                    var13 = al.a(var1, var10, var11, true);
                } else {
                    var13 = al.a(var1, var10, var11, false);
                }

                if (var13.size() != 1) {
                    if (var10.equals("=")) {
                        throw new RuntimeException("Unexpected assignment operator: '=', use '==' for comparison");
                    }

                    if (!((String) var13.get(0)).equals("") || var13.size() != 2
                            || !var10.equals("+") && !var10.equals("-")) {
                        ArrayList var38 = new ArrayList();
                        LogicBoolean$JoinerBoolean var41 = LogicBoolean$JoinerBoolean.getNewJoiner(var10);
                        boolean var42 = var41.requireBooleanChildren();
                        if (var42 && (var41 instanceof CompareJoinerBoolean$CompareNotEqualBoolean
                                || var41 instanceof CompareJoinerBoolean$CompareEqualBoolean)) {
                            com.corrodinggames.rts.gameFramework.GameEngine.log(var41.type()
                                    + " was set to require boolean. Workaround triggered. requireBooleanChildren:"
                                    + var41.requireBooleanChildren());
                            var42 = false;
                        }

                        var17 = false;
                        var18 = -1;
                        if (var10.equals("+") || var10.equals("-")) {
                            var19 = false;
                            Iterator var20 = var13.iterator();

                            String var21;
                            while (var20.hasNext()) {
                                var21 = (String) var20.next();
                                boolean var22 = isEmptyIgnoringPlusMinus(var21);
                                if (var22) {
                                    var19 = true;
                                    break;
                                }
                            }

                            if (var19) {
                                ArrayList var49 = new ArrayList();
                                var21 = "";
                                Iterator var54 = var13.iterator();

                                while (var54.hasNext()) {
                                    String var23 = (String) var54.next();
                                    if (isEmptyIgnoringPlusMinus(var23)) {
                                        var21 = var21 + var23 + var10;
                                    } else {
                                        if (!var21.equals("")) {
                                            var23 = var21 + var23;
                                            var21 = "";
                                        }

                                        var49.add(var23);
                                    }
                                }

                                if (!var21.equals("")) {
                                    throw new RuntimeException("Unexpected empty last element using: " + var10);
                                }

                                var13 = var49;
                            }
                        }

                        if (var13.size() != 1) {
                            Iterator var47 = var13.iterator();

                            while (var47.hasNext()) {
                                var50 = (String) var47.next();
                                ++var18;
                                if (var50.equals("")) {
                                    if (var18 == 0) {
                                        throw new RuntimeException("Unexpected empty element before: " + var10);
                                    }

                                    throw new RuntimeException("Unexpected empty element after: " + var10);
                                }

                                LogicBoolean var55;
                                try {
                                    var55 = parseBooleanBlock(var0, var50, var42);
                                } catch (BooleanParseException var24) {
                                    throw var24;
                                }

                                if (var55 == null) {
                                    throw new RuntimeException("null on:'" + var1 + "'");
                                }

                                var38.add(var55);
                            }

                            var41.children = (LogicBoolean[]) var38.toArray(new LogicBoolean[0]);
                            return var41.validateAndOptimize(var10, "", var1,
                                    (LogicBooleanLoader$LogicBooleanContext) null, var2);
                        }
                    }
                }
            }
        }

        String var28;
        if (var25.startsWith("not ")) {
            var28 = var1.substring("not ".length());
            LogicBoolean var32 = parseBooleanBlock(var0, var28, true);
            LogicBoolean$NotBoolean var34 = new LogicBoolean$NotBoolean(var32);
            return var34.validateAndOptimize("not", "", var28, (LogicBooleanLoader$LogicBooleanContext) null, var2);
        } else {
            if (var1.length() > 0) {
                var28 = var1;
                if (var1.startsWith("+")) {
                    var28 = var1.substring(1).trim();
                }

                var28 = al.c(var28);
                if (GameUtils.r(var28)) {
                    if (var2) {
                        throw new RuntimeException("Expected a boolean type here, not number: " + var28);
                    }

                    return LogicBoolean$StaticValueBoolean.getStaticNumber(var28);
                }

                String var29 = GameUtils.p(var1);
                if (var29 != null) {
                    if (var2) {
                        throw new RuntimeException("Expected a boolean type here, not string: " + var1);
                    }

                    return new LogicString$StaticString(var29);
                }
            }

            boolean var30 = false;
            boolean var31 = false;
            if (var1.startsWith("self.")) {
                var1 = var1.substring("self.".length());
                var30 = true;
            }

            String[] var33 = al.b(var1, ".", false);
            m var35 = new m();
            LogicBoolean var36 = null;
            String var37 = null;
            LogicBooleanLoader$LogicBooleanContext var40 = defaultContextReader;
            String var39 = null;

            for (var15 = 0; var15 < var33.length; ++var15) {
                if (var39 != null) {
                    var16 = var39;
                    var39 = null;
                } else {
                    var16 = var33[var15];
                }

                String var46;
                if (GameUtils.b(var16, '[')) {
                    int var43 = al.b(var16, "[", 0);
                    if (var43 != -1) {
                        String var48;
                        if (var43 == 0) {
                            var18 = al.b(var16, "]", 0);
                            if (var18 == -1 || var43 >= var18) {
                                throw new RuntimeException("Unexpected use of square brankets:'" + var16 + "'");
                            }

                            if (var18 < var16.length() - 1 && var18 > 0) {
                                var48 = var16.substring(var43, var18 + 1);
                                var50 = var16.substring(var18 + 1);
                                var39 = var50;
                                --var15;
                                var16 = var48;
                            }

                            if (var43 != 0 || var18 != var16.length() - 1 || var16.length() < 2) {
                                throw new RuntimeException("Error reading square brankets:'" + var16 + "'");
                            }

                            var16 = var16.substring(1, var16.length() - 1);
                            var16 = "get(" + var16 + ")";
                        } else {
                            var46 = var16.substring(0, var43);
                            var48 = var16.substring(var43);
                            var39 = var48;
                            --var15;
                            var16 = var46;
                        }
                    }
                }

                if (var16.equalsIgnoreCase("self")) {
                    if (var31) {
                        throw new RuntimeException("No field:'" + var16 + "' globals");
                    }

                    if (var33.length == 1) {
                        return UnitReference.selfUnitReference;
                    }

                    var30 = true;
                } else if (var15 == 0 && var16.equalsIgnoreCase("game")) {
                    var31 = true;
                } else {
                    var17 = var15 == var33.length - 1;
                    var46 = null;
                    if (var30) {
                        var46 = "self.";
                    }

                    if (var31) {
                        var46 = "game.";
                    }

                    var19 = var2;
                    if (!var17) {
                        var19 = false;
                    }

                    if (var36 != null) {
                        var40 = var36.createContext();
                    }

                    LogicBoolean var52 = var40.parseNextElementInChain(var46, var0, var16, var19, var1, var37, var36);
                    if (var52 == null) {
                        throw new RuntimeException("Null function or field:'" + var16 + "'");
                    }

                    var36 = var52;
                    var37 = var16;
                    var30 = true;
                    var35.add(var52);
                }
            }

            if (var35.size() == 0) {
                throw new RuntimeException("Unknown function:'" + var1 + "'");
            } else {
                LogicBoolean var45 = null;

                for (int var51 = var35.a - 1; var51 >= 0; --var51) {
                    LogicBoolean var44 = (LogicBoolean) var35.get(var51);
                    if (var45 != null) {
                        var44 = var44.setChild(var45);
                    }

                    var45 = var44;
                }

                LogicBoolean$ReturnType var53 = var45.getReturnType();
                if (var53 == LogicBoolean$ReturnType.voidReturn) {
                    var45.throwVoidReturnError(var1);
                    throw new RuntimeException("throwVoidReturnError");
                } else if (var2 && var53 != LogicBoolean$ReturnType.bool) {
                    throw new BooleanParseException("Function:'" + var1
                            + "' is expected to return a boolean type but it returns type: " + var53);
                } else {
                    return var45;
                }
            }
        }
    }

    public static String fixArguments(String string) {
        String string2 = string;
        if ((string2 = string2.trim()).equals("")) {
            return "";
        }
        if (!string2.startsWith("("))
            throw new RuntimeException("Failed to parse function arguments:'" + string2 + "'");
        if (!string2.endsWith(")"))
            throw new RuntimeException("Failed to parse function arguments:'" + string2 + "'");
        string2 = string2.substring(1, string2.length() - 1);
        string2 = string2.trim();
        return string2;
    }

    public static Matcher match(Pattern pattern, String string) {
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches())
            return null;
        return matcher;
    }

    public static void setArgumentsWithMapping(LogicBooleanLoader$ParameterMapping logicBooleanLoader$ParameterMapping,
            Object object, String string, l l2, String string2) {
        String string3;
        LogicBooleanLoader$ParameterMapping$FieldOrMethod logicBooleanLoader$ParameterMapping$FieldOrMethod;
        Object object2;
        if (string2 == null) {
            string2 = object.getClass().getSimpleName();
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        if (string != null && !"".equals(string)) {
            object2 = al.a(string, ",", false);
            int n2 = 0;
            boolean bl = false;
            Iterator iterator = ((ArrayList) object2).iterator();
            while (iterator.hasNext()) {
                String string4;
                String string5;
                String string6 = (String) iterator.next();
                int n3 = al.a(string6, "=");
                if (n3 > 0) {
                    string5 = string6.substring(0, n3);
                    string4 = string6.substring(n3 + 1);
                    bl = true;
                } else {
                    if (bl) {
                        throw new BooleanParseException(
                                string2 + "(): SyntaxError: Cannot use non-keyword arg after keyword arg");
                    }
                    if (logicBooleanLoader$ParameterMapping.numberOfPositionalParameters == 0) {
                        throw new BooleanParseException(
                                string2 + "(): Function doesn't accept any non-keyword arguments.");
                    }
                    if (logicBooleanLoader$ParameterMapping.numberOfPositionalParameters <= n2) {
                        throw new BooleanParseException(string2 + "(): Too many non-keyword arguments. Only "
                                + logicBooleanLoader$ParameterMapping.numberOfPositionalParameters + " accepted.");
                    }
                    string5 = null;
                    for (String string7 : ((Set<String>) logicBooleanLoader$ParameterMapping.parameters.keySet())) {
                        LogicBooleanLoader$ParameterMapping$FieldOrMethod logicBooleanLoader$ParameterMapping$FieldOrMethod2 = (LogicBooleanLoader$ParameterMapping$FieldOrMethod) logicBooleanLoader$ParameterMapping.parameters
                                .get(string7);
                        if (logicBooleanLoader$ParameterMapping$FieldOrMethod2.positionalOffset != n2)
                            continue;
                        string5 = string7;
                        break;
                    }
                    if (string5 == null) {
                        throw new BooleanParseException("Error failed to find non-keyword argument index: " + n2);
                    }
                    string4 = string6;
                }
                String string8 = string5;
                string5 = string5.trim();
                string5 = string5.toLowerCase(Locale.ROOT);
                if (arrayList.contains(string5)) {
                    throw new BooleanParseException(
                            "SyntaxError: Argument '" + (String) string8 + "' has been listed more than once");
                }
                arrayList.add(string5);
                LogicBooleanLoader.setArgumentWithMapping(logicBooleanLoader$ParameterMapping, object, string5, string4,
                        l2);
                ++n2;
            }
        }
        object2 = logicBooleanLoader$ParameterMapping.parameters.keySet().iterator();
        do {
            if (!((Iterator) object2).hasNext())
                return;
            string3 = (String) ((Iterator) object2).next();
            logicBooleanLoader$ParameterMapping$FieldOrMethod = (LogicBooleanLoader$ParameterMapping$FieldOrMethod) logicBooleanLoader$ParameterMapping.parameters
                    .get(string3);
        } while (!logicBooleanLoader$ParameterMapping$FieldOrMethod.required || arrayList.contains(string3));
        throw new BooleanParseException(string2 + "(): SyntaxError: Missing required argument: '" + string3 + "'");
    }

    public static Object getArgumentTextWithMapping(
            LogicBooleanLoader$ParameterMapping$FieldOrMethod logicBooleanLoader$ParameterMapping$FieldOrMethod,
            Object object) {
        if (logicBooleanLoader$ParameterMapping$FieldOrMethod != null
                && logicBooleanLoader$ParameterMapping$FieldOrMethod.field != null) {
            Object object2;
            try {
                object2 = logicBooleanLoader$ParameterMapping$FieldOrMethod.field.get(object);
            } catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
                return "<error>";
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
                return "<error>";
            }
            if (object2 != null)
                return object2;
            return null;
        }
        if (logicBooleanLoader$ParameterMapping$FieldOrMethod != null
                && logicBooleanLoader$ParameterMapping$FieldOrMethod.method != null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("getArgumentTextWithMapping: method not supported");
            return "<method>";
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log("getArgumentTextWithMapping: No method or field");
        return "<error>";
    }

    public static void setArgumentWithMapping(LogicBooleanLoader$ParameterMapping logicBooleanLoader$ParameterMapping,
            Object object, String string, String string2, l l2) {
        LogicBooleanLoader$ParameterMapping$FieldOrMethod logicBooleanLoader$ParameterMapping$FieldOrMethod = (LogicBooleanLoader$ParameterMapping$FieldOrMethod) logicBooleanLoader$ParameterMapping.parameters
                .get(string);
        if (logicBooleanLoader$ParameterMapping$FieldOrMethod != null
                && logicBooleanLoader$ParameterMapping$FieldOrMethod.field != null) {
            Class clazz = logicBooleanLoader$ParameterMapping$FieldOrMethod.type;
            Object object2 = LogicBooleanLoader.convertParameterData(string2, clazz, l2,
                    logicBooleanLoader$ParameterMapping$FieldOrMethod.returnType, string);
            if (object2 == null && logicBooleanLoader$ParameterMapping$FieldOrMethod.required) {
                throw new BooleanParseException("SyntaxError: Cannot set required argument: '" + string + "' to null");
            }
            try {
                logicBooleanLoader$ParameterMapping$FieldOrMethod.field.set(object, object2);
            } catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
                String string3 = illegalArgumentException.getMessage();
                if (string3 == null) {
                    throw new BooleanParseException(
                            "Error parameter:'" + string + "' on " + object.getClass().getSimpleName(),
                            illegalArgumentException);
                }
                string3 = string3.replace("com.corrodinggames.rts.game.units.custom.logicBooleans.", "");
                string3 = string3.replace("java.lang.", "");
                throw new BooleanParseException("Error parameter:'" + string + "': " + string3);
            } catch (IllegalAccessException illegalAccessException) {
                throw new BooleanParseException(
                        "Error setting parameter:'" + string + "' on " + object.getClass().getSimpleName(),
                        illegalAccessException);
            }
            return;
        }
        if (logicBooleanLoader$ParameterMapping$FieldOrMethod == null)
            throw new BooleanParseException("No parameter:'" + string + "' on " + object.getClass().getSimpleName()
                    + " (Possible parameters:" + logicBooleanLoader$ParameterMapping.allParametersString + ")");
        if (logicBooleanLoader$ParameterMapping$FieldOrMethod.method == null)
            throw new BooleanParseException("No parameter:'" + string + "' on " + object.getClass().getSimpleName()
                    + " (Possible parameters:" + logicBooleanLoader$ParameterMapping.allParametersString + ")");
        Class clazz = logicBooleanLoader$ParameterMapping$FieldOrMethod.type;
        Object object3 = LogicBooleanLoader.convertParameterData(string2, clazz, l2,
                logicBooleanLoader$ParameterMapping$FieldOrMethod.returnType, string);
        try {
            logicBooleanLoader$ParameterMapping$FieldOrMethod.method.invoke(object, object3);
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            String string4 = illegalArgumentException.getMessage();
            if (string4 == null) {
                throw new BooleanParseException(
                        "Error parameter:'" + string + "' on " + object.getClass().getSimpleName(),
                        illegalArgumentException);
            }
            string4 = string4.replace("com.corrodinggames.rts.game.units.custom.logicBooleans.", "");
            string4 = string4.replace("java.lang.", "");
            throw new BooleanParseException("Error setting parameter:'" + string + "': " + string4);
        } catch (IllegalAccessException illegalAccessException) {
            throw new BooleanParseException(
                    "Error setting parameter:'" + string + "' on " + object.getClass().getSimpleName(),
                    illegalAccessException);
        } catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            String string5 = "";
            if (throwable == null)
                throw new BooleanParseException(
                        "Error setting parameter:'" + string + "' on " + object.getClass().getSimpleName() + string5,
                        invocationTargetException);
            string5 = " - " + throwable.getMessage();
            throw new BooleanParseException(
                    "Error setting parameter:'" + string + "' on " + object.getClass().getSimpleName() + string5,
                    invocationTargetException);
        }
    }

    public static List getAllFieldsInherited(List list, Class clazz) {
        list.addAll(Arrays.asList(clazz.getFields()));
        return list;
    }

    public static Object convertParameterData(String string, Class clazz, l l2,
            LogicBoolean$ReturnType logicBoolean$ReturnType, String string2) {
        if (string == null) {
            return null;
        }
        if ((string = string.trim()).length() == 0) {
            return null;
        }
        if (string.equals("null")) {
            return null;
        }
        if (clazz == LogicBoolean.class) {
            LogicBoolean logicBoolean = LogicBooleanLoader.parseBooleanBlock(l2, string, false);
            if (logicBoolean == null)
                return logicBoolean;
            if (logicBoolean$ReturnType == null)
                return logicBoolean;
            LogicBoolean$ReturnType logicBoolean$ReturnType2 = logicBoolean.getReturnType();
            if (logicBoolean$ReturnType == logicBoolean$ReturnType2)
                return logicBoolean;
            throw new BooleanParseException("Wrong type. Expected type: '" + (Object) ((Object) logicBoolean$ReturnType)
                    + "' for dynamic parameter '" + string2 + "' instead got type:'"
                    + (Object) ((Object) logicBoolean$ReturnType2) + "' (parsing: " + string + ")");
        }
        if (GameUtils.s(string)) {
            if (!GameUtils.c(string, ".")) {
                if (clazz != String.class)
                    return Integer.parseInt(string);
                return string;
            }
            if (clazz != String.class)
                return Float.valueOf(Float.parseFloat(string));
            return string;
        }
        String string3 = string.toLowerCase(Locale.ENGLISH);
        if ("false".equals(string3)) {
            return Boolean.FALSE;
        }
        if ("true".equals(string3)) {
            return Boolean.TRUE;
        }
        Matcher matcher = LogicBooleanLoader.match(patternSingleQuote, string);
        if (matcher != null) {
            return GameUtils.q(matcher.group(1));
        }
        matcher = LogicBooleanLoader.match(patternDoubleQuote, string);
        if (matcher != null) {
            return GameUtils.q(matcher.group(1));
        }
        matcher = LogicBooleanLoader.match(patternInteger, string);
        if (matcher != null) {
            if (clazz != String.class)
                return Integer.parseInt(matcher.group(1));
            return matcher.group(1);
        }
        matcher = LogicBooleanLoader.match(patternFloat, string);
        if (matcher != null) {
            if (clazz != String.class)
                return Float.valueOf(Float.parseFloat(matcher.group(1)));
            return matcher.group(1);
        }
        String string4 = "null";
        if (clazz != null) {
            string4 = "data of " + clazz.getSimpleName();
            if (clazz == String.class) {
                string4 = "string";
            }
            if (clazz == Float.TYPE) {
                string4 = "number";
            }
            if (clazz == Integer.TYPE) {
                string4 = "integer";
            }
            if (clazz == Boolean.TYPE) {
                string4 = "boolean";
            }
        }
        String string5 = "Failed to read parameter '" + string2 + "' expected non-dynamic " + string4 + " got: "
                + string + "";
        if (clazz != String.class)
            throw new BooleanParseException(string5);
        string5 = string5 + " (A quoted string was expected)";
        throw new BooleanParseException(string5);
    }

    public static String breakOuterLayerBrackets(String string) {
        if (!string.startsWith("("))
            return string;
        if (!string.endsWith(")"))
            return string;
        int n2 = al.a(string, 0);
        if (n2 == -1) {
            throw new RuntimeException("Brackets unbalanced. Starting '(' in '" + string + "' was not closed.");
        }
        if (n2 != string.length() - 1)
            return string;
        string = string.substring(1, string.length() - 1);
        string = string.trim();
        string = LogicBooleanLoader.breakOuterLayerBrackets(string);
        return string;
    }
}
