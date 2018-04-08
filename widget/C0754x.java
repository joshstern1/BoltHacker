package android.support.v4.widget;

import android.widget.ListView;

public class C0754x extends C0699a {
    private final ListView f2453a;

    public C0754x(ListView listView) {
        super(listView);
        this.f2453a = listView;
    }

    public void mo717a(int i, int i2) {
        C0755y.m4959a(this.f2453a, i2);
    }

    public boolean mo718e(int i) {
        return false;
    }

    public boolean mo719f(int i) {
        ListView listView = this.f2453a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
