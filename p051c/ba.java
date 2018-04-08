package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C1143i;
import io.p038b.p039a.p040a.p044a.p046b.C2954h;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ba {
    static final Map<String, String> f4307a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final FilenameFilter f4308b = new bb();
    private static final short[] f4309c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object f4310d = new Object();
    private final ak f4311e;
    private Thread f4312f;

    private class C1144a extends C1143i {
        final /* synthetic */ ba f4305a;
        private final float f4306b;

        C1144a(ba baVar, float f) {
            this.f4305a = baVar;
            this.f4306b = f;
        }

        public void mo1188a() {
            try {
                m7840b();
            } catch (Throwable e) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            this.f4305a.f4312f = null;
        }

        private void m7840b() {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Starting report processing in " + this.f4306b + " second(s)...");
            if (this.f4306b > 0.0f) {
                try {
                    Thread.sleep((long) (this.f4306b * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            C1154g e2 = C1154g.m7958e();
            C1182y o = e2.m7979o();
            List<az> a = this.f4305a.m7844a();
            if (!o.m8081a()) {
                if (a.isEmpty() || e2.m7990z()) {
                    List list = a;
                    int i = 0;
                    while (!r0.isEmpty() && !C1154g.m7958e().m7979o().m8081a()) {
                        C3059d.m17342h().mo2431a("CrashlyticsCore", "Attempting to send " + r0.size() + " report(s)");
                        for (az a2 : r0) {
                            this.f4305a.m7846a(a2);
                        }
                        List a3 = this.f4305a.m7844a();
                        if (a3.isEmpty()) {
                            list = a3;
                        } else {
                            int i2 = i + 1;
                            long j = (long) ba.f4309c[Math.min(i, ba.f4309c.length - 1)];
                            C3059d.m17342h().mo2431a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                                list = a3;
                            } catch (InterruptedException e3) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                C3059d.m17342h().mo2431a("CrashlyticsCore", "User declined to send. Removing " + a.size() + " Report(s).");
                for (az a22 : a) {
                    a22.mo1189a();
                }
            }
        }
    }

    public ba(ak akVar) {
        if (akVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f4311e = akVar;
    }

    public synchronized void m7845a(float f) {
        if (this.f4312f == null) {
            this.f4312f = new Thread(new C1144a(this, f), "Crashlytics Report Uploader");
            this.f4312f.start();
        }
    }

    boolean m7846a(az azVar) {
        boolean z = false;
        synchronized (this.f4310d) {
            try {
                boolean a = this.f4311e.mo1178a(new aj(new C2954h().m16973a(C1154g.m7958e().m7540E()), azVar));
                C3059d.m17342h().mo2435c("CrashlyticsCore", "Crashlytics report upload " + (a ? "complete: " : "FAILED: ") + azVar.mo1190b());
                if (a) {
                    azVar.mo1189a();
                    z = true;
                }
            } catch (Throwable e) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Error occurred sending report " + azVar, e);
            }
        }
        return z;
    }

    List<az> m7844a() {
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f4310d) {
            File[] listFiles = C1154g.m7958e().m7987w().listFiles(f4308b);
        }
        List<az> linkedList = new LinkedList();
        for (File file : listFiles) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Found crash report " + file.getPath());
            linkedList.add(new bd(file));
        }
        if (linkedList.isEmpty()) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
