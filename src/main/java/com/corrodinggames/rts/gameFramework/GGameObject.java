/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import java.io.IOException;

import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.y;
import com.corrodinggames.rts.gameFramework.Serializable;
import com.corrodinggames.rts.gameFramework.j.NetworkEngine;
import com.corrodinggames.rts.gameFramework.j.GameOutputStream;
import com.corrodinggames.rts.gameFramework.j.GameInputStream;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.o;
import com.corrodinggames.rts.gameFramework.utility.s;
import com.corrodinggames.rts.gameFramework.GameObjectComparator;

public abstract class GGameObject
extends Serializable {
    public long objectId;
    public static GameObjectComparator ei = new GameObjectComparator();
    public boolean ej = false;
    public boolean ek = false;
    public boolean el;
    public int em = 2;
    public int en = 0;
    public float posX;
    public float posY;
    public float posZ = 0.0f;
    private static final o a = new o();
    public static final s fastGameObjectList = new s("fastGameObjectList");

    public void S(int n2) {
        this.em = n2;
    }

    @Override
    public void a(GameOutputStream as2) throws IOException {
        as2.a(this.ej);
        as2.a(this.ek);
        as2.a(this.em);
    }

    public void a(GameInputStream k2) throws IOException {
        this.ej = k2.e();
        this.ek = k2.e();
        this.em = k2.readInt();
    }

    public GGameObject() {
        this(false);
    }

    public GGameObject(boolean bl2) {
        if (!bl2) {
            GameEngine l2 = GameEngine.getInstance();
            if (this.objectId != 0L) {
                throw new RuntimeException("ID for GameObject is already set at:" + this.objectId);
            }
            this.objectId = l2.networkEngine.y();
            if (this.objectId == 0L) {
                throw new RuntimeException("Adding object with id:0 class:" + this.getClass().getSimpleName());
            }
            a.a(this);
            fastGameObjectList.a(this);
        } else {
            this.objectId = 0L;
        }
    }

    public abstract void a(float var1);

    public abstract void a(float var1, boolean var2) throws IOException;

    public abstract void d(float var1);

    public abstract void e(float var1) throws IOException;

    public void p(float f2) throws IOException {
    }

    public abstract boolean c(float var1) throws IOException;

    public abstract boolean f(float var1) throws IOException;

    public boolean a(GameEngine l2) {
        return true;
    }

    public void a() {
        if (this.objectId != 0L) {
            a.b(this);
            fastGameObjectList.remove(this);
        }
        this.ej = true;
    }

    public static GGameObject a(long l2, Class clazz, boolean bl2) {
        if (l2 == -1L) {
            return null;
        }
        GGameObject[] wArray = fastGameObjectList.a();
        int n2 = fastGameObjectList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            GGameObject w2 = wArray[i2];
            if (w2.objectId != l2) continue;
            if (clazz.isInstance(w2)) {
                return w2;
            }
            String string2 = w2.getClass().getName();
            String string3 = clazz.getName();
            string2 = string2.replace("com.corrodinggames.rts.", "");
            string3 = string3.replace("com.corrodinggames.rts.", "");
            NetworkEngine.g("object id:" + l2 + " was found, but with type " + string2 + " instead of " + string3);
        }
        if (!bl2) {
            NetworkEngine.g("getFromId:" + l2 + " was not found");
        }
        return null;
    }

    public static BaseUnit a(long l2, boolean bl2) {
        return (BaseUnit)GGameObject.a(l2, BaseUnit.class, bl2);
    }

    public static y b(long l2, boolean bl2) {
        return (y)GGameObject.a(l2, y.class, bl2);
    }

    public static o dK() {
        a.a();
        return a;
    }

    public static void dL() {
        a.a();
        BaseUnit.bG();
    }
}

