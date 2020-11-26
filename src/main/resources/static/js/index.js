    $(function () {
        layui.use('element', function(){
            var element = layui.element;
            element.init();
        });
        layui.use('form', function(){
            var form = layui.form;
            form.render();
        });
        loadNavList();
        $(document).on('click','.path',function(){
            var path = $(this).attr("name");
            $("#iFrame").attr("src",path).ready();
        })
        $("#login_btn").click(function () {
            var username=$("#login_userName").val();
            var password=$("#login_password").val();
            $.ajax({
                type:"post",
                url:"/user/login",
                data:{username:username,password:password},
                dataType:"json",
                success:function(data){
                    localStorage.setItem("Token",data.data);
                    layer.msg("登录成功！");
                    location.reload();
                }
            })
        })
        var token=localStorage.getItem("Token");
        if (token!=null){
            $("#login_span").text("已登录");
        }
    })
//  加载二级菜单
    function loadNavList() {
    var token=localStorage.getItem("Token");
    if (token==null){
        layer.msg("请先登录！")
        $("#nav").html("");
    }else{
        $.ajax({
            type:"post",
            url:"/user/loadNavList",
            dataType:"json",
            error:function(error){
                console.log("查询失败！");
            },success:function(data){
                $("#nav").find('span.layui-nav-bar').remove();
                var str="";
                $(data.data).each(function(a,b){
                    str+="<li class=\"layui-nav-item \" id='"+b.perId+"' ><a href='javascript:;'>"+b.pname+"</a>";
                    if(b.perList!=null){
                        for (var i = 0; i < b.perList.length; i++) {
                            str+="<dl id='dl"+b.perList[i].perId+"' class=\"layui-nav-child\"><a href='javascript:;' name='"+b.perList[i].path+"' class='path'>"+b.perList[i].pname+"</a></dl>"
                        }
                    }
                    str+="</li>"
                });
                    $("#nav").html(str);
                    draw();

            }
        });
    }
    }


        /*登录*/
        function login() {
            layer.open({
                type: 1,
                area: ['600px', '360px'],
                title: ['用户登录', 'font-size:18px;background-color: #393D49;color:#fff!important'],
                shadeClose: true,
                content:$("#login_model")
            });
        }

        /*注销*/
        function logout() {
                layer.confirm('是否确定退出系统？', {
                        btn: ['是','否'] ,
                        icon:2,
                    },function () {
                    localStorage.clear();
                    location.reload();
                })
        }
       /*渲染*/
        function draw() {
            layui.use('element', function () {
                var element = layui.element;
                var layFilter = $("#nav").attr('lay-filter');
                element.render('nav', layFilter);
            })
        }
