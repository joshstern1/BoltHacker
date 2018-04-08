package com.codetroopers.betterpickers.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class AutoScrollHorizontalScrollView extends HorizontalScrollView {
    public AutoScrollHorizontalScrollView(Context context) {
        super(context);
    }

    public AutoScrollHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoScrollHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        fullScroll(66);
    }
}
