package com.corp.shop.service;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.core.util.PlatformException;

import com.corp.shop.dao.MallItemsDao;
import com.corp.shop.entity.MallItems;
import com.ibeetl.admin.core.service.BaseService;

/**
 * MallItems Service
 */

@Service
@Transactional
public class MallItemsService extends BaseService<MallItems>{

    @Autowired private MallItemsDao mallItemsDao;

    public PageQuery<MallItems>queryByCondition(PageQuery query){
        PageQuery ret =  mallItemsDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelMallItems(List<Long> ids){
        try {
            mallItemsDao.batchDelMallItemsByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除MallItems失败", e);
        }
    }
}