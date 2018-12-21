package com.bawei.wangshuai12102.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class HorizontalView extends TextView {
    public HorizontalView(Context context) {
        super(context);
    }

    public HorizontalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean isFocused() {
        return true;
    }
}
