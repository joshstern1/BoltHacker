package com.codetroopers.betterpickers.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.widget.ZeroTopPaddingTextView;

public class TimerView extends LinearLayout {
    private ZeroTopPaddingTextView f5145a;
    private ZeroTopPaddingTextView f5146b;
    private ZeroTopPaddingTextView f5147c;
    private ZeroTopPaddingTextView f5148d;
    private final Typeface f5149e;
    private Typeface f5150f;
    private ZeroTopPaddingTextView f5151g;
    private ColorStateList f5152h;

    public TimerView(Context context) {
        this(context, null);
    }

    public TimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5149e = Typeface.createFromAsset(context.getAssets(), "fonts/AndroidClockMono-Thin.ttf");
        this.f5152h = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
    }

    public void setTheme(int i) {
        if (i != -1) {
            this.f5152h = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment).getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
        }
        m8779a();
    }

    private void m8779a() {
        if (this.f5145a != null) {
            this.f5145a.setTextColor(this.f5152h);
        }
        if (this.f5146b != null) {
            this.f5146b.setTextColor(this.f5152h);
        }
        if (this.f5147c != null) {
            this.f5147c.setTextColor(this.f5152h);
        }
        if (this.f5148d != null) {
            this.f5148d.setTextColor(this.f5152h);
        }
        if (this.f5151g != null) {
            this.f5151g.setTextColor(this.f5152h);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5147c = (ZeroTopPaddingTextView) findViewById(C1287d.hours_tens);
        this.f5148d = (ZeroTopPaddingTextView) findViewById(C1287d.minutes_tens);
        this.f5145a = (ZeroTopPaddingTextView) findViewById(C1287d.hours_ones);
        this.f5146b = (ZeroTopPaddingTextView) findViewById(C1287d.minutes_ones);
        this.f5151g = (ZeroTopPaddingTextView) findViewById(C1287d.hours_seperator);
        if (this.f5145a != null) {
            this.f5150f = this.f5145a.getTypeface();
        }
        if (this.f5148d != null) {
            this.f5148d.setTypeface(this.f5149e);
            this.f5148d.m8787a();
        }
        if (this.f5146b != null) {
            this.f5146b.setTypeface(this.f5149e);
            this.f5146b.m8787a();
        }
    }

    public void m8780a(int i, int i2, int i3, int i4) {
        if (this.f5147c != null) {
            if (i == -2) {
                this.f5147c.setVisibility(4);
            } else if (i == -1) {
                this.f5147c.setText("-");
                this.f5147c.setTypeface(this.f5149e);
                this.f5147c.setEnabled(false);
                this.f5147c.m8787a();
                this.f5147c.setVisibility(0);
            } else {
                this.f5147c.setText(String.format("%d", new Object[]{Integer.valueOf(i)}));
                this.f5147c.setTypeface(this.f5150f);
                this.f5147c.setEnabled(true);
                this.f5147c.m8788b();
                this.f5147c.setVisibility(0);
            }
        }
        if (this.f5145a != null) {
            if (i2 == -1) {
                this.f5145a.setText("-");
                this.f5145a.setTypeface(this.f5149e);
                this.f5145a.setEnabled(false);
                this.f5145a.m8787a();
            } else {
                this.f5145a.setText(String.format("%d", new Object[]{Integer.valueOf(i2)}));
                this.f5145a.setTypeface(this.f5150f);
                this.f5145a.setEnabled(true);
                this.f5145a.m8788b();
            }
        }
        if (this.f5148d != null) {
            if (i3 == -1) {
                this.f5148d.setText("-");
                this.f5148d.setEnabled(false);
            } else {
                this.f5148d.setEnabled(true);
                this.f5148d.setText(String.format("%d", new Object[]{Integer.valueOf(i3)}));
            }
        }
        if (this.f5146b == null) {
            return;
        }
        if (i4 == -1) {
            this.f5146b.setText("-");
            this.f5146b.setEnabled(false);
            return;
        }
        this.f5146b.setText(String.format("%d", new Object[]{Integer.valueOf(i4)}));
        this.f5146b.setEnabled(true);
    }
}
