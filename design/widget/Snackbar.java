package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.C0192a.C0183a;
import android.support.design.C0192a.C0186d;
import android.support.design.C0192a.C0187e;
import android.support.design.C0192a.C0188f;
import android.support.design.C0192a.C0191i;
import android.support.design.widget.CoordinatorLayout.C0220b;
import android.support.design.widget.CoordinatorLayout.C0229e;
import android.support.design.widget.ap.C0255a;
import android.support.v4.view.ao;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler f1159a = new Handler(Looper.getMainLooper(), new ag());
    private final ViewGroup f1160b;
    private final SnackbarLayout f1161c;
    private C0238b f1162d;
    private final AccessibilityManager f1163e;
    private final C0255a f1164f;

    public static class SnackbarLayout extends LinearLayout {
        private TextView f1142a;
        private Button f1143b;
        private int f1144c;
        private int f1145d;
        private C0236b f1146e;
        private C0235a f1147f;

        interface C0235a {
            void mo231a(View view);

            void mo232b(View view);
        }

        interface C0236b {
            void mo233a(View view, int i, int i2, int i3, int i4);
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.SnackbarLayout);
            this.f1144c = obtainStyledAttributes.getDimensionPixelSize(C0191i.SnackbarLayout_android_maxWidth, -1);
            this.f1145d = obtainStyledAttributes.getDimensionPixelSize(C0191i.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0191i.SnackbarLayout_elevation)) {
                ao.m3935f((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C0191i.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0188f.design_layout_snackbar_include, this);
            ao.m3930d((View) this, 1);
            ao.m3925c((View) this, 1);
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f1142a = (TextView) findViewById(C0187e.snackbar_text);
            this.f1143b = (Button) findViewById(C0187e.snackbar_action);
        }

        TextView getMessageView() {
            return this.f1142a;
        }

        Button getActionView() {
            return this.f1143b;
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f1144c > 0 && getMeasuredWidth() > this.f1144c) {
                i = MeasureSpec.makeMeasureSpec(this.f1144c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0186d.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0186d.design_snackbar_padding_vertical);
            int i3 = this.f1142a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f1145d <= 0 || this.f1143b.getMeasuredWidth() <= this.f1145d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m1736a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m1736a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void m1737a(int i, int i2) {
            ao.m3924c(this.f1142a, 0.0f);
            ao.m3950t(this.f1142a).m4189a(1.0f).m4190a((long) i2).m4195b((long) i).m4198c();
            if (this.f1143b.getVisibility() == 0) {
                ao.m3924c(this.f1143b, 0.0f);
                ao.m3950t(this.f1143b).m4189a(1.0f).m4190a((long) i2).m4195b((long) i).m4198c();
            }
        }

        void m1738b(int i, int i2) {
            ao.m3924c(this.f1142a, 1.0f);
            ao.m3950t(this.f1142a).m4189a(0.0f).m4190a((long) i2).m4195b((long) i).m4198c();
            if (this.f1143b.getVisibility() == 0) {
                ao.m3924c(this.f1143b, 1.0f);
                ao.m3950t(this.f1143b).m4189a(0.0f).m4190a((long) i2).m4195b((long) i).m4198c();
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f1146e != null) {
                this.f1146e.mo233a(this, i, i2, i3, i4);
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f1147f != null) {
                this.f1147f.mo231a(this);
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f1147f != null) {
                this.f1147f.mo232b(this);
            }
        }

        void setOnLayoutChangeListener(C0236b c0236b) {
            this.f1146e = c0236b;
        }

        void setOnAttachStateChangeListener(C0235a c0235a) {
            this.f1147f = c0235a;
        }

        private boolean m1736a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f1142a.getPaddingTop() == i2 && this.f1142a.getPaddingBottom() == i3) {
                return z;
            }
            m1735a(this.f1142a, i2, i3);
            return true;
        }

        private static void m1735a(View view, int i, int i2) {
            if (ao.m3890B(view)) {
                ao.m3905a(view, ao.m3943m(view), i, ao.m3944n(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }
    }

    final class C0237a extends SwipeDismissBehavior<SnackbarLayout> {
        final /* synthetic */ Snackbar f1158a;

        C0237a(Snackbar snackbar) {
            this.f1158a = snackbar;
        }

        public boolean mo212a(View view) {
            return view instanceof SnackbarLayout;
        }

        public boolean m1758a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.m1681a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        ap.m1953a().m1964c(this.f1158a.f1164f);
                        break;
                    case 1:
                    case 3:
                        ap.m1953a().m1965d(this.f1158a.f1164f);
                        break;
                }
            }
            return super.mo174a(coordinatorLayout, (View) snackbarLayout, motionEvent);
        }
    }

    public static abstract class C0238b {
        public void m1762a(Snackbar snackbar, int i) {
        }

        public void m1761a(Snackbar snackbar) {
        }
    }

    private void m1765b(int i) {
        ap.m1953a().m1962a(this.f1164f, i);
    }

    public boolean m1777a() {
        return ap.m1953a().m1966e(this.f1164f);
    }

    final void m1778b() {
        if (this.f1161c.getParent() == null) {
            LayoutParams layoutParams = this.f1161c.getLayoutParams();
            if (layoutParams instanceof C0229e) {
                C0220b c0237a = new C0237a(this);
                c0237a.m1751a(0.1f);
                c0237a.m1756b(0.6f);
                c0237a.m1752a(0);
                c0237a.m1753a(new ai(this));
                ((C0229e) layoutParams).m1638a(c0237a);
            }
            this.f1160b.addView(this.f1161c);
        }
        this.f1161c.setOnAttachStateChangeListener(new aj(this));
        if (ao.m3895G(this.f1161c)) {
            m1772d();
        } else {
            this.f1161c.setOnLayoutChangeListener(new al(this));
        }
    }

    private void m1772d() {
        if (VERSION.SDK_INT >= 14) {
            ao.m3920b(this.f1161c, (float) this.f1161c.getHeight());
            ao.m3950t(this.f1161c).m4197c(0.0f).m4193a(C0252a.f1253b).m4190a(250).m4191a(new am(this)).m4198c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f1161c.getContext(), C0183a.design_snackbar_in);
        loadAnimation.setInterpolator(C0252a.f1253b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new an(this));
        this.f1161c.startAnimation(loadAnimation);
    }

    private void m1770c(int i) {
        if (VERSION.SDK_INT >= 14) {
            ao.m3950t(this.f1161c).m4197c((float) this.f1161c.getHeight()).m4193a(C0252a.f1253b).m4190a(250).m4191a(new ao(this, i)).m4198c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f1161c.getContext(), C0183a.design_snackbar_out);
        loadAnimation.setInterpolator(C0252a.f1253b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new ah(this, i));
        this.f1161c.startAnimation(loadAnimation);
    }

    final void m1776a(int i) {
        if (this.f1161c.getVisibility() != 0) {
            m1773d(i);
        } else {
            m1770c(i);
        }
    }

    private void m1774e() {
        ap.m1953a().m1963b(this.f1164f);
        if (this.f1162d != null) {
            this.f1162d.m1761a(this);
        }
    }

    private void m1773d(int i) {
        ap.m1953a().m1961a(this.f1164f);
        if (this.f1162d != null) {
            this.f1162d.m1762a(this, i);
        }
        ViewParent parent = this.f1161c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f1161c);
        }
    }
}
