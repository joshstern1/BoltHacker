package com.onesignal;

import android.content.Context;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.ProductDataResponse.RequestStatus;
import java.lang.reflect.Field;

class ay {
    private Context f9226a;
    private boolean f9227b = false;
    private C2726a f9228c;
    private Class<?> f9229d;
    private Object f9230e;
    private Field f9231f;

    static /* synthetic */ class C27251 {
        static final /* synthetic */ int[] f9223a = new int[RequestStatus.values().length];

        static {
            try {
                f9223a[RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private class C2726a implements PurchasingListener {
        public PurchasingListener f9224a;
        final /* synthetic */ ay f9225b;

        private C2726a(ay ayVar) {
            this.f9225b = ayVar;
        }
    }

    ay(Context context) {
        this.f9226a = context;
        try {
            this.f9229d = Class.forName("com.amazon.device.iap.internal.d");
            this.f9230e = this.f9229d.getMethod("d", new Class[0]).invoke(null, new Object[0]);
            this.f9231f = this.f9229d.getDeclaredField("f");
            this.f9231f.setAccessible(true);
            this.f9228c = new C2726a();
            this.f9228c.f9224a = (PurchasingListener) this.f9231f.get(this.f9230e);
            this.f9227b = true;
            m15947b();
        } catch (Throwable th) {
        }
    }

    private void m15947b() {
        PurchasingService.registerListener(this.f9226a, this.f9228c);
    }

    public void m15948a() {
        if (this.f9227b) {
            try {
                PurchasingListener purchasingListener = (PurchasingListener) this.f9231f.get(this.f9230e);
                if (purchasingListener != this.f9228c) {
                    this.f9228c.f9224a = purchasingListener;
                    m15947b();
                }
            } catch (Throwable th) {
            }
        }
    }
}
