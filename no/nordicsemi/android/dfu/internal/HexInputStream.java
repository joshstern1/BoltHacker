package no.nordicsemi.android.dfu.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;

public class HexInputStream extends FilterInputStream {
    private final int LINE_LENGTH;
    private final int MBRSize;
    private int available;
    private int bytesRead;
    private int lastAddress;
    private final byte[] localBuf;
    private int localPos;
    private int pos;
    private int size;

    public HexInputStream(InputStream inputStream, int i) throws HexFileValidationException, IOException {
        super(new BufferedInputStream(inputStream));
        this.LINE_LENGTH = 128;
        this.localBuf = new byte[128];
        this.localPos = 128;
        this.size = this.localBuf.length;
        this.lastAddress = 0;
        this.MBRSize = i;
        this.available = calculateBinSize(i);
    }

    public HexInputStream(byte[] bArr, int i) throws HexFileValidationException, IOException {
        super(new ByteArrayInputStream(bArr));
        this.LINE_LENGTH = 128;
        this.localBuf = new byte[128];
        this.localPos = 128;
        this.size = this.localBuf.length;
        this.lastAddress = 0;
        this.MBRSize = i;
        this.available = calculateBinSize(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int calculateBinSize(int r8) throws java.io.IOException {
        /*
        r7 = this;
        r2 = 0;
        r3 = r7.in;
        r0 = r3.available();
        r3.mark(r0);
        r0 = r3.read();	 Catch:{ all -> 0x007e }
        r1 = r0;
        r0 = r2;
    L_0x0010:
        r7.checkComma(r1);	 Catch:{ all -> 0x007e }
        r1 = r7.readByte(r3);	 Catch:{ all -> 0x007e }
        r4 = r7.readAddress(r3);	 Catch:{ all -> 0x007e }
        r5 = r7.readByte(r3);	 Catch:{ all -> 0x007e }
        switch(r5) {
            case 0: goto L_0x0079;
            case 1: goto L_0x003d;
            case 2: goto L_0x005c;
            case 3: goto L_0x0022;
            case 4: goto L_0x0041;
            default: goto L_0x0022;
        };	 Catch:{ all -> 0x007e }
    L_0x0022:
        r1 = r1 * 2;
        r1 = r1 + 2;
        r4 = (long) r1;	 Catch:{ all -> 0x007e }
        r3.skip(r4);	 Catch:{ all -> 0x007e }
        r1 = r0;
        r0 = r2;
    L_0x002c:
        r2 = r3.read();	 Catch:{ all -> 0x007e }
        r4 = 10;
        if (r2 == r4) goto L_0x002c;
    L_0x0034:
        r4 = 13;
        if (r2 == r4) goto L_0x002c;
    L_0x0038:
        r6 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r6;
        goto L_0x0010;
    L_0x003d:
        r3.reset();
    L_0x0040:
        return r0;
    L_0x0041:
        r1 = r7.readAddress(r3);	 Catch:{ all -> 0x007e }
        if (r0 <= 0) goto L_0x0051;
    L_0x0047:
        r2 = r2 >> 16;
        r2 = r2 + 1;
        if (r1 == r2) goto L_0x0051;
    L_0x004d:
        r3.reset();
        goto L_0x0040;
    L_0x0051:
        r1 = r1 << 16;
        r4 = 2;
        r3.skip(r4);	 Catch:{ all -> 0x007e }
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x002c;
    L_0x005c:
        r1 = r7.readAddress(r3);	 Catch:{ all -> 0x007e }
        r1 = r1 << 4;
        if (r0 <= 0) goto L_0x0070;
    L_0x0064:
        r4 = r1 >> 16;
        r2 = r2 >> 16;
        r2 = r2 + 1;
        if (r4 == r2) goto L_0x0070;
    L_0x006c:
        r3.reset();
        goto L_0x0040;
    L_0x0070:
        r4 = 2;
        r3.skip(r4);	 Catch:{ all -> 0x007e }
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x002c;
    L_0x0079:
        r4 = r4 + r2;
        if (r4 < r8) goto L_0x0022;
    L_0x007c:
        r0 = r0 + r1;
        goto L_0x0022;
    L_0x007e:
        r0 = move-exception;
        r3.reset();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.HexInputStream.calculateBinSize(int):int");
    }

    public int available() {
        return this.available - this.bytesRead;
    }

    public int readPacket(byte[] bArr) throws HexFileValidationException, IOException {
        int i = 0;
        while (i < bArr.length) {
            int i2;
            if (this.localPos < this.size) {
                i2 = i + 1;
                byte[] bArr2 = this.localBuf;
                int i3 = this.localPos;
                this.localPos = i3 + 1;
                bArr[i] = bArr2[i3];
                i = i2;
            } else {
                i2 = this.bytesRead;
                int readLine = readLine();
                this.size = readLine;
                this.bytesRead = i2 + readLine;
                if (this.size == 0) {
                    break;
                }
            }
        }
        return i;
    }

    public int read() throws IOException {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int read(byte[] bArr) throws IOException {
        return readPacket(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public int sizeInBytes() {
        return this.available;
    }

    public int sizeInPackets(int i) throws IOException {
        int sizeInBytes = sizeInBytes();
        return (sizeInBytes % i > 0 ? 1 : 0) + (sizeInBytes / i);
    }

    private int readLine() throws IOException {
        if (this.pos == -1) {
            return 0;
        }
        InputStream inputStream = this.in;
        while (true) {
            int read = inputStream.read();
            this.pos++;
            if (!(read == 10 || read == 13)) {
                checkComma(read);
                int readByte = readByte(inputStream);
                this.pos += 2;
                int readAddress = readAddress(inputStream);
                this.pos += 4;
                read = readByte(inputStream);
                this.pos += 2;
                switch (read) {
                    case 0:
                        if (readAddress + this.lastAddress < this.MBRSize) {
                            this.pos = (int) (((long) this.pos) + inputStream.skip((long) ((readByte * 2) + 2)));
                            read = -1;
                            break;
                        }
                        break;
                    case 1:
                        this.pos = -1;
                        return 0;
                    case 2:
                        readAddress = readAddress(inputStream) << 4;
                        this.pos += 4;
                        if (this.bytesRead <= 0 || (readAddress >> 16) == (this.lastAddress >> 16) + 1) {
                            this.lastAddress = readAddress;
                            this.pos = (int) (((long) this.pos) + inputStream.skip(2));
                            break;
                        }
                        return 0;
                    case 4:
                        readAddress = readAddress(inputStream);
                        this.pos += 4;
                        if (this.bytesRead <= 0 || readAddress == (this.lastAddress >> 16) + 1) {
                            this.lastAddress = readAddress << 16;
                            this.pos = (int) (((long) this.pos) + inputStream.skip(2));
                            break;
                        }
                        return 0;
                    default:
                        this.pos = (int) (((long) this.pos) + inputStream.skip((long) ((readByte * 2) + 2)));
                        break;
                }
                if (read == 0) {
                    read = 0;
                    while (read < this.localBuf.length && read < readByte) {
                        int readByte2 = readByte(inputStream);
                        this.pos += 2;
                        this.localBuf[read] = (byte) readByte2;
                        read++;
                    }
                    this.pos = (int) (inputStream.skip(2) + ((long) this.pos));
                    this.localPos = 0;
                    return readByte;
                }
            }
        }
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.pos = 0;
        this.bytesRead = 0;
        this.localPos = 0;
    }

    private void checkComma(int i) throws HexFileValidationException {
        if (i != 58) {
            throw new HexFileValidationException("Not a HEX file");
        }
    }

    private int readByte(InputStream inputStream) throws IOException {
        return (asciiToInt(inputStream.read()) << 4) | asciiToInt(inputStream.read());
    }

    private int readAddress(InputStream inputStream) throws IOException {
        return (readByte(inputStream) << 8) | readByte(inputStream);
    }

    private int asciiToInt(int i) {
        if (i >= 65) {
            return i - 55;
        }
        if (i >= 48) {
            return i - 48;
        }
        return -1;
    }
}
