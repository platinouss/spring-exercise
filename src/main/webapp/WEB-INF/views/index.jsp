<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>platinouss</title>
	<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
</head>
<body>
<div id="menu">
	<ul>
		<li id="logo"><a href="<c:url value='/'/>">springEx</li>
		<li><a href="<c:url value='/board/list'/>">Board</a></li>
		<li><a href="<c:url value='/login/login'/>">Login</a></li>
		<li><a href="<c:url value='/register/add'/>">Sign in</a></li>
	</ul>
</div>
<div style="text-align:center">
	<br>
	<h1>Spring MVC를 통한 웹페이지 제작</h1>
</div>
</body>
</html>