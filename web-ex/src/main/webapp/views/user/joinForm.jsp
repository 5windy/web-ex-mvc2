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
	<section>
		<h2>회원가입</h2>
		<form method="POST" action="/service" id="form">
			<input type="hidden" name="command" value="join">
			<div>
				<div class="group">
					<input type="text" name="username" id="username" placeholder="아이디">
					<input type="password" name="password" id="password" placeholder="비밀번호"> 
					<input type="email" name="email" id="email" placeholder="이메일 (Optional)">
				</div>
				<div class="error-msg">
					<ul>
						<li id="error-username">아이디는 필수 입력값입니다.</li>
						<li id="error-password">비밀번호는 필수 입력값입니다.</li>
					</ul>
				</div>
				
				<div class="group">
					<input type="text" name="name" id="name" placeholder="이름"> 
					<input type="number" name="birth" id="birth" min="19000101" max="99999999" placeholder="생년월일"> 
					
					<input type="radio" name="gender" value="male" id="male" checked> 
					<input type="radio" name="gender" value="female" id="female"> 
					<input type="radio" name="gender" value="other" id="other">
					
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
							<option value="id">India +91</option>
							<option value="jp">Japan +81</option>
							<option value="ko" selected>Korea +82</option>
							<option value="mc">Macao +853</option>
							<option value="tg">Togo +228</option>
							<option value="ym">Yemen +967</option>
						</select> 
					</div>
					<input type="text" name="phone" id="phone" placeholder="전화번호 ###-####-####">
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