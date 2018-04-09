package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class C0651l {
    static final C0647d f2152a;

    interface C0647d {
        void mo644a(KeyEvent keyEvent);

        boolean mo645a(int i, int i2);

        boolean mo646b(int i);

        boolean mo647b(KeyEvent keyEvent);
    }

    static class C0648a implements C0647d {
        C0648a() {
        }

        private static int m4298a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int mo648a(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean mo645a(int i, int i2) {
            if (C0648a.m4298a(C0648a.m4298a(mo648a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean mo646b(int i) {
            return (mo648a(i) & 247) == 0;
        }

        public void mo644a(KeyEvent keyEvent) {
        }

        public boolean mo647b(KeyEvent keyEvent) {
            return false;
        }
    }

    static class C0649b extends C0648a {
        C0649b() {
        }

        public void mo644a(KeyEvent keyEvent) {
            C0652m.m4313a(keyEvent);
        }
    }

    static class C0650c extends C0649b {
        C0650c() {
        }

        public int mo648a(int i) {
            return C0653n.m4314a(i);
        }

        public boolean mo645a(int i, int i2) {
            return C0653n.m4315a(i, i2);
        }

        public boolean mo646b(int i) {
            return C0653n.m4317b(i);
        }

        public boolean mo647b(KeyEvent keyEvent) {
            return C0653n.m4316a(keyEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f2152a = new C0650c();
        } else {
            f2152a = new C0648a();
        }
    }

    public static boolean m4310a(KeyEvent keyEvent, int i) {
        return f2152a.mo645a(keyEvent.getMetaState(), i);
    }

    public static boolean m4309a(KeyEvent keyEvent) {
        return f2152a.mo646b(keyEvent.getMetaState());
    }

    public static void m4311b(KeyEvent keyEvent) {
        f2152a.mo644a(keyEvent);
    }

    public static boolean m4312c(KeyEvent keyEvent) {
        return f2152a.mo647b(keyEvent);
    }
}
