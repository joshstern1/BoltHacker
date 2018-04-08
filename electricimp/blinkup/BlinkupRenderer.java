package com.electricimp.blinkup;

import android.app.Activity;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import no.nordicsemi.android.dfu.DfuBaseService;

public class BlinkupRenderer implements Renderer {
    private static final int COOLDOWN_DELAY = 60;
    private static final int STATE_COOLDOWN = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_TRANSMITTING = 1;
    private Activity activity = null;
    private int currentBit = 0;
    private int delayCounter = 0;
    private int idleCounter = 0;
    private BlinkupPacket packet = null;
    private long startTime;
    private int state = 0;

    public BlinkupRenderer(Activity activity) {
        this.activity = activity;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Process.setThreadPriority(-19);
        gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl10.glClear(DfuBaseService.ERROR_CONNECTION_MASK);
    }

    public void onDrawFrame(GL10 gl10) {
        switch (this.state) {
            case 0:
                if (this.idleCounter == 0) {
                    this.startTime = System.currentTimeMillis();
                }
                this.idleCounter++;
                gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                gl10.glClear(DfuBaseService.ERROR_CONNECTION_MASK);
                return;
            case 1:
                if (this.packet == null) {
                    return;
                }
                if (this.currentBit == this.packet.numBits()) {
                    this.state = 2;
                    this.delayCounter = 60;
                    this.packet = null;
                    return;
                }
                if (this.currentBit == 0 && this.idleCounter > 0) {
                    float frameRate = getFrameRate();
                    if (frameRate >= 78.0f && frameRate <= 102.0f) {
                        this.packet.twoThirdSpeed();
                    }
                }
                switch (this.packet.bitAtIndex(this.currentBit)) {
                    case 0:
                        gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                        break;
                    case 1:
                        gl10.glClearColor(0.75f, 0.75f, 0.75f, 1.0f);
                        break;
                    case 2:
                        gl10.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                        break;
                }
                gl10.glClear(DfuBaseService.ERROR_CONNECTION_MASK);
                this.currentBit++;
                return;
            case 2:
                this.delayCounter--;
                gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                gl10.glClear(DfuBaseService.ERROR_CONNECTION_MASK);
                if (this.delayCounter == 0) {
                    this.state = 0;
                    this.activity.setResult(-1);
                    this.activity.finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        gl10.glViewport(0, 0, i, i2);
    }

    public void startTransmitting(BlinkupPacket blinkupPacket) {
        this.packet = blinkupPacket;
        this.state = 1;
    }

    public float getFrameRate() {
        return 1000.0f / ((((float) (System.currentTimeMillis() - this.startTime)) * 1.0f) / ((float) this.idleCounter));
    }
}
