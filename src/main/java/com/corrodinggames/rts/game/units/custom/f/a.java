package com.corrodinggames.rts.game.units.custom.f;

import com.corrodinggames.rts.game.units.custom.bo;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.gameFramework.utility.IniFile;
import com.corrodinggames.rts.gameFramework.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    static final Pattern a = Pattern.compile("\\$\\{([^\\}]*)\\}");
    static final Pattern b = Pattern.compile("[A-Za-z_][A-Za-z_.0-9]*");
    static b c = new b();

    public static void a(l paraml, IniFile paramab) throws bo {
        int i = 0;

        // 重置全局上下文
        c.a();

        // 处理全局变量 (@global)
        m localm1 = paramab.d("@global ");
        Iterator iterator1 = localm1.iterator();
        while (iterator1.hasNext()) {
            String str1 = (String) iterator1.next();
            m localm2 = paramab.k(str1, "@global ");
            Iterator iterator2 = localm2.iterator();
            while (iterator2.hasNext()) {
                String str2 = (String) iterator2.next();
                String str3 = str2.substring("@global ".length()).trim();

                try {
                    // 验证变量名
                    e.a(str3);
                } catch (bo localbo1) {
                    throw new bo("[" + str1 + "]" + str2 + ": " + localbo1.getMessage());
                }

                // 检查是否已存在同名section
                if (paramab.f(str3)) {
                    throw new bo("[" + str1 + "]" + str2 + ": A section already has that name");
                }

                // 获取变量值
                String str4 = paramab.e(str1, str2);

                // 检查是否包含动态值（不支持）
                if (str4.contains("${")) {
                    throw new bo(
                            "[" + str1 + "]" + str2 + " has dynamic value: '" + str4 + "', this is not yet supported");
                }

                // 将全局变量添加到上下文
                c.a.a(str3, str4);
            }
        }

        // 处理定义和变量替换
        ArrayList<ReplacementInfo> arrayList = new ArrayList<ReplacementInfo>();
        LinkedHashMap localLinkedHashMap = paramab.d();
        Iterator iterator3 = localLinkedHashMap.keySet().iterator();
        while (iterator3.hasNext()) {
            String str5 = (String) iterator3.next();

            // 跳过注释和模板
            if (str5 != null && !str5.startsWith("comment_") && !str5.startsWith("template_")) {
                // 创建新的上下文副本
                b localb = c.b();

                // 处理局部定义 (@define)
                m localm3 = paramab.k(str5, "@define ");
                Iterator iterator4 = localm3.iterator();
                while (iterator4.hasNext()) {
                    String str6 = (String) iterator4.next();
                    String str7 = str6.substring("@define ".length()).trim();

                    try {
                        // 验证变量名
                        e.a(str7);
                    } catch (bo localbo2) {
                        throw new bo("[" + str5 + "]" + str6 + ": " + localbo2.getMessage());
                    }

                    // 检查是否已存在同名section
                    if (paramab.f(str7)) {
                        throw new bo("[" + str5 + "]" + str6 + ": A section already has that name");
                    }

                    // 获取定义值
                    String str8 = paramab.e(str5, str6);

                    // 检查是否包含动态值（不支持）
                    if (str8.contains("${")) {
                        throw new bo("[" + str5 + "]" + str6 + " has dynamic value: '" + str8
                                + "', this is not yet supported");
                    }

                    // 将局部定义添加到上下文
                    localb.b.a(str7, str8);
                }

                // 处理变量替换
                Map localMap = (Map) localLinkedHashMap.get(str5);
                Iterator iterator5 = localMap.keySet().iterator();
                while (iterator5.hasNext()) {
                    String str9 = (String) iterator5.next();
                    String str10 = (String) localMap.get(str9);

                    if (str10 != null && str10.contains("${")) {
                        int j = 0;
                        StringBuffer localStringBuffer = new StringBuffer();
                        Matcher localMatcher = a.matcher(str10);
                        int k = 0;

                        // 查找并替换所有变量引用
                        while (localMatcher.find()) {
                            k++;
                            // 防止无限循环
                            if (k > 100) {
                                throw new bo("[" + str5 + "]" + str9 + ": Too many loops while parsing");
                            }

                            i++;
                            String str11 = localMatcher.group(1);

                            try {
                                // 解析变量值
                                String str12 = localb.a(paraml, paramab, str5, str11);

                                // 如果值有变化，进行替换
                                if (!str11.equals(str12)) {
                                    // 替换匹配的内容
                                    localMatcher.appendReplacement(localStringBuffer, Matcher.quoteReplacement(str12));
                                }
                            } catch (bo localbo3) {
                                localbo3.printStackTrace();
                                throw new bo("[" + str5 + "]" + str9 + ": " + localbo3.getMessage());
                            }
                        }

                        // 完成替换
                        localMatcher.appendTail(localStringBuffer);
                        String str13 = localStringBuffer.toString();

                        // 记录替换结果
                        arrayList.add(new ReplacementInfo(str5, str9, str13));
                    }
                }
            }
        }

        // 应用所有替换
        Iterator iterator6 = arrayList.iterator();
        while (iterator6.hasNext()) {
            ReplacementInfo replacementInfo = (ReplacementInfo) iterator6.next();
            paramab.e(replacementInfo.section, replacementInfo.key, replacementInfo.value);
        }

        arrayList.clear();
    }

    // 内部类，用于存储替换信息（重命名以避免冲突）
    private static class ReplacementInfo {
        public final String section;
        public final String key;
        public final String value;

        public ReplacementInfo(String section, String key, String value) {
            this.section = section;
            this.key = key;
            this.value = value;
        }
    }
}