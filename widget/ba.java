package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.C0684z;
import android.support.v4.view.bo;
import android.support.v4.widget.C0754x;
import android.support.v7.p028b.C0842a.C0831a;
import android.view.MotionEvent;
import android.view.View;

class ba extends bl {
    private boolean f3696g;
    private boolean f3697h;
    private boolean f3698i;
    private bo f3699j;
    private C0754x f3700k;

    public ba(Context context, boolean z) {
        super(context, null, C0831a.dropDownListViewStyle);
        this.f3697h = z;
        setCacheColorHint(0);
    }

    public boolean mo1002a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = C0684z.m4397a(motionEvent);
        switch (a) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m6876a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    m6875a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            m6877d();
        }
        if (z2) {
            if (this.f3700k == null) {
                this.f3700k = new C0754x(this);
            }
            this.f3700k.m4617a(true);
            this.f3700k.onTouch(this, motionEvent);
        } else if (this.f3700k != null) {
            this.f3700k.m4617a(false);
        }
        return z2;
    }

    private void m6875a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.f3696g = z;
    }

    private void m6877d() {
        this.f3698i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f3699j != null) {
            this.f3699j.m4196b();
            this.f3699j = null;
        }
    }

    private void m6876a(View view, int i, float f, float f2) {
        this.f3698i = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1) {
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m6869a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    protected boolean mo996a() {
        return this.f3698i || super.mo996a();
    }

    public boolean isInTouchMode() {
        return (this.f3697h && this.f3696g) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.f3697h || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f3697h || super.isFocused();
    }

    public boolean hasFocus() {
        return this.f3697h || super.hasFocus();
    }
}
