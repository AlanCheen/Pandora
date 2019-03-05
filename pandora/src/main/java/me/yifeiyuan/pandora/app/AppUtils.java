package me.yifeiyuan.pandora.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class AppUtils {

    private AppUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * 获取app的版本名
     *
     * @param context 上下文
     *
     * @return app的版本名 默认为""
     */
    public static String getVersionName(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取app的版本号
     *
     * @param context 上下文
     *
     * @return 获取版本号 默认为0
     */
    public static int getVersionCode(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
