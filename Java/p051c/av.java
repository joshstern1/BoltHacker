package com.p041a.p042a.p051c;

import com.p041a.p042a.p051c.p052a.p053a.C1117a;
import com.p041a.p042a.p051c.p052a.p053a.C1118b;
import com.p041a.p042a.p051c.p052a.p053a.C1119c;
import com.p041a.p042a.p051c.p052a.p053a.C1120d;
import com.p041a.p042a.p051c.p052a.p053a.C1121e;
import com.p041a.p042a.p051c.p052a.p053a.C1123f;
import com.p041a.p042a.p051c.p052a.p053a.C1123f.C1122a;
import io.p038b.p039a.p040a.C3059d;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class av {
    private static final C1121e f4290a = new C1121e("", "", 0);
    private static final C1128j[] f4291b = new C1128j[0];
    private static final C1140m[] f4292c = new C1140m[0];
    private static final C1135g[] f4293d = new C1135g[0];
    private static final C1130b[] f4294e = new C1130b[0];
    private static final C1131c[] f4295f = new C1131c[0];

    private static abstract class C1128j {
        private final int f4262a;
        private final C1128j[] f4263b;

        public C1128j(int i, C1128j... c1128jArr) {
            this.f4262a = i;
            if (c1128jArr == null) {
                c1128jArr = av.f4291b;
            }
            this.f4263b = c1128jArr;
        }

        public int mo1186b() {
            int c = m7790c();
            return (c + C1149f.m7912l(c)) + C1149f.m7911j(this.f4262a);
        }

        public int m7790c() {
            int a = mo1183a();
            for (C1128j b : this.f4263b) {
                a += b.mo1186b();
            }
            return a;
        }

        public void mo1185b(C1149f c1149f) throws IOException {
            c1149f.m7935g(this.f4262a, 2);
            c1149f.m7937k(m7790c());
            mo1184a(c1149f);
            for (C1128j b : this.f4263b) {
                b.mo1185b(c1149f);
            }
        }

        public int mo1183a() {
            return 0;
        }

        public void mo1184a(C1149f c1149f) throws IOException {
        }
    }

    private static final class C1129a extends C1128j {
        public C1129a(C1134f c1134f, C1138k c1138k) {
            super(3, c1134f, c1138k);
        }
    }

    private static final class C1130b extends C1128j {
        private final long f4264a;
        private final long f4265b;
        private final String f4266c;
        private final String f4267d;

        public C1130b(C1117a c1117a) {
            super(4, new C1128j[0]);
            this.f4264a = c1117a.f4193a;
            this.f4265b = c1117a.f4194b;
            this.f4266c = c1117a.f4195c;
            this.f4267d = c1117a.f4196d;
        }

        public int mo1183a() {
            int b = C1149f.m7897b(1, this.f4264a);
            return ((b + C1149f.m7898b(3, C1142b.m7834a(this.f4266c))) + C1149f.m7897b(2, this.f4265b)) + C1149f.m7898b(4, C1142b.m7834a(this.f4267d));
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            c1149f.m7919a(1, this.f4264a);
            c1149f.m7919a(2, this.f4265b);
            c1149f.m7920a(3, C1142b.m7834a(this.f4266c));
            c1149f.m7920a(4, C1142b.m7834a(this.f4267d));
        }
    }

    private static final class C1131c extends C1128j {
        private final String f4268a;
        private final String f4269b;

        public C1131c(C1118b c1118b) {
            super(2, new C1128j[0]);
            this.f4268a = c1118b.f4197a;
            this.f4269b = c1118b.f4198b;
        }

        public int mo1183a() {
            return C1149f.m7898b(2, C1142b.m7834a(this.f4269b == null ? "" : this.f4269b)) + C1149f.m7898b(1, C1142b.m7834a(this.f4268a));
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            c1149f.m7920a(1, C1142b.m7834a(this.f4268a));
            c1149f.m7920a(2, C1142b.m7834a(this.f4269b == null ? "" : this.f4269b));
        }
    }

    private static final class C1132d extends C1128j {
        private final float f4270a;
        private final int f4271b;
        private final boolean f4272c;
        private final int f4273d;
        private final long f4274e;
        private final long f4275f;

        public C1132d(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new C1128j[0]);
            this.f4270a = f;
            this.f4271b = i;
            this.f4272c = z;
            this.f4273d = i2;
            this.f4274e = j;
            this.f4275f = j2;
        }

        public int mo1183a() {
            return (((((0 + C1149f.m7896b(1, this.f4270a)) + C1149f.m7908f(2, this.f4271b)) + C1149f.m7899b(3, this.f4272c)) + C1149f.m7903d(4, this.f4273d)) + C1149f.m7897b(5, this.f4274e)) + C1149f.m7897b(6, this.f4275f);
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            c1149f.m7917a(1, this.f4270a);
            c1149f.m7931c(2, this.f4271b);
            c1149f.m7921a(3, this.f4272c);
            c1149f.m7918a(4, this.f4273d);
            c1149f.m7919a(5, this.f4274e);
            c1149f.m7919a(6, this.f4275f);
        }
    }

    private static final class C1133e extends C1128j {
        private final long f4276a;
        private final String f4277b;

        public C1133e(long j, String str, C1128j... c1128jArr) {
            super(10, c1128jArr);
            this.f4276a = j;
            this.f4277b = str;
        }

        public int mo1183a() {
            return C1149f.m7897b(1, this.f4276a) + C1149f.m7898b(2, C1142b.m7834a(this.f4277b));
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            c1149f.m7919a(1, this.f4276a);
            c1149f.m7920a(2, C1142b.m7834a(this.f4277b));
        }
    }

    private static final class C1134f extends C1128j {
        public C1134f(C1139l c1139l, C1138k c1138k, C1138k c1138k2) {
            super(1, c1138k, c1139l, c1138k2);
        }
    }

    private static final class C1135g extends C1128j {
        private final long f4278a;
        private final String f4279b;
        private final String f4280c;
        private final long f4281d;
        private final int f4282e;

        public C1135g(C1122a c1122a) {
            super(3, new C1128j[0]);
            this.f4278a = c1122a.f4216a;
            this.f4279b = c1122a.f4217b;
            this.f4280c = c1122a.f4218c;
            this.f4281d = c1122a.f4219d;
            this.f4282e = c1122a.f4220e;
        }

        public int mo1183a() {
            return (((C1149f.m7897b(1, this.f4278a) + C1149f.m7898b(2, C1142b.m7834a(this.f4279b))) + C1149f.m7898b(3, C1142b.m7834a(this.f4280c))) + C1149f.m7897b(4, this.f4281d)) + C1149f.m7903d(5, this.f4282e);
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            c1149f.m7919a(1, this.f4278a);
            c1149f.m7920a(2, C1142b.m7834a(this.f4279b));
            c1149f.m7920a(3, C1142b.m7834a(this.f4280c));
            c1149f.m7919a(4, this.f4281d);
            c1149f.m7918a(5, this.f4282e);
        }
    }

    private static final class C1136h extends C1128j {
        C1142b f4283a;

        public C1136h(C1142b c1142b) {
            super(6, new C1128j[0]);
            this.f4283a = c1142b;
        }

        public int mo1183a() {
            return C1149f.m7898b(1, this.f4283a);
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            c1149f.m7920a(1, this.f4283a);
        }
    }

    private static final class C1137i extends C1128j {
        public C1137i() {
            super(0, new C1128j[0]);
        }

        public void mo1185b(C1149f c1149f) throws IOException {
        }
    }

    private static final class C1138k extends C1128j {
        private final C1128j[] f4284a;

        public C1138k(C1128j... c1128jArr) {
            super(0, new C1128j[0]);
            this.f4284a = c1128jArr;
        }

        public void mo1185b(C1149f c1149f) throws IOException {
            for (C1128j b : this.f4284a) {
                b.mo1185b(c1149f);
            }
        }

        public int mo1186b() {
            int i = 0;
            C1128j[] c1128jArr = this.f4284a;
            int i2 = 0;
            while (i < c1128jArr.length) {
                i2 += c1128jArr[i].mo1186b();
                i++;
            }
            return i2;
        }
    }

    private static final class C1139l extends C1128j {
        private final String f4285a;
        private final String f4286b;
        private final long f4287c;

        public C1139l(C1121e c1121e) {
            super(3, new C1128j[0]);
            this.f4285a = c1121e.f4213a;
            this.f4286b = c1121e.f4214b;
            this.f4287c = c1121e.f4215c;
        }

        public int mo1183a() {
            return (C1149f.m7898b(1, C1142b.m7834a(this.f4285a)) + C1149f.m7898b(2, C1142b.m7834a(this.f4286b))) + C1149f.m7897b(3, this.f4287c);
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            c1149f.m7920a(1, C1142b.m7834a(this.f4285a));
            c1149f.m7920a(2, C1142b.m7834a(this.f4286b));
            c1149f.m7919a(3, this.f4287c);
        }
    }

    private static final class C1140m extends C1128j {
        private final String f4288a;
        private final int f4289b;

        public C1140m(C1123f c1123f, C1138k c1138k) {
            super(1, c1138k);
            this.f4288a = c1123f.f4221a;
            this.f4289b = c1123f.f4222b;
        }

        public int mo1183a() {
            return (m7808d() ? C1149f.m7898b(1, C1142b.m7834a(this.f4288a)) : 0) + C1149f.m7903d(2, this.f4289b);
        }

        public void mo1184a(C1149f c1149f) throws IOException {
            if (m7808d()) {
                c1149f.m7920a(1, C1142b.m7834a(this.f4288a));
            }
            c1149f.m7918a(2, this.f4289b);
        }

        private boolean m7808d() {
            return this.f4288a != null && this.f4288a.length() > 0;
        }
    }

    private static C1133e m7812a(C1120d c1120d, ar arVar, Map<String, String> map) throws IOException {
        C1129a c1129a = new C1129a(new C1134f(new C1139l(c1120d.f4208b != null ? c1120d.f4208b : f4290a), av.m7816a(c1120d.f4209c), av.m7813a(c1120d.f4210d)), av.m7814a(av.m7818a(c1120d.f4211e, map)));
        C1132d a = av.m7811a(c1120d.f4212f);
        C1142b a2 = arVar.m7770a();
        if (a2 == null) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "No log data to include with this event.");
        }
        arVar.m7774b();
        C1136h c1136h = a2 != null ? new C1136h(a2) : new C1137i();
        return new C1133e(c1120d.f4207a, "ndk-crash", c1129a, a, c1136h);
    }

    private static C1118b[] m7818a(C1118b[] c1118bArr, Map<String, String> map) {
        int i;
        Map treeMap = new TreeMap(map);
        if (c1118bArr != null) {
            for (C1118b c1118b : c1118bArr) {
                treeMap.put(c1118b.f4197a, c1118b.f4198b);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        C1118b[] c1118bArr2 = new C1118b[entryArr.length];
        for (i = 0; i < c1118bArr2.length; i++) {
            c1118bArr2[i] = new C1118b((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return c1118bArr2;
    }

    private static C1132d m7811a(C1119c c1119c) {
        return new C1132d(((float) c1119c.f4204f) / 100.0f, c1119c.f4205g, c1119c.f4206h, c1119c.f4199a, c1119c.f4200b - c1119c.f4202d, c1119c.f4201c - c1119c.f4203e);
    }

    private static C1138k m7816a(C1123f[] c1123fArr) {
        C1128j[] c1128jArr = c1123fArr != null ? new C1140m[c1123fArr.length] : f4292c;
        for (int i = 0; i < c1128jArr.length; i++) {
            C1123f c1123f = c1123fArr[i];
            c1128jArr[i] = new C1140m(c1123f, av.m7815a(c1123f.f4223c));
        }
        return new C1138k(c1128jArr);
    }

    private static C1138k m7815a(C1122a[] c1122aArr) {
        C1128j[] c1128jArr = c1122aArr != null ? new C1135g[c1122aArr.length] : f4293d;
        for (int i = 0; i < c1128jArr.length; i++) {
            c1128jArr[i] = new C1135g(c1122aArr[i]);
        }
        return new C1138k(c1128jArr);
    }

    private static C1138k m7813a(C1117a[] c1117aArr) {
        C1128j[] c1128jArr = c1117aArr != null ? new C1130b[c1117aArr.length] : f4294e;
        for (int i = 0; i < c1128jArr.length; i++) {
            c1128jArr[i] = new C1130b(c1117aArr[i]);
        }
        return new C1138k(c1128jArr);
    }

    private static C1138k m7814a(C1118b[] c1118bArr) {
        C1128j[] c1128jArr = c1118bArr != null ? new C1131c[c1118bArr.length] : f4295f;
        for (int i = 0; i < c1128jArr.length; i++) {
            c1128jArr[i] = new C1131c(c1118bArr[i]);
        }
        return new C1138k(c1128jArr);
    }

    public static void m7817a(C1120d c1120d, ar arVar, Map<String, String> map, C1149f c1149f) throws IOException {
        av.m7812a(c1120d, arVar, map).mo1185b(c1149f);
    }
}
