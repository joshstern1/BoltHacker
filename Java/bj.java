package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

class bj implements ai {
    final /* synthetic */ ViewPager f2120a;
    private final Rect f2121b = new Rect();

    bj(ViewPager viewPager) {
        this.f2120a = viewPager;
    }

    public bz mo172a(View view, bz bzVar) {
        bz a = ao.m3902a(view, bzVar);
        if (a.mo631e()) {
            return a;
        }
        Rect rect = this.f2121b;
        rect.left = a.mo626a();
        rect.top = a.mo628b();
        rect.right = a.mo629c();
        rect.bottom = a.mo630d();
        int childCount = this.f2120a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            bz b = ao.m3919b(this.f2120a.getChildAt(i), a);
            rect.left = Math.min(b.mo626a(), rect.left);
            rect.top = Math.min(b.mo628b(), rect.top);
            rect.right = Math.min(b.mo629c(), rect.right);
            rect.bottom = Math.min(b.mo630d(), rect.bottom);
        }
        return a.mo627a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
