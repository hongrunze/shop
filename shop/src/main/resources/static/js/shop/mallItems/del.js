layui.define(['table', 'mallItemsApi'], function(exports) {
    var mallItemsApi = layui.mallItemsApi;
    var table=layui.table;
    var view = {
        init:function(){
        },
        delBatch:function(){
            var data = Common.getMoreDataFromTable(table,"mallItemsTable");
            if(data==null){
                return ;
            }
            Common.openConfirm("确认要删除这些MallItems?",function(){
            var ids =Common.concatBatchId(data,"itemId");
            mallItemsApi.del(ids,function(){
                Common.info("删除成功");
                    dataReload();
                })
            })
        }
    }
    exports('del',view);
	
});