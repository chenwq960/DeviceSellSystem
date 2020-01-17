package com.baidu.po;

public class CacheSequencePO {
    private String sequenceEntity;

    private String sequenceKey;

    private Integer sequenceValue;

    public String getSequenceEntity() {
        return sequenceEntity;
    }

    public void setSequenceEntity(String sequenceEntity) {
        this.sequenceEntity = sequenceEntity == null ? null : sequenceEntity.trim();
    }

    public String getSequenceKey() {
        return sequenceKey;
    }

    public void setSequenceKey(String sequenceKey) {
        this.sequenceKey = sequenceKey == null ? null : sequenceKey.trim();
    }

    public Integer getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(Integer sequenceValue) {
        this.sequenceValue = sequenceValue;
    }
}