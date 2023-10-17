package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.user.UserDao;
import model.user.UserRequestDto;

public class LeaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao dao = UserDao.getInstance();
		
		UserRequestDto user = new UserRequestDto(username, password);
		boolean result = dao.deleteUser(user);
		
		String url = "/";
		
		if(result) {
			request.getSession().invalidate();
		} else {
			url = "/leave";
		}
		
		response.sendRedirect(url);
	}
	

}
