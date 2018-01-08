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

@WebServlet("/getvehiclebyuser")
public class GetVehiclesByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			int id = Integer.parseInt(request.getParameter("wid"));
			Vehicle[] record = VehicleDao.getByUserId(connection, id);
			request.setAttribute("orders", record);

			User user = UserDao.getById(connection, id);
			String readMode = "List of vehicles by Client: "+ user.getFirstName() + " " + user.getLastName();
			request.setAttribute("rm", readMode);
			getServletContext().getRequestDispatcher("/WEB-INF/vehicle/readVehicle.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
