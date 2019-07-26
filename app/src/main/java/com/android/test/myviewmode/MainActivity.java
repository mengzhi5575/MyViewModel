package com.android.test.myviewmode;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.android.test.myviewmode.base.BaseActivity;
import com.android.test.myviewmode.viewmodel.MainViewModel;
import com.jidouauto.ui.oushang.sideBar.JSideBar;
import com.jidouauto.ui.oushang.sideBar.Menu;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private MainViewModel mMainViewModel;
    NavController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mLayoutId = R.layout.activity_main;
        super.onCreate(savedInstanceState);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        Log.d(TAG, "mMainViewModel = " + mMainViewModel);
        mBinding.setVm(mMainViewModel);
        NavHostFragment hostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment_content);
        assert hostFragment != null;
        mController = hostFragment.getNavController();
        initJSideBar();
    }

    private void initJSideBar() {
        mBinding.menuSide.showMenus();
        mBinding.menuSide.setMenuItemSelectListener(new JSideBar.MenuItemSelectListener() {
            @Override
            public void select(int i, Menu menu) {
                switch (i) {
                    case 0:
                        mMainViewModel.setMainSideType(MainViewModel.MAIN_SIDE_TYPE_ONE);
                        break;
                    case 1:
                        mMainViewModel.setMainSideType(MainViewModel.MAIN_SIDE_TYPE_TWO);
                        break;
                    case 2:
                        mMainViewModel.setMainSideType(MainViewModel.MAIN_SIDE_TYPE_THREE);
                        break;
                }
            }
        });
    }
//        binding = DataBindingUtil.setContentView(this, mLayoutId);
//        User user = new User("jaymz", "PuDong");
//        binding.setUser(user);
//        mMainViewModel = MyApplication.of().get(MainViewModel.class);
//        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
//        lifecycleRegistry.markState(Lifecycle.State.CREATED);
//        lifecycleRegistry.addObserver(new LifecycleObserver() {
//        });
}
