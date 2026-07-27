/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$AbstractNumberBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$Parameter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanGameFunctions$NumberOfUnitsInTeam$HandleCallbackCount;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader$LogicBooleanContext;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.GameEngine;

public final class LogicBooleanGameFunctions$NumberOfUnitsInTeam
extends LogicBoolean$AbstractNumberBoolean {
    public g _withTag;
    @LogicBoolean$Parameter
    public float withinRange = -1.0f;
    public float withinRangeSq = -1.0f;
    @LogicBoolean$Parameter
    public boolean incompleteBuildings;
    @LogicBoolean$Parameter
    public boolean factoryQueue;
    @LogicBoolean$Parameter
    public boolean neutralTeam;
    @LogicBoolean$Parameter
    public boolean allTeams;
    public boolean useAggressiveTeamInsteadOfNeutralTeam;
    public static final LogicBooleanGameFunctions$NumberOfUnitsInTeam$HandleCallbackCount handleCallbackCount = new LogicBooleanGameFunctions$NumberOfUnitsInTeam$HandleCallbackCount();

    @LogicBoolean$Parameter
    public void aggressiveTeam(boolean bl2) {
        if (bl2) {
            this.neutralTeam = true;
            this.useAggressiveTeamInsteadOfNeutralTeam = true;
        }
    }

    @LogicBoolean$Parameter
    public void withTag(String string2) {
        this._withTag = g.c(string2);
    }

    @Override
    public void validate(String string2, String string3, String string4, LogicBooleanLoader$LogicBooleanContext logicBooleanLoader$LogicBooleanContext, boolean bl2) {
        super.validate(string2, string3, string4, logicBooleanLoader$LogicBooleanContext, bl2);
        if (this.withinRange > 1000.0f) {
            throw new BooleanParseException("For CPU reasons withinRange argument cannot be over 1000 (but unlimited range is fine) in function:" + string2);
        }
        if (this.withinRange > 0.0f) {
            this.withinRangeSq = this.withinRange * this.withinRange;
            if (this.factoryQueue) {
                throw new BooleanParseException("'factoryQueue' and 'withinRange' are not supported at the same time in function:" + string2);
            }
        }
    }

    @Override
    public String getName() {
        return "Unit count of " + this._withTag + (this.withinRange < 0.0f ? "" : " (within range " + this.withinRange + ")");
    }

    @Override
   public float getValue(y var1) {
      g var2 = this._withTag;
      PlayerTeam var3;
      if (this.allTeams) {
         var3 = null;
      } else if (this.neutralTeam) {
         if (!this.useAggressiveTeamInsteadOfNeutralTeam) {
            var3 = PlayerTeam.i;
         } else {
            var3 = PlayerTeam.h;
         }
      } else {
         var3 = var1.bX;
      }

      int var4;
      if (var3 == null) {
         var4 = 0;
         PlayerTeam[] var5 = PlayerTeam.d();
         PlayerTeam[] var6 = var5;
         int var7 = var5.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            PlayerTeam var9 = var6[var8];
            if (var2 == null) {
               var4 += var9.a(this.incompleteBuildings, this.factoryQueue);
            } else {
               var4 += var9.a(var2, this.incompleteBuildings, this.factoryQueue);
            }
         }
      } else if (var2 == null) {
         var4 = var3.a(this.incompleteBuildings, this.factoryQueue);
      } else {
         var4 = var3.a(var2, this.incompleteBuildings, this.factoryQueue);
      }

      if (!(this.withinRange < 0.0F) && var4 != 0) {
         handleCallbackCount.withinRangeSq = this.withinRangeSq;
         handleCallbackCount.count = 0;
         handleCallbackCount.tag = var2;
         handleCallbackCount.incompleteBuildings = this.incompleteBuildings;
         handleCallbackCount.targetTeam = var3;
         GameEngine var10 = GameEngine.getInstance();
         var10.cc.a(var1.posX, var1.posY, this.withinRange, var1, 0.0F, handleCallbackCount);
         return (float)handleCallbackCount.count;
      } else {
         return (float)var4;
      }
   }
    @Override
    public float getMaxValue(y y2) {
        return 2.1474836E9f;
    }
}

