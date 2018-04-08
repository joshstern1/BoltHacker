package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C0229e;
import android.support.v4.view.C0645j;
import android.support.v4.view.ao;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class aa extends bp<View> {
    private final Rect f1038a = new Rect();
    private final Rect f1039b = new Rect();
    private int f1040c = 0;
    private int f1041d;

    abstract View mo194a(List<View> list);

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo191a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View a = mo194a(coordinatorLayout.m1691d(view));
            if (a != null) {
                if (ao.m3955y(a) && !ao.m3955y(view)) {
                    ao.m3915a(view, true);
                    if (ao.m3955y(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (ao.m3895G(a)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.m1676a(view, i, i2, MeasureSpec.makeMeasureSpec(mo195b(a) + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    protected void mo192b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a = mo194a(coordinatorLayout.m1691d(view));
        if (a != null) {
            C0229e c0229e = (C0229e) view.getLayoutParams();
            Rect rect = this.f1038a;
            rect.set(coordinatorLayout.getPaddingLeft() + c0229e.leftMargin, a.getBottom() + c0229e.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0229e.rightMargin, ((coordinatorLayout.getHeight() + a.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0229e.bottomMargin);
            Rect rect2 = this.f1039b;
            C0645j.m4291a(m1558c(c0229e.f1080c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = m1566c(a);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f1040c = rect2.top - a.getBottom();
            return;
        }
        super.mo192b(coordinatorLayout, view, i);
        this.f1040c = 0;
    }

    float mo193a(View view) {
        return 1.0f;
    }

    final int m1566c(View view) {
        return this.f1041d == 0 ? 0 : ab.m1910a(Math.round(mo193a(view) * ((float) this.f1041d)), 0, this.f1041d);
    }

    private static int m1558c(int i) {
        return i == 0 ? 8388659 : i;
    }

    int mo195b(View view) {
        return view.getMeasuredHeight();
    }

    final int m1560a() {
        return this.f1040c;
    }

    public final void m1564b(int i) {
        this.f1041d = i;
    }
}
