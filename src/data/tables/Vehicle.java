package data.tables;

public class Vehicle {
	private int id;
	private static int counter = 0;
	private int userId;
	private String model;
	private String brand;
	private String productionDate;
	private String plateNumber;
	private String serviceDate;
	
	public Vehicle() {}

	public Vehicle(String model, String brand, String productionDate, String plateNumber,
			String serviceDate) {
		this.id = counter + 1;
		counter++;
		this.model = model;
		this.brand = brand;
		this.plateNumber = plateNumber;
		this.productionDate = productionDate;
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

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
