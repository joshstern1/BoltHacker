package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class C0635e {

    public interface C0631a {
        void mo619a(View view, int i);

        void mo620a(View view, Object obj);

        boolean mo621a(View view, AccessibilityEvent accessibilityEvent);

        boolean mo622a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo623b(View view, AccessibilityEvent accessibilityEvent);

        void mo624c(View view, AccessibilityEvent accessibilityEvent);

        void mo625d(View view, AccessibilityEvent accessibilityEvent);
    }

    public static Object m4259a() {
        return new AccessibilityDelegate();
    }

    public static Object m4260a(C0631a c0631a) {
        return new C0636f(c0631a);
    }

    public static boolean m4263a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m4265b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m4262a(Object obj, View view, Object obj2) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo) obj2);
    }

    public static void m4266c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean m4264a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void m4261a(Object obj, View view, int i) {
        ((AccessibilityDelegate) obj).sendAccessibilityEvent(view, i);
    }

    public static void m4267d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
