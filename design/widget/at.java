package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior.C0240b;
import android.support.v4.view.ao;
import android.support.v4.widget.bd.C0258a;
import android.view.View;
import android.view.ViewParent;

class at extends C0258a {
    final /* synthetic */ SwipeDismissBehavior f1303a;
    private int f1304b;

    at(SwipeDismissBehavior swipeDismissBehavior) {
        this.f1303a = swipeDismissBehavior;
    }

    public boolean mo241a(View view, int i) {
        return this.f1303a.mo212a(view);
    }

    public void mo244b(View view, int i) {
        this.f1304b = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void mo238a(int i) {
        if (this.f1303a.f1149b != null) {
            this.f1303a.f1149b.mo229a(i);
        }
    }

    public void mo239a(View view, float f, float f2) {
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int width = view.getWidth();
        if (m1990a(view, f)) {
            width = view.getLeft() < this.f1304b ? this.f1304b - width : this.f1304b + width;
            z = true;
        } else {
            width = this.f1304b;
        }
        if (this.f1303a.f1148a.m4830a(width, view.getTop())) {
            ao.m3913a(view, new C0240b(this.f1303a, view, z));
        } else if (z && this.f1303a.f1149b != null) {
            this.f1303a.f1149b.mo230a(view);
        }
    }

    private boolean m1990a(View view, float f) {
        if (f != 0.0f) {
            boolean z = ao.m3938h(view) == 1;
            if (this.f1303a.f1153f == 2) {
                return true;
            }
            if (this.f1303a.f1153f == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                    return true;
                } else if (f <= 0.0f) {
                    return false;
                } else {
                    return true;
                }
            } else if (this.f1303a.f1153f != 1) {
                return false;
            } else {
                if (z) {
                    if (f <= 0.0f) {
                        return false;
                    }
                    return true;
                } else if (f >= 0.0f) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (Math.abs(view.getLeft() - this.f1304b) < Math.round(((float) view.getWidth()) * this.f1303a.f1154g)) {
            return false;
        }
        return true;
    }

    public int mo242b(View view) {
        return view.getWidth();
    }

    public int mo243b(View view, int i, int i2) {
        int width;
        int i3;
        Object obj = ao.m3938h(view) == 1 ? 1 : null;
        if (this.f1303a.f1153f == 0) {
            if (obj != null) {
                width = this.f1304b - view.getWidth();
                i3 = this.f1304b;
            } else {
                width = this.f1304b;
                i3 = this.f1304b + view.getWidth();
            }
        } else if (this.f1303a.f1153f != 1) {
            width = this.f1304b - view.getWidth();
            i3 = this.f1304b + view.getWidth();
        } else if (obj != null) {
            width = this.f1304b;
            i3 = this.f1304b + view.getWidth();
        } else {
            width = this.f1304b - view.getWidth();
            i3 = this.f1304b;
        }
        return SwipeDismissBehavior.m1744b(width, i, i3);
    }

    public int mo237a(View view, int i, int i2) {
        return view.getTop();
    }

    public void mo240a(View view, int i, int i2, int i3, int i4) {
        float width = ((float) this.f1304b) + (((float) view.getWidth()) * this.f1303a.f1155h);
        float width2 = ((float) this.f1304b) + (((float) view.getWidth()) * this.f1303a.f1156i);
        if (((float) i) <= width) {
            ao.m3924c(view, 1.0f);
        } else if (((float) i) >= width2) {
            ao.m3924c(view, 0.0f);
        } else {
            ao.m3924c(view, SwipeDismissBehavior.m1746c(0.0f, 1.0f - SwipeDismissBehavior.m1739a(width, width2, (float) i), 1.0f));
        }
    }
}
