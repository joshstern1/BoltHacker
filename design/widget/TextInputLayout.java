package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0192a.C0185c;
import android.support.design.C0192a.C0189g;
import android.support.design.C0192a.C0190h;
import android.support.design.C0192a.C0191i;
import android.support.v4.p021b.C0307a;
import android.support.v4.view.C0249b;
import android.support.v4.view.ao;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.widget.Space;
import android.support.v7.widget.C1011w;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout {
    private EditText f1229a;
    private boolean f1230b;
    private CharSequence f1231c;
    private Paint f1232d;
    private LinearLayout f1233e;
    private int f1234f;
    private boolean f1235g;
    private TextView f1236h;
    private int f1237i;
    private boolean f1238j;
    private CharSequence f1239k;
    private boolean f1240l;
    private TextView f1241m;
    private int f1242n;
    private int f1243o;
    private int f1244p;
    private boolean f1245q;
    private ColorStateList f1246r;
    private ColorStateList f1247s;
    private final C0280i f1248t;
    private boolean f1249u;
    private bf f1250v;
    private boolean f1251w;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new bd();
        CharSequence f1224a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1224a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f1224a, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f1224a + "}";
        }
    }

    private class C0250a extends C0249b {
        final /* synthetic */ TextInputLayout f1228a;

        private C0250a(TextInputLayout textInputLayout) {
            this.f1228a = textInputLayout;
        }

        public void mo220a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo220a(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void mo221b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo221b(view, accessibilityEvent);
            CharSequence f = this.f1228a.f1248t.m2151f();
            if (!TextUtils.isEmpty(f)) {
                accessibilityEvent.getText().add(f);
            }
        }

        public void mo219a(View view, C0547e c0547e) {
            super.mo219a(view, c0547e);
            c0547e.m3443b(TextInputLayout.class.getSimpleName());
            CharSequence f = this.f1228a.f1248t.m2151f();
            if (!TextUtils.isEmpty(f)) {
                c0547e.m3449c(f);
            }
            if (this.f1228a.f1229a != null) {
                c0547e.m3457e(this.f1228a.f1229a);
            }
            f = this.f1228a.f1236h != null ? this.f1228a.f1236h.getText() : null;
            if (!TextUtils.isEmpty(f)) {
                c0547e.m3469j(true);
                c0547e.m3458e(f);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1248t = new C0280i(this);
        be.m2015a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f1248t.m2138a(C0252a.f1253b);
        this.f1248t.m2144b(new AccelerateInterpolator());
        this.f1248t.m2148d(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.TextInputLayout, i, C0190h.Widget_Design_TextInputLayout);
        this.f1230b = obtainStyledAttributes.getBoolean(C0191i.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(C0191i.TextInputLayout_android_hint));
        this.f1249u = obtainStyledAttributes.getBoolean(C0191i.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(C0191i.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0191i.TextInputLayout_android_textColorHint);
            this.f1247s = colorStateList;
            this.f1246r = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(C0191i.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(C0191i.TextInputLayout_hintTextAppearance, 0));
        }
        this.f1237i = obtainStyledAttributes.getResourceId(C0191i.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(C0191i.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(C0191i.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(C0191i.TextInputLayout_counterMaxLength, -1));
        this.f1243o = obtainStyledAttributes.getResourceId(C0191i.TextInputLayout_counterTextAppearance, 0);
        this.f1244p = obtainStyledAttributes.getResourceId(C0191i.TextInputLayout_counterOverflowTextAppearance, 0);
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        if (ao.m3931e(this) == 0) {
            ao.m3925c((View) this, 1);
        }
        ao.m3911a((View) this, new C0250a());
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            setEditText((EditText) view);
            super.addView(view, 0, m1889a(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        this.f1248t.m2137a(typeface);
    }

    public Typeface getTypeface() {
        return this.f1248t.m2140b();
    }

    private void setEditText(EditText editText) {
        if (this.f1229a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof ay)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f1229a = editText;
        this.f1248t.m2137a(this.f1229a.getTypeface());
        this.f1248t.m2133a(this.f1229a.getTextSize());
        this.f1248t.m2146c(this.f1229a.getGravity());
        this.f1229a.addTextChangedListener(new az(this));
        if (this.f1246r == null) {
            this.f1246r = this.f1229a.getHintTextColors();
        }
        if (this.f1230b && TextUtils.isEmpty(this.f1231c)) {
            setHint(this.f1229a.getHint());
            this.f1229a.setHint(null);
        }
        if (this.f1241m != null) {
            m1892a(this.f1229a.getText().length());
        }
        if (this.f1233e != null) {
            m1890a();
        }
        m1897a(false);
    }

    private LinearLayout.LayoutParams m1889a(LayoutParams layoutParams) {
        layoutParams = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f1230b) {
            if (this.f1232d == null) {
                this.f1232d = new Paint();
            }
            this.f1232d.setTypeface(this.f1248t.m2140b());
            this.f1232d.setTextSize(this.f1248t.m2147d());
            layoutParams.topMargin = (int) (-this.f1232d.ascent());
        } else {
            layoutParams.topMargin = 0;
        }
        return layoutParams;
    }

    private void m1897a(boolean z) {
        Object obj = 1;
        Object obj2 = (this.f1229a == null || TextUtils.isEmpty(this.f1229a.getText())) ? null : 1;
        boolean a = m1899a(getDrawableState(), 16842908);
        if (TextUtils.isEmpty(getError())) {
            obj = null;
        }
        if (this.f1246r != null) {
            this.f1248t.m2142b(this.f1246r.getDefaultColor());
        }
        if (this.f1245q && this.f1241m != null) {
            this.f1248t.m2134a(this.f1241m.getCurrentTextColor());
        } else if (a && this.f1247s != null) {
            this.f1248t.m2134a(this.f1247s.getDefaultColor());
        } else if (this.f1246r != null) {
            this.f1248t.m2134a(this.f1246r.getDefaultColor());
        }
        if (obj2 == null && !a && r1 == null) {
            m1905c(z);
        } else {
            m1902b(z);
        }
    }

    public EditText getEditText() {
        return this.f1229a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.f1230b) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f1231c = charSequence;
        this.f1248t.m2139a(charSequence);
    }

    public CharSequence getHint() {
        return this.f1230b ? this.f1231c : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f1230b) {
            this.f1230b = z;
            CharSequence hint = this.f1229a.getHint();
            if (!this.f1230b) {
                if (!TextUtils.isEmpty(this.f1231c) && TextUtils.isEmpty(hint)) {
                    this.f1229a.setHint(this.f1231c);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f1231c)) {
                    setHint(hint);
                }
                this.f1229a.setHint(null);
            }
            if (this.f1229a != null) {
                this.f1229a.setLayoutParams(m1889a(this.f1229a.getLayoutParams()));
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f1248t.m2150e(i);
        this.f1247s = ColorStateList.valueOf(this.f1248t.m2152g());
        if (this.f1229a != null) {
            m1897a(false);
            this.f1229a.setLayoutParams(m1889a(this.f1229a.getLayoutParams()));
            this.f1229a.requestLayout();
        }
    }

    private void m1896a(TextView textView, int i) {
        if (this.f1233e == null) {
            this.f1233e = new LinearLayout(getContext());
            this.f1233e.setOrientation(0);
            addView(this.f1233e, -1, -2);
            this.f1233e.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f1229a != null) {
                m1890a();
            }
        }
        this.f1233e.setVisibility(0);
        this.f1233e.addView(textView, i);
        this.f1234f++;
    }

    private void m1890a() {
        ao.m3905a(this.f1233e, ao.m3943m(this.f1229a), 0, ao.m3944n(this.f1229a), this.f1229a.getPaddingBottom());
    }

    private void m1895a(TextView textView) {
        if (this.f1233e != null) {
            this.f1233e.removeView(textView);
            int i = this.f1234f - 1;
            this.f1234f = i;
            if (i == 0) {
                this.f1233e.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.f1235g != z) {
            if (this.f1236h != null) {
                ao.m3950t(this.f1236h).m4196b();
            }
            if (z) {
                this.f1236h = new TextView(getContext());
                try {
                    this.f1236h.setTextAppearance(getContext(), this.f1237i);
                } catch (Exception e) {
                    this.f1236h.setTextAppearance(getContext(), C0190h.TextAppearance_AppCompat_Caption);
                    this.f1236h.setTextColor(C0307a.m2330c(getContext(), C0185c.design_textinput_error_color_light));
                }
                this.f1236h.setVisibility(4);
                ao.m3930d(this.f1236h, 1);
                m1896a(this.f1236h, 0);
            } else {
                this.f1238j = false;
                m1901b();
                m1895a(this.f1236h);
                this.f1236h = null;
            }
            this.f1235g = z;
        }
    }

    public void setError(CharSequence charSequence) {
        if (!TextUtils.equals(this.f1239k, charSequence)) {
            this.f1239k = charSequence;
            if (!this.f1235g) {
                if (!TextUtils.isEmpty(charSequence)) {
                    setErrorEnabled(true);
                } else {
                    return;
                }
            }
            boolean G = ao.m3895G(this);
            this.f1238j = !TextUtils.isEmpty(charSequence);
            if (this.f1238j) {
                this.f1236h.setText(charSequence);
                this.f1236h.setVisibility(0);
                if (G) {
                    if (ao.m3934f(this.f1236h) == 1.0f) {
                        ao.m3924c(this.f1236h, 0.0f);
                    }
                    ao.m3950t(this.f1236h).m4189a(1.0f).m4190a(200).m4193a(C0252a.f1255d).m4191a(new ba(this)).m4198c();
                }
            } else if (this.f1236h.getVisibility() == 0) {
                if (G) {
                    ao.m3950t(this.f1236h).m4189a(0.0f).m4190a(200).m4193a(C0252a.f1254c).m4191a(new bb(this, charSequence)).m4198c();
                } else {
                    this.f1236h.setVisibility(4);
                }
            }
            m1901b();
            m1897a(true);
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.f1240l != z) {
            if (z) {
                this.f1241m = new TextView(getContext());
                this.f1241m.setMaxLines(1);
                try {
                    this.f1241m.setTextAppearance(getContext(), this.f1243o);
                } catch (Exception e) {
                    this.f1241m.setTextAppearance(getContext(), C0190h.TextAppearance_AppCompat_Caption);
                    this.f1241m.setTextColor(C0307a.m2330c(getContext(), C0185c.design_textinput_error_color_light));
                }
                m1896a(this.f1241m, -1);
                if (this.f1229a == null) {
                    m1892a(0);
                } else {
                    m1892a(this.f1229a.getText().length());
                }
            } else {
                m1895a(this.f1241m);
                this.f1241m = null;
            }
            this.f1240l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f1242n != i) {
            if (i > 0) {
                this.f1242n = i;
            } else {
                this.f1242n = -1;
            }
            if (this.f1240l) {
                m1892a(this.f1229a == null ? 0 : this.f1229a.getText().length());
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f1242n;
    }

    private void m1892a(int i) {
        boolean z = this.f1245q;
        if (this.f1242n == -1) {
            this.f1241m.setText(String.valueOf(i));
            this.f1245q = false;
        } else {
            this.f1245q = i > this.f1242n;
            if (z != this.f1245q) {
                this.f1241m.setTextAppearance(getContext(), this.f1245q ? this.f1244p : this.f1243o);
            }
            this.f1241m.setText(getContext().getString(C0189g.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f1242n)}));
        }
        if (this.f1229a != null && z != this.f1245q) {
            m1897a(false);
            m1901b();
        }
    }

    private void m1901b() {
        m1904c();
        Drawable background = this.f1229a.getBackground();
        if (background != null) {
            if (this.f1238j && this.f1236h != null) {
                background.setColorFilter(C1011w.m7250a(this.f1236h.getCurrentTextColor(), Mode.SRC_IN));
            } else if (!this.f1245q || this.f1241m == null) {
                background.clearColorFilter();
                this.f1229a.refreshDrawableState();
            } else {
                background.setColorFilter(C1011w.m7250a(this.f1241m.getCurrentTextColor(), Mode.SRC_IN));
            }
        }
    }

    private void m1904c() {
        Drawable background = this.f1229a.getBackground();
        if (background != null && !this.f1251w) {
            Drawable newDrawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                this.f1251w = C0285n.m2160a((DrawableContainer) background, newDrawable.getConstantState());
            }
            if (!this.f1251w) {
                this.f1229a.setBackgroundDrawable(newDrawable);
                this.f1251w = true;
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.f1238j) {
            savedState.f1224a = getError();
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f1224a);
        requestLayout();
    }

    public CharSequence getError() {
        return this.f1235g ? this.f1239k : null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f1249u = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1230b) {
            this.f1248t.m2136a(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1230b && this.f1229a != null) {
            int left = this.f1229a.getLeft() + this.f1229a.getCompoundPaddingLeft();
            int right = this.f1229a.getRight() - this.f1229a.getCompoundPaddingRight();
            this.f1248t.m2135a(left, this.f1229a.getTop() + this.f1229a.getCompoundPaddingTop(), right, this.f1229a.getBottom() - this.f1229a.getCompoundPaddingBottom());
            this.f1248t.m2143b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.f1248t.m2149e();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        m1897a(ao.m3895G(this));
    }

    private void m1902b(boolean z) {
        if (this.f1250v != null && this.f1250v.m2041b()) {
            this.f1250v.m2044e();
        }
        if (z && this.f1249u) {
            m1891a(1.0f);
        } else {
            this.f1248t.m2141b(1.0f);
        }
    }

    private void m1905c(boolean z) {
        if (this.f1250v != null && this.f1250v.m2041b()) {
            this.f1250v.m2044e();
        }
        if (z && this.f1249u) {
            m1891a(0.0f);
        } else {
            this.f1248t.m2141b(0.0f);
        }
    }

    private void m1891a(float f) {
        if (this.f1248t.m2145c() != f) {
            if (this.f1250v == null) {
                this.f1250v = br.m2095a();
                this.f1250v.m2040a(C0252a.f1252a);
                this.f1250v.m2036a(200);
                this.f1250v.m2039a(new bc(this));
            }
            this.f1250v.m2035a(this.f1248t.m2145c(), f);
            this.f1250v.m2034a();
        }
    }

    private static boolean m1899a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
