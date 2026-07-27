/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableData;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDataArray;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDataBoolean;

public class VariableScope$VariableDataBoolArray
extends VariableScope$VariableDataArray {
    boolean[] dataArray;

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.boolArray;
    }

    @Override
    public LogicBoolean$ReturnType getElementReturnType() {
        return LogicBoolean$ReturnType.bool;
    }

    @Override
    public boolean readBooleanIndex(int n2) {
        if (n2 < 0 || n2 >= this.size) {
            return false;
        }
        return this.dataArray[n2];
    }

  public void setBooleanIndex(int var1, boolean var2) {
      if (var1 >= 0) {
         if (var1 <= 10000) {
            if (this.dataArray == null) {
               int var3 = var1 + 1;
               this.dataArray = new boolean[var3];
            }

            if (var1 >= this.dataArray.length) {
               byte var7 = 12;
               int var4 = this.dataArray.length;
               int var5 = var4 + (var4 < var7 / 2 ? var7 : var4 >> 1);
               if (var5 < var1 + 1) {
                  var5 = var1 + 1;
               }

               boolean[] var6 = new boolean[var5];
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
            if (this.dataArray[i2]) continue;
            for (int i3 = i2 + 1; i3 < this.size; ++i3) {
                this.dataArray[i3 - 1] = this.dataArray[i3];
            }
            this.dataArray[this.size - 1] = false;
            --this.size;
            --i2;
        }
    }

    @Override
    public void setDataAtIndex(VariableScope$VariableData variableScope$VariableData, int n2) {
        this.setBooleanIndex(n2, variableScope$VariableData.read(null));
    }

    @Override
    public VariableScope$VariableData readDataAtIndex(int n2) {
        return new VariableScope$VariableDataBoolean(this.readBooleanIndex(n2));
    }
}

