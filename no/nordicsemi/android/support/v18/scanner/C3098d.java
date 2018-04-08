package no.nordicsemi.android.support.v18.scanner;

import no.nordicsemi.android.support.v18.scanner.C3095a.C3094a;

class C3098d implements Runnable {
    final /* synthetic */ ScanResult f10233a;
    final /* synthetic */ C3094a f10234b;

    C3098d(C3094a c3094a, ScanResult scanResult) {
        this.f10234b = c3094a;
        this.f10233a = scanResult;
    }

    public void run() {
        this.f10234b.f10221d.mo2230a(1, this.f10233a);
    }
}
