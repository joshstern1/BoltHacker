package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

class ay {
    private static Field f2393a;
    private static boolean f2394b;
    private static Field f2395c;
    private static boolean f2396d;

    static int m4799a(TextView textView) {
        if (!f2396d) {
            f2395c = m4801a("mMaxMode");
            f2396d = true;
        }
        if (f2395c != null && m4800a(f2395c, textView) == 1) {
            if (!f2394b) {
                f2393a = m4801a("mMaximum");
                f2394b = true;
            }
            if (f2393a != null) {
                return m4800a(f2393a, textView);
            }
        }
        return -1;
    }

    private static Field m4801a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    private static int m4800a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }
}
