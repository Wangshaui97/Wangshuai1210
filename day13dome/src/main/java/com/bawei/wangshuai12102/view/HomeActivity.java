package com.bawei.wangshuai12102.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.wangshuai12102.R;
import com.bawei.wangshuai12102.adpter.Fragemntpageadpter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabs;
    private List<Fragment> list;
    private FragmentPagerAdapter fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.viewpager);
        tabs = findViewById(R.id.tabs);
        list = new ArrayList<>();
        fd = new Fragemntpageadpter(getSupportFragmentManager(),this,list);
        viewPager.setAdapter(fd);
        tabs.setupWithViewPager(viewPager);

    }
}
