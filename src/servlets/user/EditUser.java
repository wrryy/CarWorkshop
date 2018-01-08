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

@WebServlet("/edituser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			int id = Integer.parseInt(request.getParameter("id"));
			User record = UserDao.getById(connection, id);
			request.setAttribute("user", record);
			getServletContext().getRequestDispatcher("/WEB-INF/user/editUser.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setFirstName(request.getParameter("first_name"));
		user.setLastName(request.getParameter("last_name"));
		user.setEmail(request.getParameter("email"));
		user.setBirthDate(request.getParameter("birth_date"));

		try (Connection connection = DbConnection.connect()) {
			UserDao.update(connection, user);
			response.sendRedirect(request.getContextPath() + "/readuser");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while updating database record");
			getServletContext().getRequestDispatcher("/WEB-INF/user/readUser.jsp").forward(request, response);

			e.printStackTrace();
		}
	}
}