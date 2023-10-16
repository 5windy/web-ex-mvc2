const form = document.getElementById("form");

const input_username = document.getElementById("username");
const input_password = document.getElementById("password");

const error_username = document.getElementById("error-username");
const error_password = document.getElementById("error-password");

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

function checkForm(form) {
	console.log('form : ', form);
	
	const username = form.username.value;
	const password = form.password.value;
	
	if(username === "") {
		input_username.style.borderColor = 'red';
		error_username.style.display = 'block';
	} 
	else if(password === "") {
		input_password.style.borderColor = 'red';
		error_password.style.display = 'block';
	} 
	else {
		form.submit();
	}
}