$(".editusersuccess").on("click",function(){
    var username = $("#username").val().trim();
    var studentnumber = $("#studentnumber").val().trim();
    var useremail = $("#useremail").val().trim();
    var gender = $("#gender").val();
    var regUsername = /^[\w\u4e00-\u9fa5][\w\u4e00-\u9fa5]*$/;
    var regEmail = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
    var regstudentnumber = /^\d{8,12}$/;
    var isgender = true;
    if(gender != "男" && gender != "女") {
        isgender = false;
    }
    overlay_show();
    if(isgender && regUsername.exec(username) && regEmail.exec(useremail) && regstudentnumber.exec(studentnumber)) {
        var url = "/BMS/book/usereditinfo";
        var dataMsg = {username:username,studentnumber:studentnumber,email:useremail,phone:$("#phone").val(),gender:gender,birthday:$("#birthday").val()};
        $.post(url,dataMsg, function(data){
            $("#ts").html(data.editmsg);
            borrow_show();
            if(data.editresult) {
                $(".alert h2").css("background-color","#449d44");
            } else {
                $(".alert h2").css("background-color","#c9302c");
            }
        });
    } else {
        borrow_show();
        $(".alert h2").css("background-color","#c9302c");
        $("#ts").html("请按照规范修改！");
    }
});
$(".editimg").click(function(){
    $(".imgfilepath").click();
});
$(".imgfilepath").on("change",function(){
    overlay_show();
    var imgname = $("#file").val();
    if(checkPhoto(imgname)){
        $.ajaxFileUpload({
            url: '/BMS/book/editimg', //服务器端请求地址  
            secureuri: false, //是否需要安全协议，一般设置为false  
            fileElementId: 'file', //文件上传域的ID  
            dataType: 'json', //返回值类型 一般设置为json  
            enctype:'multipart/form-data',//注意一定要有该参数  
            success: function (data, status)  //服务器成功响应处理函数  
            {  
                overlay_hide();
                if(data.editresult){
                    $(".editimg").attr("src","/BMS/img/user/"+data.editmsg)
                    $(".navimg").attr("src","/BMS/img/user/"+data.editmsg)
                } else {
                    errormsg("请联系管理员！");
                }       //data是从服务器返回来的值  
               
            }
        });
    }
});
function checkPhoto(filename){
    var type="";
    if(filename!=''){
       type=filename.match(/^(.*)(\.)(.{1,8})$/)[3];
       type=type.toUpperCase();
   }
    if(type!="JPEG" && type!="PNG" && type!="JPG" && type!="GIF"){
        alert("上传图片类型错误"); 
        return false;
     } 
    return true;
} 