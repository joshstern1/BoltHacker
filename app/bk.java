package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.bl.C0367a;

class bk {
    static RemoteInput[] m2624a(C0367a[] c0367aArr) {
        if (c0367aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0367aArr.length];
        for (int i = 0; i < c0367aArr.length; i++) {
            C0367a c0367a = c0367aArr[i];
            remoteInputArr[i] = new Builder(c0367a.mo333a()).setLabel(c0367a.mo334b()).setChoices(c0367a.mo335c()).setAllowFreeFormInput(c0367a.mo336d()).addExtras(c0367a.mo337e()).build();
        }
        return remoteInputArr;
    }
}
