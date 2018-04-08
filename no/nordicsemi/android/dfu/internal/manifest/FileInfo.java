package no.nordicsemi.android.dfu.internal.manifest;

import com.google.p076a.p077a.C1475c;

public class FileInfo {
    @C1475c(a = "bin_file")
    protected String binFile;
    @C1475c(a = "dat_file")
    protected String datFile;
    @C1475c(a = "init_packet_data")
    protected InitPacketData initPacketData;

    public String getBinFileName() {
        return this.binFile;
    }

    public String getDatFileName() {
        return this.datFile;
    }

    public InitPacketData getInitPacketData() {
        return this.initPacketData;
    }
}
