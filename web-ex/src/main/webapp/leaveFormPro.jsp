<%@page import="user.UserRequestDto"%>
<%@page import="user.User"%>
<%@page import="user.UserDao"%>
<%@page import="user.UserResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserDao dao = UserDao.getInstance();
UserResponseDto user = dao.findById((int)session.getAttribute("log"));

String username = request.getParameter("username");
String password = request.getParameter("password");

if(user != null && user.getPassword().equals(password) 
	&& dao.deleteUser(new UserRequestDto(username, password))) {
	
	session.removeAttribute("log");
	response.sendRedirect("/");
} else {	
	response.sendRedirect("/leave");
}
%>
</body>
</html>