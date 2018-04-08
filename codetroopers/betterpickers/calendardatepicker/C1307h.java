package com.codetroopers.betterpickers.calendardatepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ao;
import android.support.v4.view.p025a.C0547e;
import android.support.v4.widget.C0748t;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1285b;
import com.codetroopers.betterpickers.C1292c.C1289f;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.C1314d;
import com.codetroopers.betterpickers.calendardatepicker.C1305g.C1303a;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public abstract class C1307h extends View {
    protected static int f4774a = 32;
    protected static int f4775b = 10;
    protected static int f4776c = 1;
    protected static int f4777d;
    protected static int f4778e;
    protected static int f4779f;
    protected static int f4780g;
    protected static int f4781h;
    protected static float f4782i = 0.0f;
    protected int f4783A = 7;
    protected int f4784B = this.f4783A;
    protected int f4785C = -1;
    protected int f4786D = -1;
    protected int f4787E = -1;
    protected int f4788F = -1;
    protected int f4789G;
    protected int f4790H;
    protected int f4791I;
    protected int f4792J;
    protected int f4793K;
    private String f4794L;
    private String f4795M;
    private final Formatter f4796N;
    private final StringBuilder f4797O;
    private final Calendar f4798P;
    private final Calendar f4799Q;
    private final C1306a f4800R;
    private int f4801S = 6;
    private C1304b f4802T;
    private boolean f4803U;
    private int f4804V = 0;
    protected int f4805j = 0;
    protected Paint f4806k;
    protected Paint f4807l;
    protected Paint f4808m;
    protected Paint f4809n;
    protected Paint f4810o;
    protected int f4811p = -1;
    protected int f4812q = -1;
    protected int f4813r = -1;
    protected int f4814s;
    protected int f4815t;
    protected int f4816u;
    protected int f4817v = f4774a;
    protected boolean f4818w = false;
    protected int f4819x = -1;
    protected int f4820y = -1;
    protected int f4821z = 1;

    public interface C1304b {
        void mo1263a(C1307h c1307h, C1303a c1303a);
    }

    private class C1306a extends C0748t {
        final /* synthetic */ C1307h f4771a;
        private final Rect f4772c = new Rect();
        private final Calendar f4773d = Calendar.getInstance();

        public C1306a(C1307h c1307h, View view) {
            this.f4771a = c1307h;
            super(view);
        }

        public void mo1268c(int i) {
            mo716a(this.f4771a).mo715a(i, 64, null);
        }

        public void mo1269e() {
            int d = m4955d();
            if (d != Integer.MIN_VALUE) {
                mo716a(this.f4771a).mo715a(d, 128, null);
            }
        }

        protected void mo1266a(List<Integer> list) {
            for (int i = 1; i <= this.f4771a.f4784B; i++) {
                list.add(Integer.valueOf(i));
            }
        }

        protected void mo1265a(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(m8558d(i));
        }

        protected void mo1264a(int i, C0547e c0547e) {
            m8557a(i, this.f4772c);
            c0547e.m3455d(m8558d(i));
            c0547e.m3440b(this.f4772c);
            c0547e.m3434a(16);
            if (i == this.f4771a.f4819x) {
                c0547e.m3459e(true);
            }
        }

        protected boolean mo1267a(int i, int i2, Bundle bundle) {
            switch (i2) {
                case 16:
                    this.f4771a.m8569b(i);
                    return true;
                default:
                    return false;
            }
        }

        private void m8557a(int i, Rect rect) {
            int i2 = this.f4771a.f4805j;
            int i3 = C1307h.f4780g;
            int i4 = this.f4771a.f4817v;
            int i5 = (this.f4771a.f4816u - (this.f4771a.f4805j * 2)) / this.f4771a.f4783A;
            int a = (i - 1) + this.f4771a.m8573e();
            i2 += (a % this.f4771a.f4783A) * i5;
            i3 += (a / this.f4771a.f4783A) * i4;
            rect.set(i2, i3, i5 + i2, i4 + i3);
        }

        private CharSequence m8558d(int i) {
            this.f4773d.set(this.f4771a.f4815t, this.f4771a.f4814s, i);
            CharSequence format = DateFormat.format("dd MMMM yyyy", this.f4773d.getTimeInMillis());
            if (i != this.f4771a.f4819x) {
                return format;
            }
            return this.f4771a.getContext().getString(C1289f.item_is_selected, new Object[]{format});
        }
    }

    public abstract void mo1272a(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z);

    public C1307h(Context context) {
        super(context);
        Resources resources = context.getResources();
        this.f4799Q = Calendar.getInstance();
        this.f4798P = Calendar.getInstance();
        this.f4794L = resources.getString(C1289f.day_of_week_label_typeface);
        this.f4795M = resources.getString(C1289f.sans_serif);
        this.f4789G = resources.getColor(C1284a.date_picker_text_normal);
        this.f4790H = resources.getColor(C1284a.date_picker_text_disabled);
        this.f4791I = resources.getColor(C1284a.bpBlue);
        this.f4792J = resources.getColor(C1284a.date_picker_text_normal);
        this.f4793K = resources.getColor(C1284a.circle_background);
        this.f4797O = new StringBuilder(50);
        this.f4796N = new Formatter(this.f4797O, Locale.getDefault());
        f4777d = resources.getDimensionPixelSize(C1285b.day_number_size);
        f4778e = resources.getDimensionPixelSize(C1285b.month_label_size);
        f4779f = resources.getDimensionPixelSize(C1285b.month_day_label_text_size);
        f4780g = resources.getDimensionPixelOffset(C1285b.month_list_item_header_height);
        f4781h = resources.getDimensionPixelSize(C1285b.day_number_select_circle_radius);
        this.f4817v = (resources.getDimensionPixelOffset(C1285b.date_picker_view_animator_height) - f4780g) / 6;
        this.f4800R = new C1306a(this, this);
        ao.m3911a((View) this, this.f4800R);
        ao.m3925c((View) this, 1);
        this.f4803U = true;
        m8575a();
    }

    public void setTheme(TypedArray typedArray) {
        this.f4793K = typedArray.getColor(C1291h.BetterPickersDialog_bpMainColor2, C1284a.circle_background);
        this.f4791I = typedArray.getColor(C1291h.BetterPickersDialog_bpAccentColor, C1284a.bpBlue);
        this.f4790H = typedArray.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.ampm_text_color);
        this.f4792J = typedArray.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.ampm_text_color);
        m8575a();
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        if (!this.f4803U && VERSION.SDK_INT >= 14) {
            super.setAccessibilityDelegate(accessibilityDelegate);
        }
    }

    public void setOnDayClickListener(C1304b c1304b) {
        this.f4802T = c1304b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                int a = m8574a(motionEvent.getX(), motionEvent.getY());
                if (a >= 0) {
                    m8569b(a);
                    break;
                }
                break;
        }
        return true;
    }

    protected void m8575a() {
        this.f4807l = new Paint();
        this.f4807l.setFakeBoldText(true);
        this.f4807l.setAntiAlias(true);
        this.f4807l.setTextSize((float) f4778e);
        this.f4807l.setTypeface(Typeface.create(this.f4795M, 1));
        this.f4807l.setColor(this.f4789G);
        this.f4807l.setTextAlign(Align.CENTER);
        this.f4807l.setStyle(Style.FILL);
        this.f4808m = new Paint();
        this.f4808m.setFakeBoldText(true);
        this.f4808m.setAntiAlias(true);
        this.f4808m.setColor(this.f4793K);
        this.f4808m.setTextAlign(Align.CENTER);
        this.f4808m.setStyle(Style.FILL);
        this.f4809n = new Paint();
        this.f4809n.setFakeBoldText(true);
        this.f4809n.setAntiAlias(true);
        this.f4809n.setColor(this.f4791I);
        this.f4809n.setTextAlign(Align.CENTER);
        this.f4809n.setStyle(Style.FILL);
        this.f4809n.setAlpha(60);
        this.f4810o = new Paint();
        this.f4810o.setAntiAlias(true);
        this.f4810o.setTextSize((float) f4779f);
        this.f4810o.setColor(this.f4789G);
        this.f4810o.setTypeface(Typeface.create(this.f4794L, 0));
        this.f4810o.setStyle(Style.FILL);
        this.f4810o.setTextAlign(Align.CENTER);
        this.f4810o.setFakeBoldText(true);
        this.f4806k = new Paint();
        this.f4806k.setAntiAlias(true);
        this.f4806k.setTextSize((float) f4777d);
        this.f4806k.setStyle(Style.FILL);
        this.f4806k.setTextAlign(Align.CENTER);
        this.f4806k.setFakeBoldText(false);
    }

    protected void onDraw(Canvas canvas) {
        m8570b(canvas);
        m8571c(canvas);
        m8576a(canvas);
    }

    public void setMonthParams(HashMap<String, Integer> hashMap) {
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.f4817v = ((Integer) hashMap.get("height")).intValue();
                if (this.f4817v < f4775b) {
                    this.f4817v = f4775b;
                }
            }
            if (hashMap.containsKey("selected_day")) {
                this.f4819x = ((Integer) hashMap.get("selected_day")).intValue();
            }
            if (hashMap.containsKey("range_min")) {
                this.f4787E = ((Integer) hashMap.get("range_min")).intValue();
            }
            if (hashMap.containsKey("range_max")) {
                this.f4788F = ((Integer) hashMap.get("range_max")).intValue();
            }
            this.f4814s = ((Integer) hashMap.get("month")).intValue();
            this.f4815t = ((Integer) hashMap.get("year")).intValue();
            Time time = new Time(Time.getCurrentTimezone());
            time.setToNow();
            this.f4818w = false;
            this.f4820y = -1;
            this.f4798P.set(2, this.f4814s);
            this.f4798P.set(1, this.f4815t);
            this.f4798P.set(5, 1);
            this.f4804V = this.f4798P.get(7);
            if (hashMap.containsKey("week_start")) {
                this.f4821z = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.f4821z = this.f4798P.getFirstDayOfWeek();
            }
            this.f4784B = C1314d.m8595a(this.f4814s, this.f4815t);
            for (int i = 0; i < this.f4784B; i++) {
                int i2 = i + 1;
                if (m8568a(i2, time)) {
                    this.f4818w = true;
                    this.f4820y = i2;
                }
            }
            this.f4801S = m8572d();
            this.f4800R.m4954c();
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }

    public void m8579b() {
        this.f4801S = 6;
        requestLayout();
    }

    private int m8572d() {
        int e = m8573e();
        return ((e + this.f4784B) % this.f4783A > 0 ? 1 : 0) + ((this.f4784B + e) / this.f4783A);
    }

    private boolean m8568a(int i, Time time) {
        return this.f4815t == time.year && this.f4814s == time.month && i == time.monthDay;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), (this.f4817v * this.f4801S) + f4780g);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f4816u = i;
        this.f4800R.m4954c();
    }

    private String getMonthAndYearString() {
        this.f4797O.setLength(0);
        long timeInMillis = this.f4798P.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), this.f4796N, timeInMillis, timeInMillis, 52, Time.getCurrentTimezone()).toString();
    }

    private void m8570b(Canvas canvas) {
        canvas.drawText(getMonthAndYearString(), (float) ((this.f4816u + (this.f4805j * 2)) / 2), (float) (((f4780g - f4779f) / 2) + (f4778e / 3)), this.f4807l);
    }

    private void m8571c(Canvas canvas) {
        int i = f4780g - (f4779f / 2);
        int i2 = (this.f4816u - (this.f4805j * 2)) / (this.f4783A * 2);
        for (int i3 = 0; i3 < this.f4783A; i3++) {
            int i4 = (((i3 * 2) + 1) * i2) + this.f4805j;
            this.f4799Q.set(7, (this.f4821z + i3) % this.f4783A);
            canvas.drawText(this.f4799Q.getDisplayName(7, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()), (float) i4, (float) i, this.f4810o);
        }
    }

    protected void m8576a(Canvas canvas) {
        int i = (((this.f4817v + f4777d) / 2) - f4776c) + f4780g;
        int i2 = (this.f4816u - (this.f4805j * 2)) / (this.f4783A * 2);
        int i3 = 1;
        int e = m8573e();
        while (i3 <= this.f4784B) {
            int i4 = (((e * 2) + 1) * i2) + this.f4805j;
            int i5 = i - (((this.f4817v + f4777d) / 2) - f4776c);
            Canvas canvas2 = canvas;
            mo1272a(canvas2, this.f4815t, this.f4814s, i3, i4, i, i4 - i2, i4 + i2, i5, i5 + this.f4817v, m8567a(i3));
            int i6 = e + 1;
            if (i6 == this.f4783A) {
                i6 = 0;
                i += this.f4817v;
            }
            i3++;
            e = i6;
        }
    }

    private boolean m8567a(int i) {
        return (this.f4788F < 0 || i <= this.f4788F) && (this.f4787E < 0 || i >= this.f4787E);
    }

    private int m8573e() {
        return (this.f4804V < this.f4821z ? this.f4804V + this.f4783A : this.f4804V) - this.f4821z;
    }

    public int m8574a(float f, float f2) {
        int i = this.f4805j;
        if (f < ((float) i) || f > ((float) (this.f4816u - this.f4805j))) {
            return -1;
        }
        i = ((((int) (((f - ((float) i)) * ((float) this.f4783A)) / ((float) ((this.f4816u - i) - this.f4805j)))) - m8573e()) + 1) + ((((int) (f2 - ((float) f4780g))) / this.f4817v) * this.f4783A);
        if (i < 1 || i > this.f4784B) {
            return -1;
        }
        return i;
    }

    private void m8569b(int i) {
        if (this.f4802T != null) {
            this.f4802T.mo1263a(this, new C1303a(this.f4815t, this.f4814s, i));
        }
        this.f4800R.m4949a(i, 1);
    }

    public C1303a getAccessibilityFocus() {
        int d = this.f4800R.m4955d();
        if (d >= 0) {
            return new C1303a(this.f4815t, this.f4814s, d);
        }
        return null;
    }

    public void m8580c() {
        this.f4800R.mo1269e();
    }

    public boolean m8578a(C1303a c1303a) {
        if (c1303a.f4762a != this.f4815t || c1303a.f4763b != this.f4814s || c1303a.f4764c > this.f4784B) {
            return false;
        }
        this.f4800R.mo1268c(c1303a.f4764c);
        return true;
    }
}
