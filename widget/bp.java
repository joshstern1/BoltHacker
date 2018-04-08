package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.C0917h;
import android.view.View;

public abstract class bp {
    protected final C0917h f3728a;
    final Rect f3729b;
    private int f3730c;

    public abstract int mo1009a(View view);

    public abstract void mo1010a(int i);

    public abstract int mo1011b(View view);

    public abstract int mo1012c();

    public abstract int mo1013c(View view);

    public abstract int mo1014d();

    public abstract int mo1015d(View view);

    public abstract int mo1016e();

    public abstract int mo1017e(View view);

    public abstract int mo1018f();

    public abstract int mo1019f(View view);

    public abstract int mo1020g();

    public abstract int mo1021h();

    public abstract int mo1022i();

    private bp(C0917h c0917h) {
        this.f3730c = Integer.MIN_VALUE;
        this.f3729b = new Rect();
        this.f3728a = c0917h;
    }

    public void m6907a() {
        this.f3730c = mo1018f();
    }

    public int m6909b() {
        return Integer.MIN_VALUE == this.f3730c ? 0 : mo1018f() - this.f3730c;
    }

    public static bp m6904a(C0917h c0917h, int i) {
        switch (i) {
            case 0:
                return m6903a(c0917h);
            case 1:
                return m6905b(c0917h);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static bp m6903a(C0917h c0917h) {
        return new bq(c0917h);
    }

    public static bp m6905b(C0917h c0917h) {
        return new br(c0917h);
    }
}
