<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/form.css">
<title>Join</title>
</head>
<jsp:include page="/header"/>
<body>
	<%
	if(session.getAttribute("log") == null)
		response.sendRedirect("/login");
	%>

	<section>
		<h2>회원정보 수정</h2>
		<form method="POST" action="/service" id="form">
			<input type="hidden" name="command" value="update-user">
			<div>
				<div class="group">
					<input type="text" name="username" id="username" value="${log.username}" readonly>
					<input type="hidden" name="id" id="id" value="${log.id}">
					<input type="password" name="password" id="password" placeholder="비밀번호"> 
					<input type="email" name="email" id="email" value="${log.email }">
				</div>
				<div class="error-msg">
					<ul>
						<li id="error-username">아이디는 필수 입력값입니다.</li>
						<li id="error-password">비밀번호는 필수 입력값입니다.</li>
					</ul>
				</div>
				
				<div class="group">
					<input type="text" name="name" id="name" value="${log.name }" readonly> 
					<input type="text" name="birth" id="birth" value="${log.birth}" readonly> 
					
					<input type="radio" name="gender" value="male" id="male" ${log.gender eq 'male' ? 'checked' : ''} > 
					<input type="radio" name="gender" value="female" id="female" ${log.gender eq 'female' ? 'checked' : ''}> 
					<input type="radio" name="gender" value="other" id="other" ${log.gender eq 'other' ? 'checked' : ''}>
					
					<div id="gender">
						<label for="male" id="for-male">
							<div>Male</div>
						</label> 
						<label for="female" id="for-female">
							<div>Female</div>
						</label> 
						<label for="other" id="for-other">
							<div>Other</div>
						</label>
					</div>
					<div id="country">
						<select name="country">
							<option value="id" ${log.country eq 'id' ? 'selected' : ''} >India +91</option>
							<option value="jp" ${log.country eq 'jp' ? 'selected' : ''}>Japan +81</option>
							<option value="ko" ${log.country eq 'ko' ? 'selected' : ''}>Korea +82</option>
							<option value="mc" ${log.country eq 'mc' ? 'selected' : ''}>Macao +853</option>
							<option value="tg" ${log.country eq 'tg' ? 'selected' : ''}>Togo +228</option>
							<option value="ym" ${log.country eq 'ym' ? 'selected' : ''}>Yemen +967</option>
						</select> 
					</div>
					<input type="text" name="phone" id="phone" value="${log.phone }">
				</div>
				<div class="error-msg">
					<ul>
						<li id="error-name">이름은 필수 입력값입니다.</li>
						<li id="error-birth">생년월일은 필수 입력값입니다.</li>
						<li id="error-phone">전화번호는 필수 입력값입니다. 양식 : ###-####-####</li>
					</ul>
				</div>
			</div>
			<input type="button" value="join" onclick="checkForm(form)" id="btn-submit">
		</form>
	</section>

	<script src="/resources/script/validation.js"></script>
</body>
<jsp:include page="/footer"/>
</html>