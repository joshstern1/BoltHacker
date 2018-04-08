package no.nordicsemi.android.support.v18.scanner;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.support.v18.scanner.ScanSettings.C3092a;

public abstract class C3095a {
    private static C3095a f10227a;
    private final Handler f10228b = new Handler(Looper.getMainLooper());

    class C3094a {
        final /* synthetic */ C3095a f10218a;
        private final List<ScanFilter> f10219b;
        private final ScanSettings f10220c;
        private final C2551o f10221d;
        private final List<ScanResult> f10222e;
        private final List<String> f10223f;
        private C3093a f10224g;
        private final Map<String, ScanResult> f10225h;
        private final Runnable f10226i = new C3097c(this);

        private class C3093a implements Runnable {
            final /* synthetic */ C3094a f10216a;
            private final List<ScanResult> f10217b;

            private C3093a(C3094a c3094a) {
                this.f10216a = c3094a;
                this.f10217b = new ArrayList();
            }

            public void run() {
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                for (ScanResult scanResult : this.f10216a.f10225h.values()) {
                    if (scanResult.m17435d() < elapsedRealtimeNanos - this.f10216a.f10220c.m17447i()) {
                        this.f10217b.add(scanResult);
                    }
                }
                if (!this.f10217b.isEmpty()) {
                    for (ScanResult scanResult2 : this.f10217b) {
                        this.f10216a.f10225h.remove(scanResult2.m17432a().getAddress());
                        this.f10216a.m17456a(false, scanResult2);
                    }
                    this.f10217b.clear();
                }
                this.f10216a.f10218a.f10228b.postDelayed(this.f10216a.f10224g, this.f10216a.f10220c.m17448j());
            }
        }

        C3094a(C3095a c3095a, List<ScanFilter> list, ScanSettings scanSettings, C2551o c2551o) {
            this.f10218a = c3095a;
            this.f10219b = list;
            this.f10220c = scanSettings;
            this.f10221d = c2551o;
            if (scanSettings.m17440b() == 1 || scanSettings.m17445g()) {
                this.f10225h = null;
            } else {
                this.f10225h = new HashMap();
            }
            long k = scanSettings.m17449k();
            if (k > 0) {
                this.f10222e = new ArrayList();
                this.f10223f = new ArrayList();
                c3095a.f10228b.postDelayed(this.f10226i, k);
                return;
            }
            this.f10222e = null;
            this.f10223f = null;
        }

        void m17462a() {
            if (this.f10222e != null) {
                this.f10218a.f10228b.removeCallbacks(this.f10226i);
            }
            if (this.f10225h != null) {
                this.f10225h.clear();
            }
            if (this.f10224g != null) {
                this.f10218a.f10228b.removeCallbacks(this.f10224g);
                this.f10224g = null;
            }
        }

        ScanSettings m17466b() {
            return this.f10220c;
        }

        List<ScanFilter> m17467c() {
            return this.f10219b;
        }

        C2551o m17468d() {
            return this.f10221d;
        }

        void m17469e() {
            if (this.f10222e != null) {
                synchronized (this.f10222e) {
                    this.f10221d.m15346a(this.f10222e);
                    this.f10222e.clear();
                    this.f10223f.clear();
                }
            }
        }

        void m17465a(ScanResult scanResult) {
            if (this.f10219b == null || this.f10219b.isEmpty() || m17458b(scanResult)) {
                String address = scanResult.m17432a().getAddress();
                if (this.f10225h != null) {
                    if (((ScanResult) this.f10225h.put(address, scanResult)) == null && (this.f10220c.m17440b() & 2) > 0) {
                        m17456a(true, scanResult);
                    }
                    if ((this.f10220c.m17440b() & 4) > 0 && this.f10224g == null) {
                        this.f10224g = new C3093a();
                        this.f10218a.f10228b.postDelayed(this.f10224g, this.f10220c.m17448j());
                    }
                } else if (this.f10220c.m17449k() > 0) {
                    synchronized (this.f10222e) {
                        if (!this.f10223f.contains(address)) {
                            this.f10222e.add(scanResult);
                            this.f10223f.add(address);
                        }
                    }
                } else {
                    m17460c(scanResult);
                }
            }
        }

        void m17464a(List<ScanResult> list, boolean z) {
            List list2;
            if (!(this.f10219b == null || (z && this.f10220c.m17443e()))) {
                List<ScanResult> arrayList = new ArrayList();
                for (ScanResult scanResult : list) {
                    if (m17458b(scanResult)) {
                        arrayList.add(scanResult);
                    }
                }
                list2 = arrayList;
            }
            m17454a(list2);
        }

        private boolean m17458b(ScanResult scanResult) {
            for (ScanFilter a : this.f10219b) {
                if (a.m17421a(scanResult)) {
                    return true;
                }
            }
            return false;
        }

        private void m17460c(ScanResult scanResult) {
            this.f10218a.f10228b.post(new C3098d(this, scanResult));
        }

        private void m17454a(List<ScanResult> list) {
            this.f10218a.f10228b.post(new C3099e(this, list));
        }

        private void m17456a(boolean z, ScanResult scanResult) {
            this.f10218a.f10228b.post(new C3100f(this, z, scanResult));
        }

        void m17463a(int i) {
            this.f10218a.m17473a(this.f10221d, i);
        }
    }

    abstract void mo2525b(List<ScanFilter> list, ScanSettings scanSettings, C2551o c2551o);

    public abstract void mo2526b(C2551o c2551o);

    public static C3095a m17471a() {
        if (f10227a != null) {
            return f10227a;
        }
        C3095a c3107k;
        if (VERSION.SDK_INT >= 23) {
            c3107k = new C3107k();
            f10227a = c3107k;
            return c3107k;
        } else if (VERSION.SDK_INT >= 21) {
            c3107k = new C3106j();
            f10227a = c3107k;
            return c3107k;
        } else {
            c3107k = new C3101g();
            f10227a = c3107k;
            return c3107k;
        }
    }

    C3095a() {
    }

    public void m17475a(C2551o c2551o) {
        if (c2551o == null) {
            throw new IllegalArgumentException("callback is null");
        }
        mo2525b(null, new C3092a().m17438a(), c2551o);
    }

    public void m17474a(List<ScanFilter> list, ScanSettings scanSettings, C2551o c2551o) {
        if (scanSettings == null || c2551o == null) {
            throw new IllegalArgumentException("settings or callback is null");
        }
        mo2525b(list, scanSettings, c2551o);
    }

    private void m17473a(C2551o c2551o, int i) {
        this.f10228b.post(new C3096b(this, c2551o, i));
    }
}
