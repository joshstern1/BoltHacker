package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.p028b.C0842a.C0831a;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.p028b.C0842a.C0841k;
import android.support.v7.view.menu.C0195u.C0194a;
import android.support.v7.widget.de;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0194a {
    private C0882m f2878a;
    private ImageView f2879b;
    private RadioButton f2880c;
    private TextView f2881d;
    private CheckBox f2882e;
    private TextView f2883f;
    private ImageView f2884g;
    private Drawable f2885h;
    private int f2886i;
    private Context f2887j;
    private boolean f2888k;
    private Drawable f2889l;
    private int f2890m;
    private LayoutInflater f2891n;
    private boolean f2892o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        de a = de.m7066a(getContext(), attributeSet, C0841k.MenuView, i, 0);
        this.f2885h = a.m7069a(C0841k.MenuView_android_itemBackground);
        this.f2886i = a.m7082g(C0841k.MenuView_android_itemTextAppearance, -1);
        this.f2888k = a.m7071a(C0841k.MenuView_preserveIconSpacing, false);
        this.f2887j = context;
        this.f2889l = a.m7069a(C0841k.MenuView_subMenuArrow);
        a.m7070a();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f2885h);
        this.f2881d = (TextView) findViewById(C0836f.title);
        if (this.f2886i != -1) {
            this.f2881d.setTextAppearance(this.f2887j, this.f2886i);
        }
        this.f2883f = (TextView) findViewById(C0836f.shortcut);
        this.f2884g = (ImageView) findViewById(C0836f.submenuarrow);
        if (this.f2884g != null) {
            this.f2884g.setImageDrawable(this.f2889l);
        }
    }

    public void mo130a(C0882m c0882m, int i) {
        this.f2878a = c0882m;
        this.f2890m = i;
        setVisibility(c0882m.isVisible() ? 0 : 8);
        setTitle(c0882m.m5700a((C0194a) this));
        setCheckable(c0882m.isCheckable());
        m5580a(c0882m.m5713f(), c0882m.m5709d());
        setIcon(c0882m.getIcon());
        setEnabled(c0882m.isEnabled());
        setSubMenuArrowVisible(c0882m.hasSubMenu());
    }

    public void setForceShowIcon(boolean z) {
        this.f2892o = z;
        this.f2888k = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2881d.setText(charSequence);
            if (this.f2881d.getVisibility() != 0) {
                this.f2881d.setVisibility(0);
            }
        } else if (this.f2881d.getVisibility() != 8) {
            this.f2881d.setVisibility(8);
        }
    }

    public C0882m getItemData() {
        return this.f2878a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f2880c != null || this.f2882e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f2878a.m5714g()) {
                if (this.f2880c == null) {
                    m5577c();
                }
                compoundButton = this.f2880c;
                compoundButton2 = this.f2882e;
            } else {
                if (this.f2882e == null) {
                    m5578d();
                }
                compoundButton = this.f2882e;
                compoundButton2 = this.f2880c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f2878a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f2882e != null) {
                this.f2882e.setVisibility(8);
            }
            if (this.f2880c != null) {
                this.f2880c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2878a.m5714g()) {
            if (this.f2880c == null) {
                m5577c();
            }
            compoundButton = this.f2880c;
        } else {
            if (this.f2882e == null) {
                m5578d();
            }
            compoundButton = this.f2882e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f2884g != null) {
            this.f2884g.setVisibility(z ? 0 : 8);
        }
    }

    public void m5580a(boolean z, char c) {
        int i = (z && this.f2878a.m5713f()) ? 0 : 8;
        if (i == 0) {
            this.f2883f.setText(this.f2878a.m5711e());
        }
        if (this.f2883f.getVisibility() != i) {
            this.f2883f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f2878a.m5716i() || this.f2892o) ? 1 : 0;
        if (i == 0 && !this.f2888k) {
            return;
        }
        if (this.f2879b != null || drawable != null || this.f2888k) {
            if (this.f2879b == null) {
                m5576a();
            }
            if (drawable != null || this.f2888k) {
                ImageView imageView = this.f2879b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f2879b.getVisibility() != 0) {
                    this.f2879b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f2879b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f2879b != null && this.f2888k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2879b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m5576a() {
        this.f2879b = (ImageView) getInflater().inflate(C0838h.abc_list_menu_item_icon, this, false);
        addView(this.f2879b, 0);
    }

    private void m5577c() {
        this.f2880c = (RadioButton) getInflater().inflate(C0838h.abc_list_menu_item_radio, this, false);
        addView(this.f2880c);
    }

    private void m5578d() {
        this.f2882e = (CheckBox) getInflater().inflate(C0838h.abc_list_menu_item_checkbox, this, false);
        addView(this.f2882e);
    }

    public boolean mo131b() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f2891n == null) {
            this.f2891n = LayoutInflater.from(getContext());
        }
        return this.f2891n;
    }
}
