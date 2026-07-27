/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.n.a;

import com.corrodinggames.rts.game.b.MapLoadException;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.gameFramework.n.MapTrigger;

public class TeamTagDetectCondition
extends com.corrodinggames.rts.gameFramework.n.a.TriggerCondition {
    PlayerTeam a;
    g b;

    public static TeamTagDetectCondition d(MapTrigger a2) throws MapLoadException {
        TeamTagDetectCondition b2 = new TeamTagDetectCondition();
        b2.a = a2.a();
        if (b2.a == null) {
            throw new MapLoadException("teamTagDetect requires a team set");
        }
        String string2 = a2.b("teamTag");
        if (string2 != null && !string2.equals("")) {
            try {
                b2.b = g.b(string2);
            }
            catch (bo bo2) {
                throw new MapLoadException(bo2.getMessage());
            }
        } else {
            throw new MapLoadException("teamTagDetect requires a teamTag set");
        }
        return b2;
    }

    @Override
    public boolean b(MapTrigger a2) {
        return g.a(this.b, this.a.U());
    }
}

