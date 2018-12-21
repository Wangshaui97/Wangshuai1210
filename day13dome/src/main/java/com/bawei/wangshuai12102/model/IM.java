package com.bawei.wangshuai12102.model;

import com.bawei.wangshuai12102.mycallback.MyCallback;

public interface IM<T> {
    void setResponse(String url, MyCallback myCallback);
    void setinsertResponse(String url, MyCallback myCallback);
    void setbannerResponse(String url, MyCallback myCallback);
}
