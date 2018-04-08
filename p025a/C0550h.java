package android.support.v4.view.p025a;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class C0550h {
    public static void m3527a(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).addChild(view, i);
    }

    public static void m3530b(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setSource(view, i);
    }

    public static boolean m3529a(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public static void m3528a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    public static boolean m3532b(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    public static void m3531b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }
}
