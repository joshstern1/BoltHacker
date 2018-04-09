package android.support.v4.view.p025a;

import android.os.Bundle;
import android.support.v4.view.p025a.C0563o.C0559a;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class C0564p extends AccessibilityNodeProvider {
    final /* synthetic */ C0559a f2088a;

    C0564p(C0559a c0559a) {
        this.f2088a = c0559a;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f2088a.mo491a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f2088a.mo492a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f2088a.mo493a(i, i2, bundle);
    }
}
