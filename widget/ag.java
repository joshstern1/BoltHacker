package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p013c.p014a.C0441a;
import android.support.v4.view.ao;
import android.support.v7.p028b.C0842a.C0841k;
import android.util.AttributeSet;
import android.widget.SeekBar;

class ag extends ad {
    private final SeekBar f3610b;
    private Drawable f3611c;
    private ColorStateList f3612d = null;
    private Mode f3613e = null;
    private boolean f3614f = false;
    private boolean f3615g = false;

    ag(SeekBar seekBar, C1011w c1011w) {
        super(seekBar, c1011w);
        this.f3610b = seekBar;
    }

    void mo978a(AttributeSet attributeSet, int i) {
        super.mo978a(attributeSet, i);
        de a = de.m7066a(this.f3610b.getContext(), attributeSet, C0841k.AppCompatSeekBar, i, 0);
        Drawable b = a.m7073b(C0841k.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.f3610b.setThumb(b);
        }
        mo977a(a.m7069a(C0841k.AppCompatSeekBar_tickMark));
        if (a.m7083g(C0841k.AppCompatSeekBar_tickMarkTintMode)) {
            this.f3613e = az.m6862a(a.m7068a(C0841k.AppCompatSeekBar_tickMarkTintMode, -1), this.f3613e);
            this.f3615g = true;
        }
        if (a.m7083g(C0841k.AppCompatSeekBar_tickMarkTint)) {
            this.f3612d = a.m7079e(C0841k.AppCompatSeekBar_tickMarkTint);
            this.f3614f = true;
        }
        a.m7070a();
        m6703d();
    }

    void mo977a(Drawable drawable) {
        if (this.f3611c != null) {
            this.f3611c.setCallback(null);
        }
        this.f3611c = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f3610b);
            C0441a.m2998b(drawable, ao.m3938h(this.f3610b));
            if (drawable.isStateful()) {
                drawable.setState(this.f3610b.getDrawableState());
            }
            m6703d();
        }
        this.f3610b.invalidate();
    }

    private void m6703d() {
        if (this.f3611c == null) {
            return;
        }
        if (this.f3614f || this.f3615g) {
            this.f3611c = this.f3611c.mutate();
            if (this.f3614f) {
                this.f3611c.setTintList(this.f3612d);
            }
            if (this.f3615g) {
                this.f3611c.setTintMode(this.f3613e);
            }
            if (this.f3611c.isStateful()) {
                this.f3611c.setState(this.f3610b.getDrawableState());
            }
        }
    }

    void mo979b() {
        if (this.f3611c != null) {
            this.f3611c.jumpToCurrentState();
        }
    }

    void m6708c() {
        Drawable drawable = this.f3611c;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f3610b.getDrawableState())) {
            this.f3610b.invalidateDrawable(drawable);
        }
    }

    void m6704a(Canvas canvas) {
        int i = 1;
        if (this.f3611c != null) {
            int max = this.f3610b.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f3611c.getIntrinsicWidth();
                int intrinsicHeight = this.f3611c.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f3611c.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.f3610b.getWidth() - this.f3610b.getPaddingLeft()) - this.f3610b.getPaddingRight())) / ((float) max);
                intrinsicHeight = canvas.save();
                canvas.translate((float) this.f3610b.getPaddingLeft(), (float) (this.f3610b.getHeight() / 2));
                for (i = 0; i <= max; i++) {
                    this.f3611c.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicHeight);
            }
        }
    }
}
