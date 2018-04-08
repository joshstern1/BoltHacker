package com.codetroopers.betterpickers.hmspicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1286c;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1288e;
import com.codetroopers.betterpickers.C1292c.C1291h;

public class HmsPicker extends LinearLayout implements OnClickListener, OnLongClickListener {
    protected int f4928a;
    protected final Button[] f4929b;
    protected int[] f4930c;
    protected int f4931d;
    protected ImageButton f4932e;
    protected Button f4933f;
    protected Button f4934g;
    protected HmsView f4935h;
    protected final Context f4936i;
    protected View f4937j;
    private TextView f4938k;
    private TextView f4939l;
    private TextView f4940m;
    private Button f4941n;
    private ColorStateList f4942o;
    private int f4943p;
    private int f4944q;
    private int f4945r;
    private int f4946s;
    private int f4947t;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C1323b();
        int f4925a;
        int[] f4926b;
        int f4927c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4925a = parcel.readInt();
            this.f4926b = parcel.createIntArray();
            this.f4927c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4925a);
            parcel.writeIntArray(this.f4926b);
            parcel.writeInt(this.f4927c);
        }
    }

    public HmsPicker(Context context) {
        this(context, null);
    }

    public HmsPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4928a = 5;
        this.f4929b = new Button[10];
        this.f4930c = new int[this.f4928a];
        this.f4931d = -1;
        this.f4947t = -1;
        this.f4936i = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutId(), this);
        this.f4942o = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
        this.f4943p = C1286c.key_background_dark;
        this.f4944q = C1286c.button_background_dark;
        this.f4945r = getResources().getColor(C1284a.default_divider_color_dark);
        this.f4946s = C1286c.ic_backspace_dark;
    }

    protected int getLayoutId() {
        return C1288e.hms_picker_view;
    }

    public void setTheme(int i) {
        this.f4947t = i;
        if (this.f4947t != -1) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment);
            this.f4942o = obtainStyledAttributes.getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
            this.f4943p = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpKeyBackground, this.f4943p);
            this.f4944q = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpButtonBackground, this.f4944q);
            this.f4945r = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpDividerColor, this.f4945r);
            this.f4946s = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpDeleteIcon, this.f4946s);
        }
        m8661d();
    }

    private void m8661d() {
        for (Button button : this.f4929b) {
            if (button != null) {
                button.setTextColor(this.f4942o);
                button.setBackgroundResource(this.f4943p);
            }
        }
        if (this.f4937j != null) {
            this.f4937j.setBackgroundColor(this.f4945r);
        }
        if (this.f4938k != null) {
            this.f4938k.setTextColor(this.f4942o);
            this.f4938k.setBackgroundResource(this.f4943p);
        }
        if (this.f4939l != null) {
            this.f4939l.setTextColor(this.f4942o);
            this.f4939l.setBackgroundResource(this.f4943p);
        }
        if (this.f4940m != null) {
            this.f4940m.setTextColor(this.f4942o);
            this.f4940m.setBackgroundResource(this.f4943p);
        }
        if (this.f4932e != null) {
            this.f4932e.setBackgroundResource(this.f4944q);
            this.f4932e.setImageDrawable(getResources().getDrawable(this.f4946s));
        }
        if (this.f4935h != null) {
            this.f4935h.setTheme(this.f4947t);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(C1287d.first);
        View findViewById2 = findViewById(C1287d.second);
        View findViewById3 = findViewById(C1287d.third);
        View findViewById4 = findViewById(C1287d.fourth);
        this.f4935h = (HmsView) findViewById(C1287d.hms_text);
        this.f4932e = (ImageButton) findViewById(C1287d.delete);
        this.f4932e.setOnClickListener(this);
        this.f4932e.setOnLongClickListener(this);
        this.f4929b[1] = (Button) findViewById.findViewById(C1287d.key_left);
        this.f4929b[2] = (Button) findViewById.findViewById(C1287d.key_middle);
        this.f4929b[3] = (Button) findViewById.findViewById(C1287d.key_right);
        this.f4929b[4] = (Button) findViewById2.findViewById(C1287d.key_left);
        this.f4929b[5] = (Button) findViewById2.findViewById(C1287d.key_middle);
        this.f4929b[6] = (Button) findViewById2.findViewById(C1287d.key_right);
        this.f4929b[7] = (Button) findViewById3.findViewById(C1287d.key_left);
        this.f4929b[8] = (Button) findViewById3.findViewById(C1287d.key_middle);
        this.f4929b[9] = (Button) findViewById3.findViewById(C1287d.key_right);
        this.f4933f = (Button) findViewById4.findViewById(C1287d.key_left);
        this.f4929b[0] = (Button) findViewById4.findViewById(C1287d.key_middle);
        this.f4934g = (Button) findViewById4.findViewById(C1287d.key_right);
        setLeftRightEnabled(false);
        for (int i = 0; i < 10; i++) {
            this.f4929b[i].setOnClickListener(this);
            this.f4929b[i].setText(String.format("%d", new Object[]{Integer.valueOf(i)}));
            this.f4929b[i].setTag(C1287d.numbers_key, new Integer(i));
        }
        m8667c();
        this.f4938k = (TextView) findViewById(C1287d.hours_label);
        this.f4939l = (TextView) findViewById(C1287d.minutes_label);
        this.f4940m = (TextView) findViewById(C1287d.seconds_label);
        this.f4937j = findViewById(C1287d.divider);
        m8661d();
        m8662e();
    }

    public void m8664a() {
        boolean z = this.f4931d != -1;
        if (this.f4932e != null) {
            this.f4932e.setEnabled(z);
        }
    }

    public void onClick(View view) {
        view.performHapticFeedback(1);
        m8665a(view);
        m8664a();
    }

    protected void m8665a(View view) {
        Integer num = (Integer) view.getTag(C1287d.numbers_key);
        if (num != null) {
            m8660a(num.intValue());
        } else if (view == this.f4932e && this.f4931d >= 0) {
            for (int i = 0; i < this.f4931d; i++) {
                this.f4930c[i] = this.f4930c[i + 1];
            }
            this.f4930c[this.f4931d] = 0;
            this.f4931d--;
        }
        m8662e();
    }

    public boolean onLongClick(View view) {
        view.performHapticFeedback(0);
        if (view != this.f4932e) {
            return false;
        }
        this.f4932e.setPressed(false);
        m8666b();
        m8662e();
        return true;
    }

    public void m8666b() {
        for (int i = 0; i < this.f4928a; i++) {
            this.f4930c[i] = 0;
        }
        this.f4931d = -1;
        m8667c();
    }

    private void m8662e() {
        m8667c();
        m8663f();
        m8664a();
    }

    protected void m8667c() {
        this.f4935h.m8669a(this.f4930c[4], this.f4930c[3], this.f4930c[2], this.f4930c[1], this.f4930c[0]);
    }

    private void m8660a(int i) {
        if (this.f4931d < this.f4928a - 1) {
            for (int i2 = this.f4931d; i2 >= 0; i2--) {
                this.f4930c[i2 + 1] = this.f4930c[i2];
            }
            this.f4931d++;
            this.f4930c[0] = i;
        }
    }

    private void m8663f() {
        boolean z = false;
        if (this.f4941n != null) {
            if (this.f4931d == -1) {
                this.f4941n.setEnabled(false);
                return;
            }
            Button button = this.f4941n;
            if (this.f4931d >= 0) {
                z = true;
            }
            button.setEnabled(z);
        }
    }

    public void setSetButton(Button button) {
        this.f4941n = button;
        m8663f();
    }

    public int getHours() {
        return this.f4930c[4];
    }

    public int getMinutes() {
        return (this.f4930c[3] * 10) + this.f4930c[2];
    }

    public int getSeconds() {
        return (this.f4930c[1] * 10) + this.f4930c[0];
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4926b = this.f4930c;
        savedState.f4925a = this.f4931d;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f4931d = savedState.f4925a;
            this.f4930c = savedState.f4926b;
            if (this.f4930c == null) {
                this.f4930c = new int[this.f4928a];
                this.f4931d = -1;
            }
            m8662e();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public int getTime() {
        return ((((this.f4930c[4] * 3600) + (this.f4930c[3] * 600)) + (this.f4930c[2] * 60)) + (this.f4930c[1] * 10)) + this.f4930c[0];
    }

    protected void setLeftRightEnabled(boolean z) {
        this.f4933f.setEnabled(z);
        this.f4934g.setEnabled(z);
        if (!z) {
            this.f4933f.setContentDescription(null);
            this.f4934g.setContentDescription(null);
        }
    }
}
