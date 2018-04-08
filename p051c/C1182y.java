package com.p041a.p042a.p051c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.p041a.p042a.p051c.p052a.p053a.C1120d;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p046b.C2961n;
import io.p038b.p039a.p040a.p044a.p046b.C2967t;
import io.p038b.p039a.p040a.p044a.p054g.C3045p;
import io.p038b.p039a.p040a.p044a.p054g.C3048q;
import io.p038b.p039a.p040a.p044a.p121f.C3023a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class C1182y implements UncaughtExceptionHandler {
    static final FilenameFilter f4391a = new C1183z();
    static final Comparator<File> f4392b = new ae();
    static final Comparator<File> f4393c = new af();
    static final FilenameFilter f4394d = new ag();
    private static final Pattern f4395e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> f4396f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] f4397g = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger f4398h = new AtomicInteger(0);
    private final UncaughtExceptionHandler f4399i;
    private final C3023a f4400j;
    private final AtomicBoolean f4401k;
    private final C1171r f4402l;
    private final C2967t f4403m;
    private final C1154g f4404n;
    private final ar f4405o;
    private final am f4406p;
    private final String f4407q;

    private static class C1178a implements FilenameFilter {
        private C1178a() {
        }

        public boolean accept(File file, String str) {
            return !C1182y.f4391a.accept(file, str) && C1182y.f4395e.matcher(str).matches();
        }
    }

    static class C1179b implements FilenameFilter {
        private final String f4387a;

        public C1179b(String str) {
            this.f4387a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f4387a) && !str.endsWith(".cls_temp");
        }
    }

    private static final class C1180c implements Runnable {
        private final C1154g f4388a;
        private final File f4389b;

        public C1180c(C1154g c1154g, File file) {
            this.f4388a = c1154g;
            this.f4389b = file;
        }

        public void run() {
            if (C2956j.m17019n(this.f4388a.m7540E())) {
                C3059d.m17342h().mo2431a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                ak a = this.f4388a.m7961a(C3048q.m17296a().m17300b());
                if (a != null) {
                    new ba(a).m7846a(new bd(this.f4389b, C1182y.f4396f));
                }
            }
        }
    }

    static class C1181d implements FilenameFilter {
        private final String f4390a;

        public C1181d(String str) {
            this.f4390a = str;
        }

        public boolean accept(File file, String str) {
            if (str.equals(this.f4390a + ".cls") || !str.contains(this.f4390a) || str.endsWith(".cls_temp")) {
                return false;
            }
            return true;
        }
    }

    C1182y(UncaughtExceptionHandler uncaughtExceptionHandler, C1171r c1171r, C2967t c2967t, be beVar, C3023a c3023a, C1154g c1154g) {
        this.f4399i = uncaughtExceptionHandler;
        this.f4402l = c1171r;
        this.f4403m = c2967t;
        this.f4404n = c1154g;
        this.f4407q = beVar.mo1182a();
        this.f4400j = c3023a;
        this.f4401k = new AtomicBoolean(false);
        Context E = c1154g.m7540E();
        this.f4405o = new ar(E, c3023a);
        this.f4406p = new am(E);
    }

    public synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f4401k.set(true);
        try {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            this.f4406p.m7751b();
            this.f4402l.m8017a(new ah(this, new Date(), thread, th));
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f4399i.uncaughtException(thread, th);
            this.f4401k.set(false);
        } catch (Throwable e) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f4399i.uncaughtException(thread, th);
            this.f4401k.set(false);
        } catch (Throwable th2) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f4399i.uncaughtException(thread, th);
            this.f4401k.set(false);
        }
    }

    private void m8051a(Date date, Thread thread, Throwable th) throws Exception {
        this.f4404n.m7959A();
        m8058b(date, thread, th);
        m8084d();
        m8073l();
        m8086f();
        if (!this.f4404n.m7988x()) {
            m8077p();
        }
    }

    boolean m8081a() {
        return this.f4401k.get();
    }

    void m8079a(String str, String str2, String str3) {
        this.f4402l.m8019b(new ai(this, str, str2, str3));
    }

    void m8082b() {
        this.f4402l.m8019b(new aa(this));
    }

    private String m8071j() {
        File[] n = m8075n();
        return n.length > 0 ? m8033a(n[0]) : null;
    }

    private String m8072k() {
        File[] n = m8075n();
        return n.length > 1 ? m8033a(n[1]) : null;
    }

    private String m8033a(File file) {
        return file.getName().substring(0, 35);
    }

    boolean m8083c() {
        return ((Boolean) this.f4402l.m8017a(new ab(this))).booleanValue();
    }

    private void m8073l() throws Exception {
        Date date = new Date();
        String c1145c = new C1145c(this.f4403m).toString();
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Opening an new session with ID " + c1145c);
        m8050a(c1145c, date);
        m8062c(c1145c);
        m8064d(c1145c);
        m8066e(c1145c);
        this.f4405o.m7772a(c1145c);
    }

    void m8084d() throws Exception {
        m8052a(false);
    }

    private void m8052a(boolean z) throws Exception {
        int i = z ? 1 : 0;
        m8035a(i + 8);
        File[] n = m8075n();
        if (n.length <= i) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        m8067f(m8033a(n[i]));
        C1154g c1154g = this.f4404n;
        C3045p B = C1154g.m7945B();
        if (B == null) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            m8053a(n, i, B.f10062c);
        }
    }

    private void m8053a(File[] fileArr, int i, int i2) {
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String a = m8033a(file);
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Closing session: " + a);
            m8045a(file, a, i2);
            i++;
        }
    }

    private void m8037a(C1146d c1146d) {
        if (c1146d != null) {
            try {
                c1146d.m7891a();
            } catch (Throwable e) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void m8048a(String str) {
        for (File delete : m8059b(str)) {
            delete.delete();
        }
    }

    private File[] m8059b(String str) {
        return m8055a(new C1181d(str));
    }

    private File[] m8074m() {
        return m8055a(f4391a);
    }

    File[] m8085e() {
        return m8055a(new C1179b("BeginSession"));
    }

    private File[] m8075n() {
        File[] e = m8085e();
        Arrays.sort(e, f4392b);
        return e;
    }

    private File[] m8055a(FilenameFilter filenameFilter) {
        return m8060b(m8078q().listFiles(filenameFilter));
    }

    private File[] m8060b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void m8049a(String str, int i) {
        bg.m7884a(m8078q(), new C1179b(str + "SessionEvent"), i, f4393c);
    }

    void m8086f() {
        bg.m7884a(m8078q(), f4391a, 4, f4393c);
    }

    private void m8035a(int i) {
        int i2 = 0;
        Set hashSet = new HashSet();
        File[] n = m8075n();
        int min = Math.min(i, n.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(m8033a(n[i3]));
        }
        this.f4405o.m7773a(hashSet);
        File[] a = m8055a(new C1178a());
        int length = a.length;
        while (i2 < length) {
            File file = a[i2];
            Object name = file.getName();
            Matcher matcher = f4395e.matcher(name);
            matcher.matches();
            if (!hashSet.contains(matcher.group(1))) {
                C3059d.m17342h().mo2431a("CrashlyticsCore", "Trimming open session file: " + name);
                file.delete();
            }
            i2++;
        }
    }

    private File[] m8056a(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        C3059d.m17342h().mo2431a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        m8049a(str, i);
        return m8055a(new C1179b(str + "SessionEvent"));
    }

    void m8087g() {
        this.f4402l.m8018a(new ac(this));
    }

    void m8080a(File[] fileArr) {
        m8076o();
        for (File file : fileArr) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Found invalid session part file: " + file);
            String a = m8033a(file);
            FilenameFilter adVar = new ad(this, a);
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Deleting all part files for invalid session: " + a);
            for (File file2 : m8055a(adVar)) {
                C3059d.m17342h().mo2431a("CrashlyticsCore", "Deleting session file: " + file2);
                file2.delete();
            }
        }
    }

    private void m8076o() {
        File file = new File(this.f4404n.m7987w(), "invalidClsFiles");
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
            file.delete();
        }
    }

    private void m8058b(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        try {
            String j = m8071j();
            if (j == null) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                C2956j.m16997a(null, "Failed to flush to session begin file.");
                C2956j.m16996a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C1154g.m7952a(j, th.getClass().getName());
            Closeable c1146d = new C1146d(m8078q(), j + "SessionCrash");
            try {
                flushable = C1149f.m7892a((OutputStream) c1146d);
                m8040a(flushable, date, thread, th, "crash", true);
                C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                C2956j.m16996a(c1146d, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = c1146d;
                try {
                    C3059d.m17342h().mo2439e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                    C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                    C2956j.m16996a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    e = th2;
                    C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                    C2956j.m16996a(closeable, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = c1146d;
                C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                C2956j.m16996a(closeable, "Failed to close fatal exception file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            C3059d.m17342h().mo2439e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            C2956j.m16997a(flushable, "Failed to flush to session begin file.");
            C2956j.m16996a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            C2956j.m16997a(flushable, "Failed to flush to session begin file.");
            C2956j.m16996a(closeable, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m8036a(C1120d c1120d) throws IOException {
        Closeable c1146d;
        Throwable e;
        Flushable flushable = null;
        try {
            String k = m8072k();
            if (k == null) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                C2956j.m16997a(null, "Failed to flush to session begin file.");
                C2956j.m16996a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C1154g.m7952a(k, String.format(Locale.US, "<native-crash [%s (%s)]>", new Object[]{c1120d.f4208b.f4214b, c1120d.f4208b.f4213a}));
            c1146d = new C1146d(m8078q(), k + "SessionCrash");
            try {
                flushable = C1149f.m7892a((OutputStream) c1146d);
                av.m7817a(c1120d, new ar(this.f4404n.m7540E(), this.f4400j, k), new at(m8078q()).m7785b(k), flushable);
                C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                C2956j.m16996a(c1146d, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3059d.m17342h().mo2439e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                    C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                    C2956j.m16996a(c1146d, "Failed to close fatal exception file output stream.");
                } catch (Throwable th) {
                    e = th;
                    C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                    C2956j.m16996a(c1146d, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c1146d = null;
            C3059d.m17342h().mo2439e("CrashlyticsCore", "An error occurred in the native crash logger", e);
            C2956j.m16997a(flushable, "Failed to flush to session begin file.");
            C2956j.m16996a(c1146d, "Failed to close fatal exception file output stream.");
        } catch (Throwable th2) {
            e = th2;
            c1146d = null;
            C2956j.m16997a(flushable, "Failed to flush to session begin file.");
            C2956j.m16996a(c1146d, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m8050a(String str, Date date) throws Exception {
        Closeable c1146d;
        Throwable th;
        Flushable flushable = null;
        try {
            c1146d = new C1146d(m8078q(), str + "BeginSession");
            try {
                flushable = C1149f.m7892a((OutputStream) c1146d);
                bc.m7868a((C1149f) flushable, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f4404n.mo1148a()}), date.getTime() / 1000);
                C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                C2956j.m16996a(c1146d, "Failed to close begin session file.");
            } catch (Throwable th2) {
                th = th2;
                C2956j.m16997a(flushable, "Failed to flush to session begin file.");
                C2956j.m16996a(c1146d, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c1146d = null;
            C2956j.m16997a(flushable, "Failed to flush to session begin file.");
            C2956j.m16996a(c1146d, "Failed to close begin session file.");
            throw th;
        }
    }

    private void m8062c(String str) throws Exception {
        Closeable closeable;
        Throwable th;
        Flushable flushable = null;
        try {
            Closeable c1146d = new C1146d(m8078q(), str + "SessionApp");
            try {
                Flushable a = C1149f.m7892a((OutputStream) c1146d);
                try {
                    bc.m7870a((C1149f) a, this.f4403m.m17039c(), this.f4404n.m7973i(), this.f4404n.m7976l(), this.f4404n.m7975k(), this.f4403m.m17038b(), C2961n.m17024a(this.f4404n.m7974j()).m17025a(), this.f4407q);
                    C2956j.m16997a(a, "Failed to flush to session app file.");
                    C2956j.m16996a(c1146d, "Failed to close session app file.");
                } catch (Throwable th2) {
                    closeable = c1146d;
                    Flushable flushable2 = a;
                    th = th2;
                    flushable = flushable2;
                    C2956j.m16997a(flushable, "Failed to flush to session app file.");
                    C2956j.m16996a(closeable, "Failed to close session app file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = c1146d;
                C2956j.m16997a(flushable, "Failed to flush to session app file.");
                C2956j.m16996a(closeable, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            C2956j.m16997a(flushable, "Failed to flush to session app file.");
            C2956j.m16996a(closeable, "Failed to close session app file.");
            throw th;
        }
    }

    private void m8064d(String str) throws Exception {
        Closeable c1146d;
        Throwable th;
        Flushable flushable = null;
        try {
            c1146d = new C1146d(m8078q(), str + "SessionOS");
            try {
                flushable = C1149f.m7892a((OutputStream) c1146d);
                bc.m7876a((C1149f) flushable, C2956j.m17012g(this.f4404n.m7540E()));
                C2956j.m16997a(flushable, "Failed to flush to session OS file.");
                C2956j.m16996a(c1146d, "Failed to close session OS file.");
            } catch (Throwable th2) {
                th = th2;
                C2956j.m16997a(flushable, "Failed to flush to session OS file.");
                C2956j.m16996a(c1146d, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c1146d = null;
            C2956j.m16997a(flushable, "Failed to flush to session OS file.");
            C2956j.m16996a(c1146d, "Failed to close session OS file.");
            throw th;
        }
    }

    private void m8066e(String str) throws Exception {
        Throwable th;
        Closeable closeable = null;
        Flushable flushable = null;
        try {
            OutputStream c1146d = new C1146d(m8078q(), str + "SessionDevice");
            try {
                flushable = C1149f.m7892a(c1146d);
                Context E = this.f4404n.m7540E();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                bc.m7867a((C1149f) flushable, this.f4403m.m17044h(), C2956j.m16978a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C2956j.m17000b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C2956j.m17011f(E), this.f4403m.m17045i(), C2956j.m17013h(E), Build.MANUFACTURER, Build.PRODUCT);
                C2956j.m16997a(flushable, "Failed to flush session device info.");
                C2956j.m16996a((Closeable) c1146d, "Failed to close session device file.");
            } catch (Throwable th2) {
                th = th2;
                Object obj = c1146d;
                C2956j.m16997a(flushable, "Failed to flush session device info.");
                C2956j.m16996a(closeable, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C2956j.m16997a(flushable, "Failed to flush session device info.");
            C2956j.m16996a(closeable, "Failed to close session device file.");
            throw th;
        }
    }

    private void m8067f(String str) throws Exception {
        Closeable c1146d;
        Throwable th;
        Flushable flushable = null;
        try {
            c1146d = new C1146d(m8078q(), str + "SessionUser");
            try {
                flushable = C1149f.m7892a((OutputStream) c1146d);
                bf g = m8068g(str);
                if (g.m7883a()) {
                    C2956j.m16997a(flushable, "Failed to flush session user file.");
                    C2956j.m16996a(c1146d, "Failed to close session user file.");
                    return;
                }
                bc.m7869a((C1149f) flushable, g.f4318b, g.f4319c, g.f4320d);
                C2956j.m16997a(flushable, "Failed to flush session user file.");
                C2956j.m16996a(c1146d, "Failed to close session user file.");
            } catch (Throwable th2) {
                th = th2;
                C2956j.m16997a(flushable, "Failed to flush session user file.");
                C2956j.m16996a(c1146d, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c1146d = null;
            C2956j.m16997a(flushable, "Failed to flush session user file.");
            C2956j.m16996a(c1146d, "Failed to close session user file.");
            throw th;
        }
    }

    private void m8040a(C1149f c1149f, Date date, Thread thread, Throwable th, String str, boolean z) throws Exception {
        Thread[] threadArr;
        Map treeMap;
        Context E = this.f4404n.m7540E();
        long time = date.getTime() / 1000;
        float c = C2956j.m17005c(E);
        int a = C2956j.m16980a(E, this.f4406p.m7750a());
        boolean d = C2956j.m17009d(E);
        int i = E.getResources().getConfiguration().orientation;
        long b = C2956j.m17000b() - C2956j.m17001b(E);
        long b2 = C2956j.m17002b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = C2956j.m16982a(E.getPackageName(), E);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        String n = this.f4404n.m7978n();
        String c2 = this.f4403m.m17039c();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(entry.getValue());
                i2++;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (C2956j.m16999a(E, "com.crashlytics.CollectCustomKeys", true)) {
            Map g = this.f4404n.m7971g();
            treeMap = (g == null || g.size() <= 1) ? g : new TreeMap(g);
        } else {
            treeMap = new TreeMap();
        }
        bc.m7865a(c1149f, time, str, th, thread, stackTrace, threadArr, linkedList, treeMap, this.f4405o, a2, i, c2, n, c, a, d, b, b2);
    }

    private void m8045a(File file, String str, int i) {
        boolean z;
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] a = m8055a(new C1179b(str + "SessionCrash"));
        boolean z2 = a != null && a.length > 0;
        C3059d.m17342h().mo2431a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] a2 = m8055a(new C1179b(str + "SessionEvent"));
        if (a2 == null || a2.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        C3059d.m17342h().mo2431a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            m8046a(file, str, m8056a(str, a2, i), z2 ? a[0] : null);
        } else {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "No events present for session ID " + str);
        }
        C3059d.m17342h().mo2431a("CrashlyticsCore", "Removing session part files for ID " + str);
        m8048a(str);
    }

    private void m8046a(File file, String str, File[] fileArr, File file2) {
        Closeable c1146d;
        Throwable e;
        boolean z = true;
        if (file2 == null) {
            z = false;
        }
        try {
            c1146d = new C1146d(m8078q(), str);
            try {
                Flushable a = C1149f.m7892a((OutputStream) c1146d);
                C3059d.m17342h().mo2431a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                C1182y.m8038a((C1149f) a, file);
                a.m7919a(4, new Date().getTime() / 1000);
                a.m7921a(5, z);
                a.m7918a(11, 1);
                a.m7929b(12, 3);
                m8039a((C1149f) a, str);
                C1182y.m8041a((C1149f) a, fileArr, str);
                if (z) {
                    C1182y.m8038a((C1149f) a, file2);
                }
                C2956j.m16997a(a, "Error flushing session file stream");
                C2956j.m16996a(c1146d, "Failed to close CLS file");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3059d.m17342h().mo2439e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    C2956j.m16997a(null, "Error flushing session file stream");
                    m8037a((C1146d) c1146d);
                } catch (Throwable th) {
                    e = th;
                    C2956j.m16997a(null, "Error flushing session file stream");
                    C2956j.m16996a(c1146d, "Failed to close CLS file");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c1146d = null;
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
            C2956j.m16997a(null, "Error flushing session file stream");
            m8037a((C1146d) c1146d);
        } catch (Throwable th2) {
            e = th2;
            c1146d = null;
            C2956j.m16997a(null, "Error flushing session file stream");
            C2956j.m16996a(c1146d, "Failed to close CLS file");
            throw e;
        }
    }

    private static void m8041a(C1149f c1149f, File[] fileArr, String str) {
        Arrays.sort(fileArr, C2956j.f9840a);
        for (File name : fileArr) {
            try {
                C3059d.m17342h().mo2431a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                C1182y.m8038a(c1149f, name);
            } catch (Throwable e) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void m8039a(C1149f c1149f, String str) throws IOException {
        for (String str2 : f4397g) {
            File[] a = m8055a(new C1179b(str + str2));
            if (a.length == 0) {
                C3059d.m17342h().mo2439e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                C3059d.m17342h().mo2431a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                C1182y.m8038a(c1149f, a[0]);
            }
        }
    }

    private static void m8038a(C1149f c1149f, File file) throws IOException {
        Closeable fileInputStream;
        Throwable th;
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    C1182y.m8047a((InputStream) fileInputStream, c1149f, (int) file.length());
                    C2956j.m16996a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    C2956j.m16996a(fileInputStream, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                C2956j.m16996a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        C3059d.m17342h().mo2439e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private static void m8047a(InputStream inputStream, C1149f c1149f, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        c1149f.m7926a(bArr);
    }

    private bf m8068g(String str) {
        return m8081a() ? new bf(this.f4404n.m7980p(), this.f4404n.m7982r(), this.f4404n.m7981q()) : new at(m8078q()).m7783a(str);
    }

    private void m8077p() {
        for (File c1180c : m8074m()) {
            this.f4402l.m8018a(new C1180c(this.f4404n, c1180c));
        }
    }

    private File m8078q() {
        return this.f4400j.mo2419a();
    }
}
