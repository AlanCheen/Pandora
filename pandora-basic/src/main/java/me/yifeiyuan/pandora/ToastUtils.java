package me.yifeiyuan.pandora;

import android.widget.Toast;

/**
 * Created by 程序亦非猿 on 2019/3/6.
 */
public final class ToastUtils {

    private ToastUtils() {
        throw new AssertionError("No instances.");
    }

    private static final Toast sToast;

    static {
        sToast = Toast.makeText(ApplicationUtils.getApplication(), "", Toast.LENGTH_LONG);
    }

    /**
     * 弹 Toast , 复用一个单例，解决多次弹 Toast 的问题。
     * @param msg
     */
    public static void show(final CharSequence msg) {
        MainThread.post(new Runnable() {
            @Override
            public void run() {
                try {
                    sToast.setText(msg);
                    sToast.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 在 App 处于 Debug 的环境下弹 Toast。
     * @param msg
     */
    public static void debug(final CharSequence msg) {
        if (AppUtils.isAppDebugable()) {
            show(msg);
        }
    }
}
