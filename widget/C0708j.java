package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0735l.C0707a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class C0708j extends BaseAdapter implements C0707a, Filterable {
    protected boolean f2368a;
    protected boolean f2369b;
    protected Cursor f2370c;
    protected Context f2371d;
    protected int f2372e;
    protected C0732a f2373f;
    protected DataSetObserver f2374g;
    protected C0735l f2375h;
    protected FilterQueryProvider f2376i;

    private class C0732a extends ContentObserver {
        final /* synthetic */ C0708j f2432a;

        public C0732a(C0708j c0708j) {
            this.f2432a = c0708j;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f2432a.m4714b();
        }
    }

    private class C0733b extends DataSetObserver {
        final /* synthetic */ C0708j f2433a;

        private C0733b(C0708j c0708j) {
            this.f2433a = c0708j;
        }

        public void onChanged() {
            this.f2433a.f2368a = true;
            this.f2433a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f2433a.f2368a = false;
            this.f2433a.notifyDataSetInvalidated();
        }
    }

    public abstract View mo684a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void mo1048a(View view, Context context, Cursor cursor);

    public C0708j(Context context, Cursor cursor, boolean z) {
        m4709a(context, cursor, z ? 1 : 2);
    }

    void m4709a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f2369b = true;
        } else {
            this.f2369b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f2370c = cursor;
        this.f2368a = z;
        this.f2371d = context;
        this.f2372e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f2373f = new C0732a(this);
            this.f2374g = new C0733b();
        } else {
            this.f2373f = null;
            this.f2374g = null;
        }
        if (z) {
            if (this.f2373f != null) {
                cursor.registerContentObserver(this.f2373f);
            }
            if (this.f2374g != null) {
                cursor.registerDataSetObserver(this.f2374g);
            }
        }
    }

    public Cursor mo680a() {
        return this.f2370c;
    }

    public int getCount() {
        if (!this.f2368a || this.f2370c == null) {
            return 0;
        }
        return this.f2370c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f2368a || this.f2370c == null) {
            return null;
        }
        this.f2370c.moveToPosition(i);
        return this.f2370c;
    }

    public long getItemId(int i) {
        if (this.f2368a && this.f2370c != null && this.f2370c.moveToPosition(i)) {
            return this.f2370c.getLong(this.f2372e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2368a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f2370c.moveToPosition(i)) {
            if (view == null) {
                view = mo684a(this.f2371d, this.f2370c, viewGroup);
            }
            mo1048a(view, this.f2371d, this.f2370c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2368a) {
            return null;
        }
        this.f2370c.moveToPosition(i);
        if (view == null) {
            view = mo685b(this.f2371d, this.f2370c, viewGroup);
        }
        mo1048a(view, this.f2371d, this.f2370c);
        return view;
    }

    public View mo685b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo684a(context, cursor, viewGroup);
    }

    public void mo682a(Cursor cursor) {
        Cursor b = m4712b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor m4712b(Cursor cursor) {
        if (cursor == this.f2370c) {
            return null;
        }
        Cursor cursor2 = this.f2370c;
        if (cursor2 != null) {
            if (this.f2373f != null) {
                cursor2.unregisterContentObserver(this.f2373f);
            }
            if (this.f2374g != null) {
                cursor2.unregisterDataSetObserver(this.f2374g);
            }
        }
        this.f2370c = cursor;
        if (cursor != null) {
            if (this.f2373f != null) {
                cursor.registerContentObserver(this.f2373f);
            }
            if (this.f2374g != null) {
                cursor.registerDataSetObserver(this.f2374g);
            }
            this.f2372e = cursor.getColumnIndexOrThrow("_id");
            this.f2368a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f2372e = -1;
        this.f2368a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public CharSequence mo683c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor mo681a(CharSequence charSequence) {
        if (this.f2376i != null) {
            return this.f2376i.runQuery(charSequence);
        }
        return this.f2370c;
    }

    public Filter getFilter() {
        if (this.f2375h == null) {
            this.f2375h = new C0735l(this);
        }
        return this.f2375h;
    }

    protected void m4714b() {
        if (this.f2369b && this.f2370c != null && !this.f2370c.isClosed()) {
            this.f2368a = this.f2370c.requery();
        }
    }
}
