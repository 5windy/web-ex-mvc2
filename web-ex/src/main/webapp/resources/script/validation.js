const form = document.getElementById("form");

const input_username = document.getElementById("username");
const input_password = document.getElementById("password");
const input_name = document.getElementById("name");
const input_birth = document.getElementById("birth");
const input_phone = document.getElementById("phone");

const error_username = document.getElementById("error-username");
const error_password = document.getElementById("error-password");
const error_name = document.getElementById("error-name");
const error_birth = document.getElementById("error-birth");
const error_phone = document.getElementById("error-phone");

const regExp = /^\d{3}-\d{4}-\d{4}$/;

form.addEventListener("submit", e => {
	// 기본 동작을 무시 
	e.preventDefault();
	
	checkForm(form);
});

input_username.addEventListener('change', e => {
	if(input_username.value !== '') {
		input_username.style.borderColor = 'lightgrey';
		error_username.style.display = 'none';
	}	
});

input_password.addEventListener('change', e => {
	if(input_password.value !== '') {
		input_password.style.borderColor = 'lightgrey';
		error_password.style.display = 'none';
	}	
});

input_name.addEventListener('change', e => {
	if(input_name.value !== '') {
		input_name.style.borderColor = 'lightgrey';
		error_name.style.display = 'none';
	}	
});

input_birth.addEventListener('change', e => {
	if(input_birth.value !== '') {
		input_birth.style.borderColor = 'lightgrey';
		error_birth.style.display = 'none';
	}	
});

input_phone.addEventListener('change', e => {
	if(input_phone.value !== '') {
		input_phone.style.borderColor = 'lightgrey';
		error_phone.style.display = 'none';
	}	
});

function checkForm(form) {
	console.log('form : ', form);
	
	const username = form.username.value;
	const password = form.password.value;
	const email = form.email.value;
	const name = form.name.value;
	const birth = form.birth.value;
	const gender = form.gender.value;
	const country = form.country.value;
	const phone = form.phone.value;
	
	console.log('username : ', username);
	console.log('password : ', password);
	console.log('email : ', email);
	console.log('name : ', name);
	console.log('birth : ', birth);
	console.log('gender : ', gender);
	console.log('country : ', country);
	console.log('phone : ', phone);
	
	if(username === "") {
		input_username.style.borderColor = 'red';
		error_username.style.display = 'block';
	} 
	else if(password === "") {
		input_password.style.borderColor = 'red';
		error_password.style.display = 'block';
	} 
	else if(name === "") {
		input_name.style.borderColor = 'red';
		error_name.style.display = 'block';
	} 
	else if(birth === "") {
		input_birth.style.borderColor = 'red';
		error_birth.style.display = 'block';
	} 
	else if(phone === "" || !regExp.test(phone)) {
		input_phone.style.borderColor = 'red';
		error_phone.style.display = 'block';
	} 
	else {
		form.submit();
	}
	
	// Update Join
}