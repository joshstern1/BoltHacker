package com.electricimp.blinkup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import org.json.JSONArray;

public class WifiActivity extends PreBlinkUpActivity {
    private String apiKey;
    private MCrypt mcrypt = new MCrypt(null, null);
    private String oldSSID;
    private EditText passwordView;
    private TextWatcher passwordWatcher = new C14602();
    private CheckBox rememberCheckBox;
    private SharedPreferences sharedPreferences;
    private CheckBox showCheckBox;
    private String siteids;
    private EditText ssidView;
    private TextWatcher ssidWatcher = new C14591();
    private String token;

    class C14591 implements TextWatcher {
        C14591() {
        }

        public void afterTextChanged(Editable editable) {
            WifiActivity.this.blinkupButton.setEnabled(editable.length() > 0);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class C14602 implements TextWatcher {
        C14602() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                WifiActivity.this.showCheckBox.setEnabled(true);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class C14613 implements OnCheckedChangeListener {
        C14613() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int selectionStart = WifiActivity.this.passwordView.getSelectionStart();
            int selectionEnd = WifiActivity.this.passwordView.getSelectionEnd();
            if (z) {
                WifiActivity.this.passwordView.setInputType(145);
            } else {
                WifiActivity.this.passwordView.setInputType(129);
                WifiActivity.this.passwordView.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            WifiActivity.this.passwordView.setSelection(selectionStart, selectionEnd);
            WifiActivity.this.passwordView.setTypeface(Typeface.DEFAULT);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1458R.layout.__bu_wifi);
        init();
        this.sharedPreferences = getSharedPreferences(getIntent().getExtras().getString("preferenceFile"), 0);
        this.ssidView = (EditText) findViewById(C1458R.id.__bu_wifi_ssid);
        BaseBlinkupController.setHint(this.ssidView, this.blinkup.stringIdSsidHint, C1458R.string.__bu_ssid);
        this.passwordView = (EditText) findViewById(C1458R.id.__bu_wifi_password);
        BaseBlinkupController.setHint(this.passwordView, this.blinkup.stringIdPasswordHint, C1458R.string.__bu_password);
        this.rememberCheckBox = (CheckBox) findViewById(C1458R.id.__bu_remember_password);
        BaseBlinkupController.setText(this.rememberCheckBox, this.blinkup.stringIdRememberPassword, C1458R.string.__bu_remember_password);
        this.showCheckBox = (CheckBox) findViewById(C1458R.id.__bu_show_password);
        BaseBlinkupController.setText(this.showCheckBox, this.blinkup.stringIdShowPassword, C1458R.string.__bu_show_password);
        this.showCheckBox.setOnCheckedChangeListener(new C14613());
        this.showCheckBox.setVisibility(this.blinkup.showPassword ? 0 : 8);
        this.blinkupButton.setEnabled(false);
        this.ssidView.addTextChangedListener(this.ssidWatcher);
        this.passwordView.setTypeface(Typeface.DEFAULT);
        this.passwordView.addTextChangedListener(this.passwordWatcher);
        BaseBlinkupController.setText((TextView) findViewById(C1458R.id.__bu_blinkup_desc), this.blinkup.stringIdBlinkUpDesc, C1458R.string.__bu_blinkup_desc);
        Bundle extras = getIntent().getExtras();
        this.token = extras.getString(BaseBlinkupController.FIELD_TOKEN);
        this.siteids = extras.getString("siteid");
        this.apiKey = extras.getString("apiKey");
        Object string = extras.getString(BaseBlinkupController.FIELD_SSID);
        this.oldSSID = string;
        if (string != null) {
            this.ssidView.setText(string);
            this.rememberCheckBox.setChecked(true);
        }
        Object string2 = this.sharedPreferences.getString("eimp:w:" + string, "");
        if (!TextUtils.isEmpty(string2)) {
            this.passwordView.setText(decryptPassword(string2));
            getWindow().setSoftInputMode(2);
        } else if (string != null) {
            this.passwordView.requestFocus();
        }
        this.showCheckBox.setEnabled(TextUtils.isEmpty(this.passwordView.getText()));
    }

    public void onResume() {
        super.onResume();
        this.blinkupButton.setEnabled(this.ssidView.getText().length() > 0);
    }

    public void onPause() {
        super.onPause();
        updateSavedNetworks();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 4 && this.blinkup.intentBlinkupComplete != null) {
            setResult(-1);
            finish();
        }
    }

    protected Intent createSendBlinkupIntent() {
        String obj = this.ssidView.getText().toString();
        if (obj.length() == 0) {
            return null;
        }
        String obj2 = this.passwordView.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(BaseBlinkupController.FIELD_MODE, BaseBlinkupController.MODE_WIFI);
        intent.putExtra(BaseBlinkupController.FIELD_SSID, obj);
        intent.putExtra(BaseBlinkupController.FIELD_PASSWORD, obj2);
        intent.putExtra(BaseBlinkupController.FIELD_TOKEN, this.token);
        intent.putExtra("siteid", this.siteids);
        intent.putExtra("apiKey", this.apiKey);
        return intent;
    }

    protected void addCreateTokenIntentFields(Intent intent) {
        String obj = this.ssidView.getText().toString();
        String obj2 = this.passwordView.getText().toString();
        intent.putExtra(BaseBlinkupController.FIELD_SSID, obj);
        intent.putExtra(BaseBlinkupController.FIELD_PASSWORD, obj2);
    }

    private void updateSavedNetworks() {
        String obj = this.ssidView.getText().toString();
        String obj2 = this.passwordView.getText().toString();
        List stringArrayListExtra = getIntent().getStringArrayListExtra("savedNetworks");
        if (this.rememberCheckBox.isChecked()) {
            if (!(this.oldSSID == null || this.oldSSID.equals(obj))) {
                removeSavedNetwork(stringArrayListExtra, this.oldSSID);
            }
            addSavedNetwork(stringArrayListExtra, obj, obj2);
            return;
        }
        removeSavedNetwork(stringArrayListExtra, this.oldSSID);
    }

    private void addSavedNetwork(List<String> list, String str, String str2) {
        if (str.length() != 0) {
            Editor edit = this.sharedPreferences.edit();
            if (!list.contains(str)) {
                list.add(str.replaceAll("\"", ""));
                edit.putString("eimp:savedNetworks", new JSONArray(list).toString());
            }
            edit.putString("eimp:w:" + str, encryptPassword(str2));
            edit.commit();
        }
    }

    private void removeSavedNetwork(List<String> list, String str) {
        if (list.contains(str)) {
            list.remove(str);
            JSONArray jSONArray = new JSONArray(list);
            Editor edit = this.sharedPreferences.edit();
            edit.putString("eimp:savedNetworks", jSONArray.toString());
            edit.remove("eimp:w:" + str);
            edit.commit();
        }
    }

    private String encryptPassword(String str) {
        String str2 = null;
        if (!(str == null || str.length() == 0)) {
            try {
                str2 = MCrypt.bytesToHex(this.mcrypt.encrypt(str));
            } catch (Exception e) {
                Log.e("BlinkUp", e.toString());
            }
        }
        return str2;
    }

    private String decryptPassword(String str) {
        String str2 = null;
        if (!(str == null || str.length() == 0)) {
            try {
                str2 = this.mcrypt.decryptToString(str);
            } catch (Exception e) {
                Log.e("BlinkUp", e.toString());
            }
        }
        return str2;
    }
}
