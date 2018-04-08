package android.support.v4.p023f;

import java.util.Locale;

public final class C0487e {
    public static final C0480d f1925a = new C0485e(null, false);
    public static final C0480d f1926b = new C0485e(null, true);
    public static final C0480d f1927c = new C0485e(C0483b.f1921a, false);
    public static final C0480d f1928d = new C0485e(C0483b.f1921a, true);
    public static final C0480d f1929e = new C0485e(C0482a.f1918a, false);
    public static final C0480d f1930f = C0486f.f1924a;

    private interface C0481c {
        int mo415a(CharSequence charSequence, int i, int i2);
    }

    private static class C0482a implements C0481c {
        public static final C0482a f1918a = new C0482a(true);
        public static final C0482a f1919b = new C0482a(false);
        private final boolean f1920c;

        public int mo415a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 0;
            while (i < i3) {
                switch (C0487e.m3083c(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.f1920c) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.f1920c) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
                i++;
            }
            if (i4 == 0) {
                return 2;
            }
            if (this.f1920c) {
                return 1;
            }
            return 0;
        }

        private C0482a(boolean z) {
            this.f1920c = z;
        }
    }

    private static class C0483b implements C0481c {
        public static final C0483b f1921a = new C0483b();

        public int mo415a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = C0487e.m3084d(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private C0483b() {
        }
    }

    private static abstract class C0484d implements C0480d {
        private final C0481c f1922a;

        protected abstract boolean mo417a();

        public C0484d(C0481c c0481c) {
            this.f1922a = c0481c;
        }

        public boolean mo416a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f1922a == null) {
                return mo417a();
            } else {
                return m3076b(charSequence, i, i2);
            }
        }

        private boolean m3076b(CharSequence charSequence, int i, int i2) {
            switch (this.f1922a.mo415a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo417a();
            }
        }
    }

    private static class C0485e extends C0484d {
        private final boolean f1923a;

        private C0485e(C0481c c0481c, boolean z) {
            super(c0481c);
            this.f1923a = z;
        }

        protected boolean mo417a() {
            return this.f1923a;
        }
    }

    private static class C0486f extends C0484d {
        public static final C0486f f1924a = new C0486f();

        public C0486f() {
            super(null);
        }

        protected boolean mo417a() {
            if (C0491g.m3088a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    private static int m3083c(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    private static int m3084d(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
