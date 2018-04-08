package no.nordicsemi.android.dfu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.p021b.C0429i;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import no.nordicsemi.android.p123a.C3082a;

public class DfuServiceListenerHelper {
    private static LogBroadcastReceiver mLogBroadcastReceiver;
    private static ProgressBroadcastsReceiver mProgressBroadcastReceiver;

    private static class LogBroadcastReceiver extends BroadcastReceiver {
        private DfuLogListener mGlobalLogListener;
        private Map<String, DfuLogListener> mListeners;

        private LogBroadcastReceiver() {
            this.mListeners = new HashMap();
        }

        private void setLogListener(DfuLogListener dfuLogListener) {
            this.mGlobalLogListener = dfuLogListener;
        }

        private void setLogListener(String str, DfuLogListener dfuLogListener) {
            this.mListeners.put(str, dfuLogListener);
            this.mListeners.put(DfuServiceListenerHelper.getIncrementedAddress(str), dfuLogListener);
        }

        private boolean removeLogListener(DfuLogListener dfuLogListener) {
            if (this.mGlobalLogListener == dfuLogListener) {
                this.mGlobalLogListener = null;
            }
            for (Entry entry : this.mListeners.entrySet()) {
                if (entry.getValue() == dfuLogListener) {
                    this.mListeners.remove(entry.getKey());
                    break;
                }
            }
            for (Entry entry2 : this.mListeners.entrySet()) {
                if (entry2.getValue() == dfuLogListener) {
                    this.mListeners.remove(entry2.getKey());
                    break;
                }
            }
            return this.mGlobalLogListener == null && this.mListeners.isEmpty();
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS);
            DfuLogListener dfuLogListener = this.mGlobalLogListener;
            DfuLogListener dfuLogListener2 = (DfuLogListener) this.mListeners.get(stringExtra);
            if (dfuLogListener != null || dfuLogListener2 != null) {
                int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_LOG_LEVEL, 0);
                String stringExtra2 = intent.getStringExtra(DfuBaseService.EXTRA_LOG_MESSAGE);
                if (dfuLogListener != null) {
                    dfuLogListener.onLogEvent(stringExtra, intExtra, stringExtra2);
                }
                if (dfuLogListener2 != null) {
                    dfuLogListener2.onLogEvent(stringExtra, intExtra, stringExtra2);
                }
            }
        }
    }

    private static class ProgressBroadcastsReceiver extends BroadcastReceiver {
        private DfuProgressListener mGlobalProgressListener;
        private Map<String, DfuProgressListener> mListeners;

        private ProgressBroadcastsReceiver() {
            this.mListeners = new HashMap();
        }

        private void setProgressListener(DfuProgressListener dfuProgressListener) {
            this.mGlobalProgressListener = dfuProgressListener;
        }

        private void setProgressListener(String str, DfuProgressListener dfuProgressListener) {
            this.mListeners.put(str, dfuProgressListener);
            this.mListeners.put(DfuServiceListenerHelper.getIncrementedAddress(str), dfuProgressListener);
        }

        private boolean removeProgressListener(DfuProgressListener dfuProgressListener) {
            if (this.mGlobalProgressListener == dfuProgressListener) {
                this.mGlobalProgressListener = null;
            }
            for (Entry entry : this.mListeners.entrySet()) {
                if (entry.getValue() == dfuProgressListener) {
                    this.mListeners.remove(entry.getKey());
                    break;
                }
            }
            for (Entry entry2 : this.mListeners.entrySet()) {
                if (entry2.getValue() == dfuProgressListener) {
                    this.mListeners.remove(entry2.getKey());
                    break;
                }
            }
            return this.mGlobalProgressListener == null && this.mListeners.isEmpty();
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS);
            DfuProgressListener dfuProgressListener = this.mGlobalProgressListener;
            DfuProgressListener dfuProgressListener2 = (DfuProgressListener) this.mListeners.get(stringExtra);
            if (dfuProgressListener != null || dfuProgressListener2 != null) {
                String action = intent.getAction();
                int i = -1;
                switch (action.hashCode()) {
                    case -2021868104:
                        if (action.equals(DfuBaseService.BROADCAST_PROGRESS)) {
                            i = 0;
                            break;
                        }
                        break;
                    case -1282379203:
                        if (action.equals(DfuBaseService.BROADCAST_ERROR)) {
                            i = 1;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        i = intent.getIntExtra(DfuBaseService.EXTRA_DATA, 0);
                        float floatExtra = intent.getFloatExtra(DfuBaseService.EXTRA_SPEED_B_PER_MS, 0.0f);
                        float floatExtra2 = intent.getFloatExtra(DfuBaseService.EXTRA_AVG_SPEED_B_PER_MS, 0.0f);
                        int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PART_CURRENT, 0);
                        int intExtra2 = intent.getIntExtra(DfuBaseService.EXTRA_PARTS_TOTAL, 0);
                        switch (i) {
                            case DfuBaseService.PROGRESS_ABORTED /*-7*/:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onDeviceDisconnected(stringExtra);
                                    dfuProgressListener.onDfuAborted(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onDeviceDisconnected(stringExtra);
                                    dfuProgressListener2.onDfuAborted(stringExtra);
                                    return;
                                }
                                return;
                            case DfuBaseService.PROGRESS_COMPLETED /*-6*/:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onDeviceDisconnected(stringExtra);
                                    dfuProgressListener.onDfuCompleted(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onDeviceDisconnected(stringExtra);
                                    dfuProgressListener2.onDfuCompleted(stringExtra);
                                    return;
                                }
                                return;
                            case DfuBaseService.PROGRESS_DISCONNECTING /*-5*/:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onDeviceDisconnecting(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onDeviceDisconnecting(stringExtra);
                                    return;
                                }
                                return;
                            case DfuBaseService.PROGRESS_VALIDATING /*-4*/:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onFirmwareValidating(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onFirmwareValidating(stringExtra);
                                    return;
                                }
                                return;
                            case DfuBaseService.PROGRESS_ENABLING_DFU_MODE /*-3*/:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onEnablingDfuMode(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onEnablingDfuMode(stringExtra);
                                    return;
                                }
                                return;
                            case DfuBaseService.PROGRESS_STARTING /*-2*/:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onDeviceConnected(stringExtra);
                                    dfuProgressListener.onDfuProcessStarting(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onDeviceConnected(stringExtra);
                                    dfuProgressListener2.onDfuProcessStarting(stringExtra);
                                    return;
                                }
                                return;
                            case -1:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onDeviceConnecting(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onDeviceConnecting(stringExtra);
                                    return;
                                }
                                return;
                            default:
                                if (i == 0) {
                                    if (dfuProgressListener != null) {
                                        dfuProgressListener.onDfuProcessStarted(stringExtra);
                                    }
                                    if (dfuProgressListener2 != null) {
                                        dfuProgressListener2.onDfuProcessStarted(stringExtra);
                                    }
                                }
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onProgressChanged(stringExtra, i, floatExtra, floatExtra2, intExtra, intExtra2);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onProgressChanged(stringExtra, i, floatExtra, floatExtra2, intExtra, intExtra2);
                                    return;
                                }
                                return;
                        }
                    case 1:
                        i = intent.getIntExtra(DfuBaseService.EXTRA_DATA, 0);
                        int intExtra3 = intent.getIntExtra(DfuBaseService.EXTRA_ERROR_TYPE, 0);
                        if (dfuProgressListener != null) {
                            dfuProgressListener.onDeviceDisconnected(stringExtra);
                        }
                        if (dfuProgressListener2 != null) {
                            dfuProgressListener2.onDeviceDisconnected(stringExtra);
                        }
                        switch (intExtra3) {
                            case 1:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onError(stringExtra, i, intExtra3, C3082a.m17406a(i));
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onError(stringExtra, i, intExtra3, C3082a.m17406a(i));
                                    return;
                                }
                                return;
                            default:
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onError(stringExtra, i, intExtra3, C3082a.m17407b(i));
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onError(stringExtra, i, intExtra3, C3082a.m17407b(i));
                                    return;
                                }
                                return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    public static void registerProgressListener(Context context, DfuProgressListener dfuProgressListener) {
        if (mProgressBroadcastReceiver == null) {
            mProgressBroadcastReceiver = new ProgressBroadcastsReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_PROGRESS);
            intentFilter.addAction(DfuBaseService.BROADCAST_ERROR);
            C0429i.m2924a(context).m2928a(mProgressBroadcastReceiver, intentFilter);
        }
        mProgressBroadcastReceiver.setProgressListener(dfuProgressListener);
    }

    public static void registerProgressListener(Context context, DfuProgressListener dfuProgressListener, String str) {
        if (mProgressBroadcastReceiver == null) {
            mProgressBroadcastReceiver = new ProgressBroadcastsReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_PROGRESS);
            intentFilter.addAction(DfuBaseService.BROADCAST_ERROR);
            C0429i.m2924a(context).m2928a(mProgressBroadcastReceiver, intentFilter);
        }
        mProgressBroadcastReceiver.setProgressListener(str, dfuProgressListener);
    }

    public static void unregisterProgressListener(Context context, DfuProgressListener dfuProgressListener) {
        if (mProgressBroadcastReceiver != null && mProgressBroadcastReceiver.removeProgressListener(dfuProgressListener)) {
            C0429i.m2924a(context).m2927a(mProgressBroadcastReceiver);
            mProgressBroadcastReceiver = null;
        }
    }

    public static void registerLogListener(Context context, DfuLogListener dfuLogListener) {
        if (mLogBroadcastReceiver == null) {
            mLogBroadcastReceiver = new LogBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_LOG);
            C0429i.m2924a(context).m2928a(mLogBroadcastReceiver, intentFilter);
        }
        mLogBroadcastReceiver.setLogListener(dfuLogListener);
    }

    public static void registerLogListener(Context context, DfuLogListener dfuLogListener, String str) {
        if (mLogBroadcastReceiver == null) {
            mLogBroadcastReceiver = new LogBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_LOG);
            C0429i.m2924a(context).m2928a(mLogBroadcastReceiver, intentFilter);
        }
        mLogBroadcastReceiver.setLogListener(str, dfuLogListener);
    }

    public static void unregisterLogListener(Context context, DfuLogListener dfuLogListener) {
        if (mLogBroadcastReceiver != null && mLogBroadcastReceiver.removeLogListener(dfuLogListener)) {
            C0429i.m2924a(context).m2927a(mLogBroadcastReceiver);
            mLogBroadcastReceiver = null;
        }
    }

    private static String getIncrementedAddress(String str) {
        String substring = str.substring(0, 15);
        return substring + String.format("%02X", new Object[]{Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255)});
    }
}
