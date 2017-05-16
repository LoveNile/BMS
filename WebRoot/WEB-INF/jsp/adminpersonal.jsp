<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
 <div id="content">
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box" style="left: 280px;">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
            <div class="control-group">
              <label class="control-label">姓名:</label>
              <div class="controls">
                <input type="text" class="span11" value="${admininfo.adminname }" readonly="readonly"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">邮箱 :</label>
              <div class="controls">
                <input type="text" class="span11" value="${admininfo.adminemail }" readonly="readonly" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">电话：</label>
              <div class="controls">
                <input type="text"  class="span11" value="${admininfo.adminphone }" readonly="readonly"  />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">身份证号 :</label>
              <div class="controls">
                <input type="text" class="span11" value="${admininfo.admincard }" readonly="readonly" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">地址:</label>
              <div class="controls">
                <input type="text" class="span11" value="${admininfo.adminaddress }" readonly="readonly"/>
            </div>
            </div>
            <div class="control-group">
              <label class="control-label">描述</label>
              <div class="controls">
                <textarea class="span11" readonly="readonly" >${admininfo.adminremarks }</textarea>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
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
</html>