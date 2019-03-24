package com.corp.shop.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.corp.shop.entity.*;

/**
 * MallItems Dao
 */
@SqlResource("shop.mallItems")
public interface MallItemsDao extends BaseMapper<MallItems>{
    public PageQuery<MallItems> queryByCondition(PageQuery query);
    public void batchDelMallItemsByIds( List<Long> ids);
}