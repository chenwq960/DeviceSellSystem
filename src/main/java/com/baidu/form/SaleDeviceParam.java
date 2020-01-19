package com.baidu.form;

public class SaleDeviceParam {

    private Integer recordId;
    private Integer stationId;//
    private Integer deviceId;//
    private Integer saleUser;//
    private String saleTime;//
    private Integer saleNumber;//
    private String remark;//

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

    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
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
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SaleDeviceParam [recordId=" + recordId + ", stationId=" + stationId + ", deviceId=" + deviceId
                + ", saleUser=" + saleUser + ", saleTime=" + saleTime + ", saleNumber=" + saleNumber + ", remark="
                + remark + "]";
    }

}
