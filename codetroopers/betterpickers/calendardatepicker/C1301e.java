package com.codetroopers.betterpickers.calendardatepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.codetroopers.betterpickers.C1314d;
import com.codetroopers.betterpickers.calendardatepicker.C1297b.C1294a;
import com.codetroopers.betterpickers.calendardatepicker.C1305g.C1303a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;
import no.nordicsemi.android.dfu.DfuBaseService;

public abstract class C1301e extends ListView implements OnScrollListener, C1294a {
    private static final SimpleDateFormat f4743o = new SimpleDateFormat("yyyy", Locale.getDefault());
    protected int f4744a = 6;
    protected boolean f4745b = false;
    protected int f4746c = 7;
    protected float f4747d = 1.0f;
    protected Context f4748e;
    protected Handler f4749f;
    protected C1303a f4750g = new C1303a();
    protected C1305g f4751h;
    protected C1303a f4752i = new C1303a();
    protected int f4753j;
    protected long f4754k;
    protected int f4755l = 0;
    protected int f4756m = 0;
    protected C1300a f4757n = new C1300a(this);
    private C1293a f4758p;
    private boolean f4759q;

    protected class C1300a implements Runnable {
        final /* synthetic */ C1301e f4741a;
        private int f4742b;

        protected C1300a(C1301e c1301e) {
            this.f4741a = c1301e;
        }

        public void m8529a(AbsListView absListView, int i) {
            this.f4741a.f4749f.removeCallbacks(this);
            this.f4742b = i;
            this.f4741a.f4749f.postDelayed(this, 40);
        }

        public void run() {
            int i = 1;
            this.f4741a.f4756m = this.f4742b;
            if (Log.isLoggable("MonthFragment", 3)) {
                Log.d("MonthFragment", "new scroll state: " + this.f4742b + " old state: " + this.f4741a.f4755l);
            }
            if (this.f4742b != 0 || this.f4741a.f4755l == 0 || this.f4741a.f4755l == 1) {
                this.f4741a.f4755l = this.f4742b;
                return;
            }
            this.f4741a.f4755l = this.f4742b;
            View childAt = this.f4741a.getChildAt(0);
            int i2 = 0;
            while (childAt != null && childAt.getBottom() <= 0) {
                i2++;
                childAt = this.f4741a.getChildAt(i2);
            }
            if (childAt != null) {
                i2 = this.f4741a.getFirstVisiblePosition();
                int lastVisiblePosition = this.f4741a.getLastVisiblePosition();
                if (i2 == 0 || lastVisiblePosition == this.f4741a.getCount() - 1) {
                    i = 0;
                }
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                i2 = this.f4741a.getHeight() / 2;
                if (i != 0 && top < -1) {
                    if (bottom > i2) {
                        this.f4741a.smoothScrollBy(top, SQLiteDatabase.MAX_SQL_CACHE_SIZE);
                    } else {
                        this.f4741a.smoothScrollBy(bottom, SQLiteDatabase.MAX_SQL_CACHE_SIZE);
                    }
                }
            }
        }
    }

    public abstract C1305g mo1270a(Context context, C1293a c1293a);

    public C1301e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8536a(context);
    }

    public C1301e(Context context, C1293a c1293a) {
        super(context);
        m8536a(context);
        setController(c1293a);
    }

    public void setController(C1293a c1293a) {
        this.f4758p = c1293a;
        this.f4758p.mo1252a(this);
        m8539c();
        mo1262a();
    }

    public void m8536a(Context context) {
        this.f4749f = new Handler();
        setLayoutParams(new LayoutParams(-1, -1));
        setDrawSelectorOnTop(false);
        this.f4748e = context;
        m8540d();
    }

    public void m8538b() {
        m8539c();
    }

    protected void m8539c() {
        if (this.f4751h == null) {
            this.f4751h = mo1270a(getContext(), this.f4758p);
        } else {
            this.f4751h.m8554a(this.f4750g);
        }
        setAdapter(this.f4751h);
    }

    @SuppressLint({"NewApi"})
    protected void m8540d() {
        setCacheColorHint(0);
        setDivider(null);
        setItemsCanFocus(true);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(this);
        setFadingEdgeLength(0);
        if (VERSION.SDK_INT >= 11) {
            setFriction(ViewConfiguration.getScrollFriction() * this.f4747d);
        }
    }

    public boolean m8537a(C1303a c1303a, boolean z, boolean z2, boolean z3) {
        if (z2) {
            this.f4750g.m8544a(c1303a);
        }
        this.f4752i.m8544a(c1303a);
        int i = ((c1303a.f4762a - this.f4758p.mo1254c().f4762a) * 12) + (c1303a.f4763b - this.f4758p.mo1254c().f4763b);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = getChildAt(i2);
            if (childAt != null) {
                int top = childAt.getTop();
                if (Log.isLoggable("MonthFragment", 3)) {
                    Log.d("MonthFragment", "child at " + (i3 - 1) + " has top " + top);
                }
                if (top >= 0) {
                    break;
                }
                i2 = i3;
            } else {
                break;
            }
        }
        if (childAt != null) {
            i2 = getPositionForView(childAt);
        } else {
            i2 = 0;
        }
        if (z2) {
            this.f4751h.m8554a(this.f4750g);
        }
        if (Log.isLoggable("MonthFragment", 3)) {
            Log.d("MonthFragment", "GoTo position " + i);
        }
        if (i != i2 || z3) {
            setMonthDisplayed(this.f4752i);
            this.f4755l = 2;
            if (!z || VERSION.SDK_INT < 11) {
                m8535a(i);
                return false;
            }
            smoothScrollToPositionFromTop(i, -1, SQLiteDatabase.MAX_SQL_CACHE_SIZE);
            return true;
        } else if (!z2) {
            return false;
        } else {
            setMonthDisplayed(this.f4750g);
            return false;
        }
    }

    public void m8535a(int i) {
        clearFocus();
        post(new C1302f(this, i));
        onScrollStateChanged(this, 0);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        C1307h c1307h = (C1307h) absListView.getChildAt(0);
        if (c1307h != null) {
            this.f4754k = (long) ((absListView.getFirstVisiblePosition() * c1307h.getHeight()) - c1307h.getBottom());
            this.f4755l = this.f4756m;
        }
    }

    protected void setMonthDisplayed(C1303a c1303a) {
        this.f4753j = c1303a.f4763b;
        invalidateViews();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f4757n.m8529a(absListView, i);
    }

    public void setTheme(TypedArray typedArray) {
        if (this.f4751h != null) {
            this.f4751h.m8553a(typedArray);
        }
    }

    public int getMostVisiblePosition() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int height = getHeight();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < height) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                break;
            }
            int bottom = childAt.getBottom();
            i = Math.min(bottom, height) - Math.max(0, childAt.getTop());
            if (i > i4) {
                i3 = i2;
            } else {
                i = i4;
            }
            i2++;
            i4 = i;
            i = bottom;
        }
        return i3 + firstVisiblePosition;
    }

    public void mo1262a() {
        m8537a(this.f4758p.c_(), false, true, true);
    }

    private C1303a m8532e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof C1307h) {
                C1303a accessibilityFocus = ((C1307h) childAt).getAccessibilityFocus();
                if (accessibilityFocus != null) {
                    if (VERSION.SDK_INT != 17) {
                        return accessibilityFocus;
                    }
                    ((C1307h) childAt).m8580c();
                    return accessibilityFocus;
                }
            }
        }
        return null;
    }

    private boolean m8530a(C1303a c1303a) {
        if (c1303a == null) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof C1307h) && ((C1307h) childAt).m8578a(c1303a)) {
                return true;
            }
        }
        return false;
    }

    protected void layoutChildren() {
        C1303a e = m8532e();
        super.layoutChildren();
        if (this.f4759q) {
            this.f4759q = false;
        } else {
            m8530a(e);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(-1);
    }

    private String m8531b(C1303a c1303a) {
        Calendar instance = Calendar.getInstance();
        instance.set(c1303a.f4762a, c1303a.f4763b, c1303a.f4764c);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(instance.getDisplayName(2, 2, Locale.getDefault()));
        stringBuffer.append(" ");
        stringBuffer.append(f4743o.format(instance.getTime()));
        return stringBuffer.toString();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.addAction(DfuBaseService.ERROR_REMOTE_MASK);
    }

    @SuppressLint({"NewApi"})
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i != 4096 && i != DfuBaseService.ERROR_REMOTE_MASK) {
            return super.performAccessibilityAction(i, bundle);
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        C1303a c1303a = new C1303a((firstVisiblePosition / 12) + this.f4758p.mo1254c().f4762a, firstVisiblePosition % 12, 1);
        if (i == 4096) {
            c1303a.f4763b++;
            if (c1303a.f4763b == 12) {
                c1303a.f4763b = 0;
                c1303a.f4762a++;
            }
        } else if (i == DfuBaseService.ERROR_REMOTE_MASK) {
            View childAt = getChildAt(0);
            if (childAt != null && childAt.getTop() >= -1) {
                c1303a.f4763b--;
                if (c1303a.f4763b == -1) {
                    c1303a.f4763b = 11;
                    c1303a.f4762a--;
                }
            }
        }
        C1314d.m8597a((View) this, m8531b(c1303a));
        m8537a(c1303a, true, false, true);
        this.f4759q = true;
        return true;
    }
}
