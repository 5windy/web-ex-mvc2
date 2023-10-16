<%@page import="user.UserRequestDto"%>
<%@page import="user.UserDao"%>
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
// java 문장만 작성하기 
// response 내장객체 활용 -> sendRedirect() 호출, mypage로 이동

UserDao dao = UserDao.getInstance();

String username = request.getParameter("username");
String password = request.getParameter("password");
String email = request.getParameter("email");
String name = request.getParameter("name");
String birth = request.getParameter("birth");
String gender = request.getParameter("gender");
String country = request.getParameter("country");
String phone = request.getParameter("phone");

UserRequestDto user = new UserRequestDto(username, password, name, email, phone, country, birth, gender); 
boolean result = dao.createUser(user);

if(result) {
	response.sendRedirect("/login");
} else {
	response.sendRedirect("/join");
}


%>
</body>
</html>