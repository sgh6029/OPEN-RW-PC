/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.t;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import java.io.IOException;
import java.util.List;

public class VariableScope {
    public static final VariableScope emptyVariableScope = new VariableScope$EmptyVariableScope();
    public static final String nullOrMissingString = "";
    static final VariableScope$VariableName[] emptyNames = new VariableScope$VariableName[0];
    static final VariableScope$VariableData[] emptyData = new VariableScope$VariableData[0];
    VariableScope$VariableName[] variableNames = emptyNames;
    VariableScope$VariableData[] variableData = emptyData;
    public static final VariableScope$VariableDataNull variableDataNull = new VariableScope$VariableDataNull();

    public boolean isEmpty() {
        for (int i2 = 0; i2 < this.variableData.length; ++i2) {
            VariableScope$VariableData variableScope$VariableData = this.variableData[i2];
            if (variableScope$VariableData == null) continue;
            return false;
        }
        return true;
    }

    public String debugMemory(boolean bl2, boolean bl3) {
        String string2 = nullOrMissingString;
        for (int i2 = 0; i2 < this.variableData.length; ++i2) {
            VariableScope$VariableData variableScope$VariableData = this.variableData[i2];
            if (variableScope$VariableData == null) continue;
            string2 = string2 + VariableScope$VariableName.access$000(this.variableNames[i2]) + "=" + variableScope$VariableData.valueToStringDebug(null);
            if (bl3) {
                string2 = string2 + " (" + variableScope$VariableData.getReturnType().name() + ")";
            }
            string2 = bl2 ? string2 + "\n" : string2 + "|";
        }
        return string2;
    }

    public VariableScope$VariableData getDataObjectRaw(VariableScope$VariableName variableScope$VariableName) {
        for (int i2 = 0; i2 < this.variableData.length; ++i2) {
            if (this.variableNames[i2] != variableScope$VariableName) continue;
            return this.variableData[i2];
        }
        return variableDataNull;
    }

    public void setArrayDataRaw(VariableScope$VariableName variableScope$VariableName, VariableScope$VariableData variableScope$VariableData, int n2) {
        VariableScope$VariableDataArray variableScope$VariableDataArray = null;
        LogicBoolean$ReturnType logicBoolean$ReturnType = LogicBoolean$ReturnType.undefined;
        if (variableScope$VariableData != null) {
            logicBoolean$ReturnType = variableScope$VariableData.getReturnType();
        }
        for (int i2 = 0; i2 < this.variableData.length; ++i2) {
            if (this.variableNames[i2] != variableScope$VariableName || !(this.variableData[i2] instanceof VariableScope$VariableDataArray)) continue;
            VariableScope$VariableDataArray variableScope$VariableDataArray2 = (VariableScope$VariableDataArray)this.variableData[i2];
            if (logicBoolean$ReturnType != LogicBoolean$ReturnType.undefined && variableScope$VariableDataArray2.getElementReturnType() != logicBoolean$ReturnType) continue;
            variableScope$VariableDataArray = variableScope$VariableDataArray2;
        }
        if (variableScope$VariableDataArray == null && variableScope$VariableData == null) {
            return;
        }
        if (variableScope$VariableDataArray == null) {
            if (logicBoolean$ReturnType == LogicBoolean$ReturnType.number) {
                variableScope$VariableDataArray = new VariableScope$VariableDataNumberArray();
            } else if (logicBoolean$ReturnType == LogicBoolean$ReturnType.bool) {
                variableScope$VariableDataArray = new VariableScope$VariableDataBoolArray();
            } else if (logicBoolean$ReturnType == LogicBoolean$ReturnType.unit) {
                variableScope$VariableDataArray = new VariableScope$VariableDataUnitArray();
            } else {
                com.corrodinggames.rts.gameFramework.GameEngine.b("Unhandled array type: " + (Object)((Object)logicBoolean$ReturnType));
                return;
            }
            this.setDataRaw(variableScope$VariableName, variableScope$VariableDataArray);
        }
        variableScope$VariableDataArray.setDataAtIndex(variableScope$VariableData, n2);
    }

    public void setDataRaw(VariableScope$VariableName variableScope$VariableName, VariableScope$VariableData variableScope$VariableData) {
        if (variableScope$VariableData == null) {
            variableScope$VariableData = variableDataNull;
        }
        for (int i2 = 0; i2 < this.variableData.length; ++i2) {
            if (this.variableNames[i2] != variableScope$VariableName) continue;
            this.variableData[i2] = variableScope$VariableData;
            return;
        }
        VariableScope$VariableName[] variableScope$VariableNameArray = new VariableScope$VariableName[this.variableData.length + 1];
        VariableScope$VariableData[] variableScope$VariableDataArray = new VariableScope$VariableData[this.variableData.length + 1];
        for (int i3 = 0; i3 < this.variableData.length; ++i3) {
            variableScope$VariableDataArray[i3] = this.variableData[i3];
            variableScope$VariableNameArray[i3] = this.variableNames[i3];
        }
        variableScope$VariableDataArray[variableScope$VariableDataArray.length - 1] = variableScope$VariableData;
        variableScope$VariableNameArray[variableScope$VariableNameArray.length - 1] = variableScope$VariableName;
        this.variableData = variableScope$VariableDataArray;
        this.variableNames = variableScope$VariableNameArray;
    }

    public void clearAllData() {
        this.variableData = emptyData;
        this.variableNames = emptyNames;
    }

    public void setUnit(VariableScope$VariableDefinition variableScope$VariableDefinition, BaseUnit am2) {
        if (variableScope$VariableDefinition.type != LogicBoolean$ReturnType.unit) {
            // empty if block
        }
        this.setDataRaw(variableScope$VariableDefinition.name, new VariableScope$VariableDataUnit(am2));
    }

    BaseUnit getUnit(VariableScope$VariableName variableScope$VariableName) {
        return this.getDataObjectRaw(variableScope$VariableName).readUnit(null);
    }

    LogicBoolean getAsLogicBoolean(VariableScope$VariableName variableScope$VariableName) {
        return this.getDataObjectRaw(variableScope$VariableName);
    }

    public void setFromLogicBoolean(VariableScope$VariableName variableScope$VariableName, y y2, LogicBoolean logicBoolean, LogicBoolean logicBoolean2) {
        VariableScope$VariableData variableScope$VariableData = null;
        if (logicBoolean != null) {
            LogicBoolean$ReturnType logicBoolean$ReturnType = logicBoolean.getReturnType();
            if (logicBoolean$ReturnType == LogicBoolean$ReturnType.bool) {
                variableScope$VariableData = new VariableScope$VariableDataBoolean(logicBoolean.read(y2));
            } else if (logicBoolean$ReturnType == LogicBoolean$ReturnType.unit) {
                BaseUnit am2 = logicBoolean.readUnit(y2);
                am2 = VariableScope.getSafeUnitReferenceForStorage(am2);
                variableScope$VariableData = new VariableScope$VariableDataUnit(am2);
            } else if (logicBoolean$ReturnType == LogicBoolean$ReturnType.number) {
                variableScope$VariableData = new VariableScope$VariableDataNumber(logicBoolean.readNumber(y2));
            } else if (logicBoolean$ReturnType == LogicBoolean$ReturnType.string) {
                variableScope$VariableData = new VariableScope$VariableDataString(logicBoolean.readString(y2));
            }
        }
        if (logicBoolean2 != null) {
            int n2 = (int)logicBoolean2.readNumber(y2);
            this.setArrayDataRaw(variableScope$VariableName, variableScope$VariableData, n2);
        } else {
            this.setDataRaw(variableScope$VariableName, variableScope$VariableData);
        }
    }

    double getNumber(VariableScope$VariableName variableScope$VariableName) {
        return this.getDataObjectRaw(variableScope$VariableName).readNumber(null);
    }

    String getString(VariableScope$VariableName variableScope$VariableName) {
        return this.getDataObjectRaw(variableScope$VariableName).readString(null);
    }

    boolean getBoolean(VariableScope$VariableName variableScope$VariableName) {
        return this.getDataObjectRaw(variableScope$VariableName).read(null);
    }

    public static void writeOut(GameOutputStream as2, VariableScope variableScope) throws IOException {
        if (variableScope == null) {
            as2.c(-2);
            return;
        }
        if (variableScope.variableData.length == 0) {
            as2.c(-1);
            return;
        }
        as2.c(0);
        as2.a((short)variableScope.variableData.length);
        int n2 = variableScope.variableData.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            VariableScope$VariableData variableScope$VariableData = variableScope.variableData[i2];
            as2.writeUTF(VariableScope$VariableName.access$000(variableScope.variableNames[i2]));
            boolean bl2 = false;
            as2.a(bl2);
            if (bl2) continue;
            VariableScope.writeOutDynamicData(as2, variableScope$VariableData);
        }
    }

    public static VariableScope readIn(GameInputStream k2) throws IOException {
        byte by = k2.d();
        if (by == -2) {
            return null;
        }
        if (by == -1) {
            return null;
        }
        int n2 = k2.v();
        VariableScope variableScope = new VariableScope();
        for (int i2 = 0; i2 < n2; ++i2) {
            VariableScope$VariableName variableScope$VariableName = VariableScope$VariableName.get(k2.l());
            boolean bl2 = k2.e();
            if (bl2) continue;
            VariableScope$VariableData variableScope$VariableData = VariableScope.readInDynamicData(k2);
            variableScope.setDataRaw(variableScope$VariableName, variableScope$VariableData);
        }
        return variableScope;
    }

    public static void writeOutUnitOrPlaceholder(GameOutputStream as2, BaseUnit am2) throws IOException {
        if (am2 instanceof t) {
            as2.c(1);
            as2.a(am2.posX);
            as2.a(am2.posY);
            as2.a(am2.posZ);
            as2.a(am2.cg);
            as2.a(am2.bX);
        } else {
            as2.c(0);
            as2.b(am2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void writeOutDynamicData(GameOutputStream as2, VariableScope$VariableData variableScope$VariableData) throws IOException {
        if (variableScope$VariableData == null) {
            as2.a((Enum)null);
            return;
        }
        LogicBoolean$ReturnType logicBoolean$ReturnType = variableScope$VariableData.getReturnType();
        as2.a(logicBoolean$ReturnType);
        if (variableScope$VariableData instanceof VariableScope$VariableDataUnit) {
            VariableScope$VariableDataUnit variableScope$VariableDataUnit = (VariableScope$VariableDataUnit)variableScope$VariableData;
            BaseUnit am2 = variableScope$VariableDataUnit.unit;
            VariableScope.writeOutUnitOrPlaceholder(as2, am2);
            return;
        } else if (variableScope$VariableData instanceof VariableScope$VariableDataBoolean) {
            as2.a(((VariableScope$VariableDataBoolean)variableScope$VariableData).bool);
            return;
        } else if (variableScope$VariableData instanceof VariableScope$VariableDataString) {
            as2.b(((VariableScope$VariableDataString)variableScope$VariableData).text);
            return;
        } else if (variableScope$VariableData instanceof VariableScope$VariableDataNumber) {
            as2.a(((VariableScope$VariableDataNumber)variableScope$VariableData).number);
            return;
        } else if (variableScope$VariableData instanceof VariableScope$VariableDataArray) {
            VariableScope$VariableDataArray variableScope$VariableDataArray = (VariableScope$VariableDataArray)variableScope$VariableData;
            as2.a(variableScope$VariableDataArray.size);
            if (variableScope$VariableDataArray instanceof VariableScope$VariableDataBoolArray) {
                VariableScope$VariableDataBoolArray variableScope$VariableDataBoolArray = (VariableScope$VariableDataBoolArray)variableScope$VariableDataArray;
                for (int i2 = 0; i2 < variableScope$VariableDataBoolArray.size; ++i2) {
                    as2.a(variableScope$VariableDataBoolArray.dataArray[i2]);
                }
                return;
            } else if (variableScope$VariableDataArray instanceof VariableScope$VariableDataNumberArray) {
                VariableScope$VariableDataNumberArray variableScope$VariableDataNumberArray = (VariableScope$VariableDataNumberArray)variableScope$VariableDataArray;
                for (int i3 = 0; i3 < variableScope$VariableDataNumberArray.size; ++i3) {
                    as2.a(variableScope$VariableDataNumberArray.dataArray[i3]);
                }
                return;
            } else {
                if (!(variableScope$VariableDataArray instanceof VariableScope$VariableDataUnitArray)) throw new RuntimeException("Unhandled array type: " + logicBoolean$ReturnType.name());
                VariableScope$VariableDataUnitArray variableScope$VariableDataUnitArray = (VariableScope$VariableDataUnitArray)variableScope$VariableDataArray;
                for (int i4 = 0; i4 < variableScope$VariableDataUnitArray.size; ++i4) {
                    BaseUnit am3 = variableScope$VariableDataUnitArray.dataArray[i4];
                    VariableScope.writeOutUnitOrPlaceholder(as2, am3);
                }
            }
            return;
        } else {
            if (logicBoolean$ReturnType == LogicBoolean$ReturnType.undefined) return;
            throw new RuntimeException("Unhandled type: " + logicBoolean$ReturnType.name());
        }
    }

    public static BaseUnit readInUnitOrPlaceholder(GameInputStream k2) throws IOException {
        BaseUnit am2;
        byte by = k2.d();
        if (by == 1) {
            float f2 = k2.g();
            float f3 = k2.g();
            float f4 = k2.g();
            float f5 = k2.g();
            PlayerTeam n2 = k2.s();
            am2 = t.a(n2);
            am2.posX = f2;
            am2.posY = f3;
            am2.posZ = f4;
            am2.cg = f5;
        } else if (by == 0) {
            am2 = k2.o();
        } else {
            throw new IOException("Unhandled unit type: " + by);
        }
        return am2;
    }

    public static VariableScope$VariableData readInDynamicData(GameInputStream k2) throws IOException {
        LogicBoolean$ReturnType logicBoolean$ReturnType = (LogicBoolean$ReturnType)k2.b(LogicBoolean$ReturnType.class);
        if (logicBoolean$ReturnType == null) {
            return null;
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.unit) {
            BaseUnit am2 = VariableScope.readInUnitOrPlaceholder(k2);
            VariableScope$VariableDataUnit variableScope$VariableDataUnit = new VariableScope$VariableDataUnit(am2);
            return variableScope$VariableDataUnit;
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.bool) {
            return new VariableScope$VariableDataBoolean(k2.e());
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.string) {
            return new VariableScope$VariableDataString(k2.j());
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.number) {
            return new VariableScope$VariableDataNumber(k2.h());
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.boolArray || logicBoolean$ReturnType == LogicBoolean$ReturnType.numberArray || logicBoolean$ReturnType == LogicBoolean$ReturnType.unitArray) {
            int n2 = k2.readInt();
            if (logicBoolean$ReturnType == LogicBoolean$ReturnType.boolArray) {
                VariableScope$VariableDataBoolArray variableScope$VariableDataBoolArray = new VariableScope$VariableDataBoolArray();
                for (int i2 = 0; i2 < n2; ++i2) {
                    variableScope$VariableDataBoolArray.setBooleanIndex(i2, k2.e());
                }
                return variableScope$VariableDataBoolArray;
            }
            if (logicBoolean$ReturnType == LogicBoolean$ReturnType.numberArray) {
                VariableScope$VariableDataNumberArray variableScope$VariableDataNumberArray = new VariableScope$VariableDataNumberArray();
                for (int i3 = 0; i3 < n2; ++i3) {
                    variableScope$VariableDataNumberArray.setNumberIndex(i3, k2.g());
                }
                return variableScope$VariableDataNumberArray;
            }
            if (logicBoolean$ReturnType == LogicBoolean$ReturnType.unitArray) {
                VariableScope$VariableDataUnitArray variableScope$VariableDataUnitArray = new VariableScope$VariableDataUnitArray();
                for (int i4 = 0; i4 < n2; ++i4) {
                    BaseUnit am3 = VariableScope.readInUnitOrPlaceholder(k2);
                    variableScope$VariableDataUnitArray.setUnitIndex(i4, am3);
                }
                return variableScope$VariableDataUnitArray;
            }
            throw new RuntimeException("Unhandled array type: " + logicBoolean$ReturnType.name());
        }
        if (logicBoolean$ReturnType == LogicBoolean$ReturnType.undefined) {
            throw new RuntimeException("Undefined type: " + logicBoolean$ReturnType.name());
        }
        throw new RuntimeException("Unhandled type: " + logicBoolean$ReturnType.name());
    }

    public static LogicBoolean$ReturnType getUserType(String string2) {
        LogicBoolean$ReturnType logicBoolean$ReturnType = null;
        if (string2.equals("boolean")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.bool;
        } else if (string2.equals("bool")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.bool;
        } else if (string2.equals("unit")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.unit;
        } else if (string2.equals("number")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.number;
        } else if (string2.equals("float")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.number;
        } else if (string2.equals("text")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.string;
        } else if (string2.equals("string")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.string;
        } else if (string2.equals("number[]")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.numberArray;
        } else if (string2.equals("float[]")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.numberArray;
        } else if (string2.equals("bool[]")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.boolArray;
        } else if (string2.equals("boolean[]")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.boolArray;
        } else if (string2.equals("unit[]")) {
            logicBoolean$ReturnType = LogicBoolean$ReturnType.unitArray;
        }
        return logicBoolean$ReturnType;
    }

    public static VariableScope$MemoryWriter createGenericKeyValueWriter(String string2, l l2, String string3, String string4) {
        try {
            VariableScope$MemoryWriter variableScope$MemoryWriter = new VariableScope$MemoryWriter();
            VariableScope$VariableMapping variableScope$VariableMapping = null;
            variableScope$MemoryWriter.addWriterElements(string2, new VariableScope$MemoryWriterFactory(l2, variableScope$VariableMapping));
            return variableScope$MemoryWriter;
        }
        catch (bo bo2) {
            throw new RuntimeException("[" + string3 + "]" + string4 + ": " + bo2.getMessage(), bo2);
        }
    }

    public static VariableScope$MemoryWriter createMemoryWriter(String string2, l l2, String string3, String string4) {
        try {
            VariableScope$MemoryWriter variableScope$MemoryWriter = new VariableScope$MemoryWriter();
            variableScope$MemoryWriter.addWriterElements(string2, new VariableScope$MemoryWriterFactory(l2));
            return variableScope$MemoryWriter;
        }
        catch (bo bo2) {
            throw new RuntimeException("[" + string3 + "]" + string4 + ": " + bo2.getMessage(), bo2);
        }
    }

    public static VariableScope$MemoryNames createMemoryNameList(String string2, l l2, LogicBoolean$ReturnType logicBoolean$ReturnType, String string3, String string4) {
        try {
            VariableScope$MemoryWriter variableScope$MemoryWriter = new VariableScope$MemoryWriter();
            VariableScope$MemoryWriterFactory variableScope$MemoryWriterFactory = new VariableScope$MemoryWriterFactory(l2);
            variableScope$MemoryWriterFactory.noValues = true;
            variableScope$MemoryWriter.addWriterElements(string2, variableScope$MemoryWriterFactory);
            VariableScope$MemoryNames variableScope$MemoryNames = new VariableScope$MemoryNames();
            for (VariableScope$CachedWriter$WriterElement variableScope$CachedWriter$WriterElement : ((List<VariableScope$CachedWriter$WriterElement>) variableScope$MemoryWriter.writers) ){
                if (!(variableScope$CachedWriter$WriterElement instanceof VariableScope$MemoryWriterFactory$MemoryWriterElement)) {
                    throw new bo("Unexpected element reading: " + string2, string3, string4);
                }
                VariableScope$MemoryWriterFactory$MemoryWriterElement variableScope$MemoryWriterFactory$MemoryWriterElement = (VariableScope$MemoryWriterFactory$MemoryWriterElement)variableScope$CachedWriter$WriterElement;
                if (variableScope$MemoryWriterFactory$MemoryWriterElement instanceof VariableScope$MemoryWriterFactory$MemoryWriterElementIndex) {
                    throw new bo("Expected memory name without an index got: " + string2, string3, string4);
                }
                if (logicBoolean$ReturnType != null) {
                    VariableScope$VariableDefinition variableScope$VariableDefinition = l2.r.get(variableScope$MemoryWriterFactory$MemoryWriterElement.name);
                    if (variableScope$VariableDefinition == null) {
                        throw new bo("Failed to find defined memory: " + string2, string3, string4);
                    }
                    if (variableScope$VariableDefinition.type != logicBoolean$ReturnType) {
                        throw new bo("Memory: " + string2 + " is type: " + (Object)((Object)variableScope$VariableDefinition.type) + " expected: " + (Object)((Object)logicBoolean$ReturnType), string3, string4);
                    }
                }
                variableScope$MemoryNames.names.add(variableScope$MemoryWriterFactory$MemoryWriterElement.name);
            }
            return variableScope$MemoryNames;
        }
        catch (bo bo2) {
            throw new RuntimeException("[" + string3 + "]" + string4 + ": " + bo2.getMessage(), bo2);
        }
    }

    public static boolean isMarker(BaseUnit am2) {
        if (am2 == null) {
            return false;
        }
        return am2 instanceof t;
    }

    public static BaseUnit getSafeUnitReferenceForStorage(BaseUnit am2) {
        if (am2 == null) {
            return null;
        }
        if (am2 instanceof t) {
            t t2 = t.a(am2.bX);
            t2.posX = am2.posX;
            t2.posY = am2.posY;
            t2.posZ = am2.posZ;
            t2.cg = am2.cg;
            return t2;
        }
        return am2;
    }
}

