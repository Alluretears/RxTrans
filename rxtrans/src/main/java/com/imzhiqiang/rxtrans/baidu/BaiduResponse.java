package com.imzhiqiang.rxtrans.baidu;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by zech on 2017/3/19.
 */

public class BaiduResponse {
    /**
     * from : en
     * to : zh
     * trans_result : [{"src":"apple","dst":"苹果"}]
     */

    @SerializedName("from")
    private String from;
    @SerializedName("to")
    private String to;
    @SerializedName("trans_result")
    private List<TransResult> transResult;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransResult> getTransResult() {
        return transResult;
    }

    public void setTransResult(List<TransResult> transResult) {
        this.transResult = transResult;
    }

    public static class TransResult {
        /**
         * src : apple
         * dst : 苹果
         */

        @SerializedName("src")
        private String src;
        @SerializedName("dst")
        private String dst;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getDst() {
            return dst;
        }

        public void setDst(String dst) {
            this.dst = dst;
        }
    }
}
