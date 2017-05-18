<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BMS后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut  icon" type="image/x-icon" href="/BMS/static/ico/admin.ico" media="screen" />
    <link rel="stylesheet" href="/BMS/static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/BMS/static/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="/BMS/static/css/matrix-style.css" />
    <link rel="stylesheet" href="/BMS/static/css/matrix-media.css" />
    <link href="/BMS/static/css/font-awesome.css" rel="stylesheet" />
</head>
<body>
    <!--Header-part-->
    <div id="header">
      <h1><a href="dashboard.html">图书信息管理系统</a></h1>
    </div>
    <!--close-Header-part--> 

    <!--top-Header-menu-->
    <div id="user-nav" class="navbar navbar-inverse">
        <ul class="nav">
            <li  class="dropdown" id="profile-messages" >
                <a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle">
                    <i class="icon icon-user"></i>&nbsp;
                    <span class="text">欢迎你，${Admin.adminname} </span>&nbsp;
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="icon-user"></i> 个人资料</a></li>
                    <li class="divider"></li>
                    <li><a href="logout"><i class="icon-key"></i> 退出系统</a></li>
                </ul>
            </li>
            <li class="dropdown" id="menu-messages">
                <a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle">
                    <i class="icon icon-envelope"></i>&nbsp;
                    <span class="text">我的消息</span>&nbsp;
                    <span class="label label-important">4</span>&nbsp; 
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> 新消息</a></li>
                    <li class="divider"></li>
                    <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> 收件箱</a></li>
                    <li class="divider"></li>
                    <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> 发件箱</a></li>
                    <li class="divider"></li>
                    <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> 回收站</a></li>
                </ul>
            </li>
            <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">&nbsp;设置</span></a></li>
            <li class=""><a title="" href="/BMS/admin/logout"><i class="icon icon-share-alt"></i> <span class="text">&nbsp;退出系统</span></a></li>
        </ul>
    </div>
    <!--close-top-Header-menu-->

    <!--start-top-serch-->
    <div id="search">
        <input type="text" placeholder="搜索..."/>
        <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
    </div>
    <!--close-top-serch-->

    <!--sidebar-menu-->
    <div id="sidebar" style="OVERFLOW-Y: auto; OVERFLOW-X:hidden;">
        <ul>
            <li class="submenu active">
                <a class="menu_a" link="alluser"><i class="icon icon-home"></i> <span>主页</span></a> 
            </li>
            <li class="submenu"> 
                <a href="#">
                    <i class="icon icon-user"></i> 
                    <span>用户资料</span> 
                    <span class="label label-important">4</span>
                </a>
                <ul>
                    <li><a class="menu_a" link="alluser"><i class="icon icon-caret-right"></i>全部用户</a></li>
                    <li><a class="menu_a" link="admininfo"><i class="icon icon-caret-right"></i>个人信息</a></li>
                    <li><a class="menu_a" link="edit"><i class="icon icon-caret-right"></i>修改信息</a></li>
                    <li><a class="menu_a" link="updatepassword"><i class="icon icon-caret-right"></i>修改密码</a></li>
                </ul>
            </li>
            <li class="submenu">
                <a href="#">
                    <i class="icon icon-book"></i> 
                    <span>图书信息</span> 
                    <span class="label label-important">3</span>
                </a>
                <ul>
                    <li><a class="menu_a" link="allbook"><i class="icon icon-caret-right"></i> 全部图书</a></li>
                    <li><a class="menu_a" link="toaddbook"><i class="icon icon-caret-right"></i>添加图书</a></li>
                    <li><a class="menu_a" link="categoryview"><i class="icon icon-caret-right"></i>添加分类</a></li>
                </ul>
            </li>
            <li class="submenu">
                <a href="#">
                    <i class="icon icon-th"></i> 
                    <span>图书请求</span> 
                    <span class="label label-important">3</span>
                </a>
                <ul>
                    <li><a class="menu_a" link="viewbookaskborrow"><i class="icon icon-caret-right"></i>借阅请求</a></li>
                    <li><a class="menu_a" link="viewbookaskback"><i class="icon icon-caret-right"></i>还书请求</a></li>
                    <li><a class="menu_a" link="viewallborrow"><i class="icon icon-caret-right"></i>查看借阅</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!--sidebar-menu-->

    <!--main-container-part-->
    <div id="content">
        <!--breadcrumbs-->
        <div id="content-header">
          <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
        </div>
        <!--End-breadcrumbs-->
        <iframe src="alluser" id="iframe-main" frameborder='0' style="width:100%;height:100%"></iframe>
    </div>
    <!--end-main-container-part-->

    <script src="/BMS/static/js/excanvas.min.js"></script> 
    <script src="/BMS/static/js/jquery-1.10.2.min.js"></script>  
    <script src="/BMS/static/js/jquery.ui.custom.js"></script> 
    <script src="/BMS/static/js/bootstrap.min.js"></script> 
    <script src="/BMS/static/js/jquery.nicescroll.min.js"></script> 
    <script src="/BMS/static/js/matrix.js"></script> 


    <script type="text/javascript">

    //初始化相关元素高度
    function init(){
        $("body").height($(window).height()-80);
        $("#iframe-main").height($(window).height()-90);
        $("#sidebar").height($(window).height()-50);
    }

    $(function(){
        init();
        $(window).resize(function(){
            init();
        });
    });

    // This function is called from the pop-up menus to transfer to
    // a different page. Ignore if the value returned is a null string:
    function goPage (newURL) {
        // if url is empty, skip the menu dividers and reset the menu selection to default
        if (newURL != "") {
            // if url is "-", it is this page -- reset the menu:
            if (newURL == "-" ) {
                resetMenu();            
            } 
            // else, send page to designated URL            
            else {  
                document.location.href = newURL;
            }
        }
    }

    // resets the menu selection upon entry to this page:
    function resetMenu() {
        document.gomenu.selector.selectedIndex = 2;
    }

    // uniform使用示例：
    // $.uniform.update($(this).attr("checked", true));
    </script>
</body>
</html>
