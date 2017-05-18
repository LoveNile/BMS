<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut  icon" type="image/x-icon" href="/BMS/static/ico/admin.ico" media="screen" />
    <link rel="stylesheet" href="/BMS/static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/BMS/static/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="/BMS/static/css/uniform.css" />
    <link rel="stylesheet" href="/BMS/static/css/select2.css" />
    <link rel="stylesheet" href="/BMS/static/css/matrix-style2.css" />
    <link rel="stylesheet" href="/BMS/static/css/matrix-media.css" />
    <link rel="stylesheet" href="/BMS/static/css/overlay.css" />
    <link href="/BMS/static/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
    <div id="content">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>全部用户信息</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>用户名</th>
                  <th>性别</th>
                  <th>邮箱</th>
                  <th>电话</th>
                  <th>账户状态</th>
                  <th>学号</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody class="userinfo">
                <c:forEach items="${AllUser}" var="item" varStatus="status">  
                  <tr >  
                    <td>${item.username}</td> 
                    <c:choose>
                        <c:when test="${item.gender}">
                            <td>男</td> 
                        </c:when>
                        <c:otherwise>
                            <td>女</td> 
                        </c:otherwise>
                    </c:choose>
                    <td>${item.email}</td>
                    <td>${item.phone}</td>
                    <c:choose>
                        <c:when test="${item.status}">
                            <td>激活</td> 
                        </c:when>
                        <c:otherwise>
                            <td>未激活</td> 
                        </c:otherwise>
                    </c:choose>
                    <td>${item.studentnumber}</td>  
                    <td><button id="${item.studentnumber}" class="btn btn-info student" data-toggle="modal" data-target=".student-info">查看学生信息</button>
                        <button  id="${item.userid}" class="btn btn-danger deluser">删除</button>
                    </td>  
                  </tr>  
                </c:forEach>  
              </tbody>
            </table>
          </div>
        </div>
     </div>
      <div class="modal fade student-info" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog" role="document" aria-hidden="true">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Student Infomation</h4>
                    </div>
                    <div class="modal-body">
                        <ul class="student-info-ul">
                            
                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay "></div>
</body>
    <script src="/BMS/static/js/jquery.min.js"></script> 
    <script src="/BMS/static/js/jquery.ui.custom.js"></script> 
    <script src="/BMS/static/js/bootstrap.min.js"></script> 
    <script src="/BMS/static/js/bootstrap.js"></script> 
    <script src="/BMS/static/js/jquery.uniform.js"></script> 
    <script src="/BMS/static/js/select2.min.js"></script> 
    <script src="/BMS/static/js/jquery.dataTables.min.js"></script> 
    <script src="/BMS/static/js/matrix.js"></script> 
    <script src="/BMS/static/js/matrix.tables.js"></script>
    <script src="/BMS/static/js/alert.js"></script>
    <script type="text/javascript">
    $(".student").on('click',function(){
        $(".student-info-ul").empty();
        if($(this).attr("id")!= null && $(this).attr("id") != '') {
            var url="/BMS/adminaction/viewstudentinfo";
            var dataMessage = {studentnumber :$(this).attr("id")};
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
        } else {
            $(".student-info-ul").append(
                    "<li><span>未绑定学号</span></li>"
                    );
        }
    });
    $(".deluser").on('click',function(){
        overlay_show();
        var url="/BMS/adminaction/deluser";
        var dataMessage = {userid :$(this).attr("id")};
        $.post(url,dataMessage,function(data){
            overlay_hide();
            if(data){
                location.href = "http://localhost:8080/BMS/adminaction/alluser"
            }
        });
    });
    function formatedate(todate) {
        date = new Date(todate);
        var datetime = date.getFullYear()
                + "-"// "年"
                + ((date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : "0"
                        + (date.getMonth() + 1))
                + "-"// "月"
                + (date.getDate() < 10 ? "0" + date.getDate() : date
                        .getDate());
        return datetime;
    };
    </script>
</html>