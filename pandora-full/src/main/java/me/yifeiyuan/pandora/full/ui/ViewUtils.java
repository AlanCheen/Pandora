package me.yifeiyuan.pandora.full.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

import me.yifeiyuan.pandora.UiUtils;
/**
 * Created by 程序亦非猿 on 2019-08-29.
 */
public final class ViewUtils {

    private ViewUtils() {
        //no instance
        throw new AssertionError("No instances.");
    }

    /**
     * 扩展一个 View 的点击范围
     *
     * 通常扩展点击范围可以用 padding 来处理，如果 padding 不适合则可以使用该方法。
     *
     * @param target，你想要扩展点击区域的   View
     * @param areaInDp，要扩展的大小，单位为 dp
     *
     * @see #resetClickArea(View) also
     */
    public static void expandClickArea(final View target, final int areaInDp) {

        if (target.getParent() instanceof View) {

            final View parent = (View) target.getParent();

            parent.post(new Runnable() {
                @Override
                public void run() {
                    Rect bounds = new Rect();
                    target.getHitRect(bounds);

                    int v = (int) UiUtils.dp2px(areaInDp);

                    bounds.left -= v;
                    bounds.top -= v;
                    bounds.right += v;
                    bounds.bottom += v;

                    TouchDelegate delegate = new TouchDelegate(bounds, target);
                    parent.setTouchDelegate(delegate);
                }
            });
        }
    }

    /**
     * 重置点击区域
     * @param target
     */
    public static void resetClickArea(final View target) {
        if (target.getParent() instanceof View) {
            final View parent = (View) target.getParent();
            parent.setTouchDelegate(new TouchDelegate(new Rect(), target));
        }
    }

}
