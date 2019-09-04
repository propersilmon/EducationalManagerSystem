<%--
  Created by IntelliJ IDEA.
  User: zuikaku
  Date: 2019/8/30
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>教职工登录页面</title>
</head>
<body>
<center>
    <h1>职工登录</h1>
    <form action="${pageContext.request.contextPath}/employee/login" method="post">
        <label>工号</label>
        <input type="text" name="employeeId" />
        <label>密码</label>
        <input type="text" name="password" />
        <input type="submit" value="登录">
    </form>
    <span style="color: red">${requestScope.message}</span>
</center>
</body>
</html>
