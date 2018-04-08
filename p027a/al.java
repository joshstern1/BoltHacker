package android.support.v7.p027a;

import android.app.Notification.MediaStyle;
import android.media.session.MediaSession.Token;
import android.support.v4.app.au;

class al {
    public static void m5027a(au auVar, int[] iArr, Object obj) {
        MediaStyle mediaStyle = new MediaStyle(auVar.mo326a());
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        if (obj != null) {
            mediaStyle.setMediaSession((Token) obj);
        }
    }
}
