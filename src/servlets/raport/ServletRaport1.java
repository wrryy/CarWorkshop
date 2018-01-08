package servlets.raport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.DataRaport1;
import data.dao.DataRaport2;
import system.DbConnection;

@WebServlet("/home")
public class ServletRaport1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/raport/get.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DbConnection.connect()) {
			String fromDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			String rap = request.getParameter("rap");
			if (rap.matches("Raport 1")) {
				DataRaport1[] orders = DataRaport1.generate(connection, fromDate, toDate);
				request.setAttribute("raport", orders);
				getServletContext().getRequestDispatcher("/WEB-INF/raport/rap1.jsp").forward(request, response);

			}else if(rap.matches("Raport 2")) {
				DataRaport2[] orders = DataRaport2.generate(connection, fromDate, toDate);
				request.setAttribute("raport", orders);
				getServletContext().getRequestDispatcher("/WEB-INF/raport/rap2.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
