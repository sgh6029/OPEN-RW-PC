package com.corrodinggames.rts.gameFramework;

public enum ProfilerSection {
    // 主要性能监控点
    a("total"),
    b("update"),
    c("draw"),
    d("draw_game"),
    e("draw_end"),
    f("draw_gui"),
    g("draw_game_effects"),
    h("update_game_shouldDraw"),
    i("update_game_sortRender"),
    j("update_do_all_collisions"),
    k("update_do_all_collisions2"),
    l("update_all_team_and_ai"),
    m("update_geo_indexes"),
    n("update_minimap"),
    o("update_groupcontroller"),
    p("draw_game_unit"),
    q("draw_setup"),
    r("draw_setup_fill"),
    s("draw_setup_clip"),
    t("draw_setup_drawMap"),
    u("surface_draw"),
    v("realdraw_in_drawthread"),
    w("update_waiting_on_draw"),
    x("draw_waiting_on_update"),
    y("load_total"),
    z("load_map"),
    A("load_units"),
    B("load_compression"),
    C("init_total"),
    D("init_unitcolour");

    // 枚举值数组
    private static final ProfilerSection[] E;

    // 枚举构造函数
    private ProfilerSection(String name) {
        // 枚举的构造函数由JVM处理
    }

    // 静态初始化块
    static {
        E = new ProfilerSection[]{
            a, b, c, d, e, f, g, h, i, j,
            k, l, m, n, o, p, q, r, s, t,
            u, v, w, x, y, z, A, B, C, D
        };
    }
}