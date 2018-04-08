package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.p021b.C0307a;
import android.widget.ImageView;

public class C1014z {
    private final ImageView f3941a;
    private final C1011w f3942b;

    public void m7277a(android.util.AttributeSet r7, int r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003d in list [B:12:0x003a]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r5 = -1;
        r1 = 0;
        r0 = r6.f3941a;	 Catch:{ all -> 0x003e }
        r0 = r0.getDrawable();	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x0033;	 Catch:{ all -> 0x003e }
    L_0x000a:
        r2 = r6.f3941a;	 Catch:{ all -> 0x003e }
        r2 = r2.getContext();	 Catch:{ all -> 0x003e }
        r3 = android.support.v7.p028b.C0842a.C0841k.AppCompatImageView;	 Catch:{ all -> 0x003e }
        r4 = 0;	 Catch:{ all -> 0x003e }
        r1 = android.support.v7.widget.de.m7066a(r2, r7, r3, r8, r4);	 Catch:{ all -> 0x003e }
        r2 = android.support.v7.p028b.C0842a.C0841k.AppCompatImageView_srcCompat;	 Catch:{ all -> 0x003e }
        r3 = -1;	 Catch:{ all -> 0x003e }
        r2 = r1.m7082g(r2, r3);	 Catch:{ all -> 0x003e }
        if (r2 == r5) goto L_0x0033;	 Catch:{ all -> 0x003e }
    L_0x0020:
        r0 = r6.f3942b;	 Catch:{ all -> 0x003e }
        r3 = r6.f3941a;	 Catch:{ all -> 0x003e }
        r3 = r3.getContext();	 Catch:{ all -> 0x003e }
        r0 = r0.m7272a(r3, r2);	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0033;	 Catch:{ all -> 0x003e }
    L_0x002e:
        r2 = r6.f3941a;	 Catch:{ all -> 0x003e }
        r2.setImageDrawable(r0);	 Catch:{ all -> 0x003e }
    L_0x0033:
        if (r0 == 0) goto L_0x0038;	 Catch:{ all -> 0x003e }
    L_0x0035:
        android.support.v7.widget.az.m6864b(r0);	 Catch:{ all -> 0x003e }
    L_0x0038:
        if (r1 == 0) goto L_0x003d;
    L_0x003a:
        r1.m7070a();
    L_0x003d:
        return;
    L_0x003e:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0044;
    L_0x0041:
        r1.m7070a();
    L_0x0044:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.z.a(android.util.AttributeSet, int):void");
    }

    public C1014z(ImageView imageView, C1011w c1011w) {
        this.f3941a = imageView;
        this.f3942b = c1011w;
    }

    public void m7276a(int i) {
        if (i != 0) {
            Drawable a;
            if (this.f3942b != null) {
                a = this.f3942b.m7272a(this.f3941a.getContext(), i);
            } else {
                a = C0307a.m2325a(this.f3941a.getContext(), i);
            }
            if (a != null) {
                az.m6864b(a);
            }
            this.f3941a.setImageDrawable(a);
            return;
        }
        this.f3941a.setImageDrawable(null);
    }

    boolean m7278a() {
        Drawable background = this.f3941a.getBackground();
        if (VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }
}
