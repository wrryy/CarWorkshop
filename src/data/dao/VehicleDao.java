package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.tables.Vehicle;

public class VehicleDao {
	private static final String Create = "Insert into vehicle(model, brand, production_date, plate_number, service_date) Values(?,?,?,?,?)";
	private static final String Update = "Update vehicle Set model=?, brand=?, production_date=?, plate_number=?, service_date=? Where id = ?";
	private static final String Delete = "DELETE FROM vehicle WHERE id = ?";
	private static final String GetAll = "Select * FROM vehicle";
	private static final String GetById = "SELECT * FROM vehicle where id =?";

	/**
	 * Inserts User to DB.
	 * 
	 * @param connection
	 * @param vehicle
	 * @return
	 * @throws SQLException
	 */
	public Vehicle create(Connection connection, Vehicle vehicle) throws SQLException {
		String[] generatedColumns = { "id" };
		PreparedStatement pst = connection.prepareStatement(Create, generatedColumns);
		pst.setString(1, vehicle.getModel());
		pst.setString(2, vehicle.getBrand());
		pst.setTimestamp(3, vehicle.getProductionDate());
		pst.setString(4, vehicle.getPlateNumber());
		pst.setTimestamp(5, vehicle.getServiceDate());
		pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		if (rs.next()) {
			vehicle.setId(rs.getInt(1));
		}
		return vehicle;
	}
	
	/**
	 * Updates User in DB.
	 * 
	 * @param connection
	 * @param vehicle
	 * @return
	 * @throws SQLException
	 */
	public Vehicle update(Connection connection, Vehicle vehicle) throws SQLException {

		PreparedStatement pst = connection.prepareStatement(Update);
		pst.setString(1, vehicle.getModel());
		pst.setString(2, vehicle.getBrand());
		pst.setTimestamp(3, vehicle.getProductionDate());
		pst.setString(4, vehicle.getPlateNumber());
		pst.setTimestamp(5, vehicle.getServiceDate());
		pst.setInt(6, vehicle.getId());
		pst.executeUpdate();
		return vehicle;
	}

	/**
	 * Deletes Vehicle from DB.
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public void delete(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(Delete);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	/**
	 * Returns list of all Vehicles.
	 * 
	 * @param connection
	 * @return Vehicles[]
	 * @throws SQLException
	 */
	static public Vehicle[] getAll(Connection connection) throws SQLException {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(GetAll);

		while (rs.next()) {
			Vehicle tempVehicle = new Vehicle();
			tempVehicle.setId(rs.getInt("id"));
			tempVehicle.setBrand(rs.getString("brand"));
			tempVehicle.setModel(rs.getString("model"));
			tempVehicle.setPlateNumber(rs.getString("plate_number"));
			tempVehicle.setProductionDate(rs.getTimestamp("production_date"));
			tempVehicle.setServiceDate(rs.getTimestamp("service_date"));
			vehicles.add(tempVehicle);
		}
		Vehicle[] vehicleArray = new Vehicle[vehicles.size()];
		vehicles.toArray(vehicleArray);
		return vehicleArray;
	}

	/**
	 * Returns Vehicle by ID.
	 * 
	 * @param connection
	 * @param id
	 * @return Vehicle
	 * @throws SQLException
	 * @throws NullPointerException
	 */
	static public Vehicle getById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(GetById);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			Vehicle tempVehicle = new Vehicle();
			tempVehicle.setId(rs.getInt("id"));
			tempVehicle.setBrand(rs.getString("brand"));
			tempVehicle.setModel(rs.getString("model"));
			tempVehicle.setPlateNumber(rs.getString("plate_number"));
			tempVehicle.setProductionDate(rs.getTimestamp("production_date"));
			tempVehicle.setServiceDate(rs.getTimestamp("service_date"));
			return tempVehicle;
		}
		return null;
	}
}
