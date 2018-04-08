package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class C0448h {
    public static void m3022a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m3024a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m3023a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m3025a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m3028a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable m3021a(Drawable drawable) {
        if (drawable instanceof C0165o) {
            return drawable;
        }
        return new C0460n(drawable);
    }

    public static void m3026a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean m3029b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m3030c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void m3027a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
