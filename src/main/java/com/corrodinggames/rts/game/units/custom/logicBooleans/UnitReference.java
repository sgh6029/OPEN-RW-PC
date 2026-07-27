/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.v;
import com.corrodinggames.rts.game.units.t;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class UnitReference
extends LogicBoolean
implements Cloneable {
    public static final UnitReference$SelfUnitReference selfUnitReference = new UnitReference$SelfUnitReference();
    static HashMap referenceTypes = new HashMap();
    static final LogicBooleanLoader$LogicBooleanContext unitContextChangingContext;
    static final LogicBooleanLoader$LogicBooleanContext placeholderUnitContext;

    public final BaseUnit get(BaseUnit am2) {
        if (!(am2 instanceof y)) {
            return null;
        }
        return this.getSingleRaw((y)am2);
    }

    public final BaseUnit get(y y2) {
        return this.getSingleRaw(y2);
    }

    public final BaseUnit getRealUnitOnly(y y2) {
        BaseUnit am2 = this.getSingleRaw(y2);
        if (am2 instanceof t) {
            return null;
        }
        return am2;
    }

    public abstract BaseUnit getSingleRaw(y var1);

    @Override
    public void forMeta(l l2) {
    }

    static void addUnitReferenceType(UnitReference unitReference, String ... stringArray) {
        for (String string2 : stringArray) {
            string2 = string2.toLowerCase(Locale.ROOT);
            referenceTypes.put(string2, unitReference);
            String string3 = string2.replace("self.", "subject.");
            if (string3.equals(string2)) continue;
        }
    }

    public static UnitReference$UnitReferenceOrUnitType parseUnitTypeOrReferenceFromConf(l l2, IniFile ab2, String string2, String string3, UnitReference$UnitReferenceOrUnitType unitReference$UnitReferenceOrUnitType) throws bo {
        String string4 = ab2.b(string2, string3, (String)null);
        return UnitReference.parseUnitTypeOrReference(l2, string4, string2, string3, unitReference$UnitReferenceOrUnitType);
    }

    public static UnitReference$UnitReferenceOrUnitType parseUnitTypeOrReference(l l2, String string2, String string3, String string4, UnitReference$UnitReferenceOrUnitType unitReference$UnitReferenceOrUnitType) throws bo {
        if (string2 == null) {
            return unitReference$UnitReferenceOrUnitType;
        }
        if ("".equals(string2 = string2.trim()) || "NONE".equalsIgnoreCase(string2)) {
            return unitReference$UnitReferenceOrUnitType;
        }
        if (string2.toLowerCase(Locale.ROOT).startsWith("unitref ")) {
            UnitReference unitReference = UnitReference.parseUnitReference(l2, string2, string3, string4, null, true);
            return new UnitReference$UnitReferenceOrUnitType(unitReference);
        }
        v v2 = l2.a(string2, string4, string3);
        if (v2 != null) {
            v2.f = true;
        }
        return new UnitReference$UnitReferenceOrUnitType(v2);
    }

    public static UnitReference parseUnitReferenceFromConf(l l2, IniFile ab2, String string2, String string3, UnitReference unitReference) throws bo {
        String string4 = ab2.b(string2, string3, (String)null);
        return UnitReference.parseUnitReference(l2, string4, string2, string3, unitReference, false);
    }

    public static UnitReference parseUnitReference(l l2, String string2, String string3, String string4, UnitReference unitReference, boolean bl2) throws bo {
        if (string2 == null) {
            return unitReference;
        }
        if ("".equals(string2 = string2.trim()) || "NONE".equalsIgnoreCase(string2)) {
            return unitReference;
        }
        if ((string2 = string2.toLowerCase(Locale.ROOT)).startsWith("unitref ")) {
            string2 = string2.substring("unitref ".length());
            string2 = string2.trim();
        }
        if (string2.equals("self")) {
            return selfUnitReference;
        }
        int n2 = string2.indexOf("(");
        if (n2 == -1) {
            n2 = string2.length();
        } else if (string2.indexOf(")") != string2.length() - 1) {
            throw new bo("[" + string3 + "]" + string4 + " UnitReference: Unexpected format for: '" + string2 + "'");
        }
        try {
            UnitReference unitReference2 = UnitReference.parseSingleUnitReferenceBlock(l2, string2);
            if (unitReference2 == null) {
                throw new RuntimeException("Unknown function:'" + string2 + "'");
            }
            return unitReference2;
        }
        catch (RuntimeException runtimeException) {
            throw new RuntimeException("[" + string3 + "]" + string4 + " UnitReference error: " + runtimeException.getMessage() + ", [parsing: '" + string2 + "']", runtimeException);
        }
    }

    public static UnitReference parseSingleUnitReferenceElement(l l2, String string2) {
        String string3 = string2.split("\\(")[0];
        UnitReference unitReference = (UnitReference)referenceTypes.get(string3 = string3.trim().toLowerCase(Locale.ROOT));
        if (unitReference == null) {
            return null;
        }
        String string4 = string2.substring(string3.length());
        if ((string4 = string4.trim()).equals("")) {
            string4 = "()";
        }
        if (!string4.startsWith("(") || !string4.endsWith(")")) {
            throw new RuntimeException("Failed to parse unit reference arguments for:'" + string2 + "'");
        }
        string4 = string4.substring(1, string4.length() - 1);
        string4 = string4.trim();
        UnitReference unitReference2 = unitReference.with(l2, string4, string3);
        if (unitReference2 instanceof UnitReference$NullUnitReference) {
            // empty if block
        }
        return unitReference2;
    }

    public static UnitReference parseSingleUnitReferenceBlock(l l2, String string2) {
        int n2 = al.b(string2);
        if (n2 != 0) {
            if (n2 > 0) {
                throw new RuntimeException("Brackets unbalanced for: '" + string2 + "'. A '(' was not closed.");
            }
            if (n2 < 0) {
                throw new RuntimeException("Brackets unbalanced for: '" + string2 + "'. Too many ')'.");
            }
        }
        string2 = string2.trim();
        string2 = LogicBooleanLoader.breakOuterLayerBrackets(string2);
        String[] stringArray = al.b(string2, ".", false);
        ArrayList<UnitReference> arrayList = new ArrayList<UnitReference>();
        boolean bl2 = false;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string3 = stringArray[i2];
            if (string3.equalsIgnoreCase("self")) {
                bl2 = true;
                continue;
            }
            UnitReference unitReference = UnitReference.parseSingleUnitReferenceElement(l2, string3);
            if (unitReference == null) {
                throw new RuntimeException("Unknown unit reference:'" + string3 + "'");
            }
            arrayList.add(unitReference);
        }
        if (arrayList.size() == 0) {
            if (bl2) {
                return selfUnitReference;
            }
            throw new RuntimeException("Unexpected unit reference:'" + string2 + "'");
        }
        if (arrayList.size() == 1) {
            return (UnitReference)arrayList.get(0);
        }
        UnitReference[] unitReferenceArray = arrayList.toArray(new UnitReference[0]);
        return new UnitReference$ChainedUnitReference(unitReferenceArray);
    }

    @Override
    public UnitReference with(String string2) {
        return this.with(null, string2, null);
    }

    @Override
    public UnitReference with(l l2, String string2, String string3) {
        UnitReference unitReference;
        try {
            unitReference = (UnitReference)this.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
        unitReference.forMeta(l2);
        unitReference.setArgumentsRaw(string2, l2, string3);
        return unitReference;
    }

    @Override
    public boolean read(y y2) {
        return false;
    }

    @Override
    public BaseUnit readUnit(y y2) {
        return this.getSingleRaw(y2);
    }

    @Override
    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.unit;
    }

    public String getClassDebugName() {
        return "<unit reference>";
    }

    @Override
    public String getMatchFailReasonForPlayer(y y2) {
        return this.getClassDebugName() + "(" + BaseUnit.A(this.getSingleRaw(y2)) + ")";
    }

    @Override
    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return unitContextChangingContext;
    }

    @Override
    public LogicBoolean setChild(LogicBoolean logicBoolean) {
        UnitReference$UnitContextChangingBooleanByLogic unitReference$UnitContextChangingBooleanByLogic = UnitReference$UnitContextChangingBooleanByLogic.create(this, logicBoolean);
        return unitReference$UnitContextChangingBooleanByLogic;
    }

    static {
        UnitReference.addUnitReferenceType(new UnitReference$AttachmentUnitReference(), "attachment");
        UnitReference.addUnitReferenceType(new UnitReference$ParentUnitReference(), "parent");
        UnitReference.addUnitReferenceType(new UnitReference$TransportingUnitReference(), "transporting");
        UnitReference.addUnitReferenceType(new UnitReference$ActiveWaypointTargetReference(), "activeWaypointTarget");
        UnitReference.addUnitReferenceType(new UnitReference$AttackingReference(), "attacking");
        UnitReference.addUnitReferenceType(new UnitReference$Memory1UnitReference(), "customTarget1");
        UnitReference.addUnitReferenceType(new UnitReference$Memory2UnitReference(), "customTarget2");
        UnitReference.addUnitReferenceType(new UnitReference$LastDamagedByUnitReference(), "lastDamagedBy");
        UnitReference.addUnitReferenceType(new UnitReference$NearestUnitReference(), "nearestUnit");
        UnitReference.addUnitReferenceType(new UnitReference$FirstUnitReference(), "globalSearchForFirstUnit");
        UnitReference.addUnitReferenceType(new UnitReference$NullUnitReference(), "nullUnit");
        UnitReference.addUnitReferenceType(new UnitReference$NullUnitReference(), "null");
        UnitReference.addUnitReferenceType(new UnitReference$GetOffsetAbsolute(), "getOffsetAbsolute");
        UnitReference.addUnitReferenceType(new UnitReference$GetOffsetRelative(), "getOffsetRelative");
        UnitReference.addUnitReferenceType(new UnitReference$GetAsMarker(), "getAsMarker");
        UnitReference.addUnitReferenceType(new UnitReference$ThisActionTargetReference(), "thisActionTarget");
        UnitReference.addUnitReferenceType(new UnitReference$EventSourceReference(), "eventSource");
        unitContextChangingContext = new UnitReference$UnitContextChangingContext();
        placeholderUnitContext = new UnitReference$UnitContextChangingContext();
    }
}

