function getuserinfo(){
    $(".user-info-ul").empty();
    var url="/BMS/user/getuserinfo";
    var dataMessage = null;
    $.post(url,dataMessage,function(data){
        $(".user-info-ul").append(
            "<li>"+
                "<span class='user-a'>Avatar:</span>"+
                "<img src='5.jpg' class='img-circle'>"+
            "</li>"+
            "<li>"+
                "<span class='user-a'>Username:</span>"+
                "<span class='user-b'>"+data.username+"</span>"+
            "</li>"+
            "<li>"+
                "<span class='user-a'>Phone:</span>"+
                "<span class='user-b'>"+data.phone+"</span>"+
            "</li>"+
            "<li>"+
                "<span class='user-a'>Email:</span>"+
                "<span class='user-b'>"+data.email+"</span>"+
            "</li>"+
            "<li>"+
                "<span class='user-a'>Gender:</span>"+
                "<span class='user-b'>"+data.gender+"</span>"+
            "</li>"+
            "<li>"+
                "<span class='user-a'>Birthday:</span>"+
                "<span class='user-b'>"+formatedate(data.birthday)+"</span>"+
            "</li>"+
            "<li>"+
                "<span class='user-a'>RegisterTime:</span>"+
                "<span class='user-b'>"+formatedate(data.registertime)+"</span>"+
            "</li>"+
            "<li>"+
                "<span class='user-a'>StudentNumber:</span>"+
                "<span class='user-b'>"+data.studentnumber+"</span>"+
            "</li>"+
            "<li>"+
                "<button type='button' class='btn btn-warning'>Modify</button>"+
                "<button type='button' class='btn btn-success student' data-toggle='modal' data-target='.student-info'>Student Info</button>"+
            "</li>"
        );
        $(".student").on('click',function(){
            $(".student-info-ul").empty();
            var url="/BMS/user/getstudentinfo";
            var dataMessage = null;
            $.post(url,dataMessage,function(data){
                $(".student-info-ul").append(
                        "<li><span>学号:</span><span>"+data.studentnumber+"</span></li>"+
                        "<li><span>姓名:</span><span>"+data.studentname+"</span></li>"
                );
                if(data.gender){
                    $(".student-info-ul").append(
                            "<li><span>性别:</span><span>男</span></li>"
                            );
                } else {
                    $(".student-info-ul").append(
                            "<li><span>性别:</span><span>女</span></li>"
                            );
                }
                $(".student-info-ul").append(
                        "<li><span>电话:</span><span>"+data.phone+"</span></li>"+
                        "<li><span>邮箱:</span><span>"+data.email+"</span></li>"+
                        "<li><span>学院:</span><span>"+data.speciality+"</span></li>"+
                        "<li><span>班级:</span><span>"+data.studentclass+"</span></li>"+
                        "<li><span>入学时间:</span><span>"+formatedate(data.studententeryear)+"</span></li>"
                        );
                if(data.studentstatus){
                    $(".student-info-ul").append(
                            "<li><span>在校状态:</span><span>在校</span></li>"
                            );
                } else {
                    $(".student-info-ul").append(
                            "<li><span>在校状态:</span><span>离校</span></li>"
                            );
                }
                
            });
        });
    });
    
}