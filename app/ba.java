package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.bl.C0367a;

public class ba {

    public static abstract class C0321a {

        public interface C0343a {
        }

        public abstract int mo315a();

        public abstract CharSequence mo316b();

        public abstract PendingIntent mo317c();

        public abstract Bundle mo318d();

        public abstract boolean mo319e();

        public abstract C0367a[] mo320g();
    }

    public static Notification m2561a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }
}
