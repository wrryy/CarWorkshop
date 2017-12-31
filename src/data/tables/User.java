package data.tables;

import java.sql.Timestamp;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Timestamp birthDate;
	private static int counter = 0;

	public User() {
	}

	// creating new User
	public User(String firstName, String lastName, String email, Timestamp dateBirth) {
		this.id = counter + 1;
		counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = dateBirth;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp dateBirth) {
		this.birthDate = dateBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
