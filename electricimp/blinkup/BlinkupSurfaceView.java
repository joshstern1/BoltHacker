package com.electricimp.blinkup;

import android.app.Activity;
import android.opengl.GLSurfaceView;

public class BlinkupSurfaceView extends GLSurfaceView {
    private float mMaxSize;
    private BlinkupRenderer mRenderer;

    public BlinkupSurfaceView(Activity activity, float f) {
        super(activity);
        this.mMaxSize = f;
        this.mRenderer = new BlinkupRenderer(activity);
        setRenderer(this.mRenderer);
    }

    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
        float f = 1.0f;
        if (defaultSize > defaultSize2) {
            if (((float) defaultSize) > this.mMaxSize) {
                f = this.mMaxSize / ((float) defaultSize);
            }
        } else if (((float) defaultSize2) > this.mMaxSize) {
            f = this.mMaxSize / ((float) defaultSize2);
        }
        setMeasuredDimension((int) (((float) defaultSize) * f), (int) (f * ((float) defaultSize2)));
    }

    public void startTransmitting(BlinkupPacket blinkupPacket) {
        this.mRenderer.startTransmitting(blinkupPacket);
    }

    public float getFrameRate() {
        return this.mRenderer.getFrameRate();
    }
}
