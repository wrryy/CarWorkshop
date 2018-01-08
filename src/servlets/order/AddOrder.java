package servlets.order;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.OrderDao;
import data.dao.VehicleDao;
import data.dao.WorkerDao;
import data.tables.Order;
import data.tables.Vehicle;
import data.tables.Worker;
import system.DbConnection;

@WebServlet("/addorder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			Worker[] workers = WorkerDao.getAll(connection);
			Vehicle[] vehicles = VehicleDao.getAll(connection);
			request.setAttribute("vehicles", vehicles);
			request.setAttribute("workers", workers);
			getServletContext().getRequestDispatcher("/WEB-INF/order/addOrder.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while reading database ");
			getServletContext().getRequestDispatcher("/WEB-INF/order/readOrder.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (Connection connection = DbConnection.connect()) {
			Order order = new Order();
			order.setReceiveDate(request.getParameter("receive_date"));
			order.setStartDate(request.getParameter("start_date"));
			order.setPlannedStartDate(request.getParameter("planned_start_date"));
			order.setProblemDescription(request.getParameter("problem_description"));
			order.setRepairDescription(request.getParameter("repair_description"));
			order.setStatus(request.getParameter("status"));
			int wId = Integer.parseInt(request.getParameter("worker_id"));
			order.setWorkerId(wId);
			order.setWorkerHourCost(WorkerDao.getById(connection, wId).getHourCost());
			order.setVehicleId(Integer.parseInt(request.getParameter("vehicle_id")));
			order.setUserCost(Double.parseDouble(request.getParameter("user_cost")));
			order.setPartsCost(Double.parseDouble(request.getParameter("parts_cost")));
			order.setManHours(Double.parseDouble(request.getParameter("man_hours")));

			OrderDao.create(connection, order);
			response.sendRedirect(request.getContextPath() + "/readOrder");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while adding database record");
			getServletContext().getRequestDispatcher("/WEB-INF/order/readOrder.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}
