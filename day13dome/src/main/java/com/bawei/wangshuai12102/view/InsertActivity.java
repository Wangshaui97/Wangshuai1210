package com.bawei.wangshuai12102.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangshuai12102.R;
import com.bawei.wangshuai12102.bean.InsertBean;
import com.bawei.wangshuai12102.presenter.Ipresenter;

public class InsertActivity extends AppCompatActivity implements Iview {

    private EditText putinname,putinpwd;
    private String path = "http://www.zhaoapi.cn/user/reg?mobile=%s&password=%s";
    private Ipresenter ipresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        putinname = findViewById(R.id.putinname);
        putinpwd = findViewById(R.id.putinpwd);

        ipresenter = new Ipresenter(this);


        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = putinname.getText().toString();
                String p = putinpwd.getText().toString();

                ipresenter.setinsertRequest(String.format(path,n,p));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ipresenter.onDetouch();
    }

    @Override
    public void setData(Object data) {
        InsertBean insertBean = (InsertBean) data;
        Toast.makeText(InsertActivity.this,""+insertBean.getMsg(),Toast.LENGTH_SHORT).show();
        if(insertBean.getMsg().equals("注册成功")){
            startActivity(new Intent(InsertActivity.this,MainActivity.class));
        }
    }
}
