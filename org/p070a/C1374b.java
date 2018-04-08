package org.p070a;

import java.net.InetSocketAddress;
import org.p070a.p124b.C3121a;
import org.p070a.p125c.C3128b;
import org.p070a.p125c.C3130d;
import org.p070a.p126d.C3135d;
import org.p070a.p126d.C3135d.C3140a;
import org.p070a.p126d.C3138e;
import org.p070a.p127e.C3142a;
import org.p070a.p127e.C3147h;
import org.p070a.p127e.C3148i;
import org.p070a.p127e.C3149e;

public abstract class C1374b implements C1373d {
    public C3148i mo1290a(C1375a c1375a, C3121a c3121a, C3142a c3142a) throws C3128b {
        return new C3149e();
    }

    public void mo1293a(C1375a c1375a, C3142a c3142a, C3147h c3147h) throws C3128b {
    }

    public void mo1292a(C1375a c1375a, C3142a c3142a) throws C3128b {
    }

    public void mo1291a(C1375a c1375a, C3135d c3135d) {
    }

    public void mo1294b(C1375a c1375a, C3135d c3135d) {
        C3135d c3138e = new C3138e(c3135d);
        c3138e.mo2540a(C3140a.PONG);
        c1375a.mo1303a(c3138e);
    }

    public void mo1295c(C1375a c1375a, C3135d c3135d) {
    }

    public String mo1289a(C1375a c1375a) throws C3128b {
        InetSocketAddress a = c1375a.mo1296a();
        if (a == null) {
            throw new C3130d("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(a.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
