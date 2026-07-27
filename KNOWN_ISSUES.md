# KNOWN ISSUES — 只记不修

> 铁律：阶段①"能玩"之前，这些问题只记录，不修。

## 构建期

### I001: SimpleCommandLine.java 使用 Java 14+ switch 表达式
- **文件**: `src/main/java/com/corrodinggames/rts/java/debuger/SimpleCommandLine.java:60`
- **现象**: 使用了 `switch` 箭头语法 (`case "hi" ->`)，Java 8 编译目标不支持
- **处理**: 将 sourceCompatibility/targetCompatibility 从 1.8 提至 17
- **风险**: 运行时需 JDK 17+（JDK 21 满足）

### I002: 27 个 deprecated 警告 (finalize/strictfp)
- **文件**: 多个 Android stub 类 + GameEngine + Texture 等
- **现象**: `finalize()` 在 JDK 9+ 被标记为 deprecated-for-removal；`strictfp` 在 JDK 17 被移除
- **处理**: 仅警告，编译通过。不改源码。

## 运行时（待验证）

### I003: 缺少游戏资源 (maps/mods/fonts 等)
- **现象**: fat JAR 不含游戏数据文件，运行时需要原版资源
- **处理**: T1.3 解决

### I004: LWJGL native DLL 路径问题
- **现象**: DLL 打包在 fat JAR 内部，LWJGL 2.x 需要 DLL 在 `java.library.path` 可达位置
- **处理**: T1.4 验证时处理
