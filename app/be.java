package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ba.C0321a;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class be {
    private static final Object f1697a = new Object();
    private static Field f1698b;
    private static boolean f1699c;
    private static final Object f1700d = new Object();

    public static class C0349a implements at, au {
        private Builder f1692a;
        private final Bundle f1693b;
        private List<Bundle> f1694c = new ArrayList();
        private RemoteViews f1695d;
        private RemoteViews f1696e;

        public C0349a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f1692a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f1693b = new Bundle();
            if (bundle != null) {
                this.f1693b.putAll(bundle);
            }
            if (z3) {
                this.f1693b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f1693b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f1693b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f1693b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f1693b.putString("android.support.sortKey", str2);
            }
            this.f1695d = remoteViews2;
            this.f1696e = remoteViews3;
        }

        public void mo327a(C0321a c0321a) {
            this.f1694c.add(be.m2569a(this.f1692a, c0321a));
        }

        public Builder mo326a() {
            return this.f1692a;
        }

        public Notification mo328b() {
            Notification build = this.f1692a.build();
            Bundle a = be.m2570a(build);
            Bundle bundle = new Bundle(this.f1693b);
            for (String str : this.f1693b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = be.m2572a(this.f1694c);
            if (a2 != null) {
                be.m2570a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            if (this.f1695d != null) {
                build.contentView = this.f1695d;
            }
            if (this.f1696e != null) {
                build.bigContentView = this.f1696e;
            }
            return build;
        }
    }

    public static void m2575a(au auVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(auVar.mo326a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m2574a(au auVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(auVar.mo326a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m2576a(au auVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(auVar.mo326a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> m2572a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m2570a(Notification notification) {
        synchronized (f1697a) {
            if (f1699c) {
                return null;
            }
            try {
                if (f1698b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f1698b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1699c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f1698b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1698b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f1699c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1699c = true;
                return null;
            }
        }
    }

    public static Bundle m2569a(Builder builder, C0321a c0321a) {
        builder.addAction(c0321a.mo315a(), c0321a.mo316b(), c0321a.mo317c());
        Bundle bundle = new Bundle(c0321a.mo318d());
        if (c0321a.mo320g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", bm.m2626a(c0321a.mo320g()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0321a.mo319e());
        return bundle;
    }

    public static ArrayList<Parcelable> m2573a(C0321a[] c0321aArr) {
        if (c0321aArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(c0321aArr.length);
        for (C0321a a : c0321aArr) {
            arrayList.add(m2571a(a));
        }
        return arrayList;
    }

    private static Bundle m2571a(C0321a c0321a) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", c0321a.mo315a());
        bundle.putCharSequence("title", c0321a.mo316b());
        bundle.putParcelable("actionIntent", c0321a.mo317c());
        bundle.putBundle("extras", c0321a.mo318d());
        bundle.putParcelableArray("remoteInputs", bm.m2626a(c0321a.mo320g()));
        return bundle;
    }
}
