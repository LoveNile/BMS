<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Activation successful</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta charset="utf-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="shortcut  icon" type="image/x-icon" href="/BMS/static/ico/favicon.ico" media="screen" />
    <link rel="stylesheet" type="text/css" href="/BMS/static/css/status.css">
  </head>
  <body>
    <div class="main">
        <span class="success-status">${requestScope.activationMsg}</span>
        <a href="http://localhost:8080/BMS/user/login">去登陆</a>
    </div>
    <div class="status-img">
    </div>
  </body>
</html>
