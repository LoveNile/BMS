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
            <h5>全部图书信息</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>图片</th>
                  <th>书名</th>
                  <th>作者</th>
                  <th>用户</th>
                  <th>分类</th>
                  <th>图书位置</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody class="studentinfo">
                <c:forEach items="${ask}" var="item" varStatus="status">  
                  <tr>
                    <td>${status.index + 1}</td>
                    <td><img src="/BMS/pic/${item.bookpicpath }" class="img-rounded" style="With:30px;height:30px"></td> 
                    <td>${item.bookname}</td>
                    <td>${item.bookauthor}</td>
                    <td>${item.username}</td>
                    <td>${item.categoryname}</td>  
                    <td>${item.bookaddress}</td> 
                    <td>
                        <button  id="${item.borrowid}" class="btn btn-success allow">同意</button>
                    </td>  
                  </tr>  
                </c:forEach>  
              </tbody>
            </table>
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
    $(".allow").on('click',function(){
        overlay_show();
        var url="/BMS/adminaction/askallow";
        var dataMessage = {borrowid :$(this).attr("id")};
        $.post(url,dataMessage,function(data){
            overlay_hide();
            if(data){
                location.href = "http://localhost:8080/BMS/adminaction/viewbookaskborrow"
            }
        });
    });
    </script>
</html>