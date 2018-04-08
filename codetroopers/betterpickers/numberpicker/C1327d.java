package com.codetroopers.betterpickers.numberpicker;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C1327d implements AnimationListener {
    final /* synthetic */ NumberPickerErrorTextView f4992a;

    C1327d(NumberPickerErrorTextView numberPickerErrorTextView) {
        this.f4992a = numberPickerErrorTextView;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f4992a.setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
