package me.yifeiyuan.pandora.ui;

import android.content.Context;

import me.yifeiyuan.pandora.app.ApplicationUtils;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
public final class DeviceUtils {

    private DeviceUtils() {

    }

    /**
     * @return 屏幕宽度
     */
    public static int getScreenWidth() {
        Context context = ApplicationUtils.getApplication();
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * @return 屏幕高度
     */
    public static int getScreenHeight() {
        Context context = ApplicationUtils.getApplication();
        return context.getResources().getDisplayMetrics().heightPixels;
    }

}
