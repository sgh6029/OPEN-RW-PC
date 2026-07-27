package com.corrodinggames.rts.gameFramework.utility;

class c extends Throwable {
    // $FF: synthetic field
    final b a;

    c(b var1, c var2) {
        super(b.a(var1), var2);
        this.a = var1;
    }

    public Throwable fillInStackTrace() {
        this.setStackTrace(b.b(this.a));
        return this;
    }
}
