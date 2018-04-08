package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.bo;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.C0778b;
import android.support.v7.view.menu.C0197k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0896a {
    private CharSequence f3064g;
    private CharSequence f3065h;
    private View f3066i;
    private View f3067j;
    private LinearLayout f3068k;
    private TextView f3069l;
    private TextView f3070m;
    private int f3071n;
    private int f3072o;
    private boolean f3073p;
    private int f3074q;

    public /* bridge */ /* synthetic */ bo mo888a(int i, long j) {
        return super.mo888a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        de a = de.m7066a(context, attributeSet, C0841k.ActionMode, i, 0);
        setBackgroundDrawable(a.m7069a(C0841k.ActionMode_background));
        this.f3071n = a.m7082g(C0841k.ActionMode_titleTextStyle, 0);
        this.f3072o = a.m7082g(C0841k.ActionMode_subtitleTextStyle, 0);
        this.e = a.m7080f(C0841k.ActionMode_height, 0);
        this.f3074q = a.m7082g(C0841k.ActionMode_closeItemLayout, C0838h.abc_action_mode_close_item_material);
        a.m7070a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m5871g();
            this.d.m5873i();
        }
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f3067j != null) {
            removeView(this.f3067j);
        }
        this.f3067j = view;
        if (!(view == null || this.f3068k == null)) {
            removeView(this.f3068k);
            this.f3068k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f3064g = charSequence;
        m5787e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f3065h = charSequence;
        m5787e();
    }

    public CharSequence getTitle() {
        return this.f3064g;
    }

    public CharSequence getSubtitle() {
        return this.f3065h;
    }

    private void m5787e() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.f3068k == null) {
            LayoutInflater.from(getContext()).inflate(C0838h.abc_action_bar_title_item, this);
            this.f3068k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f3069l = (TextView) this.f3068k.findViewById(C0836f.action_bar_title);
            this.f3070m = (TextView) this.f3068k.findViewById(C0836f.action_bar_subtitle);
            if (this.f3071n != 0) {
                this.f3069l.setTextAppearance(getContext(), this.f3071n);
            }
            if (this.f3072o != 0) {
                this.f3070m.setTextAppearance(getContext(), this.f3072o);
            }
        }
        this.f3069l.setText(this.f3064g);
        this.f3070m.setText(this.f3065h);
        Object obj2 = !TextUtils.isEmpty(this.f3064g) ? 1 : null;
        if (TextUtils.isEmpty(this.f3065h)) {
            obj = null;
        }
        TextView textView = this.f3070m;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f3068k;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f3068k.getParent() == null) {
            addView(this.f3068k);
        }
    }

    public void m5789a(C0778b c0778b) {
        if (this.f3066i == null) {
            this.f3066i = LayoutInflater.from(getContext()).inflate(this.f3074q, this, false);
            addView(this.f3066i);
        } else if (this.f3066i.getParent() == null) {
            addView(this.f3066i);
        }
        this.f3066i.findViewById(C0836f.action_mode_close_button).setOnClickListener(new C0981d(this, c0778b));
        C0197k c0197k = (C0197k) c0778b.mo758b();
        if (this.d != null) {
            this.d.m5872h();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.d.m5867c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0197k.m1295a(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo909a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public void m5791b() {
        if (this.f3066i == null) {
            m5792c();
        }
    }

    public void m5792c() {
        removeAllViews();
        this.f3067j = null;
        this.c = null;
    }

    public boolean mo889a() {
        if (this.d != null) {
            return this.d.m5870f();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int i5;
            int a;
            int size = MeasureSpec.getSize(i);
            if (this.e > 0) {
                i5 = this.e;
            } else {
                i5 = MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i6 = i5 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
            if (this.f3066i != null) {
                a = m5783a(this.f3066i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f3066i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m5783a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f3068k != null && this.f3067j == null) {
                if (this.f3073p) {
                    this.f3068k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f3068k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f3068k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m5783a(this.f3068k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f3067j != null) {
                int min;
                LayoutParams layoutParams = this.f3067j.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i6);
                } else {
                    min = i6;
                }
                this.f3067j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                i5 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= i5) {
                        paddingLeft = i5;
                    }
                    i4++;
                    i5 = paddingLeft;
                }
                setMeasuredDimension(size, i5);
                return;
            }
            setMeasuredDimension(size, i5);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = C0983do.m7164a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f3066i == null || this.f3066i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f3066i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0896a.m5780a(paddingRight, i5, a);
            i5 = C0896a.m5780a(m5784a(this.f3066i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f3068k == null || this.f3067j != null || this.f3068k.getVisibility() == 8)) {
            i5 += m5784a(this.f3068k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f3067j != null) {
            int a2 = m5784a(this.f3067j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m5784a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f3064g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f3073p) {
            requestLayout();
        }
        this.f3073p = z;
    }

    public boolean m5793d() {
        return this.f3073p;
    }
}
