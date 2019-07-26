package com.android.test.myviewmode.fragment;

import android.util.Log;
import android.view.View;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;

import com.android.test.myviewmode.R;
import com.android.test.myviewmode.base.BaseFragment;
import com.android.test.myviewmode.bean.DataBean;
import com.android.test.myviewmode.navigation.JNavigationUtil;
import com.android.test.myviewmode.viewmodel.MainViewModel;

public class MainContainerFragment extends BaseFragment {
    private static final String TAG = MainContainerFragment.class.getSimpleName();

    private NavController mNavController;
    private MainViewModel mMainViewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_layout;
    }

    @Override
    public void initView(View view) {
        mNavController = JNavigationUtil.injectKeep(MainContainerFragment.this, R.id.main_fragment_container, R.navigation.nav_main_container);
        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    }

    @Override
    public void initData() {

        mMainViewModel.getmMainLiveData().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                if (o instanceof DataBean) {
                    switch (((ObservableInt) ((DataBean) o).getData()).get()) {
                        case MainViewModel.MAIN_SIDE_TYPE_ONE:
                            Log.d(TAG, "MAIN_SIDE_TYPE_ONE to firstContainerFragment");
                            mNavController.navigate(R.id.firstContainerFragment);
                            break;
                        case MainViewModel.MAIN_SIDE_TYPE_TWO:
                            Log.d(TAG, "MAIN_SIDE_TYPE_TWO to secondContainerFragment");
                            mNavController.navigate(R.id.secondContainerFragment);
                            break;
                        case MainViewModel.MAIN_SIDE_TYPE_THREE:
                            Log.d(TAG, "MAIN_SIDE_TYPE_THREE to thirdContainerFragment");
                            mNavController.navigate(R.id.thirdContainerFragment);
                            break;
                    }
                }
            }
        });
    }
}
