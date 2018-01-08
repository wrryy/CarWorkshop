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

@WebServlet("/readuser")
public class ReadUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection connection = DbConnection.connect()){
		User[] users = UserDao.getAll(connection) ;
		request.setAttribute("orders", users);
		getServletContext().getRequestDispatcher("/WEB-INF/user/readUser.jsp").forward(request, response);

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
