package com.electricimp.blinkup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InterstitialActivity extends Activity {
    private View blinkupButton;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1458R.layout.__bu_interstitial);
        this.blinkupButton = findViewById(C1458R.id.__bu_blinkup_button);
        ((ImageView) findViewById(C1458R.id.__bu_interstitial)).setImageResource(BlinkupController.getInstance().drawableIdInterstitial);
    }

    protected void onResume() {
        super.onResume();
        this.blinkupButton.setEnabled(true);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void sendBlinkup(View view) {
        this.blinkupButton.setEnabled(false);
        Intent intent = new Intent(this, BlinkupGLActivity.class);
        intent.replaceExtras(getIntent().getExtras());
        startActivityForResult(intent, 4);
    }
}
