package com.bawei.wangshuai12102.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.bawei.wangshuai12102.view.BannerFragment;
import com.bawei.wangshuai12102.view.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class Fragemntpageadpter extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> mlist;
    private String[] tabs = new String[]{
            "主页", "其他"
    };

    public Fragemntpageadpter(FragmentManager fm, Context context, List<Fragment> mlist) {
        super(fm);
        this.context = context;
        this.mlist = mlist;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new BannerFragment();
            case 1:
                return new OtherFragment();
            default:
                return new OtherFragment();
        }
    }

}
