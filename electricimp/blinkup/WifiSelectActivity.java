package com.electricimp.blinkup;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.electricimp.blinkup.BaseWifiSelectActivity.NetworkItem.Type;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class WifiSelectActivity extends BaseWifiSelectActivity {
    private ListView networkListView;

    class C14621 implements OnItemClickListener {
        C14621() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            NetworkItem networkItem = (NetworkItem) ((ListAdapter) adapterView.getAdapter()).getItem(i);
            if (networkItem != null) {
                switch (networkItem.type) {
                    case CHANGE_NETWORK:
                        WifiSelectActivity.this.sendWirelessConfiguration(null);
                        return;
                    case CONNECT_USING_WPS:
                        WifiSelectActivity.this.connectUsingWPS();
                        return;
                    case CLEAR:
                        WifiSelectActivity.this.clearWirelessConfiguration();
                        return;
                    default:
                        WifiSelectActivity.this.sendWirelessConfiguration(networkItem.label);
                        return;
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1458R.layout.__bu_wifi_select);
        BlinkupController instance = BlinkupController.getInstance();
        this.networkListView = (ListView) findViewById(C1458R.id.__bu_network_list);
        this.networkListView.addHeaderView(LayoutInflater.from(this).inflate(C1458R.layout.__bu_wifi_select_header, this.networkListView, false), null, false);
        BaseBlinkupController.setText((TextView) findViewById(C1458R.id.__bu_wifi_select_header), instance.stringIdChooseWiFiNetwork, C1458R.string.__bu_choose_wifi_network);
        addFooter(this.networkListView, C1458R.string.__bu_logged_in_as, C1458R.dimen.__bu_padding);
        this.networkListStrings = new ArrayList();
        this.networkListView.setAdapter(new ArrayAdapter(this, C1458R.layout.__bu_network_list_item, this.networkListStrings));
        this.networkListView.setOnItemClickListener(new C14621());
    }

    public void onResume() {
        int i = 0;
        String currentWifiSSID = BaseBlinkupController.getCurrentWifiSSID(this);
        this.savedNetworks.clear();
        try {
            JSONArray jSONArray = new JSONArray(getSharedPreferences(this.preferenceFile, 0).getString("eimp:savedNetworks", ""));
            while (i < jSONArray.length()) {
                this.savedNetworks.add(jSONArray.getString(i));
                i++;
            }
        } catch (JSONException e) {
            Log.v("BlinkUp", "Error parsing saved networks JSON string: " + e);
        }
        this.networkListStrings.clear();
        if (currentWifiSSID != null) {
            this.networkListStrings.add(new NetworkItem(Type.NETWORK, currentWifiSSID));
        }
        Iterator it = this.savedNetworks.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!str.equals(currentWifiSSID)) {
                this.networkListStrings.add(new NetworkItem(Type.NETWORK, str));
            }
        }
        BlinkupController instance = BlinkupController.getInstance();
        this.networkListStrings.add(new NetworkItem(Type.CHANGE_NETWORK, instance.stringIdChangeNetwork != null ? instance.stringIdChangeNetwork : getString(C1458R.string.__bu_change_network)));
        this.networkListStrings.add(new NetworkItem(Type.CONNECT_USING_WPS, instance.stringIdConnectUsingWps != null ? instance.stringIdConnectUsingWps : getString(C1458R.string.__bu_connect_using_wps)));
        if (instance.showClearConfig) {
            str = instance.stringIdClearDeviceSettings;
            if (str == null) {
                str = getString(C1458R.string.__bu_clear_device_settings);
            }
            this.networkListStrings.add(new NetworkItem(Type.CLEAR, str));
        }
        this.networkListView.invalidateViews();
        super.onResume();
    }
}
