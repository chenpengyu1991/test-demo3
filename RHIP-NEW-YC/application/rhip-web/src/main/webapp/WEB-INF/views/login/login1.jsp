<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>永城市全民健康信息平台</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js"></script>
    <script src="${pageContext.request.contextPath}/js/layui/layui.js" charset="utf-8"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/cookie.js"></script>

</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">永城市全民健康信息平台登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" >
            <input name="userName" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script>
        $(function  () {
            layui.use('form', function(){
              var form = layui.form;
               layer.msg('玩命卖萌中', function(){
                 //关闭后的操作
                 });
              //监听提交
              form.on('submit(login)', function(data) {
            	  $.ajax({
                      url:'${pageContext.request.contextPath}/access/login',
                      data:data.field,
                      dataType:'text',
                      type:'post',
                      success:function (data) {
                          if (data == '1'){
                              location.href = "${pageContext.request.contextPath}/access/index";
                          }else{
                              layer.msg('登录名或密码错误');
                          }
                      }
                  })
                
                return false;
              });
            });
        })

        
    </script>

    
    <!-- 底部结束 -->
</body>
</html>