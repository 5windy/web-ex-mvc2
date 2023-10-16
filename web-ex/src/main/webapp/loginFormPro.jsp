<%@page import="user.User"%>
<%@page import="user.UserResponseDto"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	UserDao dao = UserDao.getInstance();
	UserResponseDto user =  dao.findByUsername(username);
	
	session.removeAttribute("log");
	
	if(user != null && user.getPassword().equals(password)) {
		session.setAttribute("log", user.getId());
		session.setAttribute("username", user.getUsername());
		response.sendRedirect("/mypage");
	} else {
		response.sendRedirect("/login");
	}
	%>
</body>
</html>