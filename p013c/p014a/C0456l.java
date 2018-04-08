package android.support.v4.p013c.p014a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.p014a.C0452j.C0450a;

class C0456l extends C0452j {

    private static class C0455a extends C0450a {
        C0455a(C0450a c0450a, Resources resources) {
            super(c0450a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0456l(this, resources);
        }
    }

    C0456l(Drawable drawable) {
        super(drawable);
    }

    C0456l(C0450a c0450a, Resources resources) {
        super(c0450a, resources);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    C0450a mo411b() {
        return new C0455a(this.b, null);
    }
}
