package models;

import java.util.Random;

import classes.AdminStaff;

final public class Secretary extends AdminStaff {
	public Secretary (int id, String name, String surname, int salaryLevel, String task) {
		super(id, name, surname, salaryLevel, task);
		this.salaryLevel();
	}
	
	public Random rd = new Random();
	
	@Override
	public void salaryLevel() {
		// defining the random range for salary between 1100 up to 2000
		int salaryLevel = 1100 + (int)(Math.random()*(2000));
		this.salaryLevel = salaryLevel;
		
	}

}
