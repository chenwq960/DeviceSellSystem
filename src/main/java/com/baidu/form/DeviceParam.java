package com.baidu.form;

/**
 * 设备添加或修改时，参数实体
 * 
 * @author songyz
 * @createTime 2020-01-17 18:34:03
 */
public class DeviceParam {

    private Integer deviceId;
    private String deviceName;
    private String deviceModel;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Override
    public String toString() {
        return "DeviceParam [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceModel=" + deviceModel
                + "]";
    }

}
