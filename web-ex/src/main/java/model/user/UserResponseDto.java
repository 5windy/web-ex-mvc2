package model.user;

public class UserResponseDto {
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String country;
	private String birth;
	private String gender;

	public UserResponseDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.country = user.getCountry();
		this.birth = user.getBirth();
		this.gender = user.getGender();
		
	}
	
	public UserResponseDto(UserRequestDto user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.name = user.getName();
	}
	public UserResponseDto(String username, String password, String name, String email, String phone, String country, String birth, String gender) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.birth = birth;
		this.gender = gender;
		
	}
	
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%d) %s/%s : %s", this.id, this.username, this.password, this.name);
	}
}
