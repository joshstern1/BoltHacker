package android.support.v7.p027a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.p027a.C0798e.C0795a;
import android.support.v7.p028b.C0842a.C0831a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class C0809o extends ah implements DialogInterface {
    private final C0798e f2693a = new C0798e(getContext(), this, getWindow());

    public static class C0808a {
        private final C0795a f2691a;
        private final int f2692b;

        public C0808a(Context context) {
            this(context, C0809o.m5291b(context, 0));
        }

        public C0808a(Context context, int i) {
            this.f2691a = new C0795a(new ContextThemeWrapper(context, C0809o.m5291b(context, i)));
            this.f2692b = i;
        }

        public Context m5273a() {
            return this.f2691a.f2599a;
        }

        public C0808a m5274a(int i) {
            this.f2691a.f2604f = this.f2691a.f2599a.getText(i);
            return this;
        }

        public C0808a m5282a(CharSequence charSequence) {
            this.f2691a.f2604f = charSequence;
            return this;
        }

        public C0808a m5280a(View view) {
            this.f2691a.f2605g = view;
            return this;
        }

        public C0808a m5284b(int i) {
            this.f2691a.f2606h = this.f2691a.f2599a.getText(i);
            return this;
        }

        public C0808a m5279a(Drawable drawable) {
            this.f2691a.f2602d = drawable;
            return this;
        }

        public C0808a m5275a(int i, OnClickListener onClickListener) {
            this.f2691a.f2607i = this.f2691a.f2599a.getText(i);
            this.f2691a.f2608j = onClickListener;
            return this;
        }

        public C0808a m5285b(int i, OnClickListener onClickListener) {
            this.f2691a.f2609k = this.f2691a.f2599a.getText(i);
            this.f2691a.f2610l = onClickListener;
            return this;
        }

        public C0808a m5287c(int i, OnClickListener onClickListener) {
            this.f2691a.f2611m = this.f2691a.f2599a.getText(i);
            this.f2691a.f2612n = onClickListener;
            return this;
        }

        public C0808a m5283a(boolean z) {
            this.f2691a.f2613o = z;
            return this;
        }

        public C0808a m5276a(OnCancelListener onCancelListener) {
            this.f2691a.f2614p = onCancelListener;
            return this;
        }

        public C0808a m5277a(OnDismissListener onDismissListener) {
            this.f2691a.f2615q = onDismissListener;
            return this;
        }

        public C0808a m5278a(OnKeyListener onKeyListener) {
            this.f2691a.f2616r = onKeyListener;
            return this;
        }

        public C0808a m5281a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f2691a.f2618t = listAdapter;
            this.f2691a.f2619u = onClickListener;
            return this;
        }

        public C0809o m5286b() {
            C0809o c0809o = new C0809o(this.f2691a.f2599a, this.f2692b);
            this.f2691a.m5230a(c0809o.f2693a);
            c0809o.setCancelable(this.f2691a.f2613o);
            if (this.f2691a.f2613o) {
                c0809o.setCanceledOnTouchOutside(true);
            }
            c0809o.setOnCancelListener(this.f2691a.f2614p);
            c0809o.setOnDismissListener(this.f2691a.f2615q);
            if (this.f2691a.f2616r != null) {
                c0809o.setOnKeyListener(this.f2691a.f2616r);
            }
            return c0809o;
        }

        public C0809o m5288c() {
            C0809o b = m5286b();
            b.show();
            return b;
        }
    }

    protected C0809o(Context context, int i) {
        super(context, C0809o.m5291b(context, i));
    }

    private static int m5291b(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0831a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f2693a.m5264a(charSequence);
    }

    public void m5292a(View view) {
        this.f2693a.m5271c(view);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2693a.m5259a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f2693a.m5265a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f2693a.m5269b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
