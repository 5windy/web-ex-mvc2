<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>
<jsp:include page="/header"/>
<body>
	<section>
		<h2>로그인</h2>
		<form method="POST" action="/service" id="form">
			<input type="hidden" name="command" value="login">
			<div>
				<div class="group">
					<input type="text" name="username" id="username" placeholder="아이디">
					<input type="password" name="password" id="password" placeholder="패스워드">
				</div>
				<div class="error-msg">
					<ul>
						<li id="error-username">아이디는 필수 입력값입니다.</li>
						<li id="error-password">비밀번호는 필수 입력값입니다.</li>
					</ul>
				</div>
			</div>
			<input type="button" value="login" id="btn-submit" onclick="checkForm(form)">
		</form>
	</section>
	<script src="/resources/script/user-validation.js"></script>
</body>
<jsp:include page="/footer"/>
</html>