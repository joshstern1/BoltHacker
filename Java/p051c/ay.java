package com.p041a.p042a.p051c;

import io.p038b.p039a.p040a.p044a.p046b.C2972w.C1141c;
import java.io.IOException;
import java.io.InputStream;

class ay implements C1141c {
    final /* synthetic */ byte[] f4299a;
    final /* synthetic */ int[] f4300b;
    final /* synthetic */ ax f4301c;

    ay(ax axVar, byte[] bArr, int[] iArr) {
        this.f4301c = axVar;
        this.f4299a = bArr;
        this.f4300b = iArr;
    }

    public void mo1187a(InputStream inputStream, int i) throws IOException {
        try {
            inputStream.read(this.f4299a, this.f4300b[0], i);
            int[] iArr = this.f4300b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
