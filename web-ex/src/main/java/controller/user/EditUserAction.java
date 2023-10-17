package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.user.UserDao;
import model.user.UserRequestDto;

public class EditUserAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = UserDao.getInstance();
		
		UserRequestDto user = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		
		user = new UserRequestDto(id, username, password, name, email, phone, country, birth, gender);
		
		boolean result = dao.setUser(user);
		
		if(result) {
			request.getSession().setAttribute("log", user);
		}
		
		response.sendRedirect("/edit");
		
	}

}
