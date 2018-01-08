package servlets.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.UserDao;
import data.tables.User;
import system.DbConnection;

@WebServlet("/adduser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/user/addUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setFirstName(request.getParameter("first_name"));
		user.setLastName(request.getParameter("last_name"));
		user.setEmail(request.getParameter("email"));
		user.setBirthDate(request.getParameter("birth_date"));
		
		try (Connection connection = DbConnection.connect()) {
			UserDao.create(connection, user);
			response.sendRedirect(request.getContextPath() + "/readuser");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while adding database record");
			getServletContext().getRequestDispatcher("/WEB-INF/user/readUser.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
