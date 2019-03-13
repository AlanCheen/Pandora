package me.yifeiyuan.pandora.full.io;

import android.support.annotation.Nullable;

import java.io.Closeable;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class IoUtils {

    private IoUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * 关闭流
     *
     * @param closeable
     */
    public static void closeSilently(@Nullable Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            //do nothing
            e.printStackTrace();
        }
    }
}
