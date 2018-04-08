package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v7.p018d.p019a.C0254a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class bl extends ListView {
    private static final int[] f3687g = new int[]{0};
    final Rect f3688a;
    int f3689b;
    int f3690c;
    int f3691d;
    int f3692e;
    protected int f3693f;
    private Field f3694h;
    private C0970a f3695i;

    private static class C0970a extends C0254a {
        private boolean f3720a = true;

        public C0970a(Drawable drawable) {
            super(drawable);
        }

        void m6886a(boolean z) {
            this.f3720a = z;
        }

        public boolean setState(int[] iArr) {
            if (this.f3720a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f3720a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f3720a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f3720a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f3720a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public bl(Context context) {
        this(context, null);
    }

    public bl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public bl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3688a = new Rect();
        this.f3689b = 0;
        this.f3690c = 0;
        this.f3691d = 0;
        this.f3692e = 0;
        try {
            this.f3694h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f3694h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f3695i = drawable != null ? new C0970a(drawable) : null;
        super.setSelector(this.f3695i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f3689b = rect.left;
        this.f3690c = rect.top;
        this.f3691d = rect.right;
        this.f3692e = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m6872b();
    }

    protected void dispatchDraw(Canvas canvas) {
        m6870a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f3693f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void m6872b() {
        Drawable selector = getSelector();
        if (selector != null && m6874c()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean m6874c() {
        return mo996a() && isPressed();
    }

    protected boolean mo996a() {
        return false;
    }

    protected void m6870a(Canvas canvas) {
        if (!this.f3688a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f3688a);
                selector.draw(canvas);
            }
        }
    }

    protected void m6869a(int i, View view, float f, float f2) {
        m6868a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0441a.m2989a(selector, f, f2);
        }
    }

    protected void m6868a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m6873b(i, view);
        if (z2) {
            Rect rect = this.f3688a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0441a.m2989a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m6873b(int i, View view) {
        Rect rect = this.f3688a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f3689b;
        rect.top -= this.f3690c;
        rect.right += this.f3691d;
        rect.bottom += this.f3692e;
        try {
            boolean z = this.f3694h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f3694h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int m6867a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i8 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop < i4) {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f3695i != null) {
            this.f3695i.m6886a(z);
        }
    }
}
