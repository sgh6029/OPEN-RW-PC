package com.corrodinggames.rts.gameFramework.b.a.a;

import com.corrodinggames.rts.gameFramework.b.a.ShaderAttributeType;
import com.corrodinggames.rts.gameFramework.b.a.a.ShaderProgramBase;

public class FontShader extends ShaderProgramBase {
    private static final ShaderAttributeType[] a;
    
    static {
        a = new ShaderAttributeType[]{
            ShaderAttributeType.A_Position, 
            ShaderAttributeType.A_TexCoordinate
        };
    }
    
    public FontShader() {
        super();
    }
    @Override
    public void a() {
        String vertexShader = 
            "uniform mat4 u_MVPMatrix;      \n" +
            "attribute vec4 a_Position;     \n" +
            "attribute vec2 a_TexCoordinate;\n" +
            "varying   vec2 v_TexCoordinate;\n" +
            "void main()                    \n" +
            "{                              \n" +
            "   v_TexCoordinate = a_TexCoordinate; \n" +
            "   gl_Position = u_MVPMatrix   \n" +
            "               * a_Position;   \n" +
            "}                              \n";
            
        String fragmentShader = 
            "uniform sampler2D u_Texture;       \n" +
            "precision mediump float;       \n" +
            "uniform lowp vec4 u_Color;          \n" +
            "varying vec2 v_TexCoordinate;  \n" +
            "void main()                    \n" +
            "{                              \n" +
            "   gl_FragColor = texture2D(u_Texture, v_TexCoordinate).w * u_Color;\n" +
            "}                             \n";
            
        super.a(vertexShader, fragmentShader, a);
    }
}