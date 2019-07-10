package me.yifeiyuan.pandora.full.io;

import java.io.File;
/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class FileUtils {

    private FileUtils() {
        throw new AssertionError("No instances.");
    }

    public static boolean deleteFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    public static boolean deleteFile(File file) {
        return file.delete();
    }
}
