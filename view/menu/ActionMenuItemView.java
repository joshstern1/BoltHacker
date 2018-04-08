package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.p021b.p022a.C0410a;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.menu.C0195u.C0194a;
import android.support.v7.view.menu.C0197k.C0865b;
import android.support.v7.widget.ActionMenuView.C0864a;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.bc;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements C0194a, C0864a, OnClickListener, OnLongClickListener {
    private C0882m f2864a;
    private CharSequence f2865b;
    private Drawable f2866c;
    private C0865b f2867d;
    private bc f2868e;
    private C0863b f2869f;
    private boolean f2870g;
    private boolean f2871h;
    private int f2872i;
    private int f2873j;
    private int f2874k;

    private class C0862a extends bc {
        final /* synthetic */ ActionMenuItemView f2860a;

        public C0862a(ActionMenuItemView actionMenuItemView) {
            this.f2860a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public C0872x mo844a() {
            if (this.f2860a.f2869f != null) {
                return this.f2860a.f2869f.mo908a();
            }
            return null;
        }

        protected boolean mo845b() {
            if (this.f2860a.f2867d == null || !this.f2860a.f2867d.mo848a(this.f2860a.f2864a)) {
                return false;
            }
            C0872x a = mo844a();
            if (a == null || !a.mo870f()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class C0863b {
        public abstract C0872x mo908a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f2870g = m5566e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0841k.ActionMenuItemView, i, 0);
        this.f2872i = obtainStyledAttributes.getDimensionPixelSize(C0841k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f2874k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f2873j = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f2870g = m5566e();
        m5567f();
    }

    private boolean m5566e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int b = C0410a.m2891b(getResources());
        return b >= 480 || ((b >= 640 && C0410a.m2890a(getResources()) >= 480) || configuration.orientation == 2);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f2873j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C0882m getItemData() {
        return this.f2864a;
    }

    public void mo130a(C0882m c0882m, int i) {
        this.f2864a = c0882m;
        setIcon(c0882m.getIcon());
        setTitle(c0882m.m5700a((C0194a) this));
        setId(c0882m.getItemId());
        setVisibility(c0882m.isVisible() ? 0 : 8);
        setEnabled(c0882m.isEnabled());
        if (c0882m.hasSubMenu() && this.f2868e == null) {
            this.f2868e = new C0862a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2864a.hasSubMenu() && this.f2868e != null && this.f2868e.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.f2867d != null) {
            this.f2867d.mo848a(this.f2864a);
        }
    }

    public void setItemInvoker(C0865b c0865b) {
        this.f2867d = c0865b;
    }

    public void setPopupCallback(C0863b c0863b) {
        this.f2869f = c0863b;
    }

    public boolean mo131b() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f2871h != z) {
            this.f2871h = z;
            if (this.f2864a != null) {
                this.f2864a.m5715h();
            }
        }
    }

    private void m5567f() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f2865b) ? 1 : 0;
        if (this.f2866c == null || (this.f2864a.m5720m() && (this.f2870g || this.f2871h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f2865b : null);
    }

    public void setIcon(Drawable drawable) {
        this.f2866c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f2874k) {
                f = ((float) this.f2874k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f2874k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f2874k) {
                f = ((float) this.f2874k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f2874k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m5567f();
    }

    public boolean m5569a() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f2865b = charSequence;
        setContentDescription(this.f2865b);
        m5567f();
    }

    public boolean mo846c() {
        return m5569a() && this.f2864a.getIcon() == null;
    }

    public boolean mo847d() {
        return m5569a();
    }

    public boolean onLongClick(View view) {
        if (m5569a()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (ao.m3938h(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f2864a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean a = m5569a();
        if (a && this.f2873j >= 0) {
            super.setPadding(this.f2873j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f2872i) : this.f2872i;
        if (mode != 1073741824 && this.f2872i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!a && this.f2866c != null) {
            super.setPadding((getMeasuredWidth() - this.f2866c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
