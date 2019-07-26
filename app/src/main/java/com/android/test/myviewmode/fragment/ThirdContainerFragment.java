package com.android.test.myviewmode.fragment;

import android.view.View;

import androidx.navigation.NavController;

import com.android.test.myviewmode.R;
import com.android.test.myviewmode.base.BaseFragment;
import com.android.test.myviewmode.navigation.JNavigationUtil;

public class ThirdContainerFragment extends BaseFragment {
    private NavController mController;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_third_container_layout;
    }

    @Override
    public void initView(View view) {
//        JNavigationUtil.inject(ThirdContainerFragment.this, R.id.third_fragment_container, R.navigation.nav_third);
    }

    @Override
    public void initData() {

    }
}
