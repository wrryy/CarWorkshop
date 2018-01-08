package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataRaport2 {
	
	private static final String SumWorkerHours = "SELECT sum((man_hours)*worker_hour_cost) as 'sum' "
			+ "FROM orderr where planned_start_date between '2017-01-01' and '2019-09-09' group by worker_id with rollup";
	private double manHours;
	
	public DataRaport2(double manHours) {
		this.manHours = manHours;
	}
	public DataRaport2() {}
	
	static public DataRaport2[] generate(Connection connection, String fromDate, String toDate) throws SQLException {
		ArrayList<DataRaport2> orders = new ArrayList<>();
		PreparedStatement preparedStatement = connection.prepareStatement(SumWorkerHours);
		preparedStatement.setDate(1, java.sql.Date.valueOf(fromDate));
		preparedStatement.setDate(2, java.sql.Date.valueOf(toDate));
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.last()) {
			DataRaport2 data = new DataRaport2();
			data.setManHours(rs.getDouble("sum"));
			orders.add(data);
			
		}
		DataRaport2[] orderArray = new DataRaport2[orders.size()];
		orders.toArray(orderArray);
		return orderArray;
	}
	public double getManHours() {
		return manHours;
	}
	public void setManHours(double manHours) {
		this.manHours = manHours;
	}
	
}
