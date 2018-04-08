package com.codetroopers.betterpickers.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import com.codetroopers.betterpickers.C1292c.C1289f;

public class ZeroTopPaddingTextView extends TextView {
    private static final Typeface f5167a = Typeface.create("san-serif", 1);
    private static final Typeface f5168b = Typeface.create("sans-serif-condensed", 1);
    private int f5169c;
    private String f5170d;
    private String f5171e;

    public ZeroTopPaddingTextView(Context context) {
        this(context, null);
    }

    public ZeroTopPaddingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZeroTopPaddingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5169c = 0;
        this.f5170d = "";
        this.f5171e = "";
        m8786c();
        setIncludeFontPadding(false);
        m8787a();
    }

    private void m8786c() {
        this.f5170d = getResources().getString(C1289f.number_picker_seperator);
        this.f5171e = getResources().getString(C1289f.time_picker_time_seperator);
    }

    public void m8787a() {
        float f = 0.328f;
        float f2 = 0.25f;
        if (getPaint().getTypeface() != null && getPaint().getTypeface().equals(Typeface.DEFAULT_BOLD)) {
            f2 = 0.208f;
            f = 0.208f;
        }
        if (getTypeface() != null && getTypeface().equals(f5167a)) {
            f2 = 0.208f;
            f = 0.208f;
        }
        if (getTypeface() != null && getTypeface().equals(f5168b)) {
            f2 = 0.208f;
            f = 0.208f;
        }
        if (VERSION.SDK_INT < 14 && getText() != null && (getText().toString().equals(this.f5170d) || getText().toString().equals(this.f5171e))) {
            f2 = 0.233f;
        }
        setPadding(0, (int) ((-f) * getTextSize()), this.f5169c, (int) ((-f2) * getTextSize()));
    }

    public void m8788b() {
        setPadding(0, (int) ((-1045757428) * getTextSize()), this.f5169c, (int) ((-1045757428) * getTextSize()));
    }

    public void setPaddingRight(int i) {
        this.f5169c = i;
        m8787a();
    }
}
