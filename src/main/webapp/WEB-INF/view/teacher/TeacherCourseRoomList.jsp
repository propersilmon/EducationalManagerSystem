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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8 " >
    <title>清单</title>

</head>
<body>
<form action="<%=basePath%>teacherController/selectCourse" method="post" >
    <center>
        <table>

            <tr>
                <th>课程名</th>
                <th>学分</th>
                <th>是否选修</th>
                <th>课程创建时间</th>
                <th>占用教室描述</th>
                <th>上课时间区间</th>
                <th>上课时间</th>
                <th>开始周数</th>
                <th>结束周数</th>
                <th>教室位置</th>

            </tr>


            <c:forEach  items="${teacherCourseAndRoom.course}" var="course">
                <c:forEach  items="${teacherCourseAndRoom.courseRoom}" var="courseRoom">
                    <c:if test="${course.cId==courseRoom.cId}">
                        <c:forEach  items="${teacherCourseAndRoom.room}" var="room">
                            <c:if test="${courseRoom.rId==room.rId}">
                                <tr>
                                    <th>${course.cName}</th>
                                    <th>${course.cCredit}</th>
                                    <th>${course.elective}</th>
                                    <th>${course.createDate}</th>
                                    <th>${courseRoom.desc}</th>
                                    <th>${courseRoom.interval}</th>
                                    <th>${courseRoom.week}</th>
                                    <th>${courseRoom.startWeek}</th>
                                    <th>${courseRoom.endWeek}</th>
                                    <th>${room.position}</th>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </c:forEach>

        </table>
    </center>
</form>

</body>
</html>