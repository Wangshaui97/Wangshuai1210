package com.bawei.wangshuai12102.comfig;

import android.app.Application;
import android.graphics.Bitmap;

import com.bawei.wangshuai12102.handler.UnCatchHandler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.getInstance().init(
                new ImageLoaderConfiguration.Builder(this)
                        .memoryCacheSizePercentage(10)
                        .diskCacheSize(50*1024*1024)
                        .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                                .cacheInMemory(true)
                                .cacheOnDisk(true)
                                .bitmapConfig(Bitmap.Config.RGB_565)
                                .build())
                        .build()

        );

        //第三方登录

        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

        //全局捕获异常

        UnCatchHandler.getInstance(getApplicationContext()).init(getApplicationContext());
    }
}
