    $("#registerbtn").on('click',function(){
        overlay_show();
        var registerUsername = $(".registerusername").val().trim();
        var registerEmail = $(".registeremail").val().trim();
        var registerPassword = $(".registerpassword").val().trim();
        var regUsername = /^[\w\u4e00-\u9fa5][\w\u4e00-\u9fa5]*$/;
        var regEmail = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
        if(registerUsername == '' || registerEmail == '' || registerPassword == ''){
            $("#ts").html("信息不能为空！");
            is_show();
            return false;
         }else if(!regUsername.exec(registerUsername) && !regEmail.exec(registerEmail)) {
            $("#ts").html("用户名和邮箱不符合规范！");
            is_show();
            return false;
        } else if (!regUsername.exec(registerUsername)){
            $("#ts").html("用户名不符合规范！");
            is_show();
            return false;
        } else if (!regEmail.exec(registerEmail)) {
            $("#ts").html("邮箱不符合规范！");
            is_show();
            return false;
        } else {
            var url = '/BMS/user/register';
            var dataMessage = {registerusername : registerUsername,registeremail : registerEmail,registerpassword : registerPassword};
            $.post(url,dataMessage,function(data){
                if(!data.RegisterResult){
                    $("#ts").html(data.RegisterMsg);
                    is_show();
                } else {
                    $("#ts").html(data.RegisterMsg);
                    is_show();
                }
            });
        }
    });
