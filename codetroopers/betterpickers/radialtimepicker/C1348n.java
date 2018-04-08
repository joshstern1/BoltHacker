package com.codetroopers.betterpickers.radialtimepicker;

import android.view.View;
import android.view.View.OnClickListener;

class C1348n implements OnClickListener {
    final /* synthetic */ C1343i f5118a;

    C1348n(C1343i c1343i) {
        this.f5118a = c1343i;
    }

    public void onClick(View view) {
        int i = 1;
        this.f5118a.m8756R();
        int isCurrentlyAmOrPm = this.f5118a.at.getIsCurrentlyAmOrPm();
        if (isCurrentlyAmOrPm != 0) {
            i = isCurrentlyAmOrPm == 1 ? 0 : isCurrentlyAmOrPm;
        }
        this.f5118a.m8743b(i);
        this.f5118a.at.setAmOrPm(i);
    }
}
