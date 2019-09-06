<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生课程</title>

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
    <style type="text/css">
        html{
            font-family: "Microsoft YaHei UI", serif;
        }
    </style>
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
                    <h2>选课列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </h2>
                </div>

                <div class="table-responsive">
                    <table id="data-table-selection" class="table table-striped" >
                        <thead>
                        <tr align="center">
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">课程名</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">上课时间</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">星期几</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">开始周数</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">结束周数</th>
                            <th data-column-id="received" data-order="desc" width="10%" style="text-align: center;">教室位置</th>

                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach items="${list}" var="temp">
                            <tr>
                                <td>
                                    <c:forEach items="${all}" var="temp2">
                                        <c:if test="${temp.cId==temp2.cId}">
                                            ${temp2.cName}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    ${temp.interval}
                                </td>
                                <td>
                                        ${temp.week}
                                </td>
                                <td>
                                        ${temp.startWeek}
                                </td>
                                <td>
                                        ${temp.endWeek}
                                </td>
                                <td>
                                    <c:forEach items="${list1}" var="temp3">
                                        <c:if test="${temp.rId==temp3.rId}">
                                            ${temp3.position}
                                        </c:if>
                                    </c:forEach>
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

    //取消按钮
    function canceled(){
        $("#updateWin").modal("hide");
    }
</script>
</body>
</html>