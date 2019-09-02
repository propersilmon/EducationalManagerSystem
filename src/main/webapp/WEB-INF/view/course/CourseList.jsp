<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zuikaku
  Date: 2019/8/30
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
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
                <div class="card-header">
                    <h2>员工列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>

                            <a href="${pageContext.request.contextPath}/employee/add" class="btn bgm-blue waves-effect"><i
                                    class="zmdi zmdi-account-add zmdi-hc-fw"></i>员工添加</a>
                            <button class="btn bgm-green waves-effect"><i
                                    class="tm-icon zmdi zmdi-search"></i>员工查询</button>
                            &nbsp;&nbsp;
                            <input type="text">
                            &nbsp;&nbsp;
                            <button class="btn bgm-red waves-effect"><i
                                    class="zmdi zmdi-delete zmdi-hc-fw"></i>批量删除</button>
                        </span>

                    </h2>
                </div>

                <div class="table-responsive">
                    <table id="data-table-selection" class="table table-striped">
                        <thead>
                        <tr align="center">
                            <th class="select-cell" style="text-align: center;">
                                <div class="checkbox"><label><input name="select" type="checkbox" class="select-box"
                                                                    value="all" onchange="allSelect(this)"><i
                                        class="input-helper"></i></label></div>
                            </th>
                            <th data-column-id="sender" width="20%" style="text-align: center;">课程名</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">学分
                            </th>
                            <th data-column-id="received" data-order="desc" width="40%" style="text-align: center;">
                                任课教师
                            </th>
                            <th data-column-id="received" data-order="desc" width="40%" style="text-align: center;">
                                上课时间
                            </th>

                            <th data-column-id="received" data-order="desc" width="40%" style="text-align: center;">
                                所在教室
                            </th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">
                                是否选修
                            </th>
                            <th data-column-id="received" data-order="desc" width="40%" style="text-align: center;">操作
                            </th>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach items="${ctroom}" var="ctroomS">
                            <tr>
                                <td class="select-cell">
                                    <div class="checkbox"><label><input name="select" type="checkbox"
                                                                        class="select-box myOption" value="${temp.eId}"><i
                                            class="input-helper"></i></label></div>
                                </td>
                                <td>${ctroomS.course.cName}</td>
                                <td>${ctroomS.course.cCredit}</td>
                                <td>${ctroomS.sysEmployee.eName}</td>
                                <td>${ctroomS.courseRooms.startWeek}到${ctroomS.courseRooms.endWeek}的
                                    每周${ctroomS.courseRooms.week}的${ctroomS.courseRooms.interval}
                                </td>
                                <td>${ctroomS.room.position}</td>
                                <td>${ctroomS.course.elective}</td>
                                <td>
                                    <button class="btn bgm-cyan waves-effect">修改信息</button>
                                    <button class="btn bgm-orange waves-effect">分配权限</button>
                                    <button class="btn bgm-lightgreen waves-effec">删除员工</button>
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

<footer id="footer" style="position: absolute; top: 555px">
    <span>当前页码数:${requestScope.pageBean.currentPageCode}/${requestScope.pageBean.totalPageCode} 页</span>
    <c:forEach begin="1" end="${requestScope.pageBean.totalPageCode}" var="tempNum">
        <span>    <a href="${pageContext.request.contextPath}/employee/queryEmployee/${tempNum}">${tempNum}</a></span>
    </c:forEach>
</footer>


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
<%--<html>--%>
<%--<head>--%>
<%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table>--%>
<%--<thead>--%>
<%--<th>id</th>--%>
<%--<th>用户名</th>--%>
<%--<th>性别</th>--%>
<%--<th>学生反馈平均分数</th>--%>
<%--<th>操作</th>--%>
<%--</thead>--%>
<%--<tbody>--%>
<%--<c:forEach items="${requestScope.pageBean.beanList}" var="temp">--%>
<%--<tr>--%>
<%--<td>${temp.eId}</td>--%>
<%--<td>${temp.eName}</td>--%>
<%--<td>${temp.eSex}</td>--%>
<%--<td>${temp.eAvgScore}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--&lt;%&ndash;页码部分&ndash;%&gt;--%>
<%--<span>当前页码数:${requestScope.pageBean.currentPageCode}/${requestScope.pageBean.totalPageCode} 页</span>--%>
<%--<c:forEach begin="1" end="${requestScope.pageBean.totalPageCode}" var="tempNum">--%>
<%--<span>    <a href="${pageContext.request.contextPath}/employee/queryEmployee/${tempNum}">${tempNum}</a></span>--%>
<%--</c:forEach>--%>
<%--</body>--%>
<%--</html>--%>
