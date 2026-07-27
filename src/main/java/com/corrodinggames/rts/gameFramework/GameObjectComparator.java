/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.GGameObject;
import java.util.Comparator;

class GameObjectComparator
implements Comparator {
    GameObjectComparator() {
    }

    public int a(GGameObject w2, GGameObject w3) {
        if (w2.em > w3.em) {
            return 1;
        }
        if (w2.em < w3.em) {
            return -1;
        }
        if (w2.en > w3.en) {
            return 1;
        }
        if (w2.en < w3.en) {
            return -1;
        }
        if (w2.posY > w3.posY) {
            return 1;
        }
        if (w2.posY < w3.posY) {
            return -1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((GGameObject)object, (GGameObject)object2);
    }
}

