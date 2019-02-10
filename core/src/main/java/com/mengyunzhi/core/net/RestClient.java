package com.mengyunzhi.core.net;

import com.mengyunzhi.core.net.callback.Failure;
import com.mengyunzhi.core.net.callback.Request;
import com.mengyunzhi.core.net.callback.Success;

import java.util.Map;

import okhttp3.RequestBody;

public class RestClient {

    private final String URL;

    private final Map<String, Object> PARAMS;

    private final Request REQUEST;

    private final Success SUCCESS;

    private final Failure FAILURE;

    private final Error ERROR;

    private final RequestBody REQUEST_BODY;

    public RestClient(String URL,
                      Map<String, Object> PARAMS,
                      Request REQUEST,
                      Success SUCCESS,
                      Failure FAILURE,
                      Error ERROR,
                      RequestBody REQUEST_BODY) {
        this.URL = URL;
        this.PARAMS = PARAMS;
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
        this.FAILURE = FAILURE;
        this.ERROR = ERROR;
        this.REQUEST_BODY = REQUEST_BODY;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
}
