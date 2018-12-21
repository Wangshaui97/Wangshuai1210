package com.bawei.wangshuai12102.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.wangshuai12102.R;
import com.bawei.wangshuai12102.bean.LoginBean;
import com.bawei.wangshuai12102.presenter.Ipresenter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements Iview {

    private EditText putinname, putinpwd;
    private String path = "http://www.zhaoapi.cn/user/login?mobile=%s&password=%s";
    private Ipresenter ipresenter;
    private ImageView threeloagin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        putinname = findViewById(R.id.putinname);
        putinpwd = findViewById(R.id.putinpwd);
        threeloagin = findViewById(R.id.threelogin);
        ipresenter = new Ipresenter(this);


        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = putinname.getText().toString();
                String p = putinpwd.getText().toString();

                ipresenter.setRequest(String.format(path, n, p));
            }
        });

        findViewById(R.id.zhuce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        threeloagin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UMShareAPI umShareAPI = UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                        String name = map.get("screen_name");
                        String img = map.get("profile_image_url");

                        Toast.makeText(MainActivity.this, "" + name, Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        ImageLoader.getInstance().displayImage(img, threeloagin);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ipresenter.onDetouch();
    }

    @Override
    public void setData(Object data) {
        LoginBean loginBean = (LoginBean) data;
        Toast.makeText(MainActivity.this, "" + loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (loginBean.getMsg().equals("登录成功")) {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
    }
}
