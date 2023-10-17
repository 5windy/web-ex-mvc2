package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDao;
import user.UserResponseDto;

public class LoginFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
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
		
		String url = "";
		
		System.out.println("user : " + user);
		
		if(user != null && password.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("log", user);
			
			url = "/mypage";
		} else {
			url = "/login";
		}
		
		response.sendRedirect(url);
	}

}
