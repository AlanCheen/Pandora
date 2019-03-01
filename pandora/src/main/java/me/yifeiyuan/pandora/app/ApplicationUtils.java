package me.yifeiyuan.pandora.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import me.yifeiyuan.pandora.Predictions;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
@SuppressLint("PrivateApi")
public final class ApplicationUtils {

    private ApplicationUtils() {
    }

    private static Application sApplication;

    static {
        try {
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Method m_currentActivityThread = activityThread.getDeclaredMethod("currentActivityThread");
            Field f_mInitialApplication = activityThread.getDeclaredField("mInitialApplication");
            f_mInitialApplication.setAccessible(true);
            Object current = m_currentActivityThread.invoke(null);
            Object app = f_mInitialApplication.get(current);
            sApplication = (Application) app;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static void setupApplication(@NonNull Application application) {
        Predictions.notNull(application);
        sApplication = application;
    }

    public static boolean isAppDebugable() {
        if (sApplication == null) {
            return false;
        }

        try {
            ApplicationInfo info = sApplication.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
