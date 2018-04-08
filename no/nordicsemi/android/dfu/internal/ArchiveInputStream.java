package no.nordicsemi.android.dfu.internal;

import com.google.p076a.C1567k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.FileInfo;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;
import no.nordicsemi.android.dfu.internal.manifest.SoftDeviceBootloaderFileInfo;

public class ArchiveInputStream extends ZipInputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private byte[] applicationBytes;
    private byte[] applicationInitBytes;
    private int applicationSize;
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead = 0;
    private int bytesReadFromCurrentSource = 0;
    private byte[] currentSource;
    private Map<String, byte[]> entries = new HashMap();
    private Manifest manifest;
    private byte[] softDeviceAndBootloaderBytes;
    private byte[] softDeviceBytes;
    private int softDeviceSize;
    private byte[] systemInitBytes;

    public ArchiveInputStream(InputStream inputStream, int i, int i2) throws IOException {
        int i3 = 0;
        int i4 = 1;
        super(inputStream);
        try {
            parseZip(i);
            int i5;
            if (this.manifest != null) {
                FileInfo applicationInfo;
                if (this.manifest.getApplicationInfo() == null || (i2 != 0 && (i2 & 4) <= 0)) {
                    i5 = 0;
                } else {
                    applicationInfo = this.manifest.getApplicationInfo();
                    this.applicationBytes = (byte[]) this.entries.get(applicationInfo.getBinFileName());
                    this.applicationInitBytes = (byte[]) this.entries.get(applicationInfo.getDatFileName());
                    if (this.applicationBytes == null) {
                        throw new IOException("Application file " + applicationInfo.getBinFileName() + " not found.");
                    }
                    this.applicationSize = this.applicationBytes.length;
                    this.currentSource = this.applicationBytes;
                    i5 = 1;
                }
                if (this.manifest.getBootloaderInfo() != null && (i2 == 0 || (i2 & 2) > 0)) {
                    if (this.systemInitBytes != null) {
                        throw new IOException("Manifest: softdevice and bootloader specified. Use softdevice_bootloader instead.");
                    }
                    applicationInfo = this.manifest.getBootloaderInfo();
                    this.bootloaderBytes = (byte[]) this.entries.get(applicationInfo.getBinFileName());
                    this.systemInitBytes = (byte[]) this.entries.get(applicationInfo.getDatFileName());
                    if (this.bootloaderBytes == null) {
                        throw new IOException("Bootloader file " + applicationInfo.getBinFileName() + " not found.");
                    }
                    this.bootloaderSize = this.bootloaderBytes.length;
                    this.currentSource = this.bootloaderBytes;
                    i5 = 1;
                }
                if (this.manifest.getSoftdeviceInfo() != null && (i2 == 0 || (i2 & 1) > 0)) {
                    applicationInfo = this.manifest.getSoftdeviceInfo();
                    this.softDeviceBytes = (byte[]) this.entries.get(applicationInfo.getBinFileName());
                    this.systemInitBytes = (byte[]) this.entries.get(applicationInfo.getDatFileName());
                    if (this.softDeviceBytes == null) {
                        throw new IOException("SoftDevice file " + applicationInfo.getBinFileName() + " not found.");
                    }
                    this.softDeviceSize = this.softDeviceBytes.length;
                    this.currentSource = this.softDeviceBytes;
                    i5 = 1;
                }
                if (this.manifest.getSoftdeviceBootloaderInfo() == null || (i2 != 0 && ((i2 & 1) <= 0 || (i2 & 2) <= 0))) {
                    i4 = i5;
                } else if (this.systemInitBytes != null) {
                    throw new IOException("Manifest: The softdevice_bootloader may not be used together with softdevice or bootloader.");
                } else {
                    SoftDeviceBootloaderFileInfo softdeviceBootloaderInfo = this.manifest.getSoftdeviceBootloaderInfo();
                    this.softDeviceAndBootloaderBytes = (byte[]) this.entries.get(softdeviceBootloaderInfo.getBinFileName());
                    this.systemInitBytes = (byte[]) this.entries.get(softdeviceBootloaderInfo.getDatFileName());
                    if (this.softDeviceAndBootloaderBytes == null) {
                        throw new IOException("File " + softdeviceBootloaderInfo.getBinFileName() + " not found.");
                    }
                    this.softDeviceSize = softdeviceBootloaderInfo.getSoftdeviceSize();
                    this.bootloaderSize = softdeviceBootloaderInfo.getBootloaderSize();
                    this.currentSource = this.softDeviceAndBootloaderBytes;
                }
                if (i4 == 0) {
                    throw new IOException("Manifest file must specify at least one file.");
                }
            }
            if (i2 == 0 || (i2 & 4) > 0) {
                this.applicationBytes = (byte[]) this.entries.get(APPLICATION_HEX);
                if (this.applicationBytes == null) {
                    this.applicationBytes = (byte[]) this.entries.get(APPLICATION_BIN);
                }
                if (this.applicationBytes != null) {
                    this.applicationSize = this.applicationBytes.length;
                    this.applicationInitBytes = (byte[]) this.entries.get(APPLICATION_INIT);
                    this.currentSource = this.applicationBytes;
                    i3 = 1;
                }
            }
            if (i2 == 0 || (i2 & 2) > 0) {
                this.bootloaderBytes = (byte[]) this.entries.get(BOOTLOADER_HEX);
                if (this.bootloaderBytes == null) {
                    this.bootloaderBytes = (byte[]) this.entries.get(BOOTLOADER_BIN);
                }
                if (this.bootloaderBytes != null) {
                    this.bootloaderSize = this.bootloaderBytes.length;
                    this.systemInitBytes = (byte[]) this.entries.get(SYSTEM_INIT);
                    this.currentSource = this.bootloaderBytes;
                    i3 = 1;
                }
            }
            if (i2 == 0 || (i2 & 1) > 0) {
                this.softDeviceBytes = (byte[]) this.entries.get(SOFTDEVICE_HEX);
                if (this.softDeviceBytes == null) {
                    this.softDeviceBytes = (byte[]) this.entries.get(SOFTDEVICE_BIN);
                }
                if (this.softDeviceBytes != null) {
                    this.softDeviceSize = this.softDeviceBytes.length;
                    this.systemInitBytes = (byte[]) this.entries.get(SYSTEM_INIT);
                    this.currentSource = this.softDeviceBytes;
                    i5 = 1;
                    if (i5 == 0) {
                        throw new IOException("The ZIP file must contain an Application, a Soft Device and/or a Bootloader.");
                    }
                }
            }
            i5 = i3;
            if (i5 == 0) {
                throw new IOException("The ZIP file must contain an Application, a Soft Device and/or a Bootloader.");
            }
            super.close();
        } catch (Throwable th) {
            super.close();
        }
    }

    private void parseZip(int i) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = super.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            Object toByteArray = byteArrayOutputStream.toByteArray();
            if (name.toLowerCase(Locale.US).endsWith("hex")) {
                HexInputStream hexInputStream = new HexInputStream((byte[]) toByteArray, i);
                toByteArray = new byte[hexInputStream.available()];
                hexInputStream.read(toByteArray);
                hexInputStream.close();
            }
            if (MANIFEST.equals(name)) {
                str = new String(toByteArray, "UTF-8");
            } else {
                this.entries.put(name, toByteArray);
            }
        }
        if (str != null) {
            this.manifest = ((ManifestFile) new C1567k().m9686a(str, ManifestFile.class)).getManifest();
        }
    }

    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.softDeviceBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        super.close();
    }

    public int read(byte[] bArr) throws IOException {
        int length = this.currentSource.length - this.bytesReadFromCurrentSource;
        if (bArr.length <= length) {
            length = bArr.length;
        }
        System.arraycopy(this.currentSource, this.bytesReadFromCurrentSource, bArr, 0, length);
        this.bytesReadFromCurrentSource += length;
        if (bArr.length > length) {
            if (startNextFile() == null) {
                this.bytesRead += length;
                return length;
            }
            int length2 = this.currentSource.length;
            if (bArr.length - length <= length2) {
                length2 = bArr.length - length;
            }
            System.arraycopy(this.currentSource, 0, bArr, length, length2);
            this.bytesReadFromCurrentSource += length2;
            length += length2;
        }
        this.bytesRead += length;
        return length;
    }

    public Manifest getManifest() {
        return this.manifest;
    }

    public int getContentType() {
        int i = 0;
        if (this.softDeviceSize > 0) {
            i = (byte) 1;
        }
        if (this.bootloaderSize > 0) {
            i = (byte) (i | 2);
        }
        if (this.applicationSize > 0) {
            return (byte) (i | 4);
        }
        return i;
    }

    public int setContentType(int i) {
        if (this.bytesRead > 0) {
            throw new UnsupportedOperationException("Content type must not be change after reading content");
        }
        int contentType = getContentType() & i;
        if ((contentType & 1) == 0) {
            this.softDeviceBytes = null;
            if (this.softDeviceAndBootloaderBytes != null) {
                this.softDeviceAndBootloaderBytes = null;
                this.bootloaderSize = 0;
            }
            this.softDeviceSize = 0;
        }
        if ((contentType & 2) == 0) {
            this.bootloaderBytes = null;
            if (this.softDeviceAndBootloaderBytes != null) {
                this.softDeviceAndBootloaderBytes = null;
                this.softDeviceSize = 0;
            }
            this.bootloaderSize = 0;
        }
        if ((contentType & 4) == 0) {
            this.applicationBytes = null;
            this.applicationSize = 0;
        }
        return contentType;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        if (this.currentSource == this.softDeviceBytes && this.bootloaderBytes != null) {
            bArr = this.bootloaderBytes;
            this.currentSource = bArr;
        } else if (this.currentSource == this.applicationBytes || this.applicationBytes == null) {
            bArr = null;
            this.currentSource = null;
        } else {
            bArr = this.applicationBytes;
            this.currentSource = bArr;
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    public int available() {
        return ((this.softDeviceSize + this.bootloaderSize) + this.applicationSize) - this.bytesRead;
    }

    public int softDeviceImageSize() {
        return this.softDeviceSize;
    }

    public int bootloaderImageSize() {
        return this.bootloaderSize;
    }

    public int applicationImageSize() {
        return this.applicationSize;
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }
}
