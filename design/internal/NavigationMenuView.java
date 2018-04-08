package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.C0195u;
import android.support.v7.view.menu.C0197k;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView extends RecyclerView implements C0195u {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }

    public void mo141a(C0197k c0197k) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
