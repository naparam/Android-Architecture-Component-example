package com.appiness.archcomponents.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Demonstrates usage of basic LifecycleObserver.
 */
public class MyObserver implements LifecycleObserver {
    private static final String LOG_TAG = MyObserver.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeNext() {
        Log.e(LOG_TAG, "resumed observing lifecycle Next.");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.e(LOG_TAG, "resumed observing lifecycle.");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.e(LOG_TAG, "paused observing lifecycle.");
    }
}
