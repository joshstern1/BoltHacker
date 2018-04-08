package com.codetroopers.betterpickers.calendardatepicker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.C0390p;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.codetroopers.betterpickers.C1282a;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1288e;
import com.codetroopers.betterpickers.C1292c.C1289f;
import com.codetroopers.betterpickers.C1292c.C1290g;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.C1314d;
import com.codetroopers.betterpickers.calendardatepicker.C1305g.C1303a;
import com.p059c.p060a.C1260k;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class C1297b extends C0390p implements OnClickListener, C1293a {
    private static final C1303a aj = new C1303a(1900, 0, 1);
    private static final C1303a ak = new C1303a(2100, 11, 31);
    private static final SimpleDateFormat al = new SimpleDateFormat("yyyy", Locale.getDefault());
    private static final SimpleDateFormat am = new SimpleDateFormat("dd", Locale.getDefault());
    private int aA = -1;
    private int aB = this.an.getFirstDayOfWeek();
    private C1303a aC = aj;
    private C1303a aD = ak;
    private C1282a aE;
    private boolean aF = true;
    private String aG;
    private String aH;
    private String aI;
    private String aJ;
    private int aK;
    private int aL;
    private int aM;
    private final Calendar an = Calendar.getInstance();
    private C1295b ao;
    private C1296c ap;
    private HashSet<C1294a> aq = new HashSet();
    private AccessibleDateAnimator ar;
    private LinearLayout as;
    private TextView at;
    private LinearLayout au;
    private TextView av;
    private TextView aw;
    private TextView ax;
    private C1301e ay;
    private C1312l az;

    public interface C1294a {
        void mo1262a();
    }

    public interface C1295b {
        void mo2216a(C1297b c1297b, int i, int i2, int i3);
    }

    public interface C1296c {
        void m8510a(DialogInterface dialogInterface);
    }

    public static C1297b m8513a(C1295b c1295b, int i, int i2, int i3) {
        C1297b c1297b = new C1297b();
        c1297b.m8523b(c1295b, i, i2, i3);
        return c1297b;
    }

    public void m8523b(C1295b c1295b, int i, int i2, int i3) {
        this.ao = c1295b;
        this.an.set(1, i);
        this.an.set(2, i2);
        this.an.set(5, i3);
        this.aK = C1290g.BetterPickersRadialTimePickerDialog;
    }

    public void mo349a(Bundle bundle) {
        super.mo349a(bundle);
        m2309l().getWindow().setSoftInputMode(3);
        if (bundle != null) {
            this.an.set(1, bundle.getInt("year"));
            this.an.set(2, bundle.getInt("month"));
            this.an.set(5, bundle.getInt("day"));
        }
    }

    public void mo353e(Bundle bundle) {
        super.mo353e(bundle);
        bundle.putInt("year", this.an.get(1));
        bundle.putInt("month", this.an.get(2));
        bundle.putInt("day", this.an.get(5));
        bundle.putInt("week_start", this.aB);
        bundle.putLong("date_start", this.aC.m8542a());
        bundle.putLong("date_end", this.aD.m8542a());
        bundle.putInt("current_view", this.aA);
        bundle.putInt("theme", this.aK);
        int i = -1;
        if (this.aA == 0) {
            i = this.ay.getMostVisiblePosition();
        } else if (this.aA == 1) {
            i = this.az.getFirstVisiblePosition();
            bundle.putInt("list_position_offset", this.az.getFirstPositionOffset());
        }
        bundle.putInt("list_position", i);
    }

    public View mo1250a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.d("DatePickerDialog", "onCreateView: ");
        if (g_()) {
            m2700b().getWindow().requestFeature(1);
        }
        View inflate = layoutInflater.inflate(C1288e.calendar_date_picker_dialog, null);
        this.as = (LinearLayout) inflate.findViewById(C1287d.day_picker_selected_date_layout);
        this.at = (TextView) inflate.findViewById(C1287d.date_picker_header);
        this.au = (LinearLayout) inflate.findViewById(C1287d.date_picker_month_and_day);
        this.au.setOnClickListener(this);
        this.av = (TextView) inflate.findViewById(C1287d.date_picker_month);
        this.aw = (TextView) inflate.findViewById(C1287d.date_picker_day);
        this.ax = (TextView) inflate.findViewById(C1287d.date_picker_year);
        this.ax.setOnClickListener(this);
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        if (bundle != null) {
            this.aB = bundle.getInt("week_start");
            this.aC = new C1303a(bundle.getLong("date_start"));
            this.aD = new C1303a(bundle.getLong("date_end"));
            i3 = bundle.getInt("current_view");
            i = bundle.getInt("list_position");
            i2 = bundle.getInt("list_position_offset");
            this.aK = bundle.getInt("theme");
        }
        int i4 = i;
        i = i2;
        i2 = i3;
        Context l = m2309l();
        this.ay = new C1308i(l, (C1293a) this);
        this.az = new C1312l(l, this);
        Resources m = m2310m();
        TypedArray obtainStyledAttributes = m2309l().obtainStyledAttributes(this.aK, C1291h.BetterPickersDialog);
        this.aG = m.getString(C1289f.day_picker_description);
        this.aH = m.getString(C1289f.select_day);
        this.aI = m.getString(C1289f.year_picker_description);
        this.aJ = m.getString(C1289f.select_year);
        this.aL = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpAccentColor, C1284a.bpBlue);
        this.aM = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.numbers_text_color);
        this.ar = (AccessibleDateAnimator) inflate.findViewById(C1287d.animator);
        this.ar.addView(this.ay);
        this.ar.addView(this.az);
        this.ar.setDateMillis(this.an.getTimeInMillis());
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        this.ar.setInAnimation(alphaAnimation);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        this.ar.setOutAnimation(alphaAnimation);
        Button button = (Button) inflate.findViewById(C1287d.done_button);
        button.setTextColor(this.aL);
        button.setOnClickListener(new C1298c(this));
        button = (Button) inflate.findViewById(C1287d.cancel_button);
        button.setTextColor(this.aL);
        button.setOnClickListener(new C1299d(this));
        m8517f(false);
        m8516b(i2);
        if (i4 != -1) {
            if (i2 == 0) {
                this.ay.m8535a(i4);
            } else if (i2 == 1) {
                this.az.m8594a(i4, i);
            }
        }
        this.aE = new C1282a(l);
        i3 = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpMainColor1, C1284a.bpWhite);
        i2 = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpMainColor2, C1284a.circle_background);
        i = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpLineColor, C1284a.bpWhite);
        this.ay.setTheme(obtainStyledAttributes);
        this.az.setTheme(obtainStyledAttributes);
        this.as.setBackgroundColor(i3);
        this.ax.setBackgroundColor(i3);
        this.au.setBackgroundColor(i3);
        inflate.setBackgroundColor(i2);
        if (this.at != null) {
            this.at.setBackgroundColor(i);
        }
        this.az.setBackgroundColor(i2);
        this.ay.setBackgroundColor(i2);
        return inflate;
    }

    public void mo1260u() {
        super.mo1260u();
        this.aE.m8499a();
    }

    public void mo1261v() {
        super.mo1261v();
        this.aE.m8500b();
    }

    private void m8516b(int i) {
        long timeInMillis = this.an.getTimeInMillis();
        C1260k a;
        switch (i) {
            case 0:
                a = C1314d.m8596a(this.au, 0.9f, 1.05f);
                if (this.aF) {
                    a.m8300d(500);
                    this.aF = false;
                }
                this.ay.mo1262a();
                if (this.aA != i) {
                    this.au.setSelected(true);
                    this.ax.setSelected(false);
                    this.aw.setTextColor(this.aL);
                    this.av.setTextColor(this.aL);
                    this.ax.setTextColor(this.aM);
                    this.ar.setDisplayedChild(0);
                    this.aA = i;
                }
                a.mo1219a();
                this.ar.setContentDescription(this.aG + ": " + DateUtils.formatDateTime(m2309l(), timeInMillis, 16));
                C1314d.m8597a(this.ar, this.aH);
                return;
            case 1:
                a = C1314d.m8596a(this.ax, 0.85f, 1.1f);
                if (this.aF) {
                    a.m8300d(500);
                    this.aF = false;
                }
                this.az.mo1262a();
                if (this.aA != i) {
                    this.au.setSelected(false);
                    this.ax.setSelected(true);
                    this.aw.setTextColor(this.aM);
                    this.av.setTextColor(this.aM);
                    this.ax.setTextColor(this.aL);
                    this.ar.setDisplayedChild(1);
                    this.aA = i;
                }
                a.mo1219a();
                this.ar.setContentDescription(this.aI + ": " + al.format(Long.valueOf(timeInMillis)));
                C1314d.m8597a(this.ar, this.aJ);
                return;
            default:
                return;
        }
    }

    private void m8517f(boolean z) {
        if (this.at != null) {
            this.at.setText(this.an.getDisplayName(7, 2, Locale.getDefault()).toUpperCase(Locale.getDefault()));
        }
        this.av.setText(this.an.getDisplayName(2, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()));
        this.aw.setText(am.format(this.an.getTime()));
        this.ax.setText(al.format(this.an.getTime()));
        long timeInMillis = this.an.getTimeInMillis();
        this.ar.setDateMillis(timeInMillis);
        this.au.setContentDescription(DateUtils.formatDateTime(m2309l(), timeInMillis, 24));
        if (z) {
            C1314d.m8597a(this.ar, DateUtils.formatDateTime(m2309l(), timeInMillis, 20));
        }
    }

    public void m8522a(C1303a c1303a, C1303a c1303a2) {
        if (c1303a == null) {
            this.aC = aj;
        } else {
            this.aC = c1303a;
        }
        if (c1303a2 == null) {
            this.aD = ak;
        } else {
            this.aD = c1303a2;
        }
        if (this.aD.m8545b(this.aC) < 0) {
            throw new IllegalArgumentException("End date must be larger than start date");
        } else if (this.ay != null) {
            this.ay.m8538b();
        }
    }

    private void m8514a(int i, int i2) {
        int i3 = this.an.get(5);
        int a = C1314d.m8595a(i, i2);
        if (i3 > a) {
            this.an.set(5, a);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.ap != null) {
            this.ap.m8510a(dialogInterface);
        }
    }

    public void onClick(View view) {
        e_();
        if (view.getId() == C1287d.date_picker_year) {
            m8516b(1);
        } else if (view.getId() == C1287d.date_picker_month_and_day) {
            m8516b(0);
        }
    }

    public void a_(int i) {
        m8514a(this.an.get(2), i);
        this.an.set(1, i);
        m8511R();
        m8516b(0);
        m8517f(true);
    }

    public void mo1251a(int i, int i2, int i3) {
        this.an.set(1, i);
        this.an.set(2, i2);
        this.an.set(5, i3);
        m8511R();
        m8517f(true);
    }

    private void m8511R() {
        Iterator it = this.aq.iterator();
        while (it.hasNext()) {
            ((C1294a) it.next()).mo1262a();
        }
    }

    public C1303a c_() {
        return new C1303a(this.an);
    }

    public C1303a mo1254c() {
        return this.aC;
    }

    public C1303a mo1256d() {
        return this.aD;
    }

    public int d_() {
        return this.aB;
    }

    public void mo1252a(C1294a c1294a) {
        this.aq.add(c1294a);
    }

    public void e_() {
        this.aE.m8501c();
    }
}
