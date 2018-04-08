package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class C0962b extends Drawable {
    final ActionBarContainer f3686a;

    public C0962b(ActionBarContainer actionBarContainer) {
        this.f3686a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f3686a.f3049d) {
            if (this.f3686a.f3046a != null) {
                this.f3686a.f3046a.draw(canvas);
            }
            if (this.f3686a.f3047b != null && this.f3686a.f3050e) {
                this.f3686a.f3047b.draw(canvas);
            }
        } else if (this.f3686a.f3048c != null) {
            this.f3686a.f3048c.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
