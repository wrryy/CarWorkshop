package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.tables.User;

public class UserDao {

	private static final String Create = "Insert into  user(first_name, last_name, email, birth_date) Values( ?, ?, ?, ?)";
	private static final String Update = "Update user Set first_name=?, last_name=?, email=?, birth_date=? Where id = ?";
	private static final String Delete = "DELETE FROM user WHERE id= ?";
	private static final String GetAll = "Select * from user";
	private static final String GetById = "SELECT * FROM user where id=?";

	/**
	 * Inserts User to DB.
	 * 
	 * @param connection
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User create(Connection connection, User user) throws SQLException {
		String[] generatedColumns = { "id" };
		PreparedStatement pst = connection.prepareStatement(Create, generatedColumns);
		pst.setString(1, user.getFirstName());
		pst.setString(2, user.getLastName());
		pst.setString(3, user.getEmail());
		pst.setTimestamp(4, user.getBirthDate());
		pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		if (rs.next()) {
			user.setId(rs.getInt(1));
		}
		return user;
	}
	
	/**Updates User in DB.
	 * 
	 * @param connection
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User update(Connection connection, User user) throws SQLException {

		PreparedStatement pst = connection.prepareStatement(Update);
		pst.setString(1, user.getFirstName());
		pst.setString(2, user.getLastName());
		pst.setString(3, user.getEmail());
		pst.setTimestamp(4, user.getBirthDate());
		pst.setInt(5, user.getId());
		pst.executeUpdate();
		return user;
	}

	/**
	 * Deletes User from DB.
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
	 * Returns list of all Users.
	 * 
	 * @param connection
	 * @return User[]
	 * @throws SQLException
	 */
	static public User[] getAll(Connection connection) throws SQLException {
		ArrayList<User> users = new ArrayList<>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(GetAll);

		while (rs.next()) {
			User tempUser = new User();
			tempUser.setId(rs.getInt("id"));
			tempUser.setFirstName(rs.getString("first_name"));
			tempUser.setLastName(rs.getString("last_name"));
			tempUser.setEmail(rs.getString("email"));
			tempUser.setBirthDate(rs.getTimestamp("birth_date"));
			users.add(tempUser);
		}
		User[] userArray = new User[users.size()];
		users.toArray(userArray);
		return userArray;
	}

	/**
	 * Returns User by ID.
	 * 
	 * @param connection
	 * @param id
	 * @return User
	 * @throws SQLException
	 * @throws NullPointerException
	 */
	static public User getById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(GetById);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			User tempUser = new User();
			tempUser.setId(rs.getInt("id"));
			tempUser.setFirstName(rs.getString("first_name"));
			tempUser.setLastName(rs.getString("last_name"));
			tempUser.setEmail(rs.getString("email"));
			tempUser.setBirthDate(rs.getTimestamp("birth_date"));
			return tempUser;
		}
		return null;
	}
}
