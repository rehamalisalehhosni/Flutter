
package com.bartech.sales.sa.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable
{

    @SerializedName("ContentEncoding")
    @Expose
    private Object contentEncoding;
    @SerializedName("ContentType")
    @Expose
    private Object contentType;
    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("JsonRequestBehavior")
    @Expose
    private Integer jsonRequestBehavior;
    @SerializedName("MaxJsonLength")
    @Expose
    private Object maxJsonLength;
    @SerializedName("RecursionLimit")
    @Expose
    private Object recursionLimit;
    private final static long serialVersionUID = -7793570830161973151L;

    public Object getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(Object contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public Object getContentType() {
        return contentType;
    }

    public void setContentType(Object contentType) {
        this.contentType = contentType;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getJsonRequestBehavior() {
        return jsonRequestBehavior;
    }

    public void setJsonRequestBehavior(Integer jsonRequestBehavior) {
        this.jsonRequestBehavior = jsonRequestBehavior;
    }

    public Object getMaxJsonLength() {
        return maxJsonLength;
    }

    public void setMaxJsonLength(Object maxJsonLength) {
        this.maxJsonLength = maxJsonLength;
    }

    public Object getRecursionLimit() {
        return recursionLimit;
    }

    public void setRecursionLimit(Object recursionLimit) {
        this.recursionLimit = recursionLimit;
    }

}
