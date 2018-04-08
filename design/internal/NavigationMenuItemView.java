package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0192a.C0184b;
import android.support.design.C0192a.C0186d;
import android.support.design.C0192a.C0187e;
import android.support.design.C0192a.C0188f;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.widget.ax;
import android.support.v7.view.menu.C0195u.C0194a;
import android.support.v7.view.menu.C0882m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C0193a implements C0194a {
    private static final int[] f887c = new int[]{16842912};
    private final int f888d;
    private final CheckedTextView f889e;
    private FrameLayout f890f;
    private C0882m f891g;
    private ColorStateList f892h;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0188f.design_navigation_menu_item, this, true);
        this.f888d = context.getResources().getDimensionPixelSize(C0186d.design_navigation_icon_size);
        this.f889e = (CheckedTextView) findViewById(C0187e.design_menu_item_text);
        this.f889e.setDuplicateParentStateEnabled(true);
    }

    public void mo130a(C0882m c0882m, int i) {
        this.f891g = c0882m;
        setVisibility(c0882m.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m1132c());
        }
        setCheckable(c0882m.isCheckable());
        setChecked(c0882m.isChecked());
        setEnabled(c0882m.isEnabled());
        setTitle(c0882m.getTitle());
        setIcon(c0882m.getIcon());
        setActionView(c0882m.getActionView());
    }

    public void m1133a() {
        if (this.f890f != null) {
            this.f890f.removeAllViews();
        }
        this.f889e.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (this.f890f == null) {
            this.f890f = (FrameLayout) ((ViewStub) findViewById(C0187e.design_menu_item_action_area_stub)).inflate();
        }
        this.f890f.removeAllViews();
        if (view != null) {
            this.f890f.addView(view);
        }
    }

    private StateListDrawable m1132c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0184b.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f887c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public C0882m getItemData() {
        return this.f891g;
    }

    public void setTitle(CharSequence charSequence) {
        this.f889e.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f889e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C0441a.m3002f(drawable).mutate();
            drawable.setBounds(0, 0, this.f888d, this.f888d);
            C0441a.m2992a(drawable, this.f892h);
        }
        ax.m4798a(this.f889e, drawable, null, null, null);
    }

    public boolean mo131b() {
        return false;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f891g != null && this.f891g.isCheckable() && this.f891g.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f887c);
        }
        return onCreateDrawableState;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f892h = colorStateList;
        if (this.f891g != null) {
            setIcon(this.f891g.getIcon());
        }
    }

    public void m1134a(Context context, int i) {
        this.f889e.setTextAppearance(context, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f889e.setTextColor(colorStateList);
    }
}
