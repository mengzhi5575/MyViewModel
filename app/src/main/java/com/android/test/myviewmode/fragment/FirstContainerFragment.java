package com.android.test.myviewmode.fragment;

import android.view.View;

import com.android.test.myviewmode.R;
import com.android.test.myviewmode.base.BaseFragment;

public class FirstContainerFragment extends BaseFragment {
    private static final String TAG = FirstContainerFragment.class.getSimpleName();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first_container_layout;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void initData() {
    }
}
