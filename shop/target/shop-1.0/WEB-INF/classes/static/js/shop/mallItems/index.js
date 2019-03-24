layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var mallItemsTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),mallItemsTable)
            }
        },
        initTable:function(){
            mallItemsTable = table.render({
                elem : '#mallItemsTable',
                height : Lib.getTableHeight(1),
                cellMinWidth: 100,
                method : 'post',
                url : Common.ctxPath + '/shop/mallItems/list.json' // 数据接口
                ,page : Lib.tablePage // 开启分页
                ,limit : 10,
                cols : [ [ // 表头
                    {
                        type : 'checkbox',
                        fixed:'left',
                    },
                {

                    field : 'itemId', 
                        title : 'itemId',
                    fixed:'left',
                        width : 60,
                },
                {

                    field : 'shopId', 
                        title : 'shopId',
                },
                {

                    field : 'itemTypeId', 
                        title : 'itemTypeId',
                },
                {

                    field : 'brandId', 
                        title : 'brandId',
                },
                {

                    field : 'itemName', 
                        title : 'itemName',
                },
                {

                    field : 'itemDesc', 
                        title : '????',
                },
                {

                    field : 'createTime', 
                        title : 'createTime',
                },
                {

                    field : 'createBy', 
                        title : 'createBy',
                },
                {

                    field : 'updateTime', 
                        title : 'updateTime',
                },
                {

                    field : 'updateBy', 
                        title : 'updateBy',
                }

        ] ]

        });

            table.on('checkbox(mallItemsTable)', function(obj){
                var mallItems = obj.data;
                if(obj.checked){
                    //按钮逻辑Lib.buttonEnable()
                }else{

                }
            })
        },

        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),mallItemsTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/shop/mallItems/add.do";
                    Common.openDlg(url,"MallItems管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"mallItemsTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/shop/mallItems/edit.do?itemId="+data.itemId;
                    Common.openDlg(url,"MallItems管理>"+data.itemId+">编辑");
                },
                del : function() {
                    layui.use(['del'], function(){
                        var delView = layui.del
                        delView.delBatch();
                    });
                }
        };
            $('.ext-toolbar').on('click', function() {
                var type = $(this).data('type');
                toolbar[type] ? toolbar[type].call(this) : '';
            });
        }
    }
    exports('index',view);

});