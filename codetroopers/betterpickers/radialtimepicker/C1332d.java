package com.codetroopers.betterpickers.radialtimepicker;

class C1332d implements Runnable {
    final /* synthetic */ Boolean[] f5051a;
    final /* synthetic */ RadialPickerLayout f5052b;

    C1332d(RadialPickerLayout radialPickerLayout, Boolean[] boolArr) {
        this.f5052b = radialPickerLayout;
        this.f5051a = boolArr;
    }

    public void run() {
        this.f5052b.f5017v = true;
        int a = this.f5052b.m8696a(this.f5052b.f5019x, this.f5051a[0].booleanValue(), false, true);
        this.f5052b.f4998c = a;
        this.f5052b.f5000e.mo1276a(this.f5052b.getCurrentItemShowing(), a, false);
    }
}
