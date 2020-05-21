package models;

import classes.AdminStaff;

final public class Accountant extends AdminStaff {
	public Accountant (int id, String name, String surname, double currentSalary, int salaryLevel, String task) {

		super(id, name, surname, currentSalary, salaryLevel, task);
		this.setCurrentSalary();
	}

	@Override
	public void setCurrentSalary() {
		// defining the random range for salary between 3100 up to 4500
				int currentSalary = 3100 + (int)(Math.random()*(4500));
				this.currentSalary = currentSalary;
				
	}

	@Override
	public void setSalaryLevel() {
		this.salaryLevel = 4;
		
	}


	

	

	
}
