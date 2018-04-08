package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0192a.C0184b;
import android.support.design.C0192a.C0190h;
import android.support.design.C0192a.C0191i;
import android.support.design.internal.C0198b;
import android.support.design.internal.C0212c;
import android.support.design.internal.C0217g;
import android.support.v4.p017e.C0468d;
import android.support.v4.p021b.C0307a;
import android.support.v4.view.ao;
import android.support.v7.view.C0859g;
import android.support.v7.view.menu.C0882m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class NavigationView extends C0217g {
    private static final int[] f1135a = new int[]{16842912};
    private static final int[] f1136b = new int[]{-16842910};
    private final C0198b f1137c;
    private final C0212c f1138d;
    private C0234a f1139e;
    private int f1140f;
    private MenuInflater f1141g;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C0468d.m3057a(new ad());
        public Bundle f1134a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f1134a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f1134a);
        }
    }

    public interface C0234a {
        boolean m1726a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int resourceId;
        super(context, attributeSet, i);
        this.f1138d = new C0212c();
        be.m2015a(context);
        this.f1137c = new C0198b(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.NavigationView, i, C0190h.Widget_Design_NavigationView);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0191i.NavigationView_android_background));
        if (obtainStyledAttributes.hasValue(C0191i.NavigationView_elevation)) {
            ao.m3935f((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C0191i.NavigationView_elevation, 0));
        }
        ao.m3915a((View) this, obtainStyledAttributes.getBoolean(C0191i.NavigationView_android_fitsSystemWindows, false));
        this.f1140f = obtainStyledAttributes.getDimensionPixelSize(C0191i.NavigationView_android_maxWidth, 0);
        if (obtainStyledAttributes.hasValue(C0191i.NavigationView_itemIconTint)) {
            colorStateList = obtainStyledAttributes.getColorStateList(C0191i.NavigationView_itemIconTint);
        } else {
            colorStateList = m1728c(16842808);
        }
        if (obtainStyledAttributes.hasValue(C0191i.NavigationView_itemTextAppearance)) {
            resourceId = obtainStyledAttributes.getResourceId(C0191i.NavigationView_itemTextAppearance, 0);
            int i2 = 1;
        } else {
            resourceId = 0;
            boolean z = false;
        }
        ColorStateList colorStateList2 = null;
        if (obtainStyledAttributes.hasValue(C0191i.NavigationView_itemTextColor)) {
            colorStateList2 = obtainStyledAttributes.getColorStateList(C0191i.NavigationView_itemTextColor);
        }
        if (i2 == 0 && r5 == null) {
            colorStateList2 = m1728c(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(C0191i.NavigationView_itemBackground);
        this.f1137c.mo161a(new ac(this));
        this.f1138d.m1439a(1);
        this.f1138d.mo149a(context, this.f1137c);
        this.f1138d.m1441a(colorStateList);
        if (i2 != 0) {
            this.f1138d.m1458c(resourceId);
        }
        this.f1138d.m1454b(colorStateList2);
        this.f1138d.m1442a(drawable);
        this.f1137c.m1294a(this.f1138d);
        addView((View) this.f1138d.m1438a((ViewGroup) this));
        if (obtainStyledAttributes.hasValue(C0191i.NavigationView_menu)) {
            m1729a(obtainStyledAttributes.getResourceId(C0191i.NavigationView_menu, 0));
        }
        if (obtainStyledAttributes.hasValue(C0191i.NavigationView_headerLayout)) {
            m1731b(obtainStyledAttributes.getResourceId(C0191i.NavigationView_headerLayout, 0));
        }
        obtainStyledAttributes.recycle();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1134a = new Bundle();
        this.f1137c.m1291a(savedState.f1134a);
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1137c.m1303b(savedState.f1134a);
    }

    public void setNavigationItemSelectedListener(C0234a c0234a) {
        this.f1139e = c0234a;
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.f1140f), 1073741824);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.f1140f, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected void mo211a(Rect rect) {
        this.f1138d.m1460d(rect.top);
    }

    public void m1729a(int i) {
        this.f1138d.m1455b(true);
        getMenuInflater().inflate(i, this.f1137c);
        this.f1138d.m1455b(false);
        this.f1138d.mo153a(false);
    }

    public Menu getMenu() {
        return this.f1137c;
    }

    public View m1731b(int i) {
        return this.f1138d.m1453b(i);
    }

    public int getHeaderCount() {
        return this.f1138d.m1459d();
    }

    public ColorStateList getItemIconTintList() {
        return this.f1138d.m1461e();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f1138d.m1441a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f1138d.m1462f();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f1138d.m1454b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f1138d.m1463g();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(C0307a.m2325a(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.f1138d.m1442a(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f1137c.findItem(i);
        if (findItem != null) {
            this.f1138d.m1445a((C0882m) findItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.f1138d.m1458c(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.f1141g == null) {
            this.f1141g = new C0859g(getContext());
        }
        return this.f1141g;
    }

    private ColorStateList m1728c(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = getResources().getColorStateList(typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0184b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{f1136b, f1135a, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(f1136b, defaultColor), i2, defaultColor});
    }
}
