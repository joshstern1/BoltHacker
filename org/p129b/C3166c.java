package org.p129b;

import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.p129b.p130a.C3163c;
import org.p129b.p130a.C3164e;
import org.p129b.p130a.C3165f;
import org.slf4j.impl.StaticLoggerBinder;

public final class C3166c {
    static int f10386a = 0;
    static C3164e f10387b = new C3164e();
    static C3163c f10388c = new C3163c();
    private static final String[] f10389d = new String[]{"1.6", "1.7"};
    private static String f10390e = "org/slf4j/impl/StaticLoggerBinder.class";

    private C3166c() {
    }

    private static final void m17747b() {
        C3166c.m17750c();
        if (f10386a == 3) {
            C3166c.m17753e();
        }
    }

    private static boolean m17749b(String str) {
        if (str == null) {
            return false;
        }
        if (str.indexOf("org/slf4j/impl/StaticLoggerBinder") != -1) {
            return true;
        }
        if (str.indexOf("org.slf4j.impl.StaticLoggerBinder") != -1) {
            return true;
        }
        return false;
    }

    private static final void m17750c() {
        try {
            Set f = C3166c.m17754f();
            C3166c.m17748b(f);
            StaticLoggerBinder.getSingleton();
            f10386a = 3;
            C3166c.m17751c(f);
            C3166c.m17752d();
        } catch (Throwable e) {
            if (C3166c.m17749b(e.getMessage())) {
                f10386a = 4;
                C3165f.m17740a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                C3165f.m17740a("Defaulting to no-operation (NOP) logger implementation");
                C3165f.m17740a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            C3166c.m17745a(e);
            throw e;
        } catch (NoSuchMethodError e2) {
            String message = e2.getMessage();
            if (!(message == null || message.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") == -1)) {
                f10386a = 2;
                C3165f.m17740a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                C3165f.m17740a("Your binding is version 1.5.5 or earlier.");
                C3165f.m17740a("Upgrade your binding to version 1.6.x.");
            }
            throw e2;
        } catch (Throwable e3) {
            C3166c.m17745a(e3);
            throw new IllegalStateException("Unexpected initialization failure", e3);
        }
    }

    static void m17745a(Throwable th) {
        f10386a = 2;
        C3165f.m17741a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static final void m17752d() {
        List a = f10387b.m17738a();
        if (a.size() != 0) {
            C3165f.m17740a("The following loggers will not work because they were created");
            C3165f.m17740a("during the default configuration phase of the underlying logging system.");
            C3165f.m17740a("See also http://www.slf4j.org/codes.html#substituteLogger");
            for (int i = 0; i < a.size(); i++) {
                C3165f.m17740a((String) a.get(i));
            }
        }
    }

    private static final void m17753e() {
        Object obj = null;
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            for (String startsWith : f10389d) {
                if (str.startsWith(startsWith)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                C3165f.m17740a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f10389d).toString());
                C3165f.m17740a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError e) {
        } catch (Throwable th) {
            C3165f.m17741a("Unexpected problem occured during version sanity check", th);
        }
    }

    private static Set m17754f() {
        Set linkedHashSet = new LinkedHashSet();
        try {
            Enumeration systemResources;
            ClassLoader classLoader = C3166c.class.getClassLoader();
            if (classLoader == null) {
                systemResources = ClassLoader.getSystemResources(f10390e);
            } else {
                systemResources = classLoader.getResources(f10390e);
            }
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add((URL) systemResources.nextElement());
            }
        } catch (Throwable e) {
            C3165f.m17741a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    private static boolean m17746a(Set set) {
        return set.size() > 1;
    }

    private static void m17748b(Set set) {
        if (C3166c.m17746a(set)) {
            C3165f.m17740a("Class path contains multiple SLF4J bindings.");
            for (URL url : set) {
                C3165f.m17740a("Found binding in [" + url + "]");
            }
            C3165f.m17740a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static void m17751c(Set set) {
        if (C3166c.m17746a(set)) {
            C3165f.m17740a("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
        }
    }

    public static C3158b m17744a(String str) {
        return C3166c.m17742a().mo2564a(str);
    }

    public static C3158b m17743a(Class cls) {
        return C3166c.m17744a(cls.getName());
    }

    public static C3162a m17742a() {
        if (f10386a == 0) {
            f10386a = 1;
            C3166c.m17747b();
        }
        switch (f10386a) {
            case 1:
                return f10387b;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return StaticLoggerBinder.getSingleton().getLoggerFactory();
            case 4:
                return f10388c;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
