package com.mengyunzhi.android;

import android.app.Application;

import com.mengyunzhi.core.Yunzhi;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Yunzhi.init(this)
            .setAPI("https://127.0.0.1");
    }
}
