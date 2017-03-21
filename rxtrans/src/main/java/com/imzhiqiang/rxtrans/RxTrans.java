package com.imzhiqiang.rxtrans;

import com.imzhiqiang.rxtrans.baidu.BaiduTransApi;
import com.imzhiqiang.rxtrans.youdao.YoudaoTransApi;
import io.reactivex.Observable;

/**
 * Created by zech on 2017/3/19.
 */

public class RxTrans {

    private TransApi mTransApi;
    private RetrofitService mRetrofitService;
    private static RxTrans sInstance = new RxTrans();

    private RxTrans() {
        mRetrofitService = RetrofitService.Factory.makeRetrofitService();
    }

    public static RxTrans getInstance() {
        return sInstance;
    }

    public RxTrans useBaidu(String appId, String securityKey) {
        mTransApi = new BaiduTransApi(appId, securityKey, mRetrofitService);
        return this;
    }

    public RxTrans useYoudao(String keyfrom, String key) {
        mTransApi = new YoudaoTransApi(keyfrom, key, mRetrofitService);
        return this;
    }

    public Observable<String> translateToZh(String query) {
        return translate(query, "auto", "zh");
    }

    public Observable<String> translateToEn(String query) {
        return translate(query, "auto", "en");
    }

    /**
     * @param from {@see http://api.fanyi.baidu.com/api/trans/product/apidoc#languageList}
     * @param to {@see http://api.fanyi.baidu.com/api/trans/product/apidoc#languageList}
     */
    public Observable<String> translate(String query, String from, String to) {
        return mTransApi.trans(query, from, to);
    }
}
