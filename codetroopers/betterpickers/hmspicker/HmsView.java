package com.codetroopers.betterpickers.hmspicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.widget.ZeroTopPaddingTextView;

public class HmsView extends LinearLayout {
    private ZeroTopPaddingTextView f4948a;
    private ZeroTopPaddingTextView f4949b;
    private ZeroTopPaddingTextView f4950c;
    private ZeroTopPaddingTextView f4951d;
    private ZeroTopPaddingTextView f4952e;
    private final Typeface f4953f;
    private Typeface f4954g;
    private ColorStateList f4955h;

    public HmsView(Context context) {
        this(context, null);
    }

    public HmsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4953f = Typeface.createFromAsset(context.getAssets(), "fonts/AndroidClockMono-Thin.ttf");
        this.f4955h = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
    }

    public void setTheme(int i) {
        if (i != -1) {
            this.f4955h = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment).getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
        }
        m8668a();
    }

    private void m8668a() {
        if (this.f4948a != null) {
            this.f4948a.setTextColor(this.f4955h);
        }
        if (this.f4949b != null) {
            this.f4949b.setTextColor(this.f4955h);
        }
        if (this.f4950c != null) {
            this.f4950c.setTextColor(this.f4955h);
        }
        if (this.f4951d != null) {
            this.f4951d.setTextColor(this.f4955h);
        }
        if (this.f4952e != null) {
            this.f4952e.setTextColor(this.f4955h);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4948a = (ZeroTopPaddingTextView) findViewById(C1287d.hours_ones);
        this.f4950c = (ZeroTopPaddingTextView) findViewById(C1287d.minutes_tens);
        this.f4949b = (ZeroTopPaddingTextView) findViewById(C1287d.minutes_ones);
        this.f4952e = (ZeroTopPaddingTextView) findViewById(C1287d.seconds_tens);
        this.f4951d = (ZeroTopPaddingTextView) findViewById(C1287d.seconds_ones);
        if (this.f4948a != null) {
            this.f4954g = this.f4948a.getTypeface();
            this.f4948a.m8788b();
        }
        if (this.f4950c != null) {
            this.f4950c.m8788b();
        }
        if (this.f4949b != null) {
            this.f4949b.m8788b();
        }
        if (this.f4952e != null) {
            this.f4952e.setTypeface(this.f4953f);
            this.f4952e.m8787a();
        }
        if (this.f4951d != null) {
            this.f4951d.setTypeface(this.f4953f);
            this.f4951d.m8787a();
        }
    }

    public void m8669a(int i, int i2, int i3, int i4, int i5) {
        if (this.f4948a != null) {
            this.f4948a.setText(String.format("%d", new Object[]{Integer.valueOf(i)}));
        }
        if (this.f4950c != null) {
            this.f4950c.setText(String.format("%d", new Object[]{Integer.valueOf(i2)}));
        }
        if (this.f4949b != null) {
            this.f4949b.setText(String.format("%d", new Object[]{Integer.valueOf(i3)}));
        }
        if (this.f4952e != null) {
            this.f4952e.setText(String.format("%d", new Object[]{Integer.valueOf(i4)}));
        }
        if (this.f4951d != null) {
            this.f4951d.setText(String.format("%d", new Object[]{Integer.valueOf(i5)}));
        }
    }
}
