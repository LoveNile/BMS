<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>BMS Books Info</title>
        <link rel="shortcut  icon" type="image/x-icon" href="/BMS/static/ico/favicon.ico" media="screen"  />
        <link rel="stylesheet" type="text/css" href="/BMS/static/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="/BMS/static/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/BMS/static/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" type="text/css" href="/BMS/static/css/book.css">
        <link rel="stylesheet" type="text/css" href="/BMS/static/css/userinfo.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
<body>
        <div id="wrapper">
            <nav id="sidebar-wrapper" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <ul class="nav sidebar-nav">
                    <li class="user-img">
                        <img src="/BMS/img/user/${User.picpath }" class="img-circle">
                        <span>${User.username }</span>
                    </li>
                    <li class="iconuser">
                        <span><i class="icon-user"></i>个人资料</span>
                    </li>
                    <li>
                        <span><i class="icon-edit"></i>修改信息</span>
                    </li>
                    <li class="iconpencil">
                        <span><i class="icon-pencil"></i>修改密码</span>
                    </li>
                    <li class="iconbook">
                        <span><i class="icon-book"></i>图书信息</span>
                    </li>
                    <li class="iconthlist">
                        <span><i class="icon-th-list"></i>借阅书籍</span>
                    </li>
                    <li class="icontime">
                        <span><i class="icon-time"></i>借阅历史</span>
                    </li>
                    <li>
                        <span><i class="icon-flag"></i>违约记录</span>
                    </li>
                    <li class="logout">
                        <span><i class="icon-off"></i>退出登录</span>
                    </li>
                </ul>
            </nav>
            <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
                    <span class="hamb-top"></span>
                    <span class="hamb-middle"></span>
                    <span class="hamb-bottom"></span>
            </button>
            <div id="page-content">
                <div class="date-select">
                    <div class="input-append date data-select-first ">
                        <input type="text" class="starttime" value="" readonly>
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                    <span class="date-minus"></span>
                    <div class="input-append date data-select-second ">
                        <input type="text" class="endtime" value="" readonly>
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                    
                </div>
                <div class="category-select">
                    <span class="category-span">全部</span>
                    <i class="icon-sort-down"></i>
                    <ul class="category-ul">
                       
                    </ul>
                </div>
                <div class="book-search">
                    <input type="text" name="search" class="keyword" placeholder="Keyword" autocomplete="off">
                    <i class="icon-search icon-large i-search"></i>
                </div>
                <div id="book-info">
                    <div class="book-title">
                        <span class="order">序号</span>
                        <span class="name">书名</span>
                        <span class="autor">作者</span>
                        <span class="publish">出版社</span>
                        <span class="number">数量</span>
                    </div>
                    <ul class="book-ul">
                        
                    </ul>
                </div>
                <div id="borrow-info">
                    <div class="borrow-title">
                        <span class="order">序号</span>
                        <span class="name">书名</span>
                        <span class="autor">作者</span>
                        <span class="borrow-date">借阅时间</span>
                        <span class="borrow-days">借阅天数</span>
                    </div>
                    <ul class="borrow-ul">
                        
                    </ul>
                </div>
                <div id="borrow-history-info">
                    <div class="borrow-history-title">
                        <span class="history-order">序号</span>
                        <span class="history-name">书名</span>
                        <span class="autor">作者</span>
                        <span class="borrow-date">借阅时间</span>
                        <span class="return-date">归还时间</span>
                    </div>
                    <ul class="borrow-history-ul">
                       
                    </ul>
                </div>
                <nav class="page-set" aria-label="Page navigation">
                    <ul class="pagination pageset-ul">
                        
                    </ul>
                </nav>
            </div>
            <div id="user-info">
                <div class="user-info-readonly">
                    <ul class="user-info-ul">
                    </ul>
                </div>
                <div class="user-update-password">
                    <div class="input-group">
                      <span class="input-group-addon spanoldpassword" id="basic-addon1"> 旧密码</span>
                      <input type="password" class="form-control" id="oldpassword" placeholder="Old Password" aria-describedby="basic-addon1" onpaste="return false" > 
                    </div>
                    <div class="input-group">
                      <span class="input-group-addon spannewpassword" id="basic-addon1"> 新密码</span>
                      <input type="password" class="form-control" id="newpassword" placeholder="New Password" aria-describedby="basic-addon1" onpaste="return false" 
                      data-toggle="tooltip" data-placement="left" title="密码由不能重复的数字和字母组成">
                    </div>
                    <div class="input-group">
                      <span class="input-group-addon spanagain" id="basic-addon1">再次输入</span>
                      <input type="password" class="form-control" id="againpassword" placeholder="Input Again" aria-describedby="basic-addon1" onpaste="return false" >
                    </div>
                    <button type="button" class="btn btn-default gotoreset">Reset</button>
                    <button type="button" class="btn btn-default gotoupdatepassword">Update</button>
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
        <div class="modal fade book-more-info" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog" role="document" aria-hidden="true">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabelbookinfo"></h4>
                    </div>
                    <div class="modal-body">
                        <ul class="bookmodal-info-ul">
                            
                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay "></div>
        <div class="alert">
            <h2>消息</h2>
            <div class="alert_con">
                <p id="ts"></p>
                <p id="pbtn"><a class="btnborrowalert">确定</a></p>
            </div>
        </div>
    </body>
    <script src="/BMS/static/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/BMS/static/js/alert.js"></script>
    <script type="text/javascript" src="/BMS/static/js/book.js"></script>
    <script type="text/javascript" src="/BMS/static/js/bootstrap.js"></script>
    <script type="text/javascript" src="/BMS/static/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/BMS/static/js/switch.js"></script>
    <script type="text/javascript" src="/BMS/static/js/user.js"></script>
    <script type="text/javascript" src="/BMS/static/js/updatepassword.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
          var trigger = $('.hamburger'),
             isClosed = false;

            trigger.click(function () {
              hamburger_cross();      
            });

            function hamburger_cross() {
              if (isClosed == true) {          
               
                trigger.removeClass('is-open');
                trigger.addClass('is-closed');
                isClosed = false;
              } else {   
                trigger.removeClass('is-closed');
                trigger.addClass('is-open');
                isClosed = true;
              }
          }
          $(".hamburger").click(function () {
                $('#wrapper').toggleClass('toggled');
                $('#page-content').toggleClass('page-content-leave');
          });
        });
        $(".category-select").bind("click",function(){
            var ul = $(".category-select ul");
            if (ul.is(":hidden")) {
                ul.slideDown('400',function(){
                    $(this).find("li").bind("click",function(){
                        var selectLi=$(this).text();
                        $(".category-select span").text(selectLi);
                        $(".category-select ul").slideUp(400);
                        if(!$("#book-info").is(":hidden")){
                            showbookinfo(1);
                        }
                        if(!$("#borrow-info").is(":hidden")){
                            showuserborrowbookinfo(1,"false");
                        }
                    });
                    ul.mouseleave(function() {
                        $('.category-select ul').slideUp(400);
                    });
                });
            } else {
                ul.slideUp(400);
            }
        });
        $(".data-select-first").datetimepicker({
            minView: "month",
            format: "yyyy-mm-dd",
            todayBtn : 1,
            todayHighlight:true,
            autoclose:true
          });
        $(".data-select-second").datetimepicker({
            minView: "month",
            format: "yyyy-mm-dd",
            todayBtn : 1,
            todayHighlight:true,
            autoclose:true
          });
    </script>
</html>
