package com.onesignal;

import com.onesignal.ag.C2721a;

class bd extends C2721a {
    final /* synthetic */ bc f9248a;

    bd(bc bcVar) {
        this.f9248a = bcVar;
    }

    public void mo2310a(String str) {
        this.f9248a.f9247c.f9239h.addAll(this.f9248a.f9246b);
        this.f9248a.f9247c.f9240i.putString("purchaseTokens", this.f9248a.f9247c.f9239h.toString());
        this.f9248a.f9247c.f9240i.remove("ExistingPurchases");
        this.f9248a.f9247c.f9240i.commit();
        this.f9248a.f9247c.f9241j = false;
        this.f9248a.f9247c.f9242k = false;
    }
}
