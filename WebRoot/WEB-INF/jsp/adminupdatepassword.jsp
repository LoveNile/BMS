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
    <link rel="stylesheet" href="/BMS/static/css/colorpicker.css" />
    <link rel="stylesheet" href="/BMS/static/css/uniform.css" />
    <link rel="stylesheet" href="/BMS/static/css/select2.css" />
    <link rel="stylesheet" href="/BMS/static/css/matrix-style2.css" />
    <link rel="stylesheet" href="/BMS/static/css/matrix-media.css" />
    <link rel="stylesheet" href="/BMS/static/css/overlay.css" />
    <link href="/BMS/static/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    <style type="text/css">
        .flashmessage {
            width: 300px;
            color: white;
            height: 50px;
            z-index: 10000;
            position: absolute;
            background: #2E4358;
            top: 50%;
            left: 50%;
            margin-top: -177px;
            margin-left: -140px;
            border: 1px solid;
            border-radius: 3px;
            border-color: #2E4358;
        }
        .flashmessage p {
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <c:if test="${not empty result}"> 
        <c:if test="${result }">
        <div class="flashmessage" id="flh"><p>修改成功</p></div>
        </c:if>
        <c:if test="${!result }">
        <div class="flashmessage" id="flh"><p>${msg }</p></div>
        </c:if>
        <script>
            setTimeout(function () {
                $("#flh").fadeOut("slow");},1000);
        </script>
    </c:if>
<div id="content">
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="row-fluid">
        <div class="span12">
          <div class="widget-box">
            <div class="widget-title"> <span class="icon"> <i class="icon-info-sign"></i> </span>
              <h5>更改密码</h5>
            </div>
            <div class="widget-content nopadding">
              <form class="form-horizontal" method="post" action="updateadminpassword" name="password_validate" id="password_validate" novalidate="novalidate">
                <div class="control-group">
                  <label class="control-label">旧密码</label>
                  <div class="controls">
                    <input type="password" name="oldpassword" id="pwd" />
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">密码</label>
                  <div class="controls">
                    <input type="password" name="newpassword" id="newpassword" />
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">再次输入</label>
                  <div class="controls">
                    <input type="password" name="retrypassword" id="pwd2" />
                  </div>
                </div>
                <div class="form-actions">
                  <input type="submit" value="Save" class="btn btn-success">
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
    <script src="/BMS/static/js/jquery.min.js"></script> 
    <script src="/BMS/static/js/jquery.ui.custom.js"></script>
    <script src="/BMS/static/js//bootstrap.min.js"></script>
    <script src="/BMS/static/js/jquery.uniform.js"></script> 
    <script src="/BMS/static/js/select2.min.js"></script> 
    <script src="/BMS/static/js/matrix.js"></script> 
    <script src="/BMS/static/js/jquery.validate.js"></script> 
    <script src="/BMS/static/js/alert.js"></script>
    <script src="/BMS/static/js/matrix.form_validation.js"></script>
</html>