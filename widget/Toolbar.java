package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p017e.C0468d;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.C0645j;
import android.support.v4.view.C0667t;
import android.support.v4.view.C0675w;
import android.support.v4.view.C0684z;
import android.support.v4.view.ao;
import android.support.v7.p027a.C0760a.C0757a;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.C0852c;
import android.support.v7.view.C0859g;
import android.support.v7.view.menu.C0197k;
import android.support.v7.view.menu.C0197k.C0253a;
import android.support.v7.view.menu.C0211t;
import android.support.v7.view.menu.C0211t.C0770a;
import android.support.v7.view.menu.C0882m;
import android.support.v7.view.menu.aa;
import android.support.v7.widget.ActionMenuView.C0908e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int f3543A;
    private boolean f3544B;
    private boolean f3545C;
    private final ArrayList<View> f3546D;
    private final ArrayList<View> f3547E;
    private final int[] f3548F;
    private C0776c f3549G;
    private final C0908e f3550H;
    private dj f3551I;
    private ActionMenuPresenter f3552J;
    private C0953a f3553K;
    private C0770a f3554L;
    private C0253a f3555M;
    private boolean f3556N;
    private final Runnable f3557O;
    private final C1011w f3558P;
    View f3559a;
    private ActionMenuView f3560b;
    private TextView f3561c;
    private TextView f3562d;
    private ImageButton f3563e;
    private ImageView f3564f;
    private Drawable f3565g;
    private CharSequence f3566h;
    private ImageButton f3567i;
    private Context f3568j;
    private int f3569k;
    private int f3570l;
    private int f3571m;
    private int f3572n;
    private int f3573o;
    private int f3574p;
    private int f3575q;
    private int f3576r;
    private int f3577s;
    private final cc f3578t;
    private int f3579u;
    private int f3580v;
    private int f3581w;
    private CharSequence f3582x;
    private CharSequence f3583y;
    private int f3584z;

    public interface C0776c {
        boolean mo752a(MenuItem menuItem);
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = C0468d.m3057a(new di());
        int f3537b;
        boolean f3538c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3537b = parcel.readInt();
            this.f3538c = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3537b);
            parcel.writeInt(this.f3538c ? 1 : 0);
        }
    }

    private class C0953a implements C0211t {
        C0197k f3539a;
        C0882m f3540b;
        final /* synthetic */ Toolbar f3541c;

        private C0953a(Toolbar toolbar) {
            this.f3541c = toolbar;
        }

        public void mo149a(Context context, C0197k c0197k) {
            if (!(this.f3539a == null || this.f3540b == null)) {
                this.f3539a.mo166d(this.f3540b);
            }
            this.f3539a = c0197k;
        }

        public void mo153a(boolean z) {
            Object obj = null;
            if (this.f3540b != null) {
                if (this.f3539a != null) {
                    int size = this.f3539a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f3539a.getItem(i) == this.f3540b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo158b(this.f3539a, this.f3540b);
                }
            }
        }

        public void mo152a(C0770a c0770a) {
        }

        public boolean mo155a(aa aaVar) {
            return false;
        }

        public void mo151a(C0197k c0197k, boolean z) {
        }

        public boolean mo154a() {
            return false;
        }

        public boolean mo156a(C0197k c0197k, C0882m c0882m) {
            this.f3541c.m6668p();
            if (this.f3541c.f3567i.getParent() != this.f3541c) {
                this.f3541c.addView(this.f3541c.f3567i);
            }
            this.f3541c.f3559a = c0882m.getActionView();
            this.f3540b = c0882m;
            if (this.f3541c.f3559a.getParent() != this.f3541c) {
                LayoutParams i = this.f3541c.m6686i();
                i.a = 8388611 | (this.f3541c.f3572n & 112);
                i.f3542b = 2;
                this.f3541c.f3559a.setLayoutParams(i);
                this.f3541c.addView(this.f3541c.f3559a);
            }
            this.f3541c.m6687j();
            this.f3541c.requestLayout();
            c0882m.m5712e(true);
            if (this.f3541c.f3559a instanceof C0852c) {
                ((C0852c) this.f3541c.f3559a).mo879a();
            }
            return true;
        }

        public boolean mo158b(C0197k c0197k, C0882m c0882m) {
            if (this.f3541c.f3559a instanceof C0852c) {
                ((C0852c) this.f3541c.f3559a).mo880b();
            }
            this.f3541c.removeView(this.f3541c.f3559a);
            this.f3541c.removeView(this.f3541c.f3567i);
            this.f3541c.f3559a = null;
            this.f3541c.m6688k();
            this.f3540b = null;
            this.f3541c.requestLayout();
            c0882m.m5712e(false);
            return true;
        }

        public int mo157b() {
            return 0;
        }

        public Parcelable mo159c() {
            return null;
        }

        public void mo150a(Parcelable parcelable) {
        }
    }

    public static class C0954b extends C0757a {
        int f3542b;

        public C0954b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3542b = 0;
        }

        public C0954b(int i, int i2) {
            super(i, i2);
            this.f3542b = 0;
            this.a = 8388627;
        }

        public C0954b(C0954b c0954b) {
            super((C0757a) c0954b);
            this.f3542b = 0;
            this.f3542b = c0954b.f3542b;
        }

        public C0954b(C0757a c0757a) {
            super(c0757a);
            this.f3542b = 0;
        }

        public C0954b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f3542b = 0;
            m6645a(marginLayoutParams);
        }

        public C0954b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3542b = 0;
        }

        void m6645a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m6686i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m6671a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m6672a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3578t = new cc();
        this.f3581w = 8388627;
        this.f3546D = new ArrayList();
        this.f3547E = new ArrayList();
        this.f3548F = new int[2];
        this.f3550H = new df(this);
        this.f3557O = new dg(this);
        de a = de.m7066a(getContext(), attributeSet, C0841k.Toolbar, i, 0);
        this.f3570l = a.m7082g(C0841k.Toolbar_titleTextAppearance, 0);
        this.f3571m = a.m7082g(C0841k.Toolbar_subtitleTextAppearance, 0);
        this.f3581w = a.m7074c(C0841k.Toolbar_android_gravity, this.f3581w);
        this.f3572n = a.m7074c(C0841k.Toolbar_buttonGravity, 48);
        int d = a.m7076d(C0841k.Toolbar_titleMargin, 0);
        if (a.m7083g(C0841k.Toolbar_titleMargins)) {
            d = a.m7076d(C0841k.Toolbar_titleMargins, d);
        }
        this.f3577s = d;
        this.f3576r = d;
        this.f3575q = d;
        this.f3574p = d;
        d = a.m7076d(C0841k.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f3574p = d;
        }
        d = a.m7076d(C0841k.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f3575q = d;
        }
        d = a.m7076d(C0841k.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f3576r = d;
        }
        d = a.m7076d(C0841k.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f3577s = d;
        }
        this.f3573o = a.m7078e(C0841k.Toolbar_maxButtonHeight, -1);
        d = a.m7076d(C0841k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m7076d(C0841k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f3578t.m7002b(a.m7078e(C0841k.Toolbar_contentInsetLeft, 0), a.m7078e(C0841k.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f3578t.m6999a(d, d2);
        }
        this.f3579u = a.m7076d(C0841k.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f3580v = a.m7076d(C0841k.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f3565g = a.m7069a(C0841k.Toolbar_collapseIcon);
        this.f3566h = a.m7075c(C0841k.Toolbar_collapseContentDescription);
        CharSequence c = a.m7075c(C0841k.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m7075c(C0841k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f3568j = getContext();
        setPopupTheme(a.m7082g(C0841k.Toolbar_popupTheme, 0));
        Drawable a2 = a.m7069a(C0841k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m7075c(C0841k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m7069a(C0841k.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m7075c(C0841k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m7083g(C0841k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m7072b(C0841k.Toolbar_titleTextColor, -1));
        }
        if (a.m7083g(C0841k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m7072b(C0841k.Toolbar_subtitleTextColor, -1));
        }
        a.m7070a();
        this.f3558P = C1011w.m7254a();
    }

    public void setPopupTheme(int i) {
        if (this.f3569k != i) {
            this.f3569k = i;
            if (i == 0) {
                this.f3568j = getContext();
            } else {
                this.f3568j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f3569k;
    }

    public int getTitleMarginStart() {
        return this.f3574p;
    }

    public void setTitleMarginStart(int i) {
        this.f3574p = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.f3576r;
    }

    public void setTitleMarginTop(int i) {
        this.f3576r = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.f3575q;
    }

    public void setTitleMarginEnd(int i) {
        this.f3575q = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.f3577s;
    }

    public void setTitleMarginBottom(int i) {
        this.f3577s = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        cc ccVar = this.f3578t;
        if (i != 1) {
            z = false;
        }
        ccVar.m7000a(z);
    }

    public void setLogo(int i) {
        setLogo(this.f3558P.m7272a(getContext(), i));
    }

    public boolean m6677a() {
        return getVisibility() == 0 && this.f3560b != null && this.f3560b.m5889a();
    }

    public boolean m6679b() {
        return this.f3560b != null && this.f3560b.m5899g();
    }

    public boolean m6680c() {
        return this.f3560b != null && this.f3560b.m5900h();
    }

    public boolean m6681d() {
        return this.f3560b != null && this.f3560b.m5897e();
    }

    public boolean m6682e() {
        return this.f3560b != null && this.f3560b.m5898f();
    }

    public void m6675a(C0197k c0197k, ActionMenuPresenter actionMenuPresenter) {
        if (c0197k != null || this.f3560b != null) {
            m6666n();
            C0197k d = this.f3560b.m5896d();
            if (d != c0197k) {
                if (d != null) {
                    d.m1305b(this.f3552J);
                    d.m1305b(this.f3553K);
                }
                if (this.f3553K == null) {
                    this.f3553K = new C0953a();
                }
                actionMenuPresenter.m5868d(true);
                if (c0197k != null) {
                    c0197k.m1295a((C0211t) actionMenuPresenter, this.f3568j);
                    c0197k.m1295a(this.f3553K, this.f3568j);
                } else {
                    actionMenuPresenter.mo149a(this.f3568j, null);
                    this.f3553K.mo149a(this.f3568j, null);
                    actionMenuPresenter.mo153a(true);
                    this.f3553K.mo153a(true);
                }
                this.f3560b.setPopupTheme(this.f3569k);
                this.f3560b.setPresenter(actionMenuPresenter);
                this.f3552J = actionMenuPresenter;
            }
        }
    }

    public void m6683f() {
        if (this.f3560b != null) {
            this.f3560b.m5901i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m6664l();
            if (!m6663d(this.f3564f)) {
                m6653a(this.f3564f, true);
            }
        } else if (this.f3564f != null && m6663d(this.f3564f)) {
            removeView(this.f3564f);
            this.f3547E.remove(this.f3564f);
        }
        if (this.f3564f != null) {
            this.f3564f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f3564f != null ? this.f3564f.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m6664l();
        }
        if (this.f3564f != null) {
            this.f3564f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f3564f != null ? this.f3564f.getContentDescription() : null;
    }

    private void m6664l() {
        if (this.f3564f == null) {
            this.f3564f = new ImageView(getContext());
        }
    }

    public boolean m6684g() {
        return (this.f3553K == null || this.f3553K.f3540b == null) ? false : true;
    }

    public void m6685h() {
        C0882m c0882m = this.f3553K == null ? null : this.f3553K.f3540b;
        if (c0882m != null) {
            c0882m.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f3582x;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f3561c == null) {
                Context context = getContext();
                this.f3561c = new TextView(context);
                this.f3561c.setSingleLine();
                this.f3561c.setEllipsize(TruncateAt.END);
                if (this.f3570l != 0) {
                    this.f3561c.setTextAppearance(context, this.f3570l);
                }
                if (this.f3584z != 0) {
                    this.f3561c.setTextColor(this.f3584z);
                }
            }
            if (!m6663d(this.f3561c)) {
                m6653a(this.f3561c, true);
            }
        } else if (this.f3561c != null && m6663d(this.f3561c)) {
            removeView(this.f3561c);
            this.f3547E.remove(this.f3561c);
        }
        if (this.f3561c != null) {
            this.f3561c.setText(charSequence);
        }
        this.f3582x = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f3583y;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f3562d == null) {
                Context context = getContext();
                this.f3562d = new TextView(context);
                this.f3562d.setSingleLine();
                this.f3562d.setEllipsize(TruncateAt.END);
                if (this.f3571m != 0) {
                    this.f3562d.setTextAppearance(context, this.f3571m);
                }
                if (this.f3543A != 0) {
                    this.f3562d.setTextColor(this.f3543A);
                }
            }
            if (!m6663d(this.f3562d)) {
                m6653a(this.f3562d, true);
            }
        } else if (this.f3562d != null && m6663d(this.f3562d)) {
            removeView(this.f3562d);
            this.f3547E.remove(this.f3562d);
        }
        if (this.f3562d != null) {
            this.f3562d.setText(charSequence);
        }
        this.f3583y = charSequence;
    }

    public void m6674a(Context context, int i) {
        this.f3570l = i;
        if (this.f3561c != null) {
            this.f3561c.setTextAppearance(context, i);
        }
    }

    public void m6678b(Context context, int i) {
        this.f3571m = i;
        if (this.f3562d != null) {
            this.f3562d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f3584z = i;
        if (this.f3561c != null) {
            this.f3561c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f3543A = i;
        if (this.f3562d != null) {
            this.f3562d.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.f3563e != null ? this.f3563e.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m6667o();
        }
        if (this.f3563e != null) {
            this.f3563e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f3558P.m7272a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m6667o();
            if (!m6663d(this.f3563e)) {
                m6653a(this.f3563e, true);
            }
        } else if (this.f3563e != null && m6663d(this.f3563e)) {
            removeView(this.f3563e);
            this.f3547E.remove(this.f3563e);
        }
        if (this.f3563e != null) {
            this.f3563e.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.f3563e != null ? this.f3563e.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m6667o();
        this.f3563e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m6665m();
        return this.f3560b.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m6665m();
        this.f3560b.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m6665m();
        return this.f3560b.getOverflowIcon();
    }

    private void m6665m() {
        m6666n();
        if (this.f3560b.m5896d() == null) {
            C0197k c0197k = (C0197k) this.f3560b.getMenu();
            if (this.f3553K == null) {
                this.f3553K = new C0953a();
            }
            this.f3560b.setExpandedActionViewsExclusive(true);
            c0197k.m1295a(this.f3553K, this.f3568j);
        }
    }

    private void m6666n() {
        if (this.f3560b == null) {
            this.f3560b = new ActionMenuView(getContext());
            this.f3560b.setPopupTheme(this.f3569k);
            this.f3560b.setOnMenuItemClickListener(this.f3550H);
            this.f3560b.m5888a(this.f3554L, this.f3555M);
            LayoutParams i = m6686i();
            i.a = 8388613 | (this.f3572n & 112);
            this.f3560b.setLayoutParams(i);
            m6653a(this.f3560b, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0859g(getContext());
    }

    public void setOnMenuItemClickListener(C0776c c0776c) {
        this.f3549G = c0776c;
    }

    public void m6673a(int i, int i2) {
        this.f3578t.m6999a(i, i2);
    }

    public int getContentInsetStart() {
        return this.f3578t.m7003c();
    }

    public int getContentInsetEnd() {
        return this.f3578t.m7004d();
    }

    public int getContentInsetLeft() {
        return this.f3578t.m6998a();
    }

    public int getContentInsetRight() {
        return this.f3578t.m7001b();
    }

    public int getContentInsetStartWithNavigation() {
        if (this.f3579u != Integer.MIN_VALUE) {
            return this.f3579u;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f3579u) {
            this.f3579u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.f3580v != Integer.MIN_VALUE) {
            return this.f3580v;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f3580v) {
            this.f3580v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f3579u, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.f3560b != null) {
            C0197k d = this.f3560b.m5896d();
            i = (d == null || !d.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return Math.max(getContentInsetEnd(), Math.max(this.f3580v, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ao.m3938h(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ao.m3938h(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void m6667o() {
        if (this.f3563e == null) {
            this.f3563e = new ImageButton(getContext(), null, C0831a.toolbarNavigationButtonStyle);
            LayoutParams i = m6686i();
            i.a = 8388611 | (this.f3572n & 112);
            this.f3563e.setLayoutParams(i);
        }
    }

    private void m6668p() {
        if (this.f3567i == null) {
            this.f3567i = new ImageButton(getContext(), null, C0831a.toolbarNavigationButtonStyle);
            this.f3567i.setImageDrawable(this.f3565g);
            this.f3567i.setContentDescription(this.f3566h);
            LayoutParams i = m6686i();
            i.a = 8388611 | (this.f3572n & 112);
            i.f3542b = 2;
            this.f3567i.setLayoutParams(i);
            this.f3567i.setOnClickListener(new dh(this));
        }
    }

    private void m6653a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m6686i();
        } else if (checkLayoutParams(layoutParams)) {
            C0954b c0954b = (C0954b) layoutParams;
        } else {
            layoutParams = m6672a(layoutParams);
        }
        layoutParams.f3542b = 1;
        if (!z || this.f3559a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f3547E.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f3553K == null || this.f3553K.f3540b == null)) {
            savedState.f3537b = this.f3553K.f3540b.getItemId();
        }
        savedState.f3538c = m6679b();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.m3182a());
            Menu d = this.f3560b != null ? this.f3560b.m5896d() : null;
            if (!(savedState.f3537b == 0 || this.f3553K == null || d == null)) {
                MenuItem findItem = d.findItem(savedState.f3537b);
                if (findItem != null) {
                    C0675w.m4368b(findItem);
                }
            }
            if (savedState.f3538c) {
                m6669q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void m6669q() {
        removeCallbacks(this.f3557O);
        post(this.f3557O);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3557O);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0684z.m4397a(motionEvent);
        if (a == 0) {
            this.f3544B = false;
        }
        if (!this.f3544B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f3544B = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f3544B = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0684z.m4397a(motionEvent);
        if (a == 9) {
            this.f3545C = false;
        }
        if (!this.f3545C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f3545C = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f3545C = false;
        }
        return true;
    }

    private void m6652a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int m6648a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean m6670r() {
        if (!this.f3556N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m6655a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f3548F;
        if (C0983do.m7164a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m6655a(this.f3563e)) {
            m6652a(this.f3563e, i, 0, i2, 0, this.f3573o);
            i7 = this.f3563e.getMeasuredWidth() + m6657b(this.f3563e);
            max = Math.max(0, this.f3563e.getMeasuredHeight() + m6660c(this.f3563e));
            i6 = C0983do.m7162a(0, ao.m3942l(this.f3563e));
            i5 = max;
        }
        if (m6655a(this.f3567i)) {
            m6652a(this.f3567i, i, 0, i2, 0, this.f3573o);
            i7 = this.f3567i.getMeasuredWidth() + m6657b(this.f3567i);
            i5 = Math.max(i5, this.f3567i.getMeasuredHeight() + m6660c(this.f3567i));
            i6 = C0983do.m7162a(i6, ao.m3942l(this.f3567i));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (m6655a(this.f3560b)) {
            m6652a(this.f3560b, i, max2, i2, 0, this.f3573o);
            i7 = this.f3560b.getMeasuredWidth() + m6657b(this.f3560b);
            i5 = Math.max(i5, this.f3560b.getMeasuredHeight() + m6660c(this.f3560b));
            i6 = C0983do.m7162a(i6, ao.m3942l(this.f3560b));
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (m6655a(this.f3559a)) {
            max2 += m6648a(this.f3559a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f3559a.getMeasuredHeight() + m6660c(this.f3559a));
            i6 = C0983do.m7162a(i6, ao.m3942l(this.f3559a));
        }
        if (m6655a(this.f3564f)) {
            max2 += m6648a(this.f3564f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f3564f.getMeasuredHeight() + m6660c(this.f3564f));
            i6 = C0983do.m7162a(i6, ao.m3942l(this.f3564f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0954b) childAt.getLayoutParams()).f3542b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (m6655a(childAt)) {
                max2 += m6648a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m6660c(childAt));
                i7 = C0983do.m7162a(i5, ao.m3942l(childAt));
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.f3576r + this.f3577s;
        max = this.f3574p + this.f3575q;
        if (m6655a(this.f3561c)) {
            m6648a(this.f3561c, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = m6657b(this.f3561c) + this.f3561c.getMeasuredWidth();
            i7 = this.f3561c.getMeasuredHeight() + m6660c(this.f3561c);
            i5 = C0983do.m7162a(i5, ao.m3942l(this.f3561c));
        }
        if (m6655a(this.f3562d)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, m6648a(this.f3562d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f3562d.getMeasuredHeight() + m6660c(this.f3562d);
            i5 = C0983do.m7162a(i5, ao.m3942l(this.f3562d));
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = ao.m3900a(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ao.m3900a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m6670r()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int measuredHeight;
        int measuredWidth;
        if (ao.m3938h(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = width - paddingRight;
        int[] iArr = this.f3548F;
        iArr[1] = 0;
        iArr[0] = 0;
        int s = ao.m3949s(this);
        if (!m6655a(this.f3563e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i6 = m6658b(this.f3563e, i6, iArr, s);
            i5 = paddingLeft;
        } else {
            i5 = m6649a(this.f3563e, paddingLeft, iArr, s);
        }
        if (m6655a(this.f3567i)) {
            if (obj != null) {
                i6 = m6658b(this.f3567i, i6, iArr, s);
            } else {
                i5 = m6649a(this.f3567i, i5, iArr, s);
            }
        }
        if (m6655a(this.f3560b)) {
            if (obj != null) {
                i5 = m6649a(this.f3560b, i5, iArr, s);
            } else {
                i6 = m6658b(this.f3560b, i6, iArr, s);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - i6));
        i5 = Math.max(i5, currentContentInsetLeft);
        i6 = Math.min(i6, (width - paddingRight) - currentContentInsetRight);
        if (m6655a(this.f3559a)) {
            if (obj != null) {
                i6 = m6658b(this.f3559a, i6, iArr, s);
            } else {
                i5 = m6649a(this.f3559a, i5, iArr, s);
            }
        }
        if (!m6655a(this.f3564f)) {
            currentContentInsetLeft = i6;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = m6658b(this.f3564f, i6, iArr, s);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = i6;
            currentContentInsetRight = m6649a(this.f3564f, i5, iArr, s);
        }
        boolean a = m6655a(this.f3561c);
        boolean a2 = m6655a(this.f3562d);
        i5 = 0;
        if (a) {
            C0954b c0954b = (C0954b) this.f3561c.getLayoutParams();
            i5 = 0 + (c0954b.bottomMargin + (c0954b.topMargin + this.f3561c.getMeasuredHeight()));
        }
        if (a2) {
            c0954b = (C0954b) this.f3562d.getLayoutParams();
            measuredHeight = (c0954b.bottomMargin + (c0954b.topMargin + this.f3562d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0954b = (C0954b) (a ? this.f3561c : this.f3562d).getLayoutParams();
            C0954b c0954b2 = (C0954b) (a2 ? this.f3562d : this.f3561c).getLayoutParams();
            Object obj2 = ((!a || this.f3561c.getMeasuredWidth() <= 0) && (!a2 || this.f3562d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f3581w & 112) {
                case 48:
                    paddingTop2 = (c0954b.topMargin + getPaddingTop()) + this.f3576r;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - c0954b2.bottomMargin) - this.f3577s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0954b.topMargin + this.f3576r) {
                        i6 = c0954b.topMargin + this.f3576r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < c0954b.bottomMargin + this.f3577s) {
                            i6 = Math.max(0, paddingTop2 - ((c0954b2.bottomMargin + this.f3577s) - measuredHeight));
                        } else {
                            i6 = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + i6;
                    break;
            }
            if (obj != null) {
                i6 = (obj2 != null ? this.f3574p : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, i6);
                iArr[1] = Math.max(0, -i6);
                if (a) {
                    c0954b = (C0954b) this.f3561c.getLayoutParams();
                    measuredWidth = i5 - this.f3561c.getMeasuredWidth();
                    currentContentInsetLeft = this.f3561c.getMeasuredHeight() + paddingTop2;
                    this.f3561c.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + c0954b.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.f3575q;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    c0954b = (C0954b) this.f3562d.getLayoutParams();
                    measuredWidth = c0954b.topMargin + paddingTop2;
                    measuredHeight = this.f3562d.getMeasuredHeight() + measuredWidth;
                    this.f3562d.layout(i5 - this.f3562d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i6 = c0954b.bottomMargin + measuredHeight;
                    i6 = i5 - this.f3575q;
                } else {
                    i6 = i5;
                }
                if (obj2 != null) {
                    i6 = Math.min(currentContentInsetLeft, i6);
                } else {
                    i6 = i5;
                }
                currentContentInsetLeft = i6;
            } else {
                i6 = (obj2 != null ? this.f3574p : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, i6);
                iArr[0] = Math.max(0, -i6);
                if (a) {
                    c0954b = (C0954b) this.f3561c.getLayoutParams();
                    i5 = this.f3561c.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.f3561c.getMeasuredHeight() + paddingTop2;
                    this.f3561c.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    i6 = c0954b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f3575q;
                    i5 = i6;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0954b = (C0954b) this.f3562d.getLayoutParams();
                    i5 += c0954b.topMargin;
                    paddingTop2 = this.f3562d.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.f3562d.getMeasuredHeight() + i5;
                    this.f3562d.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    i6 = c0954b.bottomMargin + measuredHeight;
                    i6 = this.f3575q + paddingTop2;
                } else {
                    i6 = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, i6);
                }
            }
        }
        m6654a(this.f3546D, 3);
        int size = this.f3546D.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m6649a((View) this.f3546D.get(measuredWidth), i5, iArr, s);
        }
        m6654a(this.f3546D, 5);
        currentContentInsetRight = this.f3546D.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = m6658b((View) this.f3546D.get(measuredWidth), currentContentInsetLeft, iArr, s);
        }
        m6654a(this.f3546D, 1);
        measuredWidth = m6650a(this.f3546D, iArr);
        i6 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i6;
        if (i6 < i5) {
            i6 = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            i6 -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.f3546D.size();
        measuredWidth = i6;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m6649a((View) this.f3546D.get(i5), measuredWidth, iArr, s);
        }
        this.f3546D.clear();
    }

    private int m6650a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0954b c0954b = (C0954b) view.getLayoutParams();
            i6 = c0954b.leftMargin - i6;
            i = c0954b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int m6649a(View view, int i, int[] iArr, int i2) {
        C0954b c0954b = (C0954b) view.getLayoutParams();
        int i3 = c0954b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m6647a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0954b.rightMargin + measuredWidth) + max;
    }

    private int m6658b(View view, int i, int[] iArr, int i2) {
        C0954b c0954b = (C0954b) view.getLayoutParams();
        int i3 = c0954b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m6647a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0954b.leftMargin + measuredWidth);
    }

    private int m6647a(View view, int i) {
        C0954b c0954b = (C0954b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m6646a(c0954b.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0954b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0954b.topMargin) {
                    i3 = c0954b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0954b.bottomMargin ? Math.max(0, i2 - (c0954b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m6646a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f3581w & 112;
        }
    }

    private void m6654a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ao.m3938h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0645j.m4290a(i, ao.m3938h(this));
        list.clear();
        C0954b c0954b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0954b = (C0954b) childAt.getLayoutParams();
                if (c0954b.f3542b == 0 && m6655a(childAt) && m6656b(c0954b.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0954b = (C0954b) childAt2.getLayoutParams();
            if (c0954b.f3542b == 0 && m6655a(childAt2) && m6656b(c0954b.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int m6656b(int i) {
        int h = ao.m3938h(this);
        int a = C0645j.m4290a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private boolean m6655a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m6657b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0667t.m4338b(marginLayoutParams) + C0667t.m4337a(marginLayoutParams);
    }

    private int m6660c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public C0954b m6671a(AttributeSet attributeSet) {
        return new C0954b(getContext(), attributeSet);
    }

    protected C0954b m6672a(LayoutParams layoutParams) {
        if (layoutParams instanceof C0954b) {
            return new C0954b((C0954b) layoutParams);
        }
        if (layoutParams instanceof C0757a) {
            return new C0954b((C0757a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0954b((MarginLayoutParams) layoutParams);
        }
        return new C0954b(layoutParams);
    }

    protected C0954b m6686i() {
        return new C0954b(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0954b);
    }

    public ap getWrapper() {
        if (this.f3551I == null) {
            this.f3551I = new dj(this, true);
        }
        return this.f3551I;
    }

    void m6687j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0954b) childAt.getLayoutParams()).f3542b == 2 || childAt == this.f3560b)) {
                removeViewAt(childCount);
                this.f3547E.add(childAt);
            }
        }
    }

    void m6688k() {
        for (int size = this.f3547E.size() - 1; size >= 0; size--) {
            addView((View) this.f3547E.get(size));
        }
        this.f3547E.clear();
    }

    private boolean m6663d(View view) {
        return view.getParent() == this || this.f3547E.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f3556N = z;
        requestLayout();
    }

    public void m6676a(C0770a c0770a, C0253a c0253a) {
        this.f3554L = c0770a;
        this.f3555M = c0253a;
        if (this.f3560b != null) {
            this.f3560b.m5888a(c0770a, c0253a);
        }
    }
}
