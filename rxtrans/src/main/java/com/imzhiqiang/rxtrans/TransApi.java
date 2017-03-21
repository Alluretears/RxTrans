package com.imzhiqiang.rxtrans;

import io.reactivex.Observable;

/**
 * Created by zech on 2017/3/19.
 */

public interface TransApi {

    Observable<String> trans(String query, String from, String to);
}
