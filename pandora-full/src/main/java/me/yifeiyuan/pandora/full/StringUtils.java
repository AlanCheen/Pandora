package me.yifeiyuan.pandora.full;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
public final class StringUtils {

    private StringUtils() {
        throw new AssertionError("No instances.");
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return defaultValue;
    }
}
