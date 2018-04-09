package android.support.v4.view.p025a;

import android.view.accessibility.AccessibilityRecord;
import java.util.List;

class C0573t {
    public static List<CharSequence> m3625a(Object obj) {
        return ((AccessibilityRecord) obj).getText();
    }

    public static void m3628a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setChecked(z);
    }

    public static void m3627a(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setClassName(charSequence);
    }

    public static void m3630b(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setContentDescription(charSequence);
    }

    public static void m3631b(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setEnabled(z);
    }

    public static void m3626a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m3629b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m3633c(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setPassword(z);
    }

    public static void m3632c(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public static void m3634d(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public static void m3635d(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m3636e(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
