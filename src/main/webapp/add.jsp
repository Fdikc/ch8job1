<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/21
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <<head>
    <title>ch8作业</title>
    <%@ include file="/basejs.jsp" %>
</head>
</head>
<body>
<header>
    <h2 >ch8作业</h2>
</header>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
        </div>
    </div>
</nav>
<div class="panel panel-primary panel-size">
    <div class="panel-heading">
        <p>课程信息录入</p>
    </div>
    <div class="panel-body panel-size">
        <form action="${pageContext.request.contextPath}/courseServlet?opera=addCourse" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="couname" class="col-sm-2 control-label">课程名</label>
            <div  class="col-sm-10">
            <input type="text" class="form-control col-md-10 " id="couname" name="couname" placeholder="课程名" required>
            </div>
        </div>
        <div class="form-group">
            <label for="miaoshu" class="col-sm-2 control-label" >课程描述</label>
            <div  class="col-sm-10">
            <textarea id="miaoshu" name="miaoshu" class="form-control col-md-10 " ></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="teacher" class="col-sm-2 control-label">任课教师</label>
            <div  class="col-sm-10">
            <input type="text" id="teacher" class="form-control col-md-10 "name="teacher" placeholder="任课教师">
            </div>
        </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
             <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
