/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updateMallItems:function(form,callback){
                Lib.submitForm("/shop/mallItems/edit.json",form,{},callback)
            },
            addMallItems:function(form,callback){
                Lib.submitForm("/shop/mallItems/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/shop/mallItems/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
		
    };
    exports('mallItemsApi',api);
});