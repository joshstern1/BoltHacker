package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.p028b.C0842a.C0831a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class af extends SeekBar {
    private ag f3608a;
    private C1011w f3609b;

    public af(Context context) {
        this(context, null);
    }

    public af(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0831a.seekBarStyle);
    }

    public af(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3609b = C1011w.m7254a();
        this.f3608a = new ag(this, this.f3609b);
        this.f3608a.mo978a(attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3608a.m6704a(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f3608a.m6708c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f3608a.mo979b();
    }
}
