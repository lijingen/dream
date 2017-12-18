package com.yy.dream.core.db.mapper.impl;

import com.yy.dream.core.db.domain.GiftInfo;
import com.yy.dream.core.db.mapper.GiftInfoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/16.
 */
@Service
public class GiftInfoMapperImpl implements GiftInfoMapper{
    @Resource
    Map<Integer,SqlSessionFactory> sqlSessionFactoryMap;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(GiftInfo record) {
        Long uid=record.getUid();
        record.setTableSuffix(uid);
        sqlSessionFactoryMap.get(record.getDatabaseSuffix(uid)).openSession().insert("com.yy.dream.core.db.mapper.GiftInfoMapper.insert",record);
        return 0;
    }

    @Override
    public int insertSelective(GiftInfo record) {
        return 0;
    }

    @Override
    public GiftInfo selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(GiftInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(GiftInfo record) {
        return 0;
    }
}
