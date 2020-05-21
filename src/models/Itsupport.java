package models;

import classes.AdminStaff;

final public class Itsupport extends AdminStaff {

	public Itsupport(int id, String name, String surname, double currentSalary, int salaryLevel, String task) {

		super(id, name, surname, currentSalary, salaryLevel, task);
		this.setCurrentSalary();
		
	}

	@Override
	public void setCurrentSalary() {
		// defining the random range for salary between 1800 up to 2900
		int currentSalary = 1800 + (int)(Math.random()*(2900));
		this.currentSalary = currentSalary;
		
	}
	
	@Override
	public void setSalaryLevel() {
		this.salaryLevel = 2;
		
	}
	
	
	
}
