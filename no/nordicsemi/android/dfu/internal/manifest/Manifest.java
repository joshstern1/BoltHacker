package no.nordicsemi.android.dfu.internal.manifest;

import com.google.p076a.p077a.C1475c;

public class Manifest {
    protected FileInfo application;
    protected FileInfo bootloader;
    protected FileInfo softdevice;
    @C1475c(a = "softdevice_bootloader")
    protected SoftDeviceBootloaderFileInfo softdeviceBootloader;

    public FileInfo getApplicationInfo() {
        return this.application;
    }

    public FileInfo getBootloaderInfo() {
        return this.bootloader;
    }

    public FileInfo getSoftdeviceInfo() {
        return this.softdevice;
    }

    public SoftDeviceBootloaderFileInfo getSoftdeviceBootloaderInfo() {
        return this.softdeviceBootloader;
    }
}
