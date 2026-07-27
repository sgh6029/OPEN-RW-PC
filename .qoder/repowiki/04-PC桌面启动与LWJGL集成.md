# PC 桌面启动与 LWJGL 集成

## 概述

`com.corrodinggames.rts.java` 包是 PC 端专用代码，负责桌面端启动、Slick2D 游戏循环、LWJGL OpenGL 渲染、OpenAL 音频、LibRocket UI 集成。Android 构建时通过 `sourceSets exclude` 排除此包。

## 启动流程

```
Main.main(args)
  ├── instance = new Main()
  ├── instance.realMain(args)
  │     ├── 解析命令行参数 (-debug, -log, -lang, -fullscreen, -nosound 等)
  │     ├── GameEngine.aq() — 初始化内存预分配 + UncaughtExceptionHandler
  │     ├── 系统信息日志 (OS/LWJGL/内存/64bit)
  │     ├── Mac OS 自动启用 sandbox
  │     ├── 设置 IPv4 优先
  │     ├── Steam 早期初始化 (如果 -steam)
  │     ├── g() — Looper 初始化 (在守护线程中)
  │     ├── Input.disableControllers() — 禁用 Slick 手柄
  │     ├── VBO 配置 (disable/force)
  │     ├── SlickGraphicsEngine.c() — 初始化渲染器引用
  │     ├── new SlickGameHandler(title) — 创建游戏处理器
  │     ├── 计算显示尺寸 (800x600 / 1000x733 / 1000x800 / 1600x900)
  │     ├── new SlickGameContainer(handler, w, h, fullscreen) — 创建 Slick 容器
  │     └── 启动 GameStartupRunnable 线程
  └── SimpleCommandLine.main(args) — 命令行交互
```

## 核心类

### Main (入口类, extends NetworkCallbacks)
- `buildNumber` = "#28"，`gameTitle` = "Rusted Warfare Core[Fork]"
- `h()` — 初始化核心：音频/LibRocket/GameEngine/网络
  - OpenALAudio (20通道, 9缓冲, 512采样)
  - OpenALSoundFactory / OpenALMusicFactory
  - HeadlessGameView + CommonGuiEngine + SlickLibRocketManager
  - 加载字体：Delicious (4体), Roboto (2体), NotoSansCJKsc, DroidSansFallback
  - GameEngine.a() 创建引擎实例
- `a(deltaTime)` — 任务队列处理
- `a(boolean)` — 关闭游戏
- `f()` — stdin 读取 (控制台命令输入)

### SlickGameHandler (extends BasicGame)
- Slick2D 游戏循环核心
- `init()` — 设置窗口图标/鼠标光标/FPS目标 (120/300)
- `update(container, delta)` — 更新帧时间
- `render(container, graphics)` — 主渲染流程：
  1. 加载中 → 显示 Logo + "Loading..."
  2. 初始化完成 → 调用 `GameEngine.processGameFrame()`
  3. LibRocket UI 渲染叠加
  4. 鼠标光标绘制 (非捕获模式)
- 鼠标/键盘事件处理 → 转发给 `HeadlessGameView` 或 LibRocket
- `g()` — 分辨率切换 (全屏/窗口/无边框)
- `a(graphics, boolean)` — 截图功能 (普通/高分辨率)

### SlickGraphicsEngine (implements y 接口)
- **1677行**，PC 端 OpenGL 渲染核心
- 基于 Slick2D Graphics + LWJGL OpenGL 直接调用
- **着色器系统**：GL20 着色器编译/链接/Uniform 管理
  - `ShaderProgram` 编译: vertex(35633) + fragment(35632)
  - Uniform 类型: float/vec2/vec4/纹理
- **纹理管理**：
  - `SlickTexture` — 自定义纹理包装 (支持热重载)
  - `SlickTextureWrapper` — 纹理包装器
  - `f` — 纹理图集 (1024x1024 自动打包)
  - PNG 加载：优先 `PNGImageData`，失败回退 `ImageIOImageData`
  - OOM 降级：替换为错误占位图 (`error_outmem`)
- **字体系统**：
  - `UnicodeFont` (Slick2D) + 动态字形加载
  - Roboto-Regular / Roboto-Bold / DroidSansFallback
  - 支持 UI 缩放时字体大小调整
- **绘制基元**：
  - 矩形/圆形/线段/多边形
  - 纹理旋转绘制 (矩阵变换)
  - `GraphicsTransform` — push/pop 变换栈
- **混合模式**：GL blend func 切换 (正常/叠加/自定义)
- **裁剪**：glScissor 矩形裁剪

### SlickGameContainer
- 包装 Slick2D `AppGameContainer`
- 管理显示模式和窗口状态

### HeadlessGameView
- 游戏视图抽象 (不含 Android View 依赖)
- 管理视图尺寸和触摸/鼠标事件分发

## 音频系统 (PC端)

| 类 | 职责 |
|----|------|
| `OpenALAudio` | OpenAL 音频设备 (来自 Slick2D) |
| `OpenALSoundFactory` | 音效工厂 |
| `OpenALSound` | 单个音效 |
| `OpenALMusicFactory` | 音乐工厂 |
| `OpenALMusic` | 音乐播放 |
| `OpenALMusicTrack` | 音乐曲目 |
| `SoundPlayThread` / `SoundPlayRequest` | 异步音效播放 |

## 辅助类

| 类 | 职责 |
|----|------|
| `CommonGuiEngine` (java.b) | GUI 引擎，处理键盘输入/UI交互 |
| `SlickLibRocketManager` (java.d) | LibRocket UI 管理器 |
| `JavaHttpClientManager` | HTTP 网络客户端 (Java 实现) |
| `JavaSteamEngine` (java.c) | Steam API 集成 |
| `JavaMissionEngine` | PC 端任务引擎 |
| `JavaInGameActivity` | 游戏内活动 (PC 端模拟) |
| `DisplayMessageThread` | 消息显示线程 |
| `FontKey` | 字体缓存键 |
| `GraphicsTransform` | 图形变换状态 |
| `GameStartupRunnable` | 启动线程 Runnable |
| `SlickImageData` | 图像数据包装 |

## 命令行参数

| 参数 | 作用 |
|------|------|
| `-debug port:host` | 调试 Socket 服务器 |
| `-debugscript script` | 调试脚本 |
| `-log file` | 日志输出到文件 |
| `-lang code` | 语言覆盖 |
| `-fullscreen` | 全屏模式 |
| `-width N -height N` | 自定义分辨率 |
| `-nosound` | 禁用音效 |
| `-nomusic` | 禁用音乐 |
| `-nodisplay` | 无头模式 (服务器) |
| `-safemode` | 安全模式 |
| `-sandbox` | 沙盒模式 |
| `-steam` | 启用 Steam |
| `-disable_vbos` / `-force_vbos` | VBO 控制 |
| `-teamshaders` / `-noteamshaders` | 队伍着色器 |
| `-postprocessing` / `-nopostprocessing` | 后处理效果 |
| `-nomods` | 禁用 Mod |
| `-nobackground` | 无菜单背景 (性能) |
| `-canvasgl` | Canvas GL 模式 |
