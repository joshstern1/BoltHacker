package no.nordicsemi.android.support.v18.scanner;

class C3102h implements Runnable {
    final /* synthetic */ C3101g f10247a;

    C3102h(C3101g c3101g) {
        this.f10247a = c3101g;
    }

    public void run() {
        if (this.f10247a.f10240a != null && this.f10247a.f10242c > 0 && this.f10247a.f10243d > 0) {
            this.f10247a.f10240a.stopLeScan(this.f10247a);
            if (this.f10247a.f10244e != null) {
                this.f10247a.f10244e.postDelayed(this.f10247a.f10246g, this.f10247a.f10242c);
            }
        }
    }
}
