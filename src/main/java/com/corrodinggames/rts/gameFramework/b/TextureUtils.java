package com.corrodinggames.rts.gameFramework.b;

import android.graphics.RectF;

public class TextureUtils {
    /**
     * 将纹理像素坐标转换为OpenGL纹理坐标
     * 
     * @param texture 纹理对象
     * @param rect 用于存储转换后坐标的RectF对象
     */
    public static void a(Texture texture, RectF rect) {
        int textureWidth = texture.b();  // 获取纹理宽度
        int textureHeight = texture.c(); // 获取纹理高度
        
        boolean flipped = texture.f();   // 检查纹理是否翻转
        
        int left = 0;
        int top = 0;
        int right = textureWidth;
        int bottom = textureHeight;
        
        if (flipped) {
            // 如果纹理是翻转的，调整坐标范围
            right = textureWidth - 1;
            bottom = textureHeight - 1;
            left = 1;
            top = 1;
        }
        
        // 将像素坐标转换为OpenGL纹理坐标 (0.0 - 1.0范围)
        rect.a(
            (float) left,
            (float) top, 
            (float) right,
            (float) bottom
        );
    }
}