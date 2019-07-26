package com.android.test.myviewmode.bean;

import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import com.android.test.myviewmode.constant.DataStatus;
import com.android.test.myviewmode.constant.ErrorData;

public class DataBean<T> implements Observable {
    private transient PropertyChangeRegistry mCallbacks;
    private T data;
    private DataStatus mDataStatus;
    private ErrorData mErrorData;

    public DataBean(T data, DataStatus mDataStatus, ErrorData mErrorData) {
        this.data = data;
        this.mDataStatus = mDataStatus;
        this.mErrorData = mErrorData;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        synchronized (this) {
            if (mCallbacks == null) {
                mCallbacks = new PropertyChangeRegistry();
            }
            mCallbacks.add(callback);
        }
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        synchronized (this) {
            if (mCallbacks == null) {
                return;
            }
            mCallbacks.remove(callback);
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DataStatus getmDataStatus() {
        if (mDataStatus == null) {
            return DataStatus.Empty;
        } else if (mDataStatus.hasContent()) {
            if (data == null) {
                return DataStatus.Empty;
            }
        }
        return mDataStatus;
    }

    public void setmDataStatus(DataStatus mDataStatus) {
        this.mDataStatus = mDataStatus;
    }

    public ErrorData getmErrorData() {
        return mErrorData;
    }

    public void setmErrorData(ErrorData mErrorData) {
        this.mErrorData = mErrorData;
    }
}
