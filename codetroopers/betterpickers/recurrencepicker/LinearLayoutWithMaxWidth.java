package com.codetroopers.betterpickers.recurrencepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class LinearLayoutWithMaxWidth extends LinearLayout {
    public LinearLayoutWithMaxWidth(Context context) {
        super(context);
    }

    public LinearLayoutWithMaxWidth(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinearLayoutWithMaxWidth(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        WeekButton.setSuggestedWidth(MeasureSpec.getSize(i) / 7);
        super.onMeasure(i, i2);
    }
}
