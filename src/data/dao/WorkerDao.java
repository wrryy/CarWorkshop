package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.tables.Worker;

public class WorkerDao {

	private static final String Create = "Insert into  worker(first_name, last_name, address, phone, note, hour_cost) Values(?,?,?,?,?,?)";
	private static final String Update = "Update worker Set first_name=?, last_name=?, address=?, phone=?, note=?, hour_cost=? Where id = ?";
	private static final String Delete = "DELETE FROM worker WHERE id= ?";
	private static final String GetAll = "Select * from worker";
	private static final String GetById = "SELECT * FROM worker where id=?";

	/**
	 * Inserts Worker to DB.
	 * 
	 * @param connection
	 * @param worker
	 * @return
	 * @throws SQLException
	 */
	public static Worker create(Connection connection, Worker worker) throws SQLException {
		String[] generatedColumns = { "id" };
		PreparedStatement pst = connection.prepareStatement(Create, generatedColumns);
		pst.setString(1, worker.getFirstName());
		pst.setString(2, worker.getLastName());
		pst.setString(3, worker.getAddress());
		pst.setString(4, worker.getPhone());
		pst.setString(5, worker.getNote());
		pst.setDouble(6, worker.getHourCost());
		pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		if (rs.next()) {
			worker.setId(rs.getInt(1));
		}
		return worker;
	}
	
	/**Updates Worker in DB.
	 * 
	 * @param connection
	 * @param worker
	 * @return
	 * @throws SQLException
	 */
	public static Worker update(Connection connection, Worker worker) throws SQLException {

		PreparedStatement pst = connection.prepareStatement(Update);
		pst.setString(1, worker.getFirstName());
		pst.setString(2, worker.getLastName());
		pst.setString(3, worker.getAddress());
		pst.setString(4, worker.getPhone());
		pst.setString(5, worker.getNote());
		pst.setDouble(6, worker.getHourCost());
		pst.setInt(7, worker.getId());
		pst.executeUpdate();
		return worker;
	}

	/**
	 * Deletes Worker from DB.
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
	 * Returns list of all Workers.
	 * 
	 * @param connection
	 * @return Worker[]
	 * @throws SQLException
	 */
	static public Worker[] getAll(Connection connection) throws SQLException {
		ArrayList<Worker> workers = new ArrayList<>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(GetAll);

		while (rs.next()) {
			Worker tempWorker = new Worker();
			tempWorker.setId(rs.getInt("id"));
			tempWorker.setFirstName(rs.getString("first_name"));
			tempWorker.setLastName(rs.getString("last_name"));
			tempWorker.setAddress(rs.getString("address"));
			tempWorker.setNote(rs.getString("note"));
			tempWorker.setPhone(rs.getString("phone"));
			tempWorker.setHourCost(rs.getDouble("hour_cost"));
			workers.add(tempWorker);
		}
		Worker[] workerArray = new Worker[workers.size()];
		workers.toArray(workerArray);
		return workerArray;
	}

	/**
	 * Returns Worker by ID.
	 * 
	 * @param connection
	 * @param id
	 * @return Worker
	 * @throws SQLException
	 * @throws NullPointerException
	 */
	static public Worker getById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(GetById);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			Worker tempWorker = new Worker();
			tempWorker.setId(rs.getInt("id"));
			tempWorker.setFirstName(rs.getString("first_name"));
			tempWorker.setLastName(rs.getString("last_name"));
			tempWorker.setAddress(rs.getString("address"));
			tempWorker.setNote(rs.getString("note"));
			tempWorker.setPhone(rs.getString("phone"));
			tempWorker.setHourCost(rs.getDouble("hour_cost"));
			return tempWorker;
		}
		return null;
	}
}
