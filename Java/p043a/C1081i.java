package com.p041a.p042a.p043a;

import io.p038b.p039a.p040a.C3059d;

class C1081i implements Runnable {
    final /* synthetic */ C1077e f4121a;

    C1081i(C1077e c1077e) {
        this.f4121a = c1077e;
    }

    public void run() {
        try {
            af a = this.f4121a.f4114f.m7615a();
            aa a2 = this.f4121a.f4113e.m7641a();
            a2.m7565a(this.f4121a);
            this.f4121a.f4110b = new C1093t(this.f4121a.f4111c, this.f4121a.f4112d, this.f4121a.f4109a, a2, this.f4121a.f4115g, a);
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("Answers", "Failed to enable events", e);
        }
    }
}
