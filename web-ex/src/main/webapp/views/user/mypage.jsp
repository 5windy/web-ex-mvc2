<%@page import="model.user.UserDao"%>
<%@page import="model.user.UserResponseDto"%>
<%@page import="model.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<jsp:include page="/header"/>
<body>
<section>
	<%
	if(session.getAttribute("log") == null)
		response.sendRedirect("/login");
	%>

	<h2>${log.username }님 환영합니다.</h2>
	
	<a href="edit">회원정보 수정</a>
	<a href="/service?command=logout">로그아웃</a>
	<a href="/leave">회원탈퇴</a>
</section>
</body>
<jsp:include page="/footer"/>
</html>