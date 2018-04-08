package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

class as extends FrameLayout {
    static ViewGroup m2455a(View view) {
        ViewGroup asVar = new as(view.getContext());
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            asVar.setLayoutParams(layoutParams);
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        asVar.addView(view);
        return asVar;
    }

    public as(Context context) {
        super(context);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }
}
