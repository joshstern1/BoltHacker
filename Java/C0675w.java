package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p015d.p016a.C0462b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class C0675w {
    static final C0670d f2158a;

    interface C0670d {
        MenuItem mo653a(MenuItem menuItem, View view);

        View mo654a(MenuItem menuItem);

        void mo655a(MenuItem menuItem, int i);

        MenuItem mo656b(MenuItem menuItem, int i);

        boolean mo657b(MenuItem menuItem);

        boolean mo658c(MenuItem menuItem);
    }

    static class C0671a implements C0670d {
        C0671a() {
        }

        public void mo655a(MenuItem menuItem, int i) {
        }

        public MenuItem mo653a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public MenuItem mo656b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public View mo654a(MenuItem menuItem) {
            return null;
        }

        public boolean mo657b(MenuItem menuItem) {
            return false;
        }

        public boolean mo658c(MenuItem menuItem) {
            return false;
        }
    }

    static class C0672b implements C0670d {
        C0672b() {
        }

        public void mo655a(MenuItem menuItem, int i) {
            C0676x.m4372a(menuItem, i);
        }

        public MenuItem mo653a(MenuItem menuItem, View view) {
            return C0676x.m4370a(menuItem, view);
        }

        public MenuItem mo656b(MenuItem menuItem, int i) {
            return C0676x.m4373b(menuItem, i);
        }

        public View mo654a(MenuItem menuItem) {
            return C0676x.m4371a(menuItem);
        }

        public boolean mo657b(MenuItem menuItem) {
            return false;
        }

        public boolean mo658c(MenuItem menuItem) {
            return false;
        }
    }

    static class C0673c extends C0672b {
        C0673c() {
        }

        public boolean mo657b(MenuItem menuItem) {
            return C0677y.m4374a(menuItem);
        }

        public boolean mo658c(MenuItem menuItem) {
            return C0677y.m4375b(menuItem);
        }
    }

    public interface C0674e {
        boolean mo881a(MenuItem menuItem);

        boolean mo882b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f2158a = new C0673c();
        } else if (i >= 11) {
            f2158a = new C0672b();
        } else {
            f2158a = new C0671a();
        }
    }

    public static void m4366a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0462b) {
            ((C0462b) menuItem).setShowAsAction(i);
        } else {
            f2158a.mo655a(menuItem, i);
        }
    }

    public static MenuItem m4364a(MenuItem menuItem, View view) {
        if (menuItem instanceof C0462b) {
            return ((C0462b) menuItem).setActionView(view);
        }
        return f2158a.mo653a(menuItem, view);
    }

    public static MenuItem m4367b(MenuItem menuItem, int i) {
        if (menuItem instanceof C0462b) {
            return ((C0462b) menuItem).setActionView(i);
        }
        return f2158a.mo656b(menuItem, i);
    }

    public static View m4365a(MenuItem menuItem) {
        if (menuItem instanceof C0462b) {
            return ((C0462b) menuItem).getActionView();
        }
        return f2158a.mo654a(menuItem);
    }

    public static MenuItem m4363a(MenuItem menuItem, C0641i c0641i) {
        if (menuItem instanceof C0462b) {
            return ((C0462b) menuItem).mo849a(c0641i);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean m4368b(MenuItem menuItem) {
        if (menuItem instanceof C0462b) {
            return ((C0462b) menuItem).expandActionView();
        }
        return f2158a.mo657b(menuItem);
    }

    public static boolean m4369c(MenuItem menuItem) {
        if (menuItem instanceof C0462b) {
            return ((C0462b) menuItem).isActionViewExpanded();
        }
        return f2158a.mo658c(menuItem);
    }
}
