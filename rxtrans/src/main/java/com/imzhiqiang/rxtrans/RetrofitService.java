package com.imzhiqiang.rxtrans;

import com.google.gson.Gson;
import com.imzhiqiang.rxtrans.baidu.BaiduResponse;
import com.imzhiqiang.rxtrans.youdao.YoudaoResponse;
import io.reactivex.Observable;
import java.util.Map;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by zech on 2017/3/19.
 */

public interface RetrofitService {

    @GET("http://api.fanyi.baidu.com/api/trans/vip/translate")
    Observable<BaiduResponse> translateByBaidu(@QueryMap Map<String, String> fields);

    @GET("http://fanyi.youdao.com/openapi.do")
    Observable<YoudaoResponse> translateByYoudao(@QueryMap Map<String, String> fields);

    class Factory {

        public static RetrofitService makeRetrofitService() {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.imzhiqiang.com")
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(RetrofitService.class);
        }
    }
}
