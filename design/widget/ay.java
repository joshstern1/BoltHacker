package android.support.design.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class ay extends AppCompatEditText {
    public ay(Context context) {
        super(context);
    }

    public ay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = getParent();
            if (parent instanceof TextInputLayout) {
                editorInfo.hintText = ((TextInputLayout) parent).getHint();
            }
        }
        return onCreateInputConnection;
    }
}
