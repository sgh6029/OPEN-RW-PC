package com.corrodinggames.rts.gameFramework.b.a;

public enum ShaderAttributeType {
    A_Position(1, "a_Position"),//a
    A_TexCoordinate(2, "a_TexCoordinate");//b
    
    private final int c;
    private final String d;
    
    private ShaderAttributeType(int value, String name) {
        this.c = value;
        this.d = name;
    }
    
    public int a() {
        return this.c;
    }
    
    public String b() {
        return this.d;
    }
}
