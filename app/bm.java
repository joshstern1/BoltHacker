package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.bl.C0367a;

class bm {
    static Bundle m2625a(C0367a c0367a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0367a.mo333a());
        bundle.putCharSequence("label", c0367a.mo334b());
        bundle.putCharSequenceArray("choices", c0367a.mo335c());
        bundle.putBoolean("allowFreeFormInput", c0367a.mo336d());
        bundle.putBundle("extras", c0367a.mo337e());
        return bundle;
    }

    static Bundle[] m2626a(C0367a[] c0367aArr) {
        if (c0367aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0367aArr.length];
        for (int i = 0; i < c0367aArr.length; i++) {
            bundleArr[i] = m2625a(c0367aArr[i]);
        }
        return bundleArr;
    }
}
