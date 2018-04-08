package android.support.v4.view;

import android.view.KeyEvent;

class C0653n {
    public static int m4314a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m4315a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m4317b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }

    public static boolean m4316a(KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }
}
