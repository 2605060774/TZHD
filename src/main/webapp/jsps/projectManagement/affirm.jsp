<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>项目管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/jss/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="layui-form-item" id="scea" style="margin-top: 30px;">
    <form id="coupon_form" class="layui-form" action="" lay-filter="coupon_form">
        <!--搜索框-->
        <div class="layui-inline">
            <label class="layui-form-label">项目名称：</label>
            <div class="layui-input-inline">
                <input type="text" id="itemName" name="itemName" lay-verify="title" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">项目编号：</label>
            <div class="layui-input-inline">
                <input type="text" id="itemCode" name="itemCode" lay-verify="title" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" id="btn"  data-type="reload" lay-filter="demo1">确定</button>
            </div>
        </div>
    </form>
</div>


<!--table表格 -->
<table id="coupon_tab" lay-filter="test"></table>

<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>




<div style="display:none" id="update">
    <form id="coupon_form1" class="layui-form" action="" lay-filter="coupon_form1">

        <div class="layui-input-inline">
            <input type="hidden" id="seqId" name="seqId" >
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">项目类型：</label>
                <div class="layui-input-inline">
                    <input type="tel" id="itemType" name="itemType" lay-verify="title" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">企业地址：</label>
                <div class="layui-input-inline">
                    <input type="tel" id="itemArea" name="itemArea" lay-verify="title" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">交易方式：</label>
                <div class="layui-input-inline">
                    <input type="tel" id="tradWay" name="tradWay" lay-verify="title" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">出让方：</label>
                <div class="layui-input-inline">
                    <input type="text" id="transferor" name="transferor" lay-verify="title" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">代理机构：</label>
                <div class="layui-input-inline">
                    <input type="tel" id="agentName" name="agentName" lay-verify="title" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系人：</label>
                <div class="layui-input-inline">
                    <input type="tel" id="linkMan" name="linkMan" lay-verify="title" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" id="yichang">
                <button type="button" class="layui-btn layui-btn-primary">取消</button>
                <button type="button" class="layui-btn" id="btnn"  lay-submit="" lay-filter="demo1">确定</button>
            </div>
        </div>
    </form>
</div>
<script>
    // 关闭弹出框
    function closeModel(){
        layer.closeAll();
    }
    layui.use('table', function(){
        var table = layui.table;
        //var form=layui.form;
        //var laydate=layui.laydate;
        table.render({
            elem: '#coupon_tab'
            ,height: 312
            ,id: 'seq_id'
            ,url: '/orojec/orojecshenhe' //数据接口
            ,page: true //开启分页
            // ,parseData : function (res) {
            //     return{
            //         "code":0,
            //         "msg":"",
            //         count:100,
            //         data:res,
            //     }.
            // }
            ,cols: [[ //表头
                {field: 'seqId', title: '序号', width:80, fixed: 'left',sort:true}
                ,{field: 'itemName', title: '项目名称', width:100}
                ,{field: 'itemCode', title: '项目编号', width:100}
                ,{field: 'itemArea', title: '所属地区', width:100}
                ,{field: 'tradWay', title: '交易方式', width:100}
                ,{field: 'transferor', title: '出让方', width:100}
                ,{field: 'transferorMan', title: '出让方联系人', width:100}
                ,{field: 'transferorPhone', title: '出让方联系电话', width:100}
                ,{field: 'applyStartTime', title: '报名开始时间', width:100}
                ,{field: 'applyEndTime', title: '报名截止时间', width:100}
                ,{field: 'agentName', title: '代理机构', width:100}
                ,{field: 'depositCharge', title: '保证金收取单位', width:100}
                ,{title: '操作', width: 200 ,toolbar: '#operation'}
            ]]

        });
        function DAS(){
        }
        var $ = layui.$, active = {
            reload: function(){
                alert(1111)
                //执行重载
                table.reload('seq_id', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        itemName:$("#itemName").val(),
                        itemCode:$("#itemCode").val(),
                    }
                }, 'data');
            }
        };
        $('#btn').on('click', function(){
            alert(123);
            var type = $(this).data('type');
            console.log(type)
            active[type] ? active[type].call(this) : '';
        })
        var url;
        // 操作表
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if(layEvent === 'detail'){ //查看

            } else if(layEvent === 'del'){ //删除

            } else if(layEvent === 'edit'){ //编辑
                // 弹出
                layer.open({
                    type: 1,
                    area: ['800px', '600px'],
                    closeBtn: 0, //不显示关闭按钮
                    shadeClose: true, //点击遮罩关闭
                    content: $("#update"),
                    success:function () {
                        form.val("coupon_form1",data);
                    }
                });
            }
            $("#btnn").click(function() {
                var formData = new FormData($("#coupon_form1")[0]);
                alert(111);
                $.ajax({
                    url: "/orojec/rojecbyId",
                    data: formData,
                    type: "POST",
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        alert("修改成功");
                        window.location.reload();

                    }, error: function () {
                        alert("修改失败");
                    }
                })
            })
        });
    });

</script>
</body>
</html>
