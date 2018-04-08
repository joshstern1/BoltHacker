package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.al;
import android.support.v7.p028b.C0842a.C0831a;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class AppCompatButton extends Button implements al {
    private final C1011w f3183a;
    private final C1004t f3184b;
    private final al f3185c;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(db.m7061a(context), attributeSet, i);
        this.f3183a = C1011w.m7254a();
        this.f3184b = new C1004t(this, this.f3183a);
        this.f3184b.m7230a(attributeSet, i);
        this.f3185c = al.m6711a((TextView) this);
        this.f3185c.mo981a(attributeSet, i);
        this.f3185c.mo980a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3184b != null) {
            this.f3184b.m7226a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3184b != null) {
            this.f3184b.m7229a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3184b != null) {
            this.f3184b.m7227a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f3184b != null ? this.f3184b.m7225a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f3184b != null) {
            this.f3184b.m7228a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f3184b != null ? this.f3184b.m7231b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3184b != null) {
            this.f3184b.m7233c();
        }
        if (this.f3185c != null) {
            this.f3185c.mo980a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3185c != null) {
            this.f3185c.m6714a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f3185c != null) {
            this.f3185c.m6717a(z);
        }
    }
}
