package android.support.p011a.p012a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

class C0173f {
    public static boolean m1057a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float m1054a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0173f.m1057a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static boolean m1056a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0173f.m1057a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static int m1055a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0173f.m1057a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static int m1058b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0173f.m1057a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
