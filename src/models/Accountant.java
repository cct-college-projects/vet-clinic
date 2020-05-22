package models;

import classes.AdminStaff;

final public class Accountant extends AdminStaff {
	public Accountant (int id, String name, String surname, double currentSalary, int salaryLevel, String task) {

		super(id, name, surname, currentSalary, salaryLevel, task);
		this.setCurrentSalary();
	}

	@Override
	//Method to set a randomly salary for the employees that belongs to this class
	public void setCurrentSalary() {
		// defining the random range for salary between 3100 up to 4500
		double currentSalary = 3100 + (double)(Math.random()*(4500));
		this.currentSalary = currentSalary;
	}
	@Override
	//Setting the level salary to the category
	public void setSalaryLevel() {
		this.salaryLevel = 4;
	}

}
