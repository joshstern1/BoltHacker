package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class C0443c {
    public static void m3008a(Drawable drawable, int i) {
        if (drawable instanceof C0165o) {
            ((C0165o) drawable).setTint(i);
        }
    }

    public static void m3009a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0165o) {
            ((C0165o) drawable).setTintList(colorStateList);
        }
    }

    public static void m3011a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0165o) {
            ((C0165o) drawable).setTintMode(mode);
        }
    }

    public static Drawable m3007a(Drawable drawable) {
        if (drawable instanceof C0165o) {
            return drawable;
        }
        return new C0452j(drawable);
    }

    public static void m3010a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
