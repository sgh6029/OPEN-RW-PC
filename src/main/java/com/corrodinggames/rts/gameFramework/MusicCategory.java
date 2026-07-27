package com.corrodinggames.rts.gameFramework;

import java.util.ArrayList;

public enum MusicCategory {
    // 音乐分类枚举值
    a("starting") {
        @Override
        String d() {
            return "music/starting";
        }
    }, // 开始界面音乐
    b("buildup") {
        @Override
        String d() {
            return "music/buildup";
        }
    }, // 建设阶段音乐
    c("attacked") {
        @Override
        String d() {
            return "music/attacked";
        }
    }; // 战斗阶段音乐

    // 存储该分类下的音乐文件列表
    String[] d;

    // 枚举值数组
    private static final MusicCategory[] e;

    // 枚举构造函数
    private MusicCategory(String name) {
        // 枚举的构造函数由JVM处理
    }

    // 加载音乐文件
    void a() {
        // 获取音乐文件夹路径并加载文件列表
        this.d = com.corrodinggames.rts.gameFramework.storage.a.a(d(), false);

        if (this.d == null) {
            this.d = new String[0];
            System.out.println("Failed to open music folder: " + d());
            return;
        }

        com.corrodinggames.rts.gameFramework.GameEngine gameEngine = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        ArrayList<String> validTracks = new ArrayList<>();

        // 遍历所有音乐文件，验证并加载
        for (String track : this.d) {
            String processedTrack = com.corrodinggames.rts.gameFramework.storage.a.o(track);

            // 检查音乐文件是否可加载
            if (com.corrodinggames.rts.gameFramework.MusicManager.a(a(processedTrack), true) != null) {
                System.out.println("Loaded track:" + processedTrack);
                validTracks.add(processedTrack);
            } else {
                System.out.println("Skipping track:" + processedTrack);
            }

            // 更新游戏引擎状态
            gameEngine.a("music", false);
        }

        // 更新有效的音乐文件列表
        this.d = validTracks.toArray(new String[0]);
    }

    // 获取该分类下的音乐文件列表
    String[] b() {
        return this.d;
    }

    // 静态方法：加载所有音乐分类
    static void c() {
        a.a();
        b.a();
        c.a();
    }

    // 抽象方法：获取音乐文件夹路径（由具体枚举实现）
    abstract String d();

    // 构建完整的音乐文件路径
    String a(String trackName) {
        return d() + "/" + trackName;
    }

    // 静态初始化块
    static {
        e = new MusicCategory[] { a, b, c };
    }
}