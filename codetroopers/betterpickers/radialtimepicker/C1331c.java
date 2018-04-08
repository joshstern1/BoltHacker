package com.codetroopers.betterpickers.radialtimepicker;

class C1331c implements Runnable {
    final /* synthetic */ RadialPickerLayout f5050a;

    C1331c(RadialPickerLayout radialPickerLayout) {
        this.f5050a = radialPickerLayout;
    }

    public void run() {
        this.f5050a.f5008m.setAmOrPmPressed(this.f5050a.f5016u);
        this.f5050a.f5008m.invalidate();
    }
}
