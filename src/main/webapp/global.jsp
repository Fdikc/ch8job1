<%--标签 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" isELIgnored="false" session="false" %>

<%--ctxPath--%>

<%
    String ctxPath=request.getContextPath();
    pageContext.setAttribute("path",ctxPath, 4);//项目路径
    pageContext.setAttribute("staticPath",ctxPath,4);//静态文件目录
%>
