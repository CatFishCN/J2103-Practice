<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<% String path = request.getContextPath(); %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <link rel='stylesheet' href='css/bootstrap.min.css'/>
    <script src='js/jquery-3.3.1.min.js'></script>
    <script src='js/bootstrap.min.js'></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_zh.js"></script>
    <script>
        $(function (){
            // $("#fromId").validate({
            //     rules:{
            //         user:"required",
            //         password:{
            //             required:true,
            //             number:true
            //         }
            //     },
            //     message:{
            //         user:"请输入用户名",
            //         password: {
            //             required: "请输入密码",
            //             number: "密码必须为合法数字"
            //         }
            //     },
            //     submitHandler:function () {
            //         return confirm("是否提交？");
            //     }
            // })
            if (${result == 0}){
                $(".alert").prop("style","display:block");
            }
        })

    </script>
</head>

<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="login_contact" method="post" id="fromId">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="user" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

<%--        <div class="form-inline">--%>
<%--            <label for="vcode">验证码：</label>--%>
<%--            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码"--%>
<%--                   style="width: 120px;"/>--%>
<%--            <a href="javascript:refreshCode()"><img src="vcode" title="看不清点击刷新" id="vcode"/></a>--%>
<%--        </div>--%>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn-default btn-primary" type="submit" value="登录" >
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert" style="display: none">
        <button type="button" class="close" data-dismiss="alert">
            <span>&times;</span></button>
        <strong>登录失败!</strong>
    </div>
</div>
</body>
</html>