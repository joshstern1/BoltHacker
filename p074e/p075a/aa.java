package com.p074e.p075a;

import android.content.Context;
import android.net.Uri;
import com.p074e.p075a.C1402r.C1439a;
import com.p074e.p075a.C1402r.C1440b;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class aa implements C1402r {
    private final OkHttpClient f5302a;

    private static OkHttpClient m8976a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public aa(Context context) {
        this(as.m9084b(context));
    }

    public aa(File file) {
        this(file, as.m9069a(file));
    }

    public aa(File file, long j) {
        this(aa.m8976a());
        try {
            this.f5302a.setCache(new Cache(file, j));
        } catch (IOException e) {
        }
    }

    public aa(OkHttpClient okHttpClient) {
        this.f5302a = okHttpClient;
    }

    public C1439a mo1323a(Uri uri, int i) throws IOException {
        CacheControl cacheControl = null;
        if (i != 0) {
            if (C1448y.m9192c(i)) {
                cacheControl = CacheControl.FORCE_CACHE;
            } else {
                Builder builder = new Builder();
                if (!C1448y.m9190a(i)) {
                    builder.noCache();
                }
                if (!C1448y.m9191b(i)) {
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.f5302a.newCall(url.build()).execute();
        int code = execute.code();
        if (code >= 300) {
            execute.body().close();
            throw new C1440b(code + " " + execute.message(), i, code);
        }
        boolean z = execute.cacheResponse() != null;
        ResponseBody body = execute.body();
        return new C1439a(body.byteStream(), z, body.contentLength());
    }
}
