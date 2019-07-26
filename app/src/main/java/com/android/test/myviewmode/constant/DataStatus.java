package com.android.test.myviewmode.constant;

public enum DataStatus {
    Loading,
    Content,
    Cache,
    Empty,
    Error;

    public boolean hasContent() {
        return this == Content || this == Cache;
    }
}
