package servlets.worker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.WorkerDao;
import data.tables.Worker;
import system.DbConnection;

@WebServlet("/readworker")
public class ReadWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			Worker[] workers = WorkerDao.getAll(connection);
			request.setAttribute("orders", workers);
			String readMode = "List of All Employees";
			request.setAttribute("rm", readMode);
			getServletContext().getRequestDispatcher("/WEB-INF/worker/readWorker.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
