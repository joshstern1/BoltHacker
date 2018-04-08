package com.p041a.p042a.p051c;

import android.content.Context;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p121f.C3023a;
import java.io.File;
import java.util.Set;

class ar {
    private static final C1127a f4253a = new C1127a();
    private final Context f4254b;
    private final C3023a f4255c;
    private aq f4256d;

    private static final class C1127a implements aq {
        private C1127a() {
        }

        public C1142b mo1179a() {
            return null;
        }

        public void mo1180b() {
        }

        public void mo1181c() {
        }
    }

    public ar(Context context, C3023a c3023a) {
        this(context, c3023a, null);
    }

    public ar(Context context, C3023a c3023a, String str) {
        this.f4254b = context;
        this.f4255c = c3023a;
        this.f4256d = f4253a;
        m7772a(str);
    }

    public final void m7772a(String str) {
        this.f4256d.mo1180b();
        this.f4256d = f4253a;
        if (str != null) {
            if (m7768c()) {
                m7771a(m7767b(str), 65536);
            } else {
                C3059d.m17342h().mo2431a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    public C1142b m7770a() {
        return this.f4256d.mo1179a();
    }

    public void m7774b() {
        this.f4256d.mo1181c();
    }

    public void m7773a(Set<String> set) {
        File[] listFiles = m7769d().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m7766a(file))) {
                    file.delete();
                }
            }
        }
    }

    void m7771a(File file, int i) {
        this.f4256d = new ax(file, i);
    }

    private File m7767b(String str) {
        return new File(m7769d(), "crashlytics-userlog-" + str + ".temp");
    }

    private String m7766a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), lastIndexOf);
    }

    private boolean m7768c() {
        return C2956j.m16999a(this.f4254b, "com.crashlytics.CollectCustomLogs", true);
    }

    private File m7769d() {
        File file = new File(this.f4255c.mo2419a(), "log-files");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
