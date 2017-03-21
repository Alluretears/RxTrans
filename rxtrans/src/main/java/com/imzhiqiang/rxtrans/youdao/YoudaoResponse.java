package com.imzhiqiang.rxtrans.youdao;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by zech on 2017/3/19.
 */

public class YoudaoResponse {

    /**
     * translation : ["苹果"]
     * basic : {"us-phonetic":"'æpl","phonetic":"'æp(ə)l","uk-phonetic":"'æp(ə)l","explains":["n. 苹果，苹果树，苹果似的东西；[美俚]炸弹，手榴弹，（棒球的）球；[美俚]人，家伙。"]}
     * query : apple
     * errorCode : 0
     * web : [{"value":["苹果","苹果","苹果公司"],"key":"APPLE"},{"value":["Apple Lossless","Apple Lossless","애플 무손실"],"key":"Apple Lossless"},{"value":["苹果商店","苹果零售店","苹果商店"],"key":"Apple Store"}]
     */

    @SerializedName("basic")
    private BasicDict basic;
    @SerializedName("query")
    private String query;
    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("translation")
    private List<String> translation;
    @SerializedName("web")
    private List<WebDict> web;

    public BasicDict getBasic() {
        return basic;
    }

    public void setBasic(BasicDict basic) {
        this.basic = basic;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<WebDict> getWeb() {
        return web;
    }

    public void setWeb(List<WebDict> web) {
        this.web = web;
    }

    public static class BasicDict {
        /**
         * us-phonetic : 'æpl
         * phonetic : 'æp(ə)l
         * uk-phonetic : 'æp(ə)l
         * explains : ["n. 苹果，苹果树，苹果似的东西；[美俚]炸弹，手榴弹，（棒球的）球；[美俚]人，家伙。"]
         */

        @SerializedName("us-phonetic")
        private String usphonetic;
        @SerializedName("phonetic")
        private String phonetic;
        @SerializedName("uk-phonetic")
        private String ukphonetic;
        @SerializedName("explains")
        private List<String> explains;

        public String getUsphonetic() {
            return usphonetic;
        }

        public void setUsphonetic(String usphonetic) {
            this.usphonetic = usphonetic;
        }

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public String getUkphonetic() {
            return ukphonetic;
        }

        public void setUkphonetic(String ukphonetic) {
            this.ukphonetic = ukphonetic;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }
    }

    public static class WebDict {
        /**
         * value : ["苹果","苹果","苹果公司"]
         * key : APPLE
         */

        @SerializedName("key")
        private String key;
        @SerializedName("value")
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
