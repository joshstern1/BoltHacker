package com.electricimp.blinkup;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;

public class BaseBlinkupGLActivity extends Activity {
    protected static final int DIALOG_LOW_FRAME_RATE = 0;
    private long blinkupStartTime;
    private int countdownCounter = 3;
    protected TextView countdownDescView;
    protected ViewGroup countdownPanel;
    protected TextView countdownView;
    private BlinkupHandler handler;
    private BlinkupSurfaceView surfaceView;
    private TokenAcquireCallback tokenAcquireCallback = null;
    private WakeLock wakeLock;

    class C14511 implements OnClickListener {
        C14511() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            BaseBlinkupGLActivity.this.goToSettings();
            BaseBlinkupGLActivity.this.finish();
        }
    }

    class C14522 implements OnClickListener {
        C14522() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            BaseBlinkupGLActivity.this.updateCountdown();
            dialogInterface.cancel();
        }
    }

    private static class BlinkupHandler extends Handler {
        public static final int MEASURE_FRAME_RATE = 2;
        public static final int START_TRANSMITTING = 1;
        public static final int UPDATE_COUNTDOWN = 0;
        private WeakReference<BaseBlinkupGLActivity> activity;
        private BlinkupPacket packet;

        public BlinkupHandler(BaseBlinkupGLActivity baseBlinkupGLActivity, BlinkupPacket blinkupPacket) {
            this.activity = new WeakReference(baseBlinkupGLActivity);
            this.packet = blinkupPacket;
        }

        public void handleMessage(Message message) {
            if (this.activity.get() != null && !((BaseBlinkupGLActivity) this.activity.get()).isFinishing()) {
                switch (message.what) {
                    case 0:
                        ((BaseBlinkupGLActivity) this.activity.get()).updateCountdown();
                        return;
                    case 1:
                        ((BaseBlinkupGLActivity) this.activity.get()).surfaceView.startTransmitting(this.packet);
                        return;
                    case 2:
                        if (BlinkupController.getInstance().isFrameRateTooLow(((BaseBlinkupGLActivity) this.activity.get()).surfaceView.getFrameRate())) {
                            ((BaseBlinkupGLActivity) this.activity.get()).showDialog(0);
                            return;
                        } else {
                            sendEmptyMessage(0);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private class PreBlinkupTokenAcquireCallback implements TokenAcquireCallback {
        private PreBlinkupTokenAcquireCallback() {
        }

        public void onSuccess(String str, String str2) {
            Intent intent = new Intent();
            intent.replaceExtras(BaseBlinkupGLActivity.this.getIntent().getExtras());
            intent.putExtra("siteid", str);
            intent.putExtra(BaseBlinkupController.FIELD_TOKEN, str2);
            BaseBlinkupGLActivity.this.initBlinkUp(intent);
        }

        public void onError(String str) {
            Toast.makeText(BaseBlinkupGLActivity.this, str, 1).show();
            Log.e("BlinkUp", "Error getting setup token: " + str);
        }
    }

    protected FrameLayout setupCoundownPanel() {
        View frameLayout = new FrameLayout(this);
        setContentView(frameLayout);
        this.countdownPanel = new RelativeLayout(this);
        frameLayout.addView(this.countdownPanel);
        int i = (int) (getResources().getDisplayMetrics().density * 28.0f);
        addCountdownDesc(i);
        addCountDown();
        addLogo(i);
        return frameLayout;
    }

    private void addCountdownDesc(int i) {
        this.countdownDescView = new TextView(this);
        this.countdownDescView.setGravity(17);
        this.countdownDescView.setTextSize(22.0f);
        this.countdownDescView.setTextColor(-1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.setMargins(i, i, i, i);
        this.countdownPanel.addView(this.countdownDescView, layoutParams);
    }

    private void addCountDown() {
        this.countdownView = new TextView(this);
        this.countdownView.setTextSize(126.0f);
        this.countdownView.setTextColor(-1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.countdownPanel.addView(this.countdownView, layoutParams);
    }

    private void addLogo(int i) {
        View imageView = new ImageView(this);
        byte[] decode = Base64.decode("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", 0);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, 0, 0, i);
        this.countdownPanel.addView(imageView, layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        getWindow().setBackgroundDrawableResource(17170444);
        setRequestedOrientation(5);
        FrameLayout frameLayout = setupCoundownPanel();
        BlinkupController instance = BlinkupController.getInstance();
        if (instance.countdownSeconds > 0) {
            this.countdownCounter = instance.countdownSeconds;
        }
        this.countdownView.setText(String.valueOf(this.countdownCounter));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(268435466, "BrightWhileBlinking");
        if (instance.setFullScreenBrightness) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.screenBrightness = 1.0f;
            getWindow().setAttributes(attributes);
        }
        this.surfaceView = new BlinkupSurfaceView(this, getResources().getDisplayMetrics().density * 640.0f);
        frameLayout.addView(this.surfaceView, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    protected Dialog onCreateDialog(int i) {
        if (i != 0) {
            return null;
        }
        BlinkupController instance = BlinkupController.getInstance();
        Builder builder = new Builder(this);
        builder.setTitle(BaseBlinkupController.getCustomStringOrDefault(this, instance.stringIdLowFrameRateTitle, C1458R.string.__bu_low_frame_rate_title));
        builder.setMessage(BaseBlinkupController.getCustomStringOrDefault(this, instance.stringIdLowFrameRateDesc, C1458R.string.__bu_low_frame_rate_desc));
        builder.setCancelable(false);
        builder.setPositiveButton(BaseBlinkupController.getCustomStringOrDefault(this, instance.stringIdLowFrameRateGoToSettings, C1458R.string.__bu_low_frame_rate_go_to_settings), new C14511());
        builder.setNegativeButton(BaseBlinkupController.getCustomStringOrDefault(this, instance.stringIdLowFrameRateProceedAnyway, C1458R.string.__bu_low_frame_rate_proceed_anyway), new C14522());
        return builder.create();
    }

    private void goToSettings() {
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    protected void startBlinkup() {
        this.blinkupStartTime = System.currentTimeMillis();
        String string = getIntent().getExtras().getString("apiKey");
        if (string != null) {
            this.tokenAcquireCallback = new PreBlinkupTokenAcquireCallback();
            BlinkupController.getInstance().acquireSetupToken(this, string, this.tokenAcquireCallback);
            return;
        }
        initBlinkUp(getIntent());
    }

    private void initBlinkUp(Intent intent) {
        long j = 0;
        BlinkupPacket createFromIntent = BlinkupPacket.createFromIntent(intent);
        BlinkupController instance = BlinkupController.getInstance();
        instance.saveLastMode(intent.getExtras().getString(BaseBlinkupController.FIELD_MODE));
        if (createFromIntent == null) {
            finish();
        }
        instance.saveLastSsid(intent.getExtras().getString(BaseBlinkupController.FIELD_SSID));
        instance.saveLastBitStream(createFromIntent.toString());
        long currentTimeMillis = 1000 - (System.currentTimeMillis() - this.blinkupStartTime);
        if (currentTimeMillis >= 0) {
            j = currentTimeMillis;
        }
        this.handler = new BlinkupHandler(this, createFromIntent);
        if (instance.shouldCheckFrameRate(this)) {
            this.handler.sendEmptyMessageDelayed(2, j);
        } else {
            this.handler.sendEmptyMessageDelayed(0, j);
        }
    }

    protected void onPause() {
        super.onPause();
        this.surfaceView.onPause();
        this.wakeLock.release();
    }

    protected void onResume() {
        super.onResume();
        this.wakeLock.acquire();
        this.surfaceView.onResume();
    }

    protected void updateCountdown() {
        this.countdownCounter--;
        this.countdownView.setText(String.valueOf(this.countdownCounter));
        if (this.countdownCounter > 0) {
            this.handler.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        this.countdownPanel.setVisibility(8);
        this.handler.sendEmptyMessageDelayed(1, 250);
    }
}
