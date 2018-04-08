package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.av.C0326d;
import android.support.v4.p021b.C0429i;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;
import net.sqlcipher.database.SQLiteDatabase;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

public abstract class DfuBaseService extends IntentService {
    public static final int ACTION_ABORT = 2;
    public static final int ACTION_PAUSE = 0;
    public static final int ACTION_RESUME = 1;
    public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
    public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
    public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
    public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
    private static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    private static final UUID DFU_CONTROL_POINT_UUID = new UUID(23300500811742L, 1523193452336828707L);
    private static final UUID DFU_PACKET_UUID = new UUID(23304795779038L, 1523193452336828707L);
    private static final UUID DFU_SERVICE_UUID = new UUID(23296205844446L, 1523193452336828707L);
    public static final int DFU_STATUS_CRC_ERROR = 5;
    public static final int DFU_STATUS_DATA_SIZE_EXCEEDS_LIMIT = 4;
    public static final int DFU_STATUS_INVALID_STATE = 2;
    public static final int DFU_STATUS_NOT_SUPPORTED = 3;
    public static final int DFU_STATUS_OPERATION_FAILED = 6;
    public static final int DFU_STATUS_SUCCESS = 1;
    private static final UUID DFU_VERSION = new UUID(23313385713630L, 1523193452336828707L);
    public static final int ERROR_BLUETOOTH_DISABLED = 4106;
    public static final int ERROR_CHARACTERISTICS_NOT_FOUND = 4103;
    public static final int ERROR_CONNECTION_MASK = 16384;
    public static final int ERROR_CONNECTION_STATE_MASK = 32768;
    public static final int ERROR_DEVICE_DISCONNECTED = 4096;
    public static final int ERROR_FILE_ERROR = 4098;
    public static final int ERROR_FILE_INVALID = 4099;
    public static final int ERROR_FILE_IO_EXCEPTION = 4100;
    public static final int ERROR_FILE_NOT_FOUND = 4097;
    public static final int ERROR_FILE_SIZE_INVALID = 4108;
    public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
    public static final int ERROR_INIT_PACKET_REQUIRED = 4107;
    public static final int ERROR_INVALID_RESPONSE = 4104;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_REMOTE_MASK = 8192;
    public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
    public static final int ERROR_SERVICE_NOT_FOUND = 4102;
    public static final int ERROR_TYPE_COMMUNICATION = 2;
    public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
    public static final int ERROR_TYPE_DFU_REMOTE = 3;
    public static final int ERROR_TYPE_OTHER = 0;
    public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
    private static final String EXTRA_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_ATTEMPT";
    public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
    public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
    public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
    public static final String EXTRA_DISABLE_NOTIFICATION = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
    public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
    public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
    public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
    public static final String EXTRA_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
    public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
    public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
    public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
    public static final String EXTRA_INIT_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
    public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
    public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
    public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
    public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
    public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
    public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
    public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
    public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
    private static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final int INDICATIONS = 2;
    public static final int LOG_LEVEL_APPLICATION = 10;
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 20;
    public static final int LOG_LEVEL_INFO = 5;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 15;
    private static final int MAX_PACKET_SIZE = 20;
    public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_ZIP = "application/zip";
    private static final int NOTIFICATIONS = 1;
    public static final int NOTIFICATION_ID = 283;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET = new byte[]{(byte) 5};
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{(byte) 2, (byte) 1};
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START = new byte[]{(byte) 2, (byte) 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{(byte) 8, (byte) 0, (byte) 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{(byte) 3};
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET = new byte[]{(byte) 6};
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU = new byte[]{(byte) 1, (byte) 0};
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_VALIDATE = new byte[]{(byte) 4};
    private static final int OP_CODE_VALIDATE_KEY = 4;
    public static final int PROGRESS_ABORTED = -7;
    public static final int PROGRESS_COMPLETED = -6;
    public static final int PROGRESS_CONNECTING = -1;
    public static final int PROGRESS_DISCONNECTING = -5;
    public static final int PROGRESS_ENABLING_DFU_MODE = -3;
    public static final int PROGRESS_STARTING = -2;
    public static final int PROGRESS_VALIDATING = -4;
    private static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    private static final int STATE_CLOSED = -5;
    private static final int STATE_CONNECTED = -2;
    private static final int STATE_CONNECTED_AND_READY = -3;
    private static final int STATE_CONNECTING = -1;
    private static final int STATE_DISCONNECTED = 0;
    private static final int STATE_DISCONNECTING = -4;
    private static final String TAG = "DfuBaseService";
    public static final int TYPE_APPLICATION = 4;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_BOOTLOADER = 2;
    public static final int TYPE_SOFT_DEVICE = 1;
    private boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBondStateBroadcastReceiver = new C30853();
    private final byte[] mBuffer = new byte[20];
    private int mBytesConfirmed;
    private int mBytesSent;
    private int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver = new C30831();
    private String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver = new C30842();
    private boolean mDisableNotification;
    private int mError;
    private int mFileType;
    private final BluetoothGattCallback mGattCallback = new C30864();
    private int mImageSizeInBytes;
    private boolean mImageSizeSent;
    private boolean mInitPacketSent;
    private InputStream mInputStream;
    private int mLastBytesSent;
    private long mLastNotificationTime;
    private int mLastProgress = -1;
    private long mLastProgressTime;
    private final Object mLock = new Object();
    private boolean mNotificationsEnabled;
    private int mPacketsBeforeNotification = 10;
    private int mPacketsSentSinceNotification;
    private int mPartCurrent;
    private int mPartsTotal;
    private boolean mPaused;
    private byte[] mReceivedData = null;
    private boolean mRemoteErrorOccurred;
    private boolean mRequestCompleted;
    private boolean mResetRequestSent;
    private boolean mServiceChangedIndicationsEnabled;
    private long mStartTime;

    class C30831 extends BroadcastReceiver {
        C30831() {
        }

        public void onReceive(Context context, Intent intent) {
            if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                DfuBaseService.this.logi("Action received: " + intent.getAction());
                DfuBaseService.this.mConnectionState = 0;
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }
        }
    }

    class C30842 extends BroadcastReceiver {
        C30842() {
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_ACTION, 0);
            DfuBaseService.this.logi("User action received: " + intExtra);
            switch (intExtra) {
                case 0:
                    DfuBaseService.this.mPaused = true;
                    return;
                case 1:
                    DfuBaseService.this.mPaused = false;
                    synchronized (DfuBaseService.this.mLock) {
                        DfuBaseService.this.mLock.notifyAll();
                    }
                    return;
                case 2:
                    DfuBaseService.this.mPaused = false;
                    DfuBaseService.this.mAborted = true;
                    synchronized (DfuBaseService.this.mLock) {
                        DfuBaseService.this.mLock.notifyAll();
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C30853 extends BroadcastReceiver {
        C30853() {
        }

        public void onReceive(Context context, Intent intent) {
            if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress) && intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1) != 11) {
                DfuBaseService.this.mRequestCompleted = true;
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }
        }
    }

    class C30864 extends BluetoothGattCallback {
        C30864() {
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i != 0) {
                DfuBaseService.this.loge("Connection state change error: " + i + " newState: " + i2);
                if (i2 == 0) {
                    DfuBaseService.this.mConnectionState = 0;
                }
                DfuBaseService.this.mPaused = false;
                DfuBaseService.this.mError = DfuBaseService.ERROR_CONNECTION_STATE_MASK | i;
            } else if (i2 == 2) {
                DfuBaseService.this.logi("Connected to GATT server");
                DfuBaseService.this.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                DfuBaseService.this.mConnectionState = -2;
                if (bluetoothGatt.getDevice().getBondState() == 12) {
                    try {
                        synchronized (this) {
                            DfuBaseService.this.logd("Waiting 1600 ms for a possible Service Changed indication...");
                            DfuBaseService.this.sendLogBroadcast(0, "wait(1600)");
                            wait(1600);
                        }
                    } catch (InterruptedException e) {
                    }
                }
                DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                boolean discoverServices = bluetoothGatt.discoverServices();
                DfuBaseService.this.logi("Attempting to start service discovery... " + (discoverServices ? "succeed" : "failed"));
                if (!discoverServices) {
                    DfuBaseService.this.mError = DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
                } else {
                    return;
                }
            } else if (i2 == 0) {
                DfuBaseService.this.logi("Disconnected from GATT server");
                DfuBaseService.this.mPaused = false;
                DfuBaseService.this.mConnectionState = 0;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                DfuBaseService.this.logi("Services discovered");
                DfuBaseService.this.mConnectionState = -3;
            } else {
                DfuBaseService.this.loge("Service discovery error: " + i);
                DfuBaseService.this.mError = i | DfuBaseService.ERROR_CONNECTION_MASK;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            boolean z = false;
            if (i != 0) {
                DfuBaseService.this.loge("Descriptor read error: " + i);
                DfuBaseService.this.mError = i | DfuBaseService.ERROR_CONNECTION_MASK;
            } else if (DfuBaseService.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid()) && DfuBaseService.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                DfuBaseService dfuBaseService = DfuBaseService.this;
                if (bluetoothGattDescriptor.getValue()[0] == (byte) 2) {
                    z = true;
                }
                dfuBaseService.mServiceChangedIndicationsEnabled = z;
                DfuBaseService.this.mRequestCompleted = true;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            boolean z = false;
            if (i != 0) {
                DfuBaseService.this.loge("Descriptor write error: " + i);
                DfuBaseService.this.mError = i | DfuBaseService.ERROR_CONNECTION_MASK;
            } else if (DfuBaseService.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid())) {
                DfuBaseService dfuBaseService;
                if (DfuBaseService.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                    dfuBaseService = DfuBaseService.this;
                    if (bluetoothGattDescriptor.getValue()[0] == (byte) 2) {
                        z = true;
                    }
                    dfuBaseService.mServiceChangedIndicationsEnabled = z;
                    DfuBaseService.this.sendLogBroadcast(1, "Indications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                } else {
                    dfuBaseService = DfuBaseService.this;
                    if (bluetoothGattDescriptor.getValue()[0] == (byte) 1) {
                        z = true;
                    }
                    dfuBaseService.mNotificationsEnabled = z;
                    DfuBaseService.this.sendLogBroadcast(1, "Notifications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                }
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            boolean z = true;
            if (i == 0) {
                if (!DfuBaseService.DFU_PACKET_UUID.equals(bluetoothGattCharacteristic.getUuid())) {
                    DfuBaseService.this.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                    DfuBaseService.this.mRequestCompleted = true;
                } else if (DfuBaseService.this.mImageSizeSent && DfuBaseService.this.mInitPacketSent) {
                    DfuBaseService.this.mBytesSent = DfuBaseService.this.mBytesSent + bluetoothGattCharacteristic.getValue().length;
                    DfuBaseService.this.mPacketsSentSinceNotification = DfuBaseService.this.mPacketsSentSinceNotification + 1;
                    boolean z2 = DfuBaseService.this.mPacketsBeforeNotification > 0 && DfuBaseService.this.mPacketsSentSinceNotification == DfuBaseService.this.mPacketsBeforeNotification;
                    if (DfuBaseService.this.mBytesSent != DfuBaseService.this.mImageSizeInBytes) {
                        z = false;
                    }
                    if (!z2 && !r1) {
                        try {
                            DfuBaseService.this.waitIfPaused();
                            if (DfuBaseService.this.mAborted || DfuBaseService.this.mError != 0 || DfuBaseService.this.mRemoteErrorOccurred || DfuBaseService.this.mResetRequestSent) {
                                synchronized (DfuBaseService.this.mLock) {
                                    DfuBaseService.this.sendLogBroadcast(15, "Upload terminated");
                                    DfuBaseService.this.mLock.notifyAll();
                                }
                                return;
                            }
                            byte[] access$2500 = DfuBaseService.this.mBuffer;
                            DfuBaseService.this.writePacket(bluetoothGatt, bluetoothGattCharacteristic, access$2500, DfuBaseService.this.mInputStream.read(access$2500));
                            DfuBaseService.this.updateProgressNotification();
                            return;
                        } catch (HexFileValidationException e) {
                            DfuBaseService.this.loge("Invalid HEX file");
                            DfuBaseService.this.mError = DfuBaseService.ERROR_FILE_INVALID;
                        } catch (Throwable e2) {
                            DfuBaseService.this.loge("Error while reading the input stream", e2);
                            DfuBaseService.this.mError = DfuBaseService.ERROR_FILE_IO_EXCEPTION;
                        }
                    } else {
                        return;
                    }
                } else if (DfuBaseService.this.mImageSizeSent) {
                    DfuBaseService.this.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                    DfuBaseService.this.mInitPacketSent = true;
                } else {
                    DfuBaseService.this.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                    DfuBaseService.this.mImageSizeSent = true;
                }
            } else if (DfuBaseService.this.mResetRequestSent) {
                DfuBaseService.this.mRequestCompleted = true;
            } else {
                DfuBaseService.this.loge("Characteristic write error: " + i);
                DfuBaseService.this.mError = i | DfuBaseService.ERROR_CONNECTION_MASK;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                DfuBaseService.this.sendLogBroadcast(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                DfuBaseService.this.mReceivedData = bluetoothGattCharacteristic.getValue();
                DfuBaseService.this.mRequestCompleted = true;
            } else {
                DfuBaseService.this.loge("Characteristic read error: " + i);
                DfuBaseService.this.mError = i | DfuBaseService.ERROR_CONNECTION_MASK;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            switch (bluetoothGattCharacteristic.getIntValue(17, 0).intValue()) {
                case 17:
                    BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(DfuBaseService.DFU_SERVICE_UUID).getCharacteristic(DfuBaseService.DFU_PACKET_UUID);
                    try {
                        DfuBaseService.this.mBytesConfirmed = bluetoothGattCharacteristic.getIntValue(20, 1).intValue();
                        DfuBaseService.this.mPacketsSentSinceNotification = 0;
                        DfuBaseService.this.waitIfPaused();
                        if (DfuBaseService.this.mAborted || DfuBaseService.this.mError != 0 || DfuBaseService.this.mRemoteErrorOccurred || DfuBaseService.this.mResetRequestSent) {
                            DfuBaseService.this.sendLogBroadcast(15, "Upload terminated");
                            break;
                        }
                        byte[] access$2500 = DfuBaseService.this.mBuffer;
                        DfuBaseService.this.writePacket(bluetoothGatt, characteristic, access$2500, DfuBaseService.this.mInputStream.read(access$2500));
                        DfuBaseService.this.updateProgressNotification();
                        return;
                    } catch (HexFileValidationException e) {
                        DfuBaseService.this.loge("Invalid HEX file");
                        DfuBaseService.this.mError = DfuBaseService.ERROR_FILE_INVALID;
                        break;
                    } catch (Throwable e2) {
                        DfuBaseService.this.loge("Error while reading the input stream", e2);
                        DfuBaseService.this.mError = DfuBaseService.ERROR_FILE_IO_EXCEPTION;
                        break;
                    }
                    break;
                default:
                    if (!DfuBaseService.this.mRemoteErrorOccurred) {
                        if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                            DfuBaseService.this.mRemoteErrorOccurred = true;
                        }
                        DfuBaseService.this.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                        DfuBaseService.this.mReceivedData = bluetoothGattCharacteristic.getValue();
                        break;
                    }
                    break;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        private String parse(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (value == null) {
                return "";
            }
            int length = value.length;
            if (length == 0) {
                return "";
            }
            char[] cArr = new char[((length * 3) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = value[i] & 255;
                cArr[i * 3] = DfuBaseService.HEX_ARRAY[i2 >>> 4];
                cArr[(i * 3) + 1] = DfuBaseService.HEX_ARRAY[i2 & 15];
                if (i != length - 1) {
                    cArr[(i * 3) + 2] = '-';
                }
            }
            return new String(cArr);
        }
    }

    protected abstract Class<? extends Activity> getNotificationTarget();

    public DfuBaseService() {
        super(TAG);
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        return intentFilter;
    }

    public void onCreate() {
        super.onCreate();
        initialize();
        C0429i a = C0429i.m2924a((Context) this);
        IntentFilter makeDfuActionIntentFilter = makeDfuActionIntentFilter();
        a.m2928a(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        registerReceiver(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        registerReceiver(this.mConnectionStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        registerReceiver(this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
    }

    public void onDestroy() {
        super.onDestroy();
        C0429i.m2924a((Context) this).m2927a(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onHandleIntent(android.content.Intent r21) {
        /*
        r20 = this;
        r9 = android.preference.PreferenceManager.getDefaultSharedPreferences(r20);
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
        r0 = r21;
        r13 = r0.getStringExtra(r4);
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
        r0 = r21;
        r8 = r0.getStringExtra(r4);
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
        r5 = 0;
        r0 = r21;
        r10 = r0.getBooleanExtra(r4, r5);
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
        r0 = r21;
        r11 = r0.getStringExtra(r4);
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
        r0 = r21;
        r4 = r0.getParcelableExtra(r4);
        r4 = (android.net.Uri) r4;
        r5 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
        r6 = 0;
        r0 = r21;
        r12 = r0.getIntExtra(r5, r6);
        r5 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
        r0 = r21;
        r14 = r0.getStringExtra(r5);
        r5 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
        r0 = r21;
        r5 = r0.getParcelableExtra(r5);
        r5 = (android.net.Uri) r5;
        r6 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
        r7 = 0;
        r0 = r21;
        r15 = r0.getIntExtra(r6, r7);
        r6 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
        r7 = 0;
        r0 = r21;
        r6 = r0.getIntExtra(r6, r7);
        if (r11 == 0) goto L_0x006f;
    L_0x005e:
        if (r6 != 0) goto L_0x006f;
    L_0x0060:
        r6 = java.util.Locale.US;
        r6 = r11.toLowerCase(r6);
        r7 = "zip";
        r6 = r6.endsWith(r7);
        if (r6 == 0) goto L_0x00d1;
    L_0x006e:
        r6 = 0;
    L_0x006f:
        r7 = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
        r0 = r21;
        r7 = r0.getStringExtra(r7);
        if (r7 == 0) goto L_0x00d3;
    L_0x0079:
        r16 = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
        r17 = 1;
        r0 = r21;
        r1 = r16;
        r2 = r17;
        r16 = r0.getIntExtra(r1, r2);
        r0 = r16;
        r1 = r20;
        r1.mPartCurrent = r0;
        r16 = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
        r17 = 1;
        r0 = r21;
        r1 = r16;
        r2 = r17;
        r16 = r0.getIntExtra(r1, r2);
        r0 = r16;
        r1 = r20;
        r1.mPartsTotal = r0;
        r16 = r6 & -8;
        if (r16 > 0) goto L_0x00b9;
    L_0x00a5:
        r16 = "application/zip";
        r0 = r16;
        r16 = r0.equals(r7);
        if (r16 != 0) goto L_0x00db;
    L_0x00af:
        r16 = "application/octet-stream";
        r0 = r16;
        r16 = r0.equals(r7);
        if (r16 != 0) goto L_0x00db;
    L_0x00b9:
        r4 = "File type or file mime-type not supported";
        r0 = r20;
        r0.logw(r4);
        r4 = 15;
        r5 = "File type or file mime-type not supported";
        r0 = r20;
        r0.sendLogBroadcast(r4, r5);
        r4 = 4105; // 0x1009 float:5.752E-42 double:2.028E-320;
        r0 = r20;
        r0.sendErrorBroadcast(r4);
    L_0x00d0:
        return;
    L_0x00d1:
        r6 = 4;
        goto L_0x006f;
    L_0x00d3:
        if (r6 != 0) goto L_0x00d8;
    L_0x00d5:
        r7 = "application/zip";
        goto L_0x0079;
    L_0x00d8:
        r7 = "application/octet-stream";
        goto L_0x0079;
    L_0x00db:
        r16 = "application/octet-stream";
        r0 = r16;
        r16 = r0.equals(r7);
        if (r16 == 0) goto L_0x010f;
    L_0x00e5:
        r16 = 1;
        r0 = r16;
        if (r6 == r0) goto L_0x010f;
    L_0x00eb:
        r16 = 2;
        r0 = r16;
        if (r6 == r0) goto L_0x010f;
    L_0x00f1:
        r16 = 4;
        r0 = r16;
        if (r6 == r0) goto L_0x010f;
    L_0x00f7:
        r4 = "Unable to determine file type";
        r0 = r20;
        r0.logw(r4);
        r4 = 15;
        r5 = "Unable to determine file type";
        r0 = r20;
        r0.sendLogBroadcast(r4, r5);
        r4 = 4105; // 0x1009 float:5.752E-42 double:2.028E-320;
        r0 = r20;
        r0.sendErrorBroadcast(r4);
        goto L_0x00d0;
    L_0x010f:
        r0 = r20;
        r0.mDeviceAddress = r13;
        r0 = r20;
        r0.mDeviceName = r8;
        r0 = r20;
        r0.mDisableNotification = r10;
        r8 = 0;
        r0 = r20;
        r0.mConnectionState = r8;
        r8 = 0;
        r0 = r20;
        r0.mBytesSent = r8;
        r8 = 0;
        r0 = r20;
        r0.mBytesConfirmed = r8;
        r8 = 0;
        r0 = r20;
        r0.mPacketsSentSinceNotification = r8;
        r8 = 0;
        r0 = r20;
        r0.mError = r8;
        r16 = 0;
        r0 = r16;
        r2 = r20;
        r2.mLastProgressTime = r0;
        r8 = 0;
        r0 = r20;
        r0.mAborted = r8;
        r8 = 0;
        r0 = r20;
        r0.mPaused = r8;
        r8 = 0;
        r0 = r20;
        r0.mNotificationsEnabled = r8;
        r8 = 0;
        r0 = r20;
        r0.mResetRequestSent = r8;
        r8 = 0;
        r0 = r20;
        r0.mRequestCompleted = r8;
        r8 = 0;
        r0 = r20;
        r0.mImageSizeSent = r8;
        r8 = 0;
        r0 = r20;
        r0.mRemoteErrorOccurred = r8;
        r8 = "settings_packet_receipt_notification_enabled";
        r10 = 1;
        r10 = r9.getBoolean(r8, r10);
        r8 = "settings_number_of_packets";
        r16 = 12;
        r16 = java.lang.String.valueOf(r16);
        r0 = r16;
        r8 = r9.getString(r8, r0);
        r8 = java.lang.Integer.parseInt(r8);	 Catch:{ NumberFormatException -> 0x0206 }
        if (r8 < 0) goto L_0x0181;
    L_0x017a:
        r16 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r0 = r16;
        if (r8 <= r0) goto L_0x0183;
    L_0x0181:
        r8 = 12;
    L_0x0183:
        if (r10 != 0) goto L_0x0186;
    L_0x0185:
        r8 = 0;
    L_0x0186:
        r0 = r20;
        r0.mPacketsBeforeNotification = r8;
        r8 = "settings_mbr_size";
        r10 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r10 = java.lang.String.valueOf(r10);
        r8 = r9.getString(r8, r10);
        r8 = java.lang.Integer.parseInt(r8);	 Catch:{ NumberFormatException -> 0x020b }
        if (r8 >= 0) goto L_0x019d;
    L_0x019c:
        r8 = 0;
    L_0x019d:
        r10 = "settings_assume_dfu_mode";
        r16 = 0;
        r0 = r16;
        r16 = r9.getBoolean(r10, r0);
        r9 = 1;
        r10 = "DFU service started";
        r0 = r20;
        r0.sendLogBroadcast(r9, r10);
        r10 = 0;
        r9 = 0;
        r17 = 1;
        r18 = "Opening file...";
        r0 = r20;
        r1 = r17;
        r2 = r18;
        r0.sendLogBroadcast(r1, r2);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        if (r4 == 0) goto L_0x020f;
    L_0x01c0:
        r0 = r20;
        r10 = r0.openInputStream(r4, r7, r8, r6);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
    L_0x01c6:
        if (r5 == 0) goto L_0x0221;
    L_0x01c8:
        r4 = r20.getContentResolver();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = r4.openInputStream(r5);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
    L_0x01d0:
        r0 = r20;
        r0.mInputStream = r10;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r12 = r10.available();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r0 = r20;
        r0.mImageSizeInBytes = r12;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r4 = r12 % 4;
        if (r4 == 0) goto L_0x0253;
    L_0x01e0:
        r4 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = "The new firmware is not word-aligned.";
        r4.<init>(r5);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        throw r4;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
    L_0x01e8:
        r4 = move-exception;
        r5 = "A security exception occurred while opening file";
        r0 = r20;
        r0.loge(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x0203 }
        if (r10 == 0) goto L_0x00d0;
    L_0x01fe:
        r10.close();	 Catch:{ IOException -> 0x0203 }
        goto L_0x00d0;
    L_0x0203:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x0206:
        r8 = move-exception;
        r8 = 12;
        goto L_0x0183;
    L_0x020b:
        r8 = move-exception;
        r8 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        goto L_0x019d;
    L_0x020f:
        if (r11 == 0) goto L_0x0218;
    L_0x0211:
        r0 = r20;
        r10 = r0.openInputStream(r11, r7, r8, r6);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        goto L_0x01c6;
    L_0x0218:
        if (r12 <= 0) goto L_0x01c6;
    L_0x021a:
        r0 = r20;
        r10 = r0.openInputStream(r12, r7, r8, r6);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        goto L_0x01c6;
    L_0x0221:
        if (r14 == 0) goto L_0x0247;
    L_0x0223:
        r5 = new java.io.FileInputStream;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5.<init>(r14);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        goto L_0x01d0;
    L_0x0229:
        r4 = move-exception;
        r5 = "An exception occurred while opening file";
        r0 = r20;
        r0.loge(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x0244 }
        if (r10 == 0) goto L_0x00d0;
    L_0x023f:
        r10.close();	 Catch:{ IOException -> 0x0244 }
        goto L_0x00d0;
    L_0x0244:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x0247:
        if (r15 <= 0) goto L_0x105f;
    L_0x0249:
        r4 = r20.getResources();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = r4.openRawResource(r15);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        goto L_0x01d0;
    L_0x0253:
        if (r6 != 0) goto L_0x105c;
    L_0x0255:
        r4 = "application/zip";
        r4 = r4.equals(r7);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        if (r4 == 0) goto L_0x105c;
    L_0x025d:
        r0 = r10;
        r0 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r0;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r4 = r0;
        r6 = r4.getContentType();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r11 = r6;
    L_0x0266:
        r0 = r20;
        r0.mFileType = r11;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r4 = "application/zip";
        r4 = r4.equals(r7);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        if (r4 == 0) goto L_0x1059;
    L_0x0272:
        r0 = r10;
        r0 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r0;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r4 = r0;
        r6 = r11 & 4;
        if (r6 <= 0) goto L_0x02a8;
    L_0x027a:
        r6 = r4.applicationImageSize();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r6 = r6 % 4;
        if (r6 == 0) goto L_0x02a8;
    L_0x0282:
        r4 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = "Application firmware is not word-aligned.";
        r4.<init>(r5);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        throw r4;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
    L_0x028a:
        r4 = move-exception;
        r5 = "Firmware not word-aligned";
        r0 = r20;
        r0.loge(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 4108; // 0x100c float:5.757E-42 double:2.0296E-320;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x02a5 }
        if (r10 == 0) goto L_0x00d0;
    L_0x02a0:
        r10.close();	 Catch:{ IOException -> 0x02a5 }
        goto L_0x00d0;
    L_0x02a5:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x02a8:
        r6 = r11 & 2;
        if (r6 <= 0) goto L_0x02da;
    L_0x02ac:
        r6 = r4.bootloaderImageSize();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r6 = r6 % 4;
        if (r6 == 0) goto L_0x02da;
    L_0x02b4:
        r4 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = "Bootloader firmware is not word-aligned.";
        r4.<init>(r5);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        throw r4;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
    L_0x02bc:
        r4 = move-exception;
        r5 = "An exception occurred while calculating file size";
        r0 = r20;
        r0.loge(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x02d7 }
        if (r10 == 0) goto L_0x00d0;
    L_0x02d2:
        r10.close();	 Catch:{ IOException -> 0x02d7 }
        goto L_0x00d0;
    L_0x02d7:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x02da:
        r6 = r11 & 1;
        if (r6 <= 0) goto L_0x030c;
    L_0x02de:
        r6 = r4.softDeviceImageSize();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r6 = r6 % 4;
        if (r6 == 0) goto L_0x030c;
    L_0x02e6:
        r4 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = "Soft Device firmware is not word-aligned.";
        r4.<init>(r5);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        throw r4;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
    L_0x02ee:
        r4 = move-exception;
        r5 = "An exception occurred while opening files. Did you set the firmware file?";
        r0 = r20;
        r0.loge(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x0309 }
        if (r10 == 0) goto L_0x00d0;
    L_0x0304:
        r10.close();	 Catch:{ IOException -> 0x0309 }
        goto L_0x00d0;
    L_0x0309:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x030c:
        r6 = 4;
        if (r11 != r6) goto L_0x038f;
    L_0x030f:
        r6 = r4.getApplicationInit();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        if (r6 == 0) goto L_0x1059;
    L_0x0315:
        r5 = new java.io.ByteArrayInputStream;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r4 = r4.getApplicationInit();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5.<init>(r4);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r14 = r5;
    L_0x031f:
        r4 = 5;
        r5 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5.<init>();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r6 = "Image file opened (";
        r5 = r5.append(r6);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r0 = r20;
        r6 = r0.mImageSizeInBytes;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = r5.append(r6);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r6 = " bytes in total)";
        r5 = r5.append(r6);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5 = r5.toString();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r0 = r20;
        r0.sendLogBroadcast(r4, r5);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        monitor-enter(r20);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r5 = "wait(1000)";
        r0 = r20;
        r0.sendLogBroadcast(r4, r5);	 Catch:{ InterruptedException -> 0x1053 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r20;
        r0.wait(r4);	 Catch:{ InterruptedException -> 0x1053 }
    L_0x0352:
        monitor-exit(r20);	 Catch:{ all -> 0x03a0 }
        r4 = 1;
        r5 = "Connecting to DFU target...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r5);	 Catch:{ all -> 0x03a3 }
        r4 = -1;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r5 = r0.connect(r13);	 Catch:{ all -> 0x03a3 }
        if (r5 != 0) goto L_0x03af;
    L_0x0369:
        r4 = "Bluetooth adapter disabled";
        r0 = r20;
        r0.loge(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 20;
        r5 = "Bluetooth adapter disabled";
        r0 = r20;
        r0.sendLogBroadcast(r4, r5);	 Catch:{ all -> 0x03a3 }
        r4 = 4106; // 0x100a float:5.754E-42 double:2.0286E-320;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x038c }
        if (r10 == 0) goto L_0x00d0;
    L_0x0387:
        r10.close();	 Catch:{ IOException -> 0x038c }
        goto L_0x00d0;
    L_0x038c:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x038f:
        r6 = r4.getSystemInit();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        if (r6 == 0) goto L_0x1059;
    L_0x0395:
        r5 = new java.io.ByteArrayInputStream;	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r4 = r4.getSystemInit();	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r5.<init>(r4);	 Catch:{ SecurityException -> 0x01e8, FileNotFoundException -> 0x0229, SizeValidationException -> 0x028a, IOException -> 0x02bc, Exception -> 0x02ee }
        r14 = r5;
        goto L_0x031f;
    L_0x03a0:
        r4 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x03a0 }
        throw r4;	 Catch:{ all -> 0x03a3 }
    L_0x03a3:
        r4 = move-exception;
        r5 = 0;
        r0 = r20;
        r0.mInputStream = r5;	 Catch:{ IOException -> 0x103b }
        if (r10 == 0) goto L_0x03ae;
    L_0x03ab:
        r10.close();	 Catch:{ IOException -> 0x103b }
    L_0x03ae:
        throw r4;
    L_0x03af:
        r0 = r20;
        r4 = r0.mError;	 Catch:{ all -> 0x03a3 }
        if (r4 <= 0) goto L_0x0462;
    L_0x03b5:
        r0 = r20;
        r4 = r0.mError;	 Catch:{ all -> 0x03a3 }
        r6 = -32769; // 0xffffffffffff7fff float:NaN double:NaN;
        r4 = r4 & r6;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x03a3 }
        r6.<init>();	 Catch:{ all -> 0x03a3 }
        r7 = "An error occurred while connecting to the device:";
        r6 = r6.append(r7);	 Catch:{ all -> 0x03a3 }
        r6 = r6.append(r4);	 Catch:{ all -> 0x03a3 }
        r6 = r6.toString();	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.loge(r6);	 Catch:{ all -> 0x03a3 }
        r6 = 20;
        r7 = "Connection failed (0x%02X): %s";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x03a3 }
        r9 = 0;
        r11 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x03a3 }
        r8[r9] = r11;	 Catch:{ all -> 0x03a3 }
        r9 = 1;
        r4 = no.nordicsemi.android.p123a.C3082a.m17406a(r4);	 Catch:{ all -> 0x03a3 }
        r8[r9] = r4;	 Catch:{ all -> 0x03a3 }
        r4 = java.lang.String.format(r7, r8);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.sendLogBroadcast(r6, r4);	 Catch:{ all -> 0x03a3 }
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_ATTEMPT";
        r6 = 0;
        r0 = r21;
        r4 = r0.getIntExtra(r4, r6);	 Catch:{ all -> 0x03a3 }
        if (r4 != 0) goto L_0x044a;
    L_0x03fe:
        r4 = 15;
        r6 = "Retrying...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r4 = r0.mConnectionState;	 Catch:{ all -> 0x03a3 }
        if (r4 == 0) goto L_0x0412;
    L_0x040d:
        r0 = r20;
        r0.disconnect(r5);	 Catch:{ all -> 0x03a3 }
    L_0x0412:
        r4 = 1;
        r0 = r20;
        r0.refreshDeviceCache(r5, r4);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.close(r5);	 Catch:{ all -> 0x03a3 }
        r4 = "Restarting the service";
        r0 = r20;
        r0.logi(r4);	 Catch:{ all -> 0x03a3 }
        r4 = new android.content.Intent;	 Catch:{ all -> 0x03a3 }
        r4.<init>();	 Catch:{ all -> 0x03a3 }
        r5 = 24;
        r0 = r21;
        r4.fillIn(r0, r5);	 Catch:{ all -> 0x03a3 }
        r5 = "no.nordicsemi.android.dfu.extra.EXTRA_ATTEMPT";
        r6 = 1;
        r4.putExtra(r5, r6);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.startService(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x0447 }
        if (r10 == 0) goto L_0x00d0;
    L_0x0442:
        r10.close();	 Catch:{ IOException -> 0x0447 }
        goto L_0x00d0;
    L_0x0447:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x044a:
        r0 = r20;
        r4 = r0.mError;	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x045f }
        if (r10 == 0) goto L_0x00d0;
    L_0x045a:
        r10.close();	 Catch:{ IOException -> 0x045f }
        goto L_0x00d0;
    L_0x045f:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x0462:
        r0 = r20;
        r4 = r0.mAborted;	 Catch:{ all -> 0x03a3 }
        if (r4 == 0) goto L_0x048d;
    L_0x0468:
        r4 = "Upload aborted";
        r0 = r20;
        r0.logi(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 15;
        r6 = "Upload aborted";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ all -> 0x03a3 }
        r4 = -7;
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x048a }
        if (r10 == 0) goto L_0x00d0;
    L_0x0485:
        r10.close();	 Catch:{ IOException -> 0x048a }
        goto L_0x00d0;
    L_0x048a:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x048d:
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_ATTEMPT";
        r6 = 0;
        r0 = r21;
        r0.putExtra(r4, r6);	 Catch:{ all -> 0x03a3 }
        r4 = DFU_SERVICE_UUID;	 Catch:{ all -> 0x03a3 }
        r4 = r5.getService(r4);	 Catch:{ all -> 0x03a3 }
        if (r4 != 0) goto L_0x04c3;
    L_0x049d:
        r4 = "DFU service does not exists on the device";
        r0 = r20;
        r0.loge(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 15;
        r6 = "Connected. DFU Service not found";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ all -> 0x03a3 }
        r4 = 4102; // 0x1006 float:5.748E-42 double:2.0267E-320;
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x04c0 }
        if (r10 == 0) goto L_0x00d0;
    L_0x04bb:
        r10.close();	 Catch:{ IOException -> 0x04c0 }
        goto L_0x00d0;
    L_0x04c0:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x04c3:
        r6 = DFU_CONTROL_POINT_UUID;	 Catch:{ all -> 0x03a3 }
        r15 = r4.getCharacteristic(r6);	 Catch:{ all -> 0x03a3 }
        r6 = DFU_PACKET_UUID;	 Catch:{ all -> 0x03a3 }
        r6 = r4.getCharacteristic(r6);	 Catch:{ all -> 0x03a3 }
        if (r15 == 0) goto L_0x04d3;
    L_0x04d1:
        if (r6 != 0) goto L_0x04f9;
    L_0x04d3:
        r4 = "DFU characteristics not found in the DFU service";
        r0 = r20;
        r0.loge(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 15;
        r6 = "Connected. DFU Characteristics not found";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ all -> 0x03a3 }
        r4 = 4103; // 0x1007 float:5.75E-42 double:2.027E-320;
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x04f6 }
        if (r10 == 0) goto L_0x00d0;
    L_0x04f1:
        r10.close();	 Catch:{ IOException -> 0x04f6 }
        goto L_0x00d0;
    L_0x04f6:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x04f9:
        r8 = DFU_VERSION;	 Catch:{ all -> 0x03a3 }
        r8 = r4.getCharacteristic(r8);	 Catch:{ all -> 0x03a3 }
        r4 = 5;
        r9 = "Services discovered";
        r0 = r20;
        r0.sendLogBroadcast(r4, r9);	 Catch:{ all -> 0x03a3 }
        monitor-enter(r20);	 Catch:{ all -> 0x03a3 }
        r4 = 0;
        r9 = "wait(1000)";
        r0 = r20;
        r0.sendLogBroadcast(r4, r9);	 Catch:{ InterruptedException -> 0x1050 }
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r20;
        r1 = r18;
        r0.wait(r1);	 Catch:{ InterruptedException -> 0x1050 }
    L_0x0519:
        monitor-exit(r20);	 Catch:{ all -> 0x0622 }
        r4 = -2;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 0;
        if (r8 == 0) goto L_0x0625;
    L_0x0523:
        r0 = r20;
        r4 = r0.readVersion(r5, r8);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r8 = r4 & 15;
        r9 = r4 >> 8;
        r13 = new java.lang.StringBuilder;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r13.<init>();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r17 = "Version number read: ";
        r0 = r17;
        r13 = r13.append(r0);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r13 = r13.append(r9);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r17 = ".";
        r0 = r17;
        r13 = r13.append(r0);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r13 = r13.append(r8);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r13 = r13.toString();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.logi(r13);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r13 = 10;
        r17 = new java.lang.StringBuilder;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r17.<init>();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r18 = "Version number read: ";
        r17 = r17.append(r18);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r17;
        r9 = r0.append(r9);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r17 = ".";
        r0 = r17;
        r9 = r9.append(r0);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r8 = r9.append(r8);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r8 = r8.toString();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.sendLogBroadcast(r13, r8);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r13 = r4;
    L_0x057c:
        r4 = 1;
        if (r13 == r4) goto L_0x058e;
    L_0x057f:
        if (r16 != 0) goto L_0x0714;
    L_0x0581:
        if (r13 != 0) goto L_0x0714;
    L_0x0583:
        r4 = r5.getServices();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = r4.size();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r8 = 3;
        if (r4 <= r8) goto L_0x0714;
    L_0x058e:
        r4 = "Application with buttonless update found";
        r0 = r20;
        r0.logw(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 15;
        r6 = "Application with buttonless update found";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 0;
        r6 = r5.getDevice();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = r6.getBondState();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r7 = 12;
        if (r6 != r7) goto L_0x063b;
    L_0x05ab:
        r6 = GENERIC_ATTRIBUTE_SERVICE_UUID;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = r5.getService(r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        if (r6 == 0) goto L_0x063b;
    L_0x05b3:
        r7 = SERVICE_CHANGED_UUID;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = r6.getCharacteristic(r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        if (r6 == 0) goto L_0x063b;
    L_0x05bb:
        r0 = r20;
        r4 = r0.isServiceChangedCCCDEnabled(r5, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        if (r4 != 0) goto L_0x0631;
    L_0x05c3:
        r4 = 2;
        r0 = r20;
        r0.enableCCCD(r5, r6, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 10;
        r6 = "Service Changed indications enabled";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
        r6 = 0;
        r0 = r21;
        r4 = r0.getBooleanExtra(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        if (r4 == 0) goto L_0x063a;
    L_0x05dd:
        r4 = r11 & 1;
        if (r4 != 0) goto L_0x063a;
    L_0x05e1:
        r4 = 1;
        r6 = "Restarting service...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.disconnect(r5);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.close(r5);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = "Restarting service";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 1;
        r6 = "Restarting service...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = new android.content.Intent;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4.<init>();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 24;
        r0 = r21;
        r4.fillIn(r0, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.startService(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x061f }
        if (r10 == 0) goto L_0x00d0;
    L_0x061a:
        r10.close();	 Catch:{ IOException -> 0x061f }
        goto L_0x00d0;
    L_0x061f:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x0622:
        r4 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x0622 }
        throw r4;	 Catch:{ all -> 0x03a3 }
    L_0x0625:
        r8 = 10;
        r9 = "DFU Version characteristic not found";
        r0 = r20;
        r0.sendLogBroadcast(r8, r9);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r13 = r4;
        goto L_0x057c;
    L_0x0631:
        r4 = 10;
        r6 = "Service Changed indications enabled";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
    L_0x063a:
        r4 = 1;
    L_0x063b:
        r6 = 1;
        r7 = "Jumping to the DFU Bootloader...";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 1;
        r0 = r20;
        r0.enableCCCD(r5, r15, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 10;
        r7 = "Notifications enabled";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        monitor-enter(r20);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 0;
        r7 = "wait(1000)";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ InterruptedException -> 0x104d }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r20;
        r0.wait(r6);	 Catch:{ InterruptedException -> 0x104d }
    L_0x0662:
        monitor-exit(r20);	 Catch:{ all -> 0x06c6 }
        r6 = -3;
        r0 = r20;
        r0.updateProgressNotification(r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = OP_CODE_START_DFU;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r7 = 1;
        r8 = 4;
        r6[r7] = r8;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = "Sending Start DFU command (Op Code = 1, Upload Mode = 4)";
        r0 = r20;
        r0.logi(r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = OP_CODE_START_DFU;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r7 = 1;
        r0 = r20;
        r0.writeOpCode(r5, r15, r6, r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 10;
        r7 = "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r20.waitUntilDisconnected();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 5;
        r7 = "Disconnected by the remote device";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        if (r4 != 0) goto L_0x0712;
    L_0x0694:
        r4 = 1;
    L_0x0695:
        r0 = r20;
        r0.refreshDeviceCache(r5, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.close(r5);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = "Starting service that will connect to the DFU bootloader";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = new android.content.Intent;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4.<init>();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 24;
        r0 = r21;
        r4.fillIn(r0, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.startService(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x06c3 }
        if (r10 == 0) goto L_0x00d0;
    L_0x06be:
        r10.close();	 Catch:{ IOException -> 0x06c3 }
        goto L_0x00d0;
    L_0x06c3:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x06c6:
        r4 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x06c6 }
        throw r4;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
    L_0x06c9:
        r4 = move-exception;
        r4 = "Upload aborted";
        r0 = r20;
        r0.logi(r4);	 Catch:{ all -> 0x03a3 }
        r4 = 15;
        r6 = "Upload aborted";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r4 = r0.mConnectionState;	 Catch:{ all -> 0x03a3 }
        r6 = -3;
        if (r4 != r6) goto L_0x06fd;
    L_0x06e1:
        r4 = 0;
        r0 = r20;
        r0.mAborted = r4;	 Catch:{ Exception -> 0x1041 }
        r4 = "Sending Reset command (Op Code = 6)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ Exception -> 0x1041 }
        r4 = OP_CODE_RESET;	 Catch:{ Exception -> 0x1041 }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ Exception -> 0x1041 }
        r4 = 10;
        r6 = "Reset request sent";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ Exception -> 0x1041 }
    L_0x06fd:
        r4 = -7;
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ all -> 0x03a3 }
    L_0x0703:
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x070f }
        if (r10 == 0) goto L_0x00d0;
    L_0x070a:
        r10.close();	 Catch:{ IOException -> 0x070f }
        goto L_0x00d0;
    L_0x070f:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x0712:
        r4 = 0;
        goto L_0x0695;
    L_0x0714:
        r4 = 5;
        if (r13 < r4) goto L_0x0750;
    L_0x0717:
        if (r14 != 0) goto L_0x0750;
    L_0x0719:
        r4 = new java.lang.StringBuilder;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4.<init>();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = "Init packet not set for the DFU Bootloader version ";
        r4 = r4.append(r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = r4.append(r13);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = r4.toString();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.logw(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 20;
        r6 = "The Init packet is required by this version DFU Bootloader";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 4107; // 0x100b float:5.755E-42 double:2.029E-320;
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x074d }
        if (r10 == 0) goto L_0x00d0;
    L_0x0748:
        r10.close();	 Catch:{ IOException -> 0x074d }
        goto L_0x00d0;
    L_0x074d:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x0750:
        r4 = 1;
        r0 = r20;
        r0.enableCCCD(r5, r15, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 10;
        r8 = "Notifications enabled";
        r0 = r20;
        r0.sendLogBroadcast(r4, r8);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        monitor-enter(r20);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 0;
        r8 = "wait(1000)";
        r0 = r20;
        r0.sendLogBroadcast(r4, r8);	 Catch:{ InterruptedException -> 0x104a }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r20;
        r0.wait(r8);	 Catch:{ InterruptedException -> 0x104a }
    L_0x076f:
        monitor-exit(r20);	 Catch:{ all -> 0x0911 }
        r4 = r11 & 1;
        if (r4 <= 0) goto L_0x0935;
    L_0x0774:
        r4 = r12;
    L_0x0775:
        r8 = r11 & 2;
        if (r8 <= 0) goto L_0x0938;
    L_0x0779:
        r8 = r12;
    L_0x077a:
        r9 = r11 & 4;
        if (r9 <= 0) goto L_0x093b;
    L_0x077e:
        r9 = r12;
    L_0x077f:
        r16 = "application/zip";
        r0 = r16;
        r7 = r0.equals(r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        if (r7 == 0) goto L_0x1056;
    L_0x0789:
        r0 = r10;
        r0 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r0;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r0;
        r7 = r4.softDeviceImageSize();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = r4.bootloaderImageSize();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = r4.applicationImageSize();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0799:
        r4 = OP_CODE_START_DFU;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = 1;
        r0 = (byte) r11;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = r0;
        r4[r16] = r17;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4.<init>();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = "Sending Start DFU command (Op Code = 1, Upload Mode = ";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r11);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = ")";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.toString();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.logi(r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = OP_CODE_START_DFU;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = 10;
        r16 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16.<init>();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = "DFU Start sent (Op Code = 1, Upload Mode = ";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r16;
        r16 = r0.append(r11);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = ")";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = r16.toString();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r1 = r16;
        r0.sendLogBroadcast(r4, r1);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4.<init>();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = "Sending image size array to DFU Packet (";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r7);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = "b, ";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r8);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = "b, ";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = "b)";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.toString();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.logi(r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r20;
        r4.writeImageSize(r5, r6, r7, r8, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = 10;
        r16 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16.<init>();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = "Firmware image size sent (";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r16;
        r16 = r0.append(r7);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = "b, ";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r16;
        r16 = r0.append(r8);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = "b, ";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r16;
        r9 = r0.append(r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = "b)";
        r0 = r16;
        r9 = r9.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r9 = r9.toString();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.sendLogBroadcast(r4, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r20.readNotificationResponse();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r9 = 1;
        r0 = r20;
        r9 = r0.getStatusCode(r4, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = 10;
        r17 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17.<init>();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r18 = "Response received (Op Code = ";
        r17 = r17.append(r18);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r18 = 1;
        r4 = r4[r18];	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r17;
        r4 = r0.append(r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = " Status = ";
        r0 = r17;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r17 = ")";
        r0 = r17;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = r4.toString();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r1 = r16;
        r0.sendLogBroadcast(r1, r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = 2;
        if (r9 != r4) goto L_0x093e;
    L_0x08ae:
        r4 = 15;
        r9 = "Last upload interrupted. Restarting device...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = -5;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = "Sending Reset command (Op Code = 6)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = OP_CODE_RESET;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = 10;
        r9 = "Reset request sent";
        r0 = r20;
        r0.sendLogBroadcast(r4, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r20.waitUntilDisconnected();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = 5;
        r9 = "Disconnected by the remote device";
        r0 = r20;
        r0.sendLogBroadcast(r4, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = 1;
        r0 = r20;
        r0.refreshDeviceCache(r5, r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.close(r5);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = "Restarting the service";
        r0 = r20;
        r0.logi(r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = new android.content.Intent;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4.<init>();	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r9 = 24;
        r0 = r21;
        r4.fillIn(r0, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.startService(r4);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r4 = 0;
        r0 = r20;
        r0.mInputStream = r4;	 Catch:{ IOException -> 0x090e }
        if (r10 == 0) goto L_0x00d0;
    L_0x0909:
        r10.close();	 Catch:{ IOException -> 0x090e }
        goto L_0x00d0;
    L_0x090e:
        r4 = move-exception;
        goto L_0x00d0;
    L_0x0911:
        r4 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x0911 }
        throw r4;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
    L_0x0914:
        r4 = move-exception;
        r6 = 20;
        r7 = "Device has disconnected";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ all -> 0x03a3 }
        r4 = r4.getMessage();	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.loge(r4);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.close(r5);	 Catch:{ all -> 0x03a3 }
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ all -> 0x03a3 }
        goto L_0x0703;
    L_0x0935:
        r4 = 0;
        goto L_0x0775;
    L_0x0938:
        r8 = 0;
        goto L_0x077a;
    L_0x093b:
        r9 = 0;
        goto L_0x077f;
    L_0x093e:
        r4 = 1;
        if (r9 == r4) goto L_0x0c52;
    L_0x0941:
        r4 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        r16 = "Starting DFU failed";
        r0 = r16;
        r4.<init>(r0, r9);	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
        throw r4;	 Catch:{ RemoteDfuException -> 0x094b, UnknownResponseException -> 0x0961 }
    L_0x094b:
        r4 = move-exception;
        r9 = r4.getErrorNumber();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = 3;
        r0 = r16;
        if (r9 == r0) goto L_0x09f5;
    L_0x0956:
        throw r4;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
    L_0x0957:
        r4 = move-exception;
        r7 = r11;
        r8 = r4.getErrorNumber();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = 3;
        if (r8 == r9) goto L_0x0b4a;
    L_0x0960:
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0961:
        r4 = move-exception;
        r6 = r4.getMessage();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.loge(r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = 20;
        r4 = r4.getMessage();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.sendLogBroadcast(r6, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = "Sending Reset command (Op Code = 6)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = OP_CODE_RESET;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 10;
        r6 = "Reset request sent";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 4104; // 0x1008 float:5.751E-42 double:2.0276E-320;
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        goto L_0x0703;
    L_0x0996:
        r4 = move-exception;
        r6 = r4.getErrorNumber();	 Catch:{ all -> 0x03a3 }
        r7 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
        r7 = r7 & r6;
        if (r7 <= 0) goto L_0x1016;
    L_0x09a1:
        r7 = -32769; // 0xffffffffffff7fff float:NaN double:NaN;
        r6 = r6 & r7;
        r7 = 20;
        r8 = "Error (0x%02X): %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x03a3 }
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x03a3 }
        r9[r11] = r12;	 Catch:{ all -> 0x03a3 }
        r11 = 1;
        r6 = no.nordicsemi.android.p123a.C3082a.m17406a(r6);	 Catch:{ all -> 0x03a3 }
        r9[r11] = r6;	 Catch:{ all -> 0x03a3 }
        r6 = java.lang.String.format(r8, r9);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.sendLogBroadcast(r7, r6);	 Catch:{ all -> 0x03a3 }
    L_0x09c3:
        r6 = r4.getMessage();	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.loge(r6);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r6 = r0.mConnectionState;	 Catch:{ all -> 0x03a3 }
        r7 = -3;
        if (r6 != r7) goto L_0x09ea;
    L_0x09d3:
        r6 = "Sending Reset command (Op Code = 6)";
        r0 = r20;
        r0.logi(r6);	 Catch:{ Exception -> 0x103e }
        r6 = OP_CODE_RESET;	 Catch:{ Exception -> 0x103e }
        r0 = r20;
        r0.writeOpCode(r5, r15, r6);	 Catch:{ Exception -> 0x103e }
        r6 = 10;
        r7 = "Reset request sent";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ Exception -> 0x103e }
    L_0x09ea:
        r4 = r4.getErrorNumber();	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.terminateConnection(r5, r4);	 Catch:{ all -> 0x03a3 }
        goto L_0x0703;
    L_0x09f5:
        r9 = r11 & 4;
        if (r9 <= 0) goto L_0x0b49;
    L_0x09f9:
        r9 = r11 & 3;
        if (r9 <= 0) goto L_0x0b49;
    L_0x09fd:
        r4 = 0;
        r0 = r20;
        r0.mRemoteErrorOccurred = r4;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = "DFU target does not support (SD/BL)+App update";
        r0 = r20;
        r0.logw(r4);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = 15;
        r9 = "DFU target does not support (SD/BL)+App update";
        r0 = r20;
        r0.sendLogBroadcast(r4, r9);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r11 = r11 & -5;
        r0 = r20;
        r0.mFileType = r11;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = OP_CODE_START_DFU;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r9 = 1;
        r0 = (byte) r11;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = r0;
        r4[r9] = r16;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = 2;
        r0 = r20;
        r0.mPartsTotal = r4;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r10;
        r0 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r0;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r0;
        r4.setContentType(r11);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r9 = 0;
        r4 = r10.available();	 Catch:{ IOException -> 0x1047 }
        r0 = r20;
        r0.mImageSizeInBytes = r4;	 Catch:{ IOException -> 0x1047 }
    L_0x0a35:
        r4 = 1;
        r16 = "Sending only SD/BL";
        r0 = r20;
        r1 = r16;
        r0.sendLogBroadcast(r4, r1);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4.<init>();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = "Resending Start DFU command (Op Code = 1, Upload Mode = ";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r11);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = ")";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.toString();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.logi(r4);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = OP_CODE_START_DFU;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = 10;
        r16 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16.<init>();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r17 = "DFU Start sent (Op Code = 1, Upload Mode = ";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r16;
        r16 = r0.append(r11);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r17 = ")";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = r16.toString();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r1 = r16;
        r0.sendLogBroadcast(r4, r1);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4.<init>();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = "Sending image size array to DFU Packet: [";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r7);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = "b, ";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r8);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = "b, ";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r9);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = "b]";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.toString();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.logi(r4);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r20;
        r4.writeImageSize(r5, r6, r7, r8, r9);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = 10;
        r16 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16.<init>();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r17 = "Firmware image size sent [";
        r16 = r16.append(r17);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r16;
        r7 = r0.append(r7);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = "b, ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r7 = r7.append(r8);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r8 = "b, ";
        r7 = r7.append(r8);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r7 = r7.append(r9);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r8 = "b]";
        r7 = r7.append(r8);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r7 = r7.toString();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.sendLogBroadcast(r4, r7);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r20.readNotificationResponse();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r7 = 1;
        r0 = r20;
        r7 = r0.getStatusCode(r4, r7);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r8 = 10;
        r9 = new java.lang.StringBuilder;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r9.<init>();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = "Response received (Op Code = ";
        r0 = r16;
        r9 = r9.append(r0);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r16 = 1;
        r4 = r4[r16];	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r9.append(r4);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r9 = " Status = ";
        r4 = r4.append(r9);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.append(r7);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r9 = ")";
        r4 = r4.append(r9);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = r4.toString();	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r0 = r20;
        r0.sendLogBroadcast(r8, r4);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r4 = 1;
        if (r7 == r4) goto L_0x0c52;
    L_0x0b41:
        r4 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        r8 = "Starting DFU failed";
        r4.<init>(r8, r7);	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
        throw r4;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
    L_0x0b49:
        throw r4;	 Catch:{ RemoteDfuException -> 0x0957, UnknownResponseException -> 0x0961 }
    L_0x0b4a:
        r8 = 4;
        if (r7 != r8) goto L_0x0c50;
    L_0x0b4d:
        r4 = 0;
        r0 = r20;
        r0.mRemoteErrorOccurred = r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "DFU target does not support DFU v.2";
        r0 = r20;
        r0.logw(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 15;
        r8 = "DFU target does not support DFU v.2";
        r0 = r20;
        r0.sendLogBroadcast(r4, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 1;
        r8 = "Switching to DFU v.1";
        r0 = r20;
        r0.sendLogBroadcast(r4, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "Resending Start DFU command (Op Code = 1)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = OP_CODE_START_DFU;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 10;
        r8 = "DFU Start sent (Op Code = 1)";
        r0 = r20;
        r0.sendLogBroadcast(r4, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = "Sending application image size to DFU Packet: ";
        r4 = r4.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = " bytes";
        r4 = r4.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r4 = r0.mImageSizeInBytes;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeImageSize(r5, r6, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 10;
        r8 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = "Firmware image size sent (";
        r8 = r8.append(r9);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = r8.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = " bytes)";
        r8 = r8.append(r9);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = r8.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r4, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r20.readNotificationResponse();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = 1;
        r0 = r20;
        r8 = r0.getStatusCode(r4, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = 10;
        r11 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r11.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = "Response received (Op Code = ";
        r11 = r11.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = 1;
        r4 = r4[r12];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r11.append(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r11 = ", Status = ";
        r4 = r4.append(r11);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r11 = ")";
        r4 = r4.append(r11);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r9, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 1;
        if (r8 == r4) goto L_0x0c51;
    L_0x0c03:
        r4 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = "Starting DFU failed";
        r4.<init>(r6, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0c0b:
        r4 = move-exception;
        r6 = r4.getErrorNumber();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r6 = r6 | 8192;
        r4 = r4.getMessage();	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.loge(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 20;
        r7 = "Remote DFU error: %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r9 = 0;
        r11 = no.nordicsemi.android.p123a.C3082a.m17407b(r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r8[r9] = r11;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.sendLogBroadcast(r4, r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = "Sending Reset command (Op Code = 6)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = OP_CODE_RESET;	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r4 = 10;
        r7 = "Reset request sent";
        r0 = r20;
        r0.sendLogBroadcast(r4, r7);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        r0 = r20;
        r0.terminateConnection(r5, r6);	 Catch:{ UploadAbortedException -> 0x06c9, DeviceDisconnectedException -> 0x0914, DfuException -> 0x0996 }
        goto L_0x0703;
    L_0x0c50:
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0c51:
        r11 = r7;
    L_0x0c52:
        if (r14 == 0) goto L_0x0cea;
    L_0x0c54:
        r4 = 10;
        r7 = "Writing Initialize DFU Parameters...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = OP_CODE_INIT_DFU_PARAMS_START;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 20;
        r4 = new byte[r4];	 Catch:{ IOException -> 0x0c7e }
    L_0x0c6f:
        r7 = 0;
        r8 = r4.length;	 Catch:{ IOException -> 0x0c7e }
        r7 = r14.read(r4, r7, r8);	 Catch:{ IOException -> 0x0c7e }
        r8 = -1;
        if (r7 == r8) goto L_0x0c90;
    L_0x0c78:
        r0 = r20;
        r0.writeInitPacket(r5, r6, r4, r7);	 Catch:{ IOException -> 0x0c7e }
        goto L_0x0c6f;
    L_0x0c7e:
        r4 = move-exception;
        r4 = "Error while reading Init packet file";
        r0 = r20;
        r0.loge(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = new no.nordicsemi.android.dfu.internal.exception.DfuException;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = "Error while reading Init packet file";
        r7 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
        r4.<init>(r6, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0c90:
        r4 = "Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = OP_CODE_INIT_DFU_PARAMS_COMPLETE;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 10;
        r7 = "Initialize DFU Parameters completed";
        r0 = r20;
        r0.sendLogBroadcast(r4, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r20.readNotificationResponse();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = 2;
        r0 = r20;
        r7 = r0.getStatusCode(r4, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = 10;
        r9 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = "Response received (Op Code = ";
        r9 = r9.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = 1;
        r4 = r4[r12];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r9.append(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = ", Status = ";
        r4 = r4.append(r9);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.append(r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = ")";
        r4 = r4.append(r9);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r8, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 1;
        if (r7 == r4) goto L_0x0cef;
    L_0x0ce2:
        r4 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = "Device returned error after sending init packet";
        r4.<init>(r6, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0cea:
        r4 = 1;
        r0 = r20;
        r0.mInitPacketSent = r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0cef:
        r0 = r20;
        r4 = r0.mPacketsBeforeNotification;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        if (r4 <= 0) goto L_0x0d41;
    L_0x0cf5:
        r7 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = "Sending the number of packets before notifications (Op Code = 8, Value = ";
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.append(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = ")";
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.logi(r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.setNumberOfPackets(r7, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeOpCode(r5, r15, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = 10;
        r8 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = "Packet Receipt Notif Req (Op Code = 8) sent (Value = ";
        r8 = r8.append(r9);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r8.append(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = ")";
        r4 = r4.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r7, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0d41:
        r4 = "Sending Receive Firmware Image request (Op Code = 3)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = OP_CODE_RECEIVE_FIRMWARE_IMAGE;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 10;
        r7 = "Receive Firmware Image request sent";
        r0 = r20;
        r0.sendLogBroadcast(r4, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.mStartTime = r8;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.mLastProgressTime = r8;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r20.updateProgressNotification();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "Uploading firmware...";
        r0 = r20;
        r0.logi(r4);	 Catch:{ DeviceDisconnectedException -> 0x0e0b, UploadAbortedException -> 0x06c9, DfuException -> 0x0996 }
        r4 = 10;
        r7 = "Uploading firmware...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r7);	 Catch:{ DeviceDisconnectedException -> 0x0e0b, UploadAbortedException -> 0x06c9, DfuException -> 0x0996 }
        r0 = r20;
        r4 = r0.uploadFirmwareImage(r5, r6, r10);	 Catch:{ DeviceDisconnectedException -> 0x0e0b, UploadAbortedException -> 0x06c9, DfuException -> 0x0996 }
        r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = 3;
        r0 = r20;
        r12 = r0.getStatusCode(r4, r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r14 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r14.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = "Response received. Op Code: ";
        r0 = r16;
        r14 = r14.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = 0;
        r16 = r4[r16];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r16;
        r14 = r14.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = " Req Op Code = ";
        r0 = r16;
        r14 = r14.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = 1;
        r16 = r4[r16];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r16;
        r14 = r14.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = ", Status = ";
        r0 = r16;
        r14 = r14.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = 2;
        r16 = r4[r16];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r16;
        r14 = r14.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r14 = r14.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.logi(r14);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r14 = 10;
        r16 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r17 = "Response received (Op Code = ";
        r16 = r16.append(r17);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r17 = 1;
        r4 = r4[r17];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r16;
        r4 = r0.append(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = ", Status = ";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = ")";
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r14, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 1;
        if (r12 == r4) goto L_0x0e14;
    L_0x0e03:
        r4 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = "Device returned error after sending file";
        r4.<init>(r6, r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0e0b:
        r4 = move-exception;
        r6 = "Disconnected while sending data";
        r0 = r20;
        r0.loge(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0e14:
        r4 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = "Transfer of ";
        r4 = r4.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r12 = r0.mBytesSent;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = " bytes has taken ";
        r4 = r4.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r16 = r6 - r8;
        r0 = r16;
        r4 = r4.append(r0);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12 = " ms";
        r4 = r4.append(r12);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 10;
        r12 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r12.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r14 = "Upload completed in ";
        r12 = r12.append(r14);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = r6 - r8;
        r6 = r12.append(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = " ms";
        r6 = r6.append(r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = r6.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "Sending Validate request (Op Code = 4)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = OP_CODE_VALIDATE;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 10;
        r6 = "Validate request sent";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r20.readNotificationResponse();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = 4;
        r0 = r20;
        r6 = r0.getStatusCode(r4, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = "Response received. Op Code: ";
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = 0;
        r8 = r4[r8];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = " Req Op Code = ";
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = 1;
        r8 = r4[r8];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = ", Status = ";
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = 2;
        r8 = r4[r8];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.logi(r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = 10;
        r8 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = "Response received (Op Code = ";
        r8 = r8.append(r9);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r9 = 1;
        r4 = r4[r9];	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r8.append(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = ", Status = ";
        r4 = r4.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.append(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = ")";
        r4 = r4.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r7, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 1;
        if (r6 == r4) goto L_0x0ef4;
    L_0x0eec:
        r4 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = "Device returned validation error";
        r4.<init>(r7, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0ef4:
        r4 = -5;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "Sending Activate and Reset request (Op Code = 5)";
        r0 = r20;
        r0.logi(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = OP_CODE_ACTIVATE_AND_RESET;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.writeOpCode(r5, r15, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 10;
        r6 = "Activate and Reset request sent";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r20.waitUntilDisconnected();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 5;
        r6 = "Disconnected by the remote device";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
        r6 = 0;
        r0 = r21;
        r6 = r0.getBooleanExtra(r4, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = 5;
        if (r13 == r4) goto L_0x0f2a;
    L_0x0f28:
        if (r6 != 0) goto L_0x0f94;
    L_0x0f2a:
        r4 = 1;
    L_0x0f2b:
        r0 = r20;
        r0.refreshDeviceCache(r5, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.close(r5);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r5.getDevice();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.getBondState();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = 12;
        if (r4 != r7) goto L_0x0f73;
    L_0x0f41:
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
        r7 = 0;
        r0 = r21;
        r4 = r0.getBooleanExtra(r4, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        if (r4 != 0) goto L_0x0f52;
    L_0x0f4c:
        if (r6 == 0) goto L_0x0f52;
    L_0x0f4e:
        r6 = r11 & 1;
        if (r6 <= 0) goto L_0x0f64;
    L_0x0f52:
        r6 = r5.getDevice();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.removeBond(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        monitor-enter(r20);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = r20;
        r0.wait(r6);	 Catch:{ InterruptedException -> 0x1038 }
    L_0x0f63:
        monitor-exit(r20);	 Catch:{ all -> 0x0f96 }
    L_0x0f64:
        if (r4 == 0) goto L_0x0f73;
    L_0x0f66:
        r4 = r11 & 4;
        if (r4 <= 0) goto L_0x0f73;
    L_0x0f6a:
        r4 = r5.getDevice();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.createBond(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0f73:
        r0 = r20;
        r4 = r0.mPartCurrent;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r6 = r0.mPartsTotal;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        if (r4 != r6) goto L_0x0f9c;
    L_0x0f7d:
        r0 = r20;
        r6 = r0.mLock;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        monitor-enter(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r4 = r0.mLock;	 Catch:{ InterruptedException -> 0x1044 }
        r8 = 1400; // 0x578 float:1.962E-42 double:6.917E-321;
        r4.wait(r8);	 Catch:{ InterruptedException -> 0x1044 }
    L_0x0f8b:
        monitor-exit(r6);	 Catch:{ all -> 0x0f99 }
        r4 = -6;
        r0 = r20;
        r0.updateProgressNotification(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        goto L_0x0703;
    L_0x0f94:
        r4 = 0;
        goto L_0x0f2b;
    L_0x0f96:
        r4 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x0f96 }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0f99:
        r4 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0f99 }
        throw r4;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0f9c:
        r4 = 1;
        r6 = "Scanning for the DFU Bootloader...";
        r0 = r20;
        r0.sendLogBroadcast(r4, r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory.getScanner();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r6 = r0.mDeviceAddress;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = r4.searchFor(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        if (r4 == 0) goto L_0x100d;
    L_0x0fb2:
        r6 = 5;
        r7 = new java.lang.StringBuilder;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r8 = "DFU Bootloader found with address ";
        r7 = r7.append(r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.append(r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7.toString();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0fcb:
        r6 = "Starting service that will upload application";
        r0 = r20;
        r0.logi(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6 = new android.content.Intent;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6.<init>();	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = 24;
        r0 = r21;
        r6.fillIn(r0, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
        r8 = "application/zip";
        r6.putExtra(r7, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
        r8 = 4;
        r6.putExtra(r7, r8);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        if (r4 == 0) goto L_0x0ff2;
    L_0x0fed:
        r7 = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
        r6.putExtra(r7, r4);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
    L_0x0ff2:
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
        r0 = r20;
        r7 = r0.mPartCurrent;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r7 = r7 + 1;
        r6.putExtra(r4, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r4 = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
        r0 = r20;
        r7 = r0.mPartsTotal;	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r6.putExtra(r4, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        r0 = r20;
        r0.startService(r6);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        goto L_0x0703;
    L_0x100d:
        r6 = 5;
        r7 = "DFU Bootloader not found. Trying the same address...";
        r0 = r20;
        r0.sendLogBroadcast(r6, r7);	 Catch:{ UnknownResponseException -> 0x0961, RemoteDfuException -> 0x0c0b }
        goto L_0x0fcb;
    L_0x1016:
        r6 = r6 & -16385;
        r7 = 20;
        r8 = "Error (0x%02X): %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x03a3 }
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x03a3 }
        r9[r11] = r12;	 Catch:{ all -> 0x03a3 }
        r11 = 1;
        r6 = no.nordicsemi.android.p123a.C3082a.m17407b(r6);	 Catch:{ all -> 0x03a3 }
        r9[r11] = r6;	 Catch:{ all -> 0x03a3 }
        r6 = java.lang.String.format(r8, r9);	 Catch:{ all -> 0x03a3 }
        r0 = r20;
        r0.sendLogBroadcast(r7, r6);	 Catch:{ all -> 0x03a3 }
        goto L_0x09c3;
    L_0x1038:
        r6 = move-exception;
        goto L_0x0f63;
    L_0x103b:
        r5 = move-exception;
        goto L_0x03ae;
    L_0x103e:
        r6 = move-exception;
        goto L_0x09ea;
    L_0x1041:
        r4 = move-exception;
        goto L_0x06fd;
    L_0x1044:
        r4 = move-exception;
        goto L_0x0f8b;
    L_0x1047:
        r4 = move-exception;
        goto L_0x0a35;
    L_0x104a:
        r4 = move-exception;
        goto L_0x076f;
    L_0x104d:
        r6 = move-exception;
        goto L_0x0662;
    L_0x1050:
        r4 = move-exception;
        goto L_0x0519;
    L_0x1053:
        r4 = move-exception;
        goto L_0x0352;
    L_0x1056:
        r7 = r4;
        goto L_0x0799;
    L_0x1059:
        r14 = r5;
        goto L_0x031f;
    L_0x105c:
        r11 = r6;
        goto L_0x0266;
    L_0x105f:
        r5 = r9;
        goto L_0x01d0;
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.onHandleIntent(android.content.Intent):void");
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private InputStream openInputStream(String str, String str2, int i, int i2) throws IOException {
        InputStream fileInputStream = new FileInputStream(str);
        if (MIME_TYPE_ZIP.equals(str2)) {
            return new ArchiveInputStream(fileInputStream, i, i2);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream(fileInputStream, i) : fileInputStream;
    }

    private InputStream openInputStream(Uri uri, String str, int i, int i2) throws IOException {
        InputStream openInputStream = getContentResolver().openInputStream(uri);
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(openInputStream, i, i2);
        }
        Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        try {
            if (query.moveToNext() && query.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                InputStream hexInputStream = new HexInputStream(openInputStream, i);
                return hexInputStream;
            }
            query.close();
            return openInputStream;
        } finally {
            query.close();
        }
    }

    private InputStream openInputStream(int i, String str, int i2, int i3) throws IOException {
        InputStream openRawResource = getResources().openRawResource(i);
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(openRawResource, i2, i3);
        }
        openRawResource.mark(2);
        int read = openRawResource.read();
        openRawResource.reset();
        return read == 58 ? new HexInputStream(openRawResource, i2) : openRawResource;
    }

    private BluetoothGatt connect(String str) {
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false)");
        BluetoothGatt connectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (((this.mConnectionState == -1 || this.mConnectionState == -2) && this.mError == 0 && !this.mAborted) || this.mPaused) {
                        this.mLock.wait();
                    }
                }
            }
            return connectGatt;
        } catch (Throwable e) {
            loge("Sleeping interrupted", e);
            return connectGatt;
        }
    }

    private void terminateConnection(BluetoothGatt bluetoothGatt, int i) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt);
        }
        refreshDeviceCache(bluetoothGatt, false);
        close(bluetoothGatt);
        updateProgressNotification(i);
    }

    private void disconnect(BluetoothGatt bluetoothGatt) {
        if (this.mConnectionState != 0) {
            sendLogBroadcast(1, "Disconnecting...");
            updateProgressNotification(-5);
            this.mConnectionState = -4;
            logi("Disconnecting from the device...");
            sendLogBroadcast(0, "gatt.disconnect()");
            bluetoothGatt.disconnect();
            waitUntilDisconnected();
            sendLogBroadcast(5, "Disconnected");
        }
    }

    private void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    this.mLock.wait();
                }
            }
        } catch (Throwable e) {
            loge("Sleeping interrupted", e);
        }
    }

    private void close(BluetoothGatt bluetoothGatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.close()");
        bluetoothGatt.close();
        this.mConnectionState = -5;
    }

    private void refreshDeviceCache(BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    logi("Refreshing result: " + ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue());
                }
            } catch (Throwable e) {
                loge("An exception occurred while refreshing device", e);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        if (bArr != null && bArr.length == 3 && bArr[0] == (byte) 16 && bArr[1] == i && bArr[2] >= (byte) 1 && bArr[2] <= (byte) 6) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, i);
    }

    private int readVersion(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (this.mConnectionState != -3) {
            throw new DeviceDisconnectedException("Unable to read version number", this.mConnectionState);
        } else if (bluetoothGattCharacteristic == null) {
            return 0;
        } else {
            this.mReceivedData = null;
            this.mError = 0;
            logi("Reading DFU version number...");
            sendLogBroadcast(1, "Reading DFU version number...");
            bluetoothGattCharacteristic.setValue((byte[]) null);
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if (((this.mRequestCompleted && bluetoothGattCharacteristic.getValue() != null) || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                            break;
                        }
                        this.mRequestCompleted = false;
                        this.mLock.wait();
                    }
                }
            } catch (Throwable e) {
                loge("Sleeping interrupted", e);
            }
            if (this.mAborted) {
                throw new UploadAbortedException();
            } else if (this.mError != 0) {
                throw new DfuException("Unable to read version number", this.mError);
            } else if (this.mConnectionState == -3) {
                return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
            } else {
                throw new DeviceDisconnectedException("Unable to read version number", this.mConnectionState);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void enableCCCD(android.bluetooth.BluetoothGatt r9, android.bluetooth.BluetoothGattCharacteristic r10, int r11) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
        r8 = this;
        r7 = 2;
        r6 = 0;
        r5 = -3;
        r4 = 1;
        if (r11 != r4) goto L_0x002d;
    L_0x0006:
        r0 = "notifications";
    L_0x0008:
        r1 = r8.mConnectionState;
        if (r1 == r5) goto L_0x0030;
    L_0x000c:
        r1 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to set ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = " state";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = r8.mConnectionState;
        r1.<init>(r0, r2);
        throw r1;
    L_0x002d:
        r0 = "indications";
        goto L_0x0008;
    L_0x0030:
        r1 = 0;
        r8.mReceivedData = r1;
        r8.mError = r6;
        if (r11 != r4) goto L_0x003b;
    L_0x0037:
        r1 = r8.mNotificationsEnabled;
        if (r1 != 0) goto L_0x0041;
    L_0x003b:
        if (r11 != r7) goto L_0x0042;
    L_0x003d:
        r1 = r8.mServiceChangedIndicationsEnabled;
        if (r1 == 0) goto L_0x0042;
    L_0x0041:
        return;
    L_0x0042:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Enabling ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = "...";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r8.logi(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Enabling ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = " for ";
        r1 = r1.append(r2);
        r2 = r10.getUuid();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r8.sendLogBroadcast(r4, r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "gatt.setCharacteristicNotification(";
        r1 = r1.append(r2);
        r2 = r10.getUuid();
        r1 = r1.append(r2);
        r2 = ", true)";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r8.sendLogBroadcast(r6, r1);
        r9.setCharacteristicNotification(r10, r4);
        r1 = CLIENT_CHARACTERISTIC_CONFIG;
        r2 = r10.getDescriptor(r1);
        if (r11 != r4) goto L_0x010f;
    L_0x00ad:
        r1 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
    L_0x00af:
        r2.setValue(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "gatt.writeDescriptor(";
        r1 = r1.append(r3);
        r3 = r2.getUuid();
        r3 = r1.append(r3);
        if (r11 != r4) goto L_0x0112;
    L_0x00c7:
        r1 = ", value=0x01-00)";
    L_0x00c9:
        r1 = r3.append(r1);
        r1 = r1.toString();
        r8.sendLogBroadcast(r6, r1);
        r9.writeDescriptor(r2);
        r2 = r8.mLock;	 Catch:{ InterruptedException -> 0x00ff }
        monitor-enter(r2);	 Catch:{ InterruptedException -> 0x00ff }
    L_0x00da:
        if (r11 != r4) goto L_0x00e0;
    L_0x00dc:
        r1 = r8.mNotificationsEnabled;	 Catch:{ all -> 0x00fc }
        if (r1 == 0) goto L_0x00e6;
    L_0x00e0:
        if (r11 != r7) goto L_0x00f2;
    L_0x00e2:
        r1 = r8.mServiceChangedIndicationsEnabled;	 Catch:{ all -> 0x00fc }
        if (r1 != 0) goto L_0x00f2;
    L_0x00e6:
        r1 = r8.mConnectionState;	 Catch:{ all -> 0x00fc }
        if (r1 != r5) goto L_0x00f2;
    L_0x00ea:
        r1 = r8.mError;	 Catch:{ all -> 0x00fc }
        if (r1 != 0) goto L_0x00f2;
    L_0x00ee:
        r1 = r8.mAborted;	 Catch:{ all -> 0x00fc }
        if (r1 == 0) goto L_0x00f6;
    L_0x00f2:
        r1 = r8.mPaused;	 Catch:{ all -> 0x00fc }
        if (r1 == 0) goto L_0x0115;
    L_0x00f6:
        r1 = r8.mLock;	 Catch:{ all -> 0x00fc }
        r1.wait();	 Catch:{ all -> 0x00fc }
        goto L_0x00da;
    L_0x00fc:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00fc }
        throw r1;	 Catch:{ InterruptedException -> 0x00ff }
    L_0x00ff:
        r1 = move-exception;
        r2 = "Sleeping interrupted";
        r8.loge(r2, r1);
    L_0x0105:
        r1 = r8.mAborted;
        if (r1 == 0) goto L_0x0117;
    L_0x0109:
        r0 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
        r0.<init>();
        throw r0;
    L_0x010f:
        r1 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        goto L_0x00af;
    L_0x0112:
        r1 = ", value=0x02-00)";
        goto L_0x00c9;
    L_0x0115:
        monitor-exit(r2);	 Catch:{ all -> 0x00fc }
        goto L_0x0105;
    L_0x0117:
        r1 = r8.mError;
        if (r1 == 0) goto L_0x013c;
    L_0x011b:
        r1 = new no.nordicsemi.android.dfu.internal.exception.DfuException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to set ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = " state";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = r8.mError;
        r1.<init>(r0, r2);
        throw r1;
    L_0x013c:
        r1 = r8.mConnectionState;
        if (r1 == r5) goto L_0x0041;
    L_0x0140:
        r1 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to set ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = " state";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = r8.mConnectionState;
        r1.<init>(r0, r2);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.enableCCCD(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    private boolean isServiceChangedCCCDEnabled(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (this.mConnectionState != -3) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD", this.mConnectionState);
        } else if (bluetoothGattCharacteristic == null) {
            return false;
        } else {
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
            if (descriptor == null) {
                return false;
            }
            this.mRequestCompleted = false;
            this.mError = 0;
            logi("Reading Service Changed CCCD value...");
            sendLogBroadcast(1, "Reading Service Changed CCCD value...");
            bluetoothGatt.readDescriptor(descriptor);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mRequestCompleted || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                            break;
                        }
                        this.mLock.wait();
                    }
                }
            } catch (Throwable e) {
                loge("Sleeping interrupted", e);
            }
            if (this.mAborted) {
                throw new UploadAbortedException();
            } else if (this.mError != 0) {
                throw new DfuException("Unable to read Service Changed CCCD", this.mError);
            } else if (this.mConnectionState == -3) {
                return this.mServiceChangedIndicationsEnabled;
            } else {
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD", this.mConnectionState);
            }
        }
    }

    private void writeOpCode(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        boolean z = false;
        if (bArr[0] == (byte) 6 || bArr[0] == (byte) 5) {
            z = true;
        }
        writeOpCode(bluetoothGatt, bluetoothGattCharacteristic, bArr, z);
    }

    private void writeOpCode(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mRequestCompleted = false;
        this.mResetRequestSent = z;
        bluetoothGattCharacteristic.setValue(bArr);
        sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mRequestCompleted || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (Throwable e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (!this.mResetRequestSent && this.mError != 0) {
            throw new DfuException("Unable to write Op Code " + bArr[0], this.mError);
        } else if (!this.mResetRequestSent && this.mConnectionState != -3) {
            throw new DeviceDisconnectedException("Unable to write Op Code " + bArr[0], this.mConnectionState);
        }
    }

    private void writeImageSize(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeSent = false;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[4]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mImageSizeSent || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (Throwable e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (this.mError != 0) {
            throw new DfuException("Unable to write Image Size", this.mError);
        } else if (this.mConnectionState != -3) {
            throw new DeviceDisconnectedException("Unable to write Image Size", this.mConnectionState);
        }
    }

    private void writeImageSize(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeSent = false;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[12]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        bluetoothGattCharacteristic.setValue(i2, 20, 4);
        bluetoothGattCharacteristic.setValue(i3, 20, 8);
        sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mImageSizeSent || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (Throwable e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (this.mError != 0) {
            throw new DfuException("Unable to write Image Sizes", this.mError);
        } else if (this.mConnectionState != -3) {
            throw new DeviceDisconnectedException("Unable to write Image Sizes", this.mConnectionState);
        }
    }

    private void writeInitPacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (bArr.length != i) {
            Object obj = new byte[i];
            System.arraycopy(bArr, 0, obj, 0, i);
            bArr = obj;
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mInitPacketSent = false;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(bArr);
        logi("Sending init packet (Value = " + parse(bArr) + ")");
        sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mInitPacketSent || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (Throwable e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (this.mError != 0) {
            throw new DfuException("Unable to write Init DFU Parameters", this.mError);
        } else if (this.mConnectionState != -3) {
            throw new DeviceDisconnectedException("Unable to write Init DFU Parameters", this.mConnectionState);
        }
    }

    private byte[] uploadFirmwareImage(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, InputStream inputStream) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        byte[] bArr = this.mBuffer;
        try {
            int read = inputStream.read(bArr);
            sendLogBroadcast(1, "Sending firmware to characteristic " + bluetoothGattCharacteristic.getUuid() + "...");
            writePacket(bluetoothGatt, bluetoothGattCharacteristic, bArr, read);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mReceivedData != null || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                            break;
                        }
                        this.mLock.wait();
                    }
                }
            } catch (Throwable e) {
                loge("Sleeping interrupted", e);
            }
            if (this.mAborted) {
                throw new UploadAbortedException();
            } else if (this.mError != 0) {
                throw new DfuException("Uploading Firmware Image failed", this.mError);
            } else if (this.mConnectionState == -3) {
                return this.mReceivedData;
            } else {
                throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected", this.mConnectionState);
            }
        } catch (HexFileValidationException e2) {
            throw new DfuException("HEX file not valid", ERROR_FILE_INVALID);
        } catch (IOException e3) {
            throw new DfuException("Error while reading file", ERROR_FILE_IO_EXCEPTION);
        }
    }

    private void writePacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (bArr.length != i) {
            Object obj = new byte[i];
            System.arraycopy(bArr, 0, obj, 0, i);
            bArr = obj;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    private void waitIfPaused() {
        synchronized (this.mLock) {
            while (this.mPaused) {
                try {
                    this.mLock.wait();
                } catch (Throwable e) {
                    loge("Sleeping interrupted", e);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private boolean createBond(BluetoothDevice bluetoothDevice) {
        boolean z = true;
        if (bluetoothDevice.getBondState() != 12) {
            this.mRequestCompleted = false;
            sendLogBroadcast(1, "Starting pairing...");
            if (VERSION.SDK_INT >= 19) {
                sendLogBroadcast(0, "gatt.getDevice().createBond()");
                z = bluetoothDevice.createBond();
            } else {
                z = createBondApi18(bluetoothDevice);
            }
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (Throwable e) {
                loge("Sleeping interrupted", e);
            }
        }
        return z;
    }

    private boolean createBondApi18(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
            if (method != null) {
                sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
                return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
            }
        } catch (Throwable e) {
            Log.w(TAG, "An exception occurred while creating bond", e);
        }
        return false;
    }

    private boolean removeBond(BluetoothDevice bluetoothDevice) {
        Throwable th;
        boolean z;
        if (bluetoothDevice.getBondState() == 10) {
            return true;
        }
        sendLogBroadcast(1, "Removing bond information...");
        try {
            Method method = bluetoothDevice.getClass().getMethod("removeBond", new Class[0]);
            if (method != null) {
                this.mRequestCompleted = false;
                sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
                boolean booleanValue = ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
                try {
                    synchronized (this.mLock) {
                        while (!this.mRequestCompleted && !this.mAborted) {
                            this.mLock.wait();
                        }
                    }
                } catch (Throwable e) {
                    try {
                        loge("Sleeping interrupted", e);
                    } catch (Throwable e2) {
                        th = e2;
                        z = booleanValue;
                        Log.w(TAG, "An exception occurred while removing bond information", th);
                        return z;
                    }
                }
            }
            z = true;
        } catch (Throwable e22) {
            th = e22;
            z = false;
            Log.w(TAG, "An exception occurred while removing bond information", th);
            return z;
        }
        return z;
    }

    private byte[] readNotificationResponse() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mError = 0;
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mReceivedData != null || this.mConnectionState != -3 || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (Throwable e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        } else if (this.mError != 0) {
            throw new DfuException("Unable to write Op Code", this.mError);
        } else if (this.mConnectionState == -3) {
            return this.mReceivedData;
        } else {
            throw new DeviceDisconnectedException("Unable to write Op Code", this.mConnectionState);
        }
    }

    private void updateProgressNotification() {
        int i = (int) ((100.0f * ((float) this.mBytesSent)) / ((float) this.mImageSizeInBytes));
        if (this.mLastProgress != i) {
            this.mLastProgress = i;
            updateProgressNotification(i);
        }
    }

    private void updateProgressNotification(int i) {
        if (i < 4096) {
            sendProgressBroadcast(i);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.mLastNotificationTime >= 250) {
                this.mLastNotificationTime = elapsedRealtime;
            } else {
                return;
            }
        }
        sendErrorBroadcast(i);
        if (!this.mDisableNotification) {
            String str = this.mDeviceAddress;
            String string = this.mDeviceName != null ? this.mDeviceName : getString(C3088R.string.dfu_unknown_name);
            C0326d b = new C0326d(this).m2480a(17301640).m2497b(true);
            b.m2504e(-7829368);
            switch (i) {
                case PROGRESS_ABORTED /*-7*/:
                    b.m2492a(false).m2490a(getString(C3088R.string.dfu_status_aborted)).m2480a(17301641).m2496b(getString(C3088R.string.dfu_status_aborted_msg)).m2500c(true);
                    break;
                case PROGRESS_COMPLETED /*-6*/:
                    b.m2492a(false).m2490a(getString(C3088R.string.dfu_status_completed)).m2480a(17301641).m2496b(getString(C3088R.string.dfu_status_completed_msg)).m2500c(true).m2504e(-16730086);
                    break;
                case -5:
                    b.m2492a(true).m2490a(getString(C3088R.string.dfu_status_disconnecting)).m2496b(getString(C3088R.string.dfu_status_disconnecting_msg, new Object[]{string})).m2482a(100, 0, true);
                    break;
                case -4:
                    b.m2492a(true).m2490a(getString(C3088R.string.dfu_status_validating)).m2496b(getString(C3088R.string.dfu_status_validating_msg)).m2482a(100, 0, true);
                    break;
                case -3:
                    b.m2492a(true).m2490a(getString(C3088R.string.dfu_status_switching_to_dfu)).m2496b(getString(C3088R.string.dfu_status_switching_to_dfu_msg)).m2482a(100, 0, true);
                    break;
                case -2:
                    b.m2492a(true).m2490a(getString(C3088R.string.dfu_status_starting)).m2496b(getString(C3088R.string.dfu_status_starting_msg)).m2482a(100, 0, true);
                    break;
                case -1:
                    b.m2492a(true).m2490a(getString(C3088R.string.dfu_status_connecting)).m2496b(getString(C3088R.string.dfu_status_connecting_msg, new Object[]{string})).m2482a(100, 0, true);
                    break;
                default:
                    if (i < 4096) {
                        CharSequence string2;
                        CharSequence string3 = this.mPartsTotal == 1 ? getString(C3088R.string.dfu_status_uploading) : getString(C3088R.string.dfu_status_uploading_part, new Object[]{Integer.valueOf(this.mPartCurrent), Integer.valueOf(this.mPartsTotal)});
                        if ((this.mFileType & 4) > 0) {
                            string2 = getString(C3088R.string.dfu_status_uploading_msg, new Object[]{string});
                        } else {
                            string2 = getString(C3088R.string.dfu_status_uploading_components_msg, new Object[]{string});
                        }
                        b.m2492a(true).m2490a(string3).m2496b(string2).m2482a(100, i, false);
                        break;
                    }
                    b.m2492a(false).m2490a(getString(C3088R.string.dfu_status_error)).m2480a(17301641).m2496b(getString(C3088R.string.dfu_status_error_msg)).m2500c(true).m2504e(-65536);
                    break;
            }
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
            intent.putExtra(EXTRA_DEVICE_NAME, string);
            intent.putExtra(EXTRA_PROGRESS, i);
            b.m2485a(PendingIntent.getActivity(this, 0, intent, 134217728));
            if (!(i == -7 || i == -6 || i >= 4096)) {
                Intent intent2 = new Intent(BROADCAST_ACTION);
                intent2.putExtra(EXTRA_ACTION, 2);
                b.m2483a(C3088R.drawable.ic_action_notify_cancel, getString(C3088R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent2, 134217728));
            }
            ((NotificationManager) getSystemService("notification")).notify(NOTIFICATION_ID, b.m2493b());
        }
    }

    private void sendProgressBroadcast(int i) {
        float f = 0.0f;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        float f2 = elapsedRealtime - this.mLastProgressTime != 0 ? ((float) (this.mBytesSent - this.mLastBytesSent)) / ((float) (elapsedRealtime - this.mLastProgressTime)) : 0.0f;
        if (elapsedRealtime - this.mStartTime != 0) {
            f = ((float) this.mBytesSent) / ((float) (elapsedRealtime - this.mStartTime));
        }
        this.mLastProgressTime = elapsedRealtime;
        this.mLastBytesSent = this.mBytesSent;
        Intent intent = new Intent(BROADCAST_PROGRESS);
        intent.putExtra(EXTRA_DATA, i);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        intent.putExtra(EXTRA_PART_CURRENT, this.mPartCurrent);
        intent.putExtra(EXTRA_PARTS_TOTAL, this.mPartsTotal);
        intent.putExtra(EXTRA_SPEED_B_PER_MS, f2);
        intent.putExtra(EXTRA_AVG_SPEED_B_PER_MS, f);
        C0429i.m2924a((Context) this).m2929a(intent);
    }

    private void sendErrorBroadcast(int i) {
        Intent intent = new Intent(BROADCAST_ERROR);
        if ((i & ERROR_CONNECTION_MASK) > 0) {
            intent.putExtra(EXTRA_DATA, i & -16385);
            intent.putExtra(EXTRA_ERROR_TYPE, 2);
        } else if ((ERROR_CONNECTION_STATE_MASK & i) > 0) {
            intent.putExtra(EXTRA_DATA, -32769 & i);
            intent.putExtra(EXTRA_ERROR_TYPE, 1);
        } else if ((i & ERROR_REMOTE_MASK) > 0) {
            intent.putExtra(EXTRA_DATA, i);
            intent.putExtra(EXTRA_ERROR_TYPE, 3);
        } else {
            intent.putExtra(EXTRA_DATA, i);
            intent.putExtra(EXTRA_ERROR_TYPE, 0);
        }
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        C0429i.m2924a((Context) this).m2929a(intent);
    }

    private void sendLogBroadcast(int i, String str) {
        String str2 = "[DFU] " + str;
        Intent intent = new Intent(BROADCAST_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, str2);
        intent.putExtra(EXTRA_LOG_LEVEL, i);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        C0429i.m2924a((Context) this).m2929a(intent);
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        this.mBluetoothAdapter = bluetoothManager.getAdapter();
        if (this.mBluetoothAdapter != null) {
            return true;
        }
        loge("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    private void loge(String str) {
        Log.e(TAG, str);
    }

    private void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    private void logw(String str) {
    }

    private void logi(String str) {
    }

    private void logd(String str) {
    }

    private String parse(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        int length = bArr.length;
        if (length == 0) {
            return "";
        }
        char[] cArr = new char[((length * 3) - 1)];
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 3] = HEX_ARRAY[i2 >>> 4];
            cArr[(i * 3) + 1] = HEX_ARRAY[i2 & 15];
            if (i != length - 1) {
                cArr[(i * 3) + 2] = '-';
            }
        }
        return new String(cArr);
    }
}
