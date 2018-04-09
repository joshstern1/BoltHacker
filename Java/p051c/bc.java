package com.p041a.p042a.p051c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import io.p038b.p039a.p040a.C3059d;
import io.p038b.p039a.p040a.p044a.p046b.C2967t.C2966a;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class bc {
    private static final C1142b f4313a = C1142b.m7834a("0");
    private static final C1142b f4314b = C1142b.m7834a("Unity");

    public static void m7868a(C1149f c1149f, String str, String str2, long j) throws Exception {
        c1149f.m7920a(1, C1142b.m7834a(str2));
        c1149f.m7920a(2, C1142b.m7834a(str));
        c1149f.m7919a(3, j);
    }

    public static void m7870a(C1149f c1149f, String str, String str2, String str3, String str4, String str5, int i, String str6) throws Exception {
        C1142b a = C1142b.m7834a(str);
        C1142b a2 = C1142b.m7834a(str2);
        C1142b a3 = C1142b.m7834a(str3);
        C1142b a4 = C1142b.m7834a(str4);
        C1142b a5 = C1142b.m7834a(str5);
        C1142b a6 = str6 != null ? C1142b.m7834a(str6) : null;
        c1149f.m7935g(7, 2);
        c1149f.m7937k(bc.m7853a(a, a2, a3, a4, a5, i, a6));
        c1149f.m7920a(1, a);
        c1149f.m7920a(2, a3);
        c1149f.m7920a(3, a4);
        c1149f.m7935g(5, 2);
        c1149f.m7937k(bc.m7851a(a2));
        c1149f.m7920a(1, a2);
        c1149f.m7920a(6, a5);
        if (a6 != null) {
            c1149f.m7920a(8, f4314b);
            c1149f.m7920a(9, a6);
        }
        c1149f.m7929b(10, i);
    }

    public static void m7876a(C1149f c1149f, boolean z) throws Exception {
        C1142b a = C1142b.m7834a(VERSION.RELEASE);
        C1142b a2 = C1142b.m7834a(VERSION.CODENAME);
        c1149f.m7935g(8, 2);
        c1149f.m7937k(bc.m7854a(a, a2, z));
        c1149f.m7929b(1, 3);
        c1149f.m7920a(2, a);
        c1149f.m7920a(3, a2);
        c1149f.m7921a(4, z);
    }

    public static void m7867a(C1149f c1149f, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<C2966a, String> map, int i3, String str3, String str4) throws Exception {
        C1142b a = C1142b.m7834a(str);
        C1142b a2 = bc.m7862a(str2);
        C1142b a3 = bc.m7862a(str4);
        C1142b a4 = bc.m7862a(str3);
        c1149f.m7935g(9, 2);
        c1149f.m7937k(bc.m7849a(i, a, a2, i2, j, j2, z, (Map) map, i3, a4, a3));
        c1149f.m7920a(1, a);
        c1149f.m7929b(3, i);
        c1149f.m7920a(4, a2);
        c1149f.m7918a(5, i2);
        c1149f.m7919a(6, j);
        c1149f.m7919a(7, j2);
        c1149f.m7921a(10, z);
        for (Entry entry : map.entrySet()) {
            c1149f.m7935g(11, 2);
            c1149f.m7937k(bc.m7855a((C2966a) entry.getKey(), (String) entry.getValue()));
            c1149f.m7929b(1, ((C2966a) entry.getKey()).f9868h);
            c1149f.m7920a(2, C1142b.m7834a((String) entry.getValue()));
        }
        c1149f.m7918a(12, i3);
        if (a4 != null) {
            c1149f.m7920a(13, a4);
        }
        if (a3 != null) {
            c1149f.m7920a(14, a3);
        }
    }

    public static void m7869a(C1149f c1149f, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        C1142b a = C1142b.m7834a(str);
        C1142b a2 = bc.m7862a(str2);
        C1142b a3 = bc.m7862a(str3);
        int b = 0 + C1149f.m7898b(1, a);
        if (str2 != null) {
            b += C1149f.m7898b(2, a2);
        }
        if (str3 != null) {
            b += C1149f.m7898b(3, a3);
        }
        c1149f.m7935g(6, 2);
        c1149f.m7937k(b);
        c1149f.m7920a(1, a);
        if (str2 != null) {
            c1149f.m7920a(2, a2);
        }
        if (str3 != null) {
            c1149f.m7920a(3, a3);
        }
    }

    public static void m7865a(C1149f c1149f, long j, String str, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, ar arVar, RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, float f, int i2, boolean z, long j2, long j3) throws Exception {
        C1142b c1142b;
        C1142b a = C1142b.m7834a(str2);
        if (str3 == null) {
            c1142b = null;
        } else {
            c1142b = C1142b.m7834a(str3.replace("-", ""));
        }
        C1142b a2 = arVar.m7770a();
        if (a2 == null) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "No log data to include with this event.");
        }
        arVar.m7774b();
        c1149f.m7935g(10, 2);
        c1149f.m7937k(bc.m7850a(j, str, th, thread, stackTraceElementArr, threadArr, (List) list, 8, (Map) map, runningAppProcessInfo, i, a, c1142b, f, i2, z, j2, j3, a2));
        c1149f.m7919a(1, j);
        c1149f.m7920a(2, C1142b.m7834a(str));
        bc.m7874a(c1149f, th, thread, stackTraceElementArr, threadArr, (List) list, 8, a, c1142b, (Map) map, runningAppProcessInfo, i);
        bc.m7863a(c1149f, f, i2, z, i, j2, j3);
        bc.m7866a(c1149f, a2);
    }

    private static void m7874a(C1149f c1149f, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1142b c1142b, C1142b c1142b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) throws Exception {
        c1149f.m7935g(3, 2);
        c1149f.m7937k(bc.m7861a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1142b, c1142b2, (Map) map, runningAppProcessInfo, i2));
        bc.m7873a(c1149f, th, thread, stackTraceElementArr, threadArr, list, i, c1142b, c1142b2);
        if (!(map == null || map.isEmpty())) {
            bc.m7875a(c1149f, (Map) map);
        }
        if (runningAppProcessInfo != null) {
            c1149f.m7921a(3, runningAppProcessInfo.importance != 100);
        }
        c1149f.m7918a(4, i2);
    }

    private static void m7873a(C1149f c1149f, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1142b c1142b, C1142b c1142b2) throws Exception {
        c1149f.m7935g(1, 2);
        c1149f.m7937k(bc.m7860a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1142b, c1142b2));
        bc.m7871a(c1149f, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bc.m7871a(c1149f, threadArr[i2], (StackTraceElement[]) list.get(i2), 0, false);
        }
        bc.m7872a(c1149f, th, 1, i, 2);
        c1149f.m7935g(3, 2);
        c1149f.m7937k(bc.m7847a());
        c1149f.m7920a(1, f4313a);
        c1149f.m7920a(2, f4313a);
        c1149f.m7919a(3, 0);
        c1149f.m7935g(4, 2);
        c1149f.m7937k(bc.m7852a(c1142b, c1142b2));
        c1149f.m7919a(1, 0);
        c1149f.m7919a(2, 0);
        c1149f.m7920a(3, c1142b);
        if (c1142b2 != null) {
            c1149f.m7920a(4, c1142b2);
        }
    }

    private static void m7875a(C1149f c1149f, Map<String, String> map) throws Exception {
        for (Entry entry : map.entrySet()) {
            c1149f.m7935g(2, 2);
            c1149f.m7937k(bc.m7857a((String) entry.getKey(), (String) entry.getValue()));
            c1149f.m7920a(1, C1142b.m7834a((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            c1149f.m7920a(2, C1142b.m7834a(str));
        }
    }

    private static void m7872a(C1149f c1149f, Throwable th, int i, int i2, int i3) throws Exception {
        int i4 = 0;
        c1149f.m7935g(i3, 2);
        c1149f.m7937k(bc.m7859a(th, 1, i2));
        c1149f.m7920a(1, C1142b.m7834a(th.getClass().getName()));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            c1149f.m7920a(3, C1142b.m7834a(localizedMessage));
        }
        for (StackTraceElement a : th.getStackTrace()) {
            bc.m7864a(c1149f, 4, a, true);
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return;
        }
        if (i < i2) {
            bc.m7872a(c1149f, cause, i + 1, i2, 6);
            return;
        }
        while (cause != null) {
            cause = cause.getCause();
            i4++;
        }
        c1149f.m7918a(7, i4);
    }

    private static void m7871a(C1149f c1149f, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        c1149f.m7935g(1, 2);
        c1149f.m7937k(bc.m7858a(thread, stackTraceElementArr, i, z));
        c1149f.m7920a(1, C1142b.m7834a(thread.getName()));
        c1149f.m7918a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            bc.m7864a(c1149f, 3, a, z);
        }
    }

    private static void m7864a(C1149f c1149f, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        int i2 = 4;
        c1149f.m7935g(i, 2);
        c1149f.m7937k(bc.m7856a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            c1149f.m7919a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            c1149f.m7919a(1, 0);
        }
        c1149f.m7920a(2, C1142b.m7834a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            c1149f.m7920a(3, C1142b.m7834a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            c1149f.m7919a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        c1149f.m7918a(5, i2);
    }

    private static void m7863a(C1149f c1149f, float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        c1149f.m7935g(5, 2);
        c1149f.m7937k(bc.m7848a(f, i, z, i2, j, j2));
        c1149f.m7917a(1, f);
        c1149f.m7931c(2, i);
        c1149f.m7921a(3, z);
        c1149f.m7918a(4, i2);
        c1149f.m7919a(5, j);
        c1149f.m7919a(6, j2);
    }

    private static void m7866a(C1149f c1149f, C1142b c1142b) throws Exception {
        if (c1142b != null) {
            c1149f.m7935g(6, 2);
            c1149f.m7937k(bc.m7877b(c1142b));
            c1149f.m7920a(1, c1142b);
        }
    }

    private static int m7853a(C1142b c1142b, C1142b c1142b2, C1142b c1142b3, C1142b c1142b4, C1142b c1142b5, int i, C1142b c1142b6) {
        int b = ((0 + C1149f.m7898b(1, c1142b)) + C1149f.m7898b(2, c1142b3)) + C1149f.m7898b(3, c1142b4);
        int a = bc.m7851a(c1142b2);
        b = (b + (a + (C1149f.m7911j(5) + C1149f.m7912l(a)))) + C1149f.m7898b(6, c1142b5);
        if (c1142b6 != null) {
            b = (b + C1149f.m7898b(8, f4314b)) + C1149f.m7898b(9, c1142b6);
        }
        return b + C1149f.m7906e(10, i);
    }

    private static int m7851a(C1142b c1142b) {
        return 0 + C1149f.m7898b(1, c1142b);
    }

    private static int m7854a(C1142b c1142b, C1142b c1142b2, boolean z) {
        return (((0 + C1149f.m7906e(1, 3)) + C1149f.m7898b(2, c1142b)) + C1149f.m7898b(3, c1142b2)) + C1149f.m7899b(4, z);
    }

    private static int m7855a(C2966a c2966a, String str) {
        return C1149f.m7906e(1, c2966a.f9868h) + C1149f.m7898b(2, C1142b.m7834a(str));
    }

    private static int m7849a(int i, C1142b c1142b, C1142b c1142b2, int i2, long j, long j2, boolean z, Map<C2966a, String> map, int i3, C1142b c1142b3, C1142b c1142b4) {
        int i4;
        int i5;
        int e = C1149f.m7906e(3, i) + (0 + C1149f.m7898b(1, c1142b));
        if (c1142b2 == null) {
            i4 = 0;
        } else {
            i4 = C1149f.m7898b(4, c1142b2);
        }
        i4 = ((((i4 + e) + C1149f.m7903d(5, i2)) + C1149f.m7897b(6, j)) + C1149f.m7897b(7, j2)) + C1149f.m7899b(10, z);
        if (map != null) {
            i5 = i4;
            for (Entry entry : map.entrySet()) {
                i4 = bc.m7855a((C2966a) entry.getKey(), (String) entry.getValue());
                i5 = (i4 + (C1149f.m7911j(11) + C1149f.m7912l(i4))) + i5;
            }
        } else {
            i5 = i4;
        }
        return (c1142b4 == null ? 0 : C1149f.m7898b(14, c1142b4)) + ((i5 + C1149f.m7903d(12, i3)) + (c1142b3 == null ? 0 : C1149f.m7898b(13, c1142b3)));
    }

    private static int m7852a(C1142b c1142b, C1142b c1142b2) {
        int b = ((0 + C1149f.m7897b(1, 0)) + C1149f.m7897b(2, 0)) + C1149f.m7898b(3, c1142b);
        if (c1142b2 != null) {
            return b + C1149f.m7898b(4, c1142b2);
        }
        return b;
    }

    private static int m7850a(long j, String str, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2, C1142b c1142b, C1142b c1142b2, float f, int i3, boolean z, long j2, long j3, C1142b c1142b3) {
        int b = (0 + C1149f.m7897b(1, j)) + C1149f.m7898b(2, C1142b.m7834a(str));
        int a = bc.m7861a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1142b, c1142b2, (Map) map, runningAppProcessInfo, i2);
        int j4 = b + (a + (C1149f.m7911j(3) + C1149f.m7912l(a)));
        a = bc.m7848a(f, i3, z, i2, j2, j3);
        a = (a + (C1149f.m7911j(5) + C1149f.m7912l(a))) + j4;
        if (c1142b3 == null) {
            return a;
        }
        int b2 = bc.m7877b(c1142b3);
        return a + (b2 + (C1149f.m7911j(6) + C1149f.m7912l(b2)));
    }

    private static int m7861a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1142b c1142b, C1142b c1142b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int a = bc.m7860a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1142b, c1142b2);
        int j = 0 + (a + (C1149f.m7911j(1) + C1149f.m7912l(a)));
        if (map != null) {
            int i3 = j;
            for (Entry entry : map.entrySet()) {
                j = bc.m7857a((String) entry.getKey(), (String) entry.getValue());
                i3 = (j + (C1149f.m7911j(2) + C1149f.m7912l(j))) + i3;
            }
            a = i3;
        } else {
            a = j;
        }
        if (runningAppProcessInfo != null) {
            j = C1149f.m7899b(3, runningAppProcessInfo.importance != 100) + a;
        } else {
            j = a;
        }
        return j + C1149f.m7903d(4, i2);
    }

    private static int m7860a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1142b c1142b, C1142b c1142b2) {
        int a;
        int a2 = bc.m7858a(thread, stackTraceElementArr, 4, true);
        a2 = (a2 + (C1149f.m7911j(1) + C1149f.m7912l(a2))) + 0;
        int length = threadArr.length;
        int i2 = a2;
        for (a2 = 0; a2 < length; a2++) {
            a = bc.m7858a(threadArr[a2], (StackTraceElement[]) list.get(a2), 0, false);
            i2 += a + (C1149f.m7911j(1) + C1149f.m7912l(a));
        }
        a = bc.m7859a(th, 1, i);
        a = (a + (C1149f.m7911j(2) + C1149f.m7912l(a))) + i2;
        a2 = bc.m7847a();
        a += a2 + (C1149f.m7911j(3) + C1149f.m7912l(a2));
        a2 = bc.m7852a(c1142b, c1142b2);
        return a + (a2 + (C1149f.m7911j(3) + C1149f.m7912l(a2)));
    }

    private static int m7857a(String str, String str2) {
        int b = C1149f.m7898b(1, C1142b.m7834a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + C1149f.m7898b(2, C1142b.m7834a(str2));
    }

    private static int m7848a(float f, int i, boolean z, int i2, long j, long j2) {
        return (((((0 + C1149f.m7896b(1, f)) + C1149f.m7908f(2, i)) + C1149f.m7899b(3, z)) + C1149f.m7903d(4, i2)) + C1149f.m7897b(5, j)) + C1149f.m7897b(6, j2);
    }

    private static int m7877b(C1142b c1142b) {
        return C1149f.m7898b(1, c1142b);
    }

    private static int m7859a(Throwable th, int i, int i2) {
        int i3 = 0;
        int b = C1149f.m7898b(1, C1142b.m7834a(th.getClass().getName())) + 0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            b += C1149f.m7898b(3, C1142b.m7834a(localizedMessage));
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i4 = 0;
        while (i4 < length) {
            int a = bc.m7856a(stackTrace[i4], true);
            i4++;
            b = (a + (C1149f.m7911j(4) + C1149f.m7912l(a))) + b;
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return b;
        }
        if (i < i2) {
            i3 = bc.m7859a(cause, i + 1, i2);
            return b + (i3 + (C1149f.m7911j(6) + C1149f.m7912l(i3)));
        }
        while (cause != null) {
            cause = cause.getCause();
            i3++;
        }
        return b + C1149f.m7903d(7, i3);
    }

    private static int m7847a() {
        return ((0 + C1149f.m7898b(1, f4313a)) + C1149f.m7898b(2, f4313a)) + C1149f.m7897b(3, 0);
    }

    private static int m7856a(StackTraceElement stackTraceElement, boolean z) {
        int b;
        int i;
        if (stackTraceElement.isNativeMethod()) {
            b = C1149f.m7897b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            b = C1149f.m7897b(1, 0) + 0;
        }
        b += C1149f.m7898b(2, C1142b.m7834a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b += C1149f.m7898b(3, C1142b.m7834a(stackTraceElement.getFileName()));
        }
        if (stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) {
            i = b;
        } else {
            i = b + C1149f.m7897b(4, (long) stackTraceElement.getLineNumber());
        }
        return C1149f.m7903d(5, z ? 2 : 0) + i;
    }

    private static int m7858a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int d = C1149f.m7903d(2, i) + C1149f.m7898b(1, C1142b.m7834a(thread.getName()));
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = bc.m7856a(a, z);
            d += a2 + (C1149f.m7911j(3) + C1149f.m7912l(a2));
        }
        return d;
    }

    private static C1142b m7862a(String str) {
        return str == null ? null : C1142b.m7834a(str);
    }
}
