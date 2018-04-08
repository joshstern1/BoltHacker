package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ba.C0321a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

class bf {

    public static class C0350a implements at, au {
        private Builder f1701a;
        private Bundle f1702b;
        private List<Bundle> f1703c = new ArrayList();
        private RemoteViews f1704d;
        private RemoteViews f1705e;

        public C0350a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f1701a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f1702b = new Bundle();
            if (bundle != null) {
                this.f1702b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f1702b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f1702b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f1702b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f1702b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f1702b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f1702b.putString("android.support.sortKey", str2);
            }
            this.f1704d = remoteViews2;
            this.f1705e = remoteViews3;
        }

        public void mo327a(C0321a c0321a) {
            this.f1703c.add(be.m2569a(this.f1701a, c0321a));
        }

        public Builder mo326a() {
            return this.f1701a;
        }

        public Notification mo328b() {
            SparseArray a = be.m2572a(this.f1703c);
            if (a != null) {
                this.f1702b.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f1701a.setExtras(this.f1702b);
            Notification build = this.f1701a.build();
            if (this.f1704d != null) {
                build.contentView = this.f1704d;
            }
            if (this.f1705e != null) {
                build.bigContentView = this.f1705e;
            }
            return build;
        }
    }

    public static Bundle m2580a(Notification notification) {
        return notification.extras;
    }
}
