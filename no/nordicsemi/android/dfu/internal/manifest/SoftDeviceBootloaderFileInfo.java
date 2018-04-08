package no.nordicsemi.android.dfu.internal.manifest;

import com.google.p076a.p077a.C1475c;

public class SoftDeviceBootloaderFileInfo extends FileInfo {
    @C1475c(a = "bl_size")
    protected int bootloaderSize;
    @C1475c(a = "sd_size")
    protected int softdeviceSize;

    public int getSoftdeviceSize() {
        return this.softdeviceSize;
    }

    public int getBootloaderSize() {
        return this.bootloaderSize;
    }
}
