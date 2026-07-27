/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.logicBooleans;

import java.util.List;

import com.corrodinggames.rts.game.units.y;

public class VariableScope$MemoryWriter
extends VariableScope$CachedWriter {
    public void writeToMemory(VariableScope variableScope, y y2) {
        for (VariableScope$CachedWriter$WriterElement variableScope$CachedWriter$WriterElement : ((List<VariableScope$CachedWriter$WriterElement>)this.writers) ){
            VariableScope$MemoryWriterFactory$MemoryWriterElement variableScope$MemoryWriterFactory$MemoryWriterElement = (VariableScope$MemoryWriterFactory$MemoryWriterElement)variableScope$CachedWriter$WriterElement;
            variableScope$MemoryWriterFactory$MemoryWriterElement.writeToMemory(variableScope, y2);
        }
    }
}

