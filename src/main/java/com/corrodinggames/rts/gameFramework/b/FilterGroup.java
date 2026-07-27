/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.ITextureFilter;
import com.corrodinggames.rts.gameFramework.b.Texture;
import com.corrodinggames.rts.gameFramework.b.ShaderInterface;
import com.corrodinggames.rts.gameFramework.b.FilterCallback;
import com.corrodinggames.rts.gameFramework.b.IGraphicsEngine;
import com.corrodinggames.rts.gameFramework.b.x;
import com.corrodinggames.rts.gameFramework.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class FilterGroup
extends ShaderInterface {
    protected List a;
    private final List<x> b = new ArrayList<x>();//TODO: 原先没有初始化
    private Texture c;
    private Texture d;

    private void a(Texture b2) {
        this.a();
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            this.b.add(new x(b2.b(), b2.c(), false));
        }
    }

    private void a() {
        for (x x2 : this.b) {
            x2.j();
        }
        this.b.clear();
    }

    public Texture a(Texture b2, IGraphicsEngine k2, FilterCallback j2) {
        if (b2 instanceof x ? !((x)b2).k() : this.d == b2 && this.c != null) {
            return this.c;
        }
        if (this.b.size() != this.a.size() || this.d != b2) {
            this.a(b2);
        }
        this.d = b2;
        Texture b3 = b2;
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            x x2 = (x)this.b.get(i2);
            ITextureFilter af2 = (ITextureFilter)this.a.get(i2);
            k2.c(x2);
            j2.a(b3, af2, i2 == 0);
            k2.d();
            b3 = x2;
            GameEngine.log("FilterGroup: renderTarget");
        }
        this.c = b3;
        return b3;
    }
}

