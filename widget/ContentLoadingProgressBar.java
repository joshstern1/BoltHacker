package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private long f2160a;
    private boolean f2161b;
    private boolean f2162c;
    private boolean f2163d;
    private final Runnable f2164e;
    private final Runnable f2165f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2160a = -1;
        this.f2161b = false;
        this.f2162c = false;
        this.f2163d = false;
        this.f2164e = new C0730h(this);
        this.f2165f = new C0731i(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m4407a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m4407a();
    }

    private void m4407a() {
        removeCallbacks(this.f2164e);
        removeCallbacks(this.f2165f);
    }
}
