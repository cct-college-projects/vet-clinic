package models;

import classes.MedicalStaff;

final public class Veterinary extends MedicalStaff {

	public Veterinary(int id, String name, String surname, double currentSalary, int salaryLevel) {
		super(id, name, surname, currentSalary, salaryLevel);
		this.setCurrentSalary();
	}

	@Override
	//Method to set a randomly salary for the employees that belongs to this class
	public void setCurrentSalary() {
		// defining the random range for salary between 2500 up to 4500
		double currentSalary = 2500 + (double)(Math.random()*(4500));
		this.currentSalary = currentSalary;
	}

	@Override
	//Setting the level salary to the category
	public void setSalaryLevel() {
		this.salaryLevel = 5;
	}

}
