package com.p041a.p042a.p051c;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.p041a.p042a.p051c.C1154g.C1153c;
import io.p038b.p039a.p040a.p044a.p054g.C3044o;

class C1167n implements Runnable {
    final /* synthetic */ Activity f4371a;
    final /* synthetic */ C1153c f4372b;
    final /* synthetic */ ap f4373c;
    final /* synthetic */ C3044o f4374d;
    final /* synthetic */ C1154g f4375e;

    C1167n(C1154g c1154g, Activity activity, C1153c c1153c, ap apVar, C3044o c3044o) {
        this.f4375e = c1154g;
        this.f4371a = activity;
        this.f4372b = c1153c;
        this.f4373c = apVar;
        this.f4374d = c3044o;
    }

    public void run() {
        Builder builder = new Builder(this.f4371a);
        OnClickListener c1168o = new C1168o(this);
        float f = this.f4371a.getResources().getDisplayMetrics().density;
        int a = C1154g.m7955b(f, 5);
        View textView = new TextView(this.f4371a);
        textView.setAutoLinkMask(15);
        textView.setText(this.f4373c.m7756b());
        textView.setTextAppearance(this.f4371a, 16973892);
        textView.setPadding(a, a, a, a);
        textView.setFocusable(false);
        View scrollView = new ScrollView(this.f4371a);
        scrollView.setPadding(C1154g.m7955b(f, 14), C1154g.m7955b(f, 2), C1154g.m7955b(f, 10), C1154g.m7955b(f, 12));
        scrollView.addView(textView);
        builder.setView(scrollView).setTitle(this.f4373c.m7755a()).setCancelable(false).setNeutralButton(this.f4373c.m7757c(), c1168o);
        if (this.f4374d.f10056d) {
            builder.setNegativeButton(this.f4373c.m7759e(), new C1169p(this));
        }
        if (this.f4374d.f10058f) {
            builder.setPositiveButton(this.f4373c.m7758d(), new C1170q(this));
        }
        builder.show();
    }
}
