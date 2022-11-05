<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/21
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>ch8作业</title>
    <%@ include file="/basejs.jsp" %>
</head>

<body>
<header>
    <h2>ch8作业</h2>
</header>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
    </div>
</nav>

      <div class="panel panel-primary panel-size">
          <div class="panel-heading">
              <p>课程信息明细</p>
          </div>
          <div class="panel-body">
        <table class="table">
            <tr>
                <td>课程名</td>
                <td>
<%--                   如果课程名含有java 则输出英语教学--%>

    <c:if test="${fn:contains(course.couname,'JAVA')}">
         ${course.couname} (英语教学)
    </c:if>
    <c:if test="${!fn:contains(course.couname,'JAVA')}">
        ${course.couname}
    </c:if>


<%--                    ${course.couname}--%>
                </td>
            </tr>
            <tr>
                <td>课程描述</td>
                <td>${course.miaoshu}</td>
            </tr>
            <tr>
                <td>课程封面</td>
                <td>
                    <img src="images/${course.pic}" width="100px" height="100px" alt="课程封面">
                </td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td>
                    <fmt:formatDate value="${course.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
            <tr>
                <td>教师</td>
                <td>${course.teacher}</td>
            </tr>

        </table>
          </div>
      </div>
    </div>

</body>
</html>
