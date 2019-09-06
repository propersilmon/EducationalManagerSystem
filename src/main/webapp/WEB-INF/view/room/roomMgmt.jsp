<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Material Admin</title>

    <!-- Vendor CSS -->
    <link href="${pageContext.request.contextPath}/vendors/bower_components/animate.css/animate.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendors/bootgrid/jquery.bootgrid.min.css" rel="stylesheet">


    <!-- CSS -->
    <link href="${pageContext.request.contextPath}/css/app.min.1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/app.min.2.css" rel="stylesheet">
</head>
<body>


<section id="main">


    <section id="content">
        <div class="container">
            <div class="block-header">
                <h2>Data Table</h2>

                <ul class="actions">

                </ul>
            </div>


            <div class="card" style="position: absolute; top: 0px;width: 100%">
                <form action="${pageContext.request.contextPath}/roomController/roomList" method="get">
                    <div class="card-header">
                        <h1>教室一览</h1>
                        <br/>
                        <span>

                            <a href="${pageContext.request.contextPath}/roomController/addRoomUI" class="btn bgm-blue waves-effect"><i
                                    class="zmdi zmdi-account-add zmdi-hc-fw"></i>新增教室</a>
                            <input type="text" name="position">
                            <button class="btn bgm-green waves-effect" type="submit" >按位置查询</button>

                        </span>

                        </h2>
                    </div>
                </form>
                <div class="table-responsive">
                    <table id="data-table-selection" class="table table-striped">
                        <thead>
                        <tr align="center">
                            <th data-column-id="sender" width="8%" style="text-align: center;">
                                教室编号
                            </th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">
                                教室位置
                            </th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">
                                教室容量
                            </th>
                            <th data-column-id="received" data-order="desc" width="47%" style="text-align: center;">
                                教室操作
                            </th>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach items="${Room}" var="Room">
                            <tr>
                                <td>${Room.rId}</td>
                                <td>${Room.position}</td>
                                <td>${Room.maxCount}</td>
                                <td>
                                    <a class="btn bgm-red waves-effec" href="${pageContext.request.contextPath}/roomController/removeRoom?rId=${Room.rId}" >教室弃置</a>
                                    <a class="btn bgm-orange waves-effec" href="${pageContext.request.contextPath}/roomController/modifyRoomUI?rId=${Room.rId}" >修改信息</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>


        </div>
    </section>

</section>



<!-- Javascript Libraries -->
<script src="${pageContext.request.contextPath}/vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/Waves/dist/waves.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bower_components/bootstrap-sweetalert/lib/sweet-alert.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/bootgrid/jquery.bootgrid.updated.min.js"></script>


<script src="${pageContext.request.contextPath}/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/js/demo.js"></script>

<!-- Data Table -->
<script type="text/javascript">
    //全选复选框选中
    function allSelect(obj) {
        var value = obj.checked;
        console.log(value);
        var options = document.getElementsByClassName("myOption");
        if (value) {
            //全选所有的勾
            for (var temp in options) {
                options[temp].checked = 'checked';
            }
        } else {
            //取消所有的勾
            for (var temp in options) {
                options[temp].checked = '';
            }
        }
    }
</script>
</body>
</html>