package com.mengyunzhi.core.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.mengyunzhi.core.R;
import com.mengyunzhi.core.fragment.YunzhiFragment;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * yunzhi activity
 * 加载根fragment
 */
public abstract class YunzhiActivity extends SupportActivity {

    /**
     * 设置rootFragment
     * @return 当前应用的根Fragment
     */
    public abstract YunzhiFragment setRootFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 新建容器
        final FrameLayout container = new FrameLayout(this);
        container.setId(R.id.container);

        setContentView(container);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.container, setRootFragment());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
