package no.nordicsemi.android.dfu.internal.manifest;

import com.google.p076a.p077a.C1475c;
import java.util.List;

public class InitPacketData {
    @C1475c(a = "application_version")
    protected long applicationVersion;
    @C1475c(a = "compression_type")
    protected int compressionType;
    @C1475c(a = "device_revision")
    protected int deviceRevision;
    @C1475c(a = "device_type")
    protected int deviceType;
    @C1475c(a = "firmware_crc16")
    protected int firmwareCRC16;
    @C1475c(a = "firmware_hash")
    protected String firmwareHash;
    @C1475c(a = "packet_version")
    protected int packetVersion;
    @C1475c(a = "softdevice_req")
    protected List<Integer> softdeviceReq;

    public int getPacketVersion() {
        return this.packetVersion;
    }

    public int getCompressionType() {
        return this.compressionType;
    }

    public long getApplicationVersion() {
        return this.applicationVersion;
    }

    public int getDeviceRevision() {
        return this.deviceRevision;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getFirmwareCRC16() {
        return this.firmwareCRC16;
    }

    public String getFirmwareHash() {
        return this.firmwareHash;
    }

    public List<Integer> getSoftdeviceReq() {
        return this.softdeviceReq;
    }
}
