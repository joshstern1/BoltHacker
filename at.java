package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class at {
    public static boolean m3996a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m3998b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m3994a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m3993a(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void m3997b(View view, Object obj) {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) obj);
    }

    public static void m3995a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }
}
