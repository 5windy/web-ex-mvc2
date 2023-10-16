package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import util.DBManager;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private UserDao() {}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	// DB에 연동 
	// 1) Create
	/*
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
	*/
	
	// 2) Read
	public UserResponseDto findById(int id) {
		UserResponseDto result = null;
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM `user` WHERE id=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String username = rs.getString(2);
					String password = rs.getString(3);
					String name = rs.getString(4);
					String email = rs.getString(5);
					String phone = rs.getString(6);
					String country = rs.getString(7);
					String birth = rs.getString(8);
					int gender = rs.getInt(9);
					
					String genderStr = "";
					if(gender == 1) genderStr = "male";
					else if(gender == 2) genderStr = "female";
					else if(gender == 3) genderStr = "other";
					
					result = new UserResponseDto(new User(id, username, password, name, email, phone, country, birth, genderStr));
					System.out.println("result : " + result);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public UserResponseDto findByUsername(String username) {
		
		return null;
	}
	/*
	
	private User getUser(UserRequestDto userDto) {
		User user = null;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUsername().equals(userDto.getUsername())) {
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
	*/

}
