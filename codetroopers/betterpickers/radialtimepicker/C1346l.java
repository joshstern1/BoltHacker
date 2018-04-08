package com.codetroopers.betterpickers.radialtimepicker;

import android.view.View;
import android.view.View.OnClickListener;

class C1346l implements OnClickListener {
    final /* synthetic */ C1343i f5116a;

    C1346l(C1343i c1343i) {
        this.f5116a = c1343i;
    }

    public void onClick(View view) {
        if (this.f5116a.aH && this.f5116a.m8732T()) {
            this.f5116a.m8751f(false);
        } else {
            this.f5116a.m8756R();
        }
        if (this.f5116a.ak != null) {
            this.f5116a.ak.mo2217a(this.f5116a, this.f5116a.at.getHours(), this.f5116a.at.getMinutes());
        }
        this.f5116a.m2694a();
    }
}
