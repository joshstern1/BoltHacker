package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.bf.C0263d;

final class bs implements C0263d {
    bs() {
    }

    public bf mo272a() {
        return new bf(VERSION.SDK_INT >= 12 ? new bk() : new bi());
    }
}
