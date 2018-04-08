package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;

public class BootloaderScannerJB implements LeScanCallback, BootloaderScanner {
    private String mBootloaderAddress;
    private String mDeviceAddress;
    private String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();

    class C30891 implements Runnable {
        C30891() {
        }

        public void run() {
            try {
                Thread.sleep(BootloaderScanner.TIMEOUT);
            } catch (InterruptedException e) {
            }
            if (!BootloaderScannerJB.this.mFound) {
                BootloaderScannerJB.this.mBootloaderAddress = null;
                BootloaderScannerJB.this.mFound = true;
                synchronized (BootloaderScannerJB.this.mLock) {
                    BootloaderScannerJB.this.mLock.notifyAll();
                }
            }
        }
    }

    public String searchFor(String str) {
        String substring = str.substring(0, 15);
        String format = String.format("%02X", new Object[]{Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255)});
        this.mDeviceAddress = str;
        this.mDeviceAddressIncremented = substring + format;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new C30891(), "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        defaultAdapter.startLeScan(this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
        }
        defaultAdapter.stopLeScan(this);
        return this.mBootloaderAddress;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        String address = bluetoothDevice.getAddress();
        if (this.mDeviceAddress.equals(address) || this.mDeviceAddressIncremented.equals(address)) {
            this.mBootloaderAddress = address;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }
}
