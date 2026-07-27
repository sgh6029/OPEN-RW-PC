/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.k;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$CallContext_self;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$CallContext_selfAndTarget;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticBooleanFalse;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticBooleanTrue;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$StaticValueBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanGameFunctions;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ParameterMapping;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$ParameterMapping$FieldOrMethod;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$CreateMarker;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionCos;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionDirection;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionDirectionBetween;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionDistance;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionDistanceBetween;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionDistanceBetweenSquared;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionDistanceSquared;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionInt;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionLength;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionMax;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionMin;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionRnd;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionSin;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicNumberFunction$FunctionSquareRoot;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$Debug;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$DebugPassthrough;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$LowerString;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$Playername;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$Select;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$StringCast;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$Substring;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$TeamName;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicString$UpperString;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$NullUnitReference;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$KnownMemoryScopeLogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$ReadEventMemoryLogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$ReadUnitMemoryLogicBoolean;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

public abstract class LogicBoolean
implements Cloneable {
    public static final boolean not = false;
    public static final LogicBoolean$StaticBoolean trueBoolean = new LogicBoolean$StaticBooleanTrue();
    public static final LogicBoolean$StaticBoolean falseBoolean = new LogicBoolean$StaticBooleanFalse();
    static LogicBoolean$CallContext_self callContext_self = new LogicBoolean$CallContext_self();
    static LogicBoolean$CallContext_selfAndTarget callContext_selfAndTarget = new LogicBoolean$CallContext_selfAndTarget();
    static HashMap booleans;
    static k activeEvent;
    static y outerUnitParameterContext;
    static final HashMap parameterMappings;

    public static final y getParameterContext(y y2) {
        y y3 = outerUnitParameterContext;
        if (y3 != null) {
            return y3;
        }
        return y2;
    }

    public static final void setOuterUnitParameterContext(y y2) {
        outerUnitParameterContext = y2;
    }

    public static final void clearOuterUnitParameterContext() {
        outerUnitParameterContext = null;
    }

    public static void enableContextEventSource() {
    }

    public static void setContextEventSource(k k2) {
        activeEvent = k2;
    }

    public static void clearContext() {
        activeEvent = null;
    }

    static void addBooleanType(LogicBoolean logicBoolean, String ... stringArray) {
        for (String string2 : stringArray) {
            if (booleans.get(string2 = string2.toLowerCase(Locale.ROOT)) != null) {
                throw new RuntimeException("logicBoolean: " + string2 + " already exists");
            }
            booleans.put(string2, logicBoolean);
        }
    }

    public void setArgumentsRaw(String string2, l l2, String string3) {
        LogicBooleanLoader$ParameterMapping parameterMapping = this.getParameters();
        LogicBooleanLoader.setArgumentsWithMapping(parameterMapping, this, string2, l2, string3);
    }

    public LogicBooleanLoader$ParameterMapping getParameters() {
        LogicBooleanLoader$ParameterMapping logicBooleanLoader$ParameterMapping = (LogicBooleanLoader$ParameterMapping)parameterMappings.get(this.getClass());
        if (logicBooleanLoader$ParameterMapping == null) {
            logicBooleanLoader$ParameterMapping = new LogicBooleanLoader$ParameterMapping(this.getClass());
            parameterMappings.put(logicBooleanLoader$ParameterMapping.type, logicBooleanLoader$ParameterMapping);
        }
        return logicBooleanLoader$ParameterMapping;
    }

    public boolean isLocked() {
        return false;
    }

    public LogicBoolean createLocked() {
        throw new RuntimeException("Not implemented");
    }

    public void forMeta(l l2) {
    }

    public LogicBoolean with(String string2) {
        return this.with(null, string2, null);
    }

    public LogicBoolean with(l l2, String string2, String string3) {
        LogicBoolean logicBoolean;
        try {
            logicBoolean = (LogicBoolean)this.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
        logicBoolean.forMeta(l2);
        if (this.isLocked()) {
            if (string2 != null && !string2.trim().equals("")) {
                throw new BooleanParseException("No parameters accepted for " + this.getClass().getSimpleName());
            }
        } else {
            logicBoolean.setArgumentsRaw(string2, l2, string3);
        }
        return logicBoolean;
    }

    public static LogicBoolean convertAlwaysTrueToNull(LogicBoolean logicBoolean) {
        if (logicBoolean == trueBoolean) {
            return null;
        }
        return logicBoolean;
    }

    public static boolean isStaticFalse(LogicBoolean logicBoolean) {
        return logicBoolean == falseBoolean;
    }

    public static boolean isStaticTrue(LogicBoolean logicBoolean) {
        return logicBoolean == trueBoolean;
    }

    public static boolean isStaticNull(LogicBoolean logicBoolean) {
        return logicBoolean instanceof UnitReference$NullUnitReference;
    }

    public static boolean isStaticNumber(LogicBoolean logicBoolean) {
        return logicBoolean instanceof LogicBoolean$StaticValueBoolean;
    }

    public static Float getStaticNumber(LogicBoolean logicBoolean) {
        if (logicBoolean instanceof LogicBoolean$StaticValueBoolean) {
            return Float.valueOf(((LogicBoolean$StaticValueBoolean)logicBoolean).staticNumber);
        }
        return null;
    }

    public static float getKnownStaticNumber(LogicBoolean logicBoolean) {
        return ((LogicBoolean$StaticValueBoolean)logicBoolean).staticNumber;
    }

    public static LogicBoolean create(l l2, String string2) {
        return LogicBoolean.create(l2, string2, null);
    }

    public static LogicBoolean create(l l2, String string2, LogicBoolean logicBoolean) {
        String string3 = string2;
        try {
            if (string3 == null) {
                return logicBoolean;
            }
            String string4 = string3.toLowerCase(Locale.ENGLISH);
            if (string4.equals("true")) {
                return trueBoolean;
            }
            if (string4.equals("false")) {
                return falseBoolean;
            }
            if (string4.startsWith("if ")) {
                string3 = string3.substring("if ".length());
                return LogicBooleanLoader.parseBooleanBlock(l2, string3, true);
            }
            throw new BooleanParseException("Cannot parse:'" + string2 + "' expected true, false or statement starting with 'if'");
        }
        catch (RuntimeException runtimeException) {
            throw new RuntimeException("LogicBoolean - Error: " + runtimeException.getMessage() + ", [parsing: '" + string2 + "']", runtimeException);
        }
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.bool;
    }

    public String valueToStringDebug(y y2) {
        LogicBoolean$ReturnType logicBoolean$ReturnType = this.getReturnType();
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.number) {
            float f2 = this.readNumber(y2);
            return GameUtils.a(f2, 2);
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.unit) {
            return BaseUnit.A(this.readUnit(y2));
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.string) {
            String string2 = this.readString(y2);
            return string2;
        }
        if (LogicBoolean$ReturnType.isArrayType(logicBoolean$ReturnType)) {
            return LogicString.arraySummaryToString(y2, this);
        }
        boolean bl2 = this.read(y2);
        return bl2 ? "true" : "false";
    }

    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
    }

    public LogicBoolean validateAndOptimize(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        this.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        return this;
    }

    public abstract boolean read(y var1);

    public float readNumber(y y2) {
        return -9999.0f;
    }

    public String readString(y y2) {
        return null;
    }

    public BaseUnit readUnit(y y2) {
        return null;
    }

    public int getArraySize(y y2) {
        return 0;
    }

    public LogicBoolean readArrayElement(y y2, int n2) {
        return null;
    }

    public abstract String getMatchFailReasonForPlayer(y var1);

    public String getDebugDetails(j j2) {
        boolean bl2 = this.read(j2);
        return this.getMatchFailReasonForPlayer(j2) + "==" + (bl2 ? "true" : "false");
    }

    public static String getAllParametersDebug(LogicBoolean logicBoolean, y y2) {
        String string2 = "";
        LogicBooleanLoader$ParameterMapping logicBooleanLoader$ParameterMapping = logicBoolean.getParameters();
        for (String string3 : ((Set<String>)logicBooleanLoader$ParameterMapping.parameters.keySet())) {
            LogicBooleanLoader$ParameterMapping$FieldOrMethod logicBooleanLoader$ParameterMapping$FieldOrMethod = (LogicBooleanLoader$ParameterMapping$FieldOrMethod)logicBooleanLoader$ParameterMapping.parameters.get(string3);
            if (logicBooleanLoader$ParameterMapping$FieldOrMethod.field == null) continue;
            if (!string2.equals("")) {
                string2 = string2 + ",";
            }
            String string4 = null;
            Object object = LogicBooleanLoader.getArgumentTextWithMapping(logicBooleanLoader$ParameterMapping$FieldOrMethod, logicBoolean);
            if (object instanceof String) {
                string4 = object.toString();
            }
            if (object instanceof LogicBoolean) {
                string4 = ((LogicBoolean)object).valueToStringDebug(y2);
            }
            string2 = string2 + string3 + "=" + string4;
        }
        return string2;
    }

    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return LogicBooleanLoader.voidContextReader;
    }

    public void throwVoidReturnError(String string2) {
        throw new RuntimeException("Function or object:'" + string2 + "' cannot be returned");
    }

    public LogicBoolean setChild(LogicBoolean logicBoolean) {
        throw new RuntimeException("setChild not supported on: " + this.getClass().getSimpleName());
    }

    public void setParent(LogicBoolean logicBoolean) {
    }

    static {
        parameterMappings = new HashMap();
        booleans = new HashMap();
        LogicBooleanGameFunctions.loadTypes();
        LogicBoolean.addBooleanType(new VariableScope$KnownMemoryScopeLogicBoolean(), "memory");
        LogicBoolean.addBooleanType(new VariableScope$ReadUnitMemoryLogicBoolean(), "self.readUnitMemory");
        LogicBoolean.addBooleanType(new VariableScope$ReadEventMemoryLogicBoolean(), "eventData");
        LogicBoolean.addBooleanType(new LogicString$Playername(), "self.playername");
        LogicBoolean.addBooleanType(new LogicString$TeamName(), "self.teamname");
        LogicBoolean.addBooleanType(new LogicString$Debug(), "debug");
        LogicBoolean.addBooleanType(new LogicString$DebugPassthrough(), "debugPassthrough");
        LogicBoolean.addBooleanType(new LogicString$Select(), "select");
        LogicBoolean.addBooleanType(new LogicString$StringCast(), "str");
        LogicBoolean.addBooleanType(new LogicString$Substring(), "substring");
        LogicBoolean.addBooleanType(new LogicString$LowerString(), "lowercase");
        LogicBoolean.addBooleanType(new LogicString$UpperString(), "uppercase");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionInt(), "int");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionRnd(), "rnd");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionMax(), "max");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionMin(), "min");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionLength(), "length");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionSquareRoot(), "squareRoot");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionDistanceSquared(), "distanceSquared");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionCos(), "cos");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionSin(), "sin");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionDistance(), "distance");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionDirection(), "direction");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionDistanceBetweenSquared(), "distanceBetweenSquared");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionDistanceBetween(), "distanceBetween");
        LogicBoolean.addBooleanType(new LogicNumberFunction$FunctionDirectionBetween(), "directionBetween");
        LogicBoolean.addBooleanType(new LogicNumberFunction$CreateMarker(), "createMarker");
        LogicBoolean.addBooleanType(trueBoolean, "true");
        LogicBoolean.addBooleanType(falseBoolean, "false");
    }
}

