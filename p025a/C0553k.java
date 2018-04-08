package android.support.v4.view.p025a;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class C0553k {
    public static void m3537a(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionInfo((CollectionInfo) obj2);
    }

    public static void m3539b(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionItemInfo((CollectionItemInfo) obj2);
    }

    public static Object m3536a(int i, int i2, boolean z, int i3) {
        return CollectionInfo.obtain(i, i2, z);
    }

    public static Object m3535a(int i, int i2, int i3, int i4, boolean z) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z);
    }

    public static void m3538a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setContentInvalid(z);
    }
}
