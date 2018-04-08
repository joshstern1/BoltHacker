package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.C0645j;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0834d;
import android.support.v7.view.menu.C0211t.C0770a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class C0891r {
    private final Context f3013a;
    private final C0197k f3014b;
    private final boolean f3015c;
    private final int f3016d;
    private final int f3017e;
    private View f3018f;
    private int f3019g;
    private boolean f3020h;
    private C0770a f3021i;
    private C0873q f3022j;
    private OnDismissListener f3023k;
    private final OnDismissListener f3024l;

    public C0891r(Context context, C0197k c0197k, View view, boolean z, int i) {
        this(context, c0197k, view, z, i, 0);
    }

    public C0891r(Context context, C0197k c0197k, View view, boolean z, int i, int i2) {
        this.f3019g = 8388611;
        this.f3024l = new C0892s(this);
        this.f3013a = context;
        this.f3014b = c0197k;
        this.f3018f = view;
        this.f3015c = z;
        this.f3016d = i;
        this.f3017e = i2;
    }

    public void m5745a(OnDismissListener onDismissListener) {
        this.f3023k = onDismissListener;
    }

    public void m5744a(View view) {
        this.f3018f = view;
    }

    public void m5746a(boolean z) {
        this.f3020h = z;
        if (this.f3022j != null) {
            this.f3022j.mo865b(z);
        }
    }

    public void m5742a(int i) {
        this.f3019g = i;
    }

    public void m5741a() {
        if (!m5749c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public C0873q m5748b() {
        if (this.f3022j == null) {
            this.f3022j = m5740g();
        }
        return this.f3022j;
    }

    public boolean m5749c() {
        if (m5752f()) {
            return true;
        }
        if (this.f3018f == null) {
            return false;
        }
        m5739a(0, 0, false, false);
        return true;
    }

    public boolean m5747a(int i, int i2) {
        if (m5752f()) {
            return true;
        }
        if (this.f3018f == null) {
            return false;
        }
        m5739a(i, i2, true, true);
        return true;
    }

    private C0873q m5740g() {
        C0873q c0874e;
        Display defaultDisplay = ((WindowManager) this.f3013a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        if ((Math.min(point.x, point.y) >= this.f3013a.getResources().getDimensionPixelSize(C0834d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null) {
            c0874e = new C0874e(this.f3013a, this.f3018f, this.f3016d, this.f3017e, this.f3015c);
        } else {
            c0874e = new C0894y(this.f3013a, this.f3014b, this.f3018f, this.f3016d, this.f3017e, this.f3015c);
        }
        c0874e.mo861a(this.f3014b);
        c0874e.mo863a(this.f3024l);
        c0874e.mo862a(this.f3018f);
        c0874e.mo152a(this.f3021i);
        c0874e.mo865b(this.f3020h);
        c0874e.mo860a(this.f3019g);
        return c0874e;
    }

    private void m5739a(int i, int i2, boolean z, boolean z2) {
        C0873q b = m5748b();
        b.mo867c(z2);
        if (z) {
            if ((C0645j.m4290a(this.f3019g, ao.m3938h(this.f3018f)) & 7) == 5) {
                i -= this.f3018f.getWidth();
            }
            b.mo864b(i);
            b.mo866c(i2);
            int i3 = (int) ((this.f3013a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.m5622a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.mo868d();
    }

    public void m5750d() {
        if (m5752f()) {
            this.f3022j.mo869e();
        }
    }

    protected void mo907e() {
        this.f3022j = null;
        if (this.f3023k != null) {
            this.f3023k.onDismiss();
        }
    }

    public boolean m5752f() {
        return this.f3022j != null && this.f3022j.mo870f();
    }

    public void m5743a(C0770a c0770a) {
        this.f3021i = c0770a;
        if (this.f3022j != null) {
            this.f3022j.mo152a(c0770a);
        }
    }
}
