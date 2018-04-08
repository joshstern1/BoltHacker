package android.support.v7.widget;

import android.view.inputmethod.InputMethodManager;

class cg implements Runnable {
    final /* synthetic */ SearchView f3773a;

    cg(SearchView searchView) {
        this.f3773a = searchView;
    }

    public void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f3773a.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            SearchView.f3391a.m6410a(inputMethodManager, this.f3773a, 0);
        }
    }
}
