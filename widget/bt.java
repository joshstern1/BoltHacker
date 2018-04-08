package android.support.v7.widget;

class bt implements Runnable {
    final /* synthetic */ RecyclerView f3732a;

    bt(RecyclerView recyclerView) {
        this.f3732a = recyclerView;
    }

    public void run() {
        if (this.f3732a.f927h != null) {
            this.f3732a.f927h.mo987a();
        }
        this.f3732a.al = false;
    }
}
