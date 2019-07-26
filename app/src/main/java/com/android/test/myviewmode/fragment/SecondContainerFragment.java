package com.android.test.myviewmode.fragment;

import android.view.View;

import com.android.test.myviewmode.R;
import com.android.test.myviewmode.base.BaseFragment;
import com.android.test.myviewmode.navigation.JNavigationUtil;

public class SecondContainerFragment extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_second_container_layout;
    }

    @Override
    public void initView(View view) {
//        JNavigationUtil.inject(SecondContainerFragment.this,R.id.second_container_fragment,R.navigation.nav_second);
    }

    @Override
    public void initData() {

    }
}
