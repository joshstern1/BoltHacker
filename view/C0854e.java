package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0778b.C0825a;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0197k.C0253a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class C0854e extends C0778b implements C0253a {
    private Context f2794a;
    private ActionBarContextView f2795b;
    private C0825a f2796c;
    private WeakReference<View> f2797d;
    private boolean f2798e;
    private boolean f2799f;
    private C0197k f2800g;

    public C0854e(Context context, ActionBarContextView actionBarContextView, C0825a c0825a, boolean z) {
        this.f2794a = context;
        this.f2795b = actionBarContextView;
        this.f2796c = c0825a;
        this.f2800g = new C0197k(actionBarContextView.getContext()).m1284a(1);
        this.f2800g.mo161a((C0253a) this);
        this.f2799f = z;
    }

    public void mo760b(CharSequence charSequence) {
        this.f2795b.setTitle(charSequence);
    }

    public void mo756a(CharSequence charSequence) {
        this.f2795b.setSubtitle(charSequence);
    }

    public void mo754a(int i) {
        mo760b(this.f2794a.getString(i));
    }

    public void mo759b(int i) {
        mo756a(this.f2794a.getString(i));
    }

    public void mo757a(boolean z) {
        super.mo757a(z);
        this.f2795b.setTitleOptional(z);
    }

    public boolean mo765h() {
        return this.f2795b.m5793d();
    }

    public void mo755a(View view) {
        this.f2795b.setCustomView(view);
        this.f2797d = view != null ? new WeakReference(view) : null;
    }

    public void mo762d() {
        this.f2796c.mo843b(this, this.f2800g);
    }

    public void mo761c() {
        if (!this.f2798e) {
            this.f2798e = true;
            this.f2795b.sendAccessibilityEvent(32);
            this.f2796c.mo840a(this);
        }
    }

    public Menu mo758b() {
        return this.f2800g;
    }

    public CharSequence mo763f() {
        return this.f2795b.getTitle();
    }

    public CharSequence mo764g() {
        return this.f2795b.getSubtitle();
    }

    public View mo766i() {
        return this.f2797d != null ? (View) this.f2797d.get() : null;
    }

    public MenuInflater mo753a() {
        return new C0859g(this.f2795b.getContext());
    }

    public boolean mo223a(C0197k c0197k, MenuItem menuItem) {
        return this.f2796c.mo842a((C0778b) this, menuItem);
    }

    public void mo222a(C0197k c0197k) {
        mo762d();
        this.f2795b.mo889a();
    }
}
