package com.mengyunzhi.core.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * yunzhi fragment
 * 用于实现布局与类的绑定
 */
public abstract class YunzhiFragment extends SwipeBackFragment {

    /**
     * 设置当前fragment的布局
     * @return layout/view
     */
    public abstract Object setLayout();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;

        // 获取布局对象
        Object layout = setLayout();

        // 渲染视图
        if (layout instanceof Integer) {
            rootView = inflater.inflate((Integer) layout, container, false);
        } else if (layout instanceof View) {
            rootView = (View) layout;
        }

        return rootView;
    }
}
