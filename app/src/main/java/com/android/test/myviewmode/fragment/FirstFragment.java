package com.android.test.myviewmode.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.android.test.myviewmode.R;
import com.android.test.myviewmode.base.BaseFragment;

public class FirstFragment extends BaseFragment {
    private static final String TAG = FirstFragment.class.getSimpleName();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first_layout;
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
