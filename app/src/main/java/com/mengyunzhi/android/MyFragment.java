package com.mengyunzhi.android;

import android.widget.Toast;

import com.mengyunzhi.core.Yunzhi;
import com.mengyunzhi.core.fragment.YunzhiFragment;
import com.mengyunzhi.core.net.RestClient;
import com.mengyunzhi.core.net.callback.Success;

public class MyFragment extends YunzhiFragment {

    @Override
    public Object setLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void init() {
        RestClient.builder()
                .url("http://news.baidu.com/")
                .success((response) -> Toast.makeText(Yunzhi.getContext(), response, Toast.LENGTH_LONG).show())
                .build()
                .get();
    }
}
