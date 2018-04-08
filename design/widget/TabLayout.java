package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.C0192a.C0186d;
import android.support.design.C0192a.C0188f;
import android.support.design.C0192a.C0190h;
import android.support.design.C0192a.C0191i;
import android.support.v4.p024g.C0511i.C0508a;
import android.support.v4.p024g.C0511i.C0509b;
import android.support.v4.p024g.C0511i.C0510c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0245f;
import android.support.v4.view.aj;
import android.support.v4.view.ao;
import android.support.v4.widget.ax;
import android.support.v7.p027a.C0760a.C0759c;
import android.support.v7.widget.C1011w;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {
    private static final C0508a<C0244d> f1197a = new C0510c(16);
    private final C0508a<C0247f> f1198A;
    private final ArrayList<C0244d> f1199b;
    private C0244d f1200c;
    private final C0243c f1201d;
    private int f1202e;
    private int f1203f;
    private int f1204g;
    private int f1205h;
    private int f1206i;
    private ColorStateList f1207j;
    private float f1208k;
    private float f1209l;
    private final int f1210m;
    private int f1211n;
    private final int f1212o;
    private final int f1213p;
    private final int f1214q;
    private int f1215r;
    private int f1216s;
    private int f1217t;
    private C0241a f1218u;
    private bf f1219v;
    private ViewPager f1220w;
    private aj f1221x;
    private DataSetObserver f1222y;
    private C0246e f1223z;

    public interface C0241a {
        void mo216a(C0244d c0244d);

        void mo217b(C0244d c0244d);

        void mo218c(C0244d c0244d);
    }

    private class C0242b extends DataSetObserver {
        final /* synthetic */ TabLayout f1168a;

        private C0242b(TabLayout tabLayout) {
            this.f1168a = tabLayout;
        }

        public void onChanged() {
            this.f1168a.m1850c();
        }

        public void onInvalidated() {
            this.f1168a.m1850c();
        }
    }

    private class C0243c extends LinearLayout {
        final /* synthetic */ TabLayout f1169a;
        private int f1170b;
        private final Paint f1171c;
        private int f1172d = -1;
        private float f1173e;
        private int f1174f = -1;
        private int f1175g = -1;
        private bf f1176h;

        C0243c(TabLayout tabLayout, Context context) {
            this.f1169a = tabLayout;
            super(context);
            setWillNotDraw(false);
            this.f1171c = new Paint();
        }

        void m1789a(int i) {
            if (this.f1171c.getColor() != i) {
                this.f1171c.setColor(i);
                ao.m3928d(this);
            }
        }

        void m1794b(int i) {
            if (this.f1170b != i) {
                this.f1170b = i;
                ao.m3928d(this);
            }
        }

        boolean m1792a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void m1790a(int i, float f) {
            if (this.f1176h != null && this.f1176h.m2041b()) {
                this.f1176h.m2044e();
            }
            this.f1172d = i;
            this.f1173e = f;
            m1788c();
        }

        float m1793b() {
            return ((float) this.f1172d) + this.f1173e;
        }

        protected void onMeasure(int i, int i2) {
            boolean z = false;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && this.f1169a.f1217t == 1 && this.f1169a.f1216s == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    int max;
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        max = Math.max(i4, childAt.getMeasuredWidth());
                    } else {
                        max = i4;
                    }
                    i3++;
                    i4 = max;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (this.f1169a.m1845b(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            boolean z2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                z2 = z;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                            i3++;
                            z = z2;
                        }
                    } else {
                        this.f1169a.f1216s = 0;
                        this.f1169a.m1844a(false);
                        z = true;
                    }
                    if (z) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f1176h == null || !this.f1176h.m2041b()) {
                m1788c();
                return;
            }
            this.f1176h.m2044e();
            m1791a(this.f1172d, Math.round(((float) this.f1176h.m2046g()) * (1.0f - this.f1176h.m2045f())));
        }

        private void m1788c() {
            int i;
            int i2;
            View childAt = getChildAt(this.f1172d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.f1173e > 0.0f && this.f1172d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f1172d + 1);
                    i2 = (int) ((((float) i2) * (1.0f - this.f1173e)) + (this.f1173e * ((float) childAt2.getLeft())));
                    i = (int) ((((float) i) * (1.0f - this.f1173e)) + (((float) childAt2.getRight()) * this.f1173e));
                }
            }
            m1787b(i2, i);
        }

        private void m1787b(int i, int i2) {
            if (i != this.f1174f || i2 != this.f1175g) {
                this.f1174f = i;
                this.f1175g = i2;
                ao.m3928d(this);
            }
        }

        void m1791a(int i, int i2) {
            if (this.f1176h != null && this.f1176h.m2041b()) {
                this.f1176h.m2044e();
            }
            Object obj = ao.m3938h(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                m1788c();
                return;
            }
            int i3;
            int i4;
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i - this.f1172d) <= 1) {
                i3 = this.f1174f;
                i4 = this.f1175g;
            } else {
                int a = this.f1169a.m1845b(24);
                if (i < this.f1172d) {
                    if (obj != null) {
                        i4 = left - a;
                        i3 = i4;
                    } else {
                        i4 = right + a;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + a;
                    i3 = i4;
                } else {
                    i4 = left - a;
                    i3 = i4;
                }
            }
            if (i3 != left || i4 != right) {
                bf a2 = br.m2095a();
                this.f1176h = a2;
                a2.m2040a(C0252a.f1253b);
                a2.m2036a(i2);
                a2.m2035a(0.0f, 1.0f);
                a2.m2039a(new aw(this, i3, left, i4, right));
                a2.m2038a(new ax(this, i));
                a2.m2034a();
            }
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f1174f >= 0 && this.f1175g > this.f1174f) {
                canvas.drawRect((float) this.f1174f, (float) (getHeight() - this.f1170b), (float) this.f1175g, (float) getHeight(), this.f1171c);
            }
        }
    }

    public static final class C0244d {
        private Object f1177a;
        private Drawable f1178b;
        private CharSequence f1179c;
        private CharSequence f1180d;
        private int f1181e;
        private View f1182f;
        private TabLayout f1183g;
        private C0247f f1184h;

        private C0244d() {
            this.f1181e = -1;
        }

        public View m1807a() {
            return this.f1182f;
        }

        public C0244d m1805a(View view) {
            this.f1182f = view;
            m1801g();
            return this;
        }

        public C0244d m1803a(int i) {
            return m1805a(LayoutInflater.from(this.f1184h.getContext()).inflate(i, this.f1184h, false));
        }

        public Drawable m1808b() {
            return this.f1178b;
        }

        public int m1810c() {
            return this.f1181e;
        }

        void m1809b(int i) {
            this.f1181e = i;
        }

        public CharSequence m1811d() {
            return this.f1179c;
        }

        public C0244d m1804a(Drawable drawable) {
            this.f1178b = drawable;
            m1801g();
            return this;
        }

        public C0244d m1806a(CharSequence charSequence) {
            this.f1179c = charSequence;
            m1801g();
            return this;
        }

        public void m1812e() {
            if (this.f1183g == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f1183g.m1874b(this);
        }

        public CharSequence m1813f() {
            return this.f1180d;
        }

        private void m1801g() {
            if (this.f1184h != null) {
                this.f1184h.m1828a();
            }
        }

        private void m1802h() {
            this.f1183g = null;
            this.f1184h = null;
            this.f1177a = null;
            this.f1178b = null;
            this.f1179c = null;
            this.f1180d = null;
            this.f1181e = -1;
            this.f1182f = null;
        }
    }

    public static class C0246e implements C0245f {
        private final WeakReference<TabLayout> f1185a;
        private int f1186b;
        private int f1187c;

        public C0246e(TabLayout tabLayout) {
            this.f1185a = new WeakReference(tabLayout);
        }

        public void mo213a(int i) {
            this.f1186b = this.f1187c;
            this.f1187c = i;
        }

        public void mo214a(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.f1185a.get();
            if (tabLayout != null) {
                boolean z2 = this.f1187c != 2 || this.f1186b == 1;
                if (!(this.f1187c == 2 && this.f1186b == 0)) {
                    z = true;
                }
                tabLayout.m1836a(i, f, z2, z);
            }
        }

        public void mo215b(int i) {
            TabLayout tabLayout = (TabLayout) this.f1185a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i) {
                boolean z = this.f1187c == 0 || (this.f1187c == 2 && this.f1186b == 0);
                tabLayout.m1875b(tabLayout.m1869a(i), z);
            }
        }

        private void m1817a() {
            this.f1187c = 0;
            this.f1186b = 0;
        }
    }

    class C0247f extends LinearLayout implements OnLongClickListener {
        final /* synthetic */ TabLayout f1188a;
        private C0244d f1189b;
        private TextView f1190c;
        private ImageView f1191d;
        private View f1192e;
        private TextView f1193f;
        private ImageView f1194g;
        private int f1195h = 2;

        public C0247f(TabLayout tabLayout, Context context) {
            this.f1188a = tabLayout;
            super(context);
            if (tabLayout.f1210m != 0) {
                setBackgroundDrawable(C1011w.m7254a().m7272a(context, tabLayout.f1210m));
            }
            ao.m3905a(this, tabLayout.f1202e, tabLayout.f1203f, tabLayout.f1204g, tabLayout.f1205h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f1189b == null) {
                return performClick;
            }
            this.f1189b.m1812e();
            return true;
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
                if (this.f1190c != null) {
                    this.f1190c.setSelected(z);
                }
                if (this.f1191d != null) {
                    this.f1191d.setSelected(z);
                }
            }
        }

        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0759c.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0759c.class.getName());
        }

        public void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int f = this.f1188a.getTabMaxWidth();
            if (f > 0 && (mode == 0 || size > f)) {
                i = MeasureSpec.makeMeasureSpec(this.f1188a.f1211n, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f1190c != null) {
                getResources();
                float h = this.f1188a.f1208k;
                size = this.f1195h;
                if (this.f1191d != null && this.f1191d.getVisibility() == 0) {
                    size = 1;
                } else if (this.f1190c != null && this.f1190c.getLineCount() > 1) {
                    h = this.f1188a.f1209l;
                }
                float textSize = this.f1190c.getTextSize();
                int lineCount = this.f1190c.getLineCount();
                int a = ax.m4797a(this.f1190c);
                if (h != textSize || (a >= 0 && size != a)) {
                    if (this.f1188a.f1217t == 1 && h > textSize && lineCount == 1) {
                        Layout layout = this.f1190c.getLayout();
                        if (layout == null || m1822a(layout, 0, h) > ((float) layout.getWidth())) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.f1190c.setTextSize(0, h);
                        this.f1190c.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        private void m1823a(C0244d c0244d) {
            if (c0244d != this.f1189b) {
                this.f1189b = c0244d;
                m1828a();
            }
        }

        private void m1827b() {
            m1823a(null);
            setSelected(false);
        }

        final void m1828a() {
            C0244d c0244d = this.f1189b;
            View a = c0244d != null ? c0244d.m1807a() : null;
            if (a != null) {
                C0247f parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(a);
                    }
                    addView(a);
                }
                this.f1192e = a;
                if (this.f1190c != null) {
                    this.f1190c.setVisibility(8);
                }
                if (this.f1191d != null) {
                    this.f1191d.setVisibility(8);
                    this.f1191d.setImageDrawable(null);
                }
                this.f1193f = (TextView) a.findViewById(16908308);
                if (this.f1193f != null) {
                    this.f1195h = ax.m4797a(this.f1193f);
                }
                this.f1194g = (ImageView) a.findViewById(16908294);
            } else {
                if (this.f1192e != null) {
                    removeView(this.f1192e);
                    this.f1192e = null;
                }
                this.f1193f = null;
                this.f1194g = null;
            }
            if (this.f1192e == null) {
                if (this.f1191d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C0188f.design_layout_tab_icon, this, false);
                    addView(imageView, 0);
                    this.f1191d = imageView;
                }
                if (this.f1190c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0188f.design_layout_tab_text, this, false);
                    addView(textView);
                    this.f1190c = textView;
                    this.f1195h = ax.m4797a(this.f1190c);
                }
                this.f1190c.setTextAppearance(getContext(), this.f1188a.f1206i);
                if (this.f1188a.f1207j != null) {
                    this.f1190c.setTextColor(this.f1188a.f1207j);
                }
                m1826a(this.f1190c, this.f1191d);
            } else if (this.f1193f != null || this.f1194g != null) {
                m1826a(this.f1193f, this.f1194g);
            }
        }

        private void m1826a(TextView textView, ImageView imageView) {
            CharSequence d;
            CharSequence f;
            boolean z;
            Drawable b = this.f1189b != null ? this.f1189b.m1808b() : null;
            if (this.f1189b != null) {
                d = this.f1189b.m1811d();
            } else {
                d = null;
            }
            if (this.f1189b != null) {
                f = this.f1189b.m1813f();
            } else {
                f = null;
            }
            if (imageView != null) {
                if (b != null) {
                    imageView.setImageDrawable(b);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(f);
            }
            if (TextUtils.isEmpty(d)) {
                z = false;
            } else {
                z = true;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(f);
            }
            if (imageView != null) {
                int a;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    a = this.f1188a.m1845b(8);
                } else {
                    a = 0;
                }
                if (a != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(f)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f1189b.m1813f(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        private float m1822a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    public static class C0248g implements C0241a {
        private final ViewPager f1196a;

        public C0248g(ViewPager viewPager) {
            this.f1196a = viewPager;
        }

        public void mo216a(C0244d c0244d) {
            this.f1196a.setCurrentItem(c0244d.m1810c());
        }

        public void mo217b(C0244d c0244d) {
        }

        public void mo218c(C0244d c0244d) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1199b = new ArrayList();
        this.f1211n = Integer.MAX_VALUE;
        this.f1198A = new C0509b(12);
        be.m2015a(context);
        setHorizontalScrollBarEnabled(false);
        this.f1201d = new C0243c(this, context);
        super.addView(this.f1201d, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0191i.TabLayout, i, C0190h.Widget_Design_TabLayout);
        this.f1201d.m1794b(obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabIndicatorHeight, 0));
        this.f1201d.m1789a(obtainStyledAttributes.getColor(C0191i.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabPadding, 0);
        this.f1205h = dimensionPixelSize;
        this.f1204g = dimensionPixelSize;
        this.f1203f = dimensionPixelSize;
        this.f1202e = dimensionPixelSize;
        this.f1202e = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabPaddingStart, this.f1202e);
        this.f1203f = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabPaddingTop, this.f1203f);
        this.f1204g = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabPaddingEnd, this.f1204g);
        this.f1205h = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabPaddingBottom, this.f1205h);
        this.f1206i = obtainStyledAttributes.getResourceId(C0191i.TabLayout_tabTextAppearance, C0190h.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.f1206i, C0191i.TextAppearance);
        try {
            this.f1208k = (float) obtainStyledAttributes2.getDimensionPixelSize(C0191i.TextAppearance_android_textSize, 0);
            this.f1207j = obtainStyledAttributes2.getColorStateList(C0191i.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(C0191i.TabLayout_tabTextColor)) {
                this.f1207j = obtainStyledAttributes.getColorStateList(C0191i.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(C0191i.TabLayout_tabSelectedTextColor)) {
                this.f1207j = m1835a(this.f1207j.getDefaultColor(), obtainStyledAttributes.getColor(C0191i.TabLayout_tabSelectedTextColor, 0));
            }
            this.f1212o = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabMinWidth, -1);
            this.f1213p = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabMaxWidth, -1);
            this.f1210m = obtainStyledAttributes.getResourceId(C0191i.TabLayout_tabBackground, 0);
            this.f1215r = obtainStyledAttributes.getDimensionPixelSize(C0191i.TabLayout_tabContentStart, 0);
            this.f1217t = obtainStyledAttributes.getInt(C0191i.TabLayout_tabMode, 1);
            this.f1216s = obtainStyledAttributes.getInt(C0191i.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.f1209l = (float) resources.getDimensionPixelSize(C0186d.design_tab_text_size_2line);
            this.f1214q = resources.getDimensionPixelSize(C0186d.design_tab_scrollable_min_width);
            m1859f();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f1201d.m1789a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f1201d.m1794b(i);
    }

    public void m1870a(int i, float f, boolean z) {
        m1836a(i, f, z, true);
    }

    private void m1836a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.f1201d.getChildCount()) {
            if (z2) {
                this.f1201d.m1790a(i, f);
            }
            if (this.f1219v != null && this.f1219v.m2041b()) {
                this.f1219v.m2044e();
            }
            scrollTo(m1832a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.f1201d.m1793b();
    }

    public void m1871a(C0244d c0244d) {
        m1872a(c0244d, this.f1199b.isEmpty());
    }

    public void m1872a(C0244d c0244d, boolean z) {
        if (c0244d.f1183g != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m1852c(c0244d, z);
        m1837a(c0244d, this.f1199b.size());
        if (z) {
            c0244d.m1812e();
        }
    }

    private void m1840a(au auVar) {
        C0244d a = m1868a();
        if (auVar.f1305a != null) {
            a.m1806a(auVar.f1305a);
        }
        if (auVar.f1306b != null) {
            a.m1804a(auVar.f1306b);
        }
        if (auVar.f1307c != 0) {
            a.m1803a(auVar.f1307c);
        }
        m1871a(a);
    }

    public void setOnTabSelectedListener(C0241a c0241a) {
        this.f1218u = c0241a;
    }

    public C0244d m1868a() {
        C0244d c0244d = (C0244d) f1197a.mo428a();
        if (c0244d == null) {
            c0244d = new C0244d();
        }
        c0244d.f1183g = this;
        c0244d.f1184h = m1849c(c0244d);
        return c0244d;
    }

    public int getTabCount() {
        return this.f1199b.size();
    }

    public C0244d m1869a(int i) {
        return (C0244d) this.f1199b.get(i);
    }

    public int getSelectedTabPosition() {
        return this.f1200c != null ? this.f1200c.m1810c() : -1;
    }

    public void m1873b() {
        for (int childCount = this.f1201d.getChildCount() - 1; childCount >= 0; childCount--) {
            m1851c(childCount);
        }
        Iterator it = this.f1199b.iterator();
        while (it.hasNext()) {
            C0244d c0244d = (C0244d) it.next();
            it.remove();
            c0244d.m1802h();
            f1197a.mo429a(c0244d);
        }
        this.f1200c = null;
    }

    public void setTabMode(int i) {
        if (i != this.f1217t) {
            this.f1217t = i;
            m1859f();
        }
    }

    public int getTabMode() {
        return this.f1217t;
    }

    public void setTabGravity(int i) {
        if (this.f1216s != i) {
            this.f1216s = i;
            m1859f();
        }
    }

    public int getTabGravity() {
        return this.f1216s;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f1207j != colorStateList) {
            this.f1207j = colorStateList;
            m1854d();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f1207j;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        if (!(this.f1220w == null || this.f1223z == null)) {
            this.f1220w.m3232b(this.f1223z);
        }
        if (viewPager != null) {
            aj adapter = viewPager.getAdapter();
            if (adapter == null) {
                throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
            }
            this.f1220w = viewPager;
            if (this.f1223z == null) {
                this.f1223z = new C0246e(this);
            }
            this.f1223z.m1817a();
            viewPager.m3225a(this.f1223z);
            setOnTabSelectedListener(new C0248g(viewPager));
            m1841a(adapter, true);
            return;
        }
        this.f1220w = null;
        setOnTabSelectedListener(null);
        m1841a(null, true);
    }

    @Deprecated
    public void setTabsFromPagerAdapter(aj ajVar) {
        m1841a(ajVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f1201d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void m1841a(aj ajVar, boolean z) {
        if (!(this.f1221x == null || this.f1222y == null)) {
            this.f1221x.m2353b(this.f1222y);
        }
        this.f1221x = ajVar;
        if (z && ajVar != null) {
            if (this.f1222y == null) {
                this.f1222y = new C0242b();
            }
            ajVar.m2344a(this.f1222y);
        }
        m1850c();
    }

    private void m1850c() {
        m1873b();
        if (this.f1221x != null) {
            int i;
            int b = this.f1221x.mo1273b();
            for (i = 0; i < b; i++) {
                m1872a(m1868a().m1806a(this.f1221x.mo2186b(i)), false);
            }
            if (this.f1220w != null && b > 0) {
                i = this.f1220w.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    m1874b(m1869a(i));
                    return;
                }
                return;
            }
            return;
        }
        m1873b();
    }

    private void m1854d() {
        int size = this.f1199b.size();
        for (int i = 0; i < size; i++) {
            ((C0244d) this.f1199b.get(i)).m1801g();
        }
    }

    private C0247f m1849c(C0244d c0244d) {
        C0247f c0247f = this.f1198A != null ? (C0247f) this.f1198A.mo428a() : null;
        if (c0247f == null) {
            c0247f = new C0247f(this, getContext());
        }
        c0247f.m1823a(c0244d);
        c0247f.setFocusable(true);
        c0247f.setMinimumWidth(getTabMinWidth());
        return c0247f;
    }

    private void m1837a(C0244d c0244d, int i) {
        c0244d.m1809b(i);
        this.f1199b.add(i, c0244d);
        int size = this.f1199b.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((C0244d) this.f1199b.get(i2)).m1809b(i2);
        }
    }

    private void m1852c(C0244d c0244d, boolean z) {
        View d = c0244d.f1184h;
        this.f1201d.addView(d, m1857e());
        if (z) {
            d.setSelected(true);
        }
    }

    public void addView(View view) {
        m1842a(view);
    }

    public void addView(View view, int i) {
        m1842a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m1842a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m1842a(view);
    }

    private void m1842a(View view) {
        if (view instanceof au) {
            m1840a((au) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LayoutParams m1857e() {
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        m1843a(layoutParams);
        return layoutParams;
    }

    private void m1843a(LayoutParams layoutParams) {
        if (this.f1217t == 1 && this.f1216s == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int m1845b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int b = (m1845b(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(b, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(b, 1073741824);
                break;
        }
        b = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.f1213p > 0) {
                b = this.f1213p;
            } else {
                b -= m1845b(56);
            }
            this.f1211n = b;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.f1217t) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        b = 0;
                        break;
                    } else {
                        b = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    b = i3;
                    break;
                default:
                    b = 0;
                    break;
            }
            if (b != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void m1851c(int i) {
        C0247f c0247f = (C0247f) this.f1201d.getChildAt(i);
        this.f1201d.removeViewAt(i);
        if (c0247f != null) {
            c0247f.m1827b();
            this.f1198A.mo429a(c0247f);
        }
        requestLayout();
    }

    private void m1855d(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ao.m3895G(this) || this.f1201d.m1792a()) {
                m1870a(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a = m1832a(i, 0.0f);
            if (scrollX != a) {
                if (this.f1219v == null) {
                    this.f1219v = br.m2095a();
                    this.f1219v.m2040a(C0252a.f1253b);
                    this.f1219v.m2036a(300);
                    this.f1219v.m2039a(new av(this));
                }
                this.f1219v.m2037a(scrollX, a);
                this.f1219v.m2034a();
            }
            this.f1201d.m1791a(i, 300);
        }
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f1201d.getChildCount();
        if (i < childCount && !this.f1201d.getChildAt(i).isSelected()) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.f1201d.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    void m1874b(C0244d c0244d) {
        m1875b(c0244d, true);
    }

    void m1875b(C0244d c0244d, boolean z) {
        if (this.f1200c != c0244d) {
            if (z) {
                int c = c0244d != null ? c0244d.m1810c() : -1;
                if (c != -1) {
                    setSelectedTabView(c);
                }
                if ((this.f1200c == null || this.f1200c.m1810c() == -1) && c != -1) {
                    m1870a(c, 0.0f, true);
                } else {
                    m1855d(c);
                }
            }
            if (!(this.f1200c == null || this.f1218u == null)) {
                this.f1218u.mo217b(this.f1200c);
            }
            this.f1200c = c0244d;
            if (this.f1200c != null && this.f1218u != null) {
                this.f1218u.mo216a(this.f1200c);
            }
        } else if (this.f1200c != null) {
            if (this.f1218u != null) {
                this.f1218u.mo218c(this.f1200c);
            }
            m1855d(c0244d.m1810c());
        }
    }

    private int m1832a(int i, float f) {
        int i2 = 0;
        if (this.f1217t != 0) {
            return 0;
        }
        int width;
        View childAt = this.f1201d.getChildAt(i);
        View childAt2 = i + 1 < this.f1201d.getChildCount() ? this.f1201d.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void m1859f() {
        int max;
        if (this.f1217t == 0) {
            max = Math.max(0, this.f1215r - this.f1202e);
        } else {
            max = 0;
        }
        ao.m3905a(this.f1201d, max, 0, 0, 0);
        switch (this.f1217t) {
            case 0:
                this.f1201d.setGravity(8388611);
                break;
            case 1:
                this.f1201d.setGravity(1);
                break;
        }
        m1844a(true);
    }

    private void m1844a(boolean z) {
        for (int i = 0; i < this.f1201d.getChildCount(); i++) {
            View childAt = this.f1201d.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            m1843a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList m1835a(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.f1199b.size();
        for (int i = 0; i < size; i++) {
            C0244d c0244d = (C0244d) this.f1199b.get(i);
            if (c0244d != null && c0244d.m1808b() != null && !TextUtils.isEmpty(c0244d.m1811d())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.f1212o != -1) {
            return this.f1212o;
        }
        return this.f1217t == 0 ? this.f1214q : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    private int getTabMaxWidth() {
        return this.f1211n;
    }
}
