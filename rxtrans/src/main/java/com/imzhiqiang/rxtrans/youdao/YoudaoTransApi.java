package com.imzhiqiang.rxtrans.youdao;

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

public final class YoudaoTransApi implements TransApi {
    /*http://fanyi.youdao.com/openapi.do?keyfrom=RxTransDemo&key=372295451&type=data&doctype=json&version=1.1&q=good
    {
        "errorCode":0
        "query":"good",
            "translation":["好"], // 有道翻译
        "basic":{ // 有道词典-基本词典
        "phonetic":"gʊd"
        "uk-phonetic":"gʊd" //英式发音
        "us-phonetic":"ɡʊd" //美式发音
        "explains":[
        "好处",
                "好的"
        "好"
        ]
    },
        "web":[ // 有道词典-网络释义
        {
            "key":"good",
                "value":["良好","善","美好"]
        },
        {...}
    ]
    }*/

    private final String keyfrom;
    private final String key;
    private RetrofitService mRetrofitService;

    public YoudaoTransApi(String keyfrom, String key, RetrofitService retrofitService) {
        this.keyfrom = keyfrom;
        this.key = key;
        this.mRetrofitService = retrofitService;
    }

    @Override
    public Observable<String> trans(String query, String from, String to) {
        Map<String, String> filters = new HashMap<>();
        filters.put("keyfrom", keyfrom);
        filters.put("key", key);
        filters.put("type", "data");
        filters.put("doctype", "json");
        filters.put("version", "1.1");
        filters.put("q", query);
        return mRetrofitService.translateByYoudao(filters)
                .map(new Function<YoudaoResponse, String>() {
                    @Override
                    public String apply(@NonNull YoudaoResponse youdaoResponse) throws Exception {
                        return youdaoResponse.getTranslation().get(0);
                    }
                });
    }
}
