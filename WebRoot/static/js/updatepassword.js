var oldpasswordisright;
$("#oldpassword").on("change",function(){
    var url = '/BMS/user/verifypassword';
    var dataMessage = {password : $("#oldpassword").val()}
    $.post(url,dataMessage,function(data){
        $(".spanoldpassword").css("color","#fff");
        if(data){
            oldpasswordisright = true;
            $(".spanoldpassword").css("background-color","#449d44");
        } else {
            oldpasswordisright = false;
            $(".spanoldpassword").css("background-color","#d9534f");
        }
    });
});
$("#newpassword").on("change",function(){
    var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
    var newpassword = $("#newpassword").val().trim();
    $(".spannewpassword").css("color","#fff");
    if(reg.exec(newpassword) && (newpassword != $("#oldpassword").val())) {
        oldpasswordisright = true;
        $(".spannewpassword").css("background-color","#449d44");
    } else {
        oldpasswordisright = false;
        $(".spannewpassword").css("background-color","#d9534f");
    }
});
$("#againpassword").on("change",function(){
    var newpassword = $("#newpassword").val().trim();
    var againpassword = $("#againpassword").val().trim();
    $(".spanagain").css("color","#fff");
    $(".gotoshowbook").removeClass("btn-default");
    if(newpassword == againpassword){
        $(".spanagain").css("background-color","#449d44");
        $(".gotoupdatepassword").removeClass("btn-danger");
        $(".gotoupdatepassword").addClass("btn-success");
        $(".gotoupdatepassword").on("click",function(){
        if(oldpasswordisright){
            overlay_show();
            var url = '/BMS/user/updatepassword';
            var dataMessage = {password : newpassword};
            $.post(url,dataMessage,function(data){
                borrow_show();
                if(data){
                    $(".alert h2").css("background-color","#449d44");
                    $("#ts").html("修改成功！");
                }else{
                    $(".alert h2").css("background-color","#c9302c");
                    $("#ts").html("修改失败,请联系管理员！");
                }
            });
        }
    });
    } else {
        $(".spanagain").css("background-color","#d9534f");
        $(".gotoupdatepassword").addClass("btn-danger");
        $(".gotoupdatepassword").removeClass("btn-success");
    }
});
$(".gotoreset").on("click",function(){
    resetpassword()
});
function resetpassword(){
    $("#oldpassword").val("");
    $("#newpassword").val("");
    $("#againpassword").val("");
    $(".spannewpassword").css("color","");
    $(".spannewpassword").css("background-color","");
    $(".spanoldpassword").css("color","");
    $(".spanoldpassword").css("background-color","");
    $(".spanagain").css("color","");
    $(".spanagain").css("background-color","");
    $(".gotoupdatepassword").removeClass("btn-danger");
    $(".gotoupdatepassword").removeClass("btn-success");
    oldpasswordisright = false;
}