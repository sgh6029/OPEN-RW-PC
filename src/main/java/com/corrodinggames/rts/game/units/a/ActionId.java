/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;

import java.io.IOException;
import java.util.HashMap;

public class ActionId {
    private static final HashMap<String,ActionId> internMap = new HashMap<String,ActionId> ();
    public static final ActionId a = com.corrodinggames.rts.game.units.a.ActionId.isSameInstance("-1");
    String id;

    public static ActionId isSameInstance(String string2) {
        ActionId c2 = (ActionId)internMap.get(string2);
        if (c2 != null) {
            return c2;
        }
        ActionId c3 = new ActionId(string2);
        internMap.put(string2, c3);
        return c3;
    }

    public String getId() {
        return this.id;
    }

    private ActionId(String string2) {
        this.id = string2;
    }

    public static void serialize(GameOutputStream as2, ActionId c2) throws IOException {
        String string2 = null;
        if (c2 != null) {
            string2 = c2.id;
        }
        as2.b(string2);
    }

    public static ActionId deserialize(GameInputStream k2) throws IOException {
        String string2 = k2.j();
        if (string2 != null) {
            return com.corrodinggames.rts.game.units.a.ActionId.isSameInstance(string2);
        }
        return null;
    }

    public boolean equals(Object object) {
        return this == object;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "ActionId(" + this.id + ")";
    }

    public final boolean fromString(ActionId c2) {
        return this == c2;
    }
}

