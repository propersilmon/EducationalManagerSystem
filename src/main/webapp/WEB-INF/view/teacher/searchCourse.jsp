<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/8/30
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <base href="<%=basePath%>"/>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>
    
        <!-- Vendor CSS -->
        <link href="vendors/bower_components/animate.css/animate.min.css" rel="stylesheet">
        <link href="vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.css" rel="stylesheet">
        <link href="vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css" rel="stylesheet">
        <link href="vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet">        
            
        <!-- CSS -->
        <link href="css/app.min.1.css" rel="stylesheet">
        <link href="css/app.min.2.css" rel="stylesheet">
        <!-- Following CSS codes are used only fore demo purposes thus you can remove anytime -->
        <style type="text/css">
            .dropdown-basic-demo {
                display: inline-block;
                margin: 0 15px 20px 0;
            }

            input {
                color: #0a0a0a;
            }
            .dropdown-basic-demo .dropdown-menu {
                display: block;
                position: relative;
                transform: scale(1);
                opacity: 1;
                filter: alpha(opacity=1);
                z-index: 0;
            }

            .dropdown-btn-demo .dropdown, .dropdown-btn-demo .btn-group, .btn-demo .btn {
                display: inline-block;
                margin: 0 5px 7px 0;
            }

            .modal-preview-demo .modal {
                position: relative;
                display: block;
                z-index: 0;
                background: rgba(0,0,0,0.1);
            }

            .margin-bottom > *{
                margin-bottom: 20px;
            }

            .popover-demo .popover {
                position: relative;
                display: inline-block;
                opacity: 1;
                margin: 0 10px 30px;
                z-index: 0;
            }

            .preloader {
                margin-right: 30px;
            }
        </style>
    </head>
    <body>




            <section id="content">
                <div class="container">
                    <div class="card">
                        <div class="card-header">
                            <h2>学生成绩录入<small>请教师严格按照考核标准录入成绩，禁止人情分</small></h2>
                        </div>
                        &nbsp;&nbsp;
                        <form action="<%=basePath%>teacherController/searchCourse" method="post">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-info waves-effect" id="checkAll"   value="全选">全选</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             <input type="text"  name="courseName" placeholder="输入查询课程关键名">
                        &nbsp;&nbsp;
                            <button class="btn btn-info waves-effect" ><trans oldtip="Submit" newtip="搜索" style="">搜索</trans></button>
                            &nbsp;&nbsp; <button type="button" onclick="batchInsert()" <%--href="<%=basePath%>teacherController/batchInsert"--%>  class="btn btn-info waves-effect" ><trans oldtip="Submit" newtip="批量录入" style="">批量录入</trans></button>
                        </form>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>学生学号</th>
                                    <th>学生姓名</th>
                                    <th>所在班级</th>
                                    <th>所在专业</th>
                                    <th>所选课程</th>
                                    <th>课程学分</th>
                                    <th>课程成绩</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${teacherCourseAndRoom.course}" var="courses">
                                    <c:if test="${course.cName==courses.cName}">
                                        <c:forEach items="${studentCoursesList}" var="studentCourses">
                                            <c:if test="${courses.cId==studentCourses.cId}">
                                              <c:forEach items="${studentList}" var="student">
                                                <c:if test="${studentCourses.sId==student.sId}">
                                                    <tr>
                                                        <th>
                                                            <input type="checkbox" id="check" name="check"  value="${studentCourses.sCId}">
                                                           <%--  ${studentCourses.sCId}--%>
                                                            <input type="hidden" value="${studentCourses.sCId}">
                                                        </th>
                                                        <th>${student.sId}</th>
                                                        <th>${student.sName}</th>
                                                        <th>${student.sClass}</th>
                                                        <th>${student.sState}</th>
                                                        <th>${courses.cName}</th>
                                                        <th>${courses.cCredit}</th>
                                                        <th>${studentCourses.sScore}</th>
                                                        <th>
                                                            <button id="entry" onclick="entry(this)" data-toggle="modal" href="#modalColor" class="btn btn-default waves-effect"><trans oldtip="Prevent Outside Click" newtip="录入成绩" style="">录入成绩</trans></button>
                                                        </th>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </section>


        <div class="modal fade in" data-modal-color="lightblue" id="modalColor" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true" style="display: none; padding-right: 18px;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title"><trans oldtip="Modal title" newtip="成绩录入">成绩录入</trans></h4>
                    </div>
                    <div class="modal-body">
                        <form action="<%=basePath%>teacherController/entryOneScores" method="post">
                            <center>

                                <tr>
                                    <input type="hidden" readonly= "true " name="scId" id="scId2" value=""></br>
                                    学号：<input type="text" readonly= "true " name="sId" id="sId" value=""></br>
                                    姓名：<input type="text" readonly= "true " name="name" id="name" value=""></br>
                                    课程：<input type="text" readonly= "true " name="course" id="course" value=""></br>
                                    成绩：<input type="text"  name="studentScore" id="studentScore" value="" placeholder="输入学生成绩"></br>
                                </tr>
                            </center>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-link waves-effect"><trans oldtip="Submit" newtip="录入" style="">录入</trans></button>
                                <button type="reset" class="btn btn-link waves-effect" data-dismiss="modal"><trans oldtip="Close" newtip="关闭" style="">关闭</trans></button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <footer id="footer">
            Copyright &copy; 2019 教务管理系统
            
            <ul class="f-menu">
                <li><a href="">Home</a></li>
                <li><a href="">Dashboard</a></li>
                <li><a href="">Reports</a></li>
                <li><a href="">Support</a></li>
                <li><a href="">Contact</a></li>
            </ul>
        </footer>

        <!-- Page Loader -->
        <div class="page-loader">
            <div class="preloader pls-blue">
                <svg class="pl-circular" viewBox="25 25 50 50">
                    <circle class="plc-path" cx="50" cy="50" r="20" />
                </svg>

                <p>Please wait...</p>
            </div>
        </div>

        <!-- Older IE warning message -->
        <!--[if lt IE 9]>
            <div class="ie-warning">
                <h1 class="c-white">Warning!!</h1>
                <p>You are using an outdated version of Internet Explorer, please upgrade <br/>to any of the following web browsers to access this website.</p>
                <div class="iew-container">
                    <ul class="iew-download">
                        <li>
                            <a href="http://www.google.com/chrome/">
                                <img src="img/browsers/chrome.png" alt="">
                                <div>Chrome</div>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.mozilla.org/en-US/firefox/new/">
                                <img src="img/browsers/firefox.png" alt="">
                                <div>Firefox</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://www.opera.com">
                                <img src="img/browsers/opera.png" alt="">
                                <div>Opera</div>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.apple.com/safari/">
                                <img src="img/browsers/safari.png" alt="">
                                <div>Safari</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                                <img src="img/browsers/ie.png" alt="">
                                <div>IE (New)</div>
                            </a>
                        </li>
                    </ul>
                </div>
                <p>Sorry for the inconvenience!</p>
            </div>   
        <![endif]-->

        <!-- Javascript Libraries -->
        <script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="vendors/bower_components/Waves/dist/waves.min.js"></script>
        <script src="vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
        <script src="vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>

        <!-- Placeholder for IE9 -->
        <!--[if IE 9 ]>
            <script src="vendors/bower_components/jquery-placeholder/jquery.placeholder.min.js"></script>
        <![endif]-->
        
        <script src="js/functions.js"></script>
        <script src="js/demo.js"></script>

        <script type="text/javascript">
            $("#checkAll").click(function(){
                $("input[name='check']").each(function(){
                    if (this.checked) {
                        this.checked = false;
                    }
                    else {
                        this.checked = true;
                    }
                });
            })
        </script>
    </body>
  </html>
<script type="text/javascript">
    let row;

    function entry(obj){
        row=obj;
        /*let scId =$(obj).parent().siblings().eq(0).text();*/
        let scId =$(obj).parent().siblings().eq(0).children('input').eq(1).val();
        let sId =$(obj).parent().siblings().eq(1).text();
        let name =$(obj).parent().siblings().eq(2).text();
        let course =$(obj).parent().siblings().eq(5).text();
        let score =$(obj).parent().siblings().eq(7).text();
        /*$("#sCId2").val(scId);*/
        $("#scId2").val(scId);
        $("#sId").val(sId);
        $("#name").val(name);
        $("#course").val(course);
        $("#studentScore").val(score);

    }
</script>
<script type="text/javascript">
    function batchInsert(){
        //判断至少写了一项
        let checkedNum = $("input[name='check']:checked").length;
        if(checkedNum==0){
            alert("请至少选择一项!");
            return false;
        }
        let checkedList = new Array();
        $("input[name='check']:checked").each(function(){
            checkedList.push($(this).val());
        });
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/teacherController/batchInsert",
            data:{"checkList":checkedList.toString()},
            dataType:"script",
            success:function(){

            },
        });

    }
</script>