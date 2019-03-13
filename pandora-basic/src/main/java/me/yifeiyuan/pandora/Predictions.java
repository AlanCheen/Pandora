package me.yifeiyuan.pandora;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by 程序亦非猿 on 2019/3/1.
 */
public final class Predictions {

    private Predictions() {
        throw new AssertionError("No instances.");
    }

    public static void notNull(Object o) {
        notNull(o, "Can't be null!");
    }

    public static void notNull(Object o, @NonNull String msg) {
        if (o == null) {
            throw new NullPointerException(msg);
        }
    }

    public static void notEmpty(CharSequence charSequence) {
        notEmpty(charSequence, "Can't be empty!");
    }

    public static void notEmpty(CharSequence charSequence, @NonNull String msg) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Throws an {@link IllegalArgumentException} if called on a thread other than the main thread.
     */
    public static void onMainThread() {
        if (!MainThread.isMainThread()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /**
     * Throws an {@link IllegalArgumentException} if called on the main thread.
     */
    public static void onBackgroundThread() {
        if (MainThread.isMainThread()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }
}
