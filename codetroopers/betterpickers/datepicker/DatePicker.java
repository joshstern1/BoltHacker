package com.codetroopers.betterpickers.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
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
import android.widget.TextView;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1286c;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1288e;
import com.codetroopers.betterpickers.C1292c.C1289f;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.widget.UnderlinePageIndicatorPicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DatePicker extends LinearLayout implements OnClickListener, OnLongClickListener {
    private static int f4841x = -1;
    private static int f4842y = -1;
    private static int f4843z = -1;
    private Button f4844A;
    private boolean f4845B;
    private ColorStateList f4846C;
    private int f4847D;
    private int f4848E;
    private int f4849F;
    private int f4850G;
    private int f4851H;
    private int f4852I;
    private int f4853J;
    protected int f4854a;
    protected int f4855b;
    protected int f4856c;
    protected int[] f4857d;
    protected int[] f4858e;
    protected int f4859f;
    protected int f4860g;
    protected final Button[] f4861h;
    protected final Button[] f4862i;
    protected final Button[] f4863j;
    protected Button f4864k;
    protected Button f4865l;
    protected Button f4866m;
    protected ImageButton f4867n;
    protected UnderlinePageIndicatorPicker f4868o;
    protected ViewPager f4869p;
    protected C1315a f4870q;
    protected ImageButton f4871r;
    protected DateView f4872s;
    protected String[] f4873t;
    protected final Context f4874u;
    protected View f4875v;
    private char[] f4876w;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C1318b();
        int f4834a;
        int f4835b;
        int[] f4836c;
        int[] f4837d;
        int f4838e;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4834a = parcel.readInt();
            this.f4835b = parcel.readInt();
            parcel.readIntArray(this.f4836c);
            parcel.readIntArray(this.f4837d);
            this.f4838e = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4834a);
            parcel.writeInt(this.f4835b);
            parcel.writeIntArray(this.f4836c);
            parcel.writeIntArray(this.f4837d);
            parcel.writeInt(this.f4838e);
        }
    }

    private class C1315a extends aj {
        final /* synthetic */ DatePicker f4839a;
        private LayoutInflater f4840b;

        public C1315a(DatePicker datePicker, LayoutInflater layoutInflater) {
            this.f4839a = datePicker;
            this.f4840b = layoutInflater;
        }

        public Object mo300a(ViewGroup viewGroup, int i) {
            View view;
            Resources resources = this.f4839a.f4874u.getResources();
            View inflate;
            View findViewById;
            View findViewById2;
            View findViewById3;
            View findViewById4;
            int i2;
            if (this.f4839a.f4876w[i] == 'M') {
                DatePicker.f4841x = i;
                inflate = this.f4840b.inflate(C1288e.keyboard_text_with_header, null);
                findViewById = inflate.findViewById(C1287d.first);
                findViewById2 = inflate.findViewById(C1287d.second);
                findViewById3 = inflate.findViewById(C1287d.third);
                findViewById4 = inflate.findViewById(C1287d.fourth);
                ((TextView) inflate.findViewById(C1287d.header)).setText(C1289f.month_c);
                this.f4839a.f4861h[0] = (Button) findViewById.findViewById(C1287d.key_left);
                this.f4839a.f4861h[1] = (Button) findViewById.findViewById(C1287d.key_middle);
                this.f4839a.f4861h[2] = (Button) findViewById.findViewById(C1287d.key_right);
                this.f4839a.f4861h[3] = (Button) findViewById2.findViewById(C1287d.key_left);
                this.f4839a.f4861h[4] = (Button) findViewById2.findViewById(C1287d.key_middle);
                this.f4839a.f4861h[5] = (Button) findViewById2.findViewById(C1287d.key_right);
                this.f4839a.f4861h[6] = (Button) findViewById3.findViewById(C1287d.key_left);
                this.f4839a.f4861h[7] = (Button) findViewById3.findViewById(C1287d.key_middle);
                this.f4839a.f4861h[8] = (Button) findViewById3.findViewById(C1287d.key_right);
                this.f4839a.f4861h[9] = (Button) findViewById4.findViewById(C1287d.key_left);
                this.f4839a.f4861h[10] = (Button) findViewById4.findViewById(C1287d.key_middle);
                this.f4839a.f4861h[11] = (Button) findViewById4.findViewById(C1287d.key_right);
                for (i2 = 0; i2 < 12; i2++) {
                    this.f4839a.f4861h[i2].setOnClickListener(this.f4839a);
                    this.f4839a.f4861h[i2].setText(this.f4839a.f4873t[i2]);
                    this.f4839a.f4861h[i2].setTextColor(this.f4839a.f4846C);
                    this.f4839a.f4861h[i2].setBackgroundResource(this.f4839a.f4847D);
                    this.f4839a.f4861h[i2].setTag(C1287d.date_keyboard, "month");
                    this.f4839a.f4861h[i2].setTag(C1287d.date_month_int, Integer.valueOf(i2));
                }
                view = inflate;
            } else if (this.f4839a.f4876w[i] == 'd') {
                DatePicker.f4842y = i;
                inflate = this.f4840b.inflate(C1288e.keyboard_right_drawable_with_header, null);
                findViewById2 = inflate.findViewById(C1287d.first);
                findViewById3 = inflate.findViewById(C1287d.second);
                findViewById4 = inflate.findViewById(C1287d.third);
                View findViewById5 = inflate.findViewById(C1287d.fourth);
                ((TextView) inflate.findViewById(C1287d.header)).setText(C1289f.day_c);
                this.f4839a.f4862i[1] = (Button) findViewById2.findViewById(C1287d.key_left);
                this.f4839a.f4862i[2] = (Button) findViewById2.findViewById(C1287d.key_middle);
                this.f4839a.f4862i[3] = (Button) findViewById2.findViewById(C1287d.key_right);
                this.f4839a.f4862i[4] = (Button) findViewById3.findViewById(C1287d.key_left);
                this.f4839a.f4862i[5] = (Button) findViewById3.findViewById(C1287d.key_middle);
                this.f4839a.f4862i[6] = (Button) findViewById3.findViewById(C1287d.key_right);
                this.f4839a.f4862i[7] = (Button) findViewById4.findViewById(C1287d.key_left);
                this.f4839a.f4862i[8] = (Button) findViewById4.findViewById(C1287d.key_middle);
                this.f4839a.f4862i[9] = (Button) findViewById4.findViewById(C1287d.key_right);
                this.f4839a.f4864k = (Button) findViewById5.findViewById(C1287d.key_left);
                this.f4839a.f4864k.setTextColor(this.f4839a.f4846C);
                this.f4839a.f4864k.setBackgroundResource(this.f4839a.f4847D);
                this.f4839a.f4862i[0] = (Button) findViewById5.findViewById(C1287d.key_middle);
                this.f4839a.f4867n = (ImageButton) findViewById5.findViewById(C1287d.key_right);
                for (i2 = 0; i2 < 10; i2++) {
                    this.f4839a.f4862i[i2].setOnClickListener(this.f4839a);
                    this.f4839a.f4862i[i2].setText(String.format("%d", new Object[]{Integer.valueOf(i2)}));
                    this.f4839a.f4862i[i2].setTextColor(this.f4839a.f4846C);
                    this.f4839a.f4862i[i2].setBackgroundResource(this.f4839a.f4847D);
                    this.f4839a.f4862i[i2].setTag(C1287d.date_keyboard, "date");
                    this.f4839a.f4862i[i2].setTag(C1287d.numbers_key, Integer.valueOf(i2));
                }
                this.f4839a.f4867n.setImageDrawable(resources.getDrawable(this.f4839a.f4851H));
                this.f4839a.f4867n.setBackgroundResource(this.f4839a.f4847D);
                this.f4839a.f4867n.setOnClickListener(this.f4839a);
                view = inflate;
            } else if (this.f4839a.f4876w[i] == 'y') {
                DatePicker.f4843z = i;
                inflate = this.f4840b.inflate(C1288e.keyboard_with_header, null);
                findViewById = inflate.findViewById(C1287d.first);
                findViewById2 = inflate.findViewById(C1287d.second);
                findViewById3 = inflate.findViewById(C1287d.third);
                findViewById4 = inflate.findViewById(C1287d.fourth);
                ((TextView) inflate.findViewById(C1287d.header)).setText(C1289f.year_c);
                this.f4839a.f4863j[1] = (Button) findViewById.findViewById(C1287d.key_left);
                this.f4839a.f4863j[2] = (Button) findViewById.findViewById(C1287d.key_middle);
                this.f4839a.f4863j[3] = (Button) findViewById.findViewById(C1287d.key_right);
                this.f4839a.f4863j[4] = (Button) findViewById2.findViewById(C1287d.key_left);
                this.f4839a.f4863j[5] = (Button) findViewById2.findViewById(C1287d.key_middle);
                this.f4839a.f4863j[6] = (Button) findViewById2.findViewById(C1287d.key_right);
                this.f4839a.f4863j[7] = (Button) findViewById3.findViewById(C1287d.key_left);
                this.f4839a.f4863j[8] = (Button) findViewById3.findViewById(C1287d.key_middle);
                this.f4839a.f4863j[9] = (Button) findViewById3.findViewById(C1287d.key_right);
                this.f4839a.f4865l = (Button) findViewById4.findViewById(C1287d.key_left);
                this.f4839a.f4865l.setTextColor(this.f4839a.f4846C);
                this.f4839a.f4865l.setBackgroundResource(this.f4839a.f4847D);
                this.f4839a.f4863j[0] = (Button) findViewById4.findViewById(C1287d.key_middle);
                this.f4839a.f4866m = (Button) findViewById4.findViewById(C1287d.key_right);
                this.f4839a.f4866m.setTextColor(this.f4839a.f4846C);
                this.f4839a.f4866m.setBackgroundResource(this.f4839a.f4847D);
                for (i2 = 0; i2 < 10; i2++) {
                    this.f4839a.f4863j[i2].setOnClickListener(this.f4839a);
                    this.f4839a.f4863j[i2].setText(String.format("%d", new Object[]{Integer.valueOf(i2)}));
                    this.f4839a.f4863j[i2].setTextColor(this.f4839a.f4846C);
                    this.f4839a.f4863j[i2].setBackgroundResource(this.f4839a.f4847D);
                    this.f4839a.f4863j[i2].setTag(C1287d.date_keyboard, "year");
                    this.f4839a.f4863j[i2].setTag(C1287d.numbers_key, Integer.valueOf(i2));
                }
                view = inflate;
            } else {
                view = new View(this.f4839a.f4874u);
            }
            this.f4839a.m8628d();
            this.f4839a.m8627c();
            this.f4839a.m8616g();
            viewGroup.addView(view, 0);
            return view;
        }

        public void mo303a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int mo1273b() {
            return 3;
        }

        public boolean mo304a(View view, Object obj) {
            return view == obj;
        }
    }

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4854a = 2;
        this.f4855b = 4;
        this.f4856c = -1;
        this.f4857d = new int[this.f4854a];
        this.f4858e = new int[this.f4855b];
        this.f4859f = -1;
        this.f4860g = -1;
        this.f4861h = new Button[12];
        this.f4862i = new Button[10];
        this.f4863j = new Button[10];
        this.f4845B = false;
        this.f4853J = -1;
        this.f4874u = context;
        this.f4876w = DateFormat.getDateFormatOrder(this.f4874u);
        this.f4873t = m8614e();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutId(), this);
        this.f4846C = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
        this.f4847D = C1286c.key_background_dark;
        this.f4848E = C1286c.button_background_dark;
        this.f4849F = getResources().getColor(C1284a.default_divider_color_dark);
        this.f4850G = getResources().getColor(C1284a.default_keyboard_indicator_color_dark);
        this.f4852I = C1286c.ic_backspace_dark;
        this.f4851H = C1286c.ic_check_dark;
    }

    protected int getLayoutId() {
        return C1288e.date_picker_view;
    }

    public void setTheme(int i) {
        this.f4853J = i;
        if (this.f4853J != -1) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment);
            this.f4846C = obtainStyledAttributes.getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
            this.f4847D = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpKeyBackground, this.f4847D);
            this.f4848E = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpButtonBackground, this.f4848E);
            this.f4851H = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpCheckIcon, this.f4851H);
            this.f4849F = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpTitleDividerColor, this.f4849F);
            this.f4850G = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpKeyboardIndicatorColor, this.f4850G);
            this.f4852I = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpDeleteIcon, this.f4852I);
        }
        m8615f();
    }

    private void m8615f() {
        int i = 0;
        for (Button button : this.f4861h) {
            if (button != null) {
                button.setTextColor(this.f4846C);
                button.setBackgroundResource(this.f4847D);
            }
        }
        for (Button button2 : this.f4862i) {
            if (button2 != null) {
                button2.setTextColor(this.f4846C);
                button2.setBackgroundResource(this.f4847D);
            }
        }
        Button[] buttonArr = this.f4863j;
        int length = buttonArr.length;
        while (i < length) {
            Button button3 = buttonArr[i];
            if (button3 != null) {
                button3.setTextColor(this.f4846C);
                button3.setBackgroundResource(this.f4847D);
            }
            i++;
        }
        if (this.f4868o != null) {
            this.f4868o.setSelectedColor(this.f4850G);
        }
        if (this.f4875v != null) {
            this.f4875v.setBackgroundColor(this.f4849F);
        }
        if (this.f4864k != null) {
            this.f4864k.setTextColor(this.f4846C);
            this.f4864k.setBackgroundResource(this.f4847D);
        }
        if (this.f4867n != null) {
            this.f4867n.setBackgroundResource(this.f4847D);
            this.f4867n.setImageDrawable(getResources().getDrawable(this.f4851H));
        }
        if (this.f4871r != null) {
            this.f4871r.setBackgroundResource(this.f4848E);
            this.f4871r.setImageDrawable(getResources().getDrawable(this.f4852I));
        }
        if (this.f4865l != null) {
            this.f4865l.setTextColor(this.f4846C);
            this.f4865l.setBackgroundResource(this.f4847D);
        }
        if (this.f4866m != null) {
            this.f4866m.setTextColor(this.f4846C);
            this.f4866m.setBackgroundResource(this.f4847D);
        }
        if (this.f4872s != null) {
            this.f4872s.setTheme(this.f4853J);
        }
    }

    protected void onFinishInflate() {
        int i;
        super.onFinishInflate();
        this.f4875v = findViewById(C1287d.divider);
        for (i = 0; i < this.f4857d.length; i++) {
            this.f4857d[i] = 0;
        }
        for (i = 0; i < this.f4858e.length; i++) {
            this.f4858e[i] = 0;
        }
        this.f4868o = (UnderlinePageIndicatorPicker) findViewById(C1287d.keyboard_indicator);
        this.f4869p = (ViewPager) findViewById(C1287d.keyboard_pager);
        this.f4869p.setOffscreenPageLimit(2);
        this.f4870q = new C1315a(this, (LayoutInflater) this.f4874u.getSystemService("layout_inflater"));
        this.f4869p.setAdapter(this.f4870q);
        this.f4868o.setViewPager(this.f4869p);
        this.f4869p.setCurrentItem(0);
        this.f4872s = (DateView) findViewById(C1287d.date_text);
        this.f4872s.setTheme(this.f4853J);
        this.f4872s.setUnderlinePage(this.f4868o);
        this.f4872s.setOnClick(this);
        this.f4871r = (ImageButton) findViewById(C1287d.delete);
        this.f4871r.setOnClickListener(this);
        this.f4871r.setOnLongClickListener(this);
        m8628d();
        m8627c();
        m8616g();
    }

    public void m8624a() {
        boolean z = (this.f4856c == -1 && this.f4859f == -1 && this.f4860g == -1) ? false : true;
        if (this.f4871r != null) {
            this.f4871r.setEnabled(z);
        }
    }

    public void onClick(View view) {
        view.performHapticFeedback(1);
        m8625a(view);
        m8624a();
    }

    protected void m8625a(View view) {
        if (view == this.f4871r) {
            int i;
            switch (this.f4876w[this.f4869p.getCurrentItem()]) {
                case 'M':
                    if (this.f4856c != -1) {
                        this.f4856c = -1;
                        break;
                    }
                    break;
                case 'd':
                    if (this.f4859f < 0) {
                        if (this.f4869p.getCurrentItem() > 0) {
                            this.f4869p.m3222a(this.f4869p.getCurrentItem() - 1, true);
                            break;
                        }
                    }
                    for (i = 0; i < this.f4859f; i++) {
                        this.f4857d[i] = this.f4857d[i + 1];
                    }
                    this.f4857d[this.f4859f] = 0;
                    this.f4859f--;
                    break;
                    break;
                case 'y':
                    if (this.f4860g < 0) {
                        if (this.f4869p.getCurrentItem() > 0) {
                            this.f4869p.m3222a(this.f4869p.getCurrentItem() - 1, true);
                            break;
                        }
                    }
                    for (i = 0; i < this.f4860g; i++) {
                        this.f4858e[i] = this.f4858e[i + 1];
                    }
                    this.f4858e[this.f4860g] = 0;
                    this.f4860g--;
                    break;
                    break;
            }
        } else if (view == this.f4867n) {
            m8617h();
        } else if (view == this.f4872s.getDate()) {
            this.f4869p.setCurrentItem(f4842y);
        } else if (view == this.f4872s.getMonth()) {
            this.f4869p.setCurrentItem(f4841x);
        } else if (view == this.f4872s.getYear()) {
            this.f4869p.setCurrentItem(f4843z);
        } else if (view.getTag(C1287d.date_keyboard).equals("month")) {
            this.f4856c = ((Integer) view.getTag(C1287d.date_month_int)).intValue();
            if (this.f4869p.getCurrentItem() < 2) {
                this.f4869p.m3222a(this.f4869p.getCurrentItem() + 1, true);
            }
        } else if (view.getTag(C1287d.date_keyboard).equals("date")) {
            m8611d(((Integer) view.getTag(C1287d.numbers_key)).intValue());
        } else if (view.getTag(C1287d.date_keyboard).equals("year")) {
            m8612e(((Integer) view.getTag(C1287d.numbers_key)).intValue());
        }
        m8616g();
    }

    public boolean onLongClick(View view) {
        view.performHapticFeedback(0);
        if (view != this.f4871r) {
            return false;
        }
        this.f4871r.setPressed(false);
        m8626b();
        m8616g();
        return true;
    }

    private void m8616g() {
        m8622m();
        m8627c();
        m8623n();
        m8624a();
        m8618i();
        m8619j();
        m8620k();
    }

    public void m8626b() {
        int i;
        for (i = 0; i < this.f4854a; i++) {
            this.f4857d[i] = 0;
        }
        for (i = 0; i < this.f4855b; i++) {
            this.f4858e[i] = 0;
        }
        this.f4859f = -1;
        this.f4860g = -1;
        this.f4856c = -1;
        this.f4869p.m3222a(0, true);
        m8627c();
    }

    protected void m8627c() {
        String str;
        if (this.f4856c < 0) {
            str = "";
        } else {
            str = this.f4873t[this.f4856c];
        }
        this.f4872s.m8632a(str, getDayOfMonth(), getYear());
    }

    protected void m8628d() {
        if (this.f4864k != null) {
            this.f4864k.setEnabled(false);
        }
        if (this.f4867n != null) {
            this.f4867n.setEnabled(m8621l());
        }
        if (this.f4865l != null) {
            this.f4865l.setEnabled(false);
        }
        if (this.f4866m != null) {
            this.f4866m.setEnabled(false);
        }
    }

    private void m8611d(int i) {
        if (this.f4859f < this.f4854a - 1) {
            for (int i2 = this.f4859f; i2 >= 0; i2--) {
                this.f4857d[i2 + 1] = this.f4857d[i2];
            }
            this.f4859f++;
            this.f4857d[0] = i;
        }
        if ((getDayOfMonth() >= 4 || (getMonthOfYear() == 1 && getDayOfMonth() >= 3)) && this.f4869p.getCurrentItem() < 2) {
            this.f4869p.m3222a(this.f4869p.getCurrentItem() + 1, true);
        }
    }

    private void m8612e(int i) {
        if (this.f4860g < this.f4855b - 1) {
            for (int i2 = this.f4860g; i2 >= 0; i2--) {
                this.f4858e[i2 + 1] = this.f4858e[i2];
            }
            this.f4860g++;
            this.f4858e[0] = i;
        }
        if (getYear() >= 1000 && this.f4869p.getCurrentItem() < 2) {
            this.f4869p.m3222a(this.f4869p.getCurrentItem() + 1, true);
        }
    }

    private void m8617h() {
        if (this.f4869p.getCurrentItem() < 2) {
            this.f4869p.m3222a(this.f4869p.getCurrentItem() + 1, true);
        }
    }

    private void m8618i() {
        int dayOfMonth = getDayOfMonth();
        for (int i = 0; i < this.f4861h.length; i++) {
            if (this.f4861h[i] != null) {
                this.f4861h[i].setEnabled(true);
            }
        }
        if (dayOfMonth > 29 && this.f4861h[1] != null) {
            this.f4861h[1].setEnabled(false);
        }
        if (dayOfMonth > 30) {
            if (this.f4861h[3] != null) {
                this.f4861h[3].setEnabled(false);
            }
            if (this.f4861h[5] != null) {
                this.f4861h[5].setEnabled(false);
            }
            if (this.f4861h[8] != null) {
                this.f4861h[8].setEnabled(false);
            }
            if (this.f4861h[10] != null) {
                this.f4861h[10].setEnabled(false);
            }
        }
    }

    private void m8619j() {
        int dayOfMonth = getDayOfMonth();
        if (dayOfMonth >= 4) {
            setDateKeyRange(-1);
        } else if (dayOfMonth >= 3) {
            if (this.f4856c == 1) {
                setDateKeyRange(-1);
            } else if (this.f4856c == 3 || this.f4856c == 5 || this.f4856c == 8 || this.f4856c == 10) {
                setDateKeyRange(0);
            } else {
                setDateKeyRange(1);
            }
        } else if (dayOfMonth >= 2) {
            setDateKeyRange(9);
        } else if (dayOfMonth >= 1) {
            setDateKeyRange(9);
        } else {
            setDateMinKeyRange(1);
        }
    }

    private void m8620k() {
        int year = getYear();
        if (year >= 1000) {
            setYearKeyRange(-1);
        } else if (year >= 1) {
            setYearKeyRange(9);
        } else {
            setYearMinKeyRange(1);
        }
    }

    private void setDateKeyRange(int i) {
        for (int i2 = 0; i2 < this.f4862i.length; i2++) {
            if (this.f4862i[i2] != null) {
                boolean z;
                Button button = this.f4862i[i2];
                if (i2 <= i) {
                    z = true;
                } else {
                    z = false;
                }
                button.setEnabled(z);
            }
        }
    }

    private void setDateMinKeyRange(int i) {
        for (int i2 = 0; i2 < this.f4862i.length; i2++) {
            if (this.f4862i[i2] != null) {
                boolean z;
                Button button = this.f4862i[i2];
                if (i2 >= i) {
                    z = true;
                } else {
                    z = false;
                }
                button.setEnabled(z);
            }
        }
    }

    private void setYearKeyRange(int i) {
        for (int i2 = 0; i2 < this.f4863j.length; i2++) {
            if (this.f4863j[i2] != null) {
                boolean z;
                Button button = this.f4863j[i2];
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
        for (int i2 = 0; i2 < this.f4863j.length; i2++) {
            if (this.f4863j[i2] != null) {
                boolean z;
                Button button = this.f4863j[i2];
                if (i2 >= i) {
                    z = true;
                } else {
                    z = false;
                }
                button.setEnabled(z);
            }
        }
    }

    private boolean m8621l() {
        return getDayOfMonth() > 0;
    }

    private void m8622m() {
        if (this.f4867n != null) {
            this.f4867n.setEnabled(m8621l());
        }
    }

    private void m8623n() {
        if (this.f4844A != null) {
            Button button = this.f4844A;
            boolean z = getDayOfMonth() > 0 && ((this.f4845B || getYear() > 0) && getMonthOfYear() >= 0);
            button.setEnabled(z);
        }
    }

    public void setSetButton(Button button) {
        this.f4844A = button;
        m8623n();
    }

    public int getYear() {
        return (((this.f4858e[3] * 1000) + (this.f4858e[2] * 100)) + (this.f4858e[1] * 10)) + this.f4858e[0];
    }

    public int getMonthOfYear() {
        return this.f4856c;
    }

    public int getDayOfMonth() {
        return (this.f4857d[1] * 10) + this.f4857d[0];
    }

    public void setYearOptional(boolean z) {
        this.f4845B = z;
    }

    public static String[] m8614e() {
        return m8605a(Locale.getDefault());
    }

    public static String[] m8605a(Locale locale) {
        Calendar gregorianCalendar;
        int i = 0;
        int i2 = locale != null ? 1 : 0;
        SimpleDateFormat simpleDateFormat = i2 != 0 ? new SimpleDateFormat("MMM", locale) : new SimpleDateFormat("MMM");
        if (i2 != 0) {
            gregorianCalendar = new GregorianCalendar(locale);
        } else {
            gregorianCalendar = new GregorianCalendar();
        }
        gregorianCalendar.set(1, 0);
        gregorianCalendar.set(5, 1);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        String[] strArr = new String[12];
        while (i < strArr.length) {
            gregorianCalendar.set(2, i);
            strArr[i] = simpleDateFormat.format(gregorianCalendar.getTime()).toUpperCase();
            i++;
        }
        return strArr;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4838e = this.f4856c;
        savedState.f4836c = this.f4857d;
        savedState.f4834a = this.f4859f;
        savedState.f4837d = this.f4858e;
        savedState.f4835b = this.f4860g;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f4859f = savedState.f4834a;
            this.f4860g = savedState.f4835b;
            this.f4857d = savedState.f4836c;
            this.f4858e = savedState.f4837d;
            if (this.f4857d == null) {
                this.f4857d = new int[this.f4854a];
                this.f4859f = -1;
            }
            if (this.f4858e == null) {
                this.f4858e = new int[this.f4855b];
                this.f4860g = -1;
            }
            this.f4856c = savedState.f4838e;
            m8616g();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
