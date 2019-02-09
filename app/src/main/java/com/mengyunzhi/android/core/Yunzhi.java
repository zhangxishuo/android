package com.mengyunzhi.android.core;

import android.content.Context;

/**
 * yunzhi 应用配置类
 */
public class Yunzhi {

    /**
     * 应用初始化
     * @param context 全局上下文
     * @return 单例配置对象
     */
    public static Configuration init(Context context) {
        return Configuration.getInstance()
                .setContext(context);
    }
}
