    $("#emailbtn").on('click', function(){
        overlay_show();
        var reg = /^[\w\u4e00-\u9fa5][\w\u4e00-\u9fa5]*$/;
        var username = $(".forgetusername").val().trim();
        if(!reg.exec(username)) {
            $("#ts").html("用户名不符合规范！");
            is_show();
            return false;
        } else {
            var url = '/BMS/user/forget';
            var dataMessage = {username : username};
            $.post(url,dataMessage,function(data){
                if(data.ForgetResult){
                    $("#ts").html(data.ForgetMsg);
                    is_show();
                    $(".verificationdiv").show().animate({"top":"45%"}, 300);
                } else {
                    $("#ts").html(data.ForgetMsg);
                    is_show();
                }
            });
        }
    });
    $("#verificationbtn").on('click', function(){
        overlay_show();
        var number = $(".verificationcode").val().trim();
        if(number == null) {
            $("#ts").html("验证码不能为空！");
            is_show();
            return false;
        } else {
            var url = '/BMS/user/verify';
            var dataMessage = {verificationcode : number};
            $.post(url,dataMessage,function(data){
                if(data) {
                    $(".newpassworddiv").show().animate({"top":"45%"}, 300);
                    $("#ts").html("验证码正确！");
                    is_show();
                } else {
                    $("#ts").html("验证码错误！");
                    is_show();
                }
            });
        }
    });
    $("#forgetbtn").on('click', function(){
        overlay_show();
        if(!$(".newpassworddiv").is(":hidden")){
            var newpassword = $(".newpassword").val().trim();
            if(newpassword == null) {
                $("#ts").html("密码不能为空！");
                is_show();
                return false;
            } else {
                var url = '/BMS/user/updatepassword';
                var dataMessage = {password : newpassword};
                $.post(url,dataMessage,function(data){
                    if(data) {
                        $("#ts").html("修改密码成功！");
                        is_show();
                        $(".page-container").animate({opacity: "show" }, 1500);
                        $(".mainforget").css("display","none");
                    } else {
                        $("#ts").html("修改密码失败！");
                        is_show();
                        $(".verificationdiv").hide();
                        $(".newpassworddiv").hide();
                    }
                });
            }
        } else {
            $("#ts").html("按步骤进行！");
            is_show();
        }
    });