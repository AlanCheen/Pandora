package me.yifeiyuan.pandora;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

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

    /**
     * 获取toolbar的高度
     *
     * @param context
     *
     * @return 默认为0
     */
    public static int getToolbarHeight(@NonNull Context context) {
        TypedValue typedValue = new TypedValue();

        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        return 0;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private int getSoftButtonsBarHeight(@NonNull Context context) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        DisplayMetrics metrics = new DisplayMetrics();

        wm.getDefaultDisplay().getMetrics(metrics);
        int usableHeight = metrics.heightPixels;

        wm.getDefaultDisplay().getRealMetrics(metrics);
        int realHeight = metrics.heightPixels;

        if (realHeight > usableHeight) {
            return realHeight - usableHeight;
        } else {
            return 0;
        }
    }

    /**
     * 获取当前屏幕截图 包含状态栏
     *
     * @param activity
     *
     * @return
     */
    public static Bitmap snapShotWithStatusBar(@NonNull Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;
    }

    /**
     * 获取当前屏幕截图 但不包含状态栏
     *
     * @param activity
     *
     * @return
     */
    public static Bitmap snapShotWithoutStatusBar(@NonNull Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        view.getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return bp;
    }
}
