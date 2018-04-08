package com.codetroopers.betterpickers.numberpicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
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
import com.codetroopers.betterpickers.C1292c.C1289f;
import com.codetroopers.betterpickers.C1292c.C1291h;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberPicker extends LinearLayout implements OnClickListener, OnLongClickListener {
    protected int f4959a;
    protected final Button[] f4960b;
    protected int[] f4961c;
    protected int f4962d;
    protected Button f4963e;
    protected Button f4964f;
    protected ImageButton f4965g;
    protected NumberView f4966h;
    protected final Context f4967i;
    protected View f4968j;
    private TextView f4969k;
    private NumberPickerErrorTextView f4970l;
    private int f4971m;
    private String f4972n;
    private Button f4973o;
    private ColorStateList f4974p;
    private int f4975q;
    private int f4976r;
    private int f4977s;
    private int f4978t;
    private int f4979u;
    private Integer f4980v;
    private Integer f4981w;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C1325b();
        int f4956a;
        int[] f4957b;
        int f4958c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4956a = parcel.readInt();
            parcel.readIntArray(this.f4957b);
            this.f4958c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4956a);
            parcel.writeIntArray(this.f4957b);
            parcel.writeInt(this.f4958c);
        }
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4959a = 20;
        this.f4960b = new Button[10];
        this.f4961c = new int[this.f4959a];
        this.f4962d = -1;
        this.f4972n = "";
        this.f4979u = -1;
        this.f4980v = null;
        this.f4981w = null;
        this.f4967i = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutId(), this);
        this.f4974p = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
        this.f4975q = C1286c.key_background_dark;
        this.f4976r = C1286c.button_background_dark;
        this.f4978t = C1286c.ic_backspace_dark;
        this.f4977s = getResources().getColor(C1284a.default_divider_color_dark);
    }

    protected int getLayoutId() {
        return C1288e.number_picker_view;
    }

    public void setTheme(int i) {
        this.f4979u = i;
        if (this.f4979u != -1) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment);
            this.f4974p = obtainStyledAttributes.getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
            this.f4975q = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpKeyBackground, this.f4975q);
            this.f4976r = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpButtonBackground, this.f4976r);
            this.f4977s = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpDividerColor, this.f4977s);
            this.f4978t = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpDeleteIcon, this.f4978t);
        }
        m8674e();
    }

    private void m8674e() {
        for (Button button : this.f4960b) {
            if (button != null) {
                button.setTextColor(this.f4974p);
                button.setBackgroundResource(this.f4975q);
            }
        }
        if (this.f4968j != null) {
            this.f4968j.setBackgroundColor(this.f4977s);
        }
        if (this.f4963e != null) {
            this.f4963e.setTextColor(this.f4974p);
            this.f4963e.setBackgroundResource(this.f4975q);
        }
        if (this.f4964f != null) {
            this.f4964f.setTextColor(this.f4974p);
            this.f4964f.setBackgroundResource(this.f4975q);
        }
        if (this.f4965g != null) {
            this.f4965g.setBackgroundResource(this.f4976r);
            this.f4965g.setImageDrawable(getResources().getDrawable(this.f4978t));
        }
        if (this.f4966h != null) {
            this.f4966h.setTheme(this.f4979u);
        }
        if (this.f4969k != null) {
            this.f4969k.setTextColor(this.f4974p);
        }
    }

    protected void onFinishInflate() {
        int i;
        super.onFinishInflate();
        this.f4968j = findViewById(C1287d.divider);
        this.f4970l = (NumberPickerErrorTextView) findViewById(C1287d.error);
        for (i = 0; i < this.f4961c.length; i++) {
            this.f4961c[i] = -1;
        }
        View findViewById = findViewById(C1287d.first);
        View findViewById2 = findViewById(C1287d.second);
        View findViewById3 = findViewById(C1287d.third);
        View findViewById4 = findViewById(C1287d.fourth);
        this.f4966h = (NumberView) findViewById(C1287d.number_text);
        this.f4965g = (ImageButton) findViewById(C1287d.delete);
        this.f4965g.setOnClickListener(this);
        this.f4965g.setOnLongClickListener(this);
        this.f4960b[1] = (Button) findViewById.findViewById(C1287d.key_left);
        this.f4960b[2] = (Button) findViewById.findViewById(C1287d.key_middle);
        this.f4960b[3] = (Button) findViewById.findViewById(C1287d.key_right);
        this.f4960b[4] = (Button) findViewById2.findViewById(C1287d.key_left);
        this.f4960b[5] = (Button) findViewById2.findViewById(C1287d.key_middle);
        this.f4960b[6] = (Button) findViewById2.findViewById(C1287d.key_right);
        this.f4960b[7] = (Button) findViewById3.findViewById(C1287d.key_left);
        this.f4960b[8] = (Button) findViewById3.findViewById(C1287d.key_middle);
        this.f4960b[9] = (Button) findViewById3.findViewById(C1287d.key_right);
        this.f4963e = (Button) findViewById4.findViewById(C1287d.key_left);
        this.f4960b[0] = (Button) findViewById4.findViewById(C1287d.key_middle);
        this.f4964f = (Button) findViewById4.findViewById(C1287d.key_right);
        m8687d();
        for (i = 0; i < 10; i++) {
            this.f4960b[i].setOnClickListener(this);
            this.f4960b[i].setText(String.format("%d", new Object[]{Integer.valueOf(i)}));
            this.f4960b[i].setTag(C1287d.numbers_key, new Integer(i));
        }
        m8686c();
        Resources resources = this.f4967i.getResources();
        this.f4963e.setText(resources.getString(C1289f.number_picker_plus_minus));
        this.f4964f.setText(resources.getString(C1289f.number_picker_seperator));
        this.f4963e.setOnClickListener(this);
        this.f4964f.setOnClickListener(this);
        this.f4969k = (TextView) findViewById(C1287d.label);
        this.f4971m = 0;
        m8676g();
        m8674e();
        m8675f();
    }

    public void setPlusMinusVisibility(int i) {
        if (this.f4963e != null) {
            this.f4963e.setVisibility(i);
        }
    }

    public void setDecimalVisibility(int i) {
        if (this.f4964f != null) {
            this.f4964f.setVisibility(i);
        }
    }

    public void setMin(int i) {
        this.f4980v = Integer.valueOf(i);
    }

    public void setMax(int i) {
        this.f4981w = Integer.valueOf(i);
    }

    public void m8683a() {
        boolean z = this.f4962d != -1;
        if (this.f4965g != null) {
            this.f4965g.setEnabled(z);
        }
    }

    public NumberPickerErrorTextView getErrorView() {
        return this.f4970l;
    }

    public void onClick(View view) {
        view.performHapticFeedback(1);
        this.f4970l.m8689b();
        m8684a(view);
        m8683a();
    }

    protected void m8684a(View view) {
        Integer num = (Integer) view.getTag(C1287d.numbers_key);
        if (num != null) {
            m8673a(num.intValue());
        } else if (view == this.f4965g) {
            if (this.f4962d >= 0) {
                for (int i = 0; i < this.f4962d; i++) {
                    this.f4961c[i] = this.f4961c[i + 1];
                }
                this.f4961c[this.f4962d] = -1;
                this.f4962d--;
            }
        } else if (view == this.f4963e) {
            m8677h();
        } else if (view == this.f4964f) {
            m8678i();
        }
        m8675f();
    }

    public boolean onLongClick(View view) {
        view.performHapticFeedback(0);
        this.f4970l.m8689b();
        if (view != this.f4965g) {
            return false;
        }
        this.f4965g.setPressed(false);
        m8685b();
        m8675f();
        return true;
    }

    private void m8675f() {
        m8681l();
        m8686c();
        m8682m();
        m8683a();
    }

    public void setLabelText(String str) {
        this.f4972n = str;
        m8676g();
    }

    private void m8676g() {
        if (this.f4969k != null) {
            this.f4969k.setText(this.f4972n);
        }
    }

    public void m8685b() {
        for (int i = 0; i < this.f4959a; i++) {
            this.f4961c[i] = -1;
        }
        this.f4962d = -1;
        m8686c();
    }

    protected void m8686c() {
        boolean z = false;
        boolean z2 = true;
        String replaceAll = getEnteredNumberString().replaceAll("\\-", "");
        String[] split = replaceAll.split("\\.");
        NumberView numberView;
        String str;
        String str2;
        boolean j;
        if (split.length >= 2) {
            if (split[0].equals("")) {
                numberView = this.f4966h;
                str = "0";
                str2 = split[1];
                j = m8679j();
                if (this.f4971m != 1) {
                    z2 = false;
                }
                numberView.m8691a(str, str2, j, z2);
                return;
            }
            numberView = this.f4966h;
            str = split[0];
            str2 = split[1];
            j = m8679j();
            if (this.f4971m != 1) {
                z2 = false;
            }
            numberView.m8691a(str, str2, j, z2);
        } else if (split.length == 1) {
            numberView = this.f4966h;
            str2 = split[0];
            str = "";
            j = m8679j();
            if (this.f4971m != 1) {
                z2 = false;
            }
            numberView.m8691a(str2, str, j, z2);
        } else if (replaceAll.equals(".")) {
            numberView = this.f4966h;
            str2 = "0";
            str = "";
            if (this.f4971m == 1) {
                z = true;
            }
            numberView.m8691a(str2, str, true, z);
        }
    }

    protected void m8687d() {
        this.f4963e.setEnabled(true);
        this.f4964f.setEnabled(m8680k());
        if (!m8680k()) {
            this.f4964f.setContentDescription(null);
        }
    }

    private void m8673a(int i) {
        if (this.f4962d >= this.f4959a - 1) {
            return;
        }
        if (this.f4961c[0] != 0 || this.f4961c[1] != -1 || m8679j() || i == 10) {
            for (int i2 = this.f4962d; i2 >= 0; i2--) {
                this.f4961c[i2 + 1] = this.f4961c[i2];
            }
            this.f4962d++;
            this.f4961c[0] = i;
            return;
        }
        this.f4961c[0] = i;
    }

    private void m8677h() {
        if (this.f4971m == 0) {
            this.f4971m = 1;
        } else {
            this.f4971m = 0;
        }
    }

    private void m8678i() {
        if (m8680k()) {
            m8673a(10);
        }
    }

    private boolean m8679j() {
        boolean z = false;
        for (int i : this.f4961c) {
            if (i == 10) {
                z = true;
            }
        }
        return z;
    }

    private boolean m8680k() {
        return !m8679j();
    }

    private String getEnteredNumberString() {
        String str = "";
        for (int i = this.f4962d; i >= 0; i--) {
            if (this.f4961c[i] != -1) {
                if (this.f4961c[i] == 10) {
                    str = str + ".";
                } else {
                    str = str + this.f4961c[i];
                }
            }
        }
        return str;
    }

    public double getEnteredNumber() {
        String str = "0";
        int i = this.f4962d;
        while (i >= 0 && this.f4961c[i] != -1) {
            if (this.f4961c[i] == 10) {
                str = str + ".";
            } else {
                str = str + this.f4961c[i];
            }
            i--;
        }
        if (this.f4971m == 1) {
            str = "-" + str;
        }
        return Double.parseDouble(str);
    }

    private void m8681l() {
        this.f4964f.setEnabled(m8680k());
    }

    private void m8682m() {
        boolean z = false;
        if (this.f4973o != null) {
            if (this.f4962d == -1) {
                this.f4973o.setEnabled(false);
                return;
            }
            Button button = this.f4973o;
            if (this.f4962d >= 0) {
                z = true;
            }
            button.setEnabled(z);
        }
    }

    public void setSetButton(Button button) {
        this.f4973o = button;
        m8682m();
    }

    public int getNumber() {
        return Integer.parseInt(m8672a(getEnteredNumber()).split("\\.|,")[0]);
    }

    public double getDecimal() {
        return BigDecimal.valueOf(getEnteredNumber()).divideAndRemainder(BigDecimal.ONE)[1].doubleValue();
    }

    public boolean getIsNegative() {
        return this.f4971m == 1;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4957b = this.f4961c;
        savedState.f4958c = this.f4971m;
        savedState.f4956a = this.f4962d;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f4962d = savedState.f4956a;
            this.f4961c = savedState.f4957b;
            if (this.f4961c == null) {
                this.f4961c = new int[this.f4959a];
                this.f4962d = -1;
            }
            this.f4971m = savedState.f4958c;
            m8675f();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private String m8672a(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
        return decimalFormat.format(d);
    }
}
