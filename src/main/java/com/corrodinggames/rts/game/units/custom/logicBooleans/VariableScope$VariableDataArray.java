/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableData;
import com.corrodinggames.rts.game.units.y;

public abstract class VariableScope$VariableDataArray
extends VariableScope$VariableData {
    int size;

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.voidReturn;
    }

    public abstract LogicBoolean$ReturnType getElementReturnType();

    public abstract void setDataAtIndex(VariableScope$VariableData var1, int var2);

    public abstract VariableScope$VariableData readDataAtIndex(int var1);

    @Override
    public int getArraySize(y y2) {
        return this.size;
    }

    @Override
    public LogicBoolean readArrayElement(y y2, int n2) {
        return this.readDataAtIndex(n2);
    }

    public boolean readBooleanIndex(int n2) {
        return false;
    }

    public float readNumberIndex(int n2) {
        return 0.0f;
    }

    public BaseUnit readUnitIndex(int n2) {
        return null;
    }

    public abstract void shrink();
}

