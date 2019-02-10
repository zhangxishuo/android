package com.mengyunzhi.core.net;

import com.mengyunzhi.core.enums.HttpMethod;
import com.mengyunzhi.core.net.callback.Error;
import com.mengyunzhi.core.net.callback.Failure;
import com.mengyunzhi.core.net.callback.Request;
import com.mengyunzhi.core.net.callback.Success;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings({"DanglingJavadoc", "NullableProblems", "FieldCanBeLocal"})
public class RestClient {

    private final String URL;

    private final Map<String, Object> PARAMS;

    private final Request REQUEST;

    private final Success SUCCESS;

    private final Failure FAILURE;

    private final Error ERROR;

    private final RequestBody REQUEST_BODY;

    RestClient(String URL,
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

    private void request(HttpMethod method) {

        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            default:
                break;
        }

        if (call != null) {
            /**
             * execute会调用主线程执行(UI线程)，影响UI绘制
             * enqueue会新建线程执行，不影响UI线程
             */
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        if (call.isExecuted()) {
                            if (SUCCESS != null) {
                                SUCCESS.onSuccess(response.body());
                            }
                        }
                    } else {
                        if (ERROR != null) {
                            ERROR.onError(response.code(), response.message());
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    if (FAILURE != null) {
                        FAILURE.onFailure();
                    }

                    if (REQUEST != null) {
                        REQUEST.onRequestEnd();
                    }
                }
            });
        }
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
