
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
    $("#category").validate({
        rules:{
            categoryname:{
                required: true,
                minlength:4,
                maxlength:20
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
    $("#addbook").validate({
        rules:{
            bookimg:{
                required: true,
                accept:".jpg"
            },
            bookname:{
                required: true,
                minlength:4,
                maxlength:20
            },
            bookauthor:{
                required: true,
                minlength:4,
                maxlength:20
            },
            bookpress:{
                required: true,
                minlength:4,
                maxlength:20
            },
            bookpublishdate:{
                required: true,
                isDate:true
            },
            bookaddress:{
                required: true,
                minlength:4,
                maxlength:20
            },
            bookstock:{
                digits:true ,
                required: true
            },
            bookintroduction:{
                required: true,
                minlength:4,
                maxlength:200
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
    $("#editbook").validate({
        rules:{
            bookimg:{
                accept:".jpg"
            },
            bookname:{
                required: true,
                minlength:2,
                maxlength:20
            },
            bookauthor:{
                required: true,
                minlength:4,
                maxlength:20
            },
            bookpress:{
                required: true,
                minlength:4,
                maxlength:20
            },
            bookpublishdate:{
                required: true,
                isDate:true
            },
            bookaddress:{
                required: true,
                minlength:4,
                maxlength:20
            },
            bookstock:{
                digits:true ,
                required: true
            },
            bookintroduction:{
                required: true,
                minlength:4,
                maxlength:200
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
    
    jQuery.validator.addMethod("isDate", function(value, element){
        var ereg = /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/;
        var r = value.match(ereg);
        if (r == null) {
            return false;
        }
        var d = new Date(r[1], r[3] - 1, r[5]);
        var result = (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[5]);
        return this.optional(element) || (result);
    }, "请输入正确的日期");
});
