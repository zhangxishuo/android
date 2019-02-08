package com.mengyunzhi.android;

import android.app.Application;

import me.yokeyword.fragmentation.Fragmentation;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fragmentation.builder()
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(true)
                .install();
    }
}
