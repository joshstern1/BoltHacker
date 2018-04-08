package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p028b.C0842a.C0840j;
import android.view.LayoutInflater;

public class C0853d extends ContextWrapper {
    private int f2791a;
    private Theme f2792b;
    private LayoutInflater f2793c;

    public C0853d(Context context, int i) {
        super(context);
        this.f2791a = i;
    }

    public C0853d(Context context, Theme theme) {
        super(context);
        this.f2792b = theme;
    }

    public void setTheme(int i) {
        if (this.f2791a != i) {
            this.f2791a = i;
            m5488b();
        }
    }

    public int m5489a() {
        return this.f2791a;
    }

    public Theme getTheme() {
        if (this.f2792b != null) {
            return this.f2792b;
        }
        if (this.f2791a == 0) {
            this.f2791a = C0840j.Theme_AppCompat_Light;
        }
        m5488b();
        return this.f2792b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2793c == null) {
            this.f2793c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2793c;
    }

    protected void m5490a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void m5488b() {
        boolean z = this.f2792b == null;
        if (z) {
            this.f2792b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2792b.setTo(theme);
            }
        }
        m5490a(this.f2792b, this.f2791a, z);
    }
}
