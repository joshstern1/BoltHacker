package android.support.v4.p017e;

import android.os.AsyncTask;

class C0465b {
    static <Params, Progress, Result> void m3055a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
