package com.codetroopers.betterpickers.radialtimepicker;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.C0390p;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.codetroopers.betterpickers.C1282a;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1287d;
import com.codetroopers.betterpickers.C1292c.C1288e;
import com.codetroopers.betterpickers.C1292c.C1289f;
import com.codetroopers.betterpickers.C1292c.C1290g;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.C1314d;
import com.codetroopers.betterpickers.radialtimepicker.RadialPickerLayout.C1328a;
import com.p059c.p060a.C1260k;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class C1343i extends C0390p implements C1328a {
    private int aA;
    private int aB;
    private boolean aC;
    private int aD;
    private char aE;
    private String aF;
    private String aG;
    private boolean aH;
    private ArrayList<Integer> aI;
    private C1340b aJ;
    private int aK;
    private int aL;
    private String aM;
    private String aN;
    private String aO;
    private String aP;
    private C1341c aj;
    private C1342d ak;
    private C1282a al;
    private Button am;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private TextView aq;
    private TextView ar;
    private View as;
    private RadialPickerLayout at;
    private int au;
    private int av;
    private String aw;
    private String ax;
    private String ay;
    private boolean az;

    private class C1339a implements OnKeyListener {
        final /* synthetic */ C1343i f5110a;

        private C1339a(C1343i c1343i) {
            this.f5110a = c1343i;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            return keyEvent.getAction() == 1 && this.f5110a.m8749d(i);
        }
    }

    private class C1340b {
        final /* synthetic */ C1343i f5111a;
        private int[] f5112b;
        private ArrayList<C1340b> f5113c = new ArrayList();

        public C1340b(C1343i c1343i, int... iArr) {
            this.f5111a = c1343i;
            this.f5112b = iArr;
        }

        public void m8726a(C1340b c1340b) {
            this.f5113c.add(c1340b);
        }

        public boolean m8727a(int i) {
            for (int i2 : this.f5112b) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public C1340b m8728b(int i) {
            if (this.f5113c == null) {
                return null;
            }
            Iterator it = this.f5113c.iterator();
            while (it.hasNext()) {
                C1340b c1340b = (C1340b) it.next();
                if (c1340b.m8727a(i)) {
                    return c1340b;
                }
            }
            return null;
        }
    }

    public interface C1341c {
        void m8729a(DialogInterface dialogInterface);
    }

    public interface C1342d {
        void mo2217a(C1343i c1343i, int i, int i2);
    }

    public static C1343i m8735a(C1342d c1342d, int i, int i2, boolean z) {
        C1343i c1343i = new C1343i();
        c1343i.m8760b(c1342d, i, i2, z);
        return c1343i;
    }

    public void m8760b(C1342d c1342d, int i, int i2, boolean z) {
        this.ak = c1342d;
        this.aA = i;
        this.aB = i2;
        this.aC = z;
        this.aH = false;
        this.aD = C1290g.BetterPickersRadialTimePickerDialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.aj != null) {
            this.aj.m8729a(dialogInterface);
        }
    }

    public void mo349a(Bundle bundle) {
        super.mo349a(bundle);
        if (bundle != null && bundle.containsKey("hour_of_day") && bundle.containsKey("minute") && bundle.containsKey("is_24_hour_view")) {
            this.aA = bundle.getInt("hour_of_day");
            this.aB = bundle.getInt("minute");
            this.aC = bundle.getBoolean("is_24_hour_view");
            this.aH = bundle.getBoolean("in_kb_mode");
            this.aD = bundle.getInt("theme");
        }
    }

    public View mo1250a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (g_()) {
            m2700b().getWindow().requestFeature(1);
        }
        View inflate = layoutInflater.inflate(C1288e.radial_time_picker_dialog, null);
        OnKeyListener c1339a = new C1339a();
        inflate.findViewById(C1287d.time_picker_dialog).setOnKeyListener(c1339a);
        Resources m = m2310m();
        TypedArray obtainStyledAttributes = m2309l().obtainStyledAttributes(this.aD, C1291h.BetterPickersDialog);
        this.aM = m.getString(C1289f.hour_picker_description);
        this.aN = m.getString(C1289f.select_hours);
        this.aO = m.getString(C1289f.minute_picker_description);
        this.aP = m.getString(C1289f.select_minutes);
        this.au = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpAccentColor, C1284a.bpBlue);
        this.av = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.numbers_text_color);
        this.an = (TextView) inflate.findViewById(C1287d.hours);
        this.an.setOnKeyListener(c1339a);
        this.ao = (TextView) inflate.findViewById(C1287d.hour_space);
        this.aq = (TextView) inflate.findViewById(C1287d.minutes_space);
        this.ap = (TextView) inflate.findViewById(C1287d.minutes);
        this.ap.setOnKeyListener(c1339a);
        this.ar = (TextView) inflate.findViewById(C1287d.ampm_label);
        this.ar.setOnKeyListener(c1339a);
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.aw = amPmStrings[0];
        this.ax = amPmStrings[1];
        this.al = new C1282a(m2309l());
        this.at = (RadialPickerLayout) inflate.findViewById(C1287d.time_picker);
        this.at.setOnValueSelectedListener(this);
        this.at.setOnKeyListener(c1339a);
        this.at.m8712a(m2309l(), this.al, this.aA, this.aB, this.aC);
        int i = 0;
        if (bundle != null && bundle.containsKey("current_item_showing")) {
            i = bundle.getInt("current_item_showing");
        }
        m8737a(i, false, true, true);
        this.at.invalidate();
        this.an.setOnClickListener(new C1344j(this));
        this.ap.setOnClickListener(new C1345k(this));
        this.am = (Button) inflate.findViewById(C1287d.done_button);
        if (this.ay != null) {
            this.am.setText(this.ay);
        }
        this.am.setTextColor(this.au);
        this.am.setOnClickListener(new C1346l(this));
        this.am.setOnKeyListener(c1339a);
        Button button = (Button) inflate.findViewById(C1287d.cancel_button);
        button.setTextColor(this.au);
        button.setOnClickListener(new C1347m(this));
        this.as = inflate.findViewById(C1287d.ampm_hitspace);
        if (this.aC) {
            this.ar.setVisibility(8);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((TextView) inflate.findViewById(C1287d.separator)).setLayoutParams(layoutParams);
        } else {
            this.ar.setVisibility(0);
            m8743b(this.aA < 12 ? 0 : 1);
            this.as.setOnClickListener(new C1348n(this));
        }
        this.az = true;
        m8736a(this.aA, true);
        m8747c(this.aB);
        this.aF = m.getString(C1289f.time_placeholder);
        this.aG = m.getString(C1289f.deleted_key);
        this.aE = this.aF.charAt(0);
        this.aL = -1;
        this.aK = -1;
        m8734V();
        if (this.aH) {
            this.aI = bundle.getIntegerArrayList("typed_times");
            m8750e(-1);
            this.an.invalidate();
        } else if (this.aI == null) {
            this.aI = new ArrayList();
        }
        this.at.setTheme(obtainStyledAttributes);
        i = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpMainColor1, C1284a.bpWhite);
        int color = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpMainColor2, C1284a.circle_background);
        obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpLineColor, C1284a.bpLine_background);
        int color2 = obtainStyledAttributes.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.numbers_text_color);
        inflate.findViewById(C1287d.time_display_background).setBackgroundColor(i);
        inflate.findViewById(C1287d.ok_cancel_buttons_layout).setBackgroundColor(i);
        inflate.findViewById(C1287d.time_display).setBackgroundColor(i);
        ((TextView) inflate.findViewById(C1287d.separator)).setTextColor(color2);
        ((TextView) inflate.findViewById(C1287d.ampm_label)).setTextColor(color2);
        this.at.setBackgroundColor(color);
        return inflate;
    }

    public void mo1260u() {
        super.mo1260u();
        this.al.m8499a();
    }

    public void mo1261v() {
        super.mo1261v();
        this.al.m8500b();
    }

    public void m8756R() {
        this.al.m8501c();
    }

    private void m8743b(int i) {
        if (i == 0) {
            this.ar.setText(this.aw);
            C1314d.m8597a(this.at, this.aw);
            this.as.setContentDescription(this.aw);
        } else if (i == 1) {
            this.ar.setText(this.ax);
            C1314d.m8597a(this.at, this.ax);
            this.as.setContentDescription(this.ax);
        } else {
            this.ar.setText(this.aF);
        }
    }

    public void mo353e(Bundle bundle) {
        if (this.at != null) {
            bundle.putInt("hour_of_day", this.at.getHours());
            bundle.putInt("minute", this.at.getMinutes());
            bundle.putBoolean("is_24_hour_view", this.aC);
            bundle.putInt("current_item_showing", this.at.getCurrentItemShowing());
            bundle.putBoolean("in_kb_mode", this.aH);
            if (this.aH) {
                bundle.putIntegerArrayList("typed_times", this.aI);
            }
            bundle.putInt("theme", this.aD);
        }
    }

    public void mo1276a(int i, int i2, boolean z) {
        if (i == 0) {
            m8736a(i2, false);
            CharSequence format = String.format("%d", new Object[]{Integer.valueOf(i2)});
            if (this.az && z) {
                m8737a(1, true, true, false);
                format = format + ". " + this.aP;
            } else {
                this.at.setContentDescription(this.aM + ": " + i2);
            }
            C1314d.m8597a(this.at, format);
        } else if (i == 1) {
            m8747c(i2);
            this.at.setContentDescription(this.aO + ": " + i2);
        } else if (i == 2) {
            m8743b(i2);
        } else if (i == 3) {
            if (!m8732T()) {
                this.aI.clear();
            }
            m8751f(true);
        }
    }

    private void m8736a(int i, boolean z) {
        String str;
        if (this.aC) {
            str = "%02d";
        } else {
            str = "%d";
            i %= 12;
            if (i == 0) {
                i = 12;
            }
        }
        CharSequence format = String.format(str, new Object[]{Integer.valueOf(i)});
        this.an.setText(format);
        this.ao.setText(format);
        if (z) {
            C1314d.m8597a(this.at, format);
        }
    }

    private void m8747c(int i) {
        if (i == 60) {
            i = 0;
        }
        CharSequence format = String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i)});
        C1314d.m8597a(this.at, format);
        this.ap.setText(format);
        this.aq.setText(format);
    }

    private void m8737a(int i, boolean z, boolean z2, boolean z3) {
        int hours;
        View view;
        this.at.m8711a(i, z);
        if (i == 0) {
            hours = this.at.getHours();
            if (!this.aC) {
                hours %= 12;
            }
            this.at.setContentDescription(this.aM + ": " + hours);
            if (z3) {
                C1314d.m8597a(this.at, this.aN);
            }
            view = this.an;
        } else {
            this.at.setContentDescription(this.aO + ": " + this.at.getMinutes());
            if (z3) {
                C1314d.m8597a(this.at, this.aP);
            }
            view = this.ap;
        }
        int i2 = i == 0 ? this.au : this.av;
        hours = i == 1 ? this.au : this.av;
        this.an.setTextColor(i2);
        this.ap.setTextColor(hours);
        C1260k a = C1314d.m8596a(view, 0.85f, 1.1f);
        if (z2) {
            a.m8300d(300);
        }
        a.mo1219a();
    }

    private boolean m8749d(int i) {
        if (i == 111 || i == 4) {
            m2694a();
            return true;
        }
        if (i == 61) {
            if (this.aH) {
                if (m8732T()) {
                    m8751f(true);
                }
                return true;
            }
        } else if (i == 66) {
            if (this.aH) {
                if (!m8732T()) {
                    return true;
                }
                m8751f(false);
            }
            if (this.ak != null) {
                this.ak.mo2217a(this, this.at.getHours(), this.at.getMinutes());
            }
            m2694a();
            return true;
        } else if (i == 67) {
            if (this.aH && !this.aI.isEmpty()) {
                String str;
                int U = m8733U();
                if (U == m8755h(0)) {
                    str = this.aw;
                } else if (U == m8755h(1)) {
                    str = this.ax;
                } else {
                    str = String.format("%d", new Object[]{Integer.valueOf(m8753g(U))});
                }
                C1314d.m8597a(this.at, String.format(this.aG, new Object[]{str}));
                m8754g(true);
            }
        } else if (i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || (!this.aC && (i == m8755h(0) || i == m8755h(1)))) {
            if (this.aH) {
                if (m8752f(i)) {
                    m8754g(false);
                }
                return true;
            } else if (this.at == null) {
                Log.e("TimePickerDialog", "Unable to initiate keyboard mode, TimePicker was null.");
                return true;
            } else {
                this.aI.clear();
                m8750e(i);
                return true;
            }
        }
        return false;
    }

    private void m8750e(int i) {
        if (!this.at.m8713a(false)) {
            return;
        }
        if (i == -1 || m8752f(i)) {
            this.aH = true;
            this.am.setEnabled(false);
            m8754g(false);
        }
    }

    private boolean m8752f(int i) {
        if (this.aC && this.aI.size() == 4) {
            return false;
        }
        if (!this.aC && m8732T()) {
            return false;
        }
        this.aI.add(Integer.valueOf(i));
        if (m8731S()) {
            int g = m8753g(i);
            C1314d.m8597a(this.at, String.format("%d", new Object[]{Integer.valueOf(g)}));
            if (m8732T()) {
                if (!this.aC && this.aI.size() <= 3) {
                    this.aI.add(this.aI.size() - 1, Integer.valueOf(7));
                    this.aI.add(this.aI.size() - 1, Integer.valueOf(7));
                }
                this.am.setEnabled(true);
            }
            return true;
        }
        m8733U();
        return false;
    }

    private boolean m8731S() {
        C1340b c1340b = this.aJ;
        Iterator it = this.aI.iterator();
        C1340b c1340b2 = c1340b;
        while (it.hasNext()) {
            c1340b = c1340b2.m8728b(((Integer) it.next()).intValue());
            if (c1340b == null) {
                return false;
            }
            c1340b2 = c1340b;
        }
        return true;
    }

    private boolean m8732T() {
        boolean z = false;
        if (this.aC) {
            int[] a = m8742a(null);
            if (a[0] < 0 || a[1] < 0 || a[1] >= 60) {
                return false;
            }
            return true;
        }
        if (this.aI.contains(Integer.valueOf(m8755h(0))) || this.aI.contains(Integer.valueOf(m8755h(1)))) {
            z = true;
        }
        return z;
    }

    private int m8733U() {
        int intValue = ((Integer) this.aI.remove(this.aI.size() - 1)).intValue();
        if (!m8732T()) {
            this.am.setEnabled(false);
        }
        return intValue;
    }

    private void m8751f(boolean z) {
        this.aH = false;
        if (!this.aI.isEmpty()) {
            int[] a = m8742a(null);
            this.at.m8710a(a[0], a[1]);
            if (!this.aC) {
                this.at.setAmOrPm(a[2]);
            }
            this.aI.clear();
        }
        if (z) {
            m8754g(false);
            this.at.m8713a(true);
        }
    }

    private void m8754g(boolean z) {
        int i = 0;
        if (z || !this.aI.isEmpty()) {
            CharSequence charSequence;
            CharSequence charSequence2;
            Boolean[] boolArr = new Boolean[]{Boolean.valueOf(false), Boolean.valueOf(false)};
            int[] a = m8742a(boolArr);
            String str = boolArr[0].booleanValue() ? "%02d" : "%2d";
            String str2 = boolArr[1].booleanValue() ? "%02d" : "%2d";
            if (a[0] == -1) {
                charSequence = this.aF;
            } else {
                charSequence = String.format(str, new Object[]{Integer.valueOf(a[0])}).replace(' ', this.aE);
            }
            if (a[1] == -1) {
                charSequence2 = this.aF;
            } else {
                charSequence2 = String.format(str2, new Object[]{Integer.valueOf(a[1])}).replace(' ', this.aE);
            }
            this.an.setText(charSequence);
            this.ao.setText(charSequence);
            this.an.setTextColor(this.av);
            this.ap.setText(charSequence2);
            this.aq.setText(charSequence2);
            this.ap.setTextColor(this.av);
            if (!this.aC) {
                m8743b(a[2]);
                return;
            }
            return;
        }
        int hours = this.at.getHours();
        int minutes = this.at.getMinutes();
        m8736a(hours, true);
        m8747c(minutes);
        if (!this.aC) {
            if (hours >= 12) {
                i = 1;
            }
            m8743b(i);
        }
        m8737a(this.at.getCurrentItemShowing(), true, true, true);
        this.am.setEnabled(true);
    }

    private int m8753g(int i) {
        switch (i) {
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 9;
            default:
                return -1;
        }
    }

    private int[] m8742a(Boolean[] boolArr) {
        int i;
        int i2;
        int intValue;
        if (this.aC || !m8732T()) {
            i = 1;
            i2 = -1;
        } else {
            intValue = ((Integer) this.aI.get(this.aI.size() - 1)).intValue();
            if (intValue == m8755h(0)) {
                intValue = 0;
            } else if (intValue == m8755h(1)) {
                boolean z = true;
            } else {
                intValue = -1;
            }
            i = 2;
            i2 = intValue;
        }
        int i3 = -1;
        int i4 = -1;
        for (int i5 = i; i5 <= this.aI.size(); i5++) {
            intValue = m8753g(((Integer) this.aI.get(this.aI.size() - i5)).intValue());
            if (i5 == i) {
                i4 = intValue;
            } else if (i5 == i + 1) {
                i4 += intValue * 10;
                if (boolArr != null && intValue == 0) {
                    boolArr[1] = Boolean.valueOf(true);
                }
            } else if (i5 == i + 2) {
                i3 = intValue;
            } else if (i5 == i + 3) {
                i3 += intValue * 10;
                if (boolArr != null && intValue == 0) {
                    boolArr[0] = Boolean.valueOf(true);
                }
            }
        }
        return new int[]{i3, i4, i2};
    }

    private int m8755h(int i) {
        if (this.aK == -1 || this.aL == -1) {
            KeyCharacterMap load = KeyCharacterMap.load(-1);
            int i2 = 0;
            while (i2 < Math.max(this.aw.length(), this.ax.length())) {
                if (this.aw.toLowerCase(Locale.getDefault()).charAt(i2) != this.ax.toLowerCase(Locale.getDefault()).charAt(i2)) {
                    KeyEvent[] events = load.getEvents(new char[]{this.aw.toLowerCase(Locale.getDefault()).charAt(i2), this.ax.toLowerCase(Locale.getDefault()).charAt(i2)});
                    if (events == null || events.length != 4) {
                        Log.e("TimePickerDialog", "Unable to find keycodes for AM and PM.");
                    } else {
                        this.aK = events[0].getKeyCode();
                        this.aL = events[2].getKeyCode();
                    }
                } else {
                    i2++;
                }
            }
        }
        if (i == 0) {
            return this.aK;
        }
        return i == 1 ? this.aL : -1;
    }

    private void m8734V() {
        this.aJ = new C1340b(this, new int[0]);
        if (this.aC) {
            C1340b c1340b = new C1340b(this, 7, 8, 9, 10, 11, 12);
            C1340b c1340b2 = new C1340b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            c1340b.m8726a(c1340b2);
            C1340b c1340b3 = new C1340b(this, 7, 8);
            this.aJ.m8726a(c1340b3);
            C1340b c1340b4 = new C1340b(this, 7, 8, 9, 10, 11, 12);
            c1340b3.m8726a(c1340b4);
            c1340b4.m8726a(c1340b);
            c1340b4.m8726a(new C1340b(this, 13, 14, 15, 16));
            c1340b4 = new C1340b(this, 13, 14, 15, 16);
            c1340b3.m8726a(c1340b4);
            c1340b4.m8726a(c1340b);
            c1340b3 = new C1340b(this, 9);
            this.aJ.m8726a(c1340b3);
            c1340b4 = new C1340b(this, 7, 8, 9, 10);
            c1340b3.m8726a(c1340b4);
            c1340b4.m8726a(c1340b);
            C1340b c1340b5 = new C1340b(this, 11, 12);
            c1340b3.m8726a(c1340b5);
            c1340b5.m8726a(c1340b2);
            c1340b5 = new C1340b(this, 10, 11, 12, 13, 14, 15, 16);
            this.aJ.m8726a(c1340b5);
            c1340b5.m8726a(c1340b);
            return;
        }
        c1340b = new C1340b(this, m8755h(0), m8755h(1));
        c1340b2 = new C1340b(this, 8);
        this.aJ.m8726a(c1340b2);
        c1340b2.m8726a(c1340b);
        c1340b3 = new C1340b(this, 7, 8, 9);
        c1340b2.m8726a(c1340b3);
        c1340b3.m8726a(c1340b);
        c1340b4 = new C1340b(this, 7, 8, 9, 10, 11, 12);
        c1340b3.m8726a(c1340b4);
        c1340b4.m8726a(c1340b);
        c1340b4 = new C1340b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        c1340b4.m8726a(c1340b4);
        c1340b4.m8726a(c1340b);
        c1340b4 = new C1340b(this, 13, 14, 15, 16);
        c1340b3.m8726a(c1340b4);
        c1340b4.m8726a(c1340b);
        c1340b3 = new C1340b(this, 10, 11, 12);
        c1340b2.m8726a(c1340b3);
        c1340b2 = new C1340b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        c1340b3.m8726a(c1340b2);
        c1340b2.m8726a(c1340b);
        c1340b2 = new C1340b(this, 9, 10, 11, 12, 13, 14, 15, 16);
        this.aJ.m8726a(c1340b2);
        c1340b2.m8726a(c1340b);
        c1340b3 = new C1340b(this, 7, 8, 9, 10, 11, 12);
        c1340b2.m8726a(c1340b3);
        c1340b2 = new C1340b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        c1340b3.m8726a(c1340b2);
        c1340b2.m8726a(c1340b);
    }
}
