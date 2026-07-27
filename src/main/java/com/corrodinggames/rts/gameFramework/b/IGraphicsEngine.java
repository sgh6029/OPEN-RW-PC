package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.b.ITextureFilter;
import com.corrodinggames.rts.gameFramework.b.Texture;
import com.corrodinggames.rts.gameFramework.b.IShaderProgram;
import com.corrodinggames.rts.gameFramework.b.MatrixCalculator;
import com.corrodinggames.rts.gameFramework.b.u;
import com.corrodinggames.rts.gameFramework.b.v;

import android.graphics.Bitmap;
import android.graphics.Paint;

public interface IGraphicsEngine {
    public u a(); // 获取纹理生成器
    public void b(); // 保存变换状态
    public void c(); // 恢复变换状态
    public void a(float var1, float var2, float var3, v var4, IShaderProgram var5); // 绘制圆形
    public void a(float var1, float var2, float var3, float var4, v var5, IShaderProgram var6); // 绘制矩形
    public void a(Texture var1, int var2, int var3, int var4, int var5, ITextureFilter var6, MatrixCalculator var7); // 绘制纹理
    public boolean a(Texture var1); // 回收纹理
    public void b(Texture var1); // 绑定纹理
    public void c(Texture var1); // 推入渲染目标
    public void d(); // 弹出渲染目标
    public void d(Texture var1); // 设置纹理参数
    public void a(Texture var1, int var2, int var3, int var4); // 分配纹理内存
    public void a(Texture var1, Bitmap var2, int var3); // 上传纹理数据
    public void a(Texture var1, int var2, int var3, Bitmap var4, int var5, int var6); // 更新纹理子区域
    public void a(int var1, int var2, int var3, int var4); // 设置裁剪区域
    public void a(String var1, float var2, float var3, Paint var4); // 绘制文本
    public void a(float[] var1, int var2, int var3, v var4, IShaderProgram var5); // 绘制顶点数组
    public void e(); // 结束批处理
    public void f(); // 刷新渲染状态
    public void a(Bitmap var1); // 截图
}