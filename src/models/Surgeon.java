package models;

import classes.MedicalStaff;

final public class Surgeon extends MedicalStaff {

	public Surgeon(int id, String name, String surname, double currentSalary, int salaryLevel) {
		super(id, name, surname, currentSalary, salaryLevel);
		this.setCurrentSalary();
	}

	@Override
	//Method to set a randomly salary for the employees that belongs to this class
	public void setCurrentSalary() {
		// defining the random range for salary between 6000 up to 10000
		double currentSalary = 6000 + (double)(Math.random()*(10000));
		this.currentSalary = currentSalary;
	}

	@Override
	//Setting the level salary to the category
	public void setSalaryLevel() {
		this.salaryLevel = 6;
	}

}
