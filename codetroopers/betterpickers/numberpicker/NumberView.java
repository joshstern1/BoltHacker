package com.codetroopers.betterpickers.numberpicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.widget.ZeroTopPaddingTextView;

public class NumberView extends LinearLayout {
    private ZeroTopPaddingTextView f4984a;
    private ZeroTopPaddingTextView f4985b;
    private ZeroTopPaddingTextView f4986c;
    private ZeroTopPaddingTextView f4987d;
    private final Typeface f4988e;
    private Typeface f4989f;
    private ColorStateList f4990g;

    public NumberView(Context context) {
        this(context, null);
    }

    public NumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4988e = Typeface.createFromAsset(context.getAssets(), "fonts/AndroidClockMono-Thin.ttf");
        this.f4990g = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
    }

    public void setTheme(int i) {
        if (i != -1) {
            this.f4990g = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment).getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
        }
        m8690a();
    }

    private void m8690a() {
        if (this.f4984a != null) {
            this.f4984a.setTextColor(this.f4990g);
        }
        if (this.f4985b != null) {
            this.f4985b.setTextColor(this.f4990g);
        }
        if (this.f4986c != null) {
            this.f4986c.setTextColor(this.f4990g);
        }
        if (this.f4987d != null) {
            this.f4987d.setTextColor(this.f4990g);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4984a = (ZeroTopPaddingTextView) findViewById(C1287d.number);
        this.f4985b = (ZeroTopPaddingTextView) findViewById(C1287d.decimal);
        this.f4986c = (ZeroTopPaddingTextView) findViewById(C1287d.decimal_separator);
        this.f4987d = (ZeroTopPaddingTextView) findViewById(C1287d.minus_label);
        if (this.f4984a != null) {
            this.f4989f = this.f4984a.getTypeface();
        }
        if (this.f4984a != null) {
            this.f4984a.setTypeface(this.f4988e);
            this.f4984a.m8787a();
        }
        if (this.f4985b != null) {
            this.f4985b.setTypeface(this.f4988e);
            this.f4985b.m8787a();
        }
        m8690a();
    }

    public void m8691a(String str, String str2, boolean z, boolean z2) {
        int i = 0;
        this.f4987d.setVisibility(z2 ? 0 : 8);
        if (this.f4984a != null) {
            if (str.equals("")) {
                this.f4984a.setText("-");
                this.f4984a.setTypeface(this.f4988e);
                this.f4984a.setEnabled(false);
                this.f4984a.m8787a();
                this.f4984a.setVisibility(0);
            } else if (z) {
                this.f4984a.setText(str);
                this.f4984a.setTypeface(this.f4989f);
                this.f4984a.setEnabled(true);
                this.f4984a.m8788b();
                this.f4984a.setVisibility(0);
            } else {
                this.f4984a.setText(str);
                this.f4984a.setTypeface(this.f4988e);
                this.f4984a.setEnabled(true);
                this.f4984a.m8787a();
                this.f4984a.setVisibility(0);
            }
        }
        if (this.f4985b != null) {
            if (str2.equals("")) {
                this.f4985b.setVisibility(8);
            } else {
                this.f4985b.setText(str2);
                this.f4985b.setTypeface(this.f4988e);
                this.f4985b.setEnabled(true);
                this.f4985b.m8787a();
                this.f4985b.setVisibility(0);
            }
        }
        if (this.f4986c != null) {
            ZeroTopPaddingTextView zeroTopPaddingTextView = this.f4986c;
            if (!z) {
                i = 8;
            }
            zeroTopPaddingTextView.setVisibility(i);
        }
    }
}
