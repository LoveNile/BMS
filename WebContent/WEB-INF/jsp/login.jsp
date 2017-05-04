<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE !DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMS Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="/BMS/static/css/reset.css">
        <link rel="stylesheet" href="/BMS/static/css/supersized.css">
        <link rel="stylesheet" href="/BMS/static/css/style.css">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body oncontextmenu="return false">

        <div class="page-container">
            <h1>Login</h1>
            <form action="login" method="post" class="loginsubmit">
                <div>
                    <input type="text" name="username" class="username" placeholder="Username" autocomplete="off"/>
                </div>
                <div>
                    <input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" />
                </div>
                <button id="submit" type="button">Sign in</button>
                <div class="forget">
                  <a href="#">Forget password?</a>
                </div>
                <div class="register">
                  <a href="#">Register</a>
                </div>
            </form>
            <div class="connect">
                <p>This moment will nap, you will have a dream; But this moment study,you will interpret a dream.</p>
                <p style="margin-top:20px;">此刻打盹，你将做梦；而此刻学习，你将圆梦。</p>
            </div>
        </div>
        <div class="alert" style="display:none">
            <h2>消息</h2>
            <div class="alert_con">
                <p id="ts"></p>
                <p style="line-height:70px"><a class="btn">确定</a></p>
            </div>
        </div>
        <div class="registerdiv" style="display:none">
            <div class="mainregister">
                <h1>Quick Register</h1>
                <form action="" method="post">
                    <div>
                        <input type="text" name="registeremail" class="registeremail" placeholder="Register Email" autocomplete="off"/>
                    </div>
                    <div>
                        <input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" />
                    </div>
                    <button id="registerbtn" type="button">Register</button>
                    <button id="tologin" class="tologin" type="button">To Login</button>
                </form>
            </div>
        </div>
        <div class="forgetdiv" style="display:none">
            <div class="mainforget">
                <h1 class="hforget">Forget Password</h1>
                <form action="" method="post">
                    <div>
                        <input type="text" name="username" class="username" placeholder="Username" autocomplete="off"/>
                    </div>
                    <div>
                        <input type="text" name="registeremail" class="registeremail" placeholder="Register Email" oncontextmenu="return false" onpaste="return false" />
                    </div>
                    <button id="forgetbtn" type="button">OK</button>
                    <button id="tologin" class="tologin" type="button">To Login</button>
                </form>
            </div>
        </div>
            
        <!-- Javascript -->
        <script src="/BMS/static/js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="/BMS/static/js/supersized.3.2.7.min.js"></script>
        <script src="/BMS/static/js/supersized-init.js"></script>
        <script>
        $(".btn").click(function(){
            is_hide();
        });
        var u = $("input[name=username]");
        var p = $("input[name=password]");
        $("#submit").on('click',function(){
            if(u.val() == '' || p.val() =='') {
                $("#ts").html("用户名或密码不能为空~");
                is_show();
                return false;
            }
            else {
                var reg = /^[0-9A-Za-z]+$/;
                if(!reg.exec(u.val())) {
                    $("#ts").html("用户名错误");
                    is_show();
                    return false;
                }
                else {
                    var url = '/BMS/user/login';
                    var dataMessage = {username : $(".username").val(), password : $(".password").val()};
                    $.post(url,dataMessage,function(data){
                        alert(data);
                    });
                }
            }
        });
        window.onload = function() {
            $(".connect p").eq(0).animate({"left":"0%"}, 600);
            $(".connect p").eq(1).animate({"left":"0%"}, 400);
        };
        function is_hide(){ $(".alert").animate({"top":"-40%"}, 300); };
        function is_show(){ $(".alert").show().animate({"top":"45%"}, 300); };
        $(".forget").click(function(){
            $(".page-container").css("display","none");
            $(".forgetdiv").animate({opacity: "show" }, 2000);
        });
        $(".register").click(function(){
            $(".registerdiv").animate({opacity: "show" }, 2000);
            $(".page-container").css("display","none");
        });
        $(".tologin").click(function(){
            $(".page-container").animate({opacity: "show" }, 2000);
            $(".forgetdiv").css("display","none");
            $(".registerdiv").css("display","none");
        });
        </script>
    </body>

</html>

