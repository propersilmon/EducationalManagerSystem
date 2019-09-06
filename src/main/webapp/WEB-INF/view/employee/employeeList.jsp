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
<!-- 修改弹出层 -->
<div class="modal fade" id="updateWin" style="top:200px">
    <div class="modal-dialog">
        <div class="modal-content">
            <!--头部-->
            <div class="modal-header" style="background-color: green; height: 20px;">
                <p style="color: white;position: absolute;top:8px;">修改对话框</p>
            </div>
            <!-- 身体 -->
            <div class="modal-body">
                <form id="updateForm" role="form" class="form-horizontal" action="${pageContext.request.contextPath}/employee/updateInfo" method="post">
<%--                    隐藏域用来表单提交时知道员工id的--%>
                    <input type="hidden" name="eId">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">名字</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="employeeName" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">性别</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="sex" />
                        </div>
                    </div>
                </form>
            </div>
            <!-- 底部 -->
            <div class="modal-footer">
                <button class="btn btn-success btn-sm" onclick="executeUpdate()">修改</button>
                <button class="btn btn-success btn-sm" onclick="canceled()">取消</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="updateRole" style="top:200px">
    <div class="modal-dialog">
        <div class="modal-content">
            <!--头部-->
            <div class="modal-header" style="background-color: green; height: 20px;">
                <p style="color: white;margin: auto; position: absolute;top:8px;">分配角色</p>
            </div>
            <!-- 身体 -->
            <div class="modal-body">
                <form id="updateRoleForm" role="form" class="form-horizontal" action="${pageContext.request.contextPath}/employee/updateRole?currentPage=${pageBean.currentPageCode}" method="post">
                    <%--                    隐藏域用来表单提交时知道员工id的--%>
                    <input type="hidden" name="eId">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">角色</label>
                        <div class="col-sm-6">
                            <c:forEach items="${roleList}" var="role">
                                <div class="col-sm-4">
                                    <label>${role.rDesc}</label>
                                </div>
                                <div class="col-sm-6">
                                    <input class="checkbox" type="checkbox" name="alterRoles" value="${role.rId}">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </form>
            </div>
            <!-- 底部 -->
            <div class="modal-footer">
                <button class="btn btn-success btn-sm" onclick="alterRole()">分配</button>
                <button class="btn btn-success btn-sm" onclick="canceledAlter()">取消</button>
            </div>
        </div>
    </div>
</div>

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

                            <a href="${pageContext.request.contextPath}/employee/add" class="btn bgm-blue waves-effect" ><i class="zmdi zmdi-account-add zmdi-hc-fw"></i>员工添加</a>
                            <button class="btn bgm-green waves-effect" ><i class="tm-icon zmdi zmdi-search"></i>员工查询</button>
                            &nbsp;&nbsp;
                            <input type="text">
                            &nbsp;&nbsp;
                            <button class="btn bgm-red waves-effect"><i class="zmdi zmdi-delete zmdi-hc-fw"></i>批量删除</button>
                        </span>

                    </h2>
                </div>

                <div class="table-responsive">
                    <table id="data-table-selection" class="table table-striped" >
                        <thead>
                        <tr align="center">
                            <th class="select-cell" style="text-align: center;"><div class="checkbox"><label><input name="select"  type="checkbox" class="select-box" value="all" onchange="allSelect(this)"><i class="input-helper"></i></label></div></th>
                            <th data-column-id="id" data-type="numeric" data-identifier="true" width="10%" style="text-align: center;">ID</th>
                            <th data-column-id="sender" width="10%" style="text-align: center;">名字</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">性别</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">平均得分</th>
                            <th data-column-id="received" data-order="desc" width="30%" style="text-align: center;">角色</th>
                            <th data-column-id="received" data-order="desc" width="30%" style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach items="${requestScope.pageBean.beanList}" var="temp">
                            <tr>
                                <td class="select-cell"><div class="checkbox"><label><input name="select"  type="checkbox" class="select-box myOption" value="${temp.eId}" ><i class="input-helper"></i></label></div></td>
                                <td>${temp.eId}</td>
                                <td>${temp.eName}</td>
                                <td>${temp.eSex}</td>
                                <td>${temp.eAvgScore}</td>
                                <td>
                                    <c:forEach items="${temp.roleList}" var="role">
                                        &nbsp&nbsp<label>${role.rDesc}</label>&nbsp&nbsp
                                    </c:forEach>
                                </td>
                                <td><button class="btn bgm-cyan waves-effect" onclick="openUpdateLayer(this)">修改信息</button>
                                    <button class="btn bgm-orange waves-effect" onclick="setRole(this)">分配角色</button>
                                    <button class="btn bgm-lightgreen waves-effec" onclick="deleteEmployee(this)">删除员工</button>
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
        var value=obj.checked;
        console.log(value);
        var options= document.getElementsByClassName("myOption");
        if(value)
        {
            //全选所有的勾
            for(var temp in options)
            {
                options[temp].checked='checked';
            }
        }else{
            //取消所有的勾
            for(var temp in options)
            {
                options[temp].checked='';
            }
        }
    }
    //打开修改弹出层
    function openUpdateLayer(obj) {
        $("#updateWin").modal("show");//打开修改面板
        //进行数据回显
        var id=$(obj).parent().parent().find("td").eq(1).text();
        var name=$(obj).parent().parent().find("td").eq(2).text();
        var sex=$(obj).parent().parent().find("td").eq(3).text();
        $("#updateWin").find("input").eq(0).val(id);
        $("#updateWin").find("input").eq(1).val(name);
        $("#updateWin").find("input").eq(2).val(sex);
    }
    //执行修改
    function executeUpdate(){
        $("#updateForm").submit();
    }

    function alterRole(){
        $("#updateRoleForm").submit();
    }

    //分配角色
    function setRole(obj) {
       $("#updateRole").modal("show");
       var id=$(obj).parent().parent().find("td").eq(1).text();
       $("#updateRole").find("input").eq(0).val(id);

    }

    //删除记录
    function deleteEmployee(obj) {
        var id=$(obj).parent().parent().find("td").eq(1).text();
        console.log("要删除的id"+id);
        var sure= window.confirm("确定要删除");
        if(sure){
        window.location.href="${pageContext.request.contextPath}/employee/deleteEmployee?eid="+id;
        }
    }

    //取消按钮
    function canceled(){
        $("#updateWin").modal("hide");
    }

    function canceledAlter(){
        $("#updateRole").modal("hide");
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
