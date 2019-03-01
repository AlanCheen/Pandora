package me.yifeiyuan.pandora;

/**
 * Created by 程序亦非猿 on 2019/3/1.
 */
public final class Predictions {

    private Predictions() {
        throw new AssertionError("No instances.");
    }

    public static void notNull(Object o) {
        notNull(o, "Can't be null");
    }

    public static void notNull(Object o, String msg) {
        if (o == null) {
            throw new NullPointerException(msg);
        }
    }
}
