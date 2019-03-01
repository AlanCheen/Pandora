package me.yifeiyuan.pandora;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
public final class ClipboardUtils {

    private ClipboardUtils() {
    }

    public static boolean copy(@NonNull Context context, @NonNull CharSequence label, @NonNull CharSequence text) {
        if (context == null || TextUtils.isEmpty(text)) {
            return false;
        }
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, text);
        if (clipboard != null) {
            clipboard.setPrimaryClip(clip);
            return true;
        }
        return false;
    }

}
