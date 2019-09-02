<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/9/1
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>

<form action="<%=basePath%>teacherController/entryOneScores" method="post">
    <input type="hidden" name="scId" value="${studentCourse.sCId}"></br>
    学号：<input type="text" name="sId" value="${studentCourse.sId}"></br>
    成绩：<input type="text" name="studentScore" value="${studentCourse.sScore}"></br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </tr>
</form>
</body>
</html>
