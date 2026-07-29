# OPEN-RW-PC

Rusted Warfare (铁锈战争) PC 版 - OpenAI 增强型 AI 难度，逆向工程重建版。

## 功能特性

- **OpenAI 增强型 AI 难度**（difficulty=4）
- **10 倍经济倍率**，智能决策
- **核弹策略**：自动建造核弹发射井 → 发射核弹
- **攻城战术（SIEGE）**：优先攻击敌方基地和工厂
- **线程安全命令队列**架构，防止崩溃
- **单位 ID 校验**，防止空气指挥
- **链式请求调度**（120 秒超时 + 5 秒冷却）
- **BUILD 命令**实际建造建筑和生产单位

## 运行要求

- Windows 10/11
- Java 17+（[下载地址](https://adoptium.net/)）

## 启动方式

### 方式一：使用启动脚本
```bash
# Windows
RustedWarfare-OpenAI.bat

# 或命令行
java -Xmx2g -Djava.library.path=. -jar "Rusted Warfare Core-1.0-SNAPSHOT-all.jar"
```

### 方式二：下载分发包
从 [Releases](https://github.com/sgh6029/OPEN-RW-PC/releases) 下载 `OPEN-RW-PC.zip`，解压后运行 `RustedWarfare-OpenAI.exe`。

## 配置 OpenAI API

1. 启动游戏
2. 进入 **设置 → OpenAI 配置**
3. 填写：
   - **API Key**：你的 OpenAI 兼容 API 密钥
   - **API Base URL**：`https://dashscope.aliyuncs.com/compatible-mode/v1`（阿里云）
   - **Model**：`qwen-plus` 或其他模型
4. 创建游戏时选择 AI 难度为 **OpenAI 增强**

## 构建

```bash
# 构建 fat JAR
./gradlew shadowJar

# 运行游戏
./gradlew runGame
```

输出位置：`build/libs/Rusted Warfare Core-1.0-SNAPSHOT-all.jar`

## 项目结构

```
├── src/main/java/
│   ├── com/corrodinggames/rts/
│   │   ├── ai/openai/          # OpenAI 增强 AI
│   │   ├── gameFramework/      # 游戏框架
│   │   └── ...
│   └── ...
├── libs/                       # 本地依赖库
├── assets/                     # 游戏资源文件
└── build.gradle               # 构建配置
```

## 技术栈

- Java 17
- Slick2D + LWJGL（图形/输入）
- Gradle + Shadow JAR（构建）
- OpenAI 兼容 API（AI 决策）

## License

本项目为逆向工程学习用途，仅供研究参考。
