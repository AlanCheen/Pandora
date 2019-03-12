package me.yifeiyuan.pandora.storage;

import android.os.Environment;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class SdCardUtils {

    private SdCardUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * @return 外部SD卡是否可用
     */
    public static boolean isSdCardMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
