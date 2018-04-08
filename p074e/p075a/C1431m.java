package com.p074e.p075a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ak.C1411a;
import java.io.IOException;
import java.io.InputStream;

class C1431m extends ak {
    private static final UriMatcher f5472a = new UriMatcher(-1);
    private final Context f5473b;

    @TargetApi(14)
    private static class C1430a {
        static InputStream m9133a(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f5472a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f5472a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f5472a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f5472a.addURI("com.android.contacts", "contacts/#", 3);
        f5472a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C1431m(Context context) {
        this.f5473b = context;
    }

    public boolean mo1326a(ah ahVar) {
        Uri uri = ahVar.f5372d;
        return "content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f5472a.match(ahVar.f5372d) != -1;
    }

    public C1411a mo1325a(ah ahVar, int i) throws IOException {
        InputStream b = m9134b(ahVar);
        return b != null ? new C1411a(b, C1406d.DISK) : null;
    }

    private InputStream m9134b(ah ahVar) throws IOException {
        ContentResolver contentResolver = this.f5473b.getContentResolver();
        Uri uri = ahVar.f5372d;
        switch (f5472a.match(uri)) {
            case 1:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return C1430a.m9133a(contentResolver, uri);
    }
}
