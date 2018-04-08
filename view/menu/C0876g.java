package android.support.v7.view.menu;

import android.os.SystemClock;
import android.support.v7.view.menu.C0874e.C0871a;
import android.support.v7.widget.bm;
import android.view.MenuItem;

class C0876g implements bm {
    final /* synthetic */ C0874e f2951a;

    C0876g(C0874e c0874e) {
        this.f2951a = c0874e;
    }

    public void mo872a(C0197k c0197k, MenuItem menuItem) {
        this.f2951a.f2930f.removeCallbacksAndMessages(c0197k);
    }

    public void mo873b(C0197k c0197k, MenuItem menuItem) {
        int i;
        this.f2951a.f2930f.removeCallbacksAndMessages(null);
        int size = this.f2951a.f2932h.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (c0197k == ((C0871a) this.f2951a.f2932h.get(i2)).f2922b) {
                i = i2;
                break;
            }
        }
        i = -1;
        if (i != -1) {
            C0871a c0871a;
            i++;
            if (i < this.f2951a.f2932h.size()) {
                c0871a = (C0871a) this.f2951a.f2932h.get(i);
            } else {
                c0871a = null;
            }
            this.f2951a.f2930f.postAtTime(new C0877h(this, c0871a, menuItem, c0197k), c0197k, SystemClock.uptimeMillis() + 200);
        }
    }
}
