package me.yifeiyuan.pandora.thread;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
public final class MainThread {

    private MainThread() {

    }

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    public static void post(@NonNull Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }

    public static void postDelayed(@NonNull Runnable runnable, long delayMillis) {
        HANDLER.postDelayed(runnable, delayMillis);
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

}
