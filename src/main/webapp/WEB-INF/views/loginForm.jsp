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
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <style>
        * { box-sizing:border-box; }
        a { text-decoration: none; }
        form {
            width:400px;
            height:500px;
            display : flex;
            flex-direction: column;
            align-items:center;
            position : absolute;
            top:50%;
            left:50%;
            transform: translate(-50%, -50%) ;
            border: 1px solid #A2D0DB;
            border-radius: 10px;
        }
        input[type='text'], input[type='password'] {
            width: 300px;
            height: 40px;
            border : 1px solid #A2D0DB;
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }
        button {
            background-color: #A2D0DB;
            color : white;
            width:300px;
            height:50px;
            font-size: 17px;
            border : none;
            border-radius: 5px;
            margin : 20px 0 30px 0;
        }
        #title {
            font-size : 50px;
            margin: 40px 0 30px 0;
        }
        #msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            color:#F94141;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div id="menu">
    <ul>
        <li id="logo"><a href="<c:url value='/'/>">springEx</a></li>
        <li><a href="<c:url value='/board/list'/>">Board</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
        <li></li>
    </ul>
</div>

<script>
  let loginMsg = "${loginMsg}";

  if(loginMsg=="LOGIN_ERR") alert("id ?????? pwd??? ???????????? ????????????.");
</script>

<form action="<c:url value="/login/login"/>" method="post" onsubmit="return formCheck(this);">
    <h3 id="title">Login</h3>
    <div id="msg">
        <c:if test="${not empty param.msg}">
            <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>
        </c:if>
    </div>
    <input type="text" name="id" value="${cookie.id.value}" placeholder="?????????" autofocus>
    <input type="password" name="pwd" placeholder="????????????">
    <input type="hidden" name="toURL" value="${param.toURL}">
    <label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> ????????? ??????</label>
    <button>?????????</button>
    <a href="<c:url value='/register/add'/>">????????????</a>
    <script>
        function formCheck(frm) {
            let msg ='';
            if(frm.id.value.length==0) {
                setMessage('id??? ??????????????????.', frm.id);
                return false;
            }
            if(frm.pwd.value.length==0) {
                setMessage('password??? ??????????????????.', frm.pwd);
                return false;
            }
            return true;
        }
        function setMessage(msg, element){
            document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
            if(element) {
                element.select();
            }
        }
    </script>
</form>
</body>
</html>