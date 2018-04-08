package com.p074e.p075a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.p074e.p075a.ab.C1406d;
import com.p074e.p075a.ak.C1411a;
import java.io.IOException;

class C1446w extends C1432n {
    private static final String[] f5524b = new String[]{"orientation"};

    enum C1445a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        
        final int f5521d;
        final int f5522e;
        final int f5523f;

        private C1445a(int i, int i2, int i3) {
            this.f5521d = i;
            this.f5522e = i2;
            this.f5523f = i3;
        }
    }

    C1446w(Context context) {
        super(context);
    }

    public boolean mo1326a(ah ahVar) {
        Uri uri = ahVar.f5372d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public C1411a mo1325a(ah ahVar, int i) throws IOException {
        ContentResolver contentResolver = this.a.getContentResolver();
        int a = C1446w.m9184a(contentResolver, ahVar.f5372d);
        String type = contentResolver.getType(ahVar.f5372d);
        Object obj = (type == null || !type.startsWith("video/")) ? null : 1;
        if (ahVar.m9014d()) {
            C1445a a2 = C1446w.m9185a(ahVar.f5376h, ahVar.f5377i);
            if (obj == null && a2 == C1445a.FULL) {
                return new C1411a(null, m9139b(ahVar), C1406d.DISK, a);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(ahVar.f5372d);
            Options c = ak.m9034c(ahVar);
            c.inJustDecodeBounds = true;
            ak.m9031a(ahVar.f5376h, ahVar.f5377i, a2.f5522e, a2.f5523f, c, ahVar);
            if (obj != null) {
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, a2 == C1445a.FULL ? 1 : a2.f5521d, c);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, a2.f5521d, c);
            }
            if (thumbnail != null) {
                return new C1411a(thumbnail, null, C1406d.DISK, a);
            }
        }
        return new C1411a(null, m9139b(ahVar), C1406d.DISK, a);
    }

    static C1445a m9185a(int i, int i2) {
        if (i <= C1445a.MICRO.f5522e && i2 <= C1445a.MICRO.f5523f) {
            return C1445a.MICRO;
        }
        if (i > C1445a.MINI.f5522e || i2 > C1445a.MINI.f5523f) {
            return C1445a.FULL;
        }
        return C1445a.MINI;
    }

    static int m9184a(ContentResolver contentResolver, Uri uri) {
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = contentResolver.query(uri, f5524b, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (RuntimeException e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
