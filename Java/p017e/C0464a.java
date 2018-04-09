package android.support.v4.p017e;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public final class C0464a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m3054a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0465b.m3055a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
