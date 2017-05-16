<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BMS Management</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut  icon" type="image/x-icon" href="/BMS/static/ico/admin.ico" media="screen" />
    <link rel="stylesheet" href="/BMS/static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/BMS/static/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="/BMS/static/css/matrix-login.css" />
    <link href="/BMS/static//css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    <style type="text/css">
        input{
            font-family: "Microsoft Yahei";
        }
        .control-label{
            color: #B2DFEE;
            padding-left: 4px;
        }
    </style>
</head>
<body onkeydown="keydown()">
    <div id="loginbox">  
        <div class="control-group normal_text"> 
            <h2 style="color:#B2DFEE;font-size:28px;">图书管理系统平台</h2>
            <span style="font-size:14px;color:gray;">版权所有 &copy; 河南工业大学 2017-2018</span>
        </div>           
        <form id="loginform" class="form-vertical" action="http://themedesigner.in/demo/matrix-admin/index.html">
            <div class="control-group">
                <label class="control-label">登陆账号</label>
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_lg"><i class="icon-user" style="font-size:16px;"></i></span><input type="text" class="adminname" value="admin" />
                    </div>
                </div>
            </div>
            <div class="control-group2">
                <label class="control-label">登陆密码</label>
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_ly"><i class="icon-lock" style="font-size:16px;"></i></span><input class="adminpassword" type="password" />
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <span class="pull-left"><a href="#" class="flip-link btn btn-info" id="to-recover">忘记密码？</a></span>
                <span class="pull-right"><input type="button" id="checkBtn" onclick="checkLogin()" class="btn btn-success" style="width:335px;" value=" 登&nbsp;&nbsp;&nbsp;&nbsp;录"/></span>
            </div>
            <div class="control-group normal_text">
                <div style="font-size:14px;color:gray;">推荐使用webkit内核浏览器，如chrome等</div>
            </div>
        </form>
        

        <form id="recoverform" action="#" class="form-vertical" style="padding-top:10px;">
            <label class="control-label">登陆账号</label>
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-user" style="font-size:16px;"></i></span><input type="text" name="re_username" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">新密码</label>
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_ly"><i class="icon-lock" style="font-size:16px;"></i></span><input type="password" name="re_password"/>
                    </div>
                </div>
            </div>
            <div class="control-group" style="padding-top:0px;">
                <label class="control-label">确认新密码</label>
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_ly"><i class="icon-lock" style="font-size:16px;"></i></span><input type="password" name="re_confirmpassword" />
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <span class="pull-left"><a href="#" class="flip-link btn btn-success" id="to-login">&laquo; 返回登录</a></span>
                <span class="pull-right"><a id="changePwd" class="btn btn-info" style="width:310px;">重置密码</a></span>
            </div>
            <div class="control-group normal_text">
                <div style="font-size:14px;color:gray;">推荐使用webkit内核浏览器，如chrome等</div>
            </div>
        </form>
    </div>
    <script src="/BMS/static/js/jquery-1.10.2.min.js"></script>  
    <script src="/BMS/static/js/matrix.login.js"></script> 
</body>

</html>
