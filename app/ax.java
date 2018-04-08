package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ba.C0321a;
import android.support.v4.app.bl.C0367a;
import android.widget.RemoteViews;
import java.util.ArrayList;

class ax {

    public static class C0344a implements at, au {
        private Builder f1681a;
        private Bundle f1682b;
        private RemoteViews f1683c;
        private RemoteViews f1684d;

        public C0344a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f1681a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f1682b = new Bundle();
            if (bundle != null) {
                this.f1682b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f1682b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.f1683c = remoteViews2;
            this.f1684d = remoteViews3;
        }

        public void mo327a(C0321a c0321a) {
            ax.m2552a(this.f1681a, c0321a);
        }

        public Builder mo326a() {
            return this.f1681a;
        }

        public Notification mo328b() {
            this.f1681a.setExtras(this.f1682b);
            Notification build = this.f1681a.build();
            if (this.f1683c != null) {
                build.contentView = this.f1683c;
            }
            if (this.f1684d != null) {
                build.bigContentView = this.f1684d;
            }
            return build;
        }
    }

    public static void m2552a(Builder builder, C0321a c0321a) {
        Bundle bundle;
        Action.Builder builder2 = new Action.Builder(c0321a.mo315a(), c0321a.mo316b(), c0321a.mo317c());
        if (c0321a.mo320g() != null) {
            for (RemoteInput addRemoteInput : bk.m2624a(c0321a.mo320g())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c0321a.mo318d() != null) {
            bundle = new Bundle(c0321a.mo318d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0321a.mo319e());
        builder2.addExtras(c0321a.mo318d());
        builder.addAction(builder2.build());
    }

    private static Action m2550a(C0321a c0321a) {
        Action.Builder addExtras = new Action.Builder(c0321a.mo315a(), c0321a.mo316b(), c0321a.mo317c()).addExtras(c0321a.mo318d());
        C0367a[] g = c0321a.mo320g();
        if (g != null) {
            for (RemoteInput addRemoteInput : bk.m2624a(g)) {
                addExtras.addRemoteInput(addRemoteInput);
            }
        }
        return addExtras.build();
    }

    public static ArrayList<Parcelable> m2551a(C0321a[] c0321aArr) {
        if (c0321aArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(c0321aArr.length);
        for (C0321a a : c0321aArr) {
            arrayList.add(m2550a(a));
        }
        return arrayList;
    }
}
