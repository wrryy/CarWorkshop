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

@WebServlet("/editvehicle")
public class EditVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			int id = Integer.parseInt(request.getParameter("id"));
			Vehicle record = VehicleDao.getById(connection, id);
			request.setAttribute("vehicle", record);
			User[] users = UserDao.getAll(connection);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/WEB-INF/vehicle/editVehicle.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Vehicle vehicle = new Vehicle();
		vehicle.setId(Integer.parseInt(request.getParameter("id")));
		vehicle.setBrand(request.getParameter("brand"));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setPlateNumber(request.getParameter("plate_number"));
		vehicle.setProductionDate(request.getParameter("production_date"));
		vehicle.setServiceDate(request.getParameter("service_date"));
		vehicle.setUserId(Integer.parseInt(request.getParameter("user_id")));

		try (Connection connection = DbConnection.connect()) {
			VehicleDao.update(connection, vehicle);
			response.sendRedirect(request.getContextPath() + "/readvehicle");

		} catch (SQLException e) {
			request.setAttribute("bug", "Encountered problem while updating database record");
			getServletContext().getRequestDispatcher("/WEB-INF/vehicle/readVehicle.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}