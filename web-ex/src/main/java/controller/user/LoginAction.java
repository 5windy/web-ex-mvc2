package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import user.UserDao;
import user.UserResponseDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 처리 로직
		
		// 0) 파라미터 username, password -> 
		// 1) 유저가 존재하는지 확인 
		// 2) 유저의 비밀번호 일치하는지 확인 
		// 2-1) 일치하면 -> /mypage 
		//      session에 log 저장 
		// 2-2) 불일치하면 -> /login
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = UserDao.getInstance();
		UserResponseDto user = userDao.findByUsername(username);
		
		String url = "/login";
		
		System.out.println("user : " + user);
		
		if(user != null && password.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("log", user);
			
			url = "/mypage";
		} 
		
		response.sendRedirect(url);
	}

}
