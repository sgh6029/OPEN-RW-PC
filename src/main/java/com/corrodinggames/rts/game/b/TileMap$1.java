/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.b;

import com.corrodinggames.rts.game.b.TileMap;
import java.io.ByteArrayInputStream;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

class TileMap$1
implements EntityResolver {
    final /* synthetic */ TileMap a;

    TileMap$1(TileMap b2) {
        this.a = b2;
    }

    @Override
    public InputSource resolveEntity(String string2, String string3) {
        return new InputSource(new ByteArrayInputStream(new byte[0]));
    }
}

