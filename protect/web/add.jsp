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
    <title>添加用户</title>

    <link rel='stylesheet' href='css/bootstrap.min.css'/>
    <script src='js/jquery-3.3.1.min.js'></script>
    <script src='js/bootstrap.min.js'></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_zh.js"></script>
    <style>
        .error{
            border-color: red;
        }
    </style>

    <script>
        $.validator.addMethod("cellphone",function (value,element,param){
            let mobile = /^1[3-9][0-9]-[0-9]{4}-[0-9]{4}$/
            return mobile.test(value);
        })
        $(function () {
            $("#fromId").validate({
                rules:{
                    name:"required",
                    gender:"required",
                    formatBirthday:"required",
                    mobile:"cellphone",
                    email:"required"
                },
                message:{
                    name:{
                        required:"请输入姓名"
                    },
                    gender:"请选择性别",
                    formatBirthday:"请输入生日",
                    mobile:"手机号不合法",
                    email:"请输入有效的邮箱地址"
                },
                submitHandler:function () {
                    return confirm("是否提交？");
                }
            })
        })
    </script>
</head>

<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">添加联系人</h3>
    <form action="add_contact" method="post" id="fromId">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="m"/>男
            <input type="radio" name="gender" value="f"/>女
            <label id="gender-error" class="error" for="gender" ></label>
        </div>
        <div class="form-group">
            <label for="formatBirthday">生日：</label>
            <input type="text" class="form-control" id="formatBirthday" name="formatBirthday" placeholder="请输入生日(yyyy-MM-dd)"/>
        </div>

        <div class="form-group">
            <label for="birthplace">籍贯：</label>
            <select name="birthplace" class="form-control">
                <option value="广州">广州</option>
				<option value="上海">上海</option>
                <option value="北京">北京</option>
            </select>
        </div>

        <div class="form-group">
            <label for="mobile">手机：</label>
            <input type="text" class="form-control" name="mobile" placeholder="请输入手机号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
