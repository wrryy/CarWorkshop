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

@WebServlet("/addworker")
public class AddWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/worker/addWorker.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Worker worker = new Worker();
		worker.setFirstName(request.getParameter("first_name"));
		worker.setLastName(request.getParameter("last_name"));
		worker.setAddress(request.getParameter("address"));
		worker.setNote(request.getParameter("note"));
		worker.setPhone(request.getParameter("phone"));
		worker.setHourCost(Double.parseDouble(request.getParameter("hour_cost")));

		try (Connection connection = DbConnection.connect()) {
			WorkerDao.create(connection, worker);
			response.sendRedirect(request.getContextPath() + "/readworker");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while adding database record");
			getServletContext().getRequestDispatcher("/WEB-INF/worker/readWorker.jsp").forward(request, response);
			e.getMessage();
		}
	}
}
