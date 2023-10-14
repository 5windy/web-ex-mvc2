package user;

import java.util.ArrayList;

public class UserDao {
	
	private ArrayList<User> list;
	
	// GoF 디자인 패턴 중 > 생성 패턴 중 하나인 > Singleton Pattern
	
	// 1) 생성자를 private로 돌림
	// ㄴ new 키워드 사용 X
	// ㄴ 클래스 외부에서 객체를 생성할 수 없도록 차단 
	private UserDao() {
		list = new ArrayList<>();
	}
	
	// 2) 단일 객체를 생성함 
	// ㄴ 클래스 내부에서만 private 생성자를 사용할 수 O 
	// ㄴ static 영역에 둠 
	private static UserDao instance = new UserDao();
	
	// 3) public static getter 제공 
	// ㄴ UserDao 객체를 얻을 수 있는 유일한 메소드 
	public static UserDao getInstance() {
		return instance;
	}
	
	
	// User에 대한 CRUD 메소드를 구현 
	// ㄴ 저장소 : list
	
	// 1) Create
	public boolean createUser(UserRequestDto user) {
		if(isDuplicatedUser(user)) 
			return false;
		
		User newUser = new User(user);
		newUser.setId(generateId());
		list.add(newUser);
		
		return true;
	}
	
	public boolean isDuplicatedUser(UserRequestDto user) {
		
		for(int i=0; i<list.size(); i++) {
			if(user.getUsername().equals(list.get(i).getUsername()))
				return true;
		}
		return false;
	}
	
	private int generateId() {
		int id = 0;
		
		boolean isDupl = false;
		do {
			id = (int) Math.floor(Math.random() * (9999-1000+1)) + 1000;	// 1000~9999

			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getId() == id)
					isDupl = true;
			}
		} while(isDupl);
		
		return id;
	}
	
	// 2) Read
	public UserResponseDto findById(int id) {
		for(int i=0; i<list.size(); i++) {
			User user = list.get(i);
			if(user.getId() == id)
				return new UserResponseDto(user);
		}
		return null;
	}
	
	public UserResponseDto findByUsername(String username) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUsername().equals(username))
				return new UserResponseDto(list.get(i));
		}
		
		return null;
	}
	
	private User getUser(UserRequestDto userDto) {
		User user = null;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUsername() == userDto.getUsername()) {
				user = list.get(i);
				System.out.println("user : " + System.identityHashCode(user));
			}
		}
		
		return user;
	}
	
	public ArrayList<UserResponseDto> findAll() {
		// private list 리턴 X (사본) 
		ArrayList<UserResponseDto> response = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			User user = list.get(i);
			response.add(new UserResponseDto(user));
		}
		
		return response;
	}
	
	// 3) Update (password)
	public boolean setUser(UserRequestDto user, String password) {
		User target = getUser(user);
		
		if(target == null)
			return false;
		
		if(!target.getPassword().equals(user.getPassword()))
			return false;
		
		target.setPassword(password);
		
		return true;
	}
	
	// 4) Delete
	public boolean deleteUser(UserRequestDto user) {
		User target = getUser(user);
		System.err.println("target : " + System.identityHashCode(target));
		
		if(target == null)
			return false;;
		
		if(!target.getPassword().equals(user.getPassword()))
			return false;
		
		list.remove(target);
			
		return true;
	}
	
	public int getSize() {
		return list.size();
	}

}
