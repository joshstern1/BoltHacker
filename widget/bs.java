package android.support.v7.widget;

class bs implements Runnable {
    final /* synthetic */ RecyclerView f3731a;

    bs(RecyclerView recyclerView) {
        this.f3731a = recyclerView;
    }

    public void run() {
        if (this.f3731a.f926g && !this.f3731a.isLayoutRequested()) {
            if (!this.f3731a.f899B) {
                this.f3731a.requestLayout();
            } else if (this.f3731a.f903F) {
                this.f3731a.f902E = true;
            } else {
                this.f3731a.m1216t();
            }
        }
    }
}
