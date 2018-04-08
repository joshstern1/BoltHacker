package com.codetroopers.betterpickers.calendardatepicker;

class C1302f implements Runnable {
    final /* synthetic */ int f4760a;
    final /* synthetic */ C1301e f4761b;

    C1302f(C1301e c1301e, int i) {
        this.f4761b = c1301e;
        this.f4760a = i;
    }

    public void run() {
        this.f4761b.setSelection(this.f4760a);
    }
}
