package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.al;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements al {
    private C1004t f3108a;
    private C1014z f3109b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(db.m7061a(context), attributeSet, i);
        C1011w a = C1011w.m7254a();
        this.f3108a = new C1004t(this, a);
        this.f3108a.m7230a(attributeSet, i);
        this.f3109b = new C1014z(this, a);
        this.f3109b.m7277a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f3109b.m7276a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3108a != null) {
            this.f3108a.m7226a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3108a != null) {
            this.f3108a.m7229a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3108a != null) {
            this.f3108a.m7227a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f3108a != null ? this.f3108a.m7225a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f3108a != null) {
            this.f3108a.m7228a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f3108a != null ? this.f3108a.m7231b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3108a != null) {
            this.f3108a.m7233c();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f3109b.m7278a() && super.hasOverlappingRendering();
    }
}
