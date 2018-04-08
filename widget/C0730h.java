package android.support.v4.widget;

class C0730h implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar f2430a;

    C0730h(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f2430a = contentLoadingProgressBar;
    }

    public void run() {
        this.f2430a.f2161b = false;
        this.f2430a.f2160a = -1;
        this.f2430a.setVisibility(8);
    }
}
