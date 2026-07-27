/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.j;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.UnitCommand;
import com.corrodinggames.rts.game.units.d.e;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.j.ChecksumField;
import com.corrodinggames.rts.gameFramework.GGameObject;
import java.util.ArrayList;
import java.util.List;

public class GameStateChecksum {
    public long a;
    public ArrayList<ChecksumField> b = new ArrayList<ChecksumField>();
    public ChecksumField c = new ChecksumField(this, "Unit Pos");
    public ChecksumField d = new ChecksumField(this, "Unit Dir", false);
    public ChecksumField e = new ChecksumField(this, "Unit Hp");
    public ChecksumField f = new ChecksumField(this, "Unit Id");
    public ChecksumField g = new ChecksumField(this, "Waypoints");
    public ChecksumField h = new ChecksumField(this, "Waypoints Pos");
    public ChecksumField i = new ChecksumField(this, "Team Credits");
    public ChecksumField j = new ChecksumField(this, "UnitPaths");
    public ChecksumField k = new ChecksumField(this, "Unit Count");
    public ChecksumField l = new ChecksumField(this, "Team Info", false);
    public ChecksumField m = new ChecksumField(this, "Team 1 Credits", false);
    public ChecksumField n = new ChecksumField(this, "Team 2 Credits", false);
    public ChecksumField o = new ChecksumField(this, "Team 3 Credits", false);
    public ChecksumField p = new ChecksumField(this, "Command center2", false);
    public ChecksumField q = new ChecksumField(this, "Command center3", false);

    public void a() {
        for (ChecksumField al2 : this.b) {
            al2.b = 0L;
        }
    }

    public void b() {
        this.a = 0L;
        this.a();
        for (Serializable bq2 : ((List<Serializable>) GGameObject.fastGameObjectList)) {
            Object object;
            if (!(bq2 instanceof y))
                continue;
            y y2 = (y) bq2;
            this.a = (long) ((float) this.a + y2.posX * 1000.0f);
            this.a = (long) ((float) this.a + y2.posY * 1000.0f);
            this.a = (long) ((float) this.a + y2.cu * 1.0f);
            this.a += y2.objectId;
            this.c.b += (long) Float.floatToRawIntBits(y2.posX);
            this.c.b += (long) Float.floatToRawIntBits(y2.posY);
            this.d.b += (long) Float.floatToRawIntBits(y2.cg);
            this.e.b = (long) ((float) this.e.b + y2.cu);
            this.f.b += y2.objectId;
            if (bq2 instanceof e) {
                object = (e) y2;
                this.p.b = (long) ((float) this.p.b + ((e) object).f * 2.0f);
                this.q.b += (long) ((e) object).h;
            }
            if ((object = y2.ar()) != null) {
                this.g.b += ((UnitCommand) object).j();
                this.h.b = (long) ((float) this.h.b + ((UnitCommand) object).g() * 1000.0f);
            }
            this.j.b += y2.aL();
        }
        for (int i2 = 0; i2 < com.corrodinggames.rts.game.PlayerTeam.c; ++i2) {
            Serializable bq2;
            bq2 = com.corrodinggames.rts.game.PlayerTeam.k(i2);
            if (bq2 == null)
                continue;
            this.i.b += (long) ((int) ((PlayerTeam) bq2).o);
            if (i2 == 0) {
                this.m.b += (long) ((int) ((PlayerTeam) bq2).o);
            }
            if (i2 == 1) {
                this.n.b += (long) ((int) ((PlayerTeam) bq2).o);
            }
            if (i2 == 2) {
                this.o.b += (long) ((int) ((PlayerTeam) bq2).o);
            }
            this.k.b += (long) ((PlayerTeam) bq2).w();
            this.l.b = this.l.b + (long) (i2 + ((PlayerTeam) bq2).x * 100 + ((PlayerTeam) bq2).r * 1000 + (((PlayerTeam) bq2).w ? i2 : 0) * 10000);
        }
    }
}
