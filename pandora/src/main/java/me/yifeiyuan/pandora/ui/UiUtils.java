package me.yifeiyuan.pandora.ui;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
public final class UiUtils {

    private UiUtils() {

    }

    public static int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, Resources.getSystem().getDisplayMetrics());
    }

    public static int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, Resources.getSystem().getDisplayMetrics());
    }

    public static int px2dp(float px) {
        float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int)(px / scale);
    }

    public static int px2sp(float px) {
        float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int)(px / fontScale);
    }

}
