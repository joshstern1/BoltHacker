package android.support.v4.view.p025a;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class C0548f {
    public static boolean m3487a(Object obj, Object obj2) {
        return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityAction) obj2);
    }

    public static Object m3484a(int i, int i2, boolean z, int i3) {
        return CollectionInfo.obtain(i, i2, z, i3);
    }

    public static Object m3483a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    public static void m3486a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setError(charSequence);
    }

    static Object m3485a(int i, CharSequence charSequence) {
        return new AccessibilityAction(i, charSequence);
    }
}
