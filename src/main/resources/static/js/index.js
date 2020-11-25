$(function () {
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
    loadSecondRes();
})
// 加载三级菜单
// function loadThirdRes(id) {
//     $.ajax({
//         type:"post",
//         url:"/org/loadThirdMenuById",
//         data:{"id":id},
//         dataType:"json",
//         error:function(error){
//             console.log("查询失败！");
//         },success:function(data){
//                 var str=""
//                 $(data).each(function(a,b){
//                     str+="<dd><a href=\"javascript:;\" >"+b.resName+"</a></dd>"
//                     for(var i=0;i<b.resList.length;i++){
//                             str+="<dd><a href='"+b.resList[i].info+"' style=\"font-size:10px\">"+b.resList[i].resName+"</a></dd>"
//                     }
//                 });
//                 $("#dl"+id).html(str);
//         }
//     });
// }
// 加载二级菜单
function loadSecondRes() {
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
                        str+="<dl id='dl"+b.perList[i].perId+"' class=\"layui-nav-child\"><a href="+b.path+">"+b.perList[i].pname+"</a></dl>"
                    }
                }
                str+="</li>"
            });
                $("#nav").html(str);
                draw();

        }
    });
}
        /*登录*/
        function login() {
            layer.open({
                type: 1,
                area: ['600px', '360px'],
                title: ['用户登录', 'font-size:18px;background-color: #393D49;color:#fff!important'],
                shadeClose: true, //点击遮罩关闭
                content:''
            });
        }
        /*注销*/
        function logout() {
                layer.confirm('是否确定退出系统？', {
                        btn: ['是','否'] ,//按钮
                        icon:2,
                    },
                    function(){
                        location.href="/log/logout";
                    });
        }
       /*渲染*/
        function draw() {
            layui.use('element', function () {
                var element = layui.element;
                var layFilter = $("#nav").attr('lay-filter');
                element.render('nav', layFilter);
            })
        }
