package com.baidu.po;

public class RegionPO {
    private Integer regionId;

    private Integer parentRegionId;

    private Byte regionLevel;

    private String regionCode;

    private byte[] regionName;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getParentRegionId() {
        return parentRegionId;
    }

    public void setParentRegionId(Integer parentRegionId) {
        this.parentRegionId = parentRegionId;
    }

    public Byte getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Byte regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    public byte[] getRegionName() {
        return regionName;
    }

    public void setRegionName(byte[] regionName) {
        this.regionName = regionName;
    }
}