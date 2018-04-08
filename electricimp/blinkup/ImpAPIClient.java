package com.electricimp.blinkup;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ImpAPIClient {
    private static final String BLINKUP_SDK_VERSION = "4.2.14";
    private String apiKey;
    private String baseUrl;

    public ImpAPIClient(String str, String str2) {
        this.baseUrl = str;
        this.apiKey = str2;
    }

    public void createSetupToken(String str, Handler handler) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("plan_id", str);
            } catch (Throwable e) {
                Log.e("BlinkUp", Log.getStackTraceString(e));
                return;
            }
        }
        request("/setup_tokens", "POST", jSONObject, handler, null);
    }

    public void readSetupToken(String str, Handler handler) {
        request("/setup_tokens/" + str, "GET", null, handler, null);
    }

    private void request(String str, String str2, JSONObject jSONObject, Handler handler, String str3) {
        final Handler handler2 = handler;
        final String str4 = str;
        final String str5 = str2;
        final JSONObject jSONObject2 = jSONObject;
        final String str6 = str3;
        new Thread(new Runnable() {
            public void run() {
                Message obtainMessage = handler2.obtainMessage();
                ImpAPIClient.this.requestTask(str4, str5, jSONObject2, str6, obtainMessage);
                handler2.sendMessage(obtainMessage);
            }
        }).start();
    }

    public void requestTask(String str, String str2, JSONObject jSONObject, String str3, Message message) {
        try {
            HttpURLConnection post;
            URL url = new URL(this.baseUrl + str);
            String str4 = "Basic " + Base64.encodeToString((this.apiKey + ":").getBytes("UTF-8"), 2);
            if (str2.equals("POST")) {
                post = BlinkupHttpURLConnection.post(url.openConnection());
            } else {
                post = BlinkupHttpURLConnection.get(url.openConnection());
            }
            post.addRequestProperty("Authorization", str4);
            post.addRequestProperty("User-Agent", System.getProperty("http.agent") + " v" + BLINKUP_SDK_VERSION);
            if (str2.equals("POST") && jSONObject != null) {
                post.addRequestProperty("Content-Type", "application/json");
                OutputStream outputStream = post.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(post.getOutputStream());
                dataOutputStream.writeBytes(jSONObject.toString());
                dataOutputStream.flush();
                dataOutputStream.close();
                outputStream.close();
            }
            int i = 200;
            if (str2.equals("POST")) {
                i = 201;
            }
            int responseCode = post.getResponseCode();
            if (responseCode == i) {
                String contentType = post.getContentType();
                if (contentType.equals("application/vnd.electricimp-v1+json") || contentType.equals("application/json")) {
                    JSONObject jSONObject2 = new JSONObject(new BufferedReader(new InputStreamReader(post.getInputStream())).readLine());
                    if (str3 == null) {
                        message.obj = jSONObject2;
                    } else {
                        message.obj = jSONObject2.get(str3);
                    }
                    message.arg1 = 1;
                    return;
                }
                message.obj = "Content type not recognized";
                message.arg1 = 0;
                return;
            }
            message.obj = "Unexpected server response: " + Integer.toString(responseCode);
            message.arg1 = 0;
        } catch (Throwable e) {
            Log.e("BlinkUp", "Error parsing JSON response", e);
            message.obj = e.getMessage();
            message.arg1 = 0;
        } catch (Throwable e2) {
            Log.e("BlinkUp", "Server connection error", e2);
            message.obj = e2.getMessage();
            message.arg1 = 0;
        }
    }
}
