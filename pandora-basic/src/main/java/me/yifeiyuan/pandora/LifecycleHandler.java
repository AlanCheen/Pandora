package me.yifeiyuan.pandora;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Handler;
import android.os.Looper;

import static me.yifeiyuan.pandora.Predictions.notNull;

/**
 * Created by 程序亦非猿 on 2019/3/11.
 */
public class LifecycleHandler extends Handler implements LifecycleObserver {

    private LifecycleOwner lifecycleOwner;

    public LifecycleHandler(final LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
        addObserver();
    }

    public LifecycleHandler(final Callback callback, final LifecycleOwner lifecycleOwner) {
        super(callback);
        this.lifecycleOwner = lifecycleOwner;
        addObserver();
    }

    public LifecycleHandler(final Looper looper, final LifecycleOwner lifecycleOwner) {
        super(looper);
        this.lifecycleOwner = lifecycleOwner;
        addObserver();
    }

    public LifecycleHandler(final Looper looper, final Callback callback, final LifecycleOwner lifecycleOwner) {
        super(looper, callback);
        this.lifecycleOwner = lifecycleOwner;
        addObserver();
    }

    private void addObserver() {
        notNull(lifecycleOwner);
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        removeCallbacksAndMessages(null);
        lifecycleOwner.getLifecycle().removeObserver(this);
    }
}
