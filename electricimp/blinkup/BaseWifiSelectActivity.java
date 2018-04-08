package com.electricimp.blinkup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class BaseWifiSelectActivity extends Activity {
    protected static final String SAVED_NETWORKS_SETTING = "eimp:savedNetworks";
    protected static final String SAVED_PASSWORD_PREFIX = "eimp:w:";
    protected String apiKey;
    protected List<NetworkItem> networkListStrings;
    protected String planID;
    protected String preferenceFile;
    protected ArrayList<String> savedNetworks;
    protected String setupToken;
    protected boolean tokenCreate;

    protected static class NetworkItem {
        public String label;
        public Type type;

        public enum Type {
            NETWORK,
            CHANGE_NETWORK,
            CONNECT_USING_WPS,
            CLEAR
        }

        public NetworkItem(Type type, String str) {
            this.type = type;
            this.label = str;
        }

        public String toString() {
            return this.label;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.savedNetworks = new ArrayList();
        this.setupToken = extras.getString("setupToken");
        this.planID = extras.getString("planID");
        this.apiKey = extras.getString("apiKey");
        this.preferenceFile = extras.getString("preferenceFile");
        this.tokenCreate = extras.getBoolean("tokenCreate");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            BlinkupController instance = BlinkupController.getInstance();
            if ((i == 1 || i == 2) && instance.intentBlinkupComplete != null) {
                setResult(-1);
                finish();
            }
            if (i == 3 && instance.intentClearComplete != null) {
                setResult(-1);
                finish();
            }
        }
        setResult(i2, intent);
        finish();
    }

    protected void addFooter(ListView listView, int i, int i2) {
        if (this.apiKey == null && getSharedPreferences("preferences", 0).getString("eimpapp:username", null) != null) {
            View textView = new TextView(this);
            textView.setText(getString(i, new Object[]{r0}));
            textView.setGravity(1);
            textView.setPadding(0, getResources().getDimensionPixelSize(i2), 0, 0);
            listView.addFooterView(textView, null, false);
        }
    }

    protected void sendWirelessConfiguration(String str) {
        Intent intent = new Intent();
        intent.putExtra(BaseBlinkupController.FIELD_TOKEN, this.setupToken);
        if (str != null) {
            intent.putExtra(BaseBlinkupController.FIELD_SSID, str);
        }
        intent.putExtra("siteid", this.planID);
        intent.putExtra("apiKey", this.apiKey);
        intent.putStringArrayListExtra("savedNetworks", this.savedNetworks);
        intent.putExtra("preferenceFile", this.preferenceFile);
        intent.putExtra("tokenCreate", this.tokenCreate);
        intent.setClassName(this, "com.electricimp.blinkup.WifiActivity");
        startActivityForResult(intent, 1);
    }

    protected void connectUsingWPS() {
        Intent intent = new Intent();
        intent.putExtra(BaseBlinkupController.FIELD_TOKEN, this.setupToken);
        intent.putExtra("siteid", this.planID);
        intent.putExtra("apiKey", this.apiKey);
        intent.putExtra("tokenCreate", this.tokenCreate);
        intent.setClassName(this, "com.electricimp.blinkup.WPSActivity");
        startActivityForResult(intent, 2);
    }

    protected void clearWirelessConfiguration() {
        Intent intent = new Intent();
        intent.setClassName(this, "com.electricimp.blinkup.ClearWifiActivity");
        intent.putExtra("siteid", this.planID);
        intent.putExtra("apiKey", this.apiKey);
        intent.putExtra("tokenCreate", this.tokenCreate);
        startActivityForResult(intent, 3);
    }
}
