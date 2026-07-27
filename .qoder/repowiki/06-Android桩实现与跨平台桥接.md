# Android 桩实现与跨平台桥接

## 概述

铁锈战争的共享代码大量引用了 Android API（`android.graphics.*`、`android.content.*`、`android.os.*` 等）。为了让 PC 端能编译这些代码，项目在 `src/main/java/android/` 下提供了一套手写的最小化桩 (stub) 实现。

## 桩包结构

```
src/main/java/android/
├── app/
│   ├── Activity.java          # 空 Activity 桩
│   ├── Application.java       # 空 Application 桩
│   └── (内部类: ActivityLifecycleCallbacks, OnProvideAssistDataListener)
├── content/
│   ├── Context.java           # Context 抽象桩 (核心)
│   ├── ContextWrapper.java    # ContextWrapper 桩
│   ├── ServerContext.java     # PC端专用：提供文件系统路径
│   └── res/ (Resources 桩)
├── graphics/
│   ├── Bitmap.java            # 位图桩 (Config/CompressFormat 内部类)
│   ├── Canvas.java            # 画布桩
│   ├── Color.java             # 颜色工具类桩
│   ├── ColorFilter.java       # 颜色过滤器基类
│   ├── LightingColorFilter.java  # 光照颜色过滤
│   ├── PorterDuffColorFilter.java
│   ├── PorterDuffXfermode.java
│   ├── Matrix.java            # 矩阵变换桩
│   ├── Paint.java             # 画笔桩 (Align/Cap/FontMetrics/Join/Style)
│   ├── Point.java / PointF.java  # 点类桩
│   └── Rect.java / RectF.java # 矩形桩
├── net/
│   └── http/                  # HTTP 相关桩 (7个文件)
├── os/
│   ├── Build.java / Build$VERSION.java  # 设备信息桩
│   ├── Bundle.java            # 数据捆绑桩
│   ├── Debug.java             # 调试桩
│   ├── Handler.java           # 消息处理器桩
│   ├── Looper.java            # 消息循环桩 (PC端手动初始化)
│   └── (其他 os 桩)
├── support/v4/                # Android Support v4 桩
├── util/
│   ├── DisplayMetrics.java    # 显示指标桩
│   ├── Log.java               # 日志桩 → System.out
│   ├── SparseArray.java       # 稀疏数组桩
│   └── (其他工具桩)
└── view/
    ├── KeyEvent.java          # 按键事件桩
    ├── MotionEvent.java       # 触摸事件桩
    └── View.java              # 视图桩
```

## 关键桩实现

### Context (核心)
- `getSharedPreferences()` — PC端返回 null 或 IniFile
- `getSystemService()` — 返回空桩
- `getPackageName()` — 返回固定包名
- `g().h()` — 获取包名 (混淆后)

### ServerContext (PC端专用)
- 继承 `ContextWrapper`
- 提供文件系统路径映射 (`/SD/rustedWarfare/` → 实际磁盘路径)
- 在 `Main.h()` 中创建: `new ServerContext()`

### Looper (消息循环)
- Android 中由系统管理，PC 端需要手动初始化
- `Main$2` 在守护线程中调用 `Looper.a()` (初始化) + `Looper.c()` (循环)
- `Looper.b()` — 获取主线程 Looper (用于 Handler)

### Log (日志)
- `Log.d(tag, msg)` → 转发到 `System.out.println`
- 在 PC 端通过 `GameEngine.log()` 统一

### Paint (画笔)
- 提供完整的属性设置接口 (颜色/样式/对齐/字体大小/Typeface)
- `k()` — 获取字体大小
- `i()` — 获取 Typeface
- `h()` — 获取 ColorFilter
- `e()` — 获取 Alpha
- `g()` — 获取笔宽

### Bitmap (位图)
- `BitmapCreator` 内部类
- `Config` / `CompressFormat` 枚举桩
- 大部分方法为空实现或抛出异常

## appFramework 桥接层

`com.corrodinggames.rts.appFramework` 包是应用框架桥接层，包含 45+ 个文件，全部为混淆名。职责：
- 平台无关的 UI 抽象
- 触摸/输入事件统一处理
- 应用生命周期管理
- Mod/地图加载 UI
- 多人联机 UI 流程

### 已知映射
- `appFramework.n.r()` — 加载地图并启动游戏 (在 Main$3 中调用)
- `appFramework.m` — 触摸事件处理器
- `appFramework.f` — 应用视图接口 (GameEngine 中的 ao/ap)
- `appFramework.c` — 上下文工具 (`a(context)` / `b(context)`)
- `appFramework.i` — 地图/Mod 工具 (`a.d(string)` / `e(string)` / `g(string)`)

## 跨平台桥接设计原则

1. **共享代码只用 Android API** — 不用 Slick/LWJGL
2. **PC 专用代码用 Slick/LWJGL** — 通过 sourceSets exclude 隔离
3. **桩类只提供编译接口** — 运行时行为由 PC 端实现类提供
4. **平台判断用静态标志位** — `GameEngine.isAndroidVersionStatic2` 等
