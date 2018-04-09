package android.support.v7.p027a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.au;
import android.support.v4.app.ba.C0321a;
import android.support.v7.p028b.C0842a.C0834d;
import android.support.v7.p028b.C0842a.C0836f;
import android.support.v7.p028b.C0842a.C0837g;
import android.support.v7.p028b.C0842a.C0838h;
import android.support.v7.p028b.C0842a.C0839i;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

class am {
    public static <T extends C0321a> void m5034a(au auVar, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        auVar.mo326a().setContent(am.m5032a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, (List) list, iArr, z2, pendingIntent));
        if (z2) {
            auVar.mo326a().setOngoing(true);
        }
    }

    private static <T extends C0321a> RemoteViews m5032a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        int i2;
        RemoteViews a = am.m5030a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, C0838h.notification_template_media, true);
        int size = list.size();
        if (iArr == null) {
            i2 = 0;
        } else {
            i2 = Math.min(iArr.length, 3);
        }
        a.removeAllViews(C0836f.media_actions);
        if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i3), Integer.valueOf(size - 1)}));
                }
                a.addView(C0836f.media_actions, am.m5029a(context, (C0321a) list.get(iArr[i3])));
            }
        }
        if (z2) {
            a.setViewVisibility(C0836f.end_padder, 8);
            a.setViewVisibility(C0836f.cancel_action, 0);
            a.setOnClickPendingIntent(C0836f.cancel_action, pendingIntent);
            a.setInt(C0836f.cancel_action, "setAlpha", context.getResources().getInteger(C0837g.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(C0836f.end_padder, 0);
            a.setViewVisibility(C0836f.cancel_action, 8);
        }
        return a;
    }

    public static <T extends C0321a> void m5033a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        notification.bigContentView = am.m5031a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, z2, pendingIntent);
        if (z2) {
            notification.flags |= 2;
        }
    }

    private static <T extends C0321a> RemoteViews m5031a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = am.m5030a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, am.m5028a(min), false);
        a.removeAllViews(C0836f.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                a.addView(C0836f.media_actions, am.m5029a(context, (C0321a) list.get(i2)));
            }
        }
        if (z2) {
            a.setViewVisibility(C0836f.cancel_action, 0);
            a.setInt(C0836f.cancel_action, "setAlpha", context.getResources().getInteger(C0837g.cancel_button_image_alpha));
            a.setOnClickPendingIntent(C0836f.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(C0836f.cancel_action, 8);
        }
        return a;
    }

    private static RemoteViews m5029a(Context context, C0321a c0321a) {
        Object obj = c0321a.mo317c() == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0838h.notification_media_action);
        remoteViews.setImageViewResource(C0836f.action0, c0321a.mo315a());
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(C0836f.action0, c0321a.mo317c());
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0836f.action0, c0321a.mo316b());
        }
        return remoteViews;
    }

    private static int m5028a(int i) {
        if (i <= 3) {
            return C0838h.notification_template_big_media_narrow;
        }
        return C0838h.notification_template_big_media;
    }

    private static RemoteViews m5030a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, boolean z2) {
        Object obj;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        Object obj2 = null;
        Object obj3 = null;
        if (bitmap == null || VERSION.SDK_INT < 16) {
            remoteViews.setViewVisibility(C0836f.icon, 8);
        } else {
            remoteViews.setViewVisibility(C0836f.icon, 0);
            remoteViews.setImageViewBitmap(C0836f.icon, bitmap);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(C0836f.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(C0836f.text, charSequence2);
            obj2 = 1;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(C0836f.info, charSequence3);
            remoteViews.setViewVisibility(C0836f.info, 0);
            obj = 1;
        } else if (i > 0) {
            if (i > context.getResources().getInteger(C0837g.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(C0836f.info, context.getResources().getString(C0839i.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(C0836f.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(C0836f.info, 0);
            int i3 = 1;
        } else {
            remoteViews.setViewVisibility(C0836f.info, 8);
            obj = obj2;
        }
        if (charSequence4 != null && VERSION.SDK_INT >= 16) {
            remoteViews.setTextViewText(C0836f.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0836f.text2, charSequence2);
                remoteViews.setViewVisibility(C0836f.text2, 0);
                obj3 = 1;
            } else {
                remoteViews.setViewVisibility(C0836f.text2, 8);
            }
        }
        if (obj3 != null && VERSION.SDK_INT >= 16) {
            if (z2) {
                remoteViews.setTextViewTextSize(C0836f.text, 0, (float) context.getResources().getDimensionPixelSize(C0834d.notification_subtext_size));
            }
            remoteViews.setViewPadding(C0836f.line1, 0, 0, 0, 0);
        }
        if (j != 0) {
            if (z) {
                remoteViews.setViewVisibility(C0836f.chronometer, 0);
                remoteViews.setLong(C0836f.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                remoteViews.setBoolean(C0836f.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(C0836f.time, 0);
                remoteViews.setLong(C0836f.time, "setTime", j);
            }
        }
        remoteViews.setViewVisibility(C0836f.line3, obj != null ? 0 : 8);
        return remoteViews;
    }
}
