package com.imzhiqiang.rxtrans;

/**
 * Created by zech on 2017/3/20.
 */

public enum Langs {
    EN("en"), ZH("zh"), AUTO("auto");
    private final String lang;

    private Langs(String s) {
        lang = s;
    }

    @Override
    public String toString() {
        return lang;
    }

}
