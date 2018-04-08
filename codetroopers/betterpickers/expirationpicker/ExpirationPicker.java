package com.codetroopers.betterpickers.expirationpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.aj;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1286c;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1288e;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.datepicker.DatePicker;
import com.codetroopers.betterpickers.widget.UnderlinePageIndicatorPicker;
import java.util.Calendar;

public class ExpirationPicker extends LinearLayout implements OnClickListener, OnLongClickListener {
    private static int f4889s = -1;
    private static int f4890t = -1;
    private int f4891A;
    private int f4892B;
    private int f4893C;
    protected int f4894a;
    protected int f4895b;
    protected int[] f4896c;
    protected int f4897d;
    protected int f4898e;
    protected final Button[] f4899f;
    protected final Button[] f4900g;
    protected Button f4901h;
    protected Button f4902i;
    protected UnderlinePageIndicatorPicker f4903j;
    protected ViewPager f4904k;
    protected C1319a f4905l;
    protected ImageButton f4906m;
    protected ExpirationView f4907n;
    protected String[] f4908o;
    protected final Context f4909p;
    protected View f4910q;
    private char[] f4911r;
    private Button f4912u;
    private ColorStateList f4913v;
    private int f4914w;
    private int f4915x;
    private int f4916y;
    private int f4917z;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C1321b();
        int f4884a;
        int[] f4885b;
        int f4886c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4884a = parcel.readInt();
            parcel.readIntArray(this.f4885b);
            this.f4886c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4884a);
            parcel.writeIntArray(this.f4885b);
            parcel.writeInt(this.f4886c);
        }
    }

    private class C1319a extends aj {
        final /* synthetic */ ExpirationPicker f4887a;
        private LayoutInflater f4888b;

        public C1319a(ExpirationPicker expirationPicker, LayoutInflater layoutInflater) {
            this.f4887a = expirationPicker;
            this.f4888b = layoutInflater;
        }

        public Object mo300a(ViewGroup viewGroup, int i) {
            View view;
            this.f4887a.f4909p.getResources();
            View inflate;
            View findViewById;
            View findViewById2;
            View findViewById3;
            View findViewById4;
            int i2;
            if (i == 0) {
                ExpirationPicker.f4889s = i;
                inflate = this.f4888b.inflate(C1288e.keyboard_text, null);
                findViewById = inflate.findViewById(C1287d.first);
                findViewById2 = inflate.findViewById(C1287d.second);
                findViewById3 = inflate.findViewById(C1287d.third);
                findViewById4 = inflate.findViewById(C1287d.fourth);
                this.f4887a.f4899f[0] = (Button) findViewById.findViewById(C1287d.key_left);
                this.f4887a.f4899f[1] = (Button) findViewById.findViewById(C1287d.key_middle);
                this.f4887a.f4899f[2] = (Button) findViewById.findViewById(C1287d.key_right);
                this.f4887a.f4899f[3] = (Button) findViewById2.findViewById(C1287d.key_left);
                this.f4887a.f4899f[4] = (Button) findViewById2.findViewById(C1287d.key_middle);
                this.f4887a.f4899f[5] = (Button) findViewById2.findViewById(C1287d.key_right);
                this.f4887a.f4899f[6] = (Button) findViewById3.findViewById(C1287d.key_left);
                this.f4887a.f4899f[7] = (Button) findViewById3.findViewById(C1287d.key_middle);
                this.f4887a.f4899f[8] = (Button) findViewById3.findViewById(C1287d.key_right);
                this.f4887a.f4899f[9] = (Button) findViewById4.findViewById(C1287d.key_left);
                this.f4887a.f4899f[10] = (Button) findViewById4.findViewById(C1287d.key_middle);
                this.f4887a.f4899f[11] = (Button) findViewById4.findViewById(C1287d.key_right);
                for (i2 = 0; i2 < 12; i2++) {
                    this.f4887a.f4899f[i2].setOnClickListener(this.f4887a);
                    this.f4887a.f4899f[i2].setText(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)}));
                    this.f4887a.f4899f[i2].setTextColor(this.f4887a.f4913v);
                    this.f4887a.f4899f[i2].setBackgroundResource(this.f4887a.f4914w);
                    this.f4887a.f4899f[i2].setTag(C1287d.date_keyboard, "month");
                    this.f4887a.f4899f[i2].setTag(C1287d.date_month_int, Integer.valueOf(i2 + 1));
                }
                view = inflate;
            } else if (i == 1) {
                ExpirationPicker.f4890t = i;
                inflate = this.f4888b.inflate(C1288e.keyboard, null);
                findViewById = inflate.findViewById(C1287d.first);
                findViewById2 = inflate.findViewById(C1287d.second);
                findViewById3 = inflate.findViewById(C1287d.third);
                findViewById4 = inflate.findViewById(C1287d.fourth);
                this.f4887a.f4900g[1] = (Button) findViewById.findViewById(C1287d.key_left);
                this.f4887a.f4900g[2] = (Button) findViewById.findViewById(C1287d.key_middle);
                this.f4887a.f4900g[3] = (Button) findViewById.findViewById(C1287d.key_right);
                this.f4887a.f4900g[4] = (Button) findViewById2.findViewById(C1287d.key_left);
                this.f4887a.f4900g[5] = (Button) findViewById2.findViewById(C1287d.key_middle);
                this.f4887a.f4900g[6] = (Button) findViewById2.findViewById(C1287d.key_right);
                this.f4887a.f4900g[7] = (Button) findViewById3.findViewById(C1287d.key_left);
                this.f4887a.f4900g[8] = (Button) findViewById3.findViewById(C1287d.key_middle);
                this.f4887a.f4900g[9] = (Button) findViewById3.findViewById(C1287d.key_right);
                this.f4887a.f4901h = (Button) findViewById4.findViewById(C1287d.key_left);
                this.f4887a.f4901h.setTextColor(this.f4887a.f4913v);
                this.f4887a.f4901h.setBackgroundResource(this.f4887a.f4914w);
                this.f4887a.f4900g[0] = (Button) findViewById4.findViewById(C1287d.key_middle);
                this.f4887a.f4902i = (Button) findViewById4.findViewById(C1287d.key_right);
                this.f4887a.f4902i.setTextColor(this.f4887a.f4913v);
                this.f4887a.f4902i.setBackgroundResource(this.f4887a.f4914w);
                for (i2 = 0; i2 < 10; i2++) {
                    this.f4887a.f4900g[i2].setOnClickListener(this.f4887a);
                    this.f4887a.f4900g[i2].setText(String.format("%d", new Object[]{Integer.valueOf(i2)}));
                    this.f4887a.f4900g[i2].setTextColor(this.f4887a.f4913v);
                    this.f4887a.f4900g[i2].setBackgroundResource(this.f4887a.f4914w);
                    this.f4887a.f4900g[i2].setTag(C1287d.date_keyboard, "year");
                    this.f4887a.f4900g[i2].setTag(C1287d.numbers_key, Integer.valueOf(i2));
                }
                view = inflate;
            } else {
                view = new View(this.f4887a.f4909p);
            }
            this.f4887a.m8654d();
            this.f4887a.m8653c();
            this.f4887a.m8646f();
            viewGroup.addView(view, 0);
            return view;
        }

        public void mo303a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int mo1273b() {
            return 2;
        }

        public boolean mo304a(View view, Object obj) {
            return view == obj;
        }
    }

    public ExpirationPicker(Context context) {
        this(context, null);
    }

    public ExpirationPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4894a = 4;
        this.f4895b = -1;
        this.f4896c = new int[this.f4894a];
        this.f4897d = -1;
        this.f4899f = new Button[12];
        this.f4900g = new Button[10];
        this.f4893C = -1;
        this.f4909p = context;
        this.f4911r = DateFormat.getDateFormatOrder(this.f4909p);
        this.f4908o = DatePicker.m8614e();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutId(), this);
        this.f4913v = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
        this.f4914w = C1286c.key_background_dark;
        this.f4915x = C1286c.button_background_dark;
        this.f4916y = getResources().getColor(C1284a.default_divider_color_dark);
        this.f4917z = getResources().getColor(C1284a.default_keyboard_indicator_color_dark);
        this.f4892B = C1286c.ic_backspace_dark;
        this.f4891A = C1286c.ic_check_dark;
        this.f4898e = Calendar.getInstance().get(1);
    }

    protected int getLayoutId() {
        return C1288e.expiration_picker_view;
    }

    public void setTheme(int i) {
        this.f4893C = i;
        if (this.f4893C != -1) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment);
            this.f4913v = obtainStyledAttributes.getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
            this.f4914w = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpKeyBackground, this.f4914w);
            this.f4915x = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpButtonBackground, this.f4915x);
            this.f4891A = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpCheckIcon, this.f4891A);
            this.f4916y = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpTitleDividerColor, this.f4916y);
            this.f4917z = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpKeyboardIndicatorColor, this.f4917z);
            this.f4892B = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpDeleteIcon, this.f4892B);
        }
        m8645e();
    }

    public void setMinYear(int i) {
        this.f4898e = i;
    }

    private void m8645e() {
        int i = 0;
        for (Button button : this.f4899f) {
            if (button != null) {
                button.setTextColor(this.f4913v);
                button.setBackgroundResource(this.f4914w);
            }
        }
        Button[] buttonArr = this.f4900g;
        int length = buttonArr.length;
        while (i < length) {
            Button button2 = buttonArr[i];
            if (button2 != null) {
                button2.setTextColor(this.f4913v);
                button2.setBackgroundResource(this.f4914w);
            }
            i++;
        }
        if (this.f4903j != null) {
            this.f4903j.setSelectedColor(this.f4917z);
        }
        if (this.f4910q != null) {
            this.f4910q.setBackgroundColor(this.f4916y);
        }
        if (this.f4906m != null) {
            this.f4906m.setBackgroundResource(this.f4915x);
            this.f4906m.setImageDrawable(getResources().getDrawable(this.f4892B));
        }
        if (this.f4901h != null) {
            this.f4901h.setTextColor(this.f4913v);
            this.f4901h.setBackgroundResource(this.f4914w);
        }
        if (this.f4902i != null) {
            this.f4902i.setTextColor(this.f4913v);
            this.f4902i.setBackgroundResource(this.f4914w);
        }
        if (this.f4907n != null) {
            this.f4907n.setTheme(this.f4893C);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4910q = findViewById(C1287d.divider);
        for (int i = 0; i < this.f4896c.length; i++) {
            this.f4896c[i] = 0;
        }
        this.f4903j = (UnderlinePageIndicatorPicker) findViewById(C1287d.keyboard_indicator);
        this.f4904k = (ViewPager) findViewById(C1287d.keyboard_pager);
        this.f4904k.setOffscreenPageLimit(2);
        this.f4905l = new C1319a(this, (LayoutInflater) this.f4909p.getSystemService("layout_inflater"));
        this.f4904k.setAdapter(this.f4905l);
        this.f4903j.setViewPager(this.f4904k);
        this.f4904k.setCurrentItem(0);
        this.f4907n = (ExpirationView) findViewById(C1287d.date_text);
        this.f4907n.setTheme(this.f4893C);
        this.f4907n.setUnderlinePage(this.f4903j);
        this.f4907n.setOnClick(this);
        this.f4906m = (ImageButton) findViewById(C1287d.delete);
        this.f4906m.setOnClickListener(this);
        this.f4906m.setOnLongClickListener(this);
        m8643c(this.f4898e / 1000);
        m8643c((this.f4898e % 1000) / 100);
        this.f4904k.m3222a(this.f4904k.getCurrentItem() - 1, true);
        m8654d();
        m8653c();
        m8646f();
    }

    public void m8650a() {
        boolean z = (this.f4895b == -1 && this.f4897d == -1) ? false : true;
        if (this.f4906m != null) {
            this.f4906m.setEnabled(z);
        }
    }

    public void onClick(View view) {
        view.performHapticFeedback(1);
        m8651a(view);
        m8650a();
    }

    protected void m8651a(View view) {
        if (view == this.f4906m) {
            switch (this.f4904k.getCurrentItem()) {
                case 0:
                    if (this.f4895b != -1) {
                        this.f4895b = -1;
                        break;
                    }
                    break;
                case 1:
                    if (this.f4897d < 2) {
                        if (this.f4904k.getCurrentItem() > 0) {
                            this.f4904k.m3222a(this.f4904k.getCurrentItem() - 1, true);
                            break;
                        }
                    }
                    for (int i = 0; i < this.f4897d; i++) {
                        this.f4896c[i] = this.f4896c[i + 1];
                    }
                    this.f4896c[this.f4897d] = 0;
                    this.f4897d--;
                    break;
                    break;
            }
        } else if (view == this.f4907n.getMonth()) {
            this.f4904k.setCurrentItem(f4889s);
        } else if (view == this.f4907n.getYear()) {
            this.f4904k.setCurrentItem(f4890t);
        } else if (view.getTag(C1287d.date_keyboard).equals("month")) {
            this.f4895b = ((Integer) view.getTag(C1287d.date_month_int)).intValue();
            if (this.f4904k.getCurrentItem() < 2) {
                this.f4904k.m3222a(this.f4904k.getCurrentItem() + 1, true);
            }
        } else if (view.getTag(C1287d.date_keyboard).equals("year")) {
            m8643c(((Integer) view.getTag(C1287d.numbers_key)).intValue());
        }
        m8646f();
    }

    public boolean onLongClick(View view) {
        view.performHapticFeedback(0);
        if (view != this.f4906m) {
            return false;
        }
        this.f4906m.setPressed(false);
        m8652b();
        m8646f();
        return true;
    }

    private void m8646f() {
        m8653c();
        m8649i();
        m8650a();
        m8647g();
        m8648h();
    }

    public void m8652b() {
        for (int i = 0; i < this.f4894a; i++) {
            this.f4896c[i] = 0;
        }
        this.f4897d = -1;
        this.f4895b = -1;
        this.f4904k.m3222a(0, true);
        m8653c();
    }

    @SuppressLint({"DefaultLocale"})
    protected void m8653c() {
        String str;
        if (this.f4895b < 0) {
            str = "";
        } else {
            str = String.format("%02d", new Object[]{Integer.valueOf(this.f4895b)});
        }
        this.f4907n.m8657a(str, getYear());
    }

    protected void m8654d() {
        if (this.f4901h != null) {
            this.f4901h.setEnabled(false);
        }
        if (this.f4902i != null) {
            this.f4902i.setEnabled(false);
        }
    }

    private void m8643c(int i) {
        if (this.f4897d < this.f4894a - 1) {
            for (int i2 = this.f4897d; i2 >= 0; i2--) {
                this.f4896c[i2 + 1] = this.f4896c[i2];
            }
            this.f4897d++;
            this.f4896c[0] = i;
        }
        if (this.f4904k.getCurrentItem() < 2) {
            this.f4904k.m3222a(this.f4904k.getCurrentItem() + 1, true);
        }
    }

    private void m8647g() {
        for (int i = 0; i < this.f4899f.length; i++) {
            if (this.f4899f[i] != null) {
                this.f4899f[i].setEnabled(true);
            }
        }
    }

    private void m8648h() {
        if (this.f4897d == 1) {
            setYearMinKeyRange((this.f4898e % 100) / 10);
        } else if (this.f4897d == 2) {
            setYearMinKeyRange(Math.max(0, (this.f4898e % 100) - (this.f4896c[0] * 10)));
        } else if (this.f4897d == 3) {
            setYearKeyRange(-1);
        }
    }

    private void setYearKeyRange(int i) {
        for (int i2 = 0; i2 < this.f4900g.length; i2++) {
            if (this.f4900g[i2] != null) {
                boolean z;
                Button button = this.f4900g[i2];
                if (i2 <= i) {
                    z = true;
                } else {
                    z = false;
                }
                button.setEnabled(z);
            }
        }
    }

    private void setYearMinKeyRange(int i) {
        for (int i2 = 0; i2 < this.f4900g.length; i2++) {
            if (this.f4900g[i2] != null) {
                boolean z;
                Button button = this.f4900g[i2];
                if (i2 >= i) {
                    z = true;
                } else {
                    z = false;
                }
                button.setEnabled(z);
            }
        }
    }

    private void m8649i() {
        if (this.f4912u != null) {
            Button button = this.f4912u;
            boolean z = getYear() >= this.f4898e && getMonthOfYear() > 0;
            button.setEnabled(z);
        }
    }

    public void setSetButton(Button button) {
        this.f4912u = button;
        m8649i();
    }

    public int getYear() {
        return (((this.f4896c[3] * 1000) + (this.f4896c[2] * 100)) + (this.f4896c[1] * 10)) + this.f4896c[0];
    }

    public int getMonthOfYear() {
        return this.f4895b;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4886c = this.f4895b;
        savedState.f4885b = this.f4896c;
        savedState.f4884a = this.f4897d;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f4897d = savedState.f4884a;
            this.f4896c = savedState.f4885b;
            if (this.f4896c == null) {
                this.f4896c = new int[this.f4894a];
                this.f4897d = -1;
            }
            this.f4895b = savedState.f4886c;
            m8646f();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
