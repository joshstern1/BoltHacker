package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import com.onesignal.C2720a.C2717a;

final class an implements C2717a {
    an() {
    }

    public void mo2311a(Activity activity) {
        if (!activity.getClass().equals(PermissionsActivity.class)) {
            Intent intent = new Intent(activity, PermissionsActivity.class);
            intent.setFlags(131072);
            activity.startActivity(intent);
        }
    }
}
