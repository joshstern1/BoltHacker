package com.p041a.p042a.p051c;

import android.os.Looper;
import io.p038b.p039a.p040a.C3059d;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class C1171r {
    private final ExecutorService f4379a;

    public C1171r(ExecutorService executorService) {
        this.f4379a = executorService;
    }

    <T> T m8017a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f4379a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f4379a.submit(callable).get();
        } catch (RejectedExecutionException e) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            C3059d.m17342h().mo2439e("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> m8018a(Runnable runnable) {
        try {
            return this.f4379a.submit(new C1172s(this, runnable));
        } catch (RejectedExecutionException e) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> m8019b(Callable<T> callable) {
        try {
            return this.f4379a.submit(new C1173t(this, callable));
        } catch (RejectedExecutionException e) {
            C3059d.m17342h().mo2431a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
