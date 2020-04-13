<%--
  Created by IntelliJ IDEA.
  User: 向文浩
  Date: 2020/3/27
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="users">
    <c:forEach items="${users}" var="user">
        <b>用户:</b><span id="mz">${user.id}</span><br>
        <b>名字:</b><span id="xm">${user.name}</span><br>
        <b>密码:</b><span id="mm">${user.password}</span><br>
        <b>年龄:</b><span id="nl">${user.age}</span><br>
    </c:forEach>
</div>
</body>
</html>
