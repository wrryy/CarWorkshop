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
import data.tables.Order;
import system.DbConnection;

/**
 * Servlet implementation class Home
 */
@WebServlet("/readOrder")
public class ReadOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection connection = DbConnection.connect()){
		Order[] orders = OrderDao.getAll(connection) ;
		request.setAttribute("orders", orders);
		String readMode = "List of All Orders";
		request.setAttribute("rm", readMode);
		getServletContext().getRequestDispatcher("/WEB-INF/order/readOrder.jsp").forward(request, response);

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
