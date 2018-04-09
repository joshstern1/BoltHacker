package android.support.v7.p027a;

class C0830z implements Runnable {
    final /* synthetic */ C0819y f2782a;

    C0830z(C0819y c0819y) {
        this.f2782a = c0819y;
    }

    public void run() {
        if ((this.f2782a.f2725F & 1) != 0) {
            this.f2782a.m5389f(0);
        }
        if ((this.f2782a.f2725F & 4096) != 0) {
            this.f2782a.m5389f(108);
        }
        this.f2782a.f2724E = false;
        this.f2782a.f2725F = 0;
    }
}
