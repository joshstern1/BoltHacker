package com.codetroopers.betterpickers.calendardatepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.codetroopers.betterpickers.calendardatepicker.C1307h.C1304b;
import java.util.Calendar;
import java.util.HashMap;

public abstract class C1305g extends BaseAdapter implements C1304b {
    protected static int f4766a = 7;
    private final Context f4767b;
    private final C1293a f4768c;
    private C1303a f4769d;
    private TypedArray f4770e;

    public static class C1303a implements Comparable<C1303a> {
        int f4762a;
        int f4763b;
        int f4764c;
        private Calendar f4765d;

        public /* synthetic */ int compareTo(Object obj) {
            return m8545b((C1303a) obj);
        }

        public C1303a() {
            m8541a(System.currentTimeMillis());
        }

        public C1303a(long j) {
            m8541a(j);
        }

        public C1303a(Calendar calendar) {
            this.f4762a = calendar.get(1);
            this.f4763b = calendar.get(2);
            this.f4764c = calendar.get(5);
        }

        public C1303a(int i, int i2, int i3) {
            m8543a(i, i2, i3);
        }

        public void m8544a(C1303a c1303a) {
            this.f4762a = c1303a.f4762a;
            this.f4763b = c1303a.f4763b;
            this.f4764c = c1303a.f4764c;
        }

        public void m8543a(int i, int i2, int i3) {
            this.f4765d = Calendar.getInstance();
            this.f4765d.set(i, i2, i3, 0, 0, 0);
            this.f4762a = this.f4765d.get(1);
            this.f4763b = this.f4765d.get(2);
            this.f4764c = this.f4765d.get(5);
        }

        public long m8542a() {
            if (this.f4765d == null) {
                this.f4765d = Calendar.getInstance();
                this.f4765d.set(this.f4762a, this.f4763b, this.f4764c, 0, 0, 0);
            }
            return this.f4765d.getTimeInMillis();
        }

        private void m8541a(long j) {
            if (this.f4765d == null) {
                this.f4765d = Calendar.getInstance();
            }
            this.f4765d.setTimeInMillis(j);
            this.f4763b = this.f4765d.get(2);
            this.f4762a = this.f4765d.get(1);
            this.f4764c = this.f4765d.get(5);
        }

        public int m8545b(C1303a c1303a) {
            if (this.f4762a < c1303a.f4762a || ((this.f4762a == c1303a.f4762a && this.f4763b < c1303a.f4763b) || (this.f4762a == c1303a.f4762a && this.f4763b == c1303a.f4763b && this.f4764c < c1303a.f4764c))) {
                return -1;
            }
            if (this.f4762a == c1303a.f4762a && this.f4763b == c1303a.f4763b && this.f4764c == c1303a.f4764c) {
                return 0;
            }
            return 1;
        }
    }

    public abstract C1307h mo1271a(Context context);

    public void m8553a(TypedArray typedArray) {
        this.f4770e = typedArray;
    }

    public C1305g(Context context, C1293a c1293a) {
        this.f4767b = context;
        this.f4768c = c1293a;
        m8552a();
        m8554a(this.f4768c.c_());
    }

    public void m8554a(C1303a c1303a) {
        this.f4769d = c1303a;
        notifyDataSetChanged();
    }

    protected void m8552a() {
        this.f4769d = new C1303a(System.currentTimeMillis());
        if (this.f4769d.m8545b(this.f4768c.mo1256d()) > 0) {
            this.f4769d = this.f4768c.mo1256d();
        }
        if (this.f4769d.m8545b(this.f4768c.mo1254c()) < 0) {
            this.f4769d = this.f4768c.mo1254c();
        }
    }

    public int getCount() {
        return ((((this.f4768c.mo1256d().f4762a - this.f4768c.mo1254c().f4762a) + 1) * 12) - (11 - this.f4768c.mo1256d().f4763b)) - this.f4768c.mo1254c().f4763b;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    @SuppressLint({"NewApi"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        int i3;
        int i4 = -1;
        HashMap hashMap = null;
        if (view != null) {
            view = (C1307h) view;
            hashMap = (HashMap) view.getTag();
        } else {
            view = mo1271a(this.f4767b);
            view.setTheme(this.f4770e);
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.setClickable(true);
            view.setOnDayClickListener(this);
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.clear();
        int i5 = (this.f4768c.mo1254c().f4763b + i) % 12;
        int i6 = ((this.f4768c.mo1254c().f4763b + i) / 12) + this.f4768c.mo1254c().f4762a;
        if (m8547a(i6, i5)) {
            i2 = this.f4769d.f4764c;
        } else {
            i2 = -1;
        }
        if (m8548b(i6, i5)) {
            i3 = this.f4768c.mo1254c().f4764c;
        } else {
            i3 = -1;
        }
        if (m8549c(i6, i5)) {
            i4 = this.f4768c.mo1256d().f4764c;
        }
        view.m8579b();
        hashMap.put("selected_day", Integer.valueOf(i2));
        hashMap.put("year", Integer.valueOf(i6));
        hashMap.put("month", Integer.valueOf(i5));
        hashMap.put("week_start", Integer.valueOf(this.f4768c.d_()));
        hashMap.put("range_min", Integer.valueOf(i3));
        hashMap.put("range_max", Integer.valueOf(i4));
        view.setMonthParams(hashMap);
        view.invalidate();
        return view;
    }

    private boolean m8547a(int i, int i2) {
        return this.f4769d.f4762a == i && this.f4769d.f4763b == i2;
    }

    private boolean m8548b(int i, int i2) {
        return this.f4768c.mo1254c().f4762a == i && this.f4768c.mo1254c().f4763b == i2;
    }

    private boolean m8549c(int i, int i2) {
        return this.f4768c.mo1256d().f4762a == i && this.f4768c.mo1256d().f4763b == i2;
    }

    public void mo1263a(C1307h c1307h, C1303a c1303a) {
        if (c1303a != null && m8550c(c1303a)) {
            m8556b(c1303a);
        }
    }

    private boolean m8550c(C1303a c1303a) {
        return c1303a.m8545b(this.f4768c.mo1254c()) >= 0 && c1303a.m8545b(this.f4768c.mo1256d()) <= 0;
    }

    protected void m8556b(C1303a c1303a) {
        this.f4768c.e_();
        this.f4768c.mo1251a(c1303a.f4762a, c1303a.f4763b, c1303a.f4764c);
        m8554a(c1303a);
    }
}
