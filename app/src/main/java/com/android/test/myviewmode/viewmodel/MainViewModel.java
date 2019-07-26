package com.android.test.myviewmode.viewmodel;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.android.test.myviewmode.livedata.MainLiveData;

public class MainViewModel extends ViewModel {
    public static final int MAIN_SIDE_TYPE_ONE = 0;
    public static final int MAIN_SIDE_TYPE_TWO = 1;
    public static final int MAIN_SIDE_TYPE_THREE = 2;

    private ObservableInt mMainSideType;
    private MainLiveData mMainLiveData;

    public MainViewModel() {
        this.mMainSideType = new ObservableInt(MAIN_SIDE_TYPE_ONE);
        this.mMainLiveData = new MainLiveData();
    }

    public void setMainSideType(int type) {
        if (type != mMainSideType.get()) {
            mMainSideType.set(type);
            mMainLiveData.postMainValue(mMainSideType);
        }
    }

    public MainLiveData getmMainLiveData() {
        return mMainLiveData;
    }
}
