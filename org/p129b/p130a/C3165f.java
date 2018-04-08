package org.p129b.p130a;

public class C3165f {
    public static final void m17741a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void m17740a(String str) {
        System.err.println("SLF4J: " + str);
    }
}
