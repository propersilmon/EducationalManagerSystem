
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生后台系统</title>

    <!-- Vendor CSS -->
    <link href="${pageContext.request.contextPath}/vendors/bower_components/animate.css/animate.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
          rel="stylesheet">

    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/app.min.1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/app.min.2.css" rel="stylesheet">
</head>
<body>
<header id="header" class="clearfix" data-current-skin="blue">
    <ul class="header-inner">
        <li id="menu-trigger" data-trigger="#sidebar">
            <div class="line-wrap">
                <div class="line top"></div>
                <div class="line center"></div>
                <div class="line bottom"></div>
            </div>
        </li>


        <li class="pull-right">
            <ul class="top-menu">
                <li id="toggle-width">
                    <div class="toggle-switch">
                        <input id="tw-switch" type="checkbox" hidden="hidden">
                        <label for="tw-switch" class="ts-helper"></label>
                    </div>
                </li>

                <li id="top-search">
                    <a href=""><i class="tm-icon zmdi zmdi-search"></i></a>
                </li>



                <li class="dropdown">
                    <a data-toggle="dropdown" href=""><i class="tm-icon zmdi zmdi-more-vert"></i></a>
                    <ul class="dropdown-menu dm-icon pull-right">
                        <li class="skin-switch hidden-xs">
                            <span class="ss-skin bgm-lightblue" data-skin="lightblue"></span>
                            <span class="ss-skin bgm-bluegray" data-skin="bluegray"></span>
                            <span class="ss-skin bgm-cyan" data-skin="cyan"></span>
                            <span class="ss-skin bgm-teal" data-skin="teal"></span>
                            <span class="ss-skin bgm-orange" data-skin="orange"></span>
                            <span class="ss-skin bgm-blue" data-skin="blue"></span>
                        </li>
                        <li class="divider hidden-xs"></li>
                        <li class="hidden-xs">
                            <a data-action="fullscreen" href=""><i class="zmdi zmdi-fullscreen"></i>切换全屏</a>
                        </li>

                    </ul>
                </li>

            </ul>
        </li>
    </ul>


    <!-- Top Search Content -->
    <div id="top-search-wrap">
        <div class="tsw-inner">
            <i id="top-search-close" class="zmdi zmdi-arrow-left"></i>
            <input type="text">
        </div>
    </div>
</header>

<section id="main">
    <aside id="sidebar" class="sidebar c-overflow">
        <div class="profile-menu">
            <a href="">
                <div class="profile-pic">
                    <img src="${pageContext.request.contextPath}/img/profile-pics/1.jpg" alt="">
                </div>

                <div class="profile-info">
                    ${activeStudent.sName}
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>
            <ul class="main-menu">
                <li>
                    <a href="javascript:changeFrame('updatePassword')"><i class="zmdi zmdi-account"></i> 修改密码</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/student/logout"><i class="zmdi zmdi-time-restore"></i> 注销</a>
                </li>
            </ul>
        </div>

        <ul class="main-menu">


            <li class="sub-menu">
                <a href=""><i class="zmdi zmdi-collection-item"></i>学生管理系统</a>
                <ul>

                    <li><a href="javascript:changeFrame('queryBX')">必修课查询</a></li>
                    <li><a href="javascript:changeFrame('queryXX')">选修课查询</a></li>
                    <li><a href="javascript:changeFrame('querycourse')">查询选课表</a></li>
                    <li><a href="javascript:changeFrame('queryChouseCourse')">退课和评教</a></li>
                </ul>
            </li>

        </ul>
    </aside>


    <section id="content">
        <div class="container"  >
            <%--使用内敛框架--%>
            <iframe id="myFrame" src="${pageContext.request.contextPath}/employee/toInnerIndex" width="100%" height="100%" frameborder="0" scrolling="no" ></iframe>
        </div>
    </section>
</section>


<!-- Page Loader -->
<div class="page-loader">
    <div class="preloader pls-blue">
        <svg class="pl-circular" viewBox="25 25 50 50">
            <circle class="plc-path" cx="50" cy="50" r="20"/>
        </svg>

        <p>Please wait...</p>
    </div>
</div>




<!-- Javascript Libraries -->
<script src="${pageContext.request.contextPath}/vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/Waves/dist/waves.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/jquery-placeholder/jquery.placeholder.min.js"></script>
<script src="${pageContext.request.contextPath}/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/js/demo.js"></script>
</body>
<script type="text/javascript">
    <%--点击按钮（超链接）后--%>
    function changeFrame(arg) {
        if(arg==='queryBX'){
            $("#myFrame").attr("src","${pageContext.request.contextPath}/student/queryBXCourse");

        }else if(arg==='queryXX'){
            $("#myFrame").attr("src","${pageContext.request.contextPath}/student/queryAllXXCourse");
        }else if(arg==='querycourse'){
            $("#myFrame").attr("src","${pageContext.request.contextPath}/student/queryAllCourse");
        }else if(arg==='queryChouseCourse'){
            $("#myFrame").attr("src","${pageContext.request.contextPath}/student/queryChoseCourse");
        }
    }
</script>
</html>

