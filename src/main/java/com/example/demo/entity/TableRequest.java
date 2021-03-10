package com.example.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TableRequest)实体类
 *
 * @author 旷彬
 * @since 2021-03-07 22:47:55
 */
public class TableRequest implements Serializable {
    private static final long serialVersionUID = 527449929037082875L;
    /**
     * ID主键
     */
    private Integer id;
    /**
     * 请求时间
     */
    private Date datetime;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 参数类型
     */
    private String type;
    /**
     * 请求头
     */
    private String headers;
    /**
     * 请求参数
     */
    private String data;

    public TableRequest(Integer id, Date datetime, String address, String url, String type, String headers, String data) {
        this.id = id;
        this.datetime = datetime;
        this.address = address;
        this.url = url;
        this.type = type;
        this.headers = headers;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
