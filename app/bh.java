package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class bh {
    static void m2612a(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(str, i);
    }

    public static void m2613a(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(str, i, notification);
    }
}
