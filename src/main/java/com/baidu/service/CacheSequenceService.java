package com.baidu.service;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baidu.mapper.CacheSequencePOMapper;
import com.baidu.po.CacheSequencePO;

/**
 * 序列号生成器
 * 
 * @author songyz
 * @createTime 2020-01-17 14:59:13
 */
@Component
public class CacheSequenceService {

    private static Format numberFormat = new DecimalFormat("000000");

    static enum Entity {
        DEVICE
    }

    @Autowired
    private CacheSequencePOMapper cacheSequencePOMapper;

    public String getSequenceCode(Entity entity, String sequenceKey) {

        CacheSequencePO sequencePO = cacheSequencePOMapper.selectByEntityAndKey(entity.name(), sequenceKey);
        if (Objects.isNull(sequencePO)) {
            sequencePO = new CacheSequencePO();
            sequencePO.setSequenceEntity(entity.name());
            sequencePO.setSequenceKey(sequenceKey);
            sequencePO.setSequenceValue(1);
            cacheSequencePOMapper.insert(sequencePO);
        }
        else {
            sequencePO.setSequenceValue(sequencePO.getSequenceValue() + 1);
        }

        return numberFormat.format(sequencePO.getSequenceValue());
    }

}
