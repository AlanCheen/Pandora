package me.yifeiyuan.pandora.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
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
     * 获取 App 的版本名
     *
     * @return app的版本名 默认为""
     */
    public static String getVersionName() {
        Context context = ApplicationUtils.getApplication();
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
     * 获取 App 的版本号
     *
     * @return 获取版本号 默认为0
     */
    public static int getVersionCode() {
        Context context = ApplicationUtils.getApplication();
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @return App 是否可以 debug
     */
    public static boolean isAppDebugable() {
        try {
            ApplicationInfo info = ApplicationUtils.getApplication().getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
