package com.android.test.myviewmode.base;

import android.app.Application;
import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

public class MyApplication extends Application {
    private static Application mApplication;
    private static Context mContext;
    private static ViewModelStore mModelStore;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mContext = getApplicationContext();
        mModelStore = new ViewModelStore();
    }

    /**
     * Activity中使用
     * @return
     */
    public static ViewModelProvider of() {
        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(mApplication);
        return new ViewModelProvider(mModelStore, factory);
    }

    /**
     * Fragment中使用
     * @param activity
     * @return
     */
    public static ViewModelProvider of(FragmentActivity activity) {
        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(mApplication);
        return new ViewModelProvider(activity.getViewModelStore(), factory);
    }
}
