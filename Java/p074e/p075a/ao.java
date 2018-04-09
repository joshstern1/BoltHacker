package com.p074e.p075a;

import java.io.PrintWriter;

public class ao {
    public final int f5422a;
    public final int f5423b;
    public final long f5424c;
    public final long f5425d;
    public final long f5426e;
    public final long f5427f;
    public final long f5428g;
    public final long f5429h;
    public final long f5430i;
    public final long f5431j;
    public final int f5432k;
    public final int f5433l;
    public final int f5434m;
    public final long f5435n;

    public ao(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f5422a = i;
        this.f5423b = i2;
        this.f5424c = j;
        this.f5425d = j2;
        this.f5426e = j3;
        this.f5427f = j4;
        this.f5428g = j5;
        this.f5429h = j6;
        this.f5430i = j7;
        this.f5431j = j8;
        this.f5432k = i3;
        this.f5433l = i4;
        this.f5434m = i5;
        this.f5435n = j9;
    }

    public void m9056a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f5422a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f5423b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f5423b) / ((float) this.f5422a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f5424c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f5425d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f5432k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f5426e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f5429h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f5433l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f5427f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f5434m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f5428g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f5430i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f5431j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f5422a + ", size=" + this.f5423b + ", cacheHits=" + this.f5424c + ", cacheMisses=" + this.f5425d + ", downloadCount=" + this.f5432k + ", totalDownloadSize=" + this.f5426e + ", averageDownloadSize=" + this.f5429h + ", totalOriginalBitmapSize=" + this.f5427f + ", totalTransformedBitmapSize=" + this.f5428g + ", averageOriginalBitmapSize=" + this.f5430i + ", averageTransformedBitmapSize=" + this.f5431j + ", originalBitmapCount=" + this.f5433l + ", transformedBitmapCount=" + this.f5434m + ", timeStamp=" + this.f5435n + '}';
    }
}
