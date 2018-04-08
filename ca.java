package android.support.v4.view;

import android.view.WindowInsets;

class ca extends bz {
    private final WindowInsets f2143a;

    ca(WindowInsets windowInsets) {
        this.f2143a = windowInsets;
    }

    public int mo626a() {
        return this.f2143a.getSystemWindowInsetLeft();
    }

    public int mo628b() {
        return this.f2143a.getSystemWindowInsetTop();
    }

    public int mo629c() {
        return this.f2143a.getSystemWindowInsetRight();
    }

    public int mo630d() {
        return this.f2143a.getSystemWindowInsetBottom();
    }

    public boolean mo631e() {
        return this.f2143a.isConsumed();
    }

    public bz mo632f() {
        return new ca(this.f2143a.consumeSystemWindowInsets());
    }

    public bz mo627a(int i, int i2, int i3, int i4) {
        return new ca(this.f2143a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    WindowInsets m4240g() {
        return this.f2143a;
    }
}
