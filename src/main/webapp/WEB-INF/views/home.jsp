<%--
  Created by IntelliJ IDEA.
  User: enhyq
  Date: 2022/12/08
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome Home!</h1>
    <h2>Say hi to ${homeName}</h2>
    <h3>This doesn't work ${name}</h3>
    <p>한국어 테스트!</p>
    <p><a href="board/list">게시판으로 가기</a></p>
</body>
</html>
