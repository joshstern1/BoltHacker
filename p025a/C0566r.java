package android.support.v4.view.p025a;

import android.os.Bundle;
import android.support.v4.view.p025a.C0565q.C0561a;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class C0566r extends AccessibilityNodeProvider {
    final /* synthetic */ C0561a f2089a;

    C0566r(C0561a c0561a) {
        this.f2089a = c0561a;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f2089a.mo494a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f2089a.mo495a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f2089a.mo496a(i, i2, bundle);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f2089a.mo497b(i);
    }
}
