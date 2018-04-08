package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p015d.p016a.C0462b;
import android.support.v4.view.C0641i.C0640b;
import android.support.v7.view.menu.C0888o.C0884a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
class C0890p extends C0888o {

    class C0889a extends C0884a implements VisibilityListener {
        C0640b f3011c;
        final /* synthetic */ C0890p f3012d;

        public C0889a(C0890p c0890p, Context context, ActionProvider actionProvider) {
            this.f3012d = c0890p;
            super(c0890p, context, actionProvider);
        }

        public View mo883a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public boolean mo885b() {
            return this.a.overridesItemVisibility();
        }

        public boolean mo886c() {
            return this.a.isVisible();
        }

        public void mo884a(C0640b c0640b) {
            VisibilityListener visibilityListener;
            this.f3011c = c0640b;
            ActionProvider actionProvider = this.a;
            if (c0640b == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f3011c != null) {
                this.f3011c.mo874a(z);
            }
        }
    }

    C0890p(Context context, C0462b c0462b) {
        super(context, c0462b);
    }

    C0884a mo887a(ActionProvider actionProvider) {
        return new C0889a(this, this.a, actionProvider);
    }
}
