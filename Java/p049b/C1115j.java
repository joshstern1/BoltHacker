package com.p041a.p042a.p049b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import io.p038b.p039a.p040a.p044a.p050a.C1114d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class C1115j implements C1114d<String> {
    public /* synthetic */ Object mo1177b(Context context) throws Exception {
        return m7732a(context);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m7732a(android.content.Context r10) throws java.lang.Exception {
        /*
        r9 = this;
        r4 = java.lang.System.nanoTime();
        r0 = "";
        r1 = 0;
        r2 = "io.crash.air";
        r1 = r9.m7734a(r10, r2);	 Catch:{ NameNotFoundException -> 0x0052, FileNotFoundException -> 0x0071, IOException -> 0x0093, all -> 0x00b7 }
        r0 = r9.m7733a(r1);	 Catch:{ NameNotFoundException -> 0x0052, FileNotFoundException -> 0x00d6, IOException -> 0x00d1 }
        if (r1 == 0) goto L_0x0016;
    L_0x0013:
        r1.close();	 Catch:{ IOException -> 0x0045 }
    L_0x0016:
        r2 = java.lang.System.nanoTime();
        r2 = r2 - r4;
        r2 = (double) r2;
        r4 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r2 = r2 / r4;
        r1 = io.p038b.p039a.p040a.C3059d.m17342h();
        r4 = "Beta";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Beta device token load took ";
        r5 = r5.append(r6);
        r2 = r5.append(r2);
        r3 = "ms";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.mo2431a(r4, r2);
        return r0;
    L_0x0045:
        r1 = move-exception;
        r2 = io.p038b.p039a.p040a.C3059d.m17342h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2439e(r3, r6, r1);
        goto L_0x0016;
    L_0x0052:
        r2 = move-exception;
        r2 = io.p038b.p039a.p040a.C3059d.m17342h();	 Catch:{ all -> 0x00cc }
        r3 = "Beta";
        r6 = "Beta by Crashlytics app is not installed";
        r2.mo2431a(r3, r6);	 Catch:{ all -> 0x00cc }
        if (r1 == 0) goto L_0x0016;
    L_0x0060:
        r1.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0016;
    L_0x0064:
        r1 = move-exception;
        r2 = io.p038b.p039a.p040a.C3059d.m17342h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2439e(r3, r6, r1);
        goto L_0x0016;
    L_0x0071:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0075:
        r3 = io.p038b.p039a.p040a.C3059d.m17342h();	 Catch:{ all -> 0x00cf }
        r6 = "Beta";
        r7 = "Failed to find the APK file";
        r3.mo2439e(r6, r7, r1);	 Catch:{ all -> 0x00cf }
        if (r2 == 0) goto L_0x0016;
    L_0x0082:
        r2.close();	 Catch:{ IOException -> 0x0086 }
        goto L_0x0016;
    L_0x0086:
        r1 = move-exception;
        r2 = io.p038b.p039a.p040a.C3059d.m17342h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2439e(r3, r6, r1);
        goto L_0x0016;
    L_0x0093:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0097:
        r3 = io.p038b.p039a.p040a.C3059d.m17342h();	 Catch:{ all -> 0x00cf }
        r6 = "Beta";
        r7 = "Failed to read the APK file";
        r3.mo2439e(r6, r7, r1);	 Catch:{ all -> 0x00cf }
        if (r2 == 0) goto L_0x0016;
    L_0x00a4:
        r2.close();	 Catch:{ IOException -> 0x00a9 }
        goto L_0x0016;
    L_0x00a9:
        r1 = move-exception;
        r2 = io.p038b.p039a.p040a.C3059d.m17342h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2439e(r3, r6, r1);
        goto L_0x0016;
    L_0x00b7:
        r0 = move-exception;
        r2 = r1;
    L_0x00b9:
        if (r2 == 0) goto L_0x00be;
    L_0x00bb:
        r2.close();	 Catch:{ IOException -> 0x00bf }
    L_0x00be:
        throw r0;
    L_0x00bf:
        r1 = move-exception;
        r2 = io.p038b.p039a.p040a.C3059d.m17342h();
        r3 = "Beta";
        r4 = "Failed to close the APK file";
        r2.mo2439e(r3, r4, r1);
        goto L_0x00be;
    L_0x00cc:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b9;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x00b9;
    L_0x00d1:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0097;
    L_0x00d6:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.j.a(android.content.Context):java.lang.String");
    }

    ZipInputStream m7734a(Context context, String str) throws NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    String m7733a(ZipInputStream zipInputStream) throws IOException {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=")) {
                return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
            }
        }
        return "";
    }
}
