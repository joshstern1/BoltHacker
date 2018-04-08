package com.codetroopers.betterpickers.calendardatepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.codetroopers.betterpickers.C1292c.C1284a;
import com.codetroopers.betterpickers.C1292c.C1285b;
import com.codetroopers.betterpickers.C1292c.C1288e;
import com.codetroopers.betterpickers.C1292c.C1291h;
import com.codetroopers.betterpickers.calendardatepicker.C1297b.C1294a;
import java.util.ArrayList;
import java.util.List;

public class C1312l extends ListView implements OnItemClickListener, C1294a {
    private final C1293a f4823a;
    private C1311a f4824b;
    private int f4825c;
    private int f4826d;
    private TextViewWithCircularIndicator f4827e;
    private int f4828f = C1284a.ampm_text_color;
    private int f4829g = C1284a.bpBlue;
    private int f4830h = C1284a.circle_background;

    private class C1311a extends ArrayAdapter<String> {
        final /* synthetic */ C1312l f4822a;

        public C1311a(C1312l c1312l, Context context, int i, List<String> list) {
            this.f4822a = c1312l;
            super(context, i, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) super.getView(i, view, viewGroup);
            textViewWithCircularIndicator.requestLayout();
            int a = this.f4822a.m8584a((TextView) textViewWithCircularIndicator);
            textViewWithCircularIndicator.setBackgroundColor(this.f4822a.f4830h);
            textViewWithCircularIndicator.setCircleColor(this.f4822a.f4829g);
            textViewWithCircularIndicator.setTextColor(this.f4822a.f4828f);
            boolean z = this.f4822a.f4823a.c_().f4762a == a;
            textViewWithCircularIndicator.m8503a(z);
            if (z) {
                this.f4822a.f4827e = textViewWithCircularIndicator;
            }
            return textViewWithCircularIndicator;
        }
    }

    public void setTheme(TypedArray typedArray) {
        this.f4830h = typedArray.getColor(C1291h.BetterPickersDialog_bpMainColor2, C1284a.circle_background);
        this.f4829g = typedArray.getColor(C1291h.BetterPickersDialog_bpAccentColor, C1284a.bpBlue);
        this.f4828f = typedArray.getColor(C1291h.BetterPickersDialog_bpMainTextColor, C1284a.ampm_text_color);
    }

    public C1312l(Context context, C1293a c1293a) {
        super(context);
        this.f4823a = c1293a;
        this.f4823a.mo1252a(this);
        setLayoutParams(new LayoutParams(-1, -2));
        Resources resources = context.getResources();
        this.f4825c = resources.getDimensionPixelOffset(C1285b.date_picker_view_animator_height);
        this.f4826d = resources.getDimensionPixelOffset(C1285b.year_label_height);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.f4826d / 3);
        m8588a(context);
        setOnItemClickListener(this);
        setSelector(new StateListDrawable());
        setDividerHeight(0);
        mo1262a();
    }

    private void m8588a(Context context) {
        List arrayList = new ArrayList();
        for (int i = this.f4823a.mo1254c().f4762a; i <= this.f4823a.mo1256d().f4762a; i++) {
            arrayList.add(String.format("%d", new Object[]{Integer.valueOf(i)}));
        }
        this.f4824b = new C1311a(this, context, C1288e.calendar_year_label_text_view, arrayList);
        setAdapter(this.f4824b);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f4823a.e_();
        TextView textView = (TextViewWithCircularIndicator) view;
        if (textView != null) {
            if (textView != this.f4827e) {
                if (this.f4827e != null) {
                    this.f4827e.m8503a(false);
                    this.f4827e.requestLayout();
                }
                textView.m8503a(true);
                textView.requestLayout();
                this.f4827e = textView;
            }
            this.f4823a.a_(m8584a(textView));
            this.f4824b.notifyDataSetChanged();
        }
    }

    private int m8584a(TextView textView) {
        return Integer.valueOf(textView.getText().toString()).intValue();
    }

    public void m8593a(int i) {
        m8594a(i, (this.f4825c / 2) - (this.f4826d / 2));
    }

    public void m8594a(int i, int i2) {
        post(new C1313m(this, i, i2));
    }

    public int getFirstPositionOffset() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public void mo1262a() {
        this.f4824b.notifyDataSetChanged();
        m8593a(this.f4823a.c_().f4762a - this.f4823a.mo1254c().f4762a);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4096) {
            accessibilityEvent.setFromIndex(0);
            accessibilityEvent.setToIndex(0);
        }
    }
}
