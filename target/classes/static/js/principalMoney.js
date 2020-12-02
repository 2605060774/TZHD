$(function () {
    layui.use(['table','form'], function () {
        var table = layui.table;
        var form = layui.form;

        var movie={
            itemName:"",
            resourceType:""
        }
        form.on('submit(formSelect)',function (data) {
            movie.itemName = data.field.itemName;
            movie.resourceType = data.field.resourceType;

            tables(movie);
        });
        tables(movie);
        function tables(movie) {
            table.render({
                elem: '#fuzerenTab'
                , url: '/money/principalCheck'
                , method: "post"
                , where: movie
                , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                , cols: [
                    [
                        {field: 'applyId', hide: true}
                        , {field: 'itemCode', width: 150, title: '项目编号'}
                        , {field: 'itemName', width: 150, title: '项目名称'}
                        , {field: 'objectName', width: 150, title: '标的名称'}
                        , {field: 'bidName', width: 150, title: '竞买人'}
                        , {field: 'resourceType', width: 150, title: '资源类型', templet: function (d) {
                            if (d.resourceType == '1') {
                                return "拓展资源";
                            }
                            ;
                            if (d.resourceType == '2') {
                                return "国有资源";
                            }
                            ;
                        }} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                        , {field: 'applyStartTime', width: 150, title: '报名开始时间'}
                        , {field: 'depositTime', width: 150, title: '保证金缴纳截止时间'}
                        , {field: 'bidStartTime', width: 150, title: '竞价开始时间'}
                        , {field: 'right', title: '操作',toolbar:'#demobar'}

                    ]
                ]
            })

        }

        table.on('tool(fuzerenTab)', function(obj){
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent=='update'){
                $.ajax({
                    url: '/money/backMoney',
                    data:{applyId:data.applyId},
                    type:"post",
                    success:function (data) {
                        if (data){
                            layer.msg("成功退回");
                            table.reload("fuzerenTab",{});
                        }else {
                            layer.msg("退回失败");
                        }
                    }

                })
            }
        })

    })

});


