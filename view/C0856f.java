package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p015d.p016a.C0196a;
import android.support.v4.p015d.p016a.C0462b;
import android.support.v4.p024g.C0494j;
import android.support.v7.view.C0778b.C0825a;
import android.support.v7.view.menu.C0893v;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public class C0856f extends ActionMode {
    final Context f2805a;
    final C0778b f2806b;

    public static class C0855a implements C0825a {
        final Callback f2801a;
        final Context f2802b;
        final ArrayList<C0856f> f2803c = new ArrayList();
        final C0494j<Menu, Menu> f2804d = new C0494j();

        public C0855a(Context context, Callback callback) {
            this.f2802b = context;
            this.f2801a = callback;
        }

        public boolean mo841a(C0778b c0778b, Menu menu) {
            return this.f2801a.onCreateActionMode(m5511b(c0778b), m5507a(menu));
        }

        public boolean mo843b(C0778b c0778b, Menu menu) {
            return this.f2801a.onPrepareActionMode(m5511b(c0778b), m5507a(menu));
        }

        public boolean mo842a(C0778b c0778b, MenuItem menuItem) {
            return this.f2801a.onActionItemClicked(m5511b(c0778b), C0893v.m5754a(this.f2802b, (C0462b) menuItem));
        }

        public void mo840a(C0778b c0778b) {
            this.f2801a.onDestroyActionMode(m5511b(c0778b));
        }

        private Menu m5507a(Menu menu) {
            Menu menu2 = (Menu) this.f2804d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0893v.m5753a(this.f2802b, (C0196a) menu);
            this.f2804d.put(menu, menu2);
            return menu2;
        }

        public ActionMode m5511b(C0778b c0778b) {
            int size = this.f2803c.size();
            for (int i = 0; i < size; i++) {
                C0856f c0856f = (C0856f) this.f2803c.get(i);
                if (c0856f != null && c0856f.f2806b == c0778b) {
                    return c0856f;
                }
            }
            ActionMode c0856f2 = new C0856f(this.f2802b, c0778b);
            this.f2803c.add(c0856f2);
            return c0856f2;
        }
    }

    public C0856f(Context context, C0778b c0778b) {
        this.f2805a = context;
        this.f2806b = c0778b;
    }

    public Object getTag() {
        return this.f2806b.m5098j();
    }

    public void setTag(Object obj) {
        this.f2806b.m5087a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f2806b.mo760b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2806b.mo756a(charSequence);
    }

    public void invalidate() {
        this.f2806b.mo762d();
    }

    public void finish() {
        this.f2806b.mo761c();
    }

    public Menu getMenu() {
        return C0893v.m5753a(this.f2805a, (C0196a) this.f2806b.mo758b());
    }

    public CharSequence getTitle() {
        return this.f2806b.mo763f();
    }

    public void setTitle(int i) {
        this.f2806b.mo754a(i);
    }

    public CharSequence getSubtitle() {
        return this.f2806b.mo764g();
    }

    public void setSubtitle(int i) {
        this.f2806b.mo759b(i);
    }

    public View getCustomView() {
        return this.f2806b.mo766i();
    }

    public void setCustomView(View view) {
        this.f2806b.mo755a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f2806b.mo753a();
    }

    public boolean getTitleOptionalHint() {
        return this.f2806b.m5099k();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f2806b.mo757a(z);
    }

    public boolean isTitleOptional() {
        return this.f2806b.mo765h();
    }
}
