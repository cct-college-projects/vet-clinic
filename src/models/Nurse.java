package models;

import classes.MedicalStaff;

final public class Nurse extends MedicalStaff {

    public Nurse(int id, String name, String surname, double currentSalary, int salaryLevel) {
        super(id, name, surname, currentSalary, salaryLevel);
        this.setCurrentSalary();
    }

	@Override
	public void setCurrentSalary() {
		// defining the random range for salary between 2100 up to 3500
		int currentSalary = 2100 + (int)(Math.random()*(3500));
		this.currentSalary = currentSalary;
	}
	@Override
	public void setSalaryLevel() {
		
		this.salaryLevel = 3;
	}
}
