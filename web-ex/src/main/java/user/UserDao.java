package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public boolean createUser(UserRequestDto user) {
		if(isDuplicatedUser(user)) {
			DBManager.close(conn, pstmt, rs);
			return false;
		}
		
		User newUser = new User(user);
		newUser.setId(generateId());
		
//		String sql = "INSERT INTO `user` VALUES(1234, 'apple', '1234', '김사과', 'apple@naver.com', '010-1234-1234', 'KR', DATE('19990909'), 1)";
		String sql = "INSERT INTO `user` VALUES(?, ?, ?, ?, ?, ?, ?, DATE(?), ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newUser.getId());
			pstmt.setString(2, newUser.getUsername());
			pstmt.setString(3, newUser.getPassword());
			pstmt.setString(4, newUser.getName());
			pstmt.setString(5, newUser.getEmail());
			pstmt.setString(6, newUser.getPhone());
			pstmt.setString(7, newUser.getCountry());
			pstmt.setString(8, newUser.getBirth());
			int gender = 1;
			if(newUser.getGender().equals("female")) gender = 2; 
			else if(newUser.getGender().equals("other")) gender = 3; 
			pstmt.setInt(9, gender);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return true;
	}
	
	public boolean isDuplicatedUser(UserRequestDto user) {
		
		String sql = "SELECT COUNT(*) FROM `user` WHERE username=?";
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt(1);
				
				if(count > 0) 
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private int generateId() {
		int id = 0;
		
		String sql = "SELECT COUNT(*) FROM `user` WHERE id=?";
				
		boolean isDupl = false;
		do {
			id = (int) Math.floor(Math.random() * (9999-1000+1)) + 1000;	// 1000~9999

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int count = rs.getInt(1);
					if(count > 0)
						isDupl = true;
					else 
						isDupl = false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} while(isDupl);
		
		return id;
	}
	
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
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return result;
	}
	
	public UserResponseDto findByUsername(String username) {
		UserResponseDto result = null;
		
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM `user` WHERE username=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int id = rs.getInt(1);
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
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return result;
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
	 */
	
	// 4) Delete
	public boolean deleteUser(UserRequestDto user) {
		String sql = "DELETE FROM `user` WHERE username = ? AND password = ?";
		
		conn = DBManager.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			pstmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return false;
	}
	
//	public int getSize() {
//		return list.size();
//	}

}
