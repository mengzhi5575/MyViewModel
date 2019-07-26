package com.android.test.myviewmode.livedata;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.android.test.myviewmode.bean.DataBean;
import com.android.test.myviewmode.constant.DataStatus;
import com.android.test.myviewmode.constant.ErrorData;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainLiveData<T> extends MutableLiveData<DataBean<T>> {
    private AtomicBoolean mPedding = new AtomicBoolean(false);

    public void postMainValue(T data) {
        super.postValue(new DataBean<T>(data, DataStatus.Content, new ErrorData(-1, "normal")));
    }

    public void setMainValue(T data) {
        setValue(new DataBean<T>(data, DataStatus.Content, new ErrorData(-1, "normal")));
    }

    @MainThread
    public void setValue(DataBean<T> dataBean) {
        mPedding.set(true);
        super.setValue(dataBean);
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner owner, @NonNull final Observer<? super DataBean<T>> observer) {
        if (hasActiveObservers()) {
        }
        super.observe(owner, new Observer<DataBean<T>>() {
            @Override
            public void onChanged(DataBean<T> dataBean) {
                if (mPedding.compareAndSet(true, false)) {
                    observer.onChanged(dataBean);
                }
            }
        });
    }
}
