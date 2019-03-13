package me.yifeiyuan.pandora.full.collection;

import android.support.annotation.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * Created by 程序亦非猿 on 2019/3/6.
 */
public final class CollectionUtils {

    private CollectionUtils() {
        throw new AssertionError("No instances.");
    }

    public static boolean isEmpty(@Nullable final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <K, V, M extends Map<K, V>> boolean isEmpty(@Nullable final M map) {
        return map == null || map.isEmpty();
    }
}
