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

@WebServlet("/editorder")
public class EditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			int id = Integer.parseInt(request.getParameter("id"));
			Order record = OrderDao.getById(connection, id);
			request.setAttribute("order", record);
			Worker[] workers = WorkerDao.getAll(connection);
			Vehicle[] vehicles = VehicleDao.getAll(connection);
			request.setAttribute("vehicles", vehicles);
			request.setAttribute("workers", workers);
			getServletContext().getRequestDispatcher("/WEB-INF/order/editOrder.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (Connection connection = DbConnection.connect()) {
			Order order = new Order();
			order.setId(Integer.parseInt(request.getParameter("id")));
			order.setReceiveDate(request.getParameter("receive_date"));
			order.setStartDate(request.getParameter("start_date"));
			order.setPlannedStartDate(request.getParameter("planned_start_date"));
			order.setProblemDescription(request.getParameter("problem_description"));
			order.setRepairDescription(request.getParameter("repair_description"));
			order.setStatus(request.getParameter("status"));
			order.setWorkerId(Integer.parseInt(request.getParameter("worker_id")));
			order.setVehicleId(Integer.parseInt(request.getParameter("vehicle_id")));
			int wId = Integer.parseInt(request.getParameter("worker_id"));
			order.setWorkerId(wId);
			order.setWorkerHourCost(WorkerDao.getById(connection, wId).getHourCost());
			order.setUserCost(Double.parseDouble(request.getParameter("user_cost")));
			order.setPartsCost(Double.parseDouble(request.getParameter("parts_cost")));
			order.setManHours(Double.parseDouble(request.getParameter("man_hours")));
			
			OrderDao.update(connection, order);
			response.sendRedirect(request.getContextPath() + "/readOrder");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while updating database record");
			getServletContext().getRequestDispatcher("/WEB-INF/order/readOrder.jsp").forward(request, response);

			e.printStackTrace();
		}
	}
}