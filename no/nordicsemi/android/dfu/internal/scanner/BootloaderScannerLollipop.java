package no.nordicsemi.android.dfu.internal.scanner;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings.Builder;

@TargetApi(21)
public class BootloaderScannerLollipop extends ScanCallback implements BootloaderScanner {
    private String mBootloaderAddress;
    private String mDeviceAddress;
    private String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();

    class C30901 implements Runnable {
        C30901() {
        }

        public void run() {
            try {
                Thread.sleep(BootloaderScanner.TIMEOUT);
            } catch (InterruptedException e) {
            }
            if (!BootloaderScannerLollipop.this.mFound) {
                BootloaderScannerLollipop.this.mBootloaderAddress = null;
                BootloaderScannerLollipop.this.mFound = true;
                synchronized (BootloaderScannerLollipop.this.mLock) {
                    BootloaderScannerLollipop.this.mLock.notifyAll();
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
        new Thread(new C30901(), "Scanner timer").start();
        BluetoothLeScanner bluetoothLeScanner = BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner();
        bluetoothLeScanner.startScan(null, new Builder().setScanMode(2).build(), this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
        }
        bluetoothLeScanner.stopScan(this);
        return this.mBootloaderAddress;
    }

    public void onScanResult(int i, ScanResult scanResult) {
        String address = scanResult.getDevice().getAddress();
        if (this.mDeviceAddress.equals(address) || this.mDeviceAddressIncremented.equals(address)) {
            this.mBootloaderAddress = address;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }
}
