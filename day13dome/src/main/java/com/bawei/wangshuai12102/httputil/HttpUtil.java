package com.bawei.wangshuai12102.httputil;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    //创建一个接口
    public interface CallBack<T>{
        void getdata(T t);
    }

    public static void getRequest(final String urlstr, final Class clazz, final CallBack callBack){
        new AsyncTask<String, Void, Object>() {
            @Override
            protected Object doInBackground(String... strings) {
                return HttpUtil.getRequest(strings[0],clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                callBack.getdata(o);
            }
        }.execute(urlstr);

    }


    public static <T> T  getRequest(String urlstr,Class clazz){
//        String str = getRequest(urlstr);
//        Log.i("ws", "str is " + str);
        T t = (T) new Gson().fromJson(getRequest(urlstr),clazz);
        return t;
    }


    public static String getRequest(String urlstr){
        String textstring=" ";
        try {
            URL url = new URL(urlstr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            int responseCode = httpURLConnection.getResponseCode();
            if(responseCode==200){
                textstring=Stream2String(httpURLConnection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return textstring;
    }

    private static String Stream2String(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str=bufferedReader.readLine())!=null){
            stringBuilder.append(str);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

}
