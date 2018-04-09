package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class af {
    private final View f2092a;
    private ViewParent f2093b;
    private boolean f2094c;
    private int[] f2095d;

    public af(View view) {
        this.f2092a = view;
    }

    public void m3651a(boolean z) {
        if (this.f2094c) {
            ao.m3894F(this.f2092a);
        }
        this.f2094c = z;
    }

    public boolean m3652a() {
        return this.f2094c;
    }

    public boolean m3658b() {
        return this.f2093b != null;
    }

    public boolean m3655a(int i) {
        if (m3658b()) {
            return true;
        }
        if (m3652a()) {
            View view = this.f2092a;
            for (ViewParent parent = this.f2092a.getParent(); parent != null; parent = parent.getParent()) {
                if (bl.m4130a(parent, view, this.f2092a, i)) {
                    this.f2093b = parent;
                    bl.m4132b(parent, view, this.f2092a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void m3659c() {
        if (this.f2093b != null) {
            bl.m4125a(this.f2093b, this.f2092a);
            this.f2093b = null;
        }
    }

    public boolean m3656a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m3652a() || this.f2093b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f2092a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            bl.m4126a(this.f2093b, this.f2092a, i, i2, i3, i4);
            if (iArr != null) {
                this.f2092a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m3657a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m3652a() || this.f2093b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f2092a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f2095d == null) {
                    this.f2095d = new int[2];
                }
                iArr = this.f2095d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            bl.m4127a(this.f2093b, this.f2092a, i, i2, iArr);
            if (iArr2 != null) {
                this.f2092a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m3654a(float f, float f2, boolean z) {
        if (!m3652a() || this.f2093b == null) {
            return false;
        }
        return bl.m4129a(this.f2093b, this.f2092a, f, f2, z);
    }

    public boolean m3653a(float f, float f2) {
        if (!m3652a() || this.f2093b == null) {
            return false;
        }
        return bl.m4128a(this.f2093b, this.f2092a, f, f2);
    }
}
