package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDao;
import user.UserRequestDto;

/**
 * Servlet implementation class EditUserFormAction
 */
@WebServlet("/EditUserFormAction")
public class EditUserFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
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
