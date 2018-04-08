package android.support.v7.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class cr implements OnEditorActionListener {
    final /* synthetic */ SearchView f3784a;

    cr(SearchView searchView) {
        this.f3784a = searchView;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f3784a.m6469p();
        return true;
    }
}
