package android.support.v4.app;

import android.view.View;

class C0392q extends C0391u {
    final /* synthetic */ Fragment f1811a;

    C0392q(Fragment fragment) {
        this.f1811a = fragment;
    }

    public View mo357a(int i) {
        if (this.f1811a.f1504S != null) {
            return this.f1811a.f1504S.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean mo358a() {
        return this.f1811a.f1504S != null;
    }
}
