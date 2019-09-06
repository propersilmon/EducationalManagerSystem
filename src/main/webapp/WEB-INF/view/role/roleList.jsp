<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zuikaku
  Date: 2019/8/30
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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

<div class="modal fade" id="addRole" style="top:200px">
    <div class="modal-dialog">
        <div class="modal-content">
            <!--头部-->
            <div class="modal-header" style="background-color: green; height: 20px;">
                <p style="color: white;position: absolute;top:8px;">添加角色</p>
            </div>
            <!-- 身体 -->
            <div class="modal-body">
                <form id="addRoleForm" role="form" class="form-horizontal" action="${pageContext.request.contextPath}/managerRoles/addRole" method="post">
                    <%--隐藏域用来表单提交时知道员工id的--%>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">角色名字</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="roleName" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">角色描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="desc" />
                        </div>
                    </div>
                </form>
            </div>
            <!-- 底部 -->
            <div class="modal-footer">
                <button class="btn btn-success btn-sm" onclick="addRole()">添加</button>
                <button class="btn btn-success btn-sm" onclick="canceled()">取消</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="alterRole" style="top:200px">
    <div class="modal-dialog">
        <div class="modal-content">
            <!--头部-->
            <div class="modal-header" style="background-color: green; height: 20px;">
                <p style="color: white;position: absolute;top:8px;">修改角色</p>
            </div>
            <!-- 身体 -->
            <div class="modal-body">
                <form id="alterRoleForm" role="form" class="form-horizontal" action="${pageContext.request.contextPath}/managerRoles/alterRole?currentPage=${pageBean.currentPageCode}" method="post">
                    <%--隐藏域用来表单提交时知道角色id的--%>
                        <input type="hidden" name="rId">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">角色名字</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="roleName" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">角色描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="desc" />
                        </div>
                    </div>
                </form>
            </div>
            <!-- 底部 -->
            <div class="modal-footer">
                <button class="btn btn-success btn-sm" onclick="alterRole()">修改</button>
                <button class="btn btn-success btn-sm" onclick="alterCanceled()">取消</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="dividePermission" style="top:200px">
    <div class="modal-dialog">
        <div class="modal-content">
            <!--头部-->
            <div class="modal-header" style="background-color: green; height: 20px;">
                <p style="color: white;margin: auto; position: absolute;top:8px;">分配权限</p>
            </div>
            <!-- 身体 -->
            <div class="modal-body">
                <form id="dividePermissionForm" role="form" class="form-horizontal" action="${pageContext.request.contextPath}/managerRoles/dividePermission?currentPage=${pageBean.currentPageCode}" method="post">
                    <%--                    隐藏域用来表单提交时知道角色id的--%>
                    <input type="hidden" name="rId">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">权限</label>
                        <div class="col-sm-6">
                            <c:forEach items="${permissionList}" var="permission">
                                <div class="col-sm-4">
                                    <label>${permission.pName}</label>
                                </div>
                                <div class="col-sm-6">
                                    <input class="checkbox" type="checkbox" name="dPermissions" value="${permission.pId}">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </form>
            </div>
            <!-- 底部 -->
            <div class="modal-footer">
                <button class="btn btn-success btn-sm" onclick="divide()">分配</button>
                <button class="btn btn-success btn-sm" onclick="canceledDivide()">取消</button>
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
                    <h2>角色列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>
                            <a href="javascript: openAddRole()" class="btn bgm-blue waves-effect" ><i class="zmdi zmdi-account-add zmdi-hc-fw"></i>角色添加</a>
                            <button class="btn bgm-green waves-effect" ><i class="tm-icon zmdi zmdi-search"></i>角色查询</button>
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
                            <th data-column-id="sender" width="10%" style="text-align: center;">名称</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">描述</th>
                            <th data-column-id="received" data-order="desc" width="30%" style="text-align: center;">权限</th>
                            <th data-column-id="received" data-order="desc" width="30%" style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach items="${requestScope.pageBean.beanList}" var="temp">
                            <tr>
                                <td class="select-cell"><div class="checkbox"><label><input name="select"  type="checkbox" class="select-box myOption" value="${temp.rId}" ><i class="input-helper"></i></label></div></td>
                                <td>${temp.rId}</td>
                                <td>${temp.rName}</td>
                                <td>${temp.rDesc}</td>
                                <td>
                                    <c:forEach items="${temp.permissionList}" var="permission">
                                        &nbsp&nbsp<label>${permission.pName}</label>&nbsp&nbsp
                                    </c:forEach>
                                </td>
                                <td>
                                    <button class="btn bgm-blue waves-effect" onclick="dividePermission(this)">分配权限</button>
                                    <button class="btn bgm-cyan waves-effect" onclick="openAlterRole(this)">修改角色</button>
                                    <button class="btn bgm-lightgreen waves-effect" onclick="deleteRole(this)">删除角色</button>
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
        <span>    <a href="${pageContext.request.contextPath}/role/queryRole/${tempNum}">${tempNum}</a></span>
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

    //添加角色
    function openAddRole() {
        $("#addRole").modal("show");
    }

    function addRole(){
        $("#addRoleForm").submit();
    }

    function canceled(){
        $("#addRole").modal("hide");
    }

    //修改角色
    function openAlterRole(obj){
        $("#alterRole").modal("show");

        //进行数据回显
        var id=$(obj).parent().parent().find("td").eq(1).text();
        $("#alterRoleForm").find("input").eq(0).val(id);
    }

    function alterRole() {
        $("#alterRoleForm").submit();
    }

    function alterCanceled(){
        $("#alterRole").modal("hide");
    }

    function deleteRole(obj){
        var id=$(obj).parent().parent().find("td").eq(1).text();
        var sure= window.confirm("确定要删除");
        if(sure){
            window.location.href="${pageContext.request.contextPath}/managerRoles/deleteRole?rId="+id + "&currentPage=${pageBean.currentPageCode}";
        }
    }

    //分配权限
    function dividePermission(obj) {
        $("#dividePermission").modal("show");

        //进行数据回显
        var id=$(obj).parent().parent().find("td").eq(1).text();
        $("#dividePermission").find("input").eq(0).val(id);
    }

    function divide() {
        $("#dividePermissionForm").submit();
    }

    function canceledDivide() {
        $("#dividePermission").modal("hide");
    }

</script>
</body>
</html>
