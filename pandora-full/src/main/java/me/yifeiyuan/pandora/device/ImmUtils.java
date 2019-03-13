package me.yifeiyuan.pandora.device;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import me.yifeiyuan.pandora.Predictions;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class ImmUtils {

    private ImmUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * 隐藏输入法
     *
     * @param act activity
     */
    public static void hide(@NonNull Activity act) {
        Predictions.notNull(act);
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = act.getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 显示输入法
     *
     * @param act activity
     */
    public static void show(@NonNull Activity act) {
        Predictions.notNull(act);
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = act.getCurrentFocus();
        if (view != null) {
            imm.showSoftInputFromInputMethod(view.getWindowToken(), InputMethodManager.SHOW_IMPLICIT);
        }
    }
}
