/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableData;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDataArray;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDataUnit;

public class VariableScope$VariableDataUnitArray
        extends VariableScope$VariableDataArray {
    BaseUnit[] dataArray;

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.unitArray;
    }

    @Override
    public LogicBoolean$ReturnType getElementReturnType() {
        return LogicBoolean$ReturnType.unit;
    }

    @Override
    public BaseUnit readUnitIndex(int n2) {
        if (n2 < 0 || n2 >= this.size) {
            return null;
        }
        return this.dataArray[n2];
    }

    public void setUnitIndex(int var1, BaseUnit var2) {
        if (var1 >= 0) {
            if (var1 <= 10000) {
                if (this.dataArray == null) {
                    int var3 = var1 + 1;
                    this.dataArray = new BaseUnit[var3];
                }

                if (var1 >= this.dataArray.length) {
                    byte var7 = 12;
                    int var4 = this.dataArray.length;
                    int var5 = var4 + (var4 < var7 / 2 ? var7 : var4 >> 1);
                    if (var5 < var1 + 1) {
                        var5 = var1 + 1;
                    }

                    BaseUnit[] var6 = new BaseUnit[var5];
                    System.arraycopy(this.dataArray, 0, var6, 0, var4);
                    this.dataArray = var6;
                }

                if (this.size < var1 + 1) {
                    this.size = var1 + 1;
                    if (this.size > this.dataArray.length) {
                        throw new RuntimeException("size:" + this.size + ", dataArray.length:" + this.dataArray.length);
                    }
                }

                this.dataArray[var1] = var2;
            }
        }
    }

    @Override
    public void setDataAtIndex(VariableScope$VariableData variableScope$VariableData, int n2) {
        this.setUnitIndex(n2, variableScope$VariableData.readUnit(null));
    }

    @Override
    public VariableScope$VariableData readDataAtIndex(int n2) {
        return new VariableScope$VariableDataUnit(this.readUnitIndex(n2));
    }

    @Override
    public void shrink() {
        for (int i2 = 0; i2 < this.size; ++i2) {
            BaseUnit am2 = this.dataArray[i2];
            if (am2 != null && (VariableScope.isMarker(am2) || !am2.bV))
                continue;
            for (int i3 = i2 + 1; i3 < this.size; ++i3) {
                this.dataArray[i3 - 1] = this.dataArray[i3];
            }
            this.dataArray[this.size - 1] = null;
            --this.size;
            --i2;
        }
    }
}
