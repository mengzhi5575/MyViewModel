package com.android.test.myviewmode.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.android.test.myviewmode.R;
import com.android.test.myviewmode.base.BaseFragment;

public class ThirdFragment extends BaseFragment {
    private static final String TAG = ThirdFragment.class.getSimpleName();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_third_layout;
    }

    @Override
    public void initView(View view) {
        Log.d(TAG, "initView()");
    }

    @Override
    public void initData() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView()");
        super.onDestroyView();
    }
}
