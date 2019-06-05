<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>/sample/all page</h1>

<!-- all/member/admin 구성 다르게!! -->

<!-- 익명의 사용자거나 로그인 하지 않았을 때 -->
<sec:authorize access="isAnonymous()"> 
	<a href="/customLogin">로그인</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="/customLogout">로그아웃</a>
</sec:authorize>


</body>
</html>