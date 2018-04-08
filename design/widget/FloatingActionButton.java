package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0192a.C0186d;
import android.support.design.C0192a.C0190h;
import android.support.design.C0192a.C0191i;
import android.support.design.widget.C0292w.C0286a;
import android.support.design.widget.CoordinatorLayout.C0220b;
import android.support.design.widget.CoordinatorLayout.C0227c;
import android.support.design.widget.CoordinatorLayout.C0229e;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.ao;
import android.support.v7.widget.C1011w;
import android.support.v7.widget.C1014z;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@C0227c(a = Behavior.class)
public class FloatingActionButton extends bu {
    private ColorStateList f1124a;
    private Mode f1125b;
    private int f1126c;
    private int f1127d;
    private int f1128e;
    private int f1129f;
    private boolean f1130g;
    private final Rect f1131h;
    private C1014z f1132i;
    private C0292w f1133j;

    public static class Behavior extends C0220b<FloatingActionButton> {
        private static final boolean f1118a = (VERSION.SDK_INT >= 11);
        private bf f1119b;
        private float f1120c;
        private Rect f1121d;

        public /* synthetic */ boolean mo196b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m1698a(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public /* synthetic */ boolean mo197c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m1700b(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public boolean m1698a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return f1118a && (view instanceof SnackbarLayout);
        }

        public boolean m1700b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof SnackbarLayout) {
                m1696c(coordinatorLayout, floatingActionButton, view);
            } else if (view instanceof AppBarLayout) {
                m1694a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            }
            return false;
        }

        private boolean m1694a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((C0229e) floatingActionButton.getLayoutParams()).m1636a() != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.f1121d == null) {
                this.f1121d = new Rect();
            }
            Rect rect = this.f1121d;
            bn.m2083b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m1723b(null, false);
            } else {
                floatingActionButton.m1719a(null, false);
            }
            return true;
        }

        private void m1696c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            float a = m1693a(coordinatorLayout, floatingActionButton);
            if (this.f1120c != a) {
                float p = ao.m3946p(floatingActionButton);
                if (this.f1119b != null && this.f1119b.m2041b()) {
                    this.f1119b.m2044e();
                }
                if (!floatingActionButton.isShown() || Math.abs(p - a) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                    ao.m3920b((View) floatingActionButton, a);
                } else {
                    if (this.f1119b == null) {
                        this.f1119b = br.m2095a();
                        this.f1119b.m2040a(C0252a.f1253b);
                        this.f1119b.m2039a(new C0288p(this, floatingActionButton));
                    }
                    this.f1119b.m2035a(p, a);
                    this.f1119b.m2034a();
                }
                this.f1120c = a;
            }
        }

        private float m1693a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            float f = 0.0f;
            List d = coordinatorLayout.m1691d((View) floatingActionButton);
            int size = d.size();
            int i = 0;
            while (i < size) {
                float min;
                View view = (View) d.get(i);
                if ((view instanceof SnackbarLayout) && coordinatorLayout.m1682a((View) floatingActionButton, view)) {
                    min = Math.min(f, ao.m3946p(view) - ((float) view.getHeight()));
                } else {
                    min = f;
                }
                i++;
                f = min;
            }
            return f;
        }

        public boolean m1697a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List d = coordinatorLayout.m1691d((View) floatingActionButton);
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) d.get(i2);
                if ((view instanceof AppBarLayout) && m1694a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m1675a((View) floatingActionButton, i);
            m1695b(coordinatorLayout, floatingActionButton);
            return true;
        }

        private void m1695b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect a = floatingActionButton.f1131h;
            if (a != null && a.centerX() > 0 && a.centerY() > 0) {
                int i2;
                C0229e c0229e = (C0229e) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0229e.rightMargin) {
                    i2 = a.right;
                } else if (floatingActionButton.getLeft() <= c0229e.leftMargin) {
                    i2 = -a.left;
                } else {
                    i2 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - c0229e.bottomMargin) {
                    i = a.bottom;
                } else if (floatingActionButton.getTop() <= c0229e.topMargin) {
                    i = -a.top;
                }
                floatingActionButton.offsetTopAndBottom(i);
                floatingActionButton.offsetLeftAndRight(i2);
            }
        }
    }

    public static abstract class C0232a {
        public void m1703a(FloatingActionButton floatingActionButton) {
        }

        public void m1704b(FloatingActionButton floatingActionButton) {
        }
    }

    private class C0233b implements af {
        final /* synthetic */ FloatingActionButton f1122a;

        private C0233b(FloatingActionButton floatingActionButton) {
            this.f1122a = floatingActionButton;
        }

        public float mo206a() {
            return ((float) this.f1122a.getSizeDimension()) / 2.0f;
        }

        public void mo207a(int i, int i2, int i3, int i4) {
            this.f1122a.f1131h.set(i, i2, i3, i4);
            this.f1122a.setPadding(this.f1122a.f1129f + i, this.f1122a.f1129f + i2, this.f1122a.f1129f + i3, this.f1122a.f1129f + i4);
        }

        public void mo208a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean mo209b() {
            return this.f1122a.f1130g;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1131h = new Rect();
        be.m2015a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.FloatingActionButton, i, C0190h.Widget_Design_FloatingActionButton);
        this.f1124a = obtainStyledAttributes.getColorStateList(C0191i.FloatingActionButton_backgroundTint);
        this.f1125b = m1715a(obtainStyledAttributes.getInt(C0191i.FloatingActionButton_backgroundTintMode, -1), null);
        this.f1127d = obtainStyledAttributes.getColor(C0191i.FloatingActionButton_rippleColor, 0);
        this.f1128e = obtainStyledAttributes.getInt(C0191i.FloatingActionButton_fabSize, 0);
        this.f1126c = obtainStyledAttributes.getDimensionPixelSize(C0191i.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(C0191i.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0191i.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f1130g = obtainStyledAttributes.getBoolean(C0191i.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.f1132i = new C1014z(this, C1011w.m7254a());
        this.f1132i.m7277a(attributeSet, i);
        this.f1129f = (getSizeDimension() - ((int) getResources().getDimension(C0186d.design_fab_image_size))) / 2;
        getImpl().mo282a(this.f1124a, this.f1125b, this.f1127d, this.f1126c);
        getImpl().m2187c(dimension);
        getImpl().m2188d(dimension2);
        getImpl().m2192g();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        sizeDimension = Math.min(m1714a(sizeDimension, i), m1714a(sizeDimension, i2));
        setMeasuredDimension((this.f1131h.left + sizeDimension) + this.f1131h.right, (sizeDimension + this.f1131h.top) + this.f1131h.bottom);
    }

    public void setRippleColor(int i) {
        if (this.f1127d != i) {
            this.f1127d = i;
            getImpl().mo280a(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f1124a;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1124a != colorStateList) {
            this.f1124a = colorStateList;
            getImpl().mo281a(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.f1125b;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f1125b != mode) {
            this.f1125b = mode;
            getImpl().mo283a(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int i) {
        this.f1132i.m7276a(i);
    }

    private void m1719a(C0232a c0232a, boolean z) {
        getImpl().mo289b(m1717a(c0232a), z);
    }

    private void m1723b(C0232a c0232a, boolean z) {
        getImpl().mo285a(m1717a(c0232a), z);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1130g != z) {
            this.f1130g = z;
            getImpl().mo290c();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f1130g;
    }

    private C0286a m1717a(C0232a c0232a) {
        if (c0232a == null) {
            return null;
        }
        return new C0287o(this, c0232a);
    }

    final int getSizeDimension() {
        switch (this.f1128e) {
            case 1:
                return getResources().getDimensionPixelSize(C0186d.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(C0186d.design_fab_size_normal);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m2193h();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m2194i();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo286a(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo287b();
    }

    public Drawable getContentBackground() {
        return getImpl().m2191f();
    }

    private static int m1714a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    static Mode m1715a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            default:
                return mode;
        }
    }

    public float getCompatElevation() {
        return getImpl().mo278a();
    }

    public void setCompatElevation(float f) {
        getImpl().m2187c(f);
    }

    private C0292w getImpl() {
        if (this.f1133j == null) {
            this.f1133j = m1718a();
        }
        return this.f1133j;
    }

    private C0292w m1718a() {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            return new C0300y(this, new C0233b());
        }
        if (i >= 14) {
            return new C0296t(this, new C0233b());
        }
        return new C0293q(this, new C0233b());
    }
}
