package com.imzhiqiang.rxtrans.baidu;

import com.imzhiqiang.rxtrans.RetrofitService;
import com.imzhiqiang.rxtrans.TransApi;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zech on 2017/3/19.
 */

public final class BaiduTransApi implements TransApi {

    private final String appId;
    private final String securityKey;
    private RetrofitService mRetrofitService;

    public BaiduTransApi(String appId, String securityKey, RetrofitService retrofitService) {
        this.appId = appId;
        this.securityKey = securityKey;
        this.mRetrofitService = retrofitService;
    }

    @Override
    public Observable<String> trans(String query, String from, String to) {
        Map<String, String> filters = new HashMap<>();
        filters.put("q", query);
        filters.put("from", from);
        filters.put("to", to);
        filters.put("appid", appId);
        String salt = String.valueOf(System.currentTimeMillis());
        filters.put("salt", salt);
        String sign = MD5.md5(appId + query + salt + securityKey);
        filters.put("sign", sign);
        return mRetrofitService.translateByBaidu(filters)
                .map(new Function<BaiduResponse, String>() {
                    @Override
                    public String apply(@NonNull BaiduResponse baiduResponse) throws Exception {
                        return baiduResponse.getTransResult().get(0).getDst();
                    }
                });
    }
}
