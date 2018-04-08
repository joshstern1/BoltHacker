package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ba.C0321a;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

class ay {

    public static class C0345a implements at, au {
        private Builder f1685a;
        private Bundle f1686b;
        private RemoteViews f1687c;
        private RemoteViews f1688d;
        private RemoteViews f1689e;

        public C0345a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
            this.f1685a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.f1686b = new Bundle();
            if (bundle != null) {
                this.f1686b.putAll(bundle);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f1685a.addPerson((String) it.next());
            }
            this.f1687c = remoteViews2;
            this.f1688d = remoteViews3;
            this.f1689e = remoteViews4;
        }

        public void mo327a(C0321a c0321a) {
            ax.m2552a(this.f1685a, c0321a);
        }

        public Builder mo326a() {
            return this.f1685a;
        }

        public Notification mo328b() {
            this.f1685a.setExtras(this.f1686b);
            Notification build = this.f1685a.build();
            if (this.f1687c != null) {
                build.contentView = this.f1687c;
            }
            if (this.f1688d != null) {
                build.bigContentView = this.f1688d;
            }
            if (this.f1689e != null) {
                build.headsUpContentView = this.f1689e;
            }
            return build;
        }
    }
}
