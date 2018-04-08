package android.support.design.widget;

import android.graphics.Outline;

class C0279h extends C0278g {
    C0279h() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
