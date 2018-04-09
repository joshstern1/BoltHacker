package android.support.v4.view.p025a;

import android.view.accessibility.AccessibilityEvent;

class C0528b {
    public static void m3250a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public static int m3249a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
