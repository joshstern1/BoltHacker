package android.support.v7.p027a;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class C0799f implements OnClickListener {
    final /* synthetic */ C0798e f2666a;

    C0799f(C0798e c0798e) {
        this.f2666a = c0798e;
    }

    public void onClick(View view) {
        Message obtain;
        if (view == this.f2666a.f2653n && this.f2666a.f2655p != null) {
            obtain = Message.obtain(this.f2666a.f2655p);
        } else if (view == this.f2666a.f2656q && this.f2666a.f2658s != null) {
            obtain = Message.obtain(this.f2666a.f2658s);
        } else if (view != this.f2666a.f2659t || this.f2666a.f2661v == null) {
            obtain = null;
        } else {
            obtain = Message.obtain(this.f2666a.f2661v);
        }
        if (obtain != null) {
            obtain.sendToTarget();
        }
        this.f2666a.f2638M.obtainMessage(1, this.f2666a.f2641b).sendToTarget();
    }
}
