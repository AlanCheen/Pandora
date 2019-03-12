package me.yifeiyuan.pandora.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import me.yifeiyuan.pandora.app.ApplicationUtils;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
public final class UiUtils {

    private UiUtils() {
        throw new AssertionError("No instances.");
    }

    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ApplicationUtils.getApplication().getResources().getDisplayMetrics());
    }

    public static float sp2px(float px) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, px, ApplicationUtils.getApplication().getResources().getDisplayMetrics());
    }

    public static int px2dp(float px) {
        final float density = ApplicationUtils.getApplication().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5f);
    }

    public static int px2sp(float px) {
        final float scale = ApplicationUtils.getApplication().getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 获得屏幕高度
     *
     * @param context
     *
     * @return
     */
    public static int getScreenWidth(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     *
     * @param context
     *
     * @return
     */
    public static int getScreenHeight(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     *
     * @return 状态栏高度  默认为0
     */
    public static int getStatusBarHeight(@NonNull Context context) {
        int result = 0;

        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }
}
