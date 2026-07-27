/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableData;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDataArray;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDataNumber;

public class VariableScope$VariableDataNumberArray
extends VariableScope$VariableDataArray {
    float[] dataArray;
    public static final boolean trace = false;

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.numberArray;
    }

    @Override
    public LogicBoolean$ReturnType getElementReturnType() {
        return LogicBoolean$ReturnType.number;
    }

    @Override
    public float readNumberIndex(int n2) {
        if (n2 < 0 || n2 >= this.size) {
            return 0.0f;
        }
        return this.dataArray[n2];
    }

   public void setNumberIndex(int var1, float var2) {
      if (var1 >= 0) {
         if (var1 <= 10000) {
            if (this.dataArray == null) {
               int var3 = var1 + 1;
               this.dataArray = new float[var3];
            }

            if (var1 >= this.dataArray.length) {
               byte var7 = 12;
               int var4 = this.dataArray.length;
               int var5 = var4 + (var4 < var7 / 2 ? var7 : var4 >> 1);
               if (var5 < var1 + 1) {
                  var5 = var1 + 1;
               }

               float[] var6 = new float[var5];
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
    public void shrink() {
        for (int i2 = 0; i2 < this.size; ++i2) {
            if (this.dataArray[i2] != 0.0f) continue;
            for (int i3 = i2 + 1; i3 < this.size; ++i3) {
                this.dataArray[i3 - 1] = this.dataArray[i3];
            }
            this.dataArray[this.size - 1] = 0.0f;
            --this.size;
            --i2;
        }
    }

    @Override
    public void setDataAtIndex(VariableScope$VariableData variableScope$VariableData, int n2) {
        this.setNumberIndex(n2, variableScope$VariableData.readNumber(null));
    }

    @Override
    public VariableScope$VariableData readDataAtIndex(int n2) {
        return new VariableScope$VariableDataNumber(this.readNumberIndex(n2));
    }
}

