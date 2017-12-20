package data.tables;

import java.sql.Timestamp;

public class Vehicle {
	private int id;
	private static int counter = 0;
	private String model;
	private String brand;
	private Timestamp productionDate;
	private String plateNumber;
	private Timestamp serviceDate;
	
	public Vehicle() {}

	public Vehicle(String model, String brand, Timestamp productionDate, String plateNumber,
			Timestamp serviceDate) {
		this.id = counter + 1;
		counter++;
		this.model = model;
		this.brand = brand;
		this.productionDate = productionDate;
		this.plateNumber = plateNumber;
		this.serviceDate = serviceDate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Timestamp getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Timestamp productionDate) {
		this.productionDate = productionDate;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Timestamp getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Timestamp serviceDate) {
		this.serviceDate = serviceDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
