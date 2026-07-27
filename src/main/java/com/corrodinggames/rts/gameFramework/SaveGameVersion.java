/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.gameFramework;

//bp
enum SaveGameVersion 
{
    a("original", 0), 
    b("v220911_added_history", 1);
    
    private static final /* synthetic */ SaveGameVersion[] c;
    
    
    private SaveGameVersion(final String name, final int ordinal) {
    }
    
    static {
        c = new SaveGameVersion[] { SaveGameVersion.a, SaveGameVersion.b };
    }
}
