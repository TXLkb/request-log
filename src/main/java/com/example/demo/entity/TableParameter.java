package com.example.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TableParameter)实体类
 *
 * @author 旷彬
 * @since 2021-03-07 22:47:50
 */
public class TableParameter implements Serializable {
    private static final long serialVersionUID = -68056195325884420L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 参数名称
     */
    private String parameterName;
    /**
     * 参数编码
     */
    private String parameterCode;
    /**
     * 参数值
     */
    private String parameterValue;
    /**
     * 参数类型
     */
    private String parameterType;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 更新时间
     */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterCode() {
        return parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
