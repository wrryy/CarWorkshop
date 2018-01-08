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
import data.dao.WorkerDao;
import data.tables.Order;
import data.tables.Worker;
import system.DbConnection;

@WebServlet("/getorderbyworker")
public class GetOrdersByWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			int id = Integer.parseInt(request.getParameter("vid"));
			Order[] record = OrderDao.getByWorkerId(connection, id);
			request.setAttribute("orders", record);
			
			Worker worker = WorkerDao.getById(connection, id);
			String readMode = "List of Orders by Employee: "+ worker.getFirstName() + " " + worker.getLastName();
			request.setAttribute("rm", readMode);
			getServletContext().getRequestDispatcher("/WEB-INF/order/readOrder.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
