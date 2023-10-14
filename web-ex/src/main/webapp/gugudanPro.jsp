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
	String[] ans = request.getParameterValues("ans");
	String[] z = request.getParameterValues("z");
	
	int score = 100;
	%>

	<h1>성적표</h1>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>정답</th>
				<th>답안</th>
				<th>결과</th>
			</tr>
		</thead>
		<tbody>
		<%
		for(int i=0; i<ans.length; i++) {
		%>
			<tr>
				<td><%=i+1 %></td>
				<td><%=z[i] %></td>
				<td><%=ans[i] %></td>
				<td><%=z[i].equals(ans[i]) ? "O" : "X" %></td>
				
				<%
				score = z[i].equals(ans[i]) ? score : score - 20;
				%>
			</tr>
		<%} %>
		</tbody>
		<tr>
			<td>점수</td>
			<td colspan="3"><%=score %></td>
		</tr>
	</table>
	
</body>
</html>