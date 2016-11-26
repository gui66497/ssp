<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="/view/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%
    String path = request.getContextPath();
%>
<head>
    <title>事件详情列表</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="${webRoot}/js/event/listEventDetail.js"></script>
</head>
<body>
    <div>
        <div id="dg" style="width: 500px;height: 500px;padding-left : 200px;"></div>
    </div>

</body>
</html>
