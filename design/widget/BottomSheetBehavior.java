package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0192a.C0191i;
import android.support.design.widget.CoordinatorLayout.C0220b;
import android.support.v4.view.C0684z;
import android.support.v4.view.ae;
import android.support.v4.view.am;
import android.support.v4.view.ao;
import android.support.v4.widget.bd;
import android.support.v4.widget.bd.C0258a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends C0220b<V> {
    private float f1056a;
    private int f1057b;
    private int f1058c;
    private int f1059d;
    private boolean f1060e;
    private int f1061f = 4;
    private bd f1062g;
    private boolean f1063h;
    private int f1064i;
    private boolean f1065j;
    private int f1066k;
    private WeakReference<V> f1067l;
    private WeakReference<View> f1068m;
    private C0224a f1069n;
    private VelocityTracker f1070o;
    private int f1071p;
    private int f1072q;
    private boolean f1073r;
    private final C0258a f1074s = new C0276e(this);

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0277f();
        final int f1052a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1052a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f1052a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1052a);
        }
    }

    public static abstract class C0224a {
        public abstract void m1600a(View view, float f);

        public abstract void m1601a(View view, int i);
    }

    private class C0225b implements Runnable {
        final /* synthetic */ BottomSheetBehavior f1053a;
        private final View f1054b;
        private final int f1055c;

        C0225b(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f1053a = bottomSheetBehavior;
            this.f1054b = view;
            this.f1055c = i;
        }

        public void run() {
            if (this.f1053a.f1062g == null || !this.f1053a.f1062g.m4833a(true)) {
                this.f1053a.m1609b(this.f1055c);
            } else {
                ao.m3913a(this.f1054b, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.BottomSheetBehavior_Params);
        m1621a(obtainStyledAttributes.getDimensionPixelSize(C0191i.BottomSheetBehavior_Params_behavior_peekHeight, 0));
        m1625a(obtainStyledAttributes.getBoolean(C0191i.BottomSheetBehavior_Params_behavior_hideable, false));
        obtainStyledAttributes.recycle();
        this.f1056a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable mo189b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.mo189b(coordinatorLayout, v), this.f1061f);
    }

    public void mo180a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo180a(coordinatorLayout, (View) v, savedState.getSuperState());
        if (savedState.f1052a == 1 || savedState.f1052a == 2) {
            this.f1061f = 4;
        } else {
            this.f1061f = savedState.f1052a;
        }
    }

    public boolean mo173a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (!(this.f1061f == 1 || this.f1061f == 2)) {
            coordinatorLayout.m1675a((View) v, i);
        }
        this.f1066k = coordinatorLayout.getHeight();
        this.f1058c = Math.max(0, this.f1066k - v.getHeight());
        this.f1059d = Math.max(this.f1066k - this.f1057b, this.f1058c);
        if (this.f1061f == 3) {
            ao.m3933e((View) v, this.f1058c);
        } else if (this.f1060e && this.f1061f == 5) {
            ao.m3933e((View) v, this.f1066k);
        } else if (this.f1061f == 4) {
            ao.m3933e((View) v, this.f1059d);
        }
        if (this.f1062g == null) {
            this.f1062g = bd.m4809a((ViewGroup) coordinatorLayout, this.f1074s);
        }
        this.f1067l = new WeakReference(v);
        this.f1068m = new WeakReference(m1603a((View) v));
        return true;
    }

    public boolean mo174a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (!v.isShown()) {
            return false;
        }
        int a = C0684z.m4397a(motionEvent);
        if (a == 0) {
            m1604a();
        }
        if (this.f1070o == null) {
            this.f1070o = VelocityTracker.obtain();
        }
        this.f1070o.addMovement(motionEvent);
        switch (a) {
            case 0:
                int x = (int) motionEvent.getX();
                this.f1072q = (int) motionEvent.getY();
                View view = (View) this.f1068m.get();
                if (view != null && coordinatorLayout.m1681a(view, x, this.f1072q)) {
                    this.f1071p = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f1073r = true;
                }
                boolean z2 = this.f1071p == -1 && !coordinatorLayout.m1681a((View) v, x, this.f1072q);
                this.f1063h = z2;
                break;
            case 1:
            case 3:
                this.f1073r = false;
                this.f1071p = -1;
                if (this.f1063h) {
                    this.f1063h = false;
                    return false;
                }
                break;
        }
        if (!this.f1063h && this.f1062g.m4831a(motionEvent)) {
            return true;
        }
        view = (View) this.f1068m.get();
        if (a != 2 || view == null || this.f1063h || this.f1061f == 1 || coordinatorLayout.m1681a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f1072q) - motionEvent.getY()) <= ((float) this.f1062g.m4843d())) {
            z = false;
        }
        return z;
    }

    public boolean mo175b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int a = C0684z.m4397a(motionEvent);
        if (this.f1061f == 1 && a == 0) {
            return true;
        }
        this.f1062g.m4835b(motionEvent);
        if (a == 0) {
            m1604a();
        }
        if (this.f1070o == null) {
            this.f1070o = VelocityTracker.obtain();
        }
        this.f1070o.addMovement(motionEvent);
        if (a != 2 || Math.abs(((float) this.f1072q) - motionEvent.getY()) <= ((float) this.f1062g.m4843d())) {
            return true;
        }
        this.f1062g.m4829a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return true;
    }

    public boolean mo186a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f1064i = 0;
        this.f1065j = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void mo183a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.f1068m.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f1058c) {
                    iArr[1] = top - this.f1058c;
                    ao.m3933e((View) v, -iArr[1]);
                    m1609b(3);
                } else {
                    iArr[1] = i2;
                    ao.m3933e((View) v, -i2);
                    m1609b(1);
                }
            } else if (i2 < 0 && !ao.m3923b(view, -1)) {
                if (i3 <= this.f1059d || this.f1060e) {
                    iArr[1] = i2;
                    ao.m3933e((View) v, -i2);
                    m1609b(1);
                } else {
                    iArr[1] = top - this.f1059d;
                    ao.m3933e((View) v, -iArr[1]);
                    m1609b(4);
                }
            }
            m1613c(v.getTop());
            this.f1064i = i2;
            this.f1065j = true;
        }
    }

    public void mo181a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.f1058c) {
            m1609b(3);
        } else if (view == this.f1068m.get() && this.f1065j) {
            int i2;
            if (this.f1064i > 0) {
                i2 = this.f1058c;
            } else if (this.f1060e && m1607a((View) v, m1608b())) {
                i2 = this.f1066k;
                i = 5;
            } else if (this.f1064i == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f1058c) < Math.abs(top - this.f1059d)) {
                    i2 = this.f1058c;
                } else {
                    i2 = this.f1059d;
                    i = 4;
                }
            } else {
                i2 = this.f1059d;
                i = 4;
            }
            if (this.f1062g.m4832a((View) v, v.getLeft(), i2)) {
                m1609b(2);
                ao.m3913a((View) v, new C0225b(this, v, i));
            } else {
                m1609b(i);
            }
            this.f1065j = false;
        }
    }

    public boolean mo198a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f1068m.get() && (this.f1061f != 3 || super.mo198a(coordinatorLayout, (View) v, view, f, f2));
    }

    public final void m1621a(int i) {
        this.f1057b = Math.max(0, i);
        this.f1059d = this.f1066k - i;
    }

    public void m1625a(boolean z) {
        this.f1060e = z;
    }

    private void m1609b(int i) {
        if (this.f1061f != i) {
            this.f1061f = i;
            View view = (View) this.f1067l.get();
            if (view != null && this.f1069n != null) {
                this.f1069n.m1601a(view, i);
            }
        }
    }

    private void m1604a() {
        this.f1071p = -1;
        if (this.f1070o != null) {
            this.f1070o.recycle();
            this.f1070o = null;
        }
    }

    private boolean m1607a(View view, float f) {
        if (view.getTop() >= this.f1059d && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f1059d)) / ((float) this.f1057b) > 0.5f) {
            return true;
        }
        return false;
    }

    private View m1603a(View view) {
        if (view instanceof ae) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = m1603a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    private float m1608b() {
        this.f1070o.computeCurrentVelocity(1000, this.f1056a);
        return am.m3670b(this.f1070o, this.f1071p);
    }

    private void m1613c(int i) {
        View view = (View) this.f1067l.get();
        if (view != null && this.f1069n != null) {
            if (i > this.f1059d) {
                this.f1069n.m1600a(view, ((float) (this.f1059d - i)) / ((float) this.f1057b));
            } else {
                this.f1069n.m1600a(view, ((float) (this.f1059d - i)) / ((float) (this.f1059d - this.f1058c)));
            }
        }
    }
}
