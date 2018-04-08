package com.codetroopers.betterpickers.calendardatepicker;

class C1313m implements Runnable {
    final /* synthetic */ int f4831a;
    final /* synthetic */ int f4832b;
    final /* synthetic */ C1312l f4833c;

    C1313m(C1312l c1312l, int i, int i2) {
        this.f4833c = c1312l;
        this.f4831a = i;
        this.f4832b = i2;
    }

    public void run() {
        this.f4833c.setSelectionFromTop(this.f4831a, this.f4832b);
        this.f4833c.requestLayout();
    }
}
