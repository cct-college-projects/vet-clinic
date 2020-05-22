package models;

import classes.MedicalStaff;

final public class Nurse extends MedicalStaff {

	public Nurse(int id, String name, String surname, double currentSalary, int salaryLevel) {
		super(id, name, surname, currentSalary, salaryLevel);
		this.setCurrentSalary();
	}

	@Override
	//Method to set a randomly salary for the employees that belongs to this class
	public void setCurrentSalary() {
		// defining the random range for salary between 2100 up to 3500
		double currentSalary = 2100 + (double)(Math.random()*(3500));
		this.currentSalary = currentSalary;
	}
	//Setting the level salary to the category
	@Override
	public void setSalaryLevel() {

		this.salaryLevel = 3;
	}
}
