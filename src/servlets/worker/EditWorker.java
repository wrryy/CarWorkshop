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

@WebServlet("/editworker")
public class EditWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			int id = Integer.parseInt(request.getParameter("id"));
			Worker record = WorkerDao.getById(connection, id);
			request.setAttribute("worker", record);
			getServletContext().getRequestDispatcher("/WEB-INF/worker/editWorker.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Worker worker = new Worker();
		worker.setId(Integer.parseInt(request.getParameter("id")));
		worker.setFirstName(request.getParameter("first_name"));
		worker.setLastName(request.getParameter("last_name"));
		worker.setAddress(request.getParameter("address"));
		worker.setNote(request.getParameter("note"));
		worker.setPhone(request.getParameter("phone"));
		worker.setHourCost(Double.parseDouble(request.getParameter("hour_cost")));

		try (Connection connection = DbConnection.connect()) {
			WorkerDao.update(connection, worker);
			response.sendRedirect(request.getContextPath() + "/readworker");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while updating database record");
			getServletContext().getRequestDispatcher("/WEB-INF/worker/readWorker.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}