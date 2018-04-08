package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0220b;
import android.support.v4.view.C0684z;
import android.support.v4.view.ao;
import android.support.v4.widget.bd;
import android.support.v4.widget.bd.C0258a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior<V extends View> extends C0220b<V> {
    private bd f1148a;
    private C0239a f1149b;
    private boolean f1150c;
    private float f1151d = 0.0f;
    private boolean f1152e;
    private int f1153f = 2;
    private float f1154g = 0.5f;
    private float f1155h = 0.0f;
    private float f1156i = 0.5f;
    private final C0258a f1157j = new at(this);

    public interface C0239a {
        void mo229a(int i);

        void mo230a(View view);
    }

    private class C0240b implements Runnable {
        final /* synthetic */ SwipeDismissBehavior f1165a;
        private final View f1166b;
        private final boolean f1167c;

        C0240b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f1165a = swipeDismissBehavior;
            this.f1166b = view;
            this.f1167c = z;
        }

        public void run() {
            if (this.f1165a.f1148a != null && this.f1165a.f1148a.m4833a(true)) {
                ao.m3913a(this.f1166b, (Runnable) this);
            } else if (this.f1167c && this.f1165a.f1149b != null) {
                this.f1165a.f1149b.mo230a(this.f1166b);
            }
        }
    }

    public void m1753a(C0239a c0239a) {
        this.f1149b = c0239a;
    }

    public void m1752a(int i) {
        this.f1153f = i;
    }

    public void m1751a(float f) {
        this.f1155h = m1746c(0.0f, f, 1.0f);
    }

    public void m1756b(float f) {
        this.f1156i = m1746c(0.0f, f, 1.0f);
    }

    public boolean mo174a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (C0684z.m4397a(motionEvent)) {
            case 1:
            case 3:
                if (this.f1150c) {
                    this.f1150c = false;
                    return false;
                }
                break;
            default:
                boolean z;
                if (coordinatorLayout.m1681a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z = false;
                } else {
                    z = true;
                }
                this.f1150c = z;
                break;
        }
        if (this.f1150c) {
            return false;
        }
        m1742a((ViewGroup) coordinatorLayout);
        return this.f1148a.m4831a(motionEvent);
    }

    public boolean mo175b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f1148a == null) {
            return false;
        }
        this.f1148a.m4835b(motionEvent);
        return true;
    }

    public boolean mo212a(View view) {
        return true;
    }

    private void m1742a(ViewGroup viewGroup) {
        if (this.f1148a == null) {
            this.f1148a = this.f1152e ? bd.m4808a(viewGroup, this.f1151d, this.f1157j) : bd.m4809a(viewGroup, this.f1157j);
        }
    }

    private static float m1746c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    private static int m1744b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    static float m1739a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
