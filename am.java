package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class am {
    static final C0577c f2098a;

    interface C0577c {
        float mo513a(VelocityTracker velocityTracker, int i);

        float mo514b(VelocityTracker velocityTracker, int i);
    }

    static class C0578a implements C0577c {
        C0578a() {
        }

        public float mo513a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float mo514b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class C0579b implements C0577c {
        C0579b() {
        }

        public float mo513a(VelocityTracker velocityTracker, int i) {
            return an.m3671a(velocityTracker, i);
        }

        public float mo514b(VelocityTracker velocityTracker, int i) {
            return an.m3672b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f2098a = new C0579b();
        } else {
            f2098a = new C0578a();
        }
    }

    public static float m3669a(VelocityTracker velocityTracker, int i) {
        return f2098a.mo513a(velocityTracker, i);
    }

    public static float m3670b(VelocityTracker velocityTracker, int i) {
        return f2098a.mo514b(velocityTracker, i);
    }
}
