package com.corp.shop.web.query;

import org.apache.commons.lang3.StringUtils;
import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.util.Tool;
import com.ibeetl.admin.core.util.enums.CoreDictType;
import com.ibeetl.admin.core.web.query.PageParam;
import java.util.Date;
/**
 *MallItems查询
 */
public class MallItemsQuery extends PageParam {
    @Query(name = "itemId", display = true)
    private Integer itemId;
    public Integer getItemId(){
        return  itemId;
    }
    public void setItemId(Integer itemId ){
        this.itemId = itemId;
    }
 
}
