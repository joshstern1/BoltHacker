package com.electricimp.blinkup;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public abstract class PreBlinkUpActivity extends Activity {
    private static final int LEGACY_MODE_DIALOG = 1000;
    protected BlinkupController blinkup;
    protected Button blinkupButton;
    protected CheckBox legacyModeCheckBox;

    class C14572 implements OnClickListener {
        C14572() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    protected abstract Intent createSendBlinkupIntent();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.blinkup = BlinkupController.getInstance();
    }

    protected void onResume() {
        super.onResume();
        this.blinkupButton.setEnabled(true);
    }

    protected void init() {
        this.blinkupButton = (Button) findViewById(C1458R.id.__bu_blinkup_button);
        this.legacyModeCheckBox = (CheckBox) findViewById(C1458R.id.__bu_legacy_mode_checkbox);
        BaseBlinkupController.setText(this.legacyModeCheckBox, this.blinkup.stringIdLegacyMode, C1458R.string.__bu_legacy_mode);
        TextView textView = (TextView) findViewById(C1458R.id.__bu_blinkup_desc);
        if (textView != null) {
            BaseBlinkupController.setText(textView, this.blinkup.stringIdBlinkUpDesc, C1458R.string.__bu_blinkup_desc);
        }
        if (this.blinkup.drawableIdInterstitial > 0) {
            BaseBlinkupController.setText(this.blinkupButton, this.blinkup.stringIdNext, C1458R.string.__bu_next);
        } else {
            BaseBlinkupController.setText(this.blinkupButton, this.blinkup.stringIdSendBlinkUp, C1458R.string.__bu_send_blinkup);
        }
        if (this.blinkup.showLegacyMode) {
            findViewById(C1458R.id.__bu_legacy_mode).setVisibility(0);
        }
    }

    protected void addCreateTokenIntentFields(Intent intent) {
    }

    public void sendBlinkup(View view) {
        this.blinkupButton.setEnabled(false);
        Intent createSendBlinkupIntent = createSendBlinkupIntent();
        if (getIntent().getBooleanExtra("tokenCreate", false)) {
            String stringExtra = createSendBlinkupIntent.getStringExtra(BaseBlinkupController.FIELD_MODE);
            final Intent intent = new Intent();
            intent.putExtra(BaseBlinkupController.FIELD_MODE, stringExtra);
            if (this.legacyModeCheckBox.isChecked()) {
                intent.putExtra("slow", true);
            }
            if (BaseBlinkupController.MODE_CLEAR.equals(stringExtra)) {
                setResult(-1, intent);
                finish();
                return;
            }
            TokenAcquireCallback c14561 = new TokenAcquireCallback() {
                public void onSuccess(String str, String str2) {
                    intent.putExtra(BaseBlinkupController.FIELD_TOKEN, str2);
                    PreBlinkUpActivity.this.addCreateTokenIntentFields(intent);
                    PreBlinkUpActivity.this.setResult(-1, intent);
                    PreBlinkUpActivity.this.finish();
                }

                public void onError(String str) {
                    Intent intent = new Intent();
                    intent.putExtra(BaseBlinkupController.FIELD_ERROR, str);
                    PreBlinkUpActivity.this.setResult(1, intent);
                    PreBlinkUpActivity.this.finish();
                }
            };
            this.blinkup.acquireSetupToken(this, getIntent().getStringExtra("apiKey"), c14561);
            return;
        }
        if (this.legacyModeCheckBox.isChecked()) {
            createSendBlinkupIntent.putExtra("slow", true);
        }
        this.blinkup.addBlinkupIntentFields(this, createSendBlinkupIntent);
        startActivityForResult(createSendBlinkupIntent, 4);
    }

    public void legacyModeLink(View view) {
        showDialog(LEGACY_MODE_DIALOG);
    }

    protected Dialog onCreateDialog(int i) {
        Builder builder = new Builder(this);
        if (i == LEGACY_MODE_DIALOG) {
            builder.setTitle(BaseBlinkupController.getCustomStringOrDefault(this, this.blinkup.stringIdLegacyMode, C1458R.string.__bu_legacy_mode));
            builder.setMessage(BaseBlinkupController.getCustomStringOrDefault(this, this.blinkup.stringIdLegacyModeDesc, C1458R.string.__bu_legacy_mode_desc));
            builder.setNeutralButton(BaseBlinkupController.getCustomStringOrDefault(this, this.blinkup.stringIdOk, C1458R.string.__bu_ok), new C14572());
        }
        return builder.create();
    }
}
