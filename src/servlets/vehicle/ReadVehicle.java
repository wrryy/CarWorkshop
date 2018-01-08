package servlets.vehicle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.VehicleDao;
import data.tables.Vehicle;
import system.DbConnection;

@WebServlet("/readvehicle")
public class ReadVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection connection = DbConnection.connect()){
			Vehicle[] vehicles = VehicleDao.getAll(connection) ;
		request.setAttribute("orders", vehicles);
		String readMode = "List of All Vehicles";
		request.setAttribute("rm", readMode);
		getServletContext().getRequestDispatcher("/WEB-INF/vehicle/readVehicle.jsp").forward(request, response);

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
