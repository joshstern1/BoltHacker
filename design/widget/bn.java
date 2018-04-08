package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class bn {
    private static final C0268a f1348a;

    private interface C0268a {
        void mo270a(ViewGroup viewGroup, View view, Rect rect);
    }

    private static class C0269b implements C0268a {
        private C0269b() {
        }

        public void mo270a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    private static class C0270c implements C0268a {
        private C0270c() {
        }

        public void mo270a(ViewGroup viewGroup, View view, Rect rect) {
            bo.m2084a(viewGroup, view, rect);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1348a = new C0270c();
        } else {
            f1348a = new C0269b();
        }
    }

    static void m2082a(ViewGroup viewGroup, View view, Rect rect) {
        f1348a.mo270a(viewGroup, view, rect);
    }

    static void m2083b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m2082a(viewGroup, view, rect);
    }
}
