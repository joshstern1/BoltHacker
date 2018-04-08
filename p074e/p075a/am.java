package com.p074e.p075a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class am {
    final HandlerThread f5406a = new HandlerThread("Picasso-Stats", 10);
    final C1427j f5407b;
    final Handler f5408c;
    long f5409d;
    long f5410e;
    long f5411f;
    long f5412g;
    long f5413h;
    long f5414i;
    long f5415j;
    long f5416k;
    int f5417l;
    int f5418m;
    int f5419n;

    private static class C1412a extends Handler {
        private final am f5405a;

        public C1412a(Looper looper, am amVar) {
            super(looper);
            this.f5405a = amVar;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f5405a.m9052c();
                    return;
                case 1:
                    this.f5405a.m9054d();
                    return;
                case 2:
                    this.f5405a.m9050b((long) message.arg1);
                    return;
                case 3:
                    this.f5405a.m9053c((long) message.arg1);
                    return;
                case 4:
                    this.f5405a.m9048a((Long) message.obj);
                    return;
                default:
                    ab.f5325a.post(new an(this, message));
                    return;
            }
        }
    }

    am(C1427j c1427j) {
        this.f5407b = c1427j;
        this.f5406a.start();
        as.m9079a(this.f5406a.getLooper());
        this.f5408c = new C1412a(this.f5406a.getLooper(), this);
    }

    void m9047a(Bitmap bitmap) {
        m9044a(bitmap, 2);
    }

    void m9051b(Bitmap bitmap) {
        m9044a(bitmap, 3);
    }

    void m9046a(long j) {
        this.f5408c.sendMessage(this.f5408c.obtainMessage(4, Long.valueOf(j)));
    }

    void m9045a() {
        this.f5408c.sendEmptyMessage(0);
    }

    void m9049b() {
        this.f5408c.sendEmptyMessage(1);
    }

    void m9052c() {
        this.f5409d++;
    }

    void m9054d() {
        this.f5410e++;
    }

    void m9048a(Long l) {
        this.f5417l++;
        this.f5411f += l.longValue();
        this.f5414i = am.m9043a(this.f5417l, this.f5411f);
    }

    void m9050b(long j) {
        this.f5418m++;
        this.f5412g += j;
        this.f5415j = am.m9043a(this.f5418m, this.f5412g);
    }

    void m9053c(long j) {
        this.f5419n++;
        this.f5413h += j;
        this.f5416k = am.m9043a(this.f5418m, this.f5413h);
    }

    ao m9055e() {
        return new ao(this.f5407b.mo1330b(), this.f5407b.mo1327a(), this.f5409d, this.f5410e, this.f5411f, this.f5412g, this.f5413h, this.f5414i, this.f5415j, this.f5416k, this.f5417l, this.f5418m, this.f5419n, System.currentTimeMillis());
    }

    private void m9044a(Bitmap bitmap, int i) {
        this.f5408c.sendMessage(this.f5408c.obtainMessage(i, as.m9068a(bitmap), 0));
    }

    private static long m9043a(int i, long j) {
        return j / ((long) i);
    }
}
