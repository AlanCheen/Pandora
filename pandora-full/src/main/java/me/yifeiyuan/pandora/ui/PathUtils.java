package me.yifeiyuan.pandora.ui;

import android.graphics.DashPathEffect;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.NonNull;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class PathUtils {

    private PathUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * 测量path的长度
     *
     * @param path 需要测量的path
     *
     * @return path的长度
     */
    public static float measurePath(@NonNull Path path) {
        PathMeasure measure = new PathMeasure(path, false);
        return measure.getLength();
    }

    /**
     * 生成一个可用作Path动画的DashPathEffect
     * 效果 从头画到尾
     *
     * @param pathLength path的长度 可以通过{@link #measurePath(Path)}来测量path的长度
     * @param phase      阶段
     *
     * @return DashPathEffect
     */
    public DashPathEffect createAnimPathEffect(float pathLength, int phase) {
        return new DashPathEffect(new float[]{pathLength * (1 - phase), pathLength}, 0);
    }

}
