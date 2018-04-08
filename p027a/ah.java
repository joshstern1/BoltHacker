package android.support.v7.p027a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.view.C0778b;
import android.support.v7.view.C0778b.C0825a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ah extends Dialog implements C0763q {
    private C0811r f2462a;

    public ah(Context context, int i) {
        super(context, ah.m5005a(context, i));
        m5006a().mo819a(null);
        m5006a().mo812i();
    }

    protected void onCreate(Bundle bundle) {
        m5006a().mo834h();
        super.onCreate(bundle);
        m5006a().mo819a(bundle);
    }

    public void setContentView(int i) {
        m5006a().mo825b(i);
    }

    public void setContentView(View view) {
        m5006a().mo821a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m5006a().mo822a(view, layoutParams);
    }

    public View findViewById(int i) {
        return m5006a().mo816a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m5006a().mo807a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m5006a().mo807a(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m5006a().mo827b(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        m5006a().mo830c();
    }

    public boolean m5009a(int i) {
        return m5006a().mo831c(i);
    }

    public void invalidateOptionsMenu() {
        m5006a().mo833e();
    }

    public C0811r m5006a() {
        if (this.f2462a == null) {
            this.f2462a = C0811r.m5309a((Dialog) this, (C0763q) this);
        }
        return this.f2462a;
    }

    private static int m5005a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0831a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void mo724a(C0778b c0778b) {
    }

    public void mo725b(C0778b c0778b) {
    }

    public C0778b mo723a(C0825a c0825a) {
        return null;
    }
}
