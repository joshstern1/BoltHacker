package android.support.v4.widget;

class C0731i implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar f2431a;

    C0731i(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f2431a = contentLoadingProgressBar;
    }

    public void run() {
        this.f2431a.f2162c = false;
        if (!this.f2431a.f2163d) {
            this.f2431a.f2160a = System.currentTimeMillis();
            this.f2431a.setVisibility(0);
        }
    }
}
