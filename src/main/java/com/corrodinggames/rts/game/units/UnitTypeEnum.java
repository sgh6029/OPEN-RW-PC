package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.custom.d.b;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.e.f;
import com.corrodinggames.rts.game.units.h.c;
import com.corrodinggames.rts.game.units.h.d;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.h.a;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.Texture_M;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/*
com.corrodinggames.rts.game.units.ar -> com.corrodinggames.rts.game.units.UnitTypeEnum:
    com.corrodinggames.rts.game.units.a.z aa -> buildAction
    int ab -> buildPriority
    com.corrodinggames.rts.game.units.am a() -> createUnitInstance
    java.util.ArrayList a(int) -> getUnitsByCount
    int a(com.corrodinggames.rts.game.units.am) -> getUnitProperty
    boolean a(com.corrodinggames.rts.game.units.as,float,float,float,float,com.corrodinggames.rts.game.n) -> canPlaceUnit
    void a(com.corrodinggames.rts.game.units.as,float,float,float,float,com.corrodinggames.rts.game.n,float,float,boolean,boolean,int,com.corrodinggames.rts.game.units.am) -> drawUnit
    void a(com.corrodinggames.rts.game.units.as,float,float,float,float,com.corrodinggames.rts.game.n,float,float,boolean,boolean,int,boolean,com.corrodinggames.rts.game.units.am) -> drawUnitWithBoolean
    int a(com.corrodinggames.rts.game.units.y) -> getUnitCountByUnit
    com.corrodinggames.rts.game.units.as a(java.lang.String) -> getUnitTypeByName
    java.lang.String a(java.lang.String,float) -> formatStringWithFloat
    java.lang.String a(java.lang.String,float,java.lang.String) -> formatStringWithFloatAndString
    java.lang.String a(java.lang.String,java.lang.String,java.lang.String) -> formatStringWithThreeStrings
    com.corrodinggames.rts.game.units.as a(java.lang.String,boolean) -> getUnitTypeByNameWithBoolean
    void a(java.util.ArrayList,int) -> addUnitsToList
    com.corrodinggames.rts.game.units.am a(boolean) -> createUnitInstanceWithBoolean
    boolean A() -> createUnit
    void b() -> abstractMethodB
    int b(int) -> getUnitPropertyWithInt
    com.corrodinggames.rts.game.units.custom.d.b B() -> loadResources
    int c() -> canBeBuilt
    int c(int) -> getUpgradeCost
    com.corrodinggames.rts.game.units.a.z d() -> getUnitTypeDescription
    com.corrodinggames.rts.game.units.custom.d.b d(int) -> getUnitTypeDescription
    java.lang.String e() -> getUnitName
    java.lang.String f() -> mo8111f
    int g() -> getBuildPoints
    void h() -> onUnitCreated
    java.lang.String i() -> getUnitDescriptionShort
    boolean j() -> isBuilding
    boolean k() -> isMobile
    boolean l() -> isFlying
    boolean m() -> hasTransport
    boolean n() -> isUnselectable
    com.corrodinggames.rts.game.units.ao o() -> getUnitMovementType
    boolean p() -> isLocked
    com.corrodinggames.rts.game.units.custom.be q() -> getCustomUnitMetadata
    void r() -> loadAllUnitTypes
    void s() -> loadUnitTypeImages
    void t() -> loadUnitTypeSounds
    com.corrodinggames.rts.game.units.custom.d.b u() -> getUnitTypeIcon
    java.lang.String v() -> getUnitTypeDescriptionString
    boolean w() -> isGlobalUnit
    com.corrodinggames.rts.game.units.custom.h x() -> getUnitCustomData
    boolean y() -> isExperimental
    com.corrodinggames.rts.gameFramework.m.e z() -> getUnitIconTexture
 */
//ar
public enum UnitTypeEnum implements UnitType {
    // 枚举常量定义 - 只列出部分作为示例

    extractor("extractor") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.g(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.g.K();
        }

        @Override
        public int c() {
            return 700;
        }

        @Override
        public int c(int n2) {
            if (n2 == 2) {
                return 1200;
            }
            if (n2 == 3) {
                return 2500;
            }
            return 0;
        }

        @Override
        public boolean p() {
            return true;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public int a(BaseUnit am2) {
            if (am2.cJ()) {
                return 110;
            }
            return 0;
        }
    },
    hoverTank("hoverTank") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.g(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.g.f();
        }

        @Override
        public int c() {
            return 450;
        }

        @Override
        public float D() {
            return 0.002f;
        }
    },
    artillery("artillery") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.a(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.a.f();
        }

        @Override
        public int c() {
            return 900;
        }

        @Override
        public float D() {
            return 0.0014f;
        }

    },
    helicopter("helicopter") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new f_f(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.b.f.f();
        }

        @Override
        public int c() {
            return 650;
        }

        @Override
        public float D() {
            return 0.0012f;
        }

    },
    airShip("airShip") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.b.AirShip(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.b.AirShip.f();
        }

        @Override
        public int c() {
            return 600;
        }

        @Override
        public float D() {
            return 0.002f;
        }

    },
    gunShip("gunShip") {

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.b.e(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.b.e.f();
        }

        @Override
        public int c() {
            return 800;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public int g() {
            return 2;
        }
    },
    missileShip("missileShip") {

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new d(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.h.d.f();
        }

        @Override
        public int c() {
            return 900;
        }

        @Override
        public float D() {
            return 0.001f;
        }
    },
    gunBoat("gunBoat") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new c(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.h.c.f();
        }

        @Override
        public int c() {
            return 300;
        }

        @Override
        public float D() {
            return 0.005f;
        }

    },
    megaTank("megaTank") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.m(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.m.f();
        }

        @Override
        public int c() {
            return 800;
        }

        @Override
        public float D() {
            return 0.0015f;
        }

    },
    laserTank("laserTank") {
        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.k(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.k.f();
        }

        @Override
        public int c() {
            return 1300;
        }

        @Override
        public float D() {
            return 0.0013f;
        }

        @Override
        public int g() {
            return 2;
        }

    },
    hovercraft("hovercraft") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.i(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.i.L();
        }

        @Override
        public int c() {
            return 600;
        }

        @Override
        public float D() {
            return 0.003f;
        }
    },
    landFactory("landFactory") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.m(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.m.b();
        }

        @Override
        public int c() {
            return 700;
        }

        @Override
        public int c(int n2) {
            if (n2 == 2) {
                return 2000;
            }
            return 0;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
            com.corrodinggames.rts.game.units.d.m.a(arrayList, n2);
        }
    },
    ladybug("ladybug") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.c.a(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.c.a.f();
        }

        @Override
        public int c() {
            return 400;
        }

        @Override
        public float D() {
            return 0.004f;
        }
    },
    battleShip("battleShip") {
        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.h.a(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.h.a.f();
        }

        @Override
        public int c() {
            return 1500;
        }

        @Override
        public float D() {
            return 0.001f;
        }

    },
    tankDestroyer("tankDestroyer") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.o(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.o.f();
        }

        @Override
        public int c() {
            return 800;
        }

        @Override
        public float D() {
            return 0.003f;
        }
    },
    heavyTank("heavyTank") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.f(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.f.f();
        }

        @Override
        public int c() {
            return 800;
        }

        @Override
        public float D() {
            return 0.0011f;
        }

        @Override
        public int g() {
            return 2;
        }
    },
    heavyHoverTank("heavyHoverTank") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.e(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.e.f();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public int g() {
            return 2;
        }
    },
    laserDefence("laserDefence") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.p(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.p.b();
        }

        @Override
        public int c() {
            return 1200;
        }

        @Override
        public int c(int n2) {
            if (n2 == 2) {
                return 2000;
            }
            return 0;
        }

        @Override
        public float D() {
            return 0.001f;
        }
    },
    dropship("dropship") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.b.d(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.b.d.L();
        }

        @Override
        public int c() {
            return 800;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public int g() {
            return 2;
        }
    },
    tree("tree") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new Tree(bl2);
        }

        @Override
        public void b() {
            Tree.b();
        }

        @Override
        public int c() {
            return 0;
        }

        @Override
        public float D() {
            return 0.0025f;
        }
    },
    repairbay("repairbay") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl) {
            return new com.corrodinggames.rts.game.units.d.r(bl);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.r.M();
        }

        @Override
        public int c() {
            return 1500;
        }

        @Override
        public float D() {
            return 0.001f;
        }
    },
    NukeLaucher("NukeLaucher") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.q(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.q.b();
        }

        @Override
        public int c() {
            return 45000;
        }

        @Override
        public float D() {
            return 1.0E-4f;
        }
    },
    airFactory("airFactory") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.a_f(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.a_f.b();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public int c(int n2) {
            if (n2 == 2) {
                return 1500;
            }
            return 0;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
            com.corrodinggames.rts.game.units.d.a_f.a(arrayList, n2);
        }
    },
    AntiNukeLaucher("AntiNukeLaucher") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.c(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.c.b();
        }

        @Override
        public int c() {
            return 15000;
        }

        @Override
        public float D() {
            return 7.0E-4f;
        }
    },
    mammothTank("mammothTank") {
        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.l(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.l.f();
        }

        @Override
        public int c() {
            return 3900;
        }

        @Override
        public float D() {
            return 9.0E-4f;
        }

        @Override
        public int g() {
            return 3;
        }
    },
    experimentalTank("experimentalTank") {
        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new d(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.d.f();
        }

        @Override
        public int c() {
            return 14000;
        }

        @Override
        public float D() {
            return 2.0E-4f;
        }

        @Override
        public int g() {
            return 3;
        }
    },
    experimentalLandFactory("experimentalLandFactory") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.f(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.f.b();
        }

        @Override
        public int c() {
            return 11000;
        }

        @Override
        public float D() {
            return 3.5E-4f;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
            com.corrodinggames.rts.game.units.d.f.a(arrayList, n2);
        }
    },
    crystalResource("crystalResource") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new e_f(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e_f.a_();
        }

        @Override
        public int c() {
            return 5000;
        }

        @Override
        public float D() {
            return 0.001f;
        }
    },
    wall_v("wall_v") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.w(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.w.b();
        }

        @Override
        public int c() {
            return 100;
        }

        @Override
        public float D() {
            return 0.003f;
        }
    },
    fabricator("fabricator") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.h(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.h.K();
        }

        @Override
        public int c() {
            return 1500;
        }

        @Override
        public int c(int n2) {
            if (n2 == 2) {
                return 3000;
            }
            if (n2 == 3) {
                return 5000;
            }
            return 0;
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    attackSubmarine("attackSubmarine") {
        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.h.e(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.h.e.b();
        }

        @Override
        public int c() {
            return 800;
        }

        @Override
        public float D() {
            return 0.001f;
        }
    },
    builderShip("builderShip") {

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.h.b(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.h.b.t_();
        }

        @Override
        public int c() {
            return 500;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public boolean l() {
            return true;
        }

        @Override
        public boolean m() {
            return false;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
            com.corrodinggames.rts.game.units.h.b.a(arrayList, n2);
        }
    },
    amphibiousJet("amphibiousJet") {
        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.b.c(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.b.c.L();
        }

        @Override
        public int c() {
            return 2000;
        }

        @Override
        public float D() {
            return 0.001f;
        }

        @Override
        public int g() {
            return 2;
        }
    },
    seaFactory("seaFactory") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.t(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.t.b();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public int c(int n2) {
            if (n2 == 2) {
                return 2000;
            }
            return 0;
        }

        @Override
        public float D() {
            return 7.0E-4f;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
            com.corrodinggames.rts.game.units.d.t.a(arrayList, n2);
        }

        @Override
        public int a(BaseUnit am2) {
            return 110;
        }
    },
    supplyDepot("supplyDepot") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.v(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.v.K();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public float D() {
            return 0.001f;
        }
    },
    experimentalHoverTank("experimentalHoverTank") {
        @Override
        public boolean C() {
            return false;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.c(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.c.f();
        }

        @Override
        public int c() {
            return 21000;
        }

        @Override
        public float D() {
            return 2.0E-4f;
        }

        @Override
        public int g() {
            return 3;
        }
    },
    turret_artillery("turret_artillery") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            com.corrodinggames.rts.game.units.d.a.b b2 = new com.corrodinggames.rts.game.units.d.a.b(bl2);
            ((BaseUnit) b2).a_("artillery");
            return b2;
        }

        @Override
        public void b() {
        }

        @Override
        public int c() {
            return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.b.dN.c();
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    turret_flamethrower("turret_flamethrower") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            com.corrodinggames.rts.game.units.d.a.b b2 = new com.corrodinggames.rts.game.units.d.a.b(bl2);
            ((BaseUnit) b2).a_("flamethrower");
            return b2;
        }

        @Override
        public void b() {
        }

        @Override
        public int c() {
            return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.b.dO.c();
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    fogRevealer("fogRevealer") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            com.corrodinggames.rts.game.units.u u2 = new com.corrodinggames.rts.game.units.u(bl2);
            return u2;
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.u.f();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    spreadingFire("spreadingFire") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            FireUnit ai2 = new FireUnit(bl2);
            return ai2;
        }

        @Override
        public void b() {
            FireUnit.b();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    antiAirTurretT2("antiAirTurretT2") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            com.corrodinggames.rts.game.units.d.a.a a2 = new com.corrodinggames.rts.game.units.d.a.a(bl2);
            a2.a(2);
            return a2;
        }

        @Override
        public void b() {
        }

        @Override
        public int c() {
            return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.a.e.c();
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    turretT2("turretT2") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            com.corrodinggames.rts.game.units.d.a.b b2 = new com.corrodinggames.rts.game.units.d.a.b(bl2);
            ((BaseUnit) b2).a_("gunT2");
            return b2;
        }

        @Override
        public void b() {
        }

        @Override
        public int c() {
            return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.b.dL.c();
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    turretT3("turretT3") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            com.corrodinggames.rts.game.units.d.a.b b2 = new com.corrodinggames.rts.game.units.d.a.b(bl2);
            ((BaseUnit) b2).a_("gunT3");
            return b2;
        }

        @Override
        public void b() {
        }

        @Override
        public int c() {
            return UnitTypeEnum.turret.c() + com.corrodinggames.rts.game.units.d.a.b.dL.c()
                    + com.corrodinggames.rts.game.units.d.a.b.dM.c();
        }

        @Override
        public float D() {
            return 3.0E-4f;
        }
    },
    damagingBorder("damagingBorder") {
        @Override
        public boolean A() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            f f2 = new f(bl2);
            return f2;
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.f_f.d_();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    commandCenter("commandCenter") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.e(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.e.b();
        }

        @Override
        public int c() {
            return 3000;
        }

        @Override
        public float D() {
            return 5.0E-4f;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
            com.corrodinggames.rts.game.units.d.e.a(arrayList, n2);
        }
    },
    zoneMarker("zoneMarker") {
        @Override
        public boolean A() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            com.corrodinggames.rts.game.units.f_f f2 = new com.corrodinggames.rts.game.units.f_f(bl2);
            f2.q = true;
            return f2;
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.f_f.d_();
        }

        @Override
        public int c() {
            return 1000;
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    editorOrBuilder("editorOrBuilder") {
        @Override
        public boolean A() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.h_f(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.h_f.K();
        }

        @Override
        public int c() {
            return 500;
        }

        @Override
        public float D() {
            return 0.002f;
        }

        @Override
        public boolean l() {
            return true;
        }

        @Override
        public boolean m() {
            return false;
        }

        @Override
        public boolean n() {
            return false;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
        }
    },
    dummyNonUnitWithTeam("editorOrBuilder") {
        @Override
        public String e() {
            return this.i();
        }

        @Override
        public String i() {
            return "marker";
        }

        @Override
        public boolean A() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            t t2 = new t(bl2);
            return t2;
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.t.b();
        }

        @Override
        public int c() {
            return 9999;
        }

        @Override
        public float D() {
            return 1.0f;
        }
    },
    // Not have-49
    turret("turret") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.a.b(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.a.b.dB();
        }

        @Override
        public int c() {
            return 500;
        }

        @Override
        public float D() {
            return 6.0E-4f;
        }
    },
    antiAirTurret("antiAirTurret") {
        @Override
        public boolean j() {
            return true;
        }

        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.d.a.a(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.d.a.a.b();
        }

        @Override
        public int c() {
            return 600;
        }

        @Override
        public float D() {
            return 8.0E-4f;
        }
    },
    builder("builder") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.b(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.b.K();
        }

        @Override
        public int c() {
            return 500;
        }

        @Override
        public float D() {
            return 0.002f;
        }

        @Override
        public boolean l() {
            return true;
        }

        @Override
        public boolean m() {
            return true;
        }

        @Override
        public boolean n() {
            return true;
        }

        @Override
        public void a(ArrayList arrayList, int n2) {
            com.corrodinggames.rts.game.units.e.b.a(arrayList, n2);
            com.corrodinggames.rts.game.units.h_f.a((ArrayList) null, n2);
        }
    },
    tank("tank") {
        @Override
        public boolean C() {
            return true;
        }

        @Override
        public BaseUnit createUnitInstanceWithBoolean(boolean bl2) {
            return new com.corrodinggames.rts.game.units.e.n(bl2);
        }

        @Override
        public void b() {
            com.corrodinggames.rts.game.units.e.n.f();
        }

        @Override
        public int c() {
            return 350;
        }

        @Override
        public float D() {
            return 0.002f;
        }
    },
    // ... 其他50个枚举常量类似定义
    ;

    // 字段定义
    private com.corrodinggames.rts.game.units.a.SelectUnitTypeAction aa;
    private int ab = -1;
    private String ac;
    private String ad;
    public static ArrayList ae = new ArrayList();
    private UnitContainer[] af;
    public static boolean ag;
    private b ah;

    private final String name;

    private UnitTypeEnum(String name) {
        this.name = name;
        this.aa = new com.corrodinggames.rts.game.units.a.SelectUnitTypeAction(this);
    }

    // 抽象方法
    public abstract BaseUnit createUnitInstanceWithBoolean(boolean arg0);

    public abstract void b();

    public abstract int c();

    // 具体方法实现
    //
    public BaseUnit createUnitInstance() {
        return createUnitInstanceWithBoolean(false);
    }

    @Override
    public com.corrodinggames.rts.game.units.a.SelectUnitTypeAction d() {
        return aa;
    }

    public String e() {
        if (this.ab != com.corrodinggames.rts.gameFramework.h.a.c || this.ac == null) {
            this.ab = com.corrodinggames.rts.gameFramework.h.a.c;
            String var1 = "units." + this.name() + ".name";
            Object[] arr = new Object[0];
            this.ac = com.corrodinggames.rts.gameFramework.h.a.a(var1, (String) null, arr);
            if (this.ac == null) {
                if (com.corrodinggames.rts.gameFramework.GameEngine.getInstance().as() && !this.A()) {
                    throw new RuntimeException("Can't find translation text for: " + var1);
                }

                this.ac = this.name();
            }
        }
        return this.ac;
    }

    public String f() {
        if (ab != a.c || ad == null) {
            ab = a.c;
            String key = "units." + name() + ".description";
            ad = a.a(key, null);

            if (ad == null && GameEngine.getInstance().as() && !A()) {
                // Provide default descriptions for missing units instead of throwing exception
            }
            if (ad == null) {
                ad = "";
            }
        }
        return ad;
    }

    public int g() {
        return 1;
    }

    public void a(ArrayList<UnitType> arg0, int arg1) {
        // 空实现
    }

    public void h() {
        af = new UnitContainer[3];
        for (int i = 1; i <= 3; i++) {
            UnitContainer techLevel = new UnitContainer();
            a(techLevel.a, i);
            af[i - 1] = techLevel;
        }
    }

    public ArrayList<UnitType> a(int techLevel) {
        if (techLevel > 3) {
            throw new RuntimeException("Tech level:" + techLevel + " greater than maxTechLevel");
        }
        return af[techLevel - 1].a;
    }

    public String i() {
        return name();
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return j();
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public UnitMovementType o() {
        BaseUnit sharedUnit = BaseUnit.a(this);
        if (sharedUnit == null) {
            throw new RuntimeException("Shared unit is null for:" + name());
        }
        return sharedUnit.h();
    }

    public boolean p() {
        return false;
    }

    public com.corrodinggames.rts.game.units.custom.be q() {
        return null;
    }

    // 静态方法
    public static UnitType a(String name) {
        return a(name, true);
    }

    public static UnitType a(String name, boolean checkCustom) {
        if (checkCustom) {
            UnitType customUnit = l.m(name);
            if (customUnit != null) {
                return customUnit;
            }
        }

        for (UnitTypeEnum unit : values()) {
            if (unit.name().equalsIgnoreCase(name)) {
                return unit;
            }
        }

        return l.n(name);
    }

    private static String a(String string2, float f2) {
        return UnitTypeEnum.a(string2, f2, "");
    }

    private static String a(String string2, float f2, String string3) {
        String string4 = "" + f2;
        if (f2 % 1.0f == 0.0f) {
            string4 = "" + (int) f2;
        }
        return UnitTypeEnum.a(string2, string4, string3);
    }

    private static String a(String string2, String string3, String string4) {
        return string2 + ": " + string3 + string4 + "\n";
    }

    private static int a(com.corrodinggames.rts.game.units.y y2) {
        com.corrodinggames.rts.game.units.a.AbstractUnitAction s2;
        com.corrodinggames.rts.game.units.a.ActionId c2 = y2.cm();
        if (c2 != null && (s2 = y2.a(c2)) != null) {
            return s2.c();
        }
        return 0;
    }

    public static void r() {
        String string2 = "output_all_unit_images/";
        new File(string2).mkdirs();
        for (int i2 = 0; i2 < 50; ++i2) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("running outputUnitImages()");
        }
        String[] stringArray = new String[] { "carrier", "experimentalGunship", "experimentalGunshipLanded", "mech_gun",
                "ladybug", "spiderBot", "wall_v", "crystalResource", "test_tank", "missing", "fogRevealer",
                "supplyDepot", "tankDestroyer", "megaTank", "crystal_mid", "mechFlyingLanded" };
        for (UnitType as2 : ((ArrayList<UnitType>) ae)) {
            UnitType as3;
            BaseUnit am2 = BaseUnit.a(as2);
            if (!(am2 instanceof y) || as2.i().startsWith("bug")
                    || (as3 = com.corrodinggames.rts.game.units.custom.l.c(as2)) != null
                    || as2 instanceof l && !((l) as2).aF)
                continue;
            y y2 = (y) am2;
            boolean bl2 = false;
            for (String string3 : stringArray) {
                if (!string3.equals(as2.i()))
                    continue;
                bl2 = true;
            }
            if (bl2)
                continue;
            String string4 = string2 + as2.i().replace("/", "_").replace("\\", "_") + ".png";
            com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine
                    .getInstance();
            int n2 = 100;
            Texture_M e2 = l2.bO.b(n2, n2, true);
            com.corrodinggames.rts.gameFramework.m.y y3 = l2.bO.b(e2);
            com.corrodinggames.rts.gameFramework.m.y y4 = l2.bO;
            l2.bO = y3;
            float f2 = 0.0f;
            float f3 = 0.0f;
            com.corrodinggames.rts.game.PlayerTeam n3 = com.corrodinggames.rts.game.PlayerTeam.k(0);
            boolean bl3 = false;
            boolean bl4 = false;
            int n4 = 1;
            boolean bl5 = true;
            try {
                UnitTypeEnum.a(as2, e2.r, e2.s, f2, f3, n3, 20.0f, n2, bl3, bl4, n4, bl5, null);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            l2.bO = y4;
            y3.p();
            l2.bO.a(e2, new File(string4));
        }
    }

    private static final class ar$49
            implements Comparator {
        ar$49() {
        }

        public int a(UnitType as2, UnitType as3) {
            b b2 = as2.u();
            b b3 = as3.u();
            int n2 = b2.a(b3);
            return n2;
        }

        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((UnitType) object, (UnitType) object2);
        }
    }

    @SuppressWarnings("unchecked")
    public static void s() {
        for (int i2 = 0; i2 < 50; ++i2) {
            com.corrodinggames.rts.gameFramework.GameEngine.a("running printForHelp()");
        }
        String[] stringArray = new String[] { "carrier", "experimentalGunship", "experimentalGunshipLanded", "mech_gun",
                "ladybug", "spiderBot", "wall_v", "crystalResource", "test_tank", "missing", "fogRevealer",
                "supplyDepot", "tankDestroyer", "megaTank", "crystal_mid", "mechFlyingLanded" };
        String string2 = "";
        ArrayList<UnitType> arrayList = new ArrayList<UnitType>();
        arrayList.addAll(ae);
        Collections.sort(arrayList, new ar$49());
        for (UnitType as2 : arrayList) {
            int n2;
            UnitType as3;
            BaseUnit am2 = BaseUnit.a(as2);
            if (!(am2 instanceof y) || as2.i().startsWith("bug")
                    || (as3 = com.corrodinggames.rts.game.units.custom.l.c(as2)) != null
                    || as2 instanceof l && !((l) as2).aF || as2 == editorOrBuilder)
                continue;
            y y2 = (y) am2;
            boolean bl2 = false;
            String[] stringArray2 = stringArray;
            int n3 = stringArray2.length;
            for (n2 = 0; n2 < n3; ++n2) {
                String string3 = stringArray2[n2];
                if (!string3.equals(as2.i()))
                    continue;
                bl2 = true;
            }
            if (bl2)
                continue;
            string2 = string2 + "\n";
            string2 = string2 + "<div class=\"unit\">\n";
            string2 = string2 + "<img src=\"unit:" + as2.i() + "\" />\n";
            string2 = string2 + "<h4>" + as2.e() + "</h4>\n";
            string2 = string2 + "<p>" + as2.f().replace("\n", "<br/>") + "</p>\n";
            string2 = string2 + "<pre>";
            string2 = string2 + UnitTypeEnum.a("Price", "$" + as2.c(), "");
            int n4 = UnitTypeEnum.a(y2);
            if (n4 > 0) {
                string2 = string2 + UnitTypeEnum.a("T2 Upgrade Price", "$" + n4, "");
                y y3 = (y) as2.createUnitInstance();
                y3.a(2);
                if (y3.V() == 2 && (n2 = UnitTypeEnum.a(y3)) > 0) {
                    string2 = string2 + UnitTypeEnum.a("T3 Upgrade Price", "$" + n2, "");
                }
            }
            string2 = string2 + UnitTypeEnum.a("Hp", y2.cv);
            string2 = string2 + UnitTypeEnum.a("Speed", y2.z());
            string2 = string2 + UnitTypeEnum.a("Turn speed", y2.A());
            string2 = string2 + UnitTypeEnum.a("Mass", y2.bN());
            if (y2.l()) {
                string2 = string2 + UnitTypeEnum.a("Shoot Delay", y2.b(0));
                string2 = string2 + UnitTypeEnum.a("Attack Range", y2.m());
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                int n5 = y2.bl();
                for (int i3 = 0; i3 < n5; ++i3) {
                    int n6 = com.corrodinggames.rts.game.f.a.a;
                    y2.a((BaseUnit) y2, i3);
                    if (n6 == com.corrodinggames.rts.game.f.a.a)
                        continue;
                    com.corrodinggames.rts.game.f f6 = (com.corrodinggames.rts.game.f) com.corrodinggames.rts.game.f.a
                            .get(com.corrodinggames.rts.game.f.a.a - 1);
                    if (f6.U > f2) {
                        f2 = f6.U;
                    }
                    if (f6.Y > f3) {
                        f3 = f6.Y;
                    }
                    f4 += f6.U;
                    f5 += f6.Y;
                }
                if (f4 != 0.0f) {
                    String string4 = "";
                    if (f4 != f2) {
                        string4 = " (total:" + f4 + ")";
                    }
                    string2 = string2 + UnitTypeEnum.a("Direct Damage", f2, string4);
                }
                if (f5 != 0.0f) {
                    String string5 = "";
                    if (f5 != f3) {
                        string5 = " (total:" + f5 + ")";
                    }
                    string2 = string2 + UnitTypeEnum.a("Area Damage", f3, string5);
                }
            }
            string2 = string2 + "</pre>";
            string2 = string2 + "</div>\n";
        }
        com.corrodinggames.rts.gameFramework.GameEngine.log(string2);
    }

    public static void t() {
        for (UnitTypeEnum ar2 : UnitTypeEnum.values()) {
            ar2.name();
            ar2.e();
            ar2.f();
        }
    }

    public static boolean a(UnitType as2, float f2, float f3, float f4, float f5, com.corrodinggames.rts.game.PlayerTeam n2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine
                .getInstance();
        BaseUnit am2 = BaseUnit.a(as2);
        if (am2 == null) {
            com.corrodinggames.rts.gameFramework.GameEngine.log("isValidHere: Failed to get unit from type:" + as2);
            return false;
        }
        am2.b(n2);
        am2.posZ = f5;
        am2.posX = f2;
        am2.posY = f3;
        if (!am2.bI()) {
            am2.cg = f4;
            if (am2 instanceof y) {
                y y2 = (y) am2;
                y2.j(f4);
            }
        }
        boolean bl2 = true;
        if (am2 instanceof y) {
            y y3 = (y) am2;
            bl2 = y3.c(n2);
        }
        am2.posZ = 0.0f;
        am2.cg = 0.0f;
        return bl2;
    }

    public static void a(UnitType as2, float f2, float f3, float f4, float f5, com.corrodinggames.rts.game.PlayerTeam n2,
            float f6,
            float f7, boolean bl2,
            boolean bl3, int n3, BaseUnit am2) throws IOException {
        boolean bl4 = true;
        UnitTypeEnum.a(as2, f2, f3, f4, f5, n2, f6, f7, bl2, bl3, n3, bl4, am2);
    }

    public static void a(UnitType as2, float f2, float f3, float f4, float f5, com.corrodinggames.rts.game.PlayerTeam n2,
            float f6,
            float f7, boolean bl2,
            boolean bl3, int n3, boolean bl4, BaseUnit am2) throws IOException {
        y y2;
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine
                .getInstance();
        BaseUnit am3 = BaseUnit.c(as2);
        boolean bl5 = am3.bI();
        am3.b(n2);
        if (am3 instanceof y) {
            y2 = (y) am3;
            y2.a(n3);
        }
        am3.posZ = f5;
        if (am3.h() == UnitMovementType.HOVER || am3.h() == UnitMovementType.OVER_CLIFF
                || am3.h() == UnitMovementType.OVER_CLIFF_WATER) {
            am3.posZ += 4.0f;
        }
        if (am3.h() == UnitMovementType.AIR) {
            am3.posZ += 10.0f;
        }
        if (!bl5) {
            am3.cg = f4;
            if (am3 instanceof y) {
                y2 = (y) am3;
                y2.j(f4);
            }
        } else {
            am3.cg = -90.0f;
        }
        boolean bl6 = true;
        boolean bl7 = am3.cp;
        am3.cp = true;
        am3.cs = false;
        am3.ct = false;
        if (!bl4) {
            am3.ct = true;
        }
        am3.co = false;
        am3.cq = false;
        am3.cr = false;
        if (bl2 || bl3) {
            am3.cq = bl3;
            am3.cr = bl2;
            bl6 = false;
        } else {
            am3.co = true;
        }
        if (!bl6) {
            am3.posX = f2;
            am3.posY = f3;
        } else {
            am3.posX = l2.cw + f2;
            am3.posY = l2.cx + f3;
        }
        float f8 = am3.cj * 2.0f * 0.8f;
        if (am3 instanceof y) {
            float f9;
            y y3 = (y) am3;
            if (y3.M != null && (f9 = (float) y3.et * y3.cD()) > f8) {
                f8 = f9;
            }
        }
        float f10 = 1.0f;
        if (f8 < f6) {
            f10 = f6 / f8;
        }
        if (f8 > f7) {
            f10 = f7 / f8;
        }
        l2.bO.k();
        if (bl6) {
            // empty if block
        }
        if (f10 != 1.0f) {
            l2.bO.a(f10, f10, f2, f3);
        }
        ag = f10 < 1.0f;
        if (am2 != null) {
            com.corrodinggames.rts.game.units.custom.e.f f11 = am3.dH;
            am3.dH = am2.dH;
            int n4 = am3.cE;
            am3.cE = am2.cE;
            float f12 = am3.cu;
            am3.cu = am2.cu;
            float f13 = am3.cB;
            am3.cB = am2.cB;
            VariableScope variableScope = am3.bw;
            am3.bw = am2.bw;
            am3.d(0.0f);
            am3.c(0.0f);
            am3.a(0.0f, false);
            am3.dH = f11;
            am3.cE = n4;
            am3.cu = f12;
            am3.cB = f13;
            am3.bw = variableScope;
        } else {
            am3.d(0.0f);
            am3.c(0.0f);
            am3.a(0.0f, false);
        }
        l2.bO.l();
        am3.posZ = 0.0f;
        am3.cg = !bl5 ? 0.0f : -90.0f;
        if (am3 instanceof y) {
            y y4 = (y) am3;
            y4.j(0.0f);
            y4.a(1);
        }
        am3.cq = false;
        am3.cr = false;
        am3.cp = bl7;
        am3.co = false;
    }

    // ... 其他静态方法

    public int b(int techLevel) {
        int cost = c();
        if (techLevel >= 2) {
            cost += c(2);
        }
        if (techLevel >= 3) {
            cost += c(2); // 注意：这里可能是bug，应该是c(3)
        }
        return cost;
    }

    public int c(int techLevel) {
        return 0;
    }

    public b u() {
        int cost = c();
        if (cost == 0) {
            return b.a;
        }
        if (ah == null || ah.a() != cost) {
            ah = b.a(cost);
        }
        return ah;
    }

    public b d(int techLevel) {
        return b.a(b(techLevel));
    }

    public String v() {
        return name();
    }

    public boolean w() {
        return false;
    }

    public com.corrodinggames.rts.game.units.custom.h x() {
        return null;
    }

    public boolean y() {
        return true;
    }

    public Texture_M z() {
        return null;
    }

    public int a(BaseUnit unit) {
        return 0;
    }

    public boolean A() {
        return false;
    }

    public b B() {
        return null;
    }

    static {
        // 初始化静态字段
        ae.addAll(java.util.Arrays.asList(values()));
    }
}