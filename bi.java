package android.support.v4.view;

class bi implements Runnable {
    final /* synthetic */ ViewPager f2119a;

    bi(ViewPager viewPager) {
        this.f2119a = viewPager;
    }

    public void run() {
        this.f2119a.setScrollState(0);
        this.f2119a.m3233c();
    }
}
