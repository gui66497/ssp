<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="/view/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%
    String path = request.getContextPath();
%>
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>


<h2>
    <a href="#">测试链接</a>
</h2>

<br>

<a href="sysUserController/showUserToJspById/2" target="_blank">查询用户信息并跳转到一个JSP页面</a>

<br>

<a href="sysUserController/showUserToJSONById/2.json" target="_blank">查询用户信息并直接输出JSON数据</a>

<br>

<a href="event/toList" target="_blank">测试Easyui的datagrid</a>

</body>
</html>
