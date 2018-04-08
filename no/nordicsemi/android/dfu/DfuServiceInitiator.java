package no.nordicsemi.android.dfu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.security.InvalidParameterException;

public class DfuServiceInitiator {
    private final String deviceAddress;
    private String deviceName;
    private boolean disableNotification;
    private String filePath;
    private int fileResId;
    private int fileType = -1;
    private Uri fileUri;
    private String initFilePath;
    private int initFileResId;
    private Uri initFileUri;
    private boolean keepBond;
    private String mimeType;

    public DfuServiceInitiator(String str) {
        this.deviceAddress = str;
    }

    public DfuServiceInitiator setDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public DfuServiceInitiator setDisableNotification(boolean z) {
        this.disableNotification = z;
        return this;
    }

    public DfuServiceInitiator setKeepBond(boolean z) {
        this.keepBond = z;
        return this;
    }

    public DfuServiceInitiator setZip(Uri uri) {
        return init(uri, null, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    public DfuServiceInitiator setZip(String str) {
        return init(null, str, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    public DfuServiceInitiator setZip(int i) {
        return init(null, null, i, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    public DfuServiceInitiator setZip(Uri uri, String str) {
        return init(uri, str, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, Uri uri) {
        if (i == 0) {
            throw new UnsupportedOperationException("You must specify the file type");
        }
        return init(uri, null, 0, i, DfuBaseService.MIME_TYPE_OCTET_STREAM);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, String str) {
        if (i == 0) {
            throw new UnsupportedOperationException("You must specify the file type");
        }
        return init(null, str, 0, i, DfuBaseService.MIME_TYPE_OCTET_STREAM);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, Uri uri, String str) {
        if (i == 0) {
            throw new UnsupportedOperationException("You must specify the file type");
        }
        return init(uri, str, 0, i, DfuBaseService.MIME_TYPE_OCTET_STREAM);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, int i2) {
        if (i == 0) {
            throw new UnsupportedOperationException("You must specify the file type");
        }
        return init(null, null, i2, i, DfuBaseService.MIME_TYPE_OCTET_STREAM);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(Uri uri) {
        return init(uri, null, 0);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(String str) {
        return init(null, str, 0);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(int i) {
        return init(null, null, i);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(Uri uri, String str) {
        return init(uri, str, 0);
    }

    public void start(Context context, Class<? extends DfuBaseService> cls) {
        if (this.fileType == -1) {
            throw new UnsupportedOperationException("You must specify the firmware file before starting the service");
        }
        Intent intent = new Intent(context, cls);
        intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, this.deviceAddress);
        intent.putExtra(DfuBaseService.EXTRA_DEVICE_NAME, this.deviceName);
        intent.putExtra(DfuBaseService.EXTRA_DISABLE_NOTIFICATION, this.disableNotification);
        intent.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, this.mimeType);
        intent.putExtra(DfuBaseService.EXTRA_FILE_TYPE, this.fileType);
        intent.putExtra(DfuBaseService.EXTRA_FILE_URI, this.fileUri);
        intent.putExtra(DfuBaseService.EXTRA_FILE_PATH, this.filePath);
        intent.putExtra(DfuBaseService.EXTRA_FILE_RES_ID, this.fileResId);
        intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_URI, this.initFileUri);
        intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_PATH, this.initFilePath);
        intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_RES_ID, this.initFileResId);
        intent.putExtra(DfuBaseService.EXTRA_KEEP_BOND, this.keepBond);
        context.startService(intent);
    }

    private DfuServiceInitiator init(Uri uri, String str, int i) {
        if (DfuBaseService.MIME_TYPE_ZIP.equals(this.mimeType)) {
            throw new InvalidParameterException("Init file must be located inside the ZIP");
        }
        this.initFileUri = uri;
        this.initFilePath = str;
        this.initFileResId = i;
        return this;
    }

    private DfuServiceInitiator init(Uri uri, String str, int i, int i2, String str2) {
        this.fileUri = uri;
        this.filePath = str;
        this.fileResId = i;
        this.fileType = i2;
        this.mimeType = str2;
        if (DfuBaseService.MIME_TYPE_ZIP.equals(str2)) {
            this.initFileUri = null;
            this.initFilePath = null;
            this.initFileResId = 0;
        }
        return this;
    }
}
