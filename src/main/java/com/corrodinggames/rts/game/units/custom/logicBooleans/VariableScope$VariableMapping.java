/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDefinition;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableName;
import com.corrodinggames.rts.gameFramework.GameUtils;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;

import java.util.List;
import java.util.Locale;

public class VariableScope$VariableMapping {
    l meta;
    m mapping = new m();

    public VariableScope$VariableDefinition create(String string2, LogicBoolean$ReturnType logicBoolean$ReturnType) {
        VariableScope$VariableName variableScope$VariableName = VariableScope$VariableName.get(string2);
        VariableScope$VariableDefinition variableScope$VariableDefinition = this.get(variableScope$VariableName);
        if (variableScope$VariableDefinition != null) {
            throw new RuntimeException("A variable already exists with the name: " + string2);
        }
        VariableScope$VariableDefinition variableScope$VariableDefinition2 = new VariableScope$VariableDefinition();
        variableScope$VariableDefinition2.name = variableScope$VariableName;
        variableScope$VariableDefinition2.type = logicBoolean$ReturnType;
        this.mapping.add(variableScope$VariableDefinition2);
        return variableScope$VariableDefinition2;
    }

    public VariableScope$VariableDefinition get(String string2) {
        string2 = string2.toLowerCase(Locale.ROOT).trim();
        VariableScope$VariableName variableScope$VariableName = VariableScope$VariableName.get(string2);
        for (VariableScope$VariableDefinition variableScope$VariableDefinition : ((List<VariableScope$VariableDefinition>)this.mapping)) {
            if (variableScope$VariableDefinition.name != variableScope$VariableName) continue;
            return variableScope$VariableDefinition;
        }
        return null;
    }

    public VariableScope$VariableDefinition get(VariableScope$VariableName variableScope$VariableName) {
        for (VariableScope$VariableDefinition variableScope$VariableDefinition : ((List<VariableScope$VariableDefinition>)this.mapping)) {
            if (variableScope$VariableDefinition.name != variableScope$VariableName) continue;
            return variableScope$VariableDefinition;
        }
        return null;
    }

    public boolean hasArrays() {
        for (VariableScope$VariableDefinition variableScope$VariableDefinition : ((List<VariableScope$VariableDefinition>)this.mapping)) {
            if (!LogicBoolean$ReturnType.isArrayType(variableScope$VariableDefinition.type)) continue;
            return true;
        }
        return false;
    }

    public String getListOfPossibleNames() {
        String string2 = null;
        for (VariableScope$VariableDefinition variableScope$VariableDefinition : ((List<VariableScope$VariableDefinition>)this.mapping)) {
            if (string2 == null) {
                string2 = "" + variableScope$VariableDefinition.name;
                continue;
            }
            string2 = string2 + ", " + variableScope$VariableDefinition.name;
        }
        return string2;
    }

    public void addDefineKey(IniFile ab2, l l2, String string2, String string3, String string4) {
        String string5 = ab2.b(string3, string4, (String)null);
        if (string5 != null && !string5.equals("")) {
            throw new RuntimeException("[" + string3 + "]" + string2 + ": Unexpected format");
        }
        this.defineVariablesRaw(string2, string3, string4);
    }

    public void addDefineValue(l l2, String string2, String string3, String string4) {
        this.defineVariablesRaw(string3, string2, string4);
    }

    public void defineVariables(l l2, String string2) {
        this.defineVariablesRaw("define", "", string2);
    }

    public void addSingleDefine(l l2, String string2, String string3, String string4, String string5) {
        String string6 = string3.trim().toLowerCase(Locale.ROOT);
        string2 = string2.toLowerCase(Locale.ROOT).trim();
        LogicBoolean$ReturnType logicBoolean$ReturnType = VariableScope.getUserType(string6);
        if (logicBoolean$ReturnType == null) {
            throw new RuntimeException("[" + string4 + "]" + string5 + ": Unknown type: " + string6);
        }
        this.checkNameReserved(string2, string4, string5);
        VariableScope$VariableDefinition variableScope$VariableDefinition = this.get(string2);
        if (variableScope$VariableDefinition != null) {
            if (variableScope$VariableDefinition.type == logicBoolean$ReturnType) {
                return;
            }
            throw new RuntimeException("[" + string4 + "]" + string5 + ": A memory variable already exists with the name: " + string2 + " and is a different type: " + variableScope$VariableDefinition.type.name());
        }
        this.create(string2, logicBoolean$ReturnType);
    }

    public void defineVariablesRaw(String string2, String string3, String string4) {
        String[] stringArray;
        for (String string5 : stringArray = GameUtils.c(string4, ',')) {
            if ((string5 = string5.trim()).equals("")) continue;
            int n2 = string5.indexOf(" ");
            if (n2 == -1) {
                throw new RuntimeException("[" + string3 + "]" + string2 + ": Expected 'type name' in each section, got: " + string5);
            }
            String string6 = string5.substring(0, n2).toLowerCase(Locale.ROOT).trim();
            String string7 = string5.substring(n2, string5.length()).toLowerCase(Locale.ROOT).trim();
            this.addSingleDefine(this.meta, string7, string6, string3, string2);
        }
    }

    public void checkNameReserved(String string2, String string3, String string4) {
        boolean bl2 = false;
        if (string2.equals("")) {
            bl2 = true;
        }
        if (string2.equals("game") || string2.equals("parent") || string2.equals("self") || string2.equals("this")) {
            bl2 = true;
        }
        if (string2.equals("boolean") || string2.equals("bool") || string2.equals("unit") || string2.equals("void") || string2.equals("null") || string2.equals("number") || string2.equals("float")) {
            bl2 = true;
        }
        if (bl2) {
            throw new RuntimeException("[" + string3 + "]" + string4 + ": Variable cannot be named: '" + string2 + "'");
        }
        if (string2.contains(".") || string2.contains("=") || string2.contains("(") || string2.contains(")") || string2.contains("'") || string2.contains("\"") || string2.contains("?") || string2.contains("|") || string2.contains("\\") || string2.contains("/") || string2.contains("[") || string2.contains("]") || string2.contains(":") || string2.contains(";")) {
            throw new RuntimeException("[" + string3 + "]" + string4 + ": Variable name has reserved symbols: '" + string2 + "'");
        }
        if (string2.contains(" ")) {
            throw new RuntimeException("[" + string3 + "]" + string4 + ": Variable name cannot have a space: '" + string2 + "'");
        }
    }
}

