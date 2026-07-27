/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import com.corrodinggames.rts.game.b.TileMap;
import com.corrodinggames.rts.game.b.MapLayer;
import com.corrodinggames.rts.game.b.MapLoadException;
import com.corrodinggames.rts.game.b.Tileset;
import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.UnitTypeEnum;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.h.d;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.y;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import com.corrodinggames.rts.gameFramework.GGameObject;

import java.io.IOException;
import java.util.Properties;

public final class MapTile {
    public Tileset a;
    public int b;
    public int c = -2;
    public short d = (short) -1;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public byte j;
    public boolean k;
    public boolean l;
    public MapTile[] m;
    static final Rect n = new Rect();

    public static boolean a(MapTile g2, MapTile g3) {
        if (g2 == g3) {
            return true;
        }
        if (g2 == null) {
            return false;
        }
        if (g3 == null) {
            return false;
        }
        if (g2.a != g3.a) {
            return false;
        }
        return g2.b == g3.b;
    }

    public MapTile a() {
        MapTile g2 = new MapTile();
        g2.a = this.a;
        g2.b = this.b;
        g2.e = this.e;
        g2.f = this.f;
        g2.g = this.g;
        g2.h = this.h;
        g2.i = this.i;
        g2.j = this.j;
        g2.k = this.k;
        g2.l = this.l;
        return g2;
    }

    public static void a(String string2) {
        com.corrodinggames.rts.gameFramework.GameEngine.b(string2);
        com.corrodinggames.rts.gameFramework.GameEngine.getInstance().a("Missing unit data while loading map: " + string2, 1);
        try {
            Thread.sleep(2L);
        } catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public static MapTile a(TileMap var0, MapLayer var1, Tileset var2, int var3, short var4, short var5, boolean var6) throws MapLoadException {
        Properties var7 = var2.a(var2.l + var3);
        String var11;
        int var20;
        if (var7 != null) {
            String var8 = var7.getProperty("showFog");
            if (var8 != null) {
                var20 = Integer.parseInt(var8);
                GameEngine var23 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
                var0.a(var4, var5);
                float var24 = (float) (var0.T + var0.p);
                float var26 = (float) (var0.U + var0.q);
                var23.bL.a(var24, var26, var20, var23.bs, false);
                return null;
            }

            String var9 = var7.getProperty("unit");
            String var10 = var7.getProperty("customUnit");
            if (var9 != null || var10 != null) {
                var11 = var7.getProperty("team");
                PlayerTeam var25 = null;
                if ("none".equalsIgnoreCase(var11)) {
                    var25 = com.corrodinggames.rts.game.PlayerTeam.k(-1);
                } else {
                    if (var11 == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("map",
                                "warning: unit has no team property:" + var9 + " at: " + var4 + "," + var5);
                        return null;
                    }

                    var25 = com.corrodinggames.rts.game.PlayerTeam.k(Integer.valueOf(var11));
                    if (var25 == null) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("map", "skipping unit without player:" + var9
                                + " at: " + var4 + "," + var5 + " team:" + var11);
                        return null;
                    }

                    if (var25.b()) {
                        com.corrodinggames.rts.gameFramework.GameEngine.b("map",
                                "Unit team is marked as spectator:" + var9 + " (skipping unit)");
                        return null;
                    }
                }

                Object var13 = null;
                String var28;
                if (var10 != null) {
                    com.corrodinggames.rts.game.units.custom.l var14 = com.corrodinggames.rts.game.units.custom.l
                            .n(var10);
                    if (var14 == null) {
                        var28 = "Could not find custom unit of:" + var10 + " at x:" + var4 + ", y:" + var5;
                        a(var28);
                        throw new MapLoadException(var28);
                    }

                    UnitType var15 = com.corrodinggames.rts.game.units.custom.l.c(var14);
                    if (var15 != null) {
                        if (var15 instanceof com.corrodinggames.rts.game.units.custom.l) {
                            var14 = (com.corrodinggames.rts.game.units.custom.l) var15;
                        } else {
                            com.corrodinggames.rts.gameFramework.GameEngine
                                    .b("replacement not a custom unit:" + var15.i());
                        }
                    }

                    var13 = com.corrodinggames.rts.game.units.custom.l.a(false, var14);
                    if (var13 == null) {
                        String var16 = "Metadata unit is null for:" + var10;
                        a(var16);
                        throw new MapLoadException(var16);
                    }
                } else {
                    UnitType var27 = UnitTypeEnum.a(var9);
                    if (var27 != null) {
                        var13 = var27.createUnitInstance();
                    }

                    if (var13 == null && "scoutShip".equalsIgnoreCase(var9)) {
                        var13 = new d(false);
                    }

                    if (var13 == null) {
                        var28 = "Could not find unit:" + var9 + " at: " + var4 + "," + var5;
                        a(var28);
                        throw new MapLoadException(var28);
                    }
                }

                var0.a(var4, var5);
                ((BaseUnit) var13).posX = (float) var0.T + ((BaseUnit) var13).cZ();
                ((BaseUnit) var13).posY = (float) var0.U + ((BaseUnit) var13).da();
                if (var25 == null) {
                    throw new MapLoadException("team has not been set for:" + var9);
                }

                ((BaseUnit) var13).b(var25);
                if (var7.getProperty("type") != null) {
                    ((BaseUnit) var13).a_(var7.getProperty("type"));
                }

                if (var7.getProperty("randomRotate") != null) {
                    ((BaseUnit) var13).cg = (float) com.corrodinggames.rts.gameFramework.GameUtils.a((BaseUnit) var13, -180, 180);
                }

                ((BaseUnit) var13).bO = "builder".equalsIgnoreCase(var9) || "builder".equalsIgnoreCase(var10);
                ((BaseUnit) var13).bP = "commandCenter".equalsIgnoreCase(var9) || "commandCenter".equalsIgnoreCase(var10);
                ((BaseUnit) var13).bM = true;
                ((BaseUnit) var13).n();
                com.corrodinggames.rts.game.PlayerTeam.c((BaseUnit) var13);
                GGameObject.dL();
                return null;
            }

            if (var1 != null && var1.l.equals("units")) {
                Log.d("RustedWarfare", "non unit on units layer at:" + var4 + "," + var5);
                return null;
            }
        }

        MapTile var19 = new MapTile();
        var19.a = var2;
        var2.p = true;
        if (var1 != null && !var1.r) {
            var2.r = true;
        }

        if (var6) {
            var2.q = true;
        }

        var19.b = var3;
        if (var7 != null) {
            if (var7.getProperty("water") != null) {
                var19.e = true;
            }

            if (var7.getProperty("water-bridge") != null) {
                var19.f = true;
            }

            if (var7.getProperty("lava") != null || var7.getProperty("lava-cliff") != null) {
                var19.g = true;
                if (var7.getProperty("lava-cliff") != null) {
                    var19.h = true;
                }
            }

            if (var7.getProperty("cliff-soft") != null) {
                var19.h = true;
            }

            if (var7.getProperty("cliff") != null) {
                var19.h = true;
            }

            if (var7.getProperty("large-cliff") != null) {
                var19.k = true;
            }

            if (var7.getProperty("trees") != null) {
                var19.k = true;
            }

            if (var7.getProperty("res_pool") != null) {
                var19.i = true;
            }

            if (var7.getProperty("tree") != null) {
            }

            if (var7.getProperty("small-rock") != null) {
                var19.j = 40;
            }

            if (var7.getProperty("large-rock") != null) {
                var19.j = -1;
            }

            if (var7.getProperty("block-land") != null) {
                var19.j = -1;
            }

            if (var7.getProperty("block-buildings") != null) {
                var19.l = true;
            }
        }

        var20 = 0;
        int var21 = 0;
        if (var19.a != null) {
            var11 = var19.a.c;
            if (var11 != null) {
                if (var19.b == 0 && var11.equals("shallowwater.png")) {
                    var20 = 5;
                }

                if (var19.b == 0 && var11.equals("deepwater.png")) {
                    var20 = 2;
                }

                if (var19.b == 0 && var11.equals("water.png")) {
                    var20 = 2;
                }

                if (var19.b == 0 && var11.equals("longgrass.png")) {
                    var20 = 3;
                }

                if (var19.b == 0 && var11.equals("mountain.png")) {
                    var20 = 3;
                }

                if (var19.b == 7 && var11.equals("stone.png")) {
                    var20 = 4;
                    var21 = 23;
                }

                if (var19.b == 0 && var11.equals("lava.png")) {
                }

                if (var19.b == 0 && var11.equals("snow.png")) {
                    var20 = 2;
                }
            }
        }

        if (var7 != null && var7.getProperty("randomTileBy") != null) {
            try {
                var20 = Integer.parseInt(var7.getProperty("randomTileBy"));
            } catch (NumberFormatException var18) {
                throw new MapLoadException("(x:" + var4 + "y:" + var5 + ") - randomTileBy: Unexpected integer value:'"
                        + var7.getProperty("randomTileBy") + "'");
            }

            if (var7.getProperty("randomTileFixedOffset") != null) {
                try {
                    var21 = Integer.parseInt(var7.getProperty("randomTileFixedOffset"));
                } catch (NumberFormatException var17) {
                    throw new MapLoadException("(x:" + var4 + "y:" + var5 + ") - randomTileFixedOffset: Unexpected integer value:'"
                            + var7.getProperty("randomTileBy") + "'");
                }
            }
        }

        if (var20 > 0) {
            MapTile[] var22 = new MapTile[var20];

            for (int var12 = 0; var12 < var20; ++var12) {
                var22[var12] = var19.a();
                var22[var12].b += var12 + 1 + var21;
            }

            var19.m = var22;
        }

        return var19;
    }

    MapTile() {
    }

    public void a(y y2, RectF rectF, float f2, Paint paint) throws IOException {
        Tileset j2 = this.a;
        Rect rect = j2.b(this.b);
        y2.a(j2.b, rect, rectF, paint);
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }
}
