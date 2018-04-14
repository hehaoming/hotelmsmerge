<%--
  Created by IntelliJ IDEA.
  User: Oliver
  Date: 2018/4/14
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404错误界面处理</title>
    <style type="text/css">
        .stbug{
            background: url("img/404..jpg") ;
            background-position:center;
        }
        .return{
            background: url('img/buttom..jpg') no-repeat;
            width: 270px;
            height: 62px;
            position: relative;
            margin-top: 600px;
            margin-left: 580px;
        }
    </style>
</head>
<body class="stbug">
   <button type="submit" onclick="window.history.back()" class="return"/>
</body>
</html>
