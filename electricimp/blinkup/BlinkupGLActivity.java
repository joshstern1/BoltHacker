package com.electricimp.blinkup;

import android.os.Bundle;

public class BlinkupGLActivity extends BaseBlinkupGLActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseBlinkupController.setText(this.countdownDescView, BlinkupController.getInstance().stringIdCountdownDesc, C1458R.string.__bu_countdown_desc);
        startBlinkup();
    }
}
