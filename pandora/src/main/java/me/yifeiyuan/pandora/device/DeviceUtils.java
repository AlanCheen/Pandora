package me.yifeiyuan.pandora.device;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class DeviceUtils {

    private DeviceUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * 默认单核
     */
    public static final int DEFAULT_CPU_COUNT = 1;

    public static String getMacAddress(@NonNull Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifi.getConnectionInfo().getMacAddress();
    }

    /**
     * 获取 CPU 数量
     *
     * @return CPU的个数 默认为1
     */
    public static int getCpuCount() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
            //不支持
            return DEFAULT_CPU_COUNT;
        }
        int count;
        try {
            count = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (SecurityException | NullPointerException e) {
            count = DEFAULT_CPU_COUNT;
        }
        return count;
    }

    private static final FileFilter CPU_FILTER = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            String path = pathname.getName();
            if (path.startsWith("cpu")) {
                for (int i = 3; i < path.length(); i++) {
                    if (path.charAt(i) < '0' || path.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
}
