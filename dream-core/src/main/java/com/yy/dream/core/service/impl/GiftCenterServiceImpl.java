package com.yy.dream.core.service.impl;


import com.yy.dream.core.api.bean.GiftInfo;
import com.yy.dream.core.api.service.IGiftCenterService;
import com.yy.dream.core.config.mysql.ContextHolder;
import com.yy.dream.core.config.mysql.DataSourceType;
import com.yy.dream.core.db.mapper.GiftInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijingen on 2017/5/10.
 */
@Service
public class GiftCenterServiceImpl implements IGiftCenterService{

    @Autowired
    GiftInfoMapper giftInfoMapper;
    @Override
    public void createGift(GiftInfo gift) {
        gift.setTableSuffix(gift.getUid());
        ContextHolder.setDataSourceByUid(gift.getUid());
        giftInfoMapper.insert(gift);
    }
}
