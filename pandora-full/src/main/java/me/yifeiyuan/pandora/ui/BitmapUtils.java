package me.yifeiyuan.pandora.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import me.yifeiyuan.pandora.io.IoUtils;

/**
 * Created by 程序亦非猿 on 2019/3/5.
 */
public final class BitmapUtils {

    private BitmapUtils() {
        throw new AssertionError("No instances.");
    }

    /**
     * 将Bitmap保存到file中
     *
     * @param file    目标文件
     * @param bitmap  目标Bitmap
     * @param format  保存的格式,具体可看{@link android.graphics.Bitmap.CompressFormat}
     * @param quality 0-100
     *
     * @return 保存是否成功
     */
    public static boolean saveBitmapToFile(@NonNull File file, @NonNull Bitmap bitmap, @NonNull Bitmap.CompressFormat format, int quality) {

        OutputStream os = null;
        boolean isSuccess = false;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(format, quality, os);
            os.flush();
            isSuccess = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.closeSilently(os);
        }
        return isSuccess;
    }

    /**
     * 获取bitmap的大小
     *
     * @param bitmap
     *
     * @return bitmap的大小
     */
    public static int getBitmapSize(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {    //API 19
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {//API 12
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();                //earlier version
    }

    /**
     * 计算inSampleSize,该方法源自Android官网
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     *
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    /**
     * 给bitmap着色
     *
     * @param sourceBitmap dest
     * @param color        颜色资源id
     *
     * @return
     */
    public static Bitmap changeBitmapColor(@NonNull Bitmap sourceBitmap, @IntegerRes int color) {

        Bitmap resultBitmap = Bitmap.createBitmap(sourceBitmap, 0, 0,
                sourceBitmap.getWidth() - 1, sourceBitmap.getHeight() - 1);
        Paint p = new Paint();
        ColorFilter filter = new LightingColorFilter(color, 1);
        p.setColorFilter(filter);

        Canvas canvas = new Canvas(resultBitmap);
        canvas.drawBitmap(resultBitmap, 0, 0, p);
        return resultBitmap;
    }
}
