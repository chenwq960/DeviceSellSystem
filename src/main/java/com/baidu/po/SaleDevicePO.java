package com.baidu.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SaleDevicePO {

    private Integer recordId;
    private Integer stationId;//
    private Integer deviceId;//
    private Integer saleUser;//

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date saleTime;//
    private Integer saleNumber;//
    private String remark;//
    private Integer createUser;
    private Date createTime;
    private Integer updateUser;
    private Date updateTime;
    @JsonIgnore
    private Boolean isDelete;

    @JsonIgnore
    private String saleDeviceName;
    @JsonIgnore
    private String saleDeviceModel;
    @JsonIgnore
    private String saleDevicePerson;
    @JsonIgnore
    private String stationName;
    @JsonIgnore
    private String createUserName;
    @JsonIgnore
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSaleDeviceModel() {
        return saleDeviceModel;
    }

    public void setSaleDeviceModel(String saleDeviceModel) {
        this.saleDeviceModel = saleDeviceModel;
    }

    public String getSaleDeviceName() {
        return saleDeviceName;
    }

    public void setSaleDeviceName(String saleDeviceName) {
        this.saleDeviceName = saleDeviceName;
    }

    public String getSaleDevicePerson() {
        return saleDevicePerson;
    }

    public void setSaleDevicePerson(String saleDevicePerson) {
        this.saleDevicePerson = saleDevicePerson;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getSaleUser() {
        return saleUser;
    }

    public void setSaleUser(Integer saleUser) {
        this.saleUser = saleUser;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Integer getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "SaleDevicePO [recordId=" + recordId + ", stationId=" + stationId + ", deviceId=" + deviceId
                + ", saleUser=" + saleUser + ", saleTime=" + saleTime + ", saleNumber=" + saleNumber + ", remark="
                + remark + ", createUser=" + createUser + ", createTime=" + createTime + ", updateUser=" + updateUser
                + ", updateTime=" + updateTime + ", isDelete=" + isDelete + "]";
    }

}