package com.bawei.wangshuai12102.view;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.wangshuai12102.R;
import com.bawei.wangshuai12102.bean.BannerBean;
import com.bawei.wangshuai12102.presenter.Ipresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;


public class BannerFragment extends Fragment implements Iview {

    private String path = "http://api.tianapi.com/wxnew/?key=c4aa776e0a51d57d6750511e2baa46b6&num=6&page=1";
    private Banner banner_t;
    private Ipresenter ipresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_banner, null);

        banner_t = view.findViewById(R.id.banne);

        ipresenter = new Ipresenter(this);

        ipresenter.setibannerRequest(path);

        view.findViewById(R.id.qrcode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},100);
                    startActivity(new Intent(getActivity(),QRCodeActivity.class));
                }else {
                    startActivity(new Intent(getActivity(),QRCodeActivity.class));
                }

            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ipresenter.onDetouch();
    }

    @Override
    public void setData(Object data) {
        initBanner(data);
    }

    private void initBanner(Object data) {
        BannerBean bannerBean = (BannerBean) data;

        banner_t.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        banner_t.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.NewslistBean bean = (BannerBean.NewslistBean) path;
                com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(bean.getPicUrl(), imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView =new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });

        banner_t.setImages(bannerBean.getNewslist());
        banner_t.start();

    }
}
