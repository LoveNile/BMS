
$(document).ready(function(){
    $("#userinfoedit").validate({
        rules:{
            adminname:{
                required: true,
                minlength:6,
                maxlength:20
            },
            adminemail:{ 
                required: true,
                email: true,
            },
            adminphone:{
                digits:true
            }
        }
    });
    $("#password_validate").validate({
        rules:{
            oldpassword:{
                required: true,
                minlength:6,
                maxlength:20
            },
            newpassword:{
                required: true,
                minlength:6,
                maxlength:20
            },
            retrypassword:{
                required:true,
                minlength:6,
                maxlength:20,
                equalTo:"#newpassword"
            }
        },
        errorClass: "help-inline",
        errorElement: "span",
        highlight:function(element, errorClass, validClass) {
            $(element).parents('.control-group').addClass('error');
        },
        unhighlight: function(element, errorClass, validClass) {
            $(element).parents('.control-group').removeClass('error');
            $(element).parents('.control-group').addClass('success');
        }
    });
});
