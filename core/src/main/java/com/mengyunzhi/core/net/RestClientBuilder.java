package com.mengyunzhi.core.net;

import com.mengyunzhi.core.net.callback.Error;
import com.mengyunzhi.core.net.callback.Failure;
import com.mengyunzhi.core.net.callback.Request;
import com.mengyunzhi.core.net.callback.Success;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 建造者模式，用于构建RestClient
 */
@SuppressWarnings("unused")
public class RestClientBuilder {

    private String url;

    private final Map<String, Object> PARAMS = RestCreator.getParams();

    private Request request;

    private Success success;

    private Failure failure;

    private Error error;

    private RequestBody requestBody;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.url = url;
        return this;
    }

    public final RestClientBuilder param(String key, Object value) {
        this.PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder params(Map<String, Object> params) {
        this.PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder request(Request request) {
        this.request = request;
        return this;
    }

    public final RestClientBuilder success(Success success) {
        this.success = success;
        return this;
    }

    public final RestClientBuilder failure(Failure failure) {
        this.failure = failure;
        return this;
    }

    public final RestClientBuilder error(Error error) {
        this.error = error;
        return this;
    }

    public final RestClientBuilder requestBody(String data) {
        this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), data);
        return this;
    }

    public final RestClient build() {
        return new RestClient(url, PARAMS, request, success, failure, error, requestBody);
    }
}
