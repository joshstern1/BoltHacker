package com.p041a.p042a.p043a;

import android.content.Context;
import android.os.Looper;
import io.p038b.p039a.p040a.p044a.p045d.C3005h;
import io.p038b.p039a.p040a.p044a.p046b.C2975z;
import io.p038b.p039a.p040a.p044a.p121f.C3023a;
import java.io.IOException;

class C1084l {
    final Context f4126a;
    final C3023a f4127b;

    public C1084l(Context context, C3023a c3023a) {
        this.f4126a = context;
        this.f4127b = c3023a;
    }

    public aa m7641a() throws IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new aa(this.f4126a, new ag(), new C2975z(), new C3005h(this.f4126a, this.f4127b.mo2419a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
