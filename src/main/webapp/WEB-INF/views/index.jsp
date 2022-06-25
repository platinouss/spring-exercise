<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>

<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>platinouss</title>
	<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<script>
	let regMsg = "${regMsg}";
	if(regMsg == "REG_OK") alert("회원가입에 성공하였습니다.");
</script>
<div id="menu">
	<ul>
		<li id="logo"><a href="<c:url value='/'/>">springEx</li>
		<li><a href="<c:url value='/board/list'/>">Board</a></li>
		<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
		<li><a href="<c:url value='/register/add'/>">Sign in</a></li>
	</ul>
</div>
<div style="text-align:center">
	<br>
	<h1>Spring MVC를 통한 웹페이지 제작</h1>
</div>
</body>
</html>