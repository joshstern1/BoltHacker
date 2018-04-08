package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p015d.p016a.C0462b;
import android.support.v4.p021b.C0307a;
import android.support.v4.view.C0641i;
import android.support.v4.view.C0675w.C0674e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class C0866a implements C0462b {
    private final int f2893a;
    private final int f2894b;
    private final int f2895c;
    private final int f2896d;
    private CharSequence f2897e;
    private CharSequence f2898f;
    private Intent f2899g;
    private char f2900h;
    private char f2901i;
    private Drawable f2902j;
    private int f2903k = 0;
    private Context f2904l;
    private OnMenuItemClickListener f2905m;
    private int f2906n = 16;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m5582a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m5585a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m5587b(i);
    }

    public C0866a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f2904l = context;
        this.f2893a = i2;
        this.f2894b = i;
        this.f2895c = i3;
        this.f2896d = i4;
        this.f2897e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f2901i;
    }

    public int getGroupId() {
        return this.f2894b;
    }

    public Drawable getIcon() {
        return this.f2902j;
    }

    public Intent getIntent() {
        return this.f2899g;
    }

    public int getItemId() {
        return this.f2893a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f2900h;
    }

    public int getOrder() {
        return this.f2896d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f2897e;
    }

    public CharSequence getTitleCondensed() {
        return this.f2898f != null ? this.f2898f : this.f2897e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f2906n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f2906n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f2906n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f2906n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f2901i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f2906n = (z ? 1 : 0) | (this.f2906n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f2906n = (z ? 2 : 0) | (this.f2906n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f2906n = (z ? 16 : 0) | (this.f2906n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2902j = drawable;
        this.f2903k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f2903k = i;
        this.f2902j = C0307a.m2325a(this.f2904l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2899g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f2900h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2905m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2900h = c;
        this.f2901i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2897e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f2897e = this.f2904l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2898f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f2906n = (z ? 0 : 8) | (this.f2906n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public C0462b m5585a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public C0462b m5582a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0641i mo851a() {
        return null;
    }

    public C0462b mo849a(C0641i c0641i) {
        throw new UnsupportedOperationException();
    }

    public C0462b m5587b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public C0462b mo850a(C0674e c0674e) {
        return this;
    }
}
