package android.support.v4.view;

import android.view.MotionEvent;

class ab {
    public static int m3645a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m3646b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m3647c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m3648d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m3644a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
