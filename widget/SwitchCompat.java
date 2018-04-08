package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.view.C0684z;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.p032f.C0849a;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
    private static final int[] f3497N = new int[]{16842912};
    private int f3498A;
    private int f3499B;
    private int f3500C;
    private int f3501D;
    private int f3502E;
    private TextPaint f3503F;
    private ColorStateList f3504G;
    private Layout f3505H;
    private Layout f3506I;
    private TransformationMethod f3507J;
    private C0952a f3508K;
    private final Rect f3509L;
    private final C1011w f3510M;
    private Drawable f3511a;
    private ColorStateList f3512b;
    private Mode f3513c;
    private boolean f3514d;
    private boolean f3515e;
    private Drawable f3516f;
    private ColorStateList f3517g;
    private Mode f3518h;
    private boolean f3519i;
    private boolean f3520j;
    private int f3521k;
    private int f3522l;
    private int f3523m;
    private boolean f3524n;
    private CharSequence f3525o;
    private CharSequence f3526p;
    private boolean f3527q;
    private int f3528r;
    private int f3529s;
    private float f3530t;
    private float f3531u;
    private VelocityTracker f3532v;
    private int f3533w;
    private float f3534x;
    private int f3535y;
    private int f3536z;

    private class C0952a extends Animation {
        final float f3493a;
        final float f3494b;
        final float f3495c;
        final /* synthetic */ SwitchCompat f3496d;

        private C0952a(SwitchCompat switchCompat, float f, float f2) {
            this.f3496d = switchCompat;
            this.f3493a = f;
            this.f3494b = f2;
            this.f3495c = f2 - f;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            this.f3496d.setThumbPosition(this.f3493a + (this.f3495c * f));
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3512b = null;
        this.f3513c = null;
        this.f3514d = false;
        this.f3515e = false;
        this.f3517g = null;
        this.f3518h = null;
        this.f3519i = false;
        this.f3520j = false;
        this.f3532v = VelocityTracker.obtain();
        this.f3509L = new Rect();
        this.f3503F = new TextPaint(1);
        Resources resources = getResources();
        this.f3503F.density = resources.getDisplayMetrics().density;
        de a = de.m7066a(context, attributeSet, C0841k.SwitchCompat, i, 0);
        this.f3511a = a.m7069a(C0841k.SwitchCompat_android_thumb);
        if (this.f3511a != null) {
            this.f3511a.setCallback(this);
        }
        this.f3516f = a.m7069a(C0841k.SwitchCompat_track);
        if (this.f3516f != null) {
            this.f3516f.setCallback(this);
        }
        this.f3525o = a.m7075c(C0841k.SwitchCompat_android_textOn);
        this.f3526p = a.m7075c(C0841k.SwitchCompat_android_textOff);
        this.f3527q = a.m7071a(C0841k.SwitchCompat_showText, true);
        this.f3521k = a.m7078e(C0841k.SwitchCompat_thumbTextPadding, 0);
        this.f3522l = a.m7078e(C0841k.SwitchCompat_switchMinWidth, 0);
        this.f3523m = a.m7078e(C0841k.SwitchCompat_switchPadding, 0);
        this.f3524n = a.m7071a(C0841k.SwitchCompat_splitTrack, false);
        ColorStateList e = a.m7079e(C0841k.SwitchCompat_thumbTint);
        if (e != null) {
            this.f3512b = e;
            this.f3514d = true;
        }
        Mode a2 = az.m6862a(a.m7068a(C0841k.SwitchCompat_thumbTintMode, -1), null);
        if (this.f3513c != a2) {
            this.f3513c = a2;
            this.f3515e = true;
        }
        if (this.f3514d || this.f3515e) {
            m6629b();
        }
        e = a.m7079e(C0841k.SwitchCompat_trackTint);
        if (e != null) {
            this.f3517g = e;
            this.f3519i = true;
        }
        a2 = az.m6862a(a.m7068a(C0841k.SwitchCompat_trackTintMode, -1), null);
        if (this.f3518h != a2) {
            this.f3518h = a2;
            this.f3520j = true;
        }
        if (this.f3519i || this.f3520j) {
            m6623a();
        }
        int g = a.m7082g(C0841k.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            m6632a(context, g);
        }
        this.f3510M = C1011w.m7254a();
        a.m7070a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3529s = viewConfiguration.getScaledTouchSlop();
        this.f3533w = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void m6632a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0841k.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0841k.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.f3504G = colorStateList;
        } else {
            this.f3504G = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0841k.TextAppearance_android_textSize, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.f3503F.getTextSize())) {
            this.f3503F.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        m6624a(obtainStyledAttributes.getInt(C0841k.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(C0841k.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(C0841k.TextAppearance_textAllCaps, false)) {
            this.f3507J = new C0849a(getContext());
        } else {
            this.f3507J = null;
        }
        obtainStyledAttributes.recycle();
    }

    private void m6624a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m6633a(typeface, i2);
    }

    public void m6633a(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle;
            int style;
            float f;
            if (typeface == null) {
                defaultFromStyle = Typeface.defaultFromStyle(i);
            } else {
                defaultFromStyle = Typeface.create(typeface, i);
            }
            setSwitchTypeface(defaultFromStyle);
            if (defaultFromStyle != null) {
                style = defaultFromStyle.getStyle();
            } else {
                style = 0;
            }
            style = (style ^ -1) & i;
            TextPaint textPaint = this.f3503F;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.f3503F;
            if ((style & 2) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.f3503F.setFakeBoldText(false);
        this.f3503F.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f3503F.getTypeface() != typeface) {
            this.f3503F.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.f3523m = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f3523m;
    }

    public void setSwitchMinWidth(int i) {
        this.f3522l = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f3522l;
    }

    public void setThumbTextPadding(int i) {
        this.f3521k = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f3521k;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.f3516f != null) {
            this.f3516f.setCallback(null);
        }
        this.f3516f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.f3510M.m7272a(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.f3516f;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f3517g = colorStateList;
        this.f3519i = true;
        m6623a();
    }

    public ColorStateList getTrackTintList() {
        return this.f3517g;
    }

    public void setTrackTintMode(Mode mode) {
        this.f3518h = mode;
        this.f3520j = true;
        m6623a();
    }

    public Mode getTrackTintMode() {
        return this.f3518h;
    }

    private void m6623a() {
        if (this.f3516f == null) {
            return;
        }
        if (this.f3519i || this.f3520j) {
            this.f3516f = this.f3516f.mutate();
            if (this.f3519i) {
                C0441a.m2992a(this.f3516f, this.f3517g);
            }
            if (this.f3520j) {
                C0441a.m2995a(this.f3516f, this.f3518h);
            }
            if (this.f3516f.isStateful()) {
                this.f3516f.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.f3511a != null) {
            this.f3511a.setCallback(null);
        }
        this.f3511a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.f3510M.m7272a(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.f3511a;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f3512b = colorStateList;
        this.f3514d = true;
        m6629b();
    }

    public ColorStateList getThumbTintList() {
        return this.f3512b;
    }

    public void setThumbTintMode(Mode mode) {
        this.f3513c = mode;
        this.f3515e = true;
        m6629b();
    }

    public Mode getThumbTintMode() {
        return this.f3513c;
    }

    private void m6629b() {
        if (this.f3511a == null) {
            return;
        }
        if (this.f3514d || this.f3515e) {
            this.f3511a = this.f3511a.mutate();
            if (this.f3514d) {
                C0441a.m2992a(this.f3511a, this.f3512b);
            }
            if (this.f3515e) {
                C0441a.m2995a(this.f3511a, this.f3513c);
            }
            if (this.f3511a.isStateful()) {
                this.f3511a.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f3524n = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f3524n;
    }

    public CharSequence getTextOn() {
        return this.f3525o;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f3525o = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f3526p;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f3526p = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.f3527q != z) {
            this.f3527q = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f3527q;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.f3527q) {
            if (this.f3505H == null) {
                this.f3505H = m6622a(this.f3525o);
            }
            if (this.f3506I == null) {
                this.f3506I = m6622a(this.f3526p);
            }
        }
        Rect rect = this.f3509L;
        if (this.f3511a != null) {
            this.f3511a.getPadding(rect);
            intrinsicWidth = (this.f3511a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f3511a.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.f3527q) {
            max = Math.max(this.f3505H.getWidth(), this.f3506I.getWidth()) + (this.f3521k * 2);
        } else {
            max = 0;
        }
        this.f3498A = Math.max(max, intrinsicWidth);
        if (this.f3516f != null) {
            this.f3516f.getPadding(rect);
            i3 = this.f3516f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        max = rect.left;
        intrinsicWidth = rect.right;
        if (this.f3511a != null) {
            rect = az.m6863a(this.f3511a);
            max = Math.max(max, rect.left);
            intrinsicWidth = Math.max(intrinsicWidth, rect.right);
        }
        intrinsicWidth = Math.max(this.f3522l, intrinsicWidth + (max + (this.f3498A * 2)));
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.f3535y = intrinsicWidth;
        this.f3536z = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(ao.m3940j(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.f3525o : this.f3526p;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout m6622a(CharSequence charSequence) {
        int ceil;
        CharSequence transformation = this.f3507J != null ? this.f3507J.getTransformation(charSequence, this) : charSequence;
        TextPaint textPaint = this.f3503F;
        if (transformation != null) {
            ceil = (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.f3503F));
        } else {
            ceil = 0;
        }
        return new StaticLayout(transformation, textPaint, ceil, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean m6628a(float f, float f2) {
        if (this.f3511a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f3511a.getPadding(this.f3509L);
        int i = this.f3500C - this.f3529s;
        thumbOffset = (thumbOffset + this.f3499B) - this.f3529s;
        int i2 = (((this.f3498A + thumbOffset) + this.f3509L.left) + this.f3509L.right) + this.f3529s;
        int i3 = this.f3502E + this.f3529s;
        if (f <= ((float) thumbOffset) || f >= ((float) i2) || f2 <= ((float) i) || f2 >= ((float) i3)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f3532v.addMovement(motionEvent);
        float x;
        float y;
        switch (C0684z.m4397a(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && m6628a(x, y)) {
                    this.f3528r = 1;
                    this.f3530t = x;
                    this.f3531u = y;
                    break;
                }
            case 1:
            case 3:
                if (this.f3528r != 2) {
                    this.f3528r = 0;
                    this.f3532v.clear();
                    break;
                }
                m6630b(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.f3528r) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.f3530t) > ((float) this.f3529s) || Math.abs(y - this.f3531u) > ((float) this.f3529s)) {
                            this.f3528r = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f3530t = x;
                            this.f3531u = y;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.f3530t;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (C0983do.m7164a(this)) {
                            x = -x;
                        }
                        x = m6619a(x + this.f3534x, 0.0f, 1.0f);
                        if (x != this.f3534x) {
                            this.f3530t = x2;
                            setThumbPosition(x);
                        }
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void m6626a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m6630b(MotionEvent motionEvent) {
        boolean z = true;
        this.f3528r = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f3532v.computeCurrentVelocity(1000);
            float xVelocity = this.f3532v.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f3533w)) {
                z = getTargetCheckedState();
            } else if (C0983do.m7164a(this)) {
                if (xVelocity >= 0.0f) {
                    z = false;
                }
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m6626a(motionEvent);
    }

    private void m6627a(boolean z) {
        if (this.f3508K != null) {
            m6631c();
        }
        this.f3508K = new C0952a(this.f3534x, z ? 1.0f : 0.0f);
        this.f3508K.setDuration(250);
        this.f3508K.setAnimationListener(new cy(this, z));
        startAnimation(this.f3508K);
    }

    private void m6631c() {
        if (this.f3508K != null) {
            clearAnimation();
            this.f3508K = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.f3534x > 0.5f;
    }

    private void setThumbPosition(float f) {
        this.f3534x = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ao.m3895G(this) && isShown()) {
            m6627a(isChecked);
            return;
        }
        m6631c();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3511a != null) {
            Rect rect = this.f3509L;
            if (this.f3516f != null) {
                this.f3516f.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = az.m6863a(this.f3511a);
            max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
        } else {
            max = 0;
        }
        if (C0983do.m7164a(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.f3535y + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.f3535y);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f3536z / 2);
                paddingLeft = this.f3536z + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.f3536z;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.f3536z + paddingTop;
                break;
        }
        this.f3499B = i5;
        this.f3500C = paddingTop;
        this.f3502E = paddingLeft;
        this.f3501D = max;
    }

    public void draw(Canvas canvas) {
        Rect a;
        int i;
        Rect rect = this.f3509L;
        int i2 = this.f3499B;
        int i3 = this.f3500C;
        int i4 = this.f3501D;
        int i5 = this.f3502E;
        int thumbOffset = i2 + getThumbOffset();
        if (this.f3511a != null) {
            a = az.m6863a(this.f3511a);
        } else {
            a = az.f3684a;
        }
        if (this.f3516f != null) {
            this.f3516f.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (a != null) {
                if (a.left > rect.left) {
                    i2 += a.left - rect.left;
                }
                if (a.top > rect.top) {
                    thumbOffset = (a.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (a.right > rect.right) {
                    i4 -= a.right - rect.right;
                }
                i = a.bottom > rect.bottom ? i5 - (a.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.f3516f.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.f3511a != null) {
            this.f3511a.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.f3498A) + rect.right;
            this.f3511a.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                C0441a.m2991a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.f3509L;
        Drawable drawable = this.f3516f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f3500C + rect.top;
        int i2 = this.f3502E - rect.bottom;
        Drawable drawable2 = this.f3511a;
        if (drawable != null) {
            if (!this.f3524n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = az.m6863a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f3505H : this.f3506I;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.f3504G != null) {
                this.f3503F.setColor(this.f3504G.getColorForState(drawableState, 0));
            }
            this.f3503F.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!C0983do.m7164a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f3535y;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.f3523m;
    }

    public int getCompoundPaddingRight() {
        if (C0983do.m7164a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f3535y;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.f3523m;
    }

    private int getThumbOffset() {
        float f;
        if (C0983do.m7164a(this)) {
            f = 1.0f - this.f3534x;
        } else {
            f = this.f3534x;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f3516f == null) {
            return 0;
        }
        Rect a;
        Rect rect = this.f3509L;
        this.f3516f.getPadding(rect);
        if (this.f3511a != null) {
            a = az.m6863a(this.f3511a);
        } else {
            a = az.f3684a;
        }
        return ((((this.f3535y - this.f3498A) - rect.left) - rect.right) - a.left) - a.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f3497N);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f3511a;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.f3516f;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f3511a != null) {
            C0441a.m2989a(this.f3511a, f, f2);
        }
        if (this.f3516f != null) {
            C0441a.m2989a(this.f3516f, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3511a || drawable == this.f3516f;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f3511a != null) {
                this.f3511a.jumpToCurrentState();
            }
            if (this.f3516f != null) {
                this.f3516f.jumpToCurrentState();
            }
            m6631c();
            setThumbPosition(isChecked() ? 1.0f : 0.0f);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.f3525o : this.f3526p;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    private static float m6619a(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }
}
