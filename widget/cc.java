package android.support.v7.widget;

class cc {
    private int f3740a = 0;
    private int f3741b = 0;
    private int f3742c = Integer.MIN_VALUE;
    private int f3743d = Integer.MIN_VALUE;
    private int f3744e = 0;
    private int f3745f = 0;
    private boolean f3746g = false;
    private boolean f3747h = false;

    cc() {
    }

    public int m6998a() {
        return this.f3740a;
    }

    public int m7001b() {
        return this.f3741b;
    }

    public int m7003c() {
        return this.f3746g ? this.f3741b : this.f3740a;
    }

    public int m7004d() {
        return this.f3746g ? this.f3740a : this.f3741b;
    }

    public void m6999a(int i, int i2) {
        this.f3742c = i;
        this.f3743d = i2;
        this.f3747h = true;
        if (this.f3746g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f3740a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f3741b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f3740a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f3741b = i2;
        }
    }

    public void m7002b(int i, int i2) {
        this.f3747h = false;
        if (i != Integer.MIN_VALUE) {
            this.f3744e = i;
            this.f3740a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f3745f = i2;
            this.f3741b = i2;
        }
    }

    public void m7000a(boolean z) {
        if (z != this.f3746g) {
            this.f3746g = z;
            if (!this.f3747h) {
                this.f3740a = this.f3744e;
                this.f3741b = this.f3745f;
            } else if (z) {
                this.f3740a = this.f3743d != Integer.MIN_VALUE ? this.f3743d : this.f3744e;
                this.f3741b = this.f3742c != Integer.MIN_VALUE ? this.f3742c : this.f3745f;
            } else {
                this.f3740a = this.f3742c != Integer.MIN_VALUE ? this.f3742c : this.f3744e;
                this.f3741b = this.f3743d != Integer.MIN_VALUE ? this.f3743d : this.f3745f;
            }
        }
    }
}
