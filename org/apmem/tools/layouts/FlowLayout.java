package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.IntToString;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apmem.tools.layouts.C3157c.C3156a;

public class FlowLayout extends ViewGroup {
    List<C3155b> f10370a = new ArrayList();
    private final C3154a f10371b;

    public static class C3153a extends MarginLayoutParams {
        @ExportedProperty(mapping = {@IntToString(from = 0, to = "NONE"), @IntToString(from = 48, to = "TOP"), @IntToString(from = 80, to = "BOTTOM"), @IntToString(from = 3, to = "LEFT"), @IntToString(from = 5, to = "RIGHT"), @IntToString(from = 16, to = "CENTER_VERTICAL"), @IntToString(from = 112, to = "FILL_VERTICAL"), @IntToString(from = 1, to = "CENTER_HORIZONTAL"), @IntToString(from = 7, to = "FILL_HORIZONTAL"), @IntToString(from = 17, to = "CENTER"), @IntToString(from = 119, to = "FILL")})
        private boolean f10360a = false;
        private int f10361b = 0;
        private float f10362c = -1.0f;
        private int f10363d;
        private int f10364e;
        private int f10365f;
        private int f10366g;
        private int f10367h;
        private int f10368i;
        private int f10369j;

        public C3153a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            m17674a(context, attributeSet);
        }

        public C3153a(int i, int i2) {
            super(i, i2);
        }

        public C3153a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean m17678a() {
            return this.f10361b != 0;
        }

        public boolean m17680b() {
            return this.f10362c >= 0.0f;
        }

        private void m17674a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3156a.FlowLayout_LayoutParams);
            try {
                this.f10360a = obtainStyledAttributes.getBoolean(C3156a.FlowLayout_LayoutParams_layout_newLine, false);
                this.f10361b = obtainStyledAttributes.getInt(C3156a.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.f10362c = obtainStyledAttributes.getFloat(C3156a.FlowLayout_LayoutParams_layout_weight, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        void m17677a(int i, int i2) {
            this.f10367h = i;
            this.f10368i = i2;
        }

        int m17681c() {
            return this.f10363d;
        }

        void m17676a(int i) {
            this.f10363d = i;
        }

        int m17683d() {
            return this.f10364e;
        }

        void m17679b(int i) {
            this.f10364e = i;
        }

        int m17685e() {
            return this.f10365f;
        }

        void m17682c(int i) {
            this.f10365f = i;
        }

        int m17686f() {
            return this.f10366g;
        }

        void m17684d(int i) {
            this.f10366g = i;
        }

        int m17687g() {
            if (this.f10369j == 0) {
                return this.leftMargin + this.rightMargin;
            }
            return this.topMargin + this.bottomMargin;
        }

        int m17688h() {
            if (this.f10369j == 0) {
                return this.topMargin + this.bottomMargin;
            }
            return this.leftMargin + this.rightMargin;
        }

        public int m17689i() {
            return this.f10361b;
        }

        public float m17690j() {
            return this.f10362c;
        }

        public boolean m17691k() {
            return this.f10360a;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m17703a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m17704a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m17705a(layoutParams);
    }

    public FlowLayout(Context context) {
        super(context);
        this.f10371b = new C3154a(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10371b = new C3154a(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10371b = new C3154a(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        C3155b c3155b;
        int childCount;
        int i3;
        int size = (MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int i4 = this.f10371b.m17707a() == 0 ? size : size2;
        if (this.f10371b.m17707a() != 0) {
            size2 = size;
        }
        if (this.f10371b.m17707a() != 0) {
            mode = mode2;
        }
        if (this.f10371b.m17707a() == 0) {
            this.f10370a.clear();
            c3155b = new C3155b(i4);
            this.f10370a.add(c3155b);
            childCount = getChildCount();
            i3 = 0;
        } else {
            this.f10370a.clear();
            c3155b = new C3155b(i4);
            this.f10370a.add(c3155b);
            childCount = getChildCount();
            i3 = 0;
        }
        while (i3 < childCount) {
            C3155b c3155b2;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                c3155b2 = c3155b;
            } else {
                C3153a c3153a = (C3153a) childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), c3153a.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), c3153a.height));
                c3153a.f10369j = this.f10371b.m17707a();
                if (this.f10371b.m17707a() == 0) {
                    c3153a.m17679b(childAt.getMeasuredWidth());
                    c3153a.m17682c(childAt.getMeasuredHeight());
                } else {
                    c3153a.m17679b(childAt.getMeasuredHeight());
                    c3153a.m17682c(childAt.getMeasuredWidth());
                }
                Object obj = (c3153a.m17691k() || !(mode == 0 || c3155b.m17723b(childAt))) ? 1 : null;
                if (obj != null) {
                    c3155b2 = new C3155b(i4);
                    if (this.f10371b.m17707a() == 1 && this.f10371b.m17716e() == 1) {
                        this.f10370a.add(0, c3155b2);
                    } else {
                        this.f10370a.add(c3155b2);
                    }
                } else {
                    c3155b2 = c3155b;
                }
                if (this.f10371b.m17707a() == 0 && this.f10371b.m17716e() == 1) {
                    c3155b2.m17719a(0, childAt);
                } else {
                    c3155b2.m17720a(childAt);
                }
            }
            i3++;
            c3155b = c3155b2;
        }
        m17696a(this.f10370a);
        int size3 = this.f10370a.size();
        childCount = 0;
        for (i3 = 0; i3 < size3; i3++) {
            childCount = Math.max(childCount, ((C3155b) this.f10370a.get(i3)).m17724c());
        }
        int b = c3155b.m17721b() + c3155b.m17717a();
        m17697a(this.f10370a, m17693a(mode, i4, childCount), m17693a(mode2, size2, b));
        for (i4 = 0; i4 < size3; i4++) {
            c3155b2 = (C3155b) this.f10370a.get(i4);
            m17701b(c3155b2);
            m17698a(c3155b2);
        }
        size = getPaddingLeft() + getPaddingRight();
        size2 = getPaddingTop() + getPaddingBottom();
        if (this.f10371b.m17707a() == 0) {
            i4 = size + childCount;
            size = size2 + b;
        } else {
            i4 = size + b;
            size = size2 + childCount;
        }
        setMeasuredDimension(resolveSize(i4, i), resolveSize(size, i2));
    }

    private int m17693a(int i, int i2, int i3) {
        switch (i) {
            case Integer.MIN_VALUE:
                return Math.min(i3, i2);
            case 1073741824:
                return i2;
            default:
                return i3;
        }
    }

    private void m17696a(List<C3155b> list) {
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            C3155b c3155b = (C3155b) list.get(i);
            c3155b.m17718a(i2);
            int b = i2 + c3155b.m17721b();
            List e = c3155b.m17728e();
            int size2 = e.size();
            int i3 = 0;
            for (i2 = 0; i2 < size2; i2++) {
                C3153a c3153a = (C3153a) ((View) e.get(i2)).getLayoutParams();
                c3153a.m17676a(i3);
                i3 += c3153a.m17687g() + c3153a.m17683d();
            }
            i++;
            i2 = b;
        }
    }

    private void m17698a(C3155b c3155b) {
        List e = c3155b.m17728e();
        int size = e.size();
        for (int i = 0; i < size; i++) {
            View view = (View) e.get(i);
            C3153a c3153a = (C3153a) view.getLayoutParams();
            if (this.f10371b.m17707a() == 0) {
                c3153a.m17677a((getPaddingLeft() + c3155b.m17726d()) + c3153a.m17681c(), (getPaddingTop() + c3155b.m17717a()) + c3153a.m17686f());
                view.measure(MeasureSpec.makeMeasureSpec(c3153a.m17683d(), 1073741824), MeasureSpec.makeMeasureSpec(c3153a.m17685e(), 1073741824));
            } else {
                c3153a.m17677a((getPaddingLeft() + c3155b.m17717a()) + c3153a.m17686f(), (getPaddingTop() + c3155b.m17726d()) + c3153a.m17681c());
                view.measure(MeasureSpec.makeMeasureSpec(c3153a.m17685e(), 1073741824), MeasureSpec.makeMeasureSpec(c3153a.m17683d(), 1073741824));
            }
        }
    }

    private void m17697a(List<C3155b> list, int i, int i2) {
        int size = list.size();
        if (size > 0) {
            int i3;
            C3155b c3155b = (C3155b) list.get(size - 1);
            int a = i2 - (c3155b.m17717a() + c3155b.m17721b());
            if (a < 0) {
                i3 = 0;
            } else {
                i3 = a;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                c3155b = (C3155b) list.get(i5);
                int a2 = m17694a(null);
                int round = Math.round((float) ((1 * i3) / size));
                int c = c3155b.m17724c();
                int b = c3155b.m17721b();
                Rect rect = new Rect();
                rect.top = i4;
                rect.left = 0;
                rect.right = i;
                rect.bottom = (b + round) + i4;
                Rect rect2 = new Rect();
                Gravity.apply(a2, c, b, rect, rect2);
                i4 += round;
                c3155b.m17722b(c3155b.m17726d() + rect2.left);
                c3155b.m17718a(c3155b.m17717a() + rect2.top);
                c3155b.m17727d(rect2.width());
                c3155b.m17725c(rect2.height());
            }
        }
    }

    private void m17701b(C3155b c3155b) {
        List e = c3155b.m17728e();
        int size = e.size();
        if (size > 0) {
            float f = 0.0f;
            int i = 0;
            while (i < size) {
                float b = f + m17699b((C3153a) ((View) e.get(i)).getLayoutParams());
                i++;
                f = b;
            }
            C3153a c3153a = (C3153a) ((View) e.get(size - 1)).getLayoutParams();
            int c = c3155b.m17724c() - (c3153a.m17681c() + (c3153a.m17683d() + c3153a.m17687g()));
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                c3153a = (C3153a) ((View) e.get(i2)).getLayoutParams();
                float b2 = m17699b(c3153a);
                int a = m17694a(c3153a);
                if (f == 0.0f) {
                    i = c / size;
                } else {
                    i = Math.round((b2 * ((float) c)) / f);
                }
                int d = c3153a.m17683d() + c3153a.m17687g();
                int e2 = c3153a.m17685e() + c3153a.m17688h();
                Rect rect = new Rect();
                rect.top = 0;
                rect.left = i3;
                rect.right = (d + i) + i3;
                rect.bottom = c3155b.m17721b();
                Rect rect2 = new Rect();
                Gravity.apply(a, d, e2, rect, rect2);
                i += i3;
                c3153a.m17676a(rect2.left + c3153a.m17681c());
                c3153a.m17684d(rect2.top);
                c3153a.m17679b(rect2.width() - c3153a.m17687g());
                c3153a.m17682c(rect2.height() - c3153a.m17688h());
                i2++;
                i3 = i;
            }
        }
    }

    private int m17694a(C3153a c3153a) {
        int i;
        int d = this.f10371b.m17715d();
        if (c3153a == null || !c3153a.m17678a()) {
            i = d;
        } else {
            i = c3153a.m17689i();
        }
        i = m17692a(i);
        d = m17692a(d);
        if ((i & 7) == 0) {
            i |= d & 7;
        }
        if ((i & 112) == 0) {
            i |= d & 112;
        }
        if ((i & 7) == 0) {
            i |= 3;
        }
        if ((i & 112) == 0) {
            return i | 48;
        }
        return i;
    }

    private int m17692a(int i) {
        int i2 = 3;
        if (this.f10371b.m17707a() == 1 && (i & 8388608) == 0) {
            i = ((((i & 7) >> 0) << 4) | 0) | (((i & 112) >> 4) << 0);
        }
        if (this.f10371b.m17716e() != 1 || (i & 8388608) == 0) {
            return i;
        }
        int i3;
        if ((i & 3) == 3) {
            i3 = 5;
        } else {
            i3 = 0;
        }
        i3 |= 0;
        if ((i & 5) != 5) {
            i2 = 0;
        }
        return i3 | i2;
    }

    private float m17699b(C3153a c3153a) {
        return c3153a.m17680b() ? c3153a.m17690j() : this.f10371b.m17713c();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C3153a c3153a = (C3153a) childAt.getLayoutParams();
            childAt.layout(c3153a.f10367h + c3153a.leftMargin, c3153a.f10368i + c3153a.topMargin, (c3153a.f10367h + c3153a.leftMargin) + childAt.getMeasuredWidth(), (c3153a.topMargin + c3153a.f10368i) + childAt.getMeasuredHeight());
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        m17695a(canvas, view);
        return drawChild;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C3153a;
    }

    protected C3153a m17703a() {
        return new C3153a(-2, -2);
    }

    public C3153a m17704a(AttributeSet attributeSet) {
        return new C3153a(getContext(), attributeSet);
    }

    protected C3153a m17705a(LayoutParams layoutParams) {
        return new C3153a(layoutParams);
    }

    private void m17695a(Canvas canvas, View view) {
        if (m17706b()) {
            float right;
            float height;
            Paint b = m17700b(-256);
            Paint b2 = m17700b(-65536);
            C3153a c3153a = (C3153a) view.getLayoutParams();
            if (c3153a.rightMargin > 0) {
                right = (float) view.getRight();
                height = (((float) view.getHeight()) / 2.0f) + ((float) view.getTop());
                canvas.drawLine(right, height, right + ((float) c3153a.rightMargin), height, b);
                canvas.drawLine((((float) c3153a.rightMargin) + right) - 4.0f, height - 4.0f, right + ((float) c3153a.rightMargin), height, b);
                canvas.drawLine((((float) c3153a.rightMargin) + right) - 4.0f, height + 4.0f, right + ((float) c3153a.rightMargin), height, b);
            }
            if (c3153a.leftMargin > 0) {
                right = (float) view.getLeft();
                height = (((float) view.getHeight()) / 2.0f) + ((float) view.getTop());
                canvas.drawLine(right, height, right - ((float) c3153a.leftMargin), height, b);
                canvas.drawLine((right - ((float) c3153a.leftMargin)) + 4.0f, height - 4.0f, right - ((float) c3153a.leftMargin), height, b);
                canvas.drawLine((right - ((float) c3153a.leftMargin)) + 4.0f, height + 4.0f, right - ((float) c3153a.leftMargin), height, b);
            }
            if (c3153a.bottomMargin > 0) {
                right = (((float) view.getWidth()) / 2.0f) + ((float) view.getLeft());
                height = (float) view.getBottom();
                canvas.drawLine(right, height, right, height + ((float) c3153a.bottomMargin), b);
                canvas.drawLine(right - 4.0f, (((float) c3153a.bottomMargin) + height) - 4.0f, right, height + ((float) c3153a.bottomMargin), b);
                canvas.drawLine(right + 4.0f, (((float) c3153a.bottomMargin) + height) - 4.0f, right, height + ((float) c3153a.bottomMargin), b);
            }
            if (c3153a.topMargin > 0) {
                right = (((float) view.getWidth()) / 2.0f) + ((float) view.getLeft());
                height = (float) view.getTop();
                canvas.drawLine(right, height, right, height - ((float) c3153a.topMargin), b);
                canvas.drawLine(right - 4.0f, (height - ((float) c3153a.topMargin)) + 4.0f, right, height - ((float) c3153a.topMargin), b);
                canvas.drawLine(right + 4.0f, (height - ((float) c3153a.topMargin)) + 4.0f, right, height - ((float) c3153a.topMargin), b);
            }
            if (!c3153a.m17691k()) {
                return;
            }
            float top;
            if (this.f10371b.m17707a() == 0) {
                right = (float) view.getLeft();
                top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                canvas.drawLine(right, top - 6.0f, right, top + 6.0f, b2);
                return;
            }
            top = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
            height = (float) view.getTop();
            canvas.drawLine(top - 6.0f, height, 6.0f + top, height, b2);
        }
    }

    private Paint m17700b(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    public int getOrientation() {
        return this.f10371b.m17707a();
    }

    public void setOrientation(int i) {
        this.f10371b.m17709a(i);
        requestLayout();
    }

    public boolean m17706b() {
        return this.f10371b.m17712b() || m17702c();
    }

    public void setDebugDraw(boolean z) {
        this.f10371b.m17710a(z);
        invalidate();
    }

    private boolean m17702c() {
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("debugDraw", (Class[]) null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this, new Object[]{null})).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public float getWeightDefault() {
        return this.f10371b.m17713c();
    }

    public void setWeightDefault(float f) {
        this.f10371b.m17708a(f);
        requestLayout();
    }

    public int getGravity() {
        return this.f10371b.m17715d();
    }

    public void setGravity(int i) {
        this.f10371b.m17711b(i);
        requestLayout();
    }

    public int getLayoutDirection() {
        if (this.f10371b == null) {
            return 0;
        }
        return this.f10371b.m17716e();
    }

    public void setLayoutDirection(int i) {
        this.f10371b.m17714c(i);
        requestLayout();
    }
}
