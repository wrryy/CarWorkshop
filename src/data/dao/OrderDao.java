package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.tables.Order;

public class OrderDao { 
	private static final String Create = "Insert into  orderr(receive_date, start_date, planned_start_date, problem_description, repair_description, "
			+ "status, worker_id, vehicle_id,worker_hour_cost,user_cost, parts_cost, man_hours) Values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String Update = "Update orderr Set receive_date=?, start_date=?, planned_start_date=?, problem_description=?, "
			+ "repair_description=?,status=?, worker_id=?, vehicle_id=?,worker_hour_cost=?,user_cost=?, parts_cost=?, man_hours=? Where id = ?";
	private static final String Delete = "DELETE FROM orderr WHERE id= ?";
	private static final String GetAll = "SELECT * FROM orderr";
	private static final String GetById = "SELECT * FROM orderr where id=?";
	private static final String GetByVehicleId = "SELECT * FROM orderr WHERE vehicle_id=?";
	private static final String GetByWorkerId = "SELECT * FROM orderr WHERE worker_id=?";

	/**
	 * Inserts Order to DB.
	 * 
	 * @param connection
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public static Order create(Connection connection, Order order) throws SQLException {
		String[] generatedColumns = { "id" };
		PreparedStatement pst = connection.prepareStatement(Create, generatedColumns);
		pst.setString(1, order.getReceiveDate());
		pst.setString(2, order.getStartDate());
		pst.setString(3, order.getPlannedStartDate());
		pst.setString(4, order.getProblemDescription());
		pst.setString(5, order.getRepairDescription());
		pst.setString(6, order.getStatus());
		pst.setInt(7, order.getWorkerId());
		pst.setInt(8, order.getVehicleId());
		pst.setDouble(9, order.getWorkerHourCost());
		pst.setDouble(10, order.getUserCost());
		pst.setDouble(11, order.getPartsCost());
		pst.setDouble(12, order.getManHours());
		pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		if (rs.next()) {
			order.setId(rs.getInt(1));
		}
		return order;
	}

	/**
	 * Updates Order in DB.
	 * 
	 * @param connection
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public static Order update(Connection connection, Order order) throws SQLException {

		PreparedStatement pst = connection.prepareStatement(Update);
		pst.setString(1, order.getReceiveDate());
		pst.setString(2, order.getStartDate());
		pst.setString(3, order.getPlannedStartDate());
		pst.setString(4, order.getProblemDescription());
		pst.setString(5, order.getRepairDescription());
		pst.setString(6, order.getStatus() + "");
		pst.setInt(7, order.getWorkerId());
		pst.setInt(8, order.getVehicleId());
		pst.setDouble(9, order.getWorkerHourCost());
		pst.setDouble(10, order.getUserCost());
		pst.setDouble(11, order.getPartsCost());
		pst.setDouble(12, order.getManHours());
		pst.setInt(13, order.getId());
		pst.executeUpdate();
		return order;
	}

	/**
	 * Deletes Order from DB.
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void delete(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(Delete);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	/**
	 * Returns list of all Orders.
	 * 
	 * @param connection
	 * @return Order[]
	 * @throws SQLException
	 */
	public static Order[] getAll(Connection connection) throws SQLException {
		ArrayList<Order> orders = new ArrayList<>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(GetAll);

		while (rs.next()) {
			Order tempOrder = new Order();
			tempOrder.setId(rs.getInt("id"));
			tempOrder.setReceiveDate(rs.getString("receive_date"));
			tempOrder.setStartDate(rs.getString("start_date"));
			tempOrder.setPlannedStartDate(rs.getString("planned_start_date"));
			tempOrder.setProblemDescription(rs.getString("problem_description"));
			tempOrder.setRepairDescription(rs.getString("repair_description"));
			tempOrder.setStatus(rs.getString("status"));
			tempOrder.setWorkerId(rs.getInt("worker_id"));
			tempOrder.setVehicleId(rs.getInt("vehicle_id"));
			tempOrder.setWorkerHourCost(rs.getDouble("worker_hour_cost"));
			tempOrder.setUserCost(rs.getDouble("user_cost"));
			tempOrder.setPartsCost(rs.getDouble("parts_cost"));
			tempOrder.setManHours(rs.getDouble("man_hours"));
			orders.add(tempOrder);

		}
		Order[] orderArray = new Order[orders.size()];
		orders.toArray(orderArray);
		return orderArray;
	}

	/**
	 * Returns Order by ID.
	 * 
	 * @param connection
	 * @param id
	 * @return Order
	 * @throws SQLException
	 * @throws NullPointerException
	 */
	static public Order getById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(GetById);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			Order tempOrder = new Order();
			tempOrder.setId(rs.getInt("id"));
			tempOrder.setReceiveDate(rs.getString("receive_date"));
			tempOrder.setStartDate(rs.getString("start_date"));
			tempOrder.setPlannedStartDate(rs.getString("planned_start_date"));
			tempOrder.setProblemDescription(rs.getString("problem_description"));
			tempOrder.setRepairDescription(rs.getString("repair_description"));
			tempOrder.setStatus(rs.getString("status"));
			tempOrder.setWorkerId(rs.getInt("worker_id"));
			tempOrder.setVehicleId(rs.getInt("vehicle_id"));
			tempOrder.setWorkerHourCost(rs.getDouble("worker_hour_cost"));
			tempOrder.setUserCost(rs.getDouble("user_cost"));
			tempOrder.setPartsCost(rs.getDouble("parts_cost"));
			tempOrder.setManHours(rs.getDouble("man_hours"));
			return tempOrder;
		}
		return null;
	}
	
	static public Order[] getByVehicleId(Connection connection, int workerId) throws SQLException {
		ArrayList<Order> orders = new ArrayList<>();
		PreparedStatement preparedStatement = connection.prepareStatement(GetByVehicleId);
		preparedStatement.setInt(1, workerId);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Order tempOrder = new Order();
			tempOrder.setId(rs.getInt("id"));
			tempOrder.setReceiveDate(rs.getString("receive_date"));
			tempOrder.setStartDate(rs.getString("start_date"));
			tempOrder.setPlannedStartDate(rs.getString("planned_start_date"));
			tempOrder.setProblemDescription(rs.getString("problem_description"));
			tempOrder.setRepairDescription(rs.getString("repair_description"));
			tempOrder.setStatus(rs.getString("status"));
			tempOrder.setWorkerId(rs.getInt("worker_id"));
			tempOrder.setVehicleId(rs.getInt("vehicle_id"));
			tempOrder.setWorkerHourCost(rs.getDouble("worker_hour_cost"));
			tempOrder.setUserCost(rs.getDouble("user_cost"));
			tempOrder.setPartsCost(rs.getDouble("parts_cost"));
			tempOrder.setManHours(rs.getDouble("man_hours"));
			orders.add(tempOrder);
		}
		Order[] orderArray = new Order[orders.size()];
		orders.toArray(orderArray);
		return orderArray;
	}
	static public Order[] getByWorkerId(Connection connection, int workerId) throws SQLException {
		ArrayList<Order> orders = new ArrayList<>();
		PreparedStatement preparedStatement = connection.prepareStatement(GetByWorkerId);
		preparedStatement.setInt(1, workerId);
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			Order tempOrder = new Order();
			tempOrder.setId(rs.getInt("id"));
			tempOrder.setReceiveDate(rs.getString("receive_date"));
			tempOrder.setStartDate(rs.getString("start_date"));
			tempOrder.setPlannedStartDate(rs.getString("planned_start_date"));
			tempOrder.setProblemDescription(rs.getString("problem_description"));
			tempOrder.setRepairDescription(rs.getString("repair_description"));
			tempOrder.setStatus(rs.getString("status"));
			tempOrder.setWorkerId(rs.getInt("worker_id"));
			tempOrder.setVehicleId(rs.getInt("vehicle_id"));
			tempOrder.setWorkerHourCost(rs.getDouble("worker_hour_cost"));
			tempOrder.setUserCost(rs.getDouble("user_cost"));
			tempOrder.setPartsCost(rs.getDouble("parts_cost"));
			tempOrder.setManHours(rs.getDouble("man_hours"));
			orders.add(tempOrder);
		}
		Order[] orderArray = new Order[orders.size()];
		orders.toArray(orderArray);
		return orderArray;
	}
}
