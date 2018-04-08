package com.electricimp.blinkup;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WPSActivity extends PreBlinkUpActivity {
    private String apiKey;
    private String siteids;
    private String token;
    private EditText wpsPinView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1458R.layout.__bu_wps);
        init();
        this.wpsPinView = (EditText) findViewById(C1458R.id.__bu_wps_pin_optional);
        BaseBlinkupController.setHint(this.wpsPinView, this.blinkup.stringIdWpsPinHint, C1458R.string.__bu_wps_pin);
        this.wpsPinView.setTypeface(Typeface.DEFAULT);
        BaseBlinkupController.setText((TextView) findViewById(C1458R.id.__bu_wps_info), this.blinkup.stringIdWpsInfo, C1458R.string.__bu_wps_info);
        Bundle extras = getIntent().getExtras();
        this.token = extras.getString(BaseBlinkupController.FIELD_TOKEN);
        this.siteids = extras.getString("siteid");
        this.apiKey = extras.getString("apiKey");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 4 && this.blinkup.intentBlinkupComplete != null) {
            setResult(-1);
            finish();
        }
    }

    protected Intent createSendBlinkupIntent() {
        String obj = this.wpsPinView.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(BaseBlinkupController.FIELD_MODE, BaseBlinkupController.MODE_WPS);
        intent.putExtra(BaseBlinkupController.FIELD_PIN, obj);
        intent.putExtra(BaseBlinkupController.FIELD_TOKEN, this.token);
        intent.putExtra("siteid", this.siteids);
        intent.putExtra("apiKey", this.apiKey);
        return intent;
    }

    protected void addCreateTokenIntentFields(Intent intent) {
        intent.putExtra(BaseBlinkupController.FIELD_PIN, this.wpsPinView.getText().toString());
    }
}
