package com.corrodinggames.rts.game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;

// 这是一个用于保存位图到文件的Runnable实现
class k implements Runnable {
    public Bitmap a;  // 位图对象
    public int b;     // 图像编号
    
    final GameLogic c;  // 外部类实例
    
    // 构造函数
    public k(GameLogic outerClass) {
        this.c = outerClass;
    }
    
    @Override
    public synchronized void run() {
        try {
            // 构建文件路径: {目录}/image_{7位数字编号}.jpg
            String fileName = this.c.h + "image_" + 
                String.format("%07d", this.b) + ".jpg";
            
            File file = new File(fileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            
            // 将位图压缩为JPEG格式并保存，质量85%
            this.a.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
            outputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
            // 发生错误时停止录制并显示错误信息
            this.c.bo = false;  // 停止录制标志
            this.c.a("Error saving jpg, recording has stopped. " +
                    "Is there free space remaining on the SD card?", 1);
        }
    }
}