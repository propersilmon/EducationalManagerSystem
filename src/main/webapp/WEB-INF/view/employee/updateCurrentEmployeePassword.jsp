<%--
  Created by IntelliJ IDEA.
  User: zuikaku
  Date: 2019/8/30
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改当前登录教职员工的密码</title>

    <!-- Vendor CSS -->
    <link href="${pageContext.request.contextPath}/vendors/bower_components/animate.css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet">

    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/app.min.1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/app.min.2.css" rel="stylesheet">
</head>

<body>


<section id="main">



    <section id="content">
        <div class="container">
            <div class="block-header">
                <h2>修改你的教职工密码</h2>

                <ul class="actions">

                </ul>
            </div>

            <div class="card">
                <div class="card-header">
                    <h2>修改密码<small>先输入原密码，再输入两次新密码</small></h2>
                </div>

                <form action="${pageContext.request.contextPath}/employee/updatePassword" method="post">
                    <%--隐藏域--%>
                    <input type="hidden" name="employeeId" value="${sessionScope.activeEmployee['employeeId']}">
                <div class="card-body card-padding">
                    <div class="form-group has-success">
                        <div class="fg-line">
                            <label class="control-label" for="inputSuccess1">原密码</label>
                            <input type="password" class="form-control" id="inputSuccess1" >
                        </div>
                        <small class="help-block"></small>
                    </div>

                    <div class="form-group has-warning">
                        <div class="fg-line">
                            <label class="control-label" for="inputWarning1">新密码</label>
                            <input name="newPassword" type="password" class="form-control" id="inputWarning1" >
                        </div>
                        <small class="help-block"></small>
                    </div>
                    <div class="form-group has-warning">
                        <div class="fg-line">
                            <label class="control-label" for="inputWarning1">再输一次</label>
                            <input type="password" class="form-control" id="inputWarning2" >
                        </div>
                        <small class="help-block"></small>
                    </div>
                    <br/>
                    <button type="button" class="btn bgm-orange btn-icon" onclick="submitNewPassword()"><i class="zmdi zmdi-check"></i></button>
                </div>
                </form>
            </div>
        </div>
    </section>
</section>



<!-- Page Loader -->
<div class="page-loader">
    <div class="preloader pls-blue">
        <svg class="pl-circular" viewBox="25 25 50 50">
            <circle class="plc-path" cx="50" cy="50" r="20" />
        </svg>

        <p>Please wait...</p>
    </div>
</div>


<script src="${pageContext.request.contextPath}/vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/Waves/dist/waves.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/autosize/dist/autosize.min.js"></script>


<script src="${pageContext.request.contextPath}/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/js/demo.js"></script>
</body>
<script type="text/javascript">
    if('${param.isOk}'==='true')
    {
        window.alert("修改成功");
    }else if('${param.isOk}'==='false'){
        window.alert("修改失败");
    }


    function submitNewPassword() {
        var oldPassword=$("input").eq(1).val();
        var newPassword=$("input").eq(2).val();
        var newPasswordRepeate=$("input").eq(3).val();
        if(oldPassword!=="${sessionScope.activeEmployee['password']}")
        {
            console.log(oldPassword);

            window.alert("原来的密码不正确");
            return;
        }
        if(newPassword==='')
        {
            window.alert("新密码不能为空");
            return;
        }
        if(newPassword!==newPasswordRepeate)
        {
            window.alert("两次密码不相同")
            return;
        }
        $("form").submit();

    }
</script>
</html>
