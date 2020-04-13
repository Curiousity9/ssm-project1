<%--
  Created by IntelliJ IDEA.
  User: 向文浩
  Date: 2020/4/8
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>mooddasfdsada页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<div id="moods">
    <b>说说列表：</b><br>
    <c:forEach items="${moods}" var="mood">
        ---------------------
        <br>
        <b>用户:</b><span id="account">${mood.userAccount}</span><br>
        <b>说说内容:</b><span id="content">${mood.content}</span> <br>
        <b>发表时间:</b><span id="publish_time">${mood.publishTime}</span><br>
        <b>点赞数:</b><span id="praise_num">${mood.priseNum}</span><br>
        <div style="margin-left: 350px">
<%--            <a id="praise" href="/ssm_project1_war_exploded/mood/${mood.id}/praise?userId=${mood.userId}">赞</a>--%>
<%--                ${mood.id}/praise?userId=${mood.userId}--%>
            <a id="praise" href="/ssm_project1_war_exploded/mood/${mood.id}/praiseForRedis?userId=${mood.userId}">赞</a>
         </div>
    </c:forEach>
</div>
</body>
<script/>
</html>
