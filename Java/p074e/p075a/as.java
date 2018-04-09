package com.p074e.p075a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

final class as {
    static final StringBuilder f5440a = new StringBuilder();

    @TargetApi(11)
    private static class C1414a {
        static int m9064a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    private static class C1415b {
        static int m9065a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    private static class C1416c {
        static C1402r m9066a(Context context) {
            return new aa(context);
        }
    }

    private static class C1417d extends Thread {
        public C1417d(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class C1418e implements ThreadFactory {
        C1418e() {
        }

        public Thread newThread(Runnable runnable) {
            return new C1417d(runnable);
        }
    }

    static int m9068a(Bitmap bitmap) {
        int a;
        if (VERSION.SDK_INT >= 12) {
            a = C1415b.m9065a(bitmap);
        } else {
            a = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static <T> T m9073a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void m9078a() {
        if (!as.m9085b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean m9085b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String m9076a(C1420c c1420c) {
        return as.m9077a(c1420c, "");
    }

    static String m9077a(C1420c c1420c, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        C1401a i = c1420c.m9112i();
        if (i != null) {
            stringBuilder.append(i.f5291b.m9011a());
        }
        List k = c1420c.m9114k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || i != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C1401a) k.get(i2)).f5291b.m9011a());
            }
        }
        return stringBuilder.toString();
    }

    static void m9081a(String str, String str2, String str3) {
        as.m9082a(str, str2, str3, "");
    }

    static void m9082a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    static String m9074a(ah ahVar) {
        String a = as.m9075a(ahVar, f5440a);
        f5440a.setLength(0);
        return a;
    }

    static String m9075a(ah ahVar, StringBuilder stringBuilder) {
        if (ahVar.f5374f != null) {
            stringBuilder.ensureCapacity(ahVar.f5374f.length() + 50);
            stringBuilder.append(ahVar.f5374f);
        } else if (ahVar.f5372d != null) {
            String uri = ahVar.f5372d.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(ahVar.f5373e);
        }
        stringBuilder.append('\n');
        if (ahVar.f5381m != 0.0f) {
            stringBuilder.append("rotation:").append(ahVar.f5381m);
            if (ahVar.f5384p) {
                stringBuilder.append('@').append(ahVar.f5382n).append('x').append(ahVar.f5383o);
            }
            stringBuilder.append('\n');
        }
        if (ahVar.m9014d()) {
            stringBuilder.append("resize:").append(ahVar.f5376h).append('x').append(ahVar.f5377i);
            stringBuilder.append('\n');
        }
        if (ahVar.f5378j) {
            stringBuilder.append("centerCrop").append('\n');
        } else if (ahVar.f5379k) {
            stringBuilder.append("centerInside").append('\n');
        }
        if (ahVar.f5375g != null) {
            int size = ahVar.f5375g.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((ap) ahVar.f5375g.get(i)).mo2294a());
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }

    static void m9080a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    static boolean m9083a(String str) {
        boolean z = true;
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if (!("CONDITIONAL_CACHE".equals(split[0]) && Integer.parseInt(split[1]) == 304)) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static C1402r m9071a(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return C1416c.m9066a(context);
        } catch (ClassNotFoundException e) {
            return new aq(context);
        }
    }

    static File m9084b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static long m9069a(File file) {
        long blockSize;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            blockSize = 5242880;
        }
        return Math.max(Math.min(blockSize, 52428800), 5242880);
    }

    static int m9088c(Context context) {
        int i;
        ActivityManager activityManager = (ActivityManager) as.m9072a(context, "activity");
        Object obj = (context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null;
        int memoryClass = activityManager.getMemoryClass();
        if (obj == null || VERSION.SDK_INT < 11) {
            i = memoryClass;
        } else {
            i = C1414a.m9064a(activityManager);
        }
        return (i * 1048576) / 7;
    }

    static boolean m9090d(Context context) {
        try {
            if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    static <T> T m9072a(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean m9086b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static byte[] m9087b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static boolean m9089c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        if (inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"))) {
            return true;
        }
        return false;
    }

    static int m9067a(Resources resources, ah ahVar) throws FileNotFoundException {
        if (ahVar.f5373e != 0 || ahVar.f5372d == null) {
            return ahVar.f5373e;
        }
        String authority = ahVar.f5372d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + ahVar.f5372d);
        }
        List pathSegments = ahVar.f5372d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + ahVar.f5372d);
        } else if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt((String) pathSegments.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + ahVar.f5372d);
            }
        } else if (pathSegments.size() == 2) {
            return resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + ahVar.f5372d);
        }
    }

    static Resources m9070a(Context context, ah ahVar) throws FileNotFoundException {
        if (ahVar.f5373e != 0 || ahVar.f5372d == null) {
            return context.getResources();
        }
        String authority = ahVar.f5372d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + ahVar.f5372d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + ahVar.f5372d);
        }
    }

    static void m9079a(Looper looper) {
        Handler atVar = new at(looper);
        atVar.sendMessageDelayed(atVar.obtainMessage(), 1000);
    }
}
