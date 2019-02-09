package com.mengyunzhi.core.config;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * 全局配置
 */
@SuppressWarnings("ALL")
public class Configuration {

    /**
     * 全局上下文
     */
    private Context APPLICATION_CONTEXT;

    private String API;

    private static class Holder {
        @SuppressLint("StaticFieldLeak")
        private static final Configuration INSTANCE = new Configuration();
    }

    public static Configuration getInstance() {
        return Holder.INSTANCE;
    }

    public Context getContext() {
        return APPLICATION_CONTEXT;
    }

    public Configuration setContext(Context context) {
        this.APPLICATION_CONTEXT = context;
        return this;
    }

    public String getAPI() {
        return API;
    }

    public Configuration setAPI(String API) {
        this.API = API;
        return this;
    }
}
