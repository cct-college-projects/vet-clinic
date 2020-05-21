package models;

import classes.MedicalStaff;

final public class Veterinary extends MedicalStaff {

	public Veterinary(int id, String name, String surname, double currentSalary, int salaryLevel) {
		super(id, name, surname, currentSalary, salaryLevel);
		this.setCurrentSalary();
	}
		 
	@Override
	public void setCurrentSalary() {
	// defining the random range for salary between 2500 up to 4500
		int currentSalary = 2500 + (int)(Math.random()*(4500));
			this.currentSalary = currentSalary;
	}
	
	@Override
	public void setSalaryLevel() {
		 		
		this.salaryLevel = 5;
	}
	
}
