package data.tables;

import java.sql.Timestamp;

public class Order {
	private int id;
	private static int counter = 0;
	private Timestamp receiveDate;
	private Timestamp startDate;
	private Timestamp plannedStartDate;
	private String problemDescription;
	private String repairDescription;
	private String status;
	private int workerId;
	private double workerHourCost;
	private int vehicleId;
	private double userCost;
	private double partsCost;
	private double manHours;
	
	public Order() {}

	public Order(Timestamp receiveDate, Timestamp startDate, Timestamp plannedStartDate,
			String problemDescription, String repairDescription, String status, int workerId, double workerHourCost,
			int vehicleId, double userCost, double partsCost, double manHour) {
		this.id = counter + 1;
		counter++;
		this.receiveDate = receiveDate;
		this.startDate = startDate;
		this.plannedStartDate = plannedStartDate;
		this.problemDescription = problemDescription;
		this.repairDescription = repairDescription;
		this.status = status;
		this.workerId = workerId;
		this.workerHourCost = workerHourCost;
		this.vehicleId = vehicleId;
		this.userCost = userCost;
		this.partsCost = partsCost;
		this.manHours = manHour;
	}

	public Timestamp getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Timestamp receiveDate) {
		this.receiveDate = receiveDate;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(Timestamp plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getRepairDescription() {
		return repairDescription;
	}

	public void setRepairDescription(String repairDescription) {
		this.repairDescription = repairDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public double getWorkerHourCost() {
		return workerHourCost;
	}

	public void setWorkerHourCost(double workerHourCost) {
		this.workerHourCost = workerHourCost;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getUserCost() {
		return userCost;
	}

	public void setUserCost(double userCost) {
		this.userCost = userCost;
	}

	public double getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(double partsCost) {
		this.partsCost = partsCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getManHours() {
		return manHours;
	}

	public void setManHours(double manHours) {
		this.manHours = manHours;
	}
	 
	
	
}
