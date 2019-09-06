<%--
  Created by IntelliJ IDEA.
  User: zuikaku
  Date: 2019/8/30
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" co6ntent="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Material Admin</title>
    <!-- Vendor CSS -->
    <link href="${pageContext.request.contextPath}/vendors/bower_components/animate.css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css" rel="stylesheet">
    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/app.min.1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/app.min.2.css" rel="stylesheet">
</head>

<body class="login-content">
    <div class="container" style="height: 800px;">
        <div class="lc-block lcb-alt toggled" id="l-lockscreen">

            <div class="fg-line">
                <input type="text" class="form-control text-center" placeholder="当前时间" readonly="readonly">
            </div>

            <div class="fg-line">
                <input type="text" class="form-control text-center" placeholder="站内消息" readonly="readonly">
            </div>

            <ul class="login-navigation">

            </ul>
        </div>
    </div>
</body>
<!-- Javascript Libraries -->
<script src="${pageContext.request.contextPath}/vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/Waves/dist/waves.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/jquery-placeholder/jquery.placeholder.min.js"></script>
<script src="${pageContext.request.contextPath}/js/functions.js"></script>
<script type="text/javascript">
    $(function () {
        var $timerBox=$("input").eq(0);
        var set=setInterval(function () {
            var myDate=new Date();
            var year=myDate.getFullYear();
            var month=myDate.getMonth()+1;//取值范围0-11
            var mydate=myDate.getDate();
            var hour=myDate.getHours();//取值范围0-23
            var minu=myDate.getMinutes();
            var second=myDate.getSeconds();
            var week=myDate.getDay();
            var myTime=year+"当前时间:"+year+"年"+month+"月"+mydate+"日 "+hour+":"+minu+":"+second+"秒"+" 今天是星期"+week;
            $timerBox.val(myTime);
        },1000);
    });


</script>
</html>



