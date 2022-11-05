<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/21
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>ch8作业</title>
    <%@ include file="/basejs.jsp" %>


</head>
<style>

</style>
<body>
<header >
    <h2 >ch8作业</h2>

</header>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">

        </div>
    </div>
</nav>
<div class="container-fluid">
<form action="${pageContext.request.contextPath}/course/search" method="post" class="form-inline">
<c:if test="${user!=null}">
   <a href="${pageContext.request.contextPath}/add.jsp" class="btn btn-primary">增加</a>
</c:if>
    <div class="form-group">
    <label for="begin">开始日期</label>
    <input type="date"  class="form-control"  id="begin" name="beginDate" required="required" >
    </div>
    <div class="form-group">
    <label for="end">结束日期</label>
    <input type="date" class="form-control"  id="end" name="endDate" required="required">
    </div>
    <input type="submit"  class="btn btn-success" value="查询">

</form>
</div>

<fmt:setBundle basename="course"/>
<table class="table table-bordered table-hover">
    <thead>
    <th>id</th>
    <th>
        <fmt:message key="CcourseName"/>
    </th>
    <th>
        <fmt:message key="Cdescription"/>
    </th>
    <th>
        <fmt:message key="CcreateTime"/>
    </th>
    <th>
        <fmt:message key="Cteacher"/>
    </th>
    <th>
        <fmt:message key="Coperate"/>
    </th>
    </thead>
    <tbody>

    <c:if test="${courses!=null}">
    <c:forEach items="${courses}" var="course">
        <tr onclick="location.href='${pageContext.request.contextPath}/courseDetailsServlet?id=${course.id}';">
            <td>${course.id}</td>
            <td>${course.couname}</td>
            <td>${course.miaoshu}</td>
            <td>
                <fmt:formatDate value="${course.createTime}" pattern="yyyy年MM月dd日"/>
            </td>
            <td>${course.teacher}</td>
            <td>
                <c:if test="${user!=null}">
                <a href="/course/update/${course.id}" class="btn btn-primary">修改</a>
                <a href="${pageContext.request.contextPath}/courseServlet?opera=del&&id=${course.id}" class="btn btn-danger">删除</a>
                </c:if>
                <c:if test="${user==null}">
                   <a href="${pageContext.request.contextPath}/login.jsp">登录后可操作</a>
                </c:if>

            </td>
        </tr>
    </c:forEach>
    </c:if>
    <c:if test="${courses[0]==null}">
        <tr>
            <td colspan="6">没有数据</td>
        </tr>
    </c:if>
    </tbody>
</table>
user :
${sessionScope.user}
${user}
${sessionScope.user.username}



</body>

</html>
