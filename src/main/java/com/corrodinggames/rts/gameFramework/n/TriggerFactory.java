/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.n;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.custom.bb;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.bp;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.n.MapTrigger;
import com.corrodinggames.rts.gameFramework.n.a.TeamTagDetectCondition;

import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Typeface;

import com.corrodinggames.rts.gameFramework.n.TriggerType;
import com.corrodinggames.rts.gameFramework.n.MissionEngine;

public class TriggerFactory {
    public static MapTrigger a(MissionEngine f2, com.corrodinggames.rts.game.b.MapObject a2)
            throws com.corrodinggames.rts.game.b.MapLoadException {
        try {
            String string2;
            TriggerType e2;
            String string3;
            GameEngine l2 = GameEngine.getInstance();
            String string4 = a2.b;
            if (string4 == null) {
                string4 = "NULL";
            }
            if ((string3 = a2.b("id")) != null && !string3.equals("")) {
                string4 = string3;
            }
            string4 = string4.trim();
            String string5 = a2.d;
            if (string5 != null) {
                e2 = TriggerType.a(string5);
                if (e2 == null) {
                    MissionEngine.c("Error: Unknown type:" + string5 + " found on " + string4);
                    return null;
                }
            } else {
                MissionEngine.c("Error: no type field set for: " + string4);
                return null;
            }
            MapTrigger a3 = new MapTrigger();
            a3.t = a2;
            a3.g = e2;
            a3.b = string4;
            int n2 = 0;
            for (MapTrigger a4 : f2.J) {
                if (!a4.b.equalsIgnoreCase(a3.b))
                    continue;
                ++n2;
            }
            a3.c = a3.b;
            if (n2 != 0) {
                a3.c = a3.c + "_" + n2;
            }
            a3.a = a2.b;
            Integer n3 = a3.d("team");
            if (n3 != null) {
                a3.y = PlayerTeam.k(n3);
                if (a3.y == null) {
                    a3.g("Cannot find team:" + n3);
                    return null;
                }
            }
            a3.r = a3.b("delay", a3.r);
            a3.p = a3.b("repeatDelay", a3.p);
            a3.o = a3.a("repeatCount", a3.o);
            a3.q = a3.b("resetActivationAfter", a3.q);
            a3.d.b = a3.h = a3.a("allToActivate", false);
            a3.s = a3.b("warmup", a3.s);
            a3.A = a3.a("globalMessage", (bb) null);
            a3.w = a3.a("textOffsetX", 0.0f);
            a3.x = a3.a("textOffsetY", 0.0f);
            if (a3.g == TriggerType.mapText || a3.g == TriggerType.objective) {
                a3.z = a3.a("text", (bb) null);
            }
            if (a3.g == TriggerType.mapText) {
                f2.i = true;
                a3.B = new Paint();
                a3.B.a(true);
                a3.B.a(Paint$Align.b);
                a3.B.a(Typeface.a(Typeface.c, 1));
                int n4 = a3.c("textColor", -1);
                a3.B.b(n4);
                int n5 = a3.a("textSize", 20);
                l2.b(a3.B, (float) n5);
                if (a3.B.f() == 0) {
                    a3.g("Text has an alpha of 0");
                }
                if ((string2 = a3.b("style")) != null && !string2.equals("")) {
                    if (string2.equalsIgnoreCase("arrow")) {
                        a3.C = true;
                    } else {
                        a3.g("Unknown style: " + string2);
                    }
                }
            }
            if (a3.g == TriggerType.event_unitAdd) {
                String string6 = a3.b("spawnUnits");
                String string7 = "<unitAdd>";
                string2 = "spawnUnits";
                try {
                    a3.v = bp.a(string6, string7, string2);
                } catch (bo bo2) {
                    MissionEngine.c(bo2.getMessage());
                    return null;
                }
                if (a3.a() == null) {
                    a3.g("No team set");
                }
            }
            if (a3.g == TriggerType.event_teamTags) {
                a3.a("addTeamTags");
                a3.a("removeTeamTags");
            }
            if (a3.g == TriggerType.event_changeCredits) {
                a3.a("add");
                a3.a("set");
            }
            if (a3.g == TriggerType.trigger_unitDetect) {
                a3.a(com.corrodinggames.rts.gameFramework.n.a.UnitCountCondition.d(a3));
            }
            if (a3.g == TriggerType.trigger_teamTagDetect) {
                a3.a(TeamTagDetectCondition.d(a3));
            }
            a3.a("comment");
            a3.a("team");
            a3.a("globalMessage");
            a3.a("globalMessage_delayPerChar");
            a3.a("globalMessage_textColor");
            a3.a("debugMessage");
            a3.a("showOnMap");
            a3.a("text");
            a3.a("target");
            a3.a("onlyIfEmpty");
            if (a3.g == TriggerType.event_move) {
                a3.a("unload");
            }
            if (a3.g == TriggerType.event_unitRemove) {
                a3.a("onlyIfEmpty");
            }
            return a3;
        } catch (RuntimeException runtimeException) {
            throw new com.corrodinggames.rts.game.b.MapLoadException("Error while reading: " + a2.b(),
                    runtimeException);
        }
    }
}
