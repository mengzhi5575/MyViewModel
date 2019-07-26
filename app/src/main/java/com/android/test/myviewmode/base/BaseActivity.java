package com.android.test.myviewmode.base;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.test.myviewmode.databinding.ActivityMainBinding;
import com.jidouauto.ui.oushang.AdaptScreenUtils;

public class BaseActivity extends AppCompatActivity {
    public int mLayoutId;
    public ActivityMainBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mLayoutId > 0) {
            mBinding = DataBindingUtil.setContentView(this, mLayoutId);
        }
    }

    @Override
    public Resources getResources() {
        return AdaptScreenUtils.adaptWidth(this, super.getResources(), 1920);
    }
}
