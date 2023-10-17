package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.user.UserDao;
import model.user.UserRequestDto;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		
		UserRequestDto user = new UserRequestDto(username, password, name, email, phone, country, birth, gender);
		
		UserDao dao = UserDao.getInstance();
		boolean result = dao.createUser(user);
		
		String url = "/join";
		
		if(result)
			url = "/login";
		
		response.sendRedirect(url);
		
	}

}
