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
            <form action="<%=basePath%>teacherController/entryAllScores" method="post">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th hidden="true"></th>
                        <th>学生学号</th>
                        <th>学生姓名</th>
                        <th>所选课程</th>
                        <th>课程成绩</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list2}" var="list">
                        <c:forEach items="${studentList}" var="student">
                            <c:if test="${list.sId==student.sId}">
                                <c:forEach items="${teacherCourseAndRoom.course}" var="course">
                                    <c:if test="${course.cId==list.cId}">
                        <tr>
                            <td hidden="true"><input type="hidden" name="scId" value="${list.sCId}"></td>
                            <td>${list.sId}</td>
                            <td>${student.sName}</td>
                            <td>${course.cName}</td>
                            <td><input type="text" name="scores" value="${list.sScore}"></td>
                        </tr>
                                    </c:if>
                                 </c:forEach>
                              </c:if>
                          </c:forEach>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
                <button class="btn btn-info waves-effect" ><trans oldtip="Submit" newtip="批量录入" style="">批量录入</trans></button>
            </form>
        </div>
    </div>
</section>
</body>
</html>
