package com.electricimp.blinkup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ClearWifiActivity extends PreBlinkUpActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1458R.layout.__bu_clear_wifi);
        init();
        BaseBlinkupController.setText((TextView) findViewById(C1458R.id.__bu_blinkup_desc), this.blinkup.stringIdBlinkUpDesc, C1458R.string.__bu_blinkup_desc);
        BaseBlinkupController.setText((TextView) findViewById(C1458R.id.__bu_clear_wifi_header), this.blinkup.stringIdClearDeviceSettings, C1458R.string.__bu_clear_device_settings);
        BaseBlinkupController.setText(this.blinkupButton, this.blinkup.stringIdClearWireless, C1458R.string.__bu_clear_wireless);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 4 && this.blinkup.intentClearComplete != null) {
                setResult(-1);
                finish();
            }
            setResult(i2, intent);
            finish();
        }
    }

    public Intent createSendBlinkupIntent() {
        Intent intent = new Intent();
        intent.putExtra(BaseBlinkupController.FIELD_MODE, BaseBlinkupController.MODE_CLEAR);
        return intent;
    }
}
