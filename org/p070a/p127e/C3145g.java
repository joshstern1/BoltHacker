package org.p070a.p127e;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class C3145g implements C3143c {
    private byte[] f10337a;
    private TreeMap<String, String> f10338b = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public Iterator<String> mo2553b() {
        return Collections.unmodifiableSet(this.f10338b.keySet()).iterator();
    }

    public String mo2552b(String str) {
        String str2 = (String) this.f10338b.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public byte[] mo2555c() {
        return this.f10337a;
    }

    public void mo2551a(byte[] bArr) {
        this.f10337a = bArr;
    }

    public void mo2550a(String str, String str2) {
        this.f10338b.put(str, str2);
    }

    public boolean mo2554c(String str) {
        return this.f10338b.containsKey(str);
    }
}
