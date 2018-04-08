package android.support.v4.p013c.p014a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.p013c.p014a.C0452j.C0450a;

class C0454k extends C0452j {

    private static class C0453a extends C0450a {
        C0453a(C0450a c0450a, Resources resources) {
            super(c0450a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0454k(this, resources);
        }
    }

    C0454k(Drawable drawable) {
        super(drawable);
    }

    C0454k(C0450a c0450a, Resources resources) {
        super(c0450a, resources);
    }

    C0450a mo411b() {
        return new C0453a(this.b, null);
    }

    protected Drawable mo410a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }
}
