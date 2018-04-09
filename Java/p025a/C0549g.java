package android.support.v4.view.p025a;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class C0549g {
    public static Object m3488a() {
        return AccessibilityNodeInfo.obtain();
    }

    public static Object m3489a(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public static Object m3490a(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    public static void m3491a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static void m3493a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public static int m3496b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m3492a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m3497b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static int m3501c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getChildCount();
    }

    public static CharSequence m3506d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence m3510e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence m3512f(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence m3514g(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean m3516h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean m3517i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean m3518j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean m3519k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean m3520l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean m3521m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean m3522n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean m3523o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean m3524p(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean m3525q(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m3502c(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void m3507d(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void m3494a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m3495a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    public static void m3499b(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void m3500b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public static void m3505c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public static void m3509d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    public static void m3511e(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public static void m3504c(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void m3498b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void m3513f(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public static void m3515g(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    public static void m3503c(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void m3508d(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setText(charSequence);
    }

    public static void m3526r(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
