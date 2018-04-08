package no.nordicsemi.android.dfu.internal.exception;

public class DeviceDisconnectedException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mState;

    public DeviceDisconnectedException(String str, int i) {
        super(str);
        this.mState = i;
    }

    public int getConnectionState() {
        return this.mState;
    }

    public String getMessage() {
        return super.getMessage() + " (connection state: " + this.mState + ")";
    }
}
