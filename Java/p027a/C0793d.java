package android.support.v7.p027a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class C0793d {
    private static final int[] f2585a = new int[]{16843531};

    static class C0792a {
        public Method f2582a;
        public Method f2583b;
        public ImageView f2584c;

        C0792a(Activity activity) {
            try {
                this.f2582a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f2583b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException e) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        findViewById = viewGroup.getChildAt(1);
                        if (childAt.getId() != 16908332) {
                            findViewById = childAt;
                        }
                        if (findViewById instanceof ImageView) {
                            this.f2584c = (ImageView) findViewById;
                        }
                    }
                }
            }
        }
    }

    public static C0792a m5227a(C0792a c0792a, Activity activity, Drawable drawable, int i) {
        C0792a c0792a2 = new C0792a(activity);
        if (c0792a2.f2582a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                c0792a2.f2582a.invoke(actionBar, new Object[]{drawable});
                c0792a2.f2583b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (c0792a2.f2584c != null) {
            c0792a2.f2584c.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return c0792a2;
    }

    public static C0792a m5226a(C0792a c0792a, Activity activity, int i) {
        if (c0792a == null) {
            c0792a = new C0792a(activity);
        }
        if (c0792a.f2582a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                c0792a.f2583b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return c0792a;
    }

    public static Drawable m5225a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(f2585a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
}
