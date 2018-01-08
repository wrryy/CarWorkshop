package servlets.vehicle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.UserDao;
import data.dao.VehicleDao;
import data.tables.User;
import data.tables.Vehicle;
import system.DbConnection;

@WebServlet("/addvehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			User[] users = UserDao.getAll(connection);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/WEB-INF/vehicle/addVehicle.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while reading database ");
			getServletContext().getRequestDispatcher("/WEB-INF/vehicle/readVehicle.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Vehicle vehicle = new Vehicle();
		vehicle.setBrand(request.getParameter("brand"));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setPlateNumber(request.getParameter("plate_number"));
		vehicle.setProductionDate(request.getParameter("production_date"));
		vehicle.setServiceDate(request.getParameter("service_date"));
		vehicle.setUserId(Integer.parseInt(request.getParameter("user_id")));

		try (Connection connection = DbConnection.connect()) {
			VehicleDao.create(connection, vehicle);
			response.sendRedirect(request.getContextPath() + "/readvehicle");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while adding database record");
			getServletContext().getRequestDispatcher("/WEB-INF/vehicle/readVehicle.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}
