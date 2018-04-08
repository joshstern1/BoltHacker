package com.codetroopers.betterpickers.numberpicker;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class NumberPickerErrorTextView extends TextView {
    private Runnable f4982a = new C1326c(this);
    private Handler f4983b = new Handler();

    public NumberPickerErrorTextView(Context context) {
        super(context);
    }

    public NumberPickerErrorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberPickerErrorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void m8688a() {
        this.f4983b.removeCallbacks(this.f4982a);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 17432577);
        loadAnimation.setAnimationListener(new C1327d(this));
        startAnimation(loadAnimation);
    }

    public void m8689b() {
        this.f4983b.removeCallbacks(this.f4982a);
        setVisibility(4);
    }
}
