package com.electricimp.blinkup;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class ImpController {
    String apiKey = null;
    private String baseUrl;
    String planID = null;
    String setupToken = null;
    private Boolean shouldPollTokenStatus = Boolean.valueOf(true);

    private static class PollTokenStatusHandler extends Handler {
        private static final long DEFAULT_TIMEOUT = 60000;
        private static final int PARSE_RESULT = 1;
        private static final int POLL = 0;
        private static final long TOKEN_STATUS_RETRY_PERIOD = 1000;
        private final ImpController controller;
        private final Handler resultHandler;
        private long startTime;
        private final long timeout;
        private final Handler tokenStatusHandler;

        public PollTokenStatusHandler(ImpController impController, Handler handler) {
            this(impController, handler, DEFAULT_TIMEOUT);
        }

        public PollTokenStatusHandler(ImpController impController, Handler handler, long j) {
            this.controller = impController;
            this.resultHandler = handler;
            this.tokenStatusHandler = new TokenStatusHandler(this);
            this.timeout = j;
            this.startTime = System.currentTimeMillis();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    synchronized (this.controller.shouldPollTokenStatus) {
                        if (this.controller.shouldPollTokenStatus.booleanValue()) {
                            this.controller.getTokenStatusHelper((String) message.obj, this.tokenStatusHandler);
                            return;
                        }
                        this.controller.shouldPollTokenStatus = Boolean.valueOf(true);
                        return;
                    }
                case 1:
                    parseResult(message);
                    return;
                default:
                    return;
            }
        }

        private void parseResult(Message message) {
            if (message.arg1 == 1) {
                JSONObject jSONObject = (JSONObject) message.obj;
                try {
                    String string = jSONObject.has("agent_url") ? jSONObject.getString("agent_url") : null;
                    if (string != null && string.length() != 0) {
                        this.resultHandler.sendMessage(this.resultHandler.obtainMessage(message.what, message.arg1, message.arg2, message.obj));
                        return;
                    } else if (System.currentTimeMillis() - this.startTime < this.timeout) {
                        sendMessageDelayed(obtainMessage(0, jSONObject.getString("id")), TOKEN_STATUS_RETRY_PERIOD);
                        return;
                    } else {
                        Message obtainMessage = this.resultHandler.obtainMessage();
                        obtainMessage.arg1 = 2;
                        this.resultHandler.sendMessage(obtainMessage);
                        return;
                    }
                } catch (JSONException e) {
                    Message obtainMessage2 = this.resultHandler.obtainMessage();
                    obtainMessage2.obj = e.getMessage();
                    obtainMessage2.arg1 = 0;
                    this.resultHandler.sendMessage(obtainMessage2);
                    return;
                }
            }
            this.resultHandler.sendMessage(this.resultHandler.obtainMessage(message.what, message.arg1, message.arg2, message.obj));
        }
    }

    private static class TokenStatusHandler extends Handler {
        private PollTokenStatusHandler poller;

        public TokenStatusHandler(PollTokenStatusHandler pollTokenStatusHandler) {
            this.poller = pollTokenStatusHandler;
        }

        public void handleMessage(Message message) {
            Message obtainMessage = this.poller.obtainMessage(message.what, message.arg1, message.arg2, message.obj);
            obtainMessage.what = 1;
            this.poller.sendMessage(obtainMessage);
        }
    }

    public ImpController(String str) {
        this.baseUrl = str;
    }

    void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    void acquireSetupToken(String str, Handler handler) {
        this.apiKey = str;
        acquireSetupToken(new ImpAPIClient(this.baseUrl, str), this.planID, handler);
    }

    void getTokenStatus(Handler handler) {
        getTokenStatus(this.setupToken, handler);
    }

    void getTokenStatus(String str, Handler handler) {
        synchronized (this.shouldPollTokenStatus) {
            this.shouldPollTokenStatus = Boolean.valueOf(true);
        }
        Handler pollTokenStatusHandler = new PollTokenStatusHandler(this, handler);
        pollTokenStatusHandler.sendMessage(pollTokenStatusHandler.obtainMessage(0, str));
    }

    void getTokenStatus(Handler handler, long j) {
        getTokenStatus(this.setupToken, handler, j);
    }

    void getTokenStatus(String str, Handler handler, long j) {
        synchronized (this.shouldPollTokenStatus) {
            this.shouldPollTokenStatus = Boolean.valueOf(true);
        }
        Handler pollTokenStatusHandler = new PollTokenStatusHandler(this, handler, j);
        pollTokenStatusHandler.sendMessage(pollTokenStatusHandler.obtainMessage(0, str));
    }

    void cancelTokenStatusPolling() {
        synchronized (this.shouldPollTokenStatus) {
            this.shouldPollTokenStatus = Boolean.valueOf(false);
        }
    }

    private void getTokenStatusHelper(String str, final Handler handler) {
        if (str == null || str.length() == 0) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = "No token specified";
            obtainMessage.arg1 = 0;
            handler.sendMessage(obtainMessage);
            return;
        }
        new ImpAPIClient(this.baseUrl, this.apiKey).readSetupToken(str, new Handler() {
            public void handleMessage(Message message) {
                handler.sendMessage(handler.obtainMessage(message.what, message.arg1, message.arg2, message.obj));
            }
        });
    }

    private void acquireSetupToken(ImpAPIClient impAPIClient, String str, final Handler handler) {
        impAPIClient.createSetupToken(str, new Handler() {
            public void handleMessage(Message message) {
                int i;
                Object obj;
                Object obj2 = message.obj;
                int i2 = message.arg1;
                if (message.arg1 == 1) {
                    JSONObject jSONObject = (JSONObject) message.obj;
                    try {
                        ImpController.this.setupToken = jSONObject.getString("id");
                        i = i2;
                        obj = obj2;
                    } catch (Throwable e) {
                        Log.e("BlinkUp", Log.getStackTraceString(e));
                        obj = e.getMessage();
                        i = 0;
                    }
                } else {
                    i = i2;
                    obj = obj2;
                }
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(message.what, i, message.arg2, obj));
                }
            }
        });
    }
}
