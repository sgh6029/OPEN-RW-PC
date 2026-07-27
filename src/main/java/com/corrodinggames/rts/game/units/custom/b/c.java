/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.PlayerTeam;
import com.corrodinggames.rts.game.q;
import com.corrodinggames.rts.game.units.BaseUnit;
import com.corrodinggames.rts.game.units.custom.b.a;
import com.corrodinggames.rts.game.units.custom.b.d;
import com.corrodinggames.rts.game.units.custom.b.e;
import com.corrodinggames.rts.game.units.custom.b.f;
import com.corrodinggames.rts.game.units.custom.b.g;
import com.corrodinggames.rts.game.units.custom.b.i;
import com.corrodinggames.rts.game.units.custom.ba;
import com.corrodinggames.rts.game.units.custom.bn;
import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.j;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.gameFramework.m.aa;
import com.corrodinggames.rts.gameFramework.m.ag;
import com.corrodinggames.rts.gameFramework.m.y;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.al;
import com.corrodinggames.rts.gameFramework.utility.m;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c
        extends a {
    static Paint a = new Paint();
    static ag b = new ag();
    m c = new m();
    m d = new m();
    m e = new m();
    m f = new m();
    m g = new m();
    boolean h;
    static final PointF i = new PointF();
    static final g j = new g("");
    static final Rect k = new Rect();
    static final RectF l = new RectF();

    private static d c(l l2, String string) {
        d d2;
        Iterator iterator = l2.q.iterator();
        do {
            if (!iterator.hasNext())
                return null;
            d2 = (d) iterator.next();
        } while (!string.equalsIgnoreCase(d2.a));
        return d2;
    }

    public static g a(l l2, String string) {
        if (string == null)
            return null;
        if (string.equals("")) {
            return null;
        }
        if (string.equalsIgnoreCase("NONE")) {
            return null;
        }
        g g2 = new g(string);
        l2.a(g2);
        return g2;
    }

    /*
     * Handled impossible loop by duplicating code
     * Handled impossible loop by adding 'first' condition
     */
public static void a(com.corrodinggames.rts.game.units.custom.l unitConfig, 
                          com.corrodinggames.rts.gameFramework.utility.IniFile configReader) throws bo {
    
    com.corrodinggames.rts.game.units.custom.b.c decalController = null;
    String decalPrefix = "decal_";
    
    // 获取所有以"decal_"开头的配置项
    com.corrodinggames.rts.gameFramework.utility.m decalKeys = configReader.e(decalPrefix);
    
    // 遍历所有贴花配置
    for (String fullKey : ((List<String>)decalKeys)) {
        // 版本兼容性检查
        unitConfig.a("1.15p9", 115009, fullKey, "decals");
        
        // 提取贴花名称（去掉前缀）
        String decalName = fullKey.substring(decalPrefix.length());
        
        // 创建新的贴花配置对象
        com.corrodinggames.rts.game.units.custom.b.d decalConfig = new com.corrodinggames.rts.game.units.custom.b.d();
        decalConfig.a = decalName;
        
        // 验证贴花名称格式
        if (decalName.contains(",")) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]Decal name: '" + decalName + "' cannot have ','");
        }
        if (decalName.contains(" ")) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]Decal name: '" + decalName + "' cannot have spaces");
        }
        if (decalName.contains("(")) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]Decal name: '" + decalName + "' cannot have '('");
        }
        
        // 读取渲染层级配置
        decalConfig.G = (com.corrodinggames.rts.game.units.custom.b.f) configReader.a(fullKey, "layer", 
            com.corrodinggames.rts.game.units.custom.b.f.onTop, 
            com.corrodinggames.rts.game.units.custom.b.f.class);
        
        // 读取渲染顺序
        decalConfig.H = (float) configReader.a(fullKey, "order", 0f);
        
        // 读取选择相关的可见性配置
        decalConfig.c = configReader.a(fullKey, "onlyWhenSelectedByOwnPlayer", false);
        decalConfig.d = configReader.a(fullKey, "onlyWhenSelectedByEnemyPlayer", false);
        decalConfig.e = configReader.a(fullKey, "onlyWhenSelectedByAllyNotOwnPlayer", false);
        decalConfig.f = configReader.a(fullKey, "onlyWhenSelectedByAnyPlayer", false);
        
        // 验证选择配置的合理性
        int selectionCount = 0;
        if (decalConfig.c) selectionCount++;
        if (decalConfig.d) selectionCount++;
        if (decalConfig.e) selectionCount++;
        if (decalConfig.f) selectionCount++;
        
        if (selectionCount >= 2) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]Doesn't make sense to set more than one onlyWhenSelectedBy* to true at a time.");
        }
        
        // 设置是否只在选择时显示
        decalConfig.b = (selectionCount > 0);
        
        // 读取父级选择包含配置
        decalConfig.g = configReader.a(fullKey, "includeParentsSelection", false);
        
        // 读取团队限制配置
        decalConfig.h = (q) configReader.a(fullKey, "onlyTeam", 
            com.corrodinggames.rts.game.q.any, com.corrodinggames.rts.game.q.class);
        
        // 读取玩家控制限制
        decalConfig.i = configReader.a(fullKey, "onlyPlayersWithUnitControl", false);
        
        // 读取缩放级别限制
        decalConfig.j = (float) configReader.a(fullKey, "onlyWithZoomLevelOrMore", 0f);
        
        // 检查是否为UI层贴花
        boolean isUILayer = (decalConfig.G == com.corrodinggames.rts.game.units.custom.b.f.beforeUI);
        
        // 读取活动状态限制
        decalConfig.k = configReader.a(fullKey, "onlyWhileActive", false);
        decalConfig.l = configReader.a(fullKey, "onlyWhileAlive", isUILayer);
        
        // 读取预览模式限制
        decalConfig.m = configReader.a(fullKey, "onlyInPreview", false);
        decalConfig.n = configReader.a(fullKey, "onlyOnNonPreview", false);
        
        // 验证预览配置
        if (decalConfig.m && decalConfig.n) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]decal with both onlyInPreview and onlyOnNonPreview will never be visible");
        }
        
        // 验证缩放级别配置
        if (decalConfig.j > 16544f) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]decal with onlyWithZoomLevelOrMore:" + decalConfig.j + " will never be visible");
        }
        if (decalConfig.j < 0f) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]onlyWithZoomLevelOrMore:" + decalConfig.j + " cannot be less than zero");
        }
        
        // 读取身体帧限制
        Integer bodyFrame = configReader.b(fullKey, "onlyOnBodyFrameOf", (Integer)null);
        if (bodyFrame != null) {
            decalConfig.o = bodyFrame;
            if (decalConfig.o < 0) {
                throw new com.corrodinggames.rts.game.units.custom.bo(
                    "[" + fullKey + "]onlyOnBodyFrameOf cannot be: " + decalConfig.o);
            }
        }
        
        // 读取图像缩放配置
        com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean imageScale = 
            configReader.c(unitConfig, fullKey, "imageScale", null);
        
        if (imageScale != null) {
            if (com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.isStaticNumber(imageScale)) {
                decalConfig.p = com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.getKnownStaticNumber(imageScale);
            } else {
                decalConfig.q = true;
                decalConfig.r = imageScale;
            }
        }
        
        // 读取独立缩放配置
        com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean scaleX = 
            configReader.c(unitConfig, fullKey, "imageScaleX", null);
        com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean scaleY = 
            configReader.c(unitConfig, fullKey, "imageScaleY", null);
        
        if (scaleX != null || scaleY != null) {
            decalConfig.q = true;
            decalConfig.s = scaleX;
            decalConfig.t = scaleY;
        }
        
        // 读取帧动画配置
        Integer totalFrames = configReader.b(fullKey, "total_frames", (Integer)null);
        if (totalFrames != null) {
            decalConfig.J = totalFrames;
            if (decalConfig.J < 1) {
                throw new com.corrodinggames.rts.game.units.custom.bo(
                    "[" + fullKey + "] TOTAL_FRAMES cannot be: " + decalConfig.J + " (must be 1 or more)");
            }
        }
        
        // 读取帧排序方式
        decalConfig.M = configReader.a(fullKey, "frame_verticalOrdering", false);
        
        // 读取帧尺寸配置
        decalConfig.K = configReader.b(fullKey, "frame_width", -1);
        decalConfig.L = configReader.b(fullKey, "frame_height", -1);
        
        // 验证帧配置
        if (decalConfig.K != -1 && decalConfig.J != -1) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]TOTAL_FRAMES and frame_width cannot be both set");
        }
        if (decalConfig.L != -1 && decalConfig.L <= 0) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]frame_height cannot be: " + decalConfig.L);
        }
        if (decalConfig.K != -1 && decalConfig.K <= 0) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]frame_width cannot be: " + decalConfig.K);
        }
        if (decalConfig.J != -1 && decalConfig.J <= 0) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]TOTAL_FRAMES cannot be: " + decalConfig.J);
        }
        
        // 设置是否使用帧动画
        if (decalConfig.L != -1 || decalConfig.K != -1 || decalConfig.J != -1) {
            decalConfig.I = true;
        }
        
        // 读取团队颜色配置
        boolean teamColors = configReader.a(fullKey, "teamColors", false);
        
        // 加载主图像
        com.corrodinggames.rts.gameFramework.m.Texture_M mainImage = 
            unitConfig.a(configReader, fullKey, "image");
        
        if (mainImage != null) {
            com.corrodinggames.rts.game.units.custom.b.e spriteConfig = new com.corrodinggames.rts.game.units.custom.b.e();
            spriteConfig.a = mainImage;
            
            // 处理团队颜色
            if (mainImage != null && teamColors) {
                spriteConfig.b = unitConfig.a(mainImage, unitConfig.ac);
            }
            
            spriteConfig.a(decalConfig);
            decalConfig.v = spriteConfig;
            decalConfig.u = true;
        }
        
        // 加载图像堆栈配置
        String imageStack = configReader.b(fullKey, "imageStack", (String)null);
        
        if (imageStack != null && !imageStack.equals("")) {
            decalConfig.u = true;
            java.util.ArrayList<com.corrodinggames.rts.game.units.custom.b.e> stackList = 
                new java.util.ArrayList<>();
            
            String[] stackItems = imageStack.split(",");
            
            for (String stackItem : stackItems) {
                String trimmedItem = stackItem.trim();
                String parameters = null;
                String imageName = trimmedItem;
                int repeatCount = 1;
                
                // 解析带参数的图像配置
                if (trimmedItem.contains("(") && trimmedItem.contains(")")) {
                    String[] parts = com.corrodinggames.rts.gameFramework.utility.al.b(trimmedItem, "(");
                    if (parts == null) {
                        throw new com.corrodinggames.rts.game.units.custom.bo(
                            "[" + fullKey + "]imageStack: Unexpected format for: " + imageStack);
                    }
                    imageName = parts[0];
                    parameters = parts[1].trim();
                }
                
                // 解析重复计数
                String[] nameParts = imageName.split("\\*");
                imageName = nameParts[0];
                if (nameParts.length >= 2) {
                    repeatCount = Integer.parseInt(nameParts[1]);
                }
                
                boolean useTeamColors = teamColors;
                
                // 解析参数
                if (parameters != null) {
                    if (parameters.endsWith(")")) {
                        parameters = parameters.substring(0, parameters.length() - 1);
                    }
                    
                    java.util.ArrayList<String> paramList = 
                        com.corrodinggames.rts.gameFramework.utility.al.a(parameters, ",", false, false);
                    
                    for (String param : paramList) {
                        String trimmedParam = param.trim();
                        if (!trimmedParam.equals("")) {
                            String[] keyValue = com.corrodinggames.rts.gameFramework.utility.al.b(trimmedParam, "=");
                            if (keyValue == null) {
                                throw new RuntimeException(
                                    "[" + fullKey + "]imageStack: Unexpected key format for: " + imageStack);
                            }
                            
                            String key = keyValue[0].trim();
                            String value = keyValue[1].trim();
                            
                            if (key.equalsIgnoreCase("teamColors") || key.equalsIgnoreCase("teamColor")) {
                                useTeamColors = com.corrodinggames.rts.gameFramework.utility.IniFile.g(fullKey, "imageStack", value);
                            } else {
                                throw new RuntimeException(
                                    "[" + fullKey + "]imageStack: Unknown parameter: " + key);
                            }
                        }
                    }
                }
                
                // 创建堆栈图像配置
                com.corrodinggames.rts.game.units.custom.b.e stackSprite = new com.corrodinggames.rts.game.units.custom.b.e();
                
                // 加载图像
                stackSprite.a = unitConfig.a(
                    unitConfig.F, imageName, false, fullKey, "imageStack");
                
                if (stackSprite.a == null) {
                    throw new com.corrodinggames.rts.game.units.custom.bo(
                        "[" + fullKey + "]failed to load image " + imageName);
                }
                
                // 处理团队颜色
                if (useTeamColors) {
                    stackSprite.b = unitConfig.a(stackSprite.a, unitConfig.ac);
                }
                
                stackSprite.a(decalConfig);
                
                // 添加重复图像
                for (int i = 0; i < repeatCount; i++) {
                    stackList.add(stackSprite);
                }
            }
            
            // 设置图像堆栈
            if (stackList.size() > 0) {
                decalConfig.w = stackList.toArray(new com.corrodinggames.rts.game.units.custom.b.e[0]);
            }
        }
        
        // 读取堆栈配置
        decalConfig.x = (float) configReader.a(fullKey, "stack_hOffset", 1f);
        decalConfig.y = configReader.b(fullKey, "stack_frameOffset", 0);
        
        decalConfig.A = configReader.c(unitConfig, fullKey, "stack_indexStart", null);
        decalConfig.B = configReader.c(unitConfig, fullKey, "stack_indexCount", null);
        
        // 读取堆栈绘制顺序
        Boolean drawReverse = configReader.a(fullKey, "stack_drawInReverseOrder", (Boolean)null);
        if (drawReverse == null || !drawReverse) {
            if (drawReverse == null && decalConfig.x < 0f) {
                decalConfig.z = true;
            }
        } else {
            decalConfig.z = true;
        }
        
        // 读取帧索引配置
        decalConfig.N = configReader.a(unitConfig, fullKey, "frame", null, 
            com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType.number);
        
        decalConfig.O = configReader.b(fullKey, "addBodyFrameMultipliedBy", 0);
        
        // 读取可见性条件
        decalConfig.F = configReader.a(unitConfig, fullKey, "isVisible", (LogicBoolean)null);
        
        // 读取位置偏移配置
        decalConfig.R = (float) configReader.a(fullKey, "xOffsetRelative", 0f);
        decalConfig.S = (float) configReader.a(fullKey, "yOffsetRelative", 0f);
        
        decalConfig.W = configReader.c(unitConfig, fullKey, "xOffsetAbsolute", null);
        decalConfig.X = configReader.c(unitConfig, fullKey, "yOffsetAbsolute", null);
        
        // 处理静态位置偏移
        if (decalConfig.W != null && 
            com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.isStaticNumber(decalConfig.W)) {
            decalConfig.T = com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.getKnownStaticNumber(decalConfig.W);
            decalConfig.W = null;
        }
        
        if (decalConfig.X != null && 
            com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.isStaticNumber(decalConfig.X)) {
            decalConfig.U = com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.getKnownStaticNumber(decalConfig.X);
            decalConfig.X = null;
        }
        
        // 读取高度和方向偏移
        decalConfig.V = (float) configReader.a(fullKey, "hOffset", 0f);
        decalConfig.aa = (float) configReader.a(fullKey, "dirOffset", 0f);
        decalConfig.ab = (float) configReader.a(fullKey, "pivotOffset", 0f);
        
        decalConfig.Y = configReader.a(fullKey, "alwaysStartDirAtZero", "alwayStartDirAtZero", (Boolean)false);
        decalConfig.Z = configReader.a(fullKey, "alwaysStartHeightAtZero", false);
        
        // 读取基础位置配置
        decalConfig.ac = configReader.b(unitConfig, fullKey, "basePosition", null);
        
        // 读取连线目标配置
        decalConfig.ad = configReader.b(unitConfig, fullKey, "drawLineTo", null);
        
        // 读取腿部位置配置
        String legPosition = configReader.b(fullKey, "basePositionFromLegEnd", (String)null);
        
        if (legPosition != null) {
            decalConfig.af = true;
            decalConfig.ae = unitConfig.b(legPosition);
            
            if (decalConfig.ae == -1) {
                throw new com.corrodinggames.rts.game.units.custom.bo(
                    "[" + fullKey + "]basePositionFromLeg* failed to find: " + legPosition);
            }
        }
        
        // 读取炮塔位置配置
        String turretPosition = configReader.b(fullKey, "basePositionFromTurret", (String)null);
        if (turretPosition != null) {
            com.corrodinggames.rts.game.units.custom.bn turretConfig = unitConfig.e(turretPosition);
            if (turretConfig == null) {
                throw new com.corrodinggames.rts.game.units.custom.bo(
                    "[" + fullKey + "]basePositionFromTurret failed to find: " + turretPosition);
            }
            decalConfig.ag = turretConfig.e;
        }
        
        // 验证位置配置冲突
        if (decalConfig.ae != -1 && decalConfig.ag != -1) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]basePositionFromTurret and basePositionFromLeg cannot be used at the same time");
        }
        
        if ((decalConfig.ae != -1 || decalConfig.ag != -1) && decalConfig.ac != null) {
            throw new com.corrodinggames.rts.game.units.custom.bo(
                "[" + fullKey + "]basePositionFromTurret/basePositionFromLeg cannot be used at the same time as basePosition");
        }
        
        // 读取阴影配置
        decalConfig.C = unitConfig.a(configReader, fullKey, "image_shadow");
        decalConfig.D = (float) configReader.a(fullKey, "shadowOffsetX", 1f);
        decalConfig.E = (float) configReader.a(fullKey, "shadowOffsetY", 1f);
        
        Integer tmp  = -1;
        // 读取颜色和线条配置
        decalConfig.P = (int) configReader.a(fullKey, "color",tmp);
        decalConfig.Q = (float) configReader.a(fullKey, "lineWidth", 1f);
        
        // 读取透明度配置
        float alphaValue = 1f;
        com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean alpha = 
            configReader.c(unitConfig, fullKey, "alpha", null);
        
        if (alpha != null) {
            if (com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.isStaticNumber(alpha)) {
                alphaValue = com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.getKnownStaticNumber(alpha);
                if (alphaValue < 0f || alphaValue > 1f) {
                    throw new com.corrodinggames.rts.game.units.custom.bo(
                        "[" + fullKey + "]alpha should be between 0-1");
                }
            } else {
                decalConfig.ai = alpha;
            }
        }
        
        // 创建绘制参数
        if (decalConfig.P != -1 || decalConfig.Q != 1f || alphaValue != 1f) {
            decalConfig.ah = new com.corrodinggames.rts.gameFramework.m.ag();
            decalConfig.ah.b(decalConfig.P);
            
            if (decalConfig.P != -1) {
                com.corrodinggames.rts.gameFramework.m.aa.a(decalConfig.ah);
            }
            
            // 计算透明度
            int alphaInt = (int)(decalConfig.ah.f() * alphaValue);
            alphaInt = Math.max(0, Math.min(255, alphaInt));
            decalConfig.ah.c(alphaInt);
            
            decalConfig.ah.a(decalConfig.Q);
        }
        
        // 确定是否需要创建渲染控制器
        boolean needsController = true;
        
        if (com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean.isStaticFalse(decalConfig.F)) {
            needsController = false;
        }
        
        if (decalConfig.ad == null && !decalConfig.u) {
            needsController = false;
        }
        
        if (alphaValue == 0f) {
            needsController = false;
        }
        
        // 添加到配置列表
        unitConfig.q.add(decalConfig);
        
        // 创建或更新渲染控制器
        if (needsController) {
            if (decalController == null) {
                decalController = new com.corrodinggames.rts.game.units.custom.b.c();
                unitConfig.b(decalController);
            }
            
            // 设置选择标记
            if (!decalConfig.b) {
                decalController.h = true;
            }
            
            // 处理阴影渲染
            if (decalConfig.C != null && decalConfig.G != com.corrodinggames.rts.game.units.custom.b.f.shadow) {
                decalController.c.add(decalConfig);
            }
            
            // 根据渲染层级分类
            com.corrodinggames.rts.gameFramework.utility.m targetList = null;
            
            if (decalConfig.G == com.corrodinggames.rts.game.units.custom.b.f.afterBody) {
                targetList = decalController.f; // 选择层
            } else if (decalConfig.G == com.corrodinggames.rts.game.units.custom.b.f.beforeBody) {
                targetList = decalController.e; // 建造层
            } else if (decalConfig.G == com.corrodinggames.rts.game.units.custom.b.f.beforeUI) {
                targetList = decalController.g; // UI层
            } else if (decalConfig.G == com.corrodinggames.rts.game.units.custom.b.f.shadow) {
                targetList = decalController.c; // 默认层
            } else if (decalConfig.G == com.corrodinggames.rts.game.units.custom.b.f.inactive) {
                targetList = null; // 无渲染层
            } else {
                targetList = decalController.d; // 其他层
            }
            
            // 添加到对应渲染列表并排序
            if (targetList != null) {
                targetList.add(decalConfig);
                java.util.Collections.sort(targetList);
            }
        }
    }
}
    @Override
    public void b(j j2, float f2) {
        com.corrodinggames.rts.gameFramework.GameEngine l2 = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
    }

    @Override
    public void a(j j2) {
    }

    @Override
    public void d(j j2, float f2) throws IOException {
        this.a(j2, f2, com.corrodinggames.rts.game.units.custom.b.f.shadow, this.c);
        this.a(j2, f2, com.corrodinggames.rts.game.units.custom.b.f.beforeBody, this.e);
    }

    @Override
    public void e(j j2, float f2) throws IOException {
        this.a(j2, f2, com.corrodinggames.rts.game.units.custom.b.f.afterBody, this.f);
    }

    @Override
    public void c(j j2, float f2) throws IOException {
        this.a(j2, f2, com.corrodinggames.rts.game.units.custom.b.f.onTop, this.d);
    }

    @Override
    public void f(j j2, float f2) throws IOException {
        this.a(j2, f2, com.corrodinggames.rts.game.units.custom.b.f.beforeUI, this.g);
    }

    public static Rect a(d d2, e e2, com.corrodinggames.rts.gameFramework.m.Texture_M e3, int n2) {
        int n3 = e2.c;
        int n4 = e2.d;
        int n5 = 0;
        int n6 = 0;
        if (n2 > 0) {
            int n7;
            if (!d2.M) {
                n7 = 0;
                int n8 = n2;
                int n9 = e2.f;
                if (n2 >= n9) {
                    n7 += n2 / n9;
                    n8 = n2 % n9;
                }
                n5 = n8 * n3;
                n6 = n7 * n4;
            } else {
                n7 = n2;
                int n10 = 0;
                int n11 = e2.e;
                if (n2 >= n11) {
                    n10 += n2 / n11;
                    n7 = n2 % n11;
                }
                n5 = n10 * n3;
                n6 = n7 * n4;
            }
        }
        Rect rect = k;
        rect.left = n5;
        rect.top = n6;
        rect.c = n5 + n3;
        rect.d = n6 + n4;
        return rect;
    }

    public static RectF a(d d2, e e2, com.corrodinggames.rts.gameFramework.m.Texture_M e3, float f2, float f3) {
        int n2 = e2.c;
        int n3 = e2.d;
        RectF rectF = l;
        rectF.left = f2 -= (float) (n2 / 2);
        rectF.c = f2 + (float) n2;
        rectF.b = f3 -= (float) (n3 / 2);
        rectF.d = f3 + (float) n3;
        return rectF;
    }

    public final void a(j j2, float f2, f f3, m m2) throws IOException {
        com.corrodinggames.rts.game.units.custom.b.c.a(j2, f2, f3, m2, null);
    }

    public final static void a(com.corrodinggames.rts.game.units.custom.j unit,
            float paramFloat,
            com.corrodinggames.rts.game.units.custom.b.f renderType,
            com.corrodinggames.rts.gameFramework.utility.m effectList,
            android.graphics.PointF point) throws IOException {

        int effectCount = effectList.a;
        if (effectCount == 0) {
            return;
        }

        // 检查单位和其父单位的可见性状态
        boolean unitVisible = unit.cG;
        boolean parentVisible = false;

        com.corrodinggames.rts.game.units.BaseUnit parentUnit = unit.dr();
        if (parentUnit != null) {
            if (parentUnit.cG) {
                parentVisible = true;
            }

            com.corrodinggames.rts.game.units.BaseUnit grandParentUnit = parentUnit.dr();
            if (grandParentUnit != null && grandParentUnit.cG) {
                parentVisible = true;
            }
        }

        com.corrodinggames.rts.gameFramework.GameEngine framework = com.corrodinggames.rts.gameFramework.GameEngine.getInstance();
        float cameraZoom = framework.cX;

        // 检查渲染类型
        boolean isDefaultRender = (renderType == com.corrodinggames.rts.game.units.custom.b.f.shadow);

        // 遍历所有特效
        Object[] effects = effectList.a();
        for (int i = 0; i < effectCount; i++) {
            com.corrodinggames.rts.game.units.custom.b.d effect = (com.corrodinggames.rts.game.units.custom.b.d) effects[i];

            // 检查特效可见性条件
            if (effect.b && !unitVisible && !parentVisible) {
                continue;
            }

            // 检查特效距离条件
            if (effect.j > cameraZoom) {
                continue;
            }

            // 检查单位状态条件
            if (effect.k && !unit.bT()) {
                continue;
            }

            if (effect.l && !unit.bV) {
                continue;
            }

            // 检查特效的团队关系条件
            if (effect.b) {
                boolean visibleToTeam = effect.g ? parentVisible : true;

                if (visibleToTeam) {
                    com.corrodinggames.rts.game.PlayerTeam localPlayerTeam = framework.bs;
                    com.corrodinggames.rts.game.PlayerTeam unitTeam = unit.bX;

                    if (localPlayerTeam != null) {
                        if (effect.c && unitTeam != localPlayerTeam) {
                            continue;
                        }
                        if (effect.d && !unitTeam.c(localPlayerTeam)) {
                            continue;
                        }
                        if (effect.e && unitTeam.d(localPlayerTeam) && unitTeam != localPlayerTeam) {
                            continue;
                        }
                    }
                }
            }

            // 检查逻辑布尔条件
            if (effect.F != null && !effect.F.read(unit)) {
                continue;
            }

            // 检查单位ID条件
            if (effect.o >= 0 && unit.a != effect.o) {
                continue;
            }

            // 检查选择状态
            if (effect.i && !framework.bS.m(unit)) {
                continue;
            }

            // 检查游戏模式条件
            if (effect.h != com.corrodinggames.rts.game.q.any && effect.h != null) {
                com.corrodinggames.rts.game.PlayerTeam localTeam = framework.bs;
                if (localTeam != null) {
                    if (!localTeam.a(effect.h, unit.bX)) {
                        continue;
                    }
                }
            }

            // 检查建造状态
            if (effect.m && !unit.cp) {
                continue;
            }
            if (effect.n && unit.cp) {
                continue;
            }

            // 计算特效位置和方向
            float posX, posY, rotation, baseRotation, finalRotation;

            // 根据不同的定位方式计算位置
            if (effect.ae != -1) {
                // 使用单位挂点位置
                com.corrodinggames.rts.game.units.custom.b.i[] unitPoints = unit.dT;
                com.corrodinggames.rts.game.units.custom.ba[] pointData = unit.x.ax;

                if (unitPoints == null || pointData == null)
                    continue;
                if (unitPoints.length <= effect.ae || pointData.length <= effect.ae)
                    continue;

                com.corrodinggames.rts.game.units.custom.b.i pointInfo = unitPoints[effect.ae];
                com.corrodinggames.rts.game.units.custom.ba pointConfig = pointData[effect.ae];

                posX = unit.posX + pointInfo.b;
                posY = unit.posY + pointInfo.c;
                rotation = unit.posZ + pointInfo.d;

                baseRotation = pointInfo.i + pointInfo.r + pointConfig.R;
                finalRotation = baseRotation + 17076f;

                // 处理旋转对齐
                if (effect.af) {
                    float unitRotation = unit.cg;
                    if (unit.x.dE) {
                        unitRotation = unit.cL[unit.x.dG].targetX;
                    }

                    float sin = com.corrodinggames.rts.gameFramework.GameUtils.k(unitRotation);
                    float cos = com.corrodinggames.rts.gameFramework.GameUtils.j(unitRotation);

                    float rotatedX = pointConfig.k * sin - pointConfig.j * cos;
                    float rotatedY = pointConfig.k * cos + pointConfig.j * sin;

                    baseRotation = com.corrodinggames.rts.gameFramework.GameUtils.d(pointInfo.b, pointInfo.c, rotatedX,
                            rotatedY);
                    finalRotation = baseRotation + 17076f;
                    com.corrodinggames.rts.gameFramework.GameUtils.a(pointInfo.b, pointInfo.c, rotatedX, rotatedY);
                }

            } else if (effect.ag != -1) {
                // 使用单位部件位置
                if (effect.ag >= unit.cL.length)
                    continue;

                int partIndex = effect.ag;
                com.corrodinggames.rts.gameFramework.utility.Vector3D partOffset = unit.F(partIndex);

                posX = partOffset.a;
                posY = partOffset.b;
                rotation = unit.posZ + partOffset.c;

                baseRotation = unit.cL[partIndex].targetX;
                finalRotation = baseRotation + 17076f;

            } else {
                // 使用单位本身位置或指定目标位置
                com.corrodinggames.rts.game.units.BaseUnit targetUnit = unit;
                if (effect.ac != null) {
                    targetUnit = effect.ac.readUnit(unit);
                    if (targetUnit == null)
                        continue;
                }

                posX = targetUnit.posX;
                posY = targetUnit.posY;
                rotation = targetUnit.posZ;

                baseRotation = targetUnit.cg;
                finalRotation = baseRotation + 17076f;

                // 使用传入的点位置
                if (point != null && effect.ac == null) {
                    posX = point.x;
                    posY = point.b;
                }

                // 处理动态旋转
                if (effect.ac == null && unit.x.dC) {
                    baseRotation = unit.cL[unit.x.dG].targetX;
                    finalRotation = baseRotation + 17076f;
                }
            }

            // 应用旋转覆盖
            if (effect.Y) {
                finalRotation = 0;
            }
            if (effect.Z) {
                rotation = 0;
            }

            // 应用位置和旋转偏移
            float adjustedRotation = baseRotation + effect.ab;
            float adjustedFinalRotation = finalRotation + effect.aa;

            float finalPosX = posX + effect.T;
            float finalPosY = posY + effect.U;

            // 应用逻辑布尔位置偏移
            if (effect.W != null) {
                finalPosX += effect.W.readNumber(unit);
            }
            if (effect.X != null) {
                finalPosY += effect.X.readNumber(unit);
            }

            // 应用旋转偏移到位置
            if (effect.R != 0 || effect.S != 0) {
                float sin = com.corrodinggames.rts.gameFramework.GameUtils.k(adjustedRotation);
                float cos = com.corrodinggames.rts.gameFramework.GameUtils.j(adjustedRotation);

                float offsetX = effect.R;
                float offsetY = effect.S;

                float rotatedX = cos * offsetY - sin * offsetX;
                float rotatedY = sin * offsetY + cos * offsetX;

                finalPosX += rotatedX;
                finalPosY += rotatedY;
            }

            // 应用高度偏移
            float heightOffset = rotation + effect.V;

            // 处理UI元素渲染
            if (isDefaultRender && effect.C != null) {
                com.corrodinggames.rts.gameFramework.m.y canvas = framework.bO;

                // 转换为屏幕坐标
                float screenX = finalPosX - framework.cw + effect.D;
                float screenY = finalPosY - framework.cx + effect.E;

                android.graphics.Paint paint = unit.R();

                canvas.k();
                canvas.a(adjustedFinalRotation, screenX, screenY);
                canvas.a(effect.C, screenX, screenY, paint);
                canvas.l();
                continue;
            }

            // 处理精灵渲染
            if (effect.u) {
                com.corrodinggames.rts.gameFramework.m.y canvas = framework.bO;

                // 转换为屏幕坐标
                float screenX = finalPosX - framework.cw;
                float screenY = finalPosY - framework.cx - heightOffset;

                // 获取绘制参数
                android.graphics.Paint paint = effect.ah;
                if (paint == null) {
                    paint = unit.aN();
                }

                // 应用透明度
                if (effect.ai != null) {
                    float alphaMultiplier = effect.ai.readNumber(unit);
                    if (alphaMultiplier != 16256f) {
                        android.graphics.Paint alphaPaint = new android.graphics.Paint();
                        alphaPaint.b(paint.e());
                        alphaPaint.a(paint.c());

                        int alpha = (int) (paint.f() * alphaMultiplier);
                        alpha = Math.max(0, Math.min(255, alpha));
                        alphaPaint.c(alpha);
                        paint = alphaPaint;
                    }
                }

                // 计算帧索引
                int baseFrame = 0;
                if (effect.N != null) {
                    baseFrame = (int) effect.N.readNumber(unit);
                }
                int frameIndex = baseFrame + unit.a * effect.O;

                // 渲染主精灵
                if (effect.v != null) {
                    com.corrodinggames.rts.game.units.custom.b.e mainSprite = effect.v;
                    com.corrodinggames.rts.gameFramework.m.Texture_M frame = mainSprite.a;

                    // 获取团队特定帧
                    if (mainSprite.b != null) {
                        frame = mainSprite.b[unit.bX.R()];
                    }

                    canvas.k();
                    canvas.a(adjustedFinalRotation, screenX, screenY);

                    // 应用缩放
                    float scaleX = effect.p;
                    float scaleY = effect.p;

                    if (effect.q) {
                        if (effect.r != null) {
                            scaleX = effect.r.readNumber(unit);
                            scaleY = scaleX;
                        }

                        if (effect.s != null) {
                            scaleX *= effect.s.readNumber(unit);
                        }
                        if (effect.t != null) {
                            scaleY *= effect.t.readNumber(unit);
                        }

                        if (scaleX != 16256f || scaleY != 16256f) {
                            canvas.a(scaleX, scaleY, screenX, screenY);
                        }
                    }

                    // 渲染帧
                    if (!effect.I) {
                        canvas.a(frame, screenX, screenY, paint);
                    } else {
                        android.graphics.Rect srcRect = com.corrodinggames.rts.game.units.custom.b.c.a(effect,
                                mainSprite, frame, frameIndex);
                        android.graphics.RectF dstRect = com.corrodinggames.rts.game.units.custom.b.c.a(effect,
                                mainSprite, frame, screenX, screenY);
                        canvas.a(frame, srcRect, dstRect, paint);
                    }

                    canvas.l();
                }

                // 渲染精灵序列
                if (effect.w != null) {
                    // 计算序列缩放
                    float seqScaleX = effect.p;
                    float seqScaleY = effect.p;

                    if (effect.q) {
                        if (effect.r != null) {
                            seqScaleX = effect.r.readNumber(unit);
                            seqScaleY = seqScaleX;
                        }

                        if (effect.s != null) {
                            seqScaleX *= effect.s.readNumber(unit);
                        }
                        if (effect.t != null) {
                            seqScaleY *= effect.t.readNumber(unit);
                        }
                    }

                    com.corrodinggames.rts.game.units.custom.b.e[] spriteSequence = effect.w;

                    // 计算序列范围
                    int startIndex = 0;
                    int endIndex = spriteSequence.length;

                    if (effect.A != null) {
                        startIndex = (int) effect.A.readNumber(unit);
                        startIndex = Math.max(0, startIndex);
                        if (startIndex >= spriteSequence.length) {
                            startIndex = spriteSequence.length;
                        }
                    }

                    if (effect.B != null) {
                        endIndex = startIndex + (int) effect.B.readNumber(unit);
                        endIndex = Math.max(0, endIndex);
                        if (endIndex >= spriteSequence.length) {
                            endIndex = spriteSequence.length;
                        }
                    }

                    // 渲染序列中的每个精灵
                    for (int seqIndex = startIndex; seqIndex < endIndex; seqIndex++) {
                        int actualIndex = effect.z ? (spriteSequence.length - 1 - seqIndex) : seqIndex;
                        com.corrodinggames.rts.game.units.custom.b.e sequenceSprite = spriteSequence[actualIndex];

                        com.corrodinggames.rts.gameFramework.m.Texture_M sequenceFrame = sequenceSprite.a;
                        if (sequenceSprite.b != null) {
                            sequenceFrame = sequenceSprite.b[unit.bX.R()];
                        }

                        // 应用垂直偏移
                        float verticalOffset = (float) actualIndex * effect.x;
                        float currentScreenY = screenY - verticalOffset;

                        canvas.k();
                        canvas.a(adjustedFinalRotation, screenX, currentScreenY);

                        // 应用缩放
                        if (seqScaleX != 16256f || seqScaleY != 16256f) {
                            canvas.a(seqScaleX, seqScaleY, screenX, currentScreenY);
                        }

                        // 计算帧索引
                        int sequenceFrameIndex = actualIndex * effect.y + frameIndex;

                        // 渲染序列帧
                        android.graphics.Rect srcRect = com.corrodinggames.rts.game.units.custom.b.c.a(effect,
                                sequenceSprite, sequenceFrame, sequenceFrameIndex);
                        android.graphics.RectF dstRect = com.corrodinggames.rts.game.units.custom.b.c.a(effect,
                                sequenceSprite, sequenceFrame, screenX, currentScreenY);
                        canvas.a(sequenceFrame, srcRect, dstRect, paint);

                        canvas.l();
                    }
                }
            }

            // 渲染连线效果
            com.corrodinggames.rts.game.units.BaseUnit lineTarget = null;
            if (effect.ad != null) {
                lineTarget = effect.ad.readUnit(unit);
            }

            if (lineTarget != null) {
                // 转换为屏幕坐标
                float startScreenX = finalPosX - framework.cw;
                float startScreenY = finalPosY - framework.cx - heightOffset;

                float targetScreenX = lineTarget.posX - framework.cw;
                float targetScreenY = lineTarget.posY - framework.cx - lineTarget.posZ;

                // 获取连线绘制参数
                android.graphics.Paint linePaint = effect.ah;
                if (linePaint == null) {
                    linePaint = com.corrodinggames.rts.game.units.custom.b.c.b;
                }

                // 应用连线透明度
                if (effect.ai != null) {
                    float lineAlpha = effect.ai.readNumber(unit);
                    if (lineAlpha != 16256f) {
                        android.graphics.Paint alphaLinePaint = new android.graphics.Paint();
                        alphaLinePaint.b(linePaint.e());

                        int calculatedAlpha = (int) (linePaint.f() * lineAlpha);
                        calculatedAlpha = Math.max(0, Math.min(255, calculatedAlpha));
                        alphaLinePaint.c(calculatedAlpha);
                        linePaint = alphaLinePaint;
                    }
                }

                // 绘制连线
                framework.bO.a(startScreenX, startScreenY, targetScreenX, targetScreenY, linePaint);
            }
        }
    }

    static /* synthetic */ d b(l l2, String string) {
        return com.corrodinggames.rts.game.units.custom.b.c.c(l2, string);
    }
}
