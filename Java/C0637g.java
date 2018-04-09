package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0637g {

    public interface C0633a {
        Object mo633a(View view);

        void mo634a(View view, int i);

        void mo635a(View view, Object obj);

        boolean mo636a(View view, int i, Bundle bundle);

        boolean mo637a(View view, AccessibilityEvent accessibilityEvent);

        boolean mo638a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo639b(View view, AccessibilityEvent accessibilityEvent);

        void mo640c(View view, AccessibilityEvent accessibilityEvent);

        void mo641d(View view, AccessibilityEvent accessibilityEvent);
    }

    public static Object m4268a(C0633a c0633a) {
        return new C0638h(c0633a);
    }

    public static Object m4269a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m4270a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
