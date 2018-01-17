package com.yy.dream.core.db.mapper;


import com.yy.dream.core.api.bean.GiftInfo;

public interface GiftInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GiftInfo record);

    int insertSelective(GiftInfo record);

    GiftInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GiftInfo record);

    int updateByPrimaryKey(GiftInfo record);
}