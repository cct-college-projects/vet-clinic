package models;

import classes.AdminStaff;

final public class Itsupport extends AdminStaff {

	public Itsupport(int id, String name, String surname, int salaryLevel, String task) {
		super(id, name, surname, salaryLevel, task);
		this.salaryLevel();
		
	}

	@Override
	public void salaryLevel() {
		// defining the random range for salary between 1800 up to 2900
		int salaryLevel = 1800 + (int)(Math.random()*(2900));
		this.salaryLevel = salaryLevel;
		
	}
	
	
	
}
