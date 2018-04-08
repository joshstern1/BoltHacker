package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p015d.p016a.C0462b;
import android.support.v4.view.C0641i;
import android.support.v4.view.C0675w.C0674e;
import android.support.v7.view.C0852c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class C0888o extends C0868c<C0462b> implements MenuItem {
    private Method f3010c;

    class C0884a extends C0641i {
        final ActionProvider f3005a;
        final /* synthetic */ C0888o f3006b;

        public C0884a(C0888o c0888o, Context context, ActionProvider actionProvider) {
            this.f3006b = c0888o;
            super(context);
            this.f3005a = actionProvider;
        }

        public View mo875a() {
            return this.f3005a.onCreateActionView();
        }

        public boolean mo877d() {
            return this.f3005a.onPerformDefaultAction();
        }

        public boolean mo878e() {
            return this.f3005a.hasSubMenu();
        }

        public void mo876a(SubMenu subMenu) {
            this.f3005a.onPrepareSubMenu(this.f3006b.m5589a(subMenu));
        }
    }

    static class C0885b extends FrameLayout implements C0852c {
        final CollapsibleActionView f3007a;

        C0885b(View view) {
            super(view.getContext());
            this.f3007a = (CollapsibleActionView) view;
            addView(view);
        }

        public void mo879a() {
            this.f3007a.onActionViewExpanded();
        }

        public void mo880b() {
            this.f3007a.onActionViewCollapsed();
        }

        View m5729c() {
            return (View) this.f3007a;
        }
    }

    private class C0886c extends C0867d<OnActionExpandListener> implements C0674e {
        final /* synthetic */ C0888o f3008a;

        C0886c(C0888o c0888o, OnActionExpandListener onActionExpandListener) {
            this.f3008a = c0888o;
            super(onActionExpandListener);
        }

        public boolean mo881a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f3008a.m5588a(menuItem));
        }

        public boolean mo882b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f3008a.m5588a(menuItem));
        }
    }

    private class C0887d extends C0867d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0888o f3009a;

        C0887d(C0888o c0888o, OnMenuItemClickListener onMenuItemClickListener) {
            this.f3009a = c0888o;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f3009a.m5588a(menuItem));
        }
    }

    C0888o(Context context, C0462b c0462b) {
        super(context, c0462b);
    }

    public int getItemId() {
        return ((C0462b) this.b).getItemId();
    }

    public int getGroupId() {
        return ((C0462b) this.b).getGroupId();
    }

    public int getOrder() {
        return ((C0462b) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0462b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0462b) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((C0462b) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0462b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C0462b) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0462b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0462b) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((C0462b) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C0462b) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C0462b) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0462b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0462b) this.b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((C0462b) this.b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0462b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C0462b) this.b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((C0462b) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((C0462b) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((C0462b) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((C0462b) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((C0462b) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((C0462b) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((C0462b) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((C0462b) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C0462b) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m5589a(((C0462b) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0462b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0887d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0462b) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((C0462b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0462b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0885b(view);
        }
        ((C0462b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0462b) this.b).setActionView(i);
        View actionView = ((C0462b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0462b) this.b).setActionView(new C0885b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C0462b) this.b).getActionView();
        if (actionView instanceof C0885b) {
            return ((C0885b) actionView).m5729c();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0462b) this.b).mo849a(actionProvider != null ? mo887a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0641i a = ((C0462b) this.b).mo851a();
        if (a instanceof C0884a) {
            return ((C0884a) a).f3005a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((C0462b) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C0462b) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C0462b) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0462b) this.b).mo850a(onActionExpandListener != null ? new C0886c(this, onActionExpandListener) : null);
        return this;
    }

    public void m5733a(boolean z) {
        try {
            if (this.f3010c == null) {
                this.f3010c = ((C0462b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f3010c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    C0884a mo887a(ActionProvider actionProvider) {
        return new C0884a(this, this.a, actionProvider);
    }
}
