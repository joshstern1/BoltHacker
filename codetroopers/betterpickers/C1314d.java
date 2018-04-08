package com.codetroopers.betterpickers;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import com.p059c.p060a.C1257i;
import com.p059c.p060a.C1260k;
import com.p059c.p060a.aa;
import com.p059c.p062c.p063a.C1280a;

public class C1314d {
    public static boolean m8598a() {
        return VERSION.SDK_INT >= 16;
    }

    @SuppressLint({"NewApi"})
    public static void m8597a(View view, CharSequence charSequence) {
        if (C1314d.m8598a() && view != null && charSequence != null) {
            view.announceForAccessibility(charSequence);
        }
    }

    public static int m8595a(int i, int i2) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                return ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) ? 28 : 29;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }

    public static C1260k m8596a(View view, float f, float f2) {
        C1257i a = C1257i.m8364a(0.0f, 1.0f);
        C1257i a2 = C1257i.m8364a(0.275f, f);
        C1257i a3 = C1257i.m8364a(0.69f, f2);
        C1257i a4 = C1257i.m8364a(1.0f, 1.0f);
        aa a5 = aa.m8245a("scaleX", a, a2, a3, a4);
        aa a6 = aa.m8245a("scaleY", a, a2, a3, a4);
        if (C1280a.f4708a) {
            view = C1280a.m8460a(view);
        }
        C1260k a7 = C1260k.m8383a(view, a5, a6);
        a7.mo1238a(544);
        return a7;
    }
}
