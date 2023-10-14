<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- 
JSP의 내장객체 

1) out
2) request
3) response
4) page
5) pageContext
6) config
7) session
8) application
9) exception

--%>

<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	System.out.println("id : " + id);
	System.out.println("password : " + password);
	%>
</body>
</html>