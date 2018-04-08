package com.codetroopers.betterpickers.expirationpicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.widget.C1316b;
import com.codetroopers.betterpickers.widget.UnderlinePageIndicatorPicker;
import com.codetroopers.betterpickers.widget.ZeroTopPaddingTextView;

public class ExpirationView extends C1316b {
    private ZeroTopPaddingTextView f4918a;
    private ZeroTopPaddingTextView f4919b;
    private final Typeface f4920c;
    private Typeface f4921d;
    private UnderlinePageIndicatorPicker f4922e;
    private ZeroTopPaddingTextView f4923f;
    private ColorStateList f4924g;

    public ExpirationView(Context context) {
        this(context, null);
    }

    public ExpirationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4920c = Typeface.createFromAsset(context.getAssets(), "fonts/AndroidClockMono-Thin.ttf");
        this.f4921d = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        this.f4924g = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
        setWillNotDraw(false);
    }

    public void setTheme(int i) {
        if (i != -1) {
            this.f4924g = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment).getColorStateList(C1291h.BetterPickersDialogFragment_bpTitleColor);
        }
        m8655a();
    }

    private void m8655a() {
        if (this.f4918a != null) {
            this.f4918a.setTextColor(this.f4924g);
        }
        if (this.f4919b != null) {
            this.f4919b.setTextColor(this.f4924g);
        }
        if (this.f4923f != null) {
            this.f4923f.setTextColor(this.f4924g);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4918a = (ZeroTopPaddingTextView) findViewById(C1287d.month);
        this.f4919b = (ZeroTopPaddingTextView) findViewById(C1287d.year_label);
        this.f4923f = (ZeroTopPaddingTextView) findViewById(C1287d.expiration_seperator);
        if (this.f4918a != null) {
            this.f4918a.setTypeface(this.f4920c);
            this.f4918a.m8787a();
        }
        if (this.f4919b != null) {
            this.f4919b.setTypeface(this.f4920c);
        }
        if (this.f4923f != null) {
            this.f4923f.setTypeface(this.f4920c);
        }
        m8655a();
    }

    public void m8657a(String str, int i) {
        if (this.f4918a != null) {
            if (str.equals("")) {
                this.f4918a.setText("--");
                this.f4918a.setEnabled(false);
                this.f4918a.m8787a();
            } else {
                this.f4918a.setText(str);
                this.f4918a.setEnabled(true);
                this.f4918a.m8787a();
            }
        }
        if (this.f4919b == null) {
            return;
        }
        if (i <= 0) {
            this.f4919b.setText("----");
            this.f4919b.setEnabled(false);
            this.f4919b.m8787a();
            return;
        }
        CharSequence num = Integer.toString(i);
        while (num.length() < 4) {
            num = num + "-";
        }
        this.f4919b.setText(num);
        this.f4919b.setEnabled(true);
        this.f4919b.m8787a();
    }

    public void setUnderlinePage(UnderlinePageIndicatorPicker underlinePageIndicatorPicker) {
        this.f4922e = underlinePageIndicatorPicker;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4922e.setTitleView(this);
    }

    public void setOnClick(OnClickListener onClickListener) {
        this.f4918a.setOnClickListener(onClickListener);
        this.f4919b.setOnClickListener(onClickListener);
    }

    public ZeroTopPaddingTextView getMonth() {
        return this.f4918a;
    }

    public ZeroTopPaddingTextView getYear() {
        return this.f4919b;
    }

    public View mo1274a(int i) {
        int[] iArr = new int[]{0, 2};
        if (i > iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }
}
