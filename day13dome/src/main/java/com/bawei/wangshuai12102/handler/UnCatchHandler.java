package com.bawei.wangshuai12102.handler;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UnCatchHandler implements Thread.UncaughtExceptionHandler {
    private static UnCatchHandler mUnCatchHandler;
    private Context mContext;


    public static UnCatchHandler getInstance(Context context) {
        if(mUnCatchHandler == null){
            synchronized (UnCatchHandler.class) {
                mUnCatchHandler = new UnCatchHandler(context);
            }
        }
        return mUnCatchHandler;
    }

    private UnCatchHandler(Context context) {
        init(context);
    }

    public void init(Context context) {

        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context.getApplicationContext();
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            Log.i("ws", e.getLocalizedMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
