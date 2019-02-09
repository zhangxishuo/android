package com.mengyunzhi.android;

import com.mengyunzhi.core.activity.YunzhiActivity;
import com.mengyunzhi.core.fragment.YunzhiFragment;

public class MainActivity extends YunzhiActivity {

    @Override
    public YunzhiFragment setRootFragment() {
        return new MyFragment();
    }
}
