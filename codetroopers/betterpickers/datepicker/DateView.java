package com.codetroopers.betterpickers.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.widget.C1316b;
import com.codetroopers.betterpickers.widget.UnderlinePageIndicatorPicker;
import com.codetroopers.betterpickers.widget.ZeroTopPaddingTextView;

public class DateView extends C1316b {
    private ZeroTopPaddingTextView f4877a;
    private ZeroTopPaddingTextView f4878b;
    private ZeroTopPaddingTextView f4879c;
    private final Typeface f4880d;
    private Typeface f4881e;
    private UnderlinePageIndicatorPicker f4882f;
    private ColorStateList f4883g;

    public DateView(Context context) {
        this(context, null);
    }

    public DateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4880d = Typeface.createFromAsset(context.getAssets(), "fonts/AndroidClockMono-Thin.ttf");
        this.f4881e = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        this.f4883g = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
        setWillNotDraw(false);
    }

    public void setTheme(int i) {
        if (i != -1) {
            this.f4883g = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment).getColorStateList(C1291h.BetterPickersDialogFragment_bpTitleColor);
        }
        m8630a();
    }

    private void m8630a() {
        if (this.f4877a != null) {
            this.f4877a.setTextColor(this.f4883g);
        }
        if (this.f4878b != null) {
            this.f4878b.setTextColor(this.f4883g);
        }
        if (this.f4879c != null) {
            this.f4879c.setTextColor(this.f4883g);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4877a = (ZeroTopPaddingTextView) findViewById(C1287d.month);
        this.f4878b = (ZeroTopPaddingTextView) findViewById(C1287d.date);
        this.f4879c = (ZeroTopPaddingTextView) findViewById(C1287d.year_label);
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(getContext());
        removeAllViews();
        for (char c : dateFormatOrder) {
            switch (c) {
                case 'M':
                    addView(this.f4877a);
                    break;
                case 'd':
                    addView(this.f4878b);
                    break;
                case 'y':
                    addView(this.f4879c);
                    break;
                default:
                    break;
            }
        }
        if (this.f4877a != null) {
        }
        if (this.f4878b != null) {
            this.f4878b.setTypeface(this.f4880d);
            this.f4878b.m8787a();
        }
        if (this.f4877a != null) {
            this.f4877a.setTypeface(this.f4880d);
            this.f4877a.m8787a();
        }
        m8630a();
    }

    public void m8632a(String str, int i, int i2) {
        if (this.f4877a != null) {
            if (str.equals("")) {
                this.f4877a.setText("-");
                this.f4877a.setTypeface(this.f4880d);
                this.f4877a.setEnabled(false);
                this.f4877a.m8787a();
            } else {
                this.f4877a.setText(str);
                this.f4877a.setTypeface(this.f4881e);
                this.f4877a.setEnabled(true);
                this.f4877a.m8788b();
            }
        }
        if (this.f4878b != null) {
            if (i <= 0) {
                this.f4878b.setText("-");
                this.f4878b.setEnabled(false);
                this.f4878b.m8787a();
            } else {
                this.f4878b.setText(Integer.toString(i));
                this.f4878b.setEnabled(true);
                this.f4878b.m8787a();
            }
        }
        if (this.f4879c == null) {
            return;
        }
        if (i2 <= 0) {
            this.f4879c.setText("----");
            this.f4879c.setEnabled(false);
            this.f4879c.m8787a();
            return;
        }
        CharSequence num = Integer.toString(i2);
        while (num.length() < 4) {
            num = "-" + num;
        }
        this.f4879c.setText(num);
        this.f4879c.setEnabled(true);
        this.f4879c.m8787a();
    }

    public void setUnderlinePage(UnderlinePageIndicatorPicker underlinePageIndicatorPicker) {
        this.f4882f = underlinePageIndicatorPicker;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4882f.setTitleView(this);
    }

    public void setOnClick(OnClickListener onClickListener) {
        this.f4878b.setOnClickListener(onClickListener);
        this.f4877a.setOnClickListener(onClickListener);
        this.f4879c.setOnClickListener(onClickListener);
    }

    public ZeroTopPaddingTextView getDate() {
        return this.f4878b;
    }

    public ZeroTopPaddingTextView getMonth() {
        return this.f4877a;
    }

    public ZeroTopPaddingTextView getYear() {
        return this.f4879c;
    }

    public View mo1274a(int i) {
        return getChildAt(i);
    }
}
