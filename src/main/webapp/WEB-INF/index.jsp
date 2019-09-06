<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>登录选择</title>
    <style type="text/css">
        html{
            font-size: 20px;
            font-family: "Microsoft YaHei UI", serif;
        }

        body{
            /*background-image: url("https://www.arch2o.com/wp-content/uploads/2018/06/Arch2O-Lishin-Elementary-School-Library-TALI-DESIGN-03.jpg");*/
            background-color: papayawhip;
            background-repeat: no-repeat;
        }

        .inside{
            position: absolute;
            top: 0;
            left: 0;
            content: "";
            background-color: black;
            opacity: 0.2;
            z-index: 1;
            width: 100%;
            height: 100%;
        }

        .outside{
            z-index: 2;
        }
    </style>
</head>
<body>
<div class="inside"></div>
<div class="col-md-5 card bgm-white outside" style="margin: auto; top: 200px; border: 1px solid black; background: none;">
    <div class="card-body" style="height: 200px; width: 600px;">
        <center>
            <button type="button" class="btn btn-outline-dark" onclick="window.location.href='${pageContext.request.contextPath}/studentLogin'">学生登录</button>
            <button type="button" class="btn btn-outline-dark" onclick="window.location.href='${pageContext.request.contextPath}/sysEmployeeLogin'">教职工登录</button>
        </center>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
