/*
 * Decompiled with CFR 0.152.
 */
package com.corrodinggames.rts.java;

import com.corrodinggames.librocket.a;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.appFramework.g;
import com.corrodinggames.rts.gameFramework.GameEngine;

public class JavaInGameActivity
extends g {
    @Override
    public void c(int n2) {
        GameEngine.log("InGameActivityJava selectMenuOption: " + n2);
        this.d(n2);
    }

    private void e(String string2) {
        ScriptEngine.getInstance().getRoot().makeSaveGamePopup(string2);
    }

    private void f(String string2) {
        ScriptEngine.getInstance().getRoot().makeExportMapGamePopup(string2);
    }

    @Override
    public void d(int n2) {
        switch (n2) {
            case 4: {
                GameEngine.getInstance().ch = !GameEngine.getInstance().ch;
                break;
            }
            case 2: {
                a.a().d();
                break;
            }
            case 3: {
                GameEngine.log("TODO");
                break;
            }
            case 6: {
                GameEngine l2 = GameEngine.getInstance();
                l2.bl = !l2.bl;
                break;
            }
            case 5: {
                GameEngine.log("TODO");
                break;
            }
            case 12: {
                this.e(null);
                break;
            }
            case 18: {
                this.f(null);
                break;
            }
            case 9: {
                GameEngine l3 = GameEngine.getInstance();
                if (!l3.bo) {
                    l3.bo = true;
                    break;
                }
                l3.bo = false;
                break;
            }
            case 19: {
                ScriptEngine.getInstance().addScriptToQueue("mp.surrenderPrompt();");
                break;
            }
            case 10: {
                ScriptEngine.getInstance().addScriptToQueue("mp.multiplayerExitPrompt();");
                break;
            }
            case 17: {
                ScriptEngine.getInstance().addScriptToQueue("mp.reinviteAsk();");
                break;
            }
            case 15: {
                ScriptEngine.getInstance().addScriptToQueue("showMainMenu();");
                break;
            }
            case 11: {
                GameEngine l4 = GameEngine.getInstance();
                if (l4.ce == null || l4.ce.h == null) break;
                l4.a("Briefing", l4.ce.h);
                break;
            }
            case 13: {
                ScriptEngine.getInstance().addScriptToQueue("makeSendMessagePopup();");
                break;
            }
            case 16: {
                ScriptEngine.getInstance().addScriptToQueue("makeSendTeamMessagePopup();");
                break;
            }
            case 14: {
                GameEngine l5 = GameEngine.getInstance();
                if (l5.networkEngine == null) break;
                l5.networkEngine.H();
                break;
            }
            case 20: {
                ScriptEngine.getInstance().addScriptToQueue("showMainMenu();");
                break;
            }
            case 21: {
                ScriptEngine.getInstance().addScriptToQueue("showBattleroom();");
                break;
            }
            case 22: {
                GameEngine l6 = GameEngine.getInstance();
                l6.cU = true;
                l6.bS.u = false;
                break;
            }
            case 23: {
                a.a().e();
            }
        }
    }

    @Override
    public void m() {
        ScriptEngine.getInstance().addScriptToQueue("showMainMenu();");
    }
}
