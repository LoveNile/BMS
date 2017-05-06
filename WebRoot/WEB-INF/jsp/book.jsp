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
                        <img src="5.jpg" alt="..." class="img-circle">
                        <span>我爱我的亲人的的的的</span>
                    </li>
                    <li>
                        <span><i class="icon-user"></i>个人资料</span>
                    </li>
                    <li>
                        <span><i class="icon-edit"></i>修改信息</span>
                    </li>
                    <li>
                        <span><i class="icon-pencil"></i>修改密码</span>
                    </li>
                    <li>
                        <span><i class="icon-book"></i>图书信息</span>
                    </li>
                    <li>
                        <span><i class="icon-th-list"></i>借阅书籍</span>
                    </li>
                    <li>
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
                        <li>
                            <span class="borrow-order">1</span>
                            <img src="5.jpg" alt="..." class="img-rounded">
                            <span class="book-name">大话java性能优化</span>
                            <span class="book-autor">李白</span>
                            <span class="book-borrow-date">2017-12-12</span>
                            <span class="book-borrow-days">31</span>
                            <button type="button" class="btn btn-info">Info</button>
                            <button type="button" class="btn btn-warning">Renew</button>
                            <button type="button" class="btn btn-success">Back</button>
                        </li>
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
                        <li>
                            <span class="borrow-history-order">1</span>
                            <img src="5.jpg" alt="..." class="img-rounded">
                            <span class="book-name">大话java性能优化</span>
                            <span class="book-autor">李白</span>
                            <span class="book-borrow-date">2017-12-12</span>
                            <span class="book-return-date">2017-1-1</span>
                            <button type="button" class="btn btn-info">Info</button>
                            <button type="button" class="btn btn-danger">Borrow</button>
                        </li>
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
                        <li>
                            <span class="user-a">Avatar:</span>
                            <img src="5.jpg" class="img-circle">
                        </li>
                        <li>
                            <span class="user-a">Username:</span>
                            <span class="user-b">我爱我的亲人打击开发商的</span>
                        </li>
                        <li>
                            <span class="user-a">Phone:</span>
                            <span class="user-b">15738869155</span>
                        </li>
                        <li>
                            <span class="user-a">Email :</span>
                            <span class="user-b">1210598758</span>
                        </li>
                        <li>
                            <span class="user-a">Gender:</span>
                            <span class="user-b">男</span>
                        </li>
                        <li>
                            <span class="user-a">Birthday:</span>
                            <span class="user-b">1995-9-17</span>
                        </li>
                        <li>
                            <span class="user-a">RegisterTime:</span>
                            <span class="user-b">2017-4-12</span>
                        </li>
                        <li>
                            <span class="user-a">StudentNumber:</span>
                            <span class="user-b">201316920206</span>
                        </li>
                        <li><button type="button" class="btn btn-warning">Modify</button>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target=".student-info">Student Info</button>
                            
                        </li>
                    </ul>
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
                            <li><span>学号:</span><span>201316920206</span></li>
                            <li><span>姓名:</span><span>Nile</span></li>
                            <li><span>性别:</span><span>男</span></li>
                            <li><span>电话:</span><span>115738869155</span></li>
                            <li><span>邮箱:</span><span>1210598758@qq.com</span></li>
                            <li><span>学院:</span><span>计算机科学与工程学院</span></li>
                            <li><span>班级:</span><span>软件1302</span></li>
                            <li><span>入学时间:</span><span>2013-9-1</span></li>
                            <li><span>在校状态:</span><span>是</span></li>
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
                        <h4 class="modal-title" id="myModalLabel">Book Infomation</h4>
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
    </body>
    <script src="/BMS/static/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/BMS/static/js/book.js"></script>
    <script type="text/javascript" src="/BMS/static/js/bootstrap.js"></script>
    <script type="text/javascript" src="/BMS/static/js/bootstrap-datetimepicker.min.js"></script>
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
                        showbookinfo();
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
