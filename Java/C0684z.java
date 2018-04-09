package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class C0684z {
    static final C0678f f2159a;

    interface C0678f {
        int mo659a(MotionEvent motionEvent);

        int mo660a(MotionEvent motionEvent, int i);

        int mo661b(MotionEvent motionEvent);

        int mo662b(MotionEvent motionEvent, int i);

        float mo663c(MotionEvent motionEvent, int i);

        float mo664d(MotionEvent motionEvent, int i);

        float mo665e(MotionEvent motionEvent, int i);
    }

    static class C0679a implements C0678f {
        C0679a() {
        }

        public int mo660a(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        public int mo662b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo663c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo664d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int mo659a(MotionEvent motionEvent) {
            return 1;
        }

        public int mo661b(MotionEvent motionEvent) {
            return 0;
        }

        public float mo665e(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    static class C0680b extends C0679a {
        C0680b() {
        }

        public int mo660a(MotionEvent motionEvent, int i) {
            return ab.m3645a(motionEvent, i);
        }

        public int mo662b(MotionEvent motionEvent, int i) {
            return ab.m3646b(motionEvent, i);
        }

        public float mo663c(MotionEvent motionEvent, int i) {
            return ab.m3647c(motionEvent, i);
        }

        public float mo664d(MotionEvent motionEvent, int i) {
            return ab.m3648d(motionEvent, i);
        }

        public int mo659a(MotionEvent motionEvent) {
            return ab.m3644a(motionEvent);
        }
    }

    static class C0681c extends C0680b {
        C0681c() {
        }

        public int mo661b(MotionEvent motionEvent) {
            return ac.m3649a(motionEvent);
        }
    }

    static class C0682d extends C0681c {
        C0682d() {
        }

        public float mo665e(MotionEvent motionEvent, int i) {
            return ad.m3650a(motionEvent, i);
        }
    }

    private static class C0683e extends C0682d {
        private C0683e() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f2159a = new C0683e();
        } else if (VERSION.SDK_INT >= 12) {
            f2159a = new C0682d();
        } else if (VERSION.SDK_INT >= 9) {
            f2159a = new C0681c();
        } else if (VERSION.SDK_INT >= 5) {
            f2159a = new C0680b();
        } else {
            f2159a = new C0679a();
        }
    }

    public static int m4397a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m4399b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m4398a(MotionEvent motionEvent, int i) {
        return f2159a.mo660a(motionEvent, i);
    }

    public static int m4400b(MotionEvent motionEvent, int i) {
        return f2159a.mo662b(motionEvent, i);
    }

    public static float m4401c(MotionEvent motionEvent, int i) {
        return f2159a.mo663c(motionEvent, i);
    }

    public static float m4403d(MotionEvent motionEvent, int i) {
        return f2159a.mo664d(motionEvent, i);
    }

    public static int m4402c(MotionEvent motionEvent) {
        return f2159a.mo659a(motionEvent);
    }

    public static int m4404d(MotionEvent motionEvent) {
        return f2159a.mo661b(motionEvent);
    }

    public static float m4405e(MotionEvent motionEvent, int i) {
        return f2159a.mo665e(motionEvent, i);
    }
}
