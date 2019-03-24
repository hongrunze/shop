queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from MALL_ITEMS t
    where del_flag=0 
    @//数据权限，该sql语句功能点  
    and #function("mallItems.query")#
    
    
    

batchDelMallItemsByIds
===

* 批量逻辑删除

    update MALL_ITEMS set del_flag = 1 where ITEM_ID  in( #join(ids)#)
    
