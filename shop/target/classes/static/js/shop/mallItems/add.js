layui.define([ 'form', 'laydate', 'table','mallItemsApi'], function(exports) {
    var form = layui.form;
    var mallItemsApi = layui.mallItemsApi;
    var index = layui.index;
    var view = {
        init:function(){
            Lib.initGenrealForm($("#addForm"),form);
            this.initSubmit();
        },
        initSubmit:function(){
            $("#addButton").click(function(){
                 form.on('submit(form)', function(){
                     mallItemsApi.addMallItems($('#addForm'),function(){
                         parent.window.dataReload();
                         Common.info("添加成功");
                         Lib.closeFrame();
                     });
                });
            });
        
            $("#addButton-cancel").click(function(){
                Lib.closeFrame();
            });
        }
    			
    }
    exports('add',view);
});