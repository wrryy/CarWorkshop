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
import system.DbConnection;

@WebServlet("/deletevehicle")
public class DeleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try (Connection connection = DbConnection.connect()) {
			int id = Integer.parseInt(request.getParameter("id"));
			VehicleDao.delete(connection, id);
			response.sendRedirect(request.getContextPath() + "/readvehicle");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
