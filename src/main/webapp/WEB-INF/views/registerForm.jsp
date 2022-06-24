<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.net.URLDecoder"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <style>
    * { box-sizing:border-box; }

    form {
      width:400px;
      height:600px;
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

    .input-field {
      width: 300px;
      height: 40px;
      border : 1px solid #A2D0DB;
      border-radius:5px;
      padding: 0 10px;
      margin-bottom: 10px;
    }

    label {
      width:300px;
      height:30px;
      margin-top :4px;
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

    .title {
      font-size : 50px;
      margin: 40px 0 30px 0;
      color: #527198;
    }

    .msg {
      height: 30px;
      text-align:center;
      font-size:16px;
      color:#F94141;
      margin-bottom: 20px;
    }

    .sns-chk {
      margin-top : 5px;
    }
  </style>
  <title>Register</title>
</head>
<body>

<%--<script>--%>
<%--  let msg = "${msg}";--%>

<%--  if(msg=="REG_ERR") alert("회원가입에 실패하였습니다. 다시 시도해주세요.");--%>
<%--</script>--%>

<%-- <form:form> 태그는 POST가 기본 --%>
<form:form modelAttribute="userDto">
  <div class="title">Register</div>
  <div id="msg" class="msg"><form:errors path="id"/></div>
  <label for="">아이디</label>
  <input class="input-field" type="text" name="id" placeholder="3글자 이상의 영대소문자와 숫자조합">
  <label for="">비밀번호</label>
  <input class="input-field" type="text" name="pwd" placeholder="8~12자리의 영대소문자와 숫자 조합">
  <label for="">이름</label>
  <input class="input-field" type="text" name="name" placeholder="홍길동">
  <label for="">이메일</label>
  <input class="input-field" type="text" name="email" placeholder="example@naver.com">
  <label for="">생일</label>
  <input class="input-field" type="text" name="birth" placeholder="2022-03-01">
  <button>회원 가입</button>
</form:form>

</body>
</html>