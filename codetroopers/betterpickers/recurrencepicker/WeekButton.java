package com.codetroopers.betterpickers.recurrencepicker;

import android.content.Context;
import android.support.v4.view.ao;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ToggleButton;

public class WeekButton extends ToggleButton {
    private static int f5119a;

    public WeekButton(Context context) {
        super(context);
    }

    public WeekButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WeekButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static void setSuggestedWidth(int i) {
        f5119a = i;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (measuredHeight > 0 && measuredWidth > 0) {
            if (measuredWidth < measuredHeight) {
                if (MeasureSpec.getMode(ao.m3941k(this)) != 1073741824) {
                    measuredHeight = measuredWidth;
                }
            } else if (measuredHeight < measuredWidth && MeasureSpec.getMode(ao.m3940j(this)) != 1073741824) {
                measuredWidth = measuredHeight;
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
