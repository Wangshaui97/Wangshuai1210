package com.bawei.wangshuai12102.presenter;

import android.content.Context;

import com.bawei.wangshuai12102.model.IModel;
import com.bawei.wangshuai12102.mycallback.MyCallback;
import com.bawei.wangshuai12102.view.Iview;

public class Ipresenter implements IP {

    private Iview iview;
    private IModel iModel;

    public Ipresenter(Iview iview) {
        this.iview = iview;
        iModel = new IModel();
    }

    @Override
    public void setRequest(String url) {
        iModel.setResponse(url, new MyCallback() {
            @Override
            public void onsetData(Object data) {
                iview.setData(data);
            }
        });
    }

    @Override
    public void setinsertRequest(String url) {
        iModel.setinsertResponse(url, new MyCallback() {
            @Override
            public void onsetData(Object data) {
                iview.setData(data);
            }
        });
    }

    @Override
    public void setibannerRequest(String url) {
        iModel.setbannerResponse(url, new MyCallback() {
            @Override
            public void onsetData(Object data) {
                iview.setData(data);
            }
        });
    }

    public void onDetouch() {
        if (iview != null) {
            iview = null;
        }
        if (iModel != null) {
            iModel = null;
        }
    }

}
