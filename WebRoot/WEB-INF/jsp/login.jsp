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

        <link rel="shortcut  icon" type="image/x-icon" href="/BMS/static/ico/favicon.ico" media="screen" />
        <link rel="stylesheet" href="/BMS/static/css/reset.css">
        <link rel="stylesheet" href="/BMS/static/css/supersized.css">
        <link rel="stylesheet" href="/BMS/static/css/style.css">
        <link rel="stylesheet" href="/BMS/static/css/alert.css">
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
        
        <div class="mainregister" style="display:none">
            <h1>Quick Register</h1>
            <form action="" method="post">
                <div>
                    <input type="text" name="registeremail" class="registerusername" placeholder="Register Username" autocomplete="off"/>
                </div>
                <div>
                    <input type="text" name="registeremail" class="registeremail" placeholder="Register Email" autocomplete="off"/>
                </div>
                <div>
                    <input type="password" name="password" class="registerpassword" placeholder="Register Password" oncontextmenu="return false" onpaste="return false" />
                </div>
                <button id="registerbtn" type="button">Register</button>
                <button id="tologin" class="tologin" type="button">To Login</button>
            </form>
        </div>
        <div class="mainforget" style="display:none">
            <h1 class="hforget">Forget Password</h1>
                <div>
                    <input type="text" name="forgetusername" class="forgetusername" placeholder="Username" oncontextmenu="return false" />
                    <button id="emailbtn">Send Email</button>
                </div>
                <div class="verificationdiv" style="display:none">
                    <input type="text" name="verificationcode" class="verificationcode" placeholder="Verification code" oncontextmenu="return false" />
                    <button id="verificationbtn">Verification</button>
                </div>
                <div class="newpassworddiv">
                    <input type="password" name="newpassword" class="newpassword" placeholder="New Password" oncontextmenu="return false" />
                </div>
                <button id="forgetbtn" type="button">OK</button>
                <button id="forgetlogin" class="tologin" type="button">To Login</button>
        </div>
        <div class="alert" style="display:none">
            <h2>消息</h2>
            <div class="alert_con">
                <p id="ts"></p>
                <p style="line-height:70px"><a class="btnalert">确定</a></p>
            </div>
        </div>
        <div class="overlay "></div>
        <!-- Javascript -->
        <script src="/BMS/static/js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="/BMS/static/js/alert.js"></script>
        <script src="/BMS/static/js/supersized.3.2.7.min.js"></script>
        <script src="/BMS/static/js/supersized-init.js"></script>
        <script src="/BMS/static/js/register.js"></script>
        <script src="/BMS/static/js/forgetpassword.js"></script>
        <script>
        var u = $("input[name=username]");
        var p = $("input[name=password]");
        $("#submit").on('click',function(){
            overlay_show();
            if(u.val().trim() == '' || p.val().trim() =='') {
                $("#ts").html("用户名或密码不能为空~");
                is_show();
                return false;
            }
            else {
                var regEmail = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
                var reg = /^[\w\u4e00-\u9fa5][\w\u4e00-\u9fa5]*$/;
                if(!reg.exec(u.val().trim()) && !regEmail.exec(u.val().trim())) {
                    $("#ts").html("用户名错误");
                    is_show();
                    return false;
                }
                else {
                    var url = '/BMS/user/login';
                    var dataMessage = {username : $(".username").val(), password : $(".password").val()};
                    $.post(url,dataMessage,function(data){
                        if(!data.UserLegal){
                            $("#ts").html(data.LoginMessage);
                            is_show();
                        } else {
                            location.href = data.LoginMessage;
                        }
                    });
                }
            }
        });
        window.onload = function() {
            $(".connect p").eq(0).animate({"left":"0%"}, 600);
            $(".connect p").eq(1).animate({"left":"0%"}, 400);
        };
        $(".forget").click(function(){
            $(".page-container").css("display","none");
            $(".mainforget").animate({opacity: "show" }, 1500);
        });
        $(".register").click(function(){
            $(".mainregister").animate({opacity: "show" }, 1500);
            $(".page-container").css("display","none");
        });
        $(".tologin").click(function(){
            $(".page-container").animate({opacity: "show" }, 1500);
            $(".mainforget").css("display","none");
            $(".mainregister").css("display","none");
        });
        </script>
    </body>

</html>

