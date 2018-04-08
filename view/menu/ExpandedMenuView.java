package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0197k.C0865b;
import android.support.v7.widget.de;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0865b, C0195u, OnItemClickListener {
    private static final int[] f2875a = new int[]{16842964, 16843049};
    private C0197k f2876b;
    private int f2877c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        de a = de.m7066a(context, attributeSet, f2875a, i, 0);
        if (a.m7083g(0)) {
            setBackgroundDrawable(a.m7069a(0));
        }
        if (a.m7083g(1)) {
            setDivider(a.m7069a(1));
        }
        a.m7070a();
    }

    public void mo141a(C0197k c0197k) {
        this.f2876b = c0197k;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean mo848a(C0882m c0882m) {
        return this.f2876b.m1300a((MenuItem) c0882m, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo848a((C0882m) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f2877c;
    }
}
