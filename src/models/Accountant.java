package models;

import classes.AdminStaff;

final public class Accountant extends AdminStaff {
	public Accountant (int id, String name, String surname, int salaryLevel, String task) {

		super(id, name, surname, salaryLevel, task);
		this.salaryLevel();
	}

	@Override
	public void salaryLevel() {
		// defining the random range for salary between 3100 up to 4500
				int salaryLevel = 3100 + (int)(Math.random()*(4500));
				this.salaryLevel = salaryLevel;
				
	}
}
