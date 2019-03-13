package me.yifeiyuan.pandora.full.device;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class NetworkUtils {

    private NetworkUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * 网络是否连接
     *
     * 注意需要权限: {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @param context 上下文
     *
     * @return true 如果网络连接着
     */
    public static boolean isNetworkConnected(@NonNull Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return null != info && info.isAvailable();
    }

    /**
     * wifi是否连接可用
     *
     * 注意需要权限: {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
     *
     * @param context
     *
     * @return true 如果wifi可用
     */
    public static boolean isWifiConnected(@NonNull Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return info != null && info.isConnected();
    }

    /**
     * 得到当前的手机网络类型
     *
     * @param context
     *
     * @return 没网返回"" , 有网返回 2g / 3g /4g/wifi
     */
    public static String getCurrNetType(@NonNull Context context) {
        String type = "";
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            type = "";
        } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            type = "wifi";
        } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            int subType = info.getSubtype();
            if (subType == TelephonyManager.NETWORK_TYPE_CDMA || subType == TelephonyManager.NETWORK_TYPE_GPRS
                    || subType == TelephonyManager.NETWORK_TYPE_EDGE) {
                type = "2g";
            } else if (subType == TelephonyManager.NETWORK_TYPE_UMTS || subType == TelephonyManager.NETWORK_TYPE_HSDPA
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_A || subType == TelephonyManager.NETWORK_TYPE_EVDO_0
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_B) {
                type = "3g";
            } else if (subType == TelephonyManager.NETWORK_TYPE_LTE) {// LTE是3g到4g的过渡，是3.9G的全球标准
                type = "4g";
            }
        }
        return type;
    }
}
