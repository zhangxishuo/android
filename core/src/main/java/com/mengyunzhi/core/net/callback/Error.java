package com.mengyunzhi.core.net.callback;

@FunctionalInterface
public interface Error {

    void onError(int code, String message);
}
