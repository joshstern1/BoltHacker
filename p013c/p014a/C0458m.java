package android.support.v4.p013c.p014a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.p014a.C0452j.C0450a;

class C0458m extends C0456l {

    private static class C0457a extends C0450a {
        C0457a(C0450a c0450a, Resources resources) {
            super(c0450a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0458m(this, resources);
        }
    }

    C0458m(Drawable drawable) {
        super(drawable);
    }

    C0458m(C0450a c0450a, Resources resources) {
        super(c0450a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    C0450a mo411b() {
        return new C0457a(this.b, null);
    }
}
