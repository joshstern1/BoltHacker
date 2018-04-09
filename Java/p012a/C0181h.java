package android.support.p011a.p012a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p011a.p012a.C0171d.C0170b;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.p021b.p022a.C0414e;
import android.support.v4.p024g.C0495a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class C0181h extends C0166g {
    static final Mode f855b = Mode.SRC_IN;
    private C0179f f856c;
    private PorterDuffColorFilter f857d;
    private ColorFilter f858e;
    private boolean f859f;
    private boolean f860g;
    private ConstantState f861h;
    private final float[] f862i;
    private final Matrix f863j;
    private final Rect f864k;

    private static class C0174d {
        protected C0170b[] f797m = null;
        String f798n;
        int f799o;

        public C0174d(C0174d c0174d) {
            this.f798n = c0174d.f798n;
            this.f799o = c0174d.f799o;
            this.f797m = C0171d.m1051a(c0174d.f797m);
        }

        public void m1059a(Path path) {
            path.reset();
            if (this.f797m != null) {
                C0170b.m1045a(this.f797m, path);
            }
        }

        public String m1061b() {
            return this.f798n;
        }

        public boolean mo128a() {
            return false;
        }
    }

    private static class C0175a extends C0174d {
        public C0175a(C0175a c0175a) {
            super(c0175a);
        }

        public void m1063a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0173f.m1057a(xmlPullParser, "pathData")) {
                TypedArray b = C0166g.m1035b(resources, theme, attributeSet, C0162a.f779d);
                m1062a(b);
                b.recycle();
            }
        }

        private void m1062a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = C0171d.m1050a(string);
            }
        }

        public boolean mo128a() {
            return true;
        }
    }

    private static class C0176b extends C0174d {
        int f800a = 0;
        float f801b = 0.0f;
        int f802c = 0;
        float f803d = 1.0f;
        int f804e;
        float f805f = 1.0f;
        float f806g = 0.0f;
        float f807h = 1.0f;
        float f808i = 0.0f;
        Cap f809j = Cap.BUTT;
        Join f810k = Join.MITER;
        float f811l = 4.0f;
        private int[] f812p;

        public C0176b(C0176b c0176b) {
            super(c0176b);
            this.f812p = c0176b.f812p;
            this.f800a = c0176b.f800a;
            this.f801b = c0176b.f801b;
            this.f803d = c0176b.f803d;
            this.f802c = c0176b.f802c;
            this.f804e = c0176b.f804e;
            this.f805f = c0176b.f805f;
            this.f806g = c0176b.f806g;
            this.f807h = c0176b.f807h;
            this.f808i = c0176b.f808i;
            this.f809j = c0176b.f809j;
            this.f810k = c0176b.f810k;
            this.f811l = c0176b.f811l;
        }

        private Cap m1065a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m1066a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        public void m1068a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0166g.m1035b(resources, theme, attributeSet, C0162a.f778c);
            m1067a(b, xmlPullParser);
            b.recycle();
        }

        private void m1067a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f812p = null;
            if (C0173f.m1057a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0171d.m1050a(string);
                }
                this.f802c = C0173f.m1058b(typedArray, xmlPullParser, "fillColor", 1, this.f802c);
                this.f805f = C0173f.m1054a(typedArray, xmlPullParser, "fillAlpha", 12, this.f805f);
                this.f809j = m1065a(C0173f.m1055a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f809j);
                this.f810k = m1066a(C0173f.m1055a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f810k);
                this.f811l = C0173f.m1054a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f811l);
                this.f800a = C0173f.m1058b(typedArray, xmlPullParser, "strokeColor", 3, this.f800a);
                this.f803d = C0173f.m1054a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f803d);
                this.f801b = C0173f.m1054a(typedArray, xmlPullParser, "strokeWidth", 4, this.f801b);
                this.f807h = C0173f.m1054a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f807h);
                this.f808i = C0173f.m1054a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f808i);
                this.f806g = C0173f.m1054a(typedArray, xmlPullParser, "trimPathStart", 5, this.f806g);
            }
        }
    }

    private static class C0177c {
        final ArrayList<Object> f813a = new ArrayList();
        private final Matrix f814b = new Matrix();
        private float f815c = 0.0f;
        private float f816d = 0.0f;
        private float f817e = 0.0f;
        private float f818f = 1.0f;
        private float f819g = 1.0f;
        private float f820h = 0.0f;
        private float f821i = 0.0f;
        private final Matrix f822j = new Matrix();
        private int f823k;
        private int[] f824l;
        private String f825m = null;

        public C0177c(C0177c c0177c, C0495a<String, Object> c0495a) {
            this.f815c = c0177c.f815c;
            this.f816d = c0177c.f816d;
            this.f817e = c0177c.f817e;
            this.f818f = c0177c.f818f;
            this.f819g = c0177c.f819g;
            this.f820h = c0177c.f820h;
            this.f821i = c0177c.f821i;
            this.f824l = c0177c.f824l;
            this.f825m = c0177c.f825m;
            this.f823k = c0177c.f823k;
            if (this.f825m != null) {
                c0495a.put(this.f825m, this);
            }
            this.f822j.set(c0177c.f822j);
            ArrayList arrayList = c0177c.f813a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0177c) {
                    this.f813a.add(new C0177c((C0177c) obj, c0495a));
                } else {
                    C0174d c0176b;
                    if (obj instanceof C0176b) {
                        c0176b = new C0176b((C0176b) obj);
                    } else if (obj instanceof C0175a) {
                        c0176b = new C0175a((C0175a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f813a.add(c0176b);
                    if (c0176b.f798n != null) {
                        c0495a.put(c0176b.f798n, c0176b);
                    }
                }
            }
        }

        public String m1074a() {
            return this.f825m;
        }

        public void m1075a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0166g.m1035b(resources, theme, attributeSet, C0162a.f777b);
            m1070a(b, xmlPullParser);
            b.recycle();
        }

        private void m1070a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f824l = null;
            this.f815c = C0173f.m1054a(typedArray, xmlPullParser, "rotation", 5, this.f815c);
            this.f816d = typedArray.getFloat(1, this.f816d);
            this.f817e = typedArray.getFloat(2, this.f817e);
            this.f818f = C0173f.m1054a(typedArray, xmlPullParser, "scaleX", 3, this.f818f);
            this.f819g = C0173f.m1054a(typedArray, xmlPullParser, "scaleY", 4, this.f819g);
            this.f820h = C0173f.m1054a(typedArray, xmlPullParser, "translateX", 6, this.f820h);
            this.f821i = C0173f.m1054a(typedArray, xmlPullParser, "translateY", 7, this.f821i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f825m = string;
            }
            m1072b();
        }

        private void m1072b() {
            this.f822j.reset();
            this.f822j.postTranslate(-this.f816d, -this.f817e);
            this.f822j.postScale(this.f818f, this.f819g);
            this.f822j.postRotate(this.f815c, 0.0f, 0.0f);
            this.f822j.postTranslate(this.f820h + this.f816d, this.f821i + this.f817e);
        }
    }

    private static class C0178e {
        private static final Matrix f826j = new Matrix();
        float f827a;
        float f828b;
        float f829c;
        float f830d;
        int f831e;
        String f832f;
        final C0495a<String, Object> f833g;
        private final Path f834h;
        private final Path f835i;
        private final Matrix f836k;
        private Paint f837l;
        private Paint f838m;
        private PathMeasure f839n;
        private int f840o;
        private final C0177c f841p;

        public C0178e() {
            this.f836k = new Matrix();
            this.f827a = 0.0f;
            this.f828b = 0.0f;
            this.f829c = 0.0f;
            this.f830d = 0.0f;
            this.f831e = 255;
            this.f832f = null;
            this.f833g = new C0495a();
            this.f841p = new C0177c();
            this.f834h = new Path();
            this.f835i = new Path();
        }

        public void m1087a(int i) {
            this.f831e = i;
        }

        public int m1085a() {
            return this.f831e;
        }

        public void m1086a(float f) {
            m1087a((int) (255.0f * f));
        }

        public float m1089b() {
            return ((float) m1085a()) / 255.0f;
        }

        public C0178e(C0178e c0178e) {
            this.f836k = new Matrix();
            this.f827a = 0.0f;
            this.f828b = 0.0f;
            this.f829c = 0.0f;
            this.f830d = 0.0f;
            this.f831e = 255;
            this.f832f = null;
            this.f833g = new C0495a();
            this.f841p = new C0177c(c0178e.f841p, this.f833g);
            this.f834h = new Path(c0178e.f834h);
            this.f835i = new Path(c0178e.f835i);
            this.f827a = c0178e.f827a;
            this.f828b = c0178e.f828b;
            this.f829c = c0178e.f829c;
            this.f830d = c0178e.f830d;
            this.f840o = c0178e.f840o;
            this.f831e = c0178e.f831e;
            this.f832f = c0178e.f832f;
            if (c0178e.f832f != null) {
                this.f833g.put(c0178e.f832f, this);
            }
        }

        private void m1080a(C0177c c0177c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0177c.f814b.set(matrix);
            c0177c.f814b.preConcat(c0177c.f822j);
            for (int i3 = 0; i3 < c0177c.f813a.size(); i3++) {
                Object obj = c0177c.f813a.get(i3);
                if (obj instanceof C0177c) {
                    m1080a((C0177c) obj, c0177c.f814b, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0174d) {
                    m1081a(c0177c, (C0174d) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        public void m1088a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m1080a(this.f841p, f826j, canvas, i, i2, colorFilter);
        }

        private void m1081a(C0177c c0177c, C0174d c0174d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f829c;
            float f2 = ((float) i2) / this.f830d;
            float min = Math.min(f, f2);
            Matrix b = c0177c.f814b;
            this.f836k.set(b);
            this.f836k.postScale(f, f2);
            f = m1077a(b);
            if (f != 0.0f) {
                c0174d.m1059a(this.f834h);
                Path path = this.f834h;
                this.f835i.reset();
                if (c0174d.mo128a()) {
                    this.f835i.addPath(path, this.f836k);
                    canvas.clipPath(this.f835i, Op.REPLACE);
                    return;
                }
                Paint paint;
                C0176b c0176b = (C0176b) c0174d;
                if (!(c0176b.f806g == 0.0f && c0176b.f807h == 1.0f)) {
                    float f3 = (c0176b.f806g + c0176b.f808i) % 1.0f;
                    float f4 = (c0176b.f807h + c0176b.f808i) % 1.0f;
                    if (this.f839n == null) {
                        this.f839n = new PathMeasure();
                    }
                    this.f839n.setPath(this.f834h, false);
                    float length = this.f839n.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.f839n.getSegment(f3, length, path, true);
                        this.f839n.getSegment(0.0f, f4, path, true);
                    } else {
                        this.f839n.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f835i.addPath(path, this.f836k);
                if (c0176b.f802c != 0) {
                    if (this.f838m == null) {
                        this.f838m = new Paint();
                        this.f838m.setStyle(Style.FILL);
                        this.f838m.setAntiAlias(true);
                    }
                    paint = this.f838m;
                    paint.setColor(C0181h.m1104b(c0176b.f802c, c0176b.f805f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f835i, paint);
                }
                if (c0176b.f800a != 0) {
                    if (this.f837l == null) {
                        this.f837l = new Paint();
                        this.f837l.setStyle(Style.STROKE);
                        this.f837l.setAntiAlias(true);
                    }
                    paint = this.f837l;
                    if (c0176b.f810k != null) {
                        paint.setStrokeJoin(c0176b.f810k);
                    }
                    if (c0176b.f809j != null) {
                        paint.setStrokeCap(c0176b.f809j);
                    }
                    paint.setStrokeMiter(c0176b.f811l);
                    paint.setColor(C0181h.m1104b(c0176b.f800a, c0176b.f803d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * c0176b.f801b);
                    canvas.drawPath(this.f835i, paint);
                }
            }
        }

        private static float m1076a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m1077a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0178e.m1076a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            if (hypot > 0.0f) {
                return Math.abs(a) / hypot;
            }
            return 0.0f;
        }
    }

    private static class C0179f extends ConstantState {
        int f842a;
        C0178e f843b;
        ColorStateList f844c;
        Mode f845d;
        boolean f846e;
        Bitmap f847f;
        ColorStateList f848g;
        Mode f849h;
        int f850i;
        boolean f851j;
        boolean f852k;
        Paint f853l;

        public C0179f(C0179f c0179f) {
            this.f844c = null;
            this.f845d = C0181h.f855b;
            if (c0179f != null) {
                this.f842a = c0179f.f842a;
                this.f843b = new C0178e(c0179f.f843b);
                if (c0179f.f843b.f838m != null) {
                    this.f843b.f838m = new Paint(c0179f.f843b.f838m);
                }
                if (c0179f.f843b.f837l != null) {
                    this.f843b.f837l = new Paint(c0179f.f843b.f837l);
                }
                this.f844c = c0179f.f844c;
                this.f845d = c0179f.f845d;
                this.f846e = c0179f.f846e;
            }
        }

        public void m1092a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f847f, null, rect, m1090a(colorFilter));
        }

        public boolean m1093a() {
            return this.f843b.m1085a() < 255;
        }

        public Paint m1090a(ColorFilter colorFilter) {
            if (!m1093a() && colorFilter == null) {
                return null;
            }
            if (this.f853l == null) {
                this.f853l = new Paint();
                this.f853l.setFilterBitmap(true);
            }
            this.f853l.setAlpha(this.f843b.m1085a());
            this.f853l.setColorFilter(colorFilter);
            return this.f853l;
        }

        public void m1091a(int i, int i2) {
            this.f847f.eraseColor(0);
            this.f843b.m1088a(new Canvas(this.f847f), i, i2, null);
        }

        public void m1094b(int i, int i2) {
            if (this.f847f == null || !m1097c(i, i2)) {
                this.f847f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f852k = true;
            }
        }

        public boolean m1097c(int i, int i2) {
            if (i == this.f847f.getWidth() && i2 == this.f847f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean m1095b() {
            if (!this.f852k && this.f848g == this.f844c && this.f849h == this.f845d && this.f851j == this.f846e && this.f850i == this.f843b.m1085a()) {
                return true;
            }
            return false;
        }

        public void m1096c() {
            this.f848g = this.f844c;
            this.f849h = this.f845d;
            this.f850i = this.f843b.m1085a();
            this.f851j = this.f846e;
            this.f852k = false;
        }

        public C0179f() {
            this.f844c = null;
            this.f845d = C0181h.f855b;
            this.f843b = new C0178e();
        }

        public Drawable newDrawable() {
            return new C0181h();
        }

        public Drawable newDrawable(Resources resources) {
            return new C0181h();
        }

        public int getChangingConfigurations() {
            return this.f842a;
        }
    }

    private static class C0180g extends ConstantState {
        private final ConstantState f854a;

        public C0180g(ConstantState constantState) {
            this.f854a = constantState;
        }

        public Drawable newDrawable() {
            Drawable c0181h = new C0181h();
            c0181h.a = (VectorDrawable) this.f854a.newDrawable();
            return c0181h;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0181h = new C0181h();
            c0181h.a = (VectorDrawable) this.f854a.newDrawable(resources);
            return c0181h;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0181h = new C0181h();
            c0181h.a = (VectorDrawable) this.f854a.newDrawable(resources, theme);
            return c0181h;
        }

        public boolean canApplyTheme() {
            return this.f854a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f854a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private C0181h() {
        this.f860g = true;
        this.f862i = new float[9];
        this.f863j = new Matrix();
        this.f864k = new Rect();
        this.f856c = new C0179f();
    }

    private C0181h(C0179f c0179f) {
        this.f860g = true;
        this.f862i = new float[9];
        this.f863j = new Matrix();
        this.f864k = new Rect();
        this.f856c = c0179f;
        this.f857d = m1106a(this.f857d, c0179f.f844c, c0179f.f845d);
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.f859f && super.mutate() == this) {
            this.f856c = new C0179f(this.f856c);
            this.f859f = true;
        }
        return this;
    }

    Object m1107a(String str) {
        return this.f856c.f843b.f833g.get(str);
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new C0180g(this.a.getConstantState());
        }
        this.f856c.f842a = getChangingConfigurations();
        return this.f856c;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.f864k);
        if (this.f864k.width() > 0 && this.f864k.height() > 0) {
            ColorFilter colorFilter = this.f858e == null ? this.f857d : this.f858e;
            canvas.getMatrix(this.f863j);
            this.f863j.getValues(this.f862i);
            float abs = Math.abs(this.f862i[0]);
            float abs2 = Math.abs(this.f862i[4]);
            float abs3 = Math.abs(this.f862i[1]);
            float abs4 = Math.abs(this.f862i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f864k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.f864k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f864k.left, (float) this.f864k.top);
                if (m1103a()) {
                    canvas.translate((float) this.f864k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f864k.offsetTo(0, 0);
                this.f856c.m1094b(min, height);
                if (!this.f860g) {
                    this.f856c.m1091a(min, height);
                } else if (!this.f856c.m1095b()) {
                    this.f856c.m1091a(min, height);
                    this.f856c.m1096c();
                }
                this.f856c.m1092a(canvas, colorFilter, this.f864k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.a != null) {
            return C0441a.m2999c(this.a);
        }
        return this.f856c.f843b.m1085a();
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else if (this.f856c.f843b.m1085a() != i) {
            this.f856c.f843b.m1087a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.f858e = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter m1106a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0441a.m2990a(this.a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0441a.m2992a(this.a, colorStateList);
            return;
        }
        C0179f c0179f = this.f856c;
        if (c0179f.f844c != colorStateList) {
            c0179f.f844c = colorStateList;
            this.f857d = m1106a(this.f857d, colorStateList, c0179f.f845d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0441a.m2995a(this.a, mode);
            return;
        }
        C0179f c0179f = this.f856c;
        if (c0179f.f845d != mode) {
            c0179f.f845d = mode;
            this.f857d = m1106a(this.f857d, c0179f.f844c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return super.isStateful() || !(this.f856c == null || this.f856c.f844c == null || !this.f856c.f844c.isStateful());
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        C0179f c0179f = this.f856c;
        if (c0179f.f844c == null || c0179f.f845d == null) {
            return false;
        }
        this.f857d = m1106a(this.f857d, c0179f.f844c, c0179f.f845d);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return (int) this.f856c.f843b.f827a;
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return (int) this.f856c.f843b.f828b;
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            C0441a.m3000d(this.a);
        }
        return false;
    }

    public static C0181h m1100a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            C0181h c0181h = new C0181h();
            c0181h.a = C0414e.m2899a(resources, i, theme);
            c0181h.f861h = new C0180g(c0181h.a.getConstantState());
            return c0181h;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0181h.m1101a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static C0181h m1101a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C0181h c0181h = new C0181h();
        c0181h.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0181h;
    }

    private static int m1104b(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.a != null) {
            C0441a.m2994a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0179f c0179f = this.f856c;
        c0179f.f843b = new C0178e();
        TypedArray b = C0166g.m1035b(resources, theme, attributeSet, C0162a.f776a);
        m1102a(b, xmlPullParser);
        b.recycle();
        c0179f.f842a = getChangingConfigurations();
        c0179f.f852k = true;
        m1105b(resources, xmlPullParser, attributeSet, theme);
        this.f857d = m1106a(this.f857d, c0179f.f844c, c0179f.f845d);
    }

    private static Mode m1099a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    private void m1102a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C0179f c0179f = this.f856c;
        C0178e c0178e = c0179f.f843b;
        c0179f.f845d = C0181h.m1099a(C0173f.m1055a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0179f.f844c = colorStateList;
        }
        c0179f.f846e = C0173f.m1056a(typedArray, xmlPullParser, "autoMirrored", 5, c0179f.f846e);
        c0178e.f829c = C0173f.m1054a(typedArray, xmlPullParser, "viewportWidth", 7, c0178e.f829c);
        c0178e.f830d = C0173f.m1054a(typedArray, xmlPullParser, "viewportHeight", 8, c0178e.f830d);
        if (c0178e.f829c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0178e.f830d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0178e.f827a = typedArray.getDimension(3, c0178e.f827a);
            c0178e.f828b = typedArray.getDimension(2, c0178e.f828b);
            if (c0178e.f827a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0178e.f828b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0178e.m1086a(C0173f.m1054a(typedArray, xmlPullParser, "alpha", 4, c0178e.m1089b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0178e.f832f = string;
                    c0178e.f833g.put(string, c0178e);
                }
            }
        }
    }

    private void m1105b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C0179f c0179f = this.f856c;
        C0178e c0178e = c0179f.f843b;
        Stack stack = new Stack();
        stack.push(c0178e.f841p);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0177c c0177c = (C0177c) stack.peek();
                if ("path".equals(name)) {
                    C0176b c0176b = new C0176b();
                    c0176b.m1068a(resources, attributeSet, theme, xmlPullParser);
                    c0177c.f813a.add(c0176b);
                    if (c0176b.m1061b() != null) {
                        c0178e.f833g.put(c0176b.m1061b(), c0176b);
                    }
                    obj2 = null;
                    c0179f.f842a = c0176b.o | c0179f.f842a;
                } else if ("clip-path".equals(name)) {
                    C0175a c0175a = new C0175a();
                    c0175a.m1063a(resources, attributeSet, theme, xmlPullParser);
                    c0177c.f813a.add(c0175a);
                    if (c0175a.m1061b() != null) {
                        c0178e.f833g.put(c0175a.m1061b(), c0175a);
                    }
                    c0179f.f842a |= c0175a.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0177c c0177c2 = new C0177c();
                        c0177c2.m1075a(resources, attributeSet, theme, xmlPullParser);
                        c0177c.f813a.add(c0177c2);
                        stack.push(c0177c2);
                        if (c0177c2.m1074a() != null) {
                            c0178e.f833g.put(c0177c2.m1074a(), c0177c2);
                        }
                        c0179f.f842a |= c0177c2.f823k;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    void m1108a(boolean z) {
        this.f860g = z;
    }

    private boolean m1103a() {
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f856c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
