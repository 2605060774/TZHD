$(function () {
    layui.use('form', function(){
        var form = layui.form;
        var token=localStorage.getItem("Token");
        var roleName=localStorage.getItem("roleName");
        if(token!=null) {
            if (roleName=="处长"){
                $.ajax({
                    url: '/business/showApplyInfoByStatus',
                    type: 'post',
                    success:function (data) {
                        if(data.data!=null){
                            $("#wait_audit").hide();
                            $("#ing_audit").show();
                            form.val("apply_form",data.data);
                            $("#seq_id").val(data.data.seqId);
                            $("#apply_form input").attr("style","border:none");
                            $("#apply_form textarea").attr("style","border:none");
                        }
                    }
                })
            }else{
                $.ajax({
                    url: '/business/showApplyInfo',
                    type: 'post',
                    data: {"token":token},
                    success:function (data) {
                        if(data.data!=null){
                            form.val("apply_form",data.data);
                            $("#wait_audit").show();
                            $("#ing_audit").hide();
                            $("#apply_form input").attr("style","border:none");
                            $("#apply_form textarea").attr("style","border:none");
                            console.log(data.data.status)
                            if (data.data.status==0){
                                $("#apply_span").text("审核中");
                            }else if (data.data.status==1){
                                $("#apply_span").text("审核成功");
                            }else {
                                $("#apply_span").text("审核失败");
                            }
                            $("#apply_btn").attr("class","layui-btn layui-btn-disabled");
                            $("#close_btn").hide();
                        }
                    }
                })
            }

        }
        form.render();
        $("#apply_btn").click(function(){
            if(token!=null){
            $("#apply_token").val(token)
            var _data=$("#apply_form").serialize();
            $.ajax({
                url: '/business/addApplyInfo',
                type: 'post',
                data: _data,
                success: function (data) {
                    form.val("apply_form",data.data);
                    $("#wait_audit").show();
                    $("#ing_audit").hide();
                    $("#apply_form input").attr("style","border:none");
                    $("#apply_form textarea").attr("style","border:none");
                    $("#apply_span").text("审核中");
                    $("#apply_btn").attr("class","layui-btn layui-btn-disabled");
                    $("#close_btn").hide();
                }
            })
            }else{
                layer.msg("请先登录！")
                location.reload();
            }
        })
        var itemName=$("#itemName").val();


        $("#audit_btn").click(function () {
            var itemName=$("#itemName").val();
                $("#audit_btn").attr("class","layui-btn layui-btn-disabled");
                $("#audit_fail_btn").hide();
                $("#audit_span").text("已审核");
                var status=1;
            $.ajax({
                url: '/business/updateApplyStatus',
                type: 'post',
                data: {
                    'token':token,
                    'itemName':itemName,
                    'status':status
                },
                success: function (data) {
                    layer.msg("已审核")
                }
            })
        })
        $("#audit_fail_btn").click(function () {
                var itemName=$("#itemName").val();
                $("#audit_btn").attr("class","layui-btn layui-btn-disabled");
                $("#audit_fail_btn").hide();
                $("#audit_span").text("已审核");
                var status=-1;
                $.ajax({
                    url: '/business/updateApplyStatus',
                    type: 'post',
                    data: {
                        'token':token,
                        'itemName':itemName,
                        'status':status
                    },
                    success: function (data) {
                        layer.msg("已审核")
                    }
                })

        })
    });

})