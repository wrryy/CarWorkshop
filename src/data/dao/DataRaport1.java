package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataRaport1 {
	
	private static final String SumWorkerHours = "SELECT w.first_name, w.last_name, sum(man_hours) as 'sum' "
			+ "FROM worker w join orderr o on w.id = o.worker_id WHERE start_date BETWEEN '?' AND '?' group by w.id order by w.last_name asc";
	private String firstName;
	private String lastName;
	private double manHours;
	
	public DataRaport1(String firstName, String lastName, double manHours) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.manHours = manHours;
	}
	public DataRaport1() {}
	
	static public DataRaport1[] generate(Connection connection, String fromDate, String toDate) throws SQLException {
		ArrayList<DataRaport1> orders = new ArrayList<>();
		PreparedStatement preparedStatement = connection.prepareStatement(SumWorkerHours);
		preparedStatement.setDate(1, java.sql.Date.valueOf(fromDate));
		preparedStatement.setDate(2, java.sql.Date.valueOf(toDate));
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			DataRaport1 data = new DataRaport1();
			data.setFirstName(rs.getString("first_name"));
			data.setLastName(rs.getString("last_name"));
			data.setManHours(rs.getDouble("sum"));
			orders.add(data);
		}
		DataRaport1[] orderArray = new DataRaport1[orders.size()];
		orders.toArray(orderArray);
		return orderArray;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getManHours() {
		return manHours;
	}
	public void setManHours(double manHours) {
		this.manHours = manHours;
	}
	
}
