package android.support.v7.widget;

import android.graphics.Outline;

class C0975c extends C0962b {
    public C0975c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f3049d) {
            if (this.a.f3048c != null) {
                this.a.f3048c.getOutline(outline);
            }
        } else if (this.a.f3046a != null) {
            this.a.f3046a.getOutline(outline);
        }
    }
}
