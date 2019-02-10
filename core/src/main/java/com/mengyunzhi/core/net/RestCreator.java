package com.mengyunzhi.core.net;

import com.mengyunzhi.core.Yunzhi;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@SuppressWarnings({"WeakerAccess", "unused"})
public class RestCreator {

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    public static Map<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    private static class ParamsHolder {

        private static final Map<String, Object> PARAMS = new WeakHashMap<>();
    }

    private static class RestServiceHolder {

        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

    private static class RetrofitHolder {

        private static final String URL = Yunzhi.getApi();

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static class OkHttpHolder {

        private static final Integer TIME_OUT = 60;

        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }
}
