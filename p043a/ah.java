package com.p041a.p042a.p043a;

import android.content.Context;
import io.p038b.p039a.p040a.p044a.p046b.C2956j;
import io.p038b.p039a.p040a.p044a.p046b.C2967t;
import io.p038b.p039a.p040a.p044a.p046b.C2967t.C2966a;
import java.util.Map;
import java.util.UUID;

class ah {
    private final Context f4098a;
    private final C2967t f4099b;
    private final String f4100c;
    private final String f4101d;

    public ah(Context context, C2967t c2967t, String str, String str2) {
        this.f4098a = context;
        this.f4099b = c2967t;
        this.f4100c = str;
        this.f4101d = str2;
    }

    public af m7615a() {
        Map i = this.f4099b.m17045i();
        return new af(this.f4099b.m17039c(), UUID.randomUUID().toString(), this.f4099b.m17038b(), (String) i.get(C2966a.ANDROID_ID), (String) i.get(C2966a.ANDROID_ADVERTISING_ID), this.f4099b.m17048l(), (String) i.get(C2966a.FONT_TOKEN), C2956j.m17018m(this.f4098a), this.f4099b.m17040d(), this.f4099b.m17043g(), this.f4100c, this.f4101d);
    }
}
