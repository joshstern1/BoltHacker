package com.codetroopers.betterpickers.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.format.DateFormat;
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
import java.text.DateFormatSymbols;

public class TimePicker extends LinearLayout implements OnClickListener, OnLongClickListener {
    protected int f5123a;
    protected final Button[] f5124b;
    protected int[] f5125c;
    protected int f5126d;
    protected Button f5127e;
    protected Button f5128f;
    protected ImageButton f5129g;
    protected TimerView f5130h;
    protected final Context f5131i;
    protected View f5132j;
    private TextView f5133k;
    private String[] f5134l;
    private final String f5135m;
    private int f5136n;
    private Button f5137o;
    private boolean f5138p;
    private ColorStateList f5139q;
    private int f5140r;
    private int f5141s;
    private int f5142t;
    private int f5143u;
    private int f5144v;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C1350b();
        int f5120a;
        int[] f5121b;
        int f5122c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5120a = parcel.readInt();
            parcel.readIntArray(this.f5121b);
            this.f5122c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5120a);
            parcel.writeIntArray(this.f5121b);
            parcel.writeInt(this.f5122c);
        }
    }

    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5123a = 4;
        this.f5124b = new Button[10];
        this.f5125c = new int[this.f5123a];
        this.f5126d = -1;
        this.f5138p = false;
        this.f5144v = -1;
        this.f5131i = context;
        this.f5138p = m8765a(this.f5131i);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutId(), this);
        this.f5135m = context.getResources().getString(C1289f.time_picker_ampm_label);
        this.f5139q = getResources().getColorStateList(C1284a.dialog_text_color_holo_dark);
        this.f5140r = C1286c.key_background_dark;
        this.f5141s = C1286c.button_background_dark;
        this.f5142t = getResources().getColor(C1284a.default_divider_color_dark);
        this.f5143u = C1286c.ic_backspace_dark;
    }

    protected int getLayoutId() {
        return C1288e.time_picker_view;
    }

    public void setTheme(int i) {
        this.f5144v = i;
        if (this.f5144v != -1) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C1291h.BetterPickersDialogFragment);
            this.f5139q = obtainStyledAttributes.getColorStateList(C1291h.BetterPickersDialogFragment_bpTextColor);
            this.f5140r = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpKeyBackground, this.f5140r);
            this.f5141s = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpButtonBackground, this.f5141s);
            this.f5142t = obtainStyledAttributes.getColor(C1291h.BetterPickersDialogFragment_bpDividerColor, this.f5142t);
            this.f5143u = obtainStyledAttributes.getResourceId(C1291h.BetterPickersDialogFragment_bpDeleteIcon, this.f5143u);
        }
        m8766d();
    }

    private void m8766d() {
        for (Button button : this.f5124b) {
            if (button != null) {
                button.setTextColor(this.f5139q);
                button.setBackgroundResource(this.f5140r);
            }
        }
        if (this.f5132j != null) {
            this.f5132j.setBackgroundColor(this.f5142t);
        }
        if (this.f5127e != null) {
            this.f5127e.setTextColor(this.f5139q);
            this.f5127e.setBackgroundResource(this.f5140r);
        }
        if (this.f5133k != null) {
            this.f5133k.setTextColor(this.f5139q);
            this.f5133k.setBackgroundResource(this.f5140r);
        }
        if (this.f5128f != null) {
            this.f5128f.setTextColor(this.f5139q);
            this.f5128f.setBackgroundResource(this.f5140r);
        }
        if (this.f5129g != null) {
            this.f5129g.setBackgroundResource(this.f5141s);
            this.f5129g.setImageDrawable(getResources().getDrawable(this.f5143u));
        }
        if (this.f5130h != null) {
            this.f5130h.setTheme(this.f5144v);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(C1287d.first);
        View findViewById2 = findViewById(C1287d.second);
        View findViewById3 = findViewById(C1287d.third);
        View findViewById4 = findViewById(C1287d.fourth);
        this.f5130h = (TimerView) findViewById(C1287d.timer_time_text);
        this.f5129g = (ImageButton) findViewById(C1287d.delete);
        this.f5129g.setOnClickListener(this);
        this.f5129g.setOnLongClickListener(this);
        this.f5124b[1] = (Button) findViewById.findViewById(C1287d.key_left);
        this.f5124b[2] = (Button) findViewById.findViewById(C1287d.key_middle);
        this.f5124b[3] = (Button) findViewById.findViewById(C1287d.key_right);
        this.f5124b[4] = (Button) findViewById2.findViewById(C1287d.key_left);
        this.f5124b[5] = (Button) findViewById2.findViewById(C1287d.key_middle);
        this.f5124b[6] = (Button) findViewById2.findViewById(C1287d.key_right);
        this.f5124b[7] = (Button) findViewById3.findViewById(C1287d.key_left);
        this.f5124b[8] = (Button) findViewById3.findViewById(C1287d.key_middle);
        this.f5124b[9] = (Button) findViewById3.findViewById(C1287d.key_right);
        this.f5127e = (Button) findViewById4.findViewById(C1287d.key_left);
        this.f5124b[0] = (Button) findViewById4.findViewById(C1287d.key_middle);
        this.f5128f = (Button) findViewById4.findViewById(C1287d.key_right);
        setLeftRightEnabled(false);
        for (int i = 0; i < 10; i++) {
            this.f5124b[i].setOnClickListener(this);
            this.f5124b[i].setText(String.format("%d", new Object[]{Integer.valueOf(i)}));
            this.f5124b[i].setTag(C1287d.numbers_key, new Integer(i));
        }
        m8778c();
        Resources resources = this.f5131i.getResources();
        this.f5134l = new DateFormatSymbols().getAmPmStrings();
        if (this.f5138p) {
            this.f5127e.setText(resources.getString(C1289f.time_picker_00_label));
            this.f5128f.setText(resources.getString(C1289f.time_picker_30_label));
        } else {
            this.f5127e.setText(this.f5134l[0]);
            this.f5128f.setText(this.f5134l[1]);
        }
        this.f5127e.setOnClickListener(this);
        this.f5128f.setOnClickListener(this);
        this.f5133k = (TextView) findViewById(C1287d.ampm_label);
        this.f5136n = 0;
        this.f5132j = findViewById(C1287d.divider);
        m8766d();
        m8767e();
    }

    public void m8775a() {
        boolean z = this.f5126d != -1;
        if (this.f5129g != null) {
            this.f5129g.setEnabled(z);
        }
    }

    public void onClick(View view) {
        view.performHapticFeedback(1);
        m8776a(view);
        m8775a();
    }

    protected void m8776a(View view) {
        Integer num = (Integer) view.getTag(C1287d.numbers_key);
        if (num != null) {
            m8764a(num.intValue());
        } else if (view == this.f5129g) {
            if (!this.f5138p && this.f5136n != 0) {
                this.f5136n = 0;
            } else if (this.f5126d >= 0) {
                for (int i = 0; i < this.f5126d; i++) {
                    this.f5125c[i] = this.f5125c[i + 1];
                }
                this.f5125c[this.f5126d] = 0;
                this.f5126d--;
            }
        } else if (view == this.f5127e) {
            m8769g();
        } else if (view == this.f5128f) {
            m8770h();
        }
        m8767e();
    }

    public boolean onLongClick(View view) {
        view.performHapticFeedback(0);
        if (view != this.f5129g) {
            return false;
        }
        this.f5129g.setPressed(false);
        this.f5136n = 0;
        m8777b();
        m8767e();
        return true;
    }

    public void m8777b() {
        for (int i = 0; i < this.f5123a; i++) {
            this.f5125c[i] = 0;
        }
        this.f5126d = -1;
        m8778c();
    }

    private void m8767e() {
        m8768f();
        m8773k();
        m8778c();
        m8772j();
        m8774l();
        m8775a();
    }

    protected void m8778c() {
        int i;
        int i2;
        int i3 = -1;
        getEnteredTime();
        if (this.f5126d > -1) {
            if (this.f5126d >= 0) {
                i = this.f5125c[this.f5126d];
                if ((this.f5138p && i >= 3 && i <= 9) || (!this.f5138p && i >= 2 && i <= 9)) {
                    i = -2;
                    if (this.f5126d > 0 && this.f5126d < 3 && r0 != -2) {
                        i2 = (this.f5125c[this.f5126d] * 10) + this.f5125c[this.f5126d - 1];
                        if ((this.f5138p && i2 >= 24 && i2 <= 25) || (!this.f5138p && i2 >= 13 && i2 <= 15)) {
                            i = -2;
                        }
                    }
                    if (this.f5126d == 3) {
                        i = this.f5125c[3];
                    }
                }
            }
            i = -1;
            i2 = (this.f5125c[this.f5126d] * 10) + this.f5125c[this.f5126d - 1];
            i = -2;
            if (this.f5126d == 3) {
                i = this.f5125c[3];
            }
        } else {
            i = -1;
        }
        int i4 = this.f5126d < 2 ? -1 : this.f5125c[2];
        i2 = this.f5126d < 1 ? -1 : this.f5125c[1];
        if (this.f5126d >= 0) {
            i3 = this.f5125c[0];
        }
        this.f5130h.m8780a(i, i4, i2, i3);
    }

    private void m8768f() {
        if (this.f5138p) {
            this.f5133k.setVisibility(4);
            this.f5136n = 3;
            return;
        }
        switch (this.f5136n) {
            case 0:
                this.f5133k.setText(this.f5135m);
                return;
            case 1:
                this.f5133k.setText(this.f5134l[1]);
                return;
            case 2:
                this.f5133k.setText(this.f5134l[0]);
                return;
            default:
                return;
        }
    }

    private void m8764a(int i) {
        if (this.f5126d < this.f5123a - 1) {
            for (int i2 = this.f5126d; i2 >= 0; i2--) {
                this.f5125c[i2 + 1] = this.f5125c[i2];
            }
            this.f5126d++;
            this.f5125c[0] = i;
        }
    }

    private void m8769g() {
        getEnteredTime();
        if (!this.f5138p) {
            if (m8771i()) {
                m8764a(0);
                m8764a(0);
            }
            this.f5136n = 2;
        } else if (m8771i()) {
            m8764a(0);
            m8764a(0);
        }
    }

    private void m8770h() {
        getEnteredTime();
        if (!this.f5138p) {
            if (m8771i()) {
                m8764a(0);
                m8764a(0);
            }
            this.f5136n = 1;
        } else if (m8771i()) {
            m8764a(3);
            m8764a(0);
        }
    }

    private boolean m8771i() {
        int enteredTime = getEnteredTime();
        if (this.f5138p) {
            if (enteredTime < 0 || enteredTime > 23 || this.f5126d <= -1 || this.f5126d >= 2) {
                return false;
            }
            return true;
        } else if (enteredTime < 1 || enteredTime > 12) {
            return false;
        } else {
            return true;
        }
    }

    private void m8772j() {
        int enteredTime = getEnteredTime();
        if (this.f5138p) {
            if (this.f5126d >= 3) {
                setKeyRange(-1);
            } else if (enteredTime == 0) {
                if (this.f5126d == -1 || this.f5126d == 0 || this.f5126d == 2) {
                    setKeyRange(9);
                } else if (this.f5126d == 1) {
                    setKeyRange(5);
                } else {
                    setKeyRange(-1);
                }
            } else if (enteredTime == 1) {
                if (this.f5126d == 0 || this.f5126d == 2) {
                    setKeyRange(9);
                } else if (this.f5126d == 1) {
                    setKeyRange(5);
                } else {
                    setKeyRange(-1);
                }
            } else if (enteredTime == 2) {
                if (this.f5126d == 2 || this.f5126d == 1) {
                    setKeyRange(9);
                } else if (this.f5126d == 0) {
                    setKeyRange(3);
                } else {
                    setKeyRange(-1);
                }
            } else if (enteredTime <= 5) {
                setKeyRange(9);
            } else if (enteredTime <= 9) {
                setKeyRange(5);
            } else if (enteredTime >= 10 && enteredTime <= 15) {
                setKeyRange(9);
            } else if (enteredTime >= 16 && enteredTime <= 19) {
                setKeyRange(5);
            } else if (enteredTime >= 20 && enteredTime <= 25) {
                setKeyRange(9);
            } else if (enteredTime >= 26 && enteredTime <= 29) {
                setKeyRange(-1);
            } else if (enteredTime >= 30 && enteredTime <= 35) {
                setKeyRange(9);
            } else if (enteredTime >= 36 && enteredTime <= 39) {
                setKeyRange(-1);
            } else if (enteredTime >= 40 && enteredTime <= 45) {
                setKeyRange(9);
            } else if (enteredTime >= 46 && enteredTime <= 49) {
                setKeyRange(-1);
            } else if (enteredTime >= 50 && enteredTime <= 55) {
                setKeyRange(9);
            } else if (enteredTime >= 56 && enteredTime <= 59) {
                setKeyRange(-1);
            } else if (enteredTime >= 60 && enteredTime <= 65) {
                setKeyRange(9);
            } else if (enteredTime >= 70 && enteredTime <= 75) {
                setKeyRange(9);
            } else if (enteredTime >= 80 && enteredTime <= 85) {
                setKeyRange(9);
            } else if (enteredTime >= 90 && enteredTime <= 95) {
                setKeyRange(9);
            } else if (enteredTime >= 100 && enteredTime <= 105) {
                setKeyRange(9);
            } else if (enteredTime >= 106 && enteredTime <= 109) {
                setKeyRange(-1);
            } else if (enteredTime >= 110 && enteredTime <= 115) {
                setKeyRange(9);
            } else if (enteredTime >= 116 && enteredTime <= 119) {
                setKeyRange(-1);
            } else if (enteredTime >= 120 && enteredTime <= 125) {
                setKeyRange(9);
            } else if (enteredTime >= 126 && enteredTime <= 129) {
                setKeyRange(-1);
            } else if (enteredTime >= 130 && enteredTime <= 135) {
                setKeyRange(9);
            } else if (enteredTime >= 136 && enteredTime <= 139) {
                setKeyRange(-1);
            } else if (enteredTime >= 140 && enteredTime <= 145) {
                setKeyRange(9);
            } else if (enteredTime >= 146 && enteredTime <= 149) {
                setKeyRange(-1);
            } else if (enteredTime >= 150 && enteredTime <= 155) {
                setKeyRange(9);
            } else if (enteredTime >= 156 && enteredTime <= 159) {
                setKeyRange(-1);
            } else if (enteredTime >= 160 && enteredTime <= 165) {
                setKeyRange(9);
            } else if (enteredTime >= 166 && enteredTime <= 169) {
                setKeyRange(-1);
            } else if (enteredTime >= 170 && enteredTime <= 175) {
                setKeyRange(9);
            } else if (enteredTime >= 176 && enteredTime <= 179) {
                setKeyRange(-1);
            } else if (enteredTime >= 180 && enteredTime <= 185) {
                setKeyRange(9);
            } else if (enteredTime >= 186 && enteredTime <= 189) {
                setKeyRange(-1);
            } else if (enteredTime >= 190 && enteredTime <= 195) {
                setKeyRange(9);
            } else if (enteredTime >= 196 && enteredTime <= 199) {
                setKeyRange(-1);
            } else if (enteredTime >= 200 && enteredTime <= 205) {
                setKeyRange(9);
            } else if (enteredTime >= 206 && enteredTime <= 209) {
                setKeyRange(-1);
            } else if (enteredTime >= 210 && enteredTime <= 215) {
                setKeyRange(9);
            } else if (enteredTime >= 216 && enteredTime <= 219) {
                setKeyRange(-1);
            } else if (enteredTime >= 220 && enteredTime <= 225) {
                setKeyRange(9);
            } else if (enteredTime >= 226 && enteredTime <= 229) {
                setKeyRange(-1);
            } else if (enteredTime >= 230 && enteredTime <= 235) {
                setKeyRange(9);
            } else if (enteredTime >= 236) {
                setKeyRange(-1);
            }
        } else if (this.f5136n != 0) {
            setKeyRange(-1);
        } else if (enteredTime == 0) {
            setKeyRange(9);
            this.f5124b[0].setEnabled(false);
        } else if (enteredTime <= 9) {
            setKeyRange(5);
        } else if (enteredTime <= 95) {
            setKeyRange(9);
        } else if (enteredTime >= 100 && enteredTime <= 105) {
            setKeyRange(9);
        } else if (enteredTime >= 106 && enteredTime <= 109) {
            setKeyRange(-1);
        } else if (enteredTime >= 110 && enteredTime <= 115) {
            setKeyRange(9);
        } else if (enteredTime >= 116 && enteredTime <= 119) {
            setKeyRange(-1);
        } else if (enteredTime >= 120 && enteredTime <= 125) {
            setKeyRange(9);
        } else if (enteredTime >= 126) {
            setKeyRange(-1);
        }
    }

    private int getEnteredTime() {
        return (((this.f5125c[3] * 1000) + (this.f5125c[2] * 100)) + (this.f5125c[1] * 10)) + this.f5125c[0];
    }

    private void setKeyRange(int i) {
        for (int i2 = 0; i2 < this.f5124b.length; i2++) {
            boolean z;
            Button button = this.f5124b[i2];
            if (i2 <= i) {
                z = true;
            } else {
                z = false;
            }
            button.setEnabled(z);
        }
    }

    private void m8773k() {
        int enteredTime = getEnteredTime();
        if (this.f5138p) {
            boolean i = m8771i();
            this.f5127e.setEnabled(i);
            this.f5128f.setEnabled(i);
        } else if ((enteredTime <= 12 || enteredTime >= 100) && enteredTime != 0 && this.f5136n == 0) {
            this.f5127e.setEnabled(true);
            this.f5128f.setEnabled(true);
        } else {
            this.f5127e.setEnabled(false);
            this.f5128f.setEnabled(false);
        }
    }

    private void m8774l() {
        boolean z = true;
        if (this.f5137o != null) {
            if (this.f5126d == -1) {
                this.f5137o.setEnabled(false);
            } else if (this.f5138p) {
                int enteredTime = getEnteredTime();
                Button button = this.f5137o;
                if (this.f5126d < 2 || (enteredTime >= 60 && enteredTime <= 95)) {
                    z = false;
                }
                button.setEnabled(z);
            } else {
                Button button2 = this.f5137o;
                if (this.f5136n == 0) {
                    z = false;
                }
                button2.setEnabled(z);
            }
        }
    }

    public void setSetButton(Button button) {
        this.f5137o = button;
        m8774l();
    }

    public int getHours() {
        int i = 12;
        int i2 = (this.f5125c[3] * 10) + this.f5125c[2];
        if (i2 == 12) {
            switch (this.f5136n) {
                case 1:
                    return 12;
                case 2:
                    return 0;
                case 3:
                    return i2;
            }
        }
        if (this.f5136n != 1) {
            i = 0;
        }
        return i + i2;
    }

    public int getMinutes() {
        return (this.f5125c[1] * 10) + this.f5125c[0];
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5121b = this.f5125c;
        savedState.f5122c = this.f5136n;
        savedState.f5120a = this.f5126d;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f5126d = savedState.f5120a;
            this.f5125c = savedState.f5121b;
            if (this.f5125c == null) {
                this.f5125c = new int[this.f5123a];
                this.f5126d = -1;
            }
            this.f5136n = savedState.f5122c;
            m8767e();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public static boolean m8765a(Context context) {
        return DateFormat.is24HourFormat(context);
    }

    public int getTime() {
        return ((((this.f5125c[4] * 3600) + (this.f5125c[3] * 600)) + (this.f5125c[2] * 60)) + (this.f5125c[1] * 10)) + this.f5125c[0];
    }

    protected void setLeftRightEnabled(boolean z) {
        this.f5127e.setEnabled(z);
        this.f5128f.setEnabled(z);
        if (!z) {
            this.f5127e.setContentDescription(null);
            this.f5128f.setContentDescription(null);
        }
    }
}
