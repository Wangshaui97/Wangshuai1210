package com.bawei.wangshuai12102.model;

import com.bawei.wangshuai12102.bean.BannerBean;
import com.bawei.wangshuai12102.bean.InsertBean;
import com.bawei.wangshuai12102.bean.LoginBean;
import com.bawei.wangshuai12102.httputil.HttpUtil;
import com.bawei.wangshuai12102.mycallback.MyCallback;

public class IModel implements IM {


    @Override
    public void setResponse(String url, final MyCallback myCallback) {

        HttpUtil.getRequest(url, LoginBean.class, new HttpUtil.CallBack<LoginBean>() {
            @Override
            public void getdata(LoginBean loginBean) {
                myCallback.onsetData(loginBean);
            }
        });

    }

    @Override
    public void setinsertResponse(String url,final MyCallback myCallback) {
        HttpUtil.getRequest(url, InsertBean.class, new HttpUtil.CallBack<InsertBean>() {
            @Override
            public void getdata(InsertBean insertBean) {
                myCallback.onsetData(insertBean);
            }
        });
    }

    @Override
    public void setbannerResponse(String url, final MyCallback myCallback) {
        HttpUtil.getRequest(url, BannerBean.class, new HttpUtil.CallBack<BannerBean>() {
            @Override
            public void getdata(BannerBean bannerBean) {
                myCallback.onsetData(bannerBean);
            }
        });
    }
}
