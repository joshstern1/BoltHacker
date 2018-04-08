package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class C0873q implements C0211t, C0872x, OnItemClickListener {
    private Rect f2924a;

    public abstract void mo860a(int i);

    public abstract void mo861a(C0197k c0197k);

    public abstract void mo862a(View view);

    public abstract void mo863a(OnDismissListener onDismissListener);

    public abstract void mo864b(int i);

    public abstract void mo865b(boolean z);

    public abstract void mo866c(int i);

    public abstract void mo867c(boolean z);

    C0873q() {
    }

    public void m5622a(Rect rect) {
        this.f2924a = rect;
    }

    public Rect m5633h() {
        return this.f2924a;
    }

    public void mo149a(Context context, C0197k c0197k) {
    }

    public boolean mo156a(C0197k c0197k, C0882m c0882m) {
        return false;
    }

    public boolean mo158b(C0197k c0197k, C0882m c0882m) {
        return false;
    }

    public int mo157b() {
        return 0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        C0873q.m5618a(listAdapter).f2969b.m1300a((MenuItem) listAdapter.getItem(i), 0);
    }

    protected static int m5617a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            ViewGroup frameLayout;
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            if (viewGroup2 == null) {
                frameLayout = new FrameLayout(context);
            } else {
                frameLayout = viewGroup2;
            }
            view = listAdapter.getView(i2, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth <= i4) {
                measuredWidth = i4;
            }
            i2++;
            i4 = measuredWidth;
            viewGroup2 = frameLayout;
        }
        return i4;
    }

    protected static C0880j m5618a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (C0880j) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (C0880j) listAdapter;
    }

    protected static boolean m5619b(C0197k c0197k) {
        int size = c0197k.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0197k.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}
